# CareerOS V0.4｜M4 剩余 96 篇两批执行计划

- 更新时间：2026-11-26（Asia/Shanghai）
- 分支：careeros-v04-m4-batch1-20261126
- 当前 PR：#21；延续现有分支和 PR，不新开 PR，不合并。
- AI-Workflow：V1.1 固定 SHA 939ec44036d89cd91622ab96b938be9f02479026；通用门禁不修改。
- 总目标：99 篇正式文章；三篇首批已获所有者肯定并通过，剩余 96 篇分两批建设。
- 最新所有者决定：“看了，很棒，甚至有点超出我逾期了。接下来分两批完成剩余的篇章。”Work 据此把 FI-01～FI-03 记为所有者通过，并开始剩余批次。

## 批次边界

两批按依赖分成“模块知识 → 统一流程及技术/课程”，便于先建立业务与财务基础，再把流程和课程链接到已完成的模块文章。

| 批次 | 数量 | 范围 | 文章 ID | 状态 |
| --- | ---: | --- | --- | --- |
| 已通过首批 | 3 | FI 基础：财务会计、会计等式、借贷记账 | FI-01～FI-03 | 所有者已阅并肯定；正式接受 3/99 |
| M4 批次 A | 50 | MM、SD、PP、QM、FI、CO 模块知识；覆盖基础、业务功能、T-Code、配置查看和数据模型，逐主张收窄 | MM-01～MM-10；SD-01～SD-07；PP-01～PP-09；QM-01～QM-08；FI-04～FI-11；CO-01～CO-08 | 进行中；FI-05、MM-01～MM-07 已 reviewed（15、16、15、18、18、15、15、15 个有效闭环，均待所有者验收）；FI-04/FI-06 保持 drafting |
| M4 批次 B | 46 | 统一业务流程、ABAP、S/4HANA 技术、SAP×AI、统一术语表及课程 | PROCESS-01～PROCESS-12；ABAP-01～ABAP-09；S4HANA-01～S4HANA-09；AI-Integration-01～AI-Integration-08；COMMON-01；COURSE-01～COURSE-07 | 待批次 A 完成 |

合计：3 + 50 + 46 = 99。每篇 ID 和目标路径以 [99 项 M3 逐篇准入分流](m3-item-readiness-triage-v0.3.md)及 [控制矩阵](m3-item-control-matrix-v0.3.md)为准；此分组不修改原批准标题和路径。

## 执行与证据规则

1. 批次分组用于排程，不表示 M3 中“限缩可写/暂缓核心”的逐主张条件已自动关闭。每篇先按原控制矩阵与来源台账建立可写主张、直接证据、版本范围、未支持项和下一步。
2. 为个人学习目的，正文可以先完成证据充分的部分。证据不足的具体技术断言须限缩、标出版本/配置/地区前提或列作待核；必要时暂不写入正文。不得为了让 99 篇都显示完成而编造事实或把“待验证”写成肯定句。
3. FI-07、MM-09、PROCESS-01、ABAP-02、ABAP-04 的既有缺口继续保留。与这些缺口无关的文章继续写；相关文章仅纳入已证实内容，缺口关闭前不把整篇标为 accepted。
4. 每篇中文为主并保留英文术语；尽量按知识树的文章结构解释业务原因、业务角色、端到端流程、配置和数据模型、会计影响、跨模块关系、适用前提及离线可选练习。T-Code、表/API、配置路径等具体产品断言均按 S/4HANA 2021 对应官方资料逐项验证；ECC 只作必要差异说明。
5. 每篇正式文章由普通读者、资深 SAP 配置顾问、普通 SAP 开发人员分别完成 5～10 个有效闭环；每个闭环含实质问题、Work 有依据的答复、修订判断/正文修改和原角色复核。严重缺陷未关闭不通过。真实执行上下文与可见模型信息如实记录；不伪造人类专家、独立代理、测试或闭环。
6. SAP 系统未连接。文章练习须可选且不依赖生产系统修改权限；研究、目录和草稿不计正式完成数。

## 状态口径

