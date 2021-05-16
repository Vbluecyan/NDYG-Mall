<%--
  @Author bluecyan
  @DateTime 2021-04-24 9:44
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>收藏</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="favoritesClothingWithLists" value="${requestScope.favoritesClothingWithLists}"/>
    <c:set var="user" value="${sessionScope.user}" />

    <style type="text/css">
        .background-favorites{
            background: #f4f4f4;
            padding-bottom: 100px;
            border-bottom: #dedede 1px solid;
        }
        .background-favorites .container{
            padding-top: 50px;
            padding-left: 0;
            padding-right: 0;
        }
        .background-favorites .col-md-2{
            background-color: white;
            padding-top: 4px;
            padding-bottom: 10px;
            margin: 10px 6px;
            width: 228px !important;
        }
        .background-favorites img{
            width: 196px;
            height: 196px;
            text-align: center;
        }
        .background-favorites .show-cloting{
            background-color: white;
            color: black;
            text-decoration : none;
        }
        .clothing-title{
            display: block;
            padding: 15px;
            width: 198px;
            height: 90px;
        }
        .clothing-price{
            display: block;
            text-align: center;
            color: red;
            font-size: 18px;
        }
        .clothing-sales{
            display: block;
            text-align: right;
            font-size: 12px;
        }
        .cancel-favorite{
            color: #409eff;
            position: relative;
            left: 140px;
            /*放在该元素上时鼠标变成小手*/
            cursor:pointer;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="background-favorites">
        <div class="container">

            <div class="row">
                <div class="col-md-1">
                    <b>我的收藏</b>
                </div>
            </div>

            <div class="row">
                <c:forEach items="${favoritesClothingWithLists}" var="item">

                    <div class="col-md-2">
                        <span class="cancel-favorite" clothingId="${item.clothing.clothingId}">取消收藏</span>
                        <a class="show-cloting" href="${Project_Path}/clothing/to-clothingDetails/${item.getClothing().getClothingId()}"  target="_blank">
                            <span>
                                <img src="${Project_Path}/${item.getPicture()[0]}" />
                            </span>
                            <span>
                                <span class="clothing-title">
                                        ${item.getClothing().getTitle()}
                                </span>
                                <span class="clothing-price">
                                    ￥&nbsp;${item.getClothing().getPrice()}
                                </span>
                                 <span class="clothing-sales">
                                    月租&nbsp${item.getClothing().getSales()}
                                 </span>
                            </span>
                        </a>
                    </div>

                </c:forEach>
            </div>

        </div>
    </div>

    <jsp:include page="end.jsp"></jsp:include>
</body>
    <script type="text/javascript">
        $(function () {
            $(".cancel-favorite").click(function () {
                var element = $(this);
                $.ajax({
                    url: "${Project_Path}/user/remove-favorites"+"/${user.userId}"+"/"+$(this).attr("clothingId"),
                    type: "PUT",
                    success: function (result) {
                        // 在ajax的success里用$(this)选择不到元素,在ajax之前声明一个用var声明一个全局变量，然后在success中用声明的全局变量代替$(this)即可
                        element.parent().remove();
                    }
                });

            });
        })
    </script>
</html>

