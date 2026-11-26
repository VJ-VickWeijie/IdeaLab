# PP-03｜工作中心与工艺路线 Routing：准入与三角色视角工作记录

- 日期：2026-11-27（Asia/Shanghai）
- 工作包：CareerOS M4 批次 A，工作线 2
- 文章路径：ideas/CareerOS/knowledge/PP/01-foundations/work-center-routing.md
- 当前状态：drafting
- 角色视角闭环：普通读者 5/5、资深 SAP 配置顾问 5/5、普通 SAP 开发人员 5/5，共 15 个完成问题、证据答复、修订判断/修改和原视角复核的循环。
- 执行上下文：同一 Work 上下文内角色视角模拟；没有真人专家或独立 Agent。模型身份未在本环境显示。
- SAP 系统：未连接；实机验证为 0。

## 1. M3 准入和实际范围

M3 逐篇分流将 PP-03 标为“限缩可写”，路径为 knowledge/PP/01-foundations/work-center-routing.md。逐篇范围要求覆盖工作中心能力、Routing/operations、替代/有效期及 BOM 关系；需要固定版 2021 直接资料解释工作中心完整定义、工序选择和成本/产能参数。M3 来源贴合度记录仅把 FSD §2.8.2.2 的 Routing/Recipe 高层概述列为直接部分支持，明确字段、有效期、产能/成本与选择条件未闭合。

本次已检查 M3 控制矩阵文件，但当前文件没有 PP-03 行；因此文章范围来自逐篇准入分流、detail-logistics、evidence-logistics-m3 与 sd-pp-source-fit-m3，不从控制矩阵缺行处补造产品规则。按本线要求只读取 PP-01、PP-02 两篇关联文章；未读取 PP-04 及更后文章。

## 2. 固定版来源与边界

| Ref | SAP 来源 | 直接支持 | 不支持 |
| --- | --- | --- | --- |
| R1 | SAP Help, “Manage Routings”, S/4HANA 2021 (Oct 2021), version 2021.000, Scope Item BJ5。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/9a63a564ff1c4194843dec4c37dfb033.html?locale=en-US&version=2021.000 | 在 BJ5 离散MTS范围内搜索现有 Routing，并导航到创建/更改应用。 | 完整 Routing 结构、所有用户权限、只读访问或所有 PP 场景适用。 |
| R2 | SAP Help, “OData API: Work Center”, S/4HANA 2021 (Oct 2021), version 2021.000, Scope Item BJ8。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f7e7144c65a647c3a68d84db06bc54c4.html?locale=en-US&version=2021.000 | 特定 OData V4 服务支持 create/read/update；条目列出 header、description、cost center allocation、pooled capacity、capacity header/description/intervals/shifts 等实体类别。 | 通用工作中心定义、完整字段合同、产能公式、成本过账、客户启用与授权。 |
| R3 | SAP Help, “OData API: Production Routing”, S/4HANA 2021 (Oct 2021), version 2021.000, Scope Item 3W4。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/470053ffc09249bea07e09bd113d0cf9.html?locale=en-US&state=PRODUCTION&version=2021.000 | 3W4 场景 operation 所需 PRT 的读取能力和条目列出的资源类别。 | 完整 Routing API、其它场景、所有 operation 字段或授权。 |
| R4 | SAP Help, “Manage Shop Floor Routings”, S/4HANA 2021，PEO-specific。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/7cb8c2893d224d0bbe47c4102d136a12.html?locale=en-US&state=PRODUCTION&version=2021.000 | PEO shop-floor routing 版本/header/effectivity 的专门范围。 | 经典 PP routing 的通用模型。 |
| R5 | SAP, PEO-ERP Implementation Guide for SAP S/4HANA 2021，PEO 专用章节 PDF 第 94 页附近。https://help.sap.com/doc/1fc98f1186c147679a500745f95fd327/2021/en-US/S4HANA_PEO_Implementation_Guide.pdf | PEO shop-floor routing 的 operation/operation activity 关系、同一 work center 活动分组的限定描述。 | 所有标准 routing 的顺序、字段、产能公式、BOM 选版或客户实现。 |
| 排除来源 | M3 登记的 FSD_OP2021_latest.pdf（动态 URL，§2.8.2.2）。 | 仅作为 M3 高层范围的定位线索。 | 本次不把该动态快照作为固定版 2021 证据。 |

## 3. 三角色闭环

每轮记录问题、证据、Work 答复、实际修订位置、原视角复核、执行上下文和日期。日期记录到日，具体分次时刻未单独保存。所有轮次是同一 Work 上下文角色模拟，不代表独立审查。

### 普通读者

