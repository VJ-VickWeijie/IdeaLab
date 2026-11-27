# QM-05｜Work 写作与三角色视角闭环记录

- 日期：2026-11-27（Asia/Shanghai）
- 文章：QM-05《质量库存与采购生产集成》
- 正文：ideas/CareerOS/knowledge/QM/02-functions/quality-stock-integration.md
- 目标版本：SAP S/4HANA 2021 On-Premise
- 执行上下文：下方“写作阶段历史记录”来自同一 Work 上下文三种角色视角模拟；另在收尾阶段由三个独立 AI reviewer-context（普通读者、资深 SAP 配置顾问、普通 SAP 开发人员）各自复核最终精确正文 5 项。没有真人 SAP 专家签核，模型 ID 未显示。
- 最终正文 blob：`11b9c2768c7de47b80f1b016d834101957b7456f`。
- 结果：历史同上下文模拟 15 项不计独立审查；收尾复核另有 15 项独立 AI reviewer-context 边界检查，最终 15/15 PASS。它们不关闭 M3“暂缓核心”证据门槛，文章仍为 Draft，不计 Role Reviewed；批次 A 计数仍 9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted。

## 写作阶段历史来源说法（收尾复核时已限缩）

以下历史模拟中的来源描述记录的是写作阶段的归纳，不是本次可复读的固定版原文摘录，不能单独视作目标版本证据：

1. 既有正文/review 曾把 2021.000《Inspection for a Goods Receipt》概括为支持外部/生产收货、不同去向和库存相关性。
2. 既有正文/review 曾把 2021.000《Stock Management in QM》概括为支持 QM 管理库存边界及 QM 未激活时 MM-IM 的行为。
3. 既有正文/review 曾把 2021.000《Stock Postings》概括为支持过账时点、目标类别、物料凭证及目录类型 3 的后台处理。
4. 旧正文曾记载移动类型 103 的特定“不估价”示例；当前 M3 QM-05 来源记录没有保留可逐句核对的摘录。
5. M3 的 QM-05 台账仅登记动态 SAP S/4HANA 2021 SPS10 FSD §2.8.5.2 的 EWM 仓储质量管理范围，明确不能替代一般 IM 证据。

收尾复核对以上三条带 `version=2021.000` 的 SAP Help 固定页面执行直接打开，均返回 not accessible。当前未锁版本页面/搜索摘要没有作为 2021.000 证据。M3 来源访问、历史记录限制和后续核验要求见[QM-05 来源补记](../../plans/qm-gr-inspection-2021-m3.md)。SAP 系统未连接。

## 写作阶段同上下文角色模拟记录（历史档案；不作为当前正文/来源证据）

以下三组 15 个模拟闭环形成于旧正文写作阶段，原样保留以供追溯。它们引用的固定版主张未在 M3 QM-05 台账留下可逐句复核摘录，且部分条目含旧的分支/状态文字；不得将其视为当前正文复核、目标版原文证据或独立审查。当前可用结论见本文“收尾阶段独立 AI reviewer-context 复核（最终正文）”。

## 普通读者视角｜5 个闭环

### 1. 看到“质检库存”是不是就代表有 QM 检验批？

- article_id：QM-05；role：普通读者；round：1
- question：初学者可能把库存状态和 QM 处理对象看成同一件事。
- evidence：固定版 Stock Management in QM 页面说 QM 未激活时，MM-IM 仍可能向检验库存过账或转出；手工创建检验批不由 QM 管理库存移动。
- work_response：这是文章最重要的边界，应放在开头，并用简表说明两个对象不可互相证明。
- change_ref：第 1 节加“检验库存/检验批/QM 管理库存/MM-IM 过账”对照表。
- recheck：原读者视角能从表中回答“有检验库存不一定证明有 QM 管理的检验批”，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 2. 仓库、消耗、收货冻结库存有什么区别？

