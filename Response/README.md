响应类
=====
#### BaseResponse
该类是所有请求的响应类(除分页以外)

结构：
```json
{
  "code":"返回码",
  "msg":"消息内容",
  "data": {
    "返回对象":"对象的数据"
  }
}
```

#### PagedResponse
该类是所有分页请求的响应类,继承BaseResponse类

结构：
```json
{
  "pageIndex":"当前页码",
  "pageSize":"分页条数",
  "count":"总条数"
}
```

#### ResponseStatus
该类是响应的枚举类