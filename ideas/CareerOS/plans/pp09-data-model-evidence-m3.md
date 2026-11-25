# PP-09｜生产数据模型与键的 SAP 2021 来源补查

日期：2026-11-25。本次仅依据实际可读的 SAP 原始文献，区分业务对象、DDIC/数据库、CDS 和 API；不连接或测试 SAP 系统，不撰写正式文章，不将资料检索计入文章审查。目标系统 FPS、权限和发布状态未知。

## 可读并核对的 2021 官方原文

### 1. 生产版本、BOM 和工艺路线：业务关联而非表连接键

[SAP S/4HANA 2021 Simplification List 1.25，§27.35，PDF 第 617～620 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=617)，封面适用 Initial Shipment、FPS01、FPS02。已实读：文中简化 sourcing 选择按物料的采购类型、生产版本锁定状态、计划收货数量范围及日期有效期选择；该 sourcing 语境下，material BOM 的选择要求适用的生产版本，生产版本帮助 BOM 与 routing 适配，其引用的 routing 用于创建生产订单。这里的 material BOM 不能无条件等同于全部按库存制造（MTS）场景。

同 §27.35 明确：寻找 make-to-order / make-to-project BOM 时可不需要生产版本，但即使使用这两类 BOM，选择工艺路线仍需要生产版本；因此**不能把“所有 BOM 都一律必须有生产版本”当无条件事实**。该段中的 `MARC-ALTSL`、`T399X-ARBPA` 主要出现在**旧 Business Suite 逻辑对照**，并指出新简化逻辑变化；不要把它们当作目标系统生产版本主键或推荐的 S/4HANA 选择逻辑。文中没有给出生产版本、BOM 和 routing 的完整物理键、关联字段、外键基数或实际订单保存的快照规则。

[同 Simplification List，PDF 第 522～523 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=522) 在特定转换及 manufacturing BOM 的语境中描述生产版本与 BOM、routing alternative；`VERID`、`STLAN`、`STLAL` 等在“Other Terms”关键词列表出现。**关键词出现不是字段定义，更不证明它们所在表、复合主键或连接条件。** 版本、数量、日期和锁定状态必须随具体业务场景核对。

### 2. 生产订单相关对象及少量真实字段

[同 Simplification List，PDF 第 665～666 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=665) 特定 EHS substance volume tracking 选择条件映射中，`PRO/PRODUCTION` 和 `CON/PRODUCTION` 两行列出 `AUFK`、`AFKO`、`AFPO`、`RESB`、`MKPF`、`MSEG`，并将 `AFKO-GSTRS` 标为 scheduled start。此处实读原文能够支持“这些名称出现在该应用选择条件上下文”，以及 `AFKO-GSTRS` 的**该文所述含义**；它没有定义这些对象各自主键、字段间关联、基数或发布状态。尤其不能因为同一行出现而证明各表一对一连接或直接写入可行。`AFKO-GSTRS` 不是本次证明的订单主键。

[S/4HANA 2021 Feature Scope Description 11.0，§2.8.4.1，PDF 第 75 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=75) 的 Order Information System 业务功能可显示生产/流程订单的 header、items、documented goods movements、operations、components、confirmations，支持对象相关的业务概念；**不能从 UI 可导航性推定表连接键、1:1 关系或 CDS 发布 API**。FSD 动态 latest，当次台账标记 11.0、2026-07-22、2021 SPS10；本次未计算哈希或归档，不由此推断其他 FPS。

### 3. 物料凭证：物理表与兼容性对象必须区分

[Simplification List，§24.5，PDF 第 478～480 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=478) 在 MM-IM 新数据模型范围内直接说明，S/4HANA 引入物理 `MATDOC`，包含先前物料凭证头与项目数据；相关旧 DDIC 对象仍存在，读取可由兼容代理 CDS 重定向。原文表格的 **DDL Source of CDS View for redirect** 一栏分别列 `MKPF` 对应 `NSDM_DDL_MKPF`、`MSEG` 对应 `NSDM_DDL_MSEG`；这两个名称是重定向 CDS 视图的 DDL source，不能将它们直接称作运行时 CDS 视图名。原文还提示写访问需要调整。

限定：这是**所述 MM-IM 简化模型及该文版本范围**；不能把 `MKPF`/`MSEG` 当作独立保存新增业务数据的两张普通物理事实表，也不能仅凭存在兼容重定向就推断某系统授权、ABAP Cloud 释放契约或推荐直接写表。源文也**未证明本任务所需的 MATDOC 主键组合或订单关联字段**；生产订单与物料凭证的一对多关系和外键仍需直接证据。

