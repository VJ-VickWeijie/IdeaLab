# SD-02｜客户业务伙伴与物料主数据

> 状态：`drafting`｜M4 批次 A｜目标版本：SAP S/4HANA 2021 On-Premise。本文按 M3“限缩可写”范围讲 Business Partner（BP）客户角色、销售交易中的伙伴职能、客户数据组织层级，以及物料主数据与销售相关信息的有限联系。BP grouping/编号、完整伙伴确定配置、物料销售视图字段/组织键、API 合同、客户系统配置和权限尚未全部核实。

## 先区分 BP、客户角色、伙伴职能和物料

| 术语 | 本篇的入门理解 | 不要据此推出 |
| --- | --- | --- |
| Business Partner（BP） | 业务伙伴主数据对象。S/4HANA 2021 的 Manage Business Partner Master Data 页面说明，一个 BP 可以分配多个主数据角色。 | 客户和供应商在任何应用中都只能经同一屏幕维护；或所有系统使用方式、迁移数据和权限都相同。 |
| BP role | BP 主数据具备的角色。目标版页面正文列举 `FLCU00`（FI Customer）和 `FLCU01`（Sales Customer）。 | BP role 就是客户在某个销售订单中的交易伙伴职能；也不据此推定编号或组织视图已经存在。 |
| Partner Function（伙伴职能） | 业务交易中某个业务伙伴承担的职责，例如售达、送达、开票或付款。 | 这些职能在所有业务单据类型中都固定、必填，或一定由四个不同的客户承担。 |
| Customer Account Group（客户账户组） | 可先把它理解为客户主数据配置中的一个分组项。2021 Partner Functions 页面说明它参与定义哪些账户组可用于哪些伙伴职能；2021 Field Status 页面说明账户组也参与字段状态设置。 | 本篇不补充账户组的完整结构或编号；它不是 BP role，也不能与 BP grouping/编号规则互换。 |
| BP Grouping（BP 分组） | 本篇不定义其编号作用。M3 没有核实该主题的 2021 固定版直接来源。 | 不要把 grouping、account group、BP role 当成同一概念。 |
| Material Master（物料主数据） | 描述材料的信息；固定版 2021 物料主数据页面把 Sales and distribution 列为信息类别之一，并举销售价格、最小订单数量等示例。 | 该类别等于某个确定的 Fiori/GUI 视图、字段表、销售组织/渠道键或工厂视图的完整定义。 |

特别要区分 **BP role** 和 **partner function**：前者说明 BP 主数据承担什么业务角色，后者说明交易中某伙伴承担什么职责。`FLCU01` 是页面列出的 BP 销售客户角色；“售达方/送达方/开票方/付款方”是交易伙伴职能。它们有关联，但不是同一套标签。

## 销售业务中的客户伙伴职能

SAP S/4HANA 2021 `Partner Functions` 页面把伙伴职能解释为交易中业务伙伴的权利和责任，并列出下列客户职能作为标准系统示例：

| Partner Function | 中文常用说法 | 2021 页面举出的信息例子 | 学习边界 |
| --- | --- | --- | --- |
| Sold-to Party | 售达方 | 销售数据，例如销售办公室或有效价目表。 | 这些是页面举例，不是售达方字段完整清单。 |
| Ship-to Party | 送达方 | 卸货点、收货时间等运输/收货相关信息。 | 不据此推断送达地址如何被系统自动选择。 |
| Bill-to Party | 开票方 | 地址、单据打印和电子通信相关数据。 | 不代表此伙伴必然承担付款或应收清账。 |
| Payer | 付款方 | 页面举出开票计划和银行数据。 | 不等于已经发生收款，也不推断付款条件、银行处理或清账规则。 |

同一个客户可以承担多个甚至全部上述职能；另一个页面例子是分支机构订货、总部付款，此时可涉及多个客户主记录，并在售达方客户记录中关联其他伙伴职能对应的客户编号。这是页面中的业务例子，只说明其提到的客户记录/编号关联，不描述技术字段、数据库键或固定关系基数，也没有定义这些客户编号与 BP 对象编号之间的完整对应关系。这些例子不意味着每个伙伴职能都要有单独客户或 BP，也不意味着每个销售订单都必须有四个不同客户。

