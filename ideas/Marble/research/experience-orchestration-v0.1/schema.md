# Marble Presentation Layer Schema V0.1

`presentation.schema.json` 每次校验一条研究记录。研究版本写入 `schemaVersion: "0.1.0"`。现有字段的含义、门禁或兼容性若变更，应更新版本并先复测样本。适用规格为 [JSON Schema Draft 2020-12](https://json-schema.org/draft/2020-12)。

## 字段和职责

| 部分 | 关键字段 | 用法 |
| --- | --- | --- |
| Knowledge | `knowledge.source`、`title`、`descriptionSummary`、`subject`、`domain`、`sourceType`、`sourceAge`、`tags`、`tagRationale` | 保留来源映射和原版标签。本地中文摘要及体验类型单独保存。标签有顺序，首项驱动首选媒介，后续项表示值得保留的体验角度。 |
| Presentation | `presentation.primaryMedium`、`mediumRationale`、`entry`、`media`、`fallback`、`activity` | 用现象或孩子的问题开场，`answer` 给出简短直接的回答，后续自选体验。现实活动可留空，离线替代始终必填。 |
| Exploration | `exploration[].targetId`、`relation`、`reason`、`optional` | `local_suggestion` 是本地候选链接。`upstream_dependency` 必须按原版依赖文件核对两个真实 ID 和方向。两者在体验层都可跳过，也允许数组为空。 |
| Adaptation | `adaptation[].ageBand`、`guidance` | 按已确认的六个年龄段选填适配指导。每段最多一条。记录可只覆盖本轮实际选定的年龄段。 |
| Safety & Quality | `safetyQuality.status`、`reasons`、`evidence` | `research_reviewed` 表示执行者已复核。`manual_review_required` 表示相关事实或安全建议待人工判定。独立审查另有单独记录。证据项用 HTTPS 链接或仓库文件相对路径。 |

## 来源、年龄和关联

- 原版记录 `id` 等同于 `source.topicId`，另存固定上游提交与 `upstream/data/topics.json` 路径。`title`、`sourceType`、`subject`、`domain`、`sourceAge` 按原版逐项匹配。`descriptionSha256` 对源 JSON 解码后的描述字符串直接编码为 UTF-8，再取 SHA-256。空格、标点和大小写均按原样保留。原文通过稳定 ID 回查，中文摘要用于人工对照。
- 本地扩展使用 `local:<slug>`。`source.referenceTopicIds` 可记录相关原版主题，`sourceType` 与 `sourceAge` 均为 `null`。年龄适配独立填写，相关主题只用于导航。
- `sourceAge.start` 与 `sourceAge.end` 保持原版年龄数值。体验侧 `ageBand` 只影响默认呈现。低龄适配允许把同一主题简化成感官命名，较高年龄可直接展开机制，孩子始终可决定是否继续。恰好 6 岁、9 岁等分界点及按月龄归档的规则留待运行时设计。活动资格由独立安全前提判定。
- 依赖校验保留原版图的方向。本地候选关系按体验入口指向目标，允许跨学科和双向互链。正式链接是否上线，仍取决于各目标节点的内容和安全审核状态。

## 媒介和离线替代

- `primaryMedium` 表达设计推荐，`media[].availability` 表达材料状态。`proposed` 为计划中的媒介，`missing` 为已知缺位，`available` 需要指定相对于已审核资源根目录的 `ref`。本轮描述了建议素材及其缺口。
- `fallback.description` 要写出能在室内、关闭网络或无法使用摄像头时执行的具体体验。单靠文字可以完成时可选 `text`；图像或音频替代须具备可访问的离线资源，或在说明中提供无需该资源的文字步骤。`offline` 必须为真，`requiresCamera` 和 `requiresUpload` 必须为假。
- 正式内容的媒体元数据可用 `role` 与 `language` 表达 `voiceover/yue`、`captions/yue`、`voiceover/en`、`captions/en`。粤语字幕采用口语稿，英文与粤语分别有完整音轨、对应字幕和独立时间轴。资源齐备、相对路径有效性、字幕同步、读音和授权属于正式内容的后续审核。`audio` 搭配 `ambient` 可另记实录声。法语语音示例使用 `audio`、`illustration` 与 `fr`。`text` 类型的 `captions` 资源可引用字幕文件。即时问答保持粤语默认与可选英文关键词规则。

例如，可为原版 Rain & Puddles（`mt_TlLE4cZgOr`）提出过程动画，同时保留一个无需动画文件的入口。

```json
{
  "primaryMedium": "animation",
  "media": [
    {"medium": "animation", "availability": "proposed"},
    {"medium": "audio", "availability": "missing", "role": "ambient"}
  ],
  "fallback": {
    "medium": "text",
    "description": "用手指比出水坑从大变小的样子，请大人说说水蒸发时会进入空气。",
    "offline": true,
    "requiresCamera": false,
    "requiresUpload": false
  }
}
```

## 现实活动与审查

- `activity` 为 `null` 时只提供离线文字或屏幕内体验。有活动时须说明行为、风险、危险因素、看护方式、环境前提和专属替代。`optional: true` 后可以直接结束。`adult_present` 指成人在场观察，`adult_leads` 指成人执行判断、示范或控制环境。
- `risk` 与 `hazards` 描述研究时识别出的风险。高风险和 `unknown` 转入人工复核。本轮样本通过空活动和显式安全理由记录高风险主题。选择活动前还需用可信上下文核对前提。前提无法确认时走安全替代。硬规则阻断优先于文案或模型意见，人工复核本身也不能解除硬阻断。
- 例子中的 `prerequisites` 是研究描述，属于给研究者与照护者浏览的文本。后续若实现运行时判定，需要由可信来源提供天气、监护、环境等结构化信号，并将候选动作映射到独立审查的规则。缺失、过期和冲突信号均应按未知处理。

## 校验边界

| 检查 | Schema 或补充证据 |
| --- | --- |
| 字段必填和值域 | Schema 校验类型、枚举、来源分支、高风险或未知危险需人工复核、离线替代标记、媒介引用状态与活动可选性。 |
| 数据一致性 | 运行附带校验，核对原版文件校验和、原文摘要的来源定位、描述摘要对应的原文哈希、稳定 ID、名称、年龄和记录总数；同一节点的适配年龄段应唯一，年龄起点不得大于终点，探索链接按来源校验。 |
| 内容判断 | 研究复核逐条看分类理由、媒介理由、离线替代、科学表述及风险前提。仍有争议的项目进入人工复核队列。 |
| 持续运行与发布 | 真实媒介交付、风险信号采集、实时策略、运行时代码、交互效果、字幕同步及正式发布需要单独验收。 |

完整实例和校验输出见 [30 个原版记录](nodes.json)、[香蕉本地样板](banana.json)、[校验日志](validation-results.json)。

原版主题和依赖来自 Marble Skill Taxonomy (v1) · © Generative Spark, Inc. (Marble)。许可和固定快照见 [Marble 上游来源](../../upstream/README.md)。
