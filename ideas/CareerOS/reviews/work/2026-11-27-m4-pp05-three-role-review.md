# PP-05｜生产订单与确认：Work 角色视角审查记录

- 日期：2026-11-27（Asia/Shanghai；仅记录日期，未保留每轮具体时分）
- 工作包：CareerOS M4 批次 A，工作线 2
- 文章路径：ideas/CareerOS/knowledge/PP/02-functions/production-order.md
- 本文状态：drafting
- 角色视角闭环：普通读者 5/5、资深 SAP 配置顾问 5/5、普通 SAP 开发人员 5/5，共 15/15。
- 独立性：同一 Work 上下文角色视角模拟；不是独立审查者、真人 SAP 专家或独立 Agent。闭环不计正式独立 review。
- 系统状态：SAP 未连接；未执行生产订单、确认/API、配置或权限实测。

## 1. M3 范围及本轮材料

M3 逐篇准入分流将 PP-05《生产订单与确认》标为“限缩可写”，路径为 knowledge/PP/02-functions/production-order.md。范围要求讨论计划订单转换、生产订单状态、释放、报工、撤销、缺料/未下达，但来源登记及 source-fit 明确指出：订单状态、下达、撤销条件和配置未被现有证据完整证明。计划要求区分动作事件及库存/成本影响前提。

当前控制矩阵没有 PP-05 独立行，故范围来自准入分流、detail-logistics、evidence-logistics 与 SD/PP source-fit；不从矩阵缺行补造产品规则。仅读取 PP-03、PP-04 为关联文章；PROCESS-05《计划到生产》在当前分支不存在，未读取或引用其正文。

## 2. 来源索引

| Ref | 来源 | 本轮可支持 | 边界 |
| --- | --- | --- | --- |
| R1 | SAP S/4HANA 2021 Feature Scope Description，动态 URL：https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf。直接 PDF 显示文档版本 11.0（2026-07-22，SPS10）；§2.8.3.1 PDF pp.70–71、§2.8.4.1 p.75、§2.8.4.2 pp.76–77。 | SPS10 概述离散制造厂内生产计划订单转换；区分技术完成与关闭、列出 TECO 的部分后果和结算接收方示例；称确认可触发订单更新、组件反冲、收货和成本更新等示例，另称确认可取消/部分取消，并列出货物移动可重处理。 | 动态 `latest` URL 的较早 SAP 官方索引曾显示 v9.0/SPS08，本轮直接 PDF 为 v11.0/SPS10；无本地 PDF 哈希归档。不能据此推出固定 2021.000 初版内容、完整状态集/条件、逐次确认必然触发、撤销后关联物料凭证规则、客户设置或 FI/CO 金额。 |
| R2 | SAP Help, “OData API: Production Order Confirmation”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b66174fc3f68458fb1dab04a09d5d95c.html?version=2021.000 | SAP 官方检索索引摘要说明确认 API 与创建确认前数量、工作活动、日期/时间、人员和货物移动提议数据；列出特定批次特性扩展。 | 规范 HTML direct open 为 0 可读行；不提供完整状态/撤销规则、完整字段合同、客户启用/授权或执行结果。 |
| R3 | SAP Help, “Manage Production Orders”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/de8ebc2f3e0f40a484585f91d4380ee3.html?locale=en-US&state=PRODUCTION&version=2021.000 | SAP 官方检索索引摘要列出 BJ5 应用的部分订单信息/操作增强。 | 规范 HTML direct open 为 0 可读行；不是所有订单状态、释放条件或客户角色权限矩阵。 |
| R4 | SAP Help, “Production Order Object Page”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/1813394db23d45aca434092495c4feae.html?version=2021.000 | SAP 官方检索索引摘要说明对象页可显示已记录货物移动，并按角色导航到相关应用。 | 规范 HTML direct open 为 0 可读行；不证明系统启用、角色映射或每个确认的库存后果。 |
| R5 | SAP Help, “Tightened Authorization Checks for Documents in Production Order Release”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/ca2d6c36965743a69e1871d3404718fb.html?version=2021.000 | SAP 官方检索索引摘要说明自动附加文档时的特定授权检查；无权限时释放可以被拒绝。 | 规范 HTML direct open 为 0 可读行；不是生产订单通用释放配置、完整授权对象或状态迁移说明。 |