#### PP03-01｜第 1 轮
- article_id：PP-03；role：普通读者；round：1
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：PP-02 已解释产品由什么组成，本篇读者可能不明白 Routing 又补充了什么。
- evidence：M3 将 PP-02 与 PP-03 分作 BOM 结构和 Routing/工序主题；固定版来源中可直接查看的 Manage Routings 页面只支持搜索和导航动作。
- work_response：开篇改成两个学习问题并明确 PP-03 只按固定版证据介绍 Routing 对象入口。
- change_ref：“本篇要学什么”及“离散制造场景中的 Routing 应用入口”。
- recheck：原角色视角复核，复核后能区分两篇学习问题，未把加工顺序作为已证事实。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-02｜第 2 轮
- article_id：PP-03；role：普通读者；round：2
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：operation、operation activity 和 work center 这些词是否可以当成每种工艺路线都会有的三级结构？
- evidence：2021 PEO 指南才明确 shop-floor routing、operation、operation activity 的关系，不能推及经典 PP routing。
- work_response：将这一层级限定为 PEO 专用示例，正文表格再次标注适用边界。
- change_ref：“PEO 专用的 shop-floor routing 示例”和边界表。
- recheck：原角色视角复核，复核后不会把 PEO 层级泛化为所有 Routing。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-03｜第 3 轮
- article_id：PP-03；role：普通读者；round：3
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：如果 SAP 页面有 Manage Routings，是否能认为每个用户都可以只读查看？
- evidence：BJ5 页面显示可搜索并导航到创建/更改应用；没有证明只读授权或客户用户拥有权限。
- work_response：明确这是特定范围的导航信息而非只读入口，并列出实际权限未知。
- change_ref：“离散制造场景中的 Routing 应用入口”和来源条目1。
- recheck：原角色视角复核，复核后读者不会把导航应用误认为只读查看承诺。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-04｜第 4 轮
- article_id：PP-03；role：普通读者；round：4
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：可否给一个简单 Routing 案例，说明产品如何从工序一走到工序二？
- evidence：固定 Manage Routings 页面未定义工序顺序；PEO 来源只直接支持 operation/activity 结构，没有通用顺序规则。
- work_response：不写标准 PP 工序流程；离线练习只识别页面明确对象与 PEO 层级。
- change_ref：“离线练习”第2-4步。
- recheck：原角色视角复核，复核后练习能做，但不包含未经证实的工序顺序。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-05｜第 5 轮
- article_id：PP-03；role：普通读者；round：5
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：这篇没有公式和案例会不会没帮助？
- evidence：M3 的核心用法/产能/成本待补；当前固定来源不足以算工时或产能。
- work_response：明确目标核心缺口，并给离线问题分类任务，不制作虚构公式。
- change_ref：“暂不写成 2021 通用规则”及练习。
- recheck：原角色视角复核，复核后稿件诚实说明未完成范围，没有猜数字。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

### 资深 SAP 配置顾问

#### PP03-06｜第 1 轮
- article_id：PP-03；role：资深 SAP 配置顾问；round：1
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：BJ5、BJ8、3W4 是三个不同场景，能否把它们统一叫成全体 PP 的 Routing 能力？
- evidence：2021 Manage Routings 标BJ5离散MTS；Work Center API标BJ8流程MTS；Production Routing OData API标3W4第三方车间执行。
- work_response：把三来源分开列明 Scope Item，不以任何一个作为其它场景覆盖证明。
- change_ref：三段固定版资料与边界表前三行。
- recheck：原角色视角复核，复核后各结论仍绑定各自 Scope Item。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-07｜第 2 轮
- article_id：PP-03；role：资深 SAP 配置顾问；round：2
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：Routing 使用哪些工序、替代与有效日期规则？
- evidence：M3 限缩范围指出工序选择、替代/有效期未核；已读 2021 固定应用页没有这些规则。
- work_response：暂不写具体操作顺序、选择算法或版本有效期，留待定向证据。
- change_ref：“暂不写成 2021 通用规则”第一和第三项。
- recheck：原角色视角复核，复核后缺口清楚可追踪，没有从功能标题补规则。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-08｜第 3 轮
- article_id：PP-03；role：资深 SAP 配置顾问；round：3
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：PEO guide 提供丰富的 routing 内容，可否借来定义普通 S/4HANA routing？
- evidence：2021 guide 的章节语境是 PEO ERP integration 与 shop-floor routing；其中 Operation Activity 是专用执行细节。
- work_response：只作为产品内特殊实现例子，显式写明不推广到标准 PP routing。
- change_ref：PEO 专用示例和来源表第5项。
- recheck：原角色视角复核，复核后 PEO 和经典 Routing 没有混写。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-09｜第 4 轮
- article_id：PP-03；role：资深 SAP 配置顾问；round：4
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：Work Center API 列了 cost center allocation 和 capacities，可否据此说明成本中心自动收到工序成本？
- evidence：API entity 名称仅证明服务数据类别；没有过账/分摊机制、成本中心计算或配置依据。
- work_response：不写成本流向或分配公式，将成本归集与结算列为未核。
- change_ref：Work Center 段、边界表及未写规则第四项。
- recheck：原角色视角复核，复核后没有把 entity 名称误当成本过账逻辑。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-10｜第 5 轮
- article_id：PP-03；role：资深 SAP 配置顾问；round：5
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：Routing 与 BOM、生产版本之间的选择/有效关系如何表达？
- evidence：M3 只将这些对象列作 PP-03/PP-02 关系；标准通用选择规则未由当前固定版资料闭合。
- work_response：仅记录课程关联，拒绝写普遍生产版本选择；状态保持 drafting。
- change_ref：边界表“BOM 与 Routing 的选择关系”和状态栏。
- recheck：原角色视角复核，复核后不把 PEO 特定关系扩为通则。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

