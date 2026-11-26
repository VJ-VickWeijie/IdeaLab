# CareerOS V0.3｜AI-Integration 来源贴合度复核

复核对象：PR #20 `a345f0b6ee68cf48713540cc6a952b740e54641d` 的 `evidence-tech-m3.md` 与 `detail-tech-ai-v0.3.md`。执行上下文：`/root/developer_plan`。这是一份 M3 来源资料复核记录，不是正式知识文章审核；未访问或测试 SAP 系统。

实际打开 NIST、arXiv、SAP AIF/PFCG、2021 安全手册及 FSD 相关原文；以下限资料层面。

- **AI-Integration-01**：NIST AI RMF 2023 PDF 物理 27–29 页 GOVERN 是通用治理职责；SAP FSD 11.0/2026 的物理 228 页 §2.15.5.2 是 ISLM 将**预测/机器学习**能力整合业务，不是 LLM/RAG 接入；具体 API、版本、认证及数据路线仍缺，SPS10 现版不能倒推 FPS00。
- **AI-Integration-02**：RAG 论文 2021 v4 §1–2 实际讨论检索器、Wikipedia 非参数记忆和生成模型；直接支持研究原理，切分与生产索引机制、ACL、删除/过期、引用可靠性不由该论文保证；具体 SAP 读取接口与 2021 可用性待核，通用论文无须 2021 限制。
- **AI-Integration-03**：Toolformer 2023 §2 是模型决定何时选 API 与参数的实验，不是通用工具调用协议或真实业务授权；SAP AIF 2021 FPS01 的 Additional Details 只列特定接口函数与授权对象，属于邻近 SAP 资料，未证明具体采购 API、身份委派、审批、幂等或写入安全。
- **AI-Integration-04**：NIST 2024 PDF 物理 37 页 MS-2.7-005 关注内容来源认证、访问控制和误报漏报的测量；SAP 2021 安全指南 v11.0 物理 241 页为 **HCM Processes and Forms** 的角色授权实例，仅邻近示例，身份透传、文档级 ACL、秘密管理、保留与服务账号仍需特定接口和系统证据。
- **AI-Integration-05**：NIST 2024 PDF 物理 28–29 页 MP-2.3 建议真实基准比较、多种评估、事实核查和对抗测试；物理 52–53 页 A.1.4 为部署前测试。支持通用评估与人审设计方向，但不能推断固定通过率、实测效果或 SAP 系统能力；待制定案例集及成功标准。
- **AI-Integration-06**：NIST PDF 物理 20 页 GV-1.5 是组织级事件监测责任，不是特定事务；SAP AIF 2021 FPS01 功能及授权对象是邻近来源，若要讲具体运维 T-Code/监控权限需逐项查该接口与组件的 2021 版本证据；不得说所有 AI 服务统一使用 AIF。
- **AI-Integration-07**：SAP PFCG What's New（ABAP Platform 2021，页脚 FPS00）只谈 Fiori Launchpad 的 PFCG 集成/部分服务类型授权默认值；据此前协调者与 `/root/consultant_plan` 的独立阅读记录，2021 Latest Gateway Authorization 支持发起用户授权检查的一般叙述；`/root/developer_plan` 本次未打开该原文；都不证明所有 API 身份透传或某服务账户已配置。具体连接、服务、账户、权限对象及只读查看须另证。
- **AI-Integration-08**：NIST 2024 PDF 物理 55–56 页 A.1.6 内容溯源及 GV-1.6（物理 20 页）信息来源/版本等；RAG 论文讨论检索记忆。支持抽象追溯动机，不规定 doc_id、key、实体关系、SAP 表或保留删除策略，现阶段只能设计为虚构模型待验证。

台账用语建议：“26 个 ID 均有直接主题的可读部分资料”对 03/04/06 的 SAP API/权限/运维核心易产生过高期待，建议改成“每 ID 有至少部分相关背景或子命题来源；部分仅邻近，核心直接来源未完成”，每行继续区分通用/特定 SAP 2021、版本和缺口。不建议以“通用 AI 文献非 2021”作为缺陷；亦不把零实测的计划标为完成。

## 来源与读取归属

- [NIST AI RMF 1.0，2023](https://nvlpubs.nist.gov/nistpubs/ai/NIST.AI.100-1.pdf)，物理页 27–29。
- [NIST Generative AI Profile，2024](https://nvlpubs.nist.gov/nistpubs/ai/NIST.AI.600-1.pdf)，物理页 20、28–29、37、52–56。
- [RAG 论文，2021 v4](https://arxiv.org/html/2005.11401v4)，摘要与 §1–2。
- [Toolformer 论文，2023 v1](https://arxiv.org/html/2302.04761v1)，摘要与 §2。
- [SAP S/4HANA 2021 Feature Scope Description](https://help.sap.com/doc/e2048712f0ab45e791e6d15ba5e20c68/2021/en-US/FSD_OP2021_latest.pdf#page=228)，当次读取 11.0，2026-07-22，物理第 228 页；`latest` 可能变化，不能将当次页码视为永久固定。
- [SAP S/4HANA 2021 Security Guide](https://help.sap.com/doc/d7c2c95f2ed2402c9efa2f58f7c233ec/2021/en-US/SEC_OP2021.pdf#page=241)，当次读取 11.0，2026-07-22，物理第 241 页。
- [SAP Application Interface Framework，S/4HANA 2021 FPS01](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/d6dbbb13ef1f47398b7864bc6e1cd051.html)，Technical Details 和 Additional Details。
- [SAP PFCG Integration，ABAP Platform 2021](https://help.sap.com/doc/34796706f38646f68d51a0fa0d4636e4/100/en-US/e6b26131fe4e43779b4141e191da6b07.html)，开头和 Technical Details。
- [SAP Gateway Authorization，ABAP Platform 2021 Latest](https://help.sap.com/docs/ABAP_PLATFORM_NEW/68bf513362174d54b58cddec28794093/815c22518bc72214e10000000a44176d.html?version=202110.latest)，该有限描述转述此前协调者与 `/root/consultant_plan` 的独立阅读记录；`/root/developer_plan` 本次未打开该原文，不能计为本人的独立原文核验。具体 FPS 待核。


## 阅读归属修订

`/root/developer_plan` 复读提交 `d6049bc2c2920033968a45b04844fccbc8a22266` 时发现初稿将 Gateway 阅读错误归于自身；Work 已改为转述此前协调者及 `/root/consultant_plan` 的实际阅读记录。原审查者已在提交 `09deed90fb2c06d62ea60e2b999a181bb1e626f5` 复读确认归属与 ID；不可因错误归属虚增独立验证次数。
