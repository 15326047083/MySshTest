<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
                    <h1>类型管理(${typeList.size()})</h1>
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
                    <c:forEach var="d" items="${typeList}">
                        <article class="entry wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                            <div class="post-excerpt">
                                <h3>名称：${d.name}</h3>
                                <h4>简介：${d.info}</h4>
                            </div>
                            <div class="post-meta">
                                <span class="post-date">
                                    <i class="fa fa-calendar"></i>创建时间：${d.buildTime}
                                </span>
                                <shiro:hasRole name="admin">
                                <span class="post-tags"><i class="fa fa-arrow-circle-right"></i><a
                                        href="/demand/queryByTypeId/${d.id}">查看订单</a>
                                </span>
                                    <span class="post-tags"><i class="fa fa-arrow-circle-left"></i><a
                                            href="/demandType/deleteDemandType/${d.id}"
                                            onclick="return deleteType(${d.demandNum})">删除</a>
                                </span>
                                </shiro:hasRole>
                            </div>
                        </article>
                    </c:forEach>
                    <script>
                        function deleteType(num) {
                            if (num > 0) {
                                alert("该类型下还有订单，无法进行删除操作！")
                                return false;
                            } else {
                                return true;
                            }
                        }
                    </script>
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