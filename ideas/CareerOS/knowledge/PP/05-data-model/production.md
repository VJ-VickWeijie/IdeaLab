# PP-09｜生产主数据与订单数据模型

- 文章 ID：PP-09
- 状态：drafting
- 目标版本：SAP S/4HANA 2021 On-Premise；ECC 只作必要差异对比
- 当前可写范围：生产版本在特定 sourcing 语境下如何关联 material BOM 与 routing；2021 简化资料中的少量订单/凭证对象名称；MM-IM 的 MATDOC 与 MKPF/MSEG 兼容访问边界；以及一项固定 SAP Cloud SDK 生成 VDM 实体键示例。
- 状态原因：没有闭合生产订单、BOM、routing、确认、物料凭证等一般业务对象的完整主键、外键和关联基数；也没有目标系统发布 API、实际元数据和授权证据。PP-02、PP-03、PP-05 依赖文章尚未出现在当前分支。核心数据模型仍不完整。
- 系统验证：SAP 系统未连接；没有读取目标系统数据库字典、运行时 $metadata 或执行 SQL/API 请求。

## 1. 先分清三层“键”

本文会出现数据库表、DDIC 兼容对象和生成的 OData VDM entity。它们处在不同层次：

1. **物理表**：本页只确认目标版 Simplification List 明确说明的 MATDOC 模型变化；没有取得 MATDOC 主键或生产订单外键的充分直接证据。
2. **兼容读取对象**：名称仍可见，不等于仍以旧表形式保存新业务数据。还要分清原文称为 compatibility view、DDL source 的对象。
3. **API/VDM 实体键**：生成模型上的 @Key 是该实体的逻辑读取键，不能转换成底层表主键，也不能证明目标客户系统已发布或授权使用此 API。

读到相同的订单号、凭证号或表名，也不能单凭名称推导一对一、一对多或可直接 JOIN。

## 2. 生产版本、BOM 与 routing：固定版文档支持的关系

SAP S/4HANA 2021 Simplification List 的 §27.35 “Simplified Sourcing” 将 in-house production 的 production version 描述为 source of supply。它说明：

- 合适的 production version 是该简化 sourcing 场景选择 material BOM 的条件之一。
- production version 关联 routing；该 routing 用于创建 production order。
- 对 make-to-order / make-to-project 场景，source 明确区分 BOM 与 routing：BOM sourcing 可以不需要 production version；若要选择 routing，仍需要 production version。
- MRP 选择时会排除标为 “Locked for any usage” 或 “Locked for automatic sourcing” 的 production version。选择还可能涉及数量/日期等有效范围，须依具体来源场景判断。

这是 **2021 简化 sourcing 的选择规则说明**，不是所有 BOM、所有制造模式、所有版本控制/工程变更或订单快照的完整数据模型。尤其不能概括成“每张 BOM 都必须有生产版本”。也不能把来源中对旧 Business Suite 的字段/配置对照，当成 2021 的主键或推荐操作。

## 3. 订单和凭证表名的有限证据

### 3.1 一个 EHS 选择条件示例

2021 Simplification List 的特定 EHS Substance Volume Tracking 选择条件中，PRO/PRODUCTION 与 CON/PRODUCTION 行列出 AUFK、AFKO、AFPO、RESB、MKPF、MSEG，并将 AFKO-GSTRS 标为 Scheduled start。

这只支持“这些名称出现在该应用选择条件上下文”和该字段在此处的说明。该表格不是 PP 数据模型目录；同一行列出多个表名不证明表间外键、连接条件或基数，也不证明直接访问它们是发布 API。

### 3.2 MATDOC 与旧名称

2021 Simplification List §24.5 的 MM-IM 部分说明：物料凭证头和项目数据进入物理表 MATDOC；MKPF、MSEG 仍可作为兼容对象被读取，读取路径由兼容 CDS 重定向。表格把 NSDM_DDL_MKPF 和 NSDM_DDL_MSEG 标为相应重定向对象的 DDL source。它们不能因此被叫作运行时 CDS 视图名称。

此材料没有给出本篇所需的 MATDOC 复合主键、生产订单引用字段、所有订单物料移动的关联规则或表连接基数。不要根据 EHS 行中共同出现的表名补出这些关系。

## 4. 一项特定确认服务的 OData entity 键

M3 的 [PP-09 固定版本 VDM 补查记录](../../plans/pp09-order-material-key-m3.md)保存了 SAP Cloud SDK 生成源包的版本、SHA-256 和逐字段读取记录。该记录将 SDK 3.59.0 定位为对应 SAP S/4HANA On-Premise 2021 VDM 的生成版本，并将 3.70.0 定位为 2021 FPS02；SAP Cloud SDK 官方发行说明也记载了 On-Premise 2021 的 VDM 更新。Work 本轮复读该项目记录和列出的字段表，没有重新下载源包。

