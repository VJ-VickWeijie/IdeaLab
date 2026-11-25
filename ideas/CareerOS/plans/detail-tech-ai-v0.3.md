# CareerOS V0.3｜技术与 AI 逐篇策划提案（M1–M3）

状态：M0 已获用户批准；本文为后续联合评审材料，非已通过 M1/M2/M3，也非 M4 实施授权。ABAP、S4HANA、AI-Integration 的 26 个原矩阵 ID 保持不变，所有条目 planned，正式文章和三角色有效轮次均为零。下方路径均是相对 `ideas/CareerOS/` 的拟议目标，不表示文件已存在。无 SAP 访问或实机测试。

每条的验收须在下列专项断言外增加：中文释义和英文术语、3–5 分钟概览、虚构例子、前提与例外、适用/不适用的业务与会计影响、权限标签、精确版本及引用、相关知识链接、可选无系统练习、三个角色各 20 个有效闭环。本文只是规划与来源线索；逐个版本/功能、授权、事务及路径必须在正文写作时验证，不可从目录入口推断 2021 已支持。配置查看仅在用户获授权的环境中考虑；任何激活、跟踪、采集、修改、测试负载均需另行授权，不能将“查看入口”理解成可在生产操作。

## 证据入口与版本标签

证据记录须区分四个层级，不能相互替代：①**可检索**：能在搜索索引发现页面或摘要；②**可读**：取得并阅读原页面正文；③**版本适用**：正文中目标产品、发行版、FPS 及其前置条件与文章主张匹配；④**支持具体主张**：正文相关段落直接支持所写的具体事实、字段、接口和限制。只有逐项完成③④，才可作为相应事实的版本证据；实机测试另记。下列地址是策划线索，未逐篇完成③④。

