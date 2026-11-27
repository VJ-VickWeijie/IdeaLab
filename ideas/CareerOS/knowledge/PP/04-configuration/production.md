# PP-08｜生产计划配置查看

- 文章 ID：PP-08
- 状态：drafting
- 目标版本：SAP S/4HANA 2021 On-Premise；仅在必要处提及 ECC 差异
- 当前可写范围：三个固定版来源支持的局部示例——MRP Scheduling Margin Key、2021 FPS01 的组件装配动作处理器设置、2021 Change Record 与 Process Order 的官方索引摘录；另将一项动态更新到 S/4HANA 2021 SPS10（v11.0）的 Operations Guide 报表前提单独标注。
- 状态原因：这些来源不足以形成通用的订单类型、排程/确认、MRP 参数和工厂主数据配置指南，也没有证明用户可在目标系统中通过哪些受授权的只读入口查看这些设置。核心范围未闭合，故保持 drafting。
- 系统验证：SAP 系统未连接；没有执行配置或实机测试。

## 1. 本篇要学什么

原定范围要求把配置项、系统行为、只读查看入口、适用前提和反例连起来。固定版资料和一份标明为 2021 SPS10 的动态指南，只能回答若干具体问题，不能把它们合并成一个“适用于所有工厂和订单类型”的 PP 配置流程。

阅读本页时要区分：

- **配置（Customizing）**：下文仅在 SAP 2021 来源直接给出具体配置路径时记录。
- **主数据字段**：某个物料/工厂相关字段的规则，不代表所有物料或工厂都用相同值。
- **功能专属前提**：为某个 SAP 功能/动作处理器设置的路径，不自动成为一般生产订单设置建议。
- **访问与授权**：SAP 文档给出的配置路径不代表当前用户拥有访问权，也不证明该路径适合只读查看。

上述区分用于阅读来源，不能替代客户系统里的授权和配置核查。

## 2. 2021 目标版资料的局部示例（按来源版本区分）

### 2.1 Scheduling Margin Key：一个有明确版本差异的 MRP 字段

SAP《Simplification List for SAP S/4HANA 2021》说明，S/4HANA 中物料主数据字段 Scheduling Margin Key（MARC-FHORI）默认并非必填；若字段选择设置（文档标为事务码 OMSR）将其定义为必填，才成为必填。文档还说明，未指定该 key 时，生产前/后的 float 和 opening period 为零；其所述结果是计划订单的转换应每日进行。来源把该字段与 ECC 旧规则作了对比：ECC 在特定 MRP type 条件下要求填写，且该要求独立于 OMSR 定制设置。

这只是对目标版文档中特定字段规则的说明。它不证明某个客户的字段选择、MRP type、计划频率或实际订单转换结果；也不是建议在生产环境中修改字段或 OMSR。

### 2.2 组件装配动作处理器：SAP S/4HANA 2021 FPS01 的功能专属设置

《What's New in SAP S/4HANA 2021 FPS01》描述一个特定动作处理器 `CHECK_BEING_ASSEMBLD_BATCH_SN_WITH_ISSUED`，用于组件装配时校验组件数量、序列号和批次与同一订单组件已过账货物发出的数据。该 FPS01 功能的来源列出两处 Customizing 路径：

1. Production → Manufacturing for Production Engineering and Operations → Production Operations → Define Additional Parameters for Processing Shop Floor Orders；选择所需 plant 和 order type，并选择 No GI at Component Assembly。
2. Production → Shop Floor Control → Master Data → Order → Define Order-Type-Dependent Parameters for Production Orders；选择所需 plant 和 order type，在 Implementation 页签中选择 Documentation of Goods Movements 下的 Planned Goods Issue。

来源将这些选项作为“使用该动作处理器”的前提。不能据此推导所有生产订单都应启用这些选项，也不能把它写成一般的组件发料、确认或排程规则。它是 2021 FPS01 功能材料；部署和功能前提仍须在目标环境核对。

### 2.3 Change Record 与流程订单：仅限特定 2021 功能

