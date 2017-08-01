# JAVA打印项目
## 项目简介
该项目是一个打印项目，现在后台管理配置好打印的一些配置后，即可进行打印
## 项目框架汇总
- Spring boot
- Maven来构建管理项目，
- Spring boot整合Mybatis作为ORM层框架
- Mysql数据库
- log4j日志
- redis
## 项目整体结构
- api-gateway 对外展示的接口，路由到不同的项目
- print-server 打印服务的主项目，进行打印
- common 存放整个项目中的公共代码块
- user-manager 打印服务后台的用户管理
## 安全
- 请求项目的接口的时候，必须携带Authorization请求头
## 返回结果
* 成功：{"code":200,"msg":"成功","data":返回的数据}
* 失败：{"code":400,"msg":"失败","data":错误信息}
* 未授权：{"code":403,"msg":"未授权","data":错误信息}
* code的数值请参照http状态码,例如404,401等等
## 公共的地址
- swagger-ui:http://localhost:port/swagger-ui.html (对外提供接口地址)
- druid:http://localhost:port/druid/login.html (数据源监控页面)
- monitor:http://localhost:port/metrics (详情：https://segmentfault.com/a/1190000004318360?_ea=568366，对项目进行监控)