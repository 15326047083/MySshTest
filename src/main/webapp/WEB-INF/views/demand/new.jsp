<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/6/4
  Time: 下午5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- 富文本编辑器 -->

<script type="text/javascript" charset="utf-8"
        src="/css/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
        src="/css/ueditor/ueditor.all.min.js">

</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
        src="<%=request.getContextPath()%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 结束 -->
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
                    <h1>发布服务需求</h1>
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
                    <div class="comment-reply-form">
                        <h3>填写需求详情</h3>
                        <form action="/demand/saveDemand" method="post">
                            <input type="hidden" id="info" name="info"/>
                            <input type="hidden" id="flag" name="flag" value="0"/>
                            <input type="hidden" name="setUserId" value="${userSession.id}">
                            <script id="editor" type="text/plain"><p>在这里填入需求详情！！！</p></script>
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
                                <input type="number" class="form-control" placeholder="赏金" id="bounty" name="bounty"
                                       required>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <input type="datetime-local" class="form-control" placeholder="结束时间" id="endTime"
                                       name="endTime" required>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="地址" id="place" name="place"
                                       required>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <input class="form-control" placeholder="微信" id="weixin" name="weixin" required/>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="QQ" id="qq" name="qq" required/>
                            </div>
                            <div class="form-group">
                                <select name="typeId" class="form-control">
                                    <c:forEach var="t" items="${typeList}">
                                        <option value="${t.id}">${t.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- End .form-group -->
                            <div class="form-group">
                                <button type="submit" onclick="return submitInfo()" class="btn btn-transparent">发布需求
                                </button>
                            </div>
                            <!-- End .form-group -->
                        </form>
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
