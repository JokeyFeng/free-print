# JAVA打印项目
## 项目简介
该项目是一个打印项目，手持和打印所处的机器需要在同一网段下才能正常工作。后台配置好IP地址后即可进行打印。

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
## 项目运行依赖资源
- Docker 17以上
- mysql
## 数据库表字段说明
## 改项目不调用任何数据库
## 该项目不提供给前端调用
