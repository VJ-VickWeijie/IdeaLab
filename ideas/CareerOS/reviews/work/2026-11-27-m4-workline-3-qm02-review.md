# QM-02｜三角色质询、答辩与复核记录

- 日期：2026-11-27（Asia/Shanghai；逐轮具体时分不可见，不编造）
- 工作线：CareerOS M4 批次 A 工作线 3
- 文章：[QM-02《检验类型与检验批》](../../knowledge/QM/02-functions/inspection-type-lot.md)
- 目标版本：SAP S/4HANA 2021 On-Premise
- M3 准入：限缩可写；需处理检验来源/类型、建批条件、供应商/质量信息记录差异、EWM 和财务凭证边界。
- 角色与真实性：下列普通读者、资深 SAP 配置顾问、普通 SAP 开发人员三组均是同一 Work 上下文中的角色视角模拟；没有调用独立子代理、第二模型或真人专家。每项记录不同的实质质询、依据、Work 回答、修订判断及同一视角复核；不把模拟说成独立审查。
- 来源依据：文章 E1–E4 是目标版本 SAP Help 页面。版本与读取情况沿用项目已保存的 [QM-02 固定版来源研究记录](../../../plans/qm-gr-inspection-2021-m3.md)：该记录称所核五页选择器显示 2021 (Oct 2021)，其中自动收货建批与库存过账时点页有独立复读。本次角色模拟没有重新打开 SAP Help 版本选择器；不能把网页搜索当前版本当作 2021 版本证据。
- 系统验证：SAP 系统未连接；未查看客户系统、授权、物料/供应商设置或真实库存/财务凭证；未做实机测试。
- 结论：三角色模拟各 5 个闭环，共 15 个。固定版资料支持收货场景下的有限建批条件与库存关联切片；跳检/不建批完整规则、通用供应商/QIR规则、EWM 及财务证据未闭合，因此文章保持 drafting，不计 batch A reviewed。

## 普通读者视角（5 个闭环）

### QM-02 / reader / round 1
- 问题：inspection lot origin、inspection type 和 inspection lot 是不是同一个“检验代码”？
- 依据与答复：E1 区分检验类型及来源，并列出标准来源/类型示例；因此三者分列，不能因为标准例子编号相同而合并。
- 修订判断：采纳；正文第 1 节增加三词对照表和“编号相同不等于字段相同”的说明。
- 原视角复核：三种名称分别回答来源、处理方式和检验对象问题，没有再把它们说成同一代码。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / reader / round 2
- 问题：每次供应商送货或采购订单收货都会自动出现检验批吗？
- 依据与答复：E2 列出自动建批所需的 QM movement-type setting、物料检验设置和供应商状态条件；页面并未说所有收货都必定建批。
- 修订判断：采纳；正文第 2 节改为明确条件清单，并在首段否定“一律建批”。
- 原视角复核：读者能看出需要同时核对设置、主数据和业务事件，而不是把收货等同于建批。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / reader / round 3
- 问题：看到检验批，货物是不是一定在质检库存里？
- 依据与答复：E2 按仓库、消耗和收货冻结库存描述 stock-relevant 与非库存相关批次；仓库库存例子也包括非限制使用或冻结库存，不只有检验库存。
- 修订判断：采纳；正文第 3 节加入目的地与库存相关性表，并解释不能只凭“检验”二字断定库存类型。
- 原视角复核：表格能区分是否与库存相关，不再把检验批和 quality inspection stock 画等号。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / reader / round 4
- 问题：如果供应商被阻止，是否代表本次收货永远不能有检验批？
- 依据与答复：E2 对被阻止的外部供应商列出一个有限例外：可在质量信息记录中针对本次收货释放。此处不能推成全面解除供应商阻止。
- 修订判断：采纳；正文第 2 节明确是“针对这一次收货”，第 6 节声明这不是完整 QIR 规则。
- 原视角复核：读者能区分单次收货的页面例子与一般供应商状态管理。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / reader / round 5
- 问题：记录了检验结果，系统会不会就自动把货物放行？
- 依据与答复：E2 只说明结果规格与结果记录场景；E4 区分库存过账与 UD，自动过账还要求页面列出的特定代码设置，不能由“记录结果”推出自动过账。
- 修订判断：采纳；正文第 4 节分开描述结果规格、UD、库存过账，补入自动设置的场景边界。
- 原视角复核：文章没有承诺结果记录必然自动作 UD 或释放库存。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

## 资深 SAP 配置顾问视角（5 个闭环）

