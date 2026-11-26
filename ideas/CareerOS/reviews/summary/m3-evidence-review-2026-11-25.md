# CareerOS V0.3｜M3 来源台账与独立复核记录

日期：2026-11-25（Asia/Shanghai）。所有者已批准 M0、M1、M2、99 篇范围和 11 个纯结构导航分类；**M3 尚未通过，M4 尚未授权**。本轮仅研究方案来源，未编写正式知识文章、未连接 SAP 系统，正式文章有效审核轮次为 0。

## 研究与范围

独立执行上下文分别形成[物流与流程来源](../../plans/evidence-logistics-m3.md) 46 条、[FI/CO 与课程来源](../../plans/evidence-finance-m3.md) 26 条、[技术与 AI 来源](../../plans/evidence-tech-m3.md) 26 条，协调者另形成[术语表来源](../../plans/evidence-common-m3.md) 1 条。此前脚本核对这 99 个 ID 与已批准范围逐项一致且无重复；覆盖指**有资料记录**，不是证据充分或文章完成。

每条仅列出有限资料和剩余缺口。有些条目仅有邻近子主题或不同版本资料，许多配置、T-Code、字段、接口、财务分录、版本与异常尚未核实，不能宣称 M3 出口条件已满足。

## 真实独立复核与修订

| 复核对象与上下文 | 实际问题、Work 答复和修订 | 重新检查与状态 |
| --- | --- | --- |
| 术语表来源；`/root/audit_design_review` | 独立复核 SAP 文档封面为 FPS01，初稿将历史 FPS00 记为当前版本；Work 修正。SEC 材料仅支持其美国语境的会计基础。 | 同一上下文确认修正，限此问题；不代表词表整体完成。 |
| 物流来源；`/root/developer_plan` | 独立抽查 7 个条目、46 个 ID，指出 PROCESS-03/04 的 §2.13.2.1 标题误写。Work 核实并改为 `Delivery Management`；PROCESS-04 改引 2021 初版跨公司调拨页面。 | 用量恢复后，原审查者读取 PR #20 的 `0730c3fc66292c1ae22ff95a0d9b89847b930d70` 确认修订，并独立读取 MM-01、MM-07、PROCESS-04、PROCESS-09 四个 2021 初版页面；仅关闭已核实的有限描述。 |
| 技术来源；`/root/consultant_plan` | 审查者指出 SQL Monitor 原文仅标“ABAP Platform 2021”，不能断言 FPS00；Work 移除无依据的 FPS 断言。 | 原审查者在 `0730c3fc` 当时复核了 Available As Of 字段；本轮另发现页尾 Version 为 FPS00，经另一独立上下文核对，历史结论已按下方记录修正。实际系统补丁仍待核。 |
| Gateway 与采购 BAPI；`/root/consultant_plan` | Work 读取 SAP Gateway `2021 Latest` 和 ECC 背景 Purchasing BAPIs 支持资料，标明有限内容。 | 独立配置顾问读取原文并确认 Gateway 授权检查及 ECC 来源边界；不能推断具体服务权限或 2021 采购 BAPI 事务。 |
| 财务台账；`/root/audit_design_review` | 独立抽查 26 个 ID 与原始资料，指出 SEC1 应包括现金流量表及 GAO1 的页码有误；Work 修正原财务台账。 | 同一审查者复核两处修正；未能独立读取大型 SAP 2021 PDF，因此未验证其具体段落。只代表抽样，不代表全文通过。 |
| 财务补查；原作者 `/root/reader_m3_review`，独立审查 `/root/audit_design_review` | 原作者重新核对并补查 [26 项 FI/CO 与课程资料](../../plans/finance-source-recheck-20261125.md)；其自身复查不能算独立验收。审查者指出补查报告的 GAO 旧页码，Work 已统一修正。 | 独立审查者复读修订，并直接读取 2014 财政部大纲及两份通知；确认仅限历史资料线索，不证明现行规定、SAP 行为或具体使用许可。其他来源未全部独立验证。 |
| 技术追加；`/root/developer_m3_review`，独立审查 `/root/developer_plan` | [技术补查](../../plans/tech-followup-m3.md) 找到 SAP Custom Code Migration Guide：封面是 2021 FPS01，尽管 URL 带 `.002`；正文涉及 SRTCM 和 SQL Monitor。 | 独立开发者核对封面和物理页 3、80、81，确认有限描述；该页不证明 SQLM 事务码、`PACKAGE SIZE` 或消除 dump，未进行 SAP 实测。 |
| 财务过账专题；`/root/reader_m3_review`，独立审查 `/root/audit_design_review` | [FI-07 补查](../../plans/finance-fi07-direct-2021.md) 取得 2021 初版收货与发票图示及账户说明。 | 独立复核前两页图示及供应商过账不等于付款；另找到2021印度不涉及消费税的货物收货借库存、贷 GR/IR 的特定例子。原文正负与借贷对应仍有歧义，不能据此断定笔误；新增印度来源最初独立复核因用量限制中断，随后 `/root/consultant_plan` 实读原文并指出 nonexcisable 应限指消费税，Work 已修正译法，原审查者复读确认，限此问题关闭。第三页已由 `/root/consultant_plan` 独立复读，第四页仍未独立复核。另有 2021 印度运输服务税的发票借贷案例由顾问实读、`/root/audit_design_review` 独立核验，不能推为普通库存采购或现行税法。 |
| 采购 BAPI 专题；`/root/developer_m3_review`，独立审查 `/root/developer_plan` | Work 补查 [BAPI 事务资料](../../plans/bapi-transaction-search-m3.md)：SAP 2026 指南仅列特定集成的函数暴露清单；第三方样章使用 2021 FPS01 具体 RAP 场景。 | 独立开发者读取两份原文并确认局限；第三方不能冒充 SAP 官方，官方目标版本特定事务语义仍待核。 |
| 2021 RAP 与 PO 扩展；`/root/developer_plan` | 原研究者只能取得索引；独立开发者在浏览器明确选择 2021 初版并阅读两个 SAP 原文，补充特定 RAP 功能和 BAPI 自定义字段扩展。 | 更新 [技术补查](../../plans/tech-followup-m3.md) 与 [BAPI研究](../../plans/bapi-transaction-search-m3.md)；不能由此推断全部特性、事务、增强副作用或系统实测。 |
| 物流与质量补查；`/root/consultant_m3_review` | [四项专题补查](../../plans/evidence-gap-four-m3.md) 找到 MM-09 特定迁移场景、QM-07/08 的 FPS01 单项配置与 CDS；原研究 SD-01 仅有搜索索引；独立顾问随后直接读取了 2021 初版销售组织和销售区域 API 两个页面。 | 独立配置顾问 `/root/consultant_plan` 复核 MM/QM 原 PDF、场景及页码，并实读 SD 两个 2021 页面；Work 按反馈更新专题记录。仅限所述问题，不代表各主题全文已验证。 |

