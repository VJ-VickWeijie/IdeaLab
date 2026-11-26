# ABAP-02 内存诊断来源复核｜2026-11-26

状态：M3 来源记录审查；不是正式文章的三角色审核轮次。本文件按实际 Work 与独立开发审查上下文的消息记录，不把来源复核计入正式文章的 5～10 轮统计。

## 审查材料

- [ABAP-02 内存短转储与资源诊断补充](../../plans/abap02-memory-dump-admin-boundary-m3.md)
- [ABAP 7.56 SQL/游标关键字来源](../../plans/abap-756-keyword-direct-m3.md)
- SAP KBA 2180736 公开预览：<https://userapps.support.sap.com/sap/support/knowledge/en/2180736>
- SAP Help Support Content：<https://help.sap.com/docs/SUPPORT_CONTENT/si/3362959561.html?locale=en-US>

## 实际审核意见、答复和修改

### 独立开发审查者的核验

独立开发审查者直接读取 KBA 2180736 公开预览及 SAP Help Support Content 正文，之后直接 fetch 并复读 PR #20 分支中的 ABAP-02 来源记录（当时 blob SHA ae55f42...）。其意见是：两个来源的版本限定、RSMEMORY/参数边界、管理员与开发团队分工，以及“这两页不能证明 TRY...CATCH 行为”的表述总体谨慎；不应把 TRY...CATCH 的缺少证据写成它必然无法捕获的事实。

### 具体问题

原文写道：“ST02 的历史 MaxUse / In Mem 观察不应误称为某一瞬间的 dump 快照。”独立审查者指出，这会把 MaxUse 和 In Mem 一并称为“历史观察”，字段含义可能因此模糊。

### Work 答复与修订

Work 接受该精度意见。基于该指南原文，不为 In Mem 额外赋予超出页面的字段定义；改为写明：指南建议将 ST02 SAP MEMORY 的 MaxUse 与 In Mem 一起对照，用于判断 uptime 内是否曾用满 EM；这不是 dump 时刻快照，dump 时的进程用量应先看该次 ST22 的 Memory consumption 区域。

修改提交：620d991bd4a736bd70d0ea9660ef942439b7fafe。

### 首次修改后的复读

独立开发审查者在 PR #20 head 32574a6ee04de819a06638e1eb0c3ae10a00a50f 复读来源记录以及相关资源表、摘要后，确认六个 2021 参数、软/硬限额、TRY...CATCH 边界、S4CORE 106 案例限定和 Additional Content/KBA preview 边界均准确。其提出三项进一步精度建议：

1. 把 “S/4HANA 2021 对应的 ABAP Platform 文档” 改为精确说明两页选择器均为 ABAP Platform 2021 (Oct 2021)，但没有 S/4HANA 2021 S4CORE/FPS 标识或系统安装实证。
2. 将 ST02 的 MaxUse/In Mem 表述明确限定为 Support Content 指南的第二个示例；它用于判断 uptime 内是否曾用满实例 EM，不是 dump 时快照，也不能单独将该次 dump 归因于全局 EM 用尽。
3. 补入 SAP KBA 3435216 preview 的窄范围：其标题列 SESSIONMEM_QUOTA_WARNING，症状限定 kernel 7.8* 或更早版本，Product 显示 ABAP Platform all versions / S/4HANA 2020；只可支持名称与页面自述范围，不能外推 2021/FPS 或处理步骤。

### Work 答复与第二次修订

Work 接受上述三项意见。已在 [ABAP-02 来源记录](../../plans/abap02-memory-dump-admin-boundary-m3.md) 精确改写 ABAP Platform 2021 版本边界与 ST02 句子，并加入 KBA 3435216 preview 的限定证据。修改提交：893499ff65874f931af7c5e5c337bf810867896e。

Work 已邀请同一审查上下文复读以上修订及相邻资源表/摘要。**第二次修改后的复核尚待回复**；在其复读前，不标记上述措辞问题关闭。

## 适用范围

该复核只针对 M3 来源记录的证据范围和字段表述。Support Content 页面标注 Additional Content 且无 S/4HANA 2021/FPS 版本范围；KBA 页面是有登录限制的公开预览。二者均不能替代目标系统 FPS/OS、实际 ST22/ST02 数据或获授权的非生产程序验证。此记录不是正式文章验收，ABAP-02 和 M3 仍未通过，M4 未授权。
