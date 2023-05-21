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
            $("#btnedit").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/category/doedit",
                    type:"post",
                    data:$("#frmadd").serialize(),
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
<h3>类别修改</h3>
<form  id="frmadd" action="${pageContext.request.contextPath}/admin/category/doedit" method="post">
    <input  name="id" type="text" id="id" value="${category.id}" hidden><br>
类别名称：<input  name="name" type="text" value="${category.name}" id="name"><br>
    商品数量：<input  name="goodsnum" type="text" value="${category.goodsnum}" id="goodsnum"><br>
<input type="button" value="修改" id="btnedit">
</form>
</body>
</html>
