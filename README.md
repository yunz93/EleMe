# 网上订餐系统的设计与实现

## 一、系统结构与需求分析

很明显，订餐系统应当分为前台和后台两部分。

前台为客户端，客户需要先登录或注册，然后选择自己喜欢的食物加入购物车，然后进入购物车管理所选菜品，提交订单并付款。

后台为管理员登录后台可以对菜品信息以及订单信息进行管理和查询。对比饿了么之类的外卖网站，这里应当是商家对自己店铺的管理功能，而网站后台则应该提供对商家的管理功能。

作为一个练手的demo，我不想做的过于复杂，后面反而实现不了，这里的后台就简单一点了==。

因此简单罗列一下各部分的功能：

![](网上订餐系统的设计与实现/系统设计.png)

## 二、数据库设计

数据库设计是整个系统设计的重中之重，如果前期数据库设计不合理，后期项目实现起来可能会有很大的问题。

这里我们根据对系统设计的分析，确定了6张表。

- 用户信息表（users）
- 管理员信息表（admin）
- 菜品分类表（mealseries）
- 菜品信息表（meal）
- 订单主表（orders）
- 订单子表（orderdts）

### 用户信息表（users）

| 字段        | 类型          | 说明         |
| --------- | ----------- | ---------- |
| Id        | int(4)      | 用户编号，主键，自增 |
| LoginName | varchar(20) | 登录名        |
| LoginPwd  | varchar(20) | 密码         |
| TrueName  | varchar(20) | 真实姓名       |
| Email     | varchar(20) | 邮箱         |
| Phone     | varchar(20) | 联系电话       |
| Address   | varchar(50) | 送货地址       |

### 管理员信息表（admin）

|           |             |       |
| --------- | ----------- | ----- |
| Id        | int(4)      | 主键，自增 |
| LoginName | varchar(20) | 登录名   |
| LoginPwd  | varchar(20) | 密码    |

### 菜品种类（mealseries）

|            |             |      |
| ---------- | ----------- | ---- |
| SeriesId   | int(4)      | 序号   |
| SeriesName | varchar(10) | 名称   |

### 菜品信息表

|                 |              |                                   |
| --------------- | ------------ | --------------------------------- |
| MealId          | int(4)       | 序号，主键，自增                          |
| MealSeriesId    | int(4)       | 所属菜系，外键，与mealseries表中SeriesId字段关联 |
| MealName        | varchar(20)  | 菜名                                |
| MealSummarize   | varchar(250) | 摘要                                |
| MealDescription | varchar(250) | 详细介绍                              |
| MealPrice       | decimal(8,2) | 价格                                |
| MealImage       | varchar(20)  | 图片文件名                             |

### 订单主表

|            |              |                    |
| ---------- | ------------ | ------------------ |
| OId        | int(4)       | 序号，主键，自增           |
| UserId     | int(4)       | 订单用户编号与user表Id字段关联 |
| OrderTime  | datetime     | 订单产生的时间            |
| OrderState | varchar(20)  | 订单状态               |
| OrderPrice | decimal(8,2) | 订单合计               |

### 订单子表

|           |              |                       |
| --------- | ------------ | --------------------- |
| ODId      | int(4)       | 略                     |
| OID       | int(4)       | 所属订单编号，与order表OId字段关联 |
| MealId    | int(4)       | 餐品编号，与meal表MealId字段关联 |
| MealPrice | decimal(8,2) | 餐品单价                  |
| MealCount | int(4)       | 餐品数量                  |

根据表项之间相关联的情况来看，不算特别复杂，没有一对多和多对多的情况。但如果有很多家店铺，就应当有更复杂的对应关系了，但这还是以后有可能再考虑吧。

## 三、项目结构

本项目中，纯粹出于练习的目的，我们在这里使用Maven + Struts2 + Hibernate + Spring的框架集合来实现。虽然按理说这么简单的项目完全用不着使用框架。==

项目结构如图：

![](网上订餐系统的设计与实现/项目结构.png)

| package               | function  |
| --------------------- | --------- |
| com.eleme.pojo        | 存放实体类     |
| com.eleme.dao         | 数据访问层     |
| com.eleme.biz         | 业务逻辑层     |
| com.eleme.action      | 存放action类 |
| com.eleme.filter      | 存放过滤器类    |
| com.eleme.interceptor | 存放拦截器类    |

ok，前期工作完成。

项目地址：https://github.com/yunz93/EleMe，欢迎关注。