财务研究阶段曾读取 10 个 OpenStax 页面，随后发现页面对生成式 AI 使用有提示限制。保留已发生读取的事实，并停止进一步读取和将其用于生成依据；不对具体法律适用作结论。

## 主要阻碍与恢复方法

1. 新的 MM/QM 证据只覆盖特定业务和补丁，SD-01 已取得部分 2021 组织定义与分配依据；其他主题中的配置与字段仍需直接依据。不能从单一 IMG 范例推断文章整体通过。
2. 2021 FSD 的 `latest.pdf` 是动态链接，同日出现旧抓取 9.0/SPS08 与当前 11.0/SPS10；记录了后者当次文件长度和 SHA-256，但未归档原文件，不能保证旧版或今后可复现。不得跨版本混用页码或宣称符合目标系统未知 FPS。
3. ABAP Platform 2021 的通用 BAPI 事务模型已由两个独立上下文实读；但 ABAP-04 特定采购 BAPI 的目标版本事务、异常和提交依据仍缺。ABAP 7.56 的分包官方示例已核读，但 APPENDING+PACKAGE SIZE 组合、游标和提交边界仍未闭合；RAP 其他特性仍须逐 FPS 核查。搜索索引可见不能当作正文已读，也不能把 ECC 事实自动套用 2021。
4. 财务借贷入门已找到历史中文资料，但当代地区适用性、具体使用许可和 SAP 会计分录仍需核对；OpenStax 已暂停使用。
5. 上次复核一度受用量限制；本次恢复后完成上表列明的复验。后续印度来源再复核与 P2P 来源补查的两个子代理任务再次遇到用量限制；印度页面随后由另一顾问独立实读，P2P 补查后由另一顾问接手并实读两页，其有限结果见 [P2P估价补查](../../plans/p2p-valuation-direct-2021.md)；完整 P2P 和付款证据仍未闭合。后续顾问实读了 2021 固定版库存采购 FM 示例，但借贷表头错位，不能据其确认方向；普通库存采购发票直接证据仍待补查，见 [FI-07 补查](../../plans/finance-fi07-direct-2021.md)。未取得的独立复核不得计作通过。P2P 补查中研究者报告 [2021 采购收货应用](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/c2be52880d194905a0692f6dce907795.html?version=2021.000) 的索引涉及凭采购订单过账收货，但正文未实读；未完成的发票到付款链仍需研究。没有公司 SAP 环境，不能声称系统实测。
6. 逐篇目标版本直接来源与实施资源计划未全部闭合；新增[逐篇门槛与资源控制计划](../../plans/m3-evidence-resource-control-v0.3.md)记录具体状态和恢复方式。M3 阶段评审须如实列出未解事项及影响；未经所有者批准 M3 和明确授权，不进入 M4。