- **planned**：尚未开始正文。
- **drafting**：正在写作或存在未完成审核/证据限制。
- **reviewed**：三角色达到每篇最低闭环并关闭严重缺陷，等待所有者审阅。
- **accepted**：三角色审核及必要复验完成，并经所有者审阅通过。
- 同一文章可以在缺少某个非核心或客户特定断言时以清楚的范围限定完成；若核心学习目标无法安全解释，保持 drafting 并记录具体阻碍，不以空文或目录占位。

## 当前进度

| 统计 | 当前值 |
| --- | ---: |
| 所有者通过文章 | 3/99 |
| 剩余文章 | 96 |
| 批次 A | 8/50 已角色 reviewed（FI-05、MM-01～MM-07）；0/50 所有者接受；FI-04/FI-06 保持 drafting |
| 批次 B | 0/46 已开始；待批次 A 完成 |
| 正式文章总审核进度 | FI-01～FI-03 共 52 闭环；FI-05 15、MM-01 16、MM-02 15、MM-03 18、MM-04 18、MM-05 15、MM-06 15、MM-07 15 个有效闭环，均 reviewed 并待所有者验收；FI-04～FI-06 首轮问题 38/45 闭环；细项见各审查记录 |
| SAP 实机测试 | 0；未连接 |

FI-01～FI-03 已由所有者审阅肯定，正式接受数仍为 3/99。批次 A 目前有 8 篇完成三角色审查：FI-05（15）、MM-01（16）、MM-02（15）、MM-03（18）、MM-04（18）、MM-05（15）、MM-06（15）、MM-07（15）个有效闭环，均待所有者验收；尚未将其计入 accepted。FI-04/FI-06 文章级证据缺口与首轮 38/45 项状态见 A01 记录，不阻挡独立文章。MM-06 审查见 `reviews/work/2026-11-26-m4-mm06-three-role-review.md`；MM-07 正文与三角色审核见 `knowledge/MM/02-functions/price-unit-conversion.md` 及 `reviews/work/2026-11-26-m4-mm07-three-role-review.md`。下一工作包为 MM-08《MM 常用事务码导航》，按批准路径 `knowledge/MM/03-tcodes/transaction-index.md` 建设；逐事务核实目标版用途、对象、权限和显示/修改边界，只有已证实条目进入正文，不用业务功能范围推定事务码。每个工作包提交文章、真实审核记录、状态与 HANDOFF 到 PR #21；新窗口优先读取 HANDOFF、本计划及当前所需文件，不载入全部 99 篇历史记录。PR 不自动合并。


## 工作线 2 进度追记（2026-11-27）

SD-06《销售配置查看》正文已建立，状态 drafting；15 个同上下文角色视角循环（普通读者 5、资深配置顾问 5、普通开发人员 5）已记录，但不构成独立审查，且通用 IMG/只读授权证据仍未闭合，因此不增加批次 A reviewed 数。当前总体计数仍为 8/50 reviewed、0/50 owner accepted，owner accepted 总数 3/99；SAP 实机测试 0。工作线 2 下一篇为 PP-01，当前准入为“暂缓核心”。详见 [SD-06 正文](../knowledge/SD/04-configuration/sales.md) 和 [审查记录](../reviews/work/2026-11-27-m4-sd06-three-role-review.md)。


## 工作线 5 进度（2026-11-27）

- FI-11《财务凭证与总账数据模型》已建立证据受限草稿，状态 `drafting`。目标版固定来源支持 Universal Journal 的报告背景和特定转换/功能说明；BKPF/ACDOCA/BSEG 的完整字段、主键、基数、released API/CDS 及权限仍缺逐字段官方依据。
- FI-11 同一上下文角色模拟完成 15 个质询—证据答复—修订—复核闭环（读者 5、配置顾问 5、开发者 5）；未声称独立专家或独立代理审查，因此不计入 role-reviewed 文章数。
- 未推导 FI-07 普通库存采购借贷、税或自动科目规则；未连接 SAP，无实机验证。来源见 `evidence-finance-m3.md` 的 M4 FI-11 记录和 `reviews/work/2026-11-27-m4-fi11-three-role-review.md`。
- 批次 A 全局 reviewed/accepted 计数保持不变：8/50、0/50；全库接受 3/99。工作线 5 下一项 CO-01。

## 工作线 2 进度追记（2026-11-27，PP-01）

