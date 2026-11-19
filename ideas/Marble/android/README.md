# Marble V0.2 Android

0–2 歲小朋友同家長可以喺溫馨森林睇實拍相片、聽粵語、探索相關事物。知識、照片、音軌、家長設定同探索記錄均以離線使用為目標。[PR #9 規劃](../planning/v0.2-android-mvp/README.md)

## 構建與測試

安裝 JDK 17、Android SDK Platform 37 同 Build Tools 37.0.0。設定 `JAVA_HOME` 同 `ANDROID_HOME`，再由呢個目錄執行以下命令。

```sh
python3 tools/check_content.py app/src/debug/assets/content
./gradlew :app:assembleDebug :app:testDebugUnitTest :app:assembleDebugAndroidTest --no-daemon
```

Windows 用 `python` 同 `gradlew.bat`。連接專用測試裝置或者模擬器後，可以跑介面回歸或安裝開發版。

```sh
./gradlew :app:connectedDebugAndroidTest --no-daemon
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

開發版應用 ID 為 `com.idealab.marble.dev`，使用 Android 開發簽章同工程測試包。飛行模式下可以由「滑滑認識世界」點香蕉圖播放，喺卡片頁嘅留白或相片位置上下掃換卡，再試詳情、家長陪讀、香蕉地圖入蘋果及逐層返回。用 `banana` 搜尋後可驗證重啟及清除歷史。[完整驗收條件](../planning/v0.2-android-mvp/T04-acceptance.md)

[M4 實施與自驗](M4-EVIDENCE.md) · [內容與素材](CONTENT.md)

## 長期覆蓋升級（M5）

已批准測試資料可清空一次；此後家庭預覽與正式版統一使用 `com.idealab.marble`，由所有者持有固定私鑰，並遞增同一 `versionCode` 序列。新增 `familyPreview` 建置供私人升級驗證：載入現有測試內容、使用家庭簽章，不允許作為正式家庭內容發佈。`debug` 維持獨立 `.dev` ID。

**[完整固定簽章、密鑰保管、Windows 建置與升級驗收規格](M5-SIGNING-AND-UPGRADE.md)**。正式簽章及小米 17 覆蓋安裝仍待所有者執行，未通過前不得宣稱 SYS05 完成。

## 家庭候選

家庭簽署版使用獨立應用 ID。經准入嘅資源包放喺 `app/src/release/assets/content/`。開發測試包放喺 `app/src/debug/assets/content/`。所有者控制簽署資料，透過受控環境提供 `MARBLE_RELEASE_KEYSTORE`、`MARBLE_RELEASE_STORE_PASSWORD`、`MARBLE_RELEASE_KEY_ALIAS` 同 `MARBLE_RELEASE_KEY_PASSWORD`。

```sh
./gradlew :app:assembleRelease --no-daemon
```

家庭試用需完成素材同粵語錄音覆核、正式簽章同真機驗收，再交所有者批准。
