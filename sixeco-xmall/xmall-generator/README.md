**项目介绍** 
- 精品后台管理系统的超级代码生成器，可直接生成四种实体类，controller、service、dao、xml代码到eclipse或ij，并支持多表连接，支持mybatis-plus 减少70%以上的开发任务
- 目前只支持MySQL、下个版本计划支持oracle,并支持最新版mybatis-plus 3.0
<br>

**加强特点** 
- mapper文件可生成多表连接
- 实体类默认引入swagger-ui 的注解。
- 实体类默认引入日期类格式化 的注解。
- 实体类默认引入hibernate-validator的注解
- 操作特别简单，能灵活生成到主流ide里面
- 灵活的权限控制，可控制到页面或按钮
- 灵活的接口开发，满足绝大部分的前后端分离
- 友好的代码结构及注释，便于阅读及二次开发

<br>

**实体类设计思想** 
- entity 是数据库层do，通用操作实体类（普通增删改查）

- model  接收传参的实体类  取自ModelAndView 的model名称
     	   实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
- vo     返回的视图类  主要是手机端接口返回的实体类 
	          （主要作用去除一些不必要的字段） 

- view  后端返回视图实体辅助类   
                 （通常后端关联的表或者自定义的字段需要返回使用）
<br> 

7.浏览器输入http://127.0.0.1:8082/freeter-generator
<br>
<br>

 **软件需求** 
- JDK1.8
- MySQL5+
- Tomcat8+
- Maven3.0+

需要引入
			hibernate-validator
			<artifactId>hutool-all</artifactId>
			<artifactId>commons-beanutils</artifactId>
			<artifactId>springfox-swagger-ui</artifactId>
<br>

