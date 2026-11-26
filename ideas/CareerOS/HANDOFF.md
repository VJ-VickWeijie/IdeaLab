# CareerOS V0.4｜跨 Work 窗口统一交接入口

更新时间：2026-11-27（Asia/Shanghai）  
状态：**M3 已验收；M4 完整 99 篇分两批建设已授权。FI-01～FI-03 所有者已接受（3/99）；FI-05、MM-01～MM-07 已完成三角色 review 并计入 8/50 reviewed。MM-08、QM-01 各有15个视角闭环但目标版核心证据未闭合，保持 drafting；FI-04/FI-06 继续 drafting。CO-01 为证据充分的限缩草稿，15个同上下文模拟闭环未计reviewed；CO-02、CO-03均已建立证据受限草稿，各有15个同上下文模拟闭环，不计reviewed。CO-03普通订单结算、预算和权限等目标版证据仍不充分；CO-04普通生产订单的WIP/差异公式、状态条件和一般结算规则仍缺直接证据。工作线5下一篇CO-05。批次A为8/50 reviewed、0/50 owner accepted。**

## 当前仓库、分支与 PR

- 仓库：[VJ-VickWeijie/IdeaLab](https://github.com/VJ-VickWeijie/IdeaLab)
- 当前 PR：[PR #21｜CareerOS M4 全量分批建设](https://github.com/VJ-VickWeijie/IdeaLab/pull/21)，目标 `main`；开放、未合并。Work 不自行合并。
- 工作分支：`careeros-v04-m4-batch1-20261126`。
- PR #20 已合并到 `main`；基线提交 `db349fe68e1aa0560ba5546a6382ffe503d0f595`。
- 本工作包提交前实时读取 PR #21：open、未合并、base main；工作分支 HEAD 为 6d3aae117e3d8328fc97dbaa646b103064fb31e6。本工作包提交后以最新HEAD查询为准。
- AI-Workflow V1.1 固定 SHA：`939ec44036d89cd91622ab96b938be9f02479026`。未更改通用门禁。

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

- PR #20 的 M3 结果已并入 main；沿用现有 M4 分支和 PR #21，不丢弃成果、不另开 PR。
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

## 正在执行与下一项明确任务

**当前里程碑：M4 批次 A（50 篇模块知识）。**  
当前已复核文章和 FI-04～FI-06 A01 工作包状态：

| 文章 | 审查闭环 | 状态 | 未解决事项 |
| --- | ---: | --- | --- |
| MM-01 组织结构与采购业务对象 | 16/16 | reviewed（待所有者验收） | 固定版来源由 Work 直接核对；顾问无法独立重开页面，限制已记录 |
| MM-02 物料主数据与供应商业务伙伴 | 15/15 | reviewed（待所有者验收） | 来源表已按固定版七类校正；客户字段/角色配置与数据模型不作未证实推断 |
| MM-03 采购信息记录与货源决定 | 18/18 | reviewed（待所有者验收） | 高层功能有来源；具体来源选择优先级、有效期边界与 quota 算法仍待详细资料；FSD 为动态链接，已披露快照限制 |
| MM-04 采购申请与订单机制 | 18/18 | reviewed（待所有者验收） | PR→PO 合并资格、后台作业触发、手工指定供应商与 source assigned 的关系及客户审批配置仍未由目标版来源闭合；动态 FSD 快照限制已披露 |
| MM-05 库存类型与货物移动 | 15/15 | reviewed（待所有者验收） | 不列未锁版移动代码；供应商寄售 K 权属、转移时点和 FI 估价仍待直接证据 |
| MM-06 收货、退货与冲销 | 15/15 | reviewed（待所有者验收） | 冲销与退货的目标版单据操作、部分数量、发票顺序与 FI 影响没有足够直接证据；正文限缩到已证实业务意图与 FSD 能力 |
| MM-07 价格单位、数量单位与换算 | 15/15 | reviewed（待所有者验收） | 不推断底层转换对象、接口字段覆盖、任意计价数量行为或发票匹配规则 |
| MM-08 MM 常用事务码导航 | 15/15 AI 评审闭环 | drafting（不计入 8/50） | 物料凭证显示入口、通用 MIGO 导航仍缺固定版 2021 直接证据；GUI/Fiori 逐代码映射与权限未核实 |
| CO-01 审查 | 普通读者、配置顾问、开发者视角模拟各5个闭环，共15；drafting，缺独立复核，不计reviewed；范围内证据充分 |
| MM-09 采购与库存配置查看 | 15/15 AI 评审闭环 | drafting（不计入 8/50） | 普通无科目分配估价收货的固定版完整分录、OBYC/BSX/WRX 条件、方向冲突及只读路径/权限未闭合 |
| MM-10 采购与库存数据模型 | 15/15 AI 原问题复核闭环 | drafting（不计入 8/50） | 完整 PR/PO/历史/物料凭证模型、键/基数、物理表/兼容视图、released API 与权限未闭合 |
| FI-04 公司代码、会计科目表与总账科目 | 14/15 | drafting | SAP S/4HANA 2021 公司代码的一般定义/组织用途缺少直接证据 |
| FI-05 会计凭证、过账与冲销 | 15/15 | reviewed | 等待后续所有者审阅；无已知严重角色问题 |
| FI-06 应付与应收 | 9/15 | drafting | 客户/供应商子账与总账、目标版 open item/clearing、部分付款/剩余项目缺固定版证据 |

工作线 1 下一项明确任务：进入 SD-01。开始前按 M3 控制矩阵和逐篇准入分流，只读取 SD-01 所需的来源与依赖。MM-08、MM-09、MM-10 均保持 drafting；分别见下方工作线 1 进度记录，不计入正式 reviewed 数。MM-09 的普通估价收货及 OBYC/BSX/WRX 证据未闭合；MM-10 的完整技术模型、键、基数、物理表/兼容视图与 released API 未闭合。

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
| 批次 A | **8/50 已角色 reviewed（FI-05、MM-01～MM-07）；0/50 已由所有者接受。** FI-04/FI-06、MM-08、QM-01 和 CO-01 均为 drafting |
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

## 工作线 4 进度（2026-11-27）

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
- **FI-10《财务配置查看》**：按 M3“暂缓核心”准入建立[证据受限草稿](knowledge/FI/04-configuration/finance-config-observation.md)，状态 `drafting`。固定版 2021 资料仅直接支持 Automatic Account Determination 应用用途与公告中有限的 BUL/BUU、HR Posting 通配符变化，以及 GR/IR 总账科目 Extended Open Item Management 字段的显示含义和 display-only 属性；没有用这些内容推导完整账户映射、公司代码/科目表、期间/收付款设置、精确路径、角色授权或 MM OBYC/BSX/WRX。普通学习者、配置顾问、开发者视角各 5 个同上下文模拟闭环，共 15，不是独立审查，不计正式 reviewed。详见[审查记录](reviews/work/2026-11-27-m4-workline-4-fi10-review.md)与[财务证据登记](plans/evidence-finance-m3.md)。未连接 SAP，无实机验证。
- 工作线 4 游标：本线负责的 QM-06～QM-08、FI-04、FI-06～FI-10 均已有文章与相应证据/审查记录；FI-04/FI-06 的既有问题闭环数分别为 14/15、9/15，FI-10 新建 15 个同上下文角色模拟闭环。当前纳入统计的工作线 4 新稿均为受限 `drafting`，不计 formal reviewed。FI-10 是本线最后一篇，工作线 4 当前无下一篇。批次 A 仍 **8/50 reviewed、0/50 owner accepted**，全库正式接受 **3/99**。
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
- [PP-07 PP 常用事务码导航（证据受限草稿）](knowledge/PP/03-tcodes/transaction-index.md)
- [PP-07 三角色审查记录](reviews/work/2026-11-27-m4-workline-3-pp07-review.md)
- [首批 FI-01～FI-03 审核答复记录](reviews/work/2026-11-26-m4-batch01-round1-response.md)
- [首批执行日志](reviews/work/2026-11-26-m4-batch01-execution-log.md)
- [M3 99 项控制矩阵](plans/m3-item-control-matrix-v0.3.md)
- [M3 逐篇准入分流](plans/m3-item-readiness-triage-v0.3.md)
- [多角色审核与记录规则](reviews/README.md)
- [M3/M4 收尾方案与所有者决定](plans/m3-closeout-batched-m4-proposal-2026-11-26.md)

## 新窗口可直接使用的接手指令

接手 GitHub 仓库 `VJ-VickWeijie/IdeaLab` 中的 CareerOS。先实时读取 PR #21、分支 `careeros-v04-m4-batch1-20261126`、`main` 和 PR #20 的状态及最新 HEAD；PR 不合并。然后读取本 HANDOFF、CareerOS README、[M4 两批执行计划](plans/m4-two-batch-execution-2026-11-26.md)、[本批 FI-04～FI-06 审查记录](reviews/work/2026-11-26-m4-batch-a01-fi04-fi06-review.md)、reviews/README、知识树和当前所选文章对应的控制矩阵/证据登记。M3 已验收；M4 全部 99 篇分批建设已授权。FI-01～FI-03 已获所有者肯定，正式接受 3/99。FI-05（15）、MM-01（16）、MM-02（15）、MM-03（18）、MM-04（18）、MM-05（15）、MM-06（15）、MM-07（15）均 reviewed、待所有者验收；MM-08、MM-09、MM-10 均因核心证据缺口保持 drafting，不计入 reviewed；批次 A 为 8/50 reviewed、0/50 owner accepted；工作线 1 下一篇 SD-01。不要重复 M0～M3 或已完成的研究；不要把草稿/来源登记算成正式文章；保留五项 M3 证据边界及 FI-04/FI-06 新阻碍；继续批次 A 中可独立写作的文章。每完成一个工作包，真实记录三角色问题、Work 答辩/修改、原角色复核及闭环数，更新本 HANDOFF 并提交到 PR #21。


## 工作线 2 进度追记（2026-11-27）

- SD-06《销售配置查看》已建立正文草稿，状态 drafting；三种角色视角各完成 5 个同上下文问题—答复—修订—复核循环，共 15 个。它们不是独立审查或真人专家意见。准确的通用销售 IMG 分支、目标系统只读访问路径/授权，以及交货、开票与科目决定证据仍未闭合。
- SD-06 的 15 个角色视角循环不计入批次 A reviewed 数：批次 A 仍为 8/50 reviewed、0/50 owner accepted；CareerOS 正式接受仍为 3/99。SAP 系统未连接、实机验证为 0。
- 工作线 2 下一篇：PP-01《生产业务与组织结构》，路径以逐篇分流为准；该项当前分流为“暂缓核心”，须先建立主张级准入，核心制造模式边界缺证时继续 drafting。
- 详细内容及闭环字段见 [SD-06 审查记录](reviews/work/2026-11-27-m4-sd06-three-role-review.md) 与 [文章](knowledge/SD/04-configuration/sales.md)。


### 2026-11-27｜工作线 5：FI-11

- 已按批准路径新增 `knowledge/FI/05-data-model/accounting-document-model.md`，范围限于 2021 固定版直接支持的 Universal Journal 报告背景、compatibility view 说明及一个 ACDOCA/ACDOCD 特定功能例子。
- 审查记录：`reviews/work/2026-11-27-m4-fi11-three-role-review.md`。普通读者、配置顾问、开发者视角各 5 个有效闭环（共 15）；本 Work 上下文内角色模拟，不代表人类专家或独立代理审查。
- 状态仍为 `drafting`，不是 reviewed/accepted。未闭合核心：BKPF、ACDOCA、BSEG 的 2021 逐字段定义、主键、基数、released CDS/API 及授权前提。正文未写未经证实的 JOIN/键表/生产 SELECT。FI-07 普通库存采购借贷、税及自动科目边界未扩展。
- FI-11 不增加批次 A 的 8/50 reviewed 数量，也不改变 0/50 owner accepted、3/99 全库接受数。SAP 系统未连接，未做实机测试。
- 本工作线下一项：CO-01《管理会计从零：成本与利润》。届时只读取该篇控制项、准入分流和证据登记；本次未加载 CO-01～CO-08 的其他文章级研究材料。

## 工作线 2 进度追记（2026-11-27，PP-01）

- PP-01《生产业务与组织结构》已建立证据受限草稿，状态 drafting；普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各有 5 个同上下文角色视角问题—答复—修订—复核循环。组织关系、MTS/MTO 与离散/流程制造核心解释仍缺固定版 2021 直接证据；这些循环不构成独立审查。
- 本线截至此记录新增 SD-06、PP-01 两篇 drafting，新增 reviewed 数为 0、owner accepted 数为 0；总体统计以 HANDOFF 当前进度表为准，草稿不计 reviewed/accepted。SAP 系统未连接，实机验证仍为 0。
- 工作线 2 下一篇：PP-02《物料清单 BOM》。PP-01 的来源范围、闭环和阻碍见 [审查记录](reviews/work/2026-11-27-m4-pp01-three-role-review.md) 与 [文章](knowledge/PP/01-foundations/production-organization.md)。


## 工作线 3 进度（2026-11-27）

- **PP-07《PP 常用事务码导航》**：状态 drafting。三种角色视角各完成 5 个有效闭环，共 15（普通读者 5、资深配置顾问 5、普通开发人员 5）；这些是同一 Work 上下文内的角色模拟，不是独立代理或真人专家审查。SAP Help 的 2021 (Oct 2021) 页面直接支持 CS03 显示物料 BOM，但页面属于 Retail 帮助内容；Routing、MRP、生产订单的逐码目标版来源及授权仍未闭合。
- PP-07 的闭环不计入批次 A reviewed 数；正式进度仍为 **8/50 reviewed、0/50 owner accepted**，正式接受总数仍为 **3/99**。SAP 系统未连接，实机测试为 0。PP-02～PP-06、PP-08 依赖文章在当前分支尚未找到。
- 本工作线下一篇：**PP-08《生产计划配置查看》**，路径以逐篇分流为准。PP-07 如取得新的固定版逐码直接证据，需回补来源、复核受影响主张后再判断状态。
- 详见 [PP-07 正文](knowledge/PP/03-tcodes/transaction-index.md) 与 [审查记录](reviews/work/2026-11-27-m4-workline-3-pp07-review.md)。

## 工作线 3 进度追记（2026-11-27，PP-08）

- **PP-08《生产计划配置查看》**已建立证据受限文章 `knowledge/PP/04-configuration/production.md`，状态 `drafting`。固定版内容限定为 2021 Simplification List 的 MARC-FHORI 规则、2021 FPS01 组件装配动作处理器的两处功能专属设置、2021 Change Record/Process Order 的特定前提，以及 2021 Operations Guide 中一个 MRP Records 报表先决条件。
- 审查记录 `reviews/work/2026-11-27-m4-workline-3-pp08-review.md` 记载同一 Work 上下文内的角色视角模拟：普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5，共 15 个有效闭环；不代表独立代理或真人专家审查。
- M3 PP-08 证据行将 SAP S/4HANA 2021 Simplification List PDF 第 623 页描述为生产版本迁移；本轮核对 PDF 目录发现第 623 页为 Browser-based Process Instruction-Sheets/Electronic Work Instructions，第 617 页为 Simplified Sourcing。文章未使用该旧行支持 PP 配置；本次只记录此错配，没有修改共享 M3 矩阵或证据台账。
- 一般订单类型、排程/确认、MRP 参数、工厂配置及目标系统的授权只读查看入口仍未闭合；PP-01 仍 drafting、PP-04/PP-05 当前不在分支中。故 PP-08 保持 `drafting`，15 个闭环不增加正式 reviewed 数。批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，全库正式接受 **3/99**；SAP 系统未连接，未做配置或实机测试。
- 下一篇：**PP-09《生产主数据与订单数据模型》**，批准路径 `knowledge/PP/05-data-model/production.md`。按准入先只读取该篇对应来源与依赖。

## 工作线 2 进度追记（2026-11-27，PP-02）

- PP-02《物料清单 BOM》已按批准路径建立固定版证据受限文章，状态 drafting。正文只说明 2021 固定版资料支持的多层结构、BOM versioning 配置条目，以及按库存重复制造确认场景中的 explosion date/BOM version 例子。
- 角色视角记录：[PP-02 三角色视角工作记录](reviews/work/2026-11-27-m4-pp02-three-role-review.md)。普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各完成 5 个问题—证据答复—修订—原视角复核闭环，共 15 个同一 Work 上下文角色视角模拟循环；未声称独立审查或真人专家意见。
- PP-02 不增加批次 A reviewed/owner accepted 数量：仍为 8/50 reviewed、0/50 owner accepted；全库正式接受仍为 3/99。SAP 系统未连接，实机验证为 0。
- 尚未闭合的核心：一般 BOM 数量/单位与计算、替代项选择和 lot size/有效日期/生产版本关系、一般有效期规则、组件缺失行为、表字段及 released API；SAP 官方固定版证据不足。M3 的 FSD_OP2021_latest.pdf 动态 URL 未作为固定版 2021 证据。
- 工作线 2 下一篇：PP-03《工作中心与工艺路线 Routing》，路径以 M3 逐篇准入分流为准。开始前只读取 PP-03 对应的控制/分流/来源和关联文章。


## 工作线 1 进度（2026-11-27，MM-08）

- **MM-08《MM 常用事务码导航》**：已建立证据受限正文，路径 `knowledge/MM/03-tcodes/transaction-index.md`。固定版 SAP S/4HANA 2021 页面支持有限物料主数据事务族与采购订单事务族；MIGO 短文本仅列为 2021 SPS05 场景受限示例。未将事务家族证据扩展为逐代码模式/授权映射，也未添加缺乏 2021 固定版依据的 Fiori 分类。
- 审查记录：`reviews/work/2026-11-27-m4-mm08-three-role-review.md`。普通读者、配置顾问视角、开发者视角各 5 个有效闭环，共 15；由三个独立 AI 子代理上下文完成，不代表人类 SAP 专家意见、不同模型证明或实机测试。原上下文完成复核，15/15 闭环。
- 状态仍为 **drafting**，不计入批次 A reviewed（总计仍为 **8/50**），不计 owner accepted（**0/50**）；全库正式接受仍为 **3/99**。未闭合核心：物料凭证显示入口、通用 MIGO 导航的固定版 2021 On-Premise 直接证据；同时没有逐代码权限矩阵。SAP 系统未连接，未做实机验证。
- 工作线 1 下一篇：**MM-09**。先按 M3 控制矩阵和逐篇准入路径处理普通估价库存收货、OBYC/BSX/WRX；按固定版证据边界写作，不因 MM-08 局部缺口停住后续工作。


## 工作线 3 进度追记（2026-11-27，PP-09）

- **PP-09《生产主数据与订单数据模型》**已建立证据受限文章 `knowledge/PP/05-data-model/production.md`，状态 `drafting`。正文只覆盖 2021 Simplified Sourcing 中 production version/BOM/routing 的有限关系与 MTO/MTP 例外、特定 EHS 选择条件中的对象名称、MATDOC 与 MKPF/MSEG 兼容读取说明，以及 M3 已登记的特定生产确认 OData entity key。
- 审查记录 `reviews/work/2026-11-27-m4-workline-3-pp09-review.md` 记载同一 Work 上下文内普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个有效闭环，共 15；不代表独立代理或真人专家审查。本轮复读已有 SDK 源码核对记录，未重新下载源包。
- 未闭合：一般生产对象物理键/外键/关联基数、MATDOC 主键与订单关联、目标系统 API 元数据/发布和权限；PP-02/03/05 依赖文档当前不在分支。M3 控制矩阵无独立 PP-09 行，S4HANA-09 仅为邻接通用门禁；本次没有修改共享矩阵。
- PP-09 保持 `drafting`，不增加正式 reviewed 数。批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，全库正式接受 **3/99**；SAP 系统未连接，无数据库/API 实机验证。
- 工作线 3 下一篇：**QM-01《质量管理业务与组织对象》**，路径 `knowledge/QM/01-foundations/quality-organization.md`。按准入逐篇读取其来源和依赖。

## 工作线 2 进度追记（2026-11-27，PP-03）

- PP-03《工作中心与工艺路线 Routing》已建立目标版证据受限文章，状态 drafting。固定版材料支持 BJ5 的 Manage Routings 搜索/创建/更改导航、BJ8 范围 Work Center OData API 数据类别、3W4 范围 Routing operation 的 PRT 读取，以及 PEO 专用 shop-floor routing 结构；这些场景在正文中分开限定。
- [PP-03 三角色视角记录](reviews/work/2026-11-27-m4-pp03-three-role-review.md)记录普通读者、资深配置顾问、普通开发人员各 5 个闭环，共 15 个同上下文角色模拟循环；不构成独立 review 或真人专家意见。
- 通用工序顺序/选择、工作中心完整定义、Routing 与 BOM/生产版本的替代和有效期关系、产能/成本参数与公式仍未闭合，故 PP-03 不计 reviewed/owner accepted。批次 A 保持 8/50 reviewed、0/50 owner accepted；正式接受 3/99；SAP 实机测试 0。
- 工作线 2 下一篇：PP-04《需求、MRP 与计划订单》，路径以 M3 逐篇准入分流为准；开始前只读取 PP-04 自身控制、来源和关联文章。


## 工作线 3 进度追记（2026-11-27，QM-01）

- **QM-01《质量管理业务与组织对象》**已建立证据受限草稿 `knowledge/QM/01-foundations/quality-organization.md`，状态 `drafting`。固定版 SAP Help version 2021.000 支持 QM-IM 应用从检验批工作清单记录结果/作使用决策，并列出 1FM、1MP、1E1、1MR 范围项；该页未证明质量组织、用户角色或检验触发。
- 审查记录 `reviews/work/2026-11-27-m4-workline-3-qm01-review.md` 记载同一 Work 上下文内普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个有效闭环，共 15；不代表独立代理或真人专家审查。
- M3 所引 FSD_OP2021_latest.pdf 为动态版本；本篇未用其快照支持固定版触发规则。MM-01 已 reviewed 但只支持采购组织模型；PP-01 仍 drafting；PROCESS-06 当前不在分支。
- 质量组织/角色、检验批创建触发、工厂/主数据设置和库存/财务结果仍未闭合。QM-01 保持 `drafting`，不增加正式 reviewed 数；批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，全库正式接受 **3/99**。SAP 系统未连接、无实机测试。
- 下一篇：**QM-02《检验类型与检验批》**，批准路径 `knowledge/QM/02-functions/inspection-type-lot.md`。按逐篇准入先读取该篇来源与依赖。


## 工作线 1 进度（2026-11-27，MM-09）

- **MM-09《采购与库存配置查看》**：文章路径 knowledge/MM/04-configuration/purchasing-inventory.md。正文限于固定版 S/4HANA 2021 对发票科目确定因素、GR/IR 概念关系和采购收货估价示例的支持；分开标示这些事实不能组成普通库存收货配置指南，保留固定版方向措辞与未锁版本课程之间的冲突，不推断 OBYC/BSX/WRX 映射或权限路径。
- 审查记录 reviews/work/2026-11-27-m4-mm09-three-role-review.md：普通读者、配置顾问视角、开发者视角各 5 个有效闭环，共 15。三个分开的 AI 子代理上下文已各自复核通过；不代表人类 SAP 专家意见、不同模型证明或系统验证。
- 状态为 **drafting**，不计入 reviewed（批次 A 仍为 **8/50**）、不计 owner accepted（**0/50**）；全库正式接受仍为 **3/99**。未闭合：普通无科目分配估价收货的固定版完整借贷方向；OBYC/BSX/WRX 触发条件和精确科目映射；估价/移动类型等条件；方向措辞冲突解释；GUI/Fiori 只读路径与权限。SAP 系统未连接，没有实机测试。
- 工作线 1 下一篇：**MM-10《采购库存数据模型与单据关系》**，路径 knowledge/MM/05-data-model/purchasing-inventory.md。按逐篇分流为“暂缓核心”，先核对固定版证据，不将 MM-09 或其他邻近文章的范围外推为完整模型。

## 工作线 5 进度（2026-11-27，CO-01）

- CO-01《管理会计从零：成本与利润》已按批准路径建立限缩草稿；当前状态 drafting。普通读者、配置顾问、开发者视角各完成 5 个有效闭环，共 15；均为同一 Work 上下文模拟，不是独立审核，故不计正式 reviewed。
- 核心入门证据来自 SAP S/4HANA 2021 Feature Scope Description v9.0（适用于 SP08）的总账、成本中心与计划/实际报告说明，以及 2021 Simplification List §8.1 的有限 Universal Journal 背景。记录见 [CO-01 审查](reviews/work/2026-11-27-m4-co01-three-role-review.md) 和 [M4 财务证据登记](plans/evidence-finance-m3.md)。
- 独立复核仍待完成；范围外的自动成本对象归属、计划维护、分摊/结算规则、利润分析配置、表/API/字段和权限仍不作通用断言。FI-07普通库存采购借贷、税及自动科目边界未扩展。SAP未连接，无实机测试。
- 批次 A 正式 reviewed 仍为 8/50、owner accepted 为 0/50；全库 owner accepted 为 3/99。工作线 5 下一篇 CO-02《成本中心与成本要素》，路径 knowledge/CO/02-functions/cost-center-elements.md；接手时先读取其准入项与证据登记，本次未加载 CO-02 完整研究资料。


## 工作线 2 进度追记（2026-11-27，PP-04）

- **PP-04《需求、MRP 与计划订单》**已按 M3 准入路径建立证据受限正文，状态 drafting，路径 knowledge/PP/02-functions/mrp-planned-order.md。正文区分 MRP 的高层补货规划、计划订单与采购申请/生产订单，并把纸面算术标为非 SAP 算法/系统结果。
- [PP-04 Work 角色视角记录](reviews/work/2026-11-27-m4-pp04-three-role-review.md)记载普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个同上下文模拟闭环，共 15；不是独立审查者或真人专家意见，不计入正式 reviewed 数。
- 来源范围：固定版 SAP S/4HANA 2021.000 Help 仅支持 J44 的 Monitor Material Coverage 功能条目和 Planned Order API 范围；Operations Guide 及 Feature Scope Description 实际所读为 2021 SPS10、文档版本 11.0/2026-07-22。FSD URL 动态，文章只标为 SPS10 快照参考，不冒充固定 2021 初始版。
- 净需求算法、批量/lot-sizing 参数、库存与收货纳入、计划提议类型选择、客户系统设置、完整 API/数据模型与权限仍未闭合。PP-04 保持 drafting；不增加批次 A reviewed 或 owner accepted 数。批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，全库正式接受 **3/99**；SAP 系统未连接，无实机测试。
- 工作线 2 下一篇：**PP-05《生产订单与确认》**，批准路径 knowledge/PP/02-functions/production-order.md；开始前只读取该篇对应准入、来源及关联材料。

## 工作线 3 进度追记（2026-11-27，QM-02）

- **QM-02《检验类型与检验批》**已按 M3 准入路径建立证据受限文章 `knowledge/QM/02-functions/inspection-type-lot.md`，当前状态 `drafting`。正文区分 inspection lot origin、inspection type 和 inspection lot；只写固定版 SAP Help 支持的采购收货建批条件、质量信息记录中的两个页面特定用例、收货去向与检验批库存相关性、结果规格和 UD/过账关系。
- [QM-02 Work 角色视角记录](reviews/work/2026-11-27-m4-workline-3-qm02-review.md)记载普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个闭环，共 15 个同一 Work 上下文角色模拟；不是独立代理、第二模型或真人专家复核。
- 目标版来源沿用 [QM-02 固定版研究记录](plans/qm-gr-inspection-2021-m3.md)，该记录称五个 SAP Help 页面版本选择器均显示 2021 (Oct 2021)，并记载独立复读覆盖自动收货建批条件页与库存过账时点页。本轮未重新打开版本选择器、未连接 SAP，也未验证客户系统。
- 尚未闭合：skip inspection/动态修改/不建批的完整规则，质量信息记录更广泛的供应商/工厂差异，普通 IM 与 EWM 的场景边界及财务凭证影响；移动类型 103 仅保留为固定版页面限定例子。未编写通用权限或事务码行为。
- QM-02 保持 `drafting`，15 个同上下文模拟闭环不计正式 reviewed；批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，全库正式接受数仍为 **3/99**。SAP 实机测试为 0。
- 下一篇：**QM-03《检验计划与检验特性》**，批准路径 `knowledge/QM/02-functions/inspection-plan-characteristic.md`。按逐篇准入只读取 QM-03 对应来源和依赖。


## 工作线 2 进度追记（2026-11-27，PP-05）

- **PP-05《生产订单与确认》**已建立证据受限草稿，状态 drafting，路径 knowledge/PP/02-functions/production-order.md。正文仅按固定 2021.000 Help 的 BJ5 订单管理、释放授权特例、确认 API 数据提议和订单对象页功能，以及动态 2021 SPS10 FSD 快照说明有限内容。
- [PP-05 Work 角色视角记录](reviews/work/2026-11-27-m4-pp05-three-role-review.md)记载读者、资深配置顾问、普通开发人员各 5 个同上下文模拟闭环，共 15；不是独立审查或真人专家意见，不计正式 reviewed。
- 订单状态全集、通用释放条件、部分/最终确认、撤销、确认与发料/收货联动、数据模型/API 合同、客户授权及 FI/CO 结果仍未闭合；不把确认直接等同于自动发料/入库。PROCESS-05 正文不在本分支，未引用。
- 批次 A 正式进度保持 **8/50 reviewed、0/50 owner accepted**；全库正式接受 **3/99**。SAP 系统未连接；未执行订单/确认/API 实机测试。
- 工作线 2 下一篇：**PP-06《生产发料、收货与成本》**，批准路径 knowledge/PP/02-functions/production-goods-cost.md；先核对该篇自身准入、来源和关联材料。

## 工作线 3 进度追记（2026-11-27，QM-03）

- **QM-03《检验计划与检验特性》**已按准入路径建立固定版证据受限草稿 `knowledge/QM/02-functions/inspection-plan-characteristic.md`，状态 `drafting`。正文只用 S/4HANA 2021 FPS01《What's New》记录的 Manage Inspection Plans 工作清单按材料筛选变化，以及 2021.000 Business Events for Inspection Plans 条目的 create/update/delete 事件范围。
- 文章提交：`0188dcd250fcb2d55ca8545f4f14f4e83a37e9fe`；[Work 角色视角审查记录](reviews/work/2026-11-27-m4-workline-3-qm03-review.md)提交：`d76af3cb1e28c4f2f9121f2156f22eb4b07d1189`。
- 三个角色各有 5 个同一 Work 上下文模拟闭环，共 15；不代表独立代理、第二模型或真人专家审查。SAP 系统未连接，未执行计划、特性、应用、权限或 API 实机测试。
- M3 原检验规划概述来自动态 FSD latest，本篇未用它作固定版 2021 证据；正文没有写完整计划结构、特性字段、plant/validity/lot-size 选择规则、sampling 参数或客户系统可用性。上述准入核心仍未闭合，故 QM-03 保持 `drafting`，不计正式 reviewed。
- QM-03 不增加正式计数：批次 A 仍为 **8/50 reviewed、0/50 owner accepted**，全库正式接受数仍为 **3/99**。下一篇：**QM-04《结果记录与使用决策》**，批准路径 `knowledge/QM/02-functions/results-usage-decision.md`；按逐篇准入只读取 QM-04 对应来源和依赖。

## 工作线 5 进度追记（2026-11-27，CO-02）

- CO-02《成本中心与成本要素》已按批准路径建立证据受限文章，状态 **drafting**，M3“暂缓核心”门槛未全部关闭。正文仅以 SAP S/4HANA 2021 FSD v9.0/SP08 快照、固定版 Migration Objects 2021.000 和 Central Finance 2021.001 指南支持有限主张。
- 记录三角色视角闭环：普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5，共 15 个同 Work 上下文模拟闭环；没有独立审查者或真人专家参与，不计 reviewed。
- 仍缺：成本中心主数据字段级有效期和组织配置约束、成本要素类别及日常分配/自动规则、通用凭证行为、表字段/键/API/CDS 和权限。Central Finance 对成本要素与总账账户的说明仅限其映射与初始加载场景；迁移范围/迁移源结构不外推为普通应用模型。
- FI-07 普通库存采购完整借贷、税务与自动科目边界保持开放；SAP 未连接，无实机测试。
- 批次 A reviewed/owner accepted 计数不变：**8/50、0/50**；全库正式接受 **3/99**。文章、闭环与证据登记分别见 [CO-02 正文](knowledge/CO/02-functions/cost-center-elements.md)、[CO-02 审查](reviews/work/2026-11-27-m4-co02-three-role-review.md)、[财务证据登记](plans/evidence-finance-m3.md)。
- 本节提交前实时检查 PR #21：状态 open、未合并、目标 main；工作分支 careeros-v04-m4-batch1-20261126；当时工作分支 HEAD 为 488c888bcbaa8c223f60d175126861ffdeafd983。该值是本节提交前的 HEAD。
- 工作线 5 下一项：CO-03《内部订单和费用归集》，按其准入路径和证据登记开始；本次没有预载 CO-03 完整研究资料。


## 工作线 3 进度追记（2026-11-27，QM-04）

- **QM-04《检验结果与使用决策》**已按准入路径建立证据受限文章，路径为 knowledge/QM/02-functions/results-usage-decision.md，状态 drafting。固定版 SAP Help 支持工作清单记录结果/作使用决策；在 planned samples 页面语境中，UD 有授权、批次释放、结果/特性/样本完成和无阻断状态等前提；库存相关批次在存在未过账数量时可于 UD 前、期间或之后过账，并区分特定代码的自动过账与周期作业自动 UD。
- Work 角色视角记录见 reviews/work/2026-11-27-m4-workline-3-qm04-review.md：普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5，共 15 个同上下文模拟闭环；独立角色审查为 0，不代表真人专家或独立代理复核。
- 文章仍为 drafting。一般结果录入字段/缺陷处理、自动 UD 完整资格、UD 撤销、移动类型、库存估价与 FI/CO 影响、具体角色/权限映射仍未闭合。EWM 不用于推导普通 IM 行为；PROCESS-06 正文在当前分支不存在。SAP 系统未连接、实机测试为 0。
- QM-04 不改变批次 A **8/50 reviewed、0/50 owner accepted** 或全库正式接受 **3/99**；本次角色模拟不计正式 reviewed。
- 工作线 3 下一篇：**QM-05《质量库存与采购生产集成》**，路径 knowledge/QM/02-functions/quality-stock-integration.md。按准入“暂缓核心”处理，逐篇读取固定版来源；特别避免用 EWM 例子代替一般 IM 库存与财务证据。

## 工作线 2 进度追记（2026-11-27，PP-06）

- **PP-06《生产发料、收货与成本》**正文与 Work 审查记录已提交至当前 PR，路径分别为 `knowledge/PP/02-functions/production-goods-cost.md` 与 `reviews/work/2026-11-27-m4-workline-2-pp06-three-role-review.md`；文章状态 `drafting`。
- 三个角色视角各 5 个闭环，共 15 个同一 Work 上下文内的模拟循环，不是独立审查者或真人专家复核。文章及审核记录明确披露此限制，不计入正式 role-reviewed 数。
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
- 本工作线不改变批次 A **8/50 reviewed、0/50 owner accepted**；全库正式接受仍为 **3/99**。PR #21 保持开放、未合并。
- 本工作线分配范围已完成；本线内没有下一篇。后续文章须由协调者另行分配。

## M4 工作线 5 更新：CO-03（2026-11-27）

- 提交前实时复核 PR #21：open、未合并、base main；工作分支 careeros-v04-m4-batch1-20261126，本次 HANDOFF 更新前 HEAD 为 d6f274693efd0a47d4ac9c78ed2b05886140e234。PR 不合并。
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
- 本次更新前已重新读取 PR #21：open、未合并、目标 `main`；基于工作分支 HEAD `7c36b5db4904e6a18e61c293a854ab2c8c4c38d6`。PR 不合并。本工作线范围已完成；本线下一篇为“无”，后续需另行分配。

## M4 工作线 5 更新：CO-04（2026-11-27）

- 提交前实时复核 PR #21：open、未合并、base main；工作分支 careeros-v04-m4-batch1-20261126，本次 HANDOFF 更新前 HEAD 为 f74d9461fcd24461477da49100e1ebf2ccfb6a47。PR 不合并。
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
