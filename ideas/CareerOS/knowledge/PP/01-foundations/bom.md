# PP-02｜物料清单（BOM）：先看产品由哪些部分组成

> 状态：drafting（证据受限草稿；角色视角闭环不等于独立 review）｜M4 批次 A｜目标版本：SAP S/4HANA 2021 On-Premise。本文目前只解释固定版资料直接支持的多层 BOM 结构和少量版本功能；数量、替代项选择、普遍有效期规则及组件缺失行为仍未闭合。

## BOM 先回答什么问题

学习物料清单（Bill of Material，BOM）时，可以先问一个问题：**一个产品或装配件的组成结构是什么？**

SAP Help 官方搜索索引中的固定 2021.000 “New App: Manage Multilevel Bill of Material” 条目显示，该应用可展示多层 BOM 层级树，先显示 BOM header，再列出嵌套 components、assemblies 和 material。当前版本化 Help HTML direct open 为 0 行，未直接复读完整正文；以下只使用官方索引可见文本。索引条目不是完整 BOM 业务规则手册，也没有给出所有 BOM 类型、数量算法或订单选择规则。

本篇因而只把 BOM 介绍为一种组成结构的学习对象。它没有据此推断物料需求计划、成本、生产订单或会计凭证一定如何处理；这些关系需在各自文章中按目标版资料单独核实。

## 读懂一张多层结构

可以把层级中的每个节点先按它在结构里的位置理解：

- **父级/装配件（assembly）**：下面还可以展开出更低层的组成结构。
- **组件（component）**：列在一个父级 BOM 下面的组成项；它可能是单个物料，也可能还有自己的下层结构。
- **BOM header**：当前所查看 BOM 的头部信息。2021.000 官方索引摘录显示，该应用先显示 BOM header，再呈现其嵌套列表；本篇不进一步定义 header 的字段。

这是对 2021 页面中树结构描述的入门读法，并不代表所有 BOM item category、物料类型或制造场景都完全相同。

### 纯教学用的虚构树

下面只表示层级关系，不表示真实主数据、BOM item 记录或 SAP 选择结果。根节点 FG-100 只表示虚构树的顶层对象；BOM header 元数据没有画进树图：

- 成品 FG-100
  - 装配件 ASM-110（此例中它也是上层组件，并继续展开为下层父级）
    - 组件 MAT-120
    - 组件 MAT-130
  - 组件 MAT-140

这些编号完全虚构。此例没有数量、单位、工厂、BOM usage、有效日期或替代号，因此不能拿来创建真实主数据或推导生产结果。

## 2021 版资料能确认的有限版本信息

SAP Help 官方索引中三个固定 2021.000 “What's New”条目包含 BOM versioning 相关说明；本轮三个版本化 HTML direct open 均为 0 行，未直接复读完整页面正文，以下只按可见索引文字记录有限功能：

1. 官方索引摘录显示，可使用 Customizing 条目 “Define Additional Control Data” 启用 BOM versioning。
2. 另一条官方索引摘录显示，对某个 BOM usage，可以在 Customizing “Define Control Data for BOM Usage” 中指定 version-controlled BOM 的手动或自动 versioning。
3. 这些条目只确认目标版本存在相关配置能力和设置名称；没有给出完整 IMG 路径、客户当前设置、版本与替代 BOM/生产版本的对应规则，也不表示所有 BOM usage 都启用了版本控制。它们分别涉及是否启用 versioning、特定 BOM usage 的创建方式设置，以及下述重复制造确认中的日期选版例子；不能合并成一条普遍的 BOM 自动选择规则。

目标版还有一个范围很窄的例子：固定 2021.000 “Confirm Repetitive Manufacturing” 的官方索引摘录显示，在按库存重复制造（make-to-stock repetitive manufacturing）的确认场景中，可使用 BOM explosion date 确定创建确认时有效的 BOM version。该版本化 Help HTML direct open 为 0 行，未直接复读完整页面正文。该页面把能力限定在这个场景。不要把这句话扩展成“所有生产订单都会按同一日期自动选择 BOM”，也不要据此推导通用的有效期或替代项优先级。

## 本篇暂不解释的规则

M3 批准范围还包括 BOM 用量、替代项、有效日期/版本，以及组件缺失情形。目前可直接固定到 S/4HANA 2021 的资料不足以安全讲完整规则，所以本篇暂不提供数量计算或选版结论。

