# CareerOS V0.3｜FI / CO 与课程逐篇实施规划草案

状态：M0–M2 及 99 篇范围基线已获批准，M3 继续补充资料且尚未通过，M4 尚未获批。以下为 26 篇正式文章的规划，不是文章正文；每篇状态均为 planned，读者/顾问/开发者有效正式审核均为 0/0/0。目标路径相对 `ideas/CareerOS/`，尚未创建；课程中使用 ID 而非指向不存在文件的链接。原路线仍以 [roadmap-v0.1.md](roadmap-v0.1.md) 为基线；每周 4–5 次、每次 30–60 分钟作为可调整的建议上限，不是强制要求，实际以工作许可、家庭时间与精力为准。

> **来源限制记录（2026-11-25）**：本次研究曾读取 OpenStax 财务及管理会计章节，随后发现其页面对未经许可用于生成式 AI/AI offerings 有限制提示。已读取事实如实保留；AI 使用许可及其具体适用性待确认，后续停止读取或以其作为生成依据。先前所列 OpenStax 主题来源已替换为已读 SEC 教育资料或明确标为缺口；详情见 [FI/CO 证据登记](evidence-finance-m3.md)。此记录不对法律适用作最终判断。

## 证据目录与使用边界

以下为**已检索到的官方入口和线索，而非本计划已逐条证明全部业务主张**。F1 的 latest URL 出现版本漂移，旧版缓存未留存可验证快照，不能作为固定证据；F2 的 PDF 正文可读取。本次尝试直接打开 F3–F8 页面未取得可读正文，其标题、版本与摘要来自搜索索引，需后续重新核验原文后才能作为事实依据。正文须按具体主张补充可访问、可定位章节、目标产品及 2021 FPS 的依据，证明不了即列待核实，阻止文章审核通过。特别注意 `version=2021.000` 是初始发行文档，不能声称已验证全部后续 FPS，实际生产系统 FPS 未知。

