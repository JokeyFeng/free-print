# JAVA打印项目
## 项目简介
该项目是一个打印项目，手持和打印所处的机器需要在同一网段下才能正常工作。后台配置好IP地址后即可进行打印。
## free-print使用的技术框架以及工具
- **Spring boot**
- **Druid**:数据库连接池
- **Mybatis**:ORM框架
- **Docker**：容器技术
- **Jenkins**:项目构建部署，自动化工具
## 项目整体结构
- print-server 打印服务的主项目，进行打印
- common 存放整个项目中的公共代码块
- user-manager 打印服务后台的用户管理（暂时弃用）
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
- monitor:http://localhost:port/metrics  (项目运行时的各种指标)
## 配置文件
* hz 杭州
* gz 广州
* hzgl 杭州瓜沥
* us 美仓加州
* us2 美仓新泽西
## 项目运行依赖资源
- Docker 17以上
- mysql
## 数据库表字段说明
## 改项目不调用任何数据库
## 该项目不提供给前端调用
