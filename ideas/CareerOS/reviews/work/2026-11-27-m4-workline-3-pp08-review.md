# PP-08｜三角色审查与证据收尾记录

- 文章：knowledge/PP/04-configuration/production.md
- 日期：2026-11-27（Asia/Shanghai）
- 固定目标：SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比。
- 原始角色模拟：普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各 5 个闭环，共 15 个；这些均在同一 Work 上下文完成，只是模拟视角，不是独立审查，不计 Role Reviewed。
- 当前状态：**Draft**。本次续核后仍缺通用生产配置学习目标及受权只读查看入口；下方新增的独立 AI reviewer-context 复核仅检查证据边界和表达，不会自动关闭 M3 准入门槛。
- 执行边界：未邀请真人专家；未连接 SAP，未执行配置、实机或权限测试。
- 固定版证据：SAP S/4HANA 2021 Simplification List PDF p.152（Scheduling Margin Key）；2021 FPS01 What's New PDF pp.146–147（组件装配动作处理器功能及特定 Customizing 前提）；SAP Help version=2021.000（Change Record/Process Order 特定功能索引摘录，HTML 直开 0 行）。另有动态 Operations Guide v11.0（2026-07-22；文档历史对应 S/4HANA 2021 SPS10）PDF p.23，只支持 MRP Records 报表先决条件，不是冻结的 2021 初版证据。
- 证据纠偏：M3 来源行原把 Simplification List PDF p.623 描述为生产版本迁移；目录核对确认 p.623 实为 Browser-based Process Instruction-Sheets/Electronic Work Instructions，p.617 为 Simplified Sourcing。本次已更正共享来源台账及来源贴合度记录，未改 M3 控制矩阵或准入结论。
- 固定版续查：按官方域名核查 `version=2021.000` 下的 production order type、production scheduling profile、confirmation parameters、MRP group/configuration；未找到可直接复读并串联一般配置项→行为→适用条件的固定 2021 On-Premise 页面。官方结果中的当前 2025/2026 页面、旧 ERP/Cloud/未锁版资料及单一功能索引摘录均未用作通用结论。`FSD_OP2021_latest.pdf` 搜索索引/打开 PDF 显示 v9.0/SPS08，与此前直接读取的 v11.0/SPS10 不一致；动态 URL 未用于填补固定版缺口。Operations Guide v11.0/SPS10 则只按动态版本披露、仅引用该报表先决条件。
- 当前依赖：PP-01 为 Draft，核心组织关系/生产模式未闭合；PP-04、PP-05、PP-06 文件存在但均为 Draft，不能作为已审查依据。
- 未解决核心项：一般订单类型、排程、确认、MRP 参数和工厂配置说明；受权只读查看入口及角色权限。状态保持 Draft。

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

## 2026-11-27 最终独立 AI reviewer-context 复核

- 首轮 reviewer-context 对候选正文 blob `4f911d0aef3bd4449912779abb167ecd57ee44e6` 的复核发现同一项来源边界缺陷：当前可读 Operations Guide 实为 v11.0（2026-07-22）/S/4HANA 2021 SPS10，不能列在未区分版本的“固定版示例”中。首轮普通读者 4/5、配置顾问 4/5、开发者 3/5；失败均集中于该版本标注及共享来源记录。作者据此把该例移至动态 SPS10 范围，补充 Document History、动态地址说明，并同步修订文章矩阵、证据台账与来源贴合度记录。
- 最终复核的精确正文 blob：`39203dad38372889c85a6f5253a8dade0dc2e1b5`。普通读者、资深 SAP 配置顾问、普通 SAP 开发人员三个独立 AI reviewer-context 各复核以下 5 项，最终 15/15 PASS。三个 reviewer-context 不是真人 SAP 专家；该复核不替代 M3 核心准入，也不构成 Role Reviewed。
- 最终状态建议：**Draft**。通用生产订单/MRP/工厂配置及受权只读入口仍无足够的固定版证据；不得把 15/15 PASS 当成核心学习目标已闭合。

