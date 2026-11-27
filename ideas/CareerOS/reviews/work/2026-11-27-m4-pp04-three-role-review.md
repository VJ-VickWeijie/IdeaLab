# PP-04｜需求、MRP 与计划订单：Work 角色视角审查记录

- 日期：2026-11-27（Asia/Shanghai；仅记录日期，未保留每轮具体时分）
- 工作包：CareerOS M4 批次 A，工作线 2
- 文章路径：ideas/CareerOS/knowledge/PP/02-functions/mrp-planned-order.md
- 审核基线：文章修订提交 668098d2c3b3ccbaf5a371edef8ee90c42673b77
- 状态：drafting
- 角色视角闭环：普通读者 5/5；资深 SAP 配置顾问 5/5；普通 SAP 开发人员 5/5；合计 15/15。
- 独立性：同一 Work 上下文内的角色视角模拟，不是独立审查者、真人专家或独立 Agent；不计正式三角色独立审查。
- 系统验证：SAP 未连接；实机 MRP、配置和 API 验证均为 0。

## 1. M3 范围、路径与记录依据

M3 逐篇准入分流将 PP-04《需求、MRP 与计划订单》标记为“限缩可写”，批准路径为 knowledge/PP/02-functions/mrp-planned-order.md。范围包括需求/库存/计划、MRP 结果与计划订单、短缺、计划参数和来源；示例应明示期初库存、需求、批量及供给假设，不把结果写成所有系统的必然计算。

PP-04 在当前 M3 控制矩阵中没有独立行。本记录按准入分流、detail-logistics、evidence-logistics 与 SD/PP source-fit 的 PP-04 条目执行，不由控制矩阵缺行补造产品规则。关联稿只读取 PP-01、PP-02、PP-03 和 MM-05；没有展开 PP-05 及更后文章。

## 2. 来源及适用边界

| Ref | SAP 官方资料 | 本轮可支持 | 本轮不能推出 |
| --- | --- | --- | --- |
| R1 | SAP, SAP S/4HANA 2021 Feature Scope Description, §2.8.3.1, PDF pp.70–71。动态 URL：https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf。实际读取封面：Document Version 11.0，2026-07-22，对应 S/4HANA 2021 SPS10。 | 该文件快照高层说明需求/供应覆盖、计划运行可产生计划订单或采购申请、库存/需求监控、计划订单的内部计划性质、部分后续转换边界；第 71 页另说明容量计划与 MRP 的区别。 | 它不是固定 2021.000 初始版页面；净需求公式、lot sizing、全部参数、客户配置或跨 FPS/SPS 行为。正文只按 SPS10 动态快照引用。 |
| R2 | SAP Help, “Monitor Material Coverage”, SAP S/4HANA 2021 (Oct 2021), version 2021.000，Scope Item J44：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/0c7dcb460ef1472989aeea008bbf1bbb.html?locale=en-US&state=PRODUCTION&version=2021.000 | 该应用新增 intraday supply 及参照 safety time 的 shortage 显示能力。 | 通用 available stock/net requirement 公式、所有系统的短缺算法或 safety stock 参数值。 |
| R3 | SAP, Operations Guide for SAP S/4HANA 2021, §10.2.1.1，PDF pp.22–24：https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf。实际读取版本 11.0（2026-07-22，SPS10）。 | MRP 记录操作说明、物料主数据 MRP views/MRP type 前提、MRP Live 总需求清理的运维注意事项。 | 通用计划公式、lot-size 计算、净需求各要素规则或客户系统的启用/配置状态。 |
| R4 | SAP Help, “OData-API: Planauftrag / Planned Order API”, SAP S/4HANA 2021 (Oct 2021), version 2021.000（德文页面）：https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/61b00a5868a944f28c4f2d865f45442c.html?locale=de-DE&state=PRODUCTION&version=2021.000 | 页面列明 API_PLANNED_ORDERS 的读取/创建/更改/删除能力、BJ5/J44 范围及使用 OData V4 的建议。 | MRP 运行或净需求算法、完整字段/主键、所有系统启用、授权或调用结果。 |

S/4HANA 2021 Operations Guide 版本历史列出 1.0（2021-10-13，初始版）到 11.0（2026-07-22，SPS10）。本轮运维细节严格称为 SPS10 资料，不把现行修订冒充 Oct 2021 初始版。FSD 也保持动态快照身份。

## 3. 闭环记录

每项均记录问题、来源、Work 答复、修订判断/修改、原角色视角复核和状态。closed-in-perspective 仅表示模拟视角内的问题已处理，不等于独立 review 通过。

### 普通读者