| 引用 ID | 原厂资料 | 作用与限制 |
| --- | --- | --- |
| F1 | [SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 2021 产品范围入口，但 latest 地址不固定：曾检索到文档 9.0（2025-07-23），2026-11-25 重新打开为 11.0（2026-07-22）；旧版未保留可校验快照，不能稳定复验。仅作检索线索，需另寻稳定版本并逐项验证目标 FPS。 |
| F2 | [SAP S/4HANA 2021 Simplification List](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf) | 初始、FPS01、FPS02 的简化事项，作为 FI/CO 数据模型和 ECC 差异检索入口；按具体章节和生效版本核验。 |
| F3 | [GR/IR Automatic Clearing，2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/d57abfc6bcf644938dd7c4e12e152ff6.html?version=2021.000) | 检索摘要提到三种清账执行模式；原文尚未读取，仅作待核验线索，不能以此证明具体模式、所有收货/发票分录或配置。 |
| F4 | [Supplier Invoices for Purchase Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMI-SE/af9ef57f504840d2b81be8667206d485/be5eb6531de6b64ce10000000a174cb4.html) | 采购发票与 GR/IR 业务线索；页面默认版本需确认、定位 2021，不能直接据此证明 2021 细节。 |
| F5 | [2021 内部订单更改日志](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/00ec2c96762d4587b976248bf2f4f12c.html?version=2021.000) | 可追溯的 2021 特定应用线索，不代表内部订单全部机制。 |
| F6 | [2021 成本要素组应用](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/daad5c6c4d764c2baa25b93a9fab7d82.html?version=2021.000) | 2021 特定成本要素组应用线索，不能代替成本要素原理或配置文档。 |
| F7 | [2021 生产成本延迟汇总](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b8102751e57e4de2ad50ec07253127e0.html?version=2021.000) | 特定配置下的 ACDOCA/ACDOCD 案例，不代表所有生产成本场景。 |
| F8 | [2021 COGS Split 特定应用](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f2bb8fe1f6c046a7a00797ddc02149f6.html?version=2021.000) | 利润分析关联的特定可配置场景；不代表所有利润分析都执行成本拆分。 |

验证原则：所有术语/事务代码/表及字段清单须再核验每条作用、只读属性、授权、发行版和现场配置；表、兼容视图、CDS、已发布 API 分别标记；资料核验与系统实测分别记录，禁止未经授权操作企业系统。涉及税、货币、期间、公司代码、库存评估和实际分录的每个案例标出假设。

## FI：11 篇候选文章

表内其他文章 ID 均为建议进一步阅读或知识关联，并非实施或开始阅读的硬先修；真正的读者入门先修与顺序见下方课程和月度计划。

| ID / 目标路径 | 阅读先修/知识关联、内容、场景和边界 | 来源与验收 |
| --- | --- | --- |
| FI-01 `knowledge/FI/01-foundations/financial-accounting-for-beginners.md` | 零先修；区分企业业务事件、实物、凭证、价值及资金，采用虚构采购；解释只创建订单/已付款可能是不同事件。 | F1 找总账/应付章节；阅读者能将一笔买卖按六列分类，标识未发生的流。 |
| FI-02 `knowledge/FI/01-foundations/accounting-equation.md` | FI-01；资产/负债/权益和会计等式，覆盖现金购买及赊购，不混淆企业和个人账。 | F1 查财报术语、辅以公开会计基础资料并标地区；用虚构金额保持等式平衡，答案可复验。 |
| FI-03 `knowledge/FI/01-foundations/debit-credit.md` | FI-02；计划先解释账户类别，再讲借贷及复式；账户具体变动方向和反例仍须独立来源核验。 | 已读 IRS 复式记账和通常余额方向资料，详见证据登记；具体增减方向/地区适用/SAP场景仍缺依据，禁止使用已暂停的 OpenStax 作为生成依据。 |
| FI-04 `knowledge/FI/02-functions/company-code-gl.md` | FI-03；公司代码、会计科目表、总账科目与组织关系；跨公司账独立前提，区别科目定义与余额。 | F1/F2 查组织与总账；完成组织→科目→凭证映射图与条件表。 |
| FI-05 `knowledge/FI/02-functions/posting-reversal.md` | FI-04；会计凭证、日期/期间、过账和冲销；区分更正原始业务、关联凭证，避免称所有凭证均可直接冲销。 | F1/F2 查凭证和版本；虚构凭证借贷平衡、识别原因及期间/权限约束。 |
| FI-06 `knowledge/FI/02-functions/payables-receivables.md` | FI-03～05；应付应收、未清项/清账、付款/收款；区分发票入账与资金支付、部分支付和差异/税币前提。 | F1/F2 查 AR/AP；一笔赊购及赊销各画事件、凭证、价值与资金表，余额自洽。 |
| FI-07 `knowledge/FI/02-functions/inventory-valuation-grir.md` | FI-03～06、MM-05/06、PROCESS-01；库存估价、GR/IR 与采购联动；区分库存/消耗、估价/非估价、先票后货、价格及数量差异；结合 PROCESS-01 分别核验成本中心、资产、内部订单采购的分配对象及实际产生的凭证，不一概归费用；税与分录依场景/配置。 | F3/F4 + 按主张补 2021 自动科目确定；场景逐事件注明实际资金是否变化，条件化分录借贷平衡，不声称通用。 |
| FI-08 `knowledge/FI/02-functions/period-close-reporting.md` | FI-04～07；期间、未清项核对、结账与报表的业务目的，区分模拟、真实过账、开关期间；不把当地会计/税规则当统一标准。 | F1/F2 查财务关账；提供可复核虚构期间结账检查表，与 PROCESS-07 互链。 |
| FI-09 `knowledge/FI/03-tcodes/finance-transactions.md` | FI-04～08；按总账、凭证、往来与报表建立入口索引；每项核对显示/更改、版本、权限、目标输入与输出，缺权限提供离线替代。 | F1/F2 + 2021 针对每事务的原厂页面；索引与 FI-10 单向指向唯一配置正文，断链检查。 |
| FI-10 `knowledge/FI/04-configuration/finance-config-observation.md` | FI-04～08；组织、科目、过账期间、自动科目与收付款配置，逐项写“配置因素→业务行为→只读检查入口→前提”；不修改配置。 | F1/F3 + 2021 对应 IMG 节点资料；逐行提供精确来源、权限和版本；检查先票/非估价条件。 |
| FI-11 `knowledge/FI/05-data-model/accounting-document-model.md` | FI-04～07、S4HANA-09；会计凭证头/项目、总账及业务关联；候选 BKPF、ACDOCA 等须验证用途、键、基数、客户端、授权与接口释放状态，兼容视图单列。 | F2 按 FI 数据模型章节 + 字段级官方依据；虚构跨凭证查询关系及 2021/ECC 差异核对，不以表存在证明可写。 |

## CO：8 篇候选文章

| ID / 目标路径 | 阅读先修/知识关联、内容、场景和边界 | 来源与验收 |
| --- | --- | --- |
| CO-01 `knowledge/CO/01-foundations/cost-profit-basics.md` | FI-01～03；从企业预算、费用、成本对象及内部管理切入，区分 FI 外部核算和 CO 管理分析，说明口径会依配置与场景不同。 | F1/F2 核验适用边界；给虚构车间费用列外部/内部观察角度，不能称无例外。 |
| CO-02 `knowledge/CO/02-functions/cost-center-elements.md` | CO-01、FI-04；成本中心、成本要素及其与会计科目关系；期间、组织归属、主数据有效期和 S/4/ECC 差异。 | F2/F6 + 具体 2021 成本要素主数据文档；追踪一笔费用进入指定成本中心、核对前提。 |
| CO-03 `knowledge/CO/02-functions/internal-orders.md` | CO-01/02；内部订单适用场景、费用归集、预算与结算的关联；区分统计/真实订单、接收对象和设定，避免断言必有结算。 | F5 + 2021 订单类型/结算资料；虚构项目归集到接收方的事件、金额及条件。 |
| CO-04 `knowledge/CO/02-functions/product-cost-variance-settlement.md` | CO-01～03、PP-05/06；生产成本归集、计划/实际、差异和结算；说明成本核算方法、期间、在制品和评估前提，模块文引用 PROCESS-05。 | F1/F7 + 2021 产品成本核算与生产订单结算文档；条件化成本流及示例平衡，严禁 F7 证明全部场景。 |
| CO-05 `knowledge/CO/02-functions/profitability-fi.md` | CO-01/02、FI-06、SD-04；销售收入成本到利润分析，明确维度、估值、具体配置与 FI 关联，不将会计收益等同资金到账。 | F1/F2/F8 + 2021 利润分析文档；区别 FI 收入、成本、获利分析和收款事件。 |
| CO-06 `knowledge/CO/03-tcodes/controlling-transactions.md` | CO-01～05；索引成本中心、订单、产品成本及利润分析查看入口；每项核对查看与运行/过账权限，未验证不写成可用事实。 | F1/F5/F6 + 对每项 2021 事务/应用原厂来源；核查输出、前提、版本及指向 CO-07 配置的链接。 |
| CO-07 `knowledge/CO/04-configuration/controlling-config-observation.md` | CO-01～05；成本中心、成本要素、订单与结算规则、组织设置；逐项关联“配置→行为→只读入口→影响对象/前提”，不操作修改。 | F1/F2 + 具体 2021 IMG 资料；列权限与未验证项，禁止杜撰配置路径。 |
| CO-08 `knowledge/CO/05-data-model/controlling-data-model.md` | CO-01～05、FI-11；成本对象、FI/CO 数据模型、通用日记账及历史结构候选；验证主键、基数、组织范围、授权、兼容/物理对象及适用版本，避免泛化。 | F2/F7 + 2021 数据字典/官方模型；虚构成本对象到凭证关联，分别标出可证明与未验证字段。 |

## COURSE：7 篇候选课程导航

所有课程只计划引用通过相应门禁的知识库原文，文章不存在时明确显示“待建设”，不得生成失效的正式链接或把计划当可读内容；具体 ID→路径由对应工作包统一确认。每篇课程同样暂按 60 个有效正式审核闭环计算；目录阅读练习仅为自愿选择，未经许可不操作 SAP。

| ID / 目标路径 | 阅读先修/知识关联、内容和边界 | 引用与验收 |
| --- | --- | --- |
| COURSE-01 `learning/24-month-roadmap.md` | 零先修；沿用原路线的基线、深化、架构、AI、职业验证阶段，链接月度目标和可选练习；不能保证工作成果。 | roadmap-v0.1 + 下表 24 个月 + COURSE-02～07；每个阶段有可阅读原文或标待建，每季可调整。 |
| COURSE-02 `learning/first-purchase.md` | 零先修；5–10 分钟一笔采购，区分订单、收货、发票、付款；对应财务无基础，不在课程重复维护流程全文。先阅读 FI-01、MM-01 的入门概览及 PROCESS-01 的 3–5 分钟概览，完整流程留到第 2 月；如原文未建成，该课程标记待建设。 | FI-01、MM-01、PROCESS-01；虚构事件排序，参照来源原文给出答案。 |
| COURSE-03 `learning/finance-controlling-from-zero.md` | COURSE-02；按 FI-01→02→03→04→05→06→07→08→CO-01→02→03/04/05 排列，适配无财务基础。 | 各条标学习目标/时间/先修；练习借贷平衡和应付未清项，练习均可离线且有参考答案。 |
| COURSE-04 `learning/mm-qm-deepening.md` | COURSE-02、FI-01～03；采购组织、货源、单位、收货、质量检验、GR/IR、异常。 | MM-01～10、QM-01～08、FI-07、PROCESS-01/06/10/11；按先修、只读条件和理解题组织。 |
| COURSE-05 `learning/cross-module-processes.md` | COURSE-03/04；P2P、O2C、STO、生产、质量、R2R 及特殊场景。 | PROCESS-01～12；每一条引用唯一流程主文并标角色、单据、物流、财务/资金及异常提问。 |
| COURSE-06 `learning/abap-s4-architecture.md` | ABAP 基础、COURSE-04；调试、接口/增强、数据模型、HANA/CDS/OData/RAP/Clean Core；具体能力按 2021 发行和 FPS 核验。 | ABAP-01～09、S4HANA-01～09；给虚构案例诊断练习，实机只读/受授权时可选。 |
| COURSE-07 `learning/sap-ai-career-validation.md` | COURSE-06；RAG、权限、评估、SAP 接口和 AI 风险；职业作品只用模拟数据，不承诺就业。 | AI-Integration-01～08、COURSE-01；检查来源版本、许可、风险、审核及作品匿名化。 |

## 24 个月学习路线：建议排程，不代表成果已经存在

阶段与原路线一致：第 1 个月基线，第 2–3 个月 MM/QM 深化，第 4–6 个月技术架构，第 7–12 个月 AI 实践，第 13–24 个月职业验证。允许按工作和家庭情况调整；不存在的原文以 ID 标记待建设，引用前核对目标文章已审核。所有练习均可选、使用虚构或获授权数据。

下表每月 ID 是建议主题池，不要求逐篇、逐月全部读完。优先阅读所需先修和对应主题的入门概览，具体岗位相关内容选读；同一月份内按列出顺序阅读。下列“入门先修”说明何时开始主题；文章表的跨文 ID 是可返回阅读的知识关联，不自动构成入门门槛：

- 第 1 月 COURSE-02 的入门前提是 FI-01 和 MM-01 的概览，以及 PROCESS-01 的速览部分；第 2 月再阅读全文。课程引用原文，不另行维护完整流程。
- CO 入门先 FI-01～03；学习 CO-02 还需 FI-04；CO-03 建立在 CO-01/02 上。第 4 月按此顺序引入，CO-04 待第 15 月先读 PP-05/06 后再深入，CO-05 待第 13 月读 SD-04 后再深入；CO-08 数据模型待第 19 月补完 CO-05 后再读。
- 同月若读不完，以理解业务事件和一项可选练习为主，其余顺延，不以月末完成数量作为质量验收。

| 月 | 本月目标及拟读正文 ID | 可选练习 / 可验证产出 |
| --- | --- | --- |
| 1 | 先速览 [FI-01 财务会计从零：企业的钱和账](coverage-matrix-v0.3-proposal.md)、[MM-01 组织结构与采购业务对象](coverage-matrix-v0.3-proposal.md) 和 [PROCESS-01 P2P 采购到付款](coverage-matrix-v0.3-proposal.md) 概览，再读 [COURSE-02 入门：一笔采购的单据物流与资金流](coverage-matrix-v0.3-proposal.md) 和 [FI-02 资产、负债、权益与会计等式](coverage-matrix-v0.3-proposal.md)；[FI-03 借贷方向与复式记账](coverage-matrix-v0.3-proposal.md)、[MM-02 物料主数据与业务伙伴](coverage-matrix-v0.3-proposal.md) 选读；盘点技能 | 画一笔虚构采购与账户等式；个人能力清单只留私密位置。 |
| 2 | 先补 [FI-03 借贷方向与复式记账](coverage-matrix-v0.3-proposal.md)，再读 [PROCESS-01 P2P 采购到付款](coverage-matrix-v0.3-proposal.md) 全文、[MM-03 采购信息记录与货源决定](coverage-matrix-v0.3-proposal.md)、[MM-04 采购申请与订单机制](coverage-matrix-v0.3-proposal.md)、[MM-05 库存类型与移动类型](coverage-matrix-v0.3-proposal.md)、[FI-04 公司代码、会计科目与总账](coverage-matrix-v0.3-proposal.md)、[FI-05 会计凭证、过账与冲销](coverage-matrix-v0.3-proposal.md)、[FI-06 应付、应收与资金流](coverage-matrix-v0.3-proposal.md) | 对比订单、到货、发票与付款四种状态。 |
| 3 | 先读 [MM-06 收货、退货与冲销](coverage-matrix-v0.3-proposal.md)，再读 [QM-01 质量管理业务与组织对象](coverage-matrix-v0.3-proposal.md)、[QM-02 检验类型与检验批](coverage-matrix-v0.3-proposal.md)、[QM-03 检验计划与检验特性](coverage-matrix-v0.3-proposal.md)、[QM-04 结果记录与使用决策](coverage-matrix-v0.3-proposal.md)、[QM-05 质量库存与采购生产集成](coverage-matrix-v0.3-proposal.md)、[FI-07 库存估价与收货发票暂估 GR/IR](coverage-matrix-v0.3-proposal.md)、[PROCESS-06 来料检验到放行 Quality-to-Release](coverage-matrix-v0.3-proposal.md)；[COURSE-04 MM 与 QM 深化](coverage-matrix-v0.3-proposal.md) 作导航 | 写一份模拟检验及暂估差异排查图。 |
| 4 | 如 [FI-01 财务会计从零：企业的钱和账](coverage-matrix-v0.3-proposal.md)、[FI-02 资产、负债、权益与会计等式](coverage-matrix-v0.3-proposal.md)、[FI-03 借贷方向与复式记账](coverage-matrix-v0.3-proposal.md)、[FI-04 公司代码、会计科目与总账](coverage-matrix-v0.3-proposal.md) 仍有缺口先补基础，再读 [CO-01 管理会计从零：成本与利润](coverage-matrix-v0.3-proposal.md)、[CO-02 成本中心与成本要素](coverage-matrix-v0.3-proposal.md)、[CO-03 内部订单和费用归集](coverage-matrix-v0.3-proposal.md) 入门；[ABAP-01 ABAP 与业务对象基础](coverage-matrix-v0.3-proposal.md)、[ABAP-02 内表、SQL 与海量数据内存](coverage-matrix-v0.3-proposal.md)、[ABAP-03 标准流程调试与运行分析](coverage-matrix-v0.3-proposal.md)、[S4HANA-01 S/4HANA 2021 技术架构入门](coverage-matrix-v0.3-proposal.md)、[S4HANA-02 HANA 数据处理与性能分析](coverage-matrix-v0.3-proposal.md)、[MM-10 采购库存数据模型与单据关系](coverage-matrix-v0.3-proposal.md) 选读 | 用假数据说明性能/内存问题与可验证假设。 |
| 5 | [S4HANA-03 CDS 数据建模与权限](coverage-matrix-v0.3-proposal.md)、[S4HANA-04 OData 服务和接口治理](coverage-matrix-v0.3-proposal.md)；[ABAP-04 BAPI、LUW 与事务提交](coverage-matrix-v0.3-proposal.md)、[ABAP-06 RFC、接口、异常与幂等](coverage-matrix-v0.3-proposal.md)；[FI-11 财务凭证与总账数据模型](coverage-matrix-v0.3-proposal.md) | 画一个只读虚构业务对象和接口边界。 |
| 6 | [S4HANA-05 RAP 在 2021 的能力与限制](coverage-matrix-v0.3-proposal.md)、[S4HANA-06 Clean Core 与扩展策略](coverage-matrix-v0.3-proposal.md)；[ABAP-05 增强技术与可扩展性](coverage-matrix-v0.3-proposal.md)、[ABAP-08 开发与增强相关配置查看](coverage-matrix-v0.3-proposal.md)；[COURSE-06 ABAP 与 S/4HANA 技术架构](coverage-matrix-v0.3-proposal.md) | 设计一个无企业数据的小方案或可选演示。 |
| 7 | [AI-Integration-01 SAP 与 AI 集成基础及适用边界](coverage-matrix-v0.3-proposal.md)、[AI-Integration-04 权限、数据保护与审计](coverage-matrix-v0.3-proposal.md)；[S4HANA-04 OData 服务和接口治理](coverage-matrix-v0.3-proposal.md) | 列数据分类、许可、权限和审计边界。 |
| 8 | [AI-Integration-02 知识检索与 RAG 方案](coverage-matrix-v0.3-proposal.md)；[PROCESS-01 P2P 采购到付款](coverage-matrix-v0.3-proposal.md)；[MM-04 采购申请与订单机制](coverage-matrix-v0.3-proposal.md) | 用公开资料构造 5 个知识检索问题。 |
| 9 | [AI-Integration-03 工具调用与 SAP API 集成](coverage-matrix-v0.3-proposal.md)、[AI-Integration-07 集成配置与授权查看](coverage-matrix-v0.3-proposal.md)；[ABAP-06 RFC、接口、异常与幂等](coverage-matrix-v0.3-proposal.md) | 设计模拟接口与权限、失败和重试表。 |
| 10 | [AI-Integration-05 评估、幻觉控制和人工复核](coverage-matrix-v0.3-proposal.md)、[AI-Integration-08 AI 集成数据模型与证据链](coverage-matrix-v0.3-proposal.md)；[FI-07 库存估价与收货发票暂估 GR/IR](coverage-matrix-v0.3-proposal.md) | 设计答案溯源和错误样本评估集。 |
| 11 | [AI-Integration-06 AI 集成相关事务码与运维入口](coverage-matrix-v0.3-proposal.md)；[ABAP-03 标准流程调试与运行分析](coverage-matrix-v0.3-proposal.md)；[S4HANA-08 技术配置与服务只读检查](coverage-matrix-v0.3-proposal.md) | 用虚构日志设计观测和敏感信息过滤。 |
| 12 | [AI-Integration-01 SAP 与 AI 集成基础及适用边界](coverage-matrix-v0.3-proposal.md)、[AI-Integration-02 知识检索与 RAG 方案](coverage-matrix-v0.3-proposal.md)、[AI-Integration-03 工具调用与 SAP API 集成](coverage-matrix-v0.3-proposal.md)、[AI-Integration-04 权限、数据保护与审计](coverage-matrix-v0.3-proposal.md)、[AI-Integration-05 评估、幻觉控制和人工复核](coverage-matrix-v0.3-proposal.md)、[AI-Integration-06 AI 集成相关事务码与运维入口](coverage-matrix-v0.3-proposal.md)、[AI-Integration-07 集成配置与授权查看](coverage-matrix-v0.3-proposal.md)、[AI-Integration-08 AI 集成数据模型与证据链](coverage-matrix-v0.3-proposal.md)；[COURSE-07 SAP 与 AI 集成及职业验证](coverage-matrix-v0.3-proposal.md) | 整理模拟原型及验证报告，若条件不足则提交设计稿。 |
| 13 | [PROCESS-02 O2C 订单到收款](coverage-matrix-v0.3-proposal.md)；[SD-01 销售业务与组织结构](coverage-matrix-v0.3-proposal.md)、[SD-02 客户业务伙伴与物料主数据](coverage-matrix-v0.3-proposal.md)、[SD-03 销售订单与交货机制](coverage-matrix-v0.3-proposal.md)、[SD-04 定价、开票与应收集成](coverage-matrix-v0.3-proposal.md)；[FI-06 应付、应收与资金流](coverage-matrix-v0.3-proposal.md) | 画销售单据、库存、会计、资金各流。 |
| 14 | [PROCESS-03 同公司库存调拨 STO](coverage-matrix-v0.3-proposal.md)、[PROCESS-04 跨公司调拨 STO 与内部结算](coverage-matrix-v0.3-proposal.md)；[MM-05 库存类型与移动类型](coverage-matrix-v0.3-proposal.md)、[MM-06 收货、退货与冲销](coverage-matrix-v0.3-proposal.md)；[FI-07 库存估价与收货发票暂估 GR/IR](coverage-matrix-v0.3-proposal.md) | 对照同公司和跨公司条件，不假设固定分录。 |
| 15 | 先读 [PP-01 生产业务与组织结构](coverage-matrix-v0.3-proposal.md)、[PP-02 物料清单 BOM](coverage-matrix-v0.3-proposal.md)、[PP-03 工作中心与工艺路线 Routing](coverage-matrix-v0.3-proposal.md)、[PP-04 需求、MRP 与计划订单](coverage-matrix-v0.3-proposal.md)、[PP-05 生产订单与确认](coverage-matrix-v0.3-proposal.md)、[PP-06 生产发料、收货与成本](coverage-matrix-v0.3-proposal.md)、[PROCESS-05 计划到生产 Plan-to-Produce](coverage-matrix-v0.3-proposal.md)，再读 [CO-04 产品成本、生产差异与结算](coverage-matrix-v0.3-proposal.md) | 画生产成本对象及事件发生顺序。 |
| 16 | [PROCESS-07 记录到报告 R2R](coverage-matrix-v0.3-proposal.md)；[FI-08 结账与报表入门](coverage-matrix-v0.3-proposal.md)；[CO-01 管理会计从零：成本与利润](coverage-matrix-v0.3-proposal.md)、[CO-02 成本中心与成本要素](coverage-matrix-v0.3-proposal.md) | 生成虚构结账核对表。 |
| 17 | [PROCESS-08 委外采购](coverage-matrix-v0.3-proposal.md)、[PROCESS-09 供应商寄售](coverage-matrix-v0.3-proposal.md)；[MM-04 采购申请与订单机制](coverage-matrix-v0.3-proposal.md)、[MM-05 库存类型与移动类型](coverage-matrix-v0.3-proposal.md)；[FI-07 库存估价与收货发票暂估 GR/IR](coverage-matrix-v0.3-proposal.md) | 对比委外与寄售的货权、库存及核算假设。 |
| 18 | [PROCESS-10 采购退货与冲销](coverage-matrix-v0.3-proposal.md)、[PROCESS-11 发票数量价格差异与冻结](coverage-matrix-v0.3-proposal.md)、[PROCESS-12 销售退货与贷项](coverage-matrix-v0.3-proposal.md)；[FI-05 会计凭证、过账与冲销](coverage-matrix-v0.3-proposal.md)、[FI-06 应付、应收与资金流](coverage-matrix-v0.3-proposal.md) | 编写模拟异常分类及安全回退提纲。 |
| 19 | 复习 [CO-03 内部订单和费用归集](coverage-matrix-v0.3-proposal.md)、[CO-04 产品成本、生产差异与结算](coverage-matrix-v0.3-proposal.md)、[PP-06 生产发料、收货与成本](coverage-matrix-v0.3-proposal.md)、[SD-04 定价、开票与应收集成](coverage-matrix-v0.3-proposal.md)，先读 [CO-05 获利分析与 FI 集成](coverage-matrix-v0.3-proposal.md) 后读 [CO-08 管理会计数据模型](coverage-matrix-v0.3-proposal.md) | 对照费用归集、结算与获利分析视角。 |
| 20 | [ABAP-03 标准流程调试与运行分析](coverage-matrix-v0.3-proposal.md)、[ABAP-04 BAPI、LUW 与事务提交](coverage-matrix-v0.3-proposal.md)、[ABAP-05 增强技术与可扩展性](coverage-matrix-v0.3-proposal.md)；[S4HANA-03 CDS 数据建模与权限](coverage-matrix-v0.3-proposal.md)、[S4HANA-06 Clean Core 与扩展策略](coverage-matrix-v0.3-proposal.md) | 整理一份匿名化排障方案，核对无雇主敏感资料。 |
| 21 | [COURSE-05 跨模块业务流程](coverage-matrix-v0.3-proposal.md)、[COURSE-06 ABAP 与 S/4HANA 技术架构](coverage-matrix-v0.3-proposal.md)；[S4HANA-04 OData 服务和接口治理](coverage-matrix-v0.3-proposal.md)、[S4HANA-05 RAP 在 2021 的能力与限制](coverage-matrix-v0.3-proposal.md)；[AI-Integration-03 工具调用与 SAP API 集成](coverage-matrix-v0.3-proposal.md) | 总结一个跨模块接口设计案例。 |
| 22 | [COURSE-07 SAP 与 AI 集成及职业验证](coverage-matrix-v0.3-proposal.md)；[AI-Integration-04 权限、数据保护与审计](coverage-matrix-v0.3-proposal.md)、[AI-Integration-05 评估、幻觉控制和人工复核](coverage-matrix-v0.3-proposal.md)、[AI-Integration-08 AI 集成数据模型与证据链](coverage-matrix-v0.3-proposal.md) | 复盘模拟 AI 原型的质量、权限和审计。 |
| 23 | [COURSE-01 24 个月路线与课程总导航](coverage-matrix-v0.3-proposal.md)、[COURSE-07 SAP 与 AI 集成及职业验证](coverage-matrix-v0.3-proposal.md)；[PROCESS-01 P2P 采购到付款](coverage-matrix-v0.3-proposal.md)、[PROCESS-06 来料检验到放行 Quality-to-Release](coverage-matrix-v0.3-proposal.md) | 汇总个人作品集、模拟说明和可验证证据。 |
| 24 | [COURSE-01 24 个月路线与课程总导航](coverage-matrix-v0.3-proposal.md)、[COURSE-07 SAP 与 AI 集成及职业验证](coverage-matrix-v0.3-proposal.md)；按个人薄弱点复读 | 按岗位公开 JD 做能力差距与下周期调整；不公开具体个人敏感信息。 |

## 逐篇证据地图：适用主张、读取状态与未覆盖项

核对日期 2026-11-25。FSD 为 SAP《Feature Scope Description》，产品虽标 2021，但 latest 地址发生版本漂移：先前检索缓存显示文档 9.0（2025-07-23），同地址再次直接读取为 11.0（2026-07-22，共 718 页）。此前 9.0 未保存可验证快照，因此原章节和页码不可稳定复验；例如 Overhead Cost Accounting 从 2.5.1.1.1 移到 2.6.1.1.1。下文已移除 FSD 的固定页码与旧章节编号，所有 FSD 记录仅作待核验线索，须寻找可固定版本或保存合法可验证快照并对照目标 FPS 后方可作证据。SAP 页面可能要求切换版本或权限。此前已读取的 OpenStax 内容因 AI 使用许可待确认，已暂停作为生成依据；下方 FI-01/02 改用 SEC 教育材料，FI-03 用 IRS 对复式记账及通常余额方向的局部说明，完整借贷增减规则仍缺直接依据。课程文章证据目前仅有已批准的规划和拟引用条目，知识正文均待建。

| ID | 逐篇主题来源（标题及 URL） | 实际读取、版本及有限用途 | 仍待核查 |
| --- | --- | --- | --- |
| FI-01 | [SEC 财务报表入门](https://www.sec.gov/about/reports-publications/beginners-guide-financial-statements) | 已读正文；美国政府教育资料，支持资产、负债、权益和收入费用基础概念，不证明 SAP 流程。 | SAP 采购例证、会计与实际资金差异需核对 PROCESS-01 和 2021 资料。 |
| FI-02 | [SEC 资产负债表入门](https://www.sec.gov/files/balancesheet-building-blocks.pdf) | 已读正文；美国 SEC 工作人员教育资料第 1 页支持会计等式；不作为中国会计准则。 | 中国及企业具体准则和资产确认条件；不以此推出 SAP 配置。 |
| FI-03 | [IRS 复式记账与账户通常余额](https://www.irs.gov/irm/part4/irm_04-010-003) §4.10.3.15.1、Exhibit 4.10.3-2；[IRS 记账示例](https://www.irs.gov/pub/irs-prior/p583--2007.pdf) Bookkeeping System | 已读美国政府资料；支持复式记账、通常余额方向与历史租金分录；不证明中国准则或 SAP 功能。此前读取的 OpenStax 已暂停作为生成依据。 | 账户的完整借贷增减规则、例外、地区适用性和 SAP 过账行为仍需直接证据。 |
| FI-04 | [SAP 2021 FSD：General Ledger（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：总账科目主数据、科目表和凭证。 | 公司代码配置映射、事务和各 FPS 差异待查专文；FSD 需固定版本并重新核验。 |
| FI-05 | [SAP 2021 FSD：General Ledger（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：描述凭证及未清项的冲销/清账能力。 | 冲销的期间、权限和前后置业务约束未全部核验；FSD 需固定版本并重新核验。 |
| FI-06 | [SAP 2021 FSD：Accounts Payable / Accounts Receivable（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：提供应付发票/供应商付款、应收和总账关联的功能范围。 | 部分清账、税、外币和具体资金事件需要其他逐项资料；FSD 需固定版本并重新核验。 |
| FI-07 | [SAP 2021 FSD：采购订单与科目分配（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：描述采购可基于成本中心和内部订单分配，不代表每种后续分录。 | 资产分配、GR/IR 三模式、非估价收货、自动科目与凭证逐项待核验；F3/F4 原文未读；FSD 需固定版本并重新核验。 |
| FI-08 | [SAP 2021 FSD：General Ledger / Closing Operations and Reporting（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：描述结账分析和报表功能范围。 | 国家会计准则、期间开关和每类结账处理前提须专文确认；FSD 需固定版本并重新核验。 |
| FI-09 | [SAP 2021 FSD：Accounting（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：功能目录有助定位财务领域，不证明任何具体事务码。 | 每个 T-Code/Fiori 应用的作用、只读权限和版本均待逐项查证；FSD 需固定版本并重新核验。 |
| FI-10 | [SAP 2021 GR/IR Automatic Clearing](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/d57abfc6bcf644938dd7c4e12e152ff6.html?version=2021.000) | 仅搜索摘要、直接打开无正文；2021 初始版线索；不得作为已确认配置依据。 | 每个 IMG 节点、配置→行为、读取权限与公司代码条件均需可读原文。 |
| FI-11 | [SAP 2021 Simplification List：8.1 Data Model Changes in FIN](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=200) | 已读正文；2021 初始版、FPS01/02 适用；列出财务数据模型变化与部分兼容视图。 | BKPF/ACDOCA 精确键、关联、访问授权及后续 FPS 仍须独立核验。 |
| CO-01 | [SAP 2021 FSD：Overhead Cost Accounting（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：涉及费用中心、作业类型和管理会计主数据。 | FI 与 CO 在具体核算情境的口径差异仍需逐项核查；FSD 需固定版本并重新核验。 |
| CO-02 | [SAP 2021 FSD：Overhead Cost Accounting（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：列举成本中心、分配和内部订单主数据。 | 成本要素与 G/L 的详细关系、有效期、配置和 ECC 对照仍需专文；FSD 需固定版本并重新核验。 |
| CO-03 | [SAP 2021 FSD：Overhead Cost Accounting（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：内部订单列于成本核算主数据。 | 内部订单统计/真实、结算规则、预算具体行为需逐条补可读专文；FSD 需固定版本并重新核验。 |
| CO-04 | [SAP 2021 FSD：Product Cost Management（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：产品成本与制造方式、成本对象和库存估价相关。 | 不同制造方式的结算、差异及在制品明细与配置需进一步证明；FSD 需固定版本并重新核验。 |
| CO-05 | [SAP 2021 FSD：Cost Management and Profitability Analysis（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：列出按产品、客户等维度分析市场以及收入和销售成本。 | 基于账户/基于成本的获利分析差异、字段、配置和账务关系待核验；FSD 需固定版本并重新核验。 |
| CO-06 | [SAP 2021 FSD：Cost Management（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：识别候选业务功能范围，不证明具体事务码。 | 每项事务码、应用、读/写权限与是否可用必须单独核验；FSD 需固定版本并重新核验。 |
| CO-07 | [SAP 2021 FSD：Overhead Cost Accounting（latest，版本漂移）](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf) | 初查 9.0 检索缓存；现地址漂移至 11.0、旧版无法稳定复验；待核验主题：说明管理会计对象和功能，不证明具体配置节点。 | 逐配置因素、业务行为、IMG 只读入口和适用版本仍待原厂原文核对；FSD 需固定版本并重新核验。 |
| CO-08 | [SAP 2021 Simplification List：8.1 Data Model Changes in FIN](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=200) | 已读正文；2021 初始版、FPS01/02；FIN 兼容视图与数据模型变化的有限证据。 | 成本对象字段级关系、成本要素及历史视图需要逐项补充 2021 依据。 |
| COURSE-01 | [原 24 个月路线](roadmap-v0.1.md) + [覆盖矩阵](coverage-matrix-v0.3-proposal.md) | 已读仓库原文；2026-11-23 路线草案与 V0.3 计划；支持既定职业发展阶段及候选 ID，不能证明正文已存在。 | 规划审批、生成实际链接、课程和文章审核。 |
| COURSE-02 | [覆盖矩阵：PROCESS-01 / FI-01 / MM-01](coverage-matrix-v0.3-proposal.md) | 已读 2026-11-25 候选矩阵；记录采购首读关联；目标文章未建。 | 完整 P2P 内容、概览、示例和理解题需要正文与原厂证据。 |
| COURSE-03 | [覆盖矩阵：FI/CO 条目](coverage-matrix-v0.3-proposal.md) | 已读 2026-11-25 候选矩阵；记录财务课程范围；正文未建。 | 先修、答案、原文链接与有效审查。 |
| COURSE-04 | [覆盖矩阵：MM/QM 条目](coverage-matrix-v0.3-proposal.md) | 已读 2026-11-25 候选矩阵；记录模块范围；正文未建。 | 场景和教材次序、原文链接及审查。 |
| COURSE-05 | [覆盖矩阵：PROCESS 条目](coverage-matrix-v0.3-proposal.md) | 已读 2026-11-25 候选矩阵；记录统一流程候选范围；正文未建。 | 每个流程内容、链接、审核与条件边界。 |
| COURSE-06 | [原路线架构阶段](roadmap-v0.1.md) + [覆盖矩阵：ABAP/S4HANA](coverage-matrix-v0.3-proposal.md) | 已读原路线和候选矩阵；分别记录 4–6 月目标及技术范围；技术正文未建。 | 每篇 2021/FPS 依据、合法练习、真实链接和审核。 |
| COURSE-07 | [原路线 AI 与职业阶段](roadmap-v0.1.md) + [覆盖矩阵：AI-Integration](coverage-matrix-v0.3-proposal.md) | 已读原路线和候选矩阵；分别记录 7–24 月方向及 AI 候选主题；正文未建。 | AI 与 SAP 各自版本证据、权限边界、课程实际链接和审核。 |

## 需后续确认和评审的缺口

1. 每篇的精确 2021 原厂页面、章节、FPS、具体只读事务及字段未全部核实，上表 F1–F8 仅是确定且受限的研究入口；任何未解决的适用性主张均不可进入 reviewed/accepted。
2. 课程引用的 ID 跨工作包，目标文件与目录由总协调者合并时检查；内容尚无正文或有效三角色审核。
3. 会计等式等跨国家基础需辅以适用地区的公开会计资料，但本项目不提供公司具体记账规则、税法或法律建议。
4. 此文本由独立执行上下文编制；尚未经独立评审，不是对 FI/CO 内容或会计配置的实机认可。
