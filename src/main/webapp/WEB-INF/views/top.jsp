<%--
  @Author bluecyan
  @DateTime 2021-04-17 15:58
  @Description 网站底部
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <style type="text/css">
        .background-top{
            background: #f5f5f5;
        }
        .background-top a:link,a:visited,a:active{
            color: black;
            text-decoration : none;
        }
        .background-top a:hover{
            color: red;
            text-decoration : none;
        }
        .background-top .glyphicon{
            color: red;
        }

        .profile-photo img{
            width: 19px;
            height: 19px;
            border-radius: 50%;
        }
        .user-info span{
            padding-right: 20px;
        }
    </style>
</head>
<body>
    <div class="background-top">
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <span>嗨，欢迎来你的衣柜</span>
                </div>
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <div class="col-md-1">
                            <span><a href="${Project_Path}/user/to-login">请登录</a></span>
                        </div>
                        <div class="col-md-1">
                            <span><a href="${Project_Path}/user/to-register">免费注册</a></span>
                        </div>
                    </c:when>
                    <c:when test="${sessionScope.user != null}">
                        <div class="col-md-3 user-info">
                            <span class="profile-photo"><a href="${Project_Path}/user/to-personalHomepage"><img src="${Project_Path}/${sessionScope.user.getProfilePhoto()}"></a></span>
                            <span><a href="${Project_Path}/user/to-personalHomepage">${sessionScope.user.nickname}</a></span>
                            <span><a href="${Project_Path}/user/login-out">退出</a></span>
                        </div>
                    </c:when>
                </c:choose>
                <div class="col-md-1  col-md-offset-4">
                    <span><a href="${Project_Path}/home/to-index">首页</a></span>
                </div>
                <div class="col-md-1">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                    <span class="right"><a href="${Project_Path}/user/to-favorites" target="_blank">收藏</a></span>
                </div>
                <div class="col-md-1">
                    <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
                    <span><a href="${Project_Path}/user/to-suitcase" target="_blank">衣箱</a></span>
                </div>
            </div>
        </div>
    </div>
</body>
    <script type="text/javascript">
    </script>
</html>
