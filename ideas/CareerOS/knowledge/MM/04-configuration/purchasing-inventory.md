# MM-09｜采购与库存配置查看

> **状态：drafting（核心自动科目确定证据未闭合）**  
> 目标系统：SAP S/4HANA 2021 On-Premise。本文用固定版官方资料说明目前能够确认的范围，并明确普通估价库存采购收货的 OBYC/科目映射仍待核实。  
> 草稿日期：2026-11-27（Asia/Shanghai）

## 本文要解决什么

采购订单收货和供应商发票会影响库存及财务过账。学习时需要分清三件事：业务单据提供了什么信息、系统采用什么设置、固定版资料到底证实了哪些账户确定规则。本文先把 S/4HANA 2021 官方帮助中能直接支持的范围讲清楚；不把通用课程、较新版本或搜索摘要当成 2021 On-Premise 的完整配置说明。

本文用**标准采购订单、无科目分配、计划进入估价库存的收货**作为待调查的学习场景；这只是范围标签，不代表 2021 来源已经证实该场景的完整会计行为。此处“无科目分配”表示订单项目没有直接指定成本中心等成本对象；业务背景见 [MM-04](../02-functions/requisition-po.md)。已有 2021 资料能描述采购收货估价示例，也能说明发票科目确定所考虑的数据类别及 GR/IR 中间科目的角色；但这些资料尚未证明该普通收货场景中 BSX、WRX 的完整过账方向、触发条件和 OBYC 配置映射。因此本文保持 drafting，不提供可据此配置系统的科目表或 IMG 路径。

## 固定版资料目前支持的内容

| 主题 | SAP S/4HANA 2021 资料能支持的内容 | 不能据此推出 |
| --- | --- | --- |
| 发票科目确定的输入类别 | 固定版 **Account Determination** 页面说明：发票过账时，科目分配会综合发票录入的信息、物料主数据、已过账单据和系统设置。页面举例包括供应商与金额、估价类和价格控制、物料对应科目、采购订单价格、是否已过收货，以及净额/总额过账和总账科目设置。 | 这页讨论的是发票过账时的因素类别；它没有列出普通收货的 OBYC 规则、BSX/WRX 交易键确定条件、具体 G/L 科目、配置屏幕或权限。 |
| GR/IR 中间科目角色 | 固定版 **Important Accounts for Invoice Verification** 将 GR/IR clearing account 描述为 stock account 与 vendor account 之间的中间科目，说明收货与发票过账如何在该账户衔接。页面没有给出完整的借贷分录表，也没有覆盖所有采购条件。 | 不据此补出完整凭证、税费、计划交货成本、价格差异、特殊库存或不同科目分配情形。 |
| 采购订单收货的估价 | 固定版 **Goods Receipt for a Purchase Order** 说明采购订单收货通常按价值更新，但不保证所有收货都估价；页面示例可按给定的订单和发票前提计算收货价值。 | 收货价值示例不等于已确定过账到哪个 G/L、使用哪个 OBYC 交易键，或证明所有收货都产生相同的财务行。 |

这些资料可以帮助学习者识别“发票科目确定要考虑哪些信息”“GR/IR 在采购收货与发票流程中的概念角色”，但不组成一份普通库存收货配置指南。

Account Determination 页面还提到可用库存是否少于发票数量。这里应理解为发票过账时检查的库存覆盖状态，不是静态物料主数据字段。页面给出的是信息类别和例子，并非精确字段名、数据库/API 映射、计算公式或已发布接口合同。

用学习语言说，GR/IR 是收货与供应商发票之间的中间核对科目：货物收到了，但发票可能尚未过账；之后发票再与这笔中间记录衔接。固定版页面支持这一概念关系，没有给出普通采购收货的完整借贷表或所有差异情形。固定版发票因素列表**不能直接移用于收货**，也不能据此推导收货时具体的 OBYC 映射。

## 保留方向表述冲突

固定版关联页面 **Postings at Goods Receipt and Invoice Receipt** 对收货金额使用了“credit the value … to the stock account”的措辞，但正文没有提供借贷表。固定版 **Important Accounts for Invoice Verification** 只说明预期净发票金额进入 stock account、对方进入 GR/IR，没有标明借方或贷方。

另有未锁定为 S/4HANA 2021 的 **Managing Goods Movements** 收货示例明确展示库存借方、GR/IR 贷方；另两篇课程 **Describing Automatic Account Determination** 与 **Managing Closing Activities in Materials Management** 的发票步骤表述还存在方向不一致。由于这些学习页面没有目标版本标记，它们不是固定版 2021 规则，也不能拿来裁定或改写固定版 SAP Help。本文保留各自交易阶段和来源，不判定 SAP 系统错误，也不把某一方向写成已由固定版完整分录表证实。

因此，本篇**不要求读者背库存/GR/IR 的借贷方向**。在取得相互一致且适用于该场景的固定版完整分录证据前，应把方向记为待核事实，而不是任选一种表述套用。

## OBYC、BSX 与 WRX：仍待固定版证据

M3 登记的待核问题是：在上述普通估价库存收货中，库存与 GR/IR 的过账如何由目标版自动科目确定规则产生；项目检索到的代码名 BSX、WRX 是否以及在什么条件下用于该场景；估价类、估价范围/分组、账户修改、移动类型及其他业务条件如何影响最终总账科目。**BSX/WRX 在本文只是待核的代码名和检索词，固定版资料尚未证实它们在该场景中的触发条件或科目映射。**

