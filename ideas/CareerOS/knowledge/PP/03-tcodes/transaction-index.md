# PP-07｜PP 常用事务码导航（证据受限草稿）

> **状态：drafting。** 本页记录四个范围受限的 BOM、Routing、MRP 和生产订单显示入口线索。CS03 只有固定版 SAP Help 官方检索索引摘要支持有限的显示入口、输入与结果线索；本轮无法直接读取该 Help 正文，因此没有任何一项构成完整逐步指南。CA03、MD04 和 CO03 仅有 SAP Support KBA 预览线索，不能据此构成完整 PP 导航。SAP 系统未连接，未做实机测试。

## 目标与边界

本页原计划覆盖物料清单（BOM）、工艺路线（Routing）、MRP 与生产订单的显示入口，并说明输入、输出和授权边界。准入控制要求逐个核对事务码用途、版本和权限；不能把 Simplification List 中的关键词当成事务说明，也不能从业务流程或其他产品版本推断显示、修改模式。

当前目标版直接资料只支持下表这些**范围受限的入口线索**，不能构成完整 PP 导航。CS03 的 2021 Help 正文本轮无法直接读取，只能依据官方检索索引摘要记录有限内容；CA03、MD04、CO03 目前只找到在版本适用范围或功能关键词上有明确锚点的 SAP Support KBA 预览，未找到四者完整的固定版 On-Premise 任务指南。表中“未核”表示证据未闭合，不表示 SAP 一定不提供该入口。

## 已核对的入口

| 事务码 / 应用 ID | SAP 目标版资料实际支持的有限线索 | 输入与可见结果（仅按来源） | 适用范围与限制 |
| --- | --- | --- | --- |
| CS03 | SAP 官方检索索引摘要对应锁定为 S/4HANA 2021.000（Oct 2021）的 SAP Help 页面，并给出 CS03 显示物料 BOM 的有限线索。 | 索引摘要列出物料、工厂、BOM 用途、可选替代 BOM 和有效期等识别输入，并提到 Item Overview；若用户主记录有 Usage 参数或系统记录上次输入，摘要称其可能作为显示默认值。该页正文本轮 canonical HTML direct open 为 0 可读行，以上不是对完整步骤的直接复读。 | 该帮助内容位于 SAP S/4HANA Retail / Fashion and Vertical Business。不能据此推断其他部署的可用性、客户角色权限或用户访问范围。 |
| CA03 | SAP KBA 3580904 的适用产品列表包括 SAP S/4HANA 2021；症状行将 CA03 关联到 Fiori app 技术名 `ProductionRouting-display`，讨论其 FLP/SAP GUI for HTML 下的滚动问题。另一个 KBA 3325837（适用范围写作 SAP S/4HANA all versions）提到 CA03 中显示 Routing operation。 | 两篇 KBA 预览均未给出完整选择屏幕、输入字段、结果列表或一般任务流程。 | 仅支持窄范围的代码/应用关联线索，不构成固定 2021 的完整 Routing 显示指南、授权说明或角色保证；后一篇是 all-versions 范围，不作为固定 2021 直接依据。 |
| MD04 | SAP KBA 3381909 的产品列表包括 SAP S/4HANA 2021，讨论 MD04 的 Intra-Plant View 默认设置。KBA 2818062 将 MD04 称为 Stock/Requirements List，但其产品范围是 S/4HANA all versions。 | 这两篇 KBA 预览不描述目标版本普通 Stock/Requirements List 的完整输入、输出或访问步骤。 | 2021 KBA 只支持一个默认视图问题线索；宽版本 KBA 仅作名称释义。不能据此补出 MRP 分支、参数、结果模式或权限。 |
| CO03 | SAP KBA 3219397 的产品列表明确包括 SAP S/4HANA 2021，并称 `App ID CO03 Display Production Order`；KBA 的具体问题是部分用户从该应用显示文档链接时遇到 OA219。 | 预览没有提供普通订单搜索、输入字段、完整显示页签或数据范围。 | 只支持该 KBA 场景里的应用 ID 名称和版本适用性；不能替代事务操作指南、授权矩阵或现场访问结果。 |

## 暂不列入导航表的候选项

- 2021 Simplification List 第 523 页把 MD01、MD02、MD03、CS01、CS02 等作为关键词列出。该处不逐码解释功能、操作方式或权限，因此本页不据此给它们分配职责。CA03、MD04、CO03 的受限 KBA 线索见上表，仍不够构成一般导航说明。
- PP-02～PP-06、PP-08 依赖文章均已存在于 PR #21 合并后的 main / 当前收尾分支，但仍为 Draft；不能拿尚未完成证据审查的文章为事务码职责背书。

## 授权与练习

“显示”是上表目标版帮助页面对 CS03 的功能描述，不代表已核实企业系统中的角色授权，也不等于对生产系统访问结果的保证。任何事务码的可用性、字段权限、价格信息限制或客户角色配置都需要对应目标版授权资料或有权系统验证；本页没有这类证据。

可选离线练习：阅读上方 SAP Help 页面及 KBA 预览，圈出 CS03 的输入字段和 Item Overview 输出；再标出 CA03、MD04、CO03 的证据分别支持什么、没有说明什么，并记录各页面的版本与产品范围。无需登录 SAP Support、连接或修改 SAP 系统。

