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
                    <h1>${title}(${demandList.size()})</h1>
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
                    <c:forEach var="d" items="${demandList}">
                        <article class="entry wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                            <div class="post-excerpt">
                                <h3>佣金：${d.bounty} 元人民币</h3>
                                    ${d.info}
                            </div>
                            <div class="post-meta">
                            <span class="post-date">
                                <i class="fa fa-calendar"></i>${d.endTime}
                            </span>
                                <c:choose>
                                    <c:when test="${d.flag==0}">
                                        <span class="post-tags"><i class="fa fa-gift"></i>等待服务商接单</span>
                                    </c:when>
                                    <c:when test="${d.flag==2}">
                                        <span class="post-tags"><i class="fa fa-gift"></i>
                                            <a href="/discuss/getDiscussListByGetUserId/${d.getUserId}">
                                                查看服务商评价
                                            </a>
                                        </span>
                                    </c:when>
                                    <c:when test="${d.flag==2&&userSession.id==d.setUserId}">
                                        <span class="post-tags"><i class="fa fa-gift"></i>
                                            <a href="/demand/finishDemand/${d.id}/${userSession.id}">
                                                订单已完成，前往评价服务商
                                            </a>
                                        </span>
                                    </c:when>
                                    <c:when test="${d.flag==1}">
                                        <span class="post-tags"><a
                                                href="/discuss/getDiscussListByGetUserId/${d.getUserId}"><i
                                                class="fa fa-gift"></i>已有服务商接单</a></span>
                                        <c:if test="${userSession.id==d.setUserId}">
                                            <span class="post-tags"><i class="fa fa-gift"></i><a
                                                    href="/demand/finishDemand/${d.id}/${userSession.id}">确认完成</a>
                                            </span>
                                        </c:if>
                                    </c:when>
                                    <c:when test="${d.flag==4}">
                                        <span class="post-tags"><i class="fa fa-gift"></i>需求订单已过期</span>
                                    </c:when>
                                </c:choose>
                                <c:if test="${d.flag==0&&userSession.id!=d.setUserId}">
                                <span class="post-tags">
                                <i class="fa fa-arrow-circle-right"></i><a
                                        href="/demand/takeDemand/${d.id}/${userSession.id}">接受订单</a>
                            </span>
                                </c:if>
                                <c:if test="${userSession.id==d.getUserId&&d.flag!=2}">
                                    <span class="post-tags">
                                <i class="fa fa-arrow-circle-left"></i><a
                                            href="/demand/takeDemand/${d.id}/null">放弃订单</a>
                            </span>
                                </c:if>
                                <c:if test="${userSession.id==d.getUserId||userSession.id==d.setUserId}">
                                    <span class="post-tags">
                                <i class="fa fa-search"></i><a
                                            href="/demand/getDemandById/${d.id}">查看详情</a>
                            </span>
                                </c:if>
                            </div>
                        </article>
                    </c:forEach>

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