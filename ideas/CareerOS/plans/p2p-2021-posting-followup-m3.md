# FI-07 / MM-09 / PROCESS-01：2021 初版普通采购借贷补查

日期：2026-11-26（UTC）。M3 文献研究，非正式文章审核；未访问 SAP 系统或业务数据。**本次未直接读到固定 2021 初版、明确无科目分配的库存采购 GR 与 IR 全部分录的 SAP 官方原文，不能宣布缺口关闭。**

## 本次实际直接阅读

1. [SAP Learning：Managing Goods Movements](https://learning.sap.com/courses/exploring-end-to-end-business-processes-in-sap/managing-goods-movements_d7cf8543-eb45-490b-810a-237bbd17485f)，通过网页工具直接读取 Integration to Finance。其估价采购收货、库存物料的示例明确列库存借、GR/IR 贷；该段没有给出 IR 借贷。页面未标 2021/FPS，不能作为固定 2021 原文；亦不证明所有采购收货只有两行。
2. [SAP Learning：Managing Closing Activities in Materials Management](https://learning.sap.com/courses/configuring-the-financial-closing-in-sap-s-4hana-materials-management)，直接读取 Goods Receipt and Invoice Receipt Postings → Three-Step Reconciliation Procedure。其概览明确 GR 库存或消费借、GR/IR 贷；IR 的 GR/IR 借、供应商贷。未标 2021/FPS，不能当作固定 2021 证据，也未穷尽价格、税和费用差异。
3. [SAP Learning：Describing Automatic Account Determination](https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/describing-automatic-account-determination)，直接读取收货/发票例子、科目确定示例与影响因素：特定标准订单无科目分配，涉及库存 BSX、GR/IR WRX、估价类、工厂/估价范围与其他因素。此页未固定 2021/FPS；其 IR 示例在清账情境下写 GR/IR credited，方向与第 2 篇不一致，记录冲突而不宣布 SAP 已勘误。无法据此确定 2021 固定版 OBYC 或所有交易键各自规则；示例数据不证明用户系统配置。

## 本次仅检索线索，未直接读到固定版

- [SAP Financial Operations：Initial Entry of Stock Balances (from Old System), Goods/Invoices Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/3cb1182b4a184bdd93f8d62e3f1f0741/ce5fd353c6244308e10000000a174cb4.html?version=2021.000)。已交协调者尝试浏览器；我只看到 2025 FPS02 的搜索索引，列按业务范围的 GR 与 IR 正负数示例。该页面标题也涉及初始库存，索引未明确无科目分配，不能混同三项业务。必须实读 2021 选择器及上下文、证明正负解释后才能使用；不得将索引当作本次目标版正文。
- [Postings at Goods Receipt and Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000)：本执行上下文打开固定版报不可访问。协调者曾浏览器实读并指出该页将 GR 库存科目写为 credits；这一陈述与上列未固定版本课程的 GR 方向有冲突。应在原文与来源记录中明确冲突，不假称我独立复核该固定版、不称 SAP 已勘误。

既有 [FI-07 图示记录](fi07-grir-taccount-2021.md) 由另一上下文在 2021 (Oct 2021) 浏览器阅读：图示库存及 GR/IR 左右位置和金额；方向解释借助 T 型账户惯例，采购项目无科目分配与税等前提未明确。不能把它冒充本次独立读图或完整满足所需前提。

继续寻找明确 2021.000、普通采购条件、GR/IR 全部分录及 OBYC BSX/WRX/T030 规则的可直接访问官方材料；客户实际授权、配置和凭证仍未验证。上述资料不得拼接成单篇 2021 已证完整流程或任何正文审核轮次。
