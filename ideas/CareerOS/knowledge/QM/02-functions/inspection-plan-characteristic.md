# QM-03｜检验计划与检验特性

- 文章 ID：QM-03
- 状态：drafting（固定版证据受限）
- 目标版本：SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比
- 当前可确认范围：固定版 SAP S/4HANA 2021 FPS01 文档记录了 Manage Inspection Plans 工作清单按材料筛选的功能变化；2021.000 文档记录了该应用及 Inspection Plan OData API 的业务事件范围。
- 状态原因：M3 原有检验规划概述来自动态 FSD latest，不作为固定版 2021 依据。本轮固定版资料未闭合检验计划选择规则、计划/工厂有效期、检验特性字段、sampling parameters 或无计划处理。现稿只保存可确认的产品变化，尚不能替代准入目标中的完整文章。
- 系统验证：SAP 系统未连接；未打开客户系统、配置、计划/特性主数据、权限或 API 元数据；未做实机测试。

## 1. 这篇文章当前能确认什么

SAP S/4HANA 2021 FPS01 的固定版《What's New》在 QM 小节记录了 Manage Inspection Plans 应用的一项变化：工作清单可以按材料筛选检验计划。该条目同时列出 scope items 1E1、1FM、1MP、1MR 与 BNQ，应用组件为 QM-PT-IP，适用版本为 SAP S/4HANA 2021 FPS01。

SAP S/4HANA 2021.000 的固定版《Business Events for Inspection Plans》记录：Manage Inspection Plans 应用及 Inspection Plan OData API 在创建、更新或删除 inspection plan 时可以触发 business events。该条目说明的是事件功能，不是 API 字段、业务对象键、用户界面步骤或检验计划的选择算法。

这两条信息可以帮助读者识别目标版本文档中出现的检验计划应用和有限功能变化。它们不能独自回答：inspection plan 的完整结构是什么、哪些 inspection characteristics 必须维护、sample size 如何计算、多个计划如何选中，或具体材料/工厂怎样匹配计划。

## 2. 固定版证据摘要

| 来源 | 直接支持的内容 | 不能据此推出 |
| --- | --- | --- |
| S/4HANA 2021 FPS01《What's New》，§4.3.1 Manage Inspection Plans | 工作清单新增按材料筛选检验计划的功能；列出该条目适用的 scope item 与 application component。 | 所有客户都启用了应用或 scope；筛选后如何自动选择计划；按工厂、用途、有效日期、批量等条件的完整优先规则。 |
| S/4HANA 2021.000《Business Events for Inspection Plans》 | Manage Inspection Plans 应用与 Inspection Plan OData API 在创建、更新、删除计划时可触发业务事件。 | OData entity、字段/键、API released 状态、授权、事件订阅配置或检查计划运行行为。 |

两个来源版本粒度不同：第一项仅明确为 2021 FPS01；第二项为固定版 2021 (Oct 2021)。本文不将其中一项扩展成另一个发行级别的通用规则。

## 3. 按来源做一个只读练习

读者可以把问题逐个放入“有直接来源”或“待查”两栏：

| 问题 | 本文结论 |
| --- | --- |
| 2021 FPS01 的 Manage Inspection Plans 工作清单是否新增按材料筛选？ | 来源明确支持“可以按材料筛选”。 |
| 页面按材料筛选是否表示系统自动为检验批选择某个计划？ | 本来源没有说明自动选择规则；标为待查。 |
| 如何根据工厂、用途、计划版本、有效期或 lot size 选计划？ | 本轮固定版来源没有给出规则；标为待查。 |
| 检验特性的主数据字段、抽样参数和计算公式是什么？ | 本轮固定版来源没有给出这些细节；标为待查。 |
| 创建、更新、删除计划时能否触发业务事件？ | 2021.000 条目明确记录了该业务事件变化；它不等于完整 API 合同或客户系统已配置。 |

这是文献阅读练习，不是系统操作步骤，也不要求在真实系统创建或修改检验计划。

## 4. 核心内容待补

下面这些准入目标目前没有固定版直接资料闭合，本篇不写成 SAP S/4HANA 2021 通用事实：

- 检验计划的完整业务结构、检验工序（inspection operation）与 inspection characteristic 的关系。
- 定量/定性特性、master inspection characteristic、inspection method 和其他特性字段的完整定义。
- 计划的 material/plant assignment、task list usage、status、valid-from/key date、change number、revision level、lot-size 范围的选择条件及优先级。
- sampling procedure、sampling scheme、dynamic modification rule 的配置、相容性和 sample calculation 参数。
- 没有计划、无适用特性、多计划同时符合或规格来源缺失时的实际系统行为。
- 相关应用在特定客户系统的启用、显示/修改权限和真实 API 发布状态。

M3 的 [物流与业务证据台账](../../../plans/evidence-logistics-m3.md)记录了 2021 FSD_OP2021_latest.pdf 的 QM 规划概述，但该 URL 为动态 latest；所读文档修订为 11.0 / 2026-07-22、标注 S/4HANA 2021 SPS10，原 PDF 未归档。本篇不把该摘录冒充固定版 2021 证据；后续若要用于特定 SPS10 内容，须明确登记并保存可复核快照。

## 5. 依赖边界

- [QM-02《检验类型与检验批》](inspection-type-lot.md)使用固定版 2021 来源描述采购收货建批和检验规格分配的有限条件；它没有证明一般检验计划选择、sampling procedure 或特性字段。
- 本篇不依赖 QM-02 drafting 中的任何未闭合触发规则，也不将 M3 的动态 FSD 摘录作为固定版证据。

## 6. 来源

1. SAP, [What's New in SAP S/4HANA 2021 FPS01](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf), §4.3.1 “Manage Inspection Plans”, PDF printed page 121; supports the material filter change and the listed scope items/component/validity.
2. SAP Help, [Business Events for Inspection Plans](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/07da1a573afa433d91b66a6bccf0e4dc.html?version=2021.000), version 2021 (Oct 2021); supports only the create/update/delete business-event statement.
3. CareerOS [M3逐篇准入分流](../../../plans/m3-item-readiness-triage-v0.3.md)、[QM-03控制矩阵](../../../plans/m3-item-control-matrix-v0.3.md)、[证据台账](../../../plans/evidence-logistics-m3.md)和 [MM/QM来源复核记录](../../../plans/review-evidence-mm-qm-m3.md)用于记录原计划来源与待核边界，不替代 SAP 产品资料。
