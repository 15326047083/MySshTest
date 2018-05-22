<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/5/17
  Time: 上午8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>
                        <strong>BBS</strong> registered
                    </h1>
                    <div class="description">
                        <p>Please use your E-mail for registered!</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Registered to our site</h3>
                            <p>Use E-mail、Password and Birthday to registered:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form action="user/newUser" method="post"
                              class="login-form" id="newUser">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label> <input
                                    type="email" name="email" placeholder="E-mail..."
                                    class="form-username form-control" id="form-username"
                                    id="email" onkeyup="username(value)" value="${user.email}">
                            </div>
                            <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
                            <script type="text/javascript">
                                function username(email) {
                                    $.ajax({
                                        type: "post",
                                        data: $('#newUser').serialize(),
                                        url: '/user/verifyEmail',
                                        dataType: "json",
                                        async: false,
                                        cache: false,
                                        success: function (date) {
                                            if ("1" == date) {
                                                alert("账号已存在!!!");
                                            } else {
                                            }
                                        },
                                        error: function () {
                                            alert(1111111);
                                        },
                                    });
                                }
                            </script>
                            <div class="form-group">
                                <label class="sr-only">Password</label> <input
                                    type="password" name="password" placeholder="Password..."
                                    class="form-password form-control"
                                    value="${user.password}">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Sex</label> <select
                                    name="sex" class="form-password form-control"
                            >
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Birthday</label> <input
                                    type="date" name="birthday" placeholder="Birthday..."
                                    class="form-password form-control"
                                    value="${user.birthday}">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Code</label> <input
                                    type="text" name="code" placeholder="Code..."
                                    class="form-password form-control">
                            </div>
                            <div align="center">
                                <input id="btnSendCode" type="button" onclick="sendMessage()"
                                       value="发送验证码" class="btn"/>
                            </div>
                            <button type="submit" class="btn">Registered!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>

</html>