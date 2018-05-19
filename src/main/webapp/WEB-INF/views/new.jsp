<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/5/17
  Time: 上午8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>新建用户</title>
</head>
<body>
<shiro:hasRole name="admin">
    这里是新建管理员
</shiro:hasRole>
<shiro:hasRole name="user">
    这里是新建用户
</shiro:hasRole>
<shiro:hasRole name="user1">
    无权访问这里
</shiro:hasRole>
</body>
</html>
