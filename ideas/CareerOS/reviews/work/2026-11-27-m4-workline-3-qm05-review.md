# QM-05｜Work 写作与三角色视角闭环记录

- 日期：2026-11-27（Asia/Shanghai）
- 文章：QM-05《质量库存与采购生产集成》
- 正文：ideas/CareerOS/knowledge/QM/02-functions/quality-stock-integration.md
- 目标版本：SAP S/4HANA 2021 On-Premise
- 执行上下文：同一 Work 上下文进行三种角色视角模拟。没有真实子代理、真人 SAP 专家或独立复核者参与；不声称独立审查。
- 结果：普通读者视角 5、资深 SAP 配置顾问视角 5、普通 SAP 开发人员视角 5，共 15 个同上下文角色视角模拟闭环；正式独立审查闭环为 0。M3 对 QM-05 标记“暂缓核心”，文章保持 drafting，不计入批次 A 8/50 reviewed。

## 本轮来源界限

1. SAP S/4HANA On-Premise 2021.000《Inspection for a Goods Receipt》支持外部/生产收货来源、不同收货去向、检验批库存相关性及页面所述检验规格分配。
2. SAP S/4HANA On-Premise 2021.000《Stock Management in QM》支持自动创建检验批的 QM 库存跟踪边界、手工检验批不由 QM 管理库存移动，以及 QM 未激活时 MM-IM 仍可能处理检验库存。
3. SAP S/4HANA On-Premise 2021.000《Stock Postings》支持库存相关性、未过账数量时点、目标类别、物料凭证及特定类型 3 UD 代码的后台处理条件。
4. 来源研究中移动类型 103 只是特定 GR-blocked 暂存区示例；没有用来构造通用库存或财务矩阵。
5. FSD 的 QM/EWM 文段标为动态 latest 的 SPS10 快照；未作为固定版普通 IM 证据。SAP 系统未连接。

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

## 结论与待补项

- 同上下文视角模拟闭环：普通读者 5/5、配置顾问 5/5、开发者 5/5。
- 正式独立角色复核：0；没有将角色模拟称作独立专家评审。
- 文章状态：drafting。M3“暂缓核心”仍未关闭：需要固定版直接证据支持一般 IM 质量库存的完整流程与状态关联、采购/生产单据对象链和库存数量/价值影响，特别是 FI/CO 财务影响。生产中检验的触发和处理另需直接证据；当前仅能确认固定版 GR 页面包括来自生产的收货来源。
- EWM 内容未推广到普通 IM；移动类型 103 未推广到一般冻结库存或估价规则。
- SAP 实机验证：0；没有执行库存过账、UD、会计凭证、权限或 API 测试。

