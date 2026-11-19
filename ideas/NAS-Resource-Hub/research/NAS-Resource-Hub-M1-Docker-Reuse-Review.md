# NAS-Resource-Hub 开源 Docker 复用评审

2026-11-19 · M1 方案评审 · 待项目所有者审批

## 推荐决定

**优先验证 C。由 MoviePilot V3 承担授权站点的按需检索和取种，独立 Hub 承担作品目录和用户选种。下载提交路径须通过写操作审计后才能定案。**

MoviePilot 已具备站点浏览、精确搜种、候选结果、季集查询及手工下载 API。剩下的主要工作是把不同来源的条目归并为统一目录、提供两个互相独立的首页区块、落实本集与整季的选种规则。独立 Hub 可以把这些规则集中维护，减少和 MoviePilot 页面、插件 SDK 及内部数据库的耦合。

**原版 A 和 C 的直连下载器路径均有阻断项。** MoviePilot v3.2.7 在 qBittorrent 登录成功时同步全局 `incomplete_files_ext`。关闭 MoviePilot 侧的开关仍可能导致一次反向修改。其重复任务分支还能改已有标签。隔离测试已复现登录配置写入。先验证受限下载通道能否让 MoviePilot 完成单笔入队。若无法满足，重新评审 C 的变体，由 MoviePilot 负责检索，Hub 用受限适配器投递一份已选种子。变体需要先确认可从服务端合规取得所选种子文件，并由项目所有者批准。 [登录及配置同步](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/qbittorrent.py#L212-L284) · [重复任务分支](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/__init__.py#L153-L229)

### 评审基线

| 资料 | 固定基线与效力 |
| --- | --- |
| IdeaLab | 评审分支基于主分支 `7449f8e107d46c4087daa41676bc9b1641d7f668`，项目 README 与上次项目提交 `5395b82731c7e0ef16d7a7771436a2f7303a4735` 一致。已记录作品与种子分离、首页双区、剧集/番剧季集结构、作品卡封面与简介、人工选种以及 qBittorrent 常驻。仓库仍将刮削列为下一项。本轮以项目所有者最新要求补纳多来源、文件名识别及人工纠错、每日更新和缺失状态。元数据供应商及展示细则待审批。 [项目记录](https://github.com/VJ-VickWeijie/IdeaLab/blob/7449f8e107d46c4087daa41676bc9b1641d7f668/ideas/NAS-Resource-Hub/README.md) |
| AI-Workflow | V1.1 `939ec44036d89cd91622ab96b938be9f02479026`。本轮产出 M1 评审、候选架构和验证计划，供 M2／M3 采纳和授权使用。仓库尚无整体 M0 通过记录。 [固定流程](https://github.com/VJ-VickWeijie/AI-Workflow/tree/939ec44036d89cd91622ab96b938be9f02479026) |
| MoviePilot | v3.2.7，`742533080577622dd91efd786b96104e847e4eda`。评估使用 V3 镜像和该 tag 源码。 [发布页](https://github.com/jxxghp/MoviePilot/releases/tag/v3.2.7) |
| pt-tools | 稳定版 v0.48.0，`4fd734f39b40f4d6ff499afb94af38d520e3a66b`。另核对预览版 v1.0.0-rc.60，`a5b25e89859d1195ab867cdd7648dfdf64e105da`。下文区分 RC 的媒体功能。 [稳定版说明](https://github.com/sunerpy/pt-tools/blob/v0.48.0/README.md) · [预览版发布](https://github.com/sunerpy/pt-tools/releases/tag/v1.0.0-rc.60) · [官方安装指引](https://firlab.app/pt-tools/guide/install) |

## M0 逐项核对

| M0 需求 | A · MoviePilot 原版与插件 | B · Fork pt-tools | C · MoviePilot 与独立 Hub |
| --- | --- | --- | --- |
| 电影、电视剧、番剧搜索，海报及简介 | 内置媒体搜索和探索，含 TMDb、豆瓣及 Bangumi 等入口。跨来源作品去重、番剧类别和封面/简介均完整的发布规则待补。 | 稳定版成熟能力集中在站点搜索和 RSS。RC 新增 TMDb 媒体探索/详情、Bangumi 番剧日历；完整目录和缺项补全仍需补。 | 复用媒体搜索/探索能力，Hub 建统一作品索引与范围筛选，发布时校验封面和简介。 |
| 首页「PT 资源上新」「近期上映／更新」 | 有分站资源浏览、缓存及探索。订阅日历只覆盖已订阅作品。插件可承载自定义区块，已核对的观影日历插件主要面向电影发行，仍需做双来源聚合。 | 稳定版有 RSS；RC 首页的今日播出来自已订阅内容。需新增按作品去重的 PT 上新区与面向未订阅作品的近期上映／更新区。 | Hub 按 PT 发布时间和影视上映/播出时间分别建立索引。两个区块可同显一部作品，链接同一详情。 |
| 一个作品、多种子、人工选一个 | 已有精确搜种和手动添加单个种子接口。全目录一作品一卡、候选分组和确认屏障待核对/补足。 | 已有跨站搜种和人工推送；RC 支持按作品/季查找、合并版本并展开选择站点。需补作品级聚合和确认规则。 | 复用搜索，Hub 管候选与确认。按站点+站内 ID 去重，同 hash 可归组，保留各站候选；重复点击回查原任务。 |
| 电视剧、番剧作品→季→集，单集与整季 | 有季/集与剧集组查询。按作品搜种接口接受季，普通手工下载入口未提供独立集号；单集、整季候选须另作约束。 | RC 有季集详情、季级搜索、按集筛选与剧集组。集卡进入季查询；需补「下载本集」与「下载整季」的明确语义及完整季包判断。 | 复用季集查询，Hub 只给本集入口列可确认的单集种，整季入口只列可确认的完整季包。缺包时明确显示，暂不拼单集或从季包拆下载。 |
| 多源刮削、文件名识别、人工纠错 | 有多源查询、识别接口、识别词及管理员重识别种子缓存。仍需作品级字段补全、来源追踪与持久纠错。 | RC 可识别种子名/副标题、纠错和集号偏移。简介/图/集信息的多源能力以入库 NFO 和图片为主；下载前作品目录需另做。 | Hub 复用识别，统一来源优先级、作品/季集映射、低置信待确认和人工锁定。 |
| 每日更新，缺失资料或资源 | RSS/站点缓存可复用。资源浏览空数组没有足够信息区分无结果和上游异常；缓存刷新只给汇总，需补站点健康、覆盖和状态。 | RSS 可定时并产生通知；需补日更快照、缺失/陈旧状态和保留窗口验证。RSS 通知规则本身无法保证全程只读。 | Hub 每日在 Asia/Shanghai 分别刷新两个源，保留上次成功数据与每源状态，确认下载时按需重新检索。 |
| 接既有 qBittorrent Docker | 内置适配；登录可能写配置，重复任务可能改标签。验证后才可讨论接入。 | 稳定版和 RC 均支持外置下载器。禁用自动下载、刷流、清理、整理等写路径，并用同一录制桩审计登录和手动推送。 | 先用受限通道验证 MoviePilot 的完整选种投递。浏览器只发候选 ID。通过条件为确认前零写入，确认后最多新增一笔任务，既有配置和任务无变化。 |

MoviePilot 原始证据见 [媒体搜索与识别](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/media.py#L380-L544) · [探索](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/discover.py#L48-L168) · [季信息](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/media.py#L778-L845) · [精确搜索](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/search.py#L521-L571) · [手工添加](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/download.py#L238-L275) · [站点资源](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/site.py#L708-L743) · [缓存刷新和纠错](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/torrent.py#L207-L265) · [订阅日历](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/docs/mcp-api.md#L249-L266) · [插件页面与仪表盘接口](https://github.com/jxxghp/MoviePilot-Frontend/blob/v3.2.7/docs/plugin-frontend-sdk.md)

pt-tools RC 原始证据见 [探索及番剧](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/docs/guide/media-subscribe.md#L13-L60) · [首页今日播出](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/docs/guide/home-and-health.md#L39-L51) · [候选搜索和手动推送](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/docs/guide/torrent-search.md#L26-L74) · [季集详情](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/docs/guide/media-detail.md#L48-L69) · [识别和纠错](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/docs/guide/media-recognize.md#L55-L84) · [多源入库刮削](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/docs/guide/media-library.md#L293-L310) · [RSS 自动下载测试](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/internal/filter/decide_test.go#L793-L827)

## 方案权衡

| 维度 | A · 配置与插件 | B · Fork | C · 两个独立服务 |
| --- | --- | --- | --- |
| 容器和配置 | 一个官方 MoviePilot 镜像。SQLite 与内置缓存起步。只配置站点、需要的元数据及经过验证的下载器入口。新增自定义插件时需验证 V3 SDK 和权限。 | 原版单容器。Fork 要自己构建 Go/Vue、发布镜像、管理持久化 SQLite 与备份，并准备独立 TMDb API Key。 | 两容器，Hub 一个进程同时提供页面和服务端 API，使用 SQLite。MoviePilot 仅走内部网络，优先用内置 SQLite 和缓存。资源通道若需额外守卫，计入维护及内存测试。 |
| 8GB 内存 | 预期低于 C，仍有 MoviePilot/Python 和可选浏览器仿真成本。 | 默认单 Go 服务，预期较轻。采用 RC 的媒体任务后仍须测刷新峰值。 | MoviePilot 常驻是主要开销，另加 Hub 与 SQLite。三案没有同等负载下的本次实测。建议初始验收值为新服务合计空闲稳态 P95 ≤512 MiB、搜索/日更峰值 ≤1 GiB、零 OOM，并在有权测 NAS 手头余量后核对。 |
| 许可 | MoviePilot GPL-3.0。使用官方镜像与发布自改版本不同，发布更改后的镜像须核对相应源码与通知义务。插件须逐个检查许可。 | pt-tools MIT。保留版权及许可文本，另清点第三方依赖、前端资产及元数据条款。 | Hub 独立通过 HTTP 与官方镜像交互，避免复制 MoviePilot 代码或运行时插件。发布自改镜像、复用代码或更紧耦合前复核 GPL 边界；媒体图片、简介和站点访问另看授权。 |
| 安全和维护 | 上游跟进成本最低；一旦定制首页与选种插件，跟随插件 SDK 升级。定期检查站点和插件权限。 | RSS/刷流/清理、自动整理、通知和 App 管理面都要纳入禁用或隔离。RC 的迁移、站点变动、安全修补、镜像和供应链由 Fork 维护。 | 自有 UI 可独立升级；固定 MoviePilot 镜像版本和摘要，保存 API 契约测试和回滚镜像。多一层服务端密钥、缓存和错误处理，下载守卫是必要验收项。 |

参考 [MoviePilot Docker 与配置](https://wiki.movie-pilot.org/zh/install) · [MoviePilot GPL 文本](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/LICENSE) · [pt-tools MIT 文本](https://github.com/sunerpy/pt-tools/blob/v0.48.0/LICENSE) · [pt-tools 构建](https://github.com/sunerpy/pt-tools/blob/v1.0.0-rc.60/Dockerfile#L63-L80) · [Docker 守护进程安全](https://docs.docker.com/engine/security/protect-access/) · [TMDb 使用及署名要求](https://developer.themoviedb.org/docs/faq)

如果 A 找到受维护的插件组合，能完整演示双区、目录去重、单集/整季和受限下发，A 可减少一个容器和自有代码。如果 MoviePilot 无法以目标站允许的方式检索/取种，而 pt-tools 能做到，或 C 实测产生明显内存压力，再以 B 重新评审。B 的 RC 媒体能力需先按固定版本复验，备份和迁移可回滚才考虑 Fork。

## C 需补开发的功能

| 工作包 | 实施内容与边界 |
| --- | --- |
| 1 · 作品目录与首页 | 建立作品、季、集、种子关联四层记录。稳定内部作品 ID 关联带来源及媒体类型的外部 ID。首页按两种时间口径独立排版，保留站点发布时点与首次发现时点；电影/剧/番分类和中外文别名搜索使用同一作品索引。 |
| 2 · 元数据与纠错 | 建议先试 TMDb 为主、Bangumi 补番剧。字段级记录图、简介、季集的来源和更新时间，优先有授权的中文资料。解析种子名/副标题与已许可返回的文件清单，处理同名不同年、绝对集号、特别篇和跨季包。低置信候选进入暂存；纠错支持指定作品及季集、重跑关联，日更保持人工结果。 |
| 3 · 选种与最小下发 | 适配 MoviePilot 查询；显示站点、范围、画质、体积、字幕及做种信息等已有字段。服务端按作品/季集/请求者绑定短时不透明候选 ID，确认时检验候选和授权，优先上传服务端取得的单个 `.torrent` 文件。以下载器及种子标识处理重复确认/超时回查，只用预配置目的地。提交成功与下载完成分别显示。 |
| 4 · 日更及状态 | 两个任务分别记最近尝试、各来源成功时间、游标和结果，使用幂等写入、并发互斥、失败退避及重启恢复。全部有效来源确认无候选时显示「暂无资源」，地区或站点未查完、限流或过期时显示「暂无法确认」或最后更新时间。资料缺失时在搜索空态或直达页显示「暂无资源」，在管理端列「资料待补」，补齐封面和简介后发布作品卡。近期上映候选可取 TMDb 的日期查询与 Bangumi 放送日历，仍需测试地区日期与单集更新语义。 [TMDb 探索](https://developer.themoviedb.org/reference/discover-movie) · [Bangumi 放送接口](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/api/endpoints/recommend.py#L364-L377) |
| 5 · 运营与权限 | 只读采集上新与确认后下发分开。上新优先验证 MoviePilot 站点资源/缓存；若无法证明完整性与失败状态，使用站点明确允许的 RSS 或正式 API 补上新入口。限制站点及元数据域名、放行必要的内部接口。站点认证、下载器凭据和种子链接只在服务端，白名单输出、脱敏日志、受保护备份。固定版本、API 合同与回滚记录。 |

资料缺失呈现、日更具体时间和首页时间窗为本次设计建议。首版交接测试范围保留人工确认；邮件、自动订阅下载和其他下载器留在后续独立决策。

## 关键风险与放行条件

| 优先级 | 风险与证据 | 放行条件 |
| --- | --- | --- |
| S1 | MoviePilot 初始化登录会写全局配置，重复任务路径会修改旧标签，某些 URL+Cookie 分支可能同步 Cookie，成功处理还可触发站点字幕。SDK 默认关闭 qBittorrent WebUI 证书校验。 [配置与证书](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/qbittorrent.py#L212-L284) · [Cookie 路径](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/qbittorrent/qbittorrent.py#L599-L615) · [字幕等附加操作](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/chain/download/processing.py#L69-L105) | 通过应用身份和仅允许登录、查询、添加的受限通道测试。拒绝全局配置/全局 Cookie、修改旧任务、整理及任意路径写入，核对 API 回执与测试前后状态。下载端点走可信内网隔离，跨信任边界的 TLS 由可校验证书的组件终止。失败则暂停原生下载链，回到设计。 |
| S1 | 站点兼容和站点授权是两道独立门槛。MoviePilot 的站点浏览需要管理权限，固定 API Key/Token 在 `verify_token` 中映射为超级用户。站点/搜索投影可含 Cookie 和下载地址。 [权限](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/adapters/web/security/access.py#L307-L345) · [索引层种子字段](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/app/modules/indexer/__init__.py#L570-L594) · [站点接入文档](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/docs/site-api-integration.md#L15-L70) | 逐站先核对规则、可用接口和站点支持。使用服务端管理身份的窄接口、内网隔离和最小权限。浏览器及日志不得出现 Cookie、带密钥链接或上游管理员凭据。第三方插件逐个审核。容器不给 Docker socket、特权模式或用户媒体库写访问。 |
| S2 | 每日一次若遇 RSS 条数上限、站点短保留或漏页，可能遗漏上新。浏览 API 空数组也不足以确认站点健康。 | 合成峰值样本验证可分页或时间回溯、持久游标和补跑。站点无法提供 24 小时覆盖时，标明覆盖限制并回评，空数据不覆盖曾成功的快照。 |
| S2 | 同名、集数偏移和跨来源 ID 错配，可能让用户选错内容。海报和简介使用受提供方条款约束。 | 使用同名异年、不同地区放映日、番剧绝对集号和缺图/简介样本。来源条款、地区和署名按选定供应商检查。低置信映射与季包判定失败时要可纠错。 |
| S2 | 固定版本升级可能改变 API 响应和权限，下载器里到底是否入队可能因超时而不明；8GB NAS 余量未知。 | 对固定镜像复跑契约、权限、入队回查、前后状态和内存测试。官方搜索路由的响应声明与返回体需以实测为准。 |

## 最小验证计划

环境使用本地/CI 独立网络、假站点与元数据响应、假下载器和临时卷。后续需要完整客户端验证时，可加一次性 qBittorrent 测试实例，使用无内容下载需求的合成种子、无有效 tracker 且禁外连。固定镜像摘要、前端及站点资源包版本并关自动资源更新。记录请求轨迹、断言及资源峰值。现有 qBittorrent 的 WebUI 认证、CSRF 和全局配置须保持原样。 [qBittorrent WebUI API 5.0](https://github.com/qbittorrent/qBittorrent/wiki/WebUI-API-(qBittorrent-5.0)) · [MoviePilot 配置](https://wiki.movie-pilot.org/zh/configuration) · [Docker 内存统计口径](https://docs.docker.com/reference/cli/docker/container/stats/)

| 顺序 | 验证 | 通过条件 |
| --- | --- | --- |
| 1 · 下载边界 | 比较 A/C 原版和受限通道。模拟 qBittorrent 设置一致/不一致、旧任务已存在、成功入队后响应丢失、确认被重复提交及权限失败。 | 初始化与浏览零写入；单次有效确认最多一笔新增；旧任务和全局设置比对一致；失败可回查，无盲重试。原版在设置不一致时已复现阻断。 |
| 2 · 接口与权限 | 固定版本验证站点资源/缓存、精确搜索、季集、手工下载，覆盖站点停用/认证失败、非管理身份、部分站点失败、未知错误及 Cookie 透传。 | 逐站记录哪个入口能提供增量数据和失败证据。断言浏览器只获显示字段和候选 ID；无下载确认则无添加操作；许可不清晰的目标站不得推定可用。 |
| 3 · 目录及季集 | 准备八部虚构作品和约 20–30 条种子：同名异年电影，其中一部跨两站有 12 个版本；新片无 PT、旧片新上种；跨两季电视剧有同集号、单集和完整季包；另一个剧集只有单集；番剧有绝对集号和特别篇；一部缺图或简介用人工纠错。 | 同名作品分开，中外文别名命中；同一作品在每区一条，跨区指向同一详情；本集与整季严格匹配；无季包可明确识别，资料补齐再展示且刷新后纠错仍保留。 |
| 4 · 日更和恢复 | 以 Asia/Shanghai 跨日模拟两次刷新和一次重复补跑，另注入空响应、单源超时、429、授权失效、结果截断和服务重启。 | 两区各自更新，游标和版本去重可复验，站点内容未完整拉取时标记覆盖或陈旧，上次成功数据仍可读；确认无候选才显示资源空态。 |
| 5 · 部署及内存 | 用同一批夹具对 A、B 的固定版本与 C 验证版本测冷启动、10 分钟空闲、3 个并发查询和一次日更；记录各容器及合计内存、峰值、OOM、重启恢复和数据卷大小。 | 初始内存预算达标，记录 Docker/cgroup 口径；两个容器独立回滚，网络无公网管理入口、无 Docker socket。未达标先关闭可选组件复测，再比较 A/B 或缩减目录规模。 |

### 本轮已执行的验证

| 项目 | 证据和结论 |
| --- | --- |
| 站点资源处理函数 | 取 v3.2.7 原始函数体，在断开外网的 Linux 网络命名空间运行，用假站点查询器和返回值。精确传递零基分页与分类；不存在站点返回 404；浏览依赖返回 `[]` 或 `None` 时都得到 `[]`；假 Cookie 和带密钥的链接字段可到达处理函数返回值。此处未经过 HTTP 响应和授权中间件。 |
| qBittorrent 登录及重复种子 | 运行同 tag 的原始登录及配置同步函数，替换客户端为内存 Mock。已有设置为 False→配置 True 及 True→False 各出现一次 `app_set_preferences`。两种设置一致各出现零次。同时捕获客户端构造选项 `VERIFY_WEBUI_CERTIFICATE=False`。独立审查另用 Mock 复现了配置写入，以及同 hash 重复时移除旧「已整理」标签并添加配置的标签。原版直连的零副作用门槛失败。 |
| MoviePilot 上游测试 | v3.2.7 固定依赖，Python 3.14.10，断网命名空间。运行站点处理、搜索响应模型、qBittorrent 兼容、剧集文件选择、手工下载媒体来源、站点刷新并发的 6 个测试文件。首次 120 通过／1 失败，失败在并发用例等待首站识别信号超时。随后并发文件单跑 9 通过，完整复跑 121 通过。记录首次失败，未确认原因。 [并发用例](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/tests/test_torrents_refresh_concurrency.py#L55-L83) · [qBittorrent 兼容用例](https://github.com/jxxghp/MoviePilot/blob/v3.2.7/tests/test_qbittorrent_compat.py#L469-L514) |
| 容器、站点和端到端 | 当前环境缺少 Docker 和 qBittorrent 执行环境。完整 API、官方镜像、站点兼容、下载守卫、端到端下发和实际内存均待验证。上述测试覆盖选定的上游逻辑、模型及模拟调用。 |

复验上游测试时，在 v3.2.7 根目录用 Python 3.14 和锁定依赖执行以下命令，运行环境关闭外网。

```sh
python -m pytest -q tests/test_site_resource.py tests/test_search_response_models.py \
  tests/test_qbittorrent_compat.py tests/test_episode_file_selection.py \
  tests/test_download_media_source.py tests/test_torrents_refresh_concurrency.py
```

## 审批与交接

| 角色 | 本轮产出 |
| --- | --- |
| 协调和架构 | 主会话读取规则、比较方案、执行隔离验证并整合报告。 |
| MoviePilot 专项审查 | 独立上下文核对原生页面/插件、API 权限及 qBittorrent 副作用，并用 Mock 单独复现。 |
| pt-tools 专项审查 | 独立上下文校验稳定与预览版差异、Fork 及计划风险。 |
| 验证与风险审查 | 独立上下文复核接口边界、验收夹具、失败条件和验证范围。 |

各角色沿用当前会话模型，未指定角色专用模型。本轮独立审查覆盖选型和源码证据，M5 产品验收尚未发生。最大分歧是 MoviePilot 与 qBittorrent 的安全边界，其次是 A 能否经现成插件达到同等体验，以及 B 是否能以更低资源消耗覆盖目标站。

**提交审批项** · 采纳「C 优先、原生下载通道须验证」为下一阶段方向，并确定缺失资料的呈现及建议内存预算是否进入验证。批准后由 Codex 从验证计划第 1–2 项接手，先提交隔离环境证据。预估 1–2 个工作日完成首轮接口与下载边界验证，属于规划估算。M3 实施授权、受限适配器变体和真实环境接入分别按本项目审批边界处理。本轮交付物仅为评审与研究证据。