以上均为规划来源审查，并非三角色对正式文章进行的有效问答、修订与复核，不计入每篇三个角色各 5～10 轮的统计。

## 本轮补充来源与方案审查

- `/root/developer_plan` 和 `/root/consultant_plan` 分别实读并独立复核 ABAP Platform 2021 的 BAPI 通用事务模型与无产品版本的 SAP Additional Content 测试示例；通用模型明确有例外，未证明采购 BAPI 的事务契约。见 [BAPI 证据](../../plans/bapi-transaction-search-m3.md)。
- `/root/developer_m3_review` 找到 SAP 官方 7.56 固定代码示例与版本映射，`/root/reader_plan` 独立复核示例的分包和累积边界；该例不保证免内存 dump。见 [7.56 证据](../../plans/abap-756-sql-evidence-m3.md)。
- `/root/audit_design_review` 发现 SQL Monitor 来源的正文和页尾版本字段表述不一致；`/root/developer_m3_review` 独立实读，确认 Available As Of 字段仅为 2021，而页面 Version 字段标 FPS00。Work 已修正主台账和细化文档；原审查者复核主表正确，但指出两条细化表引用仍缺字段区分，Work 追加修正，原审查者在 `a345f0b` 复核这两条字段描述，限该问题关闭。
- `/root/reader_plan` 发现 FI/CO 入门先修、正常余额与增减方向的教学设计以及 F4 链接问题。Work 已更新课程计划，并将财政部 2014 历史大纲的限定支持同步主台账；原审查者复核主要修订准确，并指出 COURSE-03 主表仍需同步历史来源；Work 已修正该处，原审查者在 `d6049bc` 复核历史来源与现行适用边界，限该问题关闭。未声称现行适用或 SAP 实测。
- 针对逐篇来源和资源计划欠缺量化状态，Work 新增控制计划并保留尚未判定/未闭合的标识；原审查者复核当时 5/94 状态、资源与事件数正确；后续另对 16 项技术主题进行初步贴合度归类，随后新增 MM/QM 18 项（其中 MM-09 已在重点五项），当时 38 个不同 ID 有本轮分类或重点记录；后续已覆盖全部 99 个 ID 的贴合度或重点记录，任何归类均非 M3 通过，但实际每批角色和容量仍未落实，且提出新增严重缺陷须明确复验；Work 追加说明，原审查者在 `a345f0b` 复核新发现严重缺陷的处理措辞；实际每批人选与额度仍未落实。该方案不代表 M3 门槛通过。

- `/root/developer_m3_review` 对 16 项技术计划进行了[来源贴合度初步复核](../../plans/technical-source-fit-review-m3.md)：12 项直接部分支持、4 项主要为邻近概述；当时未覆盖的 78 项不能据此判通过。`/root/audit_design_review` 独立抽查其中 ABAP-03、ABAP-07、ABAP-05、S4HANA-03、S4HANA-09 五项；其余 11 项未由该审查者逐一复核。报告中原将仓库文件误写为 `tech-m3.md`，Work 已修正为实际计划文件链接，原审查者在 `d6049bc` 复读确认，限链接问题关闭。分类不代表正式文章完成或 M3 审批。

- `/root/consultant_m3_review` 对 [MM/QM 18 项](../../plans/review-evidence-mm-qm-m3.md)逐行复核，指出 QM-05 的 SPS10 PDF 引用页码应为 189 而非 188；Work 已修正，原审查者复读 `b461828` 并确认，限该页码问题关闭。MM-01/MM-07 本轮未能独立重开网页正文，不能冒称本轮已读。此复核不是 M3 或正文通过。


## 本轮逐项贴合度检查

- 独立执行上下文分别完成 [SD/PP 16 项](../../plans/sd-pp-source-fit-m3.md)、[FI/CO/课程 26 项](../../plans/finance-source-fit-review-m3.md)、[AI 8 项](../../plans/ai-source-fit-m3.md)、[流程 11 项](../../plans/process-source-fit-m3.md)和[术语表](../../plans/common-source-fit-m3.md)的来源贴合度记录；各报告明确本轮实读与沿用既有来源记录的区别，部分来源未被本轮审查者重新打开。
- 这些记录与此前技术 16、MM/QM 18 及 ABAP-02、ABAP-04、PROCESS-01 三项重点合计 99 个独立 ID；数量仅是计划级分类覆盖，不是来源已充分、逐篇复验完成或 M3 通过。
- `/root/consultant_m3_review` 对 QM-05 页码修订进行真实复核：提交 `b46182890f73990f019b2db391ed0c0022ca9ae4` 的第189页及 EWM 限定正确，限页码问题关闭。其他场景和实机仍未验证。
- `/root/consultant_plan` 指出 SD-06 配置功能应引用 SPS10 的第118页而不是117页，并提醒 SD-07 迁移限定；`/root/developer_m3_review` 指出 PROCESS-08 的 Basic Subcontracting 章节应为 §2.8.4.7.1。Work 已修正；各原审查者复读提交 `d6049bc` 并确认，限 SD-06、SD-07 及 PROCESS-08 定位与限定问题关闭。
- 财务审查者指出 COURSE-03 的历史会计来源描述需与 FI-03 同步；BAPI 复核者建议标明示例 `WAIT = 'X'` 与浏览器不可用的历史上下文。Work 已修订；`/root/reader_plan` 复读 `d6049bc` 并确认 COURSE-03 历史范围，`/root/consultant_plan` 复读 `09deed9` 并确认 BAPI 描述的历史上下文与 WAIT 写法，限该文字问题关闭。均不计正式文章审核轮次。