PP-01《生产业务与组织结构》已建立 drafting 草稿，15 个同上下文角色视角闭环已记录；组织关系与生产模式核心证据未闭合，且没有独立审查，故不增加 reviewed/accepted 计数。工作线 2 当前两篇新增稿（SD-06、PP-01）均 drafting；总体进度以当前计划表和 HANDOFF 进度表为准。下一篇 PP-02。详见 [PP-01 正文](../knowledge/PP/01-foundations/production-organization.md) 和 [审查记录](../reviews/work/2026-11-27-m4-pp01-three-role-review.md)。

## 工作线 2 进度追记（2026-11-27，PP-02）

PP-02《物料清单 BOM》已建立证据受限文章，状态 drafting；三角色各有 5 个已闭合的同上下文角色视角循环（共 15），不代表独立 review，故不计入 reviewed 或 owner accepted。固定版 2021 来源支持多层结构、有限 BOM versioning 配置说明及 make-to-stock repetitive manufacturing 确认场景的日期示例；通用数量/单位计算、替代项选择/有效期关系、组件缺失规则及数据字段/API 仍未闭合。批次 A 维持 8/50 reviewed、0/50 owner accepted，owner accepted 总数 3/99，SAP 实机测试 0。下一项 PP-03《工作中心与工艺路线 Routing》，以 M3 准入分流批准路径为准。详见 [文章](../knowledge/PP/01-foundations/bom.md) 与 [审查记录](../reviews/work/2026-11-27-m4-pp02-three-role-review.md)。

## 工作线 2 进度追记（2026-11-27，PP-03）

PP-03《工作中心与工艺路线 Routing》已建立 drafting 草稿，并记录普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个同上下文模拟闭环（共 15；不计独立 review）。证据限于 S/4HANA 2021 BJ5 Manage Routings、BJ8 Work Center OData API、3W4 operation PRT API，以及 PEO 专用 routing 结构；不将这些场景泛化。通用 Routing 顺序/选择、工作中心字段和成本/产能关系、与 BOM/生产版本的普遍替代/有效期关系仍未闭合。批次 A 维持 8/50 reviewed、0/50 owner accepted；接受数 3/99；实机测试 0。下一篇 PP-04。详见 [文章](../knowledge/PP/01-foundations/work-center-routing.md) 和 [审查记录](../reviews/work/2026-11-27-m4-pp03-three-role-review.md)。

## 工作线 5 进度追记（2026-11-27，CO-01）

CO-01《管理会计从零：成本与利润》按批准路径完成限缩范围正文和目标版来源补查。普通读者、资深 SAP 配置顾问、普通 SAP 开发人员视角各5个有效模拟闭环，共15；均在同一Work上下文，非独立审核。核心范围有 SAP S/4HANA 2021 Feature Scope Description v9.0/SP08 与 2021 Simplification List §8.1 支持；具体成本对象分配、分摊/结算、利润分析配置、表/API/权限仍不作通用断言。文章保持 drafting，待独立复核；批次A仍8/50 reviewed、0/50 owner accepted。工作线5下一篇CO-02；该篇完整研究材料尚未读取。


## 工作线 2 进度追记（2026-11-27，PP-04）

PP-04《需求、MRP 与计划订单》已按 M3 准入分流建立证据受限正文，状态 drafting；三角色视角各 5 个同上下文模拟闭环，共 15，不是独立审查，不计 reviewed/owner accepted。固定 2021.000 Help 仅支持 J44 的 Material Coverage 应用功能和 Planned Order API 条目；Operations Guide/FSD 实际读取为 2021 SPS10、文档版本 11.0（2026-07-22）。FSD URL 动态，已明确标注为 SPS10 快照，不冒充固定版初始 2021 证据。净需求/可用库存规则、批量算法与参数、库存及供给纳入、提议类型选择、客户配置、完整 API/数据模型及授权仍待核；纸面算术不代表 SAP 结果。批次 A 维持 8/50 reviewed、0/50 owner accepted；全库 owner accepted 3/99；SAP 实机测试 0。下一篇 PP-05，路径 knowledge/PP/02-functions/production-order.md。


## 工作线 2 进度追记（2026-11-27，PP-05）

