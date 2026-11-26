# CareerOS V0.3｜MM-09、SD-01、QM-07、QM-08 专题来源补查

核查日：2026-11-25（UTC）。范围为 PR #20 规划的四篇文章；仅完成**与主题直接相关的部分来源研究**，不代表逐篇完整资料、M3 退出、正式文章或 SAP 实机测试。独立上下文查阅官方 PDF 检索缓存正文及 SAP Help 搜索结果；另有独立顾问通过浏览器读取下述 SD-01 两页原文；对仅搜索结果可读、打开时返回零行的网页，明确标为“索引正文可读、原网页读取受限”，不能冒充已用浏览器核实。

## MM-09｜采购与库存配置

**直接原文**：[SAP S/4HANA 2021 Simplification List 1.25，PDF 第 356 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=356)，文档首页明确适用于 2021 初始版本、FPS01、FPS02；该静态 PDF 正文可读。材料账实际成本迁移一节给出自动科目确定的 OBYC／IMG 入口，并将 PRL 与 GBB/AUI 的科目确定放在该特定迁移场景中说明。

**可支持的范围**：2021 初始/FPS01/FPS02 文档中的特定材料账实际成本迁移与科目确定检查。文献描述的 IMG 菜单或交易本身并不代表在实际系统中具有只读权限。

**未覆盖**：该段不证明标准 PO 收货的 BSX/WRX 分录、所有采购配置、公司特定账号、不同估价设置或生产系统权限；具体配置项→业务行为→只读入口仍需逐项核对，不能照文档执行迁移或修改。

补充线索：[2021 OData API: Reservation Document](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/021a405a74da48b4920d6ed1d83cd5dd.html?version=2021.000) 的 SAP Help 索引显示，当指定标志为 false 或未填时，特定预留项目后的货物移动按 account determination 设置决定 G/L；搜索索引正文可读但直接打开未确认，不能推广至全部货物移动。

## SD-01｜销售组织结构

**独立正文复验**：初次研究者仅取得 [2021 Sales Area - Read API](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/618d1e8552fe4e2298632025089ce845.html?version=2021.000) 的搜索索引正文。随后独立配置顾问 `/root/consultant_plan` 使用浏览器直接读取该页面，版本选择器显示 2021 (Oct 2021)，Technical Details 标注适用 SAP S/4HANA 2021；正文列出读取销售组织、分销渠道、产品组等销售区域数据。搜索工具仍返回零行，实际正文读取由该审查上下文完成。

**同版组织定义**：独立配置顾问还直接读取 [SAP 2021 Sales Organization](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f7fddfe4caca43dd967ac4c9ce6a70e4/a614c453f57eb44ce10000000a174cb4.html?version=2021.000)，版本选择器显示 2021 (Oct 2021)；Definition、Structure、Integration 解释销售组织及销售区域涉及销售组织、分销渠道和产品组，并描述一个销售组织分配一个公司代码、分销链可覆盖多个工厂及工厂可属于不同公司代码。

**边界**：上述原文支持有限组织定义及分配关系，不证明所有客户自定义、每个实际系统配置或所有跨公司开票场景；网页上下文中的跨公司开票描述不是对全部业务的普遍承诺。其他未读的 2021 动态页面仍不可称已复验。

## QM-07｜质量配置

**直接原文**：[What's New in SAP S/4HANA 2021 FPS01，§4.3.8，印刷页 126–127](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)。在 SAP 官方 2021.001 静态 PDF 的搜索服务缓存中读取到正文，明确 `Valid as Of SAP S/4HANA 2021 FPS01`；未下载原 PDF 字节，不声称哈希或系统实测。

**可支持的范围**：新增结果比较符须先维护特定配置，文档指出 SAP 参考 IMG 中质量管理→质量检验→结果记录→检验特性结果属性的补充节点；旧数据的旧符号兼容语义依该段说明。仅是一个**FPS01 特定配置示例**，不能据此推断所有 QM IMG 配置或把更改建议用在生产。

**补充初始版线索**：[Customizing Structure for Quality Inspections，2021 初始版](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eea29ed947a048aabc54ecfb5a092abc.html?version=2021.000)。搜索索引正文可读，标明 2021 (Oct 2021)，列出 Inspection at Shipping 的来源/检验类型分配等 IMG 结构变动；直接打开 HTML 为零行，因此标记索引正文而非直接页面复验。它说明的是结构改动，不是所有检验类型激活与使用决策规则。

**未覆盖**：检验类型与工厂/物料触发规则、UD 与库存自动过账、只读查看权限及实际 SAP 配置均待核实。FPS01 内容不能倒推初始版相同可用。

## QM-08｜质量对象与数据模型

**直接原文**：同一 [2021 FPS01 官方 PDF，§4.3.8，印刷页 126–127](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.001/en-US/WN_OP2021_FPS01_EN.pdf)，正文明确列出检验结果属性 CDS view `I_INSPECTIONRESULTATTRIBUTE`，维护新增比较符配置后，这些新增比较符也在该 CDS 视图中可用；这并不证明该视图本身在 FPS01 首次发布。

**可支持的范围**：这个检验结果属性 CDS 名称及所描述功能在 2021 FPS01 文档出现；不能据此确认该 CDS 的发布状态、是否可供任意开发、真实系统可访问性、检验批与结果的数据库字段/键、关联基数，或 2021 初始版功能。

**版本反例**：[What's New in SAP S/4HANA 2022：OData API Inspection Lot](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/eddde9ad50414147bfb1a26d37d3abb5.html?version=2022.000)。搜索索引正文将 `API_INSPECTIONLOT_SRV` 标为新 API、适用版本 2022。**不能把后续版本文档直接作为 2021 支持证据**；索引内容不排除其他 2021 接口或客户扩展。

## 复核与剩余门槛

- 已找到 MM-09 的 2021 版本固定 PDF 直接配置范例，以及 QM-07/QM-08 的 2021 FPS01 固定 PDF 直接范例；均只支持文中明确的少量场景，不能把文章主题整体或 M3 判为通过。
- 独立配置顾问直接复验 SD-01 两个 2021 初版页面的正文；其他此前仅有索引的 2021 Help 网页仍需要正文复验或以可读固定版本文献替代。
- 检验类型配置、字段/表键、已发布 API、事务码与系统授权，仍应逐项保留待核；无 SAP 系统权限和实机测试。
- 本文件只记录研究，未组织对正文的三角色质询、答辩、修订和复核，不计任何正式文章审核轮次。未经许可不触及生产 SAP 配置。

## 独立配置顾问复核（2026-11-25）

`/root/consultant_plan` 独立读取 SAP Simplification List 1.25 的封面与第356页，核对材料账实际成本迁移场景、OBYC、IMG 与 PRL、GBB/AUI；不能推及一般收货 BSX/WRX 或只读权限。该文另区分强制使用 material ledger 与可选 actual costing，不可混为一谈。审查者还独立读取 FPS01 What's New §4.3.8（印刷/物理页126–127）：旧数据比较符保留所述兼容语义，特性估值原有行为不变；新增符号需相关配置，CDS 出现在该限定场景。不能推断 CDS 发布状态、表键或初始版同等支持。SD 两项独立正文读取与本报告相应修订见上。以上复核不代表文章整体通过，也不是正式文章审核。