本文对 R1 仅按动态 S/4HANA 2021 SPS10 v11.0 快照说明，不称为固定 2021.000 证据。R2–R5 的版本标签锁定 2021.000/BJ5，但本轮仅从 SAP 官方检索索引摘要核对其窄范围；生产确认 API、Manage Production Orders、Production Order Object Page 与 release 授权页面规范 HTML direct open 均返回 0 行可读正文。正文不声称通读这些页面完整内容。

### 补查但未用于目标版规则的资料

- SAP Help，[Entering Confirmations](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/34de0103497c4b80a7c7fbf6952ff971/fe03b753128eb44ce10000000a174cb4.html)：当前检索结果标为 2025 FPS01；本轮无法取得可读的 2021.000 版本正文。
- SAP Help，[Goods Movements for Confirmation](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/34de0103497c4b80a7c7fbf6952ff971/1604b753128eb44ce10000000a174cb4.html)：当前检索结果标为 2025 FPS01；不用于推导 S/4HANA 2021 触发条件。
- SAP Help，[Cancel Confirmation](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/a6f0333202384ba2b48a841a4a6deb1b/5cdf2067f4a2498d953d9e7a1242f291.html?locale=en-US)：检索结果标为 2025 FPS02；不用于补写固定 2021 撤销合同。
- SAP Help 的[通用 Canceling Confirmations](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/34de0103497c4b80a7c7fbf6952ff971/3a04b753128eb44ce10000000a174cb4.html)搜索结果未显示固定 2021 版本标签；`version=2021.000` 规范页面直开不可访问，故不当作目标版证据。

## 3. 三角色问题—答复—修订—复核

每项的 recheck 均为同一上下文内的角色视角模拟复核；status closed-in-perspective 不是独立审查通过。

### 普通读者

#### PP05-R-01
- article_id：PP-05；role：普通读者；round：1；timestamp：2026-11-27（仅日期）
- question：计划订单和生产订单是不是同一张单据，只是名称不同？
- evidence：R1 对离散制造描述自制计划订单可转换为生产订单；M3 范围也将转换作为独立事件。
- work_response：正文开头把计划提议与生产执行对象分开，限定为 FSD SPS10 的离散制造例子。
- change_ref：正文“生产订单与计划订单不是一回事”。
- recheck：原读者视角复核后，能识别对象边界，不把转换说成每种制造均适用。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-R-02
- article_id：PP-05；role：普通读者；round：2；timestamp：2026-11-27（仅日期）
- question：订单建立后是否就一定可以开工？
- evidence：R5 确认目标版有释放处理和一种附加文档授权失败条件，但不提供全部释放前提或完整状态迁移。
- work_response：将“订单已创建”与“获准执行”分开，只说需核对释放，不列通用状态码/转换表。
- change_ref：对象表“释放”行及对应边界说明。
- recheck：原读者视角复核后，文章没有暗示创建后自动可执行。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-R-03
- article_id：PP-05；role：普通读者；round：3；timestamp：2026-11-27（仅日期）
- question：确认一次报工是不是就等于产品已经入库？
- evidence：R2 将确认相关提议数据与货物移动提议数据分别列出；R1 分列领料、工时确认和完工收货事项。
- work_response：把确认与货物移动拆成独立记录类别，说明现有来源不足以证明必然联动。
- change_ref：对象表“生产确认”“货物移动”行及“不能把报工当成通用开关”。
- recheck：原读者视角复核后，能够解释确认不等同已完成收货。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-R-04
- article_id：PP-05；role：普通读者；round：4；timestamp：2026-11-27（仅日期）
- question：文章为什么不直接教怎么撤销确认、退回上一步？
- evidence：M3 PP-05 source-fit 明确撤销条件未被完整证明；R2 提供确认 API 范围但没有本篇所需的撤销合同。
- work_response：不提供未经目标版证实的撤销步骤，把回退和撤销列入核心待补事项。
- change_ref：待补核心规则第三、四项。
- recheck：原读者视角复核后，未将操作危险性较高的撤销做成猜测指引。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-R-05
- article_id：PP-05；role：普通读者；round：5；timestamp：2026-11-27（仅日期）
- question：离线练习里的“订单释放”和“确认”是否是真实已验证步骤？
- evidence：练习没有客户系统连接；R3–R5 是产品说明，不证明本地系统启用/权限。
- work_response：将练习改为标注候选事件与要核查的问题，不让读者登录或提交操作；注明无系统验证。
- change_ref：正文“离线学习练习”五步和结尾系统声明。
- recheck：原读者视角复核后，练习是纸面分析，不会被误读为实机操作指导。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

