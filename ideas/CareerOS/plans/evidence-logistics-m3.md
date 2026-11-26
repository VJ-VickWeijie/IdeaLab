# CareerOS V0.3｜物流与业务 46 项公开来源核验（M3 进行中）

核验日期 2026-11-25（UTC）。基于 PR #20 当前规划；本台账仅是逐篇资料准备与缺口清单，不是文章正文、三角色审核或 SAP 实机验证。每条列出至少一个**与主题部分直接相关**的可读原文；其中个别只涉及邻近子主题或特定产品场景，已明确标示为“直接证据未解决”，不能作为该文章已满足 M3 条件的依据。

## 实际读取的官方文献

- **F（动态，当前读取正文可用）**：[SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，2026-11-25 打开为文档 **11.0，2026-07-22，2021 SPS10**，PDF 共 718 页；同日独立读取的 PDF 长度 3,056,745 字节、SHA-256 `ad3c9913ee1f0cbe81e4ede4cb15192c4fcda6497dcf9ac0654dde04b541aaec`。该 PDF 未归档，latest 以后可变；引用仅适用当次现版已读部分，**不证明 SPS08 或任何其他补丁**。同 URL 的旧索引曾为 9.0/SPS08，本文完全不把它作为当前版正文。页码是 PDF 的 1 起始页码，链接使用 `#page=`。
- **S（静态文件，已读正文）**：[SAP S/4HANA 2021 Simplification List](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)，文档 **1.25，2022-05-25，Initial Shipment、FPS01、FPS02**，只证明原文明确范围，不对 SPS10/其他版本泛化。页码同上。
- 其他 Help 页面搜索结果若点击后无可读正文，仅记为线索，不计已读。即使某行有 PDF 直接支持，也只表示对应**一小项主张**；所有事务码权限、配置路径、会计分录、跨版本/系统行为等仍需独立核实。

| ID | 来源、产品/修订及具体页 | 本次实际读取并可支持的范围 | 未覆盖与门禁 |
| --- | --- | --- | --- |
| MM-01 | [SAP 采购组织结构，S/4HANA 2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2b7eb65334e6b54ce10000000a174cb4.html?version=2021.000)；协调者及独立开发者均通过浏览器实际读取 `2021 (Oct 2021)` | 直接覆盖客户端、公司代码、工厂、采购组织与采购组的概念，及文中所述的组织关联、集中/分散采购 | 不代表每家企业的组织设置、所有模块关系和当前系统权限；该来源有限描述经独立复核 |
| MM-02 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 134 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=134)；§3.18 Business Partner Approach | BP 和 CVI 配置检查涉及 BP role category | 该段是迁移前提，非供应商角色全表及物料视图 |
| MM-03 | [F：2021 SPS10；11.0，PDF 第 153 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=153)；§2.12.3.2 Source Assignment | 信息记录关联物料和供应商，并可按采购组织或工厂维护；货源清单/配额在该节 | 优先级、有效性和自动选择条件 |
| MM-04 | [F：2021 SPS10；11.0，PDF 第 157 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=157)；§2.12.4.2 Requirements Processing | 采购申请及其处理功能 | PR→PO 各变体、审批配置与实际事务 |
| MM-05 | [F：2021 SPS10；11.0，PDF 第 169 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=169)；§2.13.1.1 Goods Movement | 货物移动、收发货与库位/库存类型变化概述 | 具体移动类型、特殊库存和价值影响 |
| MM-06 | [F：2021 SPS10；11.0，PDF 第 169 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=169)；§2.13.1.1 Goods Movement | 列举货物发出、货物收取和移动 | 冲销与退货在单据及账务上的具体差异 |
| MM-07 | [SAP Units of Measure in Purchase Orders，2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/af7eb65334e6b54ce10000000a174cb4.html?version=2021.000)；协调者及独立开发者均读取 `2021 (Oct 2021)` | 可作为普通采购订单中的订单单位、订单价格单位、换算以及采购信息记录可供默认值的直接来源；只支持文档明确的使用场景 | 未证明 BAPI 特定字段覆盖根因、所有配置优先级、后续 FPS 差异或当前系统行为；该来源有限描述经独立复核 |
| MM-08 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 151 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=151)；Material/Article Master 的 MRP 字段变更 | 对 MM01/MM02/MM03 特定屏幕字段改变有说明 | 不证明这些事务全面可用、显示/写入权限或其他采购 T-Code |
| MM-09 | [SAP Help 固定 2021 GR/IR 页面](mm09-2021-grir-direct-m3.md)、[2021 Account Determination 因素页面](mm09-obyc-source-followup-m3.md)、Simplification List 补查。Work 与独立上下文直接复读 Account Determination 页面，版本均为 2021 (Oct 2021)。 | 新页面仅支持发票侧输入/主数据/已过账单据/系统设置等影响类别；不列 OBYC、BSX/WRX、交易键或收货配置。GR/IR 关联页“credit stock account”无借贷表，方向冲突仍未裁决；估价/移动类型、权限也未证。 | Work 继续找目标版普通估价库存收货的自动科目确定规则与配置资料；将因素概览与可操作配置键分开记录。 | 未闭合 |
| MM-10 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 478 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=478)；MM-IM 数据模型简化 | 比较 ERP 与 S/4HANA 库存管理数据模型 | PR/PO 完整模型、精确键、基数和发布 API |
| SD-01 | [SAP 2021 Sales Organization](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f7fddfe4caca43dd967ac4c9ce6a70e4/a614c453f57eb44ce10000000a174cb4.html?version=2021.000)；详见[补查](evidence-gap-four-m3.md) | 独立顾问实读 2021 初版销售组织、销售区域三项以及公司代码/工厂的有限分配关系。 | 不证明所有客户自定义、实际配置及全部跨公司开票场景。 |
| SD-02 | [2021 BP 与伙伴职能补查](sd02-partner-2021-evidence-m3.md)：2021 Oct 销售伙伴、BP角色及数据层级四页；其中前两页独立复核。 | 有条件地支持 partner function、FLCU00/FLCU01、客户账户组及所述组织层级；注意原文 FLVN00 案例内部冲突，不视为 SAP 勘误。 | BP grouping/编号、全部伙伴确定配置、权限、字段/API 和系统实测仍待证。 |
| SD-03 | [F：2021 SPS10；11.0，PDF 第 122 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=122)；§2.10.2.6 Sales Order Management and Processing | 销售单据类型及确认数量日期的功能 | 具体部分交货、取消与权限 |
| SD-04 | [F：2021 SPS10；11.0，PDF 第 126 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=126)；§2.10.2.8 Sales Billing | 开票单据可传递 FI | 并非所有开票的收入确认、税和收款逻辑 |
| SD-05 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 951 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=951)；DIMP 场景快速录入兼容变更 | 特定 DIMP 快速录入的变更段提到 VA03 | 不能据此推断所有系统 VA03 的授权及完整作用 |
| SD-06 | [F：2021 SPS10；11.0，PDF 第 118 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=118)；§2.10.2.2 Price Management | 价格管理包含定价流程配置 | 准确 IMG 节点、业务分支和访问权限 |
| SD-07 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 789 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=789)；SD data model simplifications | 特定转换场景涉及 VBUK/VBUP 的状态和追加字段迁移；不推断所有状态字段均同样迁移 | 完整单据流字段、主键、接口及关联基数 |
| PP-01 | [F：2021 SPS10；11.0，PDF 第 70 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=70)；§2.8.3.1 Material Requirements Planning | 生产/客户需求与供应计划的范围 | 组织结构及所有制造模式的业务边界 |
| PP-02 | [F：2021 SPS10；11.0，PDF 第 67 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=67)；§2.8.2.1 Production BOM Management | 生产 BOM 是产品组件的结构化清单 | 有效期、替代项选择和具体表/字段 |
| PP-03 | [F：2021 SPS10；11.0，PDF 第 68 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=68)；§2.8.2.2 Master Recipe/Routing Management | 工艺路线/配方作为生产过程主数据的总体作用 | 工作中心完整定义、工序选择和成本/产能参数 |
| PP-04 | [F：2021 SPS10；11.0，PDF 第 70 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=70)；§2.8.3.1 Material Requirements Planning | MRP 覆盖需求，计划运行为补货产生提议 | 净需求计算、批量、参数及客户具体系统差异 |
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
| QM-06 | [S：2021 初版/FPS01/FPS02；1.25，PDF 第 678 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=678)；§31.2 Removed Redundant Transactions in QM | 列举 QE51 的替代及其他事务导航变化 | 旧版事务替代说明不证明所有事务在目标补丁均可访问或权限充足 |
| QM-07 | [2021 FPS01 What's New §4.3.8](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)；详见[补查](evidence-gap-four-m3.md) | 检验结果比较符的一个 FPS01 IMG 配置示例，独立顾问已核对。 | 不证明初版同样可用、检验类型激活、工厂配置或实际权限。 |
| QM-08 | [2021 FPS01 What's New §4.3.8](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)；详见[补查](evidence-gap-four-m3.md) | 特定检验结果属性 CDS `I_INSPECTIONRESULTATTRIBUTE`，独立顾问已核对。 | 不证明初版支持、检验批及结果的表键、关联、CDS 发布或授权。 |
| PROCESS-01 | [2021.000 P2P 直接来源](evidence-p2p-fi07-m3.md)、[P2P 估价](p2p-valuation-direct-2021.md)、[末端付款](p2p-payment-evidence-m3.md)；FI-07 另记 [MAP 无库存覆盖案例](finance-fi07-direct-2021.md) 与 YCOA 2025-FPS1 对照。 | MAP 特例补充数量/价差逻辑，不代表普通无科目分配通用分录；Manage Automatic Payments 不证明逐笔供应商发票会计凭证或银行扣款；完整配置、异常及资金链仍缺。 | 按标准库存/费用采购、非估价收货、税、部分数量、清账、付款及配置继续补证，不拼成通用分录。 | 未闭合 |
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