- **S1—官方产品入口**：[SAP 2021 ABAP Platform 文档入口线索](https://help.sap.com/docs/SLTOOLSET/977b323808d0440a9c9fc9bed19a0861/6bec8c7fc640430a88c48fb424a9a151.html?locale=en-US&state=PRODUCTION&version=CURRENT_VERSION_SWPM20)；本次可检索，但独立开发评审尝试打开时未取得可读正文，故只能作索引线索。后续需取得正文、选择产品和 2021/FPS 后逐条核对；不可用作具体功能证明。
- **S2—SQL/内表历史线索**：[ABAP 数据库访问文档，NetWeaver 7.52](https://help.sap.com/docs/SAP_NETWEAVER_AS_ABAP_752/7bfe8cdcfbb040dcb6702dada8c3e2f0/2bde88b3f2254766ac223ee300ae99ac.html?locale=en-US&state=PRODUCTION&version=7.52.13)；较早版本，仅帮助定位概念，必须转查 2021 关键词文档。
- **S3—调试/性能官方线索**：[原 SQL Monitor 条目](https://help.sap.com/docs/PRODUCTS/66906ae3920c4fc684cf588290fb9267/b370bcd2f756469fb83ec418797550ee.html)本次可检索，但独立开发评审打开未取得可读正文；[SAP 可读替代页](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/b370bcd2f756469fb83ec418797550ee.html)仅涉及 SQLMD 的版本变化，不可扩张证明 SAT/ST05/SQLM 的一般权限或行为。具体文章主张及 2021 适用性仍须逐条核查。
- **S4—事务模型线索**：[BAPI 事务模型](https://help.sap.com/SAPHELP_SCM700_EHP02/helpdata/EN/4d/5b102ba1483d8fe10000000a42189e/content.htm?no_cache=true)；独立评审取得可读正文，但属于旧版资料；须检查目标 2021 和所选 BAPI 自身文档及例外，不能单凭可读断定 2021 适用。
- **S5—增强线索**：[ADT 3.20 增强文档发布说明](https://help.sap.com/docs/abap-cloud/abap-development-tools-for-eclipse-release-notes/release-notes-of-abap-development-tools-3-20)：本次可检索，但独立开发评审未取得可读正文，仅作索引；目标版本、具体 BAdI、工具能力均待查证。
- **S6—CDS 版本线索**：[CDS 自定义视图前提](https://help.sap.com/docs/ABAP_PLATFORM_2020/b5670aaaa2364a29935f40b16499972d/4356ae3e6a994e119c0532abef91366b.html?locale=en-US&state=PRODUCTION&version=202110.latest)；本次可检索，但独立开发评审未取得可读正文，仅作索引；目标版本及 DCL、授权、字段和限制均待查证。
- **S7—RAP 2021 线索**：[RAP 的 ABAP Platform 2021 FPS00 新增入口](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/de-DE/7b66b9e7cdb5433a82633e650b337207.html)：独立评审取得可读正文；页面指向相应版本的发布说明，不等于现在所有 RAP 功能在 2021 均支持；各具体功能与补丁范围须另核。
- **S8—OData 权限线索**：[2021 FPS02 入站 OData 角色配置实例](https://help.sap.com/docs/ABAP_PLATFORM_NEW/a602ff71a47c441bb3000504ec938fea/2dc7493959bb4e18a91eb8c225647884.html?locale=en-US&version=202110.002)：特定 Workflow 服务，不能推广到所有服务，也不得执行其中创建角色的步骤。
- **S9—S/4 模型线索**：[2021 Simplification List](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)；须按章节、使用前提和补丁核对；[物料凭证归档说明](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/8308e6d301d54584a33cd04a9861bc52/75bcb6531de6b64ce10000000a174cb4.html)当前默认版本，2021 待核验。
- **S10—一般 AI 风险**：[NIST AI RMF 1.0](https://www.nist.gov/publications/artificial-intelligence-risk-management-framework-ai-rmf-10)（2023），[NIST 生成式 AI Profile](https://www.nist.gov/publications/artificial-intelligence-risk-management-framework-generative-artificial-intelligence)（2024）；为通用框架，不证明 SAP 功能。
- **S11—通用 RAG 研究**：[Retrieval-Augmented Generation 原始论文](https://arxiv.org/abs/2005.11401)；用于 RAG 方法背景，不证明任何 SAP 产品、模型效果或部署许可。
- **S12—较新产品对照入口**：[SAP ABAP Cloud 语言版本](https://help.sap.com/docs/abap-cloud/abap-cloud/abap-language)；以页面版本核对，不能把新版语言能力倒推 S/4HANA 2021。Clean Core 是架构方向，实际允许的扩展和发布 API 分产品及版本验证。

下表来源栏以 S 编号对应上述具体链接。标记“待核 2021”表示只完成来源线索定位，未完成该文章全部技术断言的版本核验。路径、关联与验收是计划，不代表文章已创建。**原列名“依赖”现统一改为“关联文章”**，仅用于主题互链，不是实施或阅读硬前置：例如 ABAP-02 与 S4HANA-02、ABAP-06 与 S4HANA-04 可相互参考而不互相阻塞；真正的批次硬依赖由整体实施计划另行定义并做无环检查。

## ABAP：9 篇

| ID、标题 | 拟定路径 | 核心范围、前提与例外 | 关联文章 | 来源及 2021 核验 | 可操作验收 |
| --- | --- | --- | --- | --- | --- |
| ABAP-01 业务对象基础 | `knowledge/ABAP/01-foundations/business-objects.md` | 虚构采购需求如何映射对象、字段、程序与事务；区分界面、持久化与业务规则，不假设一个事务等于一个表。 | MM-01、PROCESS-01 | S1、S9；对象及术语待核 2021 | 用单据图解释对象边界，至少一条权限及版本限制；不需 SAP。 |
| ABAP-02 SQL、内表和内存 | `knowledge/ABAP/02-functions/sql-internal-table-memory.md` | 多行读取、行宽/行数/驻留时间、过滤与分包的可选权衡；COUNT 与随后读取期间数据可能变化，行数阈值不能保证免 dump；不承诺捕获所有内存异常。 | ABAP-01、S4HANA-02 | S1、S2；语法、PACKAGE SIZE、异常待核 2021 | 虚构数据展示受限方案、估算及并发限制；没有实测就标资料验证。 |
| ABAP-03 调试与运行分析 | `knowledge/ABAP/02-functions/debug-runtime-analysis.md` | 从症状到调用栈、断点、性能/SQL trace 的取证选择；处理账号授权、生产敏感内容、性能和断点改变执行风险。 | ABAP-01、ABAP-07 | S1、S3；工具与权限待核 2021 | 给出脱敏样例与仅阅读/需授权分级，不声称已执行 trace。 |
| ABAP-04 BAPI 与 LUW | `knowledge/ABAP/02-functions/bapi-luw-commit.md` | 模拟采购订单调用、RETURN、提交/回滚、更新任务与锁；每个 BAPI 单独确认事务协议，少数例外不可套用通用模式。 | MM-04、ABAP-01 | S1、S4；所选 BAPI 和提交要求待核 2021 | 画成功、失败及提交失败分支；指出超时后不能凭重试判断是否已入账。 |
| ABAP-05 增强与扩展 | `knowledge/ABAP/02-functions/enhancements.md` | Enhancement Spot、BAdI、客户出口与选择边界；不保证所有扩展可发布或可在云版本使用；示例仅查看设计。 | ABAP-03、S4HANA-06 | S1、S5；具体增强点、释放状态待核 2021 | 对同一虚构需求解释何处验证增强与何时不采用，标实施需授权。 |
| ABAP-06 RFC 接口与幂等 | `knowledge/ABAP/02-functions/rfc-idempotency.md` | 同步/异步语义、消息与异常、超时未知结果、业务幂等键；区分重试与重复过账，按接口分别核准。 | ABAP-04、S4HANA-04 | S1、S4；具体 RFC、事务与回执待核 2021 | 给出模拟超时判定与重试状态机，验证不含真实企业数据。 |
| ABAP-07 事务码索引 | `knowledge/ABAP/03-tcodes/development-tools.md` | 规划 SE11、SE37、SE80、SAT、ST05、ST22 的用途、前提、可查看/需要授权；跨版本可用性待证。 | ABAP-03、ABAP-09 | S1、S3；逐码待核 2021 | 每项指向权威文章与文档，禁止将 trace 启用标为只读。 |
| ABAP-08 开发与增强配置 | `knowledge/ABAP/04-configuration/development-and-enhancement.md` | 展示开发对象/增强实现/传输相关的授权查看路径候选；系统设置、角色、传输和增强激活均非自动操作；精确入口待证。 | ABAP-05、ABAP-07 | S1、S5；配置项/权限待核 2021 | 每配置项映射行为、影响、授权和只读查看方式；无法验证即标待核。 |
| ABAP-09 字典与模型 | `knowledge/ABAP/05-data-model/data-dictionary.md` | 类型、数据元素、域、表、键和 CDS/接口的区别；示例区分物理表和兼容视图及发布状态。 | ABAP-01、MM-10 | S1、S9；关联与授权待核 2021 | 指明键、客户端和连接基数，使用虚构对象避免误传生产字段。 |

## S/4HANA：9 篇

| ID、标题 | 拟定路径 | 核心范围、前提与例外 | 关联文章 | 来源及 2021 核验 | 可操作验收 |
| --- | --- | --- | --- | --- | --- |
| S4HANA-01 2021 技术架构 | `knowledge/S4HANA/01-foundations/architecture-2021.md` | 应用、ABAP 平台、HANA、Fiori/Gateway、集成与部署边界；组件有安装/授权/版本前提。 | ABAP-01 | S1、S9；组件清单待核 2021 | 绘制分层图，标部署可选项，不将所有组件描述成默认启用。 |
| S4HANA-02 HANA 性能 | `knowledge/S4HANA/02-functions/hana-performance.md` | 数据库与应用层性能、过滤和数据搬运、执行计划；行数/索引影响依业务、基数和系统环境。 | ABAP-02、ABAP-03 | S1、S3；计划工具及版本待核 | 用虚构案例说明指标和诊断路径，区分没有跑过与实测。 |
| S4HANA-03 CDS 与权限 | `knowledge/S4HANA/02-functions/cds-and-access-control.md` | 建模、关联、消费和权限控制；区分 CDS 与 OData 服务权限、发布状态和访问方式。 | ABAP-09、S4HANA-01 | S1、S6；DCL、功能与 2021 语法逐条待核 | 使用虚构对象给关系和权限示意，不暗示 DCL 覆盖所有访问路径。 |
| S4HANA-04 OData 与治理 | `knowledge/S4HANA/02-functions/odata-interface-governance.md` | 服务提供者/消费者、版本、认证授权、错误处理、幂等与生命周期；Gateway 和 RAP 路径按组件与版本分别确认。 | S4HANA-03、ABAP-06 | S1、S8；具体服务、配置待核 2021 | 画请求/授权/响应/失败路径，区分标准 API 与自建接口。 |
| S4HANA-05 RAP 2021 | `knowledge/S4HANA/02-functions/rap-2021.md` | CDS、行为定义、服务的基本分层；将 2021 功能与当前云文档逐项拆开，明确 FPS 和未验证项。 | S4HANA-03、S4HANA-04 | S7、S12；逐 feature 核 2021 FPS | 清单每项给版本证据、前置组件及结论；不得通过最新版示例直接声称 2021 可运行。 |
| S4HANA-06 Clean Core | `knowledge/S4HANA/02-functions/clean-core-extensibility.md` | 内核升级与扩展边界；按目标版本比较经典增强、发布 API 和旁路集成；不要求 2021 本地具备后续 ABAP Cloud 全部能力。 | ABAP-05、S4HANA-01 | S1、S12；原则可参考新版，具体发布状态核 2021 | 同一模拟需求比较选项、代价、验证方法与不可确认项。 |
| S4HANA-07 技术事务码 | `knowledge/S4HANA/03-tcodes/platform-tools.md` | 计划覆盖版本查看、Gateway 服务检查、诊断入口；T-Code 与实际安装、权限、前后端部署相关，不写死可用性。 | S4HANA-01、ABAP-07 | S1、S8；逐码和权限待核 | 每项列用途、查看权限、影响、链接及无法访问替代方法。 |
| S4HANA-08 技术配置查看 | `knowledge/S4HANA/04-configuration/services-and-authorizations.md` | 服务注册与授权的候选只读检查；认证方式、服务角色与资源权限分开；绝不执行激活或生成角色。 | S4HANA-04、S4HANA-07 | S1、S8；仅可参考特定服务例子，通用配置待核 2021 | 配置→行为→查看入口→必要权限→风险逐条对应，找不到文档即保留待证。 |
| S4HANA-09 统一日记账和物料凭证 | `knowledge/S4HANA/05-data-model/journal-and-material-document.md` | 业务对象、通用日记账/物料凭证存储、兼容视图和 API 关系；业务分录依场景配置，旧对象不能笼统宣称消失。 | FI-11、MM-10、ABAP-09 | S9；每对象、键、兼容及 2021 访问约束待核 | 对假设数据给键与基数并注明接口释放状态及权限；无系统仅文档验证。 |

## SAP × AI：8 篇

| ID、标题 | 拟定路径 | 核心范围、前提与例外 | 关联文章 | 来源及 2021 核验 | 可操作验收 |
| --- | --- | --- | --- | --- | --- |
| AI-Integration-01 集成基础 | `knowledge/AI-Integration/01-foundations/sap-ai-boundaries.md` | SAP 数据源、服务边界、模型和用户；公开资料、模拟数据、授权范围与不能替代业务审批。 | S4HANA-04 | AI 风险 S10；SAP 接口 S1/S8 待核 2021 | 给出数据流及明确禁止输入的未授权企业数据，标未接入实测。 |
| AI-Integration-02 RAG | `knowledge/AI-Integration/02-functions/retrieval-augmented-generation.md` | 授权入库、切分、索引、检索、出处和生成；检索不到或知识过期须拒答，不能假设向量搜索天然有权限隔离。 | AI-Integration-01、AI-Integration-04 | RAG 概念 S11；SAP 接口 S1 待核 2021 | 用公开资料给虚拟查询与引用，列检索/权限失败的期望行为。 |
| AI-Integration-03 工具调用与 SAP API | `knowledge/AI-Integration/02-functions/tool-calling-sap-api.md` | 模型提议、业务授权、API 边界、参数校验、幂等、审批；只读检索与写操作单列，工具调用不自动授予写权限。 | S4HANA-04、ABAP-06、AI-Integration-01 | 一般风险 S10；具体 SAP API S1/S8，版本及释放状态待核 | 给无 SAP 模拟调用流程与失败分支；不运行写入或调用实际企业服务。 |
| AI-Integration-04 权限与审计 | `knowledge/AI-Integration/02-functions/permissions-privacy-audit.md` | 身份透传/服务账户、最小权限、秘密管理、文档权限、留存、审计；不能保证一种结构适用所有部署。 | AI-Integration-01、S4HANA-08 | 一般 AI 风险 S10；SAP 授权 S8，场景前提待核 | 虚拟敏感文档做访问矩阵、越权测试计划和审计字段，不含实际账号。 |
| AI-Integration-05 效果与人工复核 | `knowledge/AI-Integration/02-functions/evaluation-and-human-review.md` | 测试集覆盖、证据一致性、权限负例、过期内容、拒答、风险分级和人工复核；指标非现实生产保证。 | AI-Integration-02、AI-Integration-03 | S10、S11；评估方法自定义，非 SAP 2021 功能断言 | 定义模拟样本、检查方式、失败门槛和人工处理；不将计划写成测试结果。 |
| AI-Integration-06 运维入口 | `knowledge/AI-Integration/03-tcodes/integration-operations.md` | 按实际接口类型列 SAP 服务运行/日志可能入口及权限；AI 平台独立运维，若无统一 SAP T-Code 说明不适用。 | S4HANA-07、AI-Integration-03 | S1、S8；每项事务和组件待核 2021 | 条目写明组件、用途、所需授权与导航；不得为填表创造事务码。 |
| AI-Integration-07 配置与授权查看 | `knowledge/AI-Integration/04-configuration/integration-authorizations.md` | 用户/服务身份、连接及接口授权查看的候选检查；不把配置展示或启用流程作为可执行生产操作。 | AI-Integration-04、S4HANA-08 | S8 为特定服务示例；具体配置项和只读入口待核 2021 | 每项列配置→行为→已获授权时查看→风险；不可用时保留未验证。 |
| AI-Integration-08 数据模型与证据链 | `knowledge/AI-Integration/05-data-model/knowledge-audit-model.md` | 虚构文档 ID、版本、权限、检索片段、回答、引用及审计关系；角色/用户敏感标识最小化，不能把模型当 SAP 表。 | AI-Integration-02、AI-Integration-04、ABAP-09 | 一般 AI 风险 S10、RAG S11；SAP 接口相关字段另核 S1/S8 | 给实体关系、唯一键、来源追踪及删除/过期和越权处理假设。 |

## 尚待解决的 M3 门槛

1. 本文逐条列出了来源方向，但大量技术断言、T-Code、配置只读入口、具体 API 及目标系统 FPS 仍未验证；稿件编写前后需逐项追踪，未证实不得标为 reviewed/accepted。
2. 路径是拟建文件，未生成可点击正文链接；导航文章亦暂纳入正式文章 60 轮门槛。若增减、合并文章，记录完整范围和审批影响。
3. 文章有业务/会计场景时链接唯一业务流程主文；对不适用的价值流、物流、资金流在正文解释原因，不能虚构凭证。
4. 三角色能力及是否真正独立需每轮按实际记录；任何缺失、复验不全的轮次为零，不能把本次计划审阅计入正式文章。

## 逐篇主题证据补充（2026-11-25 检索记录）

追加线索（2026-11-25）：[SAP Gateway Foundation Security Guide，索引标示 2021 Latest](https://help.sap.com/docs/ABAP_PLATFORM_NEW/68bf513362174d54b58cddec28794093/535d22518bc72214e10000000a44176d.html?version=202110.latest) 的搜索抓取可见认证、授权等目录内容，但在当前环境直接打开返回零行；可用于后续查找 S4HANA-04 的版本资料，尚不能计为可直接读取、可复现的完整证据。[SAP Purchasing BAPIs](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167428.html) 与 [SAP ABAP FAQ](https://help.sap.com/docs/SUPPORT_CONTENT/abapfaq/3353523514.html) 搜索抓取分别出现采购 BAPI 提交和分包读取的线索，但直接打开同样零行、目标 2021 适用性未逐项确认；不可标为 ABAP-02/04 已验证。

本节按页面**实际打开得到的正文**记录证据，并区分目标版本和具体主张。部分 SAP Help 动态页在搜索中显示标题和内容，但打开返回零行；这些页面在本次工具环境下只算索引线索，不能说已读。`可读` 仅表示本次阅读获得页面正文，不表示整篇文章或目标版本已验证；真实系统、配置和授权均未验证。以下每行是已定位的部分证据而非文章全部依据。每次写入正文时应重新核对来源版本和精确原文；未覆盖部分保持待核验。

| 文章 | 官方/权威直接主题来源及阅读状态、版本 | 正文可支持的有限内容 / 未覆盖项目 |
| --- | --- | --- |
| ABAP-01 | [SAP ABAP Development User Guide](https://help.sap.com/doc/7c0dc3673ea54d5c97c34f87e2d87c55/Dev/en-US/abap_dev_user_guide_EN.pdf)：**正文可读**；ADT 3.16、AS ABAP 7.55 FPS01，旧版。 | 文档包含开发对象、包和对象浏览；2021 采购对象、事务与表对应关系仍待目标版本和业务对象的权威资料，不能把 ADT 对象等同采购业务对象。 |
| ABAP-02 | [SAP 数据库访问](https://help.sap.com/docs/SAP_NETWEAVER_AS_ABAP_752/7bfe8cdcfbb040dcb6702dada8c3e2f0/2bde88b3f2254766ac223ee300ae99ac.html?locale=en-US&state=PRODUCTION&version=7.52.13)：本次**可检索，打开返回零行**；NetWeaver 7.52，非 2021。 | 索引线索涉及 SELECT 和内表，不能作为已读正文或 2021 内存保证；`PACKAGE SIZE`、并发、内存保护及异常需找 2021 原文。 |
| ABAP-03 | [SQL Monitor](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/b370bcd2f756469fb83ec418797550ee.html)：**正文可读**；ABAP Platform 2021 FPS00。 | SQLMD 的 Joins/Cross Node Joins 及 Resolved 范围变化；不证明调试授权，也不代表执行过 trace。2021 调试权限候选 [Starting ABAP Debugger](https://help.sap.com/docs/ABAP_PLATFORM_NEW/ba879a6e2ea04d9bb94c7ccd7cdac446/a419aa9c58c2473bb4e3ae3c2a00b7b8.html?version=202110.002) 搜索可见但打开正文零行，待核。 |
| ABAP-04 | [Transaction Model for Developing BAPIs](https://help.sap.com/SAPHELP_SCM700_EHP02/helpdata/EN/4d/5b102ba1483d8fe10000000a42189e/content.htm?no_cache=true)：**正文可读**；旧 SCM 文档，2021 适用性待核。 | 旧文档讨论提交、回滚以及少数内置 COMMIT 例外；所选 2021 BAPI 与异常、提交要求须单独核对。 |
| ABAP-05 | [Operations Guide for SAP S/4HANA 2021](https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf)：**正文可读**；文档 11.0（2026-07-22），针对 S/4HANA 2021 SPS10，MRP 场景；该 BAdI 场景最早支持的 FPS/SPS 待核，不能据此证明 FPS00。 | `MD_ADD_ELEMENTS` 适用于文档列出的 MRP 评估和特定运行前提；不能据此推断全部 BAdI 在任何 MRP 模式中执行或属于发布 API。 |
| ABAP-06 | [BAPI Transaction Model](https://help.sap.com/SAPHELP_SCM700_EHP02/helpdata/EN/4d/5b102ba1483d8fe10000000a42189e/content.htm?no_cache=true)：**正文可读**，旧 SCM 文档；[SAP Application Interface Framework](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/d6dbbb13ef1f47398b7864bc6e1cd051.html)：**正文可读**，S/4HANA 2021 FPS01。 | 前者讨论 BAPI 事务提交；后者列出 AIF 特定功能模块授权对象。两者均不构成所有 RFC、重试或幂等行为的证明，具体接口需单查。 |
| ABAP-07 | [SQL Monitor](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/b370bcd2f756469fb83ec418797550ee.html)：**正文可读**；ABAP Platform 2021 FPS00。 | 文档涉及 SQLMD 和特定功能；SE11/SE37/SE80/SAT/ST05/ST22 各自版本、操作影响及授权仍需逐码独立来源。 |
| ABAP-08 | [SAP S/4HANA 2021 运维指南](https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf)：**正文可读**；文档 11.0（2026-07-22），针对 S/4HANA 2021 SPS10；具体功能最早支持的 FPS/SPS 待核，不能据此证明 FPS00。 | 含一个 MRP BAdI 适用场景；不提供通用增强配置的只读入口或当前系统授权，需补逐项依据。指南含修改步骤，仅阅读，不执行。 |
| ABAP-09 | [SAP ABAP Development User Guide](https://help.sap.com/doc/7c0dc3673ea54d5c97c34f87e2d87c55/Dev/en-US/abap_dev_user_guide_EN.pdf)：**正文可读**；ADT 3.16 / 7.55，旧版。 | 包含 ADT 开发对象与字典编辑器相关内容；2021 的域、数据元素、兼容视图与键仍需目标版本来源。 |
| S4HANA-01 | [Operations Guide for SAP S/4HANA 2021](https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf)：**正文可读**；文档 11.0（2026-07-22），针对 S/4HANA 2021 SPS10；具体功能最早支持的 FPS/SPS 待核，不能据此证明 FPS00。 | 可用于该指南涉及的运维和组件场景；不等于完整部署架构或证明所有组件已安装，须另补产品架构图和部署前提。 |
| S4HANA-02 | [SQL Monitor](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/b370bcd2f756469fb83ec418797550ee.html)：**正文可读**；ABAP Platform 2021 FPS00。 | 支持 SQLMD 新增选项的有限内容；优化原则、执行计划、数据量及基准结果仍需独立证据与真实测量。 |
| S4HANA-03 | [SQL Services](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/fb161b7df730447c9a7f461c500043ec.html)：**正文可读**；ABAP Platform 2021 FPS01。 | 仅支持特定 SQL service 将 CDS view entity 暴露给 ODBC 客户端且只读；不能证明所有 CDS 访问均只读、DCL 通用适用或语法适用。 |
| S4HANA-04 | [SAP Application Interface Framework](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/d6dbbb13ef1f47398b7864bc6e1cd051.html)：**正文可读**；S/4HANA 2021 FPS01。 | 描述 AIF 特定接口监控/错误处理及若干函数的授权对象；不是通用 OData 认证或所有 API 的证据。 |
| S4HANA-05 | [RESTful Application Programming Model](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/de-DE/7b66b9e7cdb5433a82633e650b337207.html)：**正文可读**；指向 2021 FPS00。 | 可证明 SAP 在该版本发布 RAP 相关入口；无法单凭入口断定 managed/unmanaged、UI 或其他具体功能均支持。各特性仍须精确原文。 |
| S4HANA-06 | [SAP ABAP Development User Guide](https://help.sap.com/doc/7c0dc3673ea54d5c97c34f87e2d87c55/Dev/en-US/abap_dev_user_guide_EN.pdf)：**正文可读**；旧 ADT 3.16/7.55。 | 文档涉及开发对象及 released objects 浏览；不能以此证明 2021 Clean Core 政策或具体扩展/API 发布状态，须另核。 |
| S4HANA-07 | [SQL Monitor](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/b370bcd2f756469fb83ec418797550ee.html)：**正文可读**；ABAP Platform 2021 FPS00。 | 只支持 SQLMD 相关新增项；其余事务码、实际安装和权限逐项待核。 |
| S4HANA-08 | [PFCG Integration](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/e6b26131fe4e43779b4141e191da6b07.html)：**正文可读**；ABAP Platform 2021 FPS00。 | 描述 Fiori Launchpad 与 PFCG 集成的特定变化；不能外推所有 API 的授权，也不意味着允许创建或调整角色。 |
| S4HANA-09 | [SAP S/4HANA 2021 Simplification List](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)：**正文可读**；文档版本 1.25，2021 初版及 FPS1、FPS2。 | 第 285–286 页（PDF 页索引 284–285）讨论 COEP 部分实际值迁入 ACDOCA、其他值类型及兼容视图；第 226 页讨论资产会计相关兼容视图。不能外推所有值类型或业务表；MATDOC 键、具体 API 与业务授权仍须独立核验。 |
| AI-Integration-01 | [NIST AI RMF 1.0](https://www.nist.gov/publications/artificial-intelligence-risk-management-framework-ai-rmf-10)：**正文可读**；2023、通用 AI 框架。 | 可用于 AI 风险治理的背景；不证明 SAP 2021 接口、权限或 AI 功能。 |
| AI-Integration-02 | [Retrieval-Augmented Generation for Knowledge-Intensive NLP Tasks](https://arxiv.org/abs/2005.11401)：**摘要可读**；论文 2020、2021 修订。 | 摘要描述结合参数化与非参数化记忆的 RAG 研究；不能据此保证权限、可引用性或 SAP 功能。实现与 ACL 需另找直接证据。 |
| AI-Integration-03 | [SAP Application Interface Framework](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/d6dbbb13ef1f47398b7864bc6e1cd051.html)：**正文可读**；S/4HANA 2021 FPS01。 | 可支持 AIF 特定功能与授权对象说明；不支持模型工具调用协议、写入审批、幂等保证或具体业务 API，均待专门资料。 |
| AI-Integration-04 | [NIST 生成式 AI Profile](https://www.nist.gov/publications/artificial-intelligence-risk-management-framework-generative-artificial-intelligence)：**正文可读**；NIST AI 600-1（2024）。 | 页面说明其为生成式 AI 风险管理框架补充；数据权限透传、日志实现及 SAP 2021 细节须另证。 |
| AI-Integration-05 | [NIST 生成式 AI Profile](https://www.nist.gov/publications/artificial-intelligence-risk-management-framework-generative-artificial-intelligence)：**正文可读**；NIST AI 600-1（2024）。 | 支持将风险管理贯穿设计、使用与评估的方向；不能凭框架直接给出特定通过率、实际评测或模型准确性。 |
| AI-Integration-06 | [Operations Guide for SAP S/4HANA 2021](https://help.sap.com/doc/6c3b63ec437f421cbfd92d10131cd685/2021/en-US/OPS_OP2021.pdf)：**正文可读**；文档 11.0（2026-07-22），针对 S/4HANA 2021 SPS10；具体功能最早支持的 FPS/SPS 待核，不能据此证明 FPS00。 | 在 Central Procurement hub 特定场景介绍 AIF 的 XML 监控及角色前提；不证明所有 AI 集成均使用 AIF 或适用同一角色。 |
| AI-Integration-07 | [PFCG Integration](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/e6b26131fe4e43779b4141e191da6b07.html)：**正文可读**；ABAP Platform 2021 FPS00。 | 只支持 Fiori Launchpad 与 PFCG 的有限集成信息；实际接口账号、权限和查看入口需查所用产品与服务。 |
| AI-Integration-08 | [RAG 原始论文摘要](https://arxiv.org/abs/2005.11401)：**摘要可读**；2020/2021；[NIST 生成式 AI Profile](https://www.nist.gov/publications/artificial-intelligence-risk-management-framework-generative-artificial-intelligence)：**正文可读**；2024。 | 前者提供检索生成背景，后者提供风险管理背景；均不规定本文虚构审计数据模型的实体键，模型设计与验证标准仍是提案。 |
