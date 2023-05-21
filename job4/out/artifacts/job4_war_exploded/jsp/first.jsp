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
    <script>
        var code;
        window.onload=function () {

            createCode();
            document.getElementById("form").onsubmit=function () {
                return  checkUsername()&&checkPassword()&&validate();
            }
            document.getElementById("username").onblur=checkUsername;
            document.getElementById("password").onblur=checkPassword;
            function checkUsername() {
                var username = document.getElementById("username").value;
                var reg = /^\w{6,12}$/;
                var flag = reg.test(username);

                var s_username = document.getElementById("s_username");
                if (flag) {
                    s_username.innerHTML = "✔";
                }
                else {
                    s_username.innerHTML = "×";
                }
                return flag;
            }
            function checkPassword() {
                var password = document.getElementById("password").value;
                var reg = /^\w{6,12}$/;
                var flag = reg.test(password);

                var s_password = document.getElementById("s_password");
                if (flag) {
                    s_password.innerHTML = "✔";
                }
                else {
                    s_password.innerHTML = "×";
                }
                return flag;
            }
        }
        function createCode() {
            //首先默认code为空字符串
            code = '';
            //设置长度
            var codeLength = 4;
            //获取验证码模块
            var oldCode = document.getElementById('code');
            //设置随机字符
            var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
            //循环codeLength
            for (var i = 0; i < codeLength; i++) {
                //设置随机数范围,Math.random()*36会产生一个[0,36)的数，注意其中包含了小数，例如产生的数为5.5，则math.floor(5.5)=5
                var index = Math.floor(Math.random() * 36);
                //字符串拼接 将每次随机的字符 进行拼接
                code += random[index];
            }
            //将拼接好的字符串赋值给展示的Value
            oldCode.value = code;
        }
        //一个用来显示验证码，页面加载后就显示验证码，点击验证码触发方法，获取新的验证码
        //按钮点击方法，判断文本框内输入的内容和验证码是否一致
        function validate() {
            var oValue = document.getElementById('input').value.toUpperCase();//toUpperCase() 方法用于把字符串转换为大写。
            if (oValue == 0) {
                alert('请输入验证码');
            } else if (oValue != code) {
                alert(oValue);
                alert(code);
                alert('验证码不正确，请重新输入');
                oValue = ' ';
                createCode();
                return false;
            } else {
                return true;
            }
        }

    </script>
</head>
<body>
<div id="hh">
    <div>
        <label id="registered">注册</label>
    </div>

    <br/>
    <form action="/reg" id="form" method="post">
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