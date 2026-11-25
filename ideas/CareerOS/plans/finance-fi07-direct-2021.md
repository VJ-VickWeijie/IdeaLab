# CareerOS M3｜FI-07 采购收货、发票与 GR/IR：SAP 2021 初版直接证据

状态：M3 来源研究；不是正式知识正文、正式文章审核或 SAP 实机测试。记录日期 2026-11-25。研究者是先前财务台账的作者，对自己补充的来源由另一独立上下文作限定范围复核，见文末。已获批准的阶段与范围不等于 M3 已通过或 M4 已授权。

## 实际查看方式与版本

公开搜索首先找到 SAP 帮助相同主题的新版页面，但其默认版本为 2025，不能用作 2021 的证明。之后通过浏览器打开下述明确 `version=2021.000` 的 SAP Help 页面，等页面完整加载，再同时读取可访问文本和可见示意图。四个成功页面的版本选择器实际显示 **2021 (Oct 2021)**，且页面提示该版不包含后续交付的更新，因此仅支持所见的 2021 初版具体描述，不代表所有 FPS、SAP 系统实际配置或后续变化。

## 来源与有限结论

1. [Postings at Goods Receipt and Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000)，`Sourcing and Procurement → Further Functions → Evaluation → MM - Material Price Change → Price Control`。浏览器版本为 2021 (Oct 2021)。页面正文说明收货和发票通过 GR/IR 过渡；**实际可见图示**为采购单 50 件、每件 2 美元、总值 100 美元：收货栏显示 `stock account 100 +`、`GR/IR account 100 −`；发票栏显示 `GR/IR account 100 +`、`vendor account 100 −`。该页文字与图示不构成可无条件推广到所有企业的分录。图中的 `+` / `−` 不是图示明确写出的“借方 / 贷方”；英文正文还使用了 `credits` 描述库存过账，如何与图中正负及借贷方向对应仍须独立证据核查。图中没有明确给出税、发票差异、企业会计政策或账户配置，不能补造。

2. [Important Accounts for Invoice Verification](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2d70b6531de6b64ce10000000a174cb4.html?version=2021.000)，`Invoice Management → Invoice Processing → Further Information → Account Determination`，同为 2021 初版。其 `Vendor Account` 与 `GR/IR Clearing Accounts` 小节分别描述：该情形的收货涉及库存与 GR/IR 对方过账；发票涉及 GR/IR 与供应商账户；供应商账户过账不等于付款。页面也列税、价差及其他账户，但这并不说明所有采购都会产生同样账户组合。

3. [Invoices for Purchase Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/be5eb6531de6b64ce10000000a174cb4.html?version=2021.000)，`Further Functions → Evaluation → MM - Material Price Change → Value Changes in Logistics Invoice Verification`，同为 2021 初版。`Features` 说明收货/发票可有先后次序；收货先、发票先及价差处理不应混成一种无条件流程。对列出的物料估价例子，它将标准价与移动平均价分开描述，并提示移动平均价的价差处理还受库存覆盖条件影响。这里不把文档描述等同所有价格控制、业务配置或系统环境。

4. [Postings Made When Posting to a Previous Period](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/4d5fb6531de6b64ce10000000a174cb4.html?version=2021.000)，`Further Functions → Evaluation → MM - Material Price Change → Posting to a Previous Period`，同为 2021 初版。正文将过账到前期的一般收货与发票账户关系与当前期比较，并列出标准价格和移动平均价库存不足时可能需要额外调整的场景。不能据此忽略过账日期、期间开放、价格变动及配置条件。

## 适用范围、限制与后续动作

- 上述 50×2 案例可作为**限定示例的研究证据**，不代表零税、全部付款、正式系统凭证、所有控制账户或所有业务场景已核查。应在正式写作时注明假设，并以原图所示为准，独立查证借贷方及税务，不直接复用图片或长篇引用；SAP 内容保留其版权和适用条款。
- 原文提及 GR/IR 被 `cleared`；“账面金额相抵”与实际执行 SAP 未清项目清账、凭证状态变化不必然是同一事件。应核查清账程序的匹配条件和凭证状态，不能凭文字直接宣称已自动清账完成。
- 发现有价值的新版搜索线索 [Postings for the Example of Price Determination](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/5e23dc8fe9be4fd496f8ab556667ea05/59a677829c5d4d31bdfd3b075cc2b6f0.html)；但本次指定 `version=2021.000` 在浏览器返回 `Page Not Found`，因此**未找到可读的目标版**，不能用于 2021 结论或声称页面不存在于所有版本。
- 供应商记账不等于真实资金支付。消费性采购、非估价、差额/税、已收未到票/先票后货的分支、单据与字段、实际审批及只读权限仍需按文章逐项定位来源、配置和系统适用性。实际 SAP 未连接、未实测。
- 建议独立审查者重开四个固定版本页面，逐条复核选择器、正文、图示数字和上述限制，尤其核验正文的 `credits` 与图表正负所引起的歧义。**四个页面中前三页已由独立审查上下文复核；第四页仍待独立复核。不能将本记录计入正式文章审核轮次。**


