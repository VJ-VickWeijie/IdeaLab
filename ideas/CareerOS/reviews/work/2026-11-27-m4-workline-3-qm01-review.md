# QM-01｜三角色审查与证据收尾记录

- 文章：knowledge/QM/01-foundations/quality-organization.md
- 日期：2026-11-27（Asia/Shanghai）
- 固定目标：SAP S/4HANA 2021 On-Premise；ECC 仅作必要差异对比。
- 结果：**drafting**。原记录的 15 个闭环（读者、资深 SAP 配置顾问、开发人员各 5）均为同一 Work 上下文的角色模拟，不计独立审查。2026-11-27 三个独立 AI reviewer-context 对最终正文 blob `4519e14b896f0aa3cd71af53e74cb378654cd4d4` 各完成 5 项复核，共 15/15 边界检查通过；质量组织/岗位、检验批创建触发、设置及授权核心证据仍缺，故保持 Draft，不计 Role Reviewed。
- 执行方式：作者模拟与独立 reviewer-context 复核分开记录；最终复核由本 Work 预置的普通读者、资深 SAP 配置顾问、普通 SAP 开发人员 reviewer-context 完成。没有邀请真人专家，未连接或测试 SAP。
- 固定版来源：2021.000《Manage Inspection Lots》官方检索摘要支持 QM-IM、四个 scope item 及 worklist 的结果记录/使用决策；《Customizing Structure for Quality Inspections》摘要仅支持 Reference IMG 结构变化。三页 canonical HTML 本轮直开均为 0 行，已如实标注未直接读取页面正文；检索到的《Business Events for Inspection Plans》仅涉及检验计划的创建/更新/删除事件，不证明检验批创建触发。
- 动态来源限制：FSD `latest` 的官方搜索索引返回 v9.0（2025-07-23），直接打开同一 URL 返回 v11.0（2026-07-22）；版本显示有漂移，均未作为固定 2021.000 证据。
- 依赖：MM-01 已 Role Reviewed，但仅覆盖采购组织；PP-01 当前为 Draft，PROCESS-06 不在批次 A 分支。它们均未补齐质量组织/岗位或检验批触发证据。
- 未解决核心项：质量业务参与者/岗位，检验组织对象与工厂配置，检验触发规则及其前提，scope item/系统功能启用状态，EWM 与普通 IM 边界，以及授权角色。

