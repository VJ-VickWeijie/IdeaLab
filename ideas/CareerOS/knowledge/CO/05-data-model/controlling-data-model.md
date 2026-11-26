# CO-08｜管理会计数据模型：理解统一日记账，但不猜表关系

> **状态：drafting（受限草稿，字段级模型与对象关系未闭合）**  
> **目标版本：SAP S/4HANA 2021 On-Premise。** 本文面向 FI/CO 初学者，中文为主并保留英文 SAP 术语。M3 对本篇的准入为“暂缓核心”：逐项核对 CO 对象、字段、主键、基数、兼容视图、API 和版本，不用未经证实的对象关联填空。  
> **验证边界：** 未连接 SAP 系统；没有读取客户字典、表数据、权限或运行结果。本文不是可直接执行的 SELECT/JOIN 指南，不提供表键或数据抽取方案。

## 1. 先从业务问题理解“数据模型”

财务会计（FI）更关心财务报告，管理会计（CO）还要支持内部管理决策。SAP 2021 转换资料把两类报告都放在统一日记账的报告存储背景中，account 是其中的统一元素。[E1] 这表示报告数据存储可以有统一背景，不表示 FI 与 CO 的业务目的、单据规则或每个对象模型相同。

把它当成**报告数据结构的高层概念**来学，不要理解成“所有 FI/CO 对象都变成一张含全部字段的普通表”。资料没有据此定义每种业务对象的物理持久化、主键、行数或 JOIN 关系。业务上说“按成本中心、订单或产品看成本”，也不能直接推成某个对象号必然在哪张表、占几行、如何连到财务凭证。

本文只展示三个目标版资料有明确边界的例子：

1. **报告层背景：**2021 Simplification List 在系统转换语境中说明统一日记账和报告数据存储；其中也讲到兼容视图（compatibility views）的历史作用。[E1 §8.1]
2. **Margin Analysis 的窄范围：**S/4HANA 2021 What's New 说明，Margin Analysis 是 account-based profitability analysis，values 和 characteristics 过账到 ACDOCA。[E2 §3.5.6.4]
3. **特定生产成本汇总：**2021.000 文档描述一种 deferred summarization of production costs：该特定功能运行后，详细 journal-entry 信息移动到 ACDOCD，汇总信息仍留在 ACDOCA。[E3]

这三条回答的是不同问题，不构成一张完整 CO 数据模型图。

## 2. 目标版证据映射

| 数据层/例子 | SAP S/4HANA 2021 来源支持的内容 | 适用范围与不可推出项 |
| --- | --- | --- |
| 财务报告的一处统一文档存储 | SI21 §8.1 说明 Universal Journal 改变交易数据的财务报告存储方式；其业务价值段落描述多类会计报告从同一 document store 读取，并以 account 作为统一元素。[E1] | 这是高层转换/报告背景，不等于每一个管理会计对象、凭证种类或客户扩展字段都具有相同表结构。来源没有给出成本中心/内部订单到凭证的字段关系、主键或基数。 |
| Margin Analysis | 2021 What's New §3.5.6.4 将 Margin Analysis 描述为 account-based profitability analysis；values 和 characteristics 过账到 ACDOCA。[E2] | 限于 Margin Analysis 的账户式范围；不推广到 costing-based CO-PA、全部 CO 业务对象或任意客户系统设置。 |
| 生产成本 deferred summarization | 在该特定 2021 功能中，详细 journal-entry 信息从 ACDOCA 移到 ACDOCD，汇总信息留在 ACDOCA；页面说明该能力针对异常大的数据量，并提示汇总会限制报告灵活性。[E3] | 是特定汇总功能与条件，不是普通制造成本每次过账的通用存储流程。不能据此说明详细/汇总行如何关联，或推导任何成本对象的普遍表键。 |
| 旧总额/应用索引对象及兼容视图 | SI21 §8.1 的转换说明记载：在其描述的 Simple Finance / S/4HANA 早期版本转换场景，部分 totals 与 application index tables 被同名 DDL SQL compatibility views 替代；资料指出数据库 SELECT 兼容性及写访问移除/改造要求。[E1] | 这一历史转换背景不能被当成 2021 客户环境可直接依赖的表/API 契约。文档没有让读者据此对兼容视图做写入，也没有证明任意旧表都能在每个 S/4HANA 2021 FPS 以相同方式使用。 |

### 一段示例：不要从“统一”跳到“能直接 JOIN”

假设管理者要分析某个管理对象的成本，业务问题是“哪些记录属于这个对象、能否按会计期间汇总”。目前三份来源只能说明：报告领域存在统一日记账背景；Margin Analysis 有明确的 ACDOCA 关联；某种特定生产成本汇总还会涉及 ACDOCD。