### 资深 SAP 配置顾问

#### PP05-C-01
- article_id：PP-05；role：资深 SAP 配置顾问；round：1；timestamp：2026-11-27（仅日期）
- question：能否列出 CRTD、REL、PCNF、CNF、TECO 等状态及所有合法转换？
- evidence：R3 只列管理应用的有限增强；R5 仅有释放中特定文档授权检查；M3 明示目标状态全集未闭合。
- work_response：不列状态码和顺序，将状态全集与条件留作明确待核项。
- change_ref：开篇状态原因及待补核心第一项。
- recheck：原顾问视角复核后，没有从常见术语推导 2021 全状态模型。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-C-02
- article_id：PP-05；role：资深 SAP 配置顾问；round：2；timestamp：2026-11-27（仅日期）
- question：R5 提到自动加文档的授权路径，是否能据此写出全部订单释放路径、配置节点和角色？
- evidence：R5 仅覆盖 BJ5 中自动附加文档时的对象授权检查，并提及特定配置前提；没有完整释放矩阵。
- work_response：正文只写受限授权结论，不把单一文档场景推广为完整 release procedure。
- change_ref：R5 来源说明和对象表“释放”行。
- recheck：原顾问视角复核后，客户定制及角色权限没有被泛化。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-C-03
- article_id：PP-05；role：资深 SAP 配置顾问；round：3；timestamp：2026-11-27（仅日期）
- question：部分确认、最终确认、剩余数量和撤销确认如何影响订单状态？
- evidence：R2 说明 BJ5 确认 API 提议信息范围，但未闭合确认类型/状态和回退规则；M3 仍把撤销条件列为缺口。
- work_response：不写部分/最终确认或撤销行为，作为本篇核心待补事项保留。
- change_ref：待补核心第三、四项。
- recheck：原顾问视角复核后，正文没有把 API 提议字段当成确认状态合同。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-C-04
- article_id：PP-05；role：资深 SAP 配置顾问；round：4；timestamp：2026-11-27（仅日期）
- question：能否把 BJ5 production order、BJ8 process order 以及 PEO shop-floor order 的状态和流程合并讲成通用生产订单？
- evidence：R2、R3 和 R5 明确涉及 BJ5；R1 的动态高层资料涵盖不同制造模式，但不提供统一状态表。
- work_response：固定版细节只限定 BJ5 离散制造；不把 process order 或 PEO 专属对象混入状态规则。
- change_ref：R2–R5 来源表的 BJ5 场景标签及待补范围。
- recheck：原顾问视角复核后，场景边界可见，状态规则未跨场景挪用。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-C-05
- article_id：PP-05；role：资深 SAP 配置顾问；round：5；timestamp：2026-11-27（仅日期）
- question：技术完成与 settlement 是否同一事件？可以列结算对象或分录吗？
- evidence：R1 SPS10 FSD 将技术完成和结算分开提及，但本篇没有成本计算/收件方规则的独立证据；M3 把财务/成本列给 PP-06/CO-04。
- work_response：表格分开写两类后续管理动作，不列结算会计或金额，明确转 PP-06/CO-04 逐项取证。
- change_ref：对象表“技术完成/结算”行及待补核心第五项。
- recheck：原顾问视角复核后，没有把结算写成释放或确认的必然后果。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

