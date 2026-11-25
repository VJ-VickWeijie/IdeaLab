# S4HANA-06：2021 扩展与升级资料证据

状态：M3 资料研究记录，不是正式文章，不计入正式文章审核轮次。没有访问客户 SAP 系统或进行实测。

## 1. 2021 初版：Key User 扩展的具体例子

来源：[App Extensibility (Key Users)](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/84e0198a20974a4086667a1c67d306fb.html?version=2021.000)，SAP Help Portal，What's New in SAP S/4HANA 2021。

读取方式：通过浏览器实际读取页面正文及版本选择器；页面显示 **2021 (Oct 2021)**，并提示该版本文档未随继任版本更新。技术详情标示 Available As Of SAP S/4HANA 2021。

支持范围：SAP 描述 Key User 可通过维护订单自定义字段扩展 Manage Work Center Utilization 和 Assign Maintenance Order Operations 两个应用。

限制：这只是两个指定应用的功能实例，不能推广到所有应用，也不能凭此认定任意对象已发布、所有扩展升级绝对稳定，或证明完整 Clean Core 接口分层策略。

## 2. 2021 FPS01：side-by-side API 的具体例子

来源：[Schedule Maintenance Plans using Maintenance Plan API](https://help.sap.com/docs/SAP_S4HANA_ON-PREMISE/e296651f454c4284ade361292c633d69/b49aca3380b5436aa4e5c494fc0fd33d.html?version=2021.001)，SAP Help Portal，What's New in SAP S/4HANA 2021 FPS01。

读取方式：通过浏览器实际读取页面正文和技术详情；版本选择器显示 **2021 FPS01 (Feb 2022)**，正文技术详情标示 Valid as Of SAP S/4HANA 2021 FPS01，页面提示该版本文档未随继任版本更新。

支持范围：SAP 在 side-by-side 扩展场景中，描述通过 Maintenance Plan API 调度或重新调度维护计划，以及使用 OData batch 集中请求。

限制：仅支持该版本和场景下页面描述的特定维护计划 API 行为；不能说 FPS00 必然支持这些操作，也不能据此推断所有 API 的发布合同、长期不变性或免于回归测试。

## 3. 2021 目标升级指南：版本漂移

来源：[Upgrade Guide for SAP S/4HANA 2021](https://help.sap.com/doc/760ce610a2af4174a329d2d8315378e2/2021/en-US/UPGR_OP2021.pdf)，SAP 官方 PDF，§2 和 §3.4，第 19 页。

读取方式：通过网页读取工具实际读取 PDF 封面、文档历史及正文。当前文件为 **Version 11.0，2026-07-22，SAP S/4HANA 2021 SPS10**；其文档历史记载了 2021 初版及后续 FPS/SPS 迭代。正文总范围是从更低的 S/4HANA 版本升级至 2021 的任意 FPS 或 SPS。

支持范围：§3.4 说明升级前需在正确目标 FPS/SPS 的 2021 系统中，用 Custom Code Migration tool 对照 simplification 检查自定义代码，识别与目标版本范围和数据结构不一致的实例。§2 对产品发行版升级推荐 SAP Readiness Check，同时说明它并非强制。

限制：此 URL 的 PDF 已随时间更新，当前读取版本不能冒充 2021 年 FPS00 原始快照；本节支持针对目标版本的升级检查，不能证明 Clean Core 三层规则、所有扩展零改造或测试可以省略。

## 4. 后期 FAQ：排除将 2022 起能力倒推至 2021

来源：[ABAP Cloud FAQ](https://pages.api.community.sap.com/topics/abap/abap-cloud-faq)，SAP 当前 FAQ，Embedded Steampunk 问答。

读取方式：通过网页读取工具实际读取正文，而非仅看搜索摘要。FAQ 明确列出 Embedded Steampunk 的适用版本为 SAP S/4HANA Cloud Public Edition 2208，以及 S/4HANA 2022 的 private 和 on-premise；对更早版本的相关问答表述该技术与内容仅适用于 2022 及以上版本。

限制：这是后期 FAQ，不是 2021 年当时的规范。它可用于阻止将 2022 起的 embedded ABAP Cloud 开发者扩展当成 2021 既有能力，不能证明 2021 没有任何 RAP、可复用接口或其他扩展方式；FAQ 对后续版本的描述也不能替代对 2021 官方规则的直接证据。

## 仍需补证

尚未找到直接面向 S/4HANA 2021 on-prem、覆盖完整 Clean Core 或发布接口分层规则的原始材料。需要进一步逐项核实 2021 目标发行版的发布对象使用范围、稳定合同与废弃策略，以及经典增强和兼容性准则。不能把最新 Public Cloud 的 C1/C2 或三层模型直接写成 2021 on-prem 已有的强制规则。


## 独立复核

`/root/reader_plan` 尝试打开前两页但正文为空，未冒称读到；之后 `/root/audit_design_review` 使用浏览器独立读取第1、2页，确认初版与 FPS01 版本、两个 app 和特定 Maintenance Plan API 例子。不能从 batch 推断原子性、幂等或其他 API 合同；审查者未核对第3、4项升级指南或 FAQ。不计正式文章审核。
