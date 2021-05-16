<%--
  @Author bluecyan
  @DateTime 2021-04-17 15:59
  @Description 网站顶部
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
        .background-end{
            background: #f4f4f4;
        }
        .bottom1{
            padding-top: 20px;
            padding-bottom: 10px;
        }
        .bottom2{
            padding-top: 10px;
            padding-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="background-end">
    <div class="container">
        <div class="row bottom1">
            <div class="col-md-12">
                <p class="text-center">Copyright © 2021 你的衣柜 ndyg.com All Rights Reserved. 京ICP证XXX号 京ICP备XXX号-X 京公网安备 XXX号</p>
            </div>
        </div>
        <div class="row bottom2">
            <div class="col-md-12">
                <p class="text-center">享100万+时装随心换穿、免费往返物流、专业透明清洗消毒</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
