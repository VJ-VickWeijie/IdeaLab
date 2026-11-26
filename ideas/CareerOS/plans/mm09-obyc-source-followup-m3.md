# MM-09：采购收货自动科目确定补充证据（M3 研究）

核验日期：2026-11-25（UTC）。性质：来源研究，不是正式文章、文章审核或系统实测。本报告仅核对列出的公开部分；尚未进入任何 SAP 系统，也未验证实际配置。

## 结论与证据等级

SAP 官方公开材料支持的主张各有边界：SAP Learning 的无科目分配估价收货示例说明 BSX、WRX 和可能的 PRD，但课程未标示 2021/FPS；SAP KBA 公开预览的产品范围为“S/4HANA all versions”，各自只涉及 101 收货 BSX、OBYC 中 BSX 配置问题或特定采购收货 WRX 凭证行。2026-11-26 Work 直接读取了固定 2021 的 [两篇 GR/IR 页面](mm09-2021-grir-direct-m3.md)，支持有限的 GR/IR 科目关系，但关联页对库存科目使用“credit”措辞且未给借贷表；因此该来源不能确定方向，也不涉及 OBYC 交易键/条件。**普通采购收货从具体条件到 BSX/WRX 科目确定的完整、可直接读取的 S/4HANA 2021 on-prem 原文仍未找到；MM-09 保持未闭合。**

## 逐源记录

1. **SAP Learning，Setting Up Account Determination for Specific Transactions**：<https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/setting-up-account-determination-for-specific-transactions>。直接打开读取网页正文“Transaction/Event Keys and Their Uses”和“Simulation of Account Assignment”。范围：无 account assignment 的采购订单行发生 valuated GR 时，BSX 对应库存过账、WRX 对应 GR/IR 抵销；标准价与订单价不同时可能涉及 PRD。Configure Automatic Postings 的模拟可检查影响因素和科目。限制：课程正文仅标 SAP S/4HANA，没有明确产品 2021、on-prem 或 FPS 版本；未证明特定系统已配置或已实测，亦不应推广为所有采购收货均只有两条分录。

2. **SAP Learning，Describing Automatic Account Determination**：<https://learning.sap.com/courses/cross-functional-customizing-in-sap-s-4hana-materials-management/describing-automatic-account-determination>。直接打开读取“Automatic Account Determination”“Influencing Factors”“General Ledger Account Determination”：解释公司代码/科目表、工厂及估价范围/估价分组代码、物料/估价类、业务及移动类型等因素；正文示例为标准订单行、无科目分配、标准价收货：10 件、标准价 10、订单价 12，库存 100、GR/IR 120、价格差异 20。实际需考虑相关交易键对应规则，不可断言每一交易键都使用同一组字段。限制：同样未注明 2021/FPS；仅限示例条件，示例具体科目号不是企业实际配置。该页 invoice receipt 段落对 GR/IR 方向措辞值得复核，本次不据其确定发票分录方向。

3. **SAP KBA 2615628 公开预览**：<https://userapps.support.sap.com/sap/support/knowledge/en/2615628>。直接打开读取 Symptom 与 Product：标题讨论 101 收货与 641 STO 发货的 BSX 总账科目确定；预览说同一物料对应相同 BSX 科目，Product 明列 SAP S/4HANA all versions（覆盖 2021，但未列 FPS，亦不是 2021 专版）。限制：这是问题场景而非完整配置与原因说明；预览未完整说明普通采购 PO 的 WRX 或其借贷及规则。全文需登录，未读。

4. **SAP KBA 1963553 公开预览**：<https://userapps.support.sap.com/sap/support/knowledge/en/1963553>。直接打开读取 Symptom 与 Product：OBYC 设置中已有 BSX 科目被再用时出现 F4803 的诊断；Product 为 SAP S/4HANA all versions。限制：仅证明该具体 OBYC/BSX 配置问题，不能当成普通 PO 收货的完整科目确定过程；全文需登录，未读。

5. **SAP KBA 2782220 公开预览**：<https://userapps.support.sap.com/sap/support/knowledge/en/2782220>。直接打开读取 Symptom 与 Product：有成本中心等科目分配对象的 PO 收货时，FI 凭证具有 WRX GR/IR 行；该问题与 MIRO 的对象填充作对比。Product 为 SAP S/4HANA all versions。限制：有科目分配对象，不能直接等同普通无科目分配入库存的完整分录，也未给出收货 BSX 与完整科目确定规则。全文需登录，未读。

6. **SAP KBA 3535270 公开预览**：<https://userapps.support.sap.com/sap/support/knowledge/en/3535270>。直接打开读取 Symptom 与 Product：更新消耗的科目分配 PO 收货不产生价格差异；Product 明列 SAP S/4HANA 2021，但未列 FPS。限制：这是特定消耗科目分配场景，而非上面的无科目分配库存场景；BSX、WRX 只出现在关键词，不能据此推导相关分录。全文需登录，未读。