- article_id：QM-05；role：普通读者；round：2
- question：需要一个直观表格说明收货目的地如何影响检验批是否库存相关。
- evidence：固定版 Inspection for a Goods Receipt 页面分别说明仓库库存为库存相关、消耗为非库存相关、收货冻结库存为库存相关。
- work_response：可以按来源页原文整理，但不要进一步推导库存价值或会计结果。
- change_ref：第 2 节逐行列出页面所述三类去向和相关性，并标明不推导财务结论。
- recheck：原读者视角可区分“有检验批”与“库存相关检验批”，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 3. “来自生产”是不是“生产过程中的检验”？

- article_id：QM-05；role：普通读者；round：3
- question：页面提到生产收货会不会让读者以为文章已证明生产订单释放/工序检验？
- evidence：固定版 Inspection for a Goods Receipt 页面只支持从生产进入收货场景；没有本篇所需的工序检验触发直接来源。
- work_response：要将生产收货与生产中检验分成两个不同问题。
- change_ref：第 3 节限定为“生产完成后作为收货来源”，并列出生产订单释放和工序检验等未证结论。
- recheck：原读者视角正确理解本篇未说明生产线内检验，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 4. QM 未激活但检验库存能否存在？

- article_id：QM-05；role：普通读者；round：4
- question：开篇既说 QM 管理检验库存，又说 MM-IM 可能仍有检验库存，会不会矛盾？
- evidence：固定版 Stock Management in QM 页面分别说明 QM 管理的自动建批库存与 QM 未激活时的 MM-IM 过账。
- work_response：这是两个处理边界，不矛盾；文章要清楚说同一类别名称不能证明由哪个组件管理。
- change_ref：第 1、2 节及案例第 3 步把“库存状态”和“QM 是否管理该批”分开。
- recheck：原读者视角复述为“库存存在，不能单独认定 QM 在管理它”，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 5. 练习是否在教人执行生产环境动作？

- article_id：QM-05；role：普通读者；round：5
- question：收货案例列了分析顺序，是否会被当作实机操作指导？
- evidence：本轮没有连接客户 SAP，产品资料不是目标系统实测。
- work_response：练习应是资料核对提问，不提供操作步骤、事务码或生产建议。
- change_ref：第 5 节标题和末句明确该案例是文献分析，不是客户系统操作指引；文首声明无实测。
- recheck：原读者视角确认没有要求用户操作系统，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

## 资深 SAP 配置顾问视角｜5 个闭环

### 1. 收货去向和库存相关性有没有条件边界？

- article_id：QM-05；role：资深 SAP 配置顾问；round：1
- question：仓库/消耗/收货冻结库存的表述是否只复述目标版页面所述场景？
- evidence：固定版 Inspection for a Goods Receipt 页面明确给出这三类收货去向和库存相关性；来源没有形成完整客户状态矩阵。
- work_response：限定到该收货页面，不推断其他库存类别、类型或估价。
- change_ref：第 2 节表格称“页面所述”，并分别列出不能推广的范围。
- recheck：原顾问视角认为页面主张与扩展边界一致，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 2. 供应商收货和生产收货如何并列？

- article_id：QM-05；role：资深 SAP 配置顾问；round：2
- question：固定版 GR 页面是否同时涵盖 vendor 和 production source，是否足以写生产中检验？
- evidence：页面支持外部供应商与内部生产作为收货来源；并未提供生产订单发布或工序检查详细行为。
- work_response：可并列两种收货来源；生产订单释放、工序检验和生产状态联动应保留为未证。
- change_ref：第 3 节补入“生产完成后作为收货来源”的窄范围，并用清单明确不推断生产检验触发。
- recheck：原顾问视角确认未把库存收货与 inspection during production 混写，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 3. 移动类型 103 的不估价示例能否用于所有冻结库存？

