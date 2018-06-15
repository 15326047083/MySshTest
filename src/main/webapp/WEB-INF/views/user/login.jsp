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


    <style type="text/css">
        /* 弹窗 (background) */
        .modal {
            display: none; /* 默认隐藏 */
            position: fixed; /* 固定定位 */
            z-index: 1; /* 设置在顶层 */
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0, 0, 0);
            background-color: rgba(0, 0, 0, 0.4);
        }

        /* 弹窗内容 */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* 关闭按钮 */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="page-container">
    <h1>登录(Login)</h1>
    <form action="/user/login" method="post">
        <input type="text" name="num" class="username" placeholder="请输入您的学号！">
        <input type="password" name="password" class="password" placeholder="请输入您的密码！">
        <a href="/user/toNewUser" style="color: blue;">立即注册</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" style="color: blue;" id="myBtn">使用验证码登陆</a>
        <button type="submit" class="submit_button">登录</button>
    </form>

    <!-- 弹窗 -->
    <div id="myModal" class="modal">
        <!-- 弹窗内容 -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <div align="center">
                <script>
                    function phoneLogin(phone) {
                        if (phone.length == 11) {
                            $.ajax({
                                type: "post",
                                url: '/user/loginByPhone/' + phone,
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
                                        document.getElementById("phone").readOnly = true;
                                    }
                                },
                                error: function () {
                                },
                            });
                        } else {
                            document.getElementById("code").type = "hidden";
                        }
                    }

                    function writeCode(code) {
                        if (code == document.getElementById("sureCode").value) {
                            document.getElementById("code").style.color = "green";
                        } else {
                            document.getElementById("code").style.color = "red";
                        }
                    }

                    function login() {
                        if (document.getElementById("code").style.color == "green") {
                            return true;
                        } else {
                            alert("验证码错误！");
                            return false;
                        }
                    }
                </script>
                <form action="/user/loginPhone" method="post">
                    <input id="phone" type="number" name="phone" placeholder="请输入手机号" required
                           onkeyup="phoneLogin(this.value)"><br>
                    <input id="code" type="hidden" name="code" onkeyup="writeCode(this.value)" placeholder="请输入验证码"><br>
                    <input type="hidden" id="sureCode">
                    <input class="tag" type="submit" value="登陆" onclick="return login()">
                </form>
            </div>
        </div>
    </div>
    <script>
        // 获取弹窗
        var modal = document.getElementById('myModal');

        // 打开弹窗的按钮对象
        var btn = document.getElementById("myBtn");

        // 获取 <span> 元素，用于关闭弹窗
        var span = document.querySelector('.close');

        // 点击按钮打开弹窗
        btn.onclick = function () {
            modal.style.display = "block";
        }

        // 点击 <span> (x), 关闭弹窗
        span.onclick = function () {
            modal.style.display = "none";
        }

        // 在用户点击其他地方时，关闭弹窗
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</div>

<!-- Javascript -->
<script src="/css/login/js/jquery-1.8.2.min.js"></script>
<script src="/css/login/js/supersized.3.2.7.min.js"></script>
<script src="/css/login/js/supersized-init.js"></script>
<script src="/css/login/js/scripts.js"></script>

</body>
</html>

