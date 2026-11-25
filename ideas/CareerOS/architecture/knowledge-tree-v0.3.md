# CareerOS V0.3｜知识树与文件约定

> 本文为建设蓝图，不代表下列文章已完成。Work 需按覆盖矩阵逐项建设，禁止用空目录充数。

## 顶层导航
- `knowledge/MM/` 物料管理
- `knowledge/SD/` 销售分销
- `knowledge/PP/` 生产计划
- `knowledge/QM/` 质量管理
- `knowledge/FI/` 财务会计（从零开始）
- `knowledge/CO/` 管理会计（从零开始）
- `knowledge/ABAP/` ABAP、Debug、增强、接口
- `knowledge/S4HANA/` CDS、RAP、HANA、Clean Core、架构
- `knowledge/AI-Integration/` SAP × AI 的合规架构与验证
- `business-processes/` 所有完整端到端流程，单模块与跨模块统一收录
- `learning/` 课程、推荐阅读、可选练习、原有 24 个月路线
- `reviews/` Work 与三角色审查、问答、修订及验收证据
- `plans/` 范围、覆盖矩阵、进度及阶段计划

## 模块目录的统一子结构
每个 `knowledge/<MODULE>/` 均设置：
- `01-foundations/` 基础概念、术语、业务背景
- `02-functions/` 功能机制、对象、业务规则
- `03-tcodes/` T-Code：用途、前置条件、查看/操作权限、输入输出、关联单据
- `04-configuration/` IMG 配置与只读查看路径、控制逻辑、风险
- `05-data-model/` 数据表、字段、关系、S/4HANA 差异
- `README.md` 模块导航、学习顺序、业务流程交叉链接

配置独立存放；配置事务码同时进入 T-Code 索引，通过相对链接指向唯一权威文章。

## 业务流程目录
- `business-processes/P2P/` 采购到付款
- `business-processes/O2C/` 订单到收款
- `business-processes/STO-Intercompany/` 同公司/跨公司调拨、跨公司销售与结算的区别
- `business-processes/Plan-to-Produce/` 计划到生产
- `business-processes/Quality-to-Release/` 来料检验到放行
- `business-processes/R2R/` 记录到报告
- `business-processes/Special-Scenarios/` 委外、寄售、退货、发票差异等

每条完整流程只保留一篇主文章；模块目录引用主文章，模块内补充特定功能，不复制流程全文。

## 单篇文章强制结构
1. 面向零基础读者的直观解释与适用前提
2. 企业为什么需要此业务、业务角色与真实但虚构的案例
3. 中英术语表与易混淆概念
4. 完整流程：角色、事件、单据流、物流、价值/资金流
5. SAP S/4HANA 2021 的实现、模块边界、T-Code、数据表、配置查看
6. 会计影响与前提条件（如适用）
7. 例外、错误、边界、版本与配置差异
8. 关联文章、公开依据、验证方式与权限标签
9. 状态：planned / drafting / reviewed / accepted；审核记录链接

## 首批必覆盖的主题（非全部范围）
MM：组织结构、主数据、采购、库存、移动类型、GR/IR。
QM：检验类型、检验批、检验结果、使用决策、库存联动。
SD：销售组织、订单、交货、开票、应收集成。
PP：BOM、工作中心、Routing、MRP、生产订单、发料与入库。
FI：借贷、会计等式、总账、应收应付、凭证、库存估价、GR/IR、关账。
CO：成本中心、成本要素、内部订单、产品成本、获利分析。
技术：ABAP、BAPI、Debug、增强、CDS、RAP、OData、HANA 性能、接口治理。
业务：P2P、O2C、STO/跨公司、生产、质量、R2R、特殊采购。
课程：零基础 FI/CO、MM/QM 深化、跨模块集成、技术架构、SAP×AI。

Work 应先制定细粒度覆盖矩阵，列出每篇计划文章、优先级、状态、来源与审查结果；不得仅凭本清单声称知识库已完整。
