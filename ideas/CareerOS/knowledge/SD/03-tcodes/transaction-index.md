# SD-05｜SD 常用事务码导航：先核版本，再找入口

> **状态：drafting（暂缓核心）**  
> **目标产品：SAP S/4HANA 2021 On-Premise**  
> 本篇是证据受限的文字导航草稿，不是完整 T-Code 清单、权限矩阵或客户系统操作说明。

## 1. 为什么这篇暂时不列“常用代码大全”

学习 SD 时，常见的导航问题是：销售订单、交货单和开票单分别从哪里查看？入口名称是否代表创建、修改或显示？同一代码在目标版本、行业范围和客户授权下是否都能使用？

M3 将 SD-05 判为“暂缓核心”，要求逐入口核对 S/4HANA 2021 支持范围、用途、对象、输入/输出及权限，尤其补查 VA03。当前固定版资料只给出若干局部情境中的入口标签；它们不能组成通用的销售、交货和开票导航目录。为避免用记忆或较新版页面填空，本稿只记录官方来源明确列出的窄范围。

## 2. 目标版本与证据读法

本文以 S/4HANA 2021 On-Premise 为目标。固定 SAP Help 页面参数 `version=2021.000` 对应 What's New in SAP S/4HANA 2021（2021 年 10 月）。《Simplification List for SAP S/4HANA 2021》1.25 的封面范围为 Initial Shipment、FPS01 和 FPS02；它只支持该文件所述的转换与适用场景，不代表所有后续 SPS/FPS 或客户系统。

表中分别标出来源称其为 **app** 还是 **transaction**。页面列出入口名称，不自动说明该入口在每个系统均已启用、某用户拥有访问权、完整输入/输出字段、API、授权对象或客户配置。范围项描述的是 SAP 文档中的功能场景，不能证明客户系统已部署该功能或给某个角色授权。

## 3. 当前能证实的有限入口

| 业务对象 | 来源中的入口标签（类别） | 固定版证据支持什么 | 不能据此推出什么 |
| --- | --- | --- | --- |
| 销售订单 | Create Sales Orders — VA01（app）；Change Sales Orders — VA02（app）；Display Sales Orders — VA03（app） | 2021.000 的 SAP Global Trade Services（GTS，全球贸易服务）销售单据合规检查说明列出这三个 app，说明完成 GTS 集成和激活后，相关状态可在所列 app 中查看。页面列出的 Scope Items 包括 BD9（Sell from Stock）、BDA（Free of Charge Delivery）、3NR（Sales Scheduling Agreements）等；这是该功能的范围上下文。 | 不代表全部标准订单流程的完整导航说明；不证明客户系统已部署/激活 GTS、用户有授权、完整输入/输出或 GUI/Fiori 类别。 |
| 销售订单（特定配置特征） | VA01、VA02、VA03（transaction 示例） | 2021《Simplification List》§49.8（PDF 第 951 页）描述：在从旧版本转换到 S/4HANA 1610 或更高版本的情境中，销售单据交易的特征值快速录入从 “Fast data entry” 页签合并到 “Configuration” 页签，并以 VA01、VA02、VA03 为例。条目属于 DIMP Mill 场景，且是否相关取决于相应业务功能和特征值快速录入的使用情况。 | 这不是 VA03 的通用用途、完整显示/修改边界、授权或现代屏幕输入输出说明；不能将特定转换情境外推给所有 S/4HANA 2021 系统。 |
| 开票单据 | Create Billing Document — VF01（transaction）；Change Billing Documents — VF02（transaction）；Display Billing Documents — VF03（transaction）；Display Invoice with Item — VF03_ITEM（transaction）；Display Archived Billing Documents — VF07（transaction） | 2021.000 的 “Brazil Tab in Billing Transactions” 逐项列出这些事务。该页面的 Brazil tab 为巴西本地化页签，输入巴西公司代码时显示，Scope Item 为 BD9。 | 不代表所有国家的完整开票导航说明；不证明用户授权、字段、归档策略、税务结果或角色可见性。 |
| 出库交货 | **目标版入口待核；本稿不列代码** | 已复核的固定 2021 M3 来源没有给出足以支持通用交货入口/代码的直接证据。 | 不从较新版帮助、SAP ERP 资料或经验推断 S/4HANA 2021 代码用途、显示/修改边界或应用类别。 |