## 来源

1. SAP Help Portal, [Displaying a Material BOM](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/9905622a5c1f49ba84e9076fc83a9c2c/e28e5b549fb50e4ee10000000a423f68.html?version=2021.000), 请求 URL 锁定 `version=2021.000`，对应 2021 (Oct 2021) 页面；内容属于 SAP S/4HANA Retail / Fashion and Vertical Business 帮助。canonical HTML direct open 本轮返回 0 行；正文只按可见 SAP 官方检索索引摘要限定引用，未通读逐步操作正文。核对日期：2026-11-27。
2. SAP, [Simplification List for SAP S/4HANA 2021](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=523), 文档 1.25，第 523 页。只用来说明关键词出现位置，未用作事务功能或权限依据。
3. SAP, [What's New in SAP S/4HANA 2021 SPS04](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.004/en-US/WN_OP2021_SPS04_EN.pdf), 第 32 页仅把 CS01/CS02/CS03 放在 BOM component description 搜索增强的标题中；未用来推导单个事务的完整职责。
4. CareerOS M3 [PP-07 证据台账](../../../../plans/evidence-logistics-m3.md) 与 [SD/PP 来源贴合度复核](../../../../plans/sd-pp-source-fit-m3.md)。
5. SAP Help 的 [Displaying a Routing](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/9905622a5c1f49ba84e9076fc83a9c2c/b0f269541fa8e530e10000000a44538d.html?version=2021.000) 请求 URL 带 `version=2021.000`，但本轮 canonical HTML direct open 返回 0 行；检索片段同时出现“Display”导航与“CA03 to create a routing”字样，存在功能措辞冲突，故未用它为 CA03 分配职责。
6. SAP Help 的 [Routing Display](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/69c3a05bb8d44f02bdd2abe5e822da8e/dd24bf53d25ab64ce10000000a174cb4.html) 页面直接列 CA03 = Display routing，但没有可核实的固定 2021.000 版本标签；未作为目标版固定证据。
7. SAP Help 的 [Monitor Stock / Requirements List (MD04)](https://help.sap.com/docs/SAP_S4HANA_CLOUD/2bba750d1e124e1ea2a039bb1cd9b6c5/daf35d93b67542c0b1f6a18807e9f6e9.html) 属 SAP S/4HANA Cloud，未用于 On-Premise 2021 事务说明。
8. SAP Help 的 [Display Production Order](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/fe39e10a9a864a8f8dc9537704f0fa13/e8021fefc094432eb038bcd7f3ea98fc.html) 页面有 CO03 特性，但当前版本范围未锁定为 2021.000；未用于固定版 2021 一般操作说明。
9. SAP Support [KBA 3580904 — CA03 transaction via FLP](https://userapps.support.sap.com/sap/support/knowledge/en/3580904)：KBA 预览的 Product 列表明确包括 SAP S/4HANA 2021，问题正文称 CA03 / `ProductionRouting-display`；仅用于窄范围入口关联，不提供完整导航或权限说明。
10. SAP Support [KBA 3325837 — CA02/CA03 Operation Graphic](https://userapps.support.sap.com/sap/support/knowledge/en/3325837)：预览提到在 S/4HANA 中用 CA02/CA03 显示 Routing operation，但适用产品标签为“S/4HANA all versions”，不是固定 2021 页面；仅作为交叉范围线索。
11. SAP Support [KBA 3381909 — MD04 Intra-Plant View default](https://userapps.support.sap.com/sap/support/knowledge/en/3381909)：Product 列表包括 SAP S/4HANA 2021；预览只说明一个 MD04 默认视图问题，不代表完整任务指南。
12. SAP Support [KBA 2818062 — Purchase requisition not displayed in MD04](https://userapps.support.sap.com/sap/support/knowledge/en/2818062)：预览将 MD04 称为 Stock/Requirements List，但产品范围为“S/4HANA all versions”；只作名称释义，不能冒充固定版 2021 直接资料。
13. SAP Support [KBA 3219397 — CO03 Display document](https://userapps.support.sap.com/sap/support/knowledge/en/3219397)：Product 列表包括 SAP S/4HANA 2021，问题正文将 CO03 称为 App ID “Display Production Order”；只支持该 KBA 场景中的应用 ID 名称和版本范围，不是完整导航或权限指南。

## 待补证后再扩展

1. 为 Routing、MRP、生产订单显示入口分别找到固定 S/4HANA 2021 On-Premise Help 任务指南，明确列出事务码、选择输入和显示结果；当前 CA03/MD04/CO03 KBA 仅解决有限的名称/适用范围线索。
2. 为每个候选入口单独查清显示/修改模式；如目标版来源未说明授权，不写具体角色、权限对象或“只读”保证。
3. 复核跨产品帮助页面适用范围，并取得 PP-02～PP-06、PP-08 可引用且已审查的依赖文章。
4. CS03 的证据仅是 Retail 范围；Routing、MRP 与订单显示输入/输出及所有候选入口的权限边界仍未闭合。上述核心目标未闭合前保持 drafting，不计入 Role Reviewed 或正式接受数。
