# FI-10《财务配置查看》

- **状态：** `drafting`（证据受限草稿；不是完整的 FI 配置指南）
- **目标版本：** SAP S/4HANA 2021 On-Premise
- **学习方式：** 阅读 SAP 固定版资料并做离线判断练习；不需要连接 SAP，也不要求生产系统写权限
- **当前证据范围：** 两个被 SAP 2021 资料明确描述的窄例子：自动科目确定应用的有限更新，以及 GR/IR 总账科目主数据中的扩展未清项管理显示字段。

## 本篇能回答什么

财务配置会影响业务凭证如何找到对应的总账科目，也会影响哪些信息可在主数据中查看。SAP S/4HANA 2021 的资料给出了下列有限线索；它们适合练习“来源实际证明了什么”，暂不足以组成公司代码、科目表、过账期间、自动科目与收付款设置的完整配置课程。

阅读后应能分清：

1. SAP 文档把某个应用描述为配置用途，不等于它是只读查看入口。
2. 主数据页上的一个只读字段，不等于用户已获授权，也不等于整张应用只读。
3. 发行说明中的某个新增键或通配符，只适用于来源写明的业务过程。

## 目标版直接证据

### 例一：Automatic Account Determination 应用

SAP《What's New in SAP S/4HANA 2021》§3.6.1.3 说明，可使用 **Automatic Account Determination** 应用配置总账科目分配（G/L account assignments）。用初学者的话说，这是为业务相关处理设置其总账科目归属；这句话不表示 SAP 在该条目中给出了具体业务触发因素或账户映射。文档说可在 App Finder 中按应用名称查找。

条目把 J58 和 FI-FIO-GL-CA 分别列为范围项（scope item）与应用组件（application component）。它们是该公告的范围元数据，不证明具体客户系统已部署该功能、已激活对应范围，或某个公司代码/用户具有相应配置权限。`Available As Of SAP S/4HANA 2021` 是该公告的版本标记；本文没有核实每个 2021 FPS 或客户系统的实际状态。

该发行说明列出的具体变化有明确限制：

- `BUL` 与 `BUU` 是该公告列出的新增交易键（transaction key，不是事务码/T-Code）。原文名称分别为 `Ledger-Specific CoCode Clearing` 与 `CoCode Clearing Between Differing Amts`；名称直译可作记忆辅助：“分类账限定的公司代码清算”和“不同金额之间的公司代码清算”。这只是名称翻译，不代表对完整业务规则的解释。SAP 把它们列为 **Prepare Intercompany Transactions** 过程中新增的可选键；不据此推导使用条件或其他公司的过账规则。
- `*` 通配符仅在总账 **Integrate with HR Postings** 过程中输入客户或供应商账号的说明中出现，文档给出 `*12345` 示例。SAP 这一段没有定义完整匹配语义、输入校验或其他通配符形式，不能推广成全系统账号搜索语法。

来源没有提供逐项总账账户映射、完整配置步骤或可安全执行的显示模式，也没有证明特定用户能打开或修改该应用。App Finder 的名称搜索提示只是文档中的导航线索，不是角色授权证明。

