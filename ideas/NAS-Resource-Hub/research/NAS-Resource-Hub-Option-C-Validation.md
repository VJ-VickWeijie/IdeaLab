# NAS-Resource-Hub 方案 C 隔离验证

2026-11-19 · 项目所有者已批准按方案 C 验证 · 本轮验证结论提交评审

## 结论

继续采用 **MoviePilot V3 搜索与取种、独立 Hub 呈现与选种、受限通道提交 qBittorrent** 的方案 C。MoviePilot v3.2.7 的原版直连接入没有通过零副作用要求。在两版实际 qBittorrent 测试进程中，受限通道均实现了确认前零写入、确认后仅提交一次、重复请求不再向 qBittorrent 发添加请求，以及断线后按种子哈希确认原任务。

qBittorrent 5.1.0 的文本回执只有成功状态，过滤临时标签后 MoviePilot 无法通过该回执获得任务 ID。5.3.0 对同一夹具返回了含任务 ID 的 JSON。两版都需要把「出现成功回执」和「已在下载器查到目标任务」分开处理。下一阶段的接口设计应以种子哈希回查为准，并记录请求在断线或进程重启前后所处状态。 [评审及 M0 基线](NAS-Resource-Hub-M1-Docker-Reuse-Review.md) · [上游响应解析](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/qbittorrent.py#L139-L158)

## 验证环境与范围

| 层 | 实际运行方式 |
| --- | --- |
| MoviePilot | 固定 v3.2.7，提交 `742533080577622dd91efd786b96104e847e4eda`。使用锁定依赖、Python 3.14.10 和 qBittorrent SDK 2026.6.0。源码 checkout 无修改。 |
| 下载器 | Debian qBittorrent-nox 5.1.0-2（Web API 2.11.4）和 5.3.0-1~bpo13+1（Web API 2.16.2），临时独立配置与下载目录，进程退出后清理。测试仅添加暂停的合成种子，tracker 是命名空间内未监听的回环地址。 |
| 隔离方式 | 独立 Linux 用户和网络命名空间，只有回环接口且 IPv4 无外部路由。一次性 HTTP 中转连接真实测试下载器，MoviePilot 原版下载器模块和客户端实际发送 HTTP 请求。 |
| REST 接口 | FastAPI ASGI 执行 MoviePilot 原版站点、搜索、季集和下载路由。身份库、令牌编解码、PT/元数据来源和下载服务端口使用夹具，跑真实路由与权限分支。 |
| 目录规则 | 虚构影视与种子，SQLite 临时文件和 Asia/Shanghai 合成时钟。验证设计断言，Hub 页面和产品调度器尚未实现。 |

真实 PT、用户现有 qBittorrent 和 NAS 未参与本轮。MoviePilot 整机镜像、浏览器仿真、完整取种链和两容器内存待下一轮 Docker 环境验证。 [MoviePilot 固定版本](https://github.com/jxxghp/MoviePilot/releases/tag/v3.2.7) · [Debian 测试包](https://packages.debian.org/trixie/qbittorrent-nox) · [qBittorrent WebUI API](https://github.com/qbittorrent/qBittorrent/wiki/WebUI-API-(qBittorrent-5.0))

## 下载写入审计

| 断言 | qBittorrent 5.1.0 | qBittorrent 5.3.0 |
| --- | --- | --- |
| 原版登录，初始未完成文件后缀为关闭 | 变成开启，原版直连失败 | 变成开启，原版直连失败 |
| 受限登录及未确认选种 | 发送给下载器的写请求为 0；拦下配置更改和未确认添加各 1 次 | 同样为 0 |
| 保留原始回执，删去入队表单中的 Cookie 和标签 | 实际新增 1 笔，回执为文本，MoviePilot 未取得任务 ID | 实际新增 1 笔，JSON 回执的任务 ID 匹配 |
| 经下载器读回同一哈希后返回结构化回执 | 实际提交 1 次，MoviePilot 获得正确任务 ID | 实际提交 1 次，MoviePilot 获得正确任务 ID |
| 入队后断开回执连接 | 原生调用报无法连接。重新认证并按哈希读取时确认已入队 | 同样可按哈希确认 |
| 重复确认和已存在任务 | 两次针对已有哈希的提交均在中转层拦截，下游添加 0 次 | 同样为 0 |
| 测试结束比对 | 全局配置、全局标签和原任务的保存路径、类别、状态及「已整理」标签一致。三种新增场景各有 1 笔暂停任务 | 同样一致 |

MoviePilot 原始表单中出现了 `cookie`、`tags`、路径和 `torrent__0`。中转只提交一份已确认的种子及测试预设字段。用断言确认转发请求没有 PT Cookie 表单字段或标签，所有配置及标签写 API 均未转发。在 5.1.0 共拦截 3 次全局标签删除、7 次任务标签移除和 2 次标签添加；5.3.0 分别为 1、9、2 次。数量反映版本分支及回执路径，验证条件是越权写请求均被挡住。 [配置同步](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/qbittorrent.py#L212-L284) · [上传表单](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/qbittorrent.py#L543-L615) · [重复下载和标签](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/__init__.py#L153-L229)

## 接口及数据验证

| 项目 | 实际结果与设计约束 |
| --- | --- |
| 站点上新 | `GET /api/v1/site/resource/1` 无令牌 401，普通身份 403，管理身份 200。页面从 0 开始。夹具的成功空结果和无结果信号均产生 `success:true,data:[]`。应记录每个来源的健康状态，避免将超时推断为「暂无资源」。 [源码](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/site.py#L708-L743) |
| 搜索及权限 | 精确搜索实际转发第二季与两个站点 ID，一次返回两条候选。附加的 `episode=3` 没有转发，空搜索业务响应为 `success:false`。搜索和站点资源响应均可携带 Cookie 及下载地址，Hub 服务端须做展示字段白名单。 [源码](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/search.py#L521-L571) |
| 季集及手工下载 | 季集查询返回指定第二季与第三集。浏览与搜索没有触发下载。无权限提交为 401，缺必要参数为 422，完整请求只调用一次模拟下载服务并返回其回执。在本测试中，REST 下载服务替换为记录器，下游 qBittorrent 验证独立执行。 [季集](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/media.py#L778-L845) · [添加下载](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/download.py#L238-L275) |
| 目录 | 八部虚构作品中，同名异年两部保留两条；同一作品跨站 12 个版本仍只有一条作品记录。新上映且无 PT 的作品仅进近期区，旧片有新种子进 PT 区，同显作品共用 ID。核对了跨季同集号、完整季包、无季包、番剧绝对集号与特别篇。缺图或简介的作品留待补录。 |
| 日更 | 在 Asia/Shanghai 时间跨日两轮刷新，模拟一站 429、另一站拉取不完整、上映源成功。重复刷新同一条数据保持幂等，旧的成功快照及状态仍可读，重开 SQLite 后人工纠错记录保留。覆盖的是数据规则，真实调度与供应商接口留待实现后验收。 |

首次运行的实验有两处夹具装配问题。qBittorrent SDK 对读取信息使用 POST，旧版与新版的认证 Cookie 名也不同。另一个问题是 ASGI 手工下载需补装配隔离的识别配置。修正测试夹具后复跑两版 qBittorrent 和全部 ASGI 断言均通过。旧版原生回执、原生直连写配置、断线后原生回执不可靠等失败属于本轮实际发现，仍作为下阶段的验收用例。

## 进入详细设计的条件

1. **保留经过验证的受限下载路径。** MoviePilot 只能访问下载通道。通道须限制认证及所需查询，核验用户确认的候选和种子内容，转发一份允许的 `.torrent`，清掉 Cookie、标签、任意 URL 和客户端给出的目标路径。测试覆盖的是 v1 种子、单通道和预置下载目录。
2. **将入队状态与重试持久化。** 同一下载器与哈希串行处理。确认前查重，入队后按哈希回读。无法查实则记录待确认。测试只覆盖此通道发出的请求，真实 NAS 上的其他写入者并发、v2／混合哈希、失权、重启中断和短时间未查到任务仍须验收。
3. **固定具体站点及新片数据来源的验证条目。** 逐站核对许可、资源上新完整性、分页和失效信号，再验证完整的 MoviePilot 获取种子→下载通道→qBittorrent 回执。部署前在隔离 Docker 测启动和刷新峰值，之后结合 DXP4800 实际内存余量复核。

审批范围是方案 C 隔离验证。本轮支持进入 M2 详细设计评审，尚无正式实施或接入用户 NAS 的审批。两位专项审查者提供了初步源码核对，后续独立审查未能完成；本报告的运行证据均由主会话复跑。

## 可复核的包哈希

| 测试包 | SHA-256 |
| --- | --- |
| `qbittorrent-nox_5.1.0-2_amd64.deb` | `a1e9436eb88ce0d5840adcdd8040c55e214fe54b8599c3c716b5a55bc10af02a` |
| `qbittorrent-nox_5.3.0-1~bpo13+1_amd64.deb` | `631d51758e75911d183cc8f9d898af6dc3b5360f979ade69396c12c61517c524` |
| `libtorrent-rasterbar2.0t64_2.0.11-1_amd64.deb` | `5871a407e756af9436e66bab3f52617fe2669db5da799b5980d180cbccc1118a` |