当前读到的固定版页面没有给出这些交易键的完整映射或决定字段。不能从未锁版的 Learning 教材、S/4HANA 2025/2026 Best Practices 示例、特定迁移场景或特殊科目分配 PO，拼接出一套声称适用于普通 2021 库存收货的规则。精确 IMG 节点、可用只读入口、角色权限和当前公司代码配置也没有证据支持，本文不列出事务码或 Fiori app 作为操作指引。

## 学习时的概念检查清单（不是 SAP 操作路径）

没有证据建立 S/4HANA 2021 的 GUI/Fiori 导航、T-Code、只读应用或角色路径。以下只是纸面学习清单，不是可照做的 SAP 操作步骤：

1. 标出当前问题发生在**收货**还是**发票**；固定版 Account Determination 页的因素列表针对发票过账，不可直接挪作收货规则。
2. 记录待调查的场景前提：采购订单项目是否有科目分配、是否进入估价库存、收货与发票先后、物料估价信息、订单价格以及是否涉及额外费用。这些只是核对情境的记录项，不是已由目标版来源确认的 BSX/WRX 决定因素。
3. 把来源明确写出的事实与待验证项分栏。本文没有验证任何事务码、Fiori app、角色或实际配置；如在练习系统查阅已有单据，必须使用该环境另行确认且已授权的显示路径，本文不提供导航承诺。
4. 在取得固定 2021 的直接证据前，不根据文章示例自行更改 OBYC 或总账科目映射。

### 无需 SAP 系统的练习

假设你要解释一个采购发票为什么采用某个总账科目。根据固定版 **Account Determination** 页面，把线索分成四组：发票输入、物料主数据、已过账单据、系统设置。然后回答：

- 页面是否足以告诉你当前公司的具体 G/L 科目？**不能**，它只列影响信息类别。
- 这些发票侧因素是否自动证明普通收货的 BSX/WRX 规则？**不能**，收货配置条件仍缺直接证据。
- 如果另一篇未锁版课程与固定版页面的方向措辞不同，应该如何处理？**保留来源、版本和原文差异，继续查目标版；不要自行宣布哪一页有误。**

相关业务背景可参阅 [MM-04 采购申请与订单](../02-functions/requisition-po.md)、[MM-05 库存类型与货物移动](../02-functions/stock-movement.md) 和 [MM-06 收货、退货与冲销](../02-functions/gr-returns-reversal.md)。这些文章介绍业务概念，不替代本篇尚缺的科目确定配置依据。

## 来源与证据边界

1. **SAP Help — Account Determination, SAP S/4HANA 2021 (Oct 2021)**：[固定版本页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/ed84b70c199d4470ae2e5ccb93b2e45b/2a70b6531de6b64ce10000000a174cb4.html?version=2021.000)。支持发票过账的影响信息类别；不提供普通收货 BSX/WRX 映射。
2. **SAP Help — Important Accounts for Invoice Verification, SAP S/4HANA 2021 (Oct 2021)**：[固定版本页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2d70b6531de6b64ce10000000a174cb4.html?version=2021.000)。支持 GR/IR 中间账户的概念角色；不提供借贷表或 OBYC 规则。
3. **SAP Help — Postings at Goods Receipt and Invoice Receipt, SAP S/4HANA 2021 (Oct 2021)**：[固定版本页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000)。页面含“credit the value … to the stock account”的方向措辞，但没有完整凭证表；保留其表述，不自行改写。
4. **SAP Help — Goods Receipt for a Purchase Order, SAP S/4HANA 2021 (Oct 2021)**：[固定版本页面](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/885eb6531de6b64ce10000000a174cb4.html?version=2021.000)。仅支持采购订单收货通常估价及页面示例中的价值计算，不支持 G/L 科目映射。
5. 项目 [M3 物流证据登记](../../../plans/evidence-logistics-m3.md) 和 [MM-09 来源补查记录](../../../plans/mm09-obyc-source-followup-m3.md)：记录了固定版来源边界、未锁版本课程方向差异与仍未解决的 OBYC/BSX/WRX 缺口；这些研究记录不计正式文章审查。

以下 SAP Learning 页面没有标明 S/4HANA 2021/FPS，仅作为冲突来源登记，不用于定裁本文的固定版主张：[Managing Goods Movements](https://learning.sap.com/courses/exploring-end-to-end-business-processes-in-sap/managing-goods-movements_d7cf8543-eb45-490b-810a-237bbd17485f) 的收货示例列库存借方、GR/IR 贷方；[Describing Automatic Account Determination](https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/describing-automatic-account-determination) 与 [Managing Closing Activities in Materials Management](https://learning.sap.com/courses/configuring-the-financial-closing-in-sap-s-4hana-materials-management) 的发票步骤方向表述不一致。不能将这些页面拼接成固定版完整会计流程。

## 未解决项

- 普通无科目分配、估价库存采购收货的固定 2021 完整会计分录与借贷方向。
- OBYC/BSX/WRX 的目标版决定规则、交易键触发条件及精确配置映射。
- 估价类、估价范围/分组、账户修改、移动类型、价格控制等条件与业务情形的对应关系。
- 有依据的 GUI/Fiori 只读查看路径及权限前提。
- 固定版原文方向冲突的可解释证据。

在核心证据补足并经原审查角色复核前，MM-09 保持 drafting，不计入 reviewed。SAP 系统未连接，没有实机测试或权限验证。
