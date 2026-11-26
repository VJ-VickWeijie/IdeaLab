# PP-07｜PP 常用事务码导航（证据受限草稿）

> **状态：drafting。** 本页只收录已找到 SAP S/4HANA 2021 固定版直接说明的入口；本轮只确认一个受限示例，不能据此构成完整 PP 导航。SAP 系统未连接，未做实机测试。

## 目标与边界

本页原计划覆盖物料清单（BOM）、工艺路线（Routing）、MRP 与生产订单的显示入口，并说明输入、输出和授权边界。准入控制要求逐个核对事务码用途、版本和权限；不能把 Simplification List 中的关键词当成事务说明，也不能从业务流程或其他产品版本推断显示、修改模式。

当前直接证据仅支持下面这个**有产品范围限制**的示例。没有找到目标版直接证据的候选项不列入导航表。表中“未核”表示证据未闭合，不表示 SAP 一定不提供该入口。

## 已核对的入口

| 事务码 | 目标版直接来源支持的用途 | 输入与可见结果（仅按来源） | 适用范围与限制 |
| --- | --- | --- | --- |
| CS03 | SAP Help 的 S/4HANA 2021（Oct 2021）页面称可用 CS03 显示物料 BOM。该页面位于 SAP S/4HANA Retail 的帮助内容。 | 页面列出的识别输入包括物料、工厂、BOM 用途、可选的替代 BOM 和有效期；确认后进入 Item Overview。若用户主记录有 Usage 参数，或系统记录了上次输入值，页面说明它可能作为显示默认值。 | 只记录该页面明确说到的显示用途与输入。来源属于 Retail 帮助内容，不能据此推断每种 S/4HANA 部署的可用性、客户角色权限或用户可访问范围。 |

## 暂不列入导航表的候选项

- 2021 Simplification List 第 523 页把 MD01、MD02、MD03、CS01、CS02 等作为关键词列出。该处不逐码解释功能、操作方式或权限，因此本页不据此给它们分配职责。
- CA03、MD04、CO03：本轮检索到的其他 SAP 页面不是已确认的 S/4HANA 2021 固定版 On-Premise 直接事务说明；不据此填写用途或显示/修改边界。
- 当前 PP-02～PP-06、PP-08 依赖文章在工作分支中尚未找到，不能拿尚未审核的下游文章为事务码职责背书。

## 授权与练习

“显示”是上表目标版帮助页面对 CS03 的功能描述，不代表已核实企业系统中的角色授权，也不等于对生产系统访问结果的保证。任何事务码的可用性、字段权限、价格信息限制或客户角色配置都需要对应目标版授权资料或有权系统验证；本页没有这类证据。

可选离线练习：阅读上方 SAP Help 页面，圈出 CS03 的输入字段和 Item Overview 输出，并记录该页面属于哪个产品帮助范围。无需连接或修改 SAP 系统。

## 来源

1. SAP Help Portal, [Displaying a Material BOM](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/9905622a5c1f49ba84e9076fc83a9c2c/e28e5b549fb50e4ee10000000a423f68.html?version=2021.000), 页面版本选择器显示 **2021 (Oct 2021)**；该页面属于 SAP S/4HANA Retail / Fashion and Vertical Business 帮助内容。核对日期：2026-11-27。
2. SAP, [Simplification List for SAP S/4HANA 2021](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=523), 文档 1.25，第 523 页。只用来说明关键词出现位置，未用作事务功能或权限依据。
3. SAP, [What's New in SAP S/4HANA 2021 SPS04](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.004/en-US/WN_OP2021_SPS04_EN.pdf), 第 32 页仅把 CS01/CS02/CS03 放在 BOM component description 搜索增强的标题中；未用来推导单个事务的完整职责。
4. CareerOS M3 [PP-07 证据台账](../../../../plans/evidence-logistics-m3.md) 与 [SD/PP 来源贴合度复核](../../../../plans/sd-pp-source-fit-m3.md)。

## 待补证后再扩展

1. 为 Routing、MRP、生产订单显示入口分别找到 S/4HANA 2021 On-Premise 固定版、直接写明事务码及职责的 SAP 来源。
2. 为每个候选入口单独查清显示/修改模式；如目标版来源未说明授权，不写具体角色、权限对象或“只读”保证。
3. 复核跨产品帮助页面适用范围，并取得 PP-02～PP-06、PP-08 可引用且已审查的依赖文章。
4. 上述核心项目未闭合前保持 drafting，不计入 reviewed 或正式接受数。
