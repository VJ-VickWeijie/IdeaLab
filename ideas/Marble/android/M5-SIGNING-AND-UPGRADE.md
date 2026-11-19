# Marble M5｜固定簽章與可覆蓋升級實施規格

2026-11-19。所有者已批准清空既有**測試資料一次**，從新建立的長期家庭安裝版本開始，固定 App 身份與簽章，不再因功能版本而變更。此文件是實施與待驗收規格，**不是已通過真機驗收的紀錄**。

## 1. 目標與不可變約束

| 路徑 | Application ID | 簽章 | 內容來源 | 用途 |
| --- | --- | --- | --- | --- |
| `assembleDebug` | `com.idealab.marble.dev` | Android 開發／臨時 Debug 簽章 | `src/debug/assets/content` | 開發和可清空測試 |
| `assembleFamilyPreview` | **`com.idealab.marble`** | **所有者固定 Keystore** | 已知非正式測試包（`src/debug/assets/content`） | 私人長期升級驗證，**不准當正式家庭內容發佈** |
| `assembleRelease` | **`com.idealab.marble`** | **同一所有者固定 Keystore** | `src/release/assets/content` | 已完成內容與版權審核的正式家庭候選 |

預覽版與正式版共享身份、簽章和 `versionCode` 序列，因此經驗收後可直接升級；兩者亦共享裝置私有的 Proto DataStore。Debug 版獨立，不承諾將 `.dev` 內的資料遷移到家庭版。`familyPreview` 強制使用不開啟除錯功能的 Release 組態，但仍有測試內容，名稱顯示「家庭預覽（測試）」。未通過內容審核前，不得將它稱為家庭正式版。

Android 正常更新需相容的應用 ID、簽章及版本號。簽署憑證不應自動生成或每次改變；本專案不使用破壞性的卸載重裝來假裝升級測試成功。

## 2. 所有者一次性產生及保管私鑰

1. 在自己的 Windows 11 電腦使用 Android Studio「Build → Generate Signed Bundle / APK → Create new」建立新的 `marble-family.jks`。使用唯一 alias（建議 `marble-family`），RSA 3072/4096 bit 及長於預期應用壽命的有效期（例如 50 年）。**只建立一次**。
2. 儲存到 Git 倉庫以外的私人目錄；把 Keystore 及密碼各自做好備份，至少保留一份離線加密備份。遺失簽署私鑰可能意味無法再對既有安裝發佈覆蓋更新。
3. 不把 `.jks`、任何密碼、私鑰或可用簽署權限的憑據放入 GitHub、Issue、PR、聊天、Codex 雲端環境或公開網盤。倉庫 `.gitignore` 已排除 `.jks`/`.keystore`，但忽略規則不是秘密保管措施。
4. 允許記錄並提交**公開的證書 SHA-256 指紋**；這是辨識簽署身份的資料，不是私鑰。

現有 `app/build.gradle` 使用四個 `MARBLE_RELEASE_*` 環境變數取得簽署資料，並對家庭預覽版與正式版都加入「缺簽章直接失敗」門禁。`tools/Build-MarbleOwner.ps1` 只在本機互動讀取密碼、運行 Gradle，完成後清除該 PowerShell 進程的四項環境變數。建議使用專用 Windows 本機帳戶與受控構建環境；密碼會在 Gradle 子進程內短暫可用，不代表零暴露風險。

## 3. 發版號與構建

- `gradle.properties` 為單一版本記錄：初始 `marbleVersionCode=1`、`marbleVersionName=0.2.1`。**每次交付新的家庭預覽或正式 APK，都必須在來源控制中遞增 `marbleVersionCode`**；從預覽切正式時同樣遞增。
- `versionName` 可變更語義版本，預覽包自動加入 `-preview`。不得依靠默認版本碼 `1` 重複發版。
- 每次發版保存：提交 SHA、`versionCode`、`versionName`、APK SHA-256、簽署證書 SHA-256、內容包版本、裝置及驗收結果。不要在 Git 記錄私鑰。

Windows 上，在 `ideas/Marble/android` 目錄執行（**腳本只可在持有私鑰的所有者本機使用**）：

```powershell
.\tools\Build-MarbleOwner.ps1 -Channel Preview -KeyStore 'D:\Private\Marble\marble-family.jks' -Alias 'marble-family'
```

以上路徑只是例子；若沒有 `D:` 磁碟，可使用其他倉庫外的受保護目錄。正式內容通過審核之後才使用 `-Channel Release`。預覽 APK 將在 `app/build/outputs/apk/familyPreview/`，正式候選在 `app/build/outputs/apk/release/`。具體檔名以 Gradle 實際輸出為準。

## 4. 雙 APK 覆蓋升級驗收（SYS05）

