<%--
  @Author bluecyan
  @DateTime 2021-04-17 1:13
  @Description 首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>你的衣柜-新时尚租衣平台</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="navigationLeft" value="${requestScope.homeWithList.getNavigationLeft()}" />
    <c:set var="navigationBar" value="${requestScope.homeWithList.getNavigationBar()}" />
    <c:set var="sideshow" value="${requestScope.homeWithList.getSideshow()}" />
    <c:set var="recommendList" value="${requestScope.homeWithList.getRecommendList()}" />
    <c:set var="hotClothingWithLists" value="${requestScope.hotClothingWithLists}" />
    <c:set var="newClothingWithLists" value="${requestScope.newClothingWithLists}" />

    <style type="text/css">
        .navigation_bar{
            background-color: red;
            color: white;
        }
        .navigation_bar .col-md-1{
            padding-top: 6px;
            padding-bottom: 6px;
        }
        .navigation_bar .container{
            padding: 0px;
        }
        .category{
            background-color: #FF8000;
            padding-top: 6px;
            padding-bottom: 6px;

        }
        .navigation_bar a:link,.navigation_bar a:visited,.navigation_bar a:active,.navigation_bar a:hover{
            color: white;
            text-decoration : none;
        }
        .navigation-left{
            background-color: red;
            color: white;
            height: 480px;
        }
        .navigation-left .col-md-12{
            padding-top: 6px;
            padding-bottom: 6px;
        }
        .navigation-left a:link,.navigation-left a:visited,.navigation-left a:active,.navigation-left a:hover{
            color: white;
            text-decoration : none;
        }
        .sideshow{
            width: 975px !important;
            height: 480px !important;
        }
        .sideshow-wrap{
            padding: 0px !important;
        }

        .background-recommend{
            background: #f4f4f4;
            padding-bottom: 100px;
            border-bottom: #dedede 1px solid;
        }
        .background-recommend .glyphicon{
            color: red;
        }
        .recommend-title{
            font-size: 20px;
            font-family: 幼圆;
            padding-bottom: 25px;
        }
        .background-recommend .container{
            padding-top: 50px;
            padding-left: 0;
            padding-right: 0;
        }
        .background-recommend .col-md-2{
            background-color: white;
            padding-top: 20px;
            padding-bottom: 10px;
            margin: 10px 6px;
            width: 228px !important;
        }
        .background-recommend img{
            width: 196px;
            height: 196px;
            text-align: center;
        }
        .background-recommend .show-cloting{
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

    </style>

</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="searchHead.jsp"></jsp:include>
    <div class="navigation_bar">
        <div class="container">
                <div class="col-md-2 category">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    &nbsp;&nbsp;分类
                </div>
                <%-- 导航栏 --%>
                <c:forEach items="${navigationBar}" var="navigation">
                    <div class="col-md-1">
                        <a href="${Project_Path}/clothing/search/${navigation}"  target="_blank">${navigation}</a>
                    </div>
                </c:forEach>
            </div>
    </div>

    <div class="container">
       <div class="row">
            <%-- 左导航 --%>
           <div class="col-md-2">
                <div class="row navigation-left">
                    <c:forEach items="${navigationLeft}" var="navigation">
                        <div class="col-md-12">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${Project_Path}/clothing/search/${navigation}"  target="_blank">${navigation}</a>
                        </div>
                    </c:forEach>
                </div>
           </div>
                <%--  轮播  --%>
           <div class="col-md-10 sideshow-wrap">
               <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3200">
                   <!-- 轮播（Carousel）指标 -->
                   <ol class="carousel-indicators">
                       <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                       <c:forEach items="${sideshow}" var="item" begin="1" varStatus="id">
                           <li data-target="#myCarousel" data-slide-to="${id.count}"></li>
                       </c:forEach>
                   </ol>
                   <!-- 轮播（Carousel）项目 -->
                   <div class="carousel-inner">
                       <div class="item active">
                           <img src="${Project_Path}/${sideshow[0]}" class="sideshow">
                       </div>
                       <c:forEach items="${sideshow}" var="item" begin="1">
                           <div class="item">
                               <img src="${Project_Path}/${item}" class="sideshow">
                           </div>
                       </c:forEach>
                   </div>
               </div>
           </div>
       </div>
    </div>


    <div class="background-recommend">

        <div class="container">
            <p class="text-center recommend-title"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span>&nbsp;热租</p>
            <div class="row">
                <c:forEach items="${hotClothingWithLists}" var="item" begin="0" end="4">

                    <div class="col-md-2">
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

            <div class="row">
                <c:forEach items="${hotClothingWithLists}" var="item" begin="5" end="9">
                    <div class="col-md-2">
                        <a class="show-cloting" href="${Project_Path}/clothing/to-clothingDetails/${item.getClothing().getClothingId()}"  target="_blank">
                            <span>
                                <img src="${Project_Path}/${item.getPicture()[0]}">
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

        <div class="container">
            <p class="text-center recommend-title"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;推荐</p>
            <div class="row">
                <c:forEach items="${recommendList}" var="item" begin="0" end="4">
                    <div class="col-md-2">
                        <a class="show-cloting" href="${Project_Path}/clothing/to-clothingDetails/${item.getClothing().getClothingId()}"  target="_blank">
                            <span>
                                <img src="${Project_Path}/${item.getPicture()[0]}">
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

            <div class="row">
                <c:forEach items="${recommendList}" var="item" begin="5" end="9">
                    <div class="col-md-2">
                        <a class="show-cloting" href="${Project_Path}/clothing/to-clothingDetails/${item.getClothing().getClothingId()}"  target="_blank">
                            <span>
                                <img src="${Project_Path}/${item.getPicture()[0]}">
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

        <div class="container">
            <p class="text-center recommend-title"><span class="glyphicon glyphicon-flash" aria-hidden="true"></span>&nbsp;上新</p>
            <div class="row">
                <c:forEach items="${newClothingWithLists}" var="item" begin="0" end="4">
                    <div class="col-md-2">
                        <a class="show-cloting" href="${Project_Path}/clothing/to-clothingDetails/${item.getClothing().getClothingId()}"  target="_blank">
                            <span>
                                <img src="${Project_Path}/${item.getPicture()[0]}">
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

            <div class="row">
                <c:forEach items="${newClothingWithLists}" var="item" begin="5" end="9">
                    <div class="col-md-2">
                        <a class="show-cloting" href="${Project_Path}/clothing/to-clothingDetails/${item.getClothing().getClothingId()}"  target="_blank">
                            <span>
                                <img src="${Project_Path}/${item.getPicture()[0]}">
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

            // 左导航栏鼠标悬停变色
            $(".navigation-left .col-md-12").hover(
                function () {
                    $(this).css("background-color","#FF8000");
                },
                function () {
                    $(this).css("background-color","red");
                }
            )

            // 商品展示悬停显示阴影
            $(".background-recommend .col-md-2").hover(
                function () {
                    $(this).css("box-shadow","0 0 10px #000");
                },
                function () {
                    $(this).css("box-shadow","none");
                }
            )

        })
    </script>
</html>
