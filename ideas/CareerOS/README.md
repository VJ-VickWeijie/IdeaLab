# CareerOS｜项目总入口（2026-11-26 更新）

> 跨 Work 窗口接手入口：[HANDOFF.md](HANDOFF.md)。M3 已验收；M4 完整 99 篇分两批建设已获授权。FI-01～FI-03 已由所有者接受，正式接受 3/99。批次 A 已有 8/50 篇完成三角色审核、0/50 篇获所有者接受；其中 FI-05、MM-01～MM-07 已 reviewed，FI-04/FI-06 保持 drafting。下一篇为 MM-08《MM 常用事务码导航》。MM-06 审查记录见[三角色记录](reviews/work/2026-11-26-m4-mm06-three-role-review.md)，MM-07 审查记录见[三角色记录](reviews/work/2026-11-26-m4-mm07-three-role-review.md)。详见 [HANDOFF](HANDOFF.md) 与[两批执行计划](plans/m4-two-batch-execution-2026-11-26.md)。
## 项目主旨
利用工作日合规的碎片时间，建立**中文为主、保留英文术语**的 SAP 业务与技术知识网络，同时保留 24 个月职业成长课程。目标不只是记住 T-Code，而是理解企业为什么需要某个流程、完整业务/单据/物流/财务流、SAP 如何实现，以及跨模块关联；FI/CO 从零基础解释。长期发展方向是 SAP MM/QM + ABAP/S/4HANA 架构 + 企业 AI 集成。

## V0.3 已确认产品决策
1. **模块知识库**：MM、SD、PP、QM、FI、CO，以及 ABAP/S4HANA/AI 技术专题。各模块分基础概念、功能知识、T-Code、配置、数据模型；配置独立建栏，并与 T-Code 索引互链。
2. **统一业务流程库**：单模块与跨模块的完整端到端业务均集中管理；P2P、O2C、跨公司 STO、生产、质量、R2R 等；模块页通过链接引用，不重复维护全文。
3. **系统学习课程**：沿用长期路线，提供推荐阅读和可选练习；不强制每天操作 SAP。
4. **质量机制**：Work 负责写作、答辩和修订；普通用户、资深 SAP 配置顾问、普通 SAP 开发人员分别对每篇正式文章按需进行**5～10 个有效质询—答辩—修订—复核轮次**，三角色合计 15～30 轮，完整过程存入 GitHub。不得将同一模型的角色扮演冒充独立子代理。

## 当前实际状态（2026-11-26，所有者后续决定已更新）

- M3 已由所有者验收。
- M4 已获授权：完整 99 篇分两批自主建设；首批 FI-01～FI-03 已获所有者肯定，正式接受 3/99。
- 当前批次 A01：FI-04 公司代码/科目表/总账科目（14/15 项意见已闭环，核心定义证据未闭合，drafting）；FI-05 会计凭证/过账/冲销（三角色各 5 个有效闭环，reviewed）；FI-06 应付/应收（9/15 项意见已闭环，SAP 子账/清账/部分付款核心证据未闭合，drafting）。
- 批次 A 已 reviewed：FI-05（15 个有效闭环）、MM-01（16）、MM-02（15）、MM-03（18）、MM-04（18）、MM-05（15）、MM-06（15）、MM-07（15）；均等待所有者验收。MM-02 七类信息表校准见[审查记录](reviews/work/2026-11-26-m4-mm02-three-role-review.md)；MM-03 的来源版本边界、供应商简称/来源对象区分和链接修正见[审查记录](reviews/work/2026-11-26-m4-mm03-three-role-review.md)；MM-04 的限额项/RFQ 入门解释、审批术语与证据边界见[审查记录](reviews/work/2026-11-26-m4-mm04-three-role-review.md)；MM-05 的库存范围、权属推论及移动类型证据边界见[审查记录](reviews/work/2026-11-26-m4-mm05-three-role-review.md)；MM-06 的三角色审核与退货/记录纠错边界见[审查记录](reviews/work/2026-11-26-m4-mm06-three-role-review.md)；MM-07《价格单位、数量单位与换算》完成三角色审核（15 个有效闭环）并待所有者验收，记录见[审查记录](reviews/work/2026-11-26-m4-mm07-three-role-review.md)。下一篇为 MM-08《MM 常用事务码导航》。
- 批次 A 50 篇、批次 B 46 篇，当前批次 A 为 8/50 role-reviewed、0/50 owner-accepted；文章逐项状态见 [HANDOFF](HANDOFF.md)。完整范围见[执行计划](plans/m4-two-batch-execution-2026-11-26.md)。证据受限文章不自动计为正式接受；独立文章不因局部证据缺口停摆。
- FI-07、PROCESS-01、MM-09、ABAP-02、ABAP-04 保持既有未闭合状态；本批不写依赖这些证据的 SAP 自动过账、采购完整借贷、内存阈值或 BAPI 专属合同断言。
- 未连接 SAP 系统；本批没有实机测试。
- 首批完整审核追踪见 [首轮意见答复与修订记录](reviews/work/2026-11-26-m4-batch01-round1-response.md)；当前批次提交与 PR 以 HANDOFF 和 M4 PR 的实时信息为准；不合并 PR。

