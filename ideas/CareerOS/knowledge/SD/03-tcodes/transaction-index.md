# SD-05｜SD 常用事务码导航：先核版本，再找入口

> **状态：drafting（暂缓核心）**  
> **目标产品：SAP S/4HANA 2021 On-Premise**  
> 本篇是证据受限的文字导航草稿，不是完整 T-Code 清单、权限矩阵或客户系统操作说明。

## 1. 为什么这篇暂时不列“常用代码大全”

学习 SD 时，常见的导航问题是：销售订单、交货单和开票单分别从哪里查看？入口名称是否代表创建、修改或显示？同一代码在目标版本、行业范围和客户授权下是否都能使用？

M3 将 SD-05 判为“暂缓核心”，要求逐入口核对 S/4HANA 2021 支持范围、用途、对象、输入/输出及权限，尤其补查 VA03。当前固定版资料只给出几个局部情境下的入口名称；它们不能组成通用的销售、交货和开票导航目录。为避免用记忆或较新版页面填空，本稿只记录来源直接列出的窄范围。

## 2. 目标版本与证据读法

本文以 S/4HANA 2021 On-Premise 为目标。固定 SAP Help 页面参数 `version=2021.000` 对应 What's New in SAP S/4HANA 2021（2021 年 10 月）。《Simplification List for SAP S/4HANA 2021》1.25 的封面范围为 Initial Shipment、FPS01 和 FPS02；它只支持该文件所述的转换与适用场景，不代表所有后续 SPS/FPS 或客户系统。

表中“页面明确写出”只表示页面在特定功能情境中列出了该名称/代码。它不自动说明：该入口在每个系统均已启用、某用户拥有访问权、输入字段完整清单、结果字段/API、授权对象或客户配置。若当地操作指南与表中有差异，以目标系统版本、部署、角色和组织配置的核对结果为准。

## 3. 当前能证实的有限入口

| 业务对象 | 页面明确写出的名称 | 固定版证据支持什么 | 不能据此推出什么 |
| --- | --- | --- | --- |
| 销售订单 | Create Sales Orders — VA01；Change Sales Orders — VA02；Display Sales Orders — VA03 | 2021.000 的 SAP GTS 销售单据合规检查说明列出这些入口，并说明相关状态在完成 GTS 集成和激活后可在所列应用中查看。该说明涉及 BD9、BDA、3NR 等范围。 | 不能当作全部标准订单流程的完整导航说明；不证明每套系统都安装/开放 GTS、不证明用户授权，也不列完整输入、输出或 GUI/Fiori 分类。VA03 在 2021《Simplification List》第 951 页另有 DIMP 特征值快速录入的特定变更语境；该段也不足以代表通用 VA03 使用说明。 |
| 开票单据 | Create Billing Document — VF01；Change Billing Documents — VF02；Display Billing Documents — VF03；Display Invoice with Item — VF03_ITEM；Display Archived Billing Documents — VF07 | 2021.000 的“Brazil Tab in Billing Transactions”列出这些事务；页面明确其巴西本地化范围，只有输入巴西公司代码时显示该国别页签，Scope Item 为 BD9。 | 不能把“Brazil Tab”页面外推成所有国家的完整开票功能说明；不证明客户系统授权、字段、归档策略、税务结果或角色可见性。 |
| 出库交货 | **目标版入口待核；本稿不列代码** | 当前已复核的固定 2021 M3 来源没有给出足以支持通用交货入口/代码的直接证据。 | 不从较新版帮助、SAP ERP 资料或经验推断 S/4HANA 2021 代码用途、显示/修改边界或应用类别。 |

### 如何读这些名称

- `Create`、`Change`、`Display` 是来源显示的入口名称，适合帮助学习者先区分动作意图。它们不是客户授权结论，也不能证明目标系统中某角色实际只能做对应动作。
- 本文没有把 `Manage Sales Orders` 等无事务码入口归为 Fiori。现有固定版证据未核实应用 ID、技术类别、Launchpad 目录/空间或业务角色映射。
- 输入与输出目前没有可逐字段引用的固定版 SD-05 证据。因此本稿不列“输入订单号、输出状态表”等未经核验的通用操作说明；具体屏幕字段应留给对应版本的 SAP Help 页面和目标系统核对。

## 4. 文字阅读练习（无需生产系统写权限）

读者可以在笔记中做一张“入口证据卡”，而不是在系统里试写：

1. 写下要查看的业务对象：销售订单、出库交货或开票单据。
2. 对照上表，标记入口名称来自哪个固定版页面、适用哪个业务/国别范围。
3. 对还未证实的项目（交货入口、输入/输出、Fiori 分类、角色授权）写“待核”，不要用工作记忆补齐。
4. 若工作系统提供了入口，记录系统版本、部署类型、应用名称/代码与授权错误信息，再用相同版本的官方帮助核验；不要通过提交或保存动作来验证权限。

这项练习训练的是证据边界和导航问题拆分，不要求连接生产系统，也不构成真实系统权限测试。

## 5. 待关闭的核心证据项

本文继续保持 `drafting`，直至至少完成以下目标版核验，并由三种原角色复核：

1. 为销售订单、出库交货和开票的通用 GUI/T-Code 入口逐项找到 S/4HANA 2021 On-Premise 直接资料，分别确认名称、用途和显示/修改边界。
2. 为 Fiori 或其他 Launchpad 应用逐项确认目标版本应用 ID、适用范围和与 GUI 事务的关系；没有固定证据的入口不贴 Fiori 标签。
3. 找到足以支撑逐入口输入/输出说明的目标版资料；如来源只列名称，就继续只列名称。
4. 将 SAP 标准产品范围与客户系统权限、业务角色和定制分开；权限须在目标系统验证，公开帮助不能证明某用户拥有权限。

未连接 SAP 系统；未验证客户配置、应用目录、授权对象、输入/输出字段或生产数据。本文不声称做过 SAP 实机测试。

## 6. 来源

1. SAP Help Portal, [Integration of SAP Global Trade Services in Sales Documents for Compliance Check — S/4HANA 2021 (version 2021.000)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/fcb3125da2904febade3759c5c4dfbb7.html?version=2021.000)。支持销售订单三个具名入口在 GTS 状态集成场景中的名称与适用范围；不作通用权限或完整流程证据。
2. SAP Help Portal, [Brazil Tab in Billing Transactions — S/4HANA 2021 (version 2021.000)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/86a74f326eab4891a61977005007753d.html?version=2021.000)。支持巴西国别页签场景中列出的 VF01、VF02、VF03、VF03_ITEM、VF07 名称及范围。
3. SAP, [Simplification List for SAP S/4HANA 2021, version 1.25, p. 951](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=951)。DIMP 特征值快速录入兼容变更中提到 VA03；仅作特定转换/特征范围证据。
4. 项目 M3 台账：[SD/PP 逐项来源贴合度复核](../../../plans/sd-pp-source-fit-m3.md)、[物流与业务来源核验](../../../plans/evidence-logistics-m3.md)。SD-05 为“邻近概述/关键词／未核验”，核心缺口包括逐入口用途、版本、对象、权限、输入输出与 GUI/Fiori 映射。
