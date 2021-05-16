<%--
  @Author bluecyan
  @DateTime 2021-04-24 10:17
  @Description 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>个人资料</title>

    <c:set var="Project_Path" value= "${pageContext.request.getContextPath()}" />
    <script id="jquery" src="${Project_Path}/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script id="bootstrapJs" src="${Project_Path}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link id="bootstrapCss" href="${Project_Path}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <c:set var="user" value="${sessionScope.user}" />

    <style type="text/css">
        .personal-data{
            margin: 0 15px;
        }
        .head-data img {
            width: 92px;
            height: 92px;
            border-radius: 50%;
        }
        .head-data{
            border-bottom: solid 1px #dedede;
            padding-top: 10px;
            padding-bottom: 10px;
        }
        .head-data .col-xs-10{
            /*强行居中*/
            line-height: 30px;
            padding-top: 14px;
        }
        .profile-photo{
            /*放在该元素上时鼠标变成小手*/
            cursor:pointer;
        }
        .upload-profile-photo{
            margin-bottom: 20px;
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
        .basic-edit{
            color: #409eff;
            font-size: 16px;
            position: relative;
            left: 786px;
            /*放在该元素上时鼠标变成小手*/
            cursor:pointer;
        }
        .basic-button{
            margin-top: 100px;
        }
        .no-show{
            display: none;
        }
    </style>
</head>
<body>

    <!-- 按钮触发模态框 -->
     <button class="btn btn-primary btn-lg modal-button" data-toggle="modal" data-target="#myModal" style="display:none;">
         开始演示模态框
     </button>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改头像
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="profile-photo-form" action="${Project_Path}/user/file-upload" method="post" enctype="multipart/form-data" >
                        <input type="hidden" name="userId" value="${user.userId}">
                        <input type="file" class="upload-profile-photo" name="uploadFile">
                        <input type="submit" class="upload-submit" value="上传头像"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <%--    在内联框架中，因为显示的区域较小，要用col-xs-。col-md-会失效--%>
    <div class="personal-data">
        <div class="basic-top">
            <div class="row head-data">
                <div class="col-xs-2">
                    <img src="${Project_Path}/${user.getProfilePhoto()}" class="profile-photo">
                </div>
                <div class="col-xs-10">
                    <div class="row">
                        <div class="col-xs-12">
                            <span class="head-nickname">${user.getNickname()}</span>(${user.getUserId()})
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <c:if test="${user.getMember() != 0}">
                                <span class="member">会员</span>
                            </c:if>
                            <c:if test="${user.getMember() == 0}">
                                <span class="member">您还不是会员</span>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="basic-info">
            <div class="row basic-head">
                <div class="col-xs-12">
                    <span class="basic-title"><b>基本信息</b></span>
                    <span class="basic-edit">
                        <span class="glyphicon glyphicon glyphicon-edit" aria-hidden="true"></span>
                        编辑
                    </span>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-2">
                    用户&nbsp;&nbsp;ID：
                </div>
                <div class="col-xs-10">
                    ${user.getUserId()}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：
                </div>
                <div class="col-xs-10 nickname">

                    <span>
                        ${user.getNickname()}
                    </span>
                    <form class="form-inline no-show">
                        <div class="form-group">
                            <input type="text" class="form-control" value="${user.getNickname()}">
                        </div>
                    </form>

                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                </div>
                <div class="col-xs-10 sex">

                    <span>
                        ${user.getSex()}
                    </span>
                    <form class="form-inline no-show">
                        <div class="form-group">
                            <input type="text" class="form-control" value=" ${user.getSex()}">
                        </div>
                    </form>

                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    收货地址：
                </div>
                <div class="col-xs-10 shopping-address">

                    <span>
                        ${user.getShippingAddress()}
                    </span>
                    <form class="form-inline no-show">
                        <div class="form-group">
                            <input type="text" class="form-control" value="${user.getShippingAddress()}">
                        </div>
                    </form>

                </div>
            </div>

            <div class="row basic-button no-show">
                <div class="col-xs-1 col-xs-offset-5">
                    <button type="button" class="btn btn-primary cancel">取消</button>
                </div>
                <div class="col-xs-1">
                    <button type="button" class="btn btn-success confirm">确定</button>
                </div>
            </div>
        </div>

    </div>
</body>
    <script type="text/javascript">
        $(function () {

            $(".profile-photo").click(function () {
                $(".modal-button").click();
            });


            $(".basic-edit").click(function () {
                $(".nickname span").addClass("no-show");
                $(".nickname form").removeClass("no-show");

                $(".sex span").addClass("no-show");
                $(".sex form").removeClass("no-show");

                $(".shopping-address span").addClass("no-show");
                $(".shopping-address form").removeClass("no-show");

                $(".basic-button").removeClass("no-show");
            });

            $(".cancel").click(function () {
                $(".nickname form").addClass("no-show");
                $(".nickname span").removeClass("no-show");

                $(".sex form").addClass("no-show");
                $(".sex span").removeClass("no-show");

                $(".shopping-address form").addClass("no-show");
                $(".shopping-address span").removeClass("no-show");

                $(".basic-button").addClass("no-show");
            });

            $(".confirm").click(function () {

                // spring MVC pojo映射 前端没有传给后端的值即为null，在这里只传了4个值
                var user = {
                    userId: "${user.getUserId()}",
                    // password: null,
                    nickname: null,
                    sex: null,
                    // profilePhoto: null,
                    // member: null,
                    shippingAddress: null,
                    // favorites: null,
                    // suitcase: null,
                };

                user.nickname = $(".nickname input").val();
                user.sex = $(".sex input").val();
                user.shippingAddress = $(".shopping-address input").val();

                $.post({
                    url: "${Project_Path}/user/update",
                    // 告知传递参数类型类JSON，必备
                    contentType:"application/json",
                    // 将JSON转化为字符串传递
                    data: JSON.stringify(user),
                    success: function (data) {
                        var user = data.result.user;
                        $(".head-nickname").text(user.nickname);
                        $(".nickname span").text(user.nickname);
                        $(".sex span").text(user.sex);
                        $(".shopping-address span").text(user.shippingAddress);

                        $(".nickname form").addClass("no-show");
                        $(".nickname span").removeClass("no-show");

                        $(".sex form").addClass("no-show");
                        $(".sex span").removeClass("no-show");

                        $(".shopping-address form").addClass("no-show");
                        $(".shopping-address span").removeClass("no-show");

                        $(".basic-button").addClass("no-show");
                    }
                });
            });
        })
    </script>
</html>
