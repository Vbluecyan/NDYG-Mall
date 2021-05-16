<%--
  @Author bluecyan
  @DateTime 2021-04-20 16:42
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>服装详情</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="clothingWithList" value="${requestScope.clothingWithList}" />
    <c:set var="clothing" value="${requestScope.clothingWithList.clothing}" />

    <c:set var="user" value="${sessionScope.user}" />

    <c:set var="orderList" value="${requestScope.orderList}" />

    <style type="text/css">
        .clothing-details{
            line-height: 3.7;
        }
        .picture .col-md-2{
            padding: 10px 0px 20px 15px;
        }
        .picture img{
            width: 180px;
            height: 180px;
        }
        .comment-text{
            border: solid 1px #dedede;
            margin-bottom: 20px;
            padding-top:10px;
            padding-bottom: 10px;
            line-height: 1.5;
        }

    </style>
</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="container clothing-details">
        <div class="row">
            <div class="col-md-12">
                <b>${clothing.title}</b>
            </div>
        </div>
        <div class="row picture">
            <c:forEach items="${clothingWithList.picture}" var="item">
                <div class="col-md-2">
                    <img src="${Project_Path}/${item}">
                </div>
            </c:forEach>
        </div>
        <div style="border: solid 1px #dedede;">
            <div class="row" >
                <div class="col-md-2">
                    <b>服装详情</b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    品牌：${clothing.brand.brandName}
                </div>
                <div class="col-md-2">
                    品类：${clothing.category.categoryName}
                </div>
                <div class="col-md-2">
                    风格：${clothing.style.styleName}
                </div>
                <div class="col-md-2">
                    性别：${clothing.sex}
                </div>
                <div class="col-md-4">
                    尺码：
                    <c:forEach items="${clothingWithList.size}" var="item" begin="1"> <%--序号0是空串，所有从1开始--%>
                        ${item}&nbsp;
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    价格：￥&nbsp;${clothing.price}
                </div>
                <div class="col-md-2">
                    库存：${clothing.inventory}
                </div>
                <div class="col-md-2">
                    厚薄：${clothing.thickness}
                </div>
                <div class="col-md-2">
                    弹力：${clothing.elastic}
                </div>
                <div class="col-md-2">
                    颜色：${clothing.colour}
                </div>

                <div class="col-md-2">
                    月租：${clothing.sales}
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    季节：${clothing.season}
                </div>
                <div class="col-md-2">
                    上架日期：<fmt:formatDate value="${clothing.date}" type="date" />
                </div>
                <div class="col-md-2">
                    材质：${clothing.texture}
                </div>
            </div>
        </div>
        <div class="row" style="padding-top: 28px;">
            <div class="col-md-1 col-md-offset-4" >
                <c:if test="${!user.favorites.contains(clothing.clothingId)}">
                    <button type="button" class="btn btn-primary favorites">收藏</button>
                </c:if>
                <c:if test="${user.favorites.contains(clothing.clothingId)}">
                    <button type="button" class="btn btn-danger favorites">取消收藏</button>
                </c:if>
            </div>
            <div class="col-md-1">
                <button type="button" class="btn btn-primary suitcase">加入衣箱</button>
            </div>
            <div class="col-md-1">
                <button type="button" class="btn btn-primary do-this">租这件</button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <b>评价</b>
            </div>
        </div>
        <c:forEach items="${orderList}" var="item">
            <c:if test="${item.commentText != null}">
                <div class="row comment-text" >
                    <div class="col-md-2">
                        用户ID@${item.userId}：
                    </div>
                    <div class="col-md-10">
                            ${item.commentText}
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <jsp:include page="end.jsp"></jsp:include>
</body>
<script type="text/javascript">
    $(function () {
        $(".favorites").click(function () {
            if (${user == null}) {
                window.location.href = "${Project_Path}/user/to-login";
                return;
            }
            switch ($.trim($(this).text())) {
                case "收藏":
                    $.ajax({
                        url: "${Project_Path}/user/add-favorites"+"/${user.userId}"+"/${clothing.clothingId}",
                        type: "PUT",
                        success: function (result) {
                            // 在ajax的success里用$(this)选择不到元素
                            $(".favorites").removeClass("btn-primary").addClass("btn-danger").text("取消收藏");
                        }
                    });
                    break;
                case "取消收藏":
                    $.ajax({
                        url: "${Project_Path}/user/remove-favorites"+"/${user.userId}"+"/${clothing.clothingId}",
                        type: "PUT",
                        success: function (result) {
                            // 在ajax的success里用$(this)选择不到元素
                            $(".favorites").removeClass("btn-danger").addClass("btn-primary").text("收藏");
                        }
                    });
                    break;
            }

        });

        $(".suitcase").click(function () {
            if (${user == null}) {
                window.location.href = "${Project_Path}/user/to-login";
                return;
            }
        });

        $(".do-this").click(function () {
            if (${user == null}) {
                window.location.href = "${Project_Path}/user/to-login";
                return;
            }

            $.post(
                "${Project_Path}/order/create-order",
                // expectantReturnDate=2021 5 30 正确 expectantReturnDate=\"2021 5 30\" 错误
                "userId=${user.userId}&&clothingId=${clothing.clothingId}&&money=${clothing.price}&&expectantReturnDate=2021 5 30",
                function () {
                    alert("租衣成功！");
                }
            );
        });
    })
</script>
</html>
