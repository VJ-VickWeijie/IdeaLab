# QM-03｜三角色质询、答辩与复核记录

- 日期：2026-11-27（Asia/Shanghai；逐轮具体时分不可见，不编造）
- 工作线：CareerOS M4 批次 A 工作线 3
- 文章：[QM-03《检验计划与检验特性》](../../knowledge/QM/02-functions/inspection-plan-characteristic.md)
- 目标版本：SAP S/4HANA 2021 On-Premise
- M3 准入：限缩可写；须补计划选择规则、抽样参数和具体字段。
- 执行方式：同一 Work 上下文依次使用普通读者、资深 SAP 配置顾问、普通 SAP 开发人员视角进行质询、证据答复、修订和原视角复核。没有调用独立子代理、第二模型或真人专家；记录不声称独立审查。
- 证据：E1 是固定 SAP S/4HANA 2021 FPS01 What's New §4.3.1；E2 是 SAP Help version 2021.000 的 Business Events for Inspection Plans；证据登记和版本边界见正文及 M3 计划。本篇没有用动态 FSD latest、较新 2025 Help、ECC 或 Cloud 文档填补目标版缺口。
- 来源读取边界：本次通过 SAP 官方检索返回并打开了 E1 PDF 正文，确认 §4.3.1、页面内容及版本；E2 固定页面的搜索结果显示版本 2021 (Oct 2021)，打开正文返回 0 行。本篇仅采用该版搜索结果明确返回的事件、对象与版本信息，未据此扩展其他行为。
- 系统验证：SAP 系统未连接；未测试客户应用、计划/特性数据、角色、权限或 API。
- 结论：三个视角各有 5 个同上下文模拟闭环，共 15 个。目标版证据只支持材料筛选和业务事件两项窄切片；inspection characteristic、计划选择、sampling 和有效性核心仍未闭合，文章保持 drafting，不计批次 A reviewed。

## 普通读者视角（5 个闭环）

### QM-03 / reader / round 1
- 问题：什么是 inspection plan？能不能把它直接讲成工厂使用的质检清单？
- 依据与答复：E1 只讲 Manage Inspection Plans 工作清单新增按材料筛选；没有定义计划的完整业务结构或企业工厂如何使用。
- 修订判断：采纳；正文第 1、4 节把“计划是什么”标成未闭合，不用常见教学解释冒充目标版来源。
- 原视角复核：读者能看出当前材料只证明一个筛选功能，尚不是完整入门定义。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / reader / round 2
- 问题：工作清单按材料筛选，是不是系统会自动挑出唯一检验计划？
- 依据与答复：E1 只支持用户可以按材料筛选计划；没有说明计划自动确定或多个结果的选中规则。
- 修订判断：采纳；正文第 2、3 节增加“筛选不等于自动选择”的边界。
- 原视角复核：练习表将筛选能力与计划选择算法区分，读者不会误以为系统已作唯一匹配。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / reader / round 3
- 问题：来源列了 1E1、1FM、1MP、1MR、BNQ，是不是这些功能都已在我的公司开启？
- 依据与答复：E1 将这些标为该项变更的 scope items，没有证明某一客户系统的部署、激活或授权。
- 修订判断：采纳；正文第 2 节说明 scope item 名称不是客户系统启用证明。
- 原视角复核：读者不再把产品范围清单当作其公司环境现状。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / reader / round 4
- 问题：inspection characteristic 是不是就表示某一项要测的数值，例如直径？
- 依据与答复：E1/E2 没有定义 inspection characteristic、定性/定量分类或字段。
- 修订判断：采纳；正文第 4 节将特性定义和字段表明确列为待补，不加直径示例造成这是 SAP 定义的误会。
- 原视角复核：本篇没有把生活例子伪装成固定版产品术语定义。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / reader / round 5
- 问题：2021 FPS01 和 2021 (Oct 2021) 是不是同一份文档？
- 依据与答复：E1 是 2021 FPS01 What's New；E2 是 2021.000 / 2021 (Oct 2021) Help 页面，来源时间粒度不同。
- 修订判断：采纳；正文第 2 节把两个来源分行、分版本登记。
- 原视角复核：读者能看到每项陈述适用的来源版本，没有被说成一个合并发行说明。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

## 资深 SAP 配置顾问视角（5 个闭环）

