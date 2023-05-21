<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/7/7
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员登录</title>
</head>
<body>
  <form method="post" action="${pageContext.request.contextPath}/dologin">
        <span>用户名：</span>
        <input type="text" name="username"/>

    <br/>

        <span>密码：</span>
        <input type="password" name="password"/>
<br>
<input type="submit" value="登录" class="button">
<input type="reset" value="重置" class="button">
  </form>
</body>
</html>
