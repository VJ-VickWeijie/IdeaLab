# QM-01｜质量管理业务与组织对象

- 文章 ID：QM-01
- 状态：drafting
- 目标版本：SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比
- 当前可写范围：固定版 SAP Help 对一个质量检验应用的功能说明和范围项名称；说明其证据不能推出企业组织结构、质量角色、检验触发或仓库执行方式。
- 状态原因：M3 准入仍为“部分/限缩可写”。固定版 2021.000 Help 的官方检索摘要仅支持一项应用功能、QM-IM 组件和 scope item 名称；本轮直开这些 canonical HTML 均为 0 行。质量部门/组织映射、用户角色、检验批创建触发、实际设置及授权仍无固定版直接证据。M3 FSD 的 latest PDF 有版本漂移，不替代固定版证据。
- 系统验证：SAP 系统未连接；未查看客户系统的应用、主数据、角色、授权或配置。

## 1. 这篇文章目前能回答什么

质量管理（Quality Management, QM）不是只凭部门名称就能描述的组织结构。本轮能从 SAP S/4HANA 2021（Oct 2021）固定版 Help 确认的是：SAP 记录了质量检验相关应用的功能范围，并给出该应用可以从检验批工作清单记录检验结果及作使用决策。该证据足以让学习者识别产品文档中的功能范围，不能据此画出一家企业的质量组织图。

本篇原定要说明质量业务参与者、组织对象、采购/生产质量场景和检验放行边界。下面对尚无直接证据的部分明确留白，不用常见顾问经验补写成 S/4HANA 2021 通用规则。

## 2. 固定版来源支持的有限功能范围

SAP Help《Manage Inspection Lots》固定为 SAP S/4HANA 2021（Oct 2021，version 2021.000），列出应用组件 QM-IM（Quality Inspection），并说明可在 inspection lot worklist 中记录 inspection results 和 make usage decisions。该页面列出的 scope items 为：

- 1FM — Quality Management in Procurement
- 1MP — Quality Management in Sales
- 1E1 — Quality Management in Discrete Manufacturing
- 1MR — Quality Management in Stock Handling

这些是该 2021 应用说明中列出的适用范围名称。它们不能证明每个客户系统都启用了相应 scope item、某个实际工厂的具体检验流程，或每个名称对应的完整触发事件和组织配置。

页面把“记录结果”（record inspection results）与“作使用决策”（make usage decisions）作为不同动作表述。本篇只据此区分术语，不补充 UD 的库存后果、会计影响、自动过账、撤销条件或审批权限；这些需要后续文章按固定版直接资料逐项证明。

## 3. 当前不能据此下的结论

| 学习问题 | 本轮固定版页面能证明什么 | 仍待直接证据或系统核查 |
| --- | --- | --- |
| 质量检验在哪些业务范围出现？ | 该应用页面列出采购、销售、离散制造和库存处理的 scope item 名称。 | scope item 是否启用、对应产品/部署前提、每类业务事件的精确检验触发条件。 |
| 谁负责质量检验？ | 页面提到 QM-IM 应用组件，但没有给出企业岗位或用户授权映射。 | 质量部门与采购/生产职责、Quality Planner/Inspector 等角色映射、审批责任及权限对象。 |
| 哪个组织对象控制检验？ | 本页没有直接证明工厂、采购组织、工作中心、存储地点或质量部门之间的配置关系。 | 目标版本组织对象、分配关系和客户配置；不可从 MM-01 的采购组织结构或 PP-01 的范围标签直接推导。 |
| 何时创建 inspection lot？ | Manage Inspection Lots 页面说明应用可处理检验批，不说明检验批创建触发。 | 检验来源/类型、物料与业务事件、激活/跳批、手工建批及“不建批”的条件；留待 QM-02。 |
| 结果与使用决策是否会自动改变库存？ | 页面只说可记录结果并作使用决策。 | UD 与库存状态/数量/价值、自动或手工处理、移动类型、EWM 与普通 IM 的差异；留待 QM-04/QM-05 的固定版证据。 |

特别说明：1MR 的范围名称含 “Stock Handling”，不能单凭该名称把 EWM 的检验流程推广到普通库存管理（IM），也不能反过来把普通 IM 的结论推广到 EWM。

## 4. 依赖文章核对