PP-05《生产订单与确认》已建立证据受限文章，状态 drafting；三角色各 5 个同上下文模拟闭环，共 15，不是独立审查，不计 reviewed/owner accepted。固定版 2021.000 Help 支持 BJ5 范围的 Manage Production Orders、释放中的特定文档授权检查、Production Order Confirmation API 的数据提议及订单页货物移动显示；动态 FSD 只按 2021 SPS10 文档版本 11.0（2026-07-22）快照标注引用。订单状态全集、通用释放条件、部分/最终确认及撤销、确认与发料/收货联动、数据模型/API 完整合同、客户权限及 FI/CO 影响仍未闭合。批次 A 维持 8/50 reviewed、0/50 owner accepted；全库 owner accepted 3/99；SAP 实机测试 0。下一篇 PP-06，路径 knowledge/PP/02-functions/production-goods-cost.md。

## 工作线 5 进度追记（2026-11-27，CO-02）

- CO-02《成本中心与成本要素》已按批准路径建立限缩草稿，当前状态 **drafting**；M3 分流仍为“暂缓核心”。
- 本篇角色视角闭环：普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5，共 15 个同一 Work 上下文模拟闭环；不代表独立审查者或真人专家，不计入批次 A reviewed。
- 目标版依据：FSD v9.0/SP08 快照支持成本中心捕捉成本及期间 actual/plan；固定版 Migration Objects 2021.000 支持 controlling area 内成本中心定义和迁移范围中的 company-code data/validity；Central Finance 2021.001 仅在映射/初始加载语境支持 S/4HANA 成本要素与 G/L account 的关系。
- 未闭合：成本中心字段级有效期、组织配置约束、成本要素类别和日常分配/自动规则、技术字段/表/API/CDS/权限；没有推广迁移场景到一般过账。FI-07 普通库存采购借贷、税务与自动科目规则未扩大或关闭。SAP 未连接，无实机验证。
- 记录见 ideas/CareerOS/knowledge/CO/02-functions/cost-center-elements.md、ideas/CareerOS/reviews/work/2026-11-27-m4-co02-three-role-review.md、evidence-finance-m3.md。批次 A 仍 **8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。工作线 5 下一项为 CO-03《内部订单和费用归集》，开始前仅读取该篇准入及其来源登记。

## 工作线 2 进度追记（2026-11-27，PP-06）

PP-06《生产发料、收货与成本》正文按 M3 分流的“限缩可写”范围提交，状态 `drafting`。普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各完成 5 个同一 Work 上下文的模拟闭环，共 15；记录披露不是独立审查，也不计入 8/50 role-reviewed。正文范围以实际读取的 SAP S/4HANA 2021 SPS10 FSD 动态快照（Document Version 11.0，2026-07-22）支持的生产执行、库存增减、物料凭证、高层成本对象和 Kanban 限定例子为限；另引用固定版 2021.000 BJ5 订单对象页的已记录货物移动显示说明。估价金额、退料/冲销条件、差异/WIP/结算计算、FI/CO 凭证与科目、数据模型/API、权限、EWM/MES 仍待目标版证据；M3 关联 CO-04 正文当前分支不存在。未连接 SAP、未实测。工作线 2 下一篇为 SD-07；批次 A 与全库正式统计不变（8/50 reviewed、0/50 owner accepted、3/99 accepted）。


## 工作线 4 进度追记（2026-11-27，FI-10）

FI-10《财务配置查看》按 M3“暂缓核心”准入建立目标版证据受限草稿，状态 `drafting`。SAP S/4HANA 2021 What's New §3.6.1.3 仅支持 Automatic Account Determination app 用途及公告中的限定变化；固定版 2021.000 Help §3.6.1.16 仅支持 GR/IR 账户的 Extended Open Item Management 字段与 display-only 属性。公司代码、科目表、过账期间、收付款配置、完整账户映射、精确配置路径和角色授权仍缺目标版直接证据。没有外推 FI 来源到 MM OBYC/BSX/WRX，也没有连接 SAP 或做实机验证。

