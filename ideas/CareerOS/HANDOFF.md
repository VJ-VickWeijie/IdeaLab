Warning: truncated output (original token count: 21332)
Total output lines: 533

# CareerOS V0.4｜跨 Work 窗口统一交接入口

更新时间：2026-11-27（Asia/Shanghai）  
**当前实时快照**：`main` 起始基线 `c026b3862c9a083c95cffb096f93e141276cfba5`；PR #21 已合并并关闭，不再追加。收尾分支 `careeros-v04-m4-batch-a-closeout-20261127` 已顺序推进至 QM-02；最终正文 blob `53b91de8ccaebf5b69c1a7519e60b023555ee874` 经三个独立 AI reviewer-context 各完成 5 项复核，问题已按证据边界修订并复验通过（15/15）；QM-02 仍因完整跳检/不建批规则、来源 05 映射、手工建批类型选择、一般 QIR、EWM 与财务证据缺口而 Draft。当前固定页面直开不可用，动态 2025 页面未作 2021 证据。新 PR 尚未创建。全库 Owner Accepted 3/99；批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；批次 B 0/46 未开始。工作线游标：W1、W2 已完成；W3 QM-03；W4 QM-06；W5 FI-11。
**独立性与状态**：同一 Work 上下文角色模拟不计 Role Reviewed；15/15 PASS 不自动通过证据门禁。SD-01 经精确正文独立 AI 角色复核后计入 Role Reviewed；SD-02、SD-07、PP-01、PP-07、PP-08、PP-09、QM-01、QM-02 的独立 AI 复核通过当前文案/证据边界检查，但各自仍有 M3 核心证据缺口，保持 Draft。QM-01 三个 reviewer-context 对最终 blob 各完成 5 项复核，边界通过但核心证据未闭合。没有推定所有者接受。未连接 SAP，未执行实机、配置、数据库、API 或权限测试。
**流程版本**：固定 SHA `939ec44036d89cd91622ab96b938be9f02479026` 未更换；IdeaLab 接入文档称 V1.1 正式版，而该固定提交 README 仍称“候选版本”，矛盾已记录于审计报告，待所有者决定是否升级。

