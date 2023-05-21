<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/5/8
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>注册</title>
    <link rel="stylesheet"  href="../CSS/first.css" />
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>

    </script>
</head>
<body>
    <form action="#" id="form" method="post">
        <div>
            <span>用户名：</span>
            <input type="text" class="text" id="username" name="username" placeholder="请输入用户名"/>
            <span id="s_username" class="error"></span>
        </div>

        <br/>

        <div>
            <span>密码：</span>
            <input type="password" class="text" id="password" name="password" placeholder="请输入密码"/>
            <span id="s_password" class="error"></span>
        </div>
        <br/>
<span>
<input type="submit" value="注册" class="button">
</span>

    </form>
</body>
</html>