# CareerOS V0.3｜COMMON-01 统一术语表：M3 来源核验

核验日期：2026-11-25（Asia/Shanghai）。本文件是来源与边界登记，不是术语表正文；COMMON-01 仍为 planned，三角色正式文章审核为 0。不能把单个术语的来源当成整个术语表的全部验证。

| 来源 | 实际阅读与适用版本 | 可支持的有限范围 | 尚缺 |
| --- | --- | --- | --- |
| [SAP Custom Code Migration Guide for SAP S/4HANA 2021](https://help.sap.com/doc/9dcbc5e47ba54a5cbb509afaa49dd5a1/202110.001/en-US/CustomCodeMigration_EndToEnd.pdf)，第 6 章，印刷页 82 | 官方 PDF 正文可读取；封面为 **S/4HANA 2021 FPS01（2022-02-23）**，文档历史另列 FPS00（2021-10-13），不能把历史版本当当前版本。具体术语语境是自定义代码迁移；2026-11-25 读取，独立审查者复核页码与封面。 | 为自定义代码、ABAP Test Cockpit、检查系统、转换、简化项目等术语提供该指南场景下的官方定义线索；应以原文语境重新核对。 | 不能用此定义采购、质量、财务、生产等其他模块术语，也不能据此推断 FPS00 或所有 FPS 的技术行为。 |
| [SEC Beginners' Guide to Financial Statements](https://www.sec.gov/about/reports-publications/beginners-guide-financial-statements)，Balance Sheets 小节 | 美国证券交易委员会页面，2014-01-12；2026-11-25 实际读取。 | 对资产、负债、权益与资产负债表等式提供基础教育参考。 | 美国语境；不能用来证明借贷方向与复式记账的全部规则、SAP 配置或中国会计准则。 |
| [OpenStax Principles of Finance — Key Terms](https://openstax.org/books/principles-finance/pages/4-key-terms) | 2026-11-25 本次已读取；独立复核指出页面对生成式 AI 使用设有限制。 | 保留此次读取的事实和来源发现，**不作为后续生成内容依据**。 | 相关使用许可及适用条件未确认；不继续读取或将其用作正文生成证据，具体法律适用不作判断。 |
| [SAP 官方术语贡献指引](https://help.sap.com/docs/open-documentation-initiative/contribution-guidelines/content-contribution_sap-terminology.html) | 搜索抓取可见 SAPterm 介绍；本次直接打开正文返回零行，无法在当前工具中确认完整内容。 | 仅作后续查找术语数据库的入口，不作为已读取、可复现的术语定义。 | 目标 2021 SAP 具体术语和中文翻译仍须按对应业务原始资料逐项核对；动态术语页面可能变化。 |

最终词表需为每个词分别绑定来源、产品版本、定义所处业务语境及对应文章；无证据的词条不能标已核验。来源本身的可读性不证明其支持的每一具体结论，也不能代替任何 SAP 实机验证。

独立复核（2026-11-25）：另一执行上下文查阅原始 SAP 文档与 SEC 页面，指出第一版将文档历史 FPS00 误作封面版本；作者修正为 FPS01。该审查者再次阅读修订记录，确认版本和范围描述得到纠正，并确认 SEC 证据未扩大到借贷规则。以上为资料计划复核，不计正式文章审核轮次。
