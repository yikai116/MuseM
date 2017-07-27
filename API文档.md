# Muse API规范文档
**注：有错别找我，自己下源码改就行了**
#### 0.规范

```json
{
  "error": {
    "code": ,
    "message": 
  },
  "data": {
    
  }
}
```

#### 1.登录注册模块

##### 1.1 注册

API：

```
POST	http://localhost:8080/MuseM/api/signUp
```

传入数据示例：

```json
{
    "userName" : "name",
    "email" : "xxx@xx.com",
    "password" : "123456",
    "intro" : "我真他妈的聪明",
    "isMale" : true
}
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "注册成功"
    },
    "data": {
        "email": "xxx@xx.com",
        "tokenStr": "jdyv37l5tzuwid43"
    }
}
```

##### 1.2 登录

API：

```
POST	http://localhost:8080/MuseM/api/signIn
```

传入数据示例：

```json
{
    "email" : "xxx@xx.com",
    "password" : "123456"
}
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "登录成功"
    },
    "data": {
        "email": "xxx@xx.com",
        "tokenStr": "vwmlbcilfv4wkp9z"
    }
}
```

#### 2.用户信息模块

##### 2.1 修改信息

API：

```
POST	http://localhost:8080/MuseM/api/set/modifyUserInfo
```

传入数据示例：

```json
{
    "userName" : "名字",
    "oldPassword" : "123456",
    "newPassword" : "123456",
    "avatar" : "png",
    "intro" : "一只小老虎",
    "isMale" : true
}
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "修改成功"
    },
    "data": {
        "userName": "名字",
        "avatar": "png",
        "intro": "一只小老虎",
        "isMale": "男",
        "artNum": 4,
        "typeNum": 3,
        "stars": [
            "xxxx@xx.com"
        ]
    }
}
```

##### 2.2 根据email得到信息

API：

```
POST	http://localhost:8080/MuseM/api/set/getUserInfo
```

传入数据示例（直接传入数据）：

```json
{
    "email":"xxx@xx.com"
}
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "修改成功"
    },
    "data": {
        "userName": "名字",
        "avatar": "png",
        "intro": "一只小老虎",
        "isMale": "男",
        "artNum": 4,
        "typeNum": 3,
        "stars": [
            "xxxx@xx.com"
        ]
    }
}
```

##### 2.3 得到当前用户信息

API：

```
POST	http://localhost:8080/MuseM/api/set/getMyInfo
```

传入数据示例（直接传入数据）：

```json
不传参
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "修改成功"
    },
    "data": {
        "userName": "名字",
        "avatar": "png",
        "intro": "一只小老虎",
        "isMale": "男",
        "artNum": 4,
        "typeNum": 3,
        "stars": [
            "xxxx@xx.com"
        ]
    }
}
```

#### 3.关注模块

##### 3.1 关注

API：

```
POST	http://localhost:8080/MuseM/api/set/Star/star
```

传入数据示例（直接传输数据）：

```json
{
    "friendEmail":"xxxx@xx.com"
}
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "关注成功"
    },
    "data": null
}
```

##### 3.2 取关

API：

```
POST	http://localhost:8080/MuseM/api/set/Star/unstar
```

传入数据示例（直接传输数据）：

```json
{
    "friendEmail":"xxxx@xx.com"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "取关成功"
    },
    "data": null
}
```

##### 3.3 是否关注

API：

```
POST	http://localhost:8080/MuseM/api/set/Star/isStar
```

传入数据示例（直接传入数据）：

```json
{
    "friendEmail":"xxxx@xx.com"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "未关注"
    },
    "data": false
}
```

#### 4.分类模块

##### 4.1 添加分类

API：

```
POST	http://localhost:8080/MuseM/api/set/Type/addType
```

传入数据示例（直接传入数据）：

```json
{
    "type":"个人日志"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "添加成功"
    },
    "data": {
        "userEmail": "xxx@xx.com",
        "type": "个人日志"
    }
}
```

##### 4.2 删除分类

API：

```
POST	http://localhost:8080/MuseM/api/set/Type/deleteType
```

传入数据示例（直接传入数据）：

```json
{
    "type":"个人日志"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "删除成功"
    },
    "data": {
        "userEmail": "xxx@xx.com",
        "type": "个人日志"
    }
}
```

##### 4.3 根据用户Email得到分类信息

API：

```
POST	http://localhost:8080/MuseM/api/set/Type/getAllByEmail
```

传入数据示例（直接传入数据）：

