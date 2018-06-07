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
<body class="blog-page">
<!--
Start Preloader
==================================== -->
<div id="loading-mask">
    <div class="loading-img">
        <img alt="Meghna Preloader" src="/css/index/img/preloader.gif"/>
    </div>
</div>
<!--
End Preloader
==================================== -->

<!--
Fixed Navigation
==================================== -->
<jsp:include page="../head.jsp"></jsp:include>
<!--
End Fixed Navigation
==================================== -->


<!-- Start Blog Banner
==================================== -->
<section id="blog-banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">

                <div class="blog-icon">
                    <i class="fa fa-book fa-4x"></i>
                </div>
                <div class="blog-title">
                    <h1>订单详情</h1>
                </div>

            </div>     <!-- End col-lg-12 -->
        </div>        <!-- End row -->
    </div>       <!-- End container -->
</section>    <!-- End Section -->


<!-- Start Blog Post Section
==================================== -->
<section id="blog-page">
    <div class="container">
        <div class="row">

            <div id="blog-posts" class="col-md-8 col-sm-8">
                <div class="post-item">

                    <!-- Single Post -->
                    <article class="entry wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                        <div class="post-excerpt">
                            <h3>佣金：${d.bounty} 元人民币</h3>
                            ${d.info}
                        </div>
                        <div class="post-excerpt">
                            <h3>详细信息以及联系方式如下，请自行进行交易！</h3>
                            发布者学号：${d.setUserNum}<br>
                            发布者姓名：${d.setUserName}<br>
                            发布者性别：${d.setUserSex}<br>
                            发布者微信：${d.weixin}<br>
                            发布者QQ：${d.qq}<br>
                            任务佣金：${d.bounty}<br>
                            任务交付地点：${d.place}<br>
                            发布者星级：<c:forEach begin="0" end="${d.setUserStar}" step="1"><i
                                class="fa fa-star"></i></c:forEach><br>
                        </div>
                        <div class="post-meta">
                            <span class="post-date">
                                发布时间：${d.startTime}
                            </span>
                            <span class="post-date">
                                截止时间：${d.endTime}
                            </span>
                            <c:choose>
                                <c:when test="${d.setUserId==userSession.id}">
                                    <span class="post-tags"><i class="fa fa-arrow-circle-left"></i><a
                                            href="/demand/delete/${userSession.id}/${d.demandId}">删除订单</a></span>
                                </c:when>
                                <c:otherwise>
                                    <span class="post-tags"><i class="fa fa-arrow-circle-left"></i><a
                                            href="/demand/takeDemand/${d.demandId}/null">放弃订单</a></span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </article>
                    <!-- End Single Post -->
                </div>
            </div>

            <!-- Widget Section -->
            <jsp:include page="../right.jsp"></jsp:include>
            <!-- End Widget Section -->

        </div>        <!-- End row -->
    </div>       <!-- End container -->
</section>    <!-- End Section -->

<!--
Essential Scripts
=====================================-->
<jsp:include page="../down.jsp"></jsp:include>
</body>
</html>