- `/root/developer_plan` 复核 AI 来源报告时发现自身误将 Gateway 文档阅读归于自己；Work 已改为准确转述协调者及 `/root/consultant_plan` 的早前阅读记录，`/root/developer_plan` 复读 `09deed9` 并确认该归属；不增加虚构独立验证次数。

- `/root/audit_design_review` 指出 AI 贴合度报告误用了 AI-01～08 别名、术语表报告未显式给出 COMMON-01，影响严格逐 ID 自动核对。Work 已改为清单原 ID；`/root/audit_design_review` 对 `09deed9` 独立执行严格集合比对，99 个唯一 ID、无缺失/额外项，仅 FI-07 与 MM-09 在重点表和领域报告重复出现且不重复计数。计划级覆盖和 M3 通过仍是不同状态。


## 新一轮目标版本补证

- FI-04：`/root/reader_plan` 阅读固定 2021 总账迁移对象，`/root/audit_design_review` 独立核对封面和页191–194；仅支持 Direct Transfer 场景，不证明一般组织基数或 FS00 全事务只读。见 [FI-04 补查](../../plans/fi04-gl-2021-evidence-m3.md)。
- S4HANA-03：`/root/developer_plan` 阅读 SAP 2021 Oct CDS/DCL 四页，`/root/audit_design_review` 独立复读其中两页；详见 [CDS/DCL 补查](../../plans/cds-dcl-2021-evidence-m3.md)。适用 DCL 与用户其他授权/访问路径不能混同。
- MM-09：`/root/consultant_m3_review` 补查 SAP Learning 和公开 KBA，`/root/reader_plan` 独立核对其中两篇课程和两个预览；前者未锁定 2021，后者只限各自具体问题与产品字段，普通库存场景完整目标版依据仍未闭合。见 [MM-09 补查](../../plans/mm09-obyc-source-followup-m3.md)。
- PROCESS-01：`/root/developer_m3_review` 补查付款建议、凭证、介质、银行状态，`/root/consultant_plan` 独立核对其中三处原文，不能据此声称真实资金已扣或所有采购付款路径已证。见 [付款末端](../../plans/p2p-payment-evidence-m3.md)。

以上均为阶段研究，不是正文审查；未连接 SAP，M3 未通过，M4 未授权。

- `/root/audit_design_review` 复核 `6ac8c0b` 的 FI-04 阅读归属及迁移范围正确，CDS 补查和主台账的两页阅读归属亦正确；指出 `#CHECK` 与 `#NOT_ALLOWED` 警告时机须限定在开发者激活相应 entity/role。Work 已修正文案，原审查者复读 `6b8e5a` 后确认；Work 依其精度建议将“未定义”改为“不存在”。
- `/root/reader_plan` 和 `/root/consultant_plan` 分别复核 `6ac8c0b` 的 MM-09 与付款末端记录，确认各自实际读取范围、特定场景与未实测边界；其余函数、完整流程与系统缺口仍开放。


## 销售、生产、成本与扩展补证

- SD-02：[伙伴职能补查](../../plans/sd02-partner-2021-evidence-m3.md)记录四个 2021 Oct 页面，`/root/audit_design_review` 独立复读前两页并确认同页 FLVN00 标注冲突；BP grouping、实际配置和其他两页的独立复核仍待查。
- PP-09：[生产数据模型补查](../../plans/pp09-data-model-evidence-m3.md)限定简化 sourcing 下 material BOM 的例外，并区分 MATDOC 与 `NSDM_DDL_*` DDL source；`/root/consultant_m3_review` 实读原文并复核两处修订，完整键/基数/API 未证。
- CO-03：[内部订单补查](../../plans/co03-internal-order-evidence-m3.md)的两篇 SAP Learning 由 `/root/audit_design_review` 独立复读，但课程未锁定 2021；2021.001 Central Finance 仅为限定场景。
- S4HANA-06：[扩展补查](../../plans/extension-2021-evidence-m3.md)的 2021 初版 key-user 与 FPS01 side-by-side 实例经独立复读；审查者未复核升级指南和后期 FAQ，完整 Clean Core/API 合同未证。