## 当前仓库、分支与 PR

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 上一 PR：[#21｜CareerOS M4 全量分批建设](https://github.com/VJ-VickWeijie/IdeaLab/pull/21)，已合并至 `main`；不再向其追加提交。
- 旧工作分支：`careeros-v04-m4-batch1-20261126`，最终 HEAD `02c5ee4518aeb9f079ea81cf1b949a21608f7d19`。
- 当前收尾分支：`careeros-v04-m4-batch-a-closeout-20261127`，起点 `main` HEAD `c026b3862c9a083c95cffb096f93e141276cfba5`。新 PR 尚未创建；批次 A 收尾完成后创建并保持开放，不合并。
- AI-Workflow 固定 SHA：`939ec44036d89cd91622ab96b938be9f02479026`；不变更。正式/候选标记矛盾见[审计报告](reviews/work/2026-11-27-m4-batch-a-reconciliation-audit.md)。
- 本次审计基线时 PR 为 282 commits、113 files changed（+10,200 / -108）；无 PR 评论、review submissions 或该 HEAD commit statuses/checks。
## 里程碑、授权与产品边界

| 项目 | 当前状态 |
| --- | --- |
| M0、M1、M2 | 已获所有者批准，无需重做 |
| M3 | 已由所有者验收 |
| M4 | 已批准完整 99 篇分批建设；FI-01～FI-03 已接受，剩余 96 篇按两批继续 |
| 最终交付 | 99 篇正式文章，以及相应课程、统一业务流程和真实逐篇审核记录 |
| 主版本 | SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比 |
| 阅读方式 | 中文为主，保留英文 SAP 术语；文字阅读优先，练习可选，不依赖生产系统写权限 |
| 三角色规则 | 普通读者、资深 SAP 配置顾问、普通 SAP 开发人员；每篇每角色按需 5～10 个有效闭环；严重缺陷修复和复验前不通过 |
| AI-Workflow | 固定版本 SHA 不变；没有擅自跳过或修改通用审批门禁 |

所有者最新决定：“看了，很棒，甚至有点超出我预期了。接下来分两批完成剩余的篇章。”据此，FI-01～FI-03 计为 owner accepted；完整目标是剩余 96 篇，而非只做样稿。

## 已完成

- PR #20 的 M3 结果已并入 main；PR #21 后续承载 M4 批次 A 起步成果并已合并。当前收尾从最新 main 新开分支，不向旧 PR 追加。
- FI-01～FI-03 已完成三角色审核，共 52 个闭环：FI-01 17、FI-02 15、FI-03 20；所有者已审阅肯定，正式接受计数更新为 3/99。
- FI-04～FI-06 已完成首轮三角色审查，并保存问题、答复、修改和原角色复核记录。45 条首轮意见中，38 条确认闭环；没有把尚未解决的 SAP 2021 目标证据缺口计为通过。
- FI-05 已达到普通读者、配置顾问、开发者各 5 个有效闭环，状态 `reviewed`。
- FI-04 与 FI-06 的问题边界已写入正文；没有 SAP 固定版证据的断言没有作为肯定事实写出。
- MM-01 已完成 16 个有效闭环：普通读者 5、配置顾问 5、开发者 6（含组织映射严重问题的额外闭环）；状态 reviewed，尚未计入所有者接受数。Work 直接复读 2021.000 SAP 页面；顾问/读者工具无法独立重开固定版页面这一限制已写入文章与审核记录。
- MM-02 已完成 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；状态 reviewed，待所有者验收。固定版信息类别表按 SAP 2021 页面七类校准；采购视图/采购组织、库存范围、BP role/CVI role category 和 FLVN 示例边界均经三角色复核。审核记录见 `reviews/work/2026-11-26-m4-mm02-three-role-review.md`，台账已补入材料类型来源范围。
- MM-03《采购信息记录与货源决定》已完成 18 个有效闭环：普通读者 5、配置顾问 7、开发者 6；状态 reviewed，待所有者验收。统一当前 FSD 11.0/SPS10 动态版的版本与章节标记；限定采购信息记录、货源清单、配额安排的高层功能；澄清供应商简称与具体来源对象，修复文章到 MM-04 及 M3 证据台账的相对链接。审核记录见 `reviews/work/2026-11-26-m4-mm03-three-role-review.md`。
- MM-04《采购申请与订单机制》完成 18 个有效闭环：普通读者 5、配置顾问 6、开发者 7；状态 reviewed，待所有者验收。文章按 FSD 高层能力说明 PR/PO、审批及合同/RFQ，区分已证实功能与客户配置条件；补充限额项、RFQ 的初学者说明，并登记“手工指定供应商是否满足后台 source assigned 条件”的未核缺口。三角色审核记录见 `reviews/work/2026-11-26-m4-mm04-three-role-review.md`。
- MM-05《库存类型与货物移动》完成 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；状态 reviewed，待所有者验收。正文区分 2021 SPS10 FSD、固定版 2021.000 应用页和未锁版概念页；限定厂内序列化转移与巴西本地化寄售 K 的支持范围，明确权属推论范围，并保留移动代码、估价和 FI 分录缺口。审核记录见 `reviews/work/2026-11-26-m4-mm05-three-role-review.md`。
- MM-06《收货、退货与冲销》完成 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；状态 reviewed，待所有者验收。正文区分真实收货后退货与记录纠错，限制 FSD 高层描述的推论范围，并明确冲销对象/数量规则、移动类型、发票顺序及 FI 影响仍缺固定版直接证据。SAP 未连接、未做实机测试。记录见 `reviews/work/2026-11-26-m4-mm06-three-role-review.md`。
- MM-07《价格单位、数量单位与换算》完成 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；状态 reviewed，待所有者验收。正文区分 PO 订单单位、订单价格单位和教学用计价数量，例题假设已限定；未推断单位因子存储字段、发票匹配或 BAPI 字段覆盖根因。记录见 `reviews/work/2026-11-26-m4-mm07-three-role-review.md`。
- 没有连接 SAP 系统或执行实机测试；没有声称验证客户配置、权限或生产凭证。

## 最近工作包（工作线 2）：PP-05（2026-11-27）

PP-05《生产订单与确认》最终正文 blob `1fffe1c2b6e8e0817e785f64c11f62e6763a58e0`。动态 SAP S/4HANA 2021 FSD 文档 11.0/SPS10 只支持计划订单转换、TECO/关闭、确认的有限示例及货物移动重处理；同一 `latest` URL 较早索引曾显示 v9.0/SPS08，版本差异与无本地 PDF 哈希均已披露。固定版 2021.000/BJ5 Help 仅按 SAP 官方索引摘要使用，canonical HTML 直开无可读正文；2025 FPS01/FPS02 和无固定版标记页面未作为 2021 规则。普通读者、配置顾问、开发者三个独立 AI reviewer-context 均对最终精确正文完成 5 项复核，15/15 PASS 仅代表来源范围与措辞通过，不是人工 SAP 专家或系统验证。状态机、一般 release 条件、确认取消后果、库存动作触发/失败恢复、完整 API/schema/授权及 FI/CO 规则仍未闭合，故 PP-05 保持 Draft，不计 Role Reviewed。未连接 SAP，未做实机、配置、数据库、API 或权限测试。详见[正文](knowledge/PP/02-functions/production-order.md)、[审查记录](reviews/work/2026-11-27-m4-pp05-three-role-review.md)、[证据台账](plans/evidence-logistics-m3.md)与[逐篇审计](reviews/work/2026-11-27-m4-batch-a-reconciliation-audit.md)。

### PP-04 历史工作包（2026-11-27）

PP-04 最终正文 blob `26d1459be3a9f6999dacc414fb8ca634da793cda`。补入动态 FSD v11.0/SPS10 中 MRP 与 capacity planning 的范围区分，并将 2021.000 J44 与 Planned Orders API 的固定版官方搜索索引摘要明确标为索引证据；对应 canonical HTML 直开为 0 可读行。动态 FSD 同一路径旧索引曾显示 v9.0/SPS08，正文只引用已直接核对的 v11 内容并披露无本地 PDF 哈希。2025 FPS01 动态 Help 页面和转换专用 Simplification List 均没有被当作 2021 通用算法证据。普通读者、配置顾问、开发者三个独立 AI reviewer-context 针对最终正文各完成 5 个有效质询及原角色复核，15/15 PASS 仅表示证据边界与措辞通过； reviewer-context 是独立 AI 上下文，不是人工 SAP 专家。净需求/库存与日期纳入、批量规则、采购来源、计划日期/firming/MRP Live 差异及 API 完整字段和权限仍未闭合，故 PP-04 保持 Draft，不计 Role Reviewed。未连接 SAP、未做实机或 API/数据库/权限测试。详见[正文](knowledge/PP/02-functions/mrp-planned-order.md)、[审查记录](reviews/work/2026-11-27-m4-pp04-three-role-review.md)、[证据台账](plans/evidence-logistics-m3.md)与[逐篇审计](reviews/work/2026-11-27-m4-batch-a-reconciliation-audit.md)。

## 当前执行状态与准确游标（2026-11-27；PP-06 检查点）

- M4 批次 A 全部 50 篇文件均已在 main：当前 9 篇 Role Reviewed、0 篇 Owner Accepted、41 篇 Draft；全库 Owner Accepted 3/99。
- 批次 B 仍为 0/46；只有批次 A 全部完成且用户在本窗口明确批准后才能开工。
- 原始 42 篇 Draft 已逐篇对照正文、M3 准入与现存 review；本轮 SD-01 依据精确正文复核升级 Role Reviewed，SD-02 与 SD-03 新一轮复核完成但仍 Draft。完整 ID、链接、证据边界、循环记录模式和下一步见[逐篇审计报告](reviews/work/2026-11-27-m4-batch-a-reconciliation-audit.md)。
- 五条当前工作线：

| 工作线 | 当前文章 | 文章状态 | 下一游标 |
| --- | --- | --- | --- |
| 1 | MM-08～MM-10、SD-01～SD-05 | 1 Role Reviewed、7 Draft | 已完成 |
| 2 | SD-06～SD-07、PP-01～PP-06 | 8 Draft | 已完成 |
| 3 | PP-07～PP-09、QM-01～QM-05 | 8 Draft | QM-03 |
| 4 | QM-06～QM-08、FI-04、FI-06～FI-10 | 9 Draft | QM-06 |
| 5 | FI-11、CO-01～CO-08 | 9 Draft | FI-11 |

**当前执行顺序**：工作线 1 已完成；工作线 2 已处理 SD-06、SD-07、PP-01～PP-06；工作线 3 已处理 PP-07～PP-09、QM-01～QM-02，下一篇 QM-03，之后按用户指定的工作线顺序推进。核心证据无法补齐时，记录已查来源、具体缺口和下一步，文章继续 Draft 并转下一篇。只有目标版证据足以支持其学习目标且完成可核验的独立角色复核，才可记 Role Reviewed。Owner Accepted 只由用户明确批准。
**最近工作包更新**：PP-06 保持 Draft。三个独立 AI reviewer-context 对精确最终正文各完成 5 项复核；当前的 M3 核心成本估价、退料/冲销、WIP/差异/结算和 FI/CO 过账证据仍不足，故不计 Role Reviewed。动态 FSD SPS10 范围、固定 2021.000 Order Split 索引边界及读取限制均已记录。批次计数不变，AI-Workflow SHA 未更换。
## 最近工作包（工作线 2）：PP-06（2026-11-27）

PP-06《生产发料、收货与成本》最终正文 blob `0ae98aa16e2e38d6468f6a2967e342cfc3eed59e`。动态 SAP S/4HANA 2021 FSD v11.0/SPS10 仅支持高层生产执行、库存变动/物料凭证、成本对象概览及 Kanban 限定例子；固定 2021.000/BJ5 Order Split 官方索引仅描述特定拆单功能中的父订单 262 冲回、对子订单 261 发料及组件成本重过账，canonical HTML 直开无可读正文。固定版一般估价、退料/冲销、WIP/差异/结算、FI/CO 凭证/科目、字段/API、权限及 EWM/MES 仍无充分直接证据。三个独立 AI reviewer-context（读者、配置顾问、开发者）各复核 5 项；复核通过只说明边界表达，不代替 M3 核心证据门槛，故 PP-06 保持 Draft，不计 Role Reviewed。PP-02、PP-05、CO-04 均在当前分支但仍 Draft，不作为已审查依赖。W2 完成；下一篇 W3 PP-07。批次 A 仍 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99；批次 B 0/46。未连接 SAP，未做实机、配置、数据库、API 或权限测试。详见[正文](knowledge/PP/02-functions/production-goods-cost.md)、[审查记录](reviews/work/2026-11-27-m4-workline-2-pp06-three-role-review.md)、[证据台账](plans/evidence-logistics-m3.md)与[逐篇审计](reviews/work/2026-11-27-m4-batch-a-reconciliation-audit.md)。

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
| 批次 A | **9/50 已角色 reviewed（FI-05、MM-01～MM-07、SD-01）；0/50 已由所有者接受。** 其余 41 篇 Draft。
| 批次 B | **0/46 开始**；待批次 A 完成 |
| FI-01～FI-03 角色审核闭环 | 52 |
| MM-01 审查 | 16 个有效闭环：普通读者 5、配置顾问 5、开发者 6；reviewed，待所有者验收 |
| MM-02 审查 | 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；reviewed，待所有者验收 |
| MM-03 审查 | 18 个有效闭环：普通读者 5、配置顾问 7、开发者 6；reviewed，待所有者验收 |
| MM-04 审查 | 18 个有效闭环：普通读者 5、配置顾问 6、开发者 7；reviewed，待所有者验收 |
| MM-05 审查 | 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；reviewed，待所有者验收 |
| MM-06 审查 | 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；reviewed，待所有者验收 |
| MM-07 审查 | 15 个有效闭环：普通读者 5、配置顾问 5、开发者 5；reviewed，待所有者验收 | 
| FI-04～FI-06 首轮审查 | 38/45 个问题完成闭环；FI-04 14/15、FI-05 15/15、FI-06 9/15 |
| SAP 实机测试 | 0；未连接 |
| 11 个纯结构导航类别 | 已批准，不计文章 |

## 工作线 4 进度（2026-11-27；历史快照，形成时批次 A 仍为 8/50 reviewed；以本文顶部实时快照为准）

- **QM-06《QM 常用事务码导航》**：已建立目标版来源受限草稿及 Work 角色视角记录。文章列出 2021《Simplification List》逐项明确的事务替代/Fiori 导航变化和 QM 授权对象操作类别；逐事务用户权限映射、完整常用入口、客户角色与当前系统可用性未由来源证明，状态 `drafting`。
- QM-06 记录 15 个同一 Work 上下文内的角色模拟闭环（读者 5、顾问 5、开发者 5），明确不是独立审查者或真人专家复核。记录见 [QM-06 Work 审查记录](reviews/work/2026-11-27-m4-workline-4-qm06-review.md)。
- **QM-07《质量管理配置查看》**：已建立仅覆盖 2021 FPS01 特定比较符设置的草稿。初始版、其他检验设置、工厂/物料适用条件和只读权限均未由该来源证明，状态 `drafting`；15 个同上下文 Work 角色模拟闭环（读者 5、顾问 5、开发者 5）见[QM-07 记录](reviews/work/2026-11-27-m4-workline-4-qm07-review.md)，不是独立审查或真人专家复核。
- **QM-08《质量检验数据模型》**：建立仅覆盖 2021 FPS01 §4.3.8 的证据受限草稿：新比较符在 `I_INSPECTIONRESULTATTRIBUTE` CDS view 中可用。没有据此推断初版可用、字段/数据库键或关系、released API/CDS 状态或授权；文章状态 `drafting`。15 个同上下文 Work 角色模拟闭环（读者 5、顾问 5、开发者 5）见[QM-08 记录](reviews/work/2026-11-27-m4-workline-4-qm08-review.md)，不是独立审查或真人专家复核。
- QM-06～QM-08 的同上下文模拟闭环均不计正式三角色独立审查数，故批次统计保持 **8/50 reviewed、0/50 owner accepted**；正式接受总数仍为 **3/99**。
- **FI-04《公司代码、会计科目表与总账科目》**：沿用既有 14/15 闭环（读者 5、顾问 4、开发者 5）；未重复 M3 研究或旧闭环。唯一开放项仍是公司代码一般定义/组织基数/法律与报告用途缺少 S/4HANA 2021 直接证据，文章继续 `drafting`。续核记录已追加至[既有审查档案](reviews/work/2026-11-26-m4-batch-a01-fi04-fi06-review.md)。
- **FI-06《应付与应收》**：沿用既有 9/15（读者 4、顾问 4、开发者 1）；本次仅移除正文重复标题并续记状态，没有重复 M3 研究或旧闭环。子账/总账、目标版 open item/clearing、部分付款/剩余项目仍缺目标版直接证据，文章保持 `drafting`。续核记录见[既有审查档案](reviews/work/2026-11-26-m4-batch-a01-fi04-fi06-review.md)。
- **FI-07《库存估价与 GR/IR》**：已建立目标版证据受限草稿，并记录 15 个同上下文角色视角模拟闭环（读者 5、顾问 5、开发者 5）；模拟不是独立审查，状态 `drafting`。固定 2021 页面支持 GR/IR 清账的有限条件，普通库存采购借贷、税和自动科目/OBYC 规则仍未闭合；未编造分录。详见[正文](knowledge/FI/02-functions/inventory-valuation-grir.md)和[Work 记录](reviews/work/2026-11-27-m4-workline-4-fi07-review.md)。
- FI-07 的模拟闭环不计 formal reviewed；批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，正式接受总数仍为 **3/99**。
- **FI-08《结账与报表入门》**：依据 SAP S/4HANA 2021 固定版 What's New §3.6.1.23–25 建立范围受限草稿，说明账户余额结转到新财年、Schedule General Ledger Jobs / `FAGLGVTR` 作业入口描述、Balance Carryforward Status 应用的信息范围与旧应用时间线。完整月结/年结、期间启闭、模拟/过账、报表和中国制度仍缺直接证据，故 `drafting`。15 个同上下文角色模拟闭环（读者 5、顾问 5、开发者 5）不是独立审查，不计入 8/50 reviewed。详见[正文](knowledge/FI/02-functions/period-close-reporting.md)、[Work 记录](reviews/work/2026-11-27-m4-workline-4-fi08-review.md)和[财务证据台账](plans/evidence-finance-m3.md)。
- **FI-09《FI 常用事务码导航》**：依据 SAP S/4HANA 2021 What's New §3.6.1.15 建立单项证据草稿，仅记录 `FGRIR_CLEARING` 的菜单路径、显示/模拟/真实更新模式和 Extended Open Item Management 条件。完整 GUI/Fiori 事务码索引、每项输入输出/权限及目标系统可用性仍未闭合，状态 `drafting`。15 个同上下文角色模拟闭环（读者 5、顾问 5、开发者 5）不是独立审查，不计 reviewed。详见[正文](knowledge/FI/03-tcodes/finance-transactions.md)、[Work 记录](reviews/work/2026-11-27-m4-workline-4-fi09-review.md)和[财务证据台账](plans/evidence-finance-m3.md)。
- **FI-10《财务配置查看》**：按 M3“暂缓核心”准入建立[证据受限草稿](knowledge/FI/04-configuration/finance-config-observation.md)，状态 `drafting`。固定版 2021 资料仅直接支持 Automatic Account Determination 应用用途与公告中有限的 BUL/BUU、HR Posting 通配符变化，以及 GR/IR 总账科目 Extended Open Item Management 字段的显示含义和 display-only 属性；没有用这些内容推导完整账户映射、公司代码/科目表、期间/收付款设置、精确路径、角色授权或 MM OBYC/BSX/WRX。初稿同上下文模拟 15 个闭环；随后三个独立 AI 子代理上下文各完成 5 个问题—证据答复—修订—原角色复验循环，共 15 个独立上下文闭环（不是真人专家签核，模型 ID 未显示）。核心配置证据仍未闭合，文章继续 `drafting`，不计 formal reviewed。详见[审查记录](reviews/work/2026-11-27-m4-workline-4-fi10-review.md)与[财务证据登记](plans/evidence-finance-m3.md)。未连接 SAP，无实机验证。
- 工作线 4 游标：本线负责的 QM-06～QM-08、FI-04、FI-06～FI-10 均已有文章与相应证据/审查记录；FI-04/FI-06 的既有问题闭环数分别为 14/15、9/15，FI-10 有 15 个独立 AI 子代理上下文复核闭环，另保留 15 个同上下文模拟闭环。当前纳入统计的工作线 4 新稿均为受限 `drafting`，不计 formal reviewed。FI-10 是本线最后一篇，工作线 4 当前无下一篇。批次 A 仍 **8/50 reviewed、0/50 owner accepted**，全库正式接受 **3/99**。
- SAP 系统未连接；没有事务码、角色、配置或客户系统实测。

## 关键文件索引

- [CareerOS README](README.md)
- [本次 M4 两批执行计划](plans/m4-two-batch-execution-2026-11-26.md)
- [FI-04 公司代码/科目表/G/L](knowledge/FI/02-functions/company-code-gl.md)
- [FI-05 凭证/过账/冲销](knowledge/FI/02-functions/posting-reversal.md)
- [FI-06 应付/应收](knowledge/FI/02-functions/payables-receivables.md)
- [FI-08 结账与报表入门（证据受限草稿）](knowledge/FI/02-functions/period-close-reporting.md)
- [FI-08 Work 角色视角记录](reviews/work/2026-11-27-m4-workline-4-fi08-review.md)
- [FI-09 FI 常用事务码导航（单项证据受限草稿）](knowledge/FI/03-tcodes/finance-transactions.md)
- [FI-09 Work 角色视角记录](reviews/work/2026-11-27-m4-workline-4-fi09-review.md)
- [FI-04～FI-06 三角色审查与证据收尾记录](reviews/work/2026-11-26-m4-batch-a01-fi04-fi06-review.md)
- [MM-01 组织结构文章](knowledge/MM/01-foundations/organization-objects.md)
- [MM-01 三角色审查记录](reviews/work/2026-11-26-m4-mm01-three-role-review.md)
- [MM-02 物料主数据与 BP](knowledge/MM/01-foundations/material-business-partner.md)
- [MM-02 三角色审查记录](reviews/work/2026-11-26-m4-mm02-three-role-review.md)
- [MM-03 采购信息记录与货源决定](knowledge/MM/02-functions/info-record-sourcing.md)
- [MM-03 三角色审查记录](reviews/work/2026-11-26-m4-mm03-three-role-review.md)
- [MM-04 采购申请与订单机制](knowledge/MM/02-functions/requisition-po.md)
- [MM-04 三角色审查记录](reviews/work/2026-11-26-m4-mm04-three-role-review.md)
- [MM-05 库存类型与货物移动](knowledge/MM/02-functions/stock-movement.md)
- [MM-05 三角色审查记录](reviews/work/2026-11-26-m4-mm05-three-role-review.md)
- [MM-06 收货、退货与冲销](knowledge/MM/02-functions/gr-returns-reversal.md)
- [MM-06 三角色审查记录](reviews/work/2026-11-26-m4-mm06-three-role-review.md)
- [MM-07 价格单位、数量单位与换算](knowledge/MM/02-functions/price-unit-conversion.md)
- [MM-07 三角色审查记录](reviews/work/2026-11-26-m4-mm07-three-role-review.md)
- [MM-08 MM 常用事务码导航（证据受限草稿）](knowledge/MM/03-tcodes/transaction-index.md)
- [MM-08 三角色审查记录](reviews/work/2026-11-27-m4-mm08-three-role-review.md)
- [MM-09 采购与库存配置查看（证据受限草稿）](knowledge/MM/04-configuration/purchasing-inventory.md)
- [MM-09 三角色审查记录](reviews/work/2026-11-27-m4-mm09-three-role-review.md)
- [MM-10 采购与库存数据模型（证据受限草稿）](knowledge/MM/05-data-model/purchasing-inventory.md)
- [MM-10 三角色审查记录](reviews/work/2026-11-27-m4-mm10-three-role-review.md)
- [SD-01 销售业务与组织结构（证据受限草稿）](knowledge/SD/01-foundations/organization.md)
- [SD-01 三角色审查记录](reviews/work/2026-11-27-m4-sd01-three-role-review.md)
- [SD-02 客户业务伙伴与物料主数据（证据受限草稿）](knowledge/SD/01-foundations/customer-product-master.md)
- [SD-02 三角色审查记录](reviews/work/2026-11-27-m4-sd02-three-role-review.md)
- [PP-07 PP 常用事务码导航（证据受限草稿）](knowledge/PP/03-tcodes/transaction-index.md)
- [PP-07 三角色审查记录](reviews/work/2026-11-27-m4-workline-3-pp07-review.md)
- [首批 FI-01～FI-03 审核答复记录](reviews/work/2026-11-26-m4-batch01-round1-response.md)
- [首批执行日志](reviews/work/2026-11-26-m4-batch01-execution-log.md)
- [M3 99 项控制矩阵](plans/m3-item-control-matrix-v0.3.md)
- [M3 逐篇准入分流](plans/m3-item-readiness-triage-v0.3.md)
- [多角色审核与记录规则](reviews/README.md)
- [M3/M4 收尾方案与所有者决定](plans/m3-closeout-batched-m4-proposal-2026-11-26.md)

## 接手与状态说明

PR #21 已合并，不要向该 PR 追加提交。批次 A 收尾从 `main` HEAD `c026b3862c9a083c95cffb096f93e141276cfba5` 建立的新分支 `careeros-v04-m4-batch-a-closeout-20261127` 执行。开始时重查 PR、main、分支及文章实时文件；按 IdeaLab 根 README、AGENTS、AI_WORKFLOW_INTEGRATION、CareerOS README/HANDOFF、M4 两批计划、M3 控制矩阵、逐篇准入/证据、reviews README、批次 A 当前 50 篇正文与各自现存 review 的顺序完成核验。固定 AI-Workflow SHA `939ec44036d89cd91622ab96b938be9f02479026` 不更换；版本标记差异需如实记录。逐篇只处理批次 A；文章有核心目标版证据缺口或没有真正独立审查时继续 Draft。Owner Accepted 只能由用户在本窗口明确批准；批次 B 必须等批次 A 完成并获明确批准。最终新 PR 保持开放，不合并。

> 后续工作线追记中的 PR #21 状态、分支 HEAD 与游标均是各条记录形成时的历史快照；PR #21 已于 `c026b3862c9a083c95cffb096f93e141276cfba5` 合并至 main。


## 工作线 2 进度追记（2026-11-27）

- SD-06《销售配置查看》已建立正文草稿，状态 drafting；三种角色视角各完成 5 个同上下文问题—答复—修订—复核循环，共 15 个。它们不是独立审查或真人专家意见。准确的通用销售 IMG 分支、目标系统只读访问路径/授权，以及交货、开票与科目决定证据仍未闭合。
- SD-06 的 15 个角色视角循环不计入批次 A reviewed 数：批次 A 仍为 8/50 reviewed、0/50 owner accepted；CareerOS 正式接受仍为 3/99。SAP 系统未连接、实机验证为 0。
- 工作线 2 下一篇：PP-03《工作中心与工艺路线 Routing》。PP-01 与 PP-02 已核对并保持 Draft；相关 M3 核心目标缺证时不以安全措辞升级。
- 详细内容及闭环字段见 [SD-06 审查记录](reviews/work/2026-11-27-m4-sd06-three-role-review.md) 与 [文章](knowledge/SD/04-configuration/sales.md)。


### 2026-11-27｜工作线 5：FI-11

- 已按批准路径新增 `knowledge/FI/05-data-model/accounting-document-model.md`，范围限于 2021 固定版直接支持的 Universal Journal 报告背景、compatibility view 说明及一个 ACDOCA/ACDOCD 特定功能例子。
- 审查记录：`reviews/work/2026-11-27-m4-fi11-three-role-review.md`。普通读者、配置顾问、开发者视角各 5 个有效闭环（共 15）；本 Work 上下文内角色模拟，不代表人类专家或独立代理审查。
- 状态仍为 `drafting`，不是 reviewed/accepted。未闭合核心：BKPF、ACDOCA、BSEG 的 2021 逐字段定义、主键、基数、released CDS/API 及授权前提。正文未写未经证实的 JOIN/键表/生产 SELECT。FI-07 普通库存采购借贷、税及自动科目边界未扩展。
- FI-11 不增加批次 A 的 8/50 reviewed 数量，也不改变 0/50 owner accepted、3/99 全库接受数。SAP 系统未连接，未做实机测试。
- 本工作线下一项：CO-01《管理会计从零：成本与利润》。届时只读取该篇控制项、准入分流和证据登记；本次未加载 CO-01～CO-08 的其他文章级研究材料。

## 工作线 2 进度追记（2026-11-27，PP-01 收尾）

- PP-01《生产业务与组织结构》最终正文 blob `2c8d036bcedc137e5a0cc13ee1846719d2006bd9`；P1 仅为固定 2021.000 官方索引（direct open=0），P2 是 2021 SPS04 静态 PDF，限于 PI Sheet/work-instruction HTML5 功能范围。已补入 Customizing enhancement 激活只针对该 HTML5 功能、不证明 Scope Item 客户许可/部署/启用的说明，并清理重复来源条目。
- 原有 15 个同一 Work 上下文角色模拟与新增独立复核分开记录。读者、配置顾问、开发三个独立 AI reviewer-context 各提出 5 项；作者逐项答复并限定/核对最终正文，最终各 5/5 PASS。此 PASS 仅确认当前证据边界，不代表目标学习内容已证。
- Plant 生产组织职责、MTS/MTO 业务规则、离散/流程制造差异及其对 BOM/MRP/订单/库存/成本的影响仍缺足够固定版直接证据。PP-01 保持 Draft，批次 A 仍 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99 Owner Accepted；批次 B 0/46 未开始。SAP 未连接，未做实机、配置或权限测试。
- 工作线 2 下一篇：PP-02《物料清单 BOM》。详情见 [审查记录](reviews/work/2026-11-27-m4-pp01-three-role-review.md)、[证据台账](plans/evidence-logistics-m3.md)、[审计报告](reviews/work/2026-11-27-m4-batch-a-reconciliation-audit.md) 与 [文章](knowledge/PP/01-foundations/production-organization.md)。


## 工作线 3 进度（2026-11-27）

- **PP-07《PP 常用事务码导航》**：状态 drafting。三种角色视角各完成 5 个有效闭环，共 15（普通读者 5、资深配置顾问 5、普通开发人员 5）；这些是同一 Work 上下文内的角色模拟，不是独立代理或真人专家审查。SAP Help 的 2021 (Oct 2021) 页面直接支持 CS03 显示物料 BOM，但页面属于 Retail 帮助内容；Routing、MRP、生产订单的逐码目标版来源及授权仍未闭合。
- PP-07 的闭环不计入批次 A reviewed 数；正式进度仍为 **8/50 reviewed、0/50 owner accepted**…5332 tokens truncated…环，共 15 个同一 Work 上下文内的模拟循环，不是独立审查者或真人专家复核。文章及审核记录明确披露此限制，不计入正式 role-reviewed 数。
- 正文的直接产品依据限于 SAP S/4HANA 2021 SPS10 FSD 动态链接实际读取快照（文档版本 11.0，2026-07-22），并引用固定 2021.000 BJ5 生产订单对象页的已记录货物移动显示范围。发料/收货数量方向和少量成本对象概览已限缩呈现。
- 库存估价和实际金额、退料/冲销触发、差异/WIP/结算算法、FI/CO 科目与凭证关系、字段/API/权限、EWM/MES 集成仍未闭合；CO-04 正文在当前分支不存在。SAP 系统未连接，实机测试 0。
- 工作线 2 已有 8 篇正文（SD-06、SD-07、PP-01～PP-06），全部 drafting；累计模拟闭环 120（每篇各角色 5），本线正式独立 role-reviewed 为 0/8。批次 A 仍为 **8/50 reviewed、0/50 owner accepted**；全库正式接受为 **3/99**。
- SD-07 后续结果见下方同名进度追记；当前分配范围已完成。


## 工作线 3 收尾（2026-11-27）

- 本工作线获分配的 PP-07～PP-09、QM-01～QM-05 均已建立文章和独立 Work 记录。八篇当前均为 drafting；没有一篇因轮数达到或同上下文模拟而计为正式 reviewed。
- 八篇各记录普通读者视角 5、资深 SAP 配置顾问视角 5、普通 SAP 开发人员视角 5，共 120 个同一 Work 上下文内角色模拟闭环。独立角色审查闭环为 0；这些记录不代表真人专家或独立子代理复核。逐篇轮数、问题、证据、修订和原视角复核见各自 Work 记录。
- PP-07 的逐事务码目标版直接证据及权限/显示修改边界仍不全；PP-08/09 的配置与对象模型目标范围仍有核心缺口。QM-01～05 分别保留各自控制矩阵中的组织/触发、检验规划、结果/UD、一般 IM 库存及财务缺口；EWM 场景未推广到普通 IM。SAP 系统未连接，实机测试为 0。
- QM-04 正文提交 9522cb9c7b2bf00edd5efb897f92a7b1793d535a，审查记录提交 f43b8f14315f6bced7661e52d20566bb46ca0115。
- QM-05 正文提交 2a1f7d9565915eeaf4689cb20eb8817d6c15de25，审查记录提交 6a6f58c9ba90de59e0c062544054a80a20fd613a。
- 本工作线不改变批次 A **8/50 reviewed、0/50 owner accepted**；全库正式接受仍为 **3/99**。该历史检查点记于 PR #21 合并前；PR #21 已于 2026-11-27 合并到 main（c026b3862c9a083c95cffb096f93e141276cfba5）。
- 本工作线分配范围已完成；本线内没有下一篇。后续文章须由协调者另行分配。

## M4 工作线 5 更新：CO-03（2026-11-27）

- 本条记录是 PR #21 合并前写入的历史进度；PR #21 当前已于 2026-11-27 合并到 main（c026b3862c9a083c95cffb096f93e141276cfba5）；工作分支 careeros-v04-m4-batch1-20261126，本次 HANDOFF 更新前 HEAD 为 d6f274693efd0a47d4ac9c78ed2b05886140e234。PR 不合并。
- CO-03《内部订单和费用归集》正文：[knowledge/CO/02-functions/internal-orders.md](knowledge/CO/02-functions/internal-orders.md)，状态 drafting；同上下文角色视角闭环为普通读者 5、资深配置顾问 5、普通 SAP 开发人员 5。没有独立角色审查、SAP 实机测试或客户权限检查，不计入 8/50 reviewed。
- 目标版证据范围：FSD v9.0/SP08 支持成本核算主数据与期间计划/实际报告；2021.002 迁移对象给出迁移语境的定义；SAP Learning 未锁发行版，仅作概念说明；2021.001 Central Finance 仅限中心结算状态检查。普通订单真实/统计规则、归集、预算、结算接收方、权限和数据模型仍有缺口。没有推导 FI-07 普通库存借贷、税或自动科目。
- 审查记录：[reviews/work/2026-11-27-m4-co03-three-role-review.md](reviews/work/2026-11-27-m4-co03-three-role-review.md)。证据记录：[plans/evidence-finance-m3.md](plans/evidence-finance-m3.md)。两批执行计划已同步。
- 本文提交 b4da71fc1d043d95d7beecfce11561ac43af7122；角色视角修订 8fdcf35d1960194b12f3c23eaccb887924ec764b；审查记录 fb3ba1b7b38c8f53865e99de2c66cc4a8b1577aa；证据台账 bd716b35088b86989aefece26c52172039b89b17；执行计划 d6f274693efd0a47d4ac9c78ed2b05886140e234。
- 下一项：CO-04。开始前仅读取 CO-04 自身准入、证据登记和依赖，不提前加载后续文章的完整研究材料。


## 工作线 2 进度追记（2026-11-27，SD-07）

- **SD-07《销售与交货数据模型》**已按 M3 准入分流的“限缩可写”范围建立正文，路径为 `knowledge/SD/05-data-model/sales-delivery.md`，状态 `drafting`。
- 普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各有 5 个同一 Work 上下文模拟闭环，共 15；Work 在每个闭环中记录质询、官方来源答辩、文章修订和原视角复核。没有独立审查者或真人专家参与，不计入批次 A reviewed 数。记录见 [SD-07 Work 审查记录](reviews/work/2026-11-27-m4-workline-2-sd07-three-role-review.md)。
- 正文按固定 SAP S/4HANA 2021《Simplification List》§36.8 限于状态表/对应对象、VBFA 简化、单据类别及冗余索引变更；明确其 system conversion 语境。固定 2021.000 What's New 中的 API_SALES_ORDER_SIMULATION_SRV 仅作为销售订单模拟 API 的窄范围例子。动态 FSD 只按实际读取 SPS10 快照标注，用于开票可过账至 Financial Accounting 的高层说明。
- 完整 VBFA/后续单据字段、主键、关联基数、组织映射、FI 凭证关系、released API/CDS 合同和权限仍未闭合；不提供生产 JOIN。M3 关联的 SD-03、SD-04 正文文件当前分支不存在。SAP 系统未连接、未执行实机测试。
- 工作线 2 已完成分配的 8 篇正文（SD-06、SD-07、PP-01～PP-06）；全部 drafting，累计 120 个同上下文模拟闭环（每篇读者/顾问/开发者各 5），本线正式独立 role-reviewed 为 0/8。批次 A 正式 reviewed 仍 **8/50**、owner accepted **0/50**；全库正式接受仍 **3/99**。SAP 实机测试为 0。
- 本条记录为 PR #21 合并前的历史进度；该 PR 当前已于 2026-11-27 合并到 `main`（c026b3862c9a083c95cffb096f93e141276cfba5）；基于工作分支 HEAD `7c36b5db4904e6a18e61c293a854ab2c8c4c38d6`。PR 不合并。本工作线范围已完成；本线下一篇为“无”，后续需另行分配。

## M4 工作线 5 更新：CO-04（2026-11-27）

- 本条记录是 PR #21 合并前写入的历史进度；PR #21 当前已于 2026-11-27 合并到 main（c026b3862c9a083c95cffb096f93e141276cfba5）。工作分支 careeros-v04-m4-batch1-20261126，本次 HANDOFF 更新前 HEAD 为 f74d9461fcd24461477da49100e1ebf2ccfb6a47。
- CO-04《产品成本、生产差异与结算》文章：[knowledge/CO/02-functions/product-cost-variance-settlement.md](knowledge/CO/02-functions/product-cost-variance-settlement.md)，状态 drafting，路径遵循 M3 “暂缓核心”边界。SAP S/4HANA 2021 FSD v9.0/SP08 快照支持制造方式影响成本观察对象、生产订单成本向接收对象结算、重复制造按期间收集，以及特定 Kanban 场景的期末 WIP/差异能力；2021.000 Deferred Summarization 是独立技术功能。普通生产订单公式、状态条件和结算规则/接收方未闭合。
- 角色视角记录：[reviews/work/2026-11-27-m4-co04-three-role-review.md](reviews/work/2026-11-27-m4-co04-three-role-review.md)：读者 5、配置顾问 5、开发者 5，同一 Work 上下文模拟；非独立审查，不计 8/50 reviewed。没有 SAP 实机、目标 FPS 或用户权限验证；无 FI-07 普通库存借贷/税/自动科目推导。
- 证据台账：[plans/evidence-finance-m3.md](plans/evidence-finance-m3.md)；两批执行计划已同步。
- CO-04 文章初稿 da84d0d0d50f9671f013be518279ad4b90a60a2e；来源定位修订 fd549cf1a5a98114e6274850ab3463f6f68a534e；视角审查修订 3a7632303662ed58e5e6e65c22857f85375c17e7；Settlement 术语修订 beaa3d541e0439237b4d34284b9f4d714bd5353f；审查档案 c6d6e22f26a045c6c0319a8438892f36586f1b03；证据台账 3a7df8f3bd8975891293e57726f15e3a1f671b0e；执行计划 8a97f1d94b3a1076b0ea102ee465f5dc102018fc。
- 下一篇：CO-05。开始前仅读取 CO-05 自身准入与证据登记，按目标版证据范围建立正文。



## 工作线 1 进度追记（2026-11-27，MM-10）

- **MM-10《采购与库存数据模型：从业务对象到待核技术关系》**正文为 `knowledge/MM/05-data-model/purchasing-inventory.md`；M3 准入为“暂缓核心”，状态保持 **drafting**。正文只教目标版来源支持的采购订单业务层级和 PR→PO 高层处理能力，不推断 PR/PO/历史/物料凭证的完整技术模型、字段键、基数、物理表/兼容视图、released API、组织范围或权限。
- 三角色原问题复核记录：[MM-10 三角色审查](reviews/work/2026-11-27-m4-mm10-three-role-review.md)。普通读者、资深配置顾问视角、普通开发者视角分别完成 5/5 原问题复核，共 **15/15 个 AI 评审闭环**；三个独立 AI 上下文，未显示可核实模型型号，不代表真人专家、SAP 系统/API/权限测试。Help 页在本轮未能被复核上下文重新读取；限制已写入审查记录。
- 批次 A 数字不变：**8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。MM-10 不计 reviewed 或 accepted；SAP 系统未连接，无实机/API/数据库/权限测试。
- 工作线 1 下一篇：**SD-01**。依据 M3 控制矩阵和逐篇准入路径逐篇处理，不预载后续篇章的完整资料。


## 工作线 5 进度追记｜CO-05（2026-11-27）

- **文章与状态：**[CO-05《获利分析与 FI 集成：收入、成本与收款分清》](knowledge/CO/02-functions/profitability-fi.md) 按 M3“限缩可写”路径建立证据受限草稿，状态 **drafting**；[逐篇角色视角记录](reviews/work/2026-11-27-m4-co05-three-role-review.md)。
- **证据：**FSD latest 直接打开为 SAP S/4HANA 2021 v11.0/SP10，搜索索引另有 v9.0/SP08 缓存，均已披露动态链接/支持包限制；固定版 Simplification List v1.25 §12.13 只覆盖 Initial Shipment/FPS1/2 的 Margin Analysis 发票/交货时点及 FI 映射范围；What’s New 2021 §3.5.6.4、2021.000 Manage COGS Splits 支持术语和特定 COGS 功能。
- **三角色闭环：**普通读者 5、资深配置顾问 5、普通开发人员 5，共15个同一 Work 上下文角色模拟闭环（均有质询、来源答复、文本修订和同视角复核）；不是独立 reviewer，不计正式 reviewed。
- **开放项：**客户 FPS、Margin Analysis 之外普通销售/合同的确认时点、客户估值/属性配置、完整 COGS split 规则、CO 数据模型/API/权限未闭合。FI-07 普通库存借贷/税/自动科目仍未推导；无 SAP 实机、客户配置、凭证或权限测试。
- 批次 A 保持 **8/50 reviewed、0/50 owner accepted**；正式接受 **3/99**。工作线 5 下一篇 **CO-06**；开始前只加载 CO-06 自身准入和证据材料。


## 工作线 1 进度追记（2026-11-27，SD-01）

- **SD-01《销售业务与组织结构》**正文：[knowledge/SD/01-foundations/organization.md](knowledge/SD/01-foundations/organization.md)，按 M3“限缩可写”边界保持 `drafting`。只讲目标版页面支持的组织概念和有限关系；不提供 IMG 路径、事务码、配置指导或客户系统权限结论。
- 三角色审查记录：[reviews/work/2026-11-27-m4-sd01-three-role-review.md](reviews/work/2026-11-27-m4-sd01-three-role-review.md)。普通读者、配置顾问视角、开发者视角各 5 个有效闭环，共 **15/15 AI 问题—答复—修订—原角色复核闭环**；三位是独立 AI 复核上下文，不是人类专家、不同模型证明或系统测试。
- 固定版 SAP Help API 页面索引支持该读取 API 在 S/4HANA 2021 的范围元数据。Sales Organization 固定版页在本轮工具中不可访问；该页仅依 M3 中独立顾问此前直接读取且版本选择器显示 `2021 (Oct 2021)` 的记录引用。组织配置、完整跨公司开票适用条件、单据角色和 FI 细节、客户 API 启用/权限仍未闭合；SAP 系统未连接、没有配置或 API 实测。
- SD-01 的 15 个闭环不等于 M3 核心门槛通过，故不计 reviewed/accepted。批次 A 数字不变：**8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。
- 工作线 1 下一篇：**SD-02《客户业务伙伴与物料主数据》**。开始前重新读取 SD-02 的 M3 准入、证据来源与当前 PR 分支状态。


### 2026-11-27｜工作线 5：CO-06

- CO-06《CO 常用入口导航：先分清查看、维护与过账》已按“暂缓核心”路径建立受限 drafting 草稿：`knowledge/CO/03-tcodes/controlling-transactions.md`；记录：`reviews/work/2026-11-27-m4-co06-three-role-review.md`。
- 固定版 SAP S/4HANA 2021 What's New 和 2021.000 Help 支持少数具名 app 的功能描述（预算处理、内部订单 display/where-used/change log、成本要素组、物料价值链实际/估算分析、COGS split 分析）。这些不是完整 GUI T-Code 目录；本文不把 KSB1/KOB1/KE30 或其他代码凭经验写成已验证事实。
- 未闭合：常用 GUI T-Code 的 2021 用途/输入输出/版本；成本中心实际/计划报表、内部订单实际行项目和一般获利分析报表映射；Fiori app ID、部署、业务目录/角色/授权、目标系统只读/修改边界。没有 SAP 系统连接或实机验证。
- 普通读者、资深配置顾问、普通开发人员视角各 5 个同上下文模拟闭环，共 15；非独立审查，不计 8/50 reviewed。文章保持 drafting，批次 A 仍 8/50 reviewed、0/50 owner accepted，正式接受 3/99。
- 工作线 5 下一篇：CO-07《管理会计配置查看》；开始前仅读取该篇准入项和单篇证据登记。


## 工作线 1 进度追记（2026-11-27，SD-02）

- **SD-02《客户业务伙伴与物料主数据》**正文：[knowledge/SD/01-foundations/customer-product-master.md](knowledge/SD/01-foundations/customer-product-master.md)，遵循 M3“限缩可写”边界并保持 `drafting`。固定版资料支持 BP 客户角色、交易伙伴职能、客户通用/公司代码/Sales Area 数据层级，以及物料 `Sales and distribution` 类别级概览；正文不推断 BP grouping/编号、完整伙伴确定配置、物料销售视图字段/键、API 或客户权限。
- 三角色审查记录：[reviews/work/2026-11-27-m4-sd02-three-role-review.md](reviews/work/2026-11-27-m4-sd02-three-role-review.md)。普通读者、配置顾问视角、开发者视角各 5 个闭环，共 **15/15 AI 问题—答复—修订—原角色复核闭环**；三个独立 AI 上下文，不代表人类专家、不同模型证明或系统测试。
- M3 记录四个 SAP Help 页面既有直接复读（版本选择器显示 `2021 (Oct 2021)`）；本轮检索无法重新打开前三个固定版页面，Field Status 页仅有固定版索引正文可读。没有用未固定版来源补缺；SAP 系统未连接，无客户数据、配置、API 或权限实测。
- SD-02 15 个闭环不等于 M3 核心证据门槛通过，故不计 reviewed/accepted。批次 A 数字不变：**8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。
- 工作线 1 下一篇：**SD-03《销售订单与交货机制》**。开始前重新读取 SD-03 的 M3 准入、证据来源及当前 PR 分支状态。


### 2026-11-27｜工作线 5：CO-07

- CO-07《管理会计配置查看：从一条可证实的规则开始》已按“暂缓核心”准入建立受限 drafting 草稿：`knowledge/CO/04-configuration/controlling-config-observation.md`；记录：`reviews/work/2026-11-27-m4-co07-three-role-review.md`。
- 固定 SAP S/4HANA 2021 What's New §3.5.1.3 支持 Block Intercompany Postings 一项 CO-OM 配置及其 IMG 路径：全部允许、全部阻止或仅允许特定发送方/接收方公司代码组合。没有扩展为一般跨公司 FI、分摊、结算或会计分录规则。
- 未闭合：其他成本中心/成本要素/内部订单/结算与分配设置的目标版证据；IMG display-only 路径、T-Code、业务角色/权限对象、客户当前配置和传输影响。SAP 系统未连接，没有执行或修改配置。
- 普通读者、资深配置顾问、普通开发人员视角各 5 个同上下文模拟闭环，共 15；不是独立审查，不计 8/50 reviewed。文章保持 drafting；批次 A 仍 8/50 reviewed、0/50 owner accepted，正式接受 3/99。
- 工作线 5 下一篇：CO-08《管理会计数据模型》；开始前仅读取该篇准入项和单篇证据登记。


### 2026-11-27｜工作线 5：CO-08（本线最后一篇）

- CO-08《管理会计数据模型：理解统一日记账，但不猜表关系》已按“暂缓核心”准入建立受限 drafting 草稿：`knowledge/CO/05-data-model/controlling-data-model.md`；记录：`reviews/work/2026-11-27-m4-co08-three-role-review.md`。
- 证据仅限三项：固定 2021 Simplification List §8.1 的报告存储/特定转换兼容视图背景；What's New 2021 §3.5.6.4 的 Margin Analysis/ACDOCA 窄范围；固定 2021.000 deferred production-cost summarization 的 ACDOCA/ACDOCD 特定案例。
- 未闭合：成本中心、内部订单、生产订单等 CO 对象字段、键、基数、组织范围与日记账关系；候选 COSP/COSS/COEP 的目标 2021 FPS 物理对象/兼容视图状态；released CDS/API 和权限。正文未给出未经证实 JOIN 或 SQL。没有 SAP 实机/数据库/API/权限测试。
- 普通读者、配置顾问、开发人员视角各 5 个同上下文模拟闭环，共 15；非独立 review，不计 8/50 reviewed。文章保持 drafting；批次 A 仍 8/50 reviewed、0/50 owner accepted，正式接受 3/99。
- 工作线 5 的 FI-11、CO-01～CO-08 分配已全部推进到文章/审查记录阶段；本线没有下一篇待处理文章。全部草稿仍待独立角色审查与所有者验收。


## 工作线 1 进度追记（2026-11-27，SD-03）

- **SD-03《销售订单与交货机制》**正文：[knowledge/SD/02-functions/sales-delivery.md](knowledge/SD/02-functions/sales-delivery.md)，按 M3“限缩可写”处置保持 drafting。FSD 只支撑受限场景下销售订单处理、sell-from-stock 的出库交货关系、交货处理活动及 PGI 库存影响；正文不推断固定状态机、技术单据流键、库存数据/API 合同、实际送达或所有权。
- 三角色审查记录：[reviews/work/2026-11-27-m4-sd03-three-role-review.md](reviews/work/2026-11-27-m4-sd03-three-role-review.md)。普通读者、配置顾问、开发人员 AI 角色视角各 5 个闭环，15/15 均经原角色复核 PASS；不代表人类专家意见，也没有 SAP 实机/API/权限测试。
- M3 仍未闭合：具体部分交货、订单/交货取消、拒绝与 PGI 冲销规则，及客户系统权限。FSD latest 当次记录为 Version 11.0（2026-07-22）、S/4HANA 2021 SPS10；文章披露动态链接与订单章节页码记录差异，不外推到 2021 初版或其他 FPS/SPS。
- 批次 A 数字不变：**8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。SD-03 保持 drafting，不计 reviewed/accepted；未连接 SAP 系统。
- 工作线 1 下一篇：**SD-04《定价、开票与应收集成》**。开始前仅加载 SD-04 自身的 M3 准入和证据资料，并重新读取 PR #21 最新 HEAD。

## 工作线 1 进度追记（2026-11-27，SD-04）

- **SD-04《定价、开票与应收集成》**正文：[knowledge/SD/02-functions/pricing-billing-ar.md](knowledge/SD/02-functions/pricing-billing-ar.md)，按 M3“限缩可写”边界保持 drafting。FSD 限定支持 billing due list、开票单据、冻结/过账/定时释放到会计，以及应收/清账的高层功能；正文不推断定价程序、税、收入确认、具体 AR/FI 凭证关系或实际银行资金。
- 三角色审查记录：[reviews/work/2026-11-27-m4-sd04-three-role-review.md](reviews/work/2026-11-27-m4-sd04-three-role-review.md)。普通读者、配置顾问、开发人员 AI 角色各 5 个闭环，15/15 均由原角色复核 PASS；不是人类专家签核，也没有 SAP 实机/API/权限测试。
- M3 来源补查于 2026-11-25 UTC 读取 FSD 动态 latest，报告标记 Version 11.0（2026-07-22）、S/4HANA 2021 SPS10；文章注明动态链接，不外推初版、其他 FPS/SPS 或客户系统。未闭合主题仍包括定价/税/收入确认及 FI 分录、客户系统实际 AR 关联、收款差异、银行资金与权限。
- 批次 A 数字不变：**8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。SD-04 保持 drafting，不计 reviewed/accepted；未连接 SAP 系统。
- 工作线 1 下一篇：**SD-05《SD 常用事务码导航》**。开始前只读取 SD-05 自身的 M3 准入和来源资料，并重新核验 PR #21 最新状态。


## 工作线 1 进度追记（2026-11-27，SD-05）

- **SD-05《SD 常用事务码导航》**正文：[knowledge/SD/03-tcodes/transaction-index.md](knowledge/SD/03-tcodes/transaction-index.md)，文章修订提交 `c1b5ed2005327f113e8d1b2e1a0efba10abc76cc)，审查记录：[reviews/work/2026-11-27-m4-sd05-three-role-review.md](reviews/work/2026-11-27-m4-sd05-three-role-review.md)，记录提交 `4cf6ad301ebe9f02b9e97c9e9535a7505f24aa4c`。按 M3“暂缓核心”路径保持 **drafting**。
- 固定版证据仅支持有限入口标签：2021.000 SAP Help 的 GTS 合规状态场景列 VA01/VA02/VA03 app；Brazil Tab 场景列 VF01/VF02/VF03/VF03_ITEM/VF07 transactions；固定 Simplification List 1.25 §49.8 p.951 支持特征值快速录入在限定转换/DIMP 条件下并入 Configuration tab，VA01/02/03 为例。未把上述内容外推成通用事务目录、交货入口、权限或输入输出。
- 普通读者、配置顾问、开发者 AI 视角各完成 5 个首轮质询及原角色复核，**15/15 个问题—Work 证据答复—正文修订—原角色复核闭环均 PASS**。三位视角因执行环境不可用，未能重新读取仓库文件或 SAP 原始页面；Work 向其提供修订文本和来源摘录。记录明确此限制，不代表人类专家、不同模型证明或系统测试。
- 通用销售/交货/开票逐码用途、出库交货入口、输入/输出、GUI/Fiori 类别、App ID/Launchpad 映射及客户系统角色/授权仍未闭合；未连接 SAP、未做实机/API/配置/权限测试。SD-05 不计入 8/50 reviewed 或 0/50 owner accepted。
- 批次 A 仍为 **8/50 reviewed、0/50 owner accepted**；全库正式接受仍 **3/99**。工作线 1 当时的下一篇 **MM-08**，现已完成 PR 候选复核；当前下一篇 **MM-09**。用户交接所述本地未提交的 MM-08 文件本轮不可读取，未将其视为已提交或已复核；详见下方 MM-08 修订追记。

## 工作线 1 进度追记（2026-11-27，MM-08 修订候选）

- **文章**：MM-08《MM 常用事务码导航》，路径 knowledge/MM/03-tcodes/transaction-index.md，候选修订提交 7eb37405554e293553985e434bd24cf0eb3449b9。按 M3“暂缓核心”路径保持 drafting。此次加入 SAP S/4HANA 2021 Best Practices《Administration Guide》§3.3.2（PDF p.53）对 Embedded EWM 的直接定义，并披露 PDF 封面日期 2024-07-05；不把封面日期当作 2021 年出版证明。
- **审查记录**：reviews/work/2026-11-27-m4-mm08-three-role-review.md，最新记录提交 3296befae121b1a54fa8da4111deea3cfa0eb2e6。普通读者、资深配置顾问、普通开发人员三个原角色上下文针对各自的 5 个原问题，按上述 exact commit 复核，15/15 PASS。审查记录保留问题、证据、Work 答复、正文修改和原角色结果，并说明各角色 SAP 原始来源读取范围及限制；不代表真人专家、不同模型或系统验证。
- **本地文件边界**：执行环境不可用，本轮无法读取用户交接所述未提交的本地 transaction-index.md。PR 上的 7eb3740 候选是基于当前可读 PR 内容所做的独立远端修订，不能视为本地副本已提交、同一或已审核。
- **未解决核心**：材料凭证显示入口与通用 MIGO 导航仍缺目标版 SAP S/4HANA 2021 On-Premise 固定版直接证据；GUI/Fiori/App ID、逐代码输入输出及权限映射也不完整。没有连接 SAP、没有实机或 API/配置/权限测试。
- **计数与游标**：MM-08 15/15 原问题完成当前候选复核，但仍不计 reviewed；批次 A 仍为 8/50 reviewed、0/50 owner accepted，全库正式接受 3/99。工作线 1 下一篇 MM-09，按 M3 控制矩阵与逐篇准入路径只处理 MM-09。



## 工作线 1 检查点 3：SD-03（2026-11-27）

- 精确正文 blob：`dade5b834076bb588fc90b2cfc796d1efa43fdbb`，正文未修改。
- 三个独立 AI reviewer-context 对当前精确正文各复核 5 个问题，15/15 PASS。顾问首轮 C2 FAIL 源于 PDF 文本提取未显示同节后半段；直接重读官方 FSD 后，确认 §2.13.2.1 明列 sales order、stock transport order 与 no reference 三种交货参照，顾问撤回 FAIL 并确认 PASS。
- FSD 为动态 latest Version 11.0（2026-07-22），适用于 S/4HANA 2021 SPS10；不能外推为 2021 初始版或其他补丁的通用证据。
- 一般部分交货、订单/交货取消或拒绝、普通 PGI 冲销和客户授权仍未闭合；4RQ 特殊 3PL 索引摘录不能支持这些一般规则。SD-03 保持 Draft，不计入正式 Role Reviewed。
- 计数保持：批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99 Owner Accepted；批次 B 0/46 未开始。
- 最新游标：W1 SD-04；W2 SD-06；W3 PP-07；W4 QM-06；W5 FI-11。
- 未连接 SAP；未执行实机、配置、数据库、API 或权限测试。


## 工作线 1 检查点 4：SD-04（2026-11-27）

- SD-04 正文当前 blob `7d349641c104cffa49f375ec2b5107a5a9f5dda6`，未修改。既有三角色独立 AI reviewer-context 15/15 闭环逐项对照当前正文；本轮不把协调者复读当作新独立闭环。
- 2021 固定版 SAP 官方资料搜索未得到可复读的通用定价条件、税、收入确认/FI 分录、实际 AR 关联、收款差异/银行资金或授权资料。固定版 Billing Due List CDS 页面直接打开无可读正文；通用 Pricing in Sales Documents 页面版本未核；2025 FPS01 及其他新版本结果排除。
- M3 的核心目标仍超出当前可证范围，SD-04 继续 Draft。SD-03/FI-06 依赖仍 Draft；PROCESS-02 不在本分支。
- 批次 A：9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99 Owner Accepted；批次 B 0/46 未开始。
- 最新游标：W1 SD-05；W2 SD-06；W3 PP-07；W4 QM-06；W5 FI-11。
- 未连接 SAP；未进行实机、配置、数据库、API、权限或资金测试。


## 工作线 1 检查点 5：SD-05 与本线完成（2026-11-27）

- SD-05 当前正文 blob `5604d5f31b6b2b78e40cd5304b87eb172e8fb6db`，未修改。既有三角色 AI reviewer-context 15/15 闭环已逐项核对；本轮协调者复读不计新增独立审查。
- 固定 2021 GTS/Brazil 页面只在官方索引摘录中可读，直接打开无正文；SAP 静态 Simplification List v1.25 §49.8 可直接读取但仅支持特定迁移/特征值例码。没有通用订单/交货/开票入口、用途、字段、类别和权限的完整证据，文章继续 Draft。
- W1 八篇完成逐篇核对：SD-01 Role Reviewed；MM-08～MM-10、SD-02～SD-05 共七篇 Draft。
- 批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99 Owner Accepted；批次 B 0/46 未开始。
- 游标：W1 已完成；W2 SD-06；W3 PP-07；W4 QM-06；W5 FI-11。
- 未连接 SAP；无实机、配置、数据库、API、权限或事务测试。


## 工作线 2 检查点 1：SD-06（2026-11-27）

- SD-06 当前正文 blob `48293fd49ac07ad4ee42ad3ed9b4f48e59a3b1a8`，未修改。固定 2021.000 Help 两个页面的可见官方索引内容仅支持 Condition Purpose 和借项审批的限定示例；HTML direct open 不可读。2021 FPS01 静态 PDF p.96–97 直接支持订阅订单 PSFX 例子。
- M3 readiness 为“限缩可写”；通用 IMG 节点、业务分支和客户系统只读授权路径仍缺。既有 15 项角色循环来自同一 Work 上下文，不能计正式 Role Reviewed。SD-06 保持 Draft。
- M3 控制矩阵经重新核对，没有 SD-01～07 或 PP-01～09 的独立 ID 行；这是 M3 文件结构缺口，本轮不更改已验收文件，逐篇准入按 triage/detail-logistics 继续执行。
- 批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99 Owner Accepted；批次 B 0/46 未开始。
- 游标：W1 已完成；W2 SD-07；W3 PP-07；W4 QM-06；W5 FI-11。
- 未连接 SAP；未进行 IMG、事务码、配置、权限或系统测试。


## 工作线 2 检查点 2：SD-07（2026-11-27）

- SD-07 正文当前 blob `7a00a76187960d5279c8052071731bc9742efb7a`；正文和证据台账已补入 SAP 固定 2021 Simplification List §36.9 的早期 VBFA/STUFE 历史范围。新增表述区分系统转换目标版与新安装起始/曾经版，并逐项列出官方清单的重建历史路径；明确不推断 2021 一般系统现况或要求普遍重建。
- 原 15 个 Work 同上下文角色模拟仍不能计独立审查。读者、顾问、开发三个独立 AI reviewer-context 各完成 5 个质询，作者答复/修订后由原角色复核，均 5/5 PASS；记录见 [SD-07 审查记录](reviews/work/2026-11-27-m4-workline-2-sd07-three-role-review.md)。这不是真人 SAP 专家意见或实机验证。
- SAP Help 的 S3 页面直开 0 行，正文仅把官方固定版检索索引作为有限模拟 API 线索；动态 FSD 仅为当前 SPS10 高层开票范围。SD-07 所需的完整 VBFA/后续单据字段、键、基数、组织约束、SD-FI 字段级关系、released API/CDS 和权限证据仍未闭合，继续 Draft。
- M3 依赖 SD-03、SD-04、FI-11 均为 Draft。批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 3/99 Owner Accepted；批次 B 0/46 未开始。
- 最新游标：W1 已完成；W2 PP-03；W3 PP-07；W4 QM-06；W5 FI-11。PR #21 已合并且不再追加；新 PR 尚未创建，不合并。
- 未连接 SAP；未执行 SE16、数据库、ABAP、API、配置或权限测试。


## 工作线 3 检查点：PP-07（2026-11-27）

- 最终正文 [PP-07《PP 常用事务码导航》](knowledge/PP/03-tcodes/transaction-index.md) blob `5695c3b0c499707e877474a2c5a2842998b0da40`；正文、M3 补证、审查记录、审计、执行计划与 README 已更新并提交到本收尾分支。
- 固定版 CS03 Help 正文本轮 canonical HTML 直开为 0 行，只能按 SAP 官方检索索引摘要保留有限显示、输入与结果线索，且限 Retail / Fashion and Vertical Business。CA03、MD04、CO03 KBA 预览只提供特定场景或名称线索；不支持完整任务步骤、输入/输出、角色权限或只读保证。Routing、MRP、生产订单逐码导航及权限仍缺充分固定版直接证据。
- 配置顾问在首轮指出“CS03 固定版 Help 逐步说明”归因过强；作者改为明确索引摘要和不可读正文边界。读者、配置顾问、开发者独立 AI reviewer-context 对最终正文各完成 5 项复核，15/15 PASS；该结果只通过表述边界检查，文章继续 Draft、不计 Role Reviewed。之前 15 项同 Work 模拟不计独立审查。
- 依赖 PP-02～PP-06、PP-08 均存在但为 Draft，未用作已审查依赖。全库 Owner Accepted 3/99；批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；批次 B 0/46 未开始。W1、W2 完成；W3 下一篇 PP-08；W4 QM-06；W5 FI-11。

## 工作线 3 检查点：PP-08（2026-11-27）

- 最终正文 [PP-08《生产计划配置查看》](knowledge/PP/04-configuration/production.md) blob `39203dad38372889c85a6f5253a8dade0dc2e1b5`；PP-08 继续 Draft。
- 固定版直接证据仅支持 MARC-FHORI 字段、2021 FPS01 指定 action-handler 配置以及 Change Record 2021.000 官方索引摘录。Operations Guide PDF 实为动态 v11.0（2026-07-22）／SAP S/4HANA 2021 SPS10，只用于 `PPH_SETUP_MRPRECORDS` 的报表先决条件，不冒充冻结初版或通用 MRP 规则。M3 证据台账 p.623 错配已更正；p.617 也标为 Simplified Sourcing。
- 首轮独立 reviewer-context 指出 Ops Guide 动态版本分类不清；作者修订文章章节、矩阵、来源清单和两份 M3 来源记录。读者、配置顾问、开发者三个独立 AI reviewer-context 对最终精确正文各完成 5 项复核，15/15 PASS。旧 15 个同 Work 角色模拟单独保留，不计独立审查；最终复核不表示 M3 核心门槛已满足。
- 通用订单类型/排程/确认/MRP 参数/工厂配置和受权只读入口仍缺固定版直接证据；PP-01、PP-04、PP-05、PP-06 存在但均为 Draft，未作为已审查依赖。PP-08 不计 Role Reviewed 或 Owner Accepted。
- 全库 Owner Accepted 3/99；批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；批次 B 0/46 未开始。W1、W2 完成；W3 下一篇 PP-09；W4 QM-06；W5 FI-11。
- 未连接 SAP；未执行配置、实机、数据库、API 或权限测试。PR #21 已合并，新 PR 尚未创建，待批次 A 收尾完成后创建并保持开放，不合并。

## 最近工作包（工作线 3）：PP-09（2026-11-27）

PP-09 精确正文 blob `df8768bef910bf09a87687d1c89630d80e78bd21` 经普通读者、资深 SAP 配置顾问和普通 SAP 开发人员三个独立 AI reviewer-context 各五项复核，15/15 仅通过证据边界与表述检查；不代表真人专家意见、M3 核心门禁关闭或系统验证，正文无需修改并继续 Draft。SAP S/4HANA 2021 固定资料支持简化 sourcing 的部分 BOM/routing/production version 关系、特定 EHS 选择条件和 MATDOC 兼容读取；SDK 记录支持特定确认 VDM entity 的逻辑键。一般生产对象物理键、外键、关联基数、运行时 API 元数据/发布/授权仍未闭合；PP-02、PP-03、PP-05 已存在但都为 Draft。PP-09 review 顶部的过期依赖句已改正。计数不变：全库 Owner Accepted 3/99；批次 A Role Reviewed 9/50、Draft 41/50、Owner Accepted 0/50；批次 B 0/46 未开始。W1、W2 已完成；W3 下一篇 QM-01；W4 QM-06；W5 FI-11。PR #21 已合并，新 PR 尚未创建。未连接 SAP，未做实机、数据库、API、配置或权限测试。

## 工作线 3 收尾检查点｜QM-01（2026-11-27）

QM-01 最终正文 blob `4519e14b896f0aa3cd71af53e74cb378654cd4d4`。三个独立 AI reviewer-context（普通读者、资深 SAP 配置顾问、普通 SAP 开发人员）各针对最终正文完成 5 项有效质询—证据答复—修订判断—原角色复核，15/15 仅代表边界检查通过；文章继续 Draft，不计 Role Reviewed。2021.000 Manage Inspection Lots 官方索引摘要支持 QM-IM、四个 scope item 和 worklist 结果/使用决策；Customizing Structure 仅支持 Reference IMG 结构变化；Business Events for Inspection Plans 仅涉及检验计划 CRUD，不能证明检验批创建触发。相关 canonical Help 页面本轮直开均为 0 行。FSD latest 搜索索引显示 v9.0（2025-07-23），直开为 v11.0（2026-07-22），属动态版本差异，不作为固定版证据。质量组织/岗位映射、检验批触发、设置、权限、客户系统启用状态及库存/财务后果仍未核。MM-01 已 reviewed 但仅覆盖采购组织，PP-01 为 Draft，PROCESS-06 未在批次 A；依赖不能补足缺口。全库 Owner Accepted 3/99；批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；批次 B 0/46。W3 下一篇 QM-02；W4 QM-06；W5 FI-11。PR #21 已合并，新 PR 尚未创建。未连接 SAP，未执行实机、配置、数据库、API 或权限测试。

## 工作线 3 收尾检查点｜QM-02（2026-11-27）

QM-02 最终正文 blob `53b91de8ccaebf5b69c1a7519e60b023555ee874` 经三个独立 AI reviewer-context（普通读者、资深 SAP 配置顾问、普通 SAP 开发人员）各完成 5 项有效质询—证据答复—修订判断—原角色复核，15/15 通过证据范围与可读性复核。旧的 15 项同 Work 模拟不计独立审查。顾问/开发者指出来源 05/类型 05 配对、手工建批多类型选择规则缺少留存的固定版逐项证据，已从正文确切事实中移除并标为待核；检验目录类型 3 的自动过账例已加限定；来源清单同步缩窄。SAP Help 固定页面本轮直开不可访问，同名动态 2025 页面未作为 2021 证据。M3 核心的完整 skip inspection/跳批/不建批条件、一般 QIR、EWM 与普通 IM 差异、库存估价/FI 凭证、客户设置与权限未闭合，QM-02 继续 Draft、不计 Role Reviewed。依赖 QM-01 为 Draft、MM-02 为 Role Reviewed；依赖不替代核心证据。计数保持：全库 Owner Accepted 3/99；批次 A 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；批次 B 0/46。W3 下一篇 QM-03；W4 QM-06；W5 FI-11。PR #21 已合并，新 PR 尚未创建；未连接 SAP 或执行实机、配置、数据库、API、库存/财务及权限测试。