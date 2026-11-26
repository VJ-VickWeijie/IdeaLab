# CareerOS V0.3｜99 项文章级 M3 证据边界与准入分类

记录日期：2026-11-26（Asia/Shanghai）  
批准依据：所有者在本会话批准按已提交方案调整 CareerOS M3 门禁，并要求继续完成 M3 收尾复核。  
状态：M3 门禁调整已批准；本清单是计划级分流与 M3 证据边界映射，不是 M4 批次授权、SAP 新来源核验、正式文章或文章级通过。

## 分类口径

此表依据已批准 manifest、现有 99 项控制矩阵、三份逐篇细化计划及原来源台账整理，不重做已完成的 SAP 文献检索，不把“没有新证据”推断成原来源不存在。文章标题和路径来自 manifest；范围、版本线索及知识关联见相应逐篇细化计划；具体来源、可读范围和不支持边界见矩阵所列的来源台账。某条元数据无法还原时继续标“未知”，不补造阅读者、日期或复核基线。

- **限缩可写（65 项）**：已有来源至少支持可辨认的有限知识切片。它不表示全文范围充分、版本全部闭合或已获 M4 写作许可。未来选入批次时，仅可写清楚由具体来源直接支持的主张；其余内容缩窄、删除或待验证。
- **暂缓核心（34 项）**：现有矩阵把核心版本／场景／事实标为未核验或未闭合，或逐篇计划明确主要目标仍缺直接依据。不得把相关核心断言写成已确认事实。若可清楚分离有依据的背景段落，可另按受限草稿处理，但整篇未满足原定学习目标前不得计为正式完成。
- 此次没有将文章标为“全文可写／已就绪”：批次尚未选择，具体文章的主张—证据对应、当期作者／三角色容量和版本边界仍需在获批 M4 后逐批确认。分类变化不改变各行原来源状态。

优先阻断 FI-07、PROCESS-01、MM-09、ABAP-02、ABAP-04 的有限安全内容及暂缓边界见 [所有者已批准的 M3/M4 方案](m3-closeout-batched-m4-proposal-2026-11-26.md)。它们是文章／主张范围限制，不是对其余 94 项的一刀切阻塞。计数按文章 ID 去重：99 个 ID、65 个受限切片、34 个核心未闭合；合计 99。

## 99 项计划级分类

“基线登记状态／来源记录”与“新的 M3 分流”是不同字段：前者保留历史研究事实；后者决定未来批次应如何限制范围。逐篇范围／版本／依赖指向详细计划，来源和不支持边界指向矩阵中已有的逐 ID 原始台账；未固定 2021、来源仅为搜索索引、打开正文失败或只是邻近版本时，继续按原限制处理。

