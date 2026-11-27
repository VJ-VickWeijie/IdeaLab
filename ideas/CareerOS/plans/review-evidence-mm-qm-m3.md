# CareerOS V0.3｜MM 与 QM 18 项现有来源独立复核

日期：2026-11-25（UTC）。复核依据 PR #20 分支 `ideas/CareerOS/plans/evidence-logistics-m3.md`，Git blob `7bb16ad7c58c44f68b0264753f7b2028866beb3a`；仅是**计划级来源复核**，不是正式文章审核，不计每角色 5～10 个正式文章审核轮次，也未执行 SAP 实机测试。18 项均不能因本表而整体通过。

## 共同版本与读取限制

- **F**：[2021 Feature Scope Description `latest`](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf)：2026-11-25 实际打开 PDF 原文首页为文档 11.0（2026-07-22），文档历史指 2021 SPS10；计划记录曾对该响应取哈希但未归档字节。`latest` 不是固定链接，链接再次变化时须重核标题、版本、页码和原文；**不可将 SPS10 事实当作 2021 初始版或所有补丁事实**。
- **S**：[Simplification List 1.25](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf)：直接读取 PDF 原文，首页写明适用于 2021 初始/FPS01/FPS02；每项仍须尊重其迁移背景与业务条件。
- **N**：[What's New 2021 FPS01](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)：搜索服务保留的 PDF 章节正文可读，§4.3.8 明确 FPS01；当前子上下文未独立下载原 PDF 字节或计算哈希，不能证明初始版本也有该功能。
- 采购组织/单位两条 2021.000 Help 页面由既有记录说明协调者和另一独立开发者已通过浏览器核验。**本轮复核者没有该浏览器工具，独立网页重开返回零行**；因此引用的是有身份的前次复核记录而非本轮已再次独立读取，不以搜索摘要补作网页实读。

## MM：10 项

| ID | 本次核对的原文及能够支持的有限事实 | 未通过／待办 |
| --- | --- | --- |
| MM-01 | [2021 采购组织结构](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/2b7eb65334e6b54ce10000000a174cb4.html?version=2021.000)：前次双上下文报告读取了 2021 初始页面；本轮无法重开正文。 | 以往记录可支持组织关系的部分资料，不等于本轮复核通过；企业实际组织、权限、其他补丁待核。 |
| MM-02 | [S PDF 134 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=134) §3.18，实读了 BP/CVI 迁移与角色检查。 | 迁移检查不是采购物料主数据视图、完整 BP 角色或所有创建维护规则；逐项待核。 |
| MM-03 | [F PDF 153 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=153)，11.0/SPS10 原文写信息记录与供应商、物料及采购组织/工厂，另有货源清单与配额。 | 正文不证明统一优先级、各种货源取值、初始版及实际配置；动态 PDF 需固定快照。 |
| MM-04 | [F PDF 157 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=157)，11.0/SPS10 §2.12.4.2 讲采购申请处理。 | 此部分不能证明所有 PR→PO 场景、审批设置和事务；待查固定版相关原文。 |
| MM-05 | [F PDF 169 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=169)，11.0/SPS10 货物移动段有收货、发货与转储概述。 | 各移动类型、特殊库存及数量/估价影响并未逐项证实；初始版待查。 |
| MM-06 | 同 [F PDF 169 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=169)，原文可见供应商退货和收货事件。 | 原文不充分证明退货和冲销的单据/账务差异、已收票约束；待查。 |
| MM-07 | [2021 采购订单单位](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/af7eb65334e6b54ce10000000a174cb4.html?version=2021.000)：前次记录称协调者与独立开发者读取初始版，本轮无法重开网页正文。 | 常规订单单位的前次核查不证明用户实际 BAPI 覆盖的根因、所有单位优先级或后续补丁；按场景继续取证。 |
| MM-08 | [S PDF 151 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=151)：实读 MM01/02/03 中特定 MRP 主数据字段变化。 | 单个字段变化不是完整 T-Code 导航；需逐事务、作用、查看权限、版本与证据。 |
| MM-09 | [S PDF 356 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=356) §15.4：2021 初始/FPS01/FPS02 文档的材料账实际成本迁移段写 OBYC/IMG、PRL、GBB/AUI。 | 只支持特定迁移案例，不证明常规收货 BSX/WRX、凭证类型/移动类型全部设置或只读权限；继续核对。 |
| MM-10 | [S PDF 478 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=478) §24.5：实读 ERP/S/4HANA 库存管理数据模型变化的起始说明。 | PR/PO 全部表、键、基数、兼容视图与发布 API 不能由该一节全部推出；字段逐项待核。 |

## QM：8 项

| ID | 本次核对的原文及能够支持的有限事实 | 未通过／待办 |
| --- | --- | --- |
| QM-01 | [Manage Inspection Lots（2021.000）官方检索摘要](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eec27eaaa6b6499687148df6e52c34ad.html?version=2021.000)：QM-IM、四个 scope item、worklist 结果/UD；[Customizing Structure（2021.000）摘要](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eea29ed947a048aabc54ecfb5a092abc.html?version=2021.000)：Reference IMG 结构调整；[Business Events for Inspection Plans（2021.000）摘要](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/07da1a573afa433d91b66a6bccf0e4dc.html?version=2021.000)：仅计划 create/update/delete events。 | 核心未通过/待办：质量组织/岗位映射、检验批创建触发、客户系统激活与授权。三个固定 Help 页面本轮直接打开均返回 0 行；正文只能标为搜索摘要及既有项目记录支持。M3 的 FSD `latest` 搜索索引出现 v9.0（2025-07-23），直开同 URL 为 v11.0（2026-07-22），存在版本漂移，不作固定版/初版证据。 |
| QM-02 | [F PDF 94 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=94)：11.0/SPS10 解释检验批代表检验请求。 | 检验类型、检验来源、创建条件及激活/跳批规则待查。 |
| QM-03 | [F PDF 93 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=93) §2.8.5.1：实读质量规划与检验特性/规格概述。 | 检验计划选择、抽样、有效期及各字段需专门资料。 |
| QM-04 | [F PDF 94 页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=94)：11.0/SPS10 描述结果记录及使用决策。 | 不足以证明 UD 的库存过账是自动还是手动、冲销或所有系统的条件。 |
| QM-05 | 11.0/SPS10 FSD 的 Basic Warehouse Management/QM 文本确实涉及 EWM origin 17 及 partial usage decision。**原表标 PDF 第 188 页，实际这些内容位于 PDF 第 189 页**：[正确页](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=189)。 | Work 已修正源码引用页码；原审查者已在提交 b461828 复读，限该页码问题关闭；该 EWM 场景不能直接代表一般 IM 质量库存、财务、工厂设置或 2021 初始版。 |
| QM-06 | [S PDF 678 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=678) §31.2：实读冗余事务替代，如 QE51/QE51N 的文档列示。 | 是 2021 初始/FPS01/FPS02 的特定转换/导航说明，不等于所有系统用户有权限或全索引已验证。 |
| QM-07 | [N §4.3.8 印刷页 126–127](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)：搜索服务 PDF 章节正文明确 FPS01 结果比较符及特定配置节点。 | 仅该变更及指定 FPS；其他检验类型、工厂设置、UD 自动库存过账和只读权限仍待核。 |
| QM-08 | 同 N §4.3.8：实读的 FPS01 文段指明结果属性 CDS `I_INSPECTIONRESULTATTRIBUTE`。 | 只支持该 CDS 特定语义和比较符；不能证明检验批/特性/结果的表键、关联基数、发布日期/发布状态或初始版支持。 |

## 本次复核结果

1. F、S、N 均指向 SAP 2021 产品文档，但分别为 SPS10 动态文档、初始/FPS01/FPS02 简化清单和 FPS01 版本说明；各文是部分事实证据，不等于 18 篇文章的完整 2021 来源门槛通过。
2. QM-05 存在具体 PDF 物理页码错误，已反馈协调者修正；未直接修改其 GitHub 台账。SPS10 的 `latest` 未固定、目标系统 FPS/授权和生产行为均未知。
3. 采购组织/单位 2021 页面本轮无法重读；记录此前人员声称读取，并保留再次独立复核的限制，不将其描述为本轮复读通过。


## 页码修订复核

`/root/consultant_m3_review` 读取提交 `b46182890f73990f019b2db391ed0c0022ca9ae4` 的 QM-05 行并重新阅读 SAP PDF 第 189 页，确认页码、EWM 限定及版本风险；页码问题关闭，其他事实、FPS、权限和系统测试不因此通过。

## M4 QM-01 目标版续核（2026-11-27）

1. SAP Help 官方检索摘要将 `Manage Inspection Lots` 固定到 2021 (Oct 2021)/version 2021.000，支持 QM-IM Application Component、1FM/1MP/1E1/1MR scope item 名称，以及 worklist 记录结果、作使用决策。摘要不支持企业岗位/组织、批次创建触发、客户启用或权限；canonical HTML 本轮直接打开为 0 行，未将本轮描述写作直接重读页面正文。
2. `Customizing Structure for Quality Inspections` 固定 2021.000 摘要仅描述 Reference IMG 质量检验结构的拆分/合并/重命名。它不证明岗位、组织映射、触发、具体客户配置或授权；canonical HTML 直开 0 行。
3. `Business Events for Inspection Plans` 固定 2021.000 摘要讨论检验计划 create/update/delete 时的业务事件。对象是 inspection plan，不是 inspection lot；不得将计划事件推作检验批创建触发。canonical HTML 直开 0 行。
4. 同一 SAP Help FSD `latest` URL 本轮官方搜索索引提供 v9.0（2025-07-23）摘录，直接打开 URL 则为 v11.0（2026-07-22）。这是动态 URL 的版本漂移；两种快照都未用于填补固定版 QM-01 门槛。此前 M3 台账所述 v11.0/SPS10 属特定直接打开快照，不等于冻结的 2021.000。
5. SAP Help 官方站点针对 quality planner、quality engineer、质量组织和 inspection lot trigger 的 2021.000 查询未找到可直接支撑 QM-01 核心学习目标的固定资料。未连接 SAP，没有进行数据库、API、配置或权限测试。QM-01 继续 Draft，下一步仍是寻找固定版质量组织/角色、检验批创建条件与只读授权证据；找不到时保留缺口。

## M4 QM-02 目标版来源访问与范围复核（2026-11-27）

M3 留存的 QM-02 来源研究称五个 SAP Help 页面的版本选择器均为 2021 (Oct 2021)，并记录自动收货建批条件页及库存过账时点页曾被独立复读。本轮网页工具重试打开四个固定 2021.000 canonical HTML 均不可访问；搜索结果中的同名 2025 FPS01/FPS02 页面不作为 2021 证据。保存的来源记录可以支持 01/01 收货标准示例、一个来源可分配多个检验类型及自动建批的类型确定，也支持收货前提、有限 QIR 例外、库存相关边界和目录类型 3 过账例。它没有保存 05/05 配对或手工建批多类型选择规则，Work 已从 QM-02 的固定 2021 肯定事实中移除，并在正文标为待核。完整跳检/不建批、通用供应商/QIR、EWM、财务凭证、客户配置与权限仍是缺口；无 SAP 实机/API/数据库/权限测试。