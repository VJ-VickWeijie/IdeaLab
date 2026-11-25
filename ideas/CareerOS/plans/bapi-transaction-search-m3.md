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

[SAP Support for Extension of Purchase Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/0fbc805785a0403d9f56beacf89c0ef4.html?version=2021.000)，搜索索引将其标为 S/4HANA 2021 initial，涉及 `BAPI_PO_CREATE1` 的自定义字段扩展。本执行上下文用网页工具打开时正文为零行，因此这里仅记录搜索线索；即便可读，该公告主题也不是提交/回滚。

相关官方 2021 initial What's New PDF 因文件大小约 15 MB 超出网页读取工具限制，未能读取对应正文，不能声称已核实。2021.1 `Cross-Plant Planning` PDF 已读到采购 BAPI 扩展参数，但它描述 ERP 的 SCM Consulting Solution 附加组件，日期或 `2021.1` 不足以证明 S/4HANA 2021 产品及事务行为。

## 检索结论与剩余动作

分别检索了 SAP 官方 Help、公开 PDF 和英文/德文的 `BAPI_PO_CREATE1`、`BAPI_TRANSACTION_COMMIT`、`BAPI_TRANSACTION_ROLLBACK`、`S/4HANA 2021`、`LUW` 等组合；也直接打开上述官方集成指南、历史事务模型和 2021 FPS01 出版样章。

**仍未取得符合全部条件的 SAP 官方原文**：明确 S/4HANA 2021 目标采购 BAPI，并直接说明提交、回滚或更新事务。上述 2026 官方集成指南与 2021 FPS01 非官方样章是有用的新证据，但不得拼接后冒称 SAP 官方对 2021 事务语义的直接证明。建议后续在获准的目标版本 SAP 系统中只读查看 SE37/函数文档及相关 SAP Note，或继续寻找固定产品版本的官方原文；系统实测与公开资料核验分别记录。在缺口解决前，具体事务断言保持待核，不能宣称已通过该项证据门槛。

## 独立开发者复核（2026-11-25）

`/root/developer_plan` 独立读取两份 PDF：SAP 2026 指南物理页 24 仅列特定集成的接口暴露要求；出版社样章物理页 4–6、印刷页 372–374 指定 S/4HANA 2021 FPS01 场景，并讨论普通 BAPI 消费者和 RAP 框架各自的事务边界。审查者确认它是第三方资料，不是 SAP 官方产品文档；其他 BAPI 可有内置事务控制例外，不能泛化到所有调用方式、版本、更新任务或失败分支。公开可访问不等于可重发布全文，故不复制整份样章。原结论无需修改：SAP 官方目标版本直接依据仍未获得，未作实机测试，不计文章审核轮次。
