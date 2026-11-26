# MM-08｜MM 常用事务码导航

> **状态：drafting（未完成核心导航范围核验）**  
> 目标系统：SAP S/4HANA 2021 On-Premise。本文只纳入已能对应到 SAP 固定版资料的导航事实；未核实的代码、应用、权限和系统行为不作推断。  
> 草稿日期：2026-11-27（Asia/Shanghai）

## 这篇文章要解决什么

学 SAP MM 时，事务码（transaction code，T-Code）是 SAP 帮助资料列出的短代码，可作为查找功能入口的索引词。本文用它帮助读者按业务对象找资料，不说明在每种界面中怎样启动代码；启动方式要看具体系统提供的界面。代码本身也不能证明当前账号有权访问，或保证只能查看、不能修改。本文把“SAP 文档列出的操作范围”和“你在具体系统中能做什么”分开。

初学时先认业务对象：要了解物料本身及其主数据，查“物料主数据”一行；要了解采购订单，查“采购订单”一行。代码列表不是操作权限清单，也不代替业务流程说明。

本篇是一个证据受限的起步索引，不是覆盖所有采购、库存和仓库操作的 T-Code 字典。目前确认了物料主数据与采购订单的两个入口族；物料凭证显示入口、完整 MIGO 导航范围及逐代码权限仍在核验，因此不能据此把本文当成完整导航表。

## 目前有固定版依据的入口

| 业务对象 | 2021 固定版资料列出的代码/入口 | 文档能支持的导航说明 | 显示、修改与权限边界 |
| --- | --- | --- | --- |
| 物料主数据记录 | `MM01`、`MM02`、`MM03` | SAP S/4HANA 2021 (Oct 2021) 的 Logistics—General 事务清单把三者列为一组，并将这组描述为创建、修改和显示物料主数据记录。清单没有逐代码分别标注动作；所引 2021 创建流程页提供的是创建场景说明，不将其推广为修改/显示流程。 | 两页均不描述具体用户的完整授权模型。创建流程页提到视图受物料类型配置影响，部门数据维护受授权及物料类型允许范围约束；这些是该创建流程的边界，不是 MM02/MM03 的完整权限说明。不得把代码名称当成当前账号授权结果。 |
| 采购订单 | `ME21N`、`ME22N`、`ME23N`（采购订单单屏事务族） | 固定版父页面标题确认这三个代码属于“Purchase Order – Single-Screen Transaction”事务族；关联的 “Create, Change, and Display Purchase Orders” 页面描述相关应用可以创建、查找、查看和编辑订单。本文区分“代码族证据”与“应用层操作说明”，不把应用说明扩展成逐代码模式映射。 | 2021 帮助说明，相关应用的创建、修改、显示模式切换需要必要授权；修改已有订单还取决于订单状态。该来源不列授权对象、完整角色模型或某用户的权限。 |

**怎样从表中选入口？** 先确认要找的对象，再看表中的入口族。本文引用的 2021 事务清单没有单独证明“`MM01` = create、`MM02` = change、`MM03` = display”这一逐代码映射；不要仅按代码顺序补出对应关系。本篇暂不能只凭这张表告诉读者三个代码中应选哪一个。采购订单的两个来源也要分开读：父页面标题确认代码族，关联页面描述相关应用的功能；两者都没有提供逐代码授权矩阵。

表格中，物料主数据行指向**物料主数据记录**，采购订单行指向**采购订单**。所引页面没有给出可作为通用接口合同的字段级输入/输出、API 或数据结构映射；本篇不补写这些技术细节。MM01/MM02/MM03 的配置和授权描述仅限来源明确写出的创建流程，不概括到另两种事务。

### 物料主数据：不要把特殊字段变更当成完整代码说明

2021 Simplification List 还提到 MM01/MM02/MM03 中特定 MRP 主数据字段变化。那是特定字段的简化说明，不是事务操作、授权或界面范围的完整定义。主数据视图、组织层级和可维护字段仍要按适用的 2021 帮助及具体配置判断。

### 采购订单：把“代码族”与“可操作模式”分开

固定版页面确认了 ME21N、ME22N、ME23N 这一采购订单单屏事务族，并描述了相关应用的订单操作。它没有在本文所引页面中给出逐代码的授权矩阵；因此，即使事务码熟悉，也要把“入口族提供的操作”和“当前会话允许的模式”分开。订单状态还可能限制实际可修改内容。

## MIGO 与物料凭证：本稿尚未建立通用导航映射

**仅作版本/场景受限的证据示例，不是已核实的 MIGO 通用导航条目。** 目前读到的固定版直接证据之一，是 SAP S/4HANA 2021 SPS05 的 “Add Short Text to Goods Movement”。它支持的范围很窄：货物移动/转储项目级短文本（最多 50 个字符）；对于库存管理到 EWM 的同步货物移动，资料明确限定为 S/4HANA 中嵌入式 EWM 场景，并指出可在 Post Goods Movement（transaction `MIGO`）中输入该文本。该功能页不能单独证明 MIGO 的完整用途、所有模式、材料凭证显示路径或一般权限边界。

SAP S/4HANA 2021 Best Practices 实施管理指南另设 “Post-Activation Steps for Embedded EWM Scope Items”，列出嵌入式 EWM 范围项的激活后步骤。它可用于提醒读者：该指南讨论的是一组需要激活并完成后续设置的 Best Practices 范围项；它不是所有 EWM 部署形态、仓库权限或事务码的通用定义。