| 学习问题 | 本篇能做的说明 | 仍待目标版直接证据 |
| --- | --- | --- |
| 一个产品的下层结构如何表示？ | 固定 2021.000 官方索引摘录支持该应用可展示多层树、BOM header 与嵌套组件/装配件/物料。 | 不同 BOM 类型、用途和生产场景的完整结构规则。 |
| BOM versioning 是否存在？ | 固定 2021.000 官方索引摘录记录了启用 BOM versioning 及按 BOM usage 设置手动/自动 versioning 的有限配置说明。 | 全部配置细节、默认值、版本生成规则以及客户系统当前状态。 |
| 哪个替代项会被生产选中？ | 目前不作通用结论。 | 目标版本的替代 BOM、lot size、有效期、生产版本和选择策略之间的逐项关系。 |
| 一个成品需要多少组件？ | 目前不做数量运算或单位换算。 | BOM item quantity、base quantity、单位和固定数量等目标版直接依据及计算边界。 |
| 组件缺失、失效或被排除时会怎样？ | 不推测其会被忽略、报错或由系统自动补齐。 | 缺失/失效条件、爆炸结果、错误或后续业务动作的直接资料。 |
| 字段和存储表是什么？ | 不列物理表、字段、键、关联或接口。 | 目标版数据模型、released API/CDS 与适用权限的逐项官方证据。 |

请把上表理解为本稿的证据边界，不是说 SAP 不支持这些功能；它们是本稿尚未证实的学习目标。

## 离线练习：只画结构，不推导数量

无需登录 SAP，可用纸笔完成这项练习：

1. 为一个虚构成品画出一层父级和两层子级。
2. 圈出同时作为“下层结构父级”的装配件。
3. 在旁边另列需要查证的问题：每个组件数量/单位、替代项、日期、版本及组件缺失时的处理。
4. 暂不回答第 3 步，也不要把猜测标成 SAP 规则。

练习仅帮助识别树形结构，不代表已验证客户系统，也不是 BOM 创建操作指导。

## 与其它文章的边界

- [PP-01｜生产业务与组织结构](production-organization.md)：生产组织与制造模式仍有独立证据缺口；本篇不借用 PP-01 尚未证实的组织/流程结论。
- [MM-02｜物料主数据与供应商业务伙伴](../../MM/01-foundations/material-business-partner.md)：可帮助区分材料主数据与本篇讨论的 BOM 组成结构；不会据此推出 BOM 字段或层级。
- PP-03 计划讨论工作中心与 Routing；该文尚未纳入本次研究，本篇不预写其内容。

## 目标版本官方来源

1. SAP Help Portal，[“New App: Manage Multilevel Bill of Material”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/40fea7f7ca7d446c800d992088133f69.html?locale=en-US&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000。官方检索索引摘录显示多层树、BOM header、嵌套组件/装配件/物料，以及 BOM Engineer business role template 授权说明；版本化 Help HTML direct open 返回 0 行，本轮未直接复读完整正文。索引显示应用支持 display and maintain，不应称为只读工具。
2. SAP Help Portal，[“Configuration to Define Versioning of Bill of Material”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/354d3184ad4449f6b515029199e69de9.html?version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000。官方检索索引摘录显示可用 “Define Additional Control Data” 启用 BOM versioning；版本化 Help HTML direct open 返回 0 行，未直接复读完整正文。不支持推导完整 IMG 路径或客户设置。
3. SAP Help Portal，[“Configuration to Maintain Manual or Automatic Versioning for BOM Usage”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/d9fae6cc2c684445b25cee45bf30502a.html?version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000。SAP 官方检索索引摘录显示可为特定 BOM usage 选择手动或自动 versioning；版本化 Help HTML direct open 返回 0 行，未直接复读完整正文。不支持推导默认值、算法及全部 BOM usage 覆盖。
4. SAP Help Portal，[“Confirm Repetitive Manufacturing”](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/87921c2813d94507b725eec99b4e979c.html?locale=en-US&version=2021.000)，S/4HANA 2021 (Oct 2021), version 2021.000。官方检索索引摘录显示，make-to-stock repetitive manufacturing 确认场景可用 BOM explosion date 确定有效 BOM version；版本化 Help HTML direct open 返回 0 行，未直接复读完整正文。该有限说明不支持通用 BOM 选版规则。
5. M3 范围/证据台账：[逐篇范围、版本线索与依赖](../../../plans/detail-logistics-v0.3.md)、[逐篇准入分流](../../../plans/m3-item-readiness-triage-v0.3.md)、[物流来源登记](../../../plans/evidence-logistics-m3.md)、[SD/PP 来源贴合度复核](../../../plans/sd-pp-source-fit-m3.md)。这些记录用于解释批准范围和来源限制，不是 BOM 产品规则的替代证据。

M3 来源台账所列 FSD_OP2021_latest.pdf 是动态 URL；本稿不把该文件当前快照当成固定版 2021 证据。没有连接 SAP 系统；没有执行或声称执行实机测试。
