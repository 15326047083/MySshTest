<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/5/15
  Time: 下午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!-- Grid Component css -->
    <link rel="stylesheet" href="/css/index/css/component.css">
    <!-- Slit Slider css -->
    <link rel="stylesheet" href="/css/index/css/slit-slider.css">
    <!-- Media Queries -->
    <link rel="stylesheet" href="/css/index/css/media-queries.css">

    <!-- Oswald / Title Font -->
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
    <!-- Ubuntu / Body Font -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,300' rel='stylesheet' type='text/css'>

    <!-- Modernizer Script for old Browsers -->
    <script src="/css/index/js/modernizr-2.6.2.min.js"></script>
</head>
<body id="body">
<!--
Start Preloader
==================================== -->
<div id="loading-mask">
    <div class="loading-img">
        <img alt="Meghna Preloader" src="img/preloader.gif"/>
    </div>
</div>
<!--
End Preloader
==================================== -->

<!--/#home section-->

<!--
Fixed Navigation
==================================== -->
<jsp:include page="head.jsp"></jsp:include>
<!--
End Fixed Navigation
==================================== -->

<!--
Start About Section
==================================== -->
<section id="about" class="bg-one">
    <div class="container">
        <div class="row">

            <!-- section title -->
            <div class="title text-center wow fadeIn" data-wow-duration="1500ms">
                <h2>About <span class="color">Us</span></h2>
                <div class="border"></div>
            </div>
            <!-- /section title -->

            <!-- About item -->
            <div class="col-md-4 text-center wow fadeInUp" data-wow-duration="500ms">
                <div class="wrap-about">
                    <div class="icon-box">
                        <i class="fa fa-lightbulb-o fa-4x"></i>
                    </div>
                    <!-- Express About Yourself -->
                    <div class="about-content text-center">
                        <h3 class="ddd">灵感来源</h3>
                        <p>微信中有很多类似的服务群，代取快递、买药等等需求服务</p>
                    </div>
                </div>
            </div>
            <!-- End About item -->

            <!-- About item -->
            <div class="col-md-4 text-center wow fadeInUp" data-wow-duration="500ms" data-wow-delay="250ms">
                <div class="wrap-about">
                    <div class="icon-box">
                        <i class="fa fa-users fa-4x"></i>
                    </div>
                    <!-- Express About Yourself -->
                    <div class="about-content text-center">
                        <h3>服务人群</h3>
                        <p>我们网站主要服务于在校大学生，你可以发布需求也可以在方便的时候接取订单</p>
                    </div>
                </div>
            </div>
            <!-- End About item -->

            <!-- About item -->
            <div class="col-md-4 text-center wow fadeInUp" data-wow-duration="500ms" data-wow-delay="500ms">
                <div class="wrap-about kill-margin-bottom">
                    <div class="icon-box">
                        <i class="fa fa-users fa-4x"></i>
                    </div>
                    <!-- Express About Yourself -->
                    <div class="about-content text-center">
                        <h3>服务范围</h3>
                        <p>服务于内蒙古财经大学，但不仅限校内服务</p>
                    </div>
                </div>
            </div>
            <!-- End About item -->

        </div>        <!-- End row -->
    </div>    <!-- End container -->
</section>   <!-- End section -->

<!--
Start Counter Section
==================================== -->

<section id="counter" class="parallax-section">
    <div class="container">
        <div class="row">

            <!-- first count item -->
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms">
                <div class="counters-item">
                    <div>
                        <span data-speed="3000" data-to="320">${userNumber}</span>
                    </div>
                    <i class="fa fa-users fa-3x"></i>
                    <h3>活跃用户</h3>
                </div>
            </div>
            <!-- end first count item -->

            <!-- second count item -->
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <div>
                        <span data-speed="3000" data-to="565">${demandTypeNumber}</span>
                    </div>
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>类型总数</h3>
                </div>
            </div>
            <!-- end second count item -->

            <!-- third count item -->
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="400ms">
                <div class="counters-item">
                    <div>
                        <span data-speed="3000" data-to="95">${discussNumber}</span>
                    </div>
                    <i class="fa fa-comments fa-3x"></i>
                    <h3>评论总数</h3>

                </div>
            </div>
            <!-- end third count item -->

            <!-- fourth count item -->
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="600ms">
                <div class="counters-item kill-margin-bottom">
                    <div>
                        <span data-speed="3000" data-to="2500">${demandNumber}</span>
                    </div>
                    <i class="fa fa-coffee fa-3x"></i>
                    <h3>订单总数</h3>
                </div>
            </div>
            <!-- end fourth count item -->

        </div>        <!-- end row -->
    </div>    <!-- end container -->
</section>   <!-- end section -->


<!-- Start Services Section
==================================== -->

<section id="services" class="bg-one">
    <div class="container">
        <div class="row">

            <!-- section title -->
            <div class="title text-center wow fadeIn" data-wow-duration="500ms">
                <h2>Our <span class="color">Services</span></h2>
                <div class="border"></div>
            </div>
            <!-- /section title -->

            <!-- Single Service Item -->
            <article class="col-md-4 col-sm-6 col-xs-12 wow fadeInUp" data-wow-duration="500ms" data-wow-delay="200ms">
                <div class="service-block text-center">
                    <div class="service-icon text-center">
                        <i class="fa fa-desktop fa-5x"></i>
                    </div>
                    <h3>网页端</h3>
                </div>
            </article>
            <!-- End Single Service Item -->
            <!-- Single Service Item -->
            <article class="col-md-4 col-sm-6 col-xs-12 wow fadeInDown" data-wow-duration="500ms"
                     data-wow-delay="400ms">
                <div class="service-block text-center">
                    <div class="service-icon text-center">
                        <i class="fa fa-android fa-5x"></i>
                    </div>
                    <h3>手机端</h3>
                </div>
            </article>
            <!-- End Single Service Item -->

            <!-- Single Service Item -->
            <article class="col-md-4 col-sm-6 col-xs-12 wow fadeInDown" data-wow-duration="500ms"
                     data-wow-delay="600ms">
                <div class="service-block text-center kill-margin-bottom">
                    <div class="service-icon text-center">
                        <i class="fa fa-link fa-5x"></i>
                    </div>
                    <h3>微信小程序</h3>
                </div>
            </article>
            <!-- End Single Service Item -->

        </div>        <!-- End row -->
    </div>    <!-- End container -->
</section>   <!-- End section -->


<!-- Start Portfolio Section
=========================================== -->

<!-- Start Team Skills
=========================================== -->

<section id="team-skills" class="parallax-section">
    <div class="container">
        <div class="row wow fadeInDown" data-wow-duration="500ms">

            <!-- section title -->
            <div class="title text-center">
                <h2>Our <span class="color">Skills</span></h2>
                <div class="border"></div>
            </div>
            <!-- /section title -->
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>IntelliJ IDEA 2018</h3>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>SpringMVC 4.3.3</h3>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>Spring 4.3.3</h3>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>Hibernate 5.0.1</h3>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>Shiro 1.4.0</h3>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>Maven 中央仓库</h3>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>Mysql</h3>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 text-center wow fadeInDown" data-wow-duration="500ms"
                 data-wow-delay="200ms">
                <div class="counters-item">
                    <i class="fa fa-tags fa-3x"></i>
                    <h3>Jdk 1.8</h3>
                </div>
            </div>
        </div>        <!-- End row -->
    </div>    <!-- End container -->
</section>   <!-- End section -->
<!-- Start Our Team
=========================================== -->

<jsp:include page="down.jsp"></jsp:include>
</body>
</html>