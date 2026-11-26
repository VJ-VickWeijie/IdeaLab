# PP-03｜工作中心与工艺路线（Routing）：先识别对象和证据边界

> 状态：drafting（证据受限草稿；同上下文角色视角闭环不等于独立 review）｜M4 批次 A｜目标版本：SAP S/4HANA 2021 On-Premise。固定版资料目前只支持若干特定产品入口与 PEO 场景；通用工序顺序、Routing 与工作中心的完整关系、选择/有效期规则及成本/产能计算仍未闭合。

## 本篇要学什么

PP-02 先看产品由哪些组成项构成；PP-03 原定继续了解工作中心（Work Center）与工艺路线（Routing）。两者在学习上是不同问题，但本篇只会陈述 SAP S/4HANA 2021 固定资料能够直接支持的内容。**不能把产品说明中的“可搜索 Routing”或某个 PEO 专用路线模型，直接当成所有标准 PP 场景的完整业务定义。**

## 2021 固定资料能确认的几件事

### 1. 离散制造场景中的 Routing 应用入口

S/4HANA 2021.000 的 “Manage Routings” 页面说明，该应用用于搜索现有 routings，并导航到创建新 Routing 或更改已有 Routing 的应用。页面标注 Scope Item BJ5（Make-to-Stock Production - Discrete Manufacturing）及组件 PP-BD-RTG。

这说明目标版文档在这个特定范围内提供了 Routing 管理入口。该页没有说明完整工序结构、工序选择、工厂适用性、替代 Routing、有效日期或作业时间公式，因此不能仅凭此页面编写这些规则；创建/更改入口也不是只读入口。

### 2. 工作中心资料的一个特定 API 范围

S/4HANA 2021.000 的 “OData API: Work Center” 条目说明，这个 OData V4 服务可以创建、读取和更新 work centers，并列出若干数据实体类别：header、description、cost center allocation、pooled capacity assignment、capacity header、capacity description、capacity intervals 和 capacity shifts。页面限定 Scope Item BJ8（Make-to-Stock - Process Manufacturing Based on Process Order）。

这份资料只支持该服务及其目标版文档范围。它不能证明每个客户都启用了该 API，也不能说明所有制造场景中的工作中心定义、字段必填性、产能公式、成本计算或用户授权。因为服务包含 create/update，本篇不把它当成安全只读入口。

### 3. “Routing operation”一词在另一特定范围中的用法

S/4HANA 2021.000 的 “OData API: Production Routing” 条目在 Scope Item 3W4（Third-Party Shop Floor Execution - Discrete Industry）中提到：可读取 Production Routing 中某 operation 所需的生产资源/工具（Production Resources and Tools，PRT），包括 Material PRT、Equipment PRT、Miscellaneous PRT 和 Document PRT。

这说明该范围的官方文档使用了 routing operation 和 PRT 这些对象名称；它不支持所有场景下的完整 Routing 结构、工序顺序、工作中心分配规则或可用 API 的授权结论。

### 4. PEO 专用的 shop-floor routing 示例

另一份固定的 SAP S/4HANA 2021 PEO-ERP Implementation Guide 描述了 PEO（Production Engineering and Operations）中的 shop-floor routing：它由 operations 组成；每个 operation 至少有一个 operation activity；在同一 work center 处理的 operation activities 会归入同一个 operation。该指南还把 shop-floor routing、版本、MBOM 和生产版本放在 PEO 的专用上下文中讨论。

可以把它当作“目标版本存在一种更细的 PEO shop-floor routing 模型”的例子。它不是标准 PP routing 的通用定义；本篇不把 PEO 的对象层级、effectivity、版本或 BOM 关联方式推广到其它路线类型。

## 工作中心和 Routing：可以先分开问的问题

| 名称 | 固定版资料直接支持的范围 | 目前不能据此推出 |
| --- | --- | --- |
| Routing | BJ5 的 Manage Routings 应用可搜索现有 Routing，并导航到创建/更改应用；3W4 的 API 文档提及 operation 所需的 PRT。 | 所有 Routing 如何表示完整加工顺序、操作控制、版本、替代或有效期。 |
| Work Center | BJ8 的特定 OData API 资料列出工作中心和 capacity/cost-center 相关实体类别。 | 通用工作中心定义、产能计算公式、成本归集/结算方式、组织分配和每个用户的授权。 |
| PEO shop-floor routing | 2021 PEO 专用指南描述 operations、operation activities 以及同一工作中心活动的分组。 | 经典 routing 与 PEO routing 完全同构，或所有 S/4HANA 2021 PP 用户都有这些应用/权限。 |
| BOM 与 Routing 的选择关系 | PP-02 文章记录 BOM 层级结构；PP-03 只能指出 M3 把两篇列为关联主题。 | 通用生产版本、替代 BOM/替代 Routing、日期/数量选择和同步规则。 |