- article_id：QM-05；role：资深 SAP 配置顾问；round：3
- question：M3来源材料提到 movement type 103 的GR blocked例子，文章是否会推广成所有冻结库存不估价？
- evidence：QM-02 固定版研究记录将该行为限定在特定 103 暂存区例子；其他冻结库存场景未闭合。
- work_response：仅把该例用作范围说明，不能扩展为通用价值规则。
- change_ref：第 6 节专门说明 103 为特定暂存示例，拒绝将其推广为所有 GR-blocked stock 的估价规则。
- recheck：原顾问视角确认未形成一般估价断言，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 4. 是否能补写 FI/CO 影响？

- article_id：QM-05；role：资深 SAP 配置顾问；round：4
- question：物料凭证与库存变化能否推导出 FI 凭证、科目和价值变化？
- evidence：固定版 Stock Postings 摘要只支持生成物料凭证；M3 对普通 IM 价值和财务影响未证。
- work_response：不能推导财务凭证和估价行为，准入核心仍有缺口。
- change_ref：第 2、4、6 节分别保留库存相关性、物料凭证和未证的价值/FI影响边界。
- recheck：原顾问视角确认没有将 MM 事件写成一般借贷分录，通过。
- status：closed；原顾问视角复核修订，但文章核心证据门禁仍未通过；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 5. EWM 的 origin 17 / 部分 UD 是否能作普通 IM 例子？

- article_id：QM-05；role：资深 SAP 配置顾问；round：5
- question：来源台账存在 EWM-specific 场景，是否可以补进一般仓储集成说明？
- evidence：M3 来源台账明确该 FSD 段属于 Basic Warehouse Management/QM 的 EWM 场景，且 FSD 是动态 latest 快照；QM-05准入要求普通 IM 的直接证据。
- work_response：不把 EWM 内容作为 IM 依据；只能登记范围界限。
- change_ref：第 6、7 节明确不引用 EWM 的 origin 17、部分 UD 和仓库任务来说明普通 IM。
- recheck：原顾问视角确认没有跨产品场景外推，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

## 普通 SAP 开发人员视角｜5 个闭环

### 1. 是否该列出库存对象表、字段或 T-Code？

- article_id：QM-05；role：普通 SAP 开发人员；round：1
- question：库存关联文章能否列出物料凭证表、检验批字段、事务码或 API？
- evidence：本轮固定版来源只支持业务层关系，不支持本篇字段/键/API或逐事务职责。
- work_response：不从业务关系推断数据库表、事务码或接口。
- change_ref：正文没有增加字段、表名、API 或 T-Code，第 6 节注明权限/操作入口未核。
- recheck：原开发者视角确认未出现未证技术映射，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 2. 物料凭证与会计凭证是否分开？

- article_id：QM-05；role：普通 SAP 开发人员；round：2
- question：stock posting 的 material document 是否可视为 accounting document？
- evidence：2021.000 Stock Postings 页面摘要支持物料凭证；财务影响没有已闭合证据。
- work_response：两种凭证不能混为一谈；不推导后者或其金额。
- change_ref：第 4 节只写物料凭证；第 6 节把估价和 FI/CO 列为不能下的结论。
- recheck：原开发者视角确认数据对象含义没有越界，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 3. 检验批如何关联具体收货凭证？

- article_id：QM-05；role：普通 SAP 开发人员；round：3
- question：文章是否暗示每个检验批一定只对应单个采购或生产收货物料凭证？
- evidence：本轮来源没有证明完整业务对象基数或关联键。
- work_response：仅说明发生收货与检验批库存相关性的有限关系，不给实体键/基数。
- change_ref：全文不声明单据一对一关系；第 7 节将 PROCESS-06 缺席与未闭合链路说明清楚。
- recheck：原开发者视角确认未引入 cardinality/JOIN 假设，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 4. 授权前提能否映射到用户角色或权限对象？

