# PP-08｜三角色审查与证据收尾记录

- 文章：knowledge/PP/04-configuration/production.md
- 日期：2026-11-27（Asia/Shanghai）
- 固定目标：SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比。
- 结果：**drafting**。普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各完成 5 个闭环，共 15 个。闭环针对证据边界与可读性；没有关闭本篇通用配置和授权只读路径的核心缺口。
- 执行方式：同一 Work 上下文分别采用三种角色视角模拟问题、答复、修订和原角色复核；未创建或调用独立审查代理，未邀请真人专家，也未切换模型。不声称独立审查。
- 固定版证据：SAP S/4HANA 2021 Simplification List PDF p.152（Scheduling Margin Key）；2021 FPS01 What's New PDF pp.146–147（组件装配动作处理器功能及特定 Customizing 前提）；SAP Help version=2021.000（Change Record/Process Order 特定功能）；2021 Operations Guide PDF p.23（MRP Records 报表先决条件）。
- 证据纠偏：M3 证据行把 Simplification List PDF p.623 描述为生产版本迁移；本轮检查目录发现 PDF p.623 对应 Browser-based Process Instruction-Sheets/Electronic Work Instructions。PDF p.617 是 Simplified Sourcing。旧行不用于本篇主张。此处仅记录，不改 M3 共享台账。
- 未解决核心项：一般订单类型/排程/确认/MRP 参数/工厂配置说明；受权只读查看入口及角色权限；PP-01 核心依赖未通过；PP-04/05 不存在于当前分支。SAP 未连接，没有配置或实机测试。状态不能提升为 reviewed。