```json
{
    "email":"xxx@xx.com"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "查找成功"
    },
    "data": [
        {
            "user": "xxx@xx.com",
            "type": "个人日志"
        },
        {
            "user": "xxx@xx.com",
            "type": "技术博客"
        }
    ]
}
```

##### 4.4 得到当前用户分类

API：

```
POST	http://localhost:8080/MuseM/api/set/Type/getMyType
```

返回数据示例：

```json
{
    "error": {
        "code": 1,
        "message": "查找成功"
    },
    "data": [
        {
            "user": "xxx@xx.com",
            "type": "个人日志"
        },
        {
            "user": "xxx@xx.com",
            "type": "技术博客"
        }
    ]
}
```

#### 5.文章增删查改

##### 5.1 查

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getArt
```

传入数据示例（直接传入数据）：

```json
{
    "id":"1002"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "获取成功"
    },
    "data": {
        "artId": 1002,
        "artTitle": "我是测试",
        "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试",
        "artType": "个人日志",
        "createDate": "2017-07-26",
        "author": "xxx@xx.com",
        "cmtNum": 0
    }
}
```

##### 5.2 删

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/deleteArt
```

传入数据示例（直接传入数据）：

```json
{
    "id":"1001"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "删除成功"
    },
    "data": {
        "artId": 1001,
        "artTitle": "我是测试",
        "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试",
        "artType": "个人日志",
        "createDate": "2017-07-26",
        "author": "xxx@xx.com",
        "cmtNum": 0
    }
}
```

##### 5.3 增

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/insertArt
```

传入数据示例：

```json
{
    "artTitle" : "我是测试",
    "artContent" : "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试",
    "artType" : "个人日志"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "添加成功"
    },
    "data": {
        "artId": 1001,
        "artTitle": "我是测试",
        "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试",
        "artType": "个人日志",
        "createDate": "2017-07-26",
        "author": "xxx@xx.com",
        "cmtNum": 0
    }
}
```

##### 5.4 改

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/updateArt
```

传入数据示例：

```json
{
    "artId": 1002,
    "artTitle": "我是试",
    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试",
    "artType": "个人日志"
}
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "更新成功"
    },
    "data": {
        "artId": 1002,
        "artTitle": "我是试",
        "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试",
        "artType": "个人日志",
        "createDate": null,
        "author": null,
        "cmtNum": 0
    }
}
```

##### 5.5 得到当前用户文章

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getMyArt
```

传入数据示例：

```json
不传参
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "获得成功"
    },
    "data": [
        {
            "artId": 1002,
            "artTitle": "我是试",
            "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是",
            "artType": "个人日志",
            "createDate": "2017-07-26",
            "author": "xxx@xx.com",
            "cmtNum": 0
        },
        {
            "artId": 1003,
            "artTitle": "我是测试",
            "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是",
            "artType": "个人日志",
            "createDate": "2017-07-26",
            "author": "xxx@xx.com",
            "cmtNum": 0
        },
        {
            "artId": 1004,
            "artTitle": "我是测试",
            "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是",
            "artType": "个人日志",
            "createDate": "2017-07-26",
            "author": "xxx@xx.com",
            "cmtNum": 0
        }
    ]
}
```

##### 5.6 根据用户email得到用户文章

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getArtsByEmail
```

传入数据示例：

```json
{
    "email":"xxx@xx.com"
}
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "获得成功"
    },
    "data": [
        {
            "artId": 1002,
            "artTitle": "我是试",
            "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是",
            "artType": "个人日志",
            "createDate": "2017-07-26",
            "author": "xxx@xx.com",
            "cmtNum": 0
        },
        {
            "artId": 1003,
            "artTitle": "我是测试",
            "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是",
            "artType": "个人日志",
            "createDate": "2017-07-26",
            "author": "xxx@xx.com",
            "cmtNum": 0
        },
        {
            "artId": 1004,
            "artTitle": "我是测试",
            "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是",
            "artType": "个人日志",
            "createDate": "2017-07-26",
            "author": "xxx@xx.com",
            "cmtNum": 0
        }
    ]
}
```

##### 5.7 得到当前用户文章列表

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getMyArtList
```

传入数据示例：

```json
不传参
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "获取成功"
    },
    "data": [
        {
            "type": "个人日志",
            "count": 3,
            "arts": [
                {
                    "artId": 1002,
                    "artTitle": "我是试"
                },
                {
                    "artId": 1003,
                    "artTitle": "我是测试"
                },
                {
                    "artId": 1004,
                    "artTitle": "我是测试"
                }
            ]
        },
        {
            "type": "技术博客",
            "count": 0,
            "arts": []
        }
    ]
}
```

##### 5.8 根据用户email得到用户文章列表

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getArtsByEmail
```