- article_id：QM-05；role：普通 SAP 开发人员；round：4
- question：UD 需要适当授权，这是否足够推出质量技术员、质量工程师或具体 authorization object？
- evidence：固定版 UD 页面仅说明 appropriate authorization；本轮没有独立读取用户角色和权限对象映射。
- work_response：只保留“适当授权是前提”，不命名角色或权限对象。
- change_ref：第 6 节权限行和第 2 节状态说明明确列出未知项；未写角色或授权对象。
- recheck：原开发者视角确认未将文档的授权前提转成客户角色事实，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 5. 依赖、EWM 与实机声明是否可审计？

- article_id：QM-05；role：普通 SAP 开发人员；round：5
- question：文章是否依赖不存在的 PROCESS-06，或把动态 FSD/EWM 和客户实测混入固定版说明？
- evidence：当前 PR #21 无 PROCESS-06 正文；M3 对 FSD 的版本风险和 EWM 边界有明确记录；SAP未连接。
- work_response：直接披露依赖不存在、FSD仅为边界提醒且不作为证据，并明确未实测。
- change_ref：第 7 节记录 PROCESS-06 缺席和 FSD 动态版本；第 6 节分开 EWM 与 IM；文首声明未连接 SAP。
- recheck：原开发者视角核对依赖、来源版本和测试声明均一致，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

## 收尾阶段独立 AI reviewer-context 复核（最终正文）

执行方式：每名 reviewer-context 在自己的独立上下文中，对最终正文精确 blob `11b9c2768c7de47b80f1b016d834101957b7456f` 完成 5 项原角色质询、证据范围检查、作者修订位置核对及原角色复核。下表记录的是文章文本/证据边界是否如实呈现；PASS 不表示相关 SAP 规则已被固定版来源证实。

### 普通读者 reviewer-context（5 项）

| # | 质询 | 证据答复与作者修订 | 原角色复核 |
| --- | --- | --- | --- |
| 1 | 质量检验库存能否证明存在 QM 管理的检验批？ | M3 QM-05 台账没有一般 IM 可复核摘录。作者在 §2 把旧正文主张改列待验证，并注明固定页本轮不可读、无逐句摘录。 | PASS：最终正文没有把二者关系写成已证实规则。 |
| 2 | 仓库 blocked stock 与 goods-receipt blocked stock 是否相同？ | 固定版收货页本轮不可访问。作者在 §2 将不同收货去向和相关性全部列为旧待核主张，不给通用库存分类。 | PASS：不再混同两种冻结库存或泛化为完整矩阵。 |
| 3 | 生产收货是否意味着生产中检验？ | M3 QM-05 仅登记 EWM 片段；固定版收货页未能复读。作者在 §3 将生产来源收货列为历史主张，且列出订单释放/工序检验等缺口。 | PASS：没有把收货来源写成生产中检验流程。 |
| 4 | 检查清单会不会被读成事件顺序或 SAP 操作指南？ | 没有固定版流程来源。作者在 §4 明确七项是资料核验问题，不是系统步骤；§1、§3 排除已验证流程/事件顺序。 | PASS：清单只用于核验资料。 |
| 5 | 依赖和 PROCESS-06 状态是否准确？ | M3 仍列为计划项；收尾分支没有文章正文。作者在 §5 说明批次 B 未开始，依赖文章状态及边界也逐项注明。 | PASS：不再称 PR #21 分支，也不把计划项当作已审阅依赖。 |

### 资深 SAP 配置顾问 reviewer-context（5 项）

