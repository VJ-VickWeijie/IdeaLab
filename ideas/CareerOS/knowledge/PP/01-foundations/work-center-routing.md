# PP-03｜工作中心与工艺路线（Routing）：把组成、工序和工作地点分开

> 状态：Draft（概念主线已补证；选择、成本/产能计算等 M3 核心细节仍缺目标版直接依据）｜M4 批次 A｜目标版本：SAP S/4HANA 2021 On-Premise。本文使用一份动态 FSD 中实际读取到的 2021 SPS08 文档快照，并单独列出固定版 2021.000 应用资料；不把 SPS08 快照称作 2021.000 初始版或客户系统结果。

## 先区分三个问题

制造一个产品时，可以把基础问题拆成三项：

1. **用哪些组件？** BOM（Bill of Material，物料清单）描述组成产品的组件。
2. **要做哪些工序，按什么顺序做？** 在离散制造中，Routing（工艺路线）描述生产材料所需的工序/步骤及其顺序。
3. **在哪些资源上做？** Work Center（工作中心）用于表示机器、生产线、员工或员工组等生产对象/人员；工序会关联到相应工作中心。

SAP S/4HANA 2021 的 FSD 在一份明确标为 SPS08 的文档快照中，将工作中心与 BOM、Routing 放在生产计划与控制的主数据背景里；并说明工作中心用于排程、成本、产能计划和简化工序维护。它把离散制造的 Routing 描述为工序/步骤及其顺序，并说其中包含相应工作中心和所需 BOM 组件的信息。以上是概念层描述，不等于字段、计算公式或客户现场配置规则。

## Routing 与 Work Center 在概念上怎样配合

| 对象 | 回答的问题 | 2021 SPS08 FSD 快照直接支持的概念 | 本文不据此推断 |
| --- | --- | --- | --- |
| BOM | 产品由什么组成？ | BOM 是组成产品的组件清单；Routing 描述中也会涉及所需 BOM 组件。 | BOM 与工序组件如何精确分配、用量/单位、有效日期、缺件处理。 |
| Routing | 制造时要做哪些步骤、顺序如何？ | Routing 描述生产产品所需的工序/步骤及顺序；离散制造中可作为创建生产订单的基础。 | 工序编号规则、替代路线选择、有效期/数量区间、工序状态及详细选择算法。 |
| Work Center | 哪些对象或人员参与生产、在哪里执行？ | 可表示机器、生产线、员工或员工组；与 BOM/Routing 一起用于排程、成本、产能计划和简化工序维护。 | 主数据完整字段、公式、标准值、成本中心/作业类型映射、产能日历和实际授权。 |
| Production Version | 多种生产方式中，哪一组 BOM 与 Routing 用于某材料？ | FSD 说明材料可能有多个 BOM 和 Routing；分配给材料的 production version（生产版本）用于定义生产所用的 BOM 与 Routing。 | 生产版本的创建前提、日期/数量选择算法、缺失或重叠版本的处理。 |

### 一个仅用于理解对象的例子

假设虚构成品 FG-100 由 BOM 列出零件 A、B；生产过程先加工零件 A，再把 A 与 B 装配。Routing 用来表达这些生产步骤及其先后顺序；每个步骤可关联执行该工作的 Work Center，例如某台机器或装配线。

这是概念示意，不是可直接录入 SAP 的主数据样例。没有真实物料、工厂、工序编号、工作中心编号、数量、时间、成本值或有效期，也不展示 SAP 的选版结果。

## 生产版本只说明 BOM 与 Routing 的配对关系

若材料有多种 BOM 或 Routing，生产版本是理解“为该材料指定哪一组 BOM 与 Routing”的关键对象。2021 SPS08 FSD 快照支持这个配对关系的概念。它没有在该段给出生产版本选择优先级、有效日期、批量范围或冲突处理规则，所以不能从“生产版本会指定组合”进一步推导出系统在任意订单日期和数量下如何自动选中某一版。

这与 PP-02 的 BOM 组件结构主题相连，但本篇不替 PP-02 补写数量、替代项或缺件行为。后续 MRP、生产订单和配置文章也须分别核对各自规则。

## 固定 2021.000 资料能够确认的特定入口

SAP Help 的固定 2021.000 “Manage Routings” 页面说明，在 Scope Item BJ5（按库存生产—离散制造）范围内，该应用可搜索现有 Routing，并导航到创建/更改应用。这确认了特定场景的应用入口；不构成所有 PP 场景都可用、用户只读或已经获授权的证明。

