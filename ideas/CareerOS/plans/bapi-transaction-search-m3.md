# CareerOS V0.3｜ABAP-04 采购 BAPI 2021 事务证据复查

状态：M3 研究记录。目标是可直接阅读、适用于 S/4HANA 2021 / ABAP Platform 2021，且**直接说明 `BAPI_PO_CREATE1` 的调用、提交、回滚或更新事务**的 SAP 官方原始材料。检索与阅读日期：2026-11-25；未进入 SAP 系统、未执行代码、未产生正式文章审核轮次。

## 当前找到的材料与适用性

### 1. SAP 官方：特定较新集成支持 1909 及以上

[SAP Predictive Replenishment Administration Guide](https://help.sap.com/doc/053d2783092d43e8872773d3b4b067bf/Latest/en-US/7fe50661b27a4ef0be475778ffb42437.pdf)，版本 1.0，2026-01-14，§3.5.1、PDF 物理第 24 页；**已直接读取正文**。

- SAP 说明该特定的订单建议到 S/4HANA On-Premise 集成支持 1909 及更高版本；按版本范围可推知涵盖 2021，但仍须具体检查当时的补丁、组件、SAP Note 及云端集成前提。
- 指南在该集成 RFC 连接前提中列出需要暴露的 `BAPI_PO_CREATE1`、`BAPI_TRANSACTION_COMMIT`、`BAPI_TRANSACTION_ROLLBACK`。
- **限度**：该段列的是暴露清单，没有给出这三个接口的具体调用顺序、成功/失败分支、更新任务或 PO 创建接口是否自行提交；因此不能仅凭它证明目标采购 BAPI 的事务语义。该文档和特定集成是 2026 年材料，也不能据此称该集成在 2021 FPS00 时已经交付。本项目不执行指南中的配置或连接步骤。

### 2. 直接针对 2021 FPS01 的出版样章：非 SAP 官方产品文档

[ABAP RESTful Application Programming Model，第 10 章公开样章](https://s3-eu-west-1.amazonaws.com/gxmedia.galileo-press.de/supplements/6161/ISBN_2379_Ch_10_Download.pdf)，Rheinwerk Publishing / SAP PRESS，ISBN 978-1-4932-2379-4，2023 年英文第一版，出版方公开的样章；§10.1，书面页 373–374（PDF 物理第 5–6 页），**已直接读取正文**。

- 作者明确该具体示例开发环境为 **S/4HANA 2021 FPS01 on-premise**，以 `BAPI_PO_CREATE1` 和 `BAPI_PO_CHANGE` 接入 RAP。
- 文中描述 BAPI 使用者控制事务，并在该 RAP 托管/非托管保存的特定示例中解释 `BAPI_TRANSACTION_COMMIT` / `BAPI_TRANSACTION_ROLLBACK` 与框架事务边界之间的关系。
- **限度**：SAP PRESS 是 Rheinwerk 出版品牌；虽然是可信的有版本示例的技术资料，它不是 SAP 官方产品文档或 SAP 对本项目当前系统的验证。不得以它满足“2021 SAP 官方原文”的条件；也不能将此书中有关 RAP 行为池的约束机械套用到普通外部调用或每个 BAPI。样章仅做研究索引和少量转述，不复制长文或代码。

### 3. SAP 官方通用 BAPI 模型：明确旧版，不能升级为 2021 证明

[Transaction Model for Developing BAPIs](https://help.sap.com/SAPHELP_SCM700_EHP02/helpdata/EN/4d/5b102ba1483d8fe10000000a42189e/content.htm?no_cache=true)，旧版 SCM Help，`Transaction Control in Client`、`Transaction Handling via Service BAPIs`、`Comment`，**已直接读取正文**。它讨论调用方事务控制以及少数自带 COMMIT 的例外，但页面不能确证 2021 特定采购 BAPI。

### 4. SAP 官方 2021 采购扩展公告：动态正文未由本执行上下文读到

[SAP Support for Extension of Purchase Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/0fbc805785a0403d9f56beacf89c0ef4.html?version=2021.000)，搜索索引将其标为 S/4HANA 2021 initial，涉及 `BAPI_PO_CREATE1` 的自定义字段扩展。本执行上下文用网页工具打开时正文为零行；随后独立开发者 `/root/developer_plan` 用浏览器实读版本选择器 2021 (Oct 2021) 与正文，确认该版本增强 BAPI_PO_CREATE1 对自定义字段的支持。该公告未给具体扩展结构，也不证明提交/回滚。

相关官方 2021 initial What's New PDF 因文件大小约 15 MB 超出网页读取工具限制，未能读取对应正文，不能声称已核实。2021.1 `Cross-Plant Planning` PDF 已读到采购 BAPI 扩展参数，但它描述 ERP 的 SCM Consulting Solution 附加组件，日期或 `2021.1` 不足以证明 S/4HANA 2021 产品及事务行为。

当时原研究者再次核查结果：该研究者执行上下文的可用工具清单没有发现 Browser、CUA 或 Node REPL，因此无法实际操作该页版本选择器；2021.000 目标 URL 再次直接打开时返回不可访问，之前另一语言地址也曾返回零行。德文搜索索引显示 2021 年 10 月初始版并涉及该 BAPI 的自定义字段扩展，但在本上下文中依然属于**仅索引**，不能记为本次独立读取官方正文或现场确认版本。自定义字段扩展信息无论读取与否，均不支持推断调用方提交、回滚、更新任务或其他 BAPI 的事务语义。

## 检索结论与剩余动作

分别检索了 SAP 官方 Help、公开 PDF 和英文/德文的 `BAPI_PO_CREATE1`、`BAPI_TRANSACTION_COMMIT`、`BAPI_TRANSACTION_ROLLBACK`、`S/4HANA 2021`、`LUW` 等组合；也直接打开上述官方集成指南、历史事务模型和 2021 FPS01 出版样章。

**仍未取得符合全部条件的 SAP 官方原文**：明确 S/4HANA 2021 目标采购 BAPI，并直接说明提交、回滚或更新事务。上述 2026 官方集成指南与 2021 FPS01 非官方样章是有用的新证据，但不得拼接后冒称 SAP 官方对 2021 事务语义的直接证明。建议后续在获准的目标版本 SAP 系统中只读查看 SE37/函数文档及相关 SAP Note，或继续寻找固定产品版本的官方原文；系统实测与公开资料核验分别记录。在缺口解决前，具体事务断言保持待核，不能宣称已通过该项证据门槛。

## 独立开发者复核（2026-11-25）

`/root/developer_plan` 独立读取两份 PDF：SAP 2026 指南物理页 24 仅列特定集成的接口暴露要求；出版社样章物理页 4–6、印刷页 372–374 指定 S/4HANA 2021 FPS01 场景，并讨论普通 BAPI 消费者和 RAP 框架各自的事务边界。审查者确认它是第三方资料，不是 SAP 官方产品文档；其他 BAPI 可有内置事务控制例外，不能泛化到所有调用方式、版本、更新任务或失败分支。公开可访问不等于可重发布全文，故不复制整份样章。原结论无需修改：SAP 官方目标版本直接依据仍未获得，未作实机测试，不计文章审核轮次。


## 2021 通用事务模型与无版本示例的新增核验

`/root/developer_plan` 通过版本选择器读取 [ABAP Platform 2021 初版的 BAPI Transaction Model](https://help.sap.com/docs/ABAP_PLATFORM_NEW/166400f6be7b46e8adc6b90fd20f3516/4d5b102ba1483d8fe10000000a42189e.html?version=202110.000)，`/root/consultant_plan` 随后独立复读，均确认选择器为 2021 (Oct 2021)。原文讨论 BAPI 通常由调用方控制提交/回滚，也明示少数自带 COMMIT 的例外和函数文档/Note 0131838。它是通用模型，**未指明 BAPI_PO_CREATE1**，不能证明该函数无例外、RETURN 判断、RFC 会话或更新任务行为。

同一开发者和独立顾问实读 [Function Module Test Sequence](https://help.sap.com/docs/SUPPORT_CONTENT/abap/3353523556.html)，其 SAP Support Additional Content 示例演示顺序调用 PO 创建和提交、检查 RETURN 及设置 WAIT = 'X'；该页面无目标产品/FPS 标识，并提示 Additional Content 不属于 SAP 条款中定义的 Documentation。示例不能视为目标函数的 2021 产品契约、完整回滚规则或执行授权。此前本文件中搜索工具打开为空的记录保留为当时结果，后续浏览器实读不应倒写为原研究者已读。

**状态**：2021 通用 BAPI 模型直接证据已找到并独立复核；2021 采购函数级事务、消息、回滚及实机行为仍待核。未操作 SAP 系统，未进行正式文章审核。


## 2026-11-26｜SAP Support Additional Content 直接阅读与独立复核

Work 与独立开发复核上下文分别直接打开并读取以下两页；两页均出现 SAP 的 Additional Content 说明，明确表示其不属于适用 SAP General Terms and Conditions 所定义的 Documentation。内容背景是 ECC/R/3，页面没有 S/4HANA 2021 版本选择器。

1. [Purchasing BAPIs](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167428.html)：页面说明 BAPI_PO_CREATE1 与 ME21N 的对应关系，讨论 X 结构字段标记、RETURN 消息/调试，并称需调用 BAPI_TRANSACTION_COMMIT 才能永久保存 BAPI 更改。
2. [How to create a Purchase Order with the help of BAPI_PO_CREATE1](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167600.html)：包含 SE37 示例中的 TESTRUN（不产生数据库效果）及测试序列 BAPI_PO_CREATE1 后接 BAPI_TRANSACTION_COMMIT；页面提到 ME21N 功能对应关系，同时承认技术差异/缺项。

独立开发复核确认了上述有限摘录和版本边界。不能从这些旧版附加示例推出目标 S/4HANA 2021 的完整函数合同、提交时机规则、回滚策略、更新任务/WAIT 保证、RFC/LUW 边界或失败分支；也未证明目标 SAP 系统可用性。它们是检索线索与有限背景，不补齐 ABAP-04 的目标版本证据门槛。

**状态**：SAP Support 页面现已由 Work 与独立开发复核上下文分别直接阅读；ABAP-04 函数级 2021 事务、提交/回滚、更新任务与失败消息语义仍待目标版本直接依据。未操作 SAP 系统、未执行代码、不计正式文章审核轮次；M3 仍未通过。
