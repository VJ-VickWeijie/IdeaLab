# CareerOS V0.3｜跨 Work 窗口统一交接入口

更新时间：2026-11-26（Asia/Shanghai）  
状态：**CareerOS 项目级 M3 门禁调整已获所有者批准；按新门禁进行 M3 独立收尾复核；M3 阶段验收待提交所有者；M4 未授权。99 篇正式文章仍全部未完成。**

## 当前仓库与提交

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 活跃 PR：[PR #20｜V0.3 阶段评审、范围与来源计划](https://github.com/VJ-VickWeijie/IdeaLab/pull/20)，仍开放、未合并；不自行合并。
- 工作分支：careeros-v03-m0-review-20261125。
- 2026-11-26 本轮接手时已核实 PR #20 有 143 个提交、67 个变更文件，head 为 03e3f2624665e3be9107b2d580c7e5c71371cd55；其后已向同一分支提交所有者批准的门禁记录、99 项文章级分流和计划修订。**以下 SHA 是本轮更新前的基线；HANDOFF 后续更新也会推进 head。每次接手必须先实时查询 PR #20 与该分支的当前 SHA，并更新本节，不得将历史 SHA 当作当前 head。**
- PR #20 之后未发现其他 CareerOS PR。PR #19 已合并。
- 最新操作应以 GitHub PR #20 当前 head、而非本文件的历史数字为准。AI-Workflow 固定提交：939ec44036d89cd91622ab96b938be9f02479026。

## 当前里程碑与审批

| 项目 | 当前状态 |
| --- | --- |
| M0、M1、M2 | 已获所有者批准；无需重做或重新审批 |
| 99 篇正式文章范围 | 已批准，范围不变 |
| 11 个纯结构导航分类 | 已批准；不计为文章 |
| M3 | 门禁调整已获所有者批准；本轮独立收尾复核进行中，之后提交 M3 阶段验收 |
| M4 | 未授权。门禁提案获批且 M3 复核后，仍需所有者明确授权 M4 |
| PR #20 | 开放、未合并；沿用当前分支继续，未经所有者指示不合并 |

## 已完成的本次接续工作

- 读取实际分支上的 IdeaLab README、AGENTS.md、AI-Workflow 接入说明、CareerOS README、知识树、Work handoff、reviews README、审核轮次变更、M3 独立门禁审计、M3 汇总复核及 99 项控制矩阵。
- 读取固定版 AI-Workflow V1.1 的 LIFECYCLE、TEAM、GATES、MODEL_SELECTION 和 WORK_CODEX 规则；没有修改通用 AI-Workflow 规则。
- 核对 PR #20、工作分支 head、PR 历史及最新提交；确认 #20 仍开放，#19 已合并。
- 普通用户／零基础读者、资深 SAP 配置顾问、普通 SAP 开发人员三个真实独立执行上下文各自完成 M3/M4 策略评估。意见已记录在 reviews/work/2026-11-26-m3-batched-transition-review.md；这不是正式文章审查，也没有重新核验 SAP 原始资料。
- 新增待审批方案 plans/m3-closeout-batched-m4-proposal-2026-11-26.md；在 CareerOS README 加入本交接入口和提案链接；已更新 PR #20 描述。
- 矩阵有 99 个唯一文章 ID／路径；五个重点缺口保持开放。来源登记、控制矩阵、结构审查和文献研究不计入正式文章完成或审核。

## 正在执行的事项

- 依已获批准的项目级门禁复核 M3 计划是否覆盖 99 项范围与依赖、计划级分流、五项文章级风险限制、批次准入、真实角色审查、严重缺陷回退、交接和每批容量核实方法。
- 普通读者、资深 SAP 配置顾问、普通 SAP 开发人员将对当前已提交的 M3 收尾资料做独立复核。此复核不计为正式文章审核，不重做 SAP 来源研究。
- 正式文章写作尚未开始。M4 尚未获授权。

## 下一项明确任务

1. 完成当前分支的三角色独立 M3 收尾复核，针对新门禁出具通过／需修订／未验证结论，说明具体范围与依据。
2. 修复并复验该复核提出的阻断或严重问题；更新复核记录、README、PR #20 摘要和本 HANDOFF。
3. 若新门禁复核通过，将 CareerOS M3 阶段成果提交所有者验收。只有所有者批准 M3 阶段转换后，才提交／等待 M4 全量分批建设授权。
4. M4 获批后，按 99 项分流选 3～5 篇首批候选，逐篇补 M4 claim-level 准入和课程依赖；开工前确认三个独立角色上下文及当期额度。后续持续构建全部 99 篇，不止于首批。
5. 每个工作包完成后更新本文件并提交到原 PR／分支。严重缺陷未修复时不得通过，不因完成 5～10 轮自动放行。

所有者已批准项目级门禁调整，不代表 M3 阶段验收或 M4 授权。

## 未解决问题与阻碍

- FI-07：普通库存采购的目标版完整分录、税与自动科目规则未闭合。
- PROCESS-01：完整 P2P 逐事件借贷、配置、异常与实际付款链未闭合。
- MM-09：普通估价库存收货方向及 BSX／WRX／OBYC 规则证据不充分。
- ABAP-02：目标系统参数、性能与异常验证未完成；不得承诺通用安全阈值、TRY...CATCH 预测或保证避免 dump。
- ABAP-04：BAPI_PO_CREATE1 函数级提交／回滚、WAIT、RETURN 和失败合同未获目标版直接证实。
- 逐篇直接证据应支持拟写主张；来源冲突的断言要缩窄、删去或暂缓，不可用“待验证”标签保留为肯定事实。
- 目标系统配置、权限、性能、实际凭证及代码运行结果是环境专属事项；没有对应环境验证就不能称为已实测。系统实机验证不是所有一般文章的前提。
- 已有 2026-11-26 独立 M3 门禁审查以旧 head bb6ee527 为基线；后续控制矩阵在 b18f3cdf 更新并有结构审阅。结构检查不关闭五项事实缺口，也不等同于逐篇证据出口判定。

## 当前真实交付统计

| 指标 | 数量／状态 |
| --- | --- |
| 正式文章完成 | 0 / 99 |
| 正式文章有效审核闭环 | 0 |
| M3 | 未通过 |
| M4 | 未授权 |
| SAP 实机验证 | 未连接／未执行 |
| 11 个结构导航分类 | 已批准，纯结构 |

## 产品决策（继续有效）

CareerOS 面向个人职业成长；以 SAP S/4HANA 2021 On-Premise 为主版本，ECC 仅作必要差异比较；范围为 MM、QM、SD、PP、FI、CO、ABAP、S/4HANA 技术架构、SAP × AI、统一业务流程、系统课程及 24 个月成长路线。中文为主、保留英文术语；FI/CO 从零解释。每篇文章应讲清业务原因、完整流程、配置、T-Code、数据模型及跨模块关联。以文字学习为主，练习可选，不依赖生产系统操作权限。

## 关键文件索引

- 总入口：ideas/CareerOS/README.md
- 范围／架构：ideas/CareerOS/architecture/knowledge-tree-v0.3.md
- 当前 99 项矩阵：ideas/CareerOS/plans/m3-item-control-matrix-v0.3.md
- M3 资源与证据门禁：ideas/CareerOS/plans/m3-evidence-resource-control-v0.3.md
- M3 门禁调整与审批记录：ideas/CareerOS/plans/m3-closeout-batched-m4-proposal-2026-11-26.md
- 99 项文章级 M3 分流：ideas/CareerOS/plans/m3-item-readiness-triage-v0.3.md
- 三角色门禁评估：ideas/CareerOS/reviews/work/2026-11-26-m3-batched-transition-review.md
- M3 门禁审计旧基线：ideas/CareerOS/reviews/work/2026-11-26-m3-gate-audit.md
- 文章审核协议：ideas/CareerOS/reviews/README.md
- 所有者已批准轮次调整：ideas/CareerOS/reviews/work/review-rounds-change-2026-11-25.md
- Work 交接与完整范围协议：ideas/CareerOS/plans/work-handoff-v0.3.md
- IdeaLab 通用启动规则：README.md、AGENTS.md、docs/AI_WORKFLOW_INTEGRATION.md

## 新窗口可直接使用的接手指令

接手 GitHub 仓库 VJ-VickWeijie/IdeaLab 的 CareerOS V0.3。先实时读取 PR #20 和分支 careeros-v03-m0-review-20261125 的状态、当前 HEAD SHA 与本 HANDOFF.md，再按 IdeaLab README、AGENTS.md、CareerOS README、当前提案／矩阵及 AI-Workflow 固定提交 939ec44036d89cd91622ab96b938be9f02479026 的顺序恢复工作。不要重复 M0/M1/M2 或已有资料研究。M3 门禁调整已获所有者批准；当前正在完成 M3 独立收尾复核。未取得 M3 阶段验收及明确 M4 授权前，不开始正式文章。维护全部 99 篇目标、五项开放缺口、每篇三角色各按需 5～10 个审核闭环和真实记录；不要合并 PR。完成每个工作包后先更新 HANDOFF.md 和 PR 状态摘要，再提交。
