# PP-09｜三角色审查与证据收尾记录

- 文章：knowledge/PP/05-data-model/production.md
- 日期：2026-11-27（Asia/Shanghai）
- 固定目标：SAP S/4HANA 2021 On-Premise；ECC 只作必要差异对比。
- 结果：**drafting**。普通读者、资深 SAP 配置顾问、普通 SAP 开发人员各完成 5 个有效闭环，共 15；核心物理关联、基数、目标系统元数据与权限未闭合，不能据轮数升级为 reviewed。
- 执行方式：同一 Work 上下文内按三种角色视角模拟提问、答复、正文修订和原角色复核；未创建/调用独立审查代理，未邀请真人专家，未重新下载项目既有 SDK 源包。不声称独立审查或本轮直接重放源包。
- 来源范围：直接读取 SAP 2021 Simplification List §27.35、§24.5 和特定 EHS 选择条件；复读 M3 PP-09 fixed VDM evidence record 中 SDK 3.59/3.70 发行说明、固定源包哈希和 entity key 字段记录。没有读取目标系统 $metadata 或 SAP 数据库字典。
- 控制项：M3 控制矩阵无 PP-09 独立行；S4HANA-09 是相邻通用控制项，不替代 PP-09。PP-02、PP-03、PP-05 当前均不在分支。
- 未解决核心项：生产对象一般物理键/关联/基数，MATDOC 主键和订单关联，2021 API 发布契约/权限及目标系统行为。SAP 系统未连接，无实机测试。

