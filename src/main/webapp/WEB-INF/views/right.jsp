<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="right-sidebar" class="col-md-4 col-sm-4">

    <!-- Single Widget -->
    <aside class="widget wow fadeInUp" data-wow-duration="1000ms">
        <div class="widget-title">
            <h3>搜索</h3>
        </div>
        <div class="widget-content">
            <form action="/demand/searchByInfo" id="search-form" method="get" role="search">
                <input type="text" class="form-control" placeholder="请输入关键字，或佣金期望值" autocomplete="on"
                       name="info">
                <button type="submit" title="Search" id="search-submit">
                    <i class="fa fa-search"></i>
                </button>
            </form>
        </div>
    </aside>
    <!-- End Single Widget -->

    <!-- Single Widget -->
    <aside class="widget wow fadeInDown">
        <div class="widget-title">
            <h3>按需求状态查询</h3>
        </div>
        <div class="widget-content">
            <ul class="categories">
                <li><i class="fa fa-plus"></i> <a href="/demand/gerDemandList/0">正常状态</a></li>
                <li><i class="fa fa-plus"></i> <a href="/demand/gerDemandList/1">进行中</a></li>
                <li><i class="fa fa-plus"></i> <a href="/demand/gerDemandList/2">已完成案例</a></li>
                <li><i class="fa fa-plus"></i> <a href="/demand/gerDemandList/4">已过期</a></li>
                <shiro:hasRole name="user">
                    <li><i class="fa fa-plus"></i> <a href="/demand/getMyDemandList/${userSession.id}/set">我发布的</a></li>
                    <li><i class="fa fa-plus"></i> <a href="/demand/getMyDemandList/${userSession.id}/get">我接受的</a></li>
                </shiro:hasRole>
            </ul>
        </div>
    </aside>
    <!-- End Single Widget -->

    <!-- Single Widget -->
    <aside class="widget wow fadeInDown">
        <div class="widget-title">
            <h3>按分类查询<shiro:hasRole name="admin"><a href="/demandType/queryAllDemandType">(查看全部)</a></shiro:hasRole>
            </h3>
        </div>
        <div class="widget-content">
            <!-- 打开弹窗按钮 -->
            <shiro:hasRole name="admin">
                <button class="tag" id="myBtn">添加分类</button>
            </shiro:hasRole>
            <!-- 弹窗 -->
            <div id="myModal" class="modal">
                <!-- 弹窗内容 -->
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <div align="center">
                        <form action="/demandType/saveOrUpdateDemandType" method="post">
                            请输入分类名称：<input type="text" name="name"><br>
                            请输入分类简介：<input type="text" name="info"><br>
                            <input class="tag" type="submit" value="添加分类">
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
            <c:forEach var="type" items="${typeList}">
                <a class="tag" href="/demand/queryByTypeId/${type.id}">${type.name}</a>
            </c:forEach>
        </div>
    </aside>
    <!-- End Single Widget -->

    <!-- Single Widget -->
    <aside class="widget wow fadeInDown">
        <div class="widget-title">
            <h3>Newsletter</h3>
            <p>Signup to receive email updates and to hear what's going on with my blog!</p>
        </div>
        <div class="widget-content">
            <form action="">
                <input type="email" name="email" class="form-control" placeholder="Enter your email"
                       required="">
                <input type="submit" value="Subscribe" class="btn btn-transparent">
            </form>
        </div>
    </aside>
    <!-- End Single Widget -->


</div>