### 普通 SAP 开发人员

#### PP05-D-01
- article_id：PP-05；role：普通 SAP 开发人员；round：1；timestamp：2026-11-27（仅日期）
- question：Production Order Confirmation API 的 proposal 能力是否可以代表完整请求/响应字段及过账行为？
- evidence：R2 仅列提议类别、批次特性扩展及 API 增强；没有完整 service schema 或客户 $metadata。
- work_response：正文只列资料明示的数据类别，不写字段/键、调用样例或过账副作用。
- change_ref：对象表“生产确认”行、来源 R2 边界、待补第五项。
- recheck：原开发者视角复核后，API 能力未被扩成完整接口合同。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-D-02
- article_id：PP-05；role：普通 SAP 开发人员；round：2；timestamp：2026-11-27（仅日期）
- question：是否可根据确认 API 名称写底层表、主键、确认记录基数或 released CDS？
- evidence：R2 是 What's New API 功能页，不覆盖数据库模型或完整 released data model；M3 PP-09 也把关联模型列作待核。
- work_response：不列物理表、键、关联基数或未证 API 状态。
- change_ref：待补核心第五项。
- recheck：原开发者视角复核后，本文没有猜测技术对象映射。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-D-03
- article_id：PP-05；role：普通 SAP 开发人员；round：3；timestamp：2026-11-27（仅日期）
- question：Production Order Object Page 能显示 documented goods movements，是否说明每个用户都能读到，或能从中推出 MIGO/API 写入权限？
- evidence：R4 明确导航以用户角色为条件；它是页面展示能力，不是授权矩阵或写接口文档。
- work_response：把角色条件写进正文，不推断显示/修改权限、MIGO 或 API 操作。
- change_ref：对象页段落及待补核心第五项。
- recheck：原开发者视角复核后，角色导航能力没有被改写为客户访问承诺。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-D-04
- article_id：PP-05；role：普通 SAP 开发人员；round：4；timestamp：2026-11-27（仅日期）
- question：R5 的 C_DRAD_OBJ 条件能否概括生产订单的全部业务授权？
- evidence：R5 限于自动附加文档的 BJ5 释放场景，不能代替生产确认、物料凭证或普通显示权限。
- work_response：只记录该特定授权检查，在文章中明确不构成完整权限路径。
- change_ref：R5 来源说明、正文释放边界和待补核心第五项。
- recheck：原开发者视角复核后，授权对象没有被推广到所有 PP 操作。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

#### PP05-D-05
- article_id：PP-05；role：普通 SAP 开发人员；round：5；timestamp：2026-11-27（仅日期）
- question：公开 API 文档可否被描述为目标客户的确认 API 已启用、调用成功或已在生产订单上测试？
- evidence：公开产品页不等于客户系统/API 配置；目标 SAP 环境未连接。
- work_response：保留“未连接/未调用/未测试”声明，不写客户 API 可用性或测试结论。
- change_ref：文章元数据、结尾声明及本记录系统验证状态。
- recheck：原开发者视角复核后，没有把文档证据写成系统运行结果。
- status：closed-in-perspective；executor_context：同一 Work 模拟，无真人专家或独立 Agent。

## 4. 结论与证据缺口

