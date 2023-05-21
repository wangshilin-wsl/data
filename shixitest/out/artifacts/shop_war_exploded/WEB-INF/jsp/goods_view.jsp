<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/8/3
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>秒杀详情</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <style>
        #countDown{
            color: aqua;
        }
    </style>
    <script>
        var interval;
        var killid;
        $(document).ready(function () {
            $.ajax({
                url:"/killgoods/goodsview",
                dataType:"json",
                data:{killid:${requestScope.killid}},
                method:"post",
                success:function (json) {
                    killid=json.goods.killid;
                    var startToEnd=json.startToEnd;
                    var remainSeconds=json.remainSeconds;
                    $("#remainSeconds").val(remainSeconds);
                    var killStatus=json.killStatus;
                    if(killStatus==0){
                        $("#killTitle").append(
                            `秒杀倒计时： <span id="countDown" >\${remainSeconds}</span>秒`);

                    }else if(killStatus==1){
                        $("#killTitle").append(
                            `<span >秒杀正在进行</span>`);

                    }else {
                        $("#killTitle").append(
                            `<span >秒杀结束</span>`);
                    }
                    $("#name").text(json.goods.name);
                    $("#image").text(json.goods.image);
                    $("#price").text(json.goods.price);
                    $("#killprice").text(json.goods.killprice);
                    $("#stockcount").text(json.goods.stockcount);
                    $("#startdate").text(json.goods.startdate);
                    $("#enddate").text(json.goods.enddate);
                    //控制按钮的状态
                    if(startToEnd>0){
                        setTimeout(go,startToEnd);
                    }
                    //实现倒计时
                    if(killStatus!=2){
                        interval = setInterval(down,1000);
                    }
                }
            });
            function go() {
                $("#killTitle").html("秒杀结束");
                $("#btn").hide();
            }
            $("#btn").click(function () {
                location.href="/killgoods/tokill?killid="+killid;
            });
        });
            function down() {
                if( $("#remainSeconds").val()>0){
                    $("#remainSeconds").val( $("#remainSeconds").val()-1);
                    $("#countDown").html($("#remainSeconds").val());
                }else if($("#remainSeconds").val()==0){
                    clearInterval(interval);
                    $("#killTitle").html("秒杀正在进行");
                    $("#btn").show();
                }
            }
    </script>
</head>
<body>
<table id="table" border="2px">
    <tr>
        <td>商品名称：</td>
        <td id="name"></td>
    </tr>
    <tr>
        <td>商品图片：</td>
        <td id="image"></td>
    </tr>
    <tr>
        <td>商品原价：</td>
        <td id="price"></td>
    </tr>
    <tr>
        <td>秒杀价：</td>
        <td id="killprice"></td>
    </tr>
    <tr>
        <td>库存数量：</td>
        <td id="stockcount"></td>
    </tr>
    <tr>
        <td>秒杀开始时间：</td>
        <td id="startdate"></td>
    </tr>
    <tr>
        <td>秒杀结束时间：</td>
        <td id="enddate"></td>
    </tr>
    <tr>
        <td id="killTitle">
            <input type="hidden" id="remainSeconds" >
        </td>
        <td>
                <input type="button" id="btn" value="立即秒杀" hidden="hidden">
        </td>
    </tr>
</table>

</body>
</html>