均属资料研究，不计入正式文章审核轮次；无 SAP 实机，M3 尚未通过，M4 尚未授权。


## 原审查者复读记录

- `/root/audit_design_review` 复读 `82410979` 的 SD-02 与扩展记录，确认实际读取归属和适用边界，指出 SD-02 账户组与职能关系一句语义重复；Work 已按原文修订，原审查者复读 `e737b344` 后确认，限此句问题关闭。
- `/root/consultant_m3_review` 复读 `82410979` 的 PP-09 记录，确认原文复核只覆盖 material BOM 与 DDL source 两项；Work 进一步写明两个 DDL source 全名，原审查者复读 `e737b344` 后确认范围准确，限此问题关闭。
- `/root/reader_plan` 复读 `82410979` 的 CO-03 记录，确认独立审查仅覆盖两篇未固定 2021 的 Learning 课程，不覆盖 Central Finance PDF；该记录问题限此关闭。

以上为来源规划资料复核，不计正式文章轮次。


## GR/IR 图与科目确定的后续补查

- `/root/consultant_plan` 浏览器读取 SAP 2021 Oct [GR/IR T 型账户](../../plans/fi07-grir-taccount-2021.md)，`/root/audit_design_review` 独立复读页面与图：收货 2,000、部分发票 1,000 欧元的账户左右位置可见；将其解释为借贷属于会计惯例，不是图示逐项文字标注。原例未明确普通库存 PO 无科目分配、税费等前提，期末调整/冲回不是付款或实际清账。
- `/root/consultant_m3_review` 追加 MM-09 [检索记录](../../plans/mm09-obyc-source-followup-m3.md)，新候选为 2023 索引、无法读取的 2021 PDF 或未解析版本的索引，均未冒称目标版直接证据。普通估价采购 BSX/WRX 完整固定版证据仍未闭合。

此轮是阶段资料研究，不计正式文章审核；未连接 SAP，M3 未通过，M4 未授权。


## PP-09：确认关联的 OData 实体补证

`/root/developer_m3_review` 读取 SAP Cloud SDK 3.59 与 3.70 的发行说明和固定源码包，`/root/consultant_m3_review` 独立复读发行说明、重新计算**同一本地包**的哈希并核对源码，见 [PP-09 OData 实体补查](../../plans/pp09-order-material-key-m3.md)。该生产确认关联物料移动实体的五字段 `@Key` 及订单属性有源码依据；这不是独立下载确认，也不是 MATDOC 物理主键或目标系统 `$metadata`、权限、全量基数证明。未访问 SAP 系统，不计正式文章审核轮次。


## 本轮来源记录复读

- `/root/audit_design_review` 复读提交 `fe81e7e60ddd1e36941472f6f193e56023eeab9c` 的 FI-07 图示及主台账，确认其本人实读归属和局限；指出此前正负号图与新 T 型左右图可能混淆，Work 已明确区分，原审查者复读 `6b4cb0092f8e965c6cc32cab24c1316c5863ab90` 确认此处准确，限该消歧问题关闭。
- `/root/consultant_m3_review` 复读同一提交的 PP-09 SDK 报告及台账，确认同一本地包的独立复算哈希、实体键与物理键区分；该审查者还补读 3.70 service，限此项资料复核，未实测 SAP。



## 2026-11-26 来源补查与独立复核

- **ABAP-02**：取得并实读 SAP AS ABAP 7.56 / ©2021 的 SELECT、INTO、OPEN CURSOR、FETCH、COMMIT、ROLLBACK 六页原文。独立读者复核后，Work 修正 FAE 与 PACKAGE SIZE 的预读语义，并将 CALL DIALOG 例外限定为被调程序中 SAP LUW 不关闭、但数据库提交仍发生；最终复核确认文字准确。目标系统 FPS、程序行为和内存实测仍未覆盖。
- **QM-02 / PROCESS-06**：补入 SAP S/4HANA 2021 (Oct 2021) 收货建批条件和库存过账时点原文，另一独立上下文复读这两页，确认需按配置条件建批且库存过账可早于、同时或晚于使用决策；自动 UD 不等于自动库存过账。其他三页由来源研究者读取，不能称五页均独立复读。
- **PROCESS-02**：补入销售订单、出库交货、发货过账、开票转应收的部分功能描述及独立复读范围。FSD 动态 latest 封面为 11.0（2026-07-22）；本轮复核没有重验 SPS10 标签、哈希、收款清账段或异常章节，不能当作固定初版证据。
- **FI-03**：补入财政部修订征求意见稿和 2026 考试大纲的限定性教学线索，并由另一上下文复核上述两项材料；征求意见稿不被写作生效规则，大纲不替代详细教材。现行企业规则和 SAP 适配仍未解决。
- **ABAP-07**：补入 SE37、ST22、SAT、SE11、ST05 的 SAP 页面研究记录，独立读者仅复读 SE37 与 ST22；SE80 和具体客户授权仍缺。无法加载的独立尝试没有算作支持。
- 以上均为 M3 来源规划和文献交叉核验，不是正式文章或三角色审查轮次；没有连接 SAP 系统。本次正式文章与正式审查闭环仍为 0，M3 未通过、M4 未授权。



