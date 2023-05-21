<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/8/3
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>秒杀商品列表</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <style>
        #table{
            margin: 100px auto;
            background-color: aqua;
        }
    </style>
    <script>
        $(document).ready(function () {
            $.ajax({
                url:"/killgoods/searchKillGoods",
                dataType:"json",
                method:"post",
                success:function (jsondata) {
                    for (let i=0;i<jsondata.length;i++){
                        let data=jsondata[i];
                        $("#body").append(` <tr>
                <td>\${data.name}</td>
                <td>\${data.image}</td>
                <td>\${data.price}</td>
                <td>\${data.killprice}</td>
                <td>\${data.stockcount}</td>
                <td><a href="${pageContext.request.contextPath}/killgoods/view/\${data.killid}">详情</a></td>
            </tr>
                    `);
                    }
                }
            });
        });
    </script>
</head>
<body>
<table border="2px" id="table">
    <thead>
    <tr>
        <td>商品名称</td>
        <td>商品图片</td>
        <td>商品原价</td>
        <td>秒杀价</td>
        <td>库存数量</td>
        <td>详情</td>
    </tr>
    </thead>
    <tbody id="body">

    </tbody>
</table>
</body>
</html>