- 记录三角色各 5 个同上下文模拟闭环，共 15 个；不是独立审查、真人专家评审或 SAP 实机验证。
- 固定 2021.000 Help 的官方索引摘要支持 BJ5 范围的确认 API 提议数据类别、对象页货物移动、有限应用增强和自动附加文档时的授权特例；动态 FSD v11.0/SPS10 另有限支持计划订单转换、TECO/关闭差异、结算对象概览及确认可触发事项示例与可取消/部分取消能力。
- 固定版完整状态全集、一般释放条件、确认种类/状态、取消后的关联单据效果、每种反冲/收货触发前提、失败回退、客户配置、数据模型/API 合同与授权、FI/CO 结果仍未闭合。
- 核心范围未闭合，文章保持 drafting；不增加批次 A reviewed 或 owner accepted 数。
- 下一篇：PP-06《生产发料、收货与成本》，批准路径 knowledge/PP/02-functions/production-goods-cost.md；开始前只读取该篇对应准入、来源及关联文章。

## 5. 独立 AI reviewer-context 质询与最终正文复核

本节是本轮独立上下文的三角色审查，和前面 15 轮同一 Work 上下文模拟分别记录。普通读者、资深配置顾问、普通 SAP 开发者各提出 5 个问题；作者按证据逐项答复并修订后，三个原角色均通过 GitHub `fetch_blob` 读取并复算最终正文 blob `1fffe1c2b6e8e0817e785f64c11f62e6763a58e0`。每问的 PASS 只表示对应范围/措辞问题已回应，不等于 M3 核心目标达成；独立 reviewer-context 不是真人 SAP 专家。

### 普通读者

| 轮次 | 质询与目标版证据 | Work 答复、修订或判断 | 精确最终正文复核 |
|---|---|---|---|
| R1 | 离线练习的编号步骤是否会被误读为业务事件顺序？SPS10 FSD 未建立适用于所有配置的完整事件顺序。 | 将“时间线”改为“事件分类表或事件图”；明确练习步骤不代表业务事件顺序，并要求将未经证实的先后关系标“待核”，不得按枚举顺序连流程。 | PASS：正文显式排除普遍顺序，且说明不要按列举顺序连成流程。 |
| R2 | 读者会否把确认和货物移动读成完全无关，或读成每次确认均自动过账？动态 FSD §2.8.4.2（SPS10）列出确认可触发订单更新、反冲、收货、成本等示例；无固定版条件。 | 将 SPS10 示例补入文章，同时明确没有逐项触发条件或客户设置证明；把“确认可取消/部分取消”与“货物移动可重处理”拆为并列陈述，明确取消不等于自动重处理。 | PASS：来源范围、潜在联动与未证因果均清楚。 |
| R3 | `GetConfProposal` / `GetGdsMvtProposal` 提议数据会否被理解成已保存确认或已过账物料凭证？固定 2021.000 API 官方索引只列创建前提议数据类别，规范页直开 0 行。 | 在正文明确提议数据不是已保存确认、已过账物料凭证或完整请求载荷；不补写字段和写入副作用。 | PASS：初学者可区分提议、确认记录和物料凭证。 |
| R4 | 自动附加文档时的 release 授权检查会否被理解成所有订单释放前提？固定 BJ5 索引只支持特定文档授权场景。 | 保留“自动附加文档”前提及文档对象/类型/状态限制，并标明不是通用释放规则或完整权限矩阵。 | PASS：没有把单一授权特例扩大成所有订单条件。 |
| R5 | TECO 与 settlement 是否像同一动作，或暗示 TECO 自动触发 settlement？SPS10 FSD 只分别概述物流完成与结算去向。 | 将技术完成与结算拆成独立表项；明确 FSD 未说 TECO 会自动触发结算，金额和 FI/CO 规则仍待 PP-06/CO-04 取证。 | PASS：两个主题与缺失的因果规则清楚分开。 |

### 资深 SAP 配置顾问

