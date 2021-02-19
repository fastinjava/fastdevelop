# sge数据库信息

## 1.微应用信息 B_APP_MAPP_DET

| MAPP_ID       |                                                              |      |
| ------------- | ------------------------------------------------------------ | ---- |
| MAPP_GROUP_ID | 本实体唯一标识                                               |      |
| MAPP_NO       | 对微应用进行编号管理，编号规则：Mxxxxxx                      |      |
| MAPP_NAME     | 微应用名称                                                   |      |
| MAPP_MODE     | 标准代码microappmode（10105），编码如下：<br/>01 Web<br/>02 Native<br/>03 Wgt' |      |
| DEVELOP_UNIT  | 开发单位                                                     |      |
| MAPP_STATUS   | '标准代码appstate（10125），编码如下：<br/>01 未发布<br/>02 已发布' |      |
| MAPP_REMARK   | 微应用说明                                                   |      |
| USER_ID       | 取ISC的用户标识                                              |      |
| CREATE_TIME   | 创建时间                                                     |      |
| MODIFY_TIME   | 更新时间                                                     |      |
| MAPP_TYPE     | '01 工单类微应用<br/>02 工具类微应用<br/>03 兼容型'          |      |
| MAPP_SORT     | 微应用排序                                                   |      |



```
create table B_APP_MAPP_DET
(
  MAPP_ID       VARCHAR2(64) not null   primary key,
  MAPP_GROUP_ID VARCHAR2(64),
  MAPP_NO       VARCHAR2(16),
  MAPP_NAME     VARCHAR2(64),
  MAPP_MODE     VARCHAR2(8),
  DEVELOP_UNIT  VARCHAR2(100),
  MAPP_STATUS   VARCHAR2(6),
  MAPP_REMARK   VARCHAR2(200),
  USER_ID       VARCHAR2(32),
  CREATE_TIME   DATE,
  MODIFY_TIME   DATE,
  MAPP_TYPE     VARCHAR2(8),
  MAPP_SORT     NUMBER(2)
)
;
```


## 2.微应用分组的信息



| MAPP_GROUP_ID     | 本实体唯一标识                             |      |
| ----------------- | ------------------------------------------ | ---- |
| MAPP_PARENT_ID    | 级应用组标识 最上级 -1                     |      |
| MAPP_GROUP_NO     | 对应用组进行编号,编码规则:Gxxxxx，编码唯一 |      |
| MAPP_GROUP_NAME   | 应用组名称                                 |      |
| MAPP_GROUP_SORT   | 应用组排序号                               |      |
| MAPP_GROUP_REMARK | 应用组说明                                 |      |
| USER_ID           | 取ISC的用户标识                            |      |
| CREATE_TIME       | 创建时间                                   |      |
| MODIFY_TIME       | 修改时间                                   |      |





```sql
create table B_APP_MAPP_GRP_DET
(
  MAPP_GROUP_ID     VARCHAR2(64) not null    primary key,
  MAPP_PARENT_ID    VARCHAR2(64),
  MAPP_GROUP_NO     VARCHAR2(16) not null,
  MAPP_GROUP_NAME   VARCHAR2(64),
  MAPP_GROUP_SORT   NUMBER(2),
  MAPP_GROUP_REMARK VARCHAR2(200),
  USER_ID           VARCHAR2(32),
  CREATE_TIME       DATE,
  MODIFY_TIME       DATE
)
;
```

## 3. 角色、微应用关系表



| ROLE_ID | 引用角色表的主键     |      |
| ------- | -------------------- | ---- |
| MAPP_ID | 引用微应用信息的主键 |      |
|         |                      |      |
|         |                      |      |
|         |                      |      |
|         |                      |      |
|         |                      |      |
|         |                      |      |
|         |                      |      |





```
create table B_APP_MAPP_ROLE_RELA
(
  ROLE_ID VARCHAR2(64) not null,
  MAPP_ID VARCHAR2(64) not null,
  constraint PK_B_APP_MAPP_ROLE_RELA
  primary key (ROLE_ID, MAPP_ID)
)
;
```

## 4.批量上传用户文件信息表



| BATCH_ID         | 批量主键id                                         |      |
| ---------------- | -------------------------------------------------- | ---- |
| BATCH_FILE_ID    | 文件ID                                             |      |
| CREATE_USER_ID   | 创建人                                             |      |
| CREATE_USER_NAME | 创建人名                                           |      |
| CREATE_TIME      | 创建时间                                           |      |
| UPDATE_USER_ID   | 变更人                                             |      |
| UPDATE_USER_NAME | 变更人名称                                         |      |
| UPDATE_TIME      | 变更时间                                           |      |
| RELECE_TIME      | 同步时间                                           |      |
| FORMAT_COUNT     | 格式错误数量                                       |      |
| REPEAT_COUNT     | 重复数量                                           |      |
| NOT_DATA_COUNT   | 数据错误数量                                       |      |
| SUC_DATA_COUNT   | 上传成功数量                                       |      |
| ALL_COUNT        | 共上传数量                                         |      |
| DEFEATED_COUNT   | 失败数量                                           |      |
| RUNSTATS         | 同步状态 ：-1 未同步，0 同步中，1 已同步,2同步失败 |      |
| FILE_TYPE        | 文件类型：0.专属客户经理 1.专属客户经理台区关系    |      |
|                  |                                                    |      |
|                  |                                                    |      |





```sql
create table B_BATCH_FILE_USER_DET
(
  BATCH_ID         VARCHAR2(64) not null    primary key,
  BATCH_FILE_ID    VARCHAR2(64),
  CREATE_USER_ID   VARCHAR2(64),
  CREATE_USER_NAME VARCHAR2(64),
  CREATE_TIME      TIMESTAMP(6),
  UPDATE_USER_ID   VARCHAR2(64),
  UPDATE_USER_NAME VARCHAR2(64),
  UPDATE_TIME      TIMESTAMP(6),
  RELECE_TIME      TIMESTAMP(6),
  FORMAT_COUNT     VARCHAR2(32),
  REPEAT_COUNT     VARCHAR2(32),
  NOT_DATA_COUNT   VARCHAR2(32),
  SUC_DATA_COUNT   VARCHAR2(32),
  ALL_COUNT        VARCHAR2(32),
  DEFEATED_COUNT   VARCHAR2(32),
  RUNSTATS         VARCHAR2(2),
  FILE_TYPE        VARCHAR2(2)
)
;
```



## 5.基于业务的角色



| ROLE_ID          | 本实体唯一主键   |      |
| ---------------- | ---------------- | ---- |
| ROLE_NO          | 角色编号         |      |
| ROLE_NAME        | 角色名称         |      |
| ROLE_DESCRIPTION | 角色描述         |      |
| CRT_DATE         | 产生此记录的时间 |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |
|                  |                  |      |



```sql
create table B_BE_PRIV_ROLE_DET
(
  ROLE_ID          VARCHAR2(64) not null
    primary key,
  ROLE_NO          VARCHAR2(16) not null,
  ROLE_NAME        VARCHAR2(32),
  ROLE_DESCRIPTION VARCHAR2(64),
  CRT_DATE         DATE,
  DEFAULT_ROLE     VARCHAR2(8)
)
;
```

## 6.用户角色关系表，给用户分配角色



```sql
create table B_BE_PRIV_ROLE_USER_RELA
(
  ROLE_ID VARCHAR2(64) not null, //角色id
  USER_ID VARCHAR2(64) not null,//用户id
  constraint PK_B_BE_PRIV_ROLE_USER_RELA
  primary key (ROLE_ID, USER_ID)
)
;
```