## 独立审查者复核（2026-11-25）

`/root/audit_design_review` 使用独立浏览器实读以上前两页，确认版本选择器均为 2021 (Oct 2021)，50×2 图中四个账户金额和正负及供应商过账与付款不同的说明均与本记录一致。审查者提出：英文正文中 `credits` 对库存的表述与图示正负存在潜在歧义，图示未把正负直接标为借贷；Work 保留待核，不写确定借贷分录。审查者亦提醒发票校验页面有关库存账户价格差异的陈述有特定上下文，不能扩展至全部收货和价差；金额抵消不等于已验证 SAP 未清项自动清账。第三、四页当时尚未由此独立上下文复核，所有系统与权限均未实测。此复核不计正式文章审核轮次。

## 收货借贷方向的追加查证（2026-11-25）

`/root/audit_design_review` 独立浏览器实读 [Entering Goods Receipts for Nonexcisable Goods](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/240fcdcc71c640ea9aa9691500b34889/b39bd7531a4d414de10000000a174cb4.html?version=2021.000)，版本选择器为 2021 (Oct 2021)。其印度本地化、不涉及消费税的货物参考采购订单收货示例的 Result 明确写出产生物料与会计凭证，借库存、贷 GR/IR。该证据仅支持这一场景，不能断言所有税区、采购配置和其他 FPS 都如此，也不能证明上文正文中 `credits` 是笔误。

审查者另读 [SAP Learning：Purchasing (MM Integration)](https://learning.sap.com/courses/configuring-additional-settings-in-financial-accounting-in-sap-s-4hana/understanding-purchasing-mm-integration)，其中描述常见收货和发票的借贷方向；但该页面没有固定 2021/FPS，不能单独证明目标版本。另一个 2021 消耗物料示例的借贷表头与内容列在所见页面中存在对齐歧义，不作为确定方向的证据；库存采购发票的明确目标版借贷方向仍需进一步核实。先前委派 `/root/reader_m3_review` 独立复核时遇到用量限制而中断；随后 `/root/consultant_plan` 通过浏览器独立实读并确认版本、场景与借贷方向，指出 nonexcisable 应译为“不涉及消费税”，不能暗示不涉及所有税种。Work 已修正该表述，原审查者复读确认，译法问题限此关闭。均非 SAP 实机测试或文章审核。

`/root/consultant_plan` 后续独立复读本文第三页发票资料，并实际读取采购订单收货示例；适用前提、部分收货及价格控制见 [P2P估价补查](p2p-valuation-direct-2021.md)。本文第四页前期过账仍未由该审查上下文独立复核。

## 印度运输服务发票：目标版本限定案例

`/root/consultant_plan` 浏览器实读 [SAP 2021 GTA Service Tax](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/240fcdcc71c640ea9aa9691500b34889/cf0d6d6be65444c4b4f37811b6e858bf.html?version=2021.000)，选择器显示 2021 (Oct 2021)，并查看截图核对借贷表格。原文为印度货物运输代理服务的特定税务示例，所列服务 15,000 INR、税率 12%，表格对应借 GR/IR 15,000、借服务税应收 1,800，贷供应商 15,000、贷服务税应付 1,800；两侧各 16,800。页面列有服务税与供应商预提税设置等条件。

该例不能代表普通库存物料无税发票、其他税区或当前印度税法，也不证明具体企业实际清账、付款或系统配置；库存采购发票的目标版直接借贷例子仍待核实。`/root/audit_design_review` 已通过独立浏览器实读页面及截图，确认版本、四行借贷、税额、合计及特定条件；未连接 SAP，也不计正式文章审核。


## 普通库存物料发票补查（2026-11-25）

`/root/consultant_plan` 通过浏览器实读 [Posting Example Warehouse Concept 4](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/d56edf94353d4beeabb7f9b90adf081a/eeedcc53a8b77214e10000000a174cb4.html?version=2021.000)，选择器为 2021 (Oct 2021)。该页为 Funds Management 与库存物料采购集成的特定仓库场景，涉及移动平均价、FM 更新设置、税及差额等前提；发票行出现 GR/IR 与供应商，但截图中借贷表头相对数据列错位，且页面没有金额。因此不能只据此将这两项明确判为借方或贷方，也不能推广到所有企业的普通库存采购。SAP Learning 的相关方向未固定 2021；印度运输服务税案例已有明确方向，但不是普通库存采购。当前仍未找到同时满足目标版本、普通库存采购及明确借贷方向的官方正文，保持待核。未连接 SAP 或进行文章审核。


## GR/IR T 型账户的补充证据

`/root/consultant_plan` 浏览器实读 [2021 GR/IR T 型账户](fi07-grir-taccount-2021.md)，`/root/audit_design_review` 独立复读正文及图：收货 2,000、部分发票 1,000 欧元的左右位置有明确图示，但图中未逐项标借贷，按左借右贷是会计惯例解释。原例未说明 PO 行无科目分配、税及全部条件；期末调整不是付款或实际清账。普通库存发票的完整目标版文字证据仍待核。
