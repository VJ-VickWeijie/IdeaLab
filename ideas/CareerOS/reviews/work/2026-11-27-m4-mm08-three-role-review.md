# MM-08｜三角色闭环审查与证据边界记录

- Article ID：`MM-08`
- Reviewed artifact: `ideas/CareerOS/knowledge/MM/03-tcodes/transaction-index.md` 的修订稿，尚未提交到 PR #21。
- Article status after review: **drafting**；三角色问题均已闭环，但材料凭证显示入口与通用 MIGO 导航仍缺足够的 SAP S/4HANA 2021 On-Premise 固定版证据。
- Review window: 2026-11-27 00:22–00:24 Asia/Shanghai。
- Author/Coordinator: 当前 Codex Work Mode 根上下文 `/root`。平台未向此任务暴露精确底层模型版本；未声称切换模型。
- Review contexts: `/root/reader_mm08`、`/root/consultant_mm08`、`/root/developer_mm08`。三者为真实分开的 AI 子代理执行上下文；都不是人类 SAP 专家或认证意见。没有声称不同底层模型。
- Round summary: ordinary reader 5/5, SAP configuration consultant perspective 5/5, SAP developer perspective 5/5; 15 个有效闭环，均由提出该问题的原上下文复核为 PASS。未发现需 reopen 的首轮问题。

## Evidence key