因此可以安全地说“数据模型与分析功能有关”；**不能**仅凭这些材料写出“成本中心编号等于某字段”“订单与财务行项目一对一”“用某个主键 JOIN 某表”“某 API 已 released”。这是本篇根据不同来源分别描述不同范围作出的边界判断，而不是对客户系统关系的实测结论。[E1][E2][E3]

## 3. 兼容视图是什么：只讲目标版资料能支持的程度

兼容视图（compatibility view）是转换资料中用于解释旧数据访问兼容性的名称。SI21 §8.1 的历史说明写到，所列转换场景中的部分旧 totals/application index 表由 DDL SQL views 替代，帮助数据库 SELECT 按既有方式工作；同一段明确指出标准写访问已经移除，或须从自定义代码中移除。[E1]

初学者可先记住两个边界：

- “旧名字仍可供特定 SELECT 兼容”不等于“旧物理表还按旧方式存储”；
- “兼容视图”也不自动等于 released CDS view、稳定 API 或可供客户代码依赖的正式接口。

该资料讨论 Simple Finance 与早期 S/4HANA 转换历史，并列出部分来源/备份对象例子。它没有提供本篇所需的 CO 全部旧表—新表映射、字段、键、组织范围或目标系统差异，因此正文不列 COSP/COSS 等为通用技术路径，也不写 SQL 示例。

## 4. 本篇明确留白的技术问题

以下结论需要固定版本的数据字典、对象文档、released API 文档，或经授权的目标系统证据；当前不作肯定断言：

- 成本中心、内部订单、生产订单等对象的字段、表名、主键和键组成；
- 每种 CO 对象与 ACDOCA 或其他凭证/行项目对象的关系基数、连接键及组织范围；
- ACDOCA/ACDOCD 在 deferred summarization 案例中的逐行关系和完整技术模型；
- COSP、COSS、COEP 等候选历史对象在目标 2021 FPS 的物理对象、兼容视图、DDL source、适用限制和查询契约；
- 哪些 CDS/API 属于 released interface、支持何种读取场景、过滤/分页及授权要求；
- 客户启用了 Margin Analysis、deferred summarization 或其他具体 CO 功能的状态；
- 某个用户、业务角色或服务账号实际能否读取这些对象。

本文没有编造表字段、主键、JOIN、基数、API、权限或客户数据结果。FI-07 普通采购库存借贷、税和自动科目规则仍开放；本篇没有推导相关分录。

## 5. 离线理解练习

不连接系统，只根据文中证据回答：

1. “Universal Journal 统一”能否证明所有 CO 对象都储存在同一表、字段相同？——不能；E1 是报告存储高层背景。
2. ACDOCA 和 ACDOCD 在什么情境下同时出现？——E3 的特定生产成本 deferred summarization；不能推广为普通流程。
3. Margin Analysis 写入 ACDOCA，是否意味着 costing-based CO-PA 使用相同持久化？——E2 只支持 Margin Analysis，不足以推出另一方案。
4. 可以从这些资料直接写数据库 JOIN 吗？——不能；键、基数、字段和 API 都未闭合。
5. “兼容视图支持 SELECT”是否意味着可对旧对象 INSERT/UPDATE？——不能；E1 在转换说明中明确指出写访问需要移除或改造。

## 6. 来源登记

| 编号 | 来源与定位 | 本文使用范围 |
| --- | --- | --- |
| E1 | [Simplification List for SAP S/4HANA 2021 – Initial Shipment, FPS 1 & 2](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)，v1.25；§8.1，印刷页 200–201。 | 转换/报告中的统一文档存储与兼容视图背景。该节的早期 Simple Finance/S/4HANA 转换叙述没有覆盖本篇需要的 CO 对象字段级关系。 |
| E2 | [What's New in SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/doc/4eefc5f2d826408f91a999687d31780f/2021/en-US/WN_OP2021__EN.pdf)，§3.5.6.4，印刷页 122。 | Margin Analysis 的 account-based 语境及 values/characteristics 与 ACDOCA 的特定关联。 |
| E3 | [Deferred Summarization of Production Costs](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b8102751e57e4de2ad50ec07253127e0.html?version=2021.000)，固定版 2021.000。 | 仅用于描述生产成本 deferred summarization 的 ACDOCA/ACDOCD 特殊示例及其报告限制，不作一般 CO 数据模型说明。 |

SAP 系统未连接；没有查询 DDIC、表内容、CDS/API、授权角色或客户数据。本文没有提供可运行的数据库语句。
