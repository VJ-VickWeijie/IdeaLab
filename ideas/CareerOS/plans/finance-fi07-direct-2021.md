# CareerOS M3｜FI-07 采购收货、发票与 GR/IR：SAP 2021 初版直接证据

状态：M3 来源研究；不是正式知识正文、正式文章审核或 SAP 实机测试。初核日期 2026-11-25；版本补查日期 2026-11-26。研究者是先前财务台账的作者，对自己补充的来源由另一独立上下文作限定范围复核，见文末。已获批准的阶段与范围不等于 M3 已通过或 M4 已授权。

## 实际查看方式与版本

公开搜索首先找到 SAP 帮助相同主题的新版页面，但其默认版本为 2025，不能用作 2021 的证明。之后通过浏览器打开下述明确 `version=2021.000` 的 SAP Help 页面，等页面完整加载，再同时读取可访问文本和可见示意图。上述直接读取页面的版本选择器实际显示 **2021 (Oct 2021)**，且页面提示该版不包含后续交付的更新，因此仅支持所见的 2021 初版具体描述，不代表所有 FPS、SAP 系统实际配置或后续变化。

## 来源与有限结论

1. [Postings at Goods Receipt and Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000)，`Sourcing and Procurement → Further Functions → Evaluation → MM - Material Price Change → Price Control`。浏览器版本为 2021 (Oct 2021)。页面正文说明收货和发票通过 GR/IR 过渡；**实际可见图示**为采购单 50 件、每件 2 美元、总值 100 美元：收货栏显示 `stock account 100 +`、`GR/IR account 100 −`；发票栏显示 `GR/IR account 100 +`、`vendor account 100 −`。该页文字与图示不构成可无条件推广到所有企业的分录。图中的 `+` / `−` 不是图示明确写出的“借方 / 贷方”；英文正文还使用了 `credits` 描述库存过账，如何与图中正负及借贷方向对应仍须独立证据核查。图中没有明确给出税、发票差异、企业会计政策或账户配置，不能补造。

2. [Important Accounts for Invoice Verification](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2d70b6531de6b64ce10000000a174cb4.html?version=2021.000)，`Invoice Management → Invoice Processing → Further Information → Account Determination`，同为 2021 初版。其 `Vendor Account` 与 `GR/IR Clearing Accounts` 小节分别描述：该情形的收货涉及库存与 GR/IR 对方过账；发票涉及 GR/IR 与供应商账户；供应商账户过账不等于付款。页面也列税、价差及其他账户，但这并不说明所有采购都会产生同样账户组合。

3. [Invoices for Purchase Orders](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/be5eb6531de6b64ce10000000a174cb4.html?version=2021.000)，`Further Functions → Evaluation → MM - Material Price Change → Value Changes in Logistics Invoice Verification`，同为 2021 初版。`Features` 说明收货/发票可有先后次序；收货先、发票先及价差处理不应混成一种无条件流程。对列出的物料估价例子，它将标准价与移动平均价分开描述，并提示移动平均价的价差处理还受库存覆盖条件影响。这里不把文档描述等同所有价格控制、业务配置或系统环境。

4. [Postings Made When Posting to a Previous Period](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/4d5fb6531de6b64ce10000000a174cb4.html?version=2021.000)，`Further Functions → Evaluation → MM - Material Price Change → Posting to a Previous Period`，同为 2021 初版。正文将过账到前期的一般收货与发票账户关系与当前期比较，并列出标准价格和移动平均价库存不足时可能需要额外调整的场景。不能据此忽略过账日期、期间开放、价格变动及配置条件。



## 2026-11-26：MAP 无库存覆盖页面直接读取

5. [Example: Material with MAP Without Stock Coverage](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/6370b6531de6b64ce10000000a174cb4.html?version=2021.000)，浏览器版本选择器显示 **2021 (Oct 2021)**，页面提示文档不包含后续版本修改。正文描述：采购收货按 PO 价格增加库存价值、对方进入 GR/IR；领料按移动平均价记成本中心、对方减少库存；发票过账时 GR/IR 按 PO 价格清理、供应商侧按发票价处理。价差只按开票时仍在库存中的数量调整库存；正文例子中 80 件现存库存对应的差额记入物料，其余差额进入 price-difference expense。该页面提供 MAP 无库存覆盖的数量/价差业务逻辑，但无完整借贷表；“debit”仅出现在 80 件差额这个有限描述中。它没有明确说明采购订单无科目分配，也不提供 BSX/WRX 的 OBYC 配置因素、税、交易键条件或普通采购通用分录。

