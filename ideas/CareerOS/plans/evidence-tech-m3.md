# CareerOS V0.3｜ABAP / S4HANA / AI 逐篇证据台账（M3）

状态：仅为材料准备；M1、M2 与 99 篇候选及 11 项纯导航分类已由所有者批准，M3 证据门禁仍在处理，M4 尚未授权。检索及阅读日期：2026-11-25。下列均为本次通过工具直接打开并读取相关正文的公开资料；RAG/Toolformer 文献及 NIST 不证明 SAP 功能。2021 目标产品不等于具体 FPS 已确认，正文断言须再次核对章节、版本、权限、场景及应用条件。本记录不是正式知识文章审查；无 SAP 实机测试。

## 本次读到的原始资料

| 代码 | 原始资料及版本 | 阅读范围和限制 |
| --- | --- | --- |
| T1 | [SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)，文档版本 11.0，2026-07-22 | PDF 物理页 198、201–206、209、215、228（零基索引分别 197、200–205、208、214、227）；内容是针对 2021 产品持续更新的特性范围，**FPS 未必逐项明确，不可倒推 FPS00**。 |
| T2 | [SQL Monitor What's New](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/b370bcd2f756469fb83ec418797550ee.html)，ABAP Platform 2021，页面版本元数据标 FPS00 | `Technical Details` 的 `Available As Of` 仅标 2021，页面底部 `Version` 字段标 ABAP Platform 2021 FPS00；两位独立上下文均核对。特指 SQLMD 的 Resolved/Joins/Cross Node Joins，不证明 SQL Monitor 整体首次出现于 FPS00 或实际环境可用。 |
| T3 | [BAPI Transaction Model](https://help.sap.com/SAPHELP_SCM700_EHP02/helpdata/EN/4d/5b102ba1483d8fe10000000a42189e/content.htm?no_cache=true)，旧版 SCM Help | `Transaction Control in Client`、`Transaction Handling via Service BAPIs`、`Comment`；可读且直接讨论通用事务/例外，**不直接证明 S/4HANA 2021 的特定 BAPI**。 |
| T4 | [What's New in SAP S/4HANA 2021 FPS01](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)，版本 1.0，2022-02-23 | 第 3.4.2.1.2 节，PDF 物理页 85–86：`EXECUTE_ALGORITHM` 特定银行对账 BAdI，含该例 IMG 路径。 |
| T5 | [S/4HANA 2021 Security Guide](https://help.sap.com/doc/d7c2c95f2ed2402c9efa2f58f7c233ec/2021/en-US/SEC_OP2021.pdf)，文档版本 11.0，2026-07-22 | PDF 物理页 158–159 Dispute Management 特定 RFC/BAPI 场景；第 241 页 HCM Processes and Forms 权限；第 709–710 页审计日志。目标产品 2021，具体 FPS 未确认。 |
| T6 | [SQL Services What's New](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/fb161b7df730447c9a7f461c500043ec.html)，ABAP Platform 2021 FPS01 | `Technical Details` 和开头：通过 SQL Services 对外部 ODBC 客户端暴露 CDS view entities，访问限只读；不能外推到全部 CDS 访问。 |
| T7 | [SAP Application Interface Framework What's New](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/d6dbbb13ef1f47398b7864bc6e1cd051.html)，S/4HANA 2021 FPS01 | `Additional Details` 特定 AIF 函数与授权对象；不是所有 OData、RFC 和业务 API 的授权规则。 |
| T8 | [PFCG Integration What's New](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/e6b26131fe4e43779b4141e191da6b07.html)，ABAP Platform 2021 FPS00 | 开头与 `Technical Details`：Fiori Launchpad 与角色维护的特定集成变化，不证明所有 API 授权。 |
| T9 | [S/4HANA 2021 Simplification List](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)，文档版本 1.25，2022-05-25，覆盖 initial/FPS01/FPS02 | PDF 物理页 285–286、12.6 中 COEP 的实际/统计值类型和兼容视图；需按具体值类型及目标 FPS 核对。 |
| T10 | [S/4HANA 2021 Operations Guide](https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf)，文档版本 11.0，2026-07-22 | PDF 物理页 24 说明特定 MRP 场景的 `MD_ADD_ELEMENTS`，同时含系统修改步骤——本项目仅阅读、不执行；具体 FPS 待核。 |
| T11 | [NIST AI RMF 1.0](https://nvlpubs.nist.gov/nistpubs/ai/NIST.AI.100-1.pdf)，2023 | GOVERN 1–6，PDF 物理页 27–29；自愿、通用 AI 风险框架。 |
| T12 | [NIST Generative AI Profile, NIST AI 600-1](https://nvlpubs.nist.gov/nistpubs/ai/NIST.AI.600-1.pdf)，2024-07 | 建议行动 GV-1.5、GV-1.6、MP-2.3、MS-2.7，附录 A.1.4/A.1.6；PDF 物理页 20、28–29、37、52–55。页码指 PDF 物理页，不是正文印刷页。 |
| T13 | [Retrieval-Augmented Generation for Knowledge-Intensive NLP Tasks](https://arxiv.org/html/2005.11401v4)，2021-04-12 v4，2020 初版 | `Abstract`、§1–2；论文中的参数化/非参数化记忆与检索生成方法，非权限系统、安全或 SAP 实现规范。 |
| T14 | [Toolformer](https://arxiv.org/html/2302.04761v1)，2023-02-09 v1 | `Abstract`、§2；论文讨论模型选择 API 和参数，不保证工具授权、生产可用性或 SAP 集成。 |
| T15 | [SAP Gateway Authorization](https://help.sap.com/docs/ABAP_PLATFORM_NEW/68bf513362174d54b58cddec28794093/815c22518bc72214e10000000a44176d.html?version=202110.latest)，ABAP Platform 2021 Latest，具体 FPS 待确认 | 协调者通过浏览器实际读取 Gateway Security Guide 与 Authorization 子页：该页说明检查基于发起用户的授权对象。独立审查者已通过浏览器实际重读并确认此有限表述；不证明具体服务对象、用户权限或令牌方式。 |
| T16 | [SAP Support：Purchasing BAPIs](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167428.html) 及[How to create a Purchase Order with BAPI_PO_CREATE1](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167600.html)，ECC/R/3 背景；未声明 S/4HANA 2021 版本 | Work 与独立开发复核上下文分别直接读取两页。页面均标注 Additional Content（SAP 说明其不属于适用 SAP 条款定义的 Documentation）；有限支持 ME21N/BAPI_PO_CREATE1 对应、TESTRUN 无数据库效果、SE37 示例先调用创建再调用 `BAPI_TRANSACTION_COMMIT`、X 结构和 RETURN/调试线索。无目标版本选择器，未说明 2021 函数级提交/回滚、更新任务、WAIT 保证、RFC/LUW 边界或完整失败处理；不作为 S/4HANA 2021 契约。 |

T1 使用动态 `latest` 地址，同一 URL 曾发生版本漂移。先前独立记录的该地址现版文件 SHA-256 为 `ad3c9913ee1f0cbe81e4ede4cb15192c4fcda6497dcf9ac0654dde04b541aaec`，大小 3,056,745 字节；**本次仅通过网页阅读正文，没有下载、计算哈希或归档对应文件**，无法独立确认该摘要与本次看到的字节一致。该 URL 不保证长期复现；内容替换或后续使用时需重新读取、计算哈希并核对证据段落，不得视为固定版资料。

## 26 篇逐项映射

“部分可证”仅指下列单个有限声明；不是文章范围全部已证，更不是允许进入 reviewed/accepted。尚未找到目标版本直接资料时明示为缺口。T1/T5/T10 虽明确是 2021 产品文档，但已于 2026 更新，除非具体段落另给 FPS，**均不表示该特性自初始版本起存在**。

| 文章 ID | 本次可读来源/具体位置 | 限定性支持及未覆盖缺口 | 状态 |
| --- | --- | --- | --- |
| ABAP-01 | T1 §2.15.1 数据建模、BOPF，PDF 物理页 203–205 | 可支持字典、CDS 与业务对象封装数据/逻辑的基础概念；采购业务对象与事务映射、精准 FPS 未证。 | 部分可证，目标 FPS 待核 |
| ABAP-02 | [SAP 7.56 SQL/游标关键字直接来源](abap-756-keyword-direct-m3.md)：Release 756（©2021），六页原文由研究者实读并有独立复核；含修订后的 FAE 分包与 CALL DIALOG 边界 | 可支持 INTO/APPENDING、PACKAGE SIZE、隐式/显式游标和提交/回滚的限定语义；不能推导所有系统会 dump 或分包能保证内存安全 | 目标系统 FPS、具体程序的内存/性能/并发、实际权限与异常仍未验证；来源不是系统实测 |
| ABAP-03 | T2 `Additional Details` | 支持 SQLMD 特定版本选项；ABAP debugger、SAT/ST05 权限、执行影响及实际跟踪仍待单独核验。 | 部分可证，文档版本字段 FPS00；系统适用性待核 |
| ABAP-04 | T3 通用事务模型；T5 特定 Dispute Management 场景；T16 ECC/R/3 SAP Support Additional Content（Work 与独立开发复核上下文直接读过）；[2021 PO 扩展页面](extension-2021-evidence-m3.md) | T16 仅有限支持 PO BAPI 对应、TESTRUN、SE37 测试序列（创建后提交）、X 结构及 RETURN/调试线索，且页面明示 Additional Content、ECC/R/3 背景、无目标版本选择器；2021 扩展页只支持自定义字段扩展。**不能拼接为 S/4HANA 2021 的函数级事务契约**。提交/回滚、更新任务、WAIT/RFC/LUW 和消息失败分支仍待直接证据。 | 辅助示例已直接读并独立复核；目标 BAPI 事务证据仍阻断 |
| ABAP-05 | T4 §3.4.2.1.2，物理页 85–86；T10 物理页 24 | T4 支持 FPS01 特定 BAdI 的增强用途；T10 仅支持对应 MRP 场景。其他增强点、发布 API 和各系统配置未证。 | 部分可证，FPS01 特定对象 |
| ABAP-06 | T5 PDF 物理页 158–159 | 指定 Dispute Management 场景分别有 RFC 对话调用和 BAPI 通信角色；不证明一般 RFC 事务、重试和幂等语义，也不能取代接口文档。 | 部分可证，FPS及接口级行为待核 |
| ABAP-07 | [2021 ABAP 工具事务码来源](abap07-tool-evidence-m3.md)：作者实读 SE37、ST22、SAT、SE11 和 ST05 对应页面；独立复核仅覆盖 SE37 与 ST22，ST05 页面为 FPS02，其他页面版本各有限定 | 可支持若干具体工具入口及页面所述只读/执行差异；dump 可按登录 client 等权限规则查看，SAT 与 ST05 用途不同 | SE80 未取得直接资料；其余页面的独立复核、权限对象、目标系统 FPS 与实际操作影响仍待核，不能把文档存在等同系统授权 |
| ABAP-08 | T4 §3.4.2.1.2，物理页 85–86 | 特定 `EXECUTE_ALGORITHM` BAdI 有明确 IMG 位置和业务条件；不能推断只读权限、所有增强点/其他 FPS 可用，更不执行配置。 | 部分可证，其他路径/权限待核 |
| ABAP-09 | T1 §2.15.1 `Data Modeling`，物理页 203 | 明确字典涉及类型、表、视图和锁对象；具体业务字段、键、发布接口、兼容视图和版本差异仍待逐项核。 | 部分可证，目标 FPS 待核 |
| S4HANA-01 | T1 §2.15.1，物理页 198 | ABAP Platform 建基于 HANA 平台；Fiori/Gateway 拓扑、安装、许可和版本组合未由该句完整证明。 | 部分可证，部署/FPS 待核 |
| S4HANA-02 | T2 `Additional Details` | 只能说明 SQLMD 诊断结果的过滤能力；执行计划、索引策略、性能结论必须按工具/真实数据另验。 | 部分可证，非性能实测 |
| S4HANA-03 | [2021 CDS/DCL 专题补查](cds-dcl-2021-evidence-m3.md)；T6 `Technical Details` | SAP 2021 初版 CDS 示例、DCL 与注解分别有原文；其中 DCL 示例与注解页已独立复读。T6 仅限 FPS01 的 SQL Service；各访问路径、具体服务/权限及实机仍待核。 | 部分可证，不代表全路径/系统通过 |
| S4HANA-04 | T1 §2.15.2 `SAP Gateway Foundation`，物理页 215；T8 `Technical Details`；T15 Gateway Authorization | T1 描述 Gateway 创建 OData 服务，T8 描述 Fiori/PFCG 指定集成；T15 据协调者阅读可支持 Gateway 根据发起用户的授权对象作检查，但不能证明具体服务的身份认证、授权对象、部署或发布状态。 | 部分可证，T15 有限描述已独立复核，安全细节待核 |
| S4HANA-05 | T1 §2.15.1 `RAP`，物理页 204 | 目标 2021 文档描述 RAP、CDS、OData 的架构与模型；此 2026 更新文档不足以证明所有列举能力在 FPS00 支持，须逐特性补目标 FPS。 | 部分可证，逐特性/FPS 待核 |
| S4HANA-06 | [2021 扩展与升级补查](extension-2021-evidence-m3.md)：特定 Key User 初版与 side-by-side FPS01 例子独立复核。 | 两个维护应用及特定 API 场景；升级指南持续更新，不能由个例推断全部接口契约、Clean Core 分层或免回归。 | 部分可证，架构政策/FPS 待核 |
| S4HANA-07 | T2 `Additional Details`；T8 `Technical Details` | 支持 SQLMD 和 PFCG 的特定说明；其他平台 T-Code、显示与修改权限及版本逐项查证。 | 部分可证，逐码待核 |
| S4HANA-08 | T8 `PFCG Integration`；T5 物理页 241；T15 Gateway Authorization | 文档分别讨论特定 Fiori 集成及 HCM 权限；T15 据协调者阅读解释 Gateway 根据发起用户的授权对象检查；不能推断 SAP API 一律采用相同角色、当前用户权限或配置查看入口。 | 部分可证，T15 有限描述已独立复核，接口及配置待核 |
| S4HANA-09 | T9 §12.6，物理页 285–286 | 可支持特定 COEP 04/11 值类型、ACDOCA 与兼容视图的说明；MATDOC 键、物理表关系、CDS/API 的发布及授权需另证。 | 部分可证，初版/FPS01/02 文档范围 |
| AI-Integration-01 | T11 `GOVERN 1–2`，物理页 27–28；T1 物理页 228 | 支持通用风险职责管理和 SAP 文档中的指定预测集成场景；不证明生成式 AI 已接入该 SAP 系统。 | 通用概念可证，SAP 接口/FPS 待核 |
| AI-Integration-02 | T13 `Abstract`、§1–2 | 支持论文研究的参数化和检索式非参数化记忆模型；权限隔离、来源有效性及 SAP 可用性需另行证明。 | 通用概念可证，权限/接口待核 |
| AI-Integration-03 | T14 `Abstract`、§2；T7 `Additional Details` | 支持研究中模型可选择调用工具/API，和特定 AIF 对象权限；不证明任何 SAP 写入已经获权，也不能证明幂等、审批或真实接口行为。 | 通用概念可证，SAP 接口/FPS 待核 |
| AI-Integration-04 | T12 `MS-2.7-005`，物理页 37；T5 物理页 241 | T12 提及控制/验证的风险评估，T5 描述 HCM 特定角色授权；并不规定通用身份透传、日志或所有 SAP 细节。 | 通用原则部分可证，具体身份/权限待核 |
| AI-Integration-05 | T12 附录 A.1.4，物理页 52–53；`MP-2.3`，物理页 28–29 | 支持事前测试、数据适用性及多种评估的风险管理建议；具体通过率、样本充分性与实际效果未证。 | 通用评估原则可证，实测未做 |
| AI-Integration-06 | T12 `GV-1.5`，物理页 20；T7 `Additional Details` | 支持生成式 AI 事故监控与 AIF 特定接口及权限概念；不证明所有 AI 集成均有统一 SAP 事务码或 AIF 组件。 | 通用运维原则可证，具体 SAP 入口待核 |
| AI-Integration-07 | T8 `PFCG Integration`；T12 `MS-2.7-005` 物理页 37；T15 Gateway Authorization | 分别支持 Fiori/PFCG 特定变化、AI 信息完整性控制评估，以及据协调者阅读的 Gateway 发起用户授权对象检查；具体接口服务账号、授权及只读配置需目标服务依据。 | 部分可证，T15 有限描述已独立复核，接口身份与配置待核 |
| AI-Integration-08 | T12 附录 A.1.6，物理页 55–56；T13 §1 | 可支持溯源元数据与 RAG 数据来源的概念；并未规定某 SAP 表、主键或虚构审计模型结构。 | 通用溯源可证，模型设计待证 |

## 阻断清单

1. **ABAP-04** 新增的 [SAP 2021 PO 扩展页面](extension-2021-evidence-m3.md) 只支持 BAPI_PO_CREATE1 自定义字段扩展这一功能，不包含该采购 BAPI 的事务协议；仍缺目标 S/4HANA 2021 特定提交、回滚、更新任务与消息语义的公开可读直接资料。T3 旧版资料不得冒充目标函数事实。
   补充来源：Work 与独立开发复核上下文直接读取 SAP [Purchasing BAPIs](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167428.html) 和 [BAPI_PO_CREATE1 采购订单示例](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167600.html)。两页均标有 Additional Content 声明并以 ECC/R/3 为背景；支持范围限于 BAPI/ME21N 对应、TESTRUN、SE37 示例的创建后提交序列、X 结构与 RETURN/调试提示。它们无 2021 版本选择器，不能证明目标版本函数级事务行为。此前其他 Function Module Test Sequence 页面在原研究上下文中打开零行的记录仍按当时结果保留，不等于这些新读页面。
2. T1/T5/T10 是 2021 产品系列持续更新文档，虽可读但不能直接证明 2021 初始版/FPS01/FPS02 的全部功能。目标系统 FPS 未知；逐条标记所需 FPS 和证据，不由本台账推断。
3. 26 个 ID 均有部分相关背景或子命题资料；部分仅为邻近背景，核心直接来源尚未完成；不少文章仍缺特定字段、接口、版本、授权、配置及异常的直接依据，不能宣称完整证据满足对应文章，也不自动等同 M3 出口要求全部达标。是否满足本项目 M3 每篇来源门槛由协调者结合具体范围和独立评审裁定。
4. 无公司 SAP 环境、生产数据和实机验证。本文只核对公开资料；不执行指南中的配置/开发步骤。

## 恢复用量后的独立复核

独立审查者 `/root/consultant_plan` 基于 PR #20 `0730c3fc66292c1ae22ff95a0d9b89847b930d70` 实际读取 T15 和 T16，并在当时根据 `Available As Of` 字段复核 T2 的修订。后续另一审查者发现页面底部还有标 FPS00 的 `Version` 字段，已由独立开发者复读；详见后续记录。T15 的 2021 Latest 页面可支持该授权检查概念，但不能推断特定服务角色。对 T16 的两篇 SAP Support Additional Content 页面，Work 与独立开发复核上下文在 2026-11-26 分别直接读取并确认其 ECC/R/3 背景、示例的有限内容及版本边界；不证明 S/4HANA 2021 采购 BAPI 事务契约。这些是 M3 来源交叉核验，不是正式文章审核。


## 追加技术来源（研究记录）

[技术证据补查](tech-followup-m3.md) 记录了 SAP 官方 2021 FPS01 Custom Code Migration Guide 关于运行时 SQL 检查和 SQL Monitor 的限定说明，以及原研究者当时尚未直接读到的 RAP 和采购 BAPI 线索；随后独立开发者已实读 2021 初版 RAP 特定功能和采购 BAPI 自定义字段扩展页面，但函数级提交/回滚语义仍缺。PDF 封面写 FPS01，不能凭 URL 中的 `.002` 将文档认作 FPS02。分包内存安全、RAP 逐功能和采购 BAPI 提交行为均未由该证据解决。

[采购 BAPI 定向补查](bapi-transaction-search-m3.md) 新发现第三方公开样章，以 S/4HANA 2021 FPS01 为特定示例讨论采购 BAPI 与 RAP 的事务边界；独立开发者已复核，但该样章并非 SAP 官方文档。2026 官方集成指南仅列接口暴露要求，不能据此推出调用或回滚语义。目标版本 SAP 官方直接依据仍未取得。

独立开发者后续通过浏览器读取 2021 初版 RAP 特性和 PO 扩展两页，[技术补查](tech-followup-m3.md) 已记录选择器、有限功能和边界；这不解决采购 BAPI 事务语义或 RAP 全部版本矩阵。
