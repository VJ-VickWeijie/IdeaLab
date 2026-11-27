# MM-04｜采购申请与订单机制：三角色审核记录

- 日期：2026-11-26（Asia/Shanghai；各次原始记录未提供精确时刻，不补造时刻）
- 分支：careeros-v04-m4-batch1-20261126
- PR：#21（开放、未合并）
- 正文：[MM-04 采购申请与订单机制](../../knowledge/MM/02-functions/requisition-po.md)
- 最终正文 blob SHA：4ec8777bb89d236d147824729e1e32d0833ed5c4
- 状态：reviewed，待所有者验收；本记录本身不等于所有者验收。
- 有效闭环：普通读者 5、资深 SAP 配置顾问 6、普通 SAP 开发人员 7，共 18 个。

## 真实执行上下文

| 执行角色 | 实际上下文 | 模型/时间信息 |
| --- | --- | --- |
| Work 写作、答辩、协调 | 本 Work 主执行上下文 | 当前界面未暴露模型 ID；日期记录为 2026-11-26 |
| 普通读者 | 独立角色上下文 reader_review_fi0406 | 非人类外部顾问；模型 ID 未暴露；只记录可见日期 |
| 资深 SAP 配置顾问 | 独立角色上下文 consultant_review_fi0406 | 非人类外部顾问；模型 ID 未暴露；只记录可见日期 |
| 普通 SAP 开发人员 | 独立角色上下文 developer_review_fi0406 | 非人类外部顾问；模型 ID 未暴露；只记录可见日期 |

各闭环均记录了角色提出的具体问题、Work 的证据答辩及修订判断、Git commit/正文差异和原角色复核。没有把 Work 自问自答计为角色意见，也没有虚构人工专家、SAP 实机测试或 T-Code 权限验证。

## 目标版本证据与边界

- 主要依据 SAP S/4HANA 2021 On-Premise Feature Scope Description（动态 latest；Work 于 2026-11-26 读取显示 11.0、2026-07-22、对应 2021 SPS10），相关部分包括 §2.12.3.2 Source Assignment（PDF 正文页 152–154）、§2.12.4.2 Requirements Processing（157–158）、§2.12.4.3 Purchase Order Processing（159–160）。动态文件未保存 2026-11-26 独立字节快照；M3 台账哈希只对应 2026-11-25 读取，文章已明确披露。
- 辅助来源分别是 SAP Help 2021.000 的 Manage Workflows for Purchase Requisitions 与 My Purchase Requisitions。后者涉及范围项 18J、1XI、O8J；限额项解释仅限该页面所列应用范围，不泛化为所有 PR 创建方式。
- RFQ 依据拆分为：§2.12.3.2 支持无有效来源时使用 RFQ；§2.12.4.2 支持无来源或多个潜在来源时创建 RFQ 寻找合适供应商。二者均不提供详细供应商选择算法。
- 未连接 SAP 系统。PR 合并资格、后台作业触发条件、手工指定供应商是否满足 source assigned 条件、工作流/审批矩阵、持久数据关系与字段复制、具体事务与权限、客户系统结果均未声称已验证。

## 普通读者｜5 个有效闭环

执行上下文：reader_review_fi0406。读者对首轮五项意见明确建议作为一组计 1 个闭环；后续每个新问题独立答辩、修订并由同一读者复核。

