# Marble Android 開發內容同素材

`marble-v0.2-dev-fixture.2` 用於 M4 離線流程、播放同介面回歸。每個知識點用本地 ID 同原創粵語樣稿。兩個年齡檔覆蓋四組主題，0–1 歲每組 5 張，1–2 歲每組 6 張。各知識點有兩個可開啟嘅關聯。選題參照 ID 保留喺 `knowledge.json`。[內容計劃 T03](../planning/v0.2-android-mvp/T03-content.md)

## 相片來源

2026-11-18 由 Wikimedia Commons 原檔頁所提供嘅元資料核對作者及許可。開發內容包內可離線閱讀署名。相片技術處理包括方向校正、縮放至長邊 720 px、JPEG 轉碼及 EXIF 移除。包內副本按各相片所列許可處理，各檔案嘅來源下載雜湊、包內 SHA-256 同原頁連結保留在 `media.json`。[Commons 轉用指引](https://commons.wikimedia.org/wiki/Commons:Reusing_content_outside_Wikimedia)

| 相片 | 原頁同作者 | 許可 |
| --- | --- | --- |
| `banana-identification` | [Banana-Single.jpg](https://commons.wikimedia.org/wiki/File:Banana-Single.jpg) · Evan-Amos | [CC BY-SA 3.0](https://creativecommons.org/licenses/by-sa/3.0) |
| `apple-example` | [Red Apple.jpg](https://commons.wikimedia.org/wiki/File:Red_Apple.jpg) · Abhijit Tembhekar from Mumbai, India | [CC BY 2.0](https://creativecommons.org/licenses/by/2.0) |
| `pear` | [Pear fruit.jpg](https://commons.wikimedia.org/wiki/File:Pear_fruit.jpg) · Dusan Bicanski | [Public domain](https://creativecommons.org/publicdomain/mark/1.0/) |
| `orange` | [Orange-Whole-&-Split.jpg](https://commons.wikimedia.org/wiki/File:Orange-Whole-%26-Split.jpg) · Evan-Amos | [CC BY-SA 3.0](https://creativecommons.org/licenses/by-sa/3.0) |
| `strawberry` | [Garden strawberry (Fragaria × ananassa) single2.jpg](https://commons.wikimedia.org/wiki/File:Garden_strawberry_(Fragaria_%C3%97_ananassa)_single2.jpg) · Ivar Leidus | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `cat` | [A domestic shorthair tortie-tabby cat.jpg](https://commons.wikimedia.org/wiki/File:A_domestic_shorthair_tortie-tabby_cat.jpg) · Leveetated | [CC0](http://creativecommons.org/publicdomain/zero/1.0/deed.en) |
| `dog` | [Golden Retriever Carlos (10581910556).jpg](https://commons.wikimedia.org/wiki/File:Golden_Retriever_Carlos_(10581910556).jpg) · Dirk Vorderstraße | [CC BY 2.0](https://creativecommons.org/licenses/by/2.0) |
| `duck` | [Male mallard duck 2.jpg](https://commons.wikimedia.org/wiki/File:Male_mallard_duck_2.jpg) · Acarpentier | [CC BY 3.0](https://creativecommons.org/licenses/by/3.0) |
| `goldfish` | [Goldfish3.jpg](https://commons.wikimedia.org/wiki/File:Goldfish3.jpg) · No machine-readable author provided. Heptagon assumed (based on copyright claims). | [Public domain](https://creativecommons.org/publicdomain/mark/1.0/) |
| `butterfly` | [Picture of butterfly.jpg](https://commons.wikimedia.org/wiki/File:Picture_of_butterfly.jpg) · Umar2z | [CC0](http://creativecommons.org/publicdomain/zero/1.0/deed.en) |
| `frog` | [Frog close-up.jpg](https://commons.wikimedia.org/wiki/File:Frog_close-up.jpg) · Madugrero | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `cup` | [Mug.jpg](https://commons.wikimedia.org/wiki/File:Mug.jpg) · Filo gèn' | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `spoon` | [Wooden spoon.jpg](https://commons.wikimedia.org/wiki/File:Wooden_spoon.jpg) · Ananthy94 | [CC BY-SA 3.0](https://creativecommons.org/licenses/by-sa/3.0) |
| `towel` | [Zusammengelegte Handtücher.jpg](https://commons.wikimedia.org/wiki/File:Zusammengelegte_Handt%C3%BCcher.jpg) · User:Mattes | [Public domain](https://creativecommons.org/publicdomain/mark/1.0/) |
| `socks` | [Odd Socks 93 365 (27331920628).jpg](https://commons.wikimedia.org/wiki/File:Odd_Socks_93_365_(27331920628).jpg) · Amanda Slater from Coventry, West Midlands, UK | [CC BY-SA 2.0](https://creativecommons.org/licenses/by-sa/2.0) |
| `book` | [Open book 1 (Unsplash).jpg](https://commons.wikimedia.org/wiki/File:Open_book_1_(Unsplash).jpg) · Alina Daniker alinadaniker | [CC0](http://creativecommons.org/publicdomain/zero/1.0/deed.en) |
| `plant-example` | [Banana Plant with Developing Fruits (Musa).jpg](https://commons.wikimedia.org/wiki/File:Banana_Plant_with_Developing_Fruits_(Musa).jpg) · Johnnybam | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `leaf` | [Leaf 1 web.jpg](https://commons.wikimedia.org/wiki/File:Leaf_1_web.jpg) · Jon Sullivan | [Public domain](https://creativecommons.org/publicdomain/mark/1.0/) |
| `tree` | [An old oak tree, on a Moat - geograph.org.uk - 650827.jpg](https://commons.wikimedia.org/wiki/File:An_old_oak_tree,_on_a_Moat_-_geograph.org.uk_-_650827.jpg) · BrianP | [CC BY-SA 2.0](https://creativecommons.org/licenses/by-sa/2.0) |
| `cloud` | [Cumulus clouds.jpg](https://commons.wikimedia.org/wiki/File:Cumulus_clouds.jpg) · T.Voekler | [CC BY-SA 3.0](https://creativecommons.org/licenses/by-sa/3.0) |
| `rain` | [Raindrops on a window.jpg](https://commons.wikimedia.org/wiki/File:Raindrops_on_a_window.jpg) · Andromeda2064 | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `puddle` | [Rain on a puddle in Tuntorp 3.jpg](https://commons.wikimedia.org/wiki/File:Rain_on_a_puddle_in_Tuntorp_3.jpg) · W.carter | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `bowl` | [A white bowl.jpg](https://commons.wikimedia.org/wiki/File:A_white_bowl.jpg) · Captain MarcusL | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |
| `watermelon` | [Liat Portal for Foodie Disorder - Whole watermelon before cutting.jpg](https://commons.wikimedia.org/wiki/File:Liat_Portal_for_Foodie_Disorder_-_Whole_watermelon_before_cutting.jpg) · Liat Portal / Foodie Disorder | [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0) |


## 測試語音

48 段圖卡粵語樣稿及一段香蕉家長陪讀用 eSpeak NG 1.52.0 `yue` 離線合成。每段對應文字見 `presentations.json`。音軌以單聲道 24 kHz AAC-LC 封裝為 M4A。整組素材用於驗證互動與離線播放，正式錄音需母語審聽、事實與適齡性覆核，以及可追溯嘅使用權利。[eSpeak NG 語言支援](https://github.com/espeak-ng/espeak-ng/blob/1.52.0/docs/languages.md)

## 家庭版內容准入

家庭組建讀取獨立嘅 `app/src/release/assets/content`。該內容包須附 `approved` 狀態及可追溯嘅審批編號，逐項記錄文案及資產簽審。替換相片、錄音或文案後一併更新引用、檔案 SHA-256、作者及使用權利。日常觀察建議同真機實測按 T03、T04 審批。

```bash
python3 tools/check_content.py app/src/debug/assets/content
python3 tools/check_content.py --release app/src/release/assets/content
```
