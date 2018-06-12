<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/6/6
  Time: 下午4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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

<jsp:include page="../head.jsp"></jsp:include>

<section id="blog-banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">

                <div class="blog-icon">
                    <i class="fa fa-book fa-4x"></i>
                </div>
                <div class="blog-title">
                    <h1>用户管理</h1>
                </div>

            </div>     <!-- End col-lg-12 -->
        </div>        <!-- End row -->
    </div>       <!-- End container -->
</section>    <!-- End Section -->


<section id="blog-page">
    <div class="container">
        <div class="row">
            <div id="blog-posts" class="col-md-8 col-sm-8">
                <div class="post-item">
                    <div id="comments" class="comments-section">
                        <h4>共${userList.size()}个用户</h4>
                        <ol class="comment-list">
                            <li id="comment-1">
                                <c:forEach var="discussUser" items="${userList}">
                                    <div class="comment-wrap">
                                        <div class="author-avatar pull-left">
                                            <img src="/css/index/img/blog/user.jpg" alt="">
                                        </div>
                                        <div class="author-comment">
                                            <cite class="pull-left">
                                                <a href="/discuss/getDiscussListByGetUserId/${discussUser.id}">
                                                        ${discussUser.name}&nbsp;&nbsp;用户星级：
                                                    <c:forEach begin="1" end="${discussUser.star}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </a>
                                            </cite>
                                            <div style="clear:both"></div>
                                        </div>
                                        <div class="comment-content">
                                            <p>用户电话：
                                                    ${discussUser.phone}
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- Widget Section -->
            <jsp:include page="../right.jsp"></jsp:include>
            <!-- End Widget Section -->
        </div>
    </div>
</section>

<jsp:include page="../down.jsp"></jsp:include>
</body>
</html>
