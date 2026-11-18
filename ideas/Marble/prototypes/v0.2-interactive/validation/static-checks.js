const assert = require('node:assert/strict');
const fs = require('node:fs');
const path = require('node:path');

const root = path.resolve(__dirname, '..');
const html = fs.readFileSync(path.join(root, 'index.html'), 'utf8');
const css = fs.readFileSync(path.join(root, 'styles.css'), 'utf8');
const app = fs.readFileSync(path.join(root, 'app.js'), 'utf8');

const checks = [
  ['static page loads local CSS and JS', /href="styles\.css"/.test(html) && /src="app\.js"/.test(html)],
  ['home primary entry adapts to selected age', /const isToddler = \["0-1", "1-2", "2-3"\]/.test(app) && /data-action="search-open"/.test(app)],
  ['continuous groups are finite and start with five fruit objects', (app.match(/name: "(?:香蕉|苹果|梨|橙子|草莓)"/g) || []).length === 5],
  ['low-age image has a small hint and no separate prominent play button', /class="audio-hint" aria-hidden="true"/.test(app) && !/class="audio-hint[^>]*>[^<]*<\/button>/.test(app)],
  ['swipe stays inside the continuous-mode surface and requires a 52px gesture', /data-gesture="continuous"/.test(app) && /Math\.abs\(dy\) >= 52/.test(app)],
  ['image speech is attached to explicit click actions', /action === "play-fruit"/.test(app) && /action === "play-topic-voice"/.test(app)],
  ['swipe changes card and stops any prior media', /function setGroupIndex\(delta\)[\s\S]*?stopAllMedia\(\)/.test(app)],
  ['group completion exposes restart, switch and home actions', /restart-group/.test(app) && /choose-group/.test(app) && /data-action="home"/.test(app)],
  ['navigation stack stores and restores scroll position', /scrollTop: content\.scrollTop/.test(app) && /content\.scrollTop = position/.test(app)],
  ['navigation stack stores and restores map origin', /mapOrigin: state\.mapOrigin \? \{ \.\.\.state\.mapOrigin \} : null/.test(app) && /state\.mapOrigin = previous\.mapOrigin \?/.test(app)],
  ['lightbox close button and backdrop both close without closing on image click', /event\.target\.closest\("\.lightbox-close"\) \|\| !event\.target\.closest\("\.lightbox"\)/.test(app)],
  ['map links are topic actions and renders three relations', /related\.map\(\(node, index\)/.test(app) && /relations\[centerKey\]/.test(app)],
  ['opening parent reading stops media and drawer is scrollable', /function openParent\(\)[\s\S]*?stopAllMedia\(\)/.test(app) && /\.parent-drawer[^\n]*max-height:86vh;overflow:auto/.test(css)],
  ['theme is globally applied and stored', /document\.body\.dataset\.theme = theme/.test(app) && /theme: state\.theme/.test(app)],
  ['history is local and can be cleared', /localStorage\.setItem\("marblePrototypeHistory"/.test(app) && /localStorage\.removeItem\("marblePrototypeHistory"/.test(app)],
  ['image, audio and rain have readable fallback or manual controls', /照片暂未加载/.test(app) && /未能播放/.test(app) && /rain-step/.test(app)],
  ['lightbox image errors reach the shared fallback handler and lightbox selector', /app\.addEventListener\("error"/.test(app) && /\.object-card, \.topic-image, \.animal-mark, \.lightbox/.test(app) && /\.lightbox\.is-fallback/.test(css)],
  ['temporary sample and upstream topic IDs stay distinguishable', /local:banana-identification/.test(app) && /mt_wHN14Unk7h/.test(app) && /mt_TlLE4cZgOr/.test(app)],
  ['large action targets meet the 56px CSS baseline', /\.icon-button\{width:56px;height:56px/.test(css) && /\.back-button\{width:56px;height:56px/.test(css) && /\.round-control\{width:56px;height:56px/.test(css)],
  ['language switching is not silently claimed as implemented', !/id="language-select"/.test(html) && !/id="language-select"/.test(app)],
];

let failures = 0;
for (const [name, ok] of checks) {
  console.log(`${ok ? 'PASS' : 'FAIL'} ${name}`);
  if (!ok) failures += 1;
}
console.log(`${checks.length - failures}/${checks.length} static assertions passed`);
if (failures) process.exitCode = 1;
