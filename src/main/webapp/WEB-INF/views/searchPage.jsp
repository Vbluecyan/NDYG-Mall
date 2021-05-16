<%--
  @Author bluecyan
  @DateTime 2021-04-19 19:21
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>搜索</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="keyword" value="${requestScope.keyword}" />
    <c:set var="brandList" value="${requestScope.brandList}" />
    <c:set var="categoryList" value="${requestScope.categoryList}" />
    <c:set var="styleList" value="${requestScope.styleList}" />

    <style type="text/css">
        .searchCondition .col-md-1,.searchCondition .col-md-10,.searchCondition .col-md-11{
            border: solid 1px #777;
            color: #777;
            padding-top: 4px;
            padding-bottom: 4px;
        }
        .searchCondition span{
            padding: 0 5px;
            margin: 0 5px;
            border-radius: 8px;
            /*放在该元素上时鼠标变成小手*/
            cursor:pointer;
        }
        .other{
            margin: 25px 0;
        }
        .other .col-md-1{
            padding-top: 8px;
            padding-bottom: 8.9px;
        }
       .other .col-md-10{
            padding-top: 8px;
            padding-bottom: 8px;
        }


        .background-recommend{
            background: #f4f4f4;
            padding-bottom: 20px;
            border-bottom: #dedede 1px solid;
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
        #page_nav_area{
            margin: 20px auto !important;
            text-align: center;
        }
        .goGroup{
            margin: 10px auto;
            text-align: center;
        }
        .numIn{
            width: 30px;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="searchHead.jsp">
        <jsp:param name="keyword" value="${keyword}"/>
    </jsp:include>

    <div class="container searchCondition">

        <div class="row brand">
            <div class="col-md-1">
                品牌
            </div>
            <div class="col-md-11">
                <c:forEach items="${brandList}" var="brand" >
                    <%-- brand-id="" 设置自定义属性用来保存数据 --%>
                    <span brand-id="${brand.getBrandId()}">
                       <c:if test="${!brand.getBrandName().equals(\"其他\")}">
                           ${brand.getBrandName()}
                       </c:if>
                    </span>
                </c:forEach>
            </div>
        </div>

        <div class="row category">
            <div class="col-md-1">
                品类
            </div>
            <div class="col-md-11">
                <c:forEach items="${categoryList}" var="category" >
                    <span category-id="${category.getCategoryId()}">
                        <c:if test="${!category.getCategoryName().equals(\"其他\")}">
                            ${category.getCategoryName()}
                        </c:if>
                    </span>
                </c:forEach>
            </div>
        </div>

        <div class="row style">
            <div class="col-md-1">
                风格
            </div>
            <div class="col-md-11">
                <c:forEach items="${styleList}" var="style" >
                    <span style-id="${style.getStyleId()}">
                       <c:if test="${!style.getStyleName().equals(\"其他\")}">
                           ${style.getStyleName()}
                       </c:if>
                    </span>
                </c:forEach>
            </div>
        </div>

        <div class="row size">
            <div class="col-md-1">
                尺码
            </div>
            <div class="col-md-11">
                <span>XS</span>
                <span>S</span>
                <span>M</span>
                <span>L</span>
                <span>XL</span>
                <span>XXL</span>
            </div>
        </div>

        <div class="row other">
            <div class="col-md-1">
                <span class="order-none" style="color: red;border-radius: 0;padding: 0;margin: 0;">
                    综合排序
                </span>
            </div>
            <div class="col-md-1">
                <span class="sale">
                   租量 <span class="caret" style="border-radius: 0;padding: 0;margin: 0;"></span>
                </span>
            </div>
            <div class="col-md-10 sex">
               <span>
                    <label class="checkbox-inline">
                        <input type="checkbox" name="sex-check-group" value="男" > 男
                    </label>
               </span>
                <span>
                    <label class="checkbox-inline">
                        <input type="checkbox" name="sex-check-group" value="女" > 女
                    </label>
                </span>
            </div>
        </div>
    </div>

    <a name="head"></a>
    <div class="background-recommend">
        <div class="container">
            <div class="row build-page">

            </div>

            <!-- 显示分页信息 -->
            <div class="row">
                <!-- 分页条信息 -->
                <div id="page_nav_area">

                </div>
            </div>
        </div>
    </div>


    <jsp:include page="end.jsp"></jsp:include>
</body>
    <script type="text/javascript">
        $(function () {
            var searchCondition = {
                keyword: "${keyword}",
                brands: [],
                categorys: [],
                styles: [],
                sizes: "",
                order: "clothing_id DESC",
                sexs: [],
                pageNum: 1
            };

            search();
            function search() {
                if (searchCondition.sizes !== "") {
                    // 把开头的 | 去掉
                    searchCondition.sizes = searchCondition.sizes.substring(1);
                    var jsonData = JSON.stringify(searchCondition);
                    // 把开头的 | 加上，不加尺码筛选有bug
                    searchCondition.sizes = "|"+searchCondition.sizes;
                } else {
                    var jsonData = JSON.stringify(searchCondition);
                }
                $.post({
                    url: "${Project_Path}/clothing/search",
                    // 告知传递参数类型类JSON，必备
                    contentType:"application/json",
                    // 将JSON转化为字符串传递
                    data: jsonData,
                    success: function (data) {
                        var clothingListBySearch = data.result.clothingListBySearchPageInfo.list;
                        var pageInfo = data.result.clothingListBySearchPageInfo;
                       buildPage(clothingListBySearch);
                       buildNav(pageInfo);
                    }
                });
            };

            // 构建搜索出来的商品
            function buildPage(clothingListBySearch) {

                // 绘制前先清空所有元素及元素的数据和事件
                $(".build-page .col-md-2").remove();

                // 循环遍历 clothingListBySearch
                $.each(clothingListBySearch,function (index,value) {
                    var div = $("<div></div>").addClass("col-md-2");
                    var a = $("<a></a>").addClass("show-cloting").attr("href","${Project_Path}/clothing/to-clothingDetails/"+value.clothingId).attr("target","_blank");
                    var span1 = $("<span></span>");
                    // value.picture.split(",")[0] 切割图片路径字符串，并取出第一张图片路径
                    var img = $("<img />").attr("src","${Project_Path}/"+value.picture.split(",")[0]);
                    var span2 = $("<span></span>");
                    var span21 = $("<span></span>").addClass("clothing-title").text(value.title);
                    var span22 = $("<span></span>").addClass("clothing-price").text("￥ "+value.price);
                    var span23 = $("<span></span>").addClass("clothing-sales").text("月租 "+value.sales);

                    span1.append(img);
                    span2.append(span21).append(span22).append(span23);
                    a.append(span1).append(span2);
                    div.append(a);
                    div.appendTo(".build-page");
                });
            }

            // 构建分页条
            function buildNav(pageInfo) {

                //page_nav_area  绘制前先清空所有元素及元素的数据和事件
                $("#page_nav_area").empty();

                //构建元素
                var ul = $("<ul></ul>").addClass("pagination pagination-lg");
                var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
                var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
                if (pageInfo.hasPreviousPage == false) {
                    firstPageLi.addClass("disabled");
                    prePageLi.addClass("disabled");
                } else {
                    //为元素添加点击翻页的事件
                    firstPageLi.click(function () {
                        searchCondition.pageNum = 1;
                        search();
                        // 跳到锚记链接 商品展示开始处
                        window.location.href = "#head";
                    });
                    prePageLi.click(function () {
                        searchCondition.pageNum = pageInfo.prePage;
                        search();
                        // 跳到锚记链接 商品展示开始处
                        window.location.href = "#head";
                    });
                }


                var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
                var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
                if (pageInfo.hasNextPage == false) {
                    nextPageLi.addClass("disabled");
                    lastPageLi.addClass("disabled");
                } else {
                    nextPageLi.click(function () {
                        searchCondition.pageNum = pageInfo.nextPage;
                        search();
                        // 跳到锚记链接 商品展示开始处
                        window.location.href = "#head";
                    });
                    lastPageLi.click(function () {
                        searchCondition.pageNum = pageInfo.pages;
                        search();
                        // 跳到锚记链接 商品展示开始处
                        window.location.href = "#head";
                    });
                }

                //添加首页和前一页 的提示
                ul.append(firstPageLi).append(prePageLi);

                //1,2，3遍历给ul中添加页码提示
                $.each(pageInfo.navigatepageNums,function(index,item){

                    var numLi = $("<li></li>").append($("<a></a>").append(item));
                    if(pageInfo.pageNum == item){
                        numLi.addClass("active");
                    }
                    numLi.click(function(){
                        searchCondition.pageNum = item;
                        search();
                        // 跳到锚记链接 商品展示开始处
                        window.location.href = "#head";
                    });
                    ul.append(numLi);
                });

                //添加下一页和末页 的提示
                ul.append(nextPageLi).append(lastPageLi).css("cursor","pointer");

                //把ul加入到nav
                var navEle = $("<nav></nav>").append(ul).attr("aria-label","Page navigation");

                var numIn =  $("<input>").attr("type","text").addClass("numIn");
                var go = $("<input>").attr("type","button").addClass("go").attr("value","确定");
                go.click(function () {
                    searchCondition.pageNum = parseInt($(".numIn").val());
                    search();
                    // 跳到锚记链接 商品展示开始处
                    window.location.href = "#head";
                });
                var goGroup = $("<span></span>").addClass("goGroup").append("共"+pageInfo.pages+"页，到第 ").append(numIn).append(" 页  ").append(go);


                navEle.appendTo("#page_nav_area");
                goGroup.appendTo("#page_nav_area");
            }


            // 商品展示悬停显示阴影 用 on 添加 hover 事件时，只能拆成 mouseenter mouseleave 两个事件
            $(".background-recommend").on("mouseenter",".col-md-2",  function () {
                    $(this).css("box-shadow","0 0 10px #000");
            })
            $(".background-recommend").on("mouseleave",".col-md-2",  function () {
                $(this).css("box-shadow","none");
            })

            // ================================搜索筛选条件点击事件 start=================================================
            $(".brand span").click(function () {
                // parseInt() 字符串转整数
                var index = searchCondition.brands.indexOf(parseInt($(this).attr("brand-id")));
                if (index == -1) {
                    searchCondition.brands[searchCondition.brands.length] = parseInt($(this).attr("brand-id"));
                    $(this).css({"background":"red","color":"white"});
                } else {
                    // 删除从下标index开始的1个元素，length会变小
                    searchCondition.brands.splice(index,1);
                    $(this).css({"background":"white","color":"#777"});
                }
                // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });

            $(".category span").click(function () {
                var index = searchCondition.categorys.indexOf(parseInt($(this).attr("category-id")));
                if (index == -1) {
                    searchCondition.categorys[searchCondition.categorys.length] = parseInt($(this).attr("category-id"));
                    $(this).css({"background":"red","color":"white"});
                } else {
                    // 删除从下标index开始的1个元素，length会变小
                    searchCondition.categorys.splice(index,1);
                    $(this).css({"background":"white","color":"#777"});
                }
                 // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });

            $(".style span").click(function () {
                var index = searchCondition.styles.indexOf(parseInt($(this).attr("style-id")));
                if (index == -1) {
                    searchCondition.styles[searchCondition.styles.length] = parseInt($(this).attr("style-id"));
                    $(this).css({"background":"red","color":"white"});
                } else {
                    // 删除从下标index开始的1个元素，length会变小
                    searchCondition.styles.splice(index,1);
                    $(this).css({"background":"white","color":"#777"});
                }
                 // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });


            $(".size span").click(function () {
                // "|" + "," + $(this).text() + ","  ,不能少，否则无法区分 XL  XXL ，而 ,XL,  ,XXL, 不会出错
                var index = searchCondition.sizes.indexOf("|" + "," + $(this).text() + ",");
                if (index == -1) {
                    searchCondition.sizes += "|" + "," + $(this).text() + ",";
                    $(this).css({"background":"red","color":"white"});
                } else {
                    // 字符串替换，默认只替换搜索到的第一个子串
                    searchCondition.sizes = searchCondition.sizes.replace("|" + "," + $(this).text() + ",","");
                    $(this).css({"background":"white","color":"#777"});
                }
                 // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });


            $(".order-none").click(function () {
                $(".sale").css("color","#777");
                searchCondition.order = "clothing_id DESC";
                $(this).css("color","red");
                 // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });

            $(".sale").click(function () {
                $(".order-none").css("color","#777");
                searchCondition.order = "sales DESC";
                $(this).css("color","red");
                 // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });

            $(".sex input").click(function () {
                var index = searchCondition.sexs.indexOf($(this).val());
                if (index == -1) {
                    searchCondition.sexs[searchCondition.sexs.length] = $(this).val();
                } else {
                    // 删除从下标index开始的1个元素，length会变小
                    searchCondition.sexs.splice(index,1);
                }
                 // 筛选后，从第一页开始看
                searchCondition.pageNum = 1;
                search();
            });
            // ================================搜索筛选条件点击事件 end=================================================

        })
    </script>
</html>
