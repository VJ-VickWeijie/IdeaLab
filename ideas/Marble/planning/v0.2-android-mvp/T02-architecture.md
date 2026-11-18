# T02｜Android 架构与离线方案

M2 技术设计提案 · 2026-11-18。目标是交付安装后即可离线探索的 0–2 岁家庭内测 APK。以下是供审批的方案与 M4 验证条件。

## 选型

| 方案 | 离线图片、文字与声音 | 手势、导航与音频生命周期 | 维护与验证 |
| --- | --- | --- | --- |
| **Kotlin + Jetpack Compose** | 随 APK 提供完整首包。系统播放器消费本地短音频，结构化本地存储保存设置与历史 | Android Back、窗口尺寸、无障碍、系统焦点和路由事件在同一客户端处理。需重做原型布局和手势 | 一个 Android 工程。可独立测试数据和状态转换，并在模拟器及目标设备验证 Android 行为 |
| Flutter | 支持打包本地 assets。候选播放器插件须核实音频焦点、设备切换和维护性 | Dart UI 可控制手势与路由。音频焦点、前后台和备份规则仍须实测 Android 端 | 适合明确需要共享 iOS UI 时。首版只有 Android，需额外验证 Flutter runtime、插件、ABI 和包体。[Flutter 支持范围](https://docs.flutter.dev/reference/supported-platforms) |
| WebView 本地封装 | 可用 WebViewAssetLoader 承载本地 HTML/CSS/JS，但原型联网照片与语音合成须替换为本地资源 | 可复用部分视觉布局，仍需处理 Android Back、应用和网页双重状态、音频生命周期及不同设备 WebView | 复用网页界面可缩短早期移植时间。需维护 WebView 与 Android 宿主测试、严格限制内容来源和导航。[Android 本地 WebView 内容](https://developer.android.com/develop/ui/views/layout/webapps/load-local-content) |

**推荐 Kotlin + Jetpack Compose、Navigation Compose 和单 Activity、单 app 模块。** 一条播放器控制路径和一条导航栈覆盖首发风险最高的点按、停音、地图回退与系统返回。网页原型与五屏视觉稿用于对照。普通实现缺陷直接在原生方案内修复。若 M4 垂直切片记录了无法消除的工具链或目标机兼容性阻塞，先给出复现与修复成本，再由所有者决定是否重审本地 WebView 回退。回退继续使用同一资产合同和真机验收，需重测 Android 生命周期与本地内容边界。[原型说明](../../prototypes/v0.2-interactive/README.md) · [温馨森林五屏基准](../../design/V0.2-forest-five-screen-visual-review-V1.md)

## 构建和设备基线

- 建议 `minSdk 26`（Android 8.0），统一采用 API 26 的 `AudioFocusRequest` 和本地日期 API。首次拿到家庭机型后核对实际系统版本。低于下限的目标机触发范围/兼容性审批。[AudioManager API](https://developer.android.com/reference/android/media/AudioManager)
- 建议 `compileSdk 37`、`targetSdk 37`（Android 17）。官方已发布 Android 17，兼容表的 API 37 最低 AGP 为 9.1.1。可复核的候选构建组合为 AGP 9.4.0、Gradle Wrapper 9.6.0、JDK 17。M4 首次可复现构建确认实际 SDK、Compose BOM、Navigation、DataStore 和 Kotlin/Compose 编译器版本，使用固定的稳定版本并记录安装/构建环境。API 37 对大屏方向和可调整窗口的行为要求覆盖横向、分屏及 ≥600 dp 布局。[Android 17 正式发布](https://developer.android.com/blog/posts/android-17-is-here) · [SDK 配置](https://developer.android.com/about/versions/17/setup-sdk) · [AGP 最低版本](https://developer.android.com/build/releases/about-agp) · [AGP 9.4 兼容表](https://developer.android.com/build/releases/agp-9-4-0-release-notes) · [API 37 行为变更](https://developer.android.com/about/versions/17/behavior-changes-17)
- Windows 11 可由 Android Studio SDK Manager、JDK 与 Gradle Wrapper 构建。工程入口、依赖下载和设备调试是开发环境事务。APK 安装后的冷启动、浏览、名称和别名索引、图片与粤语音频均从包内及设备私有存储取得数据。
- 交付一份已签名的可直接安装 APK、SHA-256、版本号与证书指纹。内部开发版本和家庭内测版本使用各自签名与应用 ID 契约。家庭版应用 ID、签名保管者和版本号策略在首个家庭版构建前记录。签名私钥保留在所有者批准的位置。[应用签名](https://developer.android.com/studio/publish/app-signing) · [APK 签名验证](https://developer.android.com/tools/apksigner)

| 环境 | 主要证据 |
| --- | --- |
| API 26 模拟器 | 最低系统安装、日历边界、离线素材、系统返回和错误恢复 |
| API 31 模拟器 | Android 12 备份规则分支、焦点丢失、具备刘海窗口时的布局 |
| API 35 或 36 模拟器 | 前台焦点申请、系统边衬、手势返回和进程重建 |
| API 37 模拟器 | 目标 SDK；窄屏、横向、分屏及 ≥600 dp，System Back 与 UI Back 相同结果。用可重复用例检测升级和资源间关系 |
| 家庭目标 Android 真机 | 记录型号、系统/API、屏幕配置和测试 APK 校验值。至少验证首次安装后飞行模式且 Wi-Fi 关闭、离线听见音频、真实触摸、旋转、锁屏、通知/其他应用音频中断、耳机断开、同签名升级和清除 |
| 可得的第二台不同 OEM/API 真机 | 补测签名安装、设备迁移/系统备份行为与两套系统音频路径。缺机时按具体项目保留未验证状态 |

家庭真机当前未知，工具链可用和模拟器通过后仍需按 T04 收集目标手机证据。未实测的组合只记已计划；T04 的真机交付门禁以实际记录为准。

## 客户端边界

| 边界 | 职责 |
| --- | --- |
| 界面与导航 | 五屏与家长入口在同一森林主题下，读取屏幕状态、发出明确操作。详情路线以节点稳定 ID 参数化，卡片、地图和陪读具有独立状态 |
| 内容仓储 | 读取内置内容包、校验合同、按适龄呈现和已发布关系查询，建立小规模内存搜索索引 |
| 本机资料 | 单实例 Proto DataStore 管理家长设置、历史、继续探索锚点与本机数据版本，采用事务写入 |
| 短音频 | 一个前台控制器串行处理当前片段、用户触发、音频焦点、失败及资源释放。页面只声明当前允许播放的作用域 |
| 构建期内容门禁 | 从已批准的小包生成 APK assets，验证 Schema、双年龄档主图词音一致性和素材索引，保留来源/核查证据。未来若引入 PC 导出的内容包，可复用合同；NAS 同步进入单独里程碑 |

中小规模数据在加载一次 JSON 后按 ID 建立索引。搜索按人工维护的显示名、别名和关键词，建议 Unicode NFKC、统一大小写与空白，再按精确、前缀、包含匹配，最后用固定显示顺序排序。简繁、粤语俗称和约定英语键盘搜索词用显式别名覆盖。查询不持久化，文本入口与标题仍遵循已批准的首发语言范围。

## 内容包合同草案

| 记录 | 必需信息与约束 |
| --- | --- |
| `manifest` | `schemaVersion` 定义可解析合同，`contentVersion` 标识发布快照。记录默认语言、各表及媒体的本地路径、版本和 SHA-256，内容来源写固定 ref |
| `knowledge` | 稳定 `nodeId`、内容分类、主题标签、事实及 `source`。如直接采用一条上游节点，沿用上游 ID 并保留原始年龄、提交与条目。首包本地适龄扩展用 `local:` 命名空间，可能引用已核对的上游 ID；引用是溯源关系。香蕉保留 `local:banana-identification` |
| `presentations` | 以 `nodeId`、`ageBand`、语言标签为键。每年龄档具备显示名、简答、替代正文、照片、无障碍描述、短粤语朗读及对应文字、家长陪读。解释深度独立选用该档经核准的附加文字，允许只有简答；开放真实观察与风险提示为可选字段。首版粤语内容标签提案为 `yue-Hant-HK`，简繁形式可用于搜索别名 |
| `relations` | `fromId`、`toId`、语义关系、显示排序。每个首发地图的默认集合提供 2–3 个不同的有效关联节点，均带真实图像且可离线打开；关系可有方向，运行时排序稳定。禁止悬空目标、自环作为关联、重复目标 |
| `groups` | 稳定 `groupId`、一个或多个年龄档的有序内容。首包 0–1 岁默认 5 张，1–2 岁默认 6 张。内容配置可用 5–8 张或按小月龄缩减。列表首末按已筛选的有序内容计算，换组只在明确触发时选择同龄可用组 |
| `media` | 稳定 `assetId`、用途、媒体类型、相对路径、尺寸/时长、字节数、校验值与许可记录索引。每节点各年龄档一条主图音轨供连续卡与详情共享。照片允许缩略派生，家长音频为可选独立轨 |
| `idAliases` | 记录经审核的旧 → 新稳定 ID 映射或明确停用标记。映射前后语义一致、终点存在、无循环。历史迁移可独立测试 |

约束：包内路径归一化后限定在 assets 子目录。构建期阻止重复键、无效引用、无档位呈现、正式发布缺少主图/主音轨/归属凭证、未核查素材和不兼容 schema。按素材记录版本、署名、许可、改动及审查证据，并随 APK 提供可离线打开的来源与署名。实际准入见 [T03 内容计划](./T03-content.md) · [研究 Schema 说明](../../research/experience-orchestration-v0.1/schema.md) · [上游来源记录](../../upstream/PROVENANCE.md)。

## 本机资料、返回与更新

1. **年龄与设置。** 用户自愿输入出生日期，存一个精确本地日历日期到 app 私有 `noBackupFilesDir` 内的资料文件，用途在输入页说明。按设备当地民用日期计算，拒绝无效或未来的出生日期。第一和第二生日切分为 `[0,1)` 与 `[1,2)`；提案采用日历周年规则（如闰日出生，在非闰年取 2 月最后一天）。M4 用固定时钟测闰日、日期变化及边界。未设置回到最小年龄档。满 2 岁自动档显示适用范围说明并使用 1–2 档。显式体验年龄覆盖自动结果，解释深度独立调整。导航状态、日志、遥测和测试证据均排除真实出生日期。
2. **历史与继续。** 历史写入有意义的详情或地图节点跳转，合并连续重复节点事件，提案上限 100 条。继续锚点保存最近明确访问的有效节点 ID，连续认知另记组 ID 和卡片节点 ID，滑卡停在何处可继续；播放、滚动和打开抽屉均无历史写入。普通长期重开显示首页与继续入口。清历史同时清除继续锚点并保留家长设置；清全部重置出生日期、覆盖年龄、解释深度、历史和继续锚点。清除与写入走同一事务队列，清历史或清全部时在同一笔 noBackupFilesDir 内的持久事务中递增清除代数，并丢弃代数过期的排队写入。清全部成功后回干净首页，旧导航栈失效。读写失败时以可理解的提示保留重试，界面只在持久化成功后显示清除完成。[DataStore 的事务更新](https://developer.android.com/topic/libraries/architecture/datastore/)
3. **隐私边界。** 检查最终合并 manifest 中没有网络、位置、录音或相机权限、没有分析 SDK，除启动器入口外避免导出组件。采用私有 `noBackupFilesDir`、`allowBackup=false`，并为 API ≤30 设置旧版全备份规则，为 API ≥31 显式设置云端备份与设备迁移排除规则。Android 12 起部分 OEM 的设备迁移行为与云备份设置独立，按测试计划核对相关设备及可用的跨平台路径。Android 16 QPR2 起另有跨平台迁移配置；首版不给出跨端目标和导出通道。[Android 备份与 D2D 规则](https://developer.android.com/identity/data/autobackup)
4. **页面栈。** 利用导航栈加目的地级保存状态保留稳定 ID、详情滚动锚点、展开、解释深度、书签式卡片位置与地图中心/有序节点。布局变换按 ID 重算尺寸，同类尺寸恢复逻辑位置与视觉顺序。系统 Back 和页面返回复用同一栈，先关闭当前覆层，再按栈返回。旋转或系统复用同一任务重建时，先比对暂存导航的清除代数与私有存储的最新代数。代数一致且数据有效时可恢复界面，恢复动作不分派历史或继续写入。过期或不可校验时丢弃旧导航快照并回首页，音频保持停止。显式重新启动、版本升级后重新打开进入首页，继续按钮按有效锚点恢复。[Compose 状态保存](https://developer.android.com/develop/ui/compose/state-saving)
5. **发布更新与迁移。** 首版随同一应用 ID、同一签名和递增 `versionCode` 的 APK 更新整包，用户资料独立于 APK assets。包格式只对显式支持的主版本解析，同主版本新加的可选字段可按契约忽略。独立的本机 `dataVersion` 负责设置格式演进，迁移在单事务内完成并支持重复执行。更新后先按有效别名重绑定历史与继续的节点和组；没有有效映射时移除失效入口，保留其余历史与设置，安全回首页。保留旧包版本的测试快照验证升级，不以卸载重装冒充数据保留。正式修复回退走更高版本号的修复 APK，保留兼容的数据版本；无法兼容或需删除用户资料时交所有者决定。[Android 更新匹配规则](https://developer.android.com/google/play/app-updates)

## 音频、故障和预算

**前台单播放器。** 显式点主图使当前片段从头播放，详情放大使用独立控件。连续认知按同一次手势的一致结果处理 tap/swipe，纵向拖动切卡完成前即取消 tap，详情纵向滚动保留普通滚动语义。切卡、导航、放大、陪读抽屉开关、执行清空、应用离开可交互前台、旋转、锁屏、音频焦点丢失以及耳机断开立即取消待播并释放片段。陪读内仅显式点选独立音频才播放；恢复前台、收回焦点和返回页面保持安静。

- 用 Android `MediaPlayer` 播放包内短轨，单声道 AAC-LC `.m4a`，例如 64 kb/s。所用文件在 APK 内保留为可获文件描述符的未压缩 entry，M4 在构建产物检查其真实打包方式；`AssetFileDescriptor` 提供 offset 与 length，播放器/描述符按生命周期关闭。请求短暂音频焦点，声明 `USAGE_MEDIA`、`CONTENT_TYPE_SPEECH`，设置收到可降低音量的系统焦点信号时也停止；耳机输出变更观察系统 `ACTION_AUDIO_BECOMING_NOISY`。若当前播放页面失去前台交互权、系统拒绝焦点、准备期间已有切换或播放报错，取消这一请求并保留对应文字。通过单序列请求标识丢弃过期异步回调。音量沿用用户设备的媒体音量。[AssetManager.openFd](https://developer.android.com/reference/android/content/res/AssetManager) · [Android 媒体格式](https://developer.android.com/media/platform/supported-formats) · [系统音频焦点](https://developer.android.com/media/optimize/audio-focus) · [Android 17 前后台音频限制](https://developer.android.com/about/versions/17/changes/bg-audio)
- 必需媒体在打包前逐项检查。运行中若照片解码失败，呈现可读图像说明并保留文字与可用音频；音频缺失/解码失败则保留同段文字并提示本段暂时不可播放，不重试坏资源循环。包解析失败显示可返回/重试的离线错误界面，并保留已有资料以便随后用修复 APK 恢复。QA 通过单独故障夹具验证损坏、缺失、恢复三种路径。正常发布的必需素材完整性另有门禁。
- 用首批 24 节点做预算。每张主照片以约 300 KiB、缩略图 40 KiB 估算，约 8 MiB。两档主图朗读各约 8–12 秒，陪读另计约 20 秒，即使每项提供陪读，按每秒 8 kB 音频约 8 MiB。文字、署名与森林装饰预留约 4 MiB，**媒体与装饰预算 ≤20 MiB，签名单 APK 目标 ≤40 MiB**。质量不达标时优先调编码、采样/尺寸或复用缩略图，核心资源降级仍须过真机验收。用家庭目标机五次进程冷启动，记录首屏可操作时间，候选目标每次 ≤3 秒，记录包体、数据范围和设备状态。[Android 启动时间测量](https://developer.android.com/topic/performance/issues/launch-time)

## M4 技术验证出口

| 技术风险 | M4 证据与失败处理 |
| --- | --- |
| 构建工具链/最低系统安装 | 固定 Gradle、JDK、Kotlin/Compose 和 SDK 版本，保存构建摘要与 API 26/37 安装结果。可修依赖冲突在阶段内复验；架构阻塞追加可复现数据并送方案重审 |
| 彻底离线 | 先用少量获准本地内容做首页到地图回退的纵向切片。发布候选再用正式资源干净安装后飞行模式冷启动，记录图片、搜索、声音、继续探索及恢复记录 |
| 声音与手势竞争 | 确认点图重播、上下滑切卡、详情可正常滚动、系统焦点丢失和离页均按合同。双击、短拖、快速连切需回归，修复后重放同一测试脚本 |
| 数据、备份与迁移 | 发布候选以假资料测试清除、更新和设备备份/迁移；使用同签名旧包升级并核对合并 manifest、历史和继续状态。记录部分 OEM 迁移验证的设备限制 |
| 包体与性能 | 统计真实签名 APK、素材占比与家庭目标机冷启动数据。超预算先查瓶颈与质量平衡，再决定常规优化或变更提案 |

T02 本轮证据为原型和官方能力核对，以及上述架构、合同与验证计划。安装、性能、备份、恢复和真机音频留待获批后的 M4/M5 实测。技术测试编号及证据模板见 [T04 验收计划](T04-acceptance.md)。
