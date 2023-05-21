<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/7/28
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
welcome to myshop!
<br>
<h1>${sessionScope.loginuser.username}</h1>
<br>
<h1>${sessionScope.loginuser.password}</h1
<br>
<h1>${loginuser.realname}</h1>
<a href="/killgoods/list">秒杀商品列表</a>
</body>
</html>
