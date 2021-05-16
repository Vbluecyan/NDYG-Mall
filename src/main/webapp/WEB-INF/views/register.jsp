<%--
  @Author bluecyan
  @DateTime 2021-04-17 21:57
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>注册</title>

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
        .ndyg-row{
            padding-top: 50px;
            padding-bottom: 170px;
        }
        .end{
            position: fixed;
            top: auto;
            right: 0;
            bottom: 0;
            left: 0;
        }
        .userIdError{
            padding-top: 8px;
            padding-bottom: 15px;
            color:  #a94442;
        }
        .passwordError{
            padding-top: 15px;
            padding-bottom: 8px;
            color:  #a94442;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp"></jsp:include>
    <div class="container">
        <div class="row ndyg-row">
            <div class="col-md-3">
                <a class="ndyg" href="${Project_Path}/home/to-index">你的衣柜</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-3">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户ID</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="userId" name="userId" placeholder="请输入用户ID">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">密码</label>
                        <div class="col-md-8">
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="button" id="register" class="btn btn-default btn-primary btn-block">注册</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-5">
                <div class="row userIdError">

                </div>
                <div class="row passwordError">

                </div>
            </div>
        </div>
    </div>
    <div class="end"><jsp:include page="end.jsp"></jsp:include></div>
</body>
    <script type="text/javascript">
        $(function(){
            $("#register").click(function(){
                $.get(
                    "${Project_Path}/user/check-user",
                    $("form").serialize(),
                    function (data) {
                        if (data.code == 200) {
                            //绘制前先清除数据
                            clear();
                            $(".userIdError").append(data.result.userIdError);
                            $(".form-group:first").addClass("has-error");
                        } else {
                            $.post(
                                "${Project_Path}/user/register",
                                $("form").serialize(),
                                function (data) {
                                    //js发送get请求，实现ajax请求后跳转到新页面
                                    window.location.href = "${Project_Path}"+data.result.toUrl;
                                }
                            );
                        }
                    }
                );
            });

            /**
             * 清空脚本构造的元素和样式
             */
            function clear() {
                $(".form-group:first").removeClass("has-error");
                $(".userIdError").empty();
            }
        });
    </script>
</html>
