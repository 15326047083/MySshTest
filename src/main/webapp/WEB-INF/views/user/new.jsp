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
    <title>登录(Login)</title>
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
               onkeyup="getPhone(this.value)">
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
                            document.getElementById("sureCode").value = data;
                        },
                        error: function () {
                        },
                    });
                    var input = document.createElement('input');
                    input.setAttribute('class', 'username'); //定义类型是文本输
                    input.setAttribute('name', 'code'); //定义类型是文本输入
                    input.setAttribute('id', 'code'); //定义类型是文本输入placeholder
                    input.setAttribute('placeholder', '请输入您的验证码！'); //定义类型是文本输入placeholder
                    document.getElementById('span').appendChild(input); //添加到form中显示
                } else {
                    document.getElementById('code').parentNode.removeChild(document.getElementById('code'));
                }
            }
        </script>
        <button type="submit" onclick="return submitReply()" class="submit_button">登录</button>
        <script>
            function submitReply() {
                var code = document.getElementById("code").value;
                var color = document.getElementById("num").style.color;
                var pswlen = document.getElementById("psw").value.length;
                var namelen = document.getElementById("name").value.length;
                var sureCode = document.getElementById("sureCode").value;
                if (color != "red" && pswlen >= 6 && namelen >= 1 && code == sureCode) {
                    return true;
                }
                alert(code + color + pswlen + namelen + sureCode);
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