| 次序 | 操作 | 必須證明 |
| --- | --- | --- |
| 1 | 生成首個所有者簽署預覽 V1 (`versionCode=1`) 並記錄 SHA | 包名 `com.idealab.marble`、公開證書指紋、內容版本固定 |
| 2 | 小米 17 / Android 17 安裝 V1；設定測試生日／年齡／深度，建立搜尋歷史與繼續探索卡片 | 資料已實際保存到 `no_backup/marble/profile.pb` 所屬 App 私有資料，無須取出私有檔案 |
| 3 | 將 `marbleVersionCode` 改為 `2`，重新建置 V2，保留同一個 Keystore | `check_apk_upgrade.py` 靜態檢查包名、簽章、版本碼通過 |
| 4 | **不卸載 V1**，用系統檔案安裝器或 `adb install -r V2.apk` 覆蓋 | Android 識別為更新，而不是新增另一個圖示或要求刪除舊 App |
| 5 | 重啟、強停後重開，核對年齡、閱讀深度、歷史、繼續探索與內容別名 | 有效資料保留；沒有無故清空或死鏈；飛行模式下可正常探索 |
| 6 | 在隔離測試場景嘗試錯簽章替換（不得使用真實資料） | 安裝被拒絕，原 APK 與私有資料不受影響 |

可用 Android SDK Build Tools 的 `aapt2`、`apksigner` 執行**靜態前置檢查**：

```sh
python tools/check_apk_upgrade.py OLD.apk NEW.apk --aapt2 aapt2 --apksigner apksigner
```

如果 Android SDK 工具不在 PATH，將兩個參數改為其絕對路徑。這個工具**不會安裝 APK，不會讀取個人資料，亦不能代替真機資料保留驗證**。單元測試：`python -m unittest discover -s tools -p 'test_*.py'`。

## 5. 已有資料與一次性清理邊界

以前的 `com.idealab.marble.dev` 和 `com.idealab.marble.dev.swipe` 與新家庭包身份不同，彼此不能直接覆蓋或自動繼承私有資料。所有者批准清空的是**這兩份測試資料**，不是新家庭包後續產生的資料。

建議等 V1 新 APK、正式私鑰加密備份和安裝冒煙都可用之後，再由所有者自行在小米 17 移除舊測試 App。卸載會清除其本機私有資料；本任務**不代替所有者執行卸載**。

此版本不新增資料匯出、NAS 同步或系統自動更新；NAS 將作獨立里程碑。新的家庭包仍保持現有離線內容、無網絡權限、禁用備份及 `noBackupFilesDir` 隱私邊界。

## 6. 交付、風險與審批

- 提交代碼及文件 PR，不提交任何 Keystore；**PR 未獲所有者批准前不可合併**。
- 編譯是否成功、簽署是否有效與小米 17 真機資料是否保留是三項不同證據。若無所有者私鑰與真機，後兩項標記為**待驗證**，不得聲稱成功。
- 既有 M5 [搜尋詞 Activity 重建缺口](M5-DEV-ACCEPTANCE.md) 保持為獨立待修事項；普通返回搜尋已測通並不代表系統重建後保留。
- 完成首個正式簽署 V1/V2 覆蓋驗收並經所有者批准後，才可將 SYS05 由「未驗證」改為「通過」。

**協作與流程**：沿用 IdeaLab 及 AI-Workflow V1.1 固定 SHA `939ec44036d89cd91622ab96b938be9f02479026`。本輪係 M5 未通過項目嘅修復子任務，編碼與自驗之後提交所有者，後續真機證據與獨立覆核仍須補齊。

## 7. 2026-11-19 實施自檢紀錄（待獨立覆核）

| 檢查 | 實際結果 |
| --- | --- |
| `python3 -m unittest discover -s tools -p 'test_*.py' -v` | **通過**，7/7；含包名、簽章及版本降級／同碼拒絕案例 |
| `python3 tools/check_content.py app/src/debug/assets/content` | **通過**，24 節點、48 呈現、48 關聯、8 組、73 個媒體資產 |
| `git diff --check` | **通過**，無空白錯誤 |
| `./gradlew :app:tasks --offline --no-daemon` | **有阻塞**：Gradle Wrapper 9.6.0 未緩存，執行環境無法連到 `services.gradle.org`；因此本輪未能驗證 Gradle 新 Variant 編譯、輸出檔名及簽章門禁的實際任務執行 |
| 私鑰生成、兩版 APK 與小米 17 覆蓋升級 | **未執行**；私鑰只應由所有者在本機產生及保管 |

本輪由同一執行上下文完成協調、開發和靜態自檢，未進行真正獨立執行上下文的代碼審查，也未切換不同模型。**正式驗收仍待擁有完整 Android SDK/Gradle 工具鏈的環境與所有者實機完成。**


## 8. 2026-11-20 Windows 本機構建環境準備紀錄（APK 尚未構建）

所有者在 Windows 11、VS Code、PowerShell 環境完成以下本機準備。此紀錄只涵蓋已提供截圖／命令輸出證明的項目；不代表 APK 已編譯、簽署或完成真機升級驗收。

