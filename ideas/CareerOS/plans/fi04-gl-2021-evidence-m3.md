# FI-04：公司代码、科目表与总账科目关系的 2021 固定版本证据

状态：M3 来源研究，2026-11-25；不是正式知识文章、文章审核、M3 验收或 SAP 实机测试。研究者为独立读者视角执行上下文 `/root/reader_plan`。没有连接 SAP，也没有修改配置。

## SAP 2021 官方固定版本：迁移对象指南

[Migration Objects for SAP S/4HANA](https://help.sap.com/doc/69dd0f1ef0034261ab6e617e0b2beb21/2021.000/en-US/MigrationObjects_OP_EN.pdf)，SAP 官方实施指南，封面标注 `SAP S/4HANA 2021 – 2021-09-09`。研究者通过网页检索工具打开并读取封面和 §1.46 `FI - G/L account`，印刷页 191–194 的可读解析文本；未下载原 PDF 字节，未核验文件哈希。该资料属于从源 ERP 到目标 SAP S/4HANA 的 **Direct Transfer - ERP** 迁移对象场景，不是一般性配置教程。

1. 印刷页 191 的业务对象定义将总账科目描述为记录某公司代码价值变动、并表示科目表中总账科目项目的结构。它直接说明三个对象存在关系；该定义本身不构成完整组织定义或财务报表边界。
2. 印刷页 191–192 的选择条件说明，该迁移对象从选定的公司代码推导科目表，并选择对应科目表的源系统 SKA1 科目；In Scope 同时列出 company code views 和 chart of accounts views。它支持此迁移场景把两类视图分别处理，不能据此宣称目标系统 SKA1 均可直接访问、确定全部字段、证明各组织基数或普遍过账规则。
3. 印刷页 194 的验证表将 FS00 同时列为 Change 与 Display。该语境支持两类用途，不意味着整个事务只读、具体人员有访问权限，亦不授权执行修改。

## 其他线索与边界

- SAP 2021.002 [Integration of SAP ERP or SAP S/4HANA with decentralized EWM](https://help.sap.com/doc/00ec86f8eab247aba7cc473a8503029a/2021.002/en-US/HTG_Integration__Decentralized_EWM_based_on_SAP_S4HANA.pdf) §7.5、印刷页 62 的网页解析文本可读，包含向科目表分配公司代码。该节针对独立 EWM 的最小或虚拟公司代码及特定集成，不能扩展为所有业务公司完整规范，不执行其配置步骤。
- 研究者尝试直接打开 SAP Help 的 `G/L Account Master Data`、`G/L Account Master Data in the Company Code` 和 `Environment: G/L Account Master Records` 的 `version=2021.000` 页面，网页检索工具均返回无法访问。默认搜索结果展示较新版本，只能作为后续线索，不能称本次读取目标版正文。

## 待补依据

公司代码定义与法人/外部财务报表边界；操作科目表和多个公司代码的对应关系；科目表视图与公司代码视图的各自字段、维护和过账前提；账本、科目表与余额关系；目标系统 FPS、功能与授权。不得从本次迁移说明外推完整生产配置或实际系统行为。

## 独立复核

`/root/audit_design_review` 使用浏览器直接读取原 PDF 封面及物理/印刷页 191–194；其网页检索工具因文件大小未能打开，**未独立下载文件或计算哈希，也未进行 SAP 实机测试**。审查者确认封面版本及日期、§1.46 的 Direct Transfer 场景、从公司代码推导科目表并选择 SKA1 的迁移范围，以及该场景中 SKB1 存在条件；文中列有两个视图，迁移范围排除 blocked G/L accounts 和 custom G/L account types。这些条件仅在该迁移对象上下文使用，不能作为全部组织基数或过账规则。

审查者还确认印刷页 194 将 FS00 同时列为 Change 和 Display：不能称整个事务只读或假称用户有权限；页 193 列出的迁移授权对象不能作为一般显示权限的完整列表。本次复核不计正式文章审核轮次。