#### PP04-R-01
- article_id：PP-04；role：普通读者；round：1；timestamp：2026-11-27（仅日期）
- question：MRP 是不是一个会直接替我买料或开生产单的按钮？
- evidence：R1 将计划运行产出的采购申请/计划订单称作补货提议，并称计划订单为内部计划要素。
- work_response：区分 MRP 运行、补货提议、采购申请与后续订单；计划结果不代表已向供应商下单。
- change_ref：正文“MRP 先解决什么问题”及对象表。
- recheck：原读者视角复核后，能区分计划与采购/生产执行。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-R-02
- article_id：PP-04；role：普通读者；round：2；timestamp：2026-11-27（仅日期）
- question：短缺出现后为什么有时是采购申请、有时是计划订单？
- evidence：R1 的高层说明列出两种提议，但未给出完整采购类型/参数决定规则。
- work_response：只介绍两者是不同补货建议，不编造由单一字段必然决定的规则。
- change_ref：对象表“计划订单”“采购申请”两行及核心待补证清单。
- recheck：原读者视角复核后，正文没有承诺每种短缺必然形成某一种建议。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-R-03
- article_id：PP-04；role：普通读者；round：3；timestamp：2026-11-27（仅日期）
- question：计划订单是不是已经向供应商下了采购订单？
- evidence：R1 说明计划订单为内部计划要素，外购计划订单可转换为采购申请。
- work_response：将计划订单、采购申请、采购订单分开，不把后续采购写成已发生。
- change_ref：正文“计划订单是什么”及对象表。
- recheck：原读者视角复核后，理解计划订单不是对外采购合同。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-R-04
- article_id：PP-04；role：普通读者；round：4；timestamp：2026-11-27（仅日期）
- question：计划订单永远只用于计划、不可能触发生产吗？
- evidence：R1 对重复制造保留例外，说明该场景可用计划订单触发生产。
- work_response：补充重复制造为单独例外，避免把“一般”写成“绝不”。
- change_ref：正文“计划订单是什么”第一段。
- recheck：原读者视角复核后，一般规则与例外分开。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-R-05
- article_id：PP-04；role：普通读者；round：5；timestamp：2026-11-27（仅日期）
- question：纸面例子算出 10 件，为什么不能说 SAP 会创建 10 件计划订单？
- evidence：R1 未给通用净需求/lot-sizing 公式；R2 是应用能力说明而非计算手册。
- work_response：把例题标为纸面余额差，明确期初量、预计供应、需求、单位、批量假设及排除项；声明 10 不是 SAP 结果。
- change_ref：正文“需求短缺不等于固定的计划订单数量”和教学假设清单。
- recheck：原读者视角复核后，不会把算术题当成产品算法。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

### 资深 SAP 配置顾问

#### PP04-C-01
- article_id：PP-04；role：资深 SAP 配置顾问；round：1；timestamp：2026-11-27（仅日期）
- question：FSD URL 含 latest 且在 2026 修订，能否当成 2021.000 初始版净需求算法的证据？
- evidence：R1 封面标文档版本 11.0/2026-07-22，对应 SPS10；M3 evidence-logistics 将其标为动态 FSD。
- work_response：不称为固定初版来源；正文保留文件版本、日期、SPS10 标签，只作该快照的高层范围参考。
- change_ref：正文开篇版本警示、来源与版本表；本记录 R1。
- recheck：原顾问视角复核后，没有把动态 SPS10 文件误标为固定版 2021.000。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-C-02
- article_id：PP-04；role：资深 SAP 配置顾问；round：2；timestamp：2026-11-27（仅日期）
- question：能否把所有需求、库存、预留、在途和收货元素写成统一净需求清单？
- evidence：R1 仅作高层需求/供应例示；M3 PP-04 source-fit 明确净需求算法和参数未核。
- work_response：不列通用可用量公式，不说任意库存、预留或在途量必然计入；把例示与纳入规则缺口分开。
- change_ref：对象表“需求”“现有库存及预期供应”两行；待补证第一项。
- recheck：原顾问视角复核后，稿件未把高层概述扩展成算法。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-C-03
- article_id：PP-04；role：资深 SAP 配置顾问；round：3；timestamp：2026-11-27（仅日期）
- question：题目 1:1 补缺口是否掩盖 lot size、舍入、损耗或安全库存的影响？
- evidence：M3 分流要求例题说明批量和供给假设；R1 未提供 lot-size 公式。
- work_response：将 1:1 标作本题教学假设而非 SAP 设置，逐项列出没有计算的限制，不把 10 件解释成 planned order quantity。
- change_ref：纸面示例的假设清单及待补证第二项。
- recheck：原顾问视角复核后，算术例子的边界和未核参数均显式可见。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-C-04
- article_id：PP-04；role：资深 SAP 配置顾问；round：4；timestamp：2026-11-27（仅日期）
- question：计划订单转换和组件预留是否会把 PP-05 的订单状态规则抢写进本篇，或暗示所有制造场景一致？
- evidence：R1 按离散、流程、重复制造分别描述转换路径/例外；M3 将订单状态及转换条件安排在 PP-05。
- work_response：仅保留有限对象边界，将资格、状态、转换条件列作 PP-05/配置的待核内容。
- change_ref：正文“计划订单是什么”第二段及待补证第三项。
- recheck：原顾问视角复核后，场景区别和后续文章边界清楚。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-C-05
- article_id：PP-04；role：资深 SAP 配置顾问；round：5；timestamp：2026-11-27（仅日期）
- question：MRP 是否已考虑工作中心/资源能力，能否据此推导订单工序日期？
- evidence：R1 §2.8.3.2（PDF p.71）把 MRP 需求覆盖与考虑能力约束的 capacity planning 分开。
- work_response：补充 MRP/产能计划边界，不由此推导工序日期或能力公式。
- change_ref：正文开篇后新增的产能边界句。
- recheck：原顾问视角复核后，MRP 与产能计划没有混为一项，动态来源限制可见。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

