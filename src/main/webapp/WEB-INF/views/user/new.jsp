<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/5/16
  Time: 下午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>内蒙古财经大学服务网站注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- CSS -->
    <link rel="stylesheet" href="/css/login/css/reset.css">
    <link rel="stylesheet" href="/css/login/css/supersized.css">
    <link rel="stylesheet" href="/css/login/css/style.css">
</head>

<body>

<div class="page-container">
    <h1>注册(New)</h1>
    <form action="/user/newUser" method="post" id="newUserFrom">
        <input type="number" name="num" class="username" placeholder="请输入您的学号！" onkeyup="username(this.value)" id="num">
        <input type="text" name="name" class="username" placeholder="请输入您的姓名！" id="name">
        <input type="password" name="password" class="password" placeholder="请输入您的密码！" id="psw">
        <select name="sex" class="username" style="width: 349px;">
            <option value=" 男">男</option>
            <option value="女">女</option>
        </select>
        <span id="span">
        <input id="phone" type="number" name="phone" class="username" placeholder="请输入您的手机号！"
               onkeyup="getPhone(this.value)" required>
        <input id="code" type="hidden" name="code" class="username" placeholder="请输入您的验证码！" required>
        </span>
        <script>
            function username(num) {
                $.ajax({
                    type: "post",
                    url: '/user/verifyEmail/' + num,
                    async: false,
                    cache: false,
                    success: function (data) {
                        if (data == "1") {
                            document.getElementById("num").style.color = "red";
                        } else {
                            document.getElementById("num").style.color = "white";
                        }
                    },
                    error: function () {
                    },
                });
            }

            function getPhone(phone) {
                if (phone.length == 11) {
                    $.ajax({
                        type: "post",
                        url: '/user/sendCode/' + phone,
                        async: false,
                        cache: false,
                        success: function (data) {
                            if (data == "0") {
                                document.getElementById("phone").style.color = "red";
                                document.getElementById("code").type = "hidden";
                            } else {
                                document.getElementById("phone").style.color = "white";
                                document.getElementById("code").type = "number";
                                document.getElementById("sureCode").value = data;
                            }
                        },
                        error: function () {
                        },
                    });
                } else {
                    document.getElementById("code").type = "hidden";
                }
            }
        </script>
        <button type="submit" onclick="return submitReply()" class="submit_button">注册并登陆</button>
        <a href="/user/toLogin" style="color: blue;">返回登陆</a>
        <script>
            function submitReply() {
                var code = document.getElementById("code").value;
                var numColor = document.getElementById("num").style.color;
                var phoneColor = document.getElementById("phone").style.color;
                var pswlen = document.getElementById("psw").value.length;
                var namelen = document.getElementById("name").value.length;
                var sureCode = document.getElementById("sureCode").value;
                var numlen = document.getElementById("num").value.length;
                if (numColor != "red" && pswlen >= 6 && namelen >= 1 && code == sureCode && phoneColor != "red" && numlen == 9) {
                    return true;
                }
                var message = "";
                if (code != sureCode)
                    message = message + "验证码错误！\n";
                if (numColor == "red")
                    message = message + "该账号已存在，请务必使用自己的学号进行注册！\n";
                if (numlen != 9)
                    message = message + "学号错误，请务必使用自己的学号进行注册！\n";
                if (phoneColor == "red")
                    message = message + "该手机已注册！\n";
                if (pswlen < 6)
                    message = message + "密码过短，请加强密码！\n";
                alert(message);
                return false;
            }
        </script>
    </form>
    <input type="hidden" id="sureCode">
</div>

<!-- Javascript -->
<script src="/css/login/js/jquery-1.8.2.min.js"></script>
<script src="/css/login/js/supersized.3.2.7.min.js"></script>
<script src="/css/login/js/supersized-init.js"></script>
<script src="/css/login/js/scripts.js"></script>

</body>
</html>

