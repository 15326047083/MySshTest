<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>save</title>
</head>
<body>
    <form method="post" action="/stu/save">
        姓名<input type="text" name="name" /> <br>
        年龄<input type="text" name="age" /> <br>
        性别<select name="sex">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        <input type="submit" value="保存">
    </form>
</body>
</html>
