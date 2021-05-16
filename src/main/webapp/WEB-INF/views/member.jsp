<%--
  @Author bluecyan
  @DateTime 2021-04-24 10:28
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>开通会员</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="user" value="${sessionScope.user}" />

    <style type="text/css">
        .member-set{
            margin: 0 15px;
        }
        .basic-info{
            line-height: 3.5;
        }
        .basic-head{
            border-bottom: solid 1px #dedede;
        }
        .basic-title{
            font-size: 18px;
        }
        .pay-edit{
            color: #409eff;
            position: relative;
            left: 20px;
            /*放在该元素上时鼠标变成小手*/
            cursor:pointer;
        }
        .basic-member input {
            width: 240px!important;
        }
        .no-show{
            /*不可见，不占据位置*/
            display: none;
        }
    </style>
</head>
<body>
    <div class="member-set">
        <div class="basic-info">

            <div class="row basic-head">
                <div class="col-xs-12">
                    <span class="basic-title"><b>开通会员</b></span>
                </div>
            </div>

            <div class="row basic-member">
                <c:if test="${user.member == 1}">
                    <div class="col-xs-2">
                        您已经是会员了
                    </div>
                </c:if>
                <c:if test="${user.member == 0}">
                    <div class="col-xs-2 is-member no-show">
                        您已经是会员了
                    </div>
                    <div class="col-xs-2 no-member">
                        开通会员：
                    </div>
                    <div class="col-xs-1 col-xs-offset-8 no-member" style="color: red">
                        ￥&nbsp;499
                    </div>
                    <div class="col-xs-1 no-member">
                        <span class="pay-edit">
                            支付
                        </span>
                    </div>
                </c:if>
            </div>

        </div>
    </div>
</body>
    <script type="text/javascript">
        $(function () {
            $(".pay-edit").click(function () {
                $.ajax({
                    url: "${Project_Path}/user/become-member/"+"${user.userId}",
                    type: "PUT",
                    success: function (result) {
                        if (result.code == 100 && result.result.user.member == 1) {
                            $(".is-member").removeClass("no-show");
                            $(".no-member").addClass("no-show");
                        }
                    }
                });
            });
        })
    </script>
</html>