| ID | 批准标题与拟建路径 | 范围、目标版本线索与依赖 | 已有来源／边界台账 | 原 M3 登记状态 | M3 规划分类 | 已登记下一步 |
| --- | --- | --- | --- | --- | --- | --- |
| MM-01 | 组织结构与采购业务对象；knowledge/MM/01-foundations/organization-objects.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：核对组织关联及其他模块关系；保留实际配置与权限待核。 |
| MM-02 | 物料主数据与业务伙伴；knowledge/MM/01-foundations/material-business-partner.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：补查采购物料视图和供应商 BP 角色。 |
| MM-03 | 采购信息记录与货源决定；knowledge/MM/02-functions/info-record-sourcing.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：优先级、有效性和自动选择条件。 |
| MM-04 | 采购申请与订单机制；knowledge/MM/02-functions/requisition-po.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：PR→PO 各变体、审批配置与实际事务。 |
| MM-05 | 库存类型与移动类型；knowledge/MM/02-functions/stock-movement.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：具体移动类型、特殊库存和价值影响。 |
| MM-06 | 收货、退货与冲销；knowledge/MM/02-functions/gr-returns-reversal.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：冲销与退货在单据及账务上的具体差异。 |
| MM-07 | 价格单位、数量单位与换算；knowledge/MM/02-functions/price-unit-conversion.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查订单单位规则、BAPI 字段覆盖和版本差异。 |
| MM-08 | MM 常用事务码导航；knowledge/MM/03-tcodes/transaction-index.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：逐事务核对用途、版本以及显示/修改权限。 |
| MM-09 | 采购与库存配置查看；knowledge/MM/04-configuration/purchasing-inventory.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未闭合 | **暂缓核心** | Work：查找固定 2021 普通估价库存收货自动科目规则；保留方向冲突。 |
| MM-10 | 采购库存数据模型与单据关系；knowledge/MM/05-data-model/purchasing-inventory.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：补查并核对：PR/PO 完整模型、精确键、基数和发布 API。 |
| SD-01 | 销售业务与组织结构；knowledge/SD/01-foundations/organization.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查组织配置及跨公司开票适用范围。 |
| SD-02 | 客户业务伙伴与物料主数据；knowledge/SD/01-foundations/customer-product-master.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查 BP grouping/编号、伙伴确定配置、字段/API 及权限。 |
| SD-03 | 销售订单与交货机制；knowledge/SD/02-functions/sales-delivery.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：具体部分交货、取消与权限。 |
| SD-04 | 定价、开票与应收集成；knowledge/SD/02-functions/pricing-billing-ar.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查收入确认、税和收款的适用条件。 |
| SD-05 | SD 常用事务码导航；knowledge/SD/03-tcodes/transaction-index.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：逐事务核对用途、版本和权限，补查 VA03。 |
| SD-06 | 销售配置查看；knowledge/SD/04-configuration/sales.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：准确 IMG 节点、业务分支和访问权限。 |
| SD-07 | 销售与交货数据模型；knowledge/SD/05-data-model/sales-delivery.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：完整单据流字段、主键、接口及关联基数。 |
| PP-01 | 生产业务与组织结构；knowledge/PP/01-foundations/production-organization.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：补查并核对：组织结构及所有制造模式的业务边界。 |
| PP-02 | 物料清单 BOM；knowledge/PP/01-foundations/bom.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：有效期、替代项选择和具体表/字段。 |
| PP-03 | 工作中心与工艺路线 Routing；knowledge/PP/01-foundations/work-center-routing.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：工作中心完整定义、工序选择和成本/产能参数。 |
| PP-04 | 需求、MRP 与计划订单；knowledge/PP/02-functions/mrp-planned-order.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：净需求计算、批量、参数及客户具体系统差异。 |
| PP-05 | 生产订单与确认；knowledge/PP/02-functions/production-order.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：各订单状态、下达、报工与回退条件。 |
| PP-06 | 生产发料、收货与成本；knowledge/PP/02-functions/production-goods-cost.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：库存估价、成本和结算账务。 |
| PP-07 | PP 常用事务码导航；knowledge/PP/03-tcodes/transaction-index.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：逐项查证 PP 事务用途、版本和权限。 |
| PP-08 | 生产计划配置查看；knowledge/PP/04-configuration/production.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：补查生产计划配置查看路径及规则。 |
| PP-09 | 生产主数据与订单数据模型；knowledge/PP/05-data-model/production.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：查证物理表键、关联基数、发布 API；区分 SDK 实体键。 |
| QM-01 | 质量管理业务与组织对象；knowledge/QM/01-foundations/quality-organization.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：质量组织、用户角色、设置和触发前提。 |
| QM-02 | 检验类型与检验批；knowledge/QM/02-functions/inspection-type-lot.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查配置、供应商/质量信息记录差异、EWM 和财务凭证。 |
| QM-03 | 检验计划与检验特性；knowledge/QM/02-functions/inspection-plan-characteristic.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：计划选择规则、抽样参数和具体字段。 |
| QM-04 | 结果记录与使用决策；knowledge/QM/02-functions/results-usage-decision.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：UD 与自动/手工库存过账、撤销及业务条件。 |
| QM-05 | 质量库存与采购生产集成；knowledge/QM/02-functions/quality-stock-integration.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未核验 | **暂缓核心** | Work：补查一般 IM 质量库存与财务影响。 |
| QM-06 | QM 常用事务码导航；knowledge/QM/03-tcodes/transaction-index.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分（固定版 2021 文档只支持部分事务替代/导航变化和授权操作类别） | **暂缓核心** | Work：补齐完整入口目录、逐事务用途/输入输出和实际权限来源；见 QM-06 草稿及 Work 同上下文角色模拟记录。 |
| QM-07 | 质量管理配置查看；knowledge/QM/04-configuration/quality.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分（仅固定 2021 FPS01 比较符配置示例；初始版及完整目标范围未证） | **暂缓核心** | Work：补查初始版、检验类型/工厂条件、其余配置项与权限；查看 [QM-07 草稿](../knowledge/QM/04-configuration/quality.md) 和 Work 同上下文模拟记录。 |
| QM-08 | 检验对象与数据模型；knowledge/QM/05-data-model/quality.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分（仅 2021 FPS01 §4.3.8 指定 CDS 功能示例；初始版与完整模型未证） | **暂缓核心** | Work：补查初始版适用性、字段/表键/关联、released CDS/API 合同与权限；查看 [QM-08 草稿](../knowledge/QM/05-data-model/quality.md) 和 Work 同上下文模拟记录。 |
| FI-01 | 财务会计从零：企业的钱和账；knowledge/FI/01-foundations/financial-accounting-for-beginners.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查并核对：采购事件的单据、库存、价值和资金的SAP 2021触发条件及地区会计规则。 |
| FI-02 | 资产、负债、权益与会计等式；knowledge/FI/01-foundations/accounting-equation.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查地区规则和拟议案例的适用边界。 |
| FI-03 | 借贷方向与复式记账；knowledge/FI/01-foundations/debit-credit.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查适用地区现行规范、科目例外和 SAP 过账依据。 |
| FI-04 | 公司代码、会计科目与总账；knowledge/FI/02-functions/company-code-gl.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查日常组织关系、主数据字段、过账及 FS00 权限。 |
| FI-05 | 会计凭证、过账与冲销；knowledge/FI/02-functions/posting-reversal.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查并核对：复式会计分录、各单据冲销条件、期间与GUI事务仍缺直接依据。 |
| FI-06 | 应付、应收与资金流；knowledge/FI/02-functions/payables-receivables.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查 2021 发票、部分付款、清账及税币条件。 |
| FI-07 | 库存估价与收货发票暂估 GR/IR；knowledge/FI/02-functions/inventory-valuation-grir.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分（固定 2021 GR/IR 清账条件和特例；普通库存分录/税/自动科目未闭合） | **暂缓核心** | 已有证据受限草稿；Work：补查普通库存采购逐事件借贷、税和自动科目规则；未闭合前不写通用分录。 |
| FI-08 | 结账与报表入门；knowledge/FI/02-functions/period-close-reporting.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查并核对：完整月结/年结和国内制度需2021专题及适用地区证据。 |
| FI-09 | FI 常用事务码导航；knowledge/FI/03-tcodes/finance-transactions.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：逐项核对 GUI/Fiori 入口、版本、输入输出及权限。 |
| FI-10 | 财务配置查看；knowledge/FI/04-configuration/finance-config-observation.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查账户映射、配置路径及只读权限。 |
| FI-11 | 财务凭证与总账数据模型；knowledge/FI/05-data-model/accounting-document-model.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查并核对：BKPF/ACDOCA主键、字段、基数、发布API和权限尚需逐字段文档或有权系统确认。 |
| CO-01 | 管理会计从零：成本与利润；knowledge/CO/01-foundations/cost-profit-basics.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查 FI/CO 视角及集成的直接依据。 |
| CO-02 | 成本中心与成本要素；knowledge/CO/02-functions/cost-center-elements.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查并核对：SAP成本中心主数据、成本要素与总账关系和组织条件。 |
| CO-03 | 内部订单和费用归集；knowledge/CO/02-functions/internal-orders.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查普通内部订单归集、统计、结算及权限。 |
| CO-04 | 产品成本、生产差异与结算；knowledge/CO/02-functions/product-cost-variance-settlement.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查制造成本、WIP、差异与结算的目标版依据。 |
| CO-05 | 获利分析与 FI 集成；knowledge/CO/02-functions/profitability-fi.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 部分 | **限缩可写** | Work：补查 2021 获利分析维度、销售/FI 集成及确认时点。 |
| CO-06 | CO 常用事务码导航；knowledge/CO/03-tcodes/controlling-transactions.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：逐项核对 CO 事务入口、版本、用途及权限。 |
| CO-07 | 管理会计配置查看；knowledge/CO/04-configuration/controlling-config-observation.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查并核对：其他成本中心/内部订单/结算设置和IMG只读入口缺逐项来源。 |
| CO-08 | 管理会计数据模型；knowledge/CO/05-data-model/controlling-data-model.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查并核对：CO对象、字段、主键、基数、兼容视图和API需逐项2021资料，不作未经证实推断。 |
| ABAP-01 | ABAP 与业务对象基础；knowledge/ABAP/01-foundations/business-objects.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记部分基础概念；目标 FPS、采购映射待核。 | **限缩可写** | Work：选定采购对象，逐项查 2021 对象、程序、持久化和授权证据。 |
| ABAP-02 | 内表、SQL 与海量数据内存；knowledge/ABAP/02-functions/sql-internal-table-memory.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；[abap-756-keyword-direct-m3.md](abap-756-keyword-direct-m3.md)；[abap02-memory-dump-admin-boundary-m3.md](abap02-memory-dump-admin-boundary-m3.md) | 未闭合：已登记 7.56 特定 SQL/游标原文；目标系统参数、性能及异常未验证。 | **暂缓核心** | Work：固定查询案例及行宽、数据量、并发假设，逐项核 2021/FPS、异常与内存依据并记录未知。 |
| ABAP-03 | 标准流程调试与运行分析；knowledge/ABAP/02-functions/debug-runtime-analysis.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记 SQLMD 特定变化；调试和 trace 未逐项覆盖。 | **暂缓核心** | Work：为 Debugger、SAT、ST05 分别补功能、授权和执行影响的目标版本来源。 |
| ABAP-04 | BAPI、LUW 与事务提交；knowledge/ABAP/02-functions/bapi-luw-commit.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；[bapi-transaction-search-m3.md](bapi-transaction-search-m3.md)；[extension-2021-evidence-m3.md](extension-2021-evidence-m3.md) | 未闭合：通用模型及扩展特例已登记；目标函数事务证据阻断未解除。 | **暂缓核心** | Work：定向查 `BAPI_PO_CREATE1` 目标版函数文档与 Note，逐项记录提交、回滚、WAIT、RETURN 与失败边界；无法读到即保留缺口。 |
| ABAP-05 | 增强技术与可扩展性；knowledge/ABAP/02-functions/enhancements.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记 FPS01 特定 BAdI 与 MRP 场景。 | **限缩可写** | Work：选定具体增强点，查调用条件、发布状态及适用 FPS，登记未覆盖情形。 |
| ABAP-06 | RFC、接口、异常与幂等；knowledge/ABAP/02-functions/rfc-idempotency.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记特定 RFC/BAPI 案例，非通用幂等证据。 | **限缩可写** | Work：选择具体接口，核事务、超时、回执、幂等与重试合同。 |
| ABAP-07 | ABAP 常用事务码导航；knowledge/ABAP/03-tcodes/development-tools.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；[abap07-tool-evidence-m3.md](abap07-tool-evidence-m3.md)；T | 部分事务入口已有来源；SE80 等待补。 | **限缩可写** | Work：找 SE80 目标版原文，为每个入口列用途、执行影响、权限和 FPS。 |
| ABAP-08 | 开发与增强相关配置查看；knowledge/ABAP/04-configuration/development-and-enhancement.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记特定 BAdI 配置位置；只读入口和权限待核。 | **限缩可写** | Work：为具体配置项查行为、只读路径、所需权限和适用前提；不得执行激活。 |
| ABAP-09 | ABAP 数据模型与字典；knowledge/ABAP/05-data-model/data-dictionary.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记字典概念；具体业务字段与关联缺口。 | **限缩可写** | Work：为虚构或选定业务对象核键、客户端、兼容对象及发布接口。 |
| S4HANA-01 | S/4HANA 2021 技术架构入门；knowledge/S4HANA/01-foundations/architecture-2021.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记平台基础概念；部署及 FPS 不完整。 | **限缩可写** | Work：补目标版应用、HANA、Gateway/Fiori 拓扑及安装前提的直接来源。 |
| S4HANA-02 | HANA 数据处理与性能分析；knowledge/S4HANA/02-functions/hana-performance.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记 SQLMD 功能；无基准测试。 | **限缩可写** | Work：查执行计划与分析工具的目标版本依据，设计可复现指标并标明尚未运行。 |
| S4HANA-03 | CDS 数据建模与权限；knowledge/S4HANA/02-functions/cds-and-access-control.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；[cds-dcl-2021-evidence-m3.md](cds-dcl-2021-evidence-m3.md)；T | 已补 2021 CDS/DCL 个别直接证据；访问路径未全覆盖。 | **限缩可写** | Work：为每个计划访问路径补 DCL、服务授权及版本前提；列不适用路径。 |
| S4HANA-04 | OData 服务和接口治理；knowledge/S4HANA/02-functions/odata-interface-governance.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记 Gateway／OData 及限定授权背景。 | **限缩可写** | Work：选定具体服务，逐项核身份、权限对象、版本、异常和重试。 |
| S4HANA-05 | RAP 在 2021 的能力与限制；knowledge/S4HANA/02-functions/rap-2021.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；[tech-followup-m3.md](tech-followup-m3.md)；T | 已登记 RAP 概述与 2021 初版特定功能，完整矩阵待补。 | **限缩可写** | Work：按 managed/unmanaged、draft、EML、服务类型逐项收集 FPS 证据。 |
| S4HANA-06 | Clean Core 与扩展策略；knowledge/S4HANA/02-functions/clean-core-extensibility.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；[extension-2021-evidence-m3.md](extension-2021-evidence-m3.md)；T | 已登记初版 Key User 与 FPS01 side-by-side 限定场景。 | **限缩可写** | Work：按具体扩展方式补 2021 发布契约、升级影响与回归依据。 |
| S4HANA-07 | 架构常用事务码导航；knowledge/S4HANA/03-tcodes/platform-tools.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | SQLMD/PFCG 局部登记，其余入口待核。 | **限缩可写** | Work：列实际计划入口，逐项查组件、权限、只读和操作影响。 |
| S4HANA-08 | 技术配置与服务只读检查；knowledge/S4HANA/04-configuration/services-and-authorizations.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T | 已登记有限授权背景；服务注册与检查路径不足。 | **限缩可写** | Work：为具体服务建立配置→行为→授权查看→风险表，并逐项找版本来源。 |
| S4HANA-09 | 通用日记账与物料凭证模型；knowledge/S4HANA/05-data-model/journal-and-material-document.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；T；[pp09-order-material-key-m3.md](pp09-order-material-key-m3.md) | 已登记统一日记账局部和特定确认实体键；物理关联未闭合。 | **暂缓核心** | Work：分别查 MATDOC 物理键、兼容对象、业务凭证关联与发布 API，不把实体键当物理键。 |
| AI-Integration-01 | SAP 与 AI 集成基础及适用边界；knowledge/AI-Integration/01-foundations/sap-ai-boundaries.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 通用治理与特定 SAP 背景已登记；具体集成未证。 | **限缩可写** | Work：指定数据源和接口，查产品版本、认证及数据边界。 |
| AI-Integration-02 | 知识检索与 RAG 方案；knowledge/AI-Integration/02-functions/retrieval-augmented-generation.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记 RAG 论文原理；生产权限和接口缺口。 | **限缩可写** | Work：查实际选定方案的授权、来源更新/删除及 SAP 读取接口，并设计失败案例。 |
| AI-Integration-03 | 工具调用与 SAP API 集成；knowledge/AI-Integration/02-functions/tool-calling-sap-api.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记 Toolformer 与限定 AIF 资料；具体调用合同未证。 | **限缩可写** | Work：选定 API，核发布、身份、审批、写入、幂等和超时分支。 |
| AI-Integration-04 | 权限、数据保护与审计；knowledge/AI-Integration/02-functions/permissions-privacy-audit.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记通用治理和特定 HCM 授权示例。 | **限缩可写** | Work：补特定部署的身份、文档 ACL、密钥、日志与留存来源；方案未定先细化。 |
| AI-Integration-05 | 评估、幻觉控制和人工复核；knowledge/AI-Integration/02-functions/evaluation-and-human-review.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记通用评估方向；尚无实测。 | **限缩可写** | Work：制定虚构测试集、分项指标、失败阈值和人工处理，注明待运行。 |
| AI-Integration-06 | AI 集成相关事务码与运维入口；knowledge/AI-Integration/03-tcodes/integration-operations.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记通用监控和特定 AIF 背景。 | **限缩可写** | Work：选定实际接口类型，查每项监控入口、组件、权限和失败处理；未选接口则需细化。 |
| AI-Integration-07 | 集成配置与授权查看；knowledge/AI-Integration/04-configuration/integration-authorizations.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记限定 PFCG、Gateway 及治理背景，服务身份未证。 | **限缩可写** | Work：选定服务后核账号、角色、授权对象、连接和只读查看条件。 |
| AI-Integration-08 | AI 集成数据模型与证据链；knowledge/AI-Integration/05-data-model/knowledge-audit-model.md | [逐篇范围、版本线索与依赖](detail-tech-ai-v0.3.md) | E；A | 已登记来源/溯源背景；数据模型仍是提案。 | **暂缓核心** | Work：为虚构模型定义实体、键、版本、权限及删除规则，逐项补依据并评审。 |
| COMMON-01 | SAP 业务和技术统一术语表；knowledge/common/glossary.md | [逐篇范围、版本线索与依赖](evidence-common-m3.md) | [evidence-common-m3.md](evidence-common-m3.md)；[common-source-fit-m3.md](common-source-fit-m3.md) | 仅部分技术和一般财务术语有语境限定依据；整表未覆盖。 | **限缩可写** | Work：建逐词清单，绑定业务定义、适用产品/FPS、中文译名来源、例子及原文链接；未证词条保持待核。 |
| PROCESS-01 | P2P 采购到付款；business-processes/P2P/purchase-to-pay.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 未闭合 | **暂缓核心** | Work：逐事件补查固定 2021 普通库存采购借贷、税、配置、异常及付款。 |
| PROCESS-02 | O2C 订单到收款；business-processes/O2C/order-to-cash.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：应收收款/清账复核、目标初版/FPS固定资料、逐科目分录/税、部分交货与异常及目标系统条件。 |
| PROCESS-03 | 同公司库存调拨 STO；business-processes/STO-Intercompany/intracompany-sto.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查直接转储及 PO-STO 分支、在途与估价条件。 |
| PROCESS-04 | 跨公司调拨 STO 与内部结算；business-processes/STO-Intercompany/intercompany-sto.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：按变体补查组织、税、分录、清算及异常。 |
| PROCESS-05 | 计划到生产 Plan-to-Produce；business-processes/Plan-to-Produce/plan-to-produce.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：计划→生产→成本结算的完整流程及价值分录。 |
| PROCESS-06 | 来料检验到放行 Quality-to-Release；business-processes/Quality-to-Release/incoming-inspection.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：目标系统设置、EWM及移动类型/凭证字段、财务影响、异常和冲销情形仍待逐项核验。 |
| PROCESS-07 | 记录到报告 R2R；business-processes/R2R/record-to-report.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：企业实际关账顺序、管理会计和分录。 |
| PROCESS-08 | 委外采购；business-processes/Special-Scenarios/subcontracting.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：所有委外采购变体的货权/库存/会计和付款。 |
| PROCESS-09 | 供应商寄售；business-processes/Special-Scenarios/supplier-consignment.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：按场景核对合同货权、税、分录及结算变体。 |
| PROCESS-10 | 采购退货与冲销；business-processes/Special-Scenarios/purchase-return-reversal.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：退货与收货冲销、后续已开票时的凭证与资金。 |
| PROCESS-11 | 发票数量价格差异与冻结；business-processes/Special-Scenarios/invoice-variance-block.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：差异容差、自动冻结与付款释放各触发条件。 |
| PROCESS-12 | 销售退货与贷项；business-processes/Special-Scenarios/sales-returns-credit.md | [逐篇范围、版本线索与依赖](detail-logistics-v0.3.md) | [evidence-logistics-m3.md](evidence-logistics-m3.md) | 部分 | **限缩可写** | Work：补查并核对：退货、退款、抵扣和税务的所有变体及必要前提。 |
| COURSE-01 | 24 个月路线与课程总导航；learning/24-month-roadmap.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：整理路线目标、时长和可选练习；正文链接待后续阶段。 |
| COURSE-02 | 入门：一笔采购的单据物流与资金流；learning/first-purchase.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：登记 FI-01、MM-01、PROCESS-01 正文与证据依赖。 |
| COURSE-03 | 零基础财务与管理会计；learning/finance-controlling-from-zero.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查地区适用依据，登记 FI/CO 正文及答案依赖。 |
| COURSE-04 | MM 与 QM 深化；learning/mm-qm-deepening.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：登记 MM/QM、单位换算及流程原文的证据依赖。 |
| COURSE-05 | 跨模块业务流程；learning/cross-module-processes.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：登记 12 篇流程主文及审核依赖；链接待正文建成。 |
| COURSE-06 | ABAP 与 S/4HANA 技术架构；learning/abap-s4-architecture.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：登记技术原文、目标版接口及权限依据依赖。 |
| COURSE-07 | SAP 与 AI 集成及职业验证；learning/sap-ai-career-validation.md | [逐篇范围、版本线索与依赖](detail-finance-courses-v0.3.md) | [evidence-finance-m3.md](evidence-finance-m3.md) | 未核验 | **暂缓核心** | Work：补查许可可用的 AI 资料，登记 SAP 接口和课程原文依赖。 |