传入数据示例：

```json
{
    "email":"xxx@xx.com"
}
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "获取成功"
    },
    "data": [
        {
            "type": "个人日志",
            "count": 3,
            "arts": [
                {
                    "artId": 1002,
                    "artTitle": "我是试"
                },
                {
                    "artId": 1003,
                    "artTitle": "我是测试"
                },
                {
                    "artId": 1004,
                    "artTitle": "我是测试"
                }
            ]
        },
        {
            "type": "技术博客",
            "count": 0,
            "arts": []
        }
    ]
}
```

##### 5.9 得到当前用户文章时间轴列表

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getMyTimeList
```

传入数据示例：

```json
不传参
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "获取成功"
    },
    "data": [
        {
            "year": 2017,
            "count": 3,
            "arts": [
                {
                    "artId": 1002,
                    "artTitle": "我是试",
                    "time": "2017-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                },
                {
                    "artId": 1003,
                    "artTitle": "我是测试",
                    "time": "2017-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                },
                {
                    "artId": 1004,
                    "artTitle": "我是测试",
                    "time": "2017-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                }
            ]
        },
        {
            "year": 2016,
            "count": 1,
            "arts": [
                {
                    "artId": 1011,
                    "artTitle": "我是测试",
                    "time": "2016-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                }
            ]
        }
    ]
}
```

##### 5.10 根据用户email得到用户文章时间轴列表

API：

```
POST	http://localhost:8080/MuseM/api/set/Article/getTimeListByEmail
```

传入数据示例：

```json
{
    "email":"xxx@xx.com"
}
```

返回结果示例（返回文章Id)：

```json
{
    "error": {
        "code": 1,
        "message": "获取成功"
    },
    "data": [
        {
            "year": 2017,
            "count": 3,
            "arts": [
                {
                    "artId": 1002,
                    "artTitle": "我是试",
                    "time": "2017-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                },
                {
                    "artId": 1003,
                    "artTitle": "我是测试",
                    "time": "2017-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                },
                {
                    "artId": 1004,
                    "artTitle": "我是测试",
                    "time": "2017-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                }
            ]
        },
        {
            "year": 2016,
            "count": 1,
            "arts": [
                {
                    "artId": 1011,
                    "artTitle": "我是测试",
                    "time": "2016-07-26",
                    "artContent": "我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是测试我是"
                }
            ]
        }
    ]
}
```

#### 6.评论模块

##### 6.1 得到文章评论

API：

```
POST	http://localhost:8080/MuseM/api/set/Comment/getAllComment
```

传入数据示例：

```json
{
    "artId":1002
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "查找成功"
    },
    "data": [
        {
            "cmterName": "名字",
            "cmter": "xxx@xx.com",
            "cmtId": 1002,
            "artId": 1002,
            "createDate": "2017-07-26",
            "cmtContent": "测试评论"
        },
        {
            "cmterName": "名字",
            "cmter": "xxx@xx.com",
            "cmtId": 1003,
            "artId": 1002,
            "createDate": "2017-07-26",
            "cmtContent": "测试评论"
        },
        {
            "cmterName": "名字",
            "cmter": "xxx@xx.com",
            "cmtId": 1004,
            "artId": 1002,
            "createDate": "2017-07-26",
            "cmtContent": "测试评论"
        }
    ]
}
```

##### 6.2 添加评论

API：

```
POST	http://localhost:8080/MuseM/api/set/Comment/addComment
```

传入数据示例：

```json
{
    "artId" : 1002,
    "cmtContent" : "测试评论"
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "添加成功"
    },
    "data": {
        "cmtId": 1001,
        "cmter": "xxx@xx.com",
        "artId": 1002,
        "createDate": "2017-07-26",
        "cmtContent": "测试评论"
    }
}
```

##### 6.3 删除评论

API：

```
POST	http://localhost:8080/MuseM/api/set/Comment/deleteComment
```

传入数据示例：

```json
{
    "cmtId":1001
}
```

返回结果示例：

```json
{
    "error": {
        "code": 1,
        "message": "删除成功"
    },
    "data": {
        "cmterName": "名字",
        "cmter": "xxx@xx.com",
        "cmtId": 1001,
        "artId": 1002,
        "createDate": "2017-07-26",
        "cmtContent": "测试评论"
    }
}
```

#### 























