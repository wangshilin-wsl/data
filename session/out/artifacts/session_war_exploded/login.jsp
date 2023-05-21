<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/4/21
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        //点击超链接或者图片换一张
        window.onload=function () {
            var img= document.getElementById("img");
            img.onclick=function () {
                //加时间戳
                var date=new Date().getTime();
                img.src="/code/CheckCodeServlet?"+date;
            }
        }
    </script>
    <style>
        div{
            color: brown;
        }
    </style>
</head>
<body>
<form action="/code/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td >验证码</td>
            <td><input type="text" name="checkCode"/></td>
        </tr>
        <tr>
            <td colspan="2"><img src="/code/CheckCodeServlet" id="img"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
<div><%=request.getAttribute("cc_error")==null? "":request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error")==null? "":request.getAttribute("login_error")%></div>
</body>
</html>
