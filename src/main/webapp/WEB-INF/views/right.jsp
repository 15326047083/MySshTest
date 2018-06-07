<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="right-sidebar" class="col-md-4 col-sm-4">

    <!-- Single Widget -->
    <aside class="widget wow fadeInUp" data-wow-duration="1000ms">
        <div class="widget-title">
            <h3>Search</h3>
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
            <h3>按分类查询</h3>
        </div>
        <div class="widget-content">
            <c:forEach var="type" items="${typeList}">
                <a class="tag" href="/demand/queryByTypeId/${type.id}">${type.name}</a>
            </c:forEach>
        </div>
    </aside>
    <!-- End Single Widget -->

    <!-- Single Widget -->
    <aside class="widget wow fadeInDown">
        <div class="widget-title">
            <h3>Text Widget</h3>
        </div>
        <div class="widget-content">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus ducimus in dolorum
                accusantium voluptate nostrum, excepturi dolores voluptatem vel rerum at, recusandae
                inventore nobis ex eveniet sunt eligendi, qui provident.</p>
        </div>
    </aside>
    <!-- End Single Widget -->

    <!-- Single Widget -->
    <aside class="widget wow fadeInDown">
        <div class="widget-title">
            <h3>Tab Widget</h3>
        </div>

        <div class="widget-content">
            <!-- tab nav -->
            <ul class="tab-post-nav clearfix">
                <li class="active"><a href="#popular" data-toggle="tab">Popular Post</a></li>
                <li><a href="#recent" data-toggle="tab">Recent Post</a></li>
                <li><a href="#most-viewed" data-toggle="tab">Most Viewed</a></li>
            </ul>
            <!-- /tab nav -->

            <!-- tab content -->
            <div class="tab-content">
                <article class="tab-pane active tab-post" id="popular">
                    <div class="clearfix">
                        <div class="tab-thumb">
                            <img src="img/blog/3D-beach-art.jpg" class="img-responsive"
                                 alt="3D Beach Art | Meghna">
                        </div>
                        <div class="tab-excerpt">
                            <h4><a href="single.html">Post Title Demo</a></h4>
                            <span>November 15 2017</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore,
                                laboriosam molestiae aliquam rem enim earum eos suscipit! Dolore, molestiae,
                                quidem quo quam deleniti ullam dicta. Incidunt, quaerat est deserunt
                                voluptatum.</p>
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="tab-thumb">
                            <img src="img/blog/amazing-caves-coverimage.jpg" class="img-responsive"
                                 alt="amazing-caves-coverimage | Meghna">
                        </div>
                        <div class="tab-excerpt">
                            <h4><a href="single.html">Post Title Demo</a></h4>
                            <span>November 15 2017</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore,
                                laboriosam molestiae aliquam rem enim earum eos suscipit! Dolore, molestiae,
                                quidem quo quam deleniti ullam dicta. Incidunt, quaerat est deserunt
                                voluptatum.</p>
                        </div>
                    </div>
                </article>

                <article class="tab-pane tab-post" id="recent">
                    <div class="clearfix">
                        <div class="tab-thumb">
                            <img src="img/blog/amazing-caves-coverimage.jpg" class="img-responsive"
                                 alt="amazing-caves-coverimage | Meghna">
                        </div>
                        <div class="tab-excerpt">
                            <h4><a href="single.html">Post Title Demo</a></h4>
                            <span>November 15 2017</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore,
                                laboriosam molestiae aliquam rem enim earum eos suscipit! Dolore, molestiae,
                                quidem quo quam deleniti ullam dicta. Incidunt, quaerat est deserunt
                                voluptatum.</p>
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="tab-thumb">
                            <img src="img/blog/3D-beach-art.jpg" class="img-responsive"
                                 alt="3D Beach Art | Meghna">
                        </div>
                        <div class="tab-excerpt">
                            <h4><a href="single.html">Post Title Demo</a></h4>
                            <span>November 15 2017</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore,
                                laboriosam molestiae aliquam rem enim earum eos suscipit! Dolore, molestiae,
                                quidem quo quam deleniti ullam dicta. Incidunt, quaerat est deserunt
                                voluptatum.</p>
                        </div>
                    </div>
                </article>

                <article class="tab-pane tab-post" id="most-viewed">
                    <div class="clearfix">
                        <div class="tab-thumb">
                            <img src="img/blog/bicycle.jpg" class="img-responsive" alt="bicycle | Meghna">
                        </div>
                        <div class="tab-excerpt">
                            <h4><a href="single.html">Post Title Demo</a></h4>
                            <span>November 15 2017</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore,
                                laboriosam molestiae aliquam rem enim earum eos suscipit! Dolore, molestiae,
                                quidem quo quam deleniti ullam dicta. Incidunt, quaerat est deserunt
                                voluptatum.</p>
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="tab-thumb">
                            <img src="img/blog/3D-beach-art.jpg" class="img-responsive"
                                 alt="3D Beach Art | Meghna">
                        </div>
                        <div class="tab-excerpt">
                            <h4><a href="single.html">Post Title Demo</a></h4>
                            <span>November 15 2017</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore,
                                laboriosam molestiae aliquam rem enim earum eos suscipit! Dolore, molestiae,
                                quidem quo quam deleniti ullam dicta. Incidunt, quaerat est deserunt
                                voluptatum.</p>
                        </div>
                    </div>
                </article>

            </div>
            <!-- /tab content -->

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
