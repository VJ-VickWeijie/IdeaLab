# PP-02｜物料清单 BOM：准入与三角色视角工作记录

- 日期：2026-11-27（Asia/Shanghai）
- 工作包：CareerOS M4 批次 A，工作线 2
- 文章路径：ideas/CareerOS/knowledge/PP/01-foundations/bom.md
- 当前状态：drafting
- 角色视角闭环：普通读者 5/5、资深 SAP 配置顾问 5/5、普通 SAP 开发人员 5/5；共 15 个完成“问题—证据答复—修改判断/正文修订—原视角复核”的闭环。
- 执行上下文：同一 Work 上下文内的角色视角模拟；不是独立代理审查，也不代表真人 SAP 专家。此环境未显示模型身份。
- SAP 系统：未连接；实机验证为 0。所有练习为离线纸笔练习。

## 1. M3 准入与本次写作范围

M3 逐篇分流将 PP-02 标为“限缩可写”，批准路径为 knowledge/PP/01-foundations/bom.md。范围包括 BOM 结构、替代、用量、有效日期和版本，并把组件缺失列为问题情形；原记录要求以虚构产品与组件练习数量，并将选择规则写成有条件的说明。

本次仅读取本篇对应记录及关联文章：逐篇准入分流、逐篇范围与依赖、物流证据登记、SD/PP 来源贴合度记录，以及 PP-01 和 MM-02 正文。当前 M3 控制矩阵文件未包含 PP-02 行；因此本篇具体范围以逐篇分流、逐篇范围记录和 PP-02 来源登记为准，不从矩阵中补造命题。PP-01 仍为 drafting，本篇没有借用它尚未闭合的组织/制造模式结论；MM-02 仅用于区分材料主数据与 BOM 组成结构。PP-03 正文未纳入本次研究。

M3 来源登记列出 FSD_OP2021_latest.pdf §2.8.2.1。该 URL 含动态 latest，文件快照可能变化，因此本次未用它证明固定版 2021 的数量、替代选择或一般有效期。固定版资料能支持有限的多层结构描述、BOM versioning 配置条目，以及重复制造确认的窄场景日期例子；不足以关闭 PP-02 全部核心目标。正文限定范围，状态保持 drafting。

## 2. 来源和主张边界

| Ref | 来源 | 本次可用的直接支持 | 不支持 / 不作结论 |
| --- | --- | --- | --- |
| P1 | SAP Help, “New App: Manage Multilevel Bill of Material”, S/4HANA 2021 (Oct 2021), version 2021.000。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/40fea7f7ca7d446c800d992088133f69.html?locale=en-US&version=2021.000 | 该应用展示多层树，先显示 BOM header，再展示嵌套的 components、assemblies 和 material；页面说明应用支持 display and maintain，权限对应 BOM Engineer business role template。 | 所有 BOM 类型/制造场景、物料数量规则、替代选择、通用有效期/爆炸逻辑、只读用户权限、客户系统角色分配。 |
| P2 | SAP Help, “Configuration to Define Versioning of Bill of Material”, S/4HANA 2021 (Oct 2021), version 2021.000。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/354d3184ad4449f6b515029199e69de9.html?version=2021.000 | 页面确认可通过 Customizing “Define Additional Control Data” 启用 BOM versioning。 | 完整 IMG 路径、默认值、全部版本规则、目标客户实际设置。 |
| P3 | SAP Help, “Configuration to Maintain Manual or Automatic Versioning for BOM Usage”, S/4HANA 2021 (Oct 2021), version 2021.000。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/d9fae6cc2c684445b25cee45bf30502a.html?locale=en-US&version=2021.000 | 该页面说明可针对特定 BOM usage 指定 version-controlled BOM 创建过程采用手动或自动 versioning。 | 全部 BOM usage 覆盖、自动编号算法、与替代项/生产版本/有效期的完整交互。 |
| P4 | SAP Help, “Confirm Repetitive Manufacturing”, S/4HANA 2021 (Oct 2021), version 2021.000。https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/87921c2813d94507b725eec99b4e979c.html?locale=en-US&version=2021.000 | 页面说明在 make-to-stock repetitive manufacturing 的确认场景中，BOM explosion date 可用于判断创建确认时有效的 BOM version。 | 全部生产订单/制造模式的通用 BOM 选版规则，或该目标客户的实际结果。 |
| M3 记录 | detail-logistics-v0.3.md；m3-item-readiness-triage-v0.3.md；evidence-logistics-m3.md；sd-pp-source-fit-m3.md | 确认文章批准路径、目标范围和既有缺口。 | 规划/贴合度记录本身不是 PP-02 产品事实的替代证据。 |
| 排除来源 | FSD_OP2021_latest.pdf（动态 URL，M3 台账 §2.8.2.1） | 仅用于追踪 M3 原始来源及解释为何当前证据范围受限。 | 不作为固定版 S/4HANA 2021 产品主张依据。 |

