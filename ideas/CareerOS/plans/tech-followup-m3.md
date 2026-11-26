# CareerOS V0.3｜M3 技术证据缺口复查：BAPI、RAP 和 ABAP SQL

状态：研究记录，M4 尚未授权；2026-11-25。未执行 SAP 程序、跟踪、系统配置或文章审核。来源标记：**已读**为本次通过网页工具打开并读到原始正文；**仅索引**为搜索引擎显示摘要，但打开正文返回零行；**不可读**为加载失败或文件过大。不得将仅索引、历史版本或非 SAP 产品年份当成目标系统 2021 事实。

## ABAP-02：ABAP SQL 语法与性能

1. **已读，目标发行版和 FPS 明确**：[Custom Code Migration Guide for SAP S/4HANA 2021](https://help.sap.com/doc/9dcbc5e47ba54a5cbb509afaa49dd5a1/2021.002/en-US/CustomCodeMigration_EndToEnd.pdf)，封面写 **2021 FPS01，2022-02-23**；尽管 URL 包含 `2021.002`，以 PDF 封面及第 3 页版本记录为准，不能根据 URL 声称 FPS02。
   - §5 `What's Next?`，PDF 物理页 80：SAP 说明可用运行时检查发现空的 `FOR ALL ENTRIES` 表、缺失的排序，并根据 SQL Monitor 识别执行耗时较高的 SQL；§5 物理页 81 提及 CDS 和 AMDP 作为后续代码下推工具。
   - 该文档的动作面向系统管理员和特定迁移工作，**不是授权在本项目或公司生产环境启用监控**。它证明检查/分析方向，不证明某 SQL 必然更快、不证明 `PACKAGE SIZE` 语法/内存占用，也不保证避免 dump。
2. **已读，但不是目标版本直接证据**：[SAP 旧版 Specifying a Target Area](https://help.sap.com/saphelp_snc700_ehp01/helpdata/en/fc/eb39eb358411d1829f0000e829fbfe/content.htm?no_cache=true) 的 `Specifying Internal Tables`；解释分包、`INTO` 和 `APPENDING` 在该版本中的行为，但不能自动证明 ABAP 7.56/2021 语法兼容。
3. **仅索引**：[SAP ABAP FAQ](https://help.sap.com/docs/SUPPORT_CONTENT/abapfaq/3353523514.html) 关于大型查询与 `PACKAGE SIZE` 的搜索摘要可见，但打开正文未取得可读内容、也没有固定 2021 产品版本。

**剩余缺口**：找可直接读取的 ABAP Platform 2021/7.56 对应关键字说明，核对 `SELECT ... PACKAGE SIZE`、`APPENDING`、游标/提交、内存消耗与异常；补充对所选数据量、单行宽度及并发场景的可复现实验。即使能分包也不能承诺从根本上消除所有内存 dump。

## S4HANA-05：RAP 在目标 FPS 的支持范围

1. **已读，目标版本入口**：[SAP RESTful Application Programming Model](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/de-DE/7b66b9e7cdb5433a82633e650b337207.html) 的 `Technical Details` 指明 SAP S/4HANA 2021 并链接 `Version 2021 FPS00`，页面是发布说明入口，不列全体具体功能。
2. **独立开发者已读原文**：[SAP `Version 2021 FPS00`](https://help.sap.com/docs/ABAP_PLATFORM_NEW/fc4c71aa50014fd1b43721701471913d/eb5df2a2aa18406382af2b2d055d2d87.html?version=202110.000&locale=en-US&state=PRODUCTION)。本研究者原先仅取到索引，后由 `/root/developer_plan` 在浏览器选择 `2021 (Oct 2021)` 并读取正文；可支持该文所列 Global Authorization Control、COMMIT ENTITIES simulation mode 等特定功能，不能代替完整功能矩阵。
3. **仅索引**：[SAP 2021 FPS02 `Exposing the Draft Business Object for a UI Business Service`](https://help.sap.com/docs/ABAP_PLATFORM_2021/fc4c71aa50014fd1b43721701471913d/97e324d003b8443181569f425a33d42e.html?locale=en-US&state=PRODUCTION&version=202110.002) 的搜索摘要涉及 managed business object 的 draft exposure；本次尚未通过可读原文核实，不能认定该页面已读。

**剩余缺口**：在可读取 SAP 动态文档的授权浏览器中逐节检查并保留准确页面和版本记录，逐项建立 managed/unmanaged、draft、OData V2/V4、EML、行为定义和认证授权支持矩阵；具体 FPS 与组件未知时保留待核。版本入口不能替代特性级证据。

## ABAP-04：采购 BAPI 的事务和提交

1. **独立开发者已读，S/4HANA 2021 initial**：[SAP `Extensibility Support for Purchase Orders`](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/0fbc805785a0403d9f56beacf89c0ef4.html?version=2021.000)。本研究者原先仅取到索引；随后 `/root/developer_plan` 在浏览器实读选择器 `2021 (Oct 2021)` 和正文：该版本增强 `BAPI_PO_CREATE1` 支持 custom fields。此概述不证明具体 EXTENSIONIN 结构、每个字段、提交/回滚或价格单位覆盖机制。
2. **仅索引，ABAP Platform 2021 FPS02**：[SAP `Implementing Idempotent Web Services`](https://help.sap.com/docs/ABAP_PLATFORM_NEW/684cffda9cbc4187ad7dad790b03b983/2ec039d6c2bf458f95041eb1079f2f2b.html?locale=en-US&state=PRODUCTION&version=202110.002) 的索引摘要提及**特定同步 SOAP Web Service** 实现中的 BAPI 处理和 `CL_SOAP_COMMIT_ROLLBACK`；本次直接打开返回零行，不能记作已读，且不能推广到 `BAPI_PO_CREATE1` 或所有 RFC/BAPI。
3. **已读，非 S/4HANA 2021 产品证据**：[SAP Cross-Plant Planning](https://help.sap.com/doc/6afeeafa6a424b9b8060d91da975c497/2021.1/en-US/CPP-EN.pdf) 封面日期 2021-05-03，§4、PDF 物理页 23；其中 ERP 的 SCM Consulting Solution 附加组件使用 `BAPI_PO_CREATE1` 的扩展参数。日期或 URL `2021.1` 不能证明产品为 S/4HANA 2021，且内容没有提交语义。
4. **已读，旧版而非目标 2021 的通用事务资料**：[SAP BAPI Transaction Model](https://help.sap.com/SAPHELP_SCM700_EHP02/helpdata/EN/4d/5b102ba1483d8fe10000000a42189e/content.htm?no_cache=true) 可解释其自身版本的调用方提交/回滚模型和少数例外，但不能单凭它断言所选 2021 采购 BAPI 的行为。

**剩余阻断**：尚无可以直接阅读并明确覆盖 S/4HANA 2021 目标采购 BAPI `BAPI_PO_CREATE1` 的提交、回滚、消息及更新任务行为的资料；不可将多个不同时代/产品的文档拼接成已证结论。仍需 2021 目标系统中的官方函数文档或明确版本的 SAP 原厂依据；无法获得就如实保留阻断，不降级为已验证。

## 研究方式与待跟进

本次执行上下文可用公开文献搜索，但没有发现可用的本地 Browser/REPL 连接器；动态 SAP 页面打不开时，已向协调者提供页面供其使用自己的可用浏览器独立核实。不得把协调者未来的读取伪称本次已完成。请将本文件与既有技术证据台账合并时，保留页面版本/物理页以及“已读 / 仅索引”的区别，不把 URL 中 `.002` 直接等同 PDF FPS02。

## 独立开发者复核（2026-11-25）

`/root/developer_plan` 独立打开原 PDF 并核对封面、物理页 3、80、81，确认以上 FPS01 与 SRTCM、SQL Monitor、CDS/AMDP 的有限表述。审查者指出原文提到 SQL Monitor，但第 80 页本身不证明 SQLM 事务码；它也不证明 2021 所有补丁一致、`PACKAGE SIZE` 语法或避免内存 dump。无需修改上述原判断，保留这些限制。该项 PDF 复核不覆盖动态页面；动态页面后续核验见下节。SAP 实机未测，也不是正式文章审核。

## 2021 初版页面的后续浏览器核验（2026-11-25）

`/root/developer_plan` 在 RAP 页面显式选择 2021 (Oct 2021)，确认页面标题为 Version 2021 FPS00；页面列 Global Authorization Control、COMMIT ENTITIES simulation mode、managed BO unmanaged early numbering、unmanaged BO managed draft early numbering 和特定 ADT Quick Fix。simulation mode 所述不实际保存并不能证明增强或外部副作用零风险。未验证全部 OData、managed/unmanaged、draft、组件、权限和实机功能。另实读采购订单扩展页面，见 ABAP-04 限定范围。页面原研究者未读取正文，不得伪称其独立复验。

`/root/developer_m3_review` 复读新增记录，确认浏览器读取归属及来源边界区分清楚；其指出旧段落可能使读者误以为后续动态页未读，Work 已将该句明确限定为 PDF 复核阶段。该研究者未实读上述两个动态页面，不能记作第二次正文复验。


## ABAP 7.56 固定示例及独立复核

`/root/developer_m3_review` 实读 SAP 官方示例仓库 [v756 固定提交的 README](https://github.com/SAP-samples/abap-cheat-sheets/blob/1274c581696579e18777463c851a2e0ef3bf8f13/README.md) 和 [ABAP SQL 示例](https://github.com/SAP-samples/abap-cheat-sheets/blob/1274c581696579e18777463c851a2e0ef3bf8f13/src/zcl_demo_abap_sql.clas.abap#L511)，以及 [ADT 系统配置指南](https://help.sap.com/doc/2e65ad9a26c84878b1413009f8ac07c3/202210.000/en-US/config_guide_system_backend_abap_development_tools.pdf)；`/root/reader_plan` 独立核对版本说明和代码。README 指明 Classic ABAP 7.56，示例中有 `INTO TABLE ... PACKAGE SIZE ... ENDSELECT`；ADT PDF 物理第 3 页将 Application Server ABAP 7.56 FPS00 及以上称为 ABAP Platform 2021。

该例用于语法演示，随后将各包累积到另一内表，**不能证明总内存受限或避免 dump**；仓库不保证示例可直接用于生产。普通 APPENDING 与 PACKAGE SIZE 在不同示例中出现，不能据此证明二者组合的语义或游标/提交行为，ADT 指南也不是 SQL 关键字语义文档。目标系统组件、具体 7.56 关键字原文、异常和实测仍待核验。该复核为规划来源检查，正式文章审核轮次为零。


## ABAP-02：7.56 关键字直接来源更新（2026-11-26）

[ABAP 7.56 SQL 与游标关键字补查](abap-756-keyword-direct-m3.md)现已直接核对 SELECT/INTO、PACKAGE SIZE、OPEN CURSOR、FETCH、COMMIT WORK 与 ROLLBACK WORK 六个 SAP HTML 页面，页眉为 AS ABAP Release 756 / ©2021。独立上下文复读了六页并提出两项具体精度修改；Work 修订 FAE 与 PACKAGE SIZE 的全部行先进入系统内表的文档提示，并逐轮修正 CALL DIALOG 特例定位。原复核者最终确认：该 SAP LUW 例外具体适用于 CALL DIALOG 被调程序，数据库提交仍发生，不能推断游标继续可用。

这一直接资料补上了 ABAP 7.56 的语法和游标语义，但没有运行 ABAP 或访问 SAP 系统；不证明目标系统 FPS、实际内存安全、性能、异常捕获或任何特定程序行为，也不计正式文章审核轮次。原章节中“需找 7.56 关键字文档”的研究待办已完成；目标系统/实测缺口仍未闭合。