## 2026-11-26｜P2P 与 FI-07 来源读取状态复核

- SAP Help 2021.000 接口读取补入“Post Goods Receipt for Purchasing Document”“Adjustment of Payment Due Dates...”正文；另一独立顾问在浏览器重读两页并确认 2021 (Oct 2021) 选择器。第二条 Manage Workflows for Supplier Invoices 仍只是搜索索引，不作为完整正文来源。
- 同一顾问独立复读 FI-07 新增的六篇 SAP S/4HANA 2021 正文，确认清账、汇兑方法、标准价差异与印度限定收货的摘要边界；未核查 Work 的 API buildNo 和 HTML hash。Work 据此将 1,700 改为“采购价”，细化公司代码选择收货/发票时有效汇率的方法，并保留“credits”与图示的借贷歧义。复读者已确认两项修订及范围准确。
- Work 更正 P2P 来源状态记录：区分接口正文、搜索索引、具有 2021 文档横幅但选择器未显示的页面，以及选择器明确锁定 2021 的页面。顾问复读更正后确认归属准确。
- P2P / FI-07 的标准采购会计方向、税、自动科目和实际系统配置仍有阻断；此次文献补充不构成完整链路或正式文章审核。正式文章与有效正文审核轮次仍为 0；M3 未通过，M4 未授权。


## 2026-11-26｜ABAP-04 采购 BAPI 扩展页面复核

- 新增 [SAP S/4HANA 2021.000 采购订单扩展页面](../../plans/extension-2021-evidence-m3.md)：Work 读取固定版本 2021 (Oct 2021)，页面支持 BAPI_PO_CREATE1 采购订单创建的自定义字段扩展，并列出 scope items J45、22Z、BNX、J13 与组件 MM-PUR、MM-FIO-PUR-PO。
- /root/consultant_plan 独立通过浏览器复读原文并确认版本选择器、范围与摘要准确；未核 Work 的 buildNo 或 HTML 摘要，未调用 BAPI 或访问 SAP 系统。
- 页面不说明提交、回滚、更新任务或消息行为；ABAP-04 事务证据仍未闭合。此次仅为 M3 文献交叉核验，正式文章与有效审查轮次仍为 0。


## 2026-11-26｜FI-07 移动平均价案例复读

- /root/consultant_plan 找到 SAP S/4HANA 2021.000 固定页 [Example: Material with MAP with Stock Coverage](../../plans/finance-fi07-direct-2021.md)；Work 随后独立在浏览器复读版本选择器、正文和图示。
- 案例描述 PO 100 件、$2.00；先票 50 件@$2.20，再收货 80 件，随后再票 50 件@$2.20。图示列示 GR/IR、供应商和库存的加减值及 MAP 变化，但没有借/贷标题；无科目分配和税务前提也未明确。正文称最后发票改变库存数量，图中数量前后均为 180，保留歧义。
- 该案例只支持有限 MAP 价格/数量差异，不解决普通库存采购借贷方向或 FI-07 / PROCESS-01 完整门槛；没有 SAP 实机验证，不计正式文章审核轮次。


## 2026-11-26｜WRX 收货分录的邻近版本对照

- /root/consultant_plan 直接读取 SAP Help 的 WRX_GR/IR Clearing Account 页面，选择器显示 2025-FPS1，路径属于 SAP_S4HANA_BEST_PRACTICES / YCOA；可见版本列表没有 2021，不能推断其他 2021 来源不存在或该资料专属部署模式。
- 页面明确写出标准 PO 无科目分配收货的库存借方、GR/IR 贷方，并给 1 件、标准价 EUR 3、PO 净价 EUR 10 的借库存 EUR 3、借价差损失 EUR 7、贷 GR/IR EUR 10 示例。它是清晰的邻近对照，但只涉及收货、不含库存发票分录，且不是 S/4HANA 2021 on-prem 固定证据。
- FI-07 与 PROCESS-01 的 2021 普通库存发票/全流程借贷缺口保持开放。未连接 SAP、未实测，不计正式文章审核轮次。


## 2026-11-26｜P2P 自动付款页面补读

