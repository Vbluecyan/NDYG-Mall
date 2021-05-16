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
    <title>账号设置</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="user" value="${sessionScope.user}" />

    <style type="text/css">
        .account-set{
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
        .alter-edit, .close-edit{
            color: #409eff;
            position: relative;
            left: 455px;
            /*放在该元素上时鼠标变成小手*/
            cursor:pointer;
        }
        .basic-password input, .basic-close input{
            width: 240px!important;
        }
        .no-show{
            /*虽然不可见，占据的位置不会少*/
            visibility: hidden;
        }

    </style>
</head>
<body>
    <div class="account-set">
        <div class="basic-info">

            <div class="row basic-head">
                <div class="col-xs-12">
                    <span class="basic-title"><b>账号设置</b></span>
                </div>
            </div>

            <div class="row basic-password">
                <div class="col-xs-2">
                    密码：
                </div>
                <div class="col-xs-10">
                    <form class="form-inline">
                        <div class="form-group no-show">
                            <input type="password" class="form-control" placeholder="请输入当前密码">
                        </div>
                        <span class="alter-edit">
                            修改密码
                        </span>
                    </form>
                </div>
            </div>


            <div class="row basic-close">
                <div class="col-xs-2">
                    注销：
                </div>
                <div class="col-xs-10">
                    <form class="form-inline">
                        <div class="form-group no-show">
                            <input type="password" class="form-control" placeholder="请输入当前密码">
                        </div>
                        <span class="close-edit">
                        注销账号
                        </span>
                    </form>
                </div>
            </div>


        </div>
    </div>
</body>
    <script type="text/javascript">
        $(function () {

            $(".alter-edit").click(function () {
                // $.trim($(this).text()) $(this).text()获取的文本前后有空格，用$.trim()去掉
                switch ($.trim($(this).text())) {
                    case "修改密码":
                        $(".basic-password .form-group").removeClass("no-show");
                        $(this).text("确认验证");
                        break;
                    case "确认验证":
                        var code = checkCurrentPassword($(".basic-password input").val());
                        // 清空表单数据
                        $(".basic-password form")[0].reset();
                        if (code == 200) {
                            $(".basic-password input").attr("placeholder","密码验证错误！请确认后重新输入");
                        }
                        if (code == 100) {
                            $(".basic-password input").attr("placeholder","请输入新密码");
                            $(this).text("确认修改");
                        }
                        break;
                    case "确认修改":
                        updatePassword();
                        break;
                }
            });

            function checkCurrentPassword (password) {
                var user = {
                    userId: "${user.userId}",
                    password: password
                }

                var code = null;

                $.post({
                    // async: false 同步操作才能保证code获取到正确的值
                    async: false,
                    url: "${Project_Path}/user/check-current-password",
                    // 告知传递参数类型类JSON，必备
                    contentType:"application/json",
                    // 将JSON转化为字符串传递
                    data: JSON.stringify(user),
                    success: function (data) {
                        code = data.code;
                    }
                });

                return code;
            };

            function updatePassword() {
                var user = {
                    userId: "${user.userId}",
                    password: null
                }
                user.password = $(".basic-password input").val();

                // target=_top  在整个浏览器窗口打开，而不是在内联框架内打开
                window.open("${Project_Path}/user/update-password/"+user.userId+"/"+user.password,"_top");
            }


            $(".close-edit").click(function () {
                // $.trim($(this).text()) $(this).text()获取的文本前后有空格，用$.trim()去掉
                switch ($.trim($(this).text())) {
                    case "注销账号":
                        $(".basic-close .form-group").removeClass("no-show");
                        $(this).text("确认验证");
                        break;
                    case "确认验证":
                        var code = checkCurrentPassword($(".basic-close input").val());
                        // 清空表单数据
                        $(".basic-close form")[0].reset();
                        if (code == 200) {
                            $(".basic-close input").attr("placeholder","密码验证错误！请确认后重新输入");
                        }
                        if (code == 100) {
                            $(".basic-close input").attr("placeholder","请点击确认注销完成注销账号操作");
                            $(this).text("确认注销");
                        }
                        break;
                    case "确认注销":
                        deleteUser();
                        break;
                }
            });

            function deleteUser() {

                // target=_top  在整个浏览器窗口打开，而不是在内联框架内打开
                window.open("${Project_Path}/user/delete-user/${user.userId}","_top");
            }

        })
    </script>
</html>