### 普通 SAP 开发人员

#### PP04-D-01
- article_id：PP-04；role：普通 SAP 开发人员；round：1；timestamp：2026-11-27（仅日期）
- question：Planned Order API 的存在是否意味着可通过 API 触发整个 MRP run？
- evidence：R4 支持计划订单的读取/创建/更改/删除，没有描述 MRP run API。
- work_response：将 API 限定为计划订单对象管理，不提供触发 MRP 的调用结论。
- change_ref：2021 有限入口第2项及待补证第四/五项。
- recheck：原开发者视角复核后，资源操作与计划计算分开。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-D-02
- article_id：PP-04；role：普通 SAP 开发人员；round：2；timestamp：2026-11-27（仅日期）
- question：能否从 API_PLANNED_ORDERS 的名称或 CRUD 能力推断生产表、字段键及头行基数？
- evidence：R4 说明 API 能力及范围，没有给出完整字段模式/数据库结构；M3 PP-04 数据模型仍需另查。
- work_response：不列物理表、主键、字段或关联基数，明示为待补证。
- change_ref：正文 API 边界句及待补证第五项。
- recheck：原开发者视角复核后，未出现从接口名推断物理模型的主张。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-D-03
- article_id：PP-04；role：普通 SAP 开发人员；round：3；timestamp：2026-11-27（仅日期）
- question：Operations Guide 的 MRP records 章节是否足以证明 lot-size 参数和净需求公式？
- evidence：R3 讲 MRP 记录运维、MRP views/MRP type 前提及部分 MRP Live 准备事项，不是通用算法。
- work_response：只用于说明 SPS10 运维前提，不由运维材料推导业务计算或开发接口。
- change_ref：2021 有限入口第3项和来源范围表。
- recheck：原开发者视角复核后，运维步骤未被外推成算法/接口合同。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-D-04
- article_id：PP-04；role：普通 SAP 开发人员；round：4；timestamp：2026-11-27（仅日期）
- question：Monitor Material Coverage 的 intraday supply/shortage 是否证明底层 available stock 公式？
- evidence：R2 是 J44 指定应用功能条目，不含库存字段集合或公式。
- work_response：将其定位为应用级监控能力，声明不能替代净需求/批量算法说明。
- change_ref：2021 有限入口第1项。
- recheck：原开发者视角复核后，没有把 UI 功能当成底层模型证据。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

#### PP04-D-05
- article_id：PP-04；role：普通 SAP 开发人员；round：5；timestamp：2026-11-27（仅日期）
- question：读过 SAP 文档，是否可以说已在目标版系统运行或验证效果？
- evidence：本轮只有公开 SAP 文档和仓库文本；目标 SAP 系统没有连接。
- work_response：正文开篇和结尾明确未执行 MRP、配置核对或 API 调用，客户系统结果未知。
- change_ref：文章元数据“系统状态”及末尾声明。
- recheck：原开发者视角复核后，没有测试、权限或客户配置已验证的暗示。
- status：closed-in-perspective；executor_context：同一 Work 上下文模拟，无真人专家或独立 Agent。

## 4. 结论与未闭合事项

- 普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各完成 5 个同上下文角色视角闭环，共 15 个；不是独立审查或真人专家评审。
- 高层 MRP/计划订单说明只引用明确标注的 S/4HANA 2021 SPS10 动态 FSD 快照。固定版 2021.000 Help 仅支持特定监控应用和 Planned Order API 条目；SPS10 Operations Guide 用于运维前提边界。
- 净需求算法、批量算法/参数、库存与收货纳入规则、计划提议选择、客户配置、完整数据模型和授权均未闭合。纸面算术不是 SAP 系统结果。
- 核心学习目标仍不足以写成完整目标版 MRP 指南；文章保持 drafting，不增加批次 A reviewed 数或 owner accepted 数。
- 下一篇：PP-05《生产订单与确认》，路径 ideas/CareerOS/knowledge/PP/02-functions/production-order.md。开始前只读 PP-05 对应准入、来源及关联文章。

