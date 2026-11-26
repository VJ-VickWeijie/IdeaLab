# CareerOS V0.3｜跨 Work 窗口统一交接入口

更新时间：2026-11-26（Asia/Shanghai）  
状态：**M3 项目级计划出口已由三角色独立复核通过；M3 阶段验收待所有者；M4 未授权。正式文章仍为 0/99。**

## 当前仓库、分支与 PR

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 活跃 PR：[PR #20｜V0.3 阶段评审、范围与来源计划](https://github.com/VJ-VickWeijie/IdeaLab/pull/20)，状态 open、未合并；不得自行合并。
- 工作分支：`careeros-v03-m0-review-20261125`，目标分支 `main`。
- 在本次 HANDOFF 同步提交前，实时核实 PR #20：head `b507408bb6dba2f9e8efee75ff3ae5f61e704137`，159 commits，69 changed files，mergeable/clean；本 HANDOFF 更新本身会再产生一个提交。**接手时必须实时读取 PR #20 和工作分支的 head；本节记录的 SHA 是 HANDOFF 提交前的最后一次核实值。**
- PR #20 之后没有更新的 PR；PR #19 已于 2026-11-25 合并。
- 本轮最新 M3 收尾报告：[2026-11-26 M3 门禁收尾独立复核](reviews/work/2026-11-26-m3-gate-closeout-review.md)，报告提交 `b87f80d4246ea082ad76ad9ccea7d31fb253056e`。三角色主要内容复核基线为 `ebdd45c1da8c410b460626645a274d0278bbf54b`；审批状态澄清复核至 `ef9bd5478a765ef6b01bbdf850af06459f02d4e7`。AI-Workflow 固定 SHA：`939ec44036d89cd91622ab96b938be9f02479026`。

## 里程碑与审批状态

| 项目 | 当前状态 |
| --- | --- |
| M0、M1、M2 | 已获所有者批准；无需重做或重审 |
| 99 篇正式文章范围 | 已批准；仍是完整最终目标 |
| 11 个纯结构导航分类 | 已批准；不计正式文章 |
| M3 门禁调整 | 已获所有者批准，仅适用于 CareerOS 项目计划出口；未修改 AI-Workflow V1.1 通用门禁 |
| M3 计划出口复核 | 普通读者、资深 SAP 配置顾问、普通 SAP 开发人员均通过 |
| M3 阶段验收 | **待所有者明确验收**；门禁调整批准不等于阶段验收 |
| M4 | **未授权**；须在 M3 阶段验收后由所有者另行明确授权 |
| PR #20 | 开放、未合并；继续沿用当前分支 |

## 已完成

- 按实际 PR #20 分支读取 IdeaLab README、AGENTS、AI-Workflow 集成说明、CareerOS README、知识树、handoff、reviews README、审核轮次决定、M3 审计/汇总与 99 项控制矩阵；读取固定版 AI-Workflow V1.1 相关规则。
- 完成 M3 门禁调整方案；所有者批准将“99 篇全部证据闭合后才允许任何写作”的全局门槛改为计划级 M3 出口与逐批 claim-level M4 准入。
- 为全部 99 个文章 ID 建立保守计划级分流，逐项保留矩阵登记状态、标题/路径、来源与细化计划链接及下一步；与 manifest、控制矩阵逐项比对一致。当前为 65 项“限缩可写”、34 项“暂缓核心”，没有全文就绪分类。
- 三个独立角色对 M3 计划出口完成复核并通过；后续窄范围复核确认门禁调整、M3 阶段验收及 M4 授权三种状态表述清楚。
- 修复 triage 原状态字段的追溯问题，更新 README 与旧计划状态；旧门禁结论和批准前评估已明确标注为历史记录。
- 创建本次 M3 收尾复核报告。该计划复核不计正式文章审核轮次；没有重做 SAP 来源研究或实机测试。
- PR #20 描述与 HANDOFF 应保持同步；本次提交只更新文档，不合并 PR。

## 正在执行／下一项明确任务

M3 计划级复核已完成。下一步是将 M3 阶段结果提交所有者明确验收。当前无需重新执行 M0–M2，也不重复已完成的 SAP 文献研究。

M3 获所有者验收后，才请求单独授权 M4。M4 获批后，先按每篇主张逐项核实和依赖选择 3–5 篇首批正式文章；只有直接证据、版本/场景边界及当期 Work 与三角色真实容量落实后才能写作、审查。之后继续完整建设 99 篇、课程、业务流程与审核记录，不止于首批。

每完成一个独立工作包，更新本 HANDOFF 并提交到 PR #20；每次窗口接手先实时查询 PR 和分支 head。

## 未解决问题与阻碍

以下是**文章/主张级**开放风险；它们限制相关内容，不构成当前计划级 M3 出口的全局阻断：

- **FI-07**：普通库存采购目标版完整借贷、税务与自动科目规则未闭合；已核实的 GR/IR、MAP 特例只能按来源场景限定。
- **PROCESS-01**：完整 P2P 逐事件借贷、配置、异常与实际资金链未闭合；payment media 不证明银行扣款。
- **MM-09**：普通估价库存收货方向、BSX/WRX/OBYC 规则与配置权限证据不足。
- **ABAP-02**：没有通用内存安全阈值；不得声称 TRY...CATCH 可预警/拦截/停止 warning dump 或保证避免 dump。目标系统参数、性能和运行行为需环境证据。
- **ABAP-04**：一般 LUW 资料不能替代 BAPI_PO_CREATE1 的函数级提交/回滚、WAIT、RETURN、失败或 RFC 合同；证据不足的代码不得写成目标版本保证。
- 其余文章同样必须在进入具体 M4 批次前做主张级证据核对。适用条件可限定，但不能用“待验证”把无证据的肯定断言留在正文。

## 当前真实交付统计

| 指标 | 数量／状态 |
| --- | --- |
| 正式文章 | 0 / 99 |
| 正式文章有效审核闭环 | 0 |
| 每篇正式文章的目标审核规则 | 三角色各按需 5～10 个有效闭环，每篇合计 15～30；严重缺陷未修复及复验时不得通过 |
| M3 计划级复核 | 通过 |
| M3 阶段验收 | 待所有者 |
| M4 建设 | 未授权 |
| SAP 实机测试 | 未连接／未执行 |
| 11 个结构导航分类 | 已批准，不计文章 |

## 产品决策（继续有效）

CareerOS 是个人职业成长 SAP 学习知识库；主版本 SAP S/4HANA 2021 On-Premise，ECC 仅作必要差异对比。范围含 MM、QM、SD、PP、FI、CO、ABAP、S/4HANA 技术架构、SAP × AI、统一业务流程、系统课程和 24 个月成长路线。中文为主，保留英文 SAP 术语；FI/CO 从零讲解。文章需解释业务原因、完整流程、配置、T-Code、数据模型及跨模块关联。以文字阅读为主，练习可选，不依赖生产系统权限。

## 关键文件索引

- 总入口：[README](README.md)
- M3/M4 批次门禁与所有者决定：[门禁调整方案](plans/m3-closeout-batched-m4-proposal-2026-11-26.md)
- 三角色 M3 收尾结论：[复核报告](reviews/work/2026-11-26-m3-gate-closeout-review.md)
- 99 项分流：[文章级准入分类](plans/m3-item-readiness-triage-v0.3.md)
- 99 项控制矩阵：[M3 控制矩阵](plans/m3-item-control-matrix-v0.3.md)
- 资源与证据门禁：[M3 资源控制计划](plans/m3-evidence-resource-control-v0.3.md)
- 范围／架构：[知识树](architecture/knowledge-tree-v0.3.md)
- 文章审核规则：[reviews README](reviews/README.md)
- Work 交接与完整目标：[Work handoff](plans/work-handoff-v0.3.md)
- 原门禁历史审计：[旧 M3 门禁审计](reviews/work/2026-11-26-m3-gate-audit.md)
- 通用启动规则：仓库根 README、AGENTS.md、docs/AI_WORKFLOW_INTEGRATION.md

## 新窗口可直接使用的接手指令

接手 GitHub 仓库 `VJ-VickWeijie/IdeaLab` 中的 CareerOS V0.3。先实时读取 PR #20、分支 `careeros-v03-m0-review-20261125` 的状态和最新 HEAD，再读本 HANDOFF、仓库 README/AGENTS/AI-Workflow 接入规则、CareerOS README、[M3 收尾复核报告](reviews/work/2026-11-26-m3-gate-closeout-review.md)、[门禁方案](plans/m3-closeout-batched-m4-proposal-2026-11-26.md)、[99 项分流](plans/m3-item-readiness-triage-v0.3.md)及本轮所需的关联文件。门禁调整已获所有者批准且三角色计划级复核通过；下一步将 M3 阶段提交所有者验收。M4 未授权；M3 阶段验收和 M4 建设是两个独立决策。不要重复 M0–M2 或既有 SAP 研究，不合并 PR，不把计划复核计作文章审核。坚持完整 99 篇目标、五项开放风险边界和每篇三角色各按需 5～10 轮规则；每个工作包完成后更新本 HANDOFF。
