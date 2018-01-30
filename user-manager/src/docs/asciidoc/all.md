# JAVA打印用户服务RESTful APIs


<a name="overview"></a>
## Overview
任何疑问请联系：QQ：1134991001


### Version information
*Version* : 1.0


### Contact information
*Contact* : 陈静（仓储）  
*Contact Email* : chenjing@banggood.com


### URI scheme
*Host* : localhost:9001  
*BasePath* : /


### Tags

* 仓库 : Storage Controller
* 仓库移动打印服务调用接口访问数据库 : Dao Controller
* 手持IP配置 : Print Config Controller
* 打印类型 : Print Type Controller
* 用户 : User Controller




<a name="paths"></a>
## Paths

<a name="insertusingpost"></a>
### 插入渠道配置打印方法
```
POST /db/channel
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Body**|**channelConfig**  <br>*required*|channelConfig|[ChannelConfig](#channelconfig)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 仓库移动打印服务调用接口访问数据库


<a name="reflectusingget"></a>
### 根据渠道名称获取渠道的打印方法
```
GET /db/channel
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Query**|**channelName**  <br>*required*|channelName|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 仓库移动打印服务调用接口访问数据库


<a name="getuserusingget"></a>
### 根据用户id获取用户信息
```
GET /db/users/{id}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Path**|**id**  <br>*required*|id|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 仓库移动打印服务调用接口访问数据库


<a name="getipusingget"></a>
### 根据用户id获取用户信息
```
GET /db/users/{id}/ip
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Path**|**id**  <br>*required*|id|string|
|**Query**|**printType**  <br>*required*|printType|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 仓库移动打印服务调用接口访问数据库