### QM-02 / consultant / round 1
- 问题：标准来源 01/type 01 例子能否直接写成所有采购收货都用 01？
- 依据与答复：E1 将 01/01 列为标准采购订单收货检验示例，同时说明可为一个来源分配多个类型并可定义额外类型。
- 修订判断：采纳；正文第 1 节标明是标准示例，不写成客户或全系统固定映射。
- 原视角复核：例子范围限定清楚，不会被读成所有客户的强制编号。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / consultant / round 2
- 问题：能否给出检验批创建的准确 IMG 路径及完整的移动类型配置表？
- 依据与答复：E2 直接支持 Customizing 中需为相关移动类型激活 QM；现有固定版片段没有完整客户路径、代码表或授权。
- 修订判断：采纳；正文只保留来源描述的配置前提，不杜撰 IMG 节点和移动类型清单。
- 原视角复核：配置要求和实际导航/完整映射已分开，未把页面概述装作完整配置指南。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / consultant / round 3
- 问题：外部供应商必须 release 的条件是否可省略，或能否推广到所有供应商？
- 依据与答复：E2 把该条件限定在其外部供应商收货场景；还只给出被阻止时针对本次收货的 QIR 例子。
- 修订判断：采纳；正文第 2 节逐项保留该条件，正文第 6 节排除供应商状态的完整规则。
- 原视角复核：没有把特定采购收货前提推广为全套 BP/QIR 维护规则。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / consultant / round 4
- 问题：供应商现场已经做过 source inspection 时，收货建批是否一律跳过？
- 依据与答复：E2 明确可在该物料/供应商组合的 QIR 中指定 additional inspection，以便收货时仍建批；它没有给出源检验的全套优先级或免检规则。
- 修订判断：采纳；正文第 2 节新增该特定条件；第 6 节把其他供应商/QIR规则列为待核。
- 原视角复核：已写出固定版直接支持的特例，同时没有反向推断“必建”或“必免检”。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / consultant / round 5
- 问题：移动类型 103 与收货冻结库存的“不估价”能否推广到所有收货冻结库存？
- 依据与答复：E3 仅以 103 举例说明尚未进入企业仓库库存的暂存区在该场景不估价，并要求与估价冻结库存区分。
- 修订判断：采纳；正文第 3 节只保留这一例子，并明示不是所有收货冻结库存的通则。
- 原视角复核：类型代码和值影响均有目标版页面例子边界，不存在普遍化表述。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

## 普通 SAP 开发人员视角（5 个闭环）

### QM-02 / developer / round 1
- 问题：能否把检验来源、检验类型写成某些 SAP 表的键字段或给出关联关系？
- 依据与答复：E1 支持业务概念和标准示例，不支持底层表、主键、外键或关联基数。
- 修订判断：采纳；正文不列数据库表或字段，不从概念页推导数据模型。
- 原视角复核：已将产品行为与数据模型证据边界分开。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / developer / round 2
- 问题：手工建批和自动建批时，系统选择类型的逻辑是否相同？
- 依据与答复：E1 明确自动创建时自动确定类型；手工创建先选来源，多个激活类型时提示用户选择。
- 修订判断：采纳；正文第 1 节分成自动与手工两条说明，不写不受支持的优先级算法。
- 原视角复核：两种路径已区分，未发明系统排序或默认类型规则。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / developer / round 3
- 问题：系统找不到唯一检验规格时，会自动随便选一个吗？
- 依据与答复：E2 说无规格或有多个规格时需人工分配，不支持自动任取一个的说法。
- 修订判断：采纳；正文第 4 节明确无规格/多规格都需要手工指定。
- 原视角复核：不会从“系统分配规格”误解为始终自动成功。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / developer / round 4
- 问题：手工创建检验批是否可以直接用 QM 的库存过账来处理？
- 依据与答复：E3 说明由货物移动自动创建的检验批在特定 MM/IM 启用条件下可由 QM 跟踪库存；同页说 QM 不管理手工创建批次的库存移动。QM 未激活时 MM-IM 仍可有检验库存过账。
- 修订判断：采纳；正文第 3 节加入自动建批/手工建批差异与 QM 未激活时的 MM-IM 边界。
- 原视角复核：不再将所有 QI 库存都归因于 QM 检验批。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-02 / developer / round 5
- 问题：页面列出的 Extended Warehouse inspection 是否表示普通 IM 与 EWM 可共用本篇触发和库存规则？
- 依据与答复：E1 标明 extended warehouse inspection 是另一个来源类型例子；它没有证明普通 IM 与 EWM 的共同行为或库存处理。
- 修订判断：采纳；正文第 6 节将 EWM 单独列为未覆盖，不外推至普通 IM；正文不写 EWM 操作结论。
- 原视角复核：文章未把一个类型名称当作完整 EWM 规则或普通 IM 证据。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

## 结果与状态

- 闭环数：普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5，共 15 个同上下文模拟闭环。
- 每项包含具体质询、目标版来源答复、修订判断和同一角色视角复核；模拟不能代表独立代理、第二模型或真人 SAP 专家。
- 文章状态仍为 drafting；未达到“完整检验建批/跳检规则、EWM 与财务边界”所需的证据覆盖，不计批次 A reviewed/owner accepted。
- 未闭合项：跳检/不建批的完整条件、客户级配置与权限、一般 EWM/普通 IM差异、通用库存估价和财务凭证影响。
- SAP 系统未连接；无实机测试。
