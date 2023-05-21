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
    <title>增加</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/docust?op=doadd" method="post">
    客户名：<input type="text" name="custname">
    <br>
    联系人：<input type="text" name="contacts" >
    <br>
    电话：<input type="text" name="tel" >
    <br>
    邮箱：<input type="text" name="email" >
    <br>
    <input type="submit" value="提交">
    <input type="button" value="重置">
</form>
</body>
</html>