来源：[SAP《What's New in SAP S/4HANA 2021》§3.6.1.3](https://help.sap.com/doc/b870b6ebcd2e4b5890f16f4b06827064/2021.000/en-US/WN_OP2021_EN.pdf)（印刷页 133–134）。

### 例二：GR/IR 科目上的 Extended Open Item Management 显示字段

SAP S/4HANA 2021 固定版 Help Portal 页面 **Open Item Management in the Manage G/L Account Master Data App** 说明，**Extended Open Item Management** 是一个状态字段，用于表示某个收货/发票收据（GR/IR）总账科目是否启用了扩展未清项管理；相关变化也适用于文档称为 **Display G/L Account Centrally (`FS00`)** 的 SAP GUI 事务。SAP 说明，在相应功能已启用后，该字段显示在相关总账科目详情中，并且字段本身为只读（display only）。本文只介绍状态字段，不讲扩展未清项的清账行为。

这只证明文档描述的特定字段属性。它不证明某个账号有权访问 FS00 或该 Fiori 应用，不证明整个页面只读，也不证明某客户系统已启用此功能。本文不提供启用程序或生产配置步骤。

同一页面还区分另一个字段：**Open Item Management by Ledger Group**（此前名称为 Clearing Specific to Ledger Groups）的后台等价元素是 `XLGCLR`。`XLGCLR` 对应的是按分类账组的未清项管理字段；不能把它说成上述 **Extended Open Item Management** 字段的技术字段、数据库键或 API。

来源：[SAP Help Portal 固定版本 2021.000](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/95c14c3ac4884b8ba46b7da9738fd391.html?locale=en-US&state=PRODUCTION&version=2021.000)，页面标题同上，What's New in SAP S/4HANA 2021 §3.6.1.16；范围项 J58、组件 FI-FIO-GL-MD、适用版本 SAP S/4HANA 2021。

## 配置与只读观察边界

| 主题 | 2021 资料直接支持 | 现有证据不能推出 |
| --- | --- | --- |
| 总账自动科目分配 | Automatic Account Determination 应用具有配置 G/L account assignments 的用途；文档提供 App Finder 名称线索及上述特定新增项 | 完整账号映射、所有业务过程的决定因素、通用 IMG 路径、只读模式、用户授权或目标系统可用性 |
| GR/IR 扩展未清项管理 | 特定 GR/IR 科目详情中的 Extended Open Item Management 字段表示启用状态；来源称字段为只读，并提及相关 SAP GUI 事务 FS00 | 启用步骤、客户系统当前状态、特定用户权限、字段背后的表/键/API，或整个页面和事务的只读属性 |
| 公司代码、科目表与总账科目 | 本篇引用的两个条目不构成这些主题的完整配置证据 | 公司代码日常组织规则、科目表分配、总账科目创建/维护路径及权限 |
| 过账期间与收付款配置 | 本篇引用的两个条目没有覆盖这些主题 | 期间开关、付款参数、银行/支付方式设置及相应只读检查方式 |
| MM 自动科目确定 | 本篇证据是 FI/J58 与 FI-FIO-GL-CA 的发行说明 | 不推导 MM 的 OBYC、BSX、WRX 或任何库存采购借贷分录 |

控制矩阵要求的“配置因素 → 业务行为 → 只读检查入口 → 前提”目前只能对上述字段示例建立局部对应；公司代码、科目表、期间、完整账户映射、收付款和角色授权尚未闭合。因此本篇保持 `drafting`，不列未经证实的操作清单。

## 离线练习：给结论贴证据标签

请把每个说法标成 **直接支持**、**有限支持** 或 **证据不足**，并写出版本和适用边界：

1. “Automatic Account Determination 可配置 G/L account assignments。”——直接支持；但该句不说明账户映射或每个流程的规则。
2. “`BUL` 和 `BUU` 是所有公司间过账都应使用的键。”——证据不足；来源只把它们作为 Prepare Intercompany Transactions 过程中新可选的键。
3. “可以在所有 FI 应用中用 `*12345` 搜索供应商。”——证据不足；来源的通配符示例只涉及 Integrate with HR Postings 的客户/供应商账号输入。
4. “Extended Open Item Management 字段只读，所以用户肯定有权打开该账号。”——证据不足；字段只读属性不等于用户权限或系统部署状态。
5. “`XLGCLR` 就是扩展未清项管理字段的数据库键。”——证据不足（来源将 `XLGCLR` 关联到另一个 Open Item Management by Ledger Group 字段，不能支持该断言）。

## 后续补证清单

- 以固定版 SAP S/4HANA 2021 On-Premise 原始资料补齐公司代码、科目表和总账科目配置条件与精确路径。
- 分别核对过账期间、收付款设置的目标版本行为，以及配置修改与只读查看入口的区别。
- 为每个将来纳入正文的应用或事务逐项确认角色/权限、版本和前提；没有权限证据时只保留离线阅读方式。
- 对自动科目确定逐项核对账户映射与业务行为；不从 FI 发行说明外推 MM OBYC/BSX/WRX 或采购分录。

**系统边界：** 未连接 SAP 系统；未打开目标系统中的应用、事务或角色，也未查看或修改任何配置。文章结论是对官方资料的阅读记录，不是客户系统验证。