## 批次准入与 M3 总体验收边界

1. 本表完成 99/99 项计划分流；它不代替每篇文章的 claim-level M4 preflight。M4 每批开工记录须列具体主张、直接支持该主张的正文来源及范围、版本／场景、未支持边界、课程／知识关联、责任作者和当期三角色实际可用容量。
2. “限缩可写”项只有在本批选择并完成上述 preflight 后才可写作；“暂缓核心”项在中心断言有证据或所有者批准缩窄范围之前不得把中心断言写成正文事实。五项重点阻碍优先按已批准提案严格限缩。
3. 图书馆级泛化的证据、未锁版本的 Learning 页面、公开索引摘要及最新版资料不能被当作 S/4HANA 2021 On-Premise 直接支持。实机不是所有一般文章的必要门槛；客户系统参数、权限、配置、运行结果等环境专属主张才需相应验证。
4. 文档中原有文章之间的“依赖”多属知识关联，不是逐篇顺序硬门禁；课程路线和确需先读内容按详细计划排序。所有 11 个纯结构导航分类仍不计正式文章。
5. 每篇正式文章继续按三个角色各按需 5～10 个有效质询—答辩—修订判断—复核闭环执行；有严重缺陷时继续修复与复验。文献研究、来源登记、矩阵结构复核及本次 M3 计划复核均不计入文章审核轮数。
6. M3 计划审查与 M4 执行授权仍是两个所有者审批点。所有者已批准的是 CareerOS 项目级 M3 门禁调整，不包含 M3 阶段结果验收或 M4 正文建设授权。

## 生成与核对记录

Work 将 manifest 的 99 个标题／路径与控制矩阵的 99 个逐 ID 来源记录映射，逐行使用原登记状态与既有下一步，按上述保守规则形成新分类；未从外部站点重新检索，也未提高任何原来源证据状态。两个显式开放主题 ABAP-03 调试／运行分析、AI-Integration-08 数据模型／证据链在逐篇范围文件中缺少其核心直接依据，因此从简单“部分资料”类别改列为“暂缓核心”。其余条目按原矩阵：含“未核验／未闭合”者归“暂缓核心”，其他存在有限来源而计划范围尚未全证者归“限缩可写”。每篇仍须过 M4 claim-level 批次门禁。独立审核与表结构核对结果另见新建的 M3 收尾复核记录。
