# CO-06｜CO 常用入口导航：先分清查看、维护与过账

> **状态：drafting（受限草稿，核心入口证据未闭合）**  
> **目标版本：SAP S/4HANA 2021 On-Premise。** 本文面向初学者，中文为主并保留 SAP 英文术语。M3 对本篇的准入为“暂缓核心”：只有在逐项有目标版原厂来源时才写入具体入口。  
> **验证边界：** 本文核对的是 SAP 固定版 2021 文档中点名的少数 Fiori app。它不是常用 SAP GUI transaction code（T-Code）全集；本文不凭顾问习惯补列 KSB1、KOB1、KE30 等代码。没有连接 SAP 系统，未验证某客户部署、app 可用性、菜单/磁贴、角色授权、只读边界或操作结果。

## 1. 先看你要完成什么

CO（Controlling，管理会计）入口需要按任务分开。一个 app 名称不能自动告诉你它是只读、可维护还是会触发业务处理。

本文把已证实入口按 SAP 2021 原文描述标成三类：

- **查看/分析**：原文明确写 display、view 或 analyze。
- **维护/处理**：原文明确包含 create、edit、transfer、supplement、return 等动作。
- **功能范围仍待核**：只知道应用名或较高层作用，不知道完整输入、输出、授权和系统状态。

注意：SAP 文档确认某功能在产品版本中有描述，不等于它已在你的客户系统部署，也不等于当前用户有访问权限。本文不提供未核实的 Fiori app ID、business catalog、business role 或 SAP GUI T-Code。

## 2. SAP S/4HANA 2021 固定文档支持的入口

| 业务问题 | 2021 文档中的应用/入口 | 原厂资料明确支持 | 使用边界 |
| --- | --- | --- | --- |
| 成本中心预算要转移、补充或退回吗？ | Manage Cost Center Budgets | SAP 2021 资料说明，该应用可 transfer、supplement、return cost center budgets；操作前当前财年的成本中心数据和预算必须存在。预算可用性控制还涉及指定的配置前提。[E1 §3.5.1.2] | 这是会改变预算的处理功能，不能标成只读报表。客户是否启用、谁可执行及金额限制须在目标系统核验。 |
| 需要跟踪成本中心承诺额吗？ | Commitments by Cost Center – Classic Commitment Management | 可跟踪各成本中心的承诺额，并与实际费用、计划和预算比较；该功能明确采用 classic commitment management framework。[E1 §3.5.1.7] | 仅说明该分析功能，不代表客户系统启用，也不证明其数据刷新、范围或授权。 |
| 查阅内部订单主数据并跳到相关应用 | Manage Internal Orders (Version 2) | SAP 2021 资料说可显示内部订单，并导航到其他内部订单应用。[E1 §3.5.1.4] | “display”不代表相关导航目标也只读；不把其他版本的 app 能力或 app ID 套用到 2021。 |
| 查找内部订单在哪些对象中被引用 | Where-Used List – Internal Orders | 资料列出的引用对象包括成本分配周期、分配段、固定资产和组，并允许继续导航到相关应用。[E1 §3.5.1.5] | 只记录文档列举的对象类型，不将其说成完整 where-used 或所有依赖追踪。 |
| 查看内部订单主数据改了什么、谁改、何时改 | Change Log – Internal Orders | 资料明确支持查看内部订单主数据变更的内容、变更者和时间。[E1 §3.5.1.6；E2] | 这是变更记录查看入口；资料没有据此确认保留期限、字段全集、导出能力或用户权限。 |
| 按成本要素组整理/维护分类 | Manage Cost Element Groups | SAP 2021 资料支持创建、编辑和显示成本要素组。[E1 §3.5.4.1；E3] | 含 create/edit，不能按“只读”推荐。该入口不等于查看成本发生额的报表，也不证明成本要素的一般配置规则。 |
| 分析物料价值链上的实际成本 | Display Material Value Chain – Actual Costs | 2021 资料记录应用名称调整，并列出利润中心显示选择及在物料/活动节点和边线上查看成本组件拆分的变化。[E1 §3.5.5.1；E4] | 是产品成本分析入口；适用范围受资料所列 scope item 限定，不能从名称推出全部成本流、差异、WIP 或结算规则。 |
| 查看物料价值链的估算成本 | Display Material Value Chain – Estimated Costs | SAP 2021 资料将其描述为按给定有效日期，用估算成本显示物料价值链上的计划数量与计划价值。[E1 §3.5.5.2] | 这是计划/估算视角，不等于实际成本或过账结果；估算条件和可用权限仍需核验。 |
| 分析已产生的 COGS split 记录 | Manage COGS Splits | 2021 资料说明该 app 用于分析已作出的 COGS split postings，并将其置于 J55 Margin Analysis 范围。[E1 §3.5.6.1；E5] | 仅是配置相关的 COGS 拆分分析入口，不是一般利润表、全部 Margin Analysis 报表或普通库存分录的替代说明。 |
| 新建成本中心 | Manage Cost Centers | 在预算应用的前提说明中，SAP 2021 资料把该 app 列为创建成本中心的入口。[E1 §3.5.1.2] | 本证据只支持“创建入口”这一点，不据此写完整主数据维护功能、具体事务码、权限或配置路径。 |

