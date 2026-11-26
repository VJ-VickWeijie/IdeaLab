# CareerOS V0.3｜跨 Work 窗口统一交接入口

更新时间：2026-11-26（Asia/Shanghai）  
状态：**M3 未通过；M4 未获授权；99 篇正式文章仍全部未完成。**

## 当前仓库与提交

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 活跃 PR：[PR #20｜V0.3 阶段评审、范围与来源计划](https://github.com/VJ-VickWeijie/IdeaLab/pull/20)，仍开放、未合并；不自行合并。
- 工作分支：careeros-v03-m0-review-20261125。
- 接手时已核实 PR #20 有 139 个提交、64 个变更文件，head 为 b18f3cdf9c46fb3381950ddaf6f5aa0a0b86af56；之后本工作包在原分支继续提交了角色评估、M3/M4 提案和 README 入口。**本文件的 GitHub 写入也会推进 head；下一次接手必须先实时查询 PR #20 与该分支的当前 SHA，并更新本节，不得把本段旧 SHA 当作当前 head。**
- PR #20 之后未发现其他 CareerOS PR。PR #19 已合并。
- 最新操作应以 GitHub PR #20 当前 head、而非本文件的历史数字为准。AI-Workflow 固定提交：939ec44036d89cd91622ab96b938be9f02479026。

## 当前里程碑与审批

| 项目 | 当前状态 |
| --- | --- |
| M0、M1、M2 | 已获所有者批准；无需重做或重新审批 |
| 99 篇正式文章范围 | 已批准，范围不变 |
| 11 个纯结构导航分类 | 已批准；不计为文章 |
| M3 | 未通过。已提交“按批次验收”项目级门禁调整提案，等所有者决定 |
| M4 | 未授权。门禁提案获批且 M3 复核后，仍需所有者明确授权 M4 |
| PR #20 | 开放、未合并；沿用当前分支继续，未经所有者指示不合并 |

## 已完成的本次接续工作

- 读取实际分支上的 IdeaLab README、AGENTS.md、AI-Workflow 接入说明、CareerOS README、知识树、Work handoff、reviews README、审核轮次变更、M3 独立门禁审计、M3 汇总复核及 99 项控制矩阵。
- 读取固定版 AI-Workflow V1.1 的 LIFECYCLE、TEAM、GATES、MODEL_SELECTION 和 WORK_CODEX 规则；没有修改通用 AI-Workflow 规则。
- 核对 PR #20、工作分支 head、PR 历史及最新提交；确认 #20 仍开放，#19 已合并。
- 普通用户／零基础读者、资深 SAP 配置顾问、普通 SAP 开发人员三个真实独立执行上下文各自完成 M3/M4 策略评估。意见已记录在 reviews/work/2026-11-26-m3-batched-transition-review.md；这不是正式文章审查，也没有重新核验 SAP 原始资料。
- 新增待审批方案 plans/m3-closeout-batched-m4-proposal-2026-11-26.md；在 CareerOS README 加入本交接入口和提案链接；已更新 PR #20 描述。
- 矩阵有 99 个唯一文章 ID／路径；五个重点缺口保持开放。来源登记、控制矩阵、结构审查和文献研究不计入正式文章完成或审核。

## 正在等待的事项

当前没有正式文章写作或 SAP 资料复查在执行。等待所有者审阅提案并决定是否：

1. 批准把项目级 M3 规划收尾与逐批 M4 文章事实验收分开；五项重点缺口成为具体主张／文章的准入限制。
2. 在 M3 计划按批准的新条件通过复核后，授权 Work 依批次完成全体 99 篇；首批建议从 3～5 篇证据边界清楚、依赖少、且不依赖五项未闭合核心事实的文章中选取。

已批准的 M0、M1、M2 不需再次批准。每篇文章三个角色各按需 5～10 个有效闭环、每篇合计 15～30 个的审核规则继续有效；该规则不在本提案中变更。没有新决定前，不开始 M4 正文建设。

## 下一项明确任务

取得所有者对上述两项提案的决定。若批准：

1. 将批准措辞、日期、范围与新门禁版本记录到 CareerOS，并依规则完成 M3 独立复核。
2. 从 99 项矩阵筛选 3～5 篇低依赖、来源边界清楚的首批文章；记录每篇范围、目标版本、主张—来源对应、缺口排除项及课程依赖。
3. 开工前确认实际写作上下文以及普通读者、配置顾问、开发者三个独立审查上下文和该批可用容量；不能确认的角色不虚构，未完整审核的文章不计完成。
4. 获得 M4 明确授权后才开始正式文章；逐批持续建设，直到 99 篇、业务流程、课程与审核记录全部完成，不把首批作为最终交付。
5. 每完成一个独立工作包，更新本文件并提交到本 PR／分支。每篇 5～10 轮后仍有严重缺陷须继续修复与复验，不能自动通过。

若所有者不批准门禁调整，则保持现行 M3/M4 状态，按其反馈修订提案；不自行放宽门禁。

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
- M3/M4 待审方案：ideas/CareerOS/plans/m3-closeout-batched-m4-proposal-2026-11-26.md
- 三角色门禁评估：ideas/CareerOS/reviews/work/2026-11-26-m3-batched-transition-review.md
- M3 门禁审计旧基线：ideas/CareerOS/reviews/work/2026-11-26-m3-gate-audit.md
- 文章审核协议：ideas/CareerOS/reviews/README.md
- 所有者已批准轮次调整：ideas/CareerOS/reviews/work/review-rounds-change-2026-11-25.md
- Work 交接与完整范围协议：ideas/CareerOS/plans/work-handoff-v0.3.md
- IdeaLab 通用启动规则：README.md、AGENTS.md、docs/AI_WORKFLOW_INTEGRATION.md

## 新窗口可直接使用的接手指令

接手 GitHub 仓库 VJ-VickWeijie/IdeaLab 的 CareerOS V0.3。先实时读取 PR #20 和分支 careeros-v03-m0-review-20261125 的状态、当前 HEAD SHA 与本 HANDOFF.md，再按 IdeaLab README、AGENTS.md、CareerOS README、当前提案／矩阵及 AI-Workflow 固定提交 939ec44036d89cd91622ab96b938be9f02479026 的顺序恢复工作。不要重复 M0/M1/M2 或已有资料研究。当前 M3/M4 分批方案仍待所有者批准，未获明确批准前不要开始正式文章。维护全部 99 篇目标、五项开放缺口、每篇三角色各按需 5～10 个审核闭环和真实记录；不要合并 PR。完成每个工作包后先更新 HANDOFF.md 和 PR 状态摘要，再提交。
