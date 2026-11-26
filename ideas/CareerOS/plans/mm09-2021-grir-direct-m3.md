# MM-09｜S/4HANA 2021 GR/IR 帮助页直读（M3）

核验日期：2026-11-26（Asia/Shanghai）。性质：公开 SAP 官方文档研究；Work 与一个独立审查上下文分别直接读取页面。未登录 SAP、未检查客户配置、未执行系统交易；不是正式文章或文章审核轮次。

## 页面与版本

1. [Important Accounts for Invoice Verification](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2d70b6531de6b64ce10000000a174cb4.html?version=2021.000)，版本选择器显示 **2021 (Oct 2021)**，页面说明文档未包含后续版本修改。
2. [Postings at Goods Receipt and Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000)，由第一篇正文中的关联链接进入，目标地址保留 `version=2021.000`；独立审查者也确认版本选择器显示 **2021 (Oct 2021)**。

## 可支持的有限主张

第一篇将 GR/IR clearing account 描述为 stock account 与 vendor account 之间的中间科目：收货时，预期的净发票金额进入 stock account，对方进入 GR/IR；发票过账时 GR/IR 再与 vendor 侧过账相抵。该段可支持流程角色和科目关系，但没有列出会计凭证表格或借贷栏，也没有说明普通无科目分配采购订单、税费及所有估价条件。

关联页面说明收货金额按“收货数量 × 采购净价”描述，并使用“credit the value ... to the stock account”的方向措辞。其正文没有借贷分录表。该词句与常见库存采购收货示例中库存借方的表述存在冲突；冲突是文档表述证据边界，不足以推断系统错误，也不能自行将 SAP 原文改写成相反方向。另一顾问独立读取的 SAP Learning 示例明确列出库存借方、GR/IR 贷方，但课程未固定 2021，不能用它覆盖或修正 2021 Help 原文。

## 不支持的结论及缺口

这些页面没有说明 OBYC 的 BSX、WRX 配置映射、交易键确定字段、估价类/估价分组、账户修改码、移动类型条件、T-Code/Fiori 权限，也没有完整涵盖价格控制、计划交货成本、特殊库存、科目分配及税务变体。它们因此只补充了固定 2021 的 GR/IR 概念关系，不能关闭 MM-09 的自动科目确定门槛。

继续寻找可直接读取且与 S/4HANA 2021 on-prem 范围相符的 OBYC 配置与交易键依据。若借贷方向仍存在原文冲突，应在后续文章中明确场景和来源限定，不把推断写成已由 2021 SAP 原文确认。

## 独立复读

独立审查上下文 `/root/mm09_independent_2021_read` 直接读取了两页，确认 URL 版本参数及两个页面上的 2021 (Oct 2021) 选择器，并复述了上述 GR/IR 关系与方向歧义。审查者判断：这两页支持有限的 GR/IR 业务关系，但不支持 MM-09 所需的借贷方向或 OBYC 规则，MM-09 仍未闭合。该复读仅为 M3 资料交叉核验，不计正式文章审查轮次。
