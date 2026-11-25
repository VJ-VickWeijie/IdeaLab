# S4HANA-03：CDS 数据建模与 DCL 权限的 2021 证据

状态：M3 资料研究记录；不是正式文章，也不计入正式文章审查轮次。研究者通过 SAP Help Portal 浏览器实际读取下列页面的正文，四页版本选择器均显示 **2021 (Oct 2021)**。本记录没有进行 SAP 系统操作或实测。

## 1. CDS 数据建模示例

来源：[Implement the CDS View as Data Model](https://help.sap.com/docs/ABAP_PLATFORM_NEW/cc0c305d2fab47bd808adcad3ca7ee9d/a7ef7d66047e4a779c0d5f996b8fcc34.html?version=202110.000)，SAP (On-Premise) - ABAP Programming Model for SAP Fiori，2021 (Oct 2021)，Procedure 和 Results。

- SAP 的 EPM 示例使用传统 `define view ... as select from`，包括数据源、字段别名、路径表达式、`key` 元素、货币语义注解和 `@AccessControl.authorizationCheck: #CHECK`。
- 该示例激活时生成 CDS view entity 和由 `@AbapCatalog.sqlViewName` 命名的 SQL view。此结论限于页面中所示的传统 CDS view，不能据此推断所有 `define view entity` 都生成 SQL view。
- 该单一示例不能证明全部 CDS 语法、关联行为、性能特征或 RAP 场景；它也不能单独证明声明 `#CHECK` 就一定存在有效 DCL 角色。

## 2. DCL 和 PFCG 示例

来源：[Implementing Authorizations for Read-Only Applications](https://help.sap.com/docs/ABAP_PLATFORM_NEW/cc0c305d2fab47bd808adcad3ca7ee9d/ed52fb28c8084db7bcf4323d9d18f4ad.html?version=202110.000)，SAP (On-Premise) - ABAP Programming Model for SAP Fiori，2021 (Oct 2021)，Creating Access Controls 和 Use Cases 1–3。

- 原文分别给出固定值过滤、`define role` / `grant select`、`aspect pfcg_auth(...)`、固定值与 PFCG 条件结合的例子。DCL 条件可以使用固定值，不能说每个 DCL 必须依赖 PFCG。
- 在页面的 PFCG 示例中，ABAP 系统必须存在相应授权对象，用户分配的角色必须包含该授权对象以及相关字段的匹配值。示例使用 `S_ACM_DEMO`、`SACMTSOID` 和 `ACTVT = '03'`，并提及演示角色 `SAP_INTNW_EPM_DEMO`；这些是示例，不能泛化成生产系统应使用的角色或授权配置。
- 如果没有为该 CDS entity 创建并部署访问控制，能访问该 entity 的用户不会受到该 DCL 的行级过滤；这不代表不存在其他访问控制或权限。

## 3. 检查机制与访问路径

来源：[ABAP Authorization Concept for CDS Entities](https://help.sap.com/docs/ABAP_PLATFORM_NEW/c6e6d078ab99452db94ed7b3b7bbcccf/42e2fef6fdd74d7e9195d58aae2b83f6.html?version=202110.000)，ABAP Platform，2021 (Oct 2021)。

- 页面说明用 ABAP SQL 访问 CDS entity 时，适用的 CDS DCL 条件可作为数据过滤条件。不存在角色时，不存在该 DCL 行级过滤；这不意味着所有其他保护均不存在。
- 页面说明 `#NOT_ALLOWED` 不应用相应 DCL 角色；ABAP SQL 的 `WITH PRIVILEGED ACCESS` 可抑制 DCL 检查。这里仅记录机制，不能将其理解为建议绕过权限，也不能推断其他安全检查都消失。
- 一个 CDS entity 消费下层 CDS entity 时，下层 DCL 不会自动继承到上层；需要针对实际直接消费的 entity 及其访问方式检查访问控制。事务启动等传统授权是不同层次，不应视为 DCL 的替代证明。
- 本次读取未证明 Native SQL、ODBC、直接访问 SQL view、OData/Gateway 或所有关联访问路径适用完全相同的规则，也未验证服务入口授权、用户身份传递或任何实际系统中的配置。上述内容需按路径查证目标版本官方文档及目标系统。

## 4. 授权注解

来源：[AccessControl Annotations](https://help.sap.com/docs/ABAP_PLATFORM_NEW/cc0c305d2fab47bd808adcad3ca7ee9d/cf2989f6f5944305a0c8bcc0b0080c7c.html?version=202110.000)，SAP (On-Premise) - ABAP Programming Model for SAP Fiori，2021 (Oct 2021)。

| 注解值 | 本次读取的页面支持范围 |
| --- | --- |
| `#CHECK` | 有相应 DCL 角色时执行检查；不存在角色时不产生 DCL 检查，开发者激活该实体且不存在相应 DCL role 时会在设计时收到警告。 |
| `#NOT_REQUIRED` | 有相应 DCL 角色时同样执行检查；不存在角色时不产生 DCL 检查，且不发出与缺失角色有关的警告。**不能写成无条件跳过已有 DCL。** |
| `#NOT_ALLOWED` | 不执行该授权检查；开发时激活该实体的 role 时会给出警告。 |

页面还讨论特定上下文中的 privileged association；不据此外推所有关联访问方式。本记录不对其他注解值的语义作未核实断言。

## 待补证与验证边界

这些原文支持 2021 版本中的 CDS 建模示例、DCL 和 PFCG 示例及所述 ABAP SQL 检查机制，但不足以替代针对具体 S/4HANA 应用、访问路径、授权对象、运行用户与版本补丁的验证。尤其需要分别补证 Native SQL、直接 SQL view、ODBC 和 OData/Gateway 的授权链；若无可访问的对应原文或可获授权的测试环境，应保持未验证状态。本次未执行代码、未连接企业系统，也未检验角色分配、传输或生产配置。


## 独立复核

`/root/audit_design_review` 通过浏览器独立读取上文第 2、4 节两个 SAP 2021 Oct 原网页，确认 DCL 固定条件/PFCG 示例与注解的限定语义：`#CHECK` 和 `#NOT_REQUIRED` 在存在相应 DCL role 时均执行检查，无角色时均无该层保护；`#NOT_ALLOWED` 仅针对所述授权检查。审查者未据此验证本报告的另外两页或全部访问路径；DCL role 与用户 PFCG 角色不可混同，未连接 SAP，不计文章审核。


## 授权注解说明的修订

`/root/audit_design_review` 复核提交 `6ac8c0b9717ba2157b1e9eb48d8de99d5d1e5779` 时指出，原稿对 `#NOT_ALLOWED` 的警告时机写得过宽，`#CHECK` 的警告时机也需具体说明。Work 已按原页面限定开发时激活的对象和条件，原审查者已复读提交 `6b8e5a` 并确认两项警告时机，建议将“未定义”精确改为“不存在”；Work 已作此措辞微调。此修订不计正式文章审核。