## 伙伴确定：允许/必需是交易与配置的结果

2021 `Partner Functions` 页面说明两层关系：

1. 客户或供应商账户组的配置用于定义哪些账户组可用于哪些伙伴职能。
2. `Partner Determination Procedure` 规定特定业务交易允许或必须使用哪些伙伴职能。

因此，入门时可以理解为：系统中的伙伴职能集合取决于交易场景和配置。页面没有证明特定企业的伙伴确定程序、销售单据类型设置、默认伙伴来源、字段值自动复制或用户权限。本篇不提供 IMG 配置路径，也不把“常见客户角色”写成全部系统的必填规则。

## 客户主数据的组织层级

目标版 `Business Partner Master Data Structure` 页面区分通用数据、公司代码数据和销售数据的组织范围：

| 数据范围 | 2021 页面支持的有限说明 | 不应超出的结论 |
| --- | --- | --- |
| General data（通用数据） | 不依赖公司代码、销售与分销组织或采购组织；页面举名称、地址、电话号码等。 | 不据此推断所有客户自定义字段都全局共享。 |
| Company Code data（公司代码数据） | 每份公司代码数据适用于一个指定公司代码；页面举 account management data 等例子，访问该视图需指定客户编号和公司代码。 | 这是页面描述的单份数据范围，不表示一个客户最多只能关联一个公司代码；页面所述访问上下文也不等于数据库键或 API 输入合同。它不是字段全表或实际用户可见范围。 |
| Sales data（销售数据） | 客户数据可因 Sales Area 而异；页面将 Sales Area 描述为 Sales Organization、Distribution Channel 和 Division 的组合。页面举定价数据、交货优先级和装运条件等销售与分销信息。 | 不据此推导底层表/键、API 输入合同、所有字段的销售组织粒度、每种销售区域都已配置或实际授权。 |

该页面还指出，处理销售订单等销售业务前需维护客户销售与分销数据；开票需要为在该业务中承担 Payer 伙伴职能的客户主记录维护相应 Financial Accounting 视图数据。这里描述的是页面所述的主数据准备范围，不表示 Payer 职能本身拥有一个 FI 视图，也不证明其对应哪个 BP role、某个客户系统数据已存在，或订单/发票一定按某一完整流程过账。

## 物料主数据：可以确认销售相关信息类别，不能臆定具体视图模型

客户主数据和物料主数据是不同的主数据对象：前一节的 Sales data 按客户的 Sales Area 描述；物料主数据页面的 `Sales and distribution` 是物料信息类别，两者不能按相同名称互相映射。固定版 S/4HANA 2021 `Material Master Data` 页面把 `Sales and distribution` 列为物料主数据信息类别之一，并举销售价格、最小订单数量和销售部门等例子。可据此建立“物料主数据中存在销售相关信息”的入门认识。

**证据边界：**该 M3 来源和已审核的 [MM-02《物料主数据与供应商业务伙伴》](../../MM/01-foundations/material-business-partner.md) 仅支持上述类别级别的概览。本文没有足够目标版直接证据逐项确认具体的 `Sales: Sales Organization`、`Sales: General/Plant` 等视图名称、字段、键、必需组织层级或 API。需要进一步使用销售视图时，应把这些点标成待核，而不要从类别示例或较新版本文档推断。

## 字段状态、Fiori 页面与权限不是一回事

固定版 `Field Status Control Based on Account Groups` 页面说明，可以在客户或供应商账户组配置中，为通用、公司代码、销售区域或采购数据字段定义可选、必输、隐藏、显示等状态。页面还描述这些字段属性在特定标准 Fiori 应用中的呈现方式，并限定为标准客户/供应商角色以及相应标准 UI 实际包含的字段；它也提到 Maintain Business Partner WebGUI 应用会反映相关字段属性。

这描述的是字段属性配置和页面呈现范围，不是给某个用户授予业务权限。`Manage Business Partner Master Data` 2021 页面记录了该应用的业务角色前提 `SAP_BR_BUPA_MASTER_SPECIALIST`，但这不证明用户账号拥有该角色、可访问某个客户数据，也不等同于 BP 主数据中的 `FLCU01`。具体 UI 启用、字段状态、访问控制和系统角色均须在目标环境核实。

