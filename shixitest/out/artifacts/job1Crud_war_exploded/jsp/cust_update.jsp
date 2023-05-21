<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/7/8
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/docust?op=update1" method="post">
  <input type="text" name="custid" value="${sessionScope.incust.custid}" hidden>
    <br>
    客户名：<input type="text" name="custname" value="${sessionScope.incust.custname}">
    <br>
    联系人：<input type="text" name="contacts" value="${sessionScope.incust.contacts}">
    <br>
    电话：<input type="text" name="tel" value="${sessionScope.incust.tel}">
    <br>
    邮箱：<input type="text" name="email" value="${sessionScope.incust.email}">
    <br>
    <input type="submit" value="修改">
    <input type="button" value="重置">
</form>
</body>
</html>
