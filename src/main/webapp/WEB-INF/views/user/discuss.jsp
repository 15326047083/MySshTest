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
<script type="text/javascript" charset="utf-8"
        src="/css/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
        src="/css/ueditor/ueditor.all.min.js">

</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
        src="<%=request.getContextPath()%>/ueditor/lang/zh-cn/zh-cn.js"></script>
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
                    <h1>用户详情</h1>
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

                    <div class="author-about clearfix">
                        <h4>关于${getDiscussUser.name}</h4>
                        <div class="post-author pull-left">
                            <img src="/css/index/img/blog/avatar.png" alt="">
                        </div>
                        <div class="author-bio">
                            <p>姓名：${getDiscussUser.name}</p>
                            <p>学号：${getDiscussUser.num}</p>
                            <shiro:hasRole name="admin">
                                <p>密码：${getDiscussUser.password}</p>
                            </shiro:hasRole>
                            <p>电话：${getDiscussUser.phone}</p>
                            <p>性别：${getDiscussUser.sex}</p>
                            <p>星级：
                                <c:forEach begin="1" end="${getDiscussUser.star}" step="1">
                                    <i class="fa fa-star"></i>
                                </c:forEach>
                            </p>
                            <shiro:hasRole name="admin">
                                <p>角色信息：
                                    <c:forEach var="roles" items="${rolesList}">
                                        ${roles.roles}&nbsp;
                                    </c:forEach>
                                    <c:if test="${rolesList.size()>0}">
                                        <a href="/user/deleteUser/${getDiscussUser.id}">删除该用户角色信息</a>
                                    </c:if>
                                </p>
                                <p>赋予角色信息：
                                <form action="/user/newUserRoles/${getDiscussUser.id}" method="post">
                                    <input type="hidden" name="studentNum" value="${getDiscussUser.num}">
                                    <select name="roles" class="btn btn-transparent">
                                        <option value="user">user</option
                                        <option value="admin">admin</option>
                                    </select>
                                    <input class="btn btn-transparent" type="submit" value="添加角色">
                                </form>
                                </p>
                            </shiro:hasRole>
                        </div>

                    </div>

                    <c:if test="${flag==1}">
                        <div id="comments" class="comments-section">
                            <form action="/discuss/saveDiscuss" method="post">
                                <input type="hidden" id="info" name="info"/>
                                <input type="hidden" id="getUserId" name="getUserId" value="${getDiscussUser.id}"/>
                                <input type="hidden" name="setUserId" value="${userSession.id}">
                                <script id="editor" type="text/plain"><p>发表评论！！！</p></script>
                                <script type="text/javascript">
                                    //实例化编辑器
                                    var ue = UE.getEditor('editor');
                                </script>
                                <script type="text/javascript">
                                    function submitInfo() {
                                        document.getElementById('info').value = UE
                                            .getEditor('editor')
                                            .getContent();
                                        return true;
                                    }
                                </script>

                                <div class="form-group">
                                    <select name="star" class="form-control">
                                        <option value="1">🌟</option>
                                        <option value="2">🌟🌟</option>
                                        <option value="3">🌟🌟🌟</option>
                                        <option value="4">🌟🌟🌟🌟</option>
                                        <option value="5">🌟🌟🌟🌟🌟</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" onclick="return submitInfo()" class="btn btn-transparent">发表评论
                                    </button>
                                </div>
                            </form>
                        </div>
                    </c:if>

                    <div id="comments" class="comments-section">
                        <h4>${discussNum}条评价</h4>
                        <ol class="comment-list">
                            <li id="comment-1">
                                <c:forEach var="discussUser" items="${discussUserList}">
                                    <div class="comment-wrap">
                                        <div class="author-avatar pull-left">
                                            <img src="/css/index/img/blog/user.jpg" alt="">
                                        </div>
                                        <div class="author-comment">
                                            <cite class="pull-left">
                                                <a href="/discuss/getDiscussListByGetUserId/${discussUser.setUserId}">
                                                        ${discussUser.setUserName}&nbsp;&nbsp;用户星级：
                                                    <c:forEach begin="1" end="${discussUser.setUserStar}" step="1">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                </a>
                                            </cite>
                                            <shiro:hasRole name="admin">
                                                <a href="/discuss/deleteDiscussById/${discussUser.discussId}"
                                                   class="replay pull-right">删除</a>
                                            </shiro:hasRole>
                                            <div style="clear:both"></div>
                                            <div class="comment-meta">
                                                <i class="fa fa-calendar"></i>${discussUser.date}
                                            </div>
                                        </div>
                                        <div class="comment-content">
                                            <p>评价星级：
                                                <c:forEach begin="1" end="${discussUser.star}" step="1">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                            </p>
                                                ${discussUser.info}
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
