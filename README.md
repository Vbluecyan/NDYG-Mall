# NDYG-Mall

[github|项目地址](https://github.com/Vbluecyan/NDYG-Mall) &nbsp; &nbsp; [gitee|项目地址](https://gitee.com/bluecyan/NDYG-Mall) 

更多详情，请访问博文：[NDYG-Mall—基于JQuery+Bootstrap和SSM框架的电商系统/商城demo](https://blog.csdn.net/bluecyan/article/details/116939552?spm=1001.2014.3001.5501)

作者博客：[bluecyan](https://blog.csdn.net/bluecyan)

## 项目介绍

`NDYG-Mall`  直译中文名为**你的衣柜商城**，正式名为**你的衣柜服装共享平台**。`NDYG-Mall`  项目是一套电商系统 demo，基于 JQuery + Bootstrap 和 SSM（Spring + Spring MVC + MyBatis）实现。主要实现了首页门户；用户注册、登录、修改基本信息、修改密码、开通会员、注销用户功能；搜索功能；收藏功能；下单功能；服装展示功能。

### 展示

首页

![首页](https://images.gitee.com/uploads/images/2021/0517/135142_7fcebf0a_8937713.jpeg "home.jpg")



搜索页

![搜索页](https://images.gitee.com/uploads/images/2021/0517/135243_340b64c4_8937713.jpeg "search.jpg")



个人资料页

![个人资料页](https://images.gitee.com/uploads/images/2021/0517/135311_f897aaaf_8937713.jpeg "profile.jpg")



### 技术栈

#### 前端技术

1. JQuery
2. Bootstrap
3. ……

#### 后端技术

1. Spring
2. Spring MVC
3. MyBatis
4. MyBatis Generator
5. MyBatis PageHelper
6. MySQL
7. Maven
8. ……

#### 架构图

![技术架构](https://images.gitee.com/uploads/images/2021/0517/135340_24a26fea_8937713.png "architecture1.png")

![技术栈](https://images.gitee.com/uploads/images/2021/0517/135402_d2390938_8937713.png "architecture2.png")

## 快速部署

1. 将项目 clone / 下载 ZIP 到本地
2. 在 IntelliJ IDEA 中打开该项目（该项目使用 IDEA 开发，使用 Eclipse 效果未知）
3. 复制并到 MySQL 数据库管理工具中执行 document/NDYG-Mall.sql 文件，将创建数据库，创建数据表，并插入初始数据
4. 修改 src/main/resources/c3p0Config.properties 配置文件，将 MySQL 数据库配置改成自己的
5. 执行 src/test/java/com/bluecyan/mapper 目录下 ClothingExtendMapperTest 类中的 insertSelective() 函数。若报错，可刷新下 Maven，之后重新尝试执行 insertSelective()  函数
6. 配置 tomcat 并运行，大功告成
7. 更多详情，请访问博文：[NDYG-Mall—基于JQuery+Bootstrap和SSM框架的电商系统/商城demo](https://blog.csdn.net/bluecyan/article/details/116939552?spm=1001.2014.3001.5501)

## 开源协议

[MIT](https://github.com/Vbluecyan/NDYG-Mall/blob/master/LICENSE)

Copyright (c) 2021 Vbluecyan