这里的 **EWM** 是 Extended Warehouse Management（扩展仓库管理）。SAP 2021 SPS05 页面所说的“同步货物移动”，仅指该页面描述的 Inventory Management 与 EWM 之间的同步处理场景；“embedded in SAP S/4HANA”是该功能页面对适用场景的限定。Best Practices 管理指南只列出其方案中的嵌入式 EWM 范围项和激活后步骤；这不表示每个 SAP S/4HANA On-Premise 系统都使用或必须激活这些范围项，也不定义所有 EWM 部署形态。本篇不把该 MIGO 特例扩展到其他 EWM 场景，也不要求读者先掌握 EWM 才能学习 MM 事务导航。

所以在以下内容核实前，本文不把 `MIGO` 填成通用收货/发货/转储操作总入口，也不列材料凭证显示代码或 Fiori 应用清单：

1. SAP S/4HANA 2021 On-Premise 对 MIGO 通用职责与所覆盖业务对象的直接固定版说明；
2. 目标版材料凭证显示入口、它的对象与显示/修改边界；
3. 如需将 Fiori 应用并入导航表，逐应用核对 2021 On-Premise 的直接资料和 app ID；
4. 对任一代码或应用的系统级授权结论，须在具体系统中验证；本项目没有连接 SAP 系统，故本稿不作此类结论。

## 无写权限时的学习方式

- 先按上表识别“主数据”与“采购订单”两个业务对象；阅读对应的 SAP 2021 官方帮助，不需要在生产系统运行事务码。
- 如在获准的练习系统只有显示权限，只查看已有演示数据；不得用创建、修改或过账操作来验证文章。
- 对某个账号能否访问、能否保存、是否只读，向该系统管理员确认角色与授权；本文不代替授权检查。
- 看到某代码出现在较新版网页、博客或搜索摘要中时，不直接补进 2021 索引；先找到带 `2021.000` 或明确 2021 SPS 标记的 SAP 来源。

**文字练习（无需登录 SAP）**：小林想确认一种新原料是否已经有主数据；小陈要阅读一张现有采购订单。请分别在上表找到对应的业务对象行，再回答：哪一行可以帮助继续查官方帮助？如果问题是“我该输入哪个代码、当前账号能否保存”，本文目前能否给出确定答案？正确做法是先按对象定位资料；逐代码选择与账号权限仍按固定版文档和具体系统授权核实。物料主数据背景参见 [MM-02 物料主数据与业务伙伴](../01-foundations/material-business-partner.md)；采购订单与采购申请背景参见 [MM-04 采购申请与订单](../02-functions/requisition-po.md)；库存移动背景参见 [MM-05 库存类型与货物移动](../02-functions/stock-movement.md) 和 [MM-06 收货、退货与冲销](../02-functions/gr-returns-reversal.md)。本篇只做入口导航，不复述完整流程或接口合同。

## 来源与主张对应

1. **物料主数据事务族**：[Transactions — Logistics—General (LO), SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/25a41481f62e469ba0e61015a0d39d20/bcd8c353b677b44ce10000000a174cb4.html?version=2021.000)。支持 `MM01, MM02, MM03` 与“create, change and display material master record”的分组对应。
2. **物料主数据视图与组织层级边界**：[Creating a Material Master Record — SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f7fddfe4caca43dd967ac4c9ce6a70e4/36528c53f894ee23e10000000a174cb4.html?locale=en-US&version=2021.000)。本文只引用视图受物料类型配置影响、部门数据维护存在授权前提等限制。
3. **采购订单单屏事务族与操作边界**：[Purchase Order – Single-Screen Transaction (ME21N, ME22N, and ME23N), SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/7e80b65334e6b54ce10000000a174cb4.html?version=2021.000)；[Create, Change, and Display Purchase Orders, same fixed version](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/af9ef57f504840d2b81be8667206d485/8780b65334e6b54ce10000000a174cb4.html?version=2021.000)。支持页面标题中的事务族以及授权、单据状态边界，不作为每个代码的唯一模式/权限矩阵。
4. **MM01/MM02/MM03 特定 MRP 字段变更**：[Simplification List for SAP S/4HANA 2021, PDF page 151](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=151)。只用于说明证据范围有限，不用于扩展事务导航主张。
5. **MIGO 短文本特例**：[Add Short Text to Goods Movement — What's New in SAP S/4HANA 2021 SPS05](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/f5d3e1005efd4e86acf9a65abf428082/ee4e8d80dc2d4625a08329d995128aea.html?version=2021.005)。只支持该 SPS05 功能及文中明确的同步 IM→嵌入式 EWM 条件。
6. **嵌入式 EWM Best Practices 范围项**：[Administration Guide to Implementation of SAP S/4HANA 2021 with SAP Best Practices, §3.5.4.5](https://help.sap.com/doc/b4447b6727684f13917622cf63e1eb98/2021/en-US/AdminGuideS4HANAImpl_HELP_EN.pdf)。该指南描述其列出的嵌入式 EWM 范围项的激活后步骤；不外推为通用 EWM 产品架构或事务权限说明。

## 当前未解决项

- **核心缺口**：尚未取得足以支撑“材料凭证显示入口”与 MIGO 通用导航用途的 2021 On-Premise 固定版直接资料。本文状态保持 `drafting`。
- 没有将较新版事务索引或 Fiori app ID 表推回 2021。
- 没有连接 SAP 系统，没有测试 GUI/Fiori、账号权限、角色、配置或单据结果。
- 在核心导航范围补足并完成原角色复核前，不计入 `reviewed`。