### 4. CDS / API：目标版本键与字段仍无已读原文

SAP 搜索索引的 [2021 CDS Views for Production Planning](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b39ff179522b435584613620f5f4cdd5.html?version=2021.000) 涉及 `I_PlannedOrderComponent` 及 BOM 相关字段弃用替代，但本次**未独立打开到可读正文，不计直接证据**；即使之后实读，计划订单组件亦不能直接等同生产订单组件。字段弃用表不自动证明主键、唯一性或发布状态。

SAP 当前 [Production Order Item CDS](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/ee6ff9b281d8448f96b4fe6c89f2bdc8/82b728664a284a1796811c87221ae0e5.html) 检索结果标示 **2025 FPS02**，描述 `I_ProductionOrderItem` 与 `AFPO`；当前 [Manufacturing Order Operation Component CDS](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/6b356c79dea443c4bbeeaf0865e04207/d821563df8ef4ecb9a5fedc2bacda6fe.html) 检索结果也为 **2025 FPS02**，描述组件、`RESB` 和 BOM 项目。它们仅为后续查找线索，**不能倒推 2021 的存在、字段、数据源或发布契约**。

当前 SAP [Create Material Documents API](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/eb2a39dd0c124fed8252f684002d55e1/8bb0d08295044ee3af444b4f2a6e4457.html) 网页正文显示 **2025 FPS01**，示例包含 `ManufacturingOrder` 等属性；例子里的日期 2021 不代表 API 文档为 2021 版本。不得把这些属性、请求示例和操作能力记为 2021 已证。检索到的 [Production Order API V2 2022 变更](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f5d3e1005efd4e86acf9a65abf428082/5c77cf91b280454aaeaff65ba11389ae.html?version=2022.000) 同样只属邻近线索；流程制造的 Process Order API 不能当离散制造 Production Order API。

## 结果和未解除的门禁

| 所需知识 | 目前可核实范围 | 尚未证实 |
| --- | --- | --- |
| 生产订单、项目、工序、组件、确认 | 2021 SPS10 FSD 的订单信息系统提供对象级视图；特定 EHS 场景列若干表名及 `AFKO-GSTRS` | 订单键、头项/工序/组件/确认的完整复合键和基数；表是否允许外部直接消费 |
| BOM、routing、生产版本 | 初版/FPS01/FPS02 简化资料解释常见选择关系和特殊场景例外 | 各对象物理表及键、版本记录有效性、变更状态与订单快照规则 |
| 物料凭证 | 初版/FPS01/FPS02 MM-IM 转换资料确认 MATDOC 与历史对象/CDS 代理关系 | `MATDOC` 主键、物料单号/年度/项目字段、订单引用字段及关联基数；已发布 API 的实际契约 |
| CDS 和 API | 找到相关新版本/索引线索 | 2021 对应 FPS 的可读正式元数据、各字段键、可用操作、服务发布/授权及字段弃用限制 |

后续需找 2021 对应 FPS 的 SAP 官方数据字典、CDS 文档或 API 元数据，逐一证明物料凭证号/年度/项目、订单号、版本、BOM、routing、工序和确认键，再分清逻辑视图/接口键与物理主键；有授权时方可在非生产环境只读核对。无此证据时，PP-09 不能称为数据模型完成。

## 独立顾问复核及本次修订（2026-11-25）

独立顾问实际实读 Simplification List PDF 第 618～619 页（简化 sourcing）和第 479～480 页（MM-IM 模型/重定向），指出本报告应限定 material BOM 的来源选择语境，不能把 material BOM 视为全部 MTS，并应将 `NSDM_DDL_MKPF` / `NSDM_DDL_MSEG` 正确标为原文列出的重定向 CDS 的 DDL source，而非运行时 CDS 视图名称。作者已据此修订以上对应段落；当时该修订尚待原顾问重新检查，后续复核结果见下。其余键、字段、基数、目标 FPS 与发布状态缺口不变，仍不代表正文审核通过。


## 独立复核结果

`/root/consultant_m3_review` 独立读 §27.35 的 PDF 618–619 页与 §24.5 的 479–480 页，提出限定 material BOM 简化 sourcing 及 DDL source 名称的修订。作者据此修改后，原审查者复读并确认这两处文字；仅关闭这两项限定问题，订单键、基数、API 与系统测试仍待证，不计正式文章审核。