### 入口与事务码不要混为一谈

上述条目是产品文档点名的应用名称，不是 SAP GUI T-Code。SAP 2021 What’s New 文档按应用功能说明，并未为本篇目标范围提供足以组成常用 CO GUI 事务码索引的逐项映射。因而本文**不列未经固定版资料核实的代码**，也不把 Fiori app name 当作 transaction code。

CO-01～CO-05 提供的业务背景可帮助判断问题属于成本中心、内部订单、产品成本或获利分析；它们不能证明某个入口代码。要把 KSB1、KOB1、产品成本或获利分析 GUI 报表纳入正式索引，仍需相应 S/4HANA 2021 原厂资料逐项确认用途、选择条件、输出、读写/过账影响及版本。

## 3. 离线选入口练习

先读问题，再按原文的功能描述选择，不执行系统操作：

1. “我只想知道订单主数据何时被谁改过。”——查 Change Log – Internal Orders 的文档范围。
2. “我想知道一个内部订单还被哪些对象引用。”——查 Where-Used List – Internal Orders；记得它只证明资料列出的引用类别。
3. “我需要处理预算转移或退回。”——Manage Cost Center Budgets 属于处理入口，先确认当前财年预算前提及目标系统授权；不能把它当作查询页面。
4. “我想比较一个物料价值链的估算值和实际值。”——两款 Display Material Value Chain app 的标题分别对应 estimated 与 actual；不要混成同一种数值。
5. “我需要一个常用 GUI 事务码。”——本文没有足够固定版证据可安全给出通用代码；先从目标系统获准的应用目录/帮助和对应 2021 原厂文档核验。

本练习只训练按业务问题找资料，不证明任何系统操作已成功。

## 4. 版本、权限与下一步

- **版本：** E1 是固定链接的 SAP S/4HANA 2021 What's New 文档；各应用按文档所标的 Valid/Available as of S/4HANA 2021 记录。它不是后续 FPS 的完整功能目录。
- **权限：** 产品功能介绍不等于授权对象或角色清单。每个 app 的 business catalog、role、目标系统是否发布以及显示/修改/运行权限均未在本篇证实。
- **事务码：** 这批固定版来源不足以建立 CO GUI T-Code 的通用导航表。没有用当前动态帮助、其他版本或记忆补齐。
- **配置关联：** 仅记录 SAP 2021 文档明确写出的功能前提。本文不推导周期、结算、分配、成本组件拆分和自动过账配置；后续 CO-07 需对每项配置单独找目标版依据。
- **核心缺口：** 成本中心实际/计划报表、内部订单实际行项目、产品成本估算/差异报表、一般获利分析报表各自的 GUI 事务或 2021 Fiori 映射仍未逐项核实；同时缺目标系统的权限与部署验证。因此状态保持 drafting，不计入批次 A reviewed。
- **FI-07 边界：** 本文不涉及普通采购库存借贷、税务或自动科目决定，也不扩展 FI-07 的未闭合结论。

## 5. 来源登记

| 编号 | 来源与定位 | 本文使用范围 |
| --- | --- | --- |
| E1 | [What's New in SAP S/4HANA 2021 (Oct 2021)](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf)，§3.5.1.2、§3.5.1.4–3.5.1.8、§3.5.4.1、§3.5.5.1–3.5.5.2、§3.5.6.1。 | 固定 2021 初始发行中的应用名称、页面列明的功能和有限前提。不是 GUI 事务码或授权索引。 |
| E2 | [Change Log – Internal Orders, 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/00ec2c96762d4587b976248bf2f4f12c.html?version=2021.000)。 | 固定 Help 页面支持查看内部订单主数据变更的内容、用户和时间。 |
| E3 | [Manage Cost Element Groups, 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/daad5c6c4d764c2baa25b93a9fab7d82.html?version=2021.000)。 | 固定 Help 页面支持创建、编辑、显示成本要素组。 |
| E4 | [Display Material Value Chain – Actual Costs, 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/18ddb677b64e455c945f4c4de9168e9e.html?locale=en-US&version=2021.000)。 | 固定 Help 页面及 What's New 对该特定产品成本分析应用的描述。 |
| E5 | [Manage COGS Splits, 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/f2bb8fe1f6c046a7a00797ddc02149f6.html?locale=en-US&version=2021.000)。 | 固定 Help 页面支持 Margin Analysis 范围内已配置 COGS 拆分的分析应用，不支持一般收入/成本报表推断。 |

SAP 系统未连接；本篇没有验证 app 启动、用户角色、客户配置、事务码、报表输出或过账。
