const PHOTO = (file) => `https://commons.wikimedia.org/wiki/Special:FilePath/${encodeURIComponent(file)}?width=1400`;
const SOUND = (file) => `https://commons.wikimedia.org/wiki/Special:FilePath/${encodeURIComponent(file)}`;

const fruitGroup = [
  { name: "香蕉", line: "弯弯的，外面有果皮。", image: PHOTO("Picture of ripe banana.jpg"), voice: "这是香蕉，一种水果。外面是果皮，里面是果肉。" },
  { name: "苹果", line: "圆圆的，颜色有好多种。", image: PHOTO("Picture of Red Apple.jpg"), voice: "这是苹果。苹果有不同的颜色和形状。" },
  { name: "梨", line: "上面细，下面圆。", image: PHOTO("Pear fruit.jpg"), voice: "这是梨。我们可以看看它的形状。" },
  { name: "橙子", line: "圆圆的，外皮有小小的凹凸。", image: PHOTO("Orange fruit.jpg"), voice: "这是橙子。橙子的外面有一层果皮。" },
  { name: "草莓", line: "小小的，表面有很多籽。", image: PHOTO("Strawberry-fruit.JPG"), voice: "这是草莓。我们可以观察它的颜色和表面。" },
];
const animalGroup = [
  { name: "黑鸫", line: "鸟会用鸣声和动作传递信息。", image: PHOTO("BlackBird.jpg"), voice: "这是一只黑鸫。不同鸟会用鸣声和动作交流。" },
  { name: "青蛙", line: "青蛙也会发出不同的声音。", image: PHOTO("Frog close-up.jpg"), voice: "这是一只青蛙。青蛙会用叫声和同伴交流。" },
  { name: "蝴蝶", line: "它会用姿态和颜色传递线索。", image: PHOTO("Picture of butterfly.jpg"), voice: "这是一只蝴蝶。动物也会用动作和颜色传递线索。" },
  { name: "松鼠", line: "身体动作也能传递信号。", image: PHOTO("Squirrel closeup.JPG"), voice: "这是一只松鼠。我们可以观察它的动作。" },
  { name: "蜜蜂", line: "动作能帮助同伴找到方向。", image: PHOTO("The honey bee.jpg"), voice: "这是一只蜜蜂。蜜蜂会用动作传递方向线索。" },
];

const topics = {
  banana: { id: "local:banana-identification", title: "香蕉是什么？", short: "这是香蕉，一种水果。外面是果皮，里面是果肉。", aliases: ["香蕉", "水果", "banana"], icon: "🍌", medium: "真实照片 · 事物识别", ageText: "0–2 岁", image: fruitGroup[0].image },
  apple: { id: "local:apple-example", title: "苹果是什么？", short: "这是苹果。苹果有不同颜色和形状。", aliases: ["苹果", "apple"], icon: "🍎", medium: "真实照片 · 事物识别", ageText: "0–2 岁", image: fruitGroup[1].image },
  animal: { id: "mt_wHN14Unk7h", title: "动物如何交流？", short: "动物会用声音、动作、气味或颜色传递信息；不同动物使用的信号不一样。", aliases: ["动物", "动物交流", "叫声", "鸟", "青蛙", "声音"], icon: "🐦", medium: "真实声音 · 信号比较", ageText: "7–9 岁", image: PHOTO("BlackBird.jpg") },
  rain: { id: "mt_TlLE4cZgOr", title: "雨水去了哪里？", short: "雨水会流进小溪和河流，也会渗进土里；一部分水受热变成水汽，后来又形成云。", aliases: ["雨", "雨水", "水循环", "水坑", "云"], icon: "🌧️", medium: "过程动画 · 因果变化", ageText: "5–7 岁", image: "" },
  plant: { id: "local:plant-example", title: "植物是什么？", short: "植物会生长，需要光、水和合适的环境。", aliases: ["植物", "plant"], icon: "🌱", medium: "照片与观察 · 自然知识", ageText: "3–6 岁", image: "" },
  growth: { id: "local:plant-growth-example", title: "植物怎样生长？", short: "植物从种子发芽，逐渐长出根、茎和叶；不同植物的生长过程不完全相同。", aliases: ["生长", "发芽", "植物生长"], icon: "🌿", medium: "过程变化 · 观察联想", ageText: "3–6 岁", image: "" },
};

const readStored = (key, fallback) => {
  try { const value = localStorage.getItem(key); return value ? JSON.parse(value) : fallback; }
  catch { return fallback; }
};
const stored = readStored("marblePrototypePrefs", {});
const state = {
  route: "home", stack: [], topicId: "banana", mapOrigin: null,
  theme: stored.theme || "forest", age: stored.age || "0-1", depth: "simple",
  fruitIndex: 0, currentGroup: "fruit", complete: false,
  history: readStored("marblePrototypeHistory", []), drawer: false, lightbox: false,
  activeAudio: null, activeAudioName: "", audioStatus: "", rainPlaying: false, rainStep: 0,
  gesture: null, suppressClickUntil: 0, restoreScroll: null,
};

const app = document.getElementById("app");
const content = document.getElementById("content");
const overlayRoot = document.getElementById("overlay-root");
const toast = document.getElementById("toast");
let toastTimer;

