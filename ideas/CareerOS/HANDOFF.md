# CareerOS V0.4｜跨 Work 窗口统一交接入口

更新时间：2026-11-26（Asia/Shanghai）  
状态：**M3 已验收；M4 全量分批建设已获所有者授权；首批 FI-01～FI-03 已形成初稿，等待真实三角色审核。正式完成仍为 0/99。**

## 当前仓库、分支与 PR

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 当前 M4 PR：[PR #21｜M4 首批 3 篇 FI 基础文章草稿](https://github.com/VJ-VickWeijie/IdeaLab/pull/21)，open、draft；不合并。
- 工作分支：careeros-v04-m4-batch1-20261126，目标分支 main。
- PR #20 已合并，合并提交 db349fe68e1aa0560ba5546a6382ffe503d0f595，作为本次 M4 分支基线。
- 首批内容工作包提交：cfc5f5bb66434bff464c4b5692d53c1720228ac0。本 HANDOFF 同步是后续独立提交；接手时请实时读取当前分支 HEAD 与 PR #21。
- 固定 AI-Workflow V1.1 SHA：939ec44036d89cd91622ab96b938be9f02479026。

## 里程碑、授权与决定

| 项目 | 状态 |
| --- | --- |
| M0、M1、M2 | 已获所有者批准，无需重做 |
| M3 | 已由所有者验收 |
| M4 | 已授权对完整 99 篇分批自主建设；首批先做 3 篇供审阅 |
| 最终目标 | 99 篇正式文章、相应课程、业务流程和逐篇真实审核记录 |
| AI-Workflow | 通用门禁未修改 |
| PR 合并 | 未授权 Work 合并；PR #21 等所有者审阅 |

所有者最新指示：“同意，先按你的说法进行M4，先拿3篇来看看。”首批据依赖顺序选 FI-01 → FI-02 → FI-03。

## 已完成

- 实时核对 PR #20 已合并到 main（合并 SHA db349fe…），当前创建 M4 独立阶段 PR #21；没有开放的旧 PR 与本阶段冲突。
- 重新读取 IdeaLab README、AGENTS、AI_WORKFLOW_INTEGRATION、CareerOS README、知识树、Work handoff、reviews README、FI 课程计划、99 项 triage、M3/M4 计划和证据台账。
- 在固定 AI-Workflow SHA 读取 LIFECYCLE、TEAM、GATES、MODEL_SELECTION、WORK_CODEX。
- 对 FI-01～FI-03 做了目标证据核验并建立逐主张边界。主要来源：财政部基本准则 2014 修订官方文本、2024 修订会计法、财政部 2014 会计基础考试大纲、财政部 2026 初级会计考试大纲、SAP S/4HANA 2021 001 Central Finance PDF 的有限英文术语说明。
- 建立 M4 首批准入与来源计划，并写出三篇中文初稿。草稿不扩写五项未闭合风险，不宣称 SAP 实机验证。

## 正在执行／下一项明确任务

开始首批真实三角色审核。每篇文章、每个角色按需 5～10 个有效闭环；每个闭环必须包含实质问题、Work 答复、修订判断/差异、该角色复核。三个角色为普通用户、资深 SAP 配置顾问、普通 SAP 开发人员。实际审查上下文和模型能力需如实记录；不能把模拟写成独立审查。严重缺陷未解决前不通过。

首篇 FI-01 审核完成后，更新其审查记录、修订文稿及本 HANDOFF，再进入 FI-02、FI-03；按可恢复工作包提交 PR #21。

## 当前真实统计

| 指标 | 当前值 |
| --- | --- |
| 有初稿文章 | 3（FI-01、FI-02、FI-03） |
| 正式接受文章 | 0/99 |
| 三角色正式文章审核闭环 | 0 |
| 当前批次角色审核 | 尚待启动 |
| SAP 系统连接/实机测试 | 未连接/未执行 |
| 11 个纯结构分类 | 已批准，仍不计文章 |

## 未解决问题与阻碍

以下五项继续保持 M3 记录的状态，本批不声称解决：

- FI-07：普通库存采购完整借贷、税务与自动科目规则未闭合。
- PROCESS-01：P2P 全链、争议中的 GR/IR 方向、完整异常与付款资金链未闭合。
- MM-09：普通估价库存收货方向、BSX/WRX/OBYC 全规则与配置证据不足。
- ABAP-02：无通用内存安全阈值；不得声称 TRY...CATCH 可提前捕获/停止 warning dump 或保证避免 dump。
- ABAP-04：通用 LUW 资料不能替代 BAPI_PO_CREATE1 的函数级事务、WAIT、RETURN、失败合同及目标版调用证据。

本批文章的 SAP 对应仅用可读原文支持的版本/场景。未被证据支持的技术断言删除、限缩或列作缺口，不靠“待验证”保留肯定表述。

## 关键文件索引

- [CareerOS README](README.md)
- [M4 首批 01 逐主张准入和证据边界](plans/m4-batch-01-fundamentals-2026-11-26.md)
- [FI-01](knowledge/FI/01-foundations/financial-accounting-for-beginners.md)
- [FI-02](knowledge/FI/01-foundations/accounting-equation.md)
- [FI-03](knowledge/FI/01-foundations/debit-credit.md)
- [Work 执行记录](reviews/work/2026-11-26-m4-batch01-execution-log.md)
- [M3/M4 方案及后续所有者决定](plans/m3-closeout-batched-m4-proposal-2026-11-26.md)
- [多角色审核规则](reviews/README.md)
- [M3 99 项准入分流](plans/m3-item-readiness-triage-v0.3.md)
- [M3 控制矩阵](plans/m3-item-control-matrix-v0.3.md)

## 新窗口可直接使用的接手指令

接手 IdeaLab 的 CareerOS。先实时查询 PR #21、分支 careeros-v04-m4-batch1-20261126 和 main 的状态/HEAD；然后读取本 HANDOFF、根 README/AGENTS/AI_WORKFLOW_INTEGRATION、CareerOS README、[M4 首批方案](plans/m4-batch-01-fundamentals-2026-11-26.md)、当前目标文章、对应真实角色审核记录及 reviews/README。M3 已验收，M4 已授权全量 99 篇按批建设；首批 FI-01～FI-03 已有初稿，但正式文章 0/99，审核闭环 0。先从 FI-01 的真实三角色审核闭环继续，不重复已完成来源研究，不将草稿/来源登记/计划当作正式文章，不越过五项开放风险，不自行合并 PR。每完成一个独立工作包，修订文章和审核记录、更新本 HANDOFF，并提交到 PR #21。
