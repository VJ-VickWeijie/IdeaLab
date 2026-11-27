# QM-04｜Work 写作与三角色视角闭环记录

- 日期：2026-11-27（Asia/Shanghai）
- 文章：QM-04《检验结果与使用决策》
- 正文：ideas/CareerOS/knowledge/QM/02-functions/results-usage-decision.md
- 目标版本：SAP S/4HANA 2021 On-Premise
- 执行上下文：同一 Work 上下文进行的三种角色视角模拟；没有真实子代理、真人 SAP 专家或独立复核者参与。以下记录是本轮实际形成的问题—答复—修改判断/修订—原视角复核闭环，不冒充独立审查。
- 结果：读者视角 5、配置顾问视角 5、开发者视角 5，共 15 个同上下文视角模拟闭环；独立角色审查闭环为 0。状态维持 drafting，不计入批次 A 的 8/50 reviewed。

## 证据边界

本轮只使用固定版 SAP Help 页面在来源核验记录中明确的内容：Manage Inspection Lots 的结果记录/UD 功能范围；Usage Decision for Inspection Lot 在 planned samples 语境下的定义、方式和前提；Stock Postings 的库存相关性、未过账数量时点、目的类别、物料凭证和特定类型 3 代码后台处理说明。固定版来源索引及版本选择器记录见 plans/qm-gr-inspection-2021-m3.md。其独立复读只覆盖收货建批条件页与库存过账时点页，不覆盖全部页面。

动态 FSD 摘录、较新版本 SAP 页面、ECC、EWM 推广、客户系统行为和一般顾问经验均未作为目标版证据。SAP 系统未连接；没有实机测试或真实权限/过账验证。

## 普通读者视角｜5 个闭环

### 1. “结果”“决策”“过账”是不是一个动作？

- article_id：QM-04；role：普通读者；round：1
- question：读者可能会把“结果合格”直接理解为库存已经放行，文章需要先解释三个词。
- evidence：Manage Inspection Lots 2021.000 把记录结果与作使用决策列为不同工作清单动作；Usage Decision 页面定义 UD；Stock Postings 页面另述库存处理时点。
- work_response：这三者需要分开讲，不能用“检验通过”作为库存已经移动的同义词。
- change_ref：文章第 1 节先定义结果记录、样本/特性处理、UD、库存过账四个动作，并解释 UD 不等于全部库存过账完成。
- recheck：原读者视角复核后，表格能逐项回答“我现在说的是哪一步”，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 2. 使用决策到底说明什么？

- article_id：QM-04；role：普通读者；round：2
- question：接受/拒绝是否就是“放到可用库存/扔掉”？
- evidence：固定版 UD 页面仅说明决定检验批货物接受或拒绝使用；Stock Postings 页另列多种目标库存类别。
- work_response：接受/拒绝表示页面定义的使用决定；不能直接替换成特定库存目标或报废结论。
- change_ref：第 2 节改写 UD 含义；第 5 节明确列出“接受即转非限制使用”“拒绝即报废/退货”均不能通用推断。
- recheck：原读者视角确认文章不再把决定结果写成固定库存动作，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 3. 为什么自动处理会出现两种说法？

- article_id：QM-04；role：普通读者；round：3
- question：文章说 UD 可以由作业自动处理，又说库存过账有另一个自动条件，读者会不会混淆？
- evidence：固定版 UD 页面列周期作业处理方式；Stock Postings 页面只针对检验目录类型 3 的 UD 代码及其选定集/后台处理指标说明自动过账。
- work_response：两个自动化对象不同，必须并列标明各自来源边界。
- change_ref：第 2、3 节分别描述自动 UD 与代码级自动库存过账；第 4 节再明确二者不是同一机制。
- recheck：原读者视角复述为“作业可做 UD；特定代码设置可能自动过账”，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 4. 有未处理数量时下一步是什么？

- article_id：QM-04；role：普通读者；round：4
- question：案例里有部分数量未处理，能否断言必须先 UD 后转库存？
- evidence：固定版 Stock Postings 页面说有可过账数量时可在 UD 前、期间或之后处理。
- work_response：不能断言顺序固定；案例应引导读者查开放数量、库存相关性与目标。
- change_ref：第 3 节写入三个可发生时点；第 4 节表格把目标库存和具体数量列为需核实内容。
- recheck：原读者视角按文中信息正确得出“不能固定成 UD 后”，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 5. 这是一份照着操作的手册吗？

