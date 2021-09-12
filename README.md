### 通过jinjava来生成mongodb表的模型类

#### 前置准备

安装mongodb    
引入jinjava依赖

#### 进行

1. 安装mongodb

这里使用docker compose安装mongodb.

安装脚本

[mongodb安装脚本](./docker-compose.yml)

2. 数据库数据

use one    
db.createCollection("cube")    
db.cube.insert({name:"topic",columns:["a","b","c"]})   

3. 配置客户端用户    

mongo安装时配置了root用户, 这个用户只能admin库里使用.如果要在外部使用,需要配置客户端访问用户

use one

db.createUser(
  {
    user: "liu3",
    pwd: "123456",
    roles: ["readWrite" ]
  }
)

4. 服务配置

这里使用spring boot来连接mongodb.需要在application.properties增加配置

```
pring.data.mongodb.uri=mongodb://liu3:123456@localhost:27017/one
```

5. 增加模板.

模板很简单是将数据库读取的字段信息.进行遍历后拼接成文本字符串

```

import ;
import ;

public class {{className}} {


  { {% for cube in fields %}

    {% if cube.name is defined %}
    /**
    /* {{cube.name}}
    /*
    {% endif %}
    {% if cube.columns is defined %}

       {% for column in cube.columns %}
        private String {{column}};
       {% endfor %}
    {% endif %}


    {% endfor %}
  }
}
```

服务运行.输出文本字符串


### 参考资料

[jinjava使用](https://github.com/HubSpot/jinjava)
