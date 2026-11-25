# CareerOS V0.3｜PROCESS-01 与 FI-07 的 2021 证据补查

核查日：2026-11-25（UTC）。只做 M3 文献研究，未编写正式正文、未进入 M4、未连接 SAP 系统、未产生正式文章审核轮次。以下区分 PDF 的搜索缓存正文、Help 页面的搜索索引正文与实际网页读取；不会把网页的搜索摘要当成已在浏览器打开的正文。

## 2021 初始版：采购订单、收货和发票的部分连接

- [Post Goods Receipt for Purchasing Document](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/c2be52880d194905a0692f6dce907795.html?version=2021.000)：SAP Help 搜索索引返回 `What's New in SAP S/4HANA 2021` 的正文片段，明确该 app 可参考采购订单过账收货；页面标 `Available As Of SAP S/4HANA 2021`。直接打开 HTML 返回零行，尚未通过浏览器复核。
- [Manage Workflows for Supplier Invoices](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/51ef12513df44d39bf3778822812813f.html?version=2021.000)：2021 初始版 SAP Help 索引正文描述可针对“发票有至少一项不期望收货”配置工作流，并指出 PO 项目的 Goods Receipt indicator 与该条件有关。只能证明此特定工作流场景的条件，不代表所有采购都必须收货，也不证明对应会计分录。
- [Adjustment of Payment Due Dates in the Case of Public Holidays for Supplier Invoices](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/004109983492485191b538488ea9daf0.html?version=2021.000)：2021 初始版索引正文描述 MIRO 或 Create Supplier Invoice - Advanced 的供应商发票付款到期日可依公共假日规则调整。直接打开 HTML 返回零行；这说明发票记录有到期日，**不能证明发票已支付、发生银行资金流或所有付款规则**。

这些网页均是 SAP 2021.000 版本参数下的搜索索引结果；索引可漂移，尚缺可读原网页/固定快照的独立复验。

## 2021 初始版：GR/IR 及清账的具体证据

[What's New in SAP S/4HANA 2021，§3.6.1.14–15，印刷页 146–147](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf)：SAP 官方静态路径 `2021.000`。本次读取搜索服务保留的 PDF 正文；独立直接获取 PDF 字节受服务大小限制，未保存 PDF 或计算哈希。

- §3.6.1.14 介绍针对 GR/IR 科目的 extended open item management 及其大凭证情形；文中对该功能的启用明确涉及不可回退后果，**仅作为研究与只读理解资料，不建议运行激活或修改生产配置**。
- §3.6.1.15 介绍用于 GR/IR 未清项的自动清账程序：展示、模拟与实际更新是三个不同模式。在启用该特定 extended open item management 的前提下，文中规定相应清账程序；不能推广到所有 GR/IR 配置。
- 这支持 2021 的 GR/IR 科目与清账机制存在及特定前提，**不提供通用借贷分录，不代表供应商应付已付清，也不证明库存采购、费用采购、非估价收货的所有变体**。

## 具体会计现象：官方公开预览，限明确条件

[SAP KBA 3644667 公开预览](https://userapps.support.sap.com/sap/support/knowledge/en/3644667) 的网页正文可直接读取，标题覆盖 SAP S/4HANA 2021 及以上。它描述某些汇率差异在收货时计入会计凭证、但在 CKM3 的某列未更新的特定问题。该预览可作为“某个具体条件下收货与会计凭证相连”的证据，**不能证明每次收货一定生成会计凭证，也不提供 PO 全链、通用分录或根因/处理方案**；全文需 SAP 权限，未读取。

## 辅助线索与尚未解决

- SAP FSD 的 `latest` 地址曾返回 SPS08、现返回 SPS10，虽然现版 §2.12.5.1 可说明供应商发票参考采购订单及会计凭证，链接不固定。不得把当前 SPS10 段落认作初始版证据。
- [Invoices for Purchase Orders，目标 2021.000 页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/be5eb6531de6b64ce10000000a174cb4.html?version=2021.000) 和 [Goods Receipt for a Purchase Order，目标 2021.000 页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/885eb6531de6b64ce10000000a174cb4.html?version=2021.000)：本研究上下文目前只找到默认版或其他产品版本的索引内容，未能自行读到目标版；另一个执行上下文此前已实际读取这两个 2021 页面，详见 [P2P估价补查](p2p-valuation-direct-2021.md)，不能把另一个上下文的读取说成本研究者本人所做。
- 尚未取得一份**可复现、固定版 2021 官方原文**将标准采购的 PO→收货→发票→应付→实际付款与对应分录端到端逐事件串通；先票后货、价差、GR 非估价、成本中心/资产科目分配、税、币种、采购金额、收货价值、发票金额和付款时点均需具体前提和直接证据。暂不得把 PROCESS-01 或 FI-07 的全部事实标为已验证。
- 文献可阅读性、产品/FPS 适配、具体主张支持性和系统验证为不同状态；实机未测。本记录不批准配置写入或生产操作。


## 复核状态

本条 P2P 补查由 `/root/consultant_m3_review` 汇总；各项标注其自身实际读取方式及未覆盖内容，独立审查者尚未复核本报告，不计正式文章审核轮次。
