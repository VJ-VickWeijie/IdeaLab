# ABAP-02｜直接读取 ABAP 7.56 SQL 和游标关键字文档

2026-11-25，资料研究；未运行 ABAP、未访问 SAP 客户系统，不计正式文章审核轮次。先前从搜索工具访问 `index.htm?file=...` 只看到零行，下面改为直接下载 `en-US` 目录下的实际 HTML 子页；每个页面正文页眉均为 **AS ABAP Release 756，©2021 SAP SE**。已有[后端配置指南](https://help.sap.com/doc/2e65ad9a26c84878b1413009f8ac07c3/202210.000/en-US/config_guide_system_backend_abap_development_tools.pdf) `Validity of Documentation` 将 Application Server ABAP 7.56 FPS00 及以上映射为 ABAP Platform 2021。关键字页面自身标 Release 756，但未逐页声明特定 FPS；目标系统 FPS、语法检查和执行结果仍未核。

## 组合语法和目标内表

[SELECT, INTO, APPENDING（7.56）](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/abapinto_clause.htm)，`Alternative 3` 与 `Addition ... PACKAGE SIZE n` 已直接实读：

- 语法列出 `INTO | APPENDING [CORRESPONDING FIELDS OF] TABLE itab ... [PACKAGE SIZE n]`，在 `SELECT` 中使用分包会开启由 `ENDSELECT` 关闭的循环。每次循环是包的处理时机，不只是客户端网络传输参数。
- 使用 `INTO` 时，每次插入前初始化目标内表，循环内只保留当前包；`APPENDING` 则把新包加入目标内表现有行。文档说明 `ENDSELECT` 后 `INTO` 目标表内容未定义，`APPENDING` 保留最后一次循环状态。不能假设 `INTO` 循环结束后仍可使用最后一包；零结果等分支应另按实际程序验证。
- `n = 0` 时文档说明把所有结果行插入目标表；负值产生不可处理异常。指定合适的正数也不构成容量、响应时间或 dump 消除保证。
- 文档明确：`PACKAGE SIZE` 在 `APPENDING` 后**不能防止**目标内表超过最大尺寸产生的运行时错误；`FOR ALL ENTRIES` 组合时，文档明确说明全部选中行先放入系统内表，再向目标表分包，不能据此断言所有系统都会 dump，但也不能靠 PACKAGE SIZE 保证避免内存溢出。分包大小也不等于数据库与应用服务器之间可配置的传输包大小。
- 目标内表若有唯一主键或次键，文档提示尝试写入重复项可产生不可处理异常；另需考虑行宽、目标表类别、总量、累积处理和并发。此处不建议单纯通过捕获异常作为安全承诺。

## 隐式 SELECT 游标、提交与回滚

[SELECT（7.56）](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/abapselect.htm) `Effect` 与 `Hints` 已实读：`SELECT ... INTO|APPENDING ... TABLE ... PACKAGE SIZE` 使用 `ENDSELECT` 循环时隐式打开数据库游标，结束循环后关闭；在该循环中不应执行会产生数据库 commit 或 rollback 并关闭对应游标的语句。文档另警示循环内写入正在读取的数据源的行为依赖数据库且未定义。

[COMMIT WORK（7.56）](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/abapcommit.htm) `Effect` 与 `Hints` 已实读：`COMMIT WORK` 一般情况下关闭当前 SAP LUW、在当前打开数据库连接上触发数据库提交并关闭游标；文档另列 CALL DIALOG 特例：在 CALL DIALOG 被调程序中，当前 SAP LUW 不关闭；Hints 另明确该情形仍触发数据库提交。页面说明之后访问关闭游标的 SELECT 循环/FETCH 可引发不可处理异常；不能因特殊调用下 SAP LUW 未关闭，就推断游标仍可继续。[ROLLBACK WORK（7.56）](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/abaprollback.htm) `Hints` 指出相关连接上的打开游标关闭，继续 SELECT 或 FETCH 会发生运行时错误。

实际程序中，数据库 LUW/SAP LUW、隐式提交触发点和所属框架需分别分析；不能假设在分包循环中提交后还能安全继续。下述显式游标的示例展示可捕获 `CX_SY_OPEN_SQL_DB`；不同页面对异常/运行时错误的表述及所展示的具体场景有差异，**不要由任一片段泛化所有情况的可捕获性**。

## 显式游标与 WITH HOLD 的有限例外

[OPEN CURSOR（7.56）](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/abapopen_cursor.htm)，`Effect`、`Addition ... WITH HOLD` 与 `Hints` 已实读。`OPEN CURSOR` 与 `FETCH` 是显式游标路径；`WITH HOLD` 限标准数据库读取，不能与 `CONNECTION` 同时指定。其例外针对文中所述的 Native SQL 数据库提交，文档以 `COMMIT CONNECTION` 举例，并指出提交发生在首次 FETCH 前后的区别；**它不保护隐式数据库提交、`COMMIT WORK` 或任何 rollback，这些情况仍关闭游标**。不要把此显式选项加到 `SELECT ... ENDSELECT` 的隐式游标上。

[FETCH（7.56）](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/abapfetch.htm) `Effect` 已实读：从显式打开的游标当前结果位置读取，支持内表和 `PACKAGE SIZE`；结果耗尽后下一次 FETCH 的 `sy-subrc` 为 4。文档讨论了 `CX_SY_OPEN_SQL_DB`，但这不意味着各类内存、键冲突或提交后异常都可由同一个 CATCH 处理。

## 可重复定位与阅读状态

以上链接直达 SAP 7.56 HTML 原文。已使用 `curl` 下载源码到本地暂存并解析可见文本；以下 SHA-256 标识本次抓取字节，不保证服务器未来内容不变，不能代替重新核版：

| SAP 页面 | 本次下载文件 SHA-256 |
| --- | --- |
| `abapinto_clause.htm` | `023c84acd5be4ebbe4a95fefa060a9c4d6d574b71d5a43992a329a5316b9c297` |
| `abapselect.htm` | `cecee724b2f6ae272073b29c3b40d33542c0f65b90870c573cd09b00501a0c33` |
| `abapopen_cursor.htm` | `6b5d9eedc48023a9f1ced845d50ff787091fdd5652b47f6a83019a60f8cb9e85` |
| `abapfetch.htm` | `4c54d3fc32d25ee87606aad0c1486006af5536d7fbd12f98e622cc4eb5e74380` |
| `abapcommit.htm` | `355ed366ff1b5fc514b3b70506f57fdec4dc8f4423a302a3cfce2ee21be936d0` |
| `abaprollback.htm` | `70ad451a7d240f4379adc22750bbe8fb59bf9287c3bf52a3c659436f8560d34a` |

本记录补上 7.56 组合语义和游标边界的直接资料；不证明某个业务程序的正确性、可用授权、内存上限、性能或特定 BAPI 的事务协议。正式文章仍需三角色审核，目标系统差异和可验证案例仍待独立评审。


## 独立文献复核与修订记录

/root/reader_plan 独立通过 curl 获取并实读上述六个 AS ABAP Release 756（©2021 SAP SE）页面，复核本报告的 INTO/APPENDING、分包、显式/隐式游标及提交/回滚表述。该上下文未计算哈希、未运行 SAP 或 ABAP。复核者提出两项精度修订：将 FOR ALL ENTRIES 与 PACKAGE SIZE 的页面提示从“可能”修正为文档明确的先读入全部选中行再分包；补充 CALL DIALOG 特殊场景中 SAP LUW 的例外及数据库提交仍发生。Work 已执行上述两项修订，复核者重新检查后确认两项语义修订准确，并指出 CALL DIALOG 特例应归于 Effect 中的特殊情形而非笼统归入 Hints；Work 接受并改为“文档另列”以精确定位。复核者随后指出，不应将该例外泛化至所有特殊调用；Work 按建议限定为 CALL DIALOG 被调程序中的特定情形，并保留 Hints 对数据库提交的说明，原复核者复读最终句后确认特例已限定在 CALL DIALOG 被调程序，且 Hints 的提交说明准确；此项文献交叉复核关闭。此为文献交叉复核，不计正式文章审核轮次。


## 相关 M3 补充：内存 warning 与排障边界

[ABAP-02 内存短转储与资源诊断补充](abap02-memory-dump-admin-boundary-m3.md)新增 SAP ABAP Platform 2021 (Oct 2021) 内存 quota soft-warning 与 hard-limit 资料：warning threshold 可产生不终止程序的 short dump，不能据此实现 TRY...CATCH 停止；同时记录 KBA 2180736、Support Content 通用诊断和一个 S/4HANA 2021 的有限同现案例。参数设置、目标系统运行行为及 warning 是否能及时提醒仍需系统侧确认。