### 如何读这些名称

- `Create`、`Change`、`Display` 是官方页面给出的名称；这里仅按来源逐项抄录。它们不是客户授权结论，也不能证明某个目标系统角色实际只能执行对应动作。
- 固定版 GTS 页面把销售订单入口称为 **apps**，巴西开票页面称为 **transactions**。这些标签不足以判定所有应用的 SAP GUI/Fiori 技术类别，也不提供完整的 Launchpad app ID、目录/空间或业务角色映射。本文不把 `Manage Sales Orders` 等名称自行归类为 Fiori。
- 输入与输出目前没有可逐字段引用的固定版 SD-05 证据。因此本稿不列未经核验的屏幕字段或结果字段/API；具体屏幕字段应留给对应版本的官方 Help 页面和目标系统核对。

## 4. 文字阅读练习（不依赖系统写权限）

读者可以只用本文和笔记完成“入口证据卡”，无需连接 SAP 系统：

1. 写下要查看的业务对象：销售订单、出库交货或开票单据。
2. 对照上表，记录入口名称、来源称谓（app/transaction）和适用的业务或国别范围。
3. 对未证实项目（通用交货入口、输入/输出、Fiori 分类、角色授权）写“待核”，不要用工作记忆补齐。
4. 若你本来就有获准的只读系统访问，可观察现有菜单/帮助中的入口，并记下系统版本、部署类型和显示的名称；不要为了完成练习去触发拒绝访问、测试授权、执行修改或保存。没有系统访问时，直接把第 3 项标为“待核”即可完成练习。

这项练习训练的是证据边界和导航问题拆分，不构成真实系统权限测试。

## 5. 待关闭的核心证据项

本文继续保持 `drafting`，直至至少完成以下目标版核验，并由三种原角色复核：

1. 为销售订单、出库交货和开票的通用 GUI/T-Code 入口逐项找到 S/4HANA 2021 On-Premise 直接资料，分别确认名称、用途和显示/修改边界。
2. 为 Fiori 或其他 Launchpad 应用逐项确认目标版本应用 ID、适用范围和与 GUI 事务的关系；没有固定证据的入口不贴 Fiori 标签。
3. 找到足以支撑逐入口输入/输出说明的目标版资料；如来源只列名称，就继续只列名称。
4. 将 SAP 标准产品范围与客户系统权限、业务角色和定制分开；公开帮助不能证明某用户拥有权限，权限须由获准的目标系统核对。

未连接 SAP 系统；未验证客户配置、应用目录、授权对象、输入/输出字段或生产数据。本文不声称做过 SAP 实机测试。

## 6. 来源

1. SAP Help Portal, [Integration of SAP Global Trade Services in Sales Documents for Compliance Check — S/4HANA 2021 (version 2021.000)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/fcb3125da2904febade3759c5c4dfbb7.html?version=2021.000)。支持 GTS 合规状态场景中三个销售订单 app 的名称及 Scope Item 范围；不作通用权限或完整流程证据。
2. SAP Help Portal, [Brazil Tab in Billing Transactions — S/4HANA 2021 (version 2021.000)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/86a74f326eab4891a61977005007753d.html?version=2021.000)。支持巴西国别页签场景中列出的 VF01、VF02、VF03、VF03_ITEM、VF07 名称及范围。
3. SAP, [Simplification List for SAP S/4HANA 2021, version 1.25, §49.8, p. 951](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=951)。特征值快速录入转换变更的逐项内容及条件；不是通用 VA03 使用/权限证据。
4. 项目 M3 台账：[SD/PP 逐项来源贴合度复核](../../../plans/sd-pp-source-fit-m3.md)、[物流与业务来源核验](../../../plans/evidence-logistics-m3.md)。SD-05 为“邻近概述/关键词／未核验”，核心缺口包括逐入口用途、版本、对象、权限、输入输出与 GUI/Fiori 映射。
