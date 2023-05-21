<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/4/30
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="../css/second.css">
    <script>
        window.onload=function () {
            var fun1=function () {
                document.getElementById("tishi").style.display="none";
            }
            document.getElementById("username").onclick=fun1;
            document.getElementById("password").onclick=fun1;
        }
    </script>
</head>
<body>
<!--首部-->
<div id="header">
    <div class="h_center">
        <img src="../image/Myxq.jpg" alt="">
        <p>为了确保您的账户的安全及正常使用，依《网络安全法》相关要求，需绑定手机，请尽快完成，谢谢您的理解与支持！</p>
    </div>
</div>
<!--中部-->
<div id="login_body">
    <div class="body_center">
        <div class="body_center_center">
            <h4>忘记密码</h4>
            <form action="/final_job/LoginServlet" id="login" method="post">
            <!--用户名-->
            <div class="username" >
                <span></span><input type="text" name="username" id="username"/>
            </div>
            <!--密码-->
            <div class="password">
                <span></span><input type="password" name="password" id="password"/>
                <p id="tishi">${sessionScope.ERROR}</p>
            </div>
            <!--按钮-->
            <div class="bt">
                <input type="submit" value="登录"/>
                <input type="button" value="取消"/>
            </div>
            <div class="forget">
                <a href="">忘记密码</a>
                <a href="">忘记会员名</a>
                <a href="first.jsp">免费注册</a>
            </div>
        </form>
        </div>
    </div>
</div>
</div>
<div id="footer">
    <div class="about">
    </div>
    <a href="">关于我们</a>
    |
    <a href="">联系我们</a>
    |
    <a href="">人才招聘</a>
    |
    <a href="">商家入驻</a>
    |
    <a href="">广告服务</a>
    |
    <a href="">手机蚂蚁</a>
    |
    <a href="">友情链接</a>
    |
    <a href="">销售联盟</a>
    |
    <a href="">蚂蚁社区</a>
    <div class="copyright">
        Copyright ©  2017-2018  蚂蚁My.com 版权所有
    </div>
</div>
</body>
</html>