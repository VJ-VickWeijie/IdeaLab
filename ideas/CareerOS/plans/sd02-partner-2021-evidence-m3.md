# SD-02：客户业务伙伴角色与伙伴职能的 2021 来源核验

## 核验范围与方法

本记录由配置顾问审查上下文独立整理，属于 M3 来源研究，不是正式文章审核轮次。以下四个 SAP 官方网页均已由本审查者在浏览器中实际读取正文；各页版本选择器均显示 **2021 (Oct 2021)**，页面说明该文档不随其后续 shipment 更新。链接保留固定版本参数。没有登录 SAP 系统，未验证实际配置、事务或权限。

## 1. 客户伙伴职能和确定规则

[SAP S/4HANA Sales: Partner Functions，2021](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/7b24a64d9d0941bda1afa753263d9e39/806fbd534f22b44ce10000000a174cb4.html?version=2021.000)

- 页面说明 partner function 用于定义业务交易中各业务伙伴的权利与责任。客户类型的标准示例包括 sold-to party、ship-to party、bill-to party 和 payer。
- 原文列举的数据示例分别是：sold-to 的销售数据，如销售办公室或价目表；ship-to 的卸货点和收货时间；bill-to 的地址、单据打印和电子通信数据；payer 的开票计划和银行数据。这些是原文示例，不是所有适用字段的穷尽列表。
- 同一客户可以承担全部伙伴职能；也可由分支机构订货、总部付款。后者涉及相应数量的客户主记录，并在 sold-to 的客户主记录中用相应客户编号关联各职能。
- 原文说明，针对客户及供应商伙伴类型，在配置中定义哪些账户组可用于哪些伙伴职能；partner determination procedure 规定特定业务交易允许或必须的职能。不能把四个示例直接推成所有场景和所有系统配置中固定必填。

## 2. Business Partner 角色和 Fiori 角色导航

[SAP Business Partner: Manage Business Partner Master Data，2021](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/74b0b157c81944ffaac6ebc07245b9dc/e28f3bd8baff43b7a63287cf47ea5f60.html?version=2021.000)

- Role Deletion 段说明一个 BP 可以分配多个角色，明确列出 FLCU00（FI Customer）和 FLCU01（Sales Customer）；同段还列出供应商角色等。
- Role Based Navigation 段举例选择 FLCU01（Customer），通过角色导航进入 Manage Customer Master Data 维护客户销售数据。这是该 Fiori 应用的描述，不能据此认定所有 UI 和系统的操作完全相同。
- 页面说明使用该应用须分配业务角色 `SAP_BR_BUPA_MASTER_SPECIALIST`。这是一项该应用文档中的前提，不证明某个实际用户具有足够的系统权限，也不替代对具体系统授权及配置的核验。
- **原文内部不一致**：Role Deletion 表格案例 1 将 FLVN00 标注为 Sales Customer，但同一案例的处理说明又将其视为唯一 Supplier 角色，而该表前的正文将 FLVN00 明确列为 FI Supplier。记录此冲突，不复制案例 1 的不一致标注；FLCU00、FLCU01 的上述映射以表前正文为依据。

## 3. 客户主数据的组织层级

[SAP S/4HANA Sales: Business Partner Master Data Structure，2021](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/7b24a64d9d0941bda1afa753263d9e39/776fbd534f22b44ce10000000a174cb4.html?version=2021.000)

- General data 不依赖公司代码、销售与分销组织或采购组织；页面举公司名称、地址和电话号码等示例。
- Company code data 只适用于一个公司代码，页面举 account management data 等例子，并说明访问相应视图需指定客户或供应商编号及公司代码。
- 一个客户的数据可以因销售区域而异；销售区域由 sales organization、distribution channel 和 division 组合而成。页面所举销售与分销数据包括 pricing data、delivery priority 和 shipping conditions。维护时要指定客户编号和销售区域；处理销售订单等销售业务前需要维护客户的销售与分销数据。
- 页面还称，开票需要维护 payer 伙伴职能的 Financial Accounting 视图数据。上述各层级和字段均按原页面给出的范围引用，不应当成各类视图的完整字段清单或将其混同。

## 4. 基于账户组的字段状态与界面范围

[What's New in SAP S/4HANA 2021: Field Status Control Based on Account Groups，2021](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/06c953e341b146a594a0d38aa87670e8.html?version=2021.000)

- 页面 Technical Details 标明 Valid as Of SAP S/4HANA 2021。它说明可在客户或供应商账户组配置中，对一般数据、公司代码、销售区域或采购数据字段定义可选、必输、隐藏和显示状态；具体适用组织层级取决于是客户还是供应商。
- 对页面列出的 Fiori 应用而言，原文限定：此字段属性呈现只针对标准客户/供应商角色，并只覆盖相应标准 Fiori UI 实际存在的字段；页面还说明 Maintain Business Partner WebGUI 应用会反映相关字段属性。
- 原文提醒：将字段设为必输前，须验证该字段存在于相关 Fiori 标准 UI，否则可能出现无法通过 UI 修复的后台错误。本记录未实际操作或测试该行为。

## 概念区分与剩余缺口

Business Partner **role**（如 FLCU00、FLCU01）表示伙伴主数据所具备的业务角色；客户 **account group** 与客户主数据控制和可用伙伴职能等有关；**partner function** 则表达业务交易中伙伴承担的职能。三者不能混为同义词。四个伙伴职能可以由同一客户承担，也可以按业务与配置由不同客户承担。

本轮没有核查 BP **grouping**（业务伙伴分组）及其编号分配的 2021 固定版本直接来源，不能把 grouping 当作 BP role 的同义词，也不能把本记录当作对其具体配置的证实。页面材料不能证明某个特定企业中伙伴确定、字段状态、授权、UI 或客户主数据的实际配置；也未覆盖所有事务代码、表字段和接口。正式文章仍需针对具体技术及业务主张补充来源，并按项目规定完成独立角色审核和复核。


## 独立复核

`/root/audit_design_review` 通过浏览器独立读取上述第1、2页，确认选择器为 2021 Oct、伙伴职能与 BP role 不同，以及页面 Role Deletion 表中 FLVN00 的内部不一致；不能断言 SAP 已发布勘误。该审查者未审第3、4页，不代表全部字段或实际权限已核实，也不计正式文章审核。


审查记录：`/root/audit_design_review` 复核 `82410979f8254cfb3f58fd3f1a71973d6f02076e` 时指出原账户组句子语义重复，Work 已按其所读 2021 原文精确修订；原审查者复读 `e737b344f1f6653ab642439392715f92b87470b1` 并确认此句与原文一致，限该文字问题关闭，不计文章审核轮次。
