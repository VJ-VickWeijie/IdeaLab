# PP-01｜生产业务与组织结构

- 文章 ID：PP-01
- 状态：drafting
- 目标版本：SAP S/4HANA 2021 On-Premise
- 当前稿件范围：记录固定版官方资料能够确认的制造范围标签，并列出生产组织、按库存/按订单及离散/流程制造的核心缺口。
- 状态原因：现有固定版资料只支持特定制造 Scope Item 名称，不足以解释工厂的生产组织角色、按库存与按订单生产边界，以及离散和流程制造的业务差异。上述概念是本篇的核心学习目标，不能以动态 latest 页面、ECC 资料或常识补成 2021 产品事实。
- SAP 系统：未连接；没有实机测试。

## 1. 生产业务需要哪些边界

本篇原定帮助学习者回答：

1. 企业为什么要把生产地点和计划/执行责任组织起来？
2. 工厂（Plant）在生产计划、物料计划和执行中承担什么角色？
3. 按库存生产（Make-to-Stock）与按订单生产（Make-to-Order）如何区分？
4. 离散制造（Discrete Manufacturing）与流程制造（Process Manufacturing）在对象和执行方式上有什么不同？
5. 这些差异如何影响后续 BOM、MRP、生产订单、成本和库存？

目前没有找到足以直接支持以上核心解释的 SAP S/4HANA 2021 On-Premise 固定版来源，因此本文不把通用 ERP 介绍、旧版 SAP ERP 文档或动态最新页面写成目标版本定论。

## 2. 固定版资料当前能证明什么

### 2.1 2021 年初始版中的命名范围

SAP Help 固定版 SAP S/4HANA 2021.000（Oct 2021）“CDS Views for Production Planning”的 SAP 官方检索索引列出 BJ5、BJ8 和 J44；本轮 direct open 返回 0 行，未直接复读页面正文。以下仅按可见索引记录 Scope Item 名称，不据此构造制造流程或定义业务模式：

- BJ5：Make-to-Stock Production - Discrete Manufacturing
- BJ8：Make-to-Stock - Process Manufacturing Based on Production Order
- J44：Material Requirements Planning

这份材料可支持“2021 产品文档将这些名称用于相应功能范围”的陈述。它不能单独证明工厂组织结构、各 Scope Item 的完整业务流程、按订单生产的具体规则或每个系统实际启用了什么功能。

### 2.2 2021 SPS04 文档中的制造场景名称

SAP《What's New in SAP S/4HANA 2021 SPS04》静态 PDF（Document Version 1.0，2023-05-17）§3.1.1 / 印刷页 13，在“HTML5 Support for Browser-Based Process Management Applications”适用范围中列出以下 Scope Item 名称：

- Make-to-Stock Production - Discrete Manufacturing
- Make-to-Stock - Process Manufacturing Based on Process Order
- Make-to-Stock - Process Manufacturing Based on Production Order
- Make-to-Order Production - Process Manufacturing
- Make-to-Stock with Co- and By-Products - Process Manufacturing

该固定版直接来源仅证明这些名称出现在 PI Sheet / work instruction 浏览器功能的适用范围中。它不是完整制造模式目录，也未解释各模式的组织、计划、库存、需求或会计差异。 文档中“激活相应 enhancement”的要求针对该 HTML5 浏览器功能，不证明列出的 Scope Item 在任何客户系统中已获许可、部署或启用。

## 3. 尚不能作为 2021 事实写入的内容

以下主题在补到固定版直接来源前保持待核：

- Plant 与公司代码、MRP 区域、生产供应区域、存储地点和工作中心之间的组织关系。
- 哪些组织层级拥有主数据、计划数据或生产责任，以及哪些关系因客户配置而不同。
- 按库存生产与按订单生产的需求关联、库存分段、计划方式和成本对象差异。
- 离散制造与流程制造对 BOM/配方、Routing、生产/流程订单和报工确认的完整差异。
- Scope Item 代码与产品能力、许可证、部署选项、激活状态之间的关系。
- 由组织或制造模式推导出来的库存估价、FI/CO 分录、订单成本或结算结果。

M3 来源登记引用的 FSD 页面是动态 latest URL。此前复核只确认其高层范围描述，并记录该 URL 的版本快照会变化；它不作为本稿的固定版直接证据。

## 4. 可用于后续补证的记录表

补证时，每个问题都要有单独的固定版来源，不能用某个 Scope Item 名称替代业务定义。

| 待核主张 | 需要的直接资料 | 当前结论 |
| --- | --- | --- |
| 工厂在 2021 生产组织中的职责及组织分配 | 固定为 SAP S/4HANA 2021 On-Premise 的组织结构或产品帮助页面 | 未闭合 |
| Make-to-Stock 与 Make-to-Order 的业务边界 | 2021 目标版流程/功能文档，明确需求、库存、订单与适用前提 | 未闭合 |
| 离散与流程制造的区别 | 2021 目标版生产帮助，明确主数据对象、生产单据与执行差异 | 未闭合 |
| 生产组织对 MRP、执行、库存和成本的影响 | 分别覆盖主张的 2021 直接证据；金额/会计结论需单独证据 | 未闭合 |
| 当前客户系统是否具备某种模式或组织配置 | 目标系统只读核对及其权限/配置证据 | 未验证 |

## 5. 当前可读的官方来源

1. SAP Help Portal，“CDS Views for Production Planning”，SAP S/4HANA 2021（Oct 2021），version 2021.000。SAP 官方检索索引列出 BJ5、BJ8、J44 为相关 Scope Items，并描述新增 PP CDS views；本轮 direct open 返回 0 行，未直接复读页面正文。本文仅将可见索引作为范围名称的有限依据：  
   https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b39ff179522b435584613620f5f4cdd5.html?locale=en-US&state=PRODUCTION&version=2021.000
2. SAP Help Portal，《What's New in SAP S/4HANA 2021 SPS04》，Document Version 1.0（2023-05-17），§3.1.1，印刷页 13。本文直接复读静态 PDF；其 Scope Item 清单只绑定 PI Sheet / work instruction 的 HTML5 浏览器功能：  
   https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.004/en-US/WN_OP2021_SPS04_EN.pdf#page=13
3. M3 的 [逐篇范围、版本线索与依赖](../../plans/detail-logistics-v0.3.md)、[来源登记](../../plans/evidence-logistics-m3.md) 和 [SD/PP 来源贴合度复核](../../plans/sd-pp-source-fit-m3.md)记录了原计划范围和证据缺口。它们是规划/来源边界记录，不替代正式文章证据。
4. SAP Help 的 FSD_OP2021_latest.pdf 为动态 URL；其标题虽然指向 SAP S/4HANA 2021，文件版本会变化。本文不把它当作固定版本 2021 证据：  
   https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf

## 6. 关联文章

M3 计划把 PP-01 与 MM-01、PROCESS-05 关联。MM-01 已存在且为 Role Reviewed；PROCESS-05 属于尚未开始的批次 B，当前分支仍无该流程正文。生产流程依赖不据计划补写，PP-02 等批次 A 关联文章已存在但仍为 Draft，不能当作已审查依据。

## 7. 当前学习建议

在获得固定版资料前，只把 BJ5、BJ8、J44 当作官方文档中的产品范围标签来识别。不要凭这些名称推演客户组织、生产流程或账务结果。学习者可先把自己的疑问填写到第 4 节记录表，暂不将其当成 2021 的已证事实。
