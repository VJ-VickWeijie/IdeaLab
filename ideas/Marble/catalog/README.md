# Marble 中英对照总目录

[下载 Excel 总目录](Marble-Knowledge-Catalog-ZH-EN.xlsx)。在「知识总目录」的表头按学科或领域筛选，阅读知识点中文名称、简介及原文。目录沿用原版「学科 → 领域 → 知识点」层级和导航草稿的分组顺序。每行保留节点 ID、原版年龄范围及节点在 `topics.json` 中的一基序号。法语学科的 4 个节点保留法语原名，简介原文为英文。

## 翻译数据

- [首批译文](translations/batch-001.json)包含原有的 30 条。
- [续译数据](translations/batch-002.json)按稳定 ID 补齐 1,882 个节点的中文名称和简介。英文及法语原名由 [topics.json](../upstream/data/topics.json) 提供，Excel 逐行保存原文。
- 续译采用机器初译与分学科审校。Excel 的译文状态区分沿用首批、初译及已修订条目。审校关注术语、易误译的例子和表述。

校验发现两个节点的原文标题和简介涵盖的内容不同。目录按各字段的原文翻译。

- `mt_e8CZ7E5qW7` 标题是 `Number bonds to 9`，简介讲的是与 1 到 9 中的一个数凑成 10。
- `mt_doX1BhmFgk` 标题是 `Tenths (age 8+)`，简介讲的是按百分之一数数及其含义。

## 来源与授权

原作 Marble Skill Taxonomy (v1) · © Generative Spark, Inc. (Marble) · [withmarble.com](https://withmarble.com)。原版固定于 [withmarbleapp/os-taxonomy 的 `2926da3` 提交](https://github.com/withmarbleapp/os-taxonomy/tree/2926da338fc9db583c2bd1d241957e8b0fe1d4ce)。本目录改编包括知识点标题与简介的简体中文翻译、学科与领域中文标签和 Excel 表格编排。

目录数据依据 [ODbL 1.0](../upstream/LICENSE) 提供，原版文字及本目录的中文翻译依据 [CC BY-SA 4.0](../upstream/LICENSE-CONTENT) 提供。第三方课程标准的来源和许可单独见[上游来源说明](../upstream/PROVENANCE.md)。
