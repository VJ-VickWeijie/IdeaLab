# CareerOS V0.3｜FI、CO 和课程逐项证据登记（M3）

状态：M1、M2及99篇候选文章、11项结构导航分类据交接已批准；M3仍在准备，M4尚未获授权。本表是证据研究记录，不是正式知识文章；没有SAP系统连接或实际系统测试，正式文章有效审核轮次为零。

## 来源使用记录与更正

2026-11-25 本次研究曾通过网页检索/打开 OpenStax《Principles of Accounting, Volume 1》2.2、3.1、3.2、3.3、3.5、12.1及 Volume 2 1.2、9.3、5.1、4.5 的网页正文。后续独立审查发现其页面对未经许可用于生成式 AI/AI offerings 有限制提示。**这些内容已被读取的事实不能撤销；后续停止读取或以其作为生成依据，暂停使用，许可及具体适用性待确认。** 这不是对法律问题的最终判断。原先据此列出的支持范围已移除，采用下方另行打开的 SEC、GAO 公开材料重建映射；如果替代材料无法支持某一主张，仍列待核实，不以旧摘录补全。

## 可读证据及限制

下列来源均于2026-11-25通过检索工具打开并读取所列段落，**来源可读只意味着局部主张有依据，不意味着整篇文章通过验收**。

