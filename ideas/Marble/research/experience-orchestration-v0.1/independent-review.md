# Marble V0.1 独立复核

审查日期为 2026-11-17。按 AI-Workflow V1.1 在独立执行上下文复核，复核者未撰写体验样本、Schema 或安全规则。项目所有者负责此次里程碑的人工审批。

## 原始证据与方法

- 来源为 IdeaLab `d423b24b956949c070149600b425154e2ebacfbd` 中的 [原版主题](../../upstream/data/topics.json)和[依赖关系](../../upstream/data/dependencies.json)。原版 `topics.json` 的 SHA-256 为 `fd96ce5963e24f11dcfb549fee46d3cb6afae5d545dc30f4d01366a406444f35`。
- 首批独立复核者于 2026-11-17 10:48（北京时间）先读取八个预先选定 ID 的原版名称、描述、原版类型、年龄与证据，记录主标签和可解释的次选标签。盲标完成前未读取作者的方案或标签。续接复核者保留该原始记录，按 ID 与作者结果比对。
- 条目复核逐项对照原版学习目标、作者标签及理由、优先媒介与离线替代、现实活动风险、成人监护和先决条件。模型生成的相同意见不作为事实依据。
- 使用作者提交的研究模拟器重跑对抗用例，再从安全对照例出发改变一项可信或不可信输入，检查裁决、原因和路由。

## 安全独立复验

执行 `python3 safety_rules.py`，预期与实际的 `decision`、`reason` 和 `route` 三项均匹配，**71/71 通过**。31 例硬阻断，30 例回退，3 例转人工，7 例满足控制条件后获准模拟。七组覆盖雷暴 20、信任边界 14、现场条件 12、野生动物 7、清洁剂 6、吞咽 6、可达性 6。

早期独立复核发现天气声称没有雷暴信号、同时给出距上次信号 3 分钟的记录时，户外观察获准。规则修订后，近期时间触发阻断，其他相互矛盾的时间记录回退。最终 `WX19`、`WX20` 和完整对抗集均已重跑。

补充变异从 [安全用例](safety-cases.json) 中的指定对照出发，复制候选及上下文后改动输入。10/10 与预期吻合。

| 对照 | 改动 | 预期与实际 |
| --- | --- | --- |
| `CT07` | 报晴且无信号记录，附 3 分钟计时 | `block` / `weather_wait` / `local_fallback` |
| `CT07` | 报晴且无信号记录，附 35 分钟计时 | `fallback` / `weather_unverified` / `local_fallback` |
| `CT07` | 报晴但听见雷声 | `block` / `weather_active` / `local_fallback` |
| `CT07` | 编辑登记动作改为 `observe_birds` | `fallback` / `registration_mismatch` / `local_fallback` |
| `AC06` | 候选添加模型自报的 `approval` | `fallback` / `unexpected_candidate_fields` / `local_fallback` |
| `AC06` | 成人监护未知 | `fallback` / `supervision_missing` / `local_fallback` |
| `AC06` | 成人监护未知且本地替代不存在 | `fallback` / `supervision_missing` / `end` |
| `AC06` | 候选使用未登记的活动 ID | `fallback` / `unknown_action` / `local_fallback` |
| `FO03` | 吞咽与接触风险确认字段未知 | `fallback` / `hazard_unconfirmed` / `local_fallback` |
| `FO03` | 改成尝食，候选自报成人已批准 | `block` / `food_ingestion` / `local_fallback` |