7. **SAP KBA 2646073 公开预览**：<https://userapps.support.sap.com/sap/support/knowledge/en/2646073>。直接打开读取 Symptom 与 Product：OBYC 可为 WRX、PRD 或 KDM 设置交易相关配置；其示例是服务行项目 MIRO 取科目问题，Product 为 SAP S/4HANA all versions。限制：服务和发票校验特殊场景，不能拿来证明普通物料收货的 WRX 确定规则或估价类必然生效；全文需登录，未读。

8. **SAP S/4HANA 2021 Simplification List，§15.4，第 356 个 PDF 页面**：<https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=356>。直接读取固定 2021 文档页面：提供 IMG 中 Configure Automatic Postings（OBYC）路径，讨论 Material Ledger actual-costing 迁移涉及的 PRL、GBB/AUI 配置。限制：这是特殊迁移场景而不是普通采购收货示例，不能用它证明 BSX/WRX；检索全文 BSX、WRX 均无匹配。不能据此断言真实配置。

9. **SAP Support Content，Basic Concepts of Price Control**：<https://help.sap.com/docs/SUPPORT_CONTENT/erpscm/3362168424.html>。搜索索引返回完整示例片段：标准价库存 BSX 200、收货 GR/IR WRX 250、价格差异 PRD 50；但直接打开网页正文返回 0 行。本次只读了搜索索引，**没有直接读取原文页面**，且产品 2021 适用范围未确认；仅作为后续检索线索，不作为版本闭合证据。

10. **SAP Help，WRX_GR/IR Clearing Account**：<https://help.sap.com/docs/s4hana-best-practices/ycoa/wrx-gr-ir-clearing-account?locale=en-US&state=PRODUCTION&version=2602>。公开搜索索引示例包含标准 PO 的 BSX/WRX/PRD，但版本明确为 2602，不是 S/4HANA 2021 on-prem。未直接读取页面，不得拿来替代固定版证据。

## 后续核验

- 寻找并实读固定 S/4HANA 2021 on-prem、明确 FPS/SPS 的无科目分配估价采购收货原文，确认 BSX/WRX 的触发、OBYC 规则与价格控制条件；如需借用动态 Help 页面，应核验网页实际版本选择器及正文而非仅拼接 URL。
- 分别核对事务键规则依赖字段、特殊库存及采购费用等额外分录，不能以课程的通用因素列表替代每个交易键的规则。
- 若后续有授权的非生产测试环境，在相应配置与样本业务条件下模拟并检查凭证；在此之前不声称验证任何企业实际配置。正式文章仍需三角色有效审核，本次研究不得计入审核轮次。


## 独立复核

`/root/reader_plan` 独立实读两篇 SAP Learning 正文和 KBA 2615628、2782220 的公开预览，确认上述场景和产品范围。KBA 2782220 仅涉及已有成本中心等科目分配对象的 PO，不能等同无科目分配库存采购；Learning 未固定 2021/FPS，KBA Product 的 all versions 也不是固定 FPS 的完整方案。此次未读 KBA 登录后的全文，未实测，不计文章审核。


## 后续检索（2026-11-25，未解除门禁）

再次检索 SAP 官方 on-prem 帮助和 2021 固定文档后，尚未独立读取同时固定 2021 on-prem、覆盖普通估价库存采购收货的 BSX/WRX 和科目确定因素的正文。新增线索如下，均不得按目标版本直接证据统计：

