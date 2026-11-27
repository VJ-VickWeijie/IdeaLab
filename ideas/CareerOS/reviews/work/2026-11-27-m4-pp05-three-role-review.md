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
| R1 | SAP S/4HANA 2021 Feature Scope Description, §2.8.4.2, PDF pp.76–77。动态 URL：https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf。实际所读版本 11.0（2026-07-22，SPS10）。 | 高层列出生产准备、物料领用、工时票/确认、完工收货录入、生产信息记录；描述订单技术完成及结算概念。 | 不是固定版 2021.000 初始版材料；不能证明状态全集、事件触发、反冲/撤销、普遍会计和金额。 |
| R2 | SAP Help, “OData API: Production Order Confirmation”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b66174fc3f68458fb1dab04a09d5d95c.html?version=2021.000 | 固定版页面说明生产订单确认 API；创建确认前可取数量、工作活动、日期/时间、人员及货物移动提议数据；列出特定批次特性扩展。 | 不提供文章所需完整状态/撤销规则、完整字段合同、客户启用/授权或执行结果。 |
| R3 | SAP Help, “Manage Production Orders”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/de8ebc2f3e0f40a484585f91d4380ee3.html?locale=en-US&state=PRODUCTION&version=2021.000 | 固定版 What's New 页面列出 BJ5 应用的若干订单信息和操作增强。 | 不是所有订单状态、释放条件或客户角色权限矩阵。 |
| R4 | SAP Help, “Production Order Object Page”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/1813394db23d45aca434092495c4feae.html?version=2021.000 | 固定版页面说明对象页可显示已记录货物移动；按用户角色导航到相关应用。 | 不证明系统启用、角色映射或每个确认的库存后果。 |
| R5 | SAP Help, “Tightened Authorization Checks for Documents in Production Order Release”, S/4HANA 2021 (Oct 2021), version 2021.000, BJ5：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/ca2d6c36965743a69e1871d3404718fb.html?version=2021.000 | 释放时自动添加文档的特定授权检查；未授权时释放可被拒绝。 | 不是生产订单通用释放配置、完整授权对象或状态迁移说明。 |

本文对 R1 仅按动态 S/4HANA 2021 SPS10 快照说明，不称为固定 2021.000 证据。R2–R5 为 version=2021.000 页面，且各自范围均限定于其列明的应用/Scope Item。

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
- 固定 2021.000 Help 支持 BJ5 范围的订单管理/释放授权特例/确认 API 数据提议/货物移动对象页等有限主张；动态 FSD 仅以 2021 SPS10、文档版本 11.0、2026-07-22 快照标注引用。
- 状态全集、释放一般条件、部分/最终确认和回退、确认与物料移动联动、客户配置、数据模型/API 合同、权限和 FI/CO 结果仍未闭合。
- 核心范围未闭合，文章保持 drafting；不增加批次 A reviewed 或 owner accepted 数。
- 下一篇：PP-06《生产发料、收货与成本》，批准路径 knowledge/PP/02-functions/production-goods-cost.md；开始前只读取该篇对应准入、来源及关联文章。