### 普通 SAP 开发人员

#### PP03-11｜第 1 轮
- article_id：PP-03；role：普通 SAP 开发人员；round：1
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：能否以常见表如 PLKO/PLPO/CRHD 建立一张数据模型表？
- evidence：本轮固定版证据为What's New、API范围和PEO guide片段，没有该目标范围的完整 released data model。
- work_response：不列物理表、字段键或关联基数，把数据模型单独列为待核。
- change_ref：“暂不写成 2021 通用规则”第五项。
- recheck：原角色视角复核，复核后没有无来源的数据表清单。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-12｜第 2 轮
- article_id：PP-03；role：普通 SAP 开发人员；round：2
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：Work Center OData API 的 create/read/update 能否直接说成通用可调用公共接口？
- evidence：2021.000 页面只列该服务、BJ8范围和实体类别；不包含所有系统启用、发布访问和用户授权证据。
- work_response：仅按页面描述特定服务能力，说明不是通用接口或只读权限证明。
- change_ref：Work Center 段和来源条目2。
- recheck：原角色视角复核，复核后接口结论未越过版本/Scope Item边界。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-13｜第 3 轮
- article_id：PP-03；role：普通 SAP 开发人员；round：3
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：PRT OData API提到operation，是否能推断完整的生产Routing接口合同和所有字段？
- evidence：2021条目只说3W4场景下可以读取 operation 的四类 PRT；不等于完整Routing实体或通用API。
- work_response：限定为PRT读操作与条目列出的资源类型，不列字段或接口调用示例。
- change_ref：“Routing operation一词”段与来源条目3。
- recheck：原角色视角复核，复核后接口支持的主张精确且不泛化。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-14｜第 4 轮
- article_id：PP-03；role：普通 SAP 开发人员；round：4
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：Manage Routings 应用能导航到创建/更改，是否可在练习中指导用户执行创建？
- evidence：固定版页面仅说明导航能力，不证明授权、客户配置、字段规则或无风险操作。
- work_response：只记录入口能力；纸笔练习不指导登录或创建/更改。
- change_ref：“离线练习”及应用入口段。
- recheck：原角色视角复核，复核后没有可执行变更说明，也无只读承诺。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

#### PP03-15｜第 5 轮
- article_id：PP-03；role：普通 SAP 开发人员；round：5
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：固定版 PEO PDF 给出操作活动，是否等于系统测试过 Routing 版本/实际配置？
- evidence：2021 guide 是官方产品说明；目标 SAP 系统未连接，文档读取不能证明客户实施状态。
- work_response：在文末和状态栏记录没有实机测试，所有客户配置/实际授权未知。
- change_ref：开头状态、文末实机声明。
- recheck：原角色视角复核，复核后没有声称运行系统、验证权限或测试。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；无真人专家或独立 Agent；模型身份未显示。

## 4. 状态与后续证据门槛

- 已记录普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个同上下文问题—答复—修订—复核闭环，共 15。
- 这些循环不构成独立 review；不能据此将 PP-03 标记为 reviewed。
- 固定版 2021 证据只支持特定 Scope Item 的 Routing 搜索/导航、Work Center API 数据类别、operation PRT 读取，以及 PEO 专用路线模型。核心通用解释仍缺：普通 PP routing operation 顺序和选择；routing/work center 完整字段及映射；替代/有效期与 BOM/生产版本关系；产能/成本公式和参数。
- 文中没有写未经证实的 T-Code、IMG 完整路径、物理表、字段键、接口授权、客户配置或生产系统结果。
- 当前状态：drafting；批次 A reviewed 和 owner accepted 数量不变。
- 下一篇：PP-04《需求、MRP 与计划订单》，路径 knowledge/PP/02-functions/mrp-planned-order.md；应先只读取 PP-04 对应控制/准入/来源及关联文章。
- 批次 A 仍为 8/50 reviewed、0/50 owner accepted；CareerOS owner accepted 仍为 3/99；SAP 实机验证为 0。