1. [Actual Costs](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/5e23dc8fe9be4fd496f8ab556667ea05/e7f14152fe4eaa1ae10000000a445394-2178.html) 为 S/4HANA on-prem CO 帮助页，搜索索引所读标记 **2023 Latest**，其 Goods Receipts 段区分外购收货和生产订单收货，另在 Production Accounting 小节说明 BSX 与库存账户、GBB/AUF 等生产场景配置。**2023 内容不可倒推 2021**，生产订单的 GBB/AUF 不是普通采购收货 WRX。尝试带 `version=2021.000` 的链接时网页工具报不可访问，未实读 2021 正文或版本选择器；已交协调者尝试浏览器选择版本。
2. [What's New in SAP S/4HANA 2021 初版 PDF](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf) 的搜索索引中，§3.6.1.3、印刷页 133–134 提到 Automatic Account Determination app 配置 G/L assignment，并针对 FI-GL 列新交易键 BUL/BUU。直接 `open` 因文件过大失败，**仅索引，不是本次实读原文**；此节没有说明 BSX/WRX 或普通采购条件，也不证明 Fiori app 与 OBYC 的配置对象等价。
3. [Valuation with Moving Average Price](https://help.sap.com/docs/PRODUCT_ID/7f47a6d9441c46ac86c96fd27f6015f0/bbd9b6ce0be14516ad7868da0982024a.html) 的搜索索引给出外购、移动平均价格、单层视角下的 100 件收货示例：BSX 借 240 欧元，WRX 贷 240 欧元。直接打开无可读正文，URL 含未解析的 `PRODUCT_ID`，版本也未核实；仅作为线索，不能计入 2021 依据、不能推广到其他价格控制或所有价格差异。

已阅固定 2021 的采购收货和发票价值举例，另见 [P2P 估价补查](p2p-valuation-direct-2021.md)；其普通收货前提、先票后货及价格差异有明确范围，但也**不证明 BSX/WRX 或 OBYC 科目确定条件**。未连接 SAP 系统，也未执行或建议生产配置。


## 固定 S/4HANA 2021 GR/IR 页直接复读（2026-11-26）

Work 通过 SAP Help 版本选择器直接读取 [Important Accounts for Invoice Verification](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2d70b6531de6b64ce10000000a174cb4.html?version=2021.000) 与关联的 [Postings at Goods Receipt and Invoice Receipt](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/825eb6531de6b64ce10000000a174cb4.html?version=2021.000)；两个页面的版本选择器均显示 2021 (Oct 2021)。页面支持 GR/IR 的中间科目角色和收货/发票关系，但关联页写“credit the value ... to the stock account”，未列出借贷表。独立审查者 `/root/mm09_independent_2021_read` 直接复读两页，确认版本、有限支持范围及方向歧义。另一位顾问虽未能打开这两页，但独立读取的未固定版本 SAP Learning 示例明确写库存借方、GR/IR 贷方；它仅提示冲突，不是目标版裁决。此矛盾不据此认定 SAP 系统有错，不能擅自反向改写原文。两页均未列 OBYC 的 BSX/WRX 配置因素、估价/移动类型条件或权限；MM-09 仍未闭合，文献复核不计正式文章审核。详见[固定版直读记录](mm09-2021-grir-direct-m3.md)。


## 2026-11-26｜OBYC 与库存估价候选页面的版本读取失败

- SAP Help 搜索索引中的 [Inventory Management and Physical Inventory](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/91b21005dded4984bcccf4a69ae1300c/199d86d0f85e4ea982a529c6e0409660-363.html) 提到估价区域/库存价值管理；尝试打开其 `version=2021.000` 地址时，SAP Help 返回 “Page Not Found”。该页面未读到正文或版本选择器，搜索摘要不能计为 2021 证据。
- [Extended Open Item Management: FAQ](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/651d8af3ea974ad1a4d74449122c620e/e03dc67ea7354354bf5d2b23cf575a8c.html) 的搜索索引涉及 WRX/FR1/FR3 与估价类变化后账户确定风险；尝试 `version=2021.000` 地址亦返回 “Page Not Found”。本次没有直接核对正文及版本，索引片段不作为目标版依据。

这仅记录上述两个版本化页面路径无法读取，不据此推断相关内容不存在于 S/4HANA 2021；MM-09 的 OBYC 条件、估价与权限证据仍待核。

## 2026-11-26｜固定 S/4HANA 2021 Account Determination 页面

[Account Determination](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/ed84b70c199d4470ae2e5ccb93b2e45b/2a70b6531de6b64ce10000000a174cb4.html?version=2021.000) 由 Work 直接在浏览器打开；版本选择器显示 **2021 (Oct 2021)**，页面说明该版本文档未随之后续版本更新。独立上下文 `/root/mm09_independent_2021_read` 后续直接重读相同 URL，确认版本与以下限定摘要。另一顾问 `/root/consultant_m3_review` 在其执行环境无法打开固定版正文；其非固定版本搜索索引仅作排查线索，不计本次独立复读。

页面将发票过账的科目确定描述为综合使用输入、系统信息与系统设置：

- 发票录入的供应商账户和金额信息；
- 物料主数据的估价类、价格控制类型及物料对应科目；
- 已过账单据中的采购订单价格、是否已过账收货；
- 系统设置中的净额/总额过账方式及需使用的总账科目。

页面还将“可用库存是否少于发票数量”列在物料主数据信息列表之下。独立审查建议将其解释为发票过账时的**库存覆盖状态比较**，不写成静态物料主数据字段。

**证据边界**：页面支持 S/4HANA 2021 发票科目确定所考虑的数据类别，但没有说明 OBYC、BSX、WRX、交易键、估价分组、账户修改码、移动类型条件、具体账户映射或配置入口/权限；也不提供逐笔借贷分录。它不能关闭普通采购收货自动科目确定门槛，也不解决 GR/IR 页面的收货方向措辞冲突。该来源是 MM-09、FI-07 与 PROCESS-01 的有限补充，不是完整规则或实机证据，文献复核不计正式文章审核轮次。
