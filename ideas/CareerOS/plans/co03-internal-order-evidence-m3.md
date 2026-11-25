# CO-03：内部订单基础与结算来源补查（M3）

研究日期：2026-11-25。研究者：独立读者视角执行上下文 `/root/reader_plan`。本记录为来源研究，不是正式文章、正式文章审核、M3 验收或 SAP 实机测试。未连接 SAP 系统，也未修改配置。

## 研究结论

已直接阅读两篇 SAP Learning 正文及一份 SAP S/4HANA 2021.001 官方 PDF。SAP Learning 介绍真实与统计内部订单、成本归集及结算，但本次页面未标明 2021/FPS；固定 2021.001 文档仅支持特定 Central Finance 场景。尚未找到同时覆盖真实/统计内部订单、普通订单归集与结算全链路、且明确适用于 S/4HANA 2021 on-prem 的可读完整原文。

## 已直接读取：SAP Learning

### 1. 内部订单及真实与统计订单

[Using Overhead Orders](https://learning.sap.com/courses/cost-center-and-internal-order-accounting-in-sap-s-4hana/using-overhead-orders)，直接读取 `Internal Orders` 和 `Real and Statistical Orders` 正文。

- 课程以虚构会展活动为例，说明使用独立内部订单分别收集活动成本，再通过结算给负责的成本中心，便于比较各活动。
- 课程说明真实订单可用于收集成本，之后向一个或多个适用接收对象分配；是否结算及接收方取决于具体业务、规则和配置，不能据此断言所有真实订单都必须结算。
- 课程说明统计订单用于附加信息；其例子将成本同时记录到统计订单与真实成本中心。课程称统计订单不能作为发送方结算。该例使用成本中心，不能推断其是所有场景唯一合法的真实对象。
- **版本边界**：课程页面未标明 S/4HANA 2021、on-prem 发行版或 FPS，因此只能作为基础概念与进一步检索线索，不能单独证明 2021 实际行为、客户配置或每个例外。

### 2. 成本过账中的真实和统计对象

[Entering Primary Postings](https://learning.sap.com/courses/cost-center-and-internal-order-accounting-in-sap-s-4hana/entering-primary-postings)，直接读取 `Event-Based Postings on Cost Centers and Account Assignment Logic`。

- 课程说明内部订单主数据区分真实与统计属性，并以过账行为例说明真实订单/成本中心与统计记录之间的区别；统计订单在所述示例中与相应真实成本对象配合使用。
- **版本边界**：同样没有明确 2021/FPS，不能推断特定企业的配置、权限或每个业务例外，也不能据此说在用户系统执行过测试。

## 已直接读取：固定 2021.001 专项官方 PDF

[SAP S/4HANA 2021.001 Central Finance PDF](https://help.sap.com/doc/a9616f4a29354fc297c58499b754e3f8/2021.001/en-US/loio4857c0540cf5ef05e10000000a4450e5.pdf)，网页工具可读解析文本，§1.4.7.2 `Status Check for Central Settlement`，印刷页 69–70。

该节说明，在 **Central Finance 成本对象复制**场景下，可对复制到目标系统的订单进行中心结算；来源订单关闭或删除的状态与未完成结算可能产生冲突，特定状态检查需要相关 SAP Note 和连接、配置等前提。

**限制**：这是 2021.001 的特定中央财务场景，不证明普通非中央财务系统所有订单的结算规则、统计订单全部处理、用户系统的实际 FPS 或配置。文中涉及的配置和维护是来源背景，不是让用户在生产系统执行的步骤。本执行上下文通过网页工具读取正文，没有记录下载原 PDF 字节或哈希。

## 2022 版本反例：仅搜索索引

[Manage Settlement Rules – Internal Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f5d3e1005efd4e86acf9a65abf428082/eee7c0dc080d4645b29a221694ecf029.html?locale=en-US&state=PRODUCTION&version=2022.000) 的公开搜索索引显示该应用 `Valid as Of SAP S/4HANA 2022`。不能将此 Fiori 应用直接写为 2021 可用。本次**仅读取搜索索引**，未直接读取该页面，也未实机核验。

## 剩余缺口

仍需可直接读取的 S/4HANA 2021 on-prem 资料，逐项核对真实/统计订单区别、可结算性、结算规则及接收对象、普通成本归集，以及目标 FPS、权限和企业配置。上述动态课程和中央财务专项材料不能拼接成所有条件均已验证的普通订单全流程。未撰写正式知识正文，未进行系统测试，本次不计正式文章审核轮次。


## 独立复核

`/root/audit_design_review` 独立读取两篇 SAP Learning 正文，确认课程示例区分真实/统计订单和成本中心，并明确统计订单在该课程语境中不能结算。页面未见 2021/FPS 版本声明，不能据此确认目标系统行为；该审查者没有核对本文 Central Finance PDF，不计正式文章审核。
