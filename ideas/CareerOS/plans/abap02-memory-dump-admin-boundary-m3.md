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
2. 指南建议从该次 ST22 short dump 的 **Memory consumption** 区域查看实际 EM、Heap 等使用值，并与 ST02 中的当前内存参数作对照。指南建议把 ST02 SAP MEMORY 表的 MaxUse 与 In Mem 放在一起对照，用于判断 uptime 内是否曾用满 EM；这不是该 dump 时刻的快照。dump 时的进程用量应先看该次 ST22 的 Memory consumption 区域。
3. 指南按平台/实现列举若干参数，并提及可由 RSMEMORY 临时调整额度；同时明确额度提高属于 system administrator 的判断，不能脱离应用需求一概调高。参数示例不是本项目提供的调优步骤，执行前必须确认目标系统 OS、memory implementation、kernel、实际参数和权限。
4. 指南将责任分成两部分：确认 memory mechanism 工作正常后，application team 分析异常内存消耗；如果异常来自客户定制程序，再由开发该程序的团队分析代码。它没有说所有此类 dump 都应归咎于代码，也没有说都应通过增加系统额度处理。

## 对 ABAP-02 的证据判定与文章边界

- 与已直接阅读的 [ABAP 7.56 SQL/游标关键词页面](abap-756-keyword-direct-m3.md)合并理解：目标版关键字原文能限定 PACKAGE SIZE、FAE、游标和提交边界；本补充支持通用的 ST22/ST02 排障视角、单进程额度与全局压力的区分，以及管理员/开发团队的责任边界。
- SAP 支持指南与 KBA 均未固定到 S/4HANA 2021/FPS，故只能作为通用邻近排障资料；不得把它们的参数样例、容量阈值、操作路径或技术结论标成 S/4HANA 2021 实测/规范。
- 本两项来源没有说明 TRY...CATCH 能否在目标版本捕获或预警所有内表分配失败，也没有为单条 SELECT ... INTO TABLE 给出通用安全行数。不得用它们声称“提前查询一定能预测 dump”或“增加 quota 即可解决”。
- 代码侧安全设计仍需以 7.56 关键字语义、逐包而非累积无界缓存的内表生命周期、业务可接受的停止策略为基础；实际安全上限需结合行宽、数据规模、运行时内存和目标系统资源由有权限的团队验证。系统配置变更不在本项目范围内。
- 公开资料的判断不能代替本公司目标系统 FPS/OS 与 ST22/ST02 数据核对，也不是用户问题的系统实测方案。

## 独立复读记录

独立开发审查上下文实际直接阅读全文，并向 Work 报告：指南的两类成因、ST22 与 ST02 的诊断要点及配额/代码责任边界可用于解释排障方向；但该页为 Additional Content、没有目标版本矩阵，不能作为 S/4HANA 2021/FPS 专属证据。Work 据此将材料限定为“通用邻近排障资料”。本记录写入后，Work 将请同一独立审查上下文复核记录是否准确呈现来源范围；复核完成前不记录为文档复读通过。此为 M3 来源交叉核验，不计正式文章轮次。

## 后续状态

ABAP-02 仍未闭合：缺目标系统 FPS/OS、获授权非生产环境验证、具体程序行宽与并发内存观测及合适的安全停止上限。相关资料和边界见 [ABAP-02 7.56 关键字来源](abap-756-keyword-direct-m3.md)。M3 未通过，M4 未授权。