## 适用范围、限制与后续动作

- 上述 50×2 案例可作为**限定示例的研究证据**，不代表零税、全部付款、正式系统凭证、所有控制账户或所有业务场景已核查。应在正式写作时注明假设，并以原图所示为准，独立查证借贷方及税务，不直接复用图片或长篇引用；SAP 内容保留其版权和适用条款。
- 原文提及 GR/IR 被 `cleared`；“账面金额相抵”与实际执行 SAP 未清项目清账、凭证状态变化不必然是同一事件。应核查清账程序的匹配条件和凭证状态，不能凭文字直接宣称已自动清账完成。
- 发现有价值的新版搜索线索 [Postings for the Example of Price Determination](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/5e23dc8fe9be4fd496f8ab556667ea05/59a677829c5d4d31bdfd3b075cc2b6f0.html)；但本次指定 `version=2021.000` 在浏览器返回 `Page Not Found`，因此**未找到可读的目标版**，不能用于 2021 结论或声称页面不存在于所有版本。
- 供应商记账不等于真实资金支付。消费性采购、非估价、差额/税、已收未到票/先票后货的分支、单据与字段、实际审批及只读权限仍需按文章逐项定位来源、配置和系统适用性。实际 SAP 未连接、未实测。
- 建议独立审查者重开四个固定版本页面，逐条复核选择器、正文、图示数字和上述限制，尤其核验正文的 `credits` 与图表正负所引起的歧义。**四个页面中前三页已由独立审查上下文复核；第四页仍待独立复核。不能将本记录计入正式文章三角色各按需 5–10 轮。**


## 独立审查者复核（2026-11-25）

`/root/audit_design_review` 使用独立浏览器实读以上前两页，确认版本选择器均为 2021 (Oct 2021)，50×2 图中四个账户金额和正负及供应商过账与付款不同的说明均与本记录一致。审查者提出：英文正文中 `credits` 对库存的表述与图示正负存在潜在歧义，图示未把正负直接标为借贷；Work 保留待核，不写确定借贷分录。审查者亦提醒发票校验页面有关库存账户价格差异的陈述有特定上下文，不能扩展至全部收货和价差；金额抵消不等于已验证 SAP 未清项自动清账。第三、四页当时尚未由此独立上下文复核，所有系统与权限均未实测。此复核不计正式文章审核轮次。

## 收货借贷方向的追加查证（2026-11-25）

`/root/audit_design_review` 独立浏览器实读 [Entering Goods Receipts for Nonexcisable Goods](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/240fcdcc71c640ea9aa9691500b34889/b39bd7531a4d414de10000000a174cb4.html?version=2021.000)，版本选择器为 2021 (Oct 2021)。其印度本地化、不涉及消费税的货物参考采购订单收货示例的 Result 明确写出产生物料与会计凭证，借库存、贷 GR/IR。该证据仅支持这一场景，不能断言所有税区、采购配置和其他 FPS 都如此，也不能证明上文正文中 `credits` 是笔误。