## M3 规划阶段状态（以下为 M3 验收前历史记录）（2026-11-26）
- 所有者于 2026-11-26 明确批准 CareerOS 项目级 M3 门禁调整（不修改 AI-Workflow V1.1）；普通读者、资深 SAP 配置顾问、普通 SAP 开发人员的计划级收尾复核均已通过。M3 阶段验收仍待所有者，M4 仍未授权。详见 [M3 收尾复核报告](reviews/work/2026-11-26-m3-gate-closeout-review.md)与 [99 项分流](plans/m3-item-readiness-triage-v0.3.md)。
- PR #19 的 V0.3 蓝图已合并；所有者已批准 M0、M1、M2、99 篇正式文章范围及 11 个纯结构导航分类。
- 五项历史来源缺口仍按文章级边界处理，不阻止与其无关且证据充分的文章进入未来批次；M4 尚未授权。
- [旧门禁审计](reviews/work/2026-11-26-m3-gate-audit.md)的“不满足出口”结论仅适用于门禁调整批准前的旧标准。按批准后的计划级门禁，M3 规划出口经三角色复核通过；此结论不等于所有者已验收 M3 阶段。五项核心风险仍未闭合，须在相关文章及主张中限缩或暂缓。
- 后续独立结构复核修正了 FI-03/FI-07/MM-09/PROCESS-01 四行证据台账的列错位和三篇 SAP Learning 的 GR/IR 归因；配置顾问复核后关闭这些文字问题。开发者另复核技术与 AI 26 项计划登记，发现负责人/下一步、阅读与独立复核元数据仍不完整；ABAP-04 状态歧义已修订并由开发者复核。详见 [M3 Work 修订记录](reviews/work/2026-11-26-m3-structure-review-remediation.md)、[配置顾问记录](reviews/consultant/2026-11-26-m3-sourcefit-structure-review.md) 与 [开发者技术结构审查](reviews/developer/2026-11-26-technical-sourcefit-structure-review.md)。
- [M3 控制矩阵](plans/m3-item-control-matrix-v0.3.md)、批准 manifest 与 [文章级分流](plans/m3-item-readiness-triage-v0.3.md) 均对应 99 个唯一 ID；分流为 65 项“限缩可写”和 34 项“暂缓核心”，不代表正文或 M4 准入。逐篇 claim-level 核实仍在相应 M4 批次进行。
- 尚未编写正式知识库正文、完成正式三角色文章审查、SAP 实机验证或全库链接验收；规划和文献研究不计作 V0.3 交付。
- ABAP-04 另由独立开发者直接复读四篇 ABAP Platform 2021 (Oct 2021) 官方通用 BAPI 事务文档：支持一般调用方管理 LUW、commit/rollback 与 update process；它们没有 BAPI_PO_CREATE1 专属 WAIT、提交例外或返回消息决策合同。此前 ECC/R/3 Additional Content 仅作有限背景，函数级缺口仍未闭合。详见 [BAPI 事务证据复查](plans/bapi-transaction-search-m3.md)。
- ABAP-02 新增 ABAP Platform 2021 (Oct 2021) 会话内存 soft warning 证据：warning threshold 越界时写 short dump 但不终止程序；目前没有依据表明 ABAP TRY...CATCH 可捕获该 warning 或自动停止，且该机制不能保证避免后续硬限额/内存 dump。独立开发者已复核版本标签、ST02 示例边界和 KBA 3435216 公开预览范围，确认三项措辞准确；目标系统参数值、kernel/FPS 和非生产实测仍待核。详情见 [ABAP-02 内存诊断补充](plans/abap02-memory-dump-admin-boundary-m3.md)及 [Work 执行记录](reviews/work/2026-11-26-abap02-memory-review.md)。
- 今日直接读取 SAP Help 的两篇 S/4HANA 2021 (Oct 2021) GR/IR 页面，补充了有限的科目关系说明；其中一页收货方向用词与其他示例不一致；另补入 MAP 无库存覆盖的数量/价差特例，但未明确无科目分配且无完整借贷表。未证明 OBYC 配置因素，MM-09 仍未闭合。
- 另直接读取并由独立上下文复读固定为 2021 (Oct 2021) 的 Account Determination 页面，补得发票科目确定的数据类别；它不列 OBYC/BSX/WRX 配置键或借贷分录，MM-09/FI-07/P2P 仍未闭合。
- 已建立 99 项 [M3 来源登记与复核记录](reviews/summary/m3-evidence-review-2026-11-25.md)；各项来源支持范围、版本与剩余缺口持续记录，未完成项不标通过。
- FI-10 另补读 SAP S/4HANA 2021 What's New §3.6.1.3（印刷页133–134），范围限 J58/FI-FIO-GL-CA：BUL、BUU 键属于 Prepare Intercompany Transactions，`*` 通配符涉及 Integrate with HR Postings 客户/供应商账号输入。它不是完整配置指南；配置顾问因 PDF 超出读取工具 10 MB 限制未能独立直读，搜索索引未计独立复核；不外推至 MM OBYC。详见 [FI/CO 证据登记](plans/evidence-finance-m3.md) 和 [贴合度复核](plans/finance-source-fit-review-m3.md)。
- 配置顾问独立复读三篇未固定 2021/FPS 的 SAP Learning 科目确定/收货/关账页面：Describing Automatic Account Determination 的发票步骤写 GR/IR 贷方，与 Managing Closing Activities 的发票借 GR/IR、贷供应商不一致；Managing Goods Movements 只明确限定收货借库存/贷 GR/IR，不支持发票方向。此冲突已记入 MM-09、FI-07、PROCESS-01 证据计划，不作为 SAP 勘误或 2021 结论；来源和边界见 [MM-09 补查](plans/mm09-obyc-source-followup-m3.md) 与 [FI-07 补查](plans/finance-fi07-direct-2021.md)。
- 普通 P2P 收货/发票借贷方向又做了一轮 2021 初版检索；独立顾问未找到明确无科目分配库存采购全分录的可读官方原文，Learning 文献有方向冲突，2021 候选页仅见 2025 FPS02 搜索索引。FI-07、MM-09、PROCESS-01 保持未闭合，详见 [P2P 普通采购借贷补查](plans/p2p-2021-posting-followup-m3.md)。
- 原始 M0 项目记录与 24 个月路线保留在下方，原始状态文字属于历史记录，以本节为当前状态。