- article_id：QM-04；role：普通读者；round：5
- question：离线案例是否会让初学者误以为需要照着客户系统操作？
- evidence：用户要求无 SAP 系统时不声称实测；固定版来源只覆盖产品说明，不是客户系统操作结果。
- work_response：练习应是文献阅读和问题清单，不提供未证实的操作步骤。
- change_ref：第 4 节题为离线案例，明确不是操作步骤；系统验证声明和未确认项目保留在文首及第 5 节。
- recheck：原读者视角确认案例要求查证而非执行操作，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

## 资深 SAP 配置顾问视角｜5 个闭环

### 1. UD 前提是否被写成了所有场景的普遍规则？

- article_id：QM-04；role：资深 SAP 配置顾问；round：1
- question：结果、关闭特性、样本评价等前提的范围是否严格对应 SAP 页面语境？
- evidence：固定版 Usage Decision 页面在 planned samples 语境下列出授权、批次释放、必需结果、特性关闭/样本评价和无阻断状态。
- work_response：这些条件可作为该页面语境内的前提清单，不能概括所有检验类型或特殊流程。
- change_ref：第 2 节首句显式限定 planned samples；状态原因和第 5 节保留未覆盖的特殊情形。
- recheck：原顾问视角逐项对照来源摘要后，范围限定充分，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 2. 自动 UD 的资格和设置是否有直接证据？

- article_id：QM-04；role：资深 SAP 配置顾问；round：2
- question：周期作业的说法有没有被误写成自动 UD 的完整配置/资格规则？
- evidence：固定版页面仅列举周期性预定作业这一方式；本轮来源核验记录明确未读自动 UD 完整具体规则。
- work_response：只能记录方式，不能补写作业参数、资格优先级、失败重试或检验来源差异。
- change_ref：第 2 节将自动 UD 限定为方式说明，并将资格规则及作业配置列入第 5 节。
- recheck：原顾问视角未发现未证实设置被写成肯定规则，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 3. 库存过账时点和库存相关性是否准确？

- article_id：QM-04；role：资深 SAP 配置顾问；round：3
- question：过账前/中/后的说法是否依赖有未过账数量，并区分非库存相关批次？
- evidence：固定版 Stock Postings 页面指出仅库存相关检验批适用，存在可过账数量时可在 UD 前、期间或之后处理。
- work_response：两个限定都要写清，且不能把不同库存目标当成通用结果。
- change_ref：第 3 节分别记录库存相关性、开放数量和三个时点；列出目标类别并提示保留前提。
- recheck：原顾问视角复核限定条件齐全，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 4. 自动过账的配置范围是否越界？

- article_id：QM-04；role：资深 SAP 配置顾问；round：4
- question：类型 3、选定集和后台处理指标是否被误说成任何 UD 代码都适用？
- evidence：固定版 Stock Postings 页面把后台处理指标与检验目录类型 3 的 UD 代码/选定集联系起来。
- work_response：必须写出限定对象和来源范围，并说明未设指标时人工确认建议。
- change_ref：第 3 节将该规则单独列为代码情境；正文两处明确不得泛化到全部检验批。
- recheck：原顾问视角确认未将客户具体配置或行为作为既定事实，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 5. 退货、报废、估价、会计和撤销是否可一并补写？

- article_id：QM-04；role：资深 SAP 配置顾问；round：5
- question：需要把目标类别扩充成移动类型、估价和 FI 分录，还需要说明决策撤销。
- evidence：Stock Postings 页面只足以支持若干目标类别和产生物料凭证；M3 控制/来源台账仍标记 UD 撤销及财务影响待查。
- work_response：不将目标类别解释成移动类型/会计分录；撤销和价值结论不在现稿范围，保持 drafting。
- change_ref：第 3 节限定物料凭证；第 5 节列出移动类型、估价、FI/CO 和撤销缺口。
- recheck：原顾问视角确认核心准入缺口仍清楚且没有被掩盖，通过其修订完整性复核；内容状态仍未通过门禁。
- status：closed as a scope review, article gate remains blocked; executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