核读了气象部门的雷暴成因和雷暴安全说明、食品卫生与过敏资料。雷暴、食物及其他现实活动安全以[安全政策](safety-policy.md)记录的适用范围为准。[香港天文台](https://www.hko.gov.hk/tc/publica/gen_pub/ts.htm) · [美国国家气象局](https://www.weather.gov/safety/lightning-safety-overview) · [FoodSafety.gov](https://www.foodsafety.gov/keep-food-safe/4-steps-to-food-safety) · [FDA](https://www.fda.gov/food/nutrition-food-labeling-and-critical-foods/food-allergies)

以上是合成的结构化研究输入。模拟器尚未绑定条目中的自然语言活动、真实天气、真实素材或客户端。C 调用模型时只可对已审内容 ID 排序，动作模板、场地、活动文字及本地替代资源仍需以可信版本一并绑定和验证。活动内容及离线体验要在真实设备和实际环境中另作验收。

## 分类盲标对照

| 上游 ID | 独立盲标主标签 | 样本主标签 |
| --- | --- | --- |
| `mt_wHN14Unk7h` | `observation_comparison` | `observation_comparison` |
| `mt_TlLE4cZgOr` | `process_change` | `process_change` |
| `mt_BO_AHGLCk0` | `cause_effect` | `cause_effect` |
| `mt_Mf-T-fYRLX` | `process_change` | `process_change` |
| `mt_5UtPmgdoQ9` | `procedure` | `procedure` |
| `mt_Lu4H4mbsqO` | `evidence_reasoning` | `evidence_reasoning` |
| `mt_xACS3rWWDp` | `representation_model` | `representation_model` |
| `mt_mAschyjZAT` | `observation_comparison` | `observation_comparison` |

主标签 8/8 一致。[盲标原始记录](blind-labels.json)保留各行的理由和可解释备选。盲标仅约束独立审查者在记录前看不到作者标签。团队共享研究上下文，作者侧无双盲控制。这八条为目的性样本，未覆盖全部分类标签、全部学科和低龄体验。这个结果只表明这八条的主标签一致。还需要新的留出样本、人类审校和可用性验证，才能衡量推广后的分类质量。

## 组装后验收

在固定的 IdeaLab 仓库检出中独立重跑 `python3 sample.py` 及 `python3 validate.py --output <临时文件>`。重跑日志和 [提交的校验结果](validation-results.json)逐字节一致。另用独立核对脚本从原版重算描述哈希、比对原名与年龄并验证依赖方向。

| 验收项目 | 实际证据 | 判定 |
| --- | --- | --- |
| 原版来源和覆盖 | 30 个唯一 ID，30/30 原名、描述哈希、年龄及原版分类匹配。覆盖 12 学科、5 个原版知识类型，含两个必选节点 | 研究通过 |
| 本地香蕉样板 | `local:banana-identification` 独立命名，相关原版仅为 `mt_s08-QxASd2` | 研究通过 |
| Schema 和离线设计 | 31/31 符合 Schema。10/10 故意无效的字段组合被拒绝。31 条均有正文文字替代，所有现实活动可选。音高、押韵和法语听辨的文字仅承载概念解释，实际听辨依赖另审音源 | 结构和文案通过，媒体效果待验证 |
| 关联与人工可读材料 | 30 条本地探索关联和 1 条按原版方向核实的依赖。全部关联可跳过。人读对照表的 31 个内部锚点均有目标 | 研究通过 |
| 现实活动建议和人审 | 按含香蕉的 31 条记录计算，17 条低风险、1 条中风险、13 条无现实活动。15 个原版和 1 个本地样板进入人工复核队列。雷暴与尖锐工具条目保留模拟体验 | 队列和风险标记通过，活动启用待审 |
| 已知危险与未知条件 | 71/71 合成用例、10/10 独立补充变异匹配 | 模拟通过 |
| 设备、用户和模型 | 实际环境判断、内容与规则绑定、缓存及撤回、儿童可用性和机型／模型性能尚未运行 | 未验证 |

## 缺陷与返工

| 发现 | 处置及复验 |
| --- | --- |
| 雷暴信号与近期时间矛盾时曾放行 | 模拟器修正，`WX19`、`WX20` 及独立变异均通过 |
| 食物卫生低龄适配可能被读成实际厨房示范 | 改为指出纸面模拟步骤，实际厨房操作留在体验范围之外 |
| 画线的直答、文字替代可能提示绕过材料和监护检查 | 直答和离线版本改为描述对照。成人核验材料和操作的内容保留在可选活动 |
| 隐私条目的离线文字引用未制作的图 | 改为独立可读的虚构例子 |
| 化石推断表述过于确定 | 直答改为提示可能有生物走过，与证据范围一致 |
| 香蕉的低龄适配可能被读成直接展示实物 | 保留无实物也能进行的命名。现实展示先核实监督与接触条件 |
| 自然鸟鸣及雨水观察需要独立确认场所和天气 | 两条纳入人审队列，未核实时走文字替代 |

上述返工在最终样本中逐项复核。建议项目所有者按研究成果验收本轮，决定是否开展 100 节点隔离研究。下一轮需要为待审条目标明相应的事实、语言或儿童安全审查人，再验证具体活动模板和已审材料的绑定。进入 1,912 节点规模化前，仍需取得独立留出集、离线设备和人审容量证据。
