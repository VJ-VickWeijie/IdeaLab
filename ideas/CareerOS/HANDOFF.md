# CareerOS V0.4｜跨 Work 窗口统一交接入口

更新时间：2026-11-26（Asia/Shanghai）  
状态：**M3 已验收；M4 完整 99 篇分两批建设已授权。FI-01～FI-03 所有者已接受（3/99）；FI-05、MM-01、MM-02、MM-03 已完成三角色 review（15、16、15、18 个有效闭环），均待所有者验收。批次 A 进行中，4/50 reviewed、0/50 owner accepted；FI-04/FI-06 因证据缺口保持 drafting。**

## 当前仓库、分支与 PR

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 当前 PR：[PR #21｜CareerOS M4 全量分批建设](https://github.com/VJ-VickWeijie/IdeaLab/pull/21)，目标 `main`；开放、未合并。Work 不自行合并。
- 工作分支：`careeros-v04-m4-batch1-20261126`。
- PR #20 已合并到 `main`；基线提交 `db349fe68e1aa0560ba5546a6382ffe503d0f595`。
- 本次 HANDOFF 更新前最近一次进度提交：`f849e2c1334d02e34327dd93c867635ea36d057e`；本 HANDOFF 提交会继续推进分支。新窗口接手时必须实时核查最新 HEAD。
- AI-Workflow V1.1 固定 SHA：`939ec44036d89cd91622ab96b938be9f02479026`。未更改通用门禁。

## 里程碑、授权与产品边界

| 项目 | 当前状态 |
| --- | --- |
| M0、M1、M2 | 已获所有者批准，无需重做 |
| M3 | 已由所有者验收 |
| M4 | 已批准完整 99 篇分批建设；先完成 3 篇查看后继续两批 |
| 最终交付 | 99 篇正式文章，以及相应课程、统一业务流程和真实逐篇审核记录 |
| 主版本 | SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比 |
| 阅读方式 | 中文为主，保留英文 SAP 术语；文字阅读优先，练习可选，不依赖生产系统写权限 |
| 三角色规则 | 普通读者、资深 SAP 配置顾问、普通 SAP 开发人员；每篇每角色按需 5～10 个有效闭环；严重缺陷修复和复验前不通过 |
| AI-Workflow | 固定版本 SHA 不变；没有擅自跳过或修改通用审批门禁 |

所有者最新决定：“看了，很棒，甚至有点超出我预期了。接下来分两批完成剩余的篇章。”据此，FI-01～FI-03 计为 owner accepted；完整目标是剩余 96 篇，而非只做样稿。

## 已完成

- PR #20 的 M3 结果已并入 main；沿用现有 M4 分支和 PR #21，不丢弃成果、不另开 PR。
- FI-01～FI-03 已完成三角色审核，共 52 个闭环：FI-01 17、FI-02 15、FI-03 20；所有者已审阅肯定，正式接受计数更新为 3/99。
- FI-04～FI-06 已完成首轮三角色审查，并保存问题、答复、修改和原角色复核记录。45 条首轮意见中，38 条确认闭环；没有把尚未解决的 SAP 2021 目标证据缺口计为通过。
- FI-05 已达到普通读者、配置顾问、开发者各 5 个有效闭环，状态 `reviewed`。
- FI-04 与 FI-06 的问题边界已写入正文；没有 SAP 固定版证据的断言没有作为肯定事实写出。
- MM-01 已完成 16 个有效闭环：普通读者 5、配置顾问 5、开发者 6（含组织映射严重问题的额外闭环）；状态 reviewed，尚未计入所有者接受数。Work 直接复读 2021.000 SAP 页面；顾问/读者工具无法独立重开固定版页面这一限制已写入文章与审核记录。
- MM-02 已完成 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；状态 reviewed，待所有者验收。固定版信息类别表按 SAP 2021 页面七类校准；采购视图/采购组织、库存范围、BP role/CVI role category 和 FLVN 示例边界均经三角色复核。审核记录见 `reviews/work/2026-11-26-m4-mm02-three-role-review.md`，台账已补入材料类型来源范围。
- MM-03《采购信息记录与货源决定》已完成 18 个有效闭环：普通读者 5、配置顾问 7、开发者 6；状态 reviewed，待所有者验收。统一当前 FSD 11.0/SPS10 动态版的版本与章节标记；限定采购信息记录、货源清单、配额安排的高层功能；澄清供应商简称与具体来源对象，修复文章到 MM-04 及 M3 证据台账的相对链接。审核记录见 `reviews/work/2026-11-26-m4-mm03-three-role-review.md`。
- 没有连接 SAP 系统或执行实机测试；没有声称验证客户配置、权限或生产凭证。

## 正在执行与下一项明确任务

**当前里程碑：M4 批次 A（50 篇模块知识）。**  
当前已复核文章和 FI-04～FI-06 A01 工作包状态：

| 文章 | 审查闭环 | 状态 | 未解决事项 |
| --- | ---: | --- | --- |
| MM-01 组织结构与采购业务对象 | 16/16 | reviewed（待所有者验收） | 固定版来源由 Work 直接核对；顾问无法独立重开页面，限制已记录 |
| MM-02 物料主数据与供应商业务伙伴 | 15/15 | reviewed（待所有者验收） | 来源表已按固定版七类校正；客户字段/角色配置与数据模型不作未证实推断 |
| MM-03 采购信息记录与货源决定 | 18/18 | reviewed（待所有者验收） | 高层功能有来源；具体来源选择优先级、有效期边界与 quota 算法仍待详细资料；FSD 为动态链接，已披露快照限制 |
| FI-04 公司代码、会计科目表与总账科目 | 14/15 | drafting | SAP S/4HANA 2021 公司代码的一般定义/组织用途缺少直接证据 |
| FI-05 会计凭证、过账与冲销 | 15/15 | reviewed | 等待后续所有者审阅；无已知严重角色问题 |
| FI-06 应付与应收 | 9/15 | drafting | 客户/供应商子账与总账、目标版 open item/clearing、部分付款/剩余项目缺固定版证据 |

下一项明确任务：继续批次 A，按批准路径 `knowledge/MM/02-functions/requisition-po.md` 建设 MM-04《采购申请与订单机制》。先读取逐篇准入分流、MM-04 来源台账和现有文章依赖；逐主张核验手工/需求驱动 PR、PR→PO 转换/参考、审批配置和真实事务证据。为保持 S/4HANA 2021 范围，逐项标注 2021.000 固定页面或 FSD SPS10 动态来源；不以 2025/2026 后续版本补写 2021 规则。若证据不足，讲已证实的文档功能、边界及待核项，不虚构完整转换变体、审批决定算法或可用事务权限。FI-04/FI-06 继续在独立队列，不阻塞 MM-04。

每个独立工作包都要提交文章、真实审核记录、状态和本 HANDOFF 更新到 PR #21。不要把计划、来源登记、导航或草稿统计成正式接受文章；不要合并 PR。

## 未解决问题与证据边界

继承自 M3 的主题级开放边界，限制相关主张，但不阻止独立文章：

- **FI-07**：普通库存采购完整借贷、税务及自动科目规则未闭合。
- **PROCESS-01**：完整 P2P 逐事件借贷、异常路径与实际付款资金链未闭合；不能从 payment media 推断银行扣款。
- **MM-09**：普通估价库存收货方向、BSX/WRX/OBYC 规则与配置证据未闭合。
- **ABAP-02**：无通用内存安全阈值；不得声称 TRY...CATCH 可预警/拦截 warning dump 或保证避免 dump。
- **ABAP-04**：一般 LUW 资料不能替代 BAPI_PO_CREATE1 函数级事务、WAIT、RETURN、失败和 RFC 调用合同。

本次新确认的文章级阻碍：

- **FI-04**：2021 Direct Transfer 迁移资料只能支持特定迁移范围内的 CoCd/CoA/G/L 视图关系；不能推出完整公司代码定义、法律主体对应或日常组织规则。
- **FI-06**：2021 客户/供应商行项目应用材料不足以证明子账—总账关系、具体未清项/清账状态、部分付款与剩余项目规则。
- 对受阻主张要继续寻找固定版直接来源。明确无法取得来源时，保留边界并限缩篇章目标；不得用更近版本文档冒充 2021，也不得把“待验证”包装成确定系统事实。

## 当前真实进度

| 指标 | 数量/状态 |
| --- | --- |
| 正式接受文章 | **3/99**（FI-01～FI-03） |
| 批次 A | **4/50 已角色 reviewed（FI-05、MM-01、MM-02、MM-03）；0/50 已由所有者接受。** FI-04/FI-06 仍 drafting |
| 批次 B | **0/46 开始**；待批次 A 完成 |
| FI-01～FI-03 角色审核闭环 | 52 |
| MM-01 审查 | 16 个有效闭环：普通读者 5、配置顾问 5、开发者 6；reviewed，待所有者验收 |
| MM-02 审查 | 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；reviewed，待所有者验收 |
| MM-03 审查 | 18 个有效闭环：普通读者 5、配置顾问 7、开发者 6；reviewed，待所有者验收 | 
| FI-04～FI-06 首轮审查 | 38/45 个问题完成闭环；FI-04 14/15、FI-05 15/15、FI-06 9/15 |
| SAP 实机测试 | 0；未连接 |
| 11 个纯结构导航类别 | 已批准，不计文章 |

## 关键文件索引

- [CareerOS README](README.md)
- [本次 M4 两批执行计划](plans/m4-two-batch-execution-2026-11-26.md)
- [FI-04 公司代码/科目表/G/L](knowledge/FI/02-functions/company-code-gl.md)
- [FI-05 凭证/过账/冲销](knowledge/FI/02-functions/posting-reversal.md)
- [FI-06 应付/应收](knowledge/FI/02-functions/payables-receivables.md)
- [FI-04～FI-06 三角色审查与证据收尾记录](reviews/work/2026-11-26-m4-batch-a01-fi04-fi06-review.md)
- [MM-01 组织结构文章](knowledge/MM/01-foundations/organization-objects.md)
- [MM-01 三角色审查记录](reviews/work/2026-11-26-m4-mm01-three-role-review.md)
- [MM-02 物料主数据与 BP](knowledge/MM/01-foundations/material-business-partner.md)
- [MM-02 三角色审查记录](reviews/work/2026-11-26-m4-mm02-three-role-review.md)
- [MM-03 采购信息记录与货源决定](knowledge/MM/02-functions/info-record-sourcing.md)
- [MM-03 三角色审查记录](reviews/work/2026-11-26-m4-mm03-three-role-review.md)
- [首批 FI-01～FI-03 审核答复记录](reviews/work/2026-11-26-m4-batch01-round1-response.md)
- [首批执行日志](reviews/work/2026-11-26-m4-batch01-execution-log.md)
- [M3 99 项控制矩阵](plans/m3-item-control-matrix-v0.3.md)
- [M3 逐篇准入分流](plans/m3-item-readiness-triage-v0.3.md)
- [多角色审核与记录规则](reviews/README.md)
- [M3/M4 收尾方案与所有者决定](plans/m3-closeout-batched-m4-proposal-2026-11-26.md)

## 新窗口可直接使用的接手指令

接手 GitHub 仓库 `VJ-VickWeijie/IdeaLab` 中的 CareerOS。先实时读取 PR #21、分支 `careeros-v04-m4-batch1-20261126`、`main` 和 PR #20 的状态及最新 HEAD；PR 不合并。然后读取本 HANDOFF、CareerOS README、[M4 两批执行计划](plans/m4-two-batch-execution-2026-11-26.md)、[本批 FI-04～FI-06 审查记录](reviews/work/2026-11-26-m4-batch-a01-fi04-fi06-review.md)、reviews/README、知识树和当前所选文章对应的控制矩阵/证据登记。M3 已验收；M4 全部 99 篇分批建设已授权。FI-01～FI-03 已获所有者肯定，正式接受 3/99。MM-01（16）、MM-02（15）、MM-03（18）均 reviewed、待所有者验收；批次 A 为 4/50 reviewed、0/50 owner accepted；下一篇 MM-04。不要重复 M0～M3 或已完成的研究；不要把草稿/来源登记算成正式文章；保留五项 M3 证据边界及 FI-04/FI-06 新阻碍；继续批次 A 中可独立写作的文章。每完成一个工作包，真实记录三角色问题、Work 答辩/修改、原角色复核及闭环数，更新本 HANDOFF 并提交到 PR #21。