| 轮次 | 质询与目标版证据 | Work 答复、修订或判断 | 精确最终正文复核 |
|---|---|---|---|
| C1 | 计划订单转换主张是否引用了正确章节？FSD §2.8.3.1 而非 §2.8.4.2 才说明转换；范围仅限 SPS10 的离散制造厂内生产。 | 在正文和来源记录引用 §2.8.3.1 pp.70–71，并限定对应离散制造厂内生产物料；不推断资格、转换前提或客户设置。 | PASS：章、页、动态版本和场景范围匹配。 |
| C2 | TECO、关闭和结算是否有可用的有限目标版信息？FSD §2.8.4.1 p.75 说明部分 TECO 后果、关闭后的更新边界和结算接收方示例。 | 拆开 TECO、关闭和结算；只纳入 SPS10 明示的 MRP/预留/能力需求等有限后果与接收方示例，不构建全状态表或 settlement 规则。 | PASS：有限状态说明未冒充固定版完整状态机，也未声称 TECO 自动结算。 |
| C3 | API 的 proposal 能力能否代表已提交结果、部分/最终确认或撤销合同？固定版索引仅有创建前数据类别，规范 HTML 直开 0 行。 | 将它保留为创建前提议数据类别；不推出确认级别、状态、撤销、载荷或客户调用能力。 | PASS：提议能力没有被扩大成 API 合同。 |
| C4 | 正文是否遗漏 SPS10 FSD 对确认触发事项的具体描述？该动态 PDF 明列示例业务操作，也提及确认取消与货物移动重处理。 | 纳入订单数据更新、组件反冲、收货过账、成本更新等示例，以及确认可取消/部分取消、货物移动可重处理；说明具体配置、触发/失败条件与因果关系未证。 | PASS：正文准确反映快照并保留触发边界；取消与重处理已改作并列陈述。 |
| C5 | 自动附加文档的释放授权检查是否被扩成通用 release gate？固定 2021.000/BJ5 索引仅支持其文档授权特例。 | 明确限定“自动附加文档”及 BJ5 文档对象/类型/状态；保留一般释放规则和权限矩阵为缺口。 | PASS：没有扩展为通用条件。 |

### 普通 SAP 开发人员

| 轮次 | 质询与目标版证据 | Work 答复、修订或判断 | 精确最终正文复核 |
|---|---|---|---|
| D1 | 创建前提议数据会否被理解成已保存确认或过账物料凭证？官方 2021.000 摘要不含实际写入合同。 | 正文明确提议值不等于已保存确认、已过账物料凭证或完整请求载荷。 | PASS：没有把查询提议和写入结果混为一谈。 |
| D2 | 正文能否作为生产确认 API 的实现说明？没有完整 schema、键、枚举、错误处理或客户 `$metadata`。 | 不列字段/键或调用示例；将完整合同和 released API 状态列为未闭合，并明确索引摘要限制。 | PASS：没有可被误用为接口实现的字段推断。 |
| D3 | 确认与货物移动的物料凭证关联字段/基数是否可推导？FSD/API/Object Page 摘要没有关联键、基数或取消后的逆转结果。 | 明确该字段、关联键/基数、写入结果和取消后的物料凭证逆转规则不可读；取消和重处理分开陈述。 | PASS：未推断物料凭证关联模型或自动重处理关系。 |
| D4 | 对象页角色导航或文档附加时的授权检查是否意味着确认 API 写入权限？ | 正文说明前者是导航范围，后者是自动附加文档特定检查；不推出 API 写权限或通用权限模型。 | PASS：授权边界分离，客户权限仍未验证。 |
| D5 | 固定 2021.000、动态 SPS10、2025 文档和实机验证是否混写？ | 正文区分固定版 SAP Help 官方索引摘要与动态 FSD v11/SPS10，记录 `latest` URL v9 索引/v11 直读差异；2025 文档不用于补充目标版规则，并保留“未连接 SAP、未做测试”。 | PASS：版本和系统验证边界一致，未出现 SAP 实测暗示。 |

三个独立 reviewer-context 均对精确最终正文各完成 5/5 原角色复核（15/15 PASS）。本次独立复核不代表真人 SAP 专家意见，也不改变文章的 M3 门禁结论：**PP-05 仍为 Draft，不增加批次 A Role Reviewed 或 Owner Accepted 计数**。未连接 SAP，未执行订单、配置、数据库、API、库存或权限测试。

