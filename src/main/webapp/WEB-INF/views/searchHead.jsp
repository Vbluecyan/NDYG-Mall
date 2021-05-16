<%--
  @Author bluecyan
  @DateTime 2021-04-17 19:20
  @Description 搜索头部
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
        .ndyg:link,.ndyg:visited,.ndyg:active,.ndyg:hover {
            color: red;
            font-family: 宋体;
            font-size: 25px;
            text-decoration : none;
        }
        .search-row{
            padding-top: 51px;
            padding-bottom: 51px;
        }
        /*加上!important优先级才够，才能覆盖原来属性*/
        .search{
            background-color: #f03726 !important;
        }
        .search-text{
            border-radius: 0 !important;
            border: #f03726 3px solid !important;
        }
        .search-btn{
            border-radius: 0 !important;
            background-color: #f03726 !important;
            color: #f5f5f2 !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row search-row">
        <div class="col-md-3">
            <a class="ndyg" href="${Project_Path}/home/to-index">你的衣柜</a>
        </div>
        <div class="col-md-6 col-md-offset-3">
            <div class="input-group search">
                <input type="text" class="form-control search-text" value="${requestScope.keyword}" placeholder="">
                <span class="input-group-btn">
                     <button class="btn btn-default search-btn" type="button">搜索</button>
                </span>
            </div><!-- /input-group -->
        </div>
    </div>
</div>
</body>
    <script type="text/javascript">
        $(function () {
            $(".search-btn").click(function () {
                //若有输入参数才发请求
                if ($(".search-text").val() != "")
                window.location.href = "${Project_Path}/clothing/search/" + $(".search-text").val();
            });
        })
    </script>
</html>