记录中的特定 ProdnOrdConfMatlDocItmType entity（Production Order Confirmation V2 服务中的 “Material Movements for Confirmation”）有五项 @Key：

- ConfirmationGroup
- ConfirmationCount
- MaterialDocument
- MaterialDocumentItem
- MaterialDocumentYear

OrderID 和 OrderItem 在该生成类中是非键属性。该实体键只描述所列 SDK 生成 VDM entity 的读取键。它不等于 MATDOC 物理主键，不证明所有生产订单货物移动都属于此 entity，不证明实际服务在客户系统中启用、发布或可由某角色访问，也不替代目标系统运行时 $metadata。

## 5. 已有证据与未闭合数据关系

| 对象或主张 | 2021 证据目前支持什么 | 仍未证实 |
| --- | --- | --- |
| Production version、material BOM、routing | 简化 sourcing 中的选择与引用关系；MTO/MTP 的 BOM/routing 区别；锁定状态对 MRP 选择的影响 | 三者完整物理键、所有版本场景、有效期快照、变更管理与订单保存行为 |
| AUFK、AFKO、AFPO、RESB | 某个 EHS 选择条件列出这些对象；其中 AFKO-GSTRS 在该处为 scheduled start | 订单 header/item/operation/component/confirmation 的一般键、外键与基数 |
| MATDOC、MKPF、MSEG | MM-IM 新模型下 MATDOC 保存物料凭证数据；旧名的兼容读取和 DDL source 关系 | MATDOC 主键、生产订单引用字段、目标系统中视图实现和授权 |
| Production Order Confirmation V2 entity | 固定 SDK 生成类内的五个 entity key；两个订单标识为非键属性 | 实际系统 $metadata、API 发布/启用、权限、运行返回和所有 FPS/补丁行为 |
| 确认与物料凭证之间的基数 | 特定确认物料移动 entity 把确认识别字段与物料凭证识别字段放在同一 entity key 中 | 一条确认是否必然有零/一/多条物料凭证；取消、冲销、非确认发起移动的关联路径 |

## 6. 本篇保留的核心缺口

- 普通生产订单、订单项目、工序、组件、确认与物料凭证之间的目标版物理键、关联条件和基数。
- BOM、routing、production version 的一般物理模型、复合键、有效期和版本快照规则。
- SAP 2021 各 FPS 中可读且正式发布的生产 CDS/API 元数据、实体键、写操作和权限条件。
- 目标客户系统实际使用的表/视图版本、接口启用情况、运行时元数据和用户授权。
- PP-02 BOM、PP-03 routing、PP-05 production order 依赖文章。目前它们均未出现在当前分支，不能引用不存在的文章或从数据表关键词反推结论。

M3 控制矩阵当前没有独立的 PP-09 行；存在的 S4HANA-09 是相邻的通用日记账/物料凭证数据模型门禁，含 MATDOC 与 SDK key 的局部限制，但不能替代 PP-09 逐篇控制项。本次不修改共享矩阵。

## 7. 离线学习方式

可选练习：把第 5 节每行的字段标为“物理表/兼容读取/生成 API entity”，再分别写出一项已证实内容和一项不能推出的关联。不要尝试用这些表名构造生产系统 SQL 或 JOIN。练习无需 SAP 系统。

## 8. 来源

1. SAP, [Simplification List for SAP S/4HANA 2021 — Initial Shipment, FPS01 & FPS02](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=617), Document Version 1.25, §27.35 “Simplified Sourcing,” document pages 617–620. 用于 production version/BOM/routing 的特定 sourcing 关系及例外。
2. 同一 SAP 2021 Simplification List，[§27.36 目录定位](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=623)与[§25.7 BOM, Routing, Production Version](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=521)。只用于版面定位；关键词或章节标题不单独证明表字段或主键。
3. 同一来源，[EHS Substance Volume Tracking 选择条件](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=665)，document page 666。只用于表名和 AFKO-GSTRS 的特定上下文。
4. 同一来源，[§24.5 MM-IM data model](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=478)，document pages 478–480. 只用于 MATDOC 与旧对象兼容读取说明。
5. SAP Cloud SDK for Java v3, [official release notes](https://sap.github.io/cloud-sdk/docs/java/v3/release-notes)，version 3.59.0 (2021-12-02)，说明 On-Premise 2021 VDM 更新；PP-09 entity 逐字段证据和 artifact hashes 见本项目 [补查记录](../../plans/pp09-order-material-key-m3.md)。本 Work 未重新下载或解压该 source package。
6. M3 的[准入分流](../../plans/m3-item-readiness-triage-v0.3.md)、[逐篇范围与依赖](../../plans/detail-logistics-v0.3.md)、[PP-09 数据模型补查](../../plans/pp09-data-model-evidence-m3.md)和[通用技术控制矩阵](../../plans/m3-item-control-matrix-v0.3.md)用于界定范围，不替代 SAP 产品证据。