- `/root/consultant_plan` 在 SAP Help 版本选择器中切换并实读 **Manage Automatic Payments** 的 2021 (Oct 2021) 初版正文；支持排定付款建议或直接排定付款、状态查看、逾期发票识别/付款信息完整性检查，以及运行后创建 payment media 等有限主张。
- 该页面不证明某张发票一定入选、支付运行必成功、银行接受支付介质、实际扣款或供应商到账。2021 初版“新输出管理”表与 2025 当前版不同，不能将后期功能倒推。
- 更新 P2P 末端付款证据、PROCESS-01 物流台账及 M3 资源控制表。完整付款配置、逐笔会计凭证、异常和资金链仍未闭合；无 SAP 系统操作，不计正式文章审核轮次。


## 2026-11-26｜MM-09 固定版 GR/IR 页面直读

- Work 通过 SAP Help 版本选择器直接读到 [Important Accounts for Invoice Verification](../../plans/mm09-2021-grir-direct-m3.md) 及其关联的 Postings at Goods Receipt and Invoice Receipt 页面；两页均固定显示 2021 (Oct 2021)，关联 URL 为 `version=2021.000`。
- 页面支持有限的 GR/IR 中间科目与收货/发票关系，但相关收货说明写“credit the value ... to the stock account”，正文无借贷表。独立上下文 `/root/mm09_independent_2021_read` 实读两页并确认版本及歧义；另一顾问读取了未固定 2021 的 Learning 采购收货示例，其借贷文字形成对照而不能替代目标版裁决。
- 本来源不列 OBYC 的 BSX/WRX 确定因素、移动类型条件、配置权限，普通库存采购完整目标版规则仍缺。冲突不视为 SAP 系统错误、不自行改写；MM-09 与 M3 继续未闭合，M4 未授权。
- 来源交叉核验不计正式文章审核轮次；无 SAP 实机测试。

## 2026-11-26｜FI-07 MAP 无库存覆盖案例补查

- Work 读取 SAP S/4HANA 2021 (Oct 2021) [Example: Material with MAP Without Stock Coverage](../../plans/finance-fi07-direct-2021.md)：支持 PO 价格收货/GR/IR、移动平均价领用，以及发票价差按仍有库存数量分流至库存或差异费用的特定案例。
- `/root/mm09_independent_2021_read` 独立复读该页并确认版本与摘要范围；页面没有完整借贷表，也没有明确采购订单无科目分配前提，不能作为普通采购分录或 OBYC 依据。
- FI-07 与 PROCESS-01 仍未闭合；该来源研究不计正式文章审核轮次，无 SAP 实机验证。MM-09 另有两个精确 `version=2021.000` 候选路径返回 Page Not Found，已如实登记为无法读取，不推断资料不存在。


## 2026-11-26｜ABAP-04 SAP Support 页面直接阅读复核