| article_id | role | round | question | evidence | work_response | change_ref | recheck | status | executor_context | timestamp |
| --- | --- | ---: | --- | --- | --- | --- | --- | --- | --- | --- |
| QM-01 | 普通读者 | 1 | 质量检验是某个质量部门的工作吗？这个部门在 SAP 里叫什么？ | 固定版 Manage Inspection Lots 页面说明 QM-IM 应用功能和范围，但不列企业部门或用户角色。 | 答复：来源不能证明企业岗位名。文章说明 SAP 应用组件与企业组织是两回事，并把部门映射列为待核。 | §1、§3 角色问题 | 复核后没有把企业组织部门当作 SAP 标准对象或角色。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通读者 | 2 | 看到采购、销售、生产、库存几个名称，是不是这四类业务都会自动创建检验批？ | 固定版页面列 scope item 名称并说明应用可处理 inspection lots；未描述创建触发。 | 答复：不能。修订表格明确页面不证明检验批创建事件和条件。 | §2、§3 检验触发行 | 原角色复核确认“应用可处理”未被说成“事件自动创建”。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通读者 | 3 | 结果记录和使用决策是不是一件事？ | 2021.000 页面分别使用 record inspection results 与 make usage decisions 两个动作描述。 | 答复：本篇只把它们当作两个不同动作名称，不补后果。 | §2 末段 | 修订后明确没有把两项动作合并，也没有声称结果必然触发 UD。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通读者 | 4 | 1MR 是不是表示 EWM？Stock Handling 的库存一定在仓库里处理吗？ | 2021 页面列 1MR Quality Management in Stock Handling；页面本身没有在此处定义 EWM/IM 操作流程。 | 答复：不从名称推断技术场景。补充不能据 scope item 名称泛化 EWM 或普通 IM。 | §3 末段 | 复核后没有把 1MR 等同 EWM 或所有库存管理场景。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通读者 | 5 | 我可以进系统看看质量角色或调整设置来完成练习吗？ | 项目未连接 SAP；当前固定页面没有客户系统角色授权说明。 | 答复：本练习仅需离线标注 scope item，不要求系统访问或配置更改。 | §5、文章 metadata | 复核后练习没有隐含系统访问、改设置或提交企业数据。 | closed | 同一 Work 上下文内普通读者视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 资深 SAP 配置顾问 | 1 | scope items 和 QM-IM 页面是否固定在 2021 初始版？ | Manage Inspection Lots URL 带 version=2021.000，页面显示版本 2021 (Oct 2021)，Available As Of SAP S/4HANA 2021。 | 答复：只将目标版固定页面所列功能和名称写为可确认事实。 | §2、来源 1 | 原角色复核确认版号与 scope item 列表来自固定页面。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 资深 SAP 配置顾问 | 2 | scope item 名称是否证明某个客户系统已经启用对应范围？ | 页面列范围项和可用版本，没有陈述该客户租户或安装系统的激活状态。 | 答复：不证明。把“产品帮助列出的范围”与“客户系统已启用”分开。 | §2 第二段、§3 第一行 | 修订后 scope item 不被写成客户系统行为事实。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 资深 SAP 配置顾问 | 3 | 是否可以使用 M3 的 FSD 行证明采购/生产/销售的固定版检验触发？ | M3 指向 FSD_OP2021_latest.pdf；M3 来源复核记录了该 URL 的版本漂移和无法稳定复现的快照。 | 答复：不能用它充当本篇固定版逐触发证据。正文说明该动态链接限制，并不据其写触发规则。 | §4 最后一项、来源 3 | 原角色复核确认未把动态 latest 摘录包装为固定 2021 直接证据。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 资深 SAP 配置顾问 | 4 | MM-01 的 Plant/采购组织规则能否推出质量组织或检验责任？ | MM-01 固定版来源只覆盖采购组织概念与分配；QM-01 依赖行要求的是质量角色/触发。 | 答复：不能。把 MM-01 作为划界依赖，不把采购组织责任迁移到 QM。 | §4 第一项、§3 组织对象行 | 修订后交叉引用没有生成未经证实的质量组织映射。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 资深 SAP 配置顾问 | 5 | 结果记录和 UD 的功能说明，是否支持库存自动放行或价值变化？ | 2021.000 页面只描述从 worklist 记录结果和作 UD；没有库存/财务内容。 | 答复：不支持。正文将库存、自动化、价值和会计结果列为待后续固定版核验。 | §3 结果与使用决策行 | 原角色复核确认没有从按钮功能推断库存/会计行为。 | closed | 同一 Work 上下文内资深 SAP 配置顾问视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通 SAP 开发人员 | 1 | QM-IM 是表/API namespace，还是此处的 application component？ | 固定版 What's New 的 Technical Details 明确将 QM-IM 列为 Application Component。 | 答复：在本文只按来源标注为应用组件，不推导 namespace、接口或数据模型。 | §2 首段 | 修订后组件标签没有被转写成 API/service 名称。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通 SAP 开发人员 | 2 | worklist 页面支持操作，是否代表某个用户角色拥有结果写入权限？ | SAP 帮助描述功能操作，但没有本客户 user role、authorization object 或显示/修改策略。 | 答复：不代表。加入角色和授权待核项，不推断业务角色。 | §3 角色行、§4 | 复核后正文没有把应用能力写成用户已获授权。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通 SAP 开发人员 | 3 | Customizing Structure for Quality Inspections 页面能否补齐 QM 组织配置路径？ | 固定版页面只说明质量检验 Customizing 结构有合并/重命名等变化。 | 答复：它不提供本篇组织对象/角色模型。只在来源中声明其未用于触发或用户角色结论。 | 来源 2、§3 | 修订后未从菜单结构变化推导质量部门或操作权限。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通 SAP 开发人员 | 4 | PROCESS-06 和 PP-01 都不能提供完整信息时，能否按常见检验流程补写？ | PP-01 为 drafting，PROCESS-06 当前不在分支；准入要求固定版直接证据。 | 答复：不能。将两个依赖状态写入正文并仅限缩至已证实的 2021 应用说明。 | §4 | 复核后没有引用未存在文章或计划流程内容冒充来源。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |
| QM-01 | 普通 SAP 开发人员 | 5 | 是否在任何地方声称过检验触发、库存或 EWM 已实机验证？ | 当前环境没有连接 SAP；固定页面只为产品 Help。 | 答复：没有。强化文章 metadata 和 review 记录的测试边界。 | 文章 metadata、§3、审查记录 | 复核确认无实际用户角色、配置或系统运行结果声明。 | closed | 同一 Work 上下文内普通开发人员视角模拟，非独立代理 | 2026-11-27 |

## M4 目标版续核与作者修订（2026-11-27）

- 首轮最终候选 blob `03065834a4dafd685f441f7cf17fd8030f84e923` 由三个 reviewer-context 复核时，配置顾问指出固定 2021 Help canonical HTML 本轮直开 0 行，须标明只依据官方检索摘要及项目已有记录；另提示《Business Events for Inspection Plans》是计划事件，不是检验批创建触发。开发者指出同一动态 FSD `latest` URL 的搜索索引 v9.0 与直接打开 v11.0 存在版本漂移。
- 作者对上述质询完成修订并生成最终正文 blob `${articleSha}`：增加两页 2021.000 Help 的 0 行直开披露，将计划事件与检验批创建分开，并记录 v9.0（2025-07-23）索引及 v11.0（2026-07-22）直开差异；不将任何动态 FSD 内容作为固定版证据。
- 最终角色复核均针对 `${articleSha}`，未再要求文章正文修改。该 15 项通过表示范围/用语复核，不表示 M3 核心组织、角色、触发、配置与授权门禁关闭。
## 独立最终正文复核（2026-11-27，最终 blob `${articleSha}`）