SAP 官方检索索引中《Integration with SAP S/4HANA Change Record》页面锁定 SAP S/4HANA 2021（Oct 2021，2021.000），范围列出 BJ8 和 1NF，并将“Required Approval”设置与相应 Change Record/Process Order 功能关联。该 Help HTML 本次直接打开为 0 行，故此处只按官方索引摘录记录，不能声称已逐段复读完整页面。索引所列路径为 Production Planning for Process Industries → Process Order → Master Data → Order → Define Order-Type-Dependent Parameters for Process Orders；设置位于流程订单类型的 Recipe 区域。

这只记录该 Change Record/Process Order 功能页面索引所列的设置前提。它不说明一般离散生产订单的批准配置，也不能单靠该索引摘要确定审批人的权限、审批发生时点、状态变化或客户系统的自动处理行为。

### 2.4 动态更新到 SAP S/4HANA 2021 SPS10 的 Operations Guide：MRP Records 报表前提

SAP Help Portal 当前提供的《Operations Guide for SAP S/4HANA 2021》PDF 为动态更新文档 v11.0（2026-07-22），文档历史将 v11.0 对应到 SAP S/4HANA 2021 SPS10；指南也说明门户提供其最新版本。该版关于 `PPH_SETUP_MRPRECORDS` 的页面说明：要为工厂建立/处理该报表使用的 MRP records，工厂中的物料必须与 MRP 相关、维护物料主数据中的 MRP views，并设置合适的 MRP type。此处只引用动态 SPS10 指南中的报表前提；它不是冻结的 S/4HANA 2021 初版证据，不构成 MRP type 的完整定义或一般配置规则，也没有给出本篇所需的用户只读访问路径。

## 3. 证据范围核对矩阵

| 范围 | 当前引用来源实际支持的内容（版本见左列） | 不能据此推出 |
| --- | --- | --- |
| MARC-FHORI | S/4HANA 2021 中默认非必填；字段选择可使其必填；未指定时来源所述的 float/opening period 为零 | 客户字段选择、任意物料/工厂的值、客户计划频率或转换作业是否每日运行 |
| 2021 FPS01 组件装配动作处理器 | 使用指定动作处理器的两处配置路径、按 plant/order type 选行及指定选项 | 所有订单类型的通用设置；当前系统是否启用该功能；更改配置后的客户系统行为 |
| 2021 Change Record 与 Process Order | 指定 Change Record 功能的 Required Approval 配置位置与 Recipe 区域前提 | 通用流程订单审批模型、离散订单批准、审批人/角色、所有状态或自动化结果 |
| MRP Records 报表（动态 Operations Guide v11.0／2021 SPS10） | 该版指南列出的报表先决条件：相关物料、维护 MRP views、合适的 MRP type | S/4HANA 2021 初版的同一规则、MRP 全部字段、MRP 净需求计算、工厂组织结构或执行权限 |
| 只读查看与授权 | 本轮来源未建立目标系统里的受权只读事务/应用入口 | 不能把 Customizing 路径、事务码名称或文档可读性当成用户已获授权 |

## 4. 尚未闭合的核心范围

以下内容没有取得足以支撑通用教学的 S/4HANA 2021 On-Premise 固定版直接证据，保持待核：

- 生产订单类型的通常配置项及其对订单创建、计划、释放、确认和结算的完整影响。
- 生产排程参数、确认参数、工厂日历/工作中心等主数据或配置如何共同决定日期与数量。
- 常见 MRP 参数的定义、相互作用、默认值、反例和版本条件。
- 工厂（plant）在生产组织和计划中的一般配置职责及其与公司代码、存储地点、MRP area 的组织关系。
- 上述设置在目标 SAP 系统中的只读查看入口，以及用户角色、授权对象、字段级限制。
- 对客户配置是否实际生效、功能是否启用、作业是否运行的确认。

PP-01 目前也是 Draft，且其核心组织关系和生产模式证据未闭合；不能把它当成 PP-08 的已审核依据。PP-04、PP-05、PP-06 文件均存在，但仍为 Draft，不能借未审查文章补足配置行为。

