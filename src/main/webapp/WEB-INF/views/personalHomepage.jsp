<%--
  @Author bluecyan
  @DateTime 2021-04-18 1:29
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>个人主页</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="user" value="${sessionScope.user}" />

    <style type="text/css">
        .top{
            width: 100%;
            border-bottom: solid 1px #dedede;
        }
        .end{
            position: fixed;
            top: auto;
            right: 0;
            bottom: 0;
            left: 0;
            width: 100%;
            border-top: solid 1px #dedede;
        }
        .person{
            background: #f4f4f4;
            width: 100%;
            height: 100%;
        }
        .person-full {
            padding-top: 10px;
            padding-bottom: 10px;
        }
        .inner{
            /*取消内联框架的边框样式*/
            frameborder: 0;
            border: 0;

            /*强行布局*/
            width: 100%;
            height: 77.7%;
        }
        .person-nav{
            background: white;
            line-height: 3.5;
            text-align: center;
        }
        .person-nav a:link, .person-nav a:visited, .person-nav a:active{

            text-decoration : none;
        }
        .person-nav a:hover{

            text-decoration : none;
        }
        .person-main{

        }
    </style>
</head>
<body>
    <div class="person">
        <div class="top"><jsp:include page="top.jsp"></jsp:include></div>
        <div class="container person-full">
            <div class="row">
                <div class="col-md-2">
                    <div class="person-nav">
                        <div class="row" >
                            <a href="${Project_Path}/user/to-personal-data" target="in" style="color: red" no="yes">个人资料</a>
                        </div>
                        <div class="row">
                            <a href="${Project_Path}/user/to-account-set" target="in">账号设置</a>
                        </div>
                        <div class="row">
                            <a href="${Project_Path}/user/to-member" target="in">开通会员</a>
                        </div>
                        <div class="row">
                            <a href="${Project_Path}/user/to-favorites" target="_blank">我的收藏</a>
                        </div>
                        <div class="row">
                            <a href="${Project_Path}/user/to-suitcase" target="_blank">我的衣箱</a>
                        </div>
                        <div class="row">
                            <a href="${Project_Path}/order/to-order" target="_blank">我的订单</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="person-main">
                        <iframe class="inner" src="${Project_Path}/user/to-personal-data" name="in"></iframe>
                    </div>
                </div>
            </div>
        </div>

        <div class="end"><jsp:include page="end.jsp"></jsp:include></div>
    </div>


</body>
    <script type="text/javascript">

        $(function () {

            $(".person-nav a[target='in']").click(function () {
                $(".person-nav a").css("color","black");
                $(".person-nav a").attr("no","no");
                $(this).css("color","red").attr("no","yes");
            });

            $(".person-nav a").hover(
                function () {
                    $(this).css("color","red");
                },
                function () {
                    if ($(this).attr("no") !== "yes")
                    $(this).css("color","black");
                }
            );

        })

    </script>
</html>
