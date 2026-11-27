# CareerOS V0.3｜物流与业务 46 项公开来源核验（M3 进行中）

核验日期 2026-11-25（UTC）。基于 PR #20 当前规划；本台账仅是逐篇资料准备与缺口清单，不是文章正文、三角色审核或 SAP 实机验证。每条列出至少一个**与主题部分直接相关**的可读原文；其中个别只涉及邻近子主题或特定产品场景，已明确标示为“直接证据未解决”，不能作为该文章已满足 M3 条件的依据。

## 实际读取的官方文献

- **F（动态，当前读取正文可用）**：[SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，2026-11-25 打开为文档 **11.0，2026-07-22，2021 SPS10**，PDF 共 718 页；同日独立读取的 PDF 长度 3,056,745 字节、SHA-256 `ad3c9913ee1f0cbe81e4ede4cb15192c4fcda6497dcf9ac0654dde04b541aaec`。该 PDF 未归档，latest 以后可变；引用仅适用当次现版已读部分，**不证明 SPS08 或任何其他补丁**。同 URL 的旧索引曾为 9.0/SPS08，本文完全不把它作为当前版正文。页码是 PDF 的 1 起始页码，链接使用 `#page=`。
- **S（静态文件，已读正文）**：[SAP S/4HANA 2021 Simplification List](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)，文档 **1.25，2022-05-25，Initial Shipment、FPS01、FPS02**，只证明原文明确范围，不对 SPS10/其他版本泛化。页码同上。
- 其他 Help 页面搜索结果若点击后无可读正文，仅记为线索，不计已读。即使某行有 PDF 直接支持，也只表示对应**一小项主张**；所有事务码权限、配置路径、会计分录、跨版本/系统行为等仍需独立核实。

| ID | 来源、产品/修订及具体页 | 本次实际读取并可支持的范围 | 未覆盖与门禁 |
| --- | --- | --- | --- |
| MM-01 | [SAP 采购组织结构，S/4HANA 2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2b7eb65334e6b54ce10000000a174cb4.html?version=2021.000)；M3 阶段协调者和独立开发者曾读取；Work 于 2026-11-26 重新打开并确认选择器显示 `2021 (Oct 2021)` | 支持 Client、Company Code、Plant、Purchasing Organization、Purchasing Group 概念；Plant 必须归属公司代码且可分配给一个或多个采购组织；采购组织可分配或不分配公司代码，不分配时可为同一 Client 内公司代码采购但所涉 Plant 须分配给该采购组织；一个采购组可代表多个采购组织；页面还描述集中/分散方式、参考采购组织与本地组织关系，以及一个特定跨公司调拨并含 SD 交货/开票的场景。逐项适用边界见 [MM-01 正文](../knowledge/MM/01-foundations/organization-objects.md#s4hana-2021-页面明确支持的组织分配规则) | 本次新增规则为 Work 在固定版页面直接核对后的概述，顾问复核者无法在其工具中独立重开该版本；不得将它写成客户配置、法律责任、自动条件共享、跨公司通用流程或实际系统测试结论。来源不覆盖全部 IMG 配置、单据字段、权限和运行结果 |
| MM-02 | [SAP Help：Material Master Data，S/4HANA On-Premise 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/3d7eb65334e6b54ce10000000a174cb4.html?version=2021.000)；[Maintaining Purchasing Data in Mat. Master Record，2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/407eb65334e6b54ce10000000a174cb4.html?version=2021.000)；[Simplification List 2021 §3.18](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=131)；[Field Status Control，Valid as of 2021](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/06c953e341b146a594a0d38aa87670e8.html?locale=en-US&version=2021.000)；[Decentralized EWM integration guide 2021.001](https://help.sap.com/doc/cae0ee080f144ca08e969756db05ae90/2021.001/en-US/HTG_Integration__Decentralized_EWM_based_on_SAP_S4HANA.pdf) | 固定版《Material Master Data》按七类组织物料信息：Accounting、Materials planning and control、Purchasing、Engineering、Storage、Forecasting、Sales and distribution，并给出各类例子；分层段另举 Client、Plant、Storage Location。固定版采购维护页以 ROH/FERT 为材料类型示例，并说明其对会计、库存管理特征与编号分配的影响。页面还支持采购视图维护例、BP 统一入口/多角色/通用与角色专属数据及 CVI 转换语境。Work 于 2026-11-26 直接读取两篇 2021.000 SAP Help 页面（选择器显示 2021 Oct）及 2021 PDF/角色示例。三角色审查已完成，见[审核记录](../reviews/work/2026-11-26-m4-mm02-three-role-review.md)。 | 信息类别表不得将设计信息另列为类别或补入该来源未列举的重量；物料层级概览列有 Purchasing Organization，但同页详述段未逐字段解释全部组织粒度。迁移资料不等于供应商日常全流程；EWM 角色代码例子不是完整 BP role map。FLVN 字段映射、CVI 配置和编号规则、客户权限、实际数据与系统行为仍未验证 |
| MM-03 | [SAP S/4HANA 2021 On-Premise Feature Scope Description，动态 latest 链接](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，§2.12.3.2 Source Assignment（正文页 152–154）；§2.12.4.2 Requirements Processing（正文页 157–158） | Work 于 2026-11-26 读取 SAP 官方 latest PDF，封面显示 Document Version 11.0（2026-07-22），Document History 显示该修订对应 S/4HANA 2021 SPS10。支持信息记录关联特定材料/供应商、价格/条件及其 MRP 纳入考虑标记；货源清单界定 MRP 可用来源并可按材料/工厂参与自动分配指定来源对象；配额安排将某材料/工厂需求分给多个来源；无来源或多个潜在来源时可使用 RFQ；PR 可从建议来源分配或手工指定供应商。实际文章与复核：[MM-03 正文](../knowledge/MM/02-functions/info-record-sourcing.md)。 | 该文件使用动态 latest URL，链接本身不固定文档快照；记录访问日期、显示版本与来源内容，但没有计算文件哈希。即使产品版本是 S/4HANA 2021，当前支持范围也不是 2021.000 初始版文档。FSD 仅支持高层功能，不支持完整选择优先级、有效日期边界、各货源控制指示、quota rating/base/max quantity 或 MRP/PR/PO 全组合算法。详细算法保持待核，不引入其他版本/产品线规则 |
| MM-04 | [F：2021 SPS10；11.0，PDF 正文第 157–160 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=157)；§2.12.3.2 Source Assignment、§2.12.4.2 Requirements Processing、§2.12.4.3 Purchase Order Processing；[SAP Help：Manage Workflows for Purchase Requisitions，固定版 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/4c20737d1b69420a9b6c7b4c481be6f5.html?version=2021.000)；[SAP Help：My Purchase Requisitions，固定版 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b8272f1725d74e5aaa527558422a0361.html?locale=en-US&version=2021.000)；实际文章：[MM-04](../knowledge/MM/02-functions/requisition-po.md) | FSD §2.12.3.2 Source Assignment 支持在无有效来源时使用 RFQ 寻找来源；§2.12.4.2 Requirements Processing 列出在无来源或存在多个潜在来源时创建 RFQ 寻找合适供应商。两处均为高层能力，不提供选择算法。FSD 也支持采购信息记录、货源清单及配额安排等高层来源分配能力。Requirements Processing 支持 PR 人工/MRP 需求驱动形成、来源与账户分配、release strategy/flexible workflow、多个 PR 汇总、已分配来源时规划后台 PO；PO Processing 支持 PO 基于 PR/其他参考或从头创建及 PO 工作流高层能力。固定版 2021.000 “Manage Workflows for Purchase Requisitions”页面仅补充有限 PR workflow 应用能力（限额项目、退回修改/期限等），不是客户完整配置证据。“My Purchase Requisitions”页面在范围项 18J/1XI/O8J 中说明，limit item 用于下单时无法详细说明的计划外服务/材料，可设预期值与总额上限；这是特定应用范围证据，不概括所有 PR 创建路径。Work 于 2026-11-26 读取 FSD 动态 latest，显示 11.0/SPS10；台账前言所记 SHA-256 对应 2026-11-25 的读取，未归档/哈希 11-26 的文件。 | PR→PO 合并资格、作业触发条件、手工指定供应商是否满足后台作业所称 source assigned、release/workflow 具体矩阵、数据关系/字段复制、限额项跨所有创建渠道的可用性、实际事务/授权和客户系统结果未由这些高层/有限来源闭合。动态 FSD 快照与固定 2021.000 Help 页面分别记录，不混为同一修订。 |
| MM-05 | [F：2021 SPS10；11.0，§2.13.1.2 Inventory Analytics and Control（PDF 正文页 170、阅读器第 171 页），§2.13.1.1 Goods Movement（PDF 正文页 168–169）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=171)；[Transfer Stock – In Plant，SAP Help 2021.000，范围项 BMC](https://help.sap.com/docs/PRODUCT_ID/e296651f454c4284ade361292c633d69/389f644cf32542719153e2743e258143.html?locale=en-US&state=PRODUCTION&version=2021.000)；[Consignment，SAP Help 2021.000，巴西本地化、范围项 2LG/2NY](https://help.sap.com/docs/PRODUCT_ID/e296651f454c4284ade361292c633d69/a63343ce18ea497e8b2c625c1a84f2f4.html?locale=en-US&state=PRODUCTION&version=2021.000)；[Stocks in the Material Master Record](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/91b21005dded4984bcccf4a69ae1300c/fc62bd534f22b44ce10000000a174cb4.html)；[The Movement Type Concept](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/91b21005dded4984bcccf4a69ae1300c/1663bd534f22b44ce10000000a174cb4.html)；实际文章：[MM-05](../knowledge/MM/02-functions/stock-movement.md) | FSD §2.13.1.2 库存报告列出供应商寄售库存，并另列“提供给分包商、存放在供应商处但仍归企业所有”的库存；仅据第二项作有限推论：该分包场景中，存放地点不代表供应商拥有库存。第一项未说明供应商寄售库存的地点或权属；K 的具体权属和转移时点仍不由此定义。FSD §2.13.1.1 支持库存变化单据、收货增量、发出减量及预留概述。固定版 Transfer Stock – In Plant 只在应用内厂内序列化库存转移说明中列出非限制使用/质量检验/冻结库存；固定版 Consignment 条目仅在巴西本地化 2LG/2NY 范围支持 K 示例。两个一般 Help 概念页未捕获版本选择器，库存释义只作一般参考。Work 于 2026-11-26 阅读动态 FSD 11.0/SPS10，未留存当日独立文件哈希。 | 固定 2021 直接资料仍未闭合完整库存类型/特殊库存清单、各移动类型代码与业务对应、冲销代码、负库存前提、移动/库存类别与估价或 FI/CO 科目的完整影响、具体配置及客户行为；供应商寄售 K 的具体权属、所有权转移时点与估价仍未由引用页面闭合。未将未固定版概念页当作 S/4HANA 2021 逐规则证据。 |
| MM-06 | [F：2021 SPS10；11.0，§2.13.1.1 Goods Movement，PDF 正文页 168–169](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=168)；[同一 FSD：§2.12.4.4 Purchase Order Collaboration，PDF 正文页 161](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=161)；实际文章：[MM-06](../knowledge/MM/02-functions/gr-returns-reversal.md) | Work 于 2026-11-26 直接打开官方动态 FSD，封面为 11.0（2026-07-22，S/4HANA 2021 SPS10）；未留存该日文件哈希，台账既有 SHA-256 只对应 2026-11-25 快照。§2.13.1.1 支持货物移动以材料凭证记录、收货增加仓库库存，以及因质量/损坏等原因在 GR 已过账后退回供应商；若供应商发送替代品，Return Delivery 可引用原 GR。§2.12.4.4 说明在业务网络/外部系统已集成且支持该能力时，可向供应商传递部分或全部交货已收的信息；此项是供应商协作通知能力。 | FSD 未展开纠错与退货的完整单据差异、冲销前后库存条件、部分项目/数量过账、移动代码、技术单据对象/字段/引用关系、已开票处理顺序、估价或 FI 借贷。PO Collaboration 的已收数量通知不证明 GR 过账、PO 项开放数量、容差或最终交货逻辑。具体流程须由适用于目标版的直接资料逐项支持；未锁版或其他 SAP 产品页面不得代替 2021 操作证据。 |

| MM-07 | [SAP Units of Measure in Purchase Orders，2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/af7eb65334e6b54ce10000000a174cb4.html?version=2021.000)；协调者及独立开发者均读取 `2021 (Oct 2021)` | 可作为普通采购订单中的订单单位、订单价格单位、换算以及采购信息记录可供默认值的直接来源；只支持文档明确的使用场景 | 未证明 BAPI 特定字段覆盖根因、所有配置优先级、后续 FPS 差异或当前系统行为；该来源有限描述经独立复核 |
| MM-08 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 151 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=151)；Material/Article Master 的 MRP 字段变更 | 对 MM01/MM02/MM03 特定屏幕字段改变有说明 | 不证明这些事务全面可用、显示/写入权限或其他采购 T-Code |
| MM-09 | [SAP Help 固定 2021 GR/IR 页面](mm09-2021-grir-direct-m3.md)、[2021 Account Determination 因素页面](mm09-obyc-source-followup-m3.md)、Simplification List 补查；另有三篇 SAP Learning 通用科目确定/收货/关账页面由独立顾问复读，未锁定 2021。 | 2021 Account Determination 仅支持发票侧因素类别，不列 OBYC/BSX/WRX 收货映射；GR/IR 关联页“credit stock account”无借贷表。Learning 的发票方向分歧仅在 Describing Automatic Account Determination（贷 GR/IR）与 Managing Closing Activities（借 GR/IR、贷供应商）之间；Managing Goods Movements 只支持限定收货方向。 | 版本未固定 2021，不能裁决目标版；估价/移动类型及权限仍缺。下一步：继续寻找固定目标版普通估价库存收货的自动科目确定规则与配置依据。判定：未闭合。 |
| MM-10 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 478 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=478)；MM-IM 数据模型简化 | 比较 ERP 与 S/4HANA 库存管理数据模型 | PR/PO 完整模型、精确键、基数和发布 API |
| SD-01 | [SAP 2021 Sales Organization](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f7fddfe4caca43dd967ac4c9ce6a70e4/a614c453f57eb44ce10000000a174cb4.html?version=2021.000)；详见[补查](evidence-gap-four-m3.md) | 独立顾问实读 2021 初版销售组织、销售区域三项以及公司代码/工厂的有限分配关系。 | 不证明所有客户自定义、实际配置及全部跨公司开票场景。 |
| SD-02 | [2021 BP 与伙伴职能补查](sd02-partner-2021-evidence-m3.md)：2021 Oct 销售伙伴、BP角色及数据层级四页；其中前两页独立复核。 | 有条件地支持 partner function、FLCU00/FLCU01、客户账户组及所述组织层级；注意原文 FLVN00 案例内部冲突，不视为 SAP 勘误。 | BP grouping/编号、全部伙伴确定配置、权限、字段/API 和系统实测仍待证。 |
| SD-03 | [F：2021 SPS10；11.0，PDF 第 122 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=122)；§2.10.2.6 Sales Order Management and Processing | 销售单据类型及确认数量日期的功能 | 具体部分交货、取消与权限 |
| SD-04 | [F：2021 SPS10；11.0，PDF 第 126 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=126)；§2.10.2.8 Sales Billing | 开票单据可传递 FI | 并非所有开票的收入确认、税和收款逻辑 |
| SD-05 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 951 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=951)；DIMP 场景快速录入兼容变更 | 特定 DIMP 快速录入的变更段提到 VA03 | 不能据此推断所有系统 VA03 的授权及完整作用 |
| SD-06 | [F：2021 SPS10；11.0，PDF 第 118 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=118)；§2.10.2.2 Price Management | 价格管理包含定价流程配置 | 准确 IMG 节点、业务分支和访问权限 |
| SD-07 | [S：2021 初版/FPS01/FPS02；1.25，PDF §36.8 第 789–790 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=789)；[§36.9 第 791–793 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=791) | §36.8 支持特定转换场景下状态表整合和追加字段转换；§36.9 补充早期目标版本的 VBFA/STUFE 间接关系历史，不是 2021 通用字段/键/基数规则 | 完整单据流字段、主键、接口、关联基数和客户本地转换历史仍待核；新增资料仅作历史边界提醒，见本文件 SD-07 来源续核附录 |
| PP-01 | [P1：SAP Help 2021.000 官方索引](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b39ff179522b435584613620f5f4cdd5.html?locale=en-US&state=PRODUCTION&version=2021.000)；[P2：What's New 2021 SPS04 固定 PDF §3.1.1 p.13](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.004/en-US/WN_OP2021_SPS04_EN.pdf#page=13)；[F：动态 FSD 11.0/SPS10 p.70](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=70) | P1 官方索引列 BJ5/BJ8/J44；P2 静态 PDF 直接列出 PI Sheet / work instruction HTML5 功能适用的制造 Scope Item 名称；F 仅为动态 SPS10 高层需求/供应计划范围 | Plant 生产组织职责、MTS/MTO 需求/库存边界、离散/流程制造业务差异、成本/权限仍缺固定版直接证据。P1 HTML direct open 0 行，P2 HTML direct open 0 行；P2 静态 PDF 可直接复读。详见 PP-01 来源续核附录 |
| PP-02 | [F：2021 SPS10；11.0，PDF 第 67 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=67)；§2.8.2.1 Production BOM Management | 生产 BOM 是产品组件的结构化清单 | 有效期、替代项选择和具体表/字段 |
| PP-03 | [F：2021 SPS10；11.0，PDF 第 68 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=68)；§2.8.2.2 Master Recipe/Routing Management | 工艺路线/配方作为生产过程主数据的总体作用 | 工作中心完整定义、工序选择和成本/产能参数 |
| PP-04 | [F：2021 SPS10；11.0，PDF 第 70 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=70)；§2.8.3.1 Material Requirements Planning；[Monitor Material Coverage，2021.000/J44](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/0c7dcb460ef1472989aeea008bbf1bbb.html?locale=en-US&state=PRODUCTION&version=2021.000)；[Simplification List 2021 §3.24](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=150) | FSD 动态 URL 直接打开的 PDF 文档历史列出 v11.0/SPS10；SAP 官方搜索索引仍显示旧 v9.0/SPS08，未归档 PDF 哈希。FSD 只支持 MRP 高层覆盖/提议说明；固定 2021.000/J44 只支持特定供需监控应用能力；固定 Simplification List §3.24 仅说明转换/升级范围内 MRP 主数据字段变化。另查的 Net Requirements Calculation、Material Requirements Planning Procedure、Calculating Procurement Quantity、Lot-Sizing Procedures 官方 Help 搜索结果显示 2025 FPS01（2026-02）；同名 2021.000 页面读取尝试不可访问，不用当前页面补写目标版算法。 | 净需求计算、库存/收货纳入、批量程序、参数组合、建议类型选择和客户系统差异仍未闭合。PP-04 保持 Draft；SAP 未连接，未做实机 MRP/API/权限验证。 |
| PP-05 | [F：2021 SPS10；11.0，PDF 第 76 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=76)；§2.8.4.2 Production Execution | 生产执行涉及准备、领料和进度记录 | 各订单状态、下达、报工与回退条件 |
| PP-06 | [F：2021 SPS10；11.0，PDF 第 76 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=76)；§2.8.4.2 Production Execution | 生产执行包括领料与入库等活动 | 库存估价、成本和结算账务 |
| PP-07 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 523 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=523)；生产版本相关 SAP Note 的关键词 | 列出 MD01/MD02/MD03、CS01/CS02 等关键词 | 关键词出现不证明事务权限、运行结果或完整导航；需对应 T-Code 直证 |
| PP-08 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 623 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=623)；MRP 相关生产版本迁移 | 以 BOM/生产版本为对象讨论转换和配置要求 | 不能推出 IMG 实际查看路径、所有工厂和设置规则 |
| PP-09 | [2021 生产模型补查](pp09-data-model-evidence-m3.md)：Simplification List 1.25 的生产版本、BOM/routing 和 MATDOC 简化，其中 material BOM 与 DDL source 两项限定已独立复核。 | 特定简化 sourcing 的 material BOM 与 MTO/MTP 例外；MATDOC 及 MKPF/MSEG 重定向说明，NSDM_DDL_MKPF、NSDM_DDL_MSEG 是所列 DDL source。 | [确认与物料凭证 SDK 实体](pp09-order-material-key-m3.md)的五项 OData 键已由源码及独立复核支持；物理表键、其他关联/基数、实际 `$metadata`、发布授权及系统仍未验证。 |
| QM-01 | [F：2021 SPS10；11.0，PDF 第 93 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=93)；§2.8.5.2 Quality Inspection | 质量检验可出现在采购、生产或销售场景 | 质量组织、用户角色、设置和触发前提 |
| QM-02 | [SAP S/4HANA 2021 收货建检验批直接资料](qm-gr-inspection-2021-m3.md)：固定版本选择器 2021 (Oct 2021)；独立复核覆盖自动建批条件页 | 采购收货建批受移动类型 QM 设置、物料检验类型及相关主数据等条件制约；01/05 为来源示例，不可泛化为所有收货 | 客户配置、供应商/质量信息记录差异、仓库/EWM和财务凭证需另核；收货并非一律进入检验库存 |
| QM-03 | [F：2021 SPS10；11.0，PDF 第 93 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=93)；§2.8.5.1 Quality Planning | 检验规划含对象、方法、特性及规格 | 计划选择规则、抽样参数和具体字段 |
| QM-04 | [F：2021 SPS10；11.0，PDF 第 94 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=94)；§2.8.5.2 Quality Inspection | 记录检验结果并执行使用决策 | UD 与自动/手工库存过账、撤销及业务条件 |
| QM-05 | [F：2021 SPS10；11.0，PDF 第 189 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=189)；仓储 Quality Management 描述 | 特定 EWM 入库处理有检验批与部分使用决策场景 | 该段属于 EWM，不能替代通用 IM 质量库存和财务影响证据 |
| QM-06 | [S：2021 初版/FPS01/FPS02；1.25，§31.2–31.4](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=678)；2026-11-27 直接读取 PDF 正文 | 支持有限的事务移除/替代、Fiori Launchpad 导航变化，以及 QM 授权对象对“编辑检验批/录入结果”等操作类别的描述。详见[QM-06 正文](../knowledge/QM/03-tcodes/transaction-index.md) | 不支持逐事务码到用户角色/权限对象映射、完整 QM 事务清单、客户系统启用或只读角色结论；文章保持 drafting。Work 单上下文角色模拟不是独立审查或 SAP 实测。 |
| QM-07 | [2021 FPS01 What's New §4.3.8](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)；Work 沿用 M3 直接来源读取记录，见[补查](evidence-gap-four-m3.md) | 只支持 QM-IM-RR 中新增结果比较符的 FPS01 特例、兼容语义及来源明列的 Customizing 活动路径。2026-11-27 建立[范围受限正文](../knowledge/QM/04-configuration/quality.md)。 | 不证明初始版同等可用、其他检验设置、检验类型激活、工厂/物料配置或实际权限；Work 单上下文角色模拟不构成独立审查。文章保持 drafting。 |
| QM-08 | [2021 FPS01 What's New §4.3.8](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)；Work 沿用 M3 直接来源记录，见[补查](evidence-gap-four-m3.md) | 限定支持：为检验结果添加比较符后，该新操作符也在 `I_INSPECTIONRESULTATTRIBUTE` CDS view 中可用；来源明确适用于 2021 FPS01。2026-11-27 建立[证据受限草稿](../knowledge/QM/05-data-model/quality.md)。 | 不证明初版可用、视图首次发布版本、底层字段/表键/关联、released API/CDS 合同、系统启用或用户授权；同上下文 Work 角色模拟不构成独立审查。文章保持 drafting。 |
| PROCESS-01 | [2021.000 P2P 直接来源](evidence-p2p-fi07-m3.md)、[P2P 估价](p2p-valuation-direct-2021.md)、[末端付款](p2p-payment-evidence-m3.md)；FI-07 另记 [MAP 无库存覆盖案例](finance-fi07-direct-2021.md)。三篇通用 SAP Learning 由独立顾问复读但未锁定 2021。 | 2021 MAP 页面仍有 “credits” 与正负图示的借贷对应歧义。Learning 课程方向仅在 Describing Automatic Account Determination 与 Managing Closing Activities 的发票描述间冲突；Managing Goods Movements 仅支持限定收货方向，不提供发票方向。 | Learning 不是目标版证据；逐事件借贷、税、配置、异常及实际付款仍缺。下一步：按固定目标版逐事件补证，不拼成通用分录或资金链。判定：未闭合。 |
| PROCESS-02 | [2021 FSD 限定来源复核](o2c-direct-2021-m3.md)：封面显示版本 11.0（2026-07-22）；独立复读覆盖销售订单、出库交货和开票相关页，动态 latest 的 SPS10 标记与哈希未重新核验 | 普通库存销售的订单、交货参照、发货过账减库存及开票过账转入应收有有限功能描述；并非所有订单必经同一路径 | 应收收款/清账复核、目标初版/FPS固定资料、逐科目分录/税、部分交货与异常及目标系统条件仍待核 |
| PROCESS-03 | [F：2021 SPS10；11.0，PDF 第 178 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=178)；§2.13.2.1 Delivery Management | 出库交货业务可包括不同工厂的库存调拨 | 不证明直接转储/PO-STO各分支、在途及公司代码估价 |
| PROCESS-04 | [SAP 跨公司代码调拨，S/4HANA 2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/91b21005dded4984bcccf4a69ae1300c/9993b853dcfcb44ce10000000a174cb4.html?version=2021.000)；协调者及独立开发者均读取 `2021 (Oct 2021)` | 直接列出跨公司一步/两步、无交货 STO、含交货和开票的 STO 等方案，并对文中所述的公司代码间清算及定价作出说明 | 不能推出全部流程必然产生发票或资金结算；具体税、组织、配置、分录及异常须逐项核验；该来源有限描述经独立复核 |
| PROCESS-05 | [F：2021 SPS10；11.0，PDF 第 76 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=76)；§2.8.4.2 Production Execution | 生产执行包括备料、领料及进度记录 | 计划→生产→成本结算的完整流程及价值分录 |
| PROCESS-06 | [SAP S/4HANA 2021 库存过账直接资料](qm-gr-inspection-2021-m3.md)：固定版本选择器 2021 (Oct 2021)；独立复核覆盖库存过账页 | 库存相关检验批在有未过账数量时，可在使用决策前、期间或之后过账；后台自动过账与人工确认取决于设置，自动使用决策不等于自动过账 | 目标系统设置、EWM及移动类型/凭证字段、财务影响、异常和冲销情形仍待逐项核验 |
| PROCESS-07 | [F：2021 SPS10；11.0，PDF 第 39 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=39)；§2.6.2.2 Financial Close 相关章节 | 财务结账功能及报表的总体范围 | 企业实际关账顺序、管理会计和分录 |
| PROCESS-08 | [F：2021 SPS10；11.0，PDF 第 90 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=90)；§2.8.4.7.1 Basic Subcontracting：Subcontracting Cockpit | 特定生产委外协作可管理采购订单、组件及交货 | 所有委外采购变体的货权/库存/会计和付款 |
| PROCESS-09 | [SAP Consignment，S/4HANA 2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/91b21005dded4984bcccf4a69ae1300c/4c13b953495bb44ce10000000a174cb4.html?version=2021.000)；协调者及独立开发者均读取 `2021 (Oct 2021)` | 直接说明该标准寄售业务的库存、提取、估价和周期结算概念 | 具体合同货权、税、公司会计分录及所有变体仍须单独核实；该来源不替代法律或业务合同；该来源有限描述经独立复核 |
| PROCESS-10 | [F：2021 SPS10；11.0，PDF 第 169 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=169)；§2.13.1.1 Goods Movement | 存在供应商退货及货物移动功能 | 退货与收货冲销、后续已开票时的凭证与资金 |
| PROCESS-11 | [F：2021 SPS10；11.0，PDF 第 164 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=164)；§2.12.5.1 Invoice Processing | 发票校验涉及内容、价格及会计 | 差异容差、自动冻结与付款释放各触发条件 |
| PROCESS-12 | [F：2021 SPS10；11.0，PDF 第 129 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=129)；§2.10.2.12 Claims, Returns, and Refund Management | 该特定客户退货流程可经检查并贷项或替代交付 | 退货、退款、抵扣和税务的所有变体及必要前提 |

## 留存与未解决

- 以上 F 的哈希只标识曾读取的字节；没有保存/发布原 PDF，不代表用户能经 latest 重现相同字节。后续应寻 SAP 官方固定版本或在许可范围内保留可复核快照及出处；若重读版本不同，重新定位正文、核验全部相关主张。
- **MM-09、SD-01、QM-07、QM-08** 已补充部分直接来源；其未覆盖的核心场景仍缺；MM-01、MM-07、PROCESS-04、PROCESS-09 的初版直接资料已独立复核有限描述，但各自未覆盖的场景仍缺。本表不以相关但范围不足的概述冒充完整文章依据。其余条目也尚有大量具体场景、字段、配置、权限和账务内容未验证，不能由部分取证推断整篇通过。
- 对 SPS10 之后目标系统补丁是否一致、用户环境权限以及所有实机运行行为没有验证；版本有差异时要另行核对。所有 46 项正文和三角色正式有效审核轮次均为 0。

## 独立开发者复核与修订（2026-11-25）

独立开发者向协调者报告：46 个 ID、FSD 哈希及七项抽查基本正确；发现 PROCESS-03/04 将 §2.13.2.1 标为 “Delivery Processing”，应为 “Delivery Management”。作者重新打开当次 SPS10 原文确认并修正。用量恢复后，原开发者读取 PR #20 `0730c3fc66292c1ae22ff95a0d9b89847b930d70` 并再次复核：PROCESS-03 标题与 PDF 一致；PROCESS-04 已换成 2021 初版跨公司资料，不再引用原错误标题。该标题缺陷的复核关闭。开发者也分别读取 MM-01、MM-07、PROCESS-04、PROCESS-09 四个 2021 初版页面，确认本表有限描述和边界；仍不能推断文章全文、配置或系统测试通过。
剩余门禁：latest 文档未固定版本且未留存原始文件；核心主题取证不足及逐项 FPS、权限、配置、分录、接口和实机行为均继续待查。计划级资料复核不能计入正式文章的有效审核轮次。


## 追加物流与质量来源（研究记录）

[四项专题补查](evidence-gap-four-m3.md) 新增 MM-09 在特定材料账迁移场景的 OBYC 依据，以及 QM-07/QM-08 在 2021 FPS01 的单项配置和 CDS 示例；SD-01 的销售组织和销售区域 API 2021 初版正文已由独立配置顾问直接读取。各来源的适用版本与未覆盖事项以补查记录为准，不代表任何文章证据完整。

[P2P 收货与发票估价补查](p2p-valuation-direct-2021.md) 收录实际读取的 2021 初版部分数量、估价与顺序示例；该范围不等于完整 P2P 或系统实测。


## MM / QM 逐项来源复核

`/root/consultant_m3_review` 对 [MM 与 QM 18 项来源](review-evidence-mm-qm-m3.md)进行复核，指出 QM-05 当前 SPS10 的引用应为 PDF 物理页 189 而非 188。Work 已修正上述台账链接与页码；原审查者已复读提交 `b46182890f73990f019b2db391ed0c0022ca9ae4` 与 SAP 第 189 页，页码问题限此关闭。FSD latest 未固定版本，MM-01/MM-07 本轮审查者未能独立重开动态正文，不可冒称本轮独立读取。以上为资料计划复核，不代表文章通过或 SAP 实测。


## SD / PP 与流程章节定位复核

`/root/consultant_plan` 逐项核查 SD/PP 来源，指出 SD-06 对应 SPS10 PDF 的配置功能位于第118页而不是117页，并提示 SD-07 只涉及特定转换字段；`/root/developer_m3_review` 指出 PROCESS-08 的委外小节应为 §2.8.4.7.1。Work 已修正这三处；`/root/consultant_plan` 已在 `d6049bc` 复核 SD-06/SD-07，`/root/developer_m3_review` 已在该提交复核 PROCESS-08，限上述定位与限定问题关闭。详见 [SD/PP 来源贴合度](sd-pp-source-fit-m3.md) 和 [流程来源贴合度](process-source-fit-m3.md)。上述文献是局部支持，不能代替完整流程、权限或目标系统实测。


## M4 固定版来源重新核对（2026-11-26）

针对 MM-01 的组织分配矩阵，Work 重新打开上列 SAP Help 页面并使用版本选择器确认 `2021 (Oct 2021)`。正文与台账所列规则按页面有限描述整理。独立读者/开发者复核了文章可读性与规则边界；独立配置顾问也复核了表述是否过度外推，但该复核工具无法重新打开固定版页面，因此不把该条写成第二次独立原文读取。官方页面链接可直接回查；更广的配置变体、客户权限、实际运行、法律责任和凭证结果仍未验证。

### MM-06 补充：采购订单协作范围

Work 于 2026-11-26 从 SAP 官方 S/4HANA 2021 动态 FSD 直接定位 §2.12.4.4 Purchase Order Collaboration（文档版本 11.0，2021 SPS10，PDF 正文页 161）。该节说明，业务网络或外部系统集成且支持相应功能时，可以向供应商发送已收货物信息，并说明部分或全部交付已收。此证据仅支持条件化的供应商协作通知能力，不说明 GR 具体过账、PO 项目开放数量、容差、最终交货状态或库存/会计更新规则。动态 latest URL 未保存本次独立文件哈希；既有 SHA-256 仍只对应 2026-11-25 快照。


## 2026-11-27 来源续核附录｜SD-03（未关闭 M3 缺口）

- SAP 官方 SAP Help 搜索结果出现固定版 `What's New in SAP S/4HANA 2021` 条目 **Change Outbound Delivery - Special Exceptions 3rd Party Warehouse**，选择器为 `2021 (Oct 2021)`、Scope Item `4RQ (Decentralized EWM - Ad Hoc Goods Issue)`、Valid As Of SAP S/4HANA 2021。搜索摘录将其限定为连接第三方物流服务商或分布式仓库的特殊例外：须先用专用 Reverse Goods Movement app 取消 goods issue，再使用专用 app 更改交货；摘录提示变更不会自动同步到外部连接系统，可能造成 S/4HANA 与外部库存数据不一致。
- **访问限制**：官方固定版链接 `https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/19b977e649f14e32830563367b2429ab.html?version=2021.000` 在本轮直接打开返回零行；上述内容只从 SAP 官方搜索索引摘录观察到，未能直接复读全文。本条仅登记为目标版窄场景候选，不作为普通 sell-from-stock 的 PGI reversal 规则、客户权限证明或已核实操作指引，不提升准入/审查状态。
- 同轮搜索还找到 `Fixing Quantities and Dates in Sales Documents` 的 2025.001 页面与 `Goods Issue Reversal` 的 2025 FPS02 页面；它们不是固定 S/4HANA 2021 证据，未用于 SD-03 的结论。
- M3 对 SD-03 的开放项仍包括一般部分交货、销售/交货取消或拒绝、普通 PGI 冲销规则及客户权限。除非取得可直接读取的适用版来源，否则文章维持 Draft；该搜索附录不改变原 M3 限缩准入。


## 2026-11-27 FSD 精确定位补充｜SD-03 出库交货来源

再次直接定位 SAP 官方 `FSD_OP2021_latest.pdf` §2.13.2.1 *Delivery Management*（本轮已识别文档 Version 11.0，2026-07-22，S/4HANA 2021 SPS10）：PDF 正文对 Outbound Deliveries 列出 sell-from-stock、returns 和 stock transfer 场景；同节 Key Features 又明确出库交货可以“with reference to a sales order”、“with reference to a stock transport order”或“without any reference”（SAP Help PDF 提取行 4337–4340、4375；打印页约 177–179）。因此，SD-03 正文中把 sell-from-stock 作为受限示意、同时明确交货可从其他场景产生并非所有 delivery 都源自销售订单的来源归因，能由该动态 SPS10 文件对应章节支持；无需为此更改文章。

此补充只解决上述有限来源定位，不将动态 FSD 升格为不可变的 S/4HANA 2021 初始版依据；正文仍需保留 SPS10 边界。一般部分交货、订单/交货取消或拒绝、普通 PGI 冲销及客户权限仍未闭合。此前登记的固定 2021 4RQ 特殊 3PL 索引候选仍不可用于这些一般规则。


## 2026-11-27 目标版来源续核｜SD-04 定价、开票与应收

- 重新审读批次 A 当前 SD-04 正文 blob `7d349641c104cffa49f375ec2b5107a5a9f5dda6`、M3 准入（“部分 / 限缩可写”）、逐篇范围与现有 15 项审查记录。正文已有 FSD 高层开票/应收边界，明确将定价条件、税、收入确认/FI 分录、客户系统实际 AR 关联、收款差异、银行资金及权限留空。
- SAP 官方搜索返回固定 `2021.000` 页面标题 **CDS Views for Preliminary Billing Documents, Billing Document Requests, and Billing Due List Items**。本轮直接打开该帮助页得到零条可读正文，因此只确认有该题名的固定版资料入口，不用搜索摘录推断 CDS 字段、发布状态、文档关系或定价/AR 行为。
- “Pricing in Sales Documents”搜索结果来自未标定版本的通用 SAP Help 页；页面未能直接打开，也不能证明其适用于 S/4HANA 2021 On-Premise，未作为目标版依据。此次搜索命中的税务、Billing Processing、Condition Technique 等内容标记为 2025 FPS01 或其他较新版本，明确排除。
- 对 `FSD_OP2021_latest.pdf` 的搜索索引出现较早的 Version 9.0 / 2025 摘录，与 M3 已直接打开并记录的 Version 11.0（2026-07-22，S/4HANA 2021 SPS10）不是同一动态响应。本轮继续以此前直接读取的版本记录为本篇现有高层证据，不将较旧搜索摘录混入，也不宣称固定初版。
- **结论与下一步**：没有获得可直接复读的 2021 固定版资料，足以支撑通用条件定价、币种/税、收入确认与具体 FI 借贷、付款/银行资金关系。后续应逐项寻找 SAP 官方 2021.000/明确 FPS 的直接正文或可复核归档，逐项限定业务条件；在此之前 SD-04 保持 Draft。SD-03、FI-06 虽在分支存在但均 Draft；M3 依赖 PROCESS-02 当前不在批次 A 分支，不能用其替代证据。未连接 SAP、未执行系统/API/配置/权限测试。


## 2026-11-27 逐篇来源复核｜SD-05 常用事务码导航

- 批次 A 当前正文 blob 5604d5f31b6b2b78e40cd5304b87eb172e8fb6db、M3 “未核验／暂缓核心”行、逐篇范围和三角色审查记录已重新逐项读取。正文正确地把目标版缺口明列为通用订单/交货/开票入口、用途及读写边界、逐入口输入/输出、GUI/Fiori 与 App ID 映射、授权。
- SAP 官方固定版本 2021.000 的 [GTS 销售单据合规检查](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/fcb3125da2904febade3759c5c4dfbb7.html?version=2021.000)搜索摘录明确写出：完成集成并激活 GTS 后，VA01/VA02/VA03 等 app 可查看状态，且限于该功能与其 Scope Items。直接 open 返回零行；本轮把官方索引中可见的原文片段仅用于核对这些逐项名词，不扩大成通用标准导航、输入/输出或权限证据。
- SAP 官方固定版本 2021.000 的 [Brazil Tab in Billing Transactions](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/86a74f326eab4891a61977005007753d.html?version=2021.000)搜索摘录逐列 VF01、VF02、VF03、VF03_ITEM、VF07，并说明该国别页签在输入巴西公司代码时可见，Scope Item BD9。直接 open 也返回零行；只使用可见摘录中的名称及条件，不推断完整通用国家目录、权限或税务行为。
- SAP 官方静态 [Simplification List for SAP S/4HANA 2021 v1.25](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=951)本轮可直接打开，封面范围为 Initial Shipment、FPS01、FPS02。§49.8（印刷页 951）仅支持旧版本转换到 S/4HANA 1610 或更高版时，特征值 Fast data entry 与 Configuration 页签合并、VA01/VA02/VA03 等为示例及 DIMP_SDUD/实际使用条件；不支持通用代码用途、屏幕输入输出或授权。正文当前边界与该原文相符。
- 搜索所得无版本 EWM/ERP 事务列表及 S/4HANA Cloud 2608 导航页不作为固定 S/4HANA 2021 On-Premise 证据；这些页面即使出现 VL03N 等入口，也不能补本篇目标版通用交货入口。
- **准入决定**：固定版证据只闭合三个局部情境中的入口名；M3 核心仍要求通用销售、交货、开票导航，以及用途/输入输出/类别/权限逐入口核验。SD-05 继续 Draft，不将局部证据升格为目录完整。后续需找到可直接复读的 2021 On-Premise Help/本地文档，并对照用户获准的目标系统核验应用类别/权限；在取得证据前不列通用交货代码。
- 未连接 SAP；未执行事务码、系统配置、API、权限或实机测试。


## 2026-11-27 逐篇来源复核｜SD-06 销售配置查看

- 当前批次 A 正文 blob 48293fd49ac07ad4ee42ad3ed9b4f48e59a3b1a8、M3 逐篇准入、详细范围、SD/PP 来源贴合度与原角色视角记录已重新核对。M3 准入表允许“限缩可写”，要求补查准确 IMG 节点、业务分支和访问权限；详细范围还要求定价/单据类型/交货/开票/科目决定、组织/主数据前提与授权只读查看路径。M3 控制矩阵没有 SD-01 至 SD-07 的独立行，不能用它补充 SD-06 的具体准入内容；本篇按 triage/detail-logistics 原行继续处理，未改写已验收的 M3 资料。
- SAP Help 官方固定版 [Condition Purposes in Business Documents](https://help.sap.com/docs/PRODUCT_ID/e296651f454c4284ade361292c633d69/8575c2f80df64d53b32340dfaab856b8.html?version=2021.000) 搜索摘录标明 What's New 2021 (Oct)、Available As Of 2021，并显示 Condition Purpose 可分配给 condition type 或 pricing procedure + condition type，路径为 Sales and Distribution > Basic Functions > Pricing > Condition Purposes in Pricing。直接 open 不可读；只按 SAP 官方索引可见文本核对该有限例子，不从它推出通用定价规则、配置授权或客户实际路径。
- SAP Help 官方固定版 [Approval Workflows for Debit Memo Requests](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/975ea2cdf26140c7a012209a7eab443e.html?version=2021.000)搜索摘录标为 What's New 2021 (Oct)、Scope Item 1F1。仅在该工作流场景中，相关借项凭证申请类型不得设置 billing block；若设置须按来源所列路径处理。页面直接 open 不可读；不推广成其他单据/场景规则或生产修改指引。
- SAP 官方静态 [What's New in SAP S/4HANA 2021 FPS01](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf#page=96)本轮直接打开并核对 §3.5.2.1：PSFX 固定价格只用于订阅订单的一次性价格处理（S/4HANA 2021 FPS01）；PDF p.96–97 列出该专项条件类型与定价程序活动。正文对此限定准确，不推广到初始版或普通销售订单。
- 对动态 FSD_OP2021_latest.pdf 本轮再次直接打开，Document Version 11.0（2026-07-22），文件记录 SPS10。先前 SD-06 角色记录曾记录同一 latest URL 的旧读取为 Version 9.0（2025-07-23，SPS08）；这反映动态响应随时间更新，不作为固定版主张证据。正文已排除此来源。
- **门禁结论**：固定证据只支持以上三个示例。通用销售配置树、其对应行为/业务分支、交货/开票与科目决定、只读访问路径/授权仍未闭合；SD-06 继续 Draft。下一步是逐项获取固定版 2021 的直接配置活动及适用前提，并取得已授权的目标系统只读访问说明；不得补写未证节点或做生产修改。未连接 SAP，未进行 IMG、事务码、权限或业务单据测试。


## SD-07 2026-11-27 固定版来源续核

- 官方 SAP《Simplification List for SAP S/4HANA 2021》Document Version 1.25（2022-05-25）封面明确覆盖 Initial Shipment、FPS 1、FPS 2。本轮直接打开该静态 PDF 并复读 §36.8–36.9：§36.8 印刷页 789–790 说明 VBUK/VBUP 状态字段迁入列明的单据表、VBFA 简化、VBTYP/VBTYPL 变化及特定追加字段转换前提；不构成完整 DDIC/API 数据字典。
- §36.9（印刷页 791–793）分开列出特定历史条件：转换目标为 1511 SP00–SP03 或 1610 SP00–SP01；或新安装系统的起始/曾经版本为 1511 SP00–SP03 或 1610 SP00–SP01。它记录早期版本中 STUFE/间接关系的变化及 1709 SP00、1610 SP02、1511 SP04 起恢复存储的历史。明确列出的重建场景为：转换至 1610 SP00/SP01 或 1511 SP00–SP03；新安装于 1610 SP00/SP01/SP02 或 1511 SP00–SP04。该段提醒检查直接读取 VBFA 的客户代码，但不是 S/4HANA 2021 通用行为/键合同，也不表示一般 2021 系统缺少间接关系或需要重建；客户系统具体转换历史仍未核。正文据此更正了条件和重建范围。
- 固定版 SAP Help “OData API: Sales Order - Simulate (A2X)” 官方检索索引摘录显示 2021-10、Available As Of SAP S/4HANA 2021、Scope Item BD9，以及 API_SALES_ORDER_SIMULATION_SRV 的头/项目级扩展属性；本轮页面 direct open 返回 0 行，未直接复读正文。本项只作为官方索引可见的窄范围模拟 API 线索，不称完整发布接口目录/字段合同、目标系统可用性或授权证明。
- 官方动态 FSD PDF direct open 显示 Version 11.0（2026-07-22），封面为 SAP S/4HANA 2021；本来源只支持正文标明的 SPS10 高层开票范围，不能代表固定 2021.000 初始版。
- **门禁结论**：M3 “限缩可写”仍要求单据流字段、主键、接口及关联基数。§36.9 是历史分支，不闭合这些目标；SD-03/04、FI-11 仍为 Draft。SD-07 继续 Draft，未执行 SE16、数据库、ABAP、API 或权限测试。

## PP-01 2026-11-27 来源续核

- **P1｜SAP S/4HANA 2021.000 Help 索引**：“CDS Views for Production Planning”，页面 URL 锁定 2021.000。SAP 官方搜索索引标明 What's New in SAP S/4HANA 2021（Oct 2021）、并将 BJ5（Make-to-Stock Production - Discrete Manufacturing）、BJ8（Make-to-Stock - Process Manufacturing Based on Production Order）和 J44（Material Requirements Planning）列为相关 Scope Items。本轮固定版 HTML direct open 返回 0 行；只可确认官方索引可见文本，不能声称直接复读页面完整正文。该项只支持产品范围标签与页面报告的 CDS 视图变更，不定义工厂组织、MTS/MTO 业务规则或制造差异。
- **P2｜SAP S/4HANA 2021 SPS04 固定版静态 PDF**：《What's New in SAP S/4HANA 2021 SPS04》，Document Version 1.0（2023-05-17），§3.1.1“HTML5 Support for Browser-Based Process Management Applications”，印刷页 13。直接打开并复读静态 PDF 后确认，该功能范围列出：Make-to-Stock Production - Discrete Manufacturing、Make-to-Stock - Process Manufacturing Based on Process Order、Make-to-Stock - Process Manufacturing Based on Production Order、Make-to-Order Production - Process Manufacturing、Make-to-Stock with Co- and By-Products - Process Manufacturing。它们是该 PI Sheet / work instruction HTML5 浏览器功能范围标签，不是完整生产模式目录、业务定义或普遍流程证明。相应 SAP Help HTML 页面 2021.004 direct open 返回 0 行；不以 HTML 页面直接正文作为证据。
- 另查 SAP 官方 Plant、Corporate Structure、MRP Area 与 Make-to-Order Production 资料。可见 Plant/Corporate Structure 页面为 2025 版；Make-to-Order 与 MRP Area 页面未锁定 S/4HANA 2021 On-Premise 版本。另见 SAP S/4HANA Cloud 2021 的 BJE（Make-to-Order Production - Finished Goods Sales and Final Assembly）应用范围，部署版与本文目标不同。上述来源均不进入本文目标版事实证据；不以其填补核心定义。
- 动态 FSD_OP2021_latest.pdf 本次打开显示 Document Version 11.0（2026-07-22），对应 SAP S/4HANA 2021 SPS10；即使 §2.8.3.1 有高层 MRP/需求供应描述，也不代表固定 2021 Initial Shipment/FPS 文档，更不支持完整 Plant/MTS/MTO/离散流程定义。
- **门禁与 M3 记录**：M3 triage 将 PP-01 标为“暂缓核心”，detail-logistics 要求组织/工厂角色及 MTS/MTO、离散/流程制造边界。复读已验收 M3 控制矩阵，未发现 PP-01 或 PP-01～PP-09 单独行；不能将它归述为 PP-01 专属矩阵条款。具体要求来自逐篇 triage/detail-logistics 与 evidence-logistics 条目。本轮不改已验收矩阵。当前固定版证据仍只支持有限范围标签，不足以支持本篇核心学习目标，PP-01 保持 Draft。未连接 SAP，未做系统/权限测试。
- **P2 激活范围补充**：同一固定 SPS04 PDF 的 Effects on Customizing 说明，需在 Customizing 激活对应 enhancement 才启用该 HTML5 支持；此条件针对 PI Sheet / work instruction 浏览器功能，不证明任何客户系统对清单中的制造 Scope Item 已获许可、已部署或已启用。SAP 官方固定 PDF：https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.004/en-US/WN_OP2021_SPS04_EN.pdf#page=13。
- **最终正文与独立复核**：PP-01 最终正文 blob `2c8d036bcedc137e5a0cc13ee1846719d2006bd9` 已由三个独立 AI reviewer-context（读者、配置顾问、开发者）各完成 5 项“质询—作者答复/修订判断—复核”，15/15 均 PASS，仅确认当前证据边界安全。M3 核心学习目标仍未被证明，文章保持 Draft，不计 Role Reviewed；复核过程见 [PP-01 审查记录](../reviews/work/2026-11-27-m4-pp01-three-role-review.md)。未连接 SAP，未做系统、配置或权限测试。

## PP-02 2026-11-27 固定版来源访问续核

- **M3 范围**：逐篇分流将 PP-02 标为“限缩可写”，后续需补查 BOM 有效期、替代项选择及具体表/字段；detail-logistics 将 BOM 结构、替代、用量、有效日期、版本与组件缺失都列为目标，并要求虚构产品与组件的数量练习和有条件选择说明。已验收 M3 控制矩阵无 PP-02 单独行，具体文章门槛来自 triage/detail-logistics/evidence 记录。
- **P1｜New App: Manage Multilevel Bill of Material**：固定 SAP S/4HANA 2021.000 官方检索索引显示层级树、BOM header 与嵌套 components/assemblies/material；索引同时显示应用支持 display and maintain，权限与 BOM Engineer business role template 对应。版本化 Help HTML 本轮 direct open 返回 0 行，未直接复读完整正文；不把索引摘录写成完整应用文档或通用 BOM 规则。
- **P2｜Configuration to Define Versioning of Bill of Material**：固定 2021.000 官方索引显示可经 “Define Additional Control Data” 启用 BOM versioning。版本化 Help HTML direct open 返回 0 行，未直接复读正文；不据此推断完整 IMG 路径、默认值或客户系统设置。
- **P3｜Configuration to Maintain Manual or Automatic Versioning for BOM Usage**：固定 2021.000 官方索引显示，version-controlled BOM 的特定 BOM usage 可配置 manual/automatic versioning。带 `locale` 参数的首次打开请求返回工具访问错误；移除 `locale`、保留 `version=2021.000` 后重开，页面仍为 0 可读行。未直接复读正文；仅按官方索引摘录记录有限能力，不据此推断全部 usage、编号算法或默认行为。
- **P4｜Confirm Repetitive Manufacturing**：固定 2021.000 官方索引显示，仅在 make-to-stock repetitive manufacturing 确认场景中，可用 BOM explosion date 确定创建确认时有效的 BOM version。版本化 Help HTML direct open 返回 0 行，未直接复读正文；不外推至一般生产订单、其他制造模式或通用选版规则。
- **补证搜索及排除**：对 BOM item/base quantity、alternate BOM/validity、缺失组件和通用选择规则的 SAP 官方搜索，出现的可读通用资料分别标记为 2025 FPS01/其他动态版或 SAP ERP EHP8；未用于 2021 On-Premise 主张。Maintenance Bill of Material 2021 API 只针对设备/功能位置 BOM，不替代 PP 物料 BOM 数据模型。未找到足以闭合 PP-02 用量/单位、有效期、替代项优先、组件缺失及表/字段/API 核心目标的固定版直接正文。
- **文章处理**：正文已限定为可见的官方检索索引摘录，明确 P1–P4 的页面正文无法直接复读；核心缺口保持在文章与 review 记录中。PP-02 保持 Draft，不计 Role Reviewed；SAP 未连接，未执行系统、配置、数据库、API 或权限测试。
- **独立角色复核与状态**：PP-02 最终正文 blob `c87f31763c7137af445cc8c0f1267280b08dfb6c` 由读者、配置顾问、开发者三个独立 AI reviewer-context 各完成 5 项质询—作者答复/修订判断—最终正文复核。读者发现 ASM-110 位置措辞歧义，作者修正后原角色复验；最终 15/15 PASS 仅表示边界清楚、未外推索引证据。用量/单位、一般选版、组件异常及数据模型等学习目标未闭合，文章保持 Draft，不增加 Role Reviewed；详见 [PP-02 审查记录](../reviews/work/2026-11-27-m4-pp02-three-role-review.md)。SAP 未连接，未做系统、配置、数据库、API 或权限测试。


## PP-03｜2026-11-27 M4 动态来源核对与独立审查补记

- 最终正文：ideas/CareerOS/knowledge/PP/01-foundations/work-center-routing.md；blob `a84cbe704635ee67f58ce5d55c1db75b06086bc0`。逐篇审查见 [PP-03 三角色工作记录](../reviews/work/2026-11-27-m4-pp03-three-role-review.md)。
- 动态 SAP 官方来源：[S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)。本轮直接打开并核对到 Document Version 11.0（2026-07-22）；文档历史将其标为 SAP S/4HANA 2021 SPS10。§2.8.2.2，PDF pp.68–69，支持高层说明：离散制造 work center 与流程工业 resource 的术语区分；Work Center 的机器/生产线/员工/员工组示例及排程、成本、产能计划用途；Routing 的工序/步骤与顺序、执行工作中心信息和所需 BOM 组件；生产版本为材料指定生产所用 BOM 与 Routing。
- 该 FSD URL 含动态 latest。本窗口早先一次官方抓取返回 Document Version 9.0（2025-07-23，SPS08），后续对同一路径的官方搜索索引及直接打开返回 v11.0/SPS10。没有本地 PDF 或固定哈希可锁定 v9 快照；文章仅采用可直接核对的 v11.0/SPS10 文本，并在正文披露版本差异与可复现性限制。不得把任何 latest 结果称为固定 2021.000 初始版。
- 固定 SAP Help：
  - [Manage Routings](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/9a63a564ff1c4194843dec4c37dfb033.html?locale=en-US&version=2021.000)：官方索引显示 2021.000、Scope Item BJ5（离散制造 MTS），搜索 Routing 并导航至创建/更改应用；本轮直接打开 HTML 为 0 可读行。不支持通用 Route 字段、选择规则、客户权限或只读承诺。
  - [OData API: Work Center](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f7e7144c65a647c3a68d84db06bc54c4.html?locale=en-US&version=2021.000)：官方索引显示 2021.000、Scope Item BJ8（基于流程订单的按库存流程制造），OData V4 create/read/update 与 header/description/cost center allocation/pooled capacity/capacity 等实体类别；本轮直接打开 HTML 为 0 可读行。API 含写能力，不是只读权限证明，也不是所有离散制造 Route 的字段合同。
  - [Manage Shop Floor Routings](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/7cb8c2893d224d0bbe47c4102d136a12.html?locale=en-US&state=PRODUCTION&version=2021.000) 与 2021 PEO-ERP Implementation Guide 仅作 PEO 专用路线边界材料，不推广为普通 PP Routing 规则。
- 支持和缺口：SPS10 FSD 只补齐概念层关系，不给 Routing operation 详细字段/选择，工厂适用性，替代/有效期/数量选择，Work Center 完整字段与工序指派，standard values/formula/capacity requirements/成本估算，BOM-component-to-operation 精确关系，生产版本冲突处理，客户配置/授权。FSD 中 same-line/alternate work center 分组只用于汇总产能评估，不支持路线、operation 或订单自动切换结论。
- 独立审查：普通读者、资深 SAP 配置顾问、普通 SAP 开发者三个独立 AI reviewer-context 各对最终正文 blob 完成 5 个问题和原角色复核，共 15/15 PASS（仅来源范围与措辞边界）。三者建议文章保持 Draft；M3 核心未闭合，因此不计 Role Reviewed。原有 15 项同 Work 角色模拟作为历史，不计独立审查。
- 未连接 SAP；未执行实机、配置、数据库、API、权限或客户设置测试。
