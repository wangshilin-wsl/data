<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/6/10
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script>
      function a() {
          $.post({
              url:"${pageContext.request.contextPath}/a1",
              data:{"name":$("#username").val()},
              success:function (data) {
                  alert(data);
              }
          })
      }
      </script>
  </head>
  <body>
  <%--失去焦点的时候，发起一个请求到后台--%>
<input type="text"  id="username" onblur="a()"/>

  </body>
</html>