| 代号 | 来源、版本、可读性及许可线索 | 实际覆盖与边界 |
| --- | --- | --- |
| S21 | [SAP《What's New in SAP S/4HANA 2021》](https://help.sap.com/doc/4eefc5f2d826408f91a999687d31780f/2021/en-US/WN_OP2021__EN.pdf)，PDF正文可读；封面明确文档1.0（2021-10-13），面向2021初始发行。部分条目含不同“Valid as Of”，须逐条核对。 | §3.5、§3.6内特定功能变更；不是所有功能、T-Code或配置的完整说明；SAP版权所有，引用须符合其适用条款。 |
| SI21 | [SAP《Simplification List for SAP S/4HANA 2021》](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)，PDF正文可读；覆盖2021初始发行及FPS01/02。 | §8.1财务数据模型转换与兼容对象背景；不证明每个字段、访问权限或发布API。文件版本和目标系统FPS须逐项复核。 |
| SEC1 | [美国SEC《Beginners’ Guide to Financial Statements》](https://www.sec.gov/about/reports-publications/beginners-guide-financial-statements)，网页正文可读，在线内容可能变更。SEC [网站FAQ](https://www.sec.gov/about/webmaster-frequently-asked-questions)称其政府制作内容可自由获取及再利用，并提示极少数内容如素材图片例外；具体素材仍需确认。 | “Balance Sheets”“Income Statements”和“Cash Flow Statements”分别介绍资产、负债、权益、会计等式、收入费用与现金流的基础概念。美国语境，不证明中国财税规则和SAP系统行为。 |
| SEC2 | [SEC《What is a balance sheet?》](https://www.sec.gov/files/balancesheet-building-blocks.pdf)，SEC小企业资本形成倡导办公室PDF正文可读；文件说明为工作人员教育资料，不具法规效力。 | 第1–2页介绍资产、负债、权益、等式及应收应付概念；使用边界同SEC1。 |
| GAO1 | [美国GAO《Illustrative Accounting Procedures for Federal Agencies》](https://www.gao.gov/assets/095099.pdf)，PDF正文可读，历史性美国联邦政府案例。GAO [版权和使用说明](https://www.gao.gov/copyright)称其产品可复制分发，但其内容可能含第三方版权材料；具体材料须核实。 | 第3–4节（印刷页19–20，§4 可能延续后页）以政府数据处理为例，描述成本中心、责任归属、直接及间接成本；不能直接映射SAP配置或当作现代中国企业制度。 |
| GAO2 | [GAO/PCIE《Financial Audit Manual》财务会计报告核对表](https://www.gao.gov/assets/a76851.html)，网页正文可读，历史性美国联邦会计指南。 | “Managerial cost accounting”和“Responsibility Segments”段落描述管理成本信息和责任分部；不证明SAP业务对象或其版次。 |
| IRS1 | [美国IRS Publication 538（2022年1月版）](https://www.irs.gov/pub/irs-pdf/p538.pdf)，PDF正文可读；仅作美国特定税务语境下现金制/权责发生制说明，不代表中国税会规则或SAP功能。 | Introduction 概述收入/费用确认时间；政府来源使用时仍应检查第三方素材及当前具体条款。 |
| IRS2 | [美国IRS《Examination Techniques》§4.10.3.15.1及 Exhibit 4.10.3-2](https://www.irs.gov/irm/part4/irm_04-010-003)，正文可读；网页可能变更，特定小节标注2003-03-01。IRS [官方使用说明 §1.17.8.6.5](https://www.irs.gov/irm/part1/irm_01-017-008)称政府人员公务编制且不含其他受保护素材的政府出版物不受版权保护；不得将其一概扩展至第三方素材。 | 复式记账、资产=负债+资本及账户通常余额方向的美国审计示例；一般余额方向不等同各账户所有变动方向，也不是中国税法或SAP过账配置。 |
| IRS3 | [美国IRS Publication 583（2007年1月版）](https://www.irs.gov/pub/irs-prior/p583--2007.pdf)，PDF正文可读，历史版本；使用限制同IRS2。 | “Bookkeeping System / Double-entry”示例说明借贷平衡和一笔租金分录，仅供通用会计示例，不代表当前美国税法、中国会计准则或SAP具体分录。 |
| ED1 | [美国教育部《Basic Accounting for Non-Title IV Specialists》](https://fsapartners.ed.gov/knowledge-center/library/historical-legacy-archived-content/1995-07-01/appendix-f-basic-accounting-non-title-iv-specialists)，1995 年历史资料；协调者于 2026-11-25 读取网页正文，独立复核未完成。 | “Normal Rules for Debiting and Crediting Accounts”支持借方/贷方记账侧的通用说明，但对应账户增减方向图在网页上不可用；材料是美国高等教育基金会计历史语境，不证明 SAP 或中国会计规定。 |
| R0 | [CareerOS原24个月路线](https://github.com/VJ-VickWeijie/IdeaLab/blob/117f69cb0f40780ebdd782cbcf3d3bcefd59b2ad/ideas/CareerOS/plans/roadmap-v0.1.md)，IdeaLab固定提交 `117f69cb0f40780ebdd782cbcf3d3bcefd59b2ad`；原文可读。 | 原路线按1–4周、2–3月、4–6月、7–12月、13–24月分阶段，原文标为待M0审批；审批记录另行查看。 |

SEC/GAO/IRS来源只支持文本中确切内容，站点其他第三方内容或图像不得自动假定相同许可；引用须注明来源及区域。涉及完整分账户借贷变动规则等未能由替代来源直接支持的细节，保留为缺口，不能从已暂停的教材补足。

## FI：逐ID支持范围与缺口

每行引用上表可访问URL；“待补”表示尚缺可读、精确适用于SAP 2021/FPS的专题依据或具体条件，不代表已完成文章审核。

| ID | 已读取证据和能支持的有限范围 | 待补、验证边界 |
| --- | --- | --- |
| FI-01 | SEC1“Balance Sheets”“Income Statements”；SEC2第1–2页支持基本财务对象/应付应收解释。 | 采购事件的单据、库存、价值和资金的SAP 2021触发条件及地区会计规则尚缺。 |
| FI-02 | SEC1“Balance Sheets”、SEC2第1页直接支持资产=负债+权益的基础概念。 | 美国教育示例不证明中国企业特定制度、税务或SAP配置。 |
| FI-03 | [财政部 2026 修订征求意见稿与考试大纲补查](fi03-mof-2026-evidence-m3.md)：独立复核覆盖草稿 PDF 与考试大纲。草稿列出银行存款、应付账款、折旧与坏账准备的限定例子；考试大纲覆盖借贷记账等知识范围，可作初学者概念线索。 | 征求意见稿不是已生效规则，考试大纲不是详细分录教材；当前适用规范、所有科目/例外、中国企业场景及 SAP 过账仍待权威资料核验，不构成法律结论。 |
| FI-04 | [SAP 2021 FI 总账迁移对象](fi04-gl-2021-evidence-m3.md)在限定 Direct Transfer 情景说明选定公司代码推导科目表、两类视图及 FS00 的 Display/Change；经独立复核。SEC1 与 S21 另提供各自有限背景。 | 日常组织基数、公司代码/报表边界、主数据字段及过账、FS00 实际权限仍需核验，迁移情景不可普遍推广。 |
| FI-05 | S21 §3.6.1.8描述特定 Manage Journal Entries 应用中的凭证分析与冲销功能。 | 复式会计分录、各单据冲销条件、期间与GUI事务仍缺直接依据；不得凭已暂停教材补足。 |
| FI-06 | SEC2第2页说明应收/应付的基本含义；S21 Finance相关条目列出特定客户和供应商项目应用。 | SAP 2021发票、过账、部分支付、付款清账及税币条件仍缺可读专题；美国教育资料不是中国准则。 |
| FI-07 | [SAP 2021 初版 FI-07 直接证据补查](finance-fi07-direct-2021.md)：含 MAP 数量/价差特例、局部地区收货例、GR/IR 页面歧义，以及固定版 GR/IR 未清项匹配/清账条件；固定 2021 Account Determination 由 Work/独立上下文复读。SAP Learning 科目确定、收货和关账课程未锁定 2021，课程间发票方向有冲突。2026-11-27 建立[证据受限草稿](../knowledge/FI/02-functions/inventory-valuation-grir.md)及[Work 角色视角记录](../reviews/work/2026-11-27-m4-workline-4-fi07-review.md)。 | 普通库存采购借贷前提、税务、一般发票处理及自动科目/OBYC 映射仍未闭合；局部案例不得外推为通用分录。文章 drafting；Work 同上下文角色模拟不构成独立审查，未做 SAP 实机测试。 |
| FI-08 | S21 §3.6.1.24–25支持固定 2021 版余额结转状态应用及特定作业：各账户余额（所有币种）结转到新财年；可用 Schedule General Ledger Jobs 安排 Balance Carryforward application job，或按文档所述使用 `FAGLGVTR` 与后台作业；状态应用可显示状态、运行时间等。条目标注 J58、FI-GL、Valid as Of S/4HANA 2021、Functional Localization: Not applicable。2026-11-27 建立[证据受限草稿](../knowledge/FI/02-functions/period-close-reporting.md)及[Work 角色视角记录](../reviews/work/2026-11-27-m4-workline-4-fi08-review.md)。IRS1 仅属美国税务语境，不用于中国规则。 | 完整月结/年结、期间启闭、模拟/过账、地区制度与报表流程需 2021 专题及适用地区证据；目标系统可用性/权限及作业行为未核，无实机操作。文章 drafting；同上下文角色模拟不是独立审查。 |
| FI-09 | S21 §3.6.1.15 直接支持一个 2021 GR/IR 专用条目：`FGRIR_CLEARING`，含菜单路径、分组未清项显示/模拟/真实更新三种模式，以及 Extended Open Item Management 条件下须用该程序的说明。2026-11-27 建立[单项证据受限草稿](../knowledge/FI/03-tcodes/finance-transactions.md)及[Work 角色视角记录](../reviews/work/2026-11-27-m4-workline-4-fi09-review.md)。 | 完整 FI GUI/Fiori 索引、每项版本、输入输出、显示/更新影响、角色权限及目标系统可用性仍须逐项核对；不把整个程序称作只读，无客户系统操作。文章 drafting；同上下文角色模拟不是独立审查。 |
| FI-10 | S21 §3.6.1.16限特定GR/IR扩展未清项字段及启用条件；[SAP《What's New in SAP S/4HANA 2021》](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf) §3.6.1.3（印刷页133–134）说明 Automatic Account Determination app 用于配置 G/L account assignments；范围为 J58、FI-FIO-GL-CA、Available As Of S/4HANA 2021。表中列出 BUL（Ledger-Specific CoCode Clearing）和 BUU（CoCode Clearing Between Differing Amts）新 transaction keys，限 Prepare Intercompany Transactions；另列 `*` 通配符可用于 Integrate with HR Postings 的客户/供应商账号输入。 | 应用公告不是完整配置指南：科目表、账户映射、设置路径、角色/权限及只读入口仍需逐项核验；FI app 变化不能推及 MM OBYC/BSX/WRX。未授权不做系统更改。 |
| FI-11 | SI21 §8.1支持转换中的FI/CO数据模型/兼容视图背景；S21 §3.6.1.26仅讨论特定成本汇总中的ACDOCA/ACDOCD。 | BKPF/ACDOCA主键、字段、基数、发布API和权限尚需逐字段文档或有权系统确认。 |

## CO：逐ID支持范围与缺口

| ID | 已读取证据和能支持的有限范围 | 待补、验证边界 |
| --- | --- | --- |
| CO-01 | GAO2“Managerial cost accounting”支持美国联邦场景下成本信息和管理需求的概念。 | 财务会计与管理会计一般区别、SAP FI/CO具体集成需补更直接资料；不能把联邦制度当企业通用规则。 |
| CO-02 | GAO1第3–4节给政府数据处理成本中心示例；S21 §3.5.1.8针对成本中心预算CDS，§3.5.4.1针对成本要素组应用。 | SAP成本中心主数据、成本要素与总账关系和组织条件尚需2021专题。 |
| CO-03 | [内部订单补查](co03-internal-order-evidence-m3.md)：SAP Learning 的真实/统计订单概念经独立复核但未锁定 2021；2021.001 PDF 限 Central Finance 特定中心结算。 | 普通内部订单 2021 版本下归集、统计及结算条件、权限和完整流程仍待直接依据，不将中央财务场景泛化。 |
| CO-04 | GAO1第4节提供特定美国政府工作职能及成本归集例子；S21 §3.5.5.1和§3.6.1.26分别为特定应用与成本汇总场景。 | 工业生产成本、WIP、差异及结算流程仍需明确的SAP 2021专题，政府数据处理示例不是制造业分录。 |
| CO-05 | GAO2“Responsibility Segments”支持美国联邦责任分部概念；S21 §3.5.6.4支持特定Margin Analysis术语及ACDOCA关联。 | SAP获利分析维度、销售和FI集成及配置、确认时点需要更多2021证据。 |
| CO-06 | S21 §3.5.1.4和§3.5.4.1分别描述特定内部订单和成本要素组应用。 | 这不是完整GUI T-Code索引；逐入口版本、权限和只读性质需核验。 |
| CO-07 | S21 §3.5.1.3列特定跨公司CO过账配置活动及控制范围。 | 其他成本中心/内部订单/结算设置和IMG只读入口缺逐项来源；不能未经授权改配置。 |
| CO-08 | SI21 §8.1财务模型转换；S21 §3.5.6.4中特定获利分析与ACDOCA关联。 | CO对象、字段、主键、基数、兼容视图和API需逐项2021资料，不作未经证实推断。 |

## 课程：逐ID规划依据与缺口

| ID | 原路线或可用证据支持的部分 | 缺口 |
| --- | --- | --- |
| COURSE-01 | R0列出原有24个月五阶段；本次逐月内容为后续规划。 | 原文引用尚未建成；需要中文标题、时长、学习目标、状态与可选练习。 |
| COURSE-02 | R0支持围绕MM/QM建立业务链路；SEC1/SEC2仅支持基础财务概念。 | 采购各流需审核通过的FI-01、MM-01、PROCESS-01正文及SAP 2021来源。 |
| COURSE-03 | R0提出FI/CO与GR/IR学习；SEC1/SEC2、GAO1/GAO2和IRS2/IRS3支持各自有限的非SAP背景，包括复式记账与通常余额方向。 | 财政部 2014 历史大纲可支持其所述一般增减规则的历史描述；现行/地区适用、完整例外和 SAP 财务场景仍缺对应直接证据。引用已审核正文，不使用暂停教材。 |
| COURSE-04 | R0提出MM/QM和GR/IR；S21 §3.6.1.15支持特定清账功能。 | 采购、质量、单位换算和异常依赖各篇SAP 2021证据，不能靠清账章节代替。 |
| COURSE-05 | R0提出跨模块学习，业务流程选题来自项目蓝图。 | 12条主文需建成且准确支持各角色、单据、物流、价值、资金及异常；计划ID不能显示为已通过链接。 |
| COURSE-06 | R0提出CDS、RAP、OData/API和架构；SI21 §8.1仅涉及财务数据模型转换背景。 | 技术课程需引用各技术文章已核实的SAP 2021功能、API、组件及权限证据。 |
| COURSE-07 | R0提出SAP×AI合规实践及职业验证。 | AI原理及评估须引用许可可用的直接来源；SAP接口另核2021，不能保证模型效果或个人就业结果。 |

## 当前结论

共26项：FI 11、CO 8、COURSE 7。**部分借贷基础已有美国政府公开资料直接支持，但完整借贷变动规则、中国适用性、生产成本和各项SAP 2021配置/字段等核心主张仍有证据缺口。** 保留为阻碍并继续研究，不得因已有索引或局部证据就宣布M3通过，也不将公开资料核验伪装成SAP系统实测。


## 独立抽查与修订复验（2026-11-25）

`/root/audit_design_review` 独立抽查 PR #20 原财务台账（blob `1d1b34a90a111df3c6a76665910000427e709dd7`）及相关规划：26 个 ID 无重复。审查者指出 SEC1 相关位置还应列出现金流量表，以及 GAO1 第3–4节的位置应为印刷页19–20而非18–19。协调者依据意见修正本台账，原审查上下文重新读取修改后本地文件确认这两处修正。SEC、GAO、IRS 仅在原记录注明的美国背景和具体范围内使用；审查者未能独立读取大型 SAP 2021 PDF，因此不能将 SAP 具体段落记成其独立验证。其他来源、主张与全部文章并未被本次抽样证明。

本台账的原作者另做 [FI/CO 来源补查](finance-source-recheck-20261125.md)，该报告不是独立验收；其中中国财政部2014历史大纲及2016修订通知只作为研究线索，不是当前规则或 SAP 2021 证据，复用范围待确认。


## M4 FI-11 证据复核（2026-11-27）

本次只复核 FI-11 所需资料，没有加载其他 CO 文章的完整研究材料。

| 来源 | 本次读取与支持范围 | 不能据此断言 |
| --- | --- | --- |
| S1. [SAP Simplification List for SAP S/4HANA 2021](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=200)，Initial Shipment、FPS1/2，§8.1，印刷页 200–201 | 2021 转换语境下 Universal Journal 的报告背景；部分总额/索引表变化；某些 compatibility view 的读取与写入说明。 | BKPF/ACDOCA/BSEG 完整字段、主键、基数、released API、权限；所有 FI/CO 数据都在一个物理表。 |
| S2. [What's New in SAP S/4HANA 2021](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b8102751e57e4de2ad50ec07253127e0.html?version=2021.000)，§3.6.1.26 | 特定 deferred summarization 场景中，明细移至 ACDOCD、汇总后明细留在 ACDOCA。 | 通用 ACDOCA 粒度、主键或跨模块关系。 |
| S3. [SAP Help：Journal Entry Item Cube](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/ee6ff9b281d8448f96b4fe6c89f2bdc8/0ee5e95760521070e10000000a44147b.html) | 当前页面描述 CDS view 的 ACDOCA 数据来源及部分授权前提；只作待查线索。 | 未锁定 2021 On-Premise，不计为目标版依据。 |

复核结果：FI-11 仍为“暂缓核心”。固定版资料不足以支撑逐字段表、主键/基数、released CDS/API 与授权说明。文章只保留高层概念与边界，状态 drafting。SAP 系统未连接，无实机验证。

## M4 CO-01 证据复核（2026-11-27）

本次只处理 CO-01《管理会计从零：成本与利润》，不预载 CO-02～CO-08 的完整研究材料。M3 原 CO-01 行仍是当时的证据快照；以下目标版来源补充其 FI/CO 视角及集成证据，不改写其他 CO 项状态。

| 来源 | 本次读取与支持范围 | 不能据此断言 |
| --- | --- | --- |
| E1. [SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，文档版本9.0（2025-07-23，适用于2021 SP08），§2.5.1.1.1，印刷页23–24；§2.5.2.1.1，印刷页27–28 | General Ledger财务会计用途；Overhead Cost Accounting按成本中心捕捉成本、以activity types描述成本中心产出、统计关键指标可作期末分摊基础；按选定期间报告成本中心等对象的actual与plan；Universal Journal相关报告范围及内外部核算协调。 | 客户实际配置、强制成本中心分配、计划自动生成、具体分摊算法、所有CO活动统一过账、利润分析方案、表/字段/API/CDS、权限或系统验证。 |
| E2. [Simplification List for SAP S/4HANA 2021](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=200)，Initial Shipment、FPS1/2，§8.1，印刷页200–201 | 转换背景下Universal Journal报告数据模型及内外部报告共同document store的高层说明；列出总账、资产会计、Controlling等不同业务活动。 | 把早期转换材料泛化到所有后续2021 SP，或推出每个业务步骤、过账、技术对象和授权完全相同。 |

**CO-01 证据判断：**资料直接支持限缩入门目标：区分FI/CO所问问题、解释成本中心actual/plan报告及报告数据联系。尚未闭合成本对象分配前提、计划维护、统计指标具体分摊规则、内部订单与结算、利润分析定义/配置、底层表字段/API及用户权限。文章对此不作通用断言。SAP系统未连接，无实机验证。

## M4 CO-02｜成本中心与成本要素
日期：2026-11-27（Asia/Shanghai）

- **M3 准入与路径：**“暂缓核心”；ideas/CareerOS/knowledge/CO/02-functions/cost-center-elements.md。本次只建立有证据边界的入门草稿，没有声称关闭核心门槛。
- **E1：**[SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，v9.0，2025-07-23，标记适用于 SP08；§2.5.1.1.1，印刷页 23–24。直接支持按成本中心捕捉成本、成本中心产出与 activity types 相关，以及按选定期间查看 actual/plan。链接为 latest，记录的是实际读取版本快照。
- **E2：**[Migration Objects for SAP S/4HANA 2021](https://help.sap.com/doc/69dd0f1ef0034261ab6e617e0b2beb21/2021.000/en-US/MigrationObjects_OP_EN.pdf)，固定版 2021.000 On-Premise；§1.35，印刷页 153–154：成本中心定义及迁移范围；成本中心属于 controlling area，定义依据可涉及功能、分配标准、地点、成本责任；迁移对象范围含 company-code data 与 validity，且迁移范围内按 company codes 推导 controlling areas。以上只按迁移对象语境支持，不是一般配置规则。
- **E3：**[Central Finance 2021 On-Premise Implementation Guide](https://help.sap.com/doc/a9616f4a29354fc297c58499b754e3f8/2021.001/en-US/loio4857c0540cf5ef05e10000000a4450e5.pdf)，固定版 2021.001；§1.4.1.1，印刷页 15。Central Finance source/target mapping 说明 S/4HANA 目标模型中的成本要素属于 G/L account/chart-of-accounts 关系；并比较两者时间依赖背景。限定为 Central Finance 映射/初始加载语境，不推广为所有流程的字段、分类和配置规格。
- **已支持的学习主张：**成本中心是组织责任／成本发生观察维度；成本要素的 S/4HANA 账户关系可在 E3 指定映射语境内说明；2021 功能范围支持成本中心实际/计划报告。
- **仍缺直接证据：**成本中心字段级有效期和更改规则、公司代码与 controlling area 一般配置约束、成本要素类别与规则、日常费用分配和自动派生、完整 FI/CO 凭证行为、数据字段/键/API/CDS/权限。
- Migration Objects 中的 secondary cost element 与 G/L/primary cost element 条目是源 ERP 到 S/4 的迁移对象说明，不据其名称推断目标 S/4 使用独立旧式 master data。
- 不涉及普通库存采购完整借贷、税务和自动科目决定（FI-07 仍开放）。SAP 未连接，未做实机验证。
- 审查记录：[CO-02 三角色视角闭环](../reviews/work/2026-11-27-m4-co02-three-role-review.md)。各角色 5 个同上下文模拟闭环；不是独立审查，不计正式 reviewed。


## M4 FI-10 来源复核与文章状态（2026-11-27）

本次对 FI-10 做目标文章级核对；本节为 M4 补记，不改写上表 M3 计划快照。

| 资料 | 直接支持的主张 | 不支持的推论 |
| --- | --- | --- |
| [SAP《What's New in SAP S/4HANA 2021》§3.6.1.3](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf)，印刷页 133–134 | Automatic Account Determination app 可配置 G/L account assignments；条目标 J58、FI-FIO-GL-CA、Available As Of S/4HANA 2021。BUL/BUU 两个新增 transaction keys 限 Prepare Intercompany Transactions；星号通配符仅在 Integrate with HR Postings 输入 customer/supplier account 的说明中出现。 | 完整映射、全部过账规则、通用 IMG 路径、只读模式、角色授权和客户系统可用性。不得外推到 MM 的 OBYC/BSX/WRX。 |
| [SAP Help Portal，Open Item Management in the Manage G/L Account Master Data App，固定版本 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/95c14c3ac4884b8ba46b7da9738fd391.html?locale=en-US&state=PRODUCTION&version=2021.000)，§3.6.1.16 | Extended Open Item Management 字段表示相关 GR/IR 总账科目是否启用该功能；文档也指向相关 SAP GUI 事务 Display G/L Account Centrally（FS00），并说相应功能启用后该字段为 display only。XLGCLR 对应的是另一个 Open Item Management by Ledger Group 字段。 | 具体账号的角色授权、客户系统是否启用、全页面只读属性、该扩展字段的表/键/API 或启用步骤。本文不提供也不建议执行启用步骤。 |

已建立[证据受限草稿](../knowledge/FI/04-configuration/finance-config-observation.md)和[Work/独立 AI 角色视角记录](../reviews/work/2026-11-27-m4-workline-4-fi10-review.md)。初稿阶段有 15 个同上下文模拟闭环；随后普通学习者、配置顾问、开发者三个独立 AI 子代理上下文各完成 5 个问题—证据答复—修订—原角色复验循环，共 15 个独立上下文闭环。不是真人专家签核，模型 ID 未显示。尽管复核问题均闭合，核心配置证据仍未闭合，FI-10 继续 `drafting`，不计 formal reviewed。

补证尝试：SAP Help 的 Manage Posting Periods 页面未能通过本次工具打开固定 `version=2021.000` 页面；可见的未锁版页面不作为 S/4HANA 2021 直接证据。公司代码、科目表、期间、收付款配置、完整账户映射、配置路径和只读/写入授权仍是开放项。SAP 系统未连接，无实机验证。

### M4 Workline 5｜CO-03 内部订单（2026-11-27）

- [文章](../knowledge/CO/02-functions/internal-orders.md) 与 [三角色视角记录](../reviews/work/2026-11-27-m4-co03-three-role-review.md) 已建立。记录来自同一 Work 上下文的读者、配置顾问、开发者视角模拟各 5 轮；不代表独立审核者，不计入 8/50 reviewed。文章状态仍为 drafting。
- SAP S/4HANA 2021 FSD v9.0 / SP08 §2.5.1.1.1（印刷页23–24）支持 internal orders 属于成本核算主数据、按选定期间报告计划/实际；latest URL 的版本快照不外推至全部 2021 FPS。
- SAP S/4HANA 2021.002 Migration Objects §1.40（印刷页172–174）在迁移对象语境定义内部订单的监控成本用途；不将迁移规则或授权扩为日常业务事实。
- SAP Learning 的真实/统计订单与结算课程未标发行版，仅用于概念说明和检索线索；不作为 2021 通用规则。2021.001 Central Finance §1.4.7.2 只支持其中央结算状态检查场景。
- 未闭合：普通 2021 订单类型/真实统计处理、成本归集细则、预算检查触发、结算配置和接收方、权限、表/字段/API/CDS；没有 SAP 系统或客户配置验证。未推导 FI-07 普通库存借贷、税或自动科目。

## M4 CO-04 证据范围与草稿记录（2026-11-27）

- [文章](../knowledge/CO/02-functions/product-cost-variance-settlement.md)：状态 drafting。按 M3“暂缓核心”建立受限草稿，不声称完整制造成本流程已证实。
- **E1**：[SAP S/4HANA 2021 FSD](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，本次读到 v9.0（2025-07-23）/ SP08 快照，latest URL 动态。§2.6.1.1.2（印刷页28–29）支持不同制造方式关注销售订单、生产/流程订单或期间成本；§2.8.4.1（页75）描述生产订单实际成本可结算到一个或多个接收成本对象；§2.8.4.3（页79–82）支持重复制造按期间由产品成本收集器收集成本及偏差汇总；§2.8.4.4（页83–85）是特定 Kanban 场景的实际成本更新及期间 WIP/差异/结算功能。仅作 FSD 所列范围，不外推到每种制造方式、客户配置或 2021 全部 FPS。
- **E2**：[Deferred Summarization of Production Costs](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b8102751e57e4de2ad50ec07253127e0.html?version=2021.000)，固定 S/4HANA 2021.000 条目 §3.6.1.26，印刷页159：特定延期汇总功能说明 journal entry details 从 ACDOCA 移到 ACDOCD、汇总细节保留于 ACDOCA。它不是 WIP/variance 算法或完整 CO 数据模型证明。
- 读者、配置顾问、开发人员各 5 个同一 Work 上下文的模拟闭环；见 [CO-04 视角记录](../reviews/work/2026-11-27-m4-co04-three-role-review.md)。无独立复核，不计 reviewed；无 SAP 实机测试。
- 未闭合：常规制造订单的 WIP/variance 公式、订单状态触发和结算规则/接收方、估价和 FI 分录条件、权限、T-Code、数据字段/键/API/CDS。未据此推出 FI-07 普通采购库存借贷、税或自动科目。
## M4 CO-05 证据补查与草稿状态（2026-11-27）

本次只处理 CO-05《获利分析与 FI 集成》，未预载后续 CO-06～CO-08 的完整研究资料。文章：`knowledge/CO/02-functions/profitability-fi.md`；三角色视角记录：`reviews/work/2026-11-27-m4-co05-three-role-review.md`。按 M3“限缩可写”路径建立 drafting 草稿。

| 来源 | 本次直接支持的范围 | 不能据此断言 |
| --- | --- | --- |
| E1. [SAP S/4HANA 2021 Feature Scope Description（On-Premise）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，直接打开的 latest 文档版本11.0（2026-07-22，SP10）。§2.6.1.1.3（印刷页29–30）、§2.6.1.1.4（页30）、§2.6.2.1.1（页31–32）、§2.6.2.1.3（页34–35）、§2.6.4.2.1（页46–47）。搜索索引也返回过旧 v9.0/SP08 快照；URL 动态，版本范围需明确。 | v11.0/SP10 直接支持市场细分（产品、产品组、客户、客户组、销售组织）、收入/销售成本、成本中心间接费用的定期分配；预测会计早于实际财务日记账；Revenue Accounting and Reporting 的合同/履约义务/履约事件；特定项目 Event-Based Revenue Recognition；应收销售/物流触发、总账同步及来款清账。 | 所有销售的统一收入确认时点、客户系统 FPS、完整销售单据链、客户合同/配置、成本估值/贡献毛利通用公式、市场属性派生和分配算法。 |
| E2. [Simplification List for SAP S/4HANA 2021，Initial Shipment、FPS 1 & 2](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)，v1.25（2022-05-25）；§8.1（印刷页200–201）、§12.13（页307–308）。 | 稳定的 S/4HANA On-Premise 2021 初始版/FPS1/2 文件：统一文档存储的转换语境；Margin Analysis 与 costing-based CO-PA 区别；在 §12.13 的 Margin Analysis 语境中，收入开票时点、COGS 交货时点、延迟开票时成本先显示的可能性；收入和销售扣减条件映射到账户并生成 FI 过账的范围。 | 不代表后续 FPS/客户设置；不等于所有合同的收入会计政策，也不支持未列配置的 price condition、估值、完整 COGS 科目规则。 |
| E3. [What’s New in SAP S/4HANA 2021](https://help.sap.com/doc/4eefc5f2d826408f91a999687d31780f/2021/en-US/WN_OP2021__EN.pdf)，§3.5.6.4，印刷页122。 | Margin Analysis 术语以及 account-based / ACDOCA 窄范围描述。 | 客户启用状态、CO-PA 全部持久化方式、字段/主键/API/权限。 |
| E4. [New App “Manage COGS Splits”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f2bb8fe1f6c046a7a00797ddc02149f6.html?locale=en-US&state=PRODUCTION&version=2021.000)，固定版2021.000。 | 一个需相应 Customizing 的 COGS 成本组件拆分场景及其分析应用。 | 普通采购库存完整借贷、税、自动科目或所有客户销售的统一规则。 |

CO-05 文章将收入确认、获利分析和应收收款/清账分别解释；用 F2 的开票/交货时点限缩说明 Margin Analysis，再与 FSD 中 Revenue Accounting and Reporting 和 Event-Based Revenue Recognition 的适用范围分开。COGS split 被限定为 S/4HANA 2021.000 的特定可配置功能，未推导 FI-07 普通库存分录。普通销售其他确认场景、客户估值/属性配置、字段/API/权限仍未闭合。

普通读者、配置顾问、开发人员各 5 个同一 Work 上下文角色视角模拟闭环，共 15；不是独立评审，不计 8/50 reviewed。SAP 系统未连接，无实机、凭证、配置或权限测试。状态保持 drafting。