- **S1** — SAP Help, [Transactions — Logistics—General (LO), SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/25a41481f62e469ba0e61015a0d39d20/bcd8c353b677b44ce10000000a174cb4.html?version=2021.000)：MM01/MM02/MM03 与创建、修改、显示物料主数据记录按组列示；未逐代码分配动作。
- **S2** — SAP Help, [Creating a Material Master Record, SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f7fddfe4caca43dd967ac4c9ce6a70e4/36528c53f894ee23e10000000a174cb4.html?locale=en-US&version=2021.000)：创建流程的视图、组织层级及授权边界；不扩展成 MM02/MM03 的完整模式或权限模型。
- **S3** — SAP Help, [Purchase Order – Single-Screen Transaction (ME21N, ME22N, and ME23N), SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/7e80b65334e6b54ce10000000a174cb4.html?version=2021.000)；及 [Create, Change, and Display Purchase Orders, same version](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/8780b65334e6b54ce10000000a174cb4.html?version=2021.000)：父页面标题列出代码族；关联应用页描述操作、授权前提和单据状态边界。未提供逐代码授权矩阵。
- **S4** — SAP, [Simplification List for SAP S/4HANA 2021, p.151](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=151)：MM01/MM02/MM03 特定 MRP 字段变更；不是完整事务导航资料。
- **S5** — SAP Help, [Add Short Text to Goods Movement, SAP S/4HANA 2021 SPS05](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f5d3e1005efd4e86acf9a65abf428082/ee4e8d80dc2d4625a08329d995128aea.html?version=2021.005)：最多 50 字符项目级短文本；只有在资料写明的同步 IM→嵌入式 EWM 场景中，页面说明可在 MIGO 输入该文本。不能支撑通用 MIGO 导航。
- **S6** — SAP, [Administration Guide to Implementation of SAP S/4HANA 2021 with SAP Best Practices, §3.5.4.5](https://help.sap.com/doc/b4447b6727684f13917622cf63e1eb98/2021/en-US/AdminGuideS4HANAImpl_HELP_EN.pdf)：列出该 Best Practices 方案中嵌入式 EWM 范围项的激活后步骤；不定义所有 S/4HANA 系统或 EWM 部署形态。

## Ordinary reader perspective — 5/5 closed

Reviewer context: `/root/reader_mm08`; each item was rechecked by the same original context after revision. Date/time recorded for this review window: 2026-11-27 Asia/Shanghai.

### R1.1 — T-Code 的用途和调用边界

- **Question:** 初学者不知道 T-Code 是什么、在哪里使用；是否要给出如何启动代码的操作说明？
- **Evidence:** S1 仅为固定版事务清单；未查到适用于所有目标界面的统一启动步骤。
- **Work response:** 不添加未经固定版来源支持的界面点击/执行步骤。把 T-Code 说明为 SAP 帮助资料里的短代码和查找索引词，并明确具体系统的启动方式不属于本篇已证范围。
- **Change ref:** Article “这篇文章要解决什么”。
- **Original role recheck:** PASS；用途与界面操作边界清楚，未新增无来源步骤。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/reader_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.2 — 如何从 MM01/MM02/MM03 中选择

- **Question:** 表格把三代码列在一起，初学者仍无法判断应选择哪个；能否补逐代码依据，或明确无法选择？
- **Evidence:** S1 将三代码与“创建、修改和显示”按组列示，没有逐代码映射。
- **Work response:** 不从名称或顺序推断。明确该来源不足以确认 `MM01=create / MM02=change / MM03=display` 的一一对应，本篇暂不能指导逐代码选择。
- **Change ref:** Article “怎样从表中选入口？”及物料主数据表格。
- **Original role recheck:** PASS；来源边界和不可据此选择入口的限制明确。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/reader_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.3 — 为什么查看采购订单

- **Question:** 没有业务例子说明读者何时要查看采购订单、以及与采购申请/收货的关系。
- **Evidence:** S3 支持相关应用能查找、查看和编辑订单；MM-04、MM-05、MM-06 是项目内对应业务文章。
- **Work response:** 增加“查看现有采购订单”的文字练习并链接 MM-04、MM-05、MM-06 获取业务背景；不在导航索引中复述完整流程或新增业务状态断言。
- **Change ref:** Article “无写权限时的学习方式”。
- **Original role recheck:** PASS；例子能引导读者按对象查表，并把流程背景交给相应文章。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/reader_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.4 — EWM 与同步货物移动术语

- **Question:** 初学者不理解同步货物移动、嵌入式 EWM、Best Practices 范围项；是否应解释或移出主线？
- **Evidence:** S5 把该短文本功能限定在同步 IM→EWM 的嵌入式场景；S6 只列 Best Practices 范围项的激活后步骤。
- **Work response:** 补充 EWM 英文全称、把“同步”限定为该页面所述场景，并说明 Best Practices 范围项只针对其方案；强调这只是短文本证据示例，不是理解通用导航的前提。
- **Change ref:** Article “MIGO 与物料凭证”及 EWM 说明段。
- **Original role recheck:** PASS；读者可将其识别为窄范围版本说明，且无需先学习 EWM。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/reader_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.5 — 无写权限时的练习

- **Question:** 只叫读者阅读帮助或看演示数据，没有不运行事务码的练习步骤。
- **Evidence:** 文章的学习边界要求不依赖生产写权限；S1/S3 只支撑对象入口族，不足以给出逐代码授权结论。
- **Work response:** 增加虚构的主数据/采购订单识别情境，让读者按对象找资料并练习识别证据边界，不要求登录或操作系统。
- **Change ref:** Article “文字练习（无需登录 SAP）”。
- **Original role recheck:** PASS；练习可在离线阅读中完成且不暗示未经证实的代码映射。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/reader_mm08`; `2026-11-27 (Asia/Shanghai)`.

## SAP configuration consultant perspective — 5/5 closed

Reviewer context: `/root/consultant_mm08`; AI review lens, not a human consultant or real-system configuration conclusion. Each item was rechecked by the same original context. Date/time recorded for this review window: 2026-11-27 Asia/Shanghai.

### R1.6 — 采购订单事务族与应用行为的归因

- **Question:** 代码族来自父页标题，创建/查找/查看/编辑和授权条件来自关联“应用”页面；是否应明确二者不能推出逐代码模式？
- **Evidence:** S3 分别支持父页所列事务族和关联应用页的功能说明；后者没有逐代码授权分配。
- **Work response:** 将表格表述改为“父页面标题确认事务族；相关应用页面描述应用层操作”，并明确不扩展成逐代码模式映射或授权矩阵。
- **Change ref:** Article 采购订单表格及“怎样从表中选入口？”段。
- **Original role recheck:** PASS；代码族与应用行为分开。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/consultant_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.7 — 物料主数据配置和授权限制的适用范围

- **Question:** 创建流程页面所述视图、配置、授权限制是否会被误读成 MM02/MM03 的完整行为？
- **Evidence:** S2 是创建流程页面，不能说明 MM02/MM03 的完整模式或授权模型。
- **Work response:** 明确该限制仅针对来源描述的创建流程，不推广到 MM02/MM03。
- **Change ref:** Article 物料主数据表格和解释段。
- **Original role recheck:** PASS；适用范围收窄准确。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/consultant_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.8 — 逐代码操作映射

- **Question:** 固定版清单按组列出 MM01/MM02/MM03，是否应明确没有单独证明每个代码的动作？
- **Evidence:** S1 只有组级 “create, change and display” 描述。
- **Work response:** 明确未验证 MM01=create、MM02=change、MM03=display 的逐代码映射，不以代码顺序推断。
- **Change ref:** Article “怎样从表中选入口？”段。
- **Original role recheck:** PASS；没有从组级证据补成逐代码事实。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/consultant_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.9 — EWM Best Practices 指南范围

- **Question:** 某 Best Practices 实施指南的嵌入式 EWM 激活后步骤是否会被读成所有 S/4HANA On-Premise 系统必需？
- **Evidence:** S6 只针对该指南列出的 Best Practices 范围项。
- **Work response:** 明确这不表示每套 S/4HANA On-Premise 系统都使用或必须激活该范围，也不将指南作为所有 EWM 部署形态的定义。
- **Change ref:** Article “MIGO 与物料凭证”及 EWM 说明段。
- **Original role recheck:** PASS；部署范围和结论强度均受限。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/consultant_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.10 — MIGO SPS05 特例是否变成通用条目

- **Question:** SPS05 短文本资料是否会被误读为 MIGO 的通用导航证明？
- **Evidence:** S5 只支持短文本功能与特定同步 IM→嵌入式 EWM 条件。
- **Work response:** 用醒目标记说明该段是版本/场景受限示例，不是已核实的 MIGO 通用导航；材料凭证显示入口和通用导航仍保持未决。
- **Change ref:** Article “MIGO 与物料凭证”首句及缺口表。
- **Original role recheck:** PASS；没有把特例推广到一般 MIGO。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/consultant_mm08`; `2026-11-27 (Asia/Shanghai)`.

## SAP developer perspective — 5/5 closed

Reviewer context: `/root/developer_mm08`; AI review lens, not a human SAP developer certification or system-test result. Each item was rechecked by the same original context. Date/time recorded for this review window: 2026-11-27 Asia/Shanghai.

### R1.11 — 物料主数据逐代码映射风险

- **Question:** 合列的 MM01/MM02/MM03 是否会被当成逐代码映射？
- **Evidence:** S1 为组级描述，没有逐代码拆分。
- **Work response:** 明确正文和练习均不确认一一对应，并指出单靠此表不能选出逐代码入口。
- **Change ref:** Article 物料主数据表格、“怎样从表中选入口？”及文字练习。
- **Original role recheck:** PASS；没有误导读者以未经证实映射操作系统。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/developer_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.12 — 代码族与相关应用功能混同

- **Question:** 采购订单页将事务族与“相关应用”功能描述并列，是否会被误认为每个代码都有相同的逐模式说明？
- **Evidence:** S3 的父页标题列出代码族；子页描述应用级功能，没有逐代码模式矩阵。
- **Work response:** 在表格及导航说明中分开两种证据，并明确缺少逐代码模式映射与授权矩阵；不加入未经证实的 Fiori 分类。
- **Change ref:** Article 采购订单表格及“怎样从表中选入口？”段。
- **Original role recheck:** PASS；两层证据及分类边界清楚。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/developer_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.13 — 授权模型不完整

- **Question:** 是否应说明引用资料不是授权对象、启动权限和只读角色的完整模型？
- **Evidence:** S2/S3 只提到必要授权和具体条件；未列授权对象或企业角色。
- **Work response:** 明确不提供授权对象、完整角色模型或个体账号结论；未连接系统、未做授权测试。
- **Change ref:** Article 表格“显示、修改与权限边界”列及练习说明。
- **Original role recheck:** PASS；无越界权限结论。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/developer_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.14 — SPS05 文本长度和嵌入式 EWM 条件

- **Question:** 是否应写清 50 字符上限，并保证嵌入式 EWM 限定只绑定于同步 IM→EWM 短文本特例？
- **Evidence:** S5 明确最多 50 个字符，并将 MIGO 中输入文本限定于同步库存管理到嵌入式 EWM 场景。
- **Work response:** 补入最多 50 字符，标为 SPS05 示例，并说明该条件不支撑其他 MIGO 操作或 EWM 部署形态。
- **Change ref:** Article “MIGO 与物料凭证”及 EWM 说明。
- **Original role recheck:** PASS；版本与场景限定完整。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/developer_mm08`; `2026-11-27 (Asia/Shanghai)`.

### R1.15 — 对象、输入/输出与关联文章

- **Question:** 导航条目是否应明确作用对象、输入/输出证据范围及学习关联？
- **Evidence:** S1/S3 支持物料主数据记录和采购订单对象，但没有通用字段级输入/输出、API 或结构合同；M3 MM-08 目标要求补业务关联。
- **Work response:** 明确列出两个对象；说明来源未提供字段级 I/O/API 合同，因此不编写字段映射；加入 MM-02、MM-04、MM-05、MM-06 关联阅读链接。
- **Change ref:** Article“表格中……”段和“文字练习”段。
- **Original role recheck:** PASS（范围受限）；对象和继续阅读路径足够，技术 I/O 缺口被如实保留，文章继续 drafting。
- **Status/context/timestamp:** closed; author `/root`, reviewer `/root/developer_mm08`; `2026-11-27 (Asia/Shanghai)`.

## Outcome and remaining blocker

- 15/15 role-specific review loops closed: ordinary reader 5, consultant perspective 5, developer perspective 5. Each loop includes an actual question, evidence-based Work response, a recorded revision decision/change, and recheck by the original reviewer context.
- No reviewer reported a remaining defect in the revised statements above. This does **not** resolve the content evidence gate: there is still no sufficient fixed-version 2021 On-Premise source in this work package for a general MIGO navigation entry or the material-document display route.
- Therefore MM-08 remains **drafting**, contributes **0** to the 8/50 role-reviewed total, and is not owner accepted. No SAP system, customer configuration, user authorization, or transaction execution was tested.