## Work 接手顺序与后续工作
先按 [IdeaLab 启动规范](../../AGENTS.md) 阅读仓库及固定 AI-Workflow 版本，再读：
- [知识树 V0.3](architecture/knowledge-tree-v0.3.md)
- [Work 全量建设任务与验收协议](plans/work-handoff-v0.3.md)
- [多角色审查与过程记录规范](reviews/README.md)
- [原有成长路线](plans/roadmap-v0.1.md)

Work 应先建立细粒度覆盖矩阵，按阶段门禁开展全范围内容建设，组织三个角色逐篇各 5～10 轮有效审查并保存真实记录，修复问题、验证链接，最后通过 PR 交用户审批；**不得只交三五篇样板，不得自行合并**。公司 SAP 环境只读/受限，严禁擅改配置、上传企业敏感资料或声称做过未执行的测试。

---

## 原始项目记录（保留历史）
# CareerOS｜长期职业竞争力成长计划

## 灵感卡
- **一句话想法**｜在保留稳定工作与家庭陪伴的前提下，利用工作日合理空档，持续提升 SAP 技术、业务架构及 AI 应用能力，增强 35 岁以后职业选择权。
- **灵感起点**｜对 AI 影响软件开发、年龄增长与长期就业竞争力的思考。
- **最想保留的点**｜不盲目转行、不依赖高强度出差；把已有 ERP 实施和 ABAP 开发经验升级为可迁移的解决方案能力。
- **当前状态**｜M0 目标探索（初始记录；阶段规划为建议草案，尚待批准）。
- **下次打开时**｜确认可投入学习时间、优先岗位、技术短板与第一个练习项目。