## 普通 SAP 开发人员视角｜5 个闭环

### 1. 是否误写了事务码或界面操作？

- article_id：QM-04；role：普通 SAP 开发人员；round：1
- question：结果录入和 UD 是否需要列经典 T-Code 或特定 Fiori 按钮？
- evidence：固定版 Manage Inspection Lots 页面只支持工作清单动作；本轮没有逐事务目标版与权限证据。
- work_response：文章可以解释产品动作，但不能从动作名推断事务码、界面步骤或显示/修改权限。
- change_ref：全文不列事务码、未提供屏幕操作说明；第 5 节明确相关入口和权限待核。
- recheck：原开发者视角搜索文章后未发现推定入口，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 2. “所有必需结果已记录”是否被误解为结果 API/字段契约？

- article_id：QM-04；role：普通 SAP 开发人员；round：2
- question：结果完成条件会不会被读成已掌握数据字段、对象键或 API 写入顺序？
- evidence：UD 固定版页面仅列必需特性结果为 UD 前提；QM-03 草稿也没有闭合结果字段或 API 合同。
- work_response：只讲业务前提；不补字段、实体、数据库表或 API 调用顺序。
- change_ref：第 1、2、5 节分别把功能范围、前置条件和缺失合同拆开；未引入技术对象映射。
- recheck：原开发者视角确认没有将流程前提包装成接口合同，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 3. 物料凭证是否能推出会计凭证或金额？

- article_id：QM-04；role：普通 SAP 开发人员；round：3
- question：库存过账生成 material document，是否意味必然同步生成 accounting document？
- evidence：固定版 Stock Postings 摘要只确认 material document；财务凭证与估价影响在来源研究记录中仍待核。
- work_response：不得推出 FI 凭证、价值变化、科目或金额。
- change_ref：第 3 节说明物料凭证事实后补“不证明每种过账均产生 FI 凭证、发生价值变化或使用相同科目”；第 5 节列入未证清单。
- recheck：原开发者视角确认物流凭证和会计对象未混同，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 4. 授权前提是否等于某个 SAP 角色？

- article_id：QM-04；role：普通 SAP 开发人员；round：4
- question：UD 页面中的 appropriate authorization 能否映射成 Quality Technician/Engineer、授权对象或只读角色？
- evidence：固定版 UD 页面只给适当授权前提，未给本文所需的角色/对象映射；相关用户角色在 M3 控制矩阵仍待补。
- work_response：只记授权是前提，不写角色名、对象和显示/修改权限。
- change_ref：第 2 节及第 5 节对授权作明确限缩；文首系统验证声明避免暗示实际角色已核。
- recheck：原开发者视角确认没有权限映射推断，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

### 5. 依赖和实测状态是否准确？

- article_id：QM-04；role：普通 SAP 开发人员；round：5
- question：文章是否引用尚不存在的 PROCESS-06，或声称跑过系统/接口测试？
- evidence：最新 PR #21 中 PROCESS-06 文件不存在；本轮没有 SAP 连接或系统测试。
- work_response：记录流程依赖不存在，不以计划表充当正文；将来源核验与实机验证分开。
- change_ref：第 6 节写明 PROCESS-06 当前不在分支；文首与第 4 节说明无系统连接、练习不是实测。
- recheck：原开发者视角确认路径和验证声明可审计，通过。
- status：closed；executor_context：同一 Work 上下文角色视角模拟；timestamp：2026-11-27。

## 结论与未闭合项

- 视角模拟闭环：普通读者 5/5；资深 SAP 配置顾问 5/5；普通 SAP 开发人员 5/5。
- 正式独立角色复核：0；没有把同上下文模拟计作 reviewer 独立验证。
- 文章状态：drafting。仍缺一般结果记录与缺陷处理的固定版直接细节、自动 UD 完整条件、决策撤销、库存价值与财务影响、具体权限/只读边界及一般 IM/EWM 场景证据。
- 版本核对：使用 QM-02/PROCESS-06 来源研究记录中的固定版 2021.000 页面；没有使用未锁定当前 SAP Help 页、较新版本、EWM 或客户系统观察来替代。
- SAP 实机验证：0；没有连接系统或执行结果录入、UD、库存过账、撤销、权限或 API 测试。