### 8.1 已驗證的工具鏈

| 項目 | 本機結果 | 證據／備註 |
| --- | --- | --- |
| JDK | Eclipse Temurin / OpenJDK 17.0.21 | `java`、`javac`、`keytool` 均可執行；`JAVA_HOME` 指向 `C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.21.9-hotspot` |
| Android SDK 根目錄 | `%LOCALAPPDATA%\\Android\\Sdk` | 已建立；Command-line Tools 放於 `cmdline-tools/latest` |
| Command-line Tools 壓縮包 | `commandlinetools-win-15859902_latest.zip` | 下載檔 SHA-256 與當時官方提供值一致；解壓目錄已整理為官方要求的 `cmdline-tools/latest` |
| Android Platform | `platforms;android-37.0` | 已安裝，目錄 `platforms/android-37.0` 存在 |
| Android Build Tools | `build-tools;37.0.0` | 已安裝，目錄 `build-tools/37.0.0` 存在 |
| Android Platform Tools | `platform-tools` | 安裝命令已執行；`platform-tools/adb.exe` 的 `Test-Path` 結果為 `True`；SDK Manager 列表顯示版本 37.0.1 |
| Gradle Wrapper | Gradle 9.6.0 | 成功下載並執行 `gradlew.bat --version`；Launcher JVM / Daemon JVM 為 17.0.21 |
| Gradle 專案設定 | `gradlew.bat help` | 最終執行結果為 `BUILD SUCCESSFUL`。此前一次嘗試曾回報 Kotlin Compose plugin 2.2.10 無法解析；其後未修改專案配置再次執行成功，具體初次失敗原因未確定 |
| Android SDK 環境變數 | `ANDROID_HOME`、`ANDROID_SDK_ROOT` | 已在當前 PowerShell 會話設定；是否已永久寫入 Windows 使用者環境變數，尚未確認 |

SDK Manager CLI 顯示 deprecated 提示，但本次仍成功列出及安裝所需 SDK 套件；此提示不等同安裝失敗。

### 8.2 固定簽章已由所有者本機建立及驗證

- 本機檔案：`%LOCALAPPDATA%\\MarbleKeys\\marble-family.jks`
- Alias：`marble-family`
- Entry：`PrivateKeyEntry`
- 公開金鑰：RSA 3072 bit
- 簽名算法：`SHA256withRSA`
- 有效期：2026-11-20 至 2076-11-07
- 證書 SHA-256：`09:0E:7A:97:94:57:25:A4:76:B0:92:D3:26:F6:42:6E:BD:05:44:BF:07:36:7B:41:3A:3C:6A:A6:9C:4F:68:C5`

Keytool 輸出確認條目為 `PrivateKeyEntry`，指紋與第 2.1 節登記值一致。JKS 格式提示為資訊性警告；本專案明確使用 JKS，保持原格式。Keystore 檔案及密碼只由所有者本機保管，沒有提交至倉庫。

### 8.3 尚未完成／不可宣稱通過

| 項目 | 狀態 |
| --- | --- |
| `:app:tasks --all` 中的 `assembleFamilyPreview`、`verifyFamilyPreviewContent`、`verifyFamilySigning` 任務核實 | 待執行 |
| Python 執行環境及內容檢查腳本 | 待核實 |
| `Build-MarbleOwner.ps1` 所有者本機簽署構建 | 待執行 |
| `familyPreview` APK 編譯及簽署 | 待執行 |
| APK 包名、versionCode、versionName、證書指紋與 APK SHA-256 靜態檢查 | 待執行 |
| 小米 17 / Android 17 安裝及 V1→V2 覆蓋升級 | 待執行 |
| 歷史、設定、繼續探索及離線使用資料保留 | 待真機驗收 |

### 8.4 下一步

1. 在 `ideas/Marble/android` 目錄核實 Gradle 任務：`./gradlew.bat :app:tasks --all`，確認 `assembleFamilyPreview`、`verifyFamilyPreviewContent`、`verifyFamilySigning`。
2. 確認 Windows `python --version` 可用，因 `verifyFamilyPreviewContent` 會執行 `tools/check_content.py`。
3. 由所有者在本機執行 `tools/Build-MarbleOwner.ps1 -Channel Preview -KeyStore "$env:LOCALAPPDATA\\MarbleKeys\\marble-family.jks" -Alias "marble-family"`，在隱藏輸入提示中輸入 Keystore 與 key 密碼。不要將密碼放入命令列、檔案、GitHub 或聊天。
4. 構建成功後記錄 APK 路徑及 SHA-256，使用 `aapt2`、`apksigner` 和 `tools/check_apk_upgrade.py` 完成靜態身份檢查，再進行小米 17 真機驗收。

**本階段判定：本機工具鏈與固定簽章材料準備已完成；Android App 編譯、APK 簽署、安裝與覆蓋升級仍未驗證。不得將 M5 SYS05 標記為通過。**
