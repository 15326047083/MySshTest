<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>校园服务网</title>

    <meta name="description" content="description">

    <!-- Mobile Specific Meta
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="/css/index/img/favicon.png"/>

    <!-- CSS
    ================================================== -->
    <!-- Fontawesome Icon font -->
    <link rel="stylesheet" href="/css/index/css/font-awesome.min.css">
    <!-- bootstrap.min css -->
    <link rel="stylesheet" href="/css/index/css/bootstrap.min.css">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="/css/index/css/owl.carousel.css">
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="/css/index/css/main.css">
    <!-- Media Queries -->
    <link rel="stylesheet" href="/css/index/css/responsive.css">

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
    <!--
    Google Font
    =========================== -->

    <!-- Titillium Web -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,200' rel='stylesheet' type='text/css'>
    <!-- Source Sans Pro -->
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300' rel='stylesheet' type='text/css'>
    <!-- Oswald -->
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,700' rel='stylesheet' type='text/css'>
    <!-- Raleway -->
    <link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>

    <!-- Modernizer Script for old Browsers -->
    <script src="/css/index/js/modernizr-2.6.2.min.js"></script>

</head>
<header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">
                <h1 id="logo">
                    <img src="/css/index/img/logo-meghna.png" alt="Meghna"/>
                </h1>
            </a>
        </div>

        <nav class="collapse navbar-collapse navbar-right">
            <ul id="nav" class="nav navbar-nav">
                <li><a href="/user/toIndex">首页</a></li>
                <li><a href="/demand/gerDemandList/0">服务商城</a></li>
                <li><a href="/demand/toSaveDemand">发布服务需求</a></li>
                <shiro:notAuthenticated>
                    <li><a href="/user/toNewUser">立即注册成为会员</a></li>
                    <li><a href="/user/toLogin">登陆</a></li>
                </shiro:notAuthenticated>
                <shiro:authenticated>
                    <li><a href="/discuss/getDiscussListByGetUserId/${userSession.id}">欢迎您！${userSession.name}</a></li>
                    <shiro:hasRole name="admin">
                        <li>
                            <a href="/demand/adminGetAllList">需求管理</a>
                        </li>
                        <li>
                            <a href="/user/getUserList/${userSession.id}">用户管理</a>
                        </li>
                    </shiro:hasRole>
                    <li><a href="/user/logOut">退出登陆</a></li>
                </shiro:authenticated>
            </ul>

        </nav><!-- /.navbar-collapse -->
    </div>
</header>