function escapeHTML(value) {
  return String(value).replace(/[&<>"']/g, (char) => ({ "&": "&amp;", "<": "&lt;", ">": "&gt;", '"': "&quot;", "'": "&#39;" })[char]);
}
function currentTopic() {
  return Object.values(topics).find((topic) => topic.id === state.topicId) || topics.banana;
}
function topicKey(topicId = state.topicId) {
  return Object.keys(topics).find((key) => topics[key].id === topicId) || "banana";
}
function savePrefs() {
  localStorage.setItem("marblePrototypePrefs", JSON.stringify({ theme: state.theme, age: state.age }));
}
function toastMessage(message) {
  toast.textContent = message;
  toast.classList.add("show");
  clearTimeout(toastTimer);
  toastTimer = setTimeout(() => toast.classList.remove("show"), 2600);
}
function stopAllMedia() {
  if (window.speechSynthesis) window.speechSynthesis.cancel();
  clearTimeout(state.rainTimer);
  if (state.activeAudio) {
    state.activeAudio.pause();
    try { state.activeAudio.currentTime = 0; } catch { /* metadata may not be ready */ }
  }
  state.activeAudio = null;
  state.activeAudioName = "";
  state.rainPlaying = false;
}
function setAudioStatus(message) {
  state.audioStatus = message;
  const status = document.getElementById("audio-status");
  if (status) status.textContent = message;
}
function recordHistory(key) {
  const topic = topics[key];
  if (!topic) return;
  const next = [{ id: topic.id, key, title: topic.title, at: new Date().toISOString() }, ...state.history.filter((item) => item.id !== topic.id)].slice(0, 10);
  state.history = next;
  localStorage.setItem("marblePrototypeHistory", JSON.stringify(next));
}
function rememberCurrent() {
  return {
    route: state.route, topicId: state.topicId, fruitIndex: state.fruitIndex,
    currentGroup: state.currentGroup, complete: state.complete, rainStep: state.rainStep,
    mapOrigin: state.mapOrigin ? { ...state.mapOrigin } : null,
    scrollTop: content.scrollTop,
  };
}
function navigate(route, options = {}) {
  stopAllMedia();
  state.drawer = false;
  state.lightbox = false;
  state.stack.push(rememberCurrent());
  state.route = route;
  state.restoreScroll = 0;
  if (options.topicKey) {
    state.topicId = topics[options.topicKey].id;
    state.depth = "simple";
    recordHistory(options.topicKey);
  }
  if (route === "map" && options.fromCurrent) {
    state.mapOrigin = { route: state.route === "map" ? "home" : state.stack[state.stack.length - 1]?.route || "home", topicId: state.topicId };
  }
  if (options.group) {
    state.currentGroup = options.group;
    state.fruitIndex = 0;
    state.complete = false;
  }
  if (route !== "rain") state.rainPlaying = false;
  render();
}
function openMap() {
  const origin = { route: state.route, topicId: state.topicId };
  navigate("map");
  state.mapOrigin = origin;
  render();
}
function goBack() {
  stopAllMedia();
  state.drawer = false;
  if (!state.stack.length) {
    state.route = "home";
    state.restoreScroll = 0;
  } else {
    const previous = state.stack.pop();
    state.route = previous.route;
    state.topicId = previous.topicId;
    state.fruitIndex = previous.fruitIndex;
    state.currentGroup = previous.currentGroup;
    state.complete = previous.complete;
    state.rainStep = previous.rainStep;
    state.mapOrigin = previous.mapOrigin ? { ...previous.mapOrigin } : null;
    state.restoreScroll = previous.scrollTop;
  }
  render();
}
function goHome() {
  stopAllMedia();
  state.stack = [];
  state.route = "home";
  state.topicId = "banana";
  state.complete = false;
  state.drawer = false;
  state.restoreScroll = 0;
  render();
}
function setTheme(theme) {
  state.theme = theme;
  savePrefs();
  document.body.dataset.theme = theme;
  const picker = document.getElementById("theme-select");
  if (picker) picker.value = theme;
  toastMessage(`已切换为${{ forest: "森林", ocean: "海洋", space: "星空", storybook: "绘本" }[theme]}主题`);
}

function searchResults(query) {
  const normalized = query.trim().toLowerCase();
  if (!normalized) return [];
  return Object.entries(topics).filter(([, topic]) => [topic.title, topic.short, ...topic.aliases].some((value) => value.toLowerCase().includes(normalized)));
}
function renderSearchBox(placeholder = "搜一搜：香蕉、动物交流、雨水") {
  return `<form class="search-box" data-form="search"><span class="search-icon" aria-hidden="true">⌕</span><label class="sr-only" for="home-search">搜索知识</label><input id="home-search" name="query" placeholder="${placeholder}" autocomplete="off" /><button type="submit" aria-label="搜索">➜</button></form>`;
}
function renderHome() {
  const last = state.history[0];
  const lastTopic = last && topics[topicKey(last.id)] ? topics[topicKey(last.id)] : topics.banana;
  const isToddler = ["0-1", "1-2", "2-3"].includes(state.age);
  const mainEntry = isToddler
    ? `<button class="primary-card" data-action="continuous" aria-label="开始滑滑认识世界"><span class="large-icon" aria-hidden="true">🍌</span><span><h2>滑滑认识世界</h2><p>水果照片 · 一次看一张 · 可以随时停</p></span><span class="card-arrow" aria-hidden="true">›</span></button>`
    : `<button class="primary-card" data-action="search-open" aria-label="从问题开始探索"><span class="large-icon" aria-hidden="true">🔎</span><span><h2>从一个问题开始</h2><p>搜索知识、听声音或看看过程变化</p></span><span class="card-arrow" aria-hidden="true">›</span></button>`;
  return `<section class="home-hero"><span class="eyebrow">你好，小小探索家</span><h1>一起发现<br />这个世界的有趣之处</h1><p>看一看、听一听，想到什么都可以继续探索。</p><span class="hero-tree" aria-hidden="true">🌳</span></section>
    <div class="age-row"><label for="age-select">现在想按哪个年龄感受？</label><select class="age-select" id="age-select"><option value="0-1" ${state.age === "0-1" ? "selected" : ""}>0–1 岁</option><option value="1-2" ${state.age === "1-2" ? "selected" : ""}>1–2 岁</option><option value="2-3" ${state.age === "2-3" ? "selected" : ""}>2–3 岁</option><option value="3-6" ${state.age === "3-6" ? "selected" : ""}>3–6 岁</option><option value="6-9" ${state.age === "6-9" ? "selected" : ""}>6–9 岁</option><option value="9-12" ${state.age === "9-12" ? "selected" : ""}>9–12 岁</option></select></div>
    ${renderSearchBox()}
    ${mainEntry}
    <div class="entry-grid"><button class="entry-card" data-action="open-parent"><span class="entry-icon" aria-hidden="true">👨‍👩‍👧</span><b>和家长一起看</b><small>自然地聊聊眼前的事</small></button><button class="entry-card" data-action="continue"><span class="entry-icon" aria-hidden="true">🌱</span><b>继续上次探索</b><small>${last ? escapeHTML(lastTopic.title) : "从香蕉开始看看"}</small></button></div>
    <div class="section-title"><h2>从一个问题出发</h2><small>可以随时结束</small></div>
    <div class="entry-grid"><button class="entry-card" data-action="topic" data-key="animal"><span class="entry-icon" aria-hidden="true">🐦</span><b>动物如何交流？</b><small>听听不同动物的声音</small></button><button class="entry-card" data-action="topic" data-key="rain"><span class="entry-icon" aria-hidden="true">🌧️</span><b>雨水去了哪里？</b><small>看看水的旅程</small></button></div>
    <button class="history-card" data-action="map-home"><span class="round-icon" aria-hidden="true">🗺️</span><span><b>从香蕉看看知识地图</b><small>当前知识和三个相关方向</small></span><span class="arrow" aria-hidden="true">›</span></button>
    <p class="footer-note">Marble 原型 · 不要求答题，也不需要完成一整组。</p>`;
}
function currentGroupData() { return state.currentGroup === "animals" ? animalGroup : fruitGroup; }
function renderContinuous() {
  const group = currentGroupData();
  const item = group[state.fruitIndex] || group[0];
  const count = `${state.fruitIndex + 1} / ${group.length}`;
  const completion = state.complete ? `<section class="complete-panel"><h2>这一组看完啦 ☀️</h2><p>想停在这里也可以。要是还想看，可以从头再来或换一组。</p><div class="complete-actions"><button class="soft-button" data-action="restart-group">再看一遍</button><button class="outline-button" data-action="choose-group">换一组</button><button class="outline-button" data-action="home">返回首页</button></div></section>` : "";
  return `<div class="page-head"><button class="back-button" data-action="back" aria-label="返回">‹</button><span><h1>滑滑认识世界</h1><small>${state.currentGroup === "animals" ? "森林里的小动物" : "水果小发现"} · 有限的一组</small></span></div>
    <div class="swipe-hint"><span>点照片听一听，滑动换一张</span><span class="count">${state.complete ? "完成" : count}</span></div>
    <div class="gesture-surface" data-gesture="continuous">
      <button class="object-card ${item.image ? "" : "is-fallback"}" data-action="play-fruit" aria-label="点击整张${item.name}照片播放系统语音">
        ${item.image ? `<img src="${item.image}" alt="${escapeHTML(item.name)}的真实照片" data-photo-fallback="${escapeHTML(item.name)}" />` : ""}
        <span class="audio-hint" aria-hidden="true">◖))</span><span class="image-scrim"></span><span class="image-name"><b>${escapeHTML(item.name)}</b><small>${escapeHTML(item.line)}</small></span>
      </button>
    </div>
    <div class="swipe-controls"><button class="round-control" data-action="previous" aria-label="上一张" ${state.fruitIndex === 0 ? "disabled" : ""}>↑</button><button class="outline-button zoom-trigger" data-action="zoom" data-image="${escapeHTML(item.image)}" data-name="${escapeHTML(item.name)}">放大照片</button><button class="round-control" data-action="next" aria-label="下一张">↓</button></div>
    <p class="gesture-explainer">上滑下一张　·　下滑上一张　·　滑动不会朗读</p><div class="status-note" id="audio-status">${escapeHTML(state.audioStatus || "系统朗读仅用于交互示意，不是正式配音。")}</div>
    <button class="text-button" data-action="open-parent">和家长一起看看　›</button>${completion}`;
}

function ageAnswer(topic) {
  const selectedAge = state.age;
  const toddlerAge = ["0-1", "1-2", "2-3"].includes(selectedAge);
  if (topic === "banana" || topic === "apple") {
    if (toddlerAge) return state.depth === "simple" ? (topic === "banana" ? "这是香蕉，一种水果。" : "这是苹果，一种水果。") : (topic === "banana" ? "香蕉外面是果皮，里面是果肉。" : "苹果有不同的颜色和形状。它是一种水果。");
    if (selectedAge === "3-6") return topic === "banana" ? "香蕉是一种水果。我们能看到弯弯的形状、果皮和里面的果肉。" : "苹果是一种水果。不同的苹果，颜色、大小和形状可以不一样。";
    return topic === "banana" ? "香蕉是植物结出的果实。果皮包着果肉，不同品种成熟时的颜色和形状也会有差异。" : "苹果是苹果树结出的果实。果实的颜色与大小会因品种和生长情况不同而变化。";
  }
  if (topic === "plant") return toddlerAge ? "这是一株植物。" : selectedAge === "3-6" ? "植物会长出根、茎和叶，也需要水、光和合适的环境。" : "植物通过根、茎、叶等部分生长；不同植物对光、水和环境的需要也不一样。";
  if (topic === "growth") return toddlerAge ? "小小的种子会慢慢长大。" : selectedAge === "3-6" ? "种子在合适的环境里会发芽，慢慢长出根、茎和叶。" : "种子发芽后，根、茎和叶逐渐发展；光照、水分、温度和物种差异都会影响生长。";
  if (topic === "animal") return toddlerAge ? "听一听，动物会发出什么声音。" : selectedAge === "3-6" ? "动物会用声音、动作、气味或颜色传递信息。不同动物使用的信号不一样。" : "动物之间的交流可以用声音、动作、气味或视觉信号；同一种信号的意义也要结合动物和环境来理解。";
  return toddlerAge ? "雨水会流动，也会汇到别的地方。" : selectedAge === "3-6" ? "雨水会流进小溪和河流，也会渗进土里。一部分水受热变成水汽，后来又形成云。" : "雨水可能汇入溪流、河流、湖泊或海洋，也可能渗入土壤；蒸发和植物蒸腾把水带回大气，水汽凝结后形成云，再降水。";
}
function parentCopy(topicKeyValue) {
  if (topicKeyValue === "banana") return { say: "你看，这个长长弯弯的水果是什么呢？它叫香蕉。外面这一层是果皮，里面是果肉。可以轻轻摸摸果皮，或闻闻自然的味道；想听我说也可以，不想说也没关系。", explore: "一起看看香蕉的形状和颜色；愿意的话，可以轻轻摸摸果皮、闻闻自然香味。", note: "家中已知香蕉过敏或需要避免接触时，可以只看照片。" };
  if (topicKeyValue === "animal") return { say: "我们听到一种声音了。它可以像长长的歌，也可以像短短的叫声；不同动物会用不同信号和同伴交流。想说说也可以，不想回答也没关系。", explore: "可以听完鸟声，再听青蛙声；也可以只听一种，或什么都不回答。", note: "声音只是临时示例，具体信号含义要结合动物与情境理解。" };
  if (topicKeyValue === "rain") return { say: "雨落下来以后，有的水沿着地面流，有的水渗进土里。阳光暖暖地照着，水也会变成看不见的水汽。", explore: "一起看动画里的水滴：从云里落下，再沿着地面流向小溪。", note: "这段动画是原型绘制的示意过程，不是正式科普素材。" };
  return { say: "你看，苹果有不同的颜色和形状。我们可以找找它们哪里一样，哪里不一样。", explore: "可以一起观察照片里的颜色、大小和形状。", note: "想停下来或换个话题都可以。" };
}
function renderTopicPage() {
  const key = topicKey();
  const topic = topics[key];
  const isPhoto = key === "banana" || key === "apple";
  const answer = ageAnswer(key);
  const related = key === "banana" ? [["apple", "苹果", "颜色和形状"], ["animal", "植物", "从植物认识食物"]] : key === "animal" ? [["rain", "声音和信号", "不同信号"], ["banana", "动物与环境", "生活环境"]] : key === "rain" ? [["banana", "云和水汽", "变化过程"], ["animal", "河流和小溪", "水的去向"]] : [["banana", "水果", "相同与不同"], ["rain", "植物", "生长需要水"]];
  const photo = isPhoto ? `<button class="topic-image" data-action="play-topic-voice" aria-label="点击整张${topic.title}主图播放系统语音"><img src="${topic.image}" alt="${escapeHTML(topic.title)}真实照片" data-photo-fallback="${escapeHTML(topic.title)}" /><span class="audio-hint" aria-hidden="true">◖))</span><span class="image-scrim"></span><span class="image-name"><b>${topic.icon} ${escapeHTML(topic.title.replace("？", ""))}</b><small>点击整张照片听系统语音示意</small></span></button><div class="zoom-row"><button data-action="zoom" data-image="${escapeHTML(topic.image)}" data-name="${escapeHTML(topic.title)}">⌕　放大照片</button></div>` : "";
  let media = "";
  if (key === "animal") media = `<div class="content-section"><h3>听听不同的声音</h3><p>点选一种声音，听完再选择另一种；声音不会自动连播。</p><div class="sound-card"><span class="animal-mark"><img src="${PHOTO("BlackBird.jpg")}" alt="黑鸫照片" data-photo-fallback="黑鸫" /></span><span><h3>黑鸫鸣声</h3><p>真实野外录音 · 临时素材</p></span><button data-action="play-animal" data-sound="bird" aria-label="播放黑鸫鸣声">▶</button></div><div class="sound-card"><span class="animal-mark"><img src="${PHOTO("Frog close-up.jpg")}" alt="青蛙照片" data-photo-fallback="青蛙" /></span><span><h3>青蛙鸣叫</h3><p>真实录音 · 临时素材</p></span><button data-action="play-animal" data-sound="frog" aria-label="播放青蛙鸣叫">▶</button></div><div class="sample-disclaimer">声音样本来自 Wikimedia Commons，仅用于原型交互测试，不是正式录音或科学审校完成的内容。</div><div class="status-note" id="audio-status">${escapeHTML(state.audioStatus || "点选一个声音开始播放")}</div></div><div class="content-section"><h3>可以比较什么？</h3><p>听听声音长短、节奏和高低，再看看动物的动作。声音不一定只有一种意思，也不要求孩子猜对。</p><div class="fact-chips"><span>声音</span><span>动作</span><span>环境</span></div></div>`;
  if (key === "rain") media = `<div class="content-section"><h3>看水滴走一趟</h3><p>这是一段可主动开始的过程示意。不同地方的水，走过的路线可能不一样。</p><div class="rain-scene ${state.rainPlaying ? "playing" : ""}" aria-label="雨水流动的示意动画"><span class="rain-sun" aria-hidden="true"></span><span class="rain-cloud" aria-hidden="true">☁️</span><span class="rain-drop" aria-hidden="true">💧</span><span class="rain-drop" aria-hidden="true">💧</span><span class="rain-drop" aria-hidden="true">💧</span><span class="rain-drop" aria-hidden="true">💧</span><span class="rain-mountain" aria-hidden="true"></span><span class="rain-river" aria-hidden="true"></span><span class="rain-stage">${["云里有水汽", "雨落下来", "沿地面流动", "水渗入土里", "水汽回到空气"][state.rainStep]}</span></div><div class="step-line">${["云里有水汽", "雨落下来", "沿地面流动", "水渗入土里", "水汽回到空气"].map((step, i) => `<button class="step-chip ${state.rainStep === i ? "active" : ""}" data-action="rain-step" data-step="${i}">${i + 1}. ${step}</button>`).join("")}</div><div class="animation-controls"><button class="soft-button" data-action="rain-toggle">${state.rainPlaying ? "暂停动画" : "开始动画"}</button><button class="outline-button" data-action="rain-restart">从头重播</button></div><div class="sample-disclaimer">本原型绘制的临时示意动画，非正式媒体；文字说明仍可独立阅读。</div></div><div class="content-section"><h3>为什么水会回到云里？</h3><p>太阳让水面和湿润地面的水变成水汽；水汽升到较冷的空气里，会凝结成小水滴，聚在一起形成云。雨落下后，水又会沿不同路径流动或渗入土里。</p></div>`;
  const intro = key === "banana" ? "本地扩展事物识别样板 · 不是原版知识节点" : key === "rain" ? "原版知识主题样板 · 动画暂缺，当前为原型示意" : key === "animal" ? "原版知识主题样板 · 媒体暂缺，本轮使用临时音频" : "地图关联的本地示例详情";
  return `<div class="page-head"><button class="back-button" data-action="back" aria-label="返回上一页">‹</button><span><h1>${escapeHTML(topic.title)}</h1><small>${escapeHTML(topic.medium)}</small></span></div>
    <div class="note-pill">${escapeHTML(intro)}</div>
    ${photo}
    <div class="detail-toolbar"><label for="detail-age">体验年龄</label><select id="detail-age"><option value="0-1" ${state.age === "0-1" ? "selected" : ""}>0–1 岁</option><option value="1-2" ${state.age === "1-2" ? "selected" : ""}>1–2 岁</option><option value="2-3" ${state.age === "2-3" ? "selected" : ""}>2–3 岁</option><option value="3-6" ${state.age === "3-6" ? "selected" : ""}>3–6 岁</option><option value="6-9" ${state.age === "6-9" ? "selected" : ""}>6–9 岁</option><option value="9-12" ${state.age === "9-12" ? "selected" : ""}>9–12 岁</option></select><label for="detail-depth">解释</label><select id="detail-depth"><option value="simple" ${state.depth === "simple" ? "selected" : ""}>简单一点</option><option value="more" ${state.depth === "more" ? "selected" : ""}>再多一点</option></select><span class="note-pill">${topic.id.startsWith("local:") ? "本地样板" : "原版年龄"}：${escapeHTML(topic.ageText || "未注明")}</span></div>
    <section class="answer-card"><span class="eyebrow">先认识一下</span><h2>${escapeHTML(answer)}</h2><p>${key === "banana" ? "照片和文字可先单独浏览；图片播放是主动选择。" : key === "rain" ? "你可以看动画、按步骤阅读，或只看文字。" : key === "animal" ? "声音是可选的体验入口，文字和比较提示也能独立理解。" : "这里是普通知识详情，页面上下滑动用于阅读。"}</p></section>
    ${media}
    <div class="detail-actions"><button data-action="open-parent"><span aria-hidden="true">💬</span>家长陪读</button><button data-action="map"><span aria-hidden="true">🗺️</span>看看知识地图</button></div>
    <div class="section-title"><h2>还可以看看</h2><small>自由选择</small></div>
    <div class="related-list">${related.map(([to, title, label]) => `<button class="topic-link" data-action="topic" data-key="${to}"><span class="round-icon" aria-hidden="true">${topics[to].icon}</span><span><b>${escapeHTML(title)}</b><small>${escapeHTML(label)} · ${escapeHTML(topics[to].title)}</small></span><span class="arrow" aria-hidden="true">›</span></button>`).join("")}</div>
    <p class="footer-note">不需要答对，也不需要继续。觉得够了就可以停在这里。</p>`;
}

function renderMap() {
  const centerKey = topicKey(state.mapOrigin?.topicId || state.topicId);
  const center = topics[centerKey];
  const relations = {
    banana: [
      { key: "plant", icon: "🌱", title: "植物", label: "生长 · 结果" },
      { key: "apple", icon: "🍎", title: "苹果", label: "相似水果" },
      { key: "growth", icon: "🌿", title: "生长过程", label: "从植物继续看" },
    ],
    apple: [
      { key: "banana", icon: "🍌", title: "香蕉", label: "相似水果" },
      { key: "plant", icon: "🌱", title: "植物", label: "果实与生长" },
      { key: "growth", icon: "🌿", title: "生长过程", label: "从植物继续看" },
    ],
    animal: [
      { key: "plant", icon: "🌱", title: "植物与动物", label: "生命与环境" },
      { key: "rain", icon: "🌧️", title: "水与栖息地", label: "环境中的水" },
      { key: "banana", icon: "🍌", title: "食物与生命", label: "生命所需" },
    ],
    rain: [
      { key: "plant", icon: "🌱", title: "植物与水", label: "水与生长" },
      { key: "growth", icon: "🌿", title: "生长过程", label: "植物需要水分" },
      { key: "animal", icon: "🐦", title: "动物与水", label: "水与栖息地" },
    ],
    plant: [
      { key: "rain", icon: "🌧️", title: "雨水", label: "生长所需" },
      { key: "growth", icon: "🌿", title: "生长过程", label: "从种子开始" },
      { key: "banana", icon: "🍌", title: "香蕉", label: "植物结出的果实" },
    ],
    growth: [
      { key: "plant", icon: "🌱", title: "植物", label: "生长的对象" },
      { key: "rain", icon: "🌧️", title: "雨水", label: "生长所需" },
      { key: "banana", icon: "🍌", title: "香蕉", label: "植物的果实" },
    ],
  };
  const related = relations[centerKey] || relations.banana;
  return `<div class="page-head"><button class="back-button" data-action="back" aria-label="返回">‹</button><span><h1>知识地图 · ${escapeHTML(center.title.replace("？", ""))}</h1><small>当前知识和少量关联</small></span></div>
    <div class="map-viewport" id="map-viewport" aria-label="知识关系图"><div class="map-inner"><svg class="map-lines" viewBox="0 0 360 430" aria-hidden="true"><line x1="180" y1="213" x2="180" y2="58"/><line x1="180" y1="213" x2="59" y2="240"/><line x1="180" y1="213" x2="300" y2="240"/></svg>
      ${related.map((node, index) => `<button class="map-node ${["plant", "apple", "fruit"][index]}" data-action="topic" data-key="${node.key}"><span class="node-emoji" aria-hidden="true">${node.icon}</span><b>${escapeHTML(node.title)}</b><small>${escapeHTML(node.label)}</small></button>`).join("")}
      <button class="map-node center" data-action="topic" data-key="${centerKey}"><span class="node-emoji" aria-hidden="true">${center.icon}</span><b>${escapeHTML(center.title.replace("？", ""))}</b><small>当前知识</small></button>
    </div></div>
    <p class="map-caption">点选一个节点查看普通知识详情；返回地图会保留当前视角。</p>
    <div class="map-bottom"><button class="soft-button" data-action="back">${state.mapOrigin?.route === "home" ? "返回探索首页" : `返回${escapeHTML(center.title.replace("？", ""))}详情`}</button><button class="outline-button" data-action="parent-hub">家长与历史</button></div>
    <p class="footer-note">低龄地图本轮只验证已确认的当前节点与 2–3 个图片关联节点，不扩展地图玩法。</p>`;
}
function renderParentHub() {
  const historyMarkup = state.history.length ? state.history.map((item) => `<div class="history-row"><span aria-hidden="true">${topics[item.key]?.icon || "◦"}</span><button data-action="topic" data-key="${item.key}"><b>${escapeHTML(item.title)}</b><small>${new Date(item.at).toLocaleString("zh-CN", { month: "numeric", day: "numeric", hour: "2-digit", minute: "2-digit" })}</small></button></div>`).join("") : `<div class="empty-state">还没有记录过知识跳转。读过的知识会保存在这台设备的浏览器里。</div>`;
  return `<div class="page-head"><button class="back-button" data-action="back" aria-label="返回">‹</button><span><h1>家长空间</h1><small>历史只保存在本机浏览器</small></span></div>
    <section class="content-section"><h3>探索历史</h3><p>只记录打开过的知识主题，不记录每次点击、滚动或搜索输入。</p>${historyMarkup}<button class="danger-link" data-action="clear-history" ${state.history.length ? "" : "disabled"}>清除本机历史</button></section>
    <section class="content-section"><h3>原型说明</h3><p>没有账号、同步、服务器或儿童数据收集。系统语音、动物录音和雨水动画都是交互示意，不是 Marble 正式媒体。</p></section>`;
}
function renderSearch() {
  const query = state.query || "";
  const results = searchResults(query);
  return `<div class="page-head"><button class="back-button" data-action="back" aria-label="返回">‹</button><span><h1>文字搜索</h1><small>原型只做文字匹配</small></span></div>${renderSearchBox("输入一个问题或知识词")}
    ${query ? `<div class="search-results">${results.length ? results.map(([key, topic]) => `<button class="topic-link" data-action="topic" data-key="${key}"><span class="round-icon" aria-hidden="true">${topic.icon}</span><span><b>${escapeHTML(topic.title)}</b><small>${escapeHTML(topic.medium)} · ${escapeHTML(topic.short)}</small></span><span class="arrow" aria-hidden="true">›</span></button>`).join("") : `<div class="empty-state">没有找到这个词。可以试试“香蕉”“动物”或“雨水”。也可以先停在这里。</div>`}</div>` : `<div class="empty-state">试试：香蕉、动物交流、雨水。语音搜索与识图不在本轮范围内。</div>`}`;
}
function render() {
  document.body.dataset.theme = state.theme;
  const themeSelect = document.getElementById("theme-select");
  if (themeSelect) themeSelect.value = state.theme;
  const views = { home: renderHome, continuous: renderContinuous, topic: renderTopicPage, map: renderMap, parent: renderParentHub, search: renderSearch };
  content.innerHTML = (views[state.route] || renderHome)();
  const bottom = document.getElementById("bottom-nav");
  bottom.hidden = !["home", "search", "parent"].includes(state.route);
  bottom.innerHTML = `<button class="nav-item ${state.route === "home" ? "active" : ""}" data-action="home"><span aria-hidden="true">⌂</span><span>首页</span></button><button class="nav-item" data-action="map-home"><span aria-hidden="true">⌘</span><span>地图</span></button><button class="nav-item ${state.route === "parent" ? "active" : ""}" data-action="parent-hub"><span aria-hidden="true">♧</span><span>家长</span></button>`;
  if (state.restoreScroll !== null) {
    const position = state.restoreScroll;
    requestAnimationFrame(() => { content.scrollTop = position; state.restoreScroll = null; });
  }
  renderOverlay();
}
function renderOverlay() {
  overlayRoot.innerHTML = "";
  if (state.drawer) {
    const topicKeyValue = topicKey();
    const copy = parentCopy(topicKeyValue);
    overlayRoot.innerHTML = `<div class="drawer-backdrop" data-action="backdrop-close"><section class="parent-drawer" role="dialog" aria-modal="true" aria-labelledby="drawer-title"><div class="drawer-handle"></div><div class="drawer-head"><h2 id="drawer-title">给爸爸妈妈的话</h2><button class="drawer-close" data-action="close-parent" aria-label="关闭陪读抽屉">×</button></div><div class="note-pill">${escapeHTML(currentTopic().title)}</div><p class="parent-copy">${escapeHTML(copy.say)}</p><div class="parent-suggestion"><h3>可以一起看看</h3><p>${escapeHTML(copy.explore)}</p></div><p class="allergy-note">${escapeHTML(copy.note)}</p><div class="sample-disclaimer">打开陪读时，当前声音已停止。关闭后不会自动续播；想听可以再主动点击。</div><button class="soft-button" data-action="close-parent">知道了</button></section></div>`;
  }
  if (state.lightbox) {
    overlayRoot.innerHTML = `<div class="lightbox-backdrop" data-action="close-zoom"><figure class="lightbox"><button class="lightbox-close" data-action="close-zoom" aria-label="关闭放大照片">×</button><img src="${state.zoomImage}" alt="${escapeHTML(state.zoomName || "放大的照片")}" data-photo-fallback="${escapeHTML(state.zoomName || "照片")}" /><figcaption class="footer-note">临时参考照片 · ${escapeHTML(state.zoomName || "")}</figcaption></figure></div>`;
  }
}

function speak(text) {
  stopAllMedia();
  if (!window.speechSynthesis || typeof SpeechSynthesisUtterance === "undefined") {
    setAudioStatus("当前浏览器没有系统语音；文字仍可阅读。点击不播放其他媒体。");
    toastMessage("没有可用的系统语音，文字内容仍可读");
    return;
  }
  const utterance = new SpeechSynthesisUtterance(text);
  utterance.lang = "zh-HK";
  utterance.rate = 0.84;
  utterance.onend = () => { state.activeAudio = null; setAudioStatus("系统语音示意已结束。可再点照片重播。"); };
  utterance.onerror = () => { state.activeAudio = null; setAudioStatus("系统语音不可用；文字内容仍可读。"); };
  window.speechSynthesis.speak(utterance);
  setAudioStatus("正在播放本机系统语音示意。不是正式配音。");
}
function playAnimalSound(which) {
  stopAllMedia();
  const src = which === "bird" ? SOUND("Common Blackbird song (Turdus merula).ogg") : SOUND("Single Frog Croak.oga");
  const label = which === "bird" ? "黑鸫鸣声" : "青蛙鸣叫";
  const audio = new Audio(src);
  audio.preload = "none";
  state.activeAudio = audio;
  state.activeAudioName = label;
  audio.onended = () => { state.activeAudio = null; state.activeAudioName = ""; setAudioStatus(`${label}播放结束。可以再选另一段声音。`); };
  audio.onerror = () => { state.activeAudio = null; setAudioStatus(`${label}未能加载。声音样本需要网络，文字说明仍可阅读。`); };
  setAudioStatus(`正在加载${label}临时录音…`);
  audio.play().then(() => setAudioStatus(`正在播放${label}临时录音。切换页面或打开陪读会停止它。`))
    .catch(() => setAudioStatus(`${label}未能播放。可能是网络或格式不支持；文字说明仍可阅读。`));
}
function setGroupIndex(delta) {
  stopAllMedia();
  const total = currentGroupData().length;
  if (delta > 0) {
    if (state.fruitIndex >= total - 1) state.complete = true;
    else state.fruitIndex += 1;
  } else if (state.fruitIndex > 0) {
    state.fruitIndex -= 1;
    state.complete = false;
  }
  state.audioStatus = "切换卡片后，上一个声音已停止。";
  render();
}
function startAnimation() {
  state.rainPlaying = !state.rainPlaying;
  if (state.rainPlaying) {
    if (state.rainStep >= 4) state.rainStep = 0;
    state.rainTimer = setTimeout(() => {
      state.rainPlaying = false;
      state.rainStep = 4;
      render();
    }, 6200);
  } else clearTimeout(state.rainTimer);
  render();
}
function openParent() {
  stopAllMedia();
  state.audioStatus = "声音已停止；关闭后需重新主动播放。";
  state.drawer = true;
  renderOverlay();
}
function openZoom(image, name) {
  state.zoomImage = image;
  state.zoomName = name;
  state.lightbox = true;
  renderOverlay();
}

app.addEventListener("click", (event) => {
  if (Date.now() < state.suppressClickUntil) return;
  const control = event.target.closest("[data-action]");
  if (!control) return;
  const action = control.dataset.action;
  const key = control.dataset.key;
  if (action === "home") return goHome();
  if (action === "back") return goBack();
  if (action === "topic") return navigate("topic", { topicKey: key });
  if (action === "search-open") { state.query = ""; return navigate("search"); }
  if (action === "continuous") { state.fruitIndex = 0; state.currentGroup = "fruit"; state.complete = false; state.audioStatus = "系统朗读仅用于交互示意，不是正式配音。"; return navigate("continuous"); }
  if (action === "continue") {
    const latest = state.history[0];
    if (!latest) return navigate("topic", { topicKey: "banana" });
    return navigate("topic", { topicKey: latest.key });
  }
  if (action === "open-parent") return openParent();
  if (action === "parent-hub") return navigate("parent");
  if (action === "map") return openMap();
  if (action === "map-home") { state.topicId = topics.banana.id; state.mapOrigin = { route: "home", topicId: topics.banana.id }; return navigate("map"); }
  if (action === "play-fruit") {
    const item = currentGroupData()[state.fruitIndex];
    return speak(item.voice);
  }
  if (action === "play-topic-voice") return speak(ageAnswer(topicKey()));
  if (action === "previous") return setGroupIndex(-1);
  if (action === "next") return setGroupIndex(1);
  if (action === "restart-group") { stopAllMedia(); state.fruitIndex = 0; state.complete = false; state.audioStatus = "从第一张重新开始。没有自动播放声音。"; return render(); }
  if (action === "choose-group") {
    const nextGroup = state.currentGroup === "fruit" ? "animals" : "fruit";
    stopAllMedia(); state.currentGroup = nextGroup; state.fruitIndex = 0; state.complete = false; state.audioStatus = "换了一组照片；声音不会自动播放。"; return render();
  }
  if (action === "zoom") return openZoom(control.dataset.image, control.dataset.name);
  if (action === "close-zoom") {
    if (event.target.closest(".lightbox-close") || !event.target.closest(".lightbox")) { state.lightbox = false; return renderOverlay(); }
    return;
  }
  if (action === "close-parent") { state.drawer = false; renderOverlay(); return toastMessage("声音已停止；想听可以重新点播放"); }
  if (action === "backdrop-close") { if (event.target === control) { state.drawer = false; renderOverlay(); } return; }
  if (action === "play-animal") return playAnimalSound(control.dataset.sound);
  if (action === "rain-toggle") return startAnimation();
  if (action === "rain-restart") { clearTimeout(state.rainTimer); state.rainPlaying = false; state.rainStep = 0; return render(); }
  if (action === "rain-step") { clearTimeout(state.rainTimer); state.rainPlaying = false; state.rainStep = Number(control.dataset.step); return render(); }
  if (action === "clear-history") {
    state.history = []; localStorage.removeItem("marblePrototypeHistory"); render(); return toastMessage("本机浏览历史已清除");
  }
});

content.addEventListener("submit", (event) => {
  if (!event.target.matches('[data-form="search"]')) return;
  event.preventDefault();
  const query = new FormData(event.target).get("query")?.toString() || "";
  state.query = query;
  navigate("search");
  const input = document.getElementById("home-search");
  if (input) input.value = query;
});
content.addEventListener("keydown", (event) => {
  if (state.route === "continuous" && event.key === "ArrowUp") { event.preventDefault(); setGroupIndex(1); }
  if (state.route === "continuous" && event.key === "ArrowDown") { event.preventDefault(); setGroupIndex(-1); }
  if (event.key === "Enter" && event.target.id === "home-search") event.target.closest("form").requestSubmit();
});
content.addEventListener("change", (event) => {
  if (event.target.id === "age-select" || event.target.id === "detail-age") { state.age = event.target.value; savePrefs(); if (state.route === "topic") render(); }
  if (event.target.id === "detail-depth") { state.depth = event.target.value; render(); }
});
document.getElementById("theme-select").addEventListener("change", (event) => setTheme(event.target.value));

app.addEventListener("error", (event) => {
  const image = event.target.closest("img[data-photo-fallback]");
  if (!image) return;
  const parent = image.closest(".object-card, .topic-image, .animal-mark, .lightbox");
  const emoji = { "香蕉": "🍌", "香蕉是什么？": "🍌", "苹果": "🍎", "苹果是什么？": "🍎", "梨": "🍐", "橙子": "🍊", "草莓": "🍓", "黑鸫": "🐦", "青蛙": "🐸", "动物如何交流？": "🐦" }[image.dataset.photoFallback] || "🌿";
  if (parent) { parent.classList.add("is-fallback"); parent.dataset.fallbackEmoji = emoji; }
  image.removeAttribute("src");
  setAudioStatus("照片暂未加载；名称和文字仍然可看。网络恢复后可重新打开页面。");
}, true);
content.addEventListener("pointerdown", (event) => {
  if (state.route !== "continuous" || !event.target.closest("[data-gesture='continuous']")) return;
  const surface = event.target.closest("[data-gesture='continuous']");
  state.gesture = { id: event.pointerId, y: event.clientY, x: event.clientX, moved: false, surface };
  try { surface.setPointerCapture(event.pointerId); } catch { /* capture may be unavailable on synthetic pointers */ }
});
content.addEventListener("pointermove", (event) => {
  if (!state.gesture || event.pointerId !== state.gesture.id) return;
  const dy = event.clientY - state.gesture.y;
  const dx = event.clientX - state.gesture.x;
  if (Math.abs(dy) > 12 || Math.abs(dx) > 12) state.gesture.moved = true;
  if (Math.abs(dy) > 10) event.preventDefault();
});
content.addEventListener("pointerup", (event) => {
  if (!state.gesture || event.pointerId !== state.gesture.id) return;
  const dy = event.clientY - state.gesture.y;
  const moved = state.gesture.moved;
  state.gesture = null;
  if (!moved) return;
  state.suppressClickUntil = Date.now() + 450;
  event.preventDefault();
  if (Math.abs(dy) >= 52) setGroupIndex(dy < 0 ? 1 : -1);
});
content.addEventListener("pointercancel", () => { state.gesture = null; });

render();