同一固定版本的 “OData API: Work Center” 条目描述 BJ8（基于流程订单的按库存流程制造）中的一个 OData V4 服务，支持创建、读取和更新 Work Center，并列出 header、description、cost center allocation、pooled capacity assignment、capacity header、capacity description、capacity intervals 和 capacity shifts 等实体类别。此条目只说明该版本文档中的服务能力和范围；不证明客户已启用服务、当前用户已获授权，也不提供通用工作中心字段合同或成本/产能公式。因为它包含写入能力，不能把它当成只读查询入口。

因此，固定版应用/接口文档与 SPS08 FSD 快照承担不同作用：前者证明特定应用或 API 范围，后者提供概念主线。二者不应合并成一个“所有场景都适用”的规则清单。

## PEO 专用路线是边界案例，不是通用 Routing 定义

2021 PEO-ERP Implementation Guide 另有 shop-floor routing（车间路线）及其版本、MBOM 等专用模型。这类 PEO 说明可以作为“存在专用路线模型”的版本例子，但不能把 PEO 的对象层级、effectivity 或版本关联方式推广到普通 PP Routing。本文不以 PEO 指南填补标准离散制造的路线选择和产能计算缺口。

## 仍未闭合的 M3 内容

M3 将 PP-03 标为“限缩可写”，并要求补查工作中心完整定义、工序选择和成本/产能参数。本次可安全说明概念主线，但下列核心细节仍缺少可直接复核的 S/4HANA 2021 资料，因此本文继续保持 Draft：

- Routing 的完整工序字段、编号/顺序细节、工厂适用性、替代路线及日期/数量选择。
- 工序如何分配 Work Center，以及 standard values、formula、capacity requirements、成本估算之间的准确关系。
- Work Center 的完整字段/组织层级、成本分配和产能参数；FSD 中“用于成本/产能计划”的高层用途不能替代这些细节。
- 生产版本、BOM、Routing 与批量/有效期的具体选择和冲突处理。
- BOM 组件与工序的精确关联、单位/用量、缺失组件、客户配置与授权。

下一步应分别补到可读的 2021.000 固定版产品帮助/配置说明或明确标注 FPS/SPS 的直接资料，再决定这些结论是否可用于学习示例。不得用当前动态 FSD、其他产品版本、客户配置或经验公式补齐通用规则。

## 离线练习：先分清对象，再标出未核实规则

1. 在“组件组成”栏画 BOM，在“步骤与顺序”栏画 Routing，在“执行资源”栏写 Work Center。
2. 选一个虚构产品，用三种不同颜色分别标注组件、工序和工作地点；不要添加 SAP 编号、公式、有效期或选择结果。
3. 把“生产版本指定 BOM 与 Routing 组合”写成一条已由 SPS08 FSD 概念支持的说明；把数量范围、有效期和选版条件列在“仍待证据核实”栏。
4. 读固定版 2021.000 Manage Routings 页面时，只记录它明确支持的动作：搜索、导航到创建、导航到更改；不要把导航入口写成当前用户的权限承诺。

练习不要求连接 SAP，也不表示任何客户系统已经配置或经过实测。

## 目标版本资料与证据边界

1. SAP Help，[“Manage Routings”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/9a63a564ff1c4194843dec4c37dfb033.html?locale=en-US&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000，Scope Item BJ5。固定版本索引可见内容支持搜索 Routing 并导航至创建/更改应用；本轮直接打开 HTML 为 0 可读行，因此不扩展其结论。
2. SAP Help，[“OData API: Work Center”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f7e7144c65a647c3a68d84db06bc54c4.html?locale=en-US&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000，Scope Item BJ8。固定版本索引可见内容支持该特定服务的操作与实体类别；本轮直接打开 HTML 为 0 可读行。
3. SAP，[S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，§2.7.2.2 “Master Recipe/Routing Management”，PDF pp.64–65。此 URL 为动态 `latest`；本轮 2026-11-27 直接打开返回 Document Version 9.0（2025-07-23），对应 S/4HANA 2021 SPS08。本文只按该读取快照使用其中概念描述，不称其为固定 2021.000、初始版或其他 FPS/SPS 证据。SAP Help 对同一路径的索引另返回 Document Version 11.0（2026-07-22）；为避免混合不同快照，本篇未将其加入证据。
4. SAP，[PEO-ERP Implementation Guide for S/4HANA 2021](https://help.sap.com/doc/1fc98f1186c147679a500745f95fd327/2021/en-US/S4HANA_PEO_Implementation_Guide.pdf)，仅作 PEO 专用路线的边界示例；不推广为标准 PP Routing 规则。
5. M3 范围及待核对项目：[逐篇范围、版本线索与依赖](../../../plans/detail-logistics-v0.3.md)、[逐篇准入分流](../../../plans/m3-item-readiness-triage-v0.3.md)、[M3 来源登记](../../../plans/evidence-logistics-m3.md)。这些计划文件不是 SAP 产品事实来源。

SAP 系统未连接；未执行实机、配置、数据库、API 或权限测试。
