# PP-09｜生产确认与物料凭证字段：SAP 2021 VDM 固定版本补查

研究日期：2026-11-25。只读公开资料与 SAP 发布的生成源码；无 SAP 系统、实际数据、服务调用或实机测试。本记录不计正式文章审查轮次，不将服务实体键解释为数据库物理主键。

## 版本和原始材料

1. 已直接读取 [SAP Cloud SDK for Java v3 官方发行说明](https://sap.github.io/cloud-sdk/docs/java/v3/release-notes)：**3.59.0，2021-12-02**，描述将 `s4hana-api-odata-onpremise` 生成 VDM 更新到 S/4HANA On-Premise **2021**；**3.70.0，2022-06-16**，描述更新到 On-Premise **2021 FPS02**。SDK 版本与 SAP 产品版本是两个不同概念。
2. 已从 Maven Central 下载并用 `unzip -p` 直接读取 SAP 发布的固定坐标源代码包：
   - [SDK 3.59.0 源码包](https://repo.maven.apache.org/maven2/com/sap/cloud/sdk/s4hana/s4hana-api-odata-onpremise/3.59.0/s4hana-api-odata-onpremise-3.59.0-sources.jar)，18,864,539 bytes；本次计算 SHA-256 `e49e2e3dbc6aa39a7c8584ba16c9e2370f66c734d5f9b37e9df8bd25a96b99a3`。
   - [SDK 3.70.0 源码包](https://repo.maven.apache.org/maven2/com/sap/cloud/sdk/s4hana/s4hana-api-odata-onpremise/3.70.0/s4hana-api-odata-onpremise-3.70.0-sources.jar)，19,602,344 bytes；本次计算 SHA-256 `74df01f9987523e3aa28aa01d0d7122ea01fc344b8aa2d611c110e22c2f6090b`。
   - 同坐标 [3.59.0 POM](https://repo.maven.apache.org/maven2/com/sap/cloud/sdk/s4hana/s4hana-api-odata-onpremise/3.59.0/s4hana-api-odata-onpremise-3.59.0.pom) 的 organization/developer 标为 SAP SE / SAP，描述为 On-Premise OData 服务生成 API classes；适用 SAP Developer License Agreement。二进制源包只在本地研究暂存，未提交仓库或重新发布。
3. 3.59.0 内 `com/sap/cloud/sdk/s4hana/onpremise/datamodel/odata/services/ProductionOrderConfirmationV2Service.java` 的 Details 标示服务 `OP_API_PROD_ORDER_CONFIRMATIO_2_SRV_0001`、API Version `1.1.0`、Minimum ERP Version `2021`；其中 Business Documentation URL 另指向 SAP `2021.000`。前述 3.59.0 的 2021 VDM 版本定位由 SAP release notes、SDK 源码和该链接共同支持；不能单凭最低版本宣称其他 FPS 字段不变。3.70.0 源码中的对应 service 仍列同一服务、版本与最低版本。

## 已从源码独立核实的字段

源文件：`com/sap/cloud/sdk/s4hana/onpremise/datamodel/odata/namespaces/productionorderconfirmationv2/ProdnOrdConfMatlDocItm.java`。3.59.0 中实体被描述为 **Material Movements for Confirmation**，原 OData EDM entity type 为 `ProdnOrdConfMatlDocItmType`。以下为该**特定实体**，而不是通用订单/库存物理模型：

| OData 属性 | 该生成源码中的含义或标记 | 解释边界 |
| --- | --- | --- |
| `ConfirmationGroup` | 订单确认的集合 ID；`@Key` | 实体键一部分，不可当物料凭证主键 |
| `ConfirmationCount` | 单次订单确认标识；`@Key` | 同上 |
| `MaterialDocument` | 物料凭证号；`@Key` | 是本实体属性，不代表已证明 MATDOC 物理键 |
| `MaterialDocumentItem` | 物料凭证项目；`@Key` | 同上 |
| `MaterialDocumentYear` | 物料凭证年度；`@Key` | 同上 |
| `OrderID` | Manufacturing Order ID，非 `@Key` 属性 | 生产订单相关标识；不能由此推断实体对订单的基数、数据库 join 或全量货物移动均填充 |
| `OrderItem` | Order Item，非 `@Key` 属性 | 订单项目属性；不可由此推断所有移动场景均适用 |

同包 `ProductionOrderConfirmationV2Service.java` 的 `getProdnOrdConfMatlDocItmByKey` 方法以以上五个 `@Key` 属性作为参数。`ProdnOrdConfMatlDocItm.java` 的 `getKey` 也返回同五项；该证据是 SAP 生成 SDK 表达的实体读取键，并非独立读取目标系统 `$metadata`，不证明所处系统已发布、已启用、授权可用、实际响应或存储主键。生成代码同时存在注释中的 EDM 非空约束和 Java `@Nullable` 注解；本次不由此推断具体运行时输入校验。

已对 SDK **3.70.0 / 官方版本说明对应 2021 FPS02** 的相同 entity 和 service 源码检查：五个 `@Key`、`OrderID`、`OrderItem` 均存在，同样仅为特定生成 VDM 的支持；该一致性不是对 FPS01 或目标系统所有补丁的逐一验证。

## 物理表与兼容对象

已独立读取 [Simplification List 1.25 §24.5，PDF 物理第 478～480 页](https://help.sap.com/doc/f2591a6901344c97a5e2029cc8f3703e/2021/en-US/SIMPL_OP2021.pdf#page=478)，该文标注 Initial Shipment、FPS01、FPS02。MM-IM 所述模型下，物料凭证头/项目旧数据结构被纳入物理表 `MATDOC`；`MKPF`、`MSEG` 的读取存在兼容代理重定向。`NSDM_DDL_MKPF`、`NSDM_DDL_MSEG` 是原文表格标出的 **DDL Source of CDS View for redirect**，不能当作运行时 CDS 视图名。

这份简化清单和 SDK 源码**没有证明** `MATDOC` 的物理复合主键、订单引用的物理字段、物料文档与订单物理表的连接键/过滤条件或关联基数。不能将 SDK 五字段的实体键转写成 MATDOC 主键，也不能因为同一实体有 `OrderID` 就推断所有生产订单移动均有确认或仅存在一种关联路径。

## 余项与边界

- 未核目标系统的 2021 具体 FPS、`$metadata`、服务激活、角色授权、关联完整性或系统数据；若可获适当非生产只读权限，应与精确系统版本下的官方元数据和 DDIC 分别复核。
- 对非确认发起的生产订单收发货、取消/冲销、组件及多个会计或物料项目，不可推广这个 entity 的覆盖范围或键；BOM、Routing 和生产版本关联仍以此前报告为限。
- 此前只从搜索索引发现的 Javadoc 直接打开为 403；本报告对字段的陈述依据**实际下载并读取的 SAP 固定版本源码**，不是索引。SDK 3.59.0 代码包中的 `2021.000` 文档链接只是附带的业务文档定位，不把该链接当成本次已实际读取的网页正文。
- 不把这项部分直接支持称作 PP-09 完整、M3 整体通过或生产系统行为已验证。


## 独立复核

`/root/consultant_m3_review` 独立读取 SAP 3.59/3.70 发行说明，并对本地已下载的两个源码包各自重新计算 SHA-256、解压核对 service/entity、五个 `@Key` 与两个非键属性；该复核使用同一本地源包，不代表第二次独立下载。结论只涉及生成 SDK 的特定实体，未读取目标系统 `$metadata`、未验证 MATDOC 物理键、权限或关联基数；不计正式文章审核轮次。