- **MM-01《组织结构与采购业务对象》**已 reviewed。它的 SAP 2021 直接页面限定于 Client、Company Code、Plant、Purchasing Organization、Purchasing Group 等采购组织概念和分配关系。它没有证明质量岗位、质量组织或质量检验类型的触发条件，因此本篇只用它划定边界。
- **PP-01《生产业务与组织结构》**当前仍为 drafting；它未闭合 Plant 的一般生产职责和制造模式差异。不能从 Scope Item 名称推出 PP 与 QM 的组织映射或生产检验配置。
- **PROCESS-06《质量至放行：来料检验》**在当前分支不存在，不能借用计划中的流程描述作为已审核证据。
- M3 的 QM-01 来源项引用动态 FSD_OP2021_latest.pdf。项目记录了曾读取到的版本发生漂移且不可稳定复现；本篇不把该动态 URL 的摘录作为固定版证据，也不写采购/生产/销售触发条件。

## 5. 学习练习

可选离线练习：仅根据第 2 节的 SAP Help 页面，为四个 scope item 标注其英文范围名称，再区分“应用支持记录检验结果”“应用支持作使用决策”与“检验批何时创建”三类问题。后者在本页没有答案，标为待查即可。无需连接 SAP，不查看或修改客户系统。

## 6. 来源

1. SAP Help Portal, [Manage Inspection Lots](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eec27eaaa6b6499687148df6e52c34ad.html?version=2021.000), SAP S/4HANA 2021 (Oct 2021), version 2021.000. 页面说明 QM-IM 应用可在 inspection lot worklist 记录结果并作使用决策，并列出 1MP/1MR/1E1/1FM scope items。本文只使用这些明确内容。
2. SAP Help Portal, [Customizing Structure for Quality Inspections](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eea29ed947a048aabc54ecfb5a092abc.html?version=2021.000), SAP S/4HANA 2021 (Oct 2021), version 2021.000。此页面记录固定版质量检验 Customizing 结构变化；未用于证明本篇的用户角色、触发或工厂设置。
3. CareerOS [QM-01 逐篇准入分流](../../plans/m3-item-readiness-triage-v0.3.md)、[逐篇范围与依赖](../../plans/detail-logistics-v0.3.md)、[QM-01 证据台账](../../plans/evidence-logistics-m3.md)和[MM/QM M3 来源复核记录](../../plans/review-evidence-mm-qm-m3.md)作为范围/限制记录，不替代 SAP 产品证据。
4. [MM-01 组织结构文章](../../MM/01-foundations/organization-objects.md)、[PP-01 生产组织文章](../../PP/01-foundations/production-organization.md)是依赖阅读材料；PROCESS-06 当前未建设。它们不作为质量角色或检验触发的证据。

## 7. 2026-11-27 目标版本来源续核

- SAP Help 固定页面 [Manage Inspection Lots（2021.000）](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eec27eaaa6b6499687148df6e52c34ad.html?version=2021.000) 的官方检索摘要确认：应用组件 QM-IM、四个 scope item 名称，以及从检验批 worklist 记录结果和作使用决策。本轮直接打开该 canonical HTML 为 0 行，因此把这些内容限定为 SAP 官方检索摘要及项目已有记录所能支持的范围；它不说明企业组织、用户角色、检验批创建事件、客户系统启用或权限。
- 固定页面 [Customizing Structure for Quality Inspections（2021.000）](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eea29ed947a048aabc54ecfb5a092abc.html?version=2021.000) 的官方检索摘要说明 Reference IMG 的质量检验配置结构改动；本轮直接打开该 canonical HTML 为 0 行。本篇不据此推导质量岗位、组织分配、触发规则或具体客户设置。
- 本轮以 SAP Help 官方站点按 `quality planner`、`quality engineer`、质量组织与检验批触发加 `2021.000` 进行目标版搜索，没有找到可直接支持质量岗位/组织映射或检验批创建触发的固定版资料。另检索到 [Business Events for Inspection Plans（2021.000）](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/07da1a573afa433d91b66a6bccf0e4dc.html?version=2021.000)：其主题是 inspection plan 创建、更新、删除时触发业务事件，不是 inspection lot 创建；本轮直接打开其 canonical HTML 也为 0 行，故不用于本篇触发结论。搜索无结果只描述本次查询范围，不表示 SAP 文档中必定不存在其他材料。
- M3 记录中的 FSD `latest` 链接会变化：本轮 SAP 官方搜索索引返回 v9.0（2025-07-23）摘录，直接打开同一 URL 则标注 v11.0（2026-07-22）。版本显示存在漂移；两个动态快照均不作为冻结 2021.000 初版或角色/组织配置证据。
- 状态不变：现有固定版证据不足以安全支撑质量组织、角色、检验触发与配置的核心学习目标，QM-01 继续 Draft。未连接 SAP；未执行角色、权限、配置或业务流程测试。