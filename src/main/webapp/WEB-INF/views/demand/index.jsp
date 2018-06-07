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
                    <h1>${title}</h1>
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
                                    <c:when test="${d.flag==1}">
                                        <span class="post-tags"><i class="fa fa-gift"></i>已有服务商接单</span>
                                    </c:when>
                                    <c:when test="${d.flag==4}">
                                        <span class="post-tags"><i class="fa fa-gift"></i>需求订单已过期</span>
                                    </c:when>
                                </c:choose>
                                <c:if test="${d.flag==0}">
                                <span class="post-tags">
                                <i class="fa fa-arrow-circle-right"></i><a
                                        href="/demand/takeDemand/${d.id}/${userSession.id}">接受订单</a>
                            </span>
                                </c:if>
                                <c:if test="${userSession.id==d.getUserId}">
                                    <span class="post-tags">
                                <i class="fa fa-arrow-circle-left"></i><a
                                            href="/demand/takeDemand/${d.id}/null">放弃订单</a>
                            </span>
                                </c:if>
                            </div>
                        </article>
                    </c:forEach>

                    <!-- End Single Post -->

                    <div class="next-prev clearfix">
                        <a href="" class="prev-post">
                            <i class="fa fa-angle-left fa-2x"></i>Previous Post
                        </a>
                        <a href="" class="next-post pull-right">
                            Next Post<i class="fa fa-angle-right fa-2x"></i>
                        </a>
                    </div>
                    <div class="author-about clearfix">
                        <h4>About Jhon Doe</h4>
                        <div class="post-author pull-left">
                            <img src="/css/index/img/blog/avatar.png" alt="">
                        </div>
                        <div class="author-bio">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae modi quisquam
                                laboriosam, expedita ea natus tempora unde sed sequi velit, quia veniam libero quos
                                sunt.</p>
                            <h5>Follow The Author</h5>
                            <div class="social-profile">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook-square fa-2x"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter-square fa-2x"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a></li>
                                </ul>
                            </div>
                        </div>

                    </div>

                    <div id="comments" class="comments-section">
                        <h4>4 Comments</h4>
                        <ol class="comment-list">
                            <li id="comment-1">
                                <div class="comment-wrap">
                                    <div class="author-avatar pull-left">
                                        <img src="img/blog/user.jpg" alt="">
                                    </div>
                                    <div class="author-comment">
                                        <cite class="pull-left"><a href="#">Smithson</a></cite>
                                        <a href="" class="replay pull-right">Replay</a>
                                        <div style="clear:both"></div>
                                        <div class="comment-meta">
                                            <i class="fa fa-calendar"></i> 26 aug 2013 at 07:30 PM
                                        </div>
                                    </div>
                                    <div class="comment-content">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non, repellendus.
                                            Culpa nam aut vel. Ab, excepturi minus, quasi debitis quaerat animi, enim
                                            quod repellat minima dolores facere veniam quam quo!</p>
                                    </div>
                                </div>
                                <ul>
                                    <li id="comment-2">
                                        <div class="comment-wrap">
                                            <div class="author-avatar pull-left">
                                                <img src="img/blog/user.jpg" alt="">
                                            </div>
                                            <div class="author-comment">
                                                <cite class="pull-left"><a href="#">Smithson</a></cite>
                                                <a href="" class="replay pull-right">Replay</a>
                                                <div style="clear:both"></div>
                                                <div class="comment-meta">
                                                    <i class="fa fa-calendar"></i> 26 aug 2013 at 07:30 PM
                                                </div>
                                            </div>
                                            <div class="comment-content">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non,
                                                    repellendus. Culpa nam aut vel. Ab, excepturi minus, quasi debitis
                                                    quaerat animi, enim quod repellat minima dolores facere veniam quam
                                                    quo!</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li id="comment-3">
                                        <div class="comment-wrap">
                                            <div class="author-avatar pull-left">
                                                <img src="img/blog/user.jpg" alt="">
                                            </div>
                                            <div class="author-comment">
                                                <cite class="pull-left"><a href="#">Smithson</a></cite>
                                                <a href="" class="replay pull-right">Replay</a>
                                                <div style="clear:both"></div>
                                                <div class="comment-meta">
                                                    <i class="fa fa-calendar"></i> 26 aug 2013 at 07:30 PM
                                                </div>
                                            </div>
                                            <div class="comment-content">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non,
                                                    repellendus. Culpa nam aut vel. Ab, excepturi minus, quasi debitis
                                                    quaerat animi, enim quod repellat minima dolores facere veniam quam
                                                    quo!</p>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <div class="comment-wrap">
                                    <div class="author-avatar pull-left">
                                        <img src="img/blog/user.jpg" alt="">
                                    </div>
                                    <div class="author-comment">
                                        <cite class="pull-left"><a href="#">Smithson</a></cite>
                                        <a href="" class="replay pull-right">Replay</a>
                                        <div style="clear:both"></div>
                                        <div class="comment-meta">
                                            <i class="fa fa-calendar"></i> 26 aug 2013 at 07:30 PM
                                        </div>
                                    </div>
                                    <div class="comment-content">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non, repellendus.
                                            Culpa nam aut vel. Ab, excepturi minus, quasi debitis quaerat animi, enim
                                            quod repellat minima dolores facere veniam quam quo!</p>
                                    </div>
                                </div>
                            </li>
                        </ol>
                    </div>

                    <div class="comment-reply-form">
                        <h3>Leave a Replay</h3>
                        <form id="comment-form" method="post" action="#">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Name *" id="name" name="name"
                                       required>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="E-mail *" id="email" name="email"
                                       required>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Website" id="website"
                                       name="website">
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <textarea class="form-control" placeholder="Message *" id="message" name="message"
                                          rows="5" cols="5" required></textarea>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <input type="submit" id="post-comment" value="Post Comment" class="btn btn-transparent">
                            </div>
                            <!-- End .form-group -->
                        </form>
                    </div>
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