<a name="postusingpost"></a>
### 插入手持的IP配置信息
```
POST /print/config
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Body**|**printConfig**  <br>*required*|printConfig|[PrintConfig](#printconfig)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 手持IP配置


<a name="putusingput"></a>
### 修改手持的IP配置信息
```
PUT /print/config
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Body**|**printConfig**  <br>*required*|printConfig|[PrintConfig](#printconfig)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 手持IP配置


<a name="deletebyidsusingdelete"></a>
### 删除手持IP配置的信息
```
DELETE /print/config
```


#### Description
批量删除手持IP配置的信息,多个id用英文逗号分隔


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Body**|**ids**  <br>*required*|ids|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 手持IP配置


<a name="listusingget"></a>
### 获取手持的IP配置信息
```
GET /print/config/list
```


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string||
|**Query**|**limit**  <br>*optional*|limit|integer (int32)|`10`|
|**Query**|**pageNum**  <br>*optional*|pageNum|integer (int32)|`1`|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 手持IP配置


<a name="searchbyconditionusingget"></a>
### 根据条件搜索手持IP配置的信息
```
GET /print/config/search
```


#### Description
根据传入条件来进行搜索


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string||
|**Query**|**limit**  <br>*optional*|limit|integer (int32)|`10`|
|**Query**|**operateId**  <br>*optional*|operateId|string||
|**Query**|**pageNum**  <br>*optional*|pageNum|integer (int32)|`1`|
|**Query**|**warehouseId**  <br>*optional*|warehouseId|integer (int32)||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 手持IP配置


<a name="deletebyidusingdelete"></a>
### 删除手持IP配置的信息
```
DELETE /print/config/{id}
```


#### Description
根据id删除手持IP配置的信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Path**|**id**  <br>*required*|id|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 手持IP配置


<a name="insertusingpost_1"></a>
### 新增打印类型
```
POST /printtype
```


#### Description
传入json对象进行新增操作


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Body**|**printType**  <br>*required*|printType|[PrintType](#printtype)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="insertusingget_1"></a>
### 获取所有的打印机类型
```
GET /printtypes
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Query**|**limit**  <br>*optional*|limit|string|
|**Query**|**pageNum**  <br>*optional*|pageNum|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="busingdelete"></a>
### 删除打印机类型
```
DELETE /printtypes
```


#### Description
批量删除打印机类型，多个id用逗号分隔


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Body**|**ids**  <br>*required*|ids|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="ausingget"></a>
### 判断是否重复
```
GET /printtypes/repeat
```


#### Description
根据打印类型名称判断是否重复


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Query**|**printTypeName**  <br>*required*|printTypeName|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="insertusingget"></a>
### 根据名称查询打印机类型
```
GET /printtypes/search
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Query**|**limit**  <br>*optional*|limit|string|
|**Query**|**name**  <br>*required*|name|string|
|**Query**|**pageNum**  <br>*optional*|pageNum|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="putusingput_1"></a>
### 修改打印机类型
```
PUT /printtypes/{id}
```


#### Description
根据id修改打印机类型，传入json对象


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Path**|**id**  <br>*required*|id|string|
|**Body**|**printType**  <br>*required*|printType|[PrintType](#printtype)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="delusingdelete"></a>
### 删除打印机类型
```
DELETE /printtypes/{id}
```


#### Description
根据id删除打印机类型


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string|
|**Path**|**id**  <br>*required*|id|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 打印类型


<a name="searchusingget"></a>
### 根据仓库名进行搜索
```
GET /storage/search
```


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string||
|**Query**|**limit**  <br>*optional*|limit|integer (int32)|`10`|
|**Query**|**pageNum**  <br>*optional*|pageNum|integer (int32)|`1`|
|**Query**|**storageName**  <br>*required*|storageName|string||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 仓库


<a name="getusingget"></a>
### 获取所有的仓库
```
GET /storages
```


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string||
|**Query**|**limit**  <br>*optional*|limit|integer (int32)|`10`|
|**Query**|**pageNum**  <br>*optional*|pageNum|integer (int32)|`1`|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 仓库


<a name="searchusingget_1"></a>
### 根据用户名进行搜索
```
GET /user/search
```


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string||
|**Query**|**limit**  <br>*optional*|limit|integer (int32)|`10`|
|**Query**|**pageNum**  <br>*optional*|pageNum|integer (int32)|`1`|
|**Query**|**userName**  <br>*required*|userName|string||


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 用户


<a name="getusingget_1"></a>
### 获取所有的用户
```
GET /users
```


#### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Header**|**authorization**  <br>*required*|app secret|string||
|**Query**|**limit**  <br>*optional*|limit|integer (int32)|`10`|
|**Query**|**pageNum**  <br>*optional*|pageNum|integer (int32)|`1`|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* 用户




<a name="definitions"></a>
## Definitions

<a name="channelconfig"></a>
### ChannelConfig

|Name|Schema|
|---|---|
|**clazz**  <br>*optional*|string|
|**createTime**  <br>*optional*|string (date-time)|
|**creator**  <br>*optional*|string|
|**delTime**  <br>*optional*|string (date-time)|
|**deletor**  <br>*optional*|string|
|**id**  <br>*optional*|integer (int32)|
|**isDelete**  <br>*optional*|boolean|
|**method**  <br>*optional*|string|
|**name**  <br>*optional*|string|
|**updateTime**  <br>*optional*|string (date-time)|
|**updator**  <br>*optional*|string|


<a name="printconfig"></a>
### PrintConfig

|Name|Schema|
|---|---|
|**createDate**  <br>*optional*|string (date-time)|
|**createUserId**  <br>*optional*|integer (int32)|
|**deleteDate**  <br>*optional*|string (date-time)|
|**deleteUserid**  <br>*optional*|integer (int32)|
|**isDeleted**  <br>*optional*|boolean|
|**isEnable**  <br>*optional*|boolean|
|**machineIp**  <br>*optional*|string|
|**machinePort**  <br>*optional*|integer (int32)|
|**modifyDate**  <br>*optional*|string (date-time)|
|**modifyUserId**  <br>*optional*|integer (int32)|
|**operateUserId**  <br>*optional*|integer (int32)|
|**printConfigId**  <br>*optional*|integer (int32)|
|**printTypeId**  <br>*optional*|integer (int32)|
|**storageId**  <br>*optional*|integer (int32)|


<a name="printtype"></a>
### PrintType

|Name|Schema|
|---|---|
|**createTime**  <br>*optional*|string (date-time)|
|**creator**  <br>*optional*|string|
|**delTime**  <br>*optional*|string (date-time)|
|**deletor**  <br>*optional*|string|
|**id**  <br>*optional*|integer (int32)|
|**isDelete**  <br>*optional*|boolean|
|**typeName**  <br>*optional*|string|
|**updateTime**  <br>*optional*|string (date-time)|
|**updator**  <br>*optional*|string|


<a name="result"></a>
### Result

|Name|Schema|
|---|---|
|**code**  <br>*optional*|integer (int32)|
|**data**  <br>*optional*|object|
|**msg**  <br>*optional*|string|