本轮还按官方 SAP 域名检索了 `version=2021.000` 的 production order type、production scheduling profile、confirmation parameters 与 MRP group/configuration 相关页面。没有找到可直接复读、能串联一般配置项、行为和适用条件的固定版 2021 On-Premise 页面。命中项中有当前 2025/2026 文档、旧 SAP ERP 文档、未锁定版本页面或单一功能索引摘录；均未被用作通用 2021 规则。SAP `FSD_OP2021_latest.pdf` 的搜索索引与 PDF 版本记录还出现 v9.0/SPS08 与此前直接读取的 v11.0/SPS10 差异，进一步说明该 `latest` URL 会变化；本篇不以它填补固定版配置缺口。

## 5. M3 来源台账的页码/主题错配

M3 的 PP-08 来源行将 SAP《Simplification List for SAP S/4HANA 2021》PDF 第 623 页描述为“MRP 相关生产版本迁移”。本轮直接检查 PDF 目录后，第 623 页列为“S4TWL - Browser-based Process Instruction-Sheets/Electronic Work Instructions”；该页码本身不能支持该描述。相邻的第 617 页为“S4TWL - Simplified Sourcing”，也不支持一般 PP 配置规则。故本篇不将上述旧行用作证据。

本轮已在共享来源台账与来源贴合度记录中更正 PDF 第 623 页的主题描述，并保留 M3 原有“未核验 / 暂缓核心”准入结论；没有修改 M3 控制矩阵或放宽门槛。PP-08 的产品事实按下列来源分别标注固定版直接资料、官方索引摘录或动态 SPS10 指南，不将它们混为一类。

## 6. 离线学习方式

可选练习：把第 2 节四个示例分别标为“物料主数据字段”“功能专属 Customizing 前提”或“报表先决条件”，再用第 3 节核对矩阵写出每个例子不能推出的结论。无需连接 SAP，也不修改生产配置。

不要把本文中的路径复制到客户系统执行。当前页没有提供授权核验步骤，也没有做过真实系统访问。

## 7. 来源

1. SAP, [Simplification List for SAP S/4HANA 2021 — Initial Shipment, FPS01 & FPS02](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=152), Document Version 1.25, PDF page 152, “Scheduling Margin Key”. 2021 固定版来源；用途限于字段的目标版规则和 ECC 对比。PDF 目录中 PDF page 623 为 Browser-based Process Instruction-Sheets/Electronic Work Instructions。
2. SAP, [What's New in SAP S/4HANA 2021 FPS01](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf), “Manage Action Settings”, PDF page 146（功能介绍）及 PDF page 147（Effects on Customizing），Valid as Of SAP S/4HANA 2021 FPS01。只用于该动作处理器的专属前提。
3. SAP Help Portal, [Integration with SAP S/4HANA Change Record](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/50eafcd7add0463a86ae7616718c5eba.html?version=2021.000), SAP S/4HANA 2021 (Oct 2021), version 2021.000；官方搜索索引摘录列出 BJ8/1NF 与该功能的 Required Approval 配置前提；canonical HTML 本轮直开 0 行，未声称通读全文。
4. SAP, [Operations Guide for SAP S/4HANA 2021](https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf), “Report for Processing MRP Records”, PDF p.23；所读 PDF 为动态 v11.0（2026-07-22），文档历史对应 S/4HANA 2021 SPS10，入口提供最新指南。只用于该动态版本的报表前提，不作为冻结初版资料。
5. CareerOS M3 的[逐篇准入分流](../../plans/m3-item-readiness-triage-v0.3.md)、[逐篇范围、版本线索与依赖](../../plans/detail-logistics-v0.3.md)、[PP-08 来源台账](../../plans/evidence-logistics-m3.md)和[SD/PP 来源贴合度记录](../../plans/sd-pp-source-fit-m3.md)作为范围与待核记录，不替代 SAP 产品证据。
