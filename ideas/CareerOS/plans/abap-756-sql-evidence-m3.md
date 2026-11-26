# CareerOS｜ABAP-02 版本 7.56 的 SQL 证据补充

状态：M3 研究记录，2026-11-25；尚未授权 M4，未执行 SAP 程序或正式文章审核。本文仅记录公开 SAP 原始资料的有限含义，不是操作教程。实际系统 FPS、语法检查和内存/游标实测仍未知。

## 版本映射：ABAP 7.56 与 ABAP Platform 2021

[SAP Configuring the ABAP Back-end for ABAP Development Tools](https://help.sap.com/doc/2e65ad9a26c84878b1413009f8ac07c3/202210.000/en-US/config_guide_system_backend_abap_development_tools.pdf)，文档 3.28、2022-10-10，**已直接读取正文**：PDF 物理第 3 页、`Validity of Documentation` 明确将 Application Server ABAP 7.56 FPS00 及以上称作 ABAP Platform 2021。该文档本身是 ADT 配置指南，不是 7.56 SQL 关键字说明，不为任意业务系统或补丁提供性能保证。

## SAP 官方 7.56 代码样例：APPENDING 与 PACKAGE SIZE

[SAP-samples/abap-cheat-sheets，7.56 固定提交 README](https://github.com/SAP-samples/abap-cheat-sheets/blob/1274c581696579e18777463c851a2e0ef3bf8f13/README.md) 明确标注 Classic ABAP **7.56**；[固定版本的 ABAP SQL 样例](https://github.com/SAP-samples/abap-cheat-sheets/blob/1274c581696579e18777463c851a2e0ef3bf8f13/src/zcl_demo_abap_sql.clas.abap) 是 SAP SE 维护的可读原始示例，实际通过 GitHub 连接器读取，提交 `1274c581696579e18777463c851a2e0ef3bf8f13`、代码 blob `d613e61b23ec4b3a871a1f6edf4106a44fbd849f`。

| 位置 | 有限支持范围 | 不能据此得出 |
| --- | --- | --- |
| 第 465–477 行，`12) Appending the result set to an existing internal table` | 该 7.56 示例演示普通 `SELECT ... APPENDING TABLE` 将结果加入已有内表。 | 本段未将 APPENDING TABLE 与 PACKAGE SIZE 组合，不能证明该组合的全部循环语义。 |
| 第 479–508 行 | `APPENDING CORRESPONDING FIELDS OF TABLE` 示例保留既有行并按相应字段接收数据。 | 不证明任何自定义表、字段或系统权限，未实测。 |
| 第 511–538 行，`13) Reading into packages of a specified number of rows` | 该 7.56 示例以 `SELECT ... INTO TABLE ... PACKAGE SIZE 3 ... ENDSELECT` 逐轮处理，代码注释说明每轮目标行数。 | 示例**同时将每包积累到另一个内表 `itab_pack`**，并非恒定内存占用方案；不证明 2021 每个 FPS 具体系统中无 dump、不证明耗时或任何游标/COMMIT 语义。 |

此仓库 README 明确该代码只作语法演示、不直接用于生产，并且没有对正确性与完整性提供保证；本次也未在 ABAP 系统中运行。`7.56` 分支未声明每行针对 FPS00 的独立验证，不能扩写为已核实所有补丁；实际系统应在授权范围内核对相应 FPS 的关键字文档和运行环境。

## APPENDING + PACKAGE SIZE 与游标/事务：仍需目标关键字原文

- [SAP 旧版 Specifying a Target Area](https://help.sap.com/saphelp_snc700_ehp01/helpdata/en/fc/eb39eb358411d1829f0000e829fbfe/content.htm?no_cache=true)，`Specifying Internal Tables` 和示例已直接读取，解释该旧版本 `INTO`、`APPENDING` 和 `PACKAGE SIZE`；不能仅凭该材料证明目标 7.56 的完整语义。
- [ABAP 7.56 官方关键字文档入口](https://help.sap.com/doc/abapdocu_756_index_htm/7.56/en-US/index.htm) 经搜索可定位，但本环境打开返回零行；附 `?file=abapselect.htm` 等参数的尝试未取得可读正文。因此本次**未读取 7.56 关键字文档**，不能把本次 SAP 样例冒称为关键字规范。
- 现有 7.56 SQL 样例与上述版本映射**没有覆盖 `SELECT ... APPENDING TABLE ... PACKAGE SIZE` 的组合，也没有说明 SELECT 隐式游标与 `COMMIT WORK`、`ROLLBACK WORK`、`OPEN CURSOR WITH HOLD` 等边界**。这些断言保持待核，不应将新版 ABAP Cloud 或历史文档直接宣称为 2021 依据。
- 为查找显式游标例子，本次读取该固定提交树下 51 个 `.abap` 源码文件，并按 `OPEN CURSOR`、`FETCH NEXT CURSOR`、`CLOSE CURSOR`、`WITH HOLD` 字符串查找，未命中。这只能说明这组示例未包含上述文本，不能证明 7.56 不支持游标或不存在其他官方资料。
- 建议后续由具备浏览器的独立执行者打开上述 7.56 关键字文档，核对并记录具体页面标题、版本、有效内容、不同目标和异常；必要时只读查看获授权的 2021 系统 F1 文档。不能未经允许启动跟踪或执行写入。

## 本次发现对 M3 的影响

这是针对 ABAP-02 的**版本定位与样例证据补充**，可以减少 `SELECT ... INTO TABLE ... PACKAGE SIZE` 在 7.56 的文献缺口；组合语义、游标/事务、行数与内存上限、异常和并发仍未全部核验。不得将计划、样例或本研究算作文章完成或角色审核轮次。

## 独立复核

`/root/reader_plan` 独立读取固定提交的 README、SQL 代码及 SAP ADT PDF，确认 7.56 版本映射和分包示例；特别指出示例累积结果，不能保证整体内存上限或避免 dump。版本映射不证明全部客户系统/FPS、组合语义或性能。此复核不计正式文章轮次。