| article_id | role | round | question | evidence | work_response | change_ref | recheck | status | executor_context | timestamp |
| --- | --- | ---: | --- | --- | --- | --- | --- | --- | --- | --- |
| PP-08 | 普通读者 | 1 | 这一页讲“配置查看”，我能直接拿里面的路径去改生产环境吗？ | 文章的固定版来源只给出几个功能专属 Customizing 前提；没有连接系统或提供变更操作授权。 | 答复：不可以把学习说明当变更指令。加上不执行配置的学习边界和草稿状态。 | “离线学习方式”；文章头部状态原因 | 修订后明确路径用于理解来源，练习不要求连接 SAP，未声称系统访问。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通读者 | 2 | MARC-FHORI 是什么信息？不填是不是会让所有排程都停住？ | 2021 Simplification List p.152 说明字段规则、缺省值与所述 float/opening period；未指定 key 时相关值为零。 | 答复：只复述该字段的 2021 规则，并把排程影响限于来源文字；没有推出生产都停止。 | §2.1、§3 MARC-FHORI 行 | 修订后可区分字段规则与客户实际排程；不再写“会停产”等来源没有的结果。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通读者 | 3 | opening period 为零和“每天转换计划订单”是什么意思，是不是 SAP 自动每天转换？ | 来源说 zero opening period means planned orders should be converted into production orders every day；没有说作业自动运行或系统已安排。 | 答复：将语气限定为文档解释的计划要求，不写成自动处理。 | §2.1 与 §3 边界表 | 修订后清楚区分计划建议文字、自动作业和客户执行状态。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通读者 | 4 | 两条订单类型路径都是每个工厂都必须设置的吗？ | 2021 FPS01 来源把行选择限定在 required plant 和 order type，并服务于一个指定 action handler。 | 答复：否。写明这是功能专属前提，不外推到所有订单或工厂。 | §2.2 首尾段、§3 矩阵 | 修订后已注明选所需 plant/order type，且不构成通用规则。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通读者 | 5 | 我用离线练习要不要打开 SAP 或者找个事务码看配置？ | 本篇来源没有建立受权只读事务/应用路径。 | 答复：不用。新增只读路径待核提示和基于来源分类的离线练习。 | §3 授权行、§6 | 复核后练习不需系统；没有凭事务码名推测显示入口。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 1 | Simplification List p.623 是否真的对应 M3 台账所称的生产版本迁移？ | SAP 2021 PDF 目录列 p.623 为 Browser-based Process Instruction-Sheets/Electronic Work Instructions；p.617 为 Simplified Sourcing。 | 答复：不支持台账那一描述。修订文章明确页码/主题错配、将 p.623 排除为 PP 配置证据，并保留不改共享台账的范围说明。 | §5、§7 来源 1 | 原顾问视角复核：p.623 不再列为 PP 配置依据，p.617 也未被泛化。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 2 | MARC-FHORI 的必填规则是否与物料主数据字段选择相关？ | SAP S/4HANA 2021 Simplification List p.152 直接说若在 OMSR 定义则必填，默认不必填。 | 答复：按该来源区分 S/4 默认与字段选择条件，并只保留必要 ECC 旧规则对比。 | §2.1、§3 | 修订后未把默认不必填误写成绝对永不必填；也未把 ECC 条件套到 S/4。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 3 | “Define Order-Type-Dependent Parameters for Production Orders”能否代表所有离散订单类型配置？ | SAP 2021 FPS01 p.147 将该路径用于指定组件装配 action handler；SAP 2021.000 Change Record 页面另是 process order 的具体功能。 | 答复：两个来源分别适用于明确功能，不能据同一路径名称推导通用订单配置。将范围在段落及矩阵中分开。 | §2.2、§2.3、§3 | 修订后两种来源的部署/业务范围没有混为一谈。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 4 | Required Approval 是否就等于某用户批准、自动放行或确定状态变化？ | 2021.000 Change Record 页面只在对应功能 Effects on Customizing 中说配置 Required Approval 与流程订单类型 Recipe 区域。 | 答复：来源没有给出审批角色、时点或客户行为；删去此类推断并显式限缩。 | §2.3 末段、§3 Change Record 行 | 修订后没有把配置前提转成审批人/自动批准行为结论。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 5 | MRP Records 的物料/工厂先决条件能不能推广成通用 MRP 配置规范？ | S/4HANA 2021 Operations Guide 的 `PPH_SETUP_MRPRECORDS` 说明限定在报表使用的 MRP records。 | 答复：不能。把它限定成报表先决条件，不写为所有 MRP 运行的完整规则。 | §2.4、§3 MRP Records 行 | 修订后范围没有从某个报表扩大到所有 MRP parameter。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 1 | 报表前提中的“MRP views 已维护”是否等于 SAP 自动完成工厂主数据配置？ | 2021 Operations Guide p.23 列相关物料、维护 MRP views、合适 MRP type，未称系统自动创建或配置。 | 答复：避免把前置条件误解为自动行为；只按原文列条件。 | §2.4 | 修订后未描述自动数据填充或 master data 创建。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 2 | Change Record 依赖的两个 Scope Items 是否能用于证明客户启用了审批功能？ | SAP Help 2021.000 列 BJ8/1NF 作为页面范围，但没有提供任何客户系统激活状态。 | 答复：不行。把 Scope Item 只作为该来源适用范围标识，不推断产品激活或许可。 | §2.3、§3 Change Record 行 | 修订后该页面范围和客户系统功能状态明确分离。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 3 | Customizing 路径写得很具体，是否已经等于“只读查看入口和权限”证据？ | 计划要求须区分配置路径、授权只读路径；上述 SAP 文档没有给定目标用户授权对象或只读角色。 | 答复：不是。增加矩阵行明确本轮没建立受权只读入口。 | §3 授权行、§4 | 修订后没有以可引用配置路径暗示用户可查看或拥有权限。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 4 | M3 台账和 PDF 目录发生冲突时，能否继续引用旧描述？ | 固定 PDF 目录明确 p.623 为 browser-based instructions，和 M3 行的生产版本迁移描述不符。 | 答复：本篇不使用旧描述为事实，记录纠偏和需维护者后续决定的共享记录。 | §5、审查记录“证据纠偏” | 修订后正文来源只链接本轮直接核对的 p.152、FPS01、2021.000 和 Operations Guide。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 5 | 当前 M3 证据行本身属于官方 SAP 文档，可否不经核对直接当证据？ | M3 文件是项目内证据登记/规划文字，而非 SAP 产品文档；PP-08 准入要求固定版直接证据。 | 答复：不可以。文章明确把 M3 材料用作范围记录，并将产品事实追溯到正式 SAP 2021 来源。 | §5、§7 来源 5 | 修订后“项目计划”与“产品证据”分别标识，不互相替代。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |


## 2026-11-27 分支依赖续核

逐篇核对 HEAD `41131a194e332c50d98183a092caf41f98105a74` 时，PP-04、PP-05 已存在于当前 PR 分支，但两篇仍为 Draft。前文“不存在于当前分支”是旧快照；本次纠正为“存在但未完成证据/独立审查”，不改变 PP-08 的 drafting 状态。
