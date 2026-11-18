# Marble V0.2 M5｜现有开发版独立验收

2026-11-18。所有者批准进入 M5，先验收现有开发版。本轮沿用 0–2 岁、离线图卡与亲子探索首版范围。地图关系扩充与粤语模型更换留待后续。家庭试用须按 T04 完成正式候选验收并另行批准。

- 验收对象为所有者试过的 `Marble-V0.2-swipe-preview.apk`，应用 ID `com.idealab.marble.dev.swipe`，`versionName 0.2.0-swipe-preview`，`versionCode 2`。
- APK 大小 15,599,750 bytes，SHA-256 为 `aef326d567ecf10662c6359b62a838bb3266c2babd8fe2c9b29575b9899fd132`。以 Android SDK Build Tools 37.0.0 的 `apksigner` 验出一个 Android Debug v2 签名，证书 SHA-256 为 `4b30de9c63e90114f9fedf87bcb220d560adc69ed19cd5c9a060bad18176e895`。
- [已合并的 PR #12](https://github.com/VJ-VickWeijie/IdeaLab/pull/12) 的手势源码为 `d0f60e8b6eb24f252919593bb5bc90d1dd1e8ef3`，Android 工程与合并提交 `63488f3d07c0c3ecdaece358d09eaf698176dd1d` 一致。比对到本轮读取的 `main` 提交 `1791ea0bc993d8d7d11087059f9836acb902dfbd`，Android 目录只增加了 [#11 的实测记录](https://github.com/VJ-VickWeijie/IdeaLab/pull/11)。流程版本为 [AI-Workflow V1.1 固定提交](https://github.com/VJ-VickWeijie/AI-Workflow/tree/939ec44036d89cd91622ab96b938be9f02479026)，验收依据为 [T04](../planning/v0.2-android-mvp/T04-acceptance.md)。

## 所有者实机反馈与已有证据

所有者在前一开发版确认离线使用、播放声音、地图返回、搜索和历史正常，随后在手势预览版确认手势通过。后一次验收聚焦大图和整页上下扫。实际机型及系统版本未登记。

#12 记录 20 项单测和 2 项 Android 8.0 飞行模式操作测试通过。开发组的 [M4 记录](M4-EVIDENCE.md) 与 #11 记录前一开发版在 Android 17 软模拟环境成功安装，Activity 启动逾时。#12 的手势版两次在系统启动时逾时，均未安装。Android 17 App 运行与启动性能待复验。

## 本轮可复现的包内检查

| 范围 | 结果 |
| --- | --- |
| APK 指纹与签章 | 通过。下载件 SHA-256 与 #12 一致，ZIP 完整性和 Android v2 签章验证均通过。 |
| 离线与备份配置 | 静态通过。用 `aapt2 dump badging` 和 `dump xmltree` 确认最低 API 26、目标 37，唯一声明使用的权限是应用自己的 AndroidX 签名权限。无互联网权限，应用备份关闭，云备份与换机规则均排除资料目录。历史和设置写入 `no_backup/marble/profile.pb`。厂商设备迁移仍需实测。 |
| 内容与媒体 | 工程包检查通过。APK 内容逐文件匹配源码中的测试包。内含 24 个知识点、48 条分龄呈现、48 条地图关系、8 组图卡。用 FFmpeg 实际解码 24 张照片和 49 段音轨，音轨均为 APK 中的未压缩项。此项验证解码与格式，粤语听感留待正式素材验证。 |
| 家庭版准入 | 现有测试包以 `check_content.py --release` 检查时被正确拒绝。正式素材的事实、适龄性、粤语和授权审核，以及所有者控制的家庭签章仍待完成。 |

## 本轮单测复跑

在独立 JDK 17／JUnit 4.13.2 环境直接编译现有源码和测试，保留 Android 工程指定的 Proto 和 DataStore 版本。10 项内容与资料存储测试、10 项手势与播放控制测试全部通过。手势单测在 JVM 单独编译手势判定类，页面手势交由设备测试。整套 Gradle 任务运行到 Kotlin 编译后达到本轮时限，单测结果来自以上 JVM 复跑。两组单测均输出 `OK (10 tests)`。

## 独立代码复核

M5 协调者负责验收基线、实跑与证据整合。独立审查者在单独的 Codex 执行上下文中直接核对固定提交、批准的验收条件和 M4 留存证据。两者使用当前 Codex 环境的继承模型，具体子型号未披露。

- 历史与清除。[`ParentStore.kt`](app/src/main/java/com/idealab/marble/data/ParentStore.kt) 在同一更新清除历史和继续锚点，增加资料代数，拒绝旧代数导航写入。[`MarbleApp.kt`](app/src/main/java/com/idealab/marble/ui/MarbleApp.kt) 以代数、内容版及 APK 版本重设导航。
- 地图与声音。地图关联进入普通知识详情。切换页面会停音，[`MainActivity.kt`](app/src/main/java/com/idealab/marble/MainActivity.kt) 和播放控制层处理离页、失焦和声音输出设备改变。系统层面的锁屏、争抢焦点和耳机／蓝牙切换仍需目标设备证据。
- **S3 搜索恢复。** `MarbleApp.kt:98–100,259–260` 以 `remember` 保存查询词。Android 重建 Activity 时导航栈可恢复，查询词未随之保留。同页面的返回搜索在现有测试有断言，详情经过重建再返回须单独复验。建议以 `rememberSaveable` 保存查询词，补上「搜索 → 详情 → 重建 → 返回原结果」回归。
- **SYS05 升级与可复现性。** 原开发版和手势版已核实使用不同应用 ID 和签名证书，现有两份 APK 的并装证据无法覆盖升级。仓库正常 Debug 配置默认产出 `com.idealab.marble.dev`／`0.2.0-dev`，而手势预览版使用独立包名和版本名。后续候选需记录构建参数、证书和版本，准备同包名、同签名及递增版本号的测试包，再验证升级保留与错误签名拒绝。

## 本轮 Android 运行验证

Android 8.0.0／API 26，x86_64 软件模拟，使用专用测试 AVD。系统启动后显示 `airplane_mode_on=1`、`Wi-Fi is disabled`、`Active default network: none`。离线设置后设备端命令无进一步输出，等待近两分钟后结束本次运行。没有取得本轮 APK 安装成功、应用启动或界面流程结果，目标手机亦未接入本环境。

| 验收点 | 本轮状态 |
| --- | --- |
| 离线核心流程、地图及手势 | 所有者体验结论与 M4 的两项 Android 8 离线操作记录可作现有证据。本轮重新验了 APK 与离线配置；针对现有 APK 的设备复跑未完成。 |
| 历史清除、进程重启 | 资料单测通过，覆盖代数与清除相关写入。真机强停、历史保持为空及设备恢复待补验证。 |
| 后台、锁屏与系统声音焦点 | 播放层单测通过。后台和系统声音中断有源码处理，实际真机停音、耳机或蓝牙切换待复验。 |
| 旋转后返回搜索 | 独立源码复核发现缺口，设备复现尚未完成。 |
| 同签名升级、设备迁移、Android 17 | 需同包名同签名的两个版本、目标设备或可用硬件加速环境。 |

## 阶段结论

现有开发版的 APK 完整性、内容完整性、媒体解码及 20 项单测复核通过。保留所有者已经确认的使用体验，M5 结论为**部分通过**。搜索重建是已记录的一般缺陷风险。家庭候选的内容审核、正式签章及设备复验仍未完成。

下一次复验优先用目标手机做「搜索 → 详情 → 旋转 → 返回」，再验证「清除历史 → 强停 → 重开」和播放中切换后台／锁屏。同签名升级测试在取得连续版本后补齐。家庭试用须以同一份签章候选跑完适用用例并由所有者审批。
