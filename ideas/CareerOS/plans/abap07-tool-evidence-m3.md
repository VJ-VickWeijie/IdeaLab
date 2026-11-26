# ABAP-07：ABAP 工具与事务码的 2021 证据

状态：M3 资料研究记录；不是正式文章，也不计入正式文章审查轮次。研究者通过浏览器实际读取以下 SAP Help Portal 页面正文及可见版本选择器；没有连接客户 SAP 系统、执行事务、开启跟踪或进行实测。版本为 2021 Latest 的页面不是固定初版快照。

## SE37：Function Builder

来源：[Looking Up Function Modules](https://help.sap.com/docs/ABAP_PLATFORM_NEW/bd833c8355f34e96a6e83096b38bf192/d1801ec1454211d189710000e8322d00.html?version=202110.000)，ABAP Workbench Tools，选择器 **2021 (Oct 2021)**。

正文 Procedure 明确将 SE37 称为 Function Builder，并说明可按函数组或包查找现有函数模块，也可筛选 RFC、更新例程和面向客户发布的函数模块。

支持范围限于该页面所述查找流程；它不证明某个具体函数的发布合同、能否安全执行，或当前用户拥有何种权限。查阅函数与执行函数不同；执行的实际影响取决于函数和调用上下文。

## SE11：字典对象维护的具体例子

来源：[Example: Using Check Lock Modes](https://help.sap.com/docs/ABAP_PLATFORM_NEW/6568469cf5a1460a8d85c58b83d21ec2/562639d058ea4843ab4ada04b466951b.html?version=202110.latest)，SAP Lock Concept，选择器 **2021 Latest**。正文在 Procedure 的注释中说明，可用 SE11 或 SE80 基于具有外键关系的表定义该示例中的锁对象。这个动态版本不是固定 FPS00 快照。

补充来源：[Running Local Quality Checks with the ATC](https://help.sap.com/docs/ABAP_PLATFORM_NEW/ba879a6e2ea04d9bb94c7ccd7cdac446/ca5e041535c0491db596d3ca6658cd7d.html?version=202110.002)，ABAP Test and Analysis Tools，选择器 **2021 FPS02 (May 2022)**。正文将 SE11 列为可启动本地 ATC 检查的 ABAP Workbench 编辑事务之一。

上述资料支持特定对象维护与本地检查入口，不构成 SE11 全部对象功能的说明。查看与修改、激活或传输是不同操作，实际权限、影响及变更流程尚待目标环境核实。

## ST22：ABAP Dump Analysis

来源：[ABAP Dump Analysis](https://help.sap.com/docs/ABAP_PLATFORM_NEW/ba879a6e2ea04d9bb94c7ccd7cdac446/491805ac005338a1e10000000a421937.html?version=202110.000)，ABAP Test and Analysis Tools，选择器 **2021 (Oct 2021)**；页面导航标出 ABAP Dump Analysis (ST22)。

正文说明未处理异常会引发 ABAP 运行时错误、终止程序执行并产生 short dump；相关工具可查看和调查保存的 dump，也提供本地保存、打印及保留管理等功能。页面说明标准情况下只显示登录 client 中的 dump，查看其他 client 的 dump 需要相应授权。

不能据此认定所有用户可查看全部 dump。导出或分享 dump 前，应依实际内容和组织规则处理可能包含的业务敏感信息；具体权限和保留策略未在目标系统验证。

## SAT：ABAP 运行测量

来源：[Executing a Measurement in the New ABAP Debugger](https://help.sap.com/docs/ABAP_PLATFORM_NEW/ba879a6e2ea04d9bb94c7ccd7cdac446/6750b67d421f45249bf3f93ecad958cf.html?version=202110.000)，ABAP Test and Analysis Tools，选择器 **2021 (Oct 2021)**。

正文介绍从调试器启动并停止 ABAP trace，成功后通过 SAT 查看 trace 文件；若被调试程序结束时测量仍处于运行状态，需在 SAT 中结束并显示该测量。此来源支持所述 ABAP 运行测量和结果查看场景，不能把 SAT 简化为 ST05 的 SQL trace，也不能推断任何用户都有运行或查看权限。启动测量与仅查看已有结果是不同操作。

## ST05：SQL trace 的具体场景

来源：[Troubleshooting Access Controls for CDS Entities](https://help.sap.com/docs/ABAP_PLATFORM_NEW/c6e6d078ab99452db94ed7b3b7bbcccf/e962eec37286441d909d210a37c328c1.html?version=202110.002)，User and Role Administration of the ABAP Platform，选择器 **2021 FPS02 (May 2022)**。

正文 Procedure 提到，当应用结果可能过多或过少时，可使用事务 ST05 中的 SQL trace 协助分析 CDS access control 场景。此处只能证明该 FPS02 页面描述的 SQL trace 用途，不能据此证明 FPS00 中该篇原文相同、列出 ST05 的全部跟踪类型，或认定一次 trace 必然识别根因。页面随后涉及修复和重建步骤；读取文档不构成执行这些步骤的授权。

## 共通权限和执行边界

文档中存在事务或菜单不等于当前用户拥有事务启动、底层对象访问或跨 client 查看权限。SE37 执行函数、SE11 修改和激活对象、SAT 或 ST05 开启跟踪，都应区分于只读查阅；实际操作可能改变系统状态、增加资源开销或记录敏感数据。应遵循组织的授权与变更流程，在适当的隔离环境中练习。

本次未逐项建立具体授权对象和最小权限，未核实每种 ST05 trace、跟踪开销及文件存储或保留策略，也未验证任何生产系统中的操作安全性。


## 独立文献复核记录

/root/audit_design_review 独立通过浏览器复读 SE37 的 Function Builder 页面与 ST22 的 ABAP Dump Analysis 页面，并确认本文中对应的有限用途、版本信息及只读/执行边界；未复读本报告其余 SE11、SAT、ST05 页面，未访问或操作 SAP 系统。/root/consultant_m3_review 曾尝试独立打开 SE37、ST22 等动态页面，但该上下文返回零行，故其失败尝试不作为交叉支持。Work 保留作者阅读其余来源与独立复核范围的区别；本报告仍未逐项建立具体授权对象、目标系统 FPS 和生产安全证明，不计正式文章审核轮次。
