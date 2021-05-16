<%--
  @Author bluecyan
  @DateTime 2021-04-26 0:06
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>订单管理</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="orderList" value="${requestScope.orderList}"/>

    <style type="text/css">
        .my-order{
            line-height: 4;
        }
        .one-order{
            margin: 15px 0;
            border: solid 1px #dedede;
        }
        .no-show{
            display: none;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="container my-order">

        <div class="row">
            <div class="col-md-1" style="padding: 0px!important;">
                <b>我的订单</b>
            </div>
        </div>
        <c:forEach items="${orderList}" var="item">
            <div class="row one-order">
                <div class="col-md-2">
                    订单号：${item.orderId}
                </div>
                <div class="col-md-2">
                    服装ID：
                    <a href="${Project_Path}/clothing/to-clothingDetails/${item.clothingId}" target="_blank">${item.clothingId}</a>
                </div>
                <div class="col-md-2">
                    价格：${item.money}
                </div>
                <div class="col-md-3">
                    订单创建时间：<fmt:formatDate value="${item.creationDatetime}" type="both" />
                </div>
                <c:if test="${item.finishDatetime != null}">
                    <div class="col-md-3">
                        订单完成时间：<fmt:formatDate value="${item.finishDatetime}" type="both" />
                    </div>
                </c:if>
                <div class="col-md-3 finishDatetime${item.orderId} no-show">

                </div>
                <div class="col-md-3">
                    预期归还时间：<fmt:formatDate value="${item.expectantReturnDate}" type="date" />
                </div>
                <c:if test="${item.actualReturnDate != null}">
                    <div class="col-md-3">
                        实际归还时间：<fmt:formatDate value="${item.actualReturnDate}" type="date" />
                    </div>
                </c:if>
                <div class="col-md-3 actualReturnDate${item.orderId} no-show">

                </div>

                <c:choose>
                    <c:when test="${item.finishDatetime == null}">
                        <div class="col-md-1">
                            <button type="button" class="btn btn-primary cancel-order" orderId="${item.orderId}">取消订单</button>
                        </div>

                        <div class="col-md-1">
                            <button type="button" class="btn btn-primary confirm-receive" orderId="${item.orderId}">确认收货</button>
                        </div>
                    </c:when>
                    <c:when test="${item.finishDatetime != null}">
                        <c:if test="${item.actualReturnDate == null}">
                            <div class="col-md-1">
                                <button type="button" class="btn btn-primary return-clothing" orderId="${item.orderId}">申请还衣</button>
                            </div>
                        </c:if>
                        <c:if test="${item.commentText == null}">
                            <div class="col-md-1">
                                <button type="button" class="btn btn-primary comment comment-${item.orderId}" data-toggle="modal" data-target="#myModal-${item.orderId}" orderId="${item.orderId}">立即评价</button>
                            </div>
                        </c:if>
                    </c:when>
                </c:choose>
                <div class="col-md-1 no-show">
                    <button type="button" class="btn btn-primary return-clothing" orderId="${item.orderId}">申请还衣</button>
                </div>

                <div class="col-md-1 no-show">
                    <button type="button" class="btn btn-primary comment comment-${item.orderId}" data-toggle="modal" data-target="#myModal-${item.orderId}" orderId="${item.orderId}">立即评价</button>
                </div>

                <!-- 按钮触发模态框 -->
               <%-- <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    开始演示模态框
                </button>--%>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal-${item.orderId}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    评价
                                </h4>
                            </div>
                            <div class="modal-body">
                                <textarea rows="16" cols="76" class="form-control comment-text-${item.orderId}"></textarea>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary submit-comment" data-dismiss="modal" orderId="${item.orderId}">
                                    提交评价
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

            </div>
        </c:forEach>

    </div>
    <jsp:include page="end.jsp"></jsp:include>
</body>
    <script type="text/javascript">
        $(function () {
            $(".cancel-order").click(function () {
                var element = $(this);
                $.ajax({
                    url: "${Project_Path}/order/cancel-order/"+$(this).attr("orderId"),
                    type: "DELETE",
                    success: function (result) {
                        // 在ajax的success里用$(this)选择不到元素,在ajax之前声明一个用var声明一个全局变量，然后在success中用声明的全局变量代替$(this)即可
                        element.parent().parent().remove();
                    }
                });
            });

            $(".confirm-receive").click(function () {
                var element = $(this);
                $.ajax({
                    url: "${Project_Path}/order/confirm-receive/"+$(this).attr("orderId"),
                    type: "PUT",
                    success: function (result) {
                        $(".finishDatetime"+element.attr("orderId")).removeClass("no-show").text("订单完成时间："+result.result.dateStr);
                        element.parent().parent().find(".cancel-order").parent().addClass("no-show");
                        element.parent().addClass("no-show");
                        element.parent().parent().find(".return-clothing").parent().removeClass("no-show");
                        element.parent().parent().find(".comment").parent().removeClass("no-show");
                    }
                });
            });

            $(".return-clothing").click(function () {
                var element = $(this);
                $.ajax({
                    url: "${Project_Path}/order/return-clothing/"+$(this).attr("orderId"),
                    type: "PUT",
                    success: function (result) {
                        $(".actualReturnDate"+element.attr("orderId")).removeClass("no-show").text("实际归还时间："+result.result.dateStr);
                        element.parent().remove();
                    }
                });
            });


            $(".submit-comment").click(function () {
                var order = {
                    orderId: $(this).attr("orderId"),
                    commentText: $(".comment-text-"+$(this).attr("orderId")).val()
                }

                var element = $(this);

                $.post({
                    url: "${Project_Path}/order/comment",
                    // 告知传递参数类型类JSON，必备
                    contentType:"application/json",
                    // 将JSON转化为字符串传递
                    data: JSON.stringify(order),
                    success: function () {
                        $(".comment-"+element.attr("orderId")).parent().remove();
                    }
                });
            });
        })
    </script>
</html>