- Work 与独立开发复核上下文分别直接阅读 SAP Help 的 [Purchasing BAPIs](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167428.html) 和 [BAPI_PO_CREATE1 采购示例](https://help.sap.com/docs/SUPPORT_CONTENT/spmm/3362167600.html)。两页均标有 SAP Additional Content 免责声明，背景为 ECC/R/3，未声明 S/4HANA 2021。
- 可有限记录 PO BAPI 与 ME21N 对应、TESTRUN 不产生数据库效果、SE37 测试序列为创建后调用 BAPI_TRANSACTION_COMMIT、X 结构及 RETURN/调试提示。独立开发复核确认上述摘录没有越过页面范围。
- 这不能证明目标版本的函数级提交时机、回滚、更新任务、WAIT 保证、RFC/LUW 边界或失败处理。ABAP-04 与 M3 保持未闭合；未操作 SAP 系统、不计正式文章审核轮次，M4 未授权。


## 2026-11-26｜ABAP-04 SAP Help 第二轮定向检索

- 对 `BAPI_PO_CREATE1`、commit/rollback、更新任务与 S/4HANA 2021 作定向检索，未发现新的目标版本函数级事务文件。
- 搜索摘要发现的通用 dialog/BAPI 事务页面没有锁定目标版本；SAP ERP 6.0 EHP8 的 Processing BAPIs 内容属于 inbound IDoc 处理语境。对这三页尝试打开均返回零行，因此只登记为搜索线索，未作为直接证据。
- 结果不改变 ABAP-04 未闭合状态；后续需目标版本函数文档/适用 Note，或获授权系统的只读 SE37 文档核验。无 SAP 系统访问或执行，不计正式文章审核轮次。


## 2026-11-26｜MM-09 / FI-07 / PROCESS-01：固定版 Account Determination 复核

- Work 在 SAP Help 浏览器直接读取 [Account Determination](../../plans/mm09-obyc-source-followup-m3.md) 所链接的固定页面，版本选择器显示 S/4HANA 2021 (Oct 2021)；独立上下文 `/root/mm09_independent_2021_read` 随后直接重读相同页面并确认版本和内容边界。
- 页面有限支持发票科目确定所考虑的数据类别：发票输入的供应商账户/金额、物料主数据的估价类/价格控制/物料对应科目、已过账单据的 PO 价格/收货状态，以及系统设置的净额/总额方式/G/L 科目。库存是否覆盖发票数量应描述为过账时库存状态比较，不是静态主数据字段。
- 页面没有提供 OBYC、BSX、WRX、交易键、估价分组、账户修改码、移动类型条件、具体科目映射、配置入口/权限或借贷凭证；不解决 GR/IR 收货方向歧义。
- `/root/consultant_m3_review` 无法直接打开此固定 URL；其未固定版本的搜索索引仅提供辅助线索，不计独立复读。已成功的独立复读由 `/root/mm09_independent_2021_read` 完成。以上仅为 M3 来源核对，不计正式文章审核轮次；MM-09、FI-07、PROCESS-01 及 M3 仍未闭合，M4 未授权。


## 2026-11-26｜FI-10 自动科目确定应用公告

Work 直接读取 [SAP《What's New in SAP S/4HANA 2021》](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf) §3.6.1.3（PDF 印刷页 133–134）。原文说明 Automatic Account Determination app 用于配置 G/L account assignments；标注 J58、FI-FIO-GL-CA、Available As Of SAP S/4HANA 2021。表中 BUL（Ledger-Specific CoCode Clearing）与 BUU（CoCode Clearing Between Differing Amts）两个新增 transaction keys 限于 Prepare Intercompany Transactions；另有 `*` 通配符用于 Integrate with HR Postings 的客户/供应商账号输入。

该公告不是完整配置指南，不提供具体科目映射、完整设置路径、角色/权限或只读入口，也不能套用于 MM OBYC/BSX/WRX。配置顾问 `/root/consultant_m3_review` 尝试独立打开指定 PDF，但其工具因文件超过 10 MB 无法读取；其搜索索引只作为辅助线索，不计独立直读或复核。FI-10 仅获有限目标版本证据，配置缺口未关闭；不计正式文章审查轮次。


## 2026-11-26｜SAP Learning GR/IR 方向的独立顾问交叉核对

- /root/consultant_m3_review 直接读取 [Describing Automatic Account Determination](https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/describing-automatic-account-determination)：仅支持通用因素和教学场景；页内发票步骤把 GR/IR 写作 credited。
- 同一顾问直接读取 [Managing Goods Movements](https://learning.sap.com/courses/exploring-end-to-end-business-processes-in-sap/managing-goods-movements_d7cf8543-eb45-490b-810a-237bbd17485f) 与 [Managing Closing Activities in Materials Management](https://learning.sap.com/courses/configuring-the-financial-closing-in-sap-s-4hana/managing-closing-activities-in-materials-management)：两页写收货借库存/消费、贷 GR/IR；关账课程还写发票借 GR/IR、贷供应商。三页均未锁定 S/4HANA 2021/FPS。
- 此为真实 M3 来源交叉复核，确认存在同一通用课程内及不同页面间的方向表述冲突；不把它认作 SAP 勘误，也不能用非目标版本定裁目标版。Work 将冲突保留并同步到 MM-09、FI-07、PROCESS-01 计划记录。正式文章审核轮次不增加，M3 仍未通过、M4 未授权。 本轮 9 份已修改 Markdown 文档共检查 43 个唯一相对文件目标，全部存在；未检查锚点及全部外链。


## 2026-11-26｜ABAP-04 通用 BAPI 事务模型独立复核

- `/root/bapi_independent_developer_review` 直接通过版本选择器读取四篇 ABAP Platform 2021 (Oct 2021) SAP Help 页面：Transaction Model for Developing BAPIs、Programming Dialog Applications、Programming Distributed Applications、Example: BAPI Transaction Model (Without Commit)。
- 目标版通用文档支持调用方显式管理 SAP LUW/commit/rollback 和 update process；对话应用 Return 消息、RFC BAPI 和 IDoc 包装器流程有各自说明。少数含内部 COMMIT 的 BAPI 是文档要求说明的例外；IDoc Type A/E 规则不能推广到一般 BAPI 调用。
- 未找到 BAPI_PO_CREATE1 专属的 2021 commit/rollback/WAIT/消息错误合同；搜索未发现不等于资料不存在。通用模型不能证实采购函数实现，ABAP-04 仍未闭合。未连接 SAP、不执行代码、不计正式文章审核轮次；M3 未通过、M4 未授权。


本轮 5 份更新 Markdown 的 41 个唯一相对文件目标全部存在；锚点和全部外链未检查。