表内“不能推出”表示当前文章证据不足，不是否定目标产品可能存在相应规则。

## 暂不写成 2021 通用规则的核心问题

M3 将本篇批准为“限缩可写”，并要求补证工作中心完整定义、工序选择、成本/产能参数，以及 Routing 的替代/有效期和与 BOM 的关系。现有固定版来源没有闭合这些目标。

因此，本篇暂不提供：

- 一般离散制造 Routing 的工序顺序、工序编号/子工序或默认选择算法。
- 标准 Routing 与工作中心的字段映射、作业时间、公式、capacity requirement 或成本计算。
- Routing/BOM alternative、production version、lot size、validity date 之间的普遍选版规则。
- 客户工厂、工作中心、成本中心、产能日历或成本控制数据的实际配置与授权。
- 物理表、字段键、关联基数、API release 状态或可执行的读/改步骤。

上述项目需要固定版 2021 的逐项直接来源；PEO 专用指南、动态 FSD 快照或经验做法都不能替代这些证据。

## 离线练习：识别“路线对象”而不模拟系统规则

无需 SAP 登录，可以把下面的问题写在纸上：

1. 将 PP-02 的“组件组成结构”与本篇的“Routing 管理对象”分成两个问题栏。
2. 读 BJ5 Manage Routings 页面，记下它明确支持的入口动作：搜索、导航至创建、导航至更改。
3. 读 PEO 专用指南片段，标注它明确出现的层级：shop-floor routing → operation → operation activity；旁边写明“仅 PEO 示例”。
4. 对工序选择、工序排序、工作中心分配、耗时和成本计算标记“待目标版资料核实”，不填写猜测值。

这项练习只训练证据分层，不代表任何客户系统已配置或实测，也不要求执行创建/更改操作。

## 与关联文章的边界

- [PP-01｜生产业务与组织结构](production-organization.md) 仍因工厂组织关系和制造模式核心证据不足而保持 drafting；本篇不借用它未证实的组织结论。
- [PP-02｜物料清单（BOM）](bom.md) 当前解释固定版资料支持的 BOM 层级结构，数量与选版仍有缺口。PP-03 不因此补写 BOM 选择规则。
- M3 将 PP-03 与 PP-01、PP-02 关联；PP-04 的 MRP 关系在下篇再按其自身材料核验。本次未读取 PP-04 正文。

## 目标版本官方来源

1. SAP Help Portal，[“Manage Routings”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/9a63a564ff1c4194843dec4c37dfb033.html?locale=en-US&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000，Scope Item BJ5。支持特定离散制造范围内搜索已有 Routing 并导航到创建/更改应用。
2. SAP Help Portal，[“OData API: Work Center”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f7e7144c65a647c3a68d84db06bc54c4.html?locale=en-US&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000，Scope Item BJ8。支持该 OData V4 服务及其列出的 work-center/capacity 数据类别；不是只读或所有场景的权限证明。
3. SAP Help Portal，[“OData API: Production Routing”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/470053ffc09249bea07e09bd113d0cf9.html?locale=en-US&state=PRODUCTION&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000，Scope Item 3W4。只支持文档说明的 operation PRT 读取能力与资源类型。
4. SAP Help Portal，[“Manage Shop Floor Routings”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/7cb8c2893d224d0bbe47c4102d136a12.html?locale=en-US&state=PRODUCTION&version=2021.000)，S/4HANA 2021。仅用于说明 PEO shop-floor routing 的专用版本/header/effectivity 资料，不作标准 routing 通则。
5. SAP，[PEO-ERP Implementation Guide for SAP S/4HANA 2021](https://help.sap.com/doc/1fc98f1186c147679a500745f95fd327/2021/en-US/S4HANA_PEO_Implementation_Guide.pdf)，§“Operation Activities”及相关 PEO 章节，PDF 第 94 页附近。仅支持 PEO 专用 shop-floor routing 模型；不得推广到全部 PP routing。
6. M3 范围和原来源登记：[逐篇范围、版本线索与依赖](../../../plans/detail-logistics-v0.3.md)、[逐篇准入分流](../../../plans/m3-item-readiness-triage-v0.3.md)、[物流来源登记](../../../plans/evidence-logistics-m3.md)、[SD/PP 来源贴合度复核](../../../plans/sd-pp-source-fit-m3.md)。这些是计划/范围记录，不替代产品事实证据。

M3 原记录引用的 FSD_OP2021_latest.pdf 是动态 URL；本稿不以当前快照证明固定版 2021 事实。SAP 系统未连接；未执行或声称执行实机测试。