## 3. 角色闭环记录

每条包含角色问题、证据、Work 答复、修订和同角色视角复核。每轮时间粒度只记录到本地日期；环境未保留每条闭环的分钟级时间。所有轮次均属同上下文角色视角模拟，不计作独立审查。

### 普通读者

#### PP02-01｜第 1 轮
- article_id：PP-02；role：普通读者；round：1
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：只看到一棵树，读者可能仍不知道 BOM 用来回答什么实际问题；是否能用一句日常语言说明？
- evidence：固定版 2021 Manage Multilevel BOM 页面说明多层 BOM 由 header 和嵌套组件、装配件、物料组成；它没有给出更广泛的计划或成本结论。
- work_response：把入门问题改成“一个产品或装配件的组成结构是什么”，并限定本篇只回答组成结构。
- change_ref：正文“BOM 先回答什么问题”新增问题句和范围句。
- recheck：原角色视角复核，复核后可从一句话理解学习目标，同时没有把 BOM 扩写为 MRP、成本或会计规则。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-02｜第 2 轮
- article_id：PP-02；role：普通读者；round：2
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：component 和 assembly 对初学者是否太像术语？装配件也会是上一层的组件吗？
- evidence：2021 页面明确显示嵌套的 components、assemblies 和 material，但没有定义全部 item category。
- work_response：以父级/装配件/组件的树上位置解释，并注明这是入门读法，不覆盖所有 item category。
- change_ref：正文“读懂一张多层结构”增加三条术语解释和范围提示。
- recheck：原角色视角复核，复核后读者能按树的位置理解词语，也能看出这不是分类规则全表。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-03｜第 3 轮
- article_id：PP-02；role：普通读者；round：3
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：没有数量与单位，BOM 文章是不是少了关键内容？
- evidence：M3 逐篇范围要求用量；当前固定版 2021 页面没有支持通用数量公式，动态 FSD 不作为固定证据。
- work_response：承认这是目标核心缺口，删除数量示范，列出待补证的数量/单位/换算。
- change_ref：正文范围提醒及“本篇暂不解释的规则”增加数量与单位缺口。
- recheck：原角色视角复核，复核后文章没有伪装完整，也未把缺证内容包装成默认规则。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-04｜第 4 轮
- article_id：PP-02；role：普通读者；round：4
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：如果某个组件没有列出来，能不能理解为需要数量是 0，或系统会自动补齐？
- evidence：当前固定版来源未说明缺失组件的爆炸、报错或默认处理。
- work_response：不推测忽略、报错或自动补齐，并将问题留在表格中待核。
- change_ref：正文“本篇暂不解释的规则”新增组件缺失行为边界。
- recheck：原角色视角复核，复核后不会从树结构自行推导缺项后的系统行为。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-05｜第 5 轮
- article_id：PP-02；role：普通读者；round：5
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：没有真实 SAP 系统，读者能做什么练习？
- evidence：系统未连接；固定页只直接支持结构树的可视化描述。
- work_response：设计只画虚构结构的离线练习，数量、日期、选版问题只记录不作答。
- change_ref：正文“离线练习”提供四步纸笔练习并强调非系统操作。
- recheck：原角色视角复核，复核后练习可在离线完成，且不会让读者误以为已测试 SAP。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

