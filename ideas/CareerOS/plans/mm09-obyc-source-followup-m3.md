# MM-09：采购收货自动科目确定补充证据（M3 研究）

核验日期：2026-11-25（UTC）。性质：来源研究，不是正式文章、文章审核或系统实测。本报告仅核对列出的公开部分；尚未进入任何 SAP 系统，也未验证实际配置。

## 结论与证据等级

SAP 官方公开材料现在可分别支持以下有限结论：SAP Learning 的无科目分配估价收货示例直接说明 BSX 库存、WRX GR/IR 和可能的 PRD；但该课程网页未标示 2021/FPS，其版本适用性尚需另证。SAP KBA 公开预览中，2615628、1963553 和 2782220 的产品均写明“S/4HANA all versions”，分别直接涉及 101 收货 BSX 科目确定、OBYC 的 BSX 配置问题以及采购订单收货 WRX 凭证行，但每篇仅支持自身具体上下文；这比未知版本的课程更接近 2021 适用证据，却不是专门固定于 2021 的完整操作说明。**因此普通库存采购收货从条件到 BSX/WRX 科目确定的单一、可公开阅读、明确固定于 S/4HANA 2021 on-prem 的完整原文仍未找到。MM-09 不应据此宣称版本固定证据已闭合。**

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