本轮三个独立 AI reviewer-context 均 fetch 并读取最终 blob；每位角色针对下列五项挑战执行证据判断和原角色复核。最终正文在该复核后未再修改。独立 AI reviewer-context 不是真人专家意见。

| 独立角色 | # | 质询 | 证据答复与最终角色复核 | 判断 |
| --- | ---: | --- | --- | --- |
| 普通读者 | 1 | 2021.000《Manage Inspection Lots》能证明哪些范围？ | SAP 官方摘要支持 QM-IM、1FM/1MP/1E1/1MR 及 worklist 记录结果/作使用决策；本轮 canonical HTML 直开 0 行。正文已限定摘要证据。 | PASS；不推导客户启用、部门或检验批自动创建。 |
| 普通读者 | 2 | 《Customizing Structure for Quality Inspections》是否支持质量组织/岗位？ | 2021.000 官方摘要说明 Reference IMG 结构变化；页面不定义客户角色或组织映射，直开 0 行。 | PASS；只用来描述结构变化。 |
| 普通读者 | 3 | 四个 scope item 是否证明系统激活、业务触发或 EWM 流程？ | 固定版页面列名称，但无客户系统启用或逐项事件条件；1MR 名称不等于 EWM 或 IM 操作流程。 | PASS；边界清楚。 |
| 普通读者 | 4 | FSD 动态版和计划事件页面能否补足检验批触发？ | `latest` 搜索索引 v9.0 与直开 v11.0 不一致；Business Events for Inspection Plans 只涉及计划 CRUD，不是 inspection lot 创建。 | PASS；均被明确排除为核心触发证据。 |
| 普通读者 | 5 | QM-01 的质量组织、角色和检验批触发学习目标是否完成？ | M3 triage 为部分/限缩可写；MM-01 只限采购组织，PP-01 为 Draft，PROCESS-06 尚未建设。 | PASS（状态判断）；保留 Draft。 |
| 资深 SAP 配置顾问 | 1 | 官方 2021.000 app 页面支持功能是否超出摘要？ | 搜索摘要支持应用、组件、范围项及两种 worklist 动作；canonical HTML 直开 0 行。 | PASS；摘要与读取限制已明确。 |
| 资深 SAP 配置顾问 | 2 | IMG 结构变化能否支持用户岗位、组织分配或检验触发？ | Customizing Structure 页面只支持 Reference IMG 改动，不能证明客户设置或责任映射。 | PASS；不作超范围推导。 |
| 资深 SAP 配置顾问 | 3 | Business Events for Inspection Plans 是否能作为 lot creation 规则？ | 2021.000 摘要只列检验计划 create/update/delete 事件；不说明 inspection lot 创建。 | PASS；文章明确区分两类对象。 |
| 资深 SAP 配置顾问 | 4 | FSD latest 的版本边界是否准确？ | 官方检索索引返回 v9.0（2025-07-23），直开相同 URL 显示 v11.0（2026-07-22）；两者均动态。 | PASS；记录版本差异，不作固定版证据。 |
| 资深 SAP 配置顾问 | 5 | 是否达到 M3 核心目标，依赖是否能补足？ | M3 仍要求质量组织、角色、设置与触发；MM-01、PP-01、PROCESS-06 的范围不能填补质量映射。 | PASS（门禁判断）；继续 Draft。 |
| 普通 SAP 开发人员 | 1 | QM-IM 是否被误写成 API namespace 或用户角色？ | 2021.000 官方摘要称其为 Application Component；正文仅译为应用组件。 | PASS。 |
| 普通 SAP 开发人员 | 2 | scope item 是否证明业务服务已发布或授权？ | 固定页仅列范围名和应用功能；未读取客户系统状态/授权。 | PASS；无运行时结论。 |
| 普通 SAP 开发人员 | 3 | IMG 来源是否证明授权对象或只读入口？ | 2021.000 Customizing 摘要只说结构变化；无用户授权或只读测试。 | PASS；未声称角色/权限证据。 |
| 普通 SAP 开发人员 | 4 | FSD 和计划事件的版本/对象边界是否明确？ | FSD v9/v11 搜索与直开差异已披露；计划事件限定于 inspection plan CRUD，不推广为 lot trigger。 | PASS。 |
| 普通 SAP 开发人员 | 5 | 系统启用、触发和核心目标是否经过验证？ | 正文明确未连接 SAP、未核客户应用/角色/设置/授权；M3 核心项仍列缺口。 | PASS（边界准确）；整体维持 Draft。 |

**结论：** 15 项独立 reviewer-context 检查通过的是证据边界和说明准确度，不能替代核心资料。QM-01 保持 Draft，不计 Role Reviewed 或 Owner Accepted。未连接 SAP；未做实机、配置、业务流程或权限测试。