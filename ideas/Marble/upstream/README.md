# Marble 上游知识库（只读快照）

来源：https://github.com/withmarbleapp/os-taxonomy

## 导入状态

**已导入。** 七个主要知识 JSON 已通过手动 GitHub Actions 工作流复制到 `data/`，工作流根据上游 `manifest.json` 对每个文件执行字节数及 SHA-256 校验后，才创建审核用 Pull Request；该 PR 已合并到 IdeaLab 的 `main` 分支。

- 上游固定版本：`2926da338fc9db583c2bd1d241957e8b0fe1d4ce`（见 `UPSTREAM_COMMIT.txt`）
- 数据清单：`manifest.json`（其 `generatedAt` 为 `2026-11-02T21:58:14.606Z`，是数据生成时间，不是本仓库导入时间）
- 校验依据：`manifest.json` 中每个文件的 `bytes` 和 `sha256`
- 导入工作流：`.github/workflows/marble-upstream-import.yml`（手动触发，创建 PR，不直接修改主分支）
- 当前为**固定版本快照**，不是持续自动同步的镜像；重新运行工作流可能导入新版上游数据，需再次审核

## 数据文件

`data/` 内已导入七个主要 JSON：

1. `topics.json`
2. `dependencies.json`
3. `curriculum-standards.json`
4. `clusters.json`
5. `teaching-research.json`
6. `archived-teaching-research.json`
7. `curriculum-alignments.json`

原版清单记载 1,912 个 topics、4,002 条 dependencies；这些是**该上游快照**的数据规模，不代表已完成本项目的分龄改写、粤语本地化或媒体素材制作。

## 授权及来源

- `LICENSE`：Open Database License (ODbL 1.0)
- `LICENSE-CONTENT`：Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)
- `PROVENANCE.md`：第三方课程标准及内容来源说明

原项目：Marble Skill Taxonomy (v1) · © Generative Spark, Inc. (Marble) · https://withmarble.com

**重要：** 第三方课程标准不应自动视作与 Marble 原创数据采用同一许可证。任何进一步改编、发布或再分发，均应根据 `PROVENANCE.md` 和对应许可条款核查署名及共享要求。

## 使用约定与后续工作

- `upstream/` 保持只读原版快照，不直接编辑原始知识节点 ID、依赖关系或授权文件。
- 本项目自有的分龄解释、粤英双语文案、知识关联及卡片/动画设计，放在相邻的 `../extensions/` 中，以稳定 ID 建立映射。
- **仍待完成：** 统一扩展 Schema、上游节点映射、分龄内容制作、事实核查和媒体生成；这些不属于原版数据导入的完成范围。