审查者另读 [SAP Learning：Purchasing (MM Integration)](https://learning.sap.com/courses/configuring-additional-settings-in-financial-accounting-in-sap-s-4hana/understanding-purchasing-mm-integration)，其中描述常见收货和发票的借贷方向；但该页面没有固定 2021/FPS，不能单独证明目标版本。另一个 2021 消耗物料示例的借贷表头与内容列在所见页面中存在对齐歧义，不作为确定方向的证据；库存采购发票的明确目标版借贷方向仍需进一步核实。先前委派 `/root/reader_m3_review` 独立复核时遇到用量限制而中断；随后 `/root/consultant_plan` 通过浏览器独立实读并确认版本、场景与借贷方向，指出 nonexcisable 应译为“不涉及消费税”，不能暗示不涉及所有税种。Work 已修正该表述，原审查者复读确认，译法问题限此关闭。均非 SAP 实机测试或文章审核。

`/root/consultant_plan` 后续独立复读本文第三页发票资料，并实际读取采购订单收货示例；适用前提、部分收货及价格控制见 [P2P估价补查](p2p-valuation-direct-2021.md)。本文第四页前期过账仍未由该审查上下文独立复核。

## 印度运输服务发票：目标版本限定案例

`/root/consultant_plan` 浏览器实读 [SAP 2021 GTA Service Tax](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/240fcdcc71c640ea9aa9691500b34889/cf0d6d6be65444c4b4f37811b6e858bf.html?version=2021.000)，选择器显示 2021 (Oct 2021)，并查看截图核对借贷表格。原文为印度货物运输代理服务的特定税务示例，所列服务 15,000 INR、税率 12%，表格对应借 GR/IR 15,000、借服务税应收 1,800，贷供应商 15,000、贷服务税应付 1,800；两侧各 16,800。页面列有服务税与供应商预提税设置等条件。

该例不能代表普通库存物料无税发票、其他税区或当前印度税法，也不证明具体企业实际清账、付款或系统配置；库存采购发票的目标版直接借贷例子仍待核实。`/root/audit_design_review` 已通过独立浏览器实读页面及截图，确认版本、四行借贷、税额、合计及特定条件；未连接 SAP，也不计正式文章审核。


## 2026-11-26（Asia/Shanghai）：通过 SAP Help 页面接口重新读取固定版原文

为提高版本可复现性，Work 直接读取 SAP Help Portal 的只读 pagecontent 接口：先向 deliverableMetadata 请求 `version=2021.000`，确认版本标签与 buildNo，再读取对应话题 HTML。以下 SHA-256 是接口返回的 `data.body` HTML 字符串编码后的摘要，不是 SAP 发布方签名，也不保证未来接口快照不变；固定版本标签显示 **2021 (Oct 2021)**。这次重读未访问客户系统。

| 页面 | 2021 buildNo | 本次读取到的具体内容与边界 | 返回 HTML 摘要 SHA-256 |
| --- | ---: | --- | --- |
| [Postings at Goods Receipt and Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000) | 509 | 正文说 GR/IR 作为收货与发票的中间清算账户，并将收货金额称为“credits”到 stock account；此前记录的图示则以正负号呈现，二者不构成无歧义的借贷标签。不得擅自消除该文献内部的表达歧义。 | `b298c34d92d08aa0c35ad98460a90661ee897b58a37da8c746a09e2ee7555235` |
| [Important Accounts for Invoice Verification](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2d70b6531de6b64ce10000000a174cb4.html?version=2021.000) | 509 | 说明供应商子账过账不等于付款、GR/IR 为中间账户；提及物料主数据决定相关库存账户，并在发票校验语境下描述库存账户与发票价差的关系。不能脱离上下文把它解释为所有收货都不更新库存。 | `575ec297ee014ea1edbc7de6f872c5d0202d5a2fb36ca5cfe3a6ff85dd85e732` |
| [Entering Goods Receipts for Nonexcisable Goods](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/240fcdcc71c640ea9aa9691500b34889/b39bd7531a4d414de10000000a174cb4.html?version=2021.000) | 505 | 印度本地化、不涉及消费税的采购订单收货流程明确写出借记 inventory、贷记 GR/IR；仅支持此货物与税务场景，不等于其他税种不存在。 | `47b52f2003781ee669ad78706ef9f63cf74805592b2f433046c0ef7d393de635` |
| [Example: Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/0f095921571d4e94a53bfaa5f6dc120d/1d4bd953292a424de10000000a174cb4.html?version=2021.000) | 505 | 标准价 1,500、采购价 1,700 的示例列 stock 1,500、price difference expense 200 与 GR/IR 1,700，并讨论 profit center；该表没有明确 debit/credit 列标题。 | `0dbbf8ec69ce080733d0e9a9081d2cd040f80a9d580049879f0c432f59e5e18d` |
| [GR/IR Clearing Account](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/651d8af3ea974ad1a4d74449122c620e/f47fd1538cdf4608e10000000a174cb4.html?version=2021.000) | 508 | 对同一采购订单及项目的收货/发票项目不会自动清账；F.13/F.13E 可按 PO 与项目分析未清项并对零余额项目清账，无法配对或非零余额项仍保留。科目贷方余额表示已收未票、借方余额表示已票未收，是该文所述分析情境。手工过账不等于可手工清账。 | `976a123a8e22569a693fe070b64593135e1b9bd065f093b939481540e3960c0c` |
| [Treatment of Exchange Rate Differences for Incoming Invoices](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b4970dc428d14ce7a16e91dd0ffd733b.html?version=2021.000) | 351 | 2021 文档说明可按公司代码选择使用收货时或发票接收时有效汇率的方法；其标准价、移动平均价、科目分配订单和库存不足条件下的分配规则各不相同。范围限于该配置页描述的 incoming invoice 场景。 | `dd8e8d1b14d6e223589597b78872ea60f097bd9a613039124bf5784437f58df7` |

本次补证增加了清账条件和外币发票价差的目标版直接证据，但**没有解决普通非印度库存采购中** SAP 初版正文 “credits” 与图示符号的歧义，也未证明一般场景下逐项借贷、自动科目决定、税务处理和当前系统配置。FI-07/PROCESS-01 保持未闭合；须继续寻找无歧义、同一目标版本与明确采购前提的来源，并由独立顾问复读本追加资料。上述资料研究不计正式文章审核轮次。


## 2026-11-26 直接来源复读后的审查边界补充

本轮通过 SAP Help 的固定版本页面接口再次读取若干原文；在前述表格中已记录 buildNo 与返回 HTML 摘要。此次明确新补证的两个交叉点为：

- [GR/IR Clearing Account](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/651d8af3ea974ad1a4d74449122c620e/f47fd1538cdf4608e10000000a174cb4.html?version=2021.000) 明确同一 PO 和项目上的收货/发票更新 GR/IR 未清项，不会自动清账；F.13/F.13E 对可匹配的零余额项目清账，不能匹配或不为零的项目继续保持未清。该资料支持过程状态区别，仍不是 SAP 系统实测或所有配置适用保证。
- [Treatment of Exchange Rate Differences for Incoming Invoices](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b4970dc428d14ce7a16e91dd0ffd733b.html?version=2021.000) 为 SAP S/4HANA 2021 文档。其汇率取值时点、标准价/移动平均价/科目分配及库存不足情形不同；该页面可支持“公司代码级处理设置会影响汇兑差额归属”这一限定命题，不是所有采购与汇率类型的一揽子规则。

root/consultant_plan 独立在 SAP Help 浏览器复读本节的六个页面正文，确认版本选择器为 2021 (Oct 2021)，并核对本节的 GR/IR 清账规则、印度限定收货、标准价差异例子、外币差额规则及 credits/图示歧义。审查者没有重新计算本文 API 返回内容的 SHA-256，也未核对本文的 buildNo；Work 仅将其记录为对页面正文和场景边界的独立核验。Work 接受其两项精度建议：将 1,700 标为“采购价”而非“发票金额”，并将汇率选项表述为“选择使用收货时或发票接收时有效汇率的方法”；复核时区标为 Asia/Shanghai，以消除日期歧义。

经此修订，普通库存物料采购中 Postings at Goods Receipt and Invoice Receipt 的 “credits” 措辞、图示正负及借贷关系仍有来源内部歧义；印度不涉及消费税例子给出明确方向，但不可泛化到所有国家与所有税。普通无税库存发票、自动科目决定、异常/冲销、目标系统配置仍未充分闭合。故 FI-07 与 PROCESS-01 仍未闭合。


## SAP Help 2021 初版：MAP 库存覆盖下先票、收货、再票案例

来源：[Example: Material with MAP with Stock Coverage](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/d96eb6531de6b64ce10000000a174cb4.html?version=2021.000)，Sourcing and Procurement，Posting Quantity and Price Variances。Work 在 SAP Help 浏览器中直接打开固定版页面，选择器显示 **2021 (Oct 2021)**，页面说明该版文档未随后继发行版更新。

页面限定案例：材料移动平均价 MAP 为 $2.00，初始库存 100 件；采购订单为 100 件、$2.00/件。先过账 50 件、$2.20/件的发票（$110），再收货 80 件，随后过账另 50 件、$2.20/件的发票（$110）。页面图中按账户列示数值变化：第一次发票时 GR/IR +110、供应商 -110；收货时库存 +170、GR/IR -170；第二次发票时库存 +6、GR/IR +104、供应商 -110。图示还列出库存金额/MAP依次由 100件/$200/$2.00 变为收货后的 180件/$370/$2.05，再变为第二次发票后的 180件/$376/$2.09。

边界：本页支持这个特定的先票—部分收货—再票、MAP 有库存覆盖、存在价格/数量差异的价值流转示例。图示用账户加减号，没有明确标为借方/贷方；不能将符号直接翻译成借贷方向。本页未明确写出无科目分配、税务前提或通用配置，不能代替标准普通库存无税采购的通用分录。另有一处正文称第二次发票会改变库存数量，但同一图示的库存数量从第二次发票前到后均为 180；保留这项来源内部不一致，不据正文或图示单独推广。普通库存采购借贷、税、自动科目和配置缺口仍未闭合。

来源读取归属：/root/consultant_plan 首先检索并实读此页；Work 随后独立用浏览器复读固定版选择器、正文和图示。两次均未访问 SAP 系统或进行过账实测；本段是来源复核，不是第二角色对报告的正式审核，不计正式文章审核轮次。


## 邻近对照：SAP Best Practices YCOA 的 WRX 示例（2025-FPS1，不是 2021 证据）

来源：[WRX_GR/IR Clearing Account](https://help.sap.com/docs/s4hana-best-practices/ycoa-1f2ae10b96f740759d66e695f953aa8f/wrx-gr-ir-clearing-account?version=2025-FPS1)。/root/consultant_plan 直接在 SAP Help 浏览器读取；当前跳转地址的版本选择器显示 2025-FPS1，路径面包屑为 SAP_S4HANA_BEST_PRACTICES / YCOA / Account Determination / Material Management。其展开版本列表列有 2608、2602、2025-FPS1、2025-FPS0、2023-FPS02，没有 2021；这不证明其他 SAP 官方 2021 来源不存在，也不据此断定该 Best Practices 仅适用于某一部署版。

该页面明确说明标准物料采购订单不得有科目分配，收货时借记库存、贷记 GR/IR。限定示例为 1 件，标准价 EUR 3、PO 净价 EUR 10：借库存 EUR 3（BSX）、借价格差异损失 EUR 7（PRD）、贷 GR/IR EUR 10（WRX）。这是有明确借贷栏的收货示例，可作解释机制的邻近对照。

范围限制：版本为 2025-FPS1，不是 S/4HANA 2021 on-prem 固定版资料；它未提供普通库存发票过账分录，未说明税务条件，也未证明目标系统当前配置。因此不能用于关闭 FI-07 / PROCESS-01 的 2021 版本门槛或替代前述 2021 MAP 页面。/root/consultant_plan 实读本页，本 Work 在当前搜索服务可见索引但打开正文返回空，故保留读取归属，不冒称 Work 已复读原文。本次为 M3 来源研究，不计正式文章审核轮次。


## MAP 无库存覆盖页面独立复读（2026-11-26）

`/root/mm09_independent_2021_read` 独立读取上述页面，确认版本选择器为 2021 (Oct 2021)；其摘要范围与本文一致：收货/领用/发票价差关系可支持 MAP 无库存覆盖场景，但正文没有完整借贷表，且未明确是无科目分配采购，不能作为普通库存采购通用分录或 OBYC 配置依据。此为 M3 来源交叉核验，不计正式文章审查轮次，无 SAP 实机验证。


## 2026-11-26｜通用 SAP Learning 的独立交叉核对

配置顾问 /root/consultant_m3_review 独立直接复读 [SAP Learning: Describing Automatic Account Determination](https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/describing-automatic-account-determination)，确认其一般性估价收货例、BSX/WRX 键及公司代码/科目表、估价范围/分组、物料类型/估价类、业务/移动类型、库存覆盖等因素；该课程未固定 2021/FPS。审查者同时发现该页的发票说明称 GR/IR 在发票时 credited，与 [SAP Learning: Managing Closing Activities in Materials Management](https://learning.sap.com/courses/configuring-the-financial-closing-in-sap-s-4hana/managing-closing-activities-in-materials-management) 明确的发票借 GR/IR、贷供应商不一致；[SAP Learning: Managing Goods Movements](https://learning.sap.com/courses/exploring-end-to-end-business-processes-in-sap/managing-goods-movements_d7cf8543-eb45-490b-810a-237bbd17485f) 的 Integration to Finance 仅明确限定采购收货借库存、贷 GR/IR，不提供发票方向。关账课程还明确收货借库存/消费、贷 GR/IR，并允许 GR/IR 顺序互换。上述页面不是目标版固定证据；不据此宣称已确认 SAP 误植/勘误，或推演所有税、价差与采购变体。它们仅用于记录跨来源冲突并提示需继续寻找目标版清晰原文。此独立来源复核不计正式文章审核轮次。