### QM-03 / consultant / round 1
- 问题：M3 的 FSD latest 已标记 S/4HANA 2021 SPS10，为什么不拿它补计划/特性概述？
- 依据与答复：M3 来源台账记录该 URL 为动态 latest、文档修订与快照非固定；用户要求 QM-01～QM-05 只使用固定版可支持的断言。
- 修订判断：采纳；正文第 4 节明示不把动态摘录冒充固定版事实，并列明修订/归档限制。
- 原视角复核：正文没有将 SPS10 快照混称为 2021.000 或所有 2021 修订。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / consultant / round 2
- 问题：Business Events 对计划 create/update/delete 的说明，能不能用来证明检验计划的选择过程？
- 依据与答复：E2 仅说明对应用和 OData API 的业务事件；它未写出检验批如何选计划或特性。
- 修订判断：采纳；正文第 1、2 节把事件功能与计划运行/选择规则分开。
- 原视角复核：事件创建/变更/删除与 inspection plan determination 没有混为一谈。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / consultant / round 3
- 问题：计划的 plant、valid-from/key date、change number 和 lot-size 范围应如何共同筛选？
- 依据与答复：E1/E2 均未给出这些筛选条件、优先顺序或适用关系。
- 修订判断：采纳；正文第 4 节逐项列入核心待补项，不写未核实的通用选择规则。
- 原视角复核：顾问能辨认清楚哪些关键配置变量尚无固定版支持。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / consultant / round 4
- 问题：sample size、sampling procedure、sampling scheme 和 dynamic modification 的数据关系是否有目标版证据？
- 依据与答复：本轮固定 E1/E2 未提供抽样字段、参数、兼容性或样本计算公式；动态 FSD 摘录不满足本篇固定版要求。
- 修订判断：采纳；正文第 4 节把这些对象和计算列为待核，未从较新 SAP Help 外推。
- 原视角复核：文章没有暗示抽样参数已确认，或将其他发行版规则装入 2021。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / consultant / round 5
- 问题：FPS01 scope item 和 application component 是否足以断言项目客户已经启用相关功能？
- 依据与答复：E1 是发行说明，列出该变化的 scope item 与 QM-PT-IP；它不证明客户实际激活范围或 Customizing。
- 修订判断：采纳；正文第 2 节仅记录来源标签，明确排除客户部署/激活推断。
- 原视角复核：发行说明属性与项目落地状态边界清楚。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

## 普通 SAP 开发人员视角（5 个闭环）

### QM-03 / developer / round 1
- 问题：E2 提到 Inspection Plan OData API，是否可列实体名、字段、键和 released 状态？
- 依据与答复：E2 只说明该 API 有 create/update/delete 事件；没有给出实体模型、字段、键、版本合同或 released 状态。
- 修订判断：采纳；正文不添加 OData 技术名称、数据结构或生产调用示例。
- 原视角复核：API 事件线索没有被扩写成接口合同。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / developer / round 2
- 问题：事件功能说明是否证明系统已完成事件配置，或某个订阅者会收到事件？
- 依据与答复：E2 只列目标版功能变化，不证明客户系统配置、发布者/订阅者或运行日志。
- 修订判断：采纳；正文第 1、2 节限定为产品文档记载的能力，不说明事件实际交付。
- 原视角复核：文章没有声称集成链已配置或真实消息已经发送。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / developer / round 3
- 问题：工作清单的材料筛选具体是精确匹配、模糊匹配、跨工厂搜索还是服务端参数？
- 依据与答复：E1 只写“filter inspection plans based on materials”，没有描述匹配方式、组织范围或 API 查询细节。
- 修订判断：采纳；正文将此功能描述限制在原文表述，不写筛选语义和技术实现。
- 原视角复核：材料筛选的唯一结论来自原文，没有虚构 UI/API 行为。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / developer / round 4
- 问题：是否能画 inspection plan、operation、characteristic 的表关系或对象关联图？
- 依据与答复：E1/E2 没有完整对象结构或关系基数；当前固定版资料也没有本篇可用的 schema 证据。
- 修订判断：采纳；正文第 4 节把完整结构关系列为待补，不画未经证实的数据模型。
- 原视角复核：读者不会将一张教学图误认为 SAP 技术数据模型。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

### QM-03 / developer / round 5
- 问题：能否在无 SAP 系统的情况下写“Fiori 已可用、Quality Planner 可维护”或标为已验证？
- 依据与答复：E1 说明产品发行变化，不证明客户部署和权限；本轮也没有接入客户系统。
- 修订判断：采纳；正文及文章元数据明示未做系统、授权、应用或 API 实测。
- 原视角复核：没有测试结果、用户角色或应用可用性的虚构陈述。
- 状态：closed-in-simulated-perspective；executor_context：同一 Work 上下文角色模拟；timestamp：2026-11-27（Asia/Shanghai，具体时分未记录）。

## 结果与状态

- 闭环数：普通读者 5、资深 SAP 配置顾问 5、普通 SAP 开发人员 5，共 15 个同上下文模拟闭环。
- 每个闭环均有具体问题、目标版证据答复、修订判断、对应正文位置和同一角色视角复核；不代表独立代理、第二模型或真人专家意见。
- 文章继续保持 drafting：计划选择、检验特性、sampling、有效期和客户环境证据仍不足，不计批次 A reviewed 或 owner accepted。
- SAP 系统未连接；没有实际 app/API/权限测试。