| # | 质询 | 证据答复与作者修订 | 原角色复核 |
| --- | --- | --- | --- |
| 1 | 固定版主张是否足以覆盖一般 IM 核心学习目标？ | M3 triage/control/evidence 仍为“未核验／暂缓核心”；QM-05 台账只支持动态 SPS10 EWM 范围。作者在 §1–3 保留缺口，未用 EWM 替代一般 IM。 | PASS：没有把有限材料说成核心目标已完成。 |
| 2 | QM 管理库存、手工检验批和 QM 未激活时 MM-IM 的旧说法是否有可复核摘录？ | 当前 M3 来源记录没有对应的一般 IM 原文摘录。作者在 §2 将这些改列待验证，不作肯定事实。 | PASS：边界在文本中如实标为未复核。 |
| 3 | 库存过账时点、目标、类型 3 自动处理和反向推论是否准确？ | 固定版 Stock Postings 页面不可访问；较新/未锁版搜索内容不作目标版依据。作者在 §2 删除确定规则，并明确不保留“没有后台标记就必须手工确认”的反向推论。 | PASS：没有写出未证实的过账或自动化规则。 |
| 4 | 移动类型 103 能否支撑估价或 FI/CO 结论？ | 本轮台账无 103 摘录。作者从正文移除“不估价”肯定主张，并在 §3 将数量/价值/财务/冲销列为未闭合。 | PASS：未从例码外推估价或财务结果。 |
| 5 | EWM、PROCESS-06、QM-02/QM-04/MM-05 如何处理？ | EWM 为动态 SPS10 范围；PROCESS-06 是未启动批次 B 计划项；QM-02/QM-04 Draft，MM-05 Role Reviewed 但不等价 QM 直接证据。作者在 §3、§5 明确记录这些边界。 | PASS：依赖和范围准确；M3 门禁仍未关闭。 |

### 普通 SAP 开发人员 reviewer-context（5 项）

| # | 质询 | 证据答复与作者修订 | 原角色复核 |
| --- | --- | --- | --- |
| 1 | 是否由收货与检验批的叙述暗示特定物料凭证链接、键或基数？ | 固定页本轮不可读且没有对象关联摘录。作者在 §3、§4 将单据链接、字段、键和基数列作未证。 | PASS：不声称一对一关系或 JOIN。 |
| 2 | 是否存在表、字段、API、T-Code 或 FI 推断？ | M3 没有 QM-05 对应技术合同；作者在 §3 明确这些对象及 FI/CO 影响均未证。 | PASS：未发现技术模型、接口或会计断言。 |
| 3 | 版本和来源可追溯范围是否清楚？ | 三个固定版 direct open 均不可访问；旧记录为历史主张。作者在 §2、§6 分开记载链接、访问失败和未锁版排除结果，并更新 M3 来源补记。 | PASS：未把动态/当前搜索结果冒充 2021 证据。 |
| 4 | “适当授权”是否有可复核固定版来源？ | 旧正文的 UD 授权语句没有固定版可复核依据。作者在 §3 删除该肯定说法，列出角色、权限对象、只读入口皆待证。 | PASS：没有从页面或模拟推导客户权限。 |
| 5 | PROCESS-06 与 EWM 是否被准确限定？ | PROCESS-06 在批次 B 尚未开始，当前收尾分支无正文；动态 EWM 范围不等于一般 IM。作者在 §3、§5 明确区分并修正过时 PR #21 指代。 | PASS：没有把计划项或 EWM 作为一般 IM 产品事实。 |

## 结论与待补项

- 写作阶段旧记录含 15 项同上下文模拟；其历史问题/答复仍保留，但不计独立审查。
- 收尾阶段三个独立 AI reviewer-context 各复核 5 项，最终 15/15 PASS，限于正文证据边界与依赖状态准确性；不是真人 SAP 专家签核，也不是 SAP 实机验证。
- M3“暂缓核心”仍未关闭：一般 IM 质量库存、QM/MM库存管理边界、库存数量/价值及 FI/CO 影响、对象链、生产场景规则和撤销条件仍缺可复现目标版直接证据。QM-05 继续 Draft，不计批次 A Role Reviewed。
- 批次 A 当前计数：9/50 Role Reviewed、41/50 Draft、0/50 Owner Accepted；全库 Owner Accepted 3/99；批次 B 0/46 未开始。
- SAP 实机、库存过账、使用决策、配置、数据库、API、权限或会计凭证测试均未执行。

