<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/5/8
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>注册</title>
    <link rel="stylesheet"  href="../CSS/first.css" />
</head>
<body>
<div id="hh">
    <div>
        <label id="registered">注册</label>
    </div>

    <br/>
    <form action="/job6/Servlet2" id="form" method="post">
        <div>
            <span>用户名：</span>
            <input type="text" class="text" id="username" name="username"/>
            <span id="s_username" class="error"></span>
        </div>

        <br/>

        <div>
            <span>密码：</span>
            <input type="password" class="text" id="password" name="password"/>
            <span id="s_password" class="error"></span>
        </div>

        <br/>

        <div>
            <span>性别：</span>
            <input type="radio" name="sex" id="man" value="男"/>
            <label for="man">男</label>
            <input type="radio" name="sex" id="woman" value="女"/>
            <label for="woman">女</label>
        </div>

        <br/>

        <div>
            <span>手机号码：</span>
            <input type="text" class="text" name="tel"/>
        </div>

        <br/>
        <div>
            <span>验证码：</span>
            <input type="text" id="input"  class="text" value="" />
            <input type="button" id="code" onclick="createCode()" />
        </div>
        <div>
<span>
<input type="submit" value="注册" class="button">
</span>
            <span>
<input type="reset" value="重置" class="button">
</span>
        </div>
    </form>
</div>
</body>
</html>