## 只读学习练习

不需要连接生产系统。使用虚构资料，把“页面支持”“例子/假设”和“当前未知”分栏：

1. 一个客户 BP 同时承担售达方和付款方。说明 `FLCU01` 与这两个 partner functions 分别属于什么概念，并列出不能从角色名称推出的内容。
2. 只按 2021 页面，分别说明一份 General data、Company Code data 和 Sales data 的组织范围。题目只比较数据范围，不假设每个客户或每笔业务都必须维护这三类数据；Company Code data 的范围描述也不能推出一个客户最多只能有一个公司代码数据集。哪些字段或键仍需额外来源？
3. 一项物料记录列有 `Sales and distribution` 信息类别。你能否据此确认具体 Fiori/GUI 销售视图、字段、组织键或授权？还需要什么版本固定的证据？

**参考思路：**`FLCU01` 是 BP 主数据角色；售达方与付款方是伙伴职能。General data、Company Code data、Sales data 的组织范围可按目标版页面有限复述；但具体字段、完整伙伴确定配置、BP grouping/编号、物料销售视图组织范围、API 和用户权限须保留为待核。

## 来源与复核边界

- SAP Help：**Partner Functions**，SAP S/4HANA On-Premise `2021.000`：[官方页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/7b24a64d9d0941bda1afa753263d9e39/806fbd534f22b44ce10000000a174cb4.html?version=2021.000)。只使用其伙伴职能示例、账户组关系和 partner determination procedure 的有限说明。
- SAP Help：**Manage Business Partner Master Data**，`2021.000`：[官方页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/74b0b157c81944ffaac6ebc07245b9dc/e28f3bd8baff43b7a63287cf47ea5f60.html?version=2021.000)。只取 BP 可分配多个角色、FLCU00/FLCU01、角色导航及应用业务角色前提；有关供应商角色的表格/案例不用于本文结论，M3 来源记录登记了原文内部不一致。
- SAP Help：**Business Partner Master Data Structure**，S/4HANA On-Premise `2021.000`：[官方页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/7b24a64d9d0941bda1afa753263d9e39/776fbd534f22b44ce10000000a174cb4.html?version=2021.000)。只使用 General data、Company Code data、Sales data 的页面层级和所举字段示例。
- SAP Help：**Field Status Control Based on Account Groups**，S/4HANA On-Premise `2021.000`：[官方页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/06c953e341b146a594a0d38aa87670e8.html?version=2021.000)。该 What's New 条目标明 Valid as Of SAP S/4HANA 2021；本文不由字段属性配置推断实际用户权限。
- SAP Help：**Material Master Data**，S/4HANA On-Premise `2021.000`：[官方页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/3d7eb65334e6b54ce10000000a174cb4.html?version=2021.000)。仅作销售与分销信息类别的依据；MM-02 对其他物料组织粒度仍保留字段级限制。
- M3 记录：[SD-02 2021 BP 与伙伴职能来源核验](../../../plans/sd02-partner-2021-evidence-m3.md)；[SD-02 逐篇准入](../../../plans/m3-item-readiness-triage-v0.3.md)；[物流证据台账](../../../plans/evidence-logistics-m3.md)；[三角色审查记录](../../../reviews/work/2026-11-27-m4-sd02-three-role-review.md)。

M3 记录称四篇 SAP Help 页面曾由配置顾问直接读取，版本选择器均显示 `2021 (Oct 2021)`；其中伙伴职能和 Manage Business Partner 页面另有独立审查者复读记录。本轮检索无法重新打开前三篇固定版页面，Field Status 页面仅有固定版索引正文可读；因此没有声称本轮亲自重新读取前三页，也未使用未固定版页面填补其内容。本文不列出或宣称任何已 released 的 BP/客户 API；维护应用页面不替代目标版接口文档和发布状态证据。未连接 SAP 系统；没有查看客户 BP/物料记录、实际伙伴确定配置、API、Fiori 角色或权限。
