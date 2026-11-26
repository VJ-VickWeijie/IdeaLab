# CareerOS V0.3｜PROCESS-01 与 FI-07 的 2021 证据补查

原始核查日：2026-11-25（UTC）；状态更正：2026-11-26（Asia/Shanghai）。只做 M3 文献研究，未编写正式正文、未进入 M4、未连接 SAP 系统、未产生正式文章审核轮次。以下区分 PDF 的搜索缓存正文、Help 页面的搜索索引正文与实际网页读取；不会把网页的搜索摘要当成已在浏览器打开的正文。

## 2021 初始版：采购订单、收货和发票的部分连接

- [Post Goods Receipt for Purchasing Document](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/c2be52880d194905a0692f6dce907795.html?version=2021.000)：SAP Help 页面接口固定到 2021 (Oct 2021)，直接读取正文（buildNo 351，返回 HTML SHA-256：7ea146c6fb0e380e19abaf74231e4e59b42964dbc8741097665727a53564e38e）。正文说明该 app 对采购订单参考收货过账的功能范围；另列特定委外序列号、分割估价与 EWM 条件，不能将其当作所有收货变体或会计分录的证据。
- [Manage Workflows for Supplier Invoices](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/51ef12513df44d39bf3778822812813f.html?version=2021.000)：2021 初始版 SAP Help 索引正文描述可针对“发票有至少一项不期望收货”配置工作流，并指出 PO 项目的 Goods Receipt indicator 与该条件有关。只能证明此特定工作流场景的条件，不代表所有采购都必须收货，也不证明对应会计分录。
- [Adjustment of Payment Due Dates in the Case of Public Holidays for Supplier Invoices](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/004109983492485191b538488ea9daf0.html?version=2021.000)：SAP Help 页面接口固定到 2021 (Oct 2021)，直接读取正文（buildNo 351，返回 HTML SHA-256：a76a3021268484a1b4172021c49caf33a0e33e06faf861e753fe769f724d8fc3）。该例为日本本地化：供应商发票在 MIRO/指定 app 的付款到期日遇公共假日时，可按设定调整到期日和现金折扣天数；这不证明发票已支付、银行资金流发生或其它地区付款规则。

## Work/审查者读取方式与版本边界（更正）

上列第 1 条（Post Goods Receipt for Purchasing Document）与第 3 条（Adjustment of Payment Due Dates...）是 Work 读取 SAP Help 页面的 2021.000 版本接口正文；另一顾问随后在浏览器独立重读两页，实际看到版本选择器为 2021 (Oct 2021)。审查者确认正文摘要与局限，但未重算 Work 的 HTML 摘要或核对 buildNo。第 2 条（Manage Workflows for Supplier Invoices）仍仅有 2021.000 搜索索引片段，本文未直接读取其完整正文，不能将该摘要计为已读来源。

另两份资料请分别按[收货与发票估价补查](p2p-valuation-direct-2021.md)的事实状态引用：[Invoices for Purchase Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/be5eb6531de6b64ce10000000a174cb4.html?version=2021.000)的浏览器版本选择器显示 2021 (Oct 2021)，页面同时显示该版文档提示，且已读取正文；/root/reader_m3_review 与 /root/consultant_plan 的既有记录分别说明曾读取与复读此页。[Goods Receipt for a Purchase Order](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/885eb6531de6b64ce10000000a174cb4.html?version=2021.000)由 /root/consultant_plan 正文实读，页面显示 2021 (Oct 2021) 文档提示且说明不随后续版本更新，但读取时版本选择器未显示。不能概括成“未读目标版页面”；后者版本钉定强度仍低于明确选择器显示的页面。

上列直接读取的来源均只能支持各自页面明确限定的流程或功能；FSD、S/4HANA 2021 页面和 SAP Help 特定文章不能拼接成所有场景通用的配置/分录/付款证明。

## 2021 初始版：GR/IR 及清账的具体证据