| article_id | role | round | question | evidence | author_response_and_revision_judgment | change_ref | recheck | status | executor_context | timestamp |
| --- | --- | ---: | --- | --- | --- | --- | --- | --- | --- | --- |
| PP-08 | 普通读者 | 1 | 不填 MARC-FHORI 会不会停止排程，或 SAP 是否会自动每日转换计划订单？ | §2.1 与矩阵将字段默认规则、OMSR 字段选择及来源写明的每日转换建议分开；SAP 2021 Simplification List p.152 未证明客户配置或自动作业。 | 答复：不能据字段来源推断客户系统行为；无需修改最终措辞。 | §2.1、§3 | 最终 blob `39203dad38372889c85a6f5253a8dade0dc2e1b5` 清楚保留边界。 | PASS | 独立 AI reviewer-context（普通读者） | 2026-11-27 |
| PP-08 | 普通读者 | 2 | 两条组件装配 Customizing 路径是否适用于所有工厂和订单类型？ | 2021 FPS01 What's New pp.146–147 将其列为指定 action handler 的前提，并按所需 plant/order type 选行。 | 答复：该例仅为功能专属设置；不扩写为通用配置。无需追加修改。 | §2.2、§3 | 最终正文中的路径限定及矩阵范围一致。 | PASS | 独立 AI reviewer-context（普通读者） | 2026-11-27 |
| PP-08 | 普通读者 | 3 | Change Record 的 Required Approval 是否是完整页面已读或一般审批规则？ | 固定 `version=2021.000` 的官方索引列出 BJ8/1NF；canonical HTML 直开 0 行。 | 答复：它只是一条官方索引摘要，不推出审批人、时点、权限或客户行为；无需修改。 | §2.3、§7 来源 3 | 最终正文明确标示索引摘录和 0 行直开限制。 | PASS | 独立 AI reviewer-context（普通读者） | 2026-11-27 |
| PP-08 | 普通读者 | 4 | MRP Records 报表前提是否会被误读成固定 2021 初版或通用 MRP 规则？ | SAP Operations Guide PDF 文档历史记 v11.0（2026-07-22），对应 2021 SPS10；该版 p.23 仅列该报表前提。 | 答复：首轮发现版本分类不清后，已移出固定版例，标明动态 SPS10 及用途；同步台账。 | §2.4、§3、§7 来源 4；两份来源记录 | 最终正文和台账均明确版本、报表范围和非通用性。 | PASS | 独立 AI reviewer-context（普通读者） | 2026-11-27 |
| PP-08 | 普通读者 | 5 | 离线练习是否暗示需登录 SAP，或文章已满足 PP-08 学习目标？ | §4 列出一般配置与受权只读入口缺口；§6 明确无需连接 SAP；M3 triage 仍为“未核验／暂缓核心”。 | 答复：无需系统操作；保持 Draft，未修改。 | §4、§6；M3 triage PP-08 | 最终正文未诱导配置更改，状态仍 Draft。 | PASS | 独立 AI reviewer-context（普通读者） | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 1 | MARC-FHORI 与 ECC 旧规则有否混淆？ | 2021 Simplification List p.152 区分 S/4 默认非必填、OMSR 可能要求及 ECC 特定 MRP type 规则。 | 答复：按来源分别陈述，不把 ECC 条件套到 S/4；无需修改。 | §2.1、§3 | 最终正文没有把客户设置或 ECC 条件泛化。 | PASS | 独立 AI reviewer-context（配置顾问） | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 2 | FPS01 action-handler 路径是否可作为一般离散生产订单配置建议？ | SAP 2021 FPS01 pp.146–147 将路径限定为特定组件装配 handler。 | 答复：不可以；已限于指定功能、plant/order type，不作通用建议。无需额外修订。 | §2.2、§3 | 最终正文路径和边界通过复核。 | PASS | 独立 AI reviewer-context（配置顾问） | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 3 | Change Record/Process Order 索引能否证明通用订单审批模型或客户自动批准？ | 2021.000 官方索引只给出指定功能范围、Required Approval 路径；页面直开 0 行。 | 答复：不推导离散订单、审批角色、状态、时点或自动行为；无需修改。 | §2.3、§3 | 最终正文明确为索引摘录，范围限定准确。 | PASS | 独立 AI reviewer-context（配置顾问） | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 4 | MRP Records 的 MRP views/type 前提是否能推广到一般 MRP 配置？ | 动态 Operations Guide v11.0/SPS10 p.23 只说明 `PPH_SETUP_MRPRECORDS` 报表。 | 答复：不能；修订明确版本与报表范围，仅作动态版线索。 | §2.4、§3；evidence-logistics、source-fit PP-08 | 最终正文与 M3 来源记录均未把其标作固定初版或通用规则。 | PASS | 独立 AI reviewer-context（配置顾问） | 2026-11-27 |
| PP-08 | 资深 SAP 配置顾问 | 5 | p.623/p.617 的错误归因是否完全纠正，Draft 缺口是否仍准确？ | 固定 Simplification List 目录：p.623 为 Browser-based Process Instruction-Sheets/Electronic Work Instructions，p.617 为 Simplified Sourcing。 | 答复：已更正共享来源行与 source-fit；保留 M3“暂缓核心”，不改控制矩阵。 | §5；evidence-logistics PP-08；sd-pp-source-fit PP-08 | 最终文字与两份来源记录一致；通用配置和权限缺口仍列明。 | PASS | 独立 AI reviewer-context（配置顾问） | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 1 | 固定版、索引摘录与动态版来源是否可辨？ | §§2.1–2.4、来源清单分别标注固定清单、FPS01 PDF、2021.000 索引与动态 SPS10 Ops Guide。 | 答复：已将 Ops Guide 版本明确标出；其他来源分类维持原样。 | §2、§7 | 最终 blob 明确区分固定资料、索引摘要与动态版本。 | PASS | 独立 AI reviewer-context（普通开发人员） | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 2 | Customizing 路径或事务名是否证明用户拥有只读授权？ | 正文指出来源未建立目标系统的受权只读事务/app、角色或授权对象。 | 答复：不证明；没有从路径推断权限。无需修改。 | §1、§3、§4 | 最终正文明确记录权限缺口。 | PASS | 独立 AI reviewer-context（普通开发人员） | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 3 | 文档前提是否等于客户已启用设置、作业已运行或已验证？ | §2 各例限定来源适用范围；页首声明未连接 SAP、未配置或实机测试。 | 答复：不能作此推断；无需修改。 | §2、系统验证声明 | 最终正文未声称客户现状或测试结论。 | PASS | 独立 AI reviewer-context（普通开发人员） | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 4 | PP-01、PP-04～PP-06 的依赖文件是否存在且仍是 Draft？ | 当前分支逐篇文件核对：四篇文件存在，均为 Draft；未作为已审查依据。 | 答复：准确标为“存在但 Draft”，不借依赖替代来源证据。无需修改。 | §4 | 最终正文依赖说明正确。 | PASS | 独立 AI reviewer-context（普通开发人员） | 2026-11-27 |
| PP-08 | 普通 SAP 开发人员 | 5 | 共享证据记录是否还残留 p.623 错配或 Operations Guide 固定版误标？ | evidence-logistics、source-fit PP-08 行分别标注 p.623/p.617 真实主题与 Ops Guide v11.0/SPS10 动态边界。 | 答复：均已修订；历史的旧描述只保留在明确标注的纠偏说明中。 | 两份 M3 来源记录及 §5 | 最终工作树记录与正文一致。 | PASS | 独立 AI reviewer-context（普通开发人员） | 2026-11-27 |