## 已确认背景（2026-11-23）
- 年龄约 31 岁，现任 SAP ABAP 开发；当前工作预计相对稳定 1–2 年，无迫在眉睫的裁员风险。
- 前一份工作约 2.5 年，参与 ERP 实施与开发，曾与业务部门对接流程、需求、功能和接口方案。
- 当前岗位近 3 年以按需求开发为主，较少直接参与业务沟通与方案设计。
- 核心业务经验：MM 采购、库存、收货；QM 质量检验；熟悉 PP BOM，但不熟 Routing；SD 有部分流程认知；FI/CO 基础薄弱；另有少量 PM 接触，深度待核实。
- 技术经验：ABAP、BAPI、标准程序 Debug、接口与 HANA 性能问题；具体熟练程度仍需通过项目案例验证。
- 当前工作日 8 小时，通常约 5–6 小时实际工作量；学习应安排在公司许可的合理空档，不影响岗位职责。
- 有家庭与年幼子女；希望工作稳定、尽量少长期出差，可接受适度加班。

## 目标与非目标
**长期目标**：形成“SAP MM/QM 业务理解 + ABAP/S/4HANA 技术架构 + 企业 AI 集成”复合竞争力，并具备可展示的成果和可迁移技能。

**近期目标**：不急于辞职；建立持续学习机制，补齐跨模块基础，逐步恢复业务方案能力。

**非目标**：立即转做高频出差实施顾问、从零转纯 AI 算法工程师、在未经授权情况下使用企业生产数据或代码训练/调用外部 AI。

## 工作与家庭边界
- 优先考虑企业内部 SAP Technical Lead、SAP Application Specialist、技术方案/集成类岗位；实际出差与加班需按岗位核实。
- 学习以工作日合理空档为主，不把夜间家庭时间作为默认资源。
- AI 实践优先使用模拟/脱敏数据、公开文档与合规环境；企业内部资料须经授权。
- 不以 35 岁作为硬性失业期限；以可验证能力与岗位选择权评估进展。

## 初步能力发展路线（建议，未审批）
1. **0–1 个月｜能力盘点与习惯建立**：梳理实施/开发案例、技术栈、目标岗位 JD；形成每周可执行学习节奏。
2. **1–3 个月｜SAP 深化**：MM/QM 核心链路，MM 与 FI/CO 的 GR/IR、库存估价及凭证关系；补足 PP/SD 必要集成；ABAP 性能与标准增强。
3. **3–6 个月｜架构与可迁移成果**：CDS、RAP、OData/API、Clean Core 与接口治理；以模拟数据完成一份 SAP 技术方案及可复现 Demo。
4. **6–12 个月｜SAP × AI 实践**：基于许可数据制作 AI 辅助排障或采购/质检知识检索原型，建立验证、权限与审计设计。
5. **12–24 个月｜职业竞争力验证**：持续优化作品集、履历、岗位市场验证与面试能力；根据家庭和市场情况调整路线。

以上时间为建议区间，不构成学习成果或求职结果保证。

## 初步学习节奏
建议从每周 4–5 个工作日、每次 30–60 分钟开始，按真实工作负荷调整；每周留下一个可检验成果（笔记、代码练习、案例或方案），每月复盘一次。具体时间表待 M0 审批后确定。

## 项目治理
- **AI-Workflow**：V1.1 固定提交 `939ec44036d89cd91622ab96b938be9f02479026`。
- **当前里程碑**：M0 目标探索；本次授权仅建立项目并记录初始资料，不代表 M0 已通过或授权进入 M1。
- **后续流程**：按 IdeaLab 根 README、AGENTS、AI-Workflow 规范执行，主要阶段须人工审批。
- **隐私**：IdeaLab 为可公开阅读的仓库，避免存放薪酬、具体雇主、家庭成员身份、私有工作代码与其他敏感个人资料。

## 文档
- [初始职业背景与约束](notes/2026-11-23-baseline.md)
- [初步学习与阶段规划](plans/roadmap-v0.1.md)

