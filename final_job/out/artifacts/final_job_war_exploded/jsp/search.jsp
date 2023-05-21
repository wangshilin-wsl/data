<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/4/30
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="../css/third.css">
</head>
<body>
<!--头部-->
<div id="header">
    <!--头部的顶部-->
    <div class="header_top">
        <!--头部的顶部的中部-->
        <div class="header_top_center">
            <!--头部的中部的左边-->
            <div class="h_top_left">
                欢迎来到蚂蚁商城
            </div>
            <!--头部的中部的右边-->
            <div class="h_top_right">
                <a href="">登录${sessionScope.name}</a>
                <a href="second.jsp">退出</a>
                <a href="">购物车</a>
                <a href="">我的订单</a>
            </div>
        </div>
    </div>
    <!--头部的中部-->
    <div class="header_center">
        <div class="h_c_logo">
            <img src="../image/logo.png" alt="">
        </div>
        <div class="h_c_search">
            <form action="/final_job/SearchServlet">
                <input type="text" placeholder="输入一些内容..." class="t_input" name="search"/>
                <input type="submit" value="搜索" class="t_button"/>
            </form>
            <div class="hot">
                <a href="#" >idea</a>
                <a href="#">电脑管家</a>
                <a href="#">爱奇艺</a>
                <a href="#">英雄联盟</a>
                <a href="#">网易云音乐</a>
            </div>
        </div>
        <div class="h_c_code">
            <img src="../image/pcode.png" alt="">
        </div>
    </div>
    <!--底部导航-->
    <div class="nav">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#game">游戏软件</a></li>
            <li><a href="#offer">办公软件</a></li>
            <li><a href="#qq">社交软件</a></li>
            <li><a href="#music">音乐软件</a></li>
            <li><a href="#vid">视频软件</a></li>
        </ul>
    </div>
</div>
<!--广告-->
<div id="ad">
    <img src="../image/ad.jpg" alt="">
</div>
<!--秒杀专栏-->
<div id="rm">
    <div class="rm_top" >
        <span>软件下载</span>
    </div>
    <div class="rm_body">
        <ul>
            <c:forEach items="${sessionScope.detail}" var="str" varStatus="s">
            <li>
                <a href="">
                    <img src="../image/goods${str.id}.png" alt=""/>
                    <p>${str.detail}</p>
                    <span class="price">${str.number}</span>
                </a>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>

<!--版权-->
<div id="footer">
    <div class="about">
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
    </div>
    <div class="copyright" >
        Copyright ©  2017-2018  蚂蚁My.com 版权所有
    </div>
    </div>
</body>
</html>