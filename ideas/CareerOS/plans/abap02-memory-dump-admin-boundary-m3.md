# ABAP-02｜内存短转储与资源诊断补充（M3）

日期：2026-11-26。阶段研究记录，不是正式知识文章；没有访问客户 SAP 系统、执行配置或运行 ABAP 程序，也不计入正式文章审核轮次。目标主题是 ABAP-02（大批量查询、内表内存风险和 TSV_TNEW_PAGE_ALLOC_FAILED 的预防与诊断）。

## 来源一：SAP KBA 2180736 公开预览

[SAP KBA 2180736 - TSV_TNEW_PAGE_ALLOC_FAILED (or similar, memory related) short dumps](https://userapps.support.sap.com/sap/support/knowledge/en/2180736)

- Work 与独立开发审查上下文分别直接读取公开预览。页面注明这是 SAP Knowledge Base Article - Preview；阅读全文要求登录 SAP for Me。
- 页面标注 Environment 为 SAP NetWeaver release independent、ABAP Platform，Product 为 ABAP platform all versions / SAP NetWeaver all versions。
- 公开预览说明该 KBA 面向 SAP NetWeaver 管理员，讨论 ST22 中的 TSV_TNEW_PAGE_ALLOC_FAILED 及类似内存相关短转储。
- **可支持的范围**：这类 dump 的排查应包括应用服务器资源/内存管理方向；公开预览并未提供诊断步骤、字段解释、配额调整参数或 ABAP 代码修订建议。
- **不能支持的范围**：不能当作 S/4HANA 2021 或具体 FPS 的专属依据；不能据此建议直接提高额度；不能把公开预览当作 KBA 登录全文。

## 来源二：SAP Help Support Content 的内存诊断指南

[SAP Help - TSV_TNEW_PAGE_ALLOC_FAILED](https://help.sap.com/docs/SUPPORT_CONTENT/si/3362959561.html?locale=en-US)

- Work 与独立开发审查上下文分别直接打开并阅读正文。页面注明为 **Additional Content**，并说明它不属于 SAP 一般条款所定义的 Documentation；页面没有 S/4HANA 2021 / FPS 版本选择器或版本矩阵。
- 内容以公开支持指南形式提供诊断示例，不等于目标产品版本规范或特定客户系统配置结论。

### 正文明确支持的诊断框架

1. 指南区分两个可能场景：单个 work process 达到其获分配的 memory quota；或多个进程同时申请资源，导致 application server 总内存压力触及全局阈值。单凭短转储名称不能分辨这两种情形。
2. 指南建议从该次 ST22 short dump 的 **Memory consumption** 区域查看实际 EM、Heap 等使用值，并与 ST02 中的当前内存参数作对照。指南的第二个示例将 ST02 SAP MEMORY 表中的 MaxUse 与 In Mem 对照，用于判断在当前 uptime 内至少曾有一次用满实例可用 Extended Memory 的情形；这个比较不是所选 dump 时刻的快照，也不能单凭它认定该次 dump 就是全局 EM 用尽造成的。该次进程用量应先看对应 ST22 short dump 的 Memory consumption 区域。
3. 指南按平台/实现列举若干参数，并提及可由 RSMEMORY 临时调整额度；同时明确额度提高属于 system administrator 的判断，不能脱离应用需求一概调高。参数示例不是本项目提供的调优步骤，执行前必须确认目标系统 OS、memory implementation、kernel、实际参数和权限。
4. 指南将责任分成两部分：确认 memory mechanism 工作正常后，application team 分析异常内存消耗；如果异常来自客户定制程序，再由开发该程序的团队分析代码。它没有说所有此类 dump 都应归咎于代码，也没有说都应通过增加系统额度处理。

## 来源三：ABAP Platform 2021 内存软阈值和硬限额

SAP ABAP Platform 2021 (Oct 2021) 文档由独立开发审查上下文直接读取：

- [Parameter Reference of SAP Memory Management](https://help.sap.com/docs/ABAP_PLATFORM_NEW/f146e75588924fa4987b6c8f1a7a8c7e/493431b15cce5717e10000000a42189b.html?version=202110.000)
- [Session Memory](https://help.sap.com/docs/ABAP_PLATFORM_NEW/f146e75588924fa4987b6c8f1a7a8c7e/11c6413c521e4a13adf7473af49e8291.html?version=202110.000)

参数参考表列出六个按百分比设置的参数，默认值均为 0：常规会话内存 warning 的 em/sessionmem_warn 与 em/sessionmem_warn_nondia、扩展额度 em/sessionmem_ext 与 em/sessionmem_ext_nondia、扩展额度 warning 的 em/sessionmem_ext_warn 与 em/sessionmem_ext_warn_nondia。

Session Memory 页面区分软阈值与硬限额：在会话内存 quota 尚未用尽时越过 warning threshold，会产生 runtime warning 和 short dump，但程序不会因此终止；超过硬 quota 则会终止程序并写正常 short dump。扩展额度只适用于页面指定的受控场景；页面明确 CL_MEMORY_EXEMPTION 仅可由 SAP 内部使用，不构成客户程序通用的申请接口。参数表可用于辨认系统配置项，不能据此改动客户系统。

这两份 SAP Help 页面的版本选择器均为 ABAP Platform 2021 (Oct 2021)，其参数表和正文列有 Basis profile 层的会话内存软阈值机制。它们不标注 S/4HANA 2021 的 S4CORE 版本或具体 FPS，也不证明任一目标系统实际安装、启用或配置了这些参数；目标系统仍需由 Basis 核实。现有公开正文没有证明该 runtime warning 可由应用程序作为 TRY...CATCH 可捕获的异常事件，或可用作应用级停止信号；也没有说明应用程序能读取/捕获该 warning，或保证程序收到该警告后停止。

## 来源四：SAP KBA 3435216 公开预览中的 warning 名称与版本范围

[SAP KBA 3435216 - SESSIONMEM_QUOTA_WARNING](https://userapps.support.sap.com/sap/support/knowledge/en/3435216) 的公开预览由 Work 与独立开发审查上下文直接读取。预览标题列出 SESSIONMEM_QUOTA_WARNING；Symptom 写明 SAP kernel 7.8* or older version 的系统报告 SESSIONMEM_QUOTA_WARNING 与 SESSIONMEM_QUOTA_EXT_WARNING；Product 标为 ABAP platform all versions / SAP S/4HANA 2020。页面注明完整版需 SAP for Me 登录。

该预览只支持转储名称及其自述版本范围；不能由 SAP S/4HANA 2020 产品条目外推 2021/FPS 行为，也不提供原因、处理步骤、参数默认值或 TRY...CATCH 关系。2021 参数行为应以来源三的固定版本 SAP Help 为依据。

## 来源五：S/4HANA 2021 的 warning 与资源 dump 同时出现的有限案例

[SAP KBA 3564988 - FINS_CFIN_AIF_ANALYZER: Internal task handler error ABAP session terminated](https://userapps.support.sap.com/sap/support/knowledge/en/3564988) 的公开预览由 Work 直接读取；它标注 S4CORE 106、SAP S/4HANA 2021。对于特定 Central Finance AIF Analyzer 报告，预览称 ST22 中可见 SESSIONMEM_QUOTA_WARNING、TSV_TNEW_OCCURS_NO_ROLL_MEMORY 和 TSV_TNEW_PAGE_ALLOC_FAILED。

该公开预览可证明这些 dump 名称在一个 S/4HANA 2021 产品场景中被一并列出；它没有公开全文，未说明三者发生顺序、共同根因、参数设置或一般适用条件。因此不能据此断言 soft warning 必然能阻止 TSV dump，也不能把特定 CFIN 报告推广为普通 SELECT 内表场景或任何客户系统结论。

## 对 ABAP-02 的证据判定与文章边界

- 与已直接阅读的 [ABAP 7.56 SQL/游标关键词页面](abap-756-keyword-direct-m3.md)合并理解：目标版关键字原文能限定 PACKAGE SIZE、FAE、游标和提交边界；本补充支持通用的 ST22/ST02 排障视角、单进程额度与全局压力的区分，以及管理员/开发团队的责任边界。
- KBA 2180736、KBA 3435216 与 SAP Support Content 指南没有固定到 S/4HANA 2021/FPS，作为通用邻近排障资料使用。KBA 3564988 的预览明确列出 S4CORE 106 / S/4HANA 2021 的一个特定 CFIN AIF Analyzer 场景，但没有提供 FPS、warning 与其他 dump 的发生顺序或一般根因。不得把这些资料的参数样例、容量阈值或操作路径标成目标系统规范，也不得将该特定案例推广为普通 SELECT 内表场景。
- 本两项来源没有说明 TRY...CATCH 能否在目标版本捕获或预警所有内表分配失败，也没有为单条 SELECT ... INTO TABLE 给出通用安全行数。不得用它们声称“提前查询一定能预测 dump”或“增加 quota 即可解决”。
- 代码侧安全设计仍需以 7.56 关键字语义、逐包而非累积无界缓存的内表生命周期、业务可接受的停止策略为基础；实际安全上限需结合行宽、数据规模、运行时内存和目标系统资源由有权限的团队验证。系统配置变更不在本项目范围内。
- 公开资料的判断不能代替本公司目标系统 FPS/OS 与 ST22/ST02 数据核对，也不是用户问题的系统实测方案。

## 独立复读记录

独立开发审查上下文直接读取 KBA 2180736 公开预览及 Support Content 指南，并指出其 Additional Content / 版本范围限制；Work 因此将两者限定为通用邻近排障资料。审查者随后指出 ST02 MaxUse/In Mem 表述歧义，Work 于提交 `620d991` 修订；再提出 ABAP Platform 2021 与 S/4HANA 2021/FPS 的标签边界、ST02 第二示例边界及 KBA 3435216 预览范围三项精度意见，Work 于提交 `893499f` 修订。同一审查者在 PR #20 head `63b9bd0` 复读后确认这三项文字准确，可以关闭。该复核只关闭本记录的相应措辞问题，不证明目标系统安装、配置、进程内存画像或应用级安全停止；完整问答、提交和复核过程见 [开发审查日志](../reviews/developer/2026-11-26-abap02-memory-source-review.md)及 [Work 执行记录](../reviews/work/2026-11-26-abap02-memory-review.md)。此为 M3 来源交叉核验，不计正式文章轮次。

## 后续状态

ABAP-02 仍未闭合：缺目标系统 FPS/OS、获授权非生产环境验证、具体程序行宽与并发内存观测及合适的安全停止上限。相关资料和边界见 [ABAP-02 7.56 关键字来源](abap-756-keyword-direct-m3.md)。M3 未通过，M4 未授权。
