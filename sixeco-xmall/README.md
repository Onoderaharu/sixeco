 **精品后台管理系统是接私活利器，企业级快速开发框架**
 
**项目说明** 

- 采用SpringBoot、MyBatis、Shiro、mybaits-plus黄金搭档。
- 有单独的后台，还有单独的接口框架，可以实现前后端分离协作开发，还有火爆的商场功能模块，jwt
- 提供了超级代码生成器，可以生成验证注解，swagger-ui注解，多表分页查询sql,只需编写30%左右代码，其余的代码交给系统自动生成，可快速完成开发任务
- 支持MySQL、Oracle、SQL Server、PostgreSQL等主流数据库
- 支持j2cache 二级缓存
<br>

**具有如下特点** 
- 火爆的商场模块，后续会加入更多的商城模块
- 超级代码生成器，可直接生成到IDE中，eclipse和ij都可以
- 引入2Cache 是 OSChina 目前正在使用的两级缓存框架
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 完善的部门管理及数据权限，通过注解实现数据权限的控制
- 完善的XSS防范及脚本过滤，支持白名单过滤,彻底杜绝XSS攻击
- 支持分布式部署，session存储在redis中
- 友好的代码结构及注释，便于阅读及二次开发
- 引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
- 页面交互使用layui,vue.js，极大的提高了开发效率
- 引入swagger文档支持，方便编写API接口文档

<br>

 **项目结构** 

sixeco-xmall 此项目包含

|--xmall-admin 后台管理 <br>
|--xmall-api 移动端接口<br>
|--xmall-common 公共模块<br>
|--xmall-generator 代码生成<br>

<br> 

 **商城模块** 

频道列表： 可以理解为一级分类， 特殊的分类 底下可以不挂分类也可以挂视频，图片等等。

商品分类：有两级分类  商品可以修改二级分类 一级分类可以修改 因为一级分类绑定了规格而二级分类没有。

商品规格： 可以设置通用规格 也可以与一级分类绑定设置规格。商品规格可以重置 可以删除

商品基础功能全部完成。

会员管理

<br>

 **技术选型：** 
- 核心框架：Spring Boot
- 安全框架：Apache Shiro
- 视图框架：Spring MVC
- 持久层框架：MyBatis
- 定时器：Quartz 2.3
- 数据库连接池：Druid
- 日志管理：logback
- 页面交互：layui
- 下拉框：bootstrap-select
- 文件上传：Bootstrap File Input
- 热部署 jrebel
- 验证框架 hibernate-validator
- mybatis加强工具 mybatis-plus  文档 http://mp.baomidou.com/#/?id=%E7%AE%80%E4%BB%8B
- 通用工具类 hutool 文档 http://hutool.mydoc.io/
- j2cache  https://gitee.com/ld/J2Cache
<br> 

 **软件需求** 
- JDK1.8
- MySQL5.5+
- Tomcat8+
- Maven3.0+

<br>