### 资深 SAP 配置顾问

#### PP02-06｜第 1 轮
- article_id：PP-02；role：资深 SAP 配置顾问；round：1
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：Manage Multilevel BOM 页面放在 2021 文档中，但它的业务定位是否可被泛化为所有制造场景？
- evidence：固定版条目标为 LO-MD-BOM，并处在 R+D/Engineering 与 Integrated Product Development for Discrete Industries 语境；它是新应用介绍。
- work_response：把页面描述限定为该版本该应用直接展示的层级能力，不把它推广为全部离散/流程生产配置规则。
- change_ref：正文开篇和来源条目加入应用上下文、范围提醒。
- recheck：原角色视角复核，复核后不会从一个 2021 应用新功能推导所有 PP 制造场景。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-07｜第 2 轮
- article_id：PP-02；role：资深 SAP 配置顾问；round：2
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：“启用 BOM versioning”是否足以给用户一条通用 IMG 配置路径或表示版本控制默认开启？
- evidence：2021.000 页面仅列 Customizing “Define Additional Control Data”，没有完整 IMG 路径、默认值或客户设置。
- work_response：保留页面给出的 Customizing 名称；不提供路径、默认值和实际激活判断。
- change_ref：正文“2021 版资料能确认的有限版本信息”与来源表限定字段。
- recheck：原角色视角复核，复核后准确区分能力存在、设置名称、路径与客户实际状态。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-08｜第 3 轮
- article_id：PP-02；role：资深 SAP 配置顾问；round：3
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：manual/automatic versioning 能否写成所有 BOM 都可任选的固定行为？
- evidence：2021.000 页面只说明对特定 BOM usage 的 version-controlled BOM 创建过程，可设置 manual 或 automatic versioning。
- work_response：将表述限缩为该页面对 BOM usage 的配置说明，不补写自动编号、版本生成或适用范围矩阵。
- change_ref：正文版本信息第 2 点与来源第 3 项采用条件化描述。
- recheck：原角色视角复核，复核后没有把有限的设置说明扩写成所有 BOM 的一般规则。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-09｜第 4 轮
- article_id：PP-02；role：资深 SAP 配置顾问；round：4
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：BOM explosion date 与有效 version 的关系，能否概括成所有生产单据的选版准则？
- evidence：固定版 2021 页面明确这是 Confirm Repetitive Manufacturing，限 make-to-stock repetitive manufacturing 的确认场景。
- work_response：单列成窄场景例子，保留按库存重复制造和创建确认两个前提，不做普遍推论。
- change_ref：正文版本信息第 3 点新增场景限定与反例提醒。
- recheck：原角色视角复核，复核后不会将重复制造确认行为推广到其它订单/制造类型。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-10｜第 5 轮
- article_id：PP-02；role：资深 SAP 配置顾问；round：5
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：替代 BOM、lot size、有效日期和生产版本之间的选版关系是 M3 的核心；为何不在正文给常见规则？
- evidence：M3 分流将替代项选择列为待核；本轮固定版 2021 资料只覆盖版本控制配置和一个重复制造日期示例。
- work_response：不拿动态 latest 或旧版规则填空；明确列出待核的策略关系与核心缺口，状态保留 drafting。
- change_ref：正文“本篇暂不解释的规则”增加替代项、lot size、生产版本和有效日期的证据项。
- recheck：原角色视角复核，复核后 M3 核心目标可追溯，文章没有被误标为 reviewed。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

### 普通 SAP 开发人员

