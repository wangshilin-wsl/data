<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/8/5
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>秒杀订单信息</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script>
        $(document).ready(function () {
            $.ajax({
                url:"/killgoods/kill",
                dataType:"json",
                data:{orderinfoid:${requestScope.orderinfoid}},
                method:"post",
                success:function (json) {
                    $("#goodsname").text(json.goodsname);
                    $("#goodsprice").text(json.goodsprice);
                    $("#createdate").text(json.createdate);
                    if(json.orderstatus==0){
                        $("#orderstatus").append(`<td>未支付</td>`);
                    }else {
                        $("#orderstatus").append(`<td>已支付</td>`);
                    }
                }
            });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <td>商品名称：</td>
        <td id="goodsname"></td>
    </tr>
    <tr>
        <td>商品价格：</td>
        <td id="goodsprice"></td>
    </tr>
    <tr>
        <td>下单时间：</td>
        <td id="createdate"></td>
    </tr>
    <tr id="orderstatus">
        <td >订单状态：</td>
    </tr>
</table>
</body>
</html>
