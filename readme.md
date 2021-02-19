# 如何发布

## 概述

1、首先发布fastdevelop_web

2、fastdevelop_biz_web

##fastdevelop_web

1、指定激活配置文件application.yml

```yaml
spring:
  profiles:
    active: prod #这里改成发布的环境
```

2、配置发布环境
application-prod.yml



```yaml


```

可以直接从dev配置文件拷贝过来，如果保持基本端口号不变和contexntPath不变的话，改下mysql地址就可以了

3、打包mvn package -Dmaven.test.skip=true


4、java -jar
发布程序