#### PP02-11｜第 1 轮
- article_id：PP-02；role：普通 SAP 开发人员；round：1
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：从树形业务概念是否可以顺手列 STKO/STPO 或 BOM 物理表、主键和父子关联？
- evidence：本轮固定版资料是应用功能/What's New，不是 released data model、表字段文档或 API 合同。
- work_response：不列表、字段、键、关联基数或 SELECT 示例；把数据模型留作独立核验项。
- change_ref：正文开篇范围与未覆盖问题表新增“字段和存储表”边界。
- recheck：原角色视角复核，复核后没有任何未经证实的物理表/API 断言。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-12｜第 2 轮
- article_id：PP-02；role：普通 SAP 开发人员；round：2
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：M3 台账里的 FSD 文件标题写 2021，能否把里面的组件数量或 BOM 规则作为 2021 固定证据？
- evidence：FSD_OP2021_latest.pdf 的 URL 含 latest，文件快照可变；当前检索所见文档版本为 2025 文档版，不能证明当年的固定文本。
- work_response：将它保留为 M3 定位线索，不用作文章中的固定版产品主张；只引用带 2021.000 的 SAP Help 页面。
- change_ref：来源范围和文末声明说明 dynamic latest 未作为证据。
- recheck：原角色视角复核，复核后每条产品主张可追到固定 2021 页面，动态文件没有被冒充。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-13｜第 3 轮
- article_id：PP-02；role：普通 SAP 开发人员；round：3
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：2021 新应用页提到 BOM Engineer business role template，能否说该角色给只读权限或目标客户用户已具备授权？
- evidence：固定页面说应用可 display and maintain，并要求与 BOM Engineer template 相同的 authorizations；它没有说明客户用户的实际分配。
- work_response：指出该应用不是只读工具；不推定目标系统角色分配或用户权限，只记录文档所述应用授权边界。
- change_ref：正文开篇与来源第 1 项明确 display-and-maintain / actual access unknown。
- recheck：原角色视角复核，复核后没有把 business role template 写成只读角色或实际系统授权证明。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-14｜第 4 轮
- article_id：PP-02；role：普通 SAP 开发人员；round：4
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：2021 的重复制造页面提到 MFBF、BAPI 和 OData；是否应把它们直接列为一般 BOM 查看/读取接口？
- evidence：页面把这些入口限定为重复制造确认功能新增 explosion-date 字段的场景，不等同一般 BOM 读取 API 或访问授权。
- work_response：不把接口扩展成通用 BOM 导航；文章只说明窄场景产品事实，并将接口用途留在对应技术文章核验。
- change_ref：正文没有加入一般 T-Code/API 清单，来源第 4 项明示使用边界。
- recheck：原角色视角复核，复核后没有出现“可用接口”或通用权限结论。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

#### PP02-15｜第 5 轮
- article_id：PP-02；role：普通 SAP 开发人员；round：5
- timestamp：2026-11-27（Asia/Shanghai；具体分次时刻未记录）
- question：当前没有 SAP 连接，离线练习会不会被误读成已验证数据或测试结果？
- evidence：工具上下文没有连接目标 SAP；本练习是画虚构树，不运行 SAP。
- work_response：在练习末尾和文末声明只记录纸笔结构练习、没有实机验证。
- change_ref：正文“离线练习”与最后一段加入系统边界。
- recheck：原角色视角复核，复核后文内没有声称测试、配置查看或客户系统访问。
- status：closed-in-perspective
- executor_context：同一 Work 上下文角色视角模拟；没有真人专家或独立 Agent；模型身份未显示。

## 4. 最终判断与阻碍

- 15 个角色视角循环各完成证据答复、修订判断和原视角复核；普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5。
- 这些循环不构成独立审查，不能据此将文章标为 reviewed。
- 固定版 2021 资料不足以闭合 M3 核心：BOM 组件用量/单位及计算、替代 BOM 与 lot size/有效日期/生产版本的选择关系、普遍有效日期规则、组件缺失行为，以及目标版表字段/API。
- 正文只保留固定版支持的多层结构、BOM versioning 配置条目和重复制造 MTS 确认的日期示例；没有编造 IMG 完整路径、T-Code、表键、授权或系统结果。
- 当前文章状态：drafting；不计入批次 A reviewed，也不增加 owner accepted。
- 下一篇：PP-03《工作中心与工艺路线 Routing》，批准路径 knowledge/PP/01-foundations/work-center-routing.md。开始前只读取 PP-03 对应的范围、来源和关联材料。
- 批次 A 正式统计仍为 8/50 reviewed、0/50 owner accepted；CareerOS owner accepted 仍为 3/99；SAP 实机测试 0。