[What's New in SAP S/4HANA 2021，§3.6.1.14–15，印刷页 146–147](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf)：SAP 官方静态路径 `2021.000`。本次读取搜索服务保留的 PDF 正文；独立直接获取 PDF 字节受服务大小限制，未保存 PDF 或计算哈希。

- §3.6.1.14 介绍针对 GR/IR 科目的 extended open item management 及其大凭证情形；文中对该功能的启用明确涉及不可回退后果，**仅作为研究与只读理解资料，不建议运行激活或修改生产配置**。
- §3.6.1.15 介绍用于 GR/IR 未清项的自动清账程序：展示、模拟与实际更新是三个不同模式。在启用该特定 extended open item management 的前提下，文中规定相应清账程序；不能推广到所有 GR/IR 配置。
- 这支持 2021 的 GR/IR 科目与清账机制存在及特定前提，**不提供通用借贷分录，不代表供应商应付已付清，也不证明库存采购、费用采购、非估价收货的所有变体**。

## 具体会计现象：官方公开预览，限明确条件

[SAP KBA 3644667 公开预览](https://userapps.support.sap.com/sap/support/knowledge/en/3644667) 的网页正文可直接读取，标题覆盖 SAP S/4HANA 2021 及以上。它描述某些汇率差异在收货时计入会计凭证、但在 CKM3 的某列未更新的特定问题。该预览可作为“某个具体条件下收货与会计凭证相连”的证据，**不能证明每次收货一定生成会计凭证，也不提供 PO 全链、通用分录或根因/处理方案**；全文需 SAP 权限，未读取。

## 辅助线索与尚未解决

- SAP FSD 的 `latest` 地址曾返回 SPS08、现返回 SPS10，虽然现版 §2.12.5.1 可说明供应商发票参考采购订单及会计凭证，链接不固定。不得把当前 SPS10 段落认作初始版证据。
- 同前述来源状态更正：Invoices for Purchase Orders 的 2021 (Oct 2021) 选择器及正文已读；Goods Receipt for a Purchase Order 的正文带 2021 (Oct 2021) 固定版提示、但读取时未见版本选择器。两者的具体收货/发票估价例子见 [P2P 估价补查](p2p-valuation-direct-2021.md)；不能把其范围夸大成所有业务变体或全链路过账证据。
- 尚未取得一份**可复现、固定版 2021 官方原文**将标准采购的 PO→收货→发票→应付→实际付款与对应分录端到端逐事件串通；先票后货、价差、GR 非估价、成本中心/资产科目分配、税、币种、采购金额、收货价值、发票金额和付款时点均需具体前提和直接证据。暂不得把 PROCESS-01 或 FI-07 的全部事实标为已验证。
- 文献可阅读性、产品/FPS 适配、具体主张支持性和系统验证为不同状态；实机未测。本记录不批准配置写入或生产操作。


## 2026-11-26｜固定 2021 发票 Account Determination 页面

Work 直接读取 [Account Determination](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/ed84b70c199d4470ae2e5ccb93b2e45b/2a70b6531de6b64ce10000000a174cb4.html?version=2021.000)，版本选择器显示 2021 (Oct 2021)；独立上下文 `/root/mm09_independent_2021_read` 直接复读同一页面并确认版本和有限摘要。页面说明供应商账户/金额、物料估价类/价格控制/物料科目、PO 价格与收货状态、净额/总额设置及 G/L 科目类别如何参与发票过账科目确定；库存是否覆盖发票数量应视为过账时的库存状态比较，不是静态主数据字段。

此页不说明采购收货 OBYC 交易键、BSX/WRX 配置映射或借贷分录，也不证明发票必定入账/付款。它补充 PROCESS-01 与 FI-07 的目标版发票决策因素，但不闭合标准采购 PO→GR→IR→AP→实际付款及其逐笔会计链；正式正文和审核轮次仍为 0。


## 2026-11-26｜通用 SAP Learning 来源独立复核

/root/consultant_m3_review 直接复读三篇 SAP Learning 页面：
- [SAP Learning: Describing Automatic Account Determination](https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/describing-automatic-account-determination)
- [SAP Learning: Managing Goods Movements](https://learning.sap.com/courses/exploring-end-to-end-business-processes-in-sap/managing-goods-movements_d7cf8543-eb45-490b-810a-237bbd17485f)
- [SAP Learning: Managing Closing Activities in Materials Management](https://learning.sap.com/courses/configuring-the-financial-closing-in-sap-s-4hana/managing-closing-activities-in-materials-management)

第一篇 Describing Automatic Account Determination 支持有限的自动科目确定因素，但其发票步骤把 GR/IR 写作贷方；这与第三篇 Managing Closing Activities in Materials Management 明确的发票借 GR/IR、贷供应商不一致。第二篇 Managing Goods Movements 的 Integration to Finance 只明确特定采购收货借库存/贷 GR/IR，不提供发票方向。三页均未固定到 2021/FPS，不用来裁决 2021 Help 的措辞，也不视为 SAP 勘误。正式文章和文章审核轮次仍为 0。