Work 在同一上下文以普通学习者、资深 SAP 配置顾问、普通 SAP 开发人员三个视角各完成 5 个模拟质询—证据答复—修订判断—复核闭环，共 15；没有独立代理/真人专家签核，不计入正式 8/50 reviewed。记录见 [文章](../knowledge/FI/04-configuration/finance-config-observation.md) 和 [角色视角审查记录](../reviews/work/2026-11-27-m4-workline-4-fi10-review.md)。工作线 4 已完成所分配的新建与续核文章，FI-10 为本线最后一篇，无下一篇在本线范围内。

### M4 Workline 5 CO-03｜2026-11-27

CO-03《内部订单和费用归集》已按 M3 “限缩可写”路径建立证据受限草稿，路径为 `knowledge/CO/02-functions/internal-orders.md`。普通读者、资深配置顾问、普通 SAP 开发人员视角各完成 5 个同一 Work 上下文模拟闭环，共 15；未独立复核，不计入批次 A reviewed，文章状态 drafting。正文逐项区分目标版 FSD v9.0/SP08 和迁移文档、未标发行版的 SAP Learning、2021.001 Central Finance 专项范围。普通订单结算/接收方、真实/统计通用规则、预算触发、配置、权限、数据模型/API 仍待直接证据；无 SAP 实机测试，不推导 FI-07 库存借贷、税或自动科目。详见 [CO-03 文章](../knowledge/CO/02-functions/internal-orders.md)、[闭环记录](../reviews/work/2026-11-27-m4-co03-three-role-review.md) 与 [证据边界](evidence-finance-m3.md)。批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，正式接受数 **3/99**。工作线 5 下一篇 CO-04；开始前仅读取 CO-04 自身准入与证据登记。


## 工作线 2 进度追记（2026-11-27，SD-07）

SD-07《销售与交货数据模型》按 M3 “限缩可写”准入建立目标版证据受限文章，路径 `../knowledge/SD/05-data-model/sales-delivery.md`，状态 `drafting`。Work 在同一上下文模拟普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个闭环，共 15 个；每项包括质询、来源答辩、修订和原视角复核，但不是独立专家/代理审查，不增加正式 reviewed 数。固定 SAP 2021 Simplification List §36.8 支持的状态简化、VBFA 简化、单据类别和索引表变化均按 system conversion 语境限定；2021.000 API 示例仅是销售订单模拟 API；FSD 11.0/SPS10 动态快照仅用于高层开票至 FI 能力。完整 VBFA 和后续单据的字段、键、基数、组织映射、SD-FI 凭证关系、released API/CDS 合同及权限仍待核；SD-03/SD-04 正文当前分支不存在。未连接 SAP、未实测。

工作线 2 分配的 8 篇文章（SD-06、SD-07、PP-01～PP-06）均为 drafting，累计 120 个同上下文模拟闭环；本线正式独立 role-reviewed 为 0/8。批次 A 正式计数仍 8/50 reviewed、0/50 owner accepted，全库正式接受 3/99。本线已完成分配范围，无下一篇。

### M4 Workline 5 CO-04｜2026-11-27

CO-04《产品成本、生产差异与结算》按 M3 “暂缓核心”路径建立了受限 drafting 草稿：[文章](../knowledge/CO/02-functions/product-cost-variance-settlement.md)、[三角色视角记录](../reviews/work/2026-11-27-m4-co04-three-role-review.md)、[证据台账](evidence-finance-m3.md)。SAP S/4HANA 2021 FSD v9.0/SP08 快照支持制造方式影响成本观察对象、生产订单成本向一个或多个成本对象结算、重复制造期间性成本收集，以及特定 Kanban 场景的 WIP/差异和期末能力；2021.000 Deferred Summarization 仅说明特定数据汇总功能。普通生产订单 WIP/variance 公式、状态触发、一般结算规则/接收方和 FI 分录仍未由直接目标版证据闭合。普通读者、配置顾问、开发者视角各 5 个同上下文模拟闭环（共15）；不是独立 review，不计 reviewed。无 SAP 实机或用户权限验证；未推导 FI-07 采购库存借贷、税或自动科目。批次 A 仍 **8/50 reviewed、0/50 owner accepted**，owner accepted 为 **3/99**。工作线 5 下一篇 CO-05；开始前仅读取 CO-05 自身准入与证据登记。
