<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/7/30
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别添加</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#btnadd").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/category/doadd",
                    type:"post",
                    data:{name:$("#name").val()},
                    dataType:"json",
                    success:function (jsondata) {
                        if(jsondata.statusCode==0){
                            location.href="${pageContext.request.contextPath}/admin/category/view/manager";
                        }else{
                            alert(jsondata.msg);
                        }
                    }
                });
            });
        });
    </script>
</head>

<h3>类别添加</h3>
<form  id="frmadd" action="${pageContext.request.contextPath}/admin/category/doadd" method="post">
类别名称：<input type="text" id="name"><br>
<input type="button" value="添加" id="btnadd">
</form>
</body>
</html>