| article_id | role | round | question | evidence | work_response | change_ref | recheck | status | executor_context | timestamp |
| --- | --- | ---: | --- | --- | --- | --- | --- | --- | --- | --- |
| PP-09 | 普通读者 | 1 | Production version 和 BOM、routing 是不是三份可以直接互相 JOIN 的数据？ | SAP 2021 §27.35 支持在简化 sourcing 场景中 production version 关联 BOM/routing，并说明相应 routing 用于生产订单；未提供表关联键。 | 答复：只能说明业务对象引用，不能推出数据库连接。开头加入物理表、兼容读取和 API entity 三层区分。 | §1、§2 | 修订后明确“业务关系不等于表外键”，没有画出未证实的连接线。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通读者 | 2 | 是不是每个 BOM 都一定要先建 production version？ | SAP 2021 §27.35 明确区分 MTO/MTP：选择 BOM 可不需要 production version，但选 routing 仍需要。 | 答复：否。将普通简化 sourcing 的例子与 MTO/MTP 例外分开写。 | §2、§5 第一行 | 修订后没有写成“一律必须”；保留了例外的限定场景。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通读者 | 3 | 看到 AUFK、AFKO、AFPO 几个名字后，能不能认定它们就是生产订单三层表？ | 2021 Simplification List 特定 EHS Substance Volume Tracking 选择条件列出若干对象名；该页不是完整 PP 数据模型说明。 | 答复：不能。把其表名信息限缩为特定应用选择条件，并说明同列不证明关系。 | §3.1、§5 第二行 | 修订后表名没有被扩写成 header/item/operation 关系。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通读者 | 4 | MATDOC 和 MKPF/MSEG 是不是三张同样保存新凭证数据的表？ | SAP 2021 §24.5 说物料凭证数据保存在 MATDOC；旧表名通过兼容 CDS 读取。 | 答复：不是同一层。增加兼容读取对象解释，避免“旧名仍存在=仍存新业务数据”。 | §3.2、§5 第三行 | 复核后将物理数据存储与兼容对象区分。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通读者 | 5 | OData entity 有五个 key，能不能拿来查询 MATDOC 主键？ | M3 fixed VDM 记录说明五个 key 属特定 confirmation material movement entity；记录明确不等于 MATDOC 物理主键。 | 答复：不能。文章用单独小节和对照表把 entity key 与物理键分开。 | §4、§5 第四行 | 修订后没有把 API 键复制到 SQL 或数据库模型。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 资深 SAP 配置顾问 | 1 | §27.35 的规则是不是所有生产模式的 BOM/routing 主数据设计要求？ | 固定版资料章节为 Simplified Sourcing，且原文对 MTO/MTP BOM 和 routing 另列例外。 | 答复：不能普遍化。文首加上简化 sourcing 范围和制造模式例外提示。 | §2 首段、§5 第一行 | 复核后范围限定仍清楚，不冒称生产主数据全模型。 | closed | 同一 Work 上下文内资深配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 资深 SAP 配置顾问 | 2 | MRP 对生产版本的锁定规则是否只区分 locked/not locked？ | 2021 §27.35 明列 Locked for any usage 与 Locked for automatic sourcing 两种排除状态。 | 答复：保留来源的两个状态名称，不折成一个普通锁定标志。 | §2 bullet 4 | 原角色复核确认文案没有抹平两种状态差异。 | closed | 同一 Work 上下文内资深配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 资深 SAP 配置顾问 | 3 | 生产版本和 BOM/routing 的数量或日期有效范围能否直接当成表字段和复合键？ | M3 数据补查支持来源场景中的数量/日期选择，但没有给出目标表字段、复合键或数据库关联。 | 答复：不能。将使用条件与数据键分开列，物理结构留待固定版字典/API 元数据。 | §2、§5 第一行 | 修订后没有把选择逻辑转成字段定义。 | closed | 同一 Work 上下文内资深配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 资深 SAP 配置顾问 | 4 | Simplification List 的 EHS 选择条件可以证明每个 PP 系统一般关联 AUFK/AFKO/AFPO/RESB 吗？ | SAP 2021 页面将这些名字列在特定 PRO/CON 的 Substance Volume Tracking 选择条件中。 | 答复：仅限该应用上下文。添加小节标题与显著“不能推出”句。 | §3.1、§5 第二行 | 原角色复核确认未泛化成系统接口或产品数据字典。 | closed | 同一 Work 上下文内资深配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 资深 SAP 配置顾问 | 5 | S4HANA-09 控制项已写到 MATDOC/SDK keys，是否可以替代 PP-09 的文章门禁？ | 当前 M3 matrix 有 S4HANA-09 crosscutting row，但没有 PP-09 row；triage/detail row 仍有 PP09-specific tasks. | 答复：不能。文章记录矩阵结构缺口，维持 PP-09 对象范围和依赖条件。 | §6 末段、审查记录控制项 | 修订后不会把相邻 S4HANA-09 当作本篇验收或控制项。 | closed | 同一 Work 上下文内资深配置顾问视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通 SAP 开发人员 | 1 | 生成 VDM 的 SDK 版本号是不是 SAP S/4HANA FPS 版本？ | M3 PP09 补查记录和 SAP SDK release notes 分别说明 SDK 3.59.0 对应 On-Premise 2021、3.70.0 对应 2021 FPS02；它们是不同版本体系。 | 答复：不是。文章来源写明 Work 本轮复读项目证据记录，没有重新下载或拆包。 | §4、审查记录来源范围 | 修订后没有声称已执行本轮 Maven 包验证。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通 SAP 开发人员 | 2 | OData entity 的五个 key 是否含 OrderID/OrderItem？ | M3 逐字段记录列五项 @Key，OrderID 与 OrderItem 为非键属性。 | 答复：按该类生成源码标记列出，且限定特定 entity。 | §4 | 复核后 key 列表完整并将订单标识放在非键属性叙述。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通 SAP 开发人员 | 3 | 含“Confirmation”名称的服务能否覆盖取消确认、其他物料移动或所有订单？ | M3 补查记录说明该 entity 仅表示 Material Movements for Confirmation，未证明非确认发起移动、取消/冲销或订单关系基数。 | 答复：不外推。将未证实的覆盖/基数写入表格和核心缺口。 | §4、§5 第四/五行 | 修订后服务和实体边界没有被标题扩大。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通 SAP 开发人员 | 4 | 五个 @Key 能否证明客户系统已启用服务、角色已授权或 $metadata 完全一致？ | 固定 SDK 源码只证明生成 VDM model；未读目标系统 metadata、服务发布配置或用户授权。 | 答复：不能。增加“没有系统测试”的文章边界并明确 API 实际启用/授权待核。 | 文章 metadata、§4、§6 | 修订后无实机测试、授权或运行结果声明。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| PP-09 | 普通 SAP 开发人员 | 5 | 能否根据同一行里的 AUFK/AFKO/AFPO/RESB/MKPF/MSEG，给读者一个直接 JOIN 示例？ | 特定 EHS 选择条件列名，但没有 JOIN、key 或 cardinality 定义；用户范围要求不能从关键词推测关联。 | 答复：不可以。练习只做对象分类和证据边界标注，不加入 SQL/JOIN。 | §1、§3.1、§7 | 复核后没有加入 JOIN 或未经证明的一对多关系。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |


## 2026-11-27 分支依赖续核

HEAD `41131a194e332c50d98183a092caf41f98105a74` 已包含 PP-02、PP-03、PP-05；三篇当前均为 Draft。将早期“当前均不在分支”的记录修正为“存在但尚不能作为已审查依赖”，不改变 PP-09 状态。M3 控制矩阵仍无 PP-09 独立行，逐篇准入与固定来源记录继续作为范围依据。