| 轮次 | 读者问题与证据 | Work 答辩、修订与差异 | 原角色复核与状态 |
| --- | --- | --- | --- |
| R01（计 1） | PO 一创建是否构成对外法律承诺；编号步骤是否暗示固定顺序；PR 自动审批与 PO 自动放行是否同义；合同调用是否易懂；离线练习是否可自检。依据 FSD §§2.12.4.2–4.3。 | 将 PO 限定为发给供应商的请求/指令，不判断法律效力或发送状态；说明编号只是阅读组织；把 PR 与 PO 的自动处理解释为不同单据上的流程关口；解释合同调用为基于已有合同创建具体 PO；给练习补充答案思路。相关差异：[ea259694](https://github.com/VJ-VickWeijie/IdeaLab/commit/ea25969488a2f62a848154bbd0e9d3cfd01df4cd)、[b5f6797](https://github.com/VJ-VickWeijie/IdeaLab/commit/b5f67970989b1b345709d45784e9281d3b31e87d)、[025af17](https://github.com/VJ-VickWeijie/IdeaLab/commit/025af17fe7ce0c0322c789776fcf86ce00648882)、[40d6c3f](https://github.com/VJ-VickWeijie/IdeaLab/commit/40d6c3fcf6e07387e2b929f498d7087b48536d69)。 | 读者在 SHA 7539a2cbd7057084d3456f59c3487865a0ec11d3 的复核中逐项确认五项已解决；仅计一个捆绑审核闭环。通过。 |
| R02 | 比较表“本文不据此推断”行被插入的说明文字打断，可能脱离表格。 | 将说明移至完整表格之后，恢复表格行。差异：[b0fcd1d](https://github.com/VJ-VickWeijie/IdeaLab/commit/b0fcd1db15c4009638ef683bdb67fc537d21f4c3)。 | 读者在 SHA b15d55a02e0c27297bc4256e727d4bb75759596f 确认表格结构通过；本项关闭。 |
| R03 | “限额项”对第一次接触采购流程的读者不清楚，影响练习自检。 | 基于固定版 2021.000 My Purchase Requisitions 页面说明：指定范围内，限额项用于下单时无法详细说明的计划外服务/材料，可设预期值和总额上限；排除服务明细、审批和发票规则的推断。正文和台账分别更新：[a273d1d](https://github.com/VJ-VickWeijie/IdeaLab/commit/a273d1d32a8ebbc284af4fd763b4fea2a8dd745d)、[685938b](https://github.com/VJ-VickWeijie/IdeaLab/commit/685938bfd88e0e48f7aef3c7e78c54ea0b77f60d)。 | 读者在 SHA 25e444d51b446726aa606508d666f9c2f00c1080 确认解释足够通俗且限定应用范围；本项关闭。 |
| R04 | RFQ 首次出现未给中文/英文全称和用途，练习要求区分其业务角色。 | 首次出现改为“询价（Request for Quotation，RFQ）”，说明用于向潜在供应商征集报价寻找来源；补入 §2.12.3.2/§2.12.4.2 链接并限制算法推断。正文与台账差异：[2403bcf](https://github.com/VJ-VickWeijie/IdeaLab/commit/2403bcf1be37cbcfd6b75afa0db7a27505dbe62c)、[fd48dd7](https://github.com/VJ-VickWeijie/IdeaLab/commit/fd48dd7ab7c37d93e16e7d2bb99f391ded8da608)。 | 读者在 SHA 845d9b560f833042b5fa5e9c9aecdaf6d7fbfc43 确认术语和用途清楚且无新增歧义；本项关闭。 |
| R05 | 手工填写供应商是否等同于后台建 PO 条件中的 source assigned，正文需区分。 | 明确 FSD 未证明两者等价；要求查具体系统与配置，并将该证据缺口登记到 M3 台账。差异：[8e3d925](https://github.com/VJ-VickWeijie/IdeaLab/commit/8e3d925faf242432fe821e6d3da3939ef2261f84)、[949a431](https://github.com/VJ-VickWeijie/IdeaLab/commit/949a43135898a5a5aff8469717a0b52e963dea14)。 | 读者在 SHA 21fb49fd1c0785e375a8620db445fa64b6d7a024 确认差异和待核边界已明确；本项关闭。 |

最终读者复核于正文 SHA af80a0c218c1ad5797ac9933660e52d89a5b67af 通过；随后只更正状态行至最终 blob 4ec8777bb89d236d147824729e1e32d0833ed5c4。读者比较确认正文逐字未变。

## 资深 SAP 配置顾问｜6 个有效闭环

执行上下文：consultant_review_fi0406。

| 轮次 | 顾问问题与证据 | Work 答辩、修订与差异 | 原角色复核与状态 |
| --- | --- | --- | --- |
| C01 | FSD 支持采购人员或其他专员手工创建 PR，不直接支持正文所列的使用部门/计划人员为系统创建者。 | 区分业务需求提出者与系统创建者；限定系统手工创建角色至 FSD 用语，不枚举未证实来源。差异：[b5f6797](https://github.com/VJ-VickWeijie/IdeaLab/commit/b5f67970989b1b345709d45784e9281d3b31e87d)。 | 顾问在最终复核中确认边界关闭；无新事实错误。 |
| C02 | 自动/单步/多步审批、审批人分配和退回修改应归于 flexible workflow，不能套用到 release strategy。 | 将具体能力明确限定于 flexible workflow；release strategy 仅列为另一机制，不补写未证实规则。差异：[b5f6797](https://github.com/VJ-VickWeijie/IdeaLab/commit/b5f67970989b1b345709d45784e9281d3b31e87d)。 | 顾问最终复核确认关闭。 |
| C03 | FSD 列举多条 PR 合并和后台创建 PO 的能力，但未给合并资格、作业条件；来源已分配不等于必然触发。 | 将其限定为功能选项；不声称任意 PR 可合并、来源分配足以触发作业或批准 PR 必然变 PO。差异：[b5f6797](https://github.com/VJ-VickWeijie/IdeaLab/commit/b5f67970989b1b345709d45784e9281d3b31e87d)。 | 顾问最终复核确认关闭；未将未证实规则写入正文。 |
| C04 | 账户分配不适用于所有 PO，不能由高层示例推导普遍 FI 费用过账。 | 限定为使用账户分配的采购项目，并说明是业务层解释，不代表每笔采购都有该处理。差异：[b5f6797](https://github.com/VJ-VickWeijie/IdeaLab/commit/b5f67970989b1b345709d45784e9281d3b31e87d)。 | 顾问最终复核确认关闭。 |
| C05 | 动态 FSD 与固定版 Help 页面是不同证据；应说明动态源哈希日期和未证明客户配置的边界。 | 正文和证据台账分列 FSD 11.0/SPS10 与 Help 2021.000；说明 11 月 25 日 hash 不属于 11 月 26 日读取文件，且未保存该日独立快照。差异：[025af17](https://github.com/VJ-VickWeijie/IdeaLab/commit/025af17fe7ce0c0322c789776fcf86ce00648882)、[685938b](https://github.com/VJ-VickWeijie/IdeaLab/commit/685938bfd88e0e48f7aef3c7e78c54ea0b77f60d)。 | 顾问在 SHA b15d55a02e0c27297bc4256e727d4bb75759596f 及后续 SHA af80a0c218c1ad5797ac9933660e52d89a5b67af 复核通过。 |
| C06 | RFQ 用途引用到 FSD 章节时，§2.12.3.2 与 §2.12.4.2 支持的条件不同，原引用把两者混在一起。 | 分开标记：§2.12.3.2 对应无有效来源；§2.12.4.2 对应无来源或多个潜在来源。同步修正文和台账：[a864a3c](https://github.com/VJ-VickWeijie/IdeaLab/commit/a864a3c39e6e9d9bbaab4e10180a40ecb4aba0e7)、[7812e99](https://github.com/VJ-VickWeijie/IdeaLab/commit/7812e9919890fa62a524fb2436cc5eb7a1082b73)。 | 顾问在 SHA af80a0c218c1ad5797ac9933660e52d89a5b67af 确认两节归属正确；本项关闭。状态行 SHA 4ec8777bb89d236d147824729e1e32d0833ed5c4 仅标记结果，顾问确认计数为 6。 |

## 普通 SAP 开发人员｜7 个有效闭环

执行上下文：developer_review_fi0406。

| 轮次 | 开发者问题与证据 | Work 答辩、修订与差异 | 原角色复核与状态 |
| --- | --- | --- | --- |
| D01 | “是否直接等于对外承诺”的表述可能越过 FSD 对采购请求/指令的定义，暗示法律效力。 | 改为讨论单据面向对象和业务表达，并排除审批/发送状态与法律效力推断。差异：[025af17](https://github.com/VJ-VickWeijie/IdeaLab/commit/025af17fe7ce0c0322c789776fcf86ce00648882)。 | 开发者确认关闭。 |
| D02 | M3 台账 PDF hash 是 11 月 25 日，不可当作 11 月 26 日文章读取的字节快照。 | 正文说明日期和 hash 归属、未保留 11 月 26 日独立 hash。差异：[025af17](https://github.com/VJ-VickWeijie/IdeaLab/commit/025af17fe7ce0c0322c789776fcf86ce00648882)。 | 开发者确认追溯限制透明；关闭。 |
| D03（不计数） | 检查 T-Code、应用名称与未来导航路径是否有未经核实主张。 | 未发现该类问题，因此无正文更改；这是无缺陷检查，不计有效闭环。 | 开发者明确建议不计数。 |
| D04 | PO 创建参考来源不代表已证明持久关系、字段复制或表/API 映射。 | 正文限定为创建 PO 时可用的参考，不推导数据持久关系、复制规则或数据模型。差异：[025af17](https://github.com/VJ-VickWeijie/IdeaLab/commit/025af17fe7ce0c0322c789776fcf86ce00648882)。 | 开发者确认关闭。 |
| D05 | “业务对象”易与 SAP Business Object/API 混淆。 | 改称成本/费用承担对象，并声明不是 SAP Business Object、API 或数据库对象。差异：[025af17](https://github.com/VJ-VickWeijie/IdeaLab/commit/025af17fe7ce0c0322c789776fcf86ce00648882)。 | 开发者确认关闭。 |
| D06 | 表格说明块中断 Markdown 表格，导致限制行可能脱离。 | 将说明移至表格之后；恢复最后一行。差异：[b0fcd1d](https://github.com/VJ-VickWeijie/IdeaLab/commit/b0fcd1db15c4009638ef683bdb67fc537d21f4c3)。 | 开发者在 SHA b15d55a02e0c27297bc4256e727d4bb75759596f 确认通过。 |
| D07 | PR 章节的 FSD 来源名称没有可点击链接，难以直达对应内容。 | 加入官方 FSD #page=157 的 §2.12.4.2 直链。差异：[32d64fd](https://github.com/VJ-VickWeijie/IdeaLab/commit/32d64fd2d86f852d8afb4f76f14ce821414abb67)。 | 开发者在 SHA b15d55a02e0c27297bc4256e727d4bb75759596f 确认链接修复。 |
| D08 | 来源列表两条来源重复编号 4。 | 将来源连续编号改为 1–6。差异：[536cc8b](https://github.com/VJ-VickWeijie/IdeaLab/commit/536cc8b77a9a0e7b12c1655a26902b93c4203788)。 | 开发者在 SHA 08b663f8c23fa5c8af32074e711ccf6456b031ff 确认连续编号通过；随后对 RFQ 引文归属及状态行复核均通过。 |

## 最终结论

普通读者 5、资深 SAP 配置顾问 6、普通 SAP 开发人员 7 个有效闭环均已完成，严重问题关闭。正文最终 SHA 为 4ec8777bb89d236d147824729e1e32d0833ed5c4，状态为 reviewed、待所有者验收；仍不等于 owner accepted。该文章和来源台账已更新到 PR #21，PR 未合并。
