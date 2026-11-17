# Marble 原版知识库引入与本地扩展规范（2026-11-17）

> **历史阶段记录（已归档）**：本文的“尚未导入上游 JSON”“待锁定版本”“Marble README 待更新”等状态已过时。当前已完成七个上游 JSON 导入、固定版本、1,912 条中文目录初译及 README 更新。请以 [Marble 当前进度](../README.md) 与 [中文目录](../catalog/README.md) 为准；本文保留原始讨论记录，不代表当前待办清单。

## 上游来源
- 仓库：https://github.com/withmarbleapp/os-taxonomy
- 数据目录：https://github.com/withmarbleapp/os-taxonomy/tree/main/data
- 清单：https://github.com/withmarbleapp/os-taxonomy/blob/main/data/manifest.json
- 读取日期：2026-11-17；上游数据随时可能更新，以固定 commit 和校验和为准。
- 本文记录的是引入方案和已核实的清单，**不代表完整上游 JSON 已复制入 IdeaLab**。

## 核实数据（manifest.json）
- 知识节点 topics：1,912
- 前置关系 dependencies：4,002
- 课程标准 curriculumStandards：8,721
- 课程关联 topicStandardLinks：12,566
- clusters：177；teachingResearch：1,097
- 七个主要 JSON 文件合计：32,045,638 bytes（约 30.56 MiB）
- 文件：topics.json、dependencies.json、curriculum-standards.json、clusters.json、teaching-research.json、archived-teaching-research.json、curriculum-alignments.json。
- README 统计与 manifest 可能因更新时点不同而不一致，导入以实际快照和校验为准。

## 授权与来源
- 数据库结构和关系：ODbL 1.0（上游 LICENSE）
- Marble 原创文字：CC BY-SA 4.0（上游 LICENSE-CONTENT）
- 第三方课程标准：分别核对上游 PROVENANCE.md，不能直接当作 Marble 自有许可。
- 署名：Marble Skill Taxonomy (v1) · © Generative Spark, Inc. (Marble) · https://withmarble.com
- 扩展或公开分发时遵循署名、相同方式共享及第三方来源要求；不要假定私有仓库自动豁免后续发布义务。

## 建议结构
- upstream/：原版数据只读快照，保留 commit SHA、manifest 和许可证
- extensions/：本项目新增知识、0–12 岁分龄解释、粤语和英文、呈现策略
- mappings/：上游 topicId 与本项目知识节点 ID 对应
- generated/：由模板生成的卡片/动画元数据，不覆盖 upstream
- 大型媒体以后存 NAS；GitHub 只保存元数据、脚本及必要小文件

## 统一呈现规范（用户已确认）
- 根据知识类型选择卡片、对比动画、过程动画、身体内部探索等；不强制所有内容都写故事。
- 分龄影响默认呈现，不限制可探索知识；优先直接回答，按追问逐层深入。
- 正式知识卡片、动画、专题必须准备：粤语配音、粤语口语字幕、英文字幕、完整英文配音音频；两条音轨独立，字幕各自按时间轴同步。
- 即时问答默认粤语，可补英文关键词；不强制即时生成英文音轨。若升格为正式内容，再补齐四类资源。
- 科学准确性优先，拟人化/比喻不可误导真实机制。

## 引入步骤（待执行）
1. 在可联网的环境 clone 上游仓库，固定 commit SHA。
2. 核对 manifest.json 的各文件 SHA-256 和记录数量。
3. 核查许可证和 PROVENANCE.md，决定哪些第三方标准适合导入。
4. 将经核验的上游数据作为只读快照引入，单独保存本项目扩展。
5. 将上游知识节点映射到本项目统一模板，先抽样核验，再批量扩展。

本文件为阶段性记录，不是完整数据导入完成证明。
