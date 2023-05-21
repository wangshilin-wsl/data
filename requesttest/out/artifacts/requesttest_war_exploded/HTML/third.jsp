<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/4/30
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="../CSS/third.css">
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
                <a href="second.html">登录${sessionScope.name}</a>
                <a href="first.html">退出</a>
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
            <form action="#">
                <input type="text" placeholder="输入一些内容..." class="t_input"/>
                <input type="submit" value="搜索" class="t_button"/>
            </form>
            <div class="hot">
                <a href="#" >新款连衣裙</a>
                <a href="#">四件套</a>
                <a href="#">潮流T恤</a>
                <a href="#">时尚女鞋</a>
                <a href="#">短裤半身裙</a>
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
            <li><a href="#">电脑办公</a></li>
            <li><a href="#">家具家居</a></li>
            <li><a href="#">鲜果时光</a></li>
            <li><a href="#">图书音像</a></li>
            <li><a href="#">母婴孕婴</a></li>
        </ul>
    </div>
</div>
<!--广告-->
<div id="ad">
    <img src="../image/ad.jpg" alt="">
</div>
<!--秒杀专栏-->
<div id="ms">
    <div class="ms_top">
        <span>蚂蚁秒杀</span>
        <span>总有你想不到的低价</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/good1.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods2.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods3.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods4.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods5.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--热卖-->
<div id="rm">
    <div class="rm_top">
        <h3>热卖商品</h3>
    </div>
    <div class="rm_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/goods6.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods7.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods8.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods9.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods10.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods11.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods12.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods13.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods14.png" alt=""/>
                    <p>小米(MI)小米净化器2只能家用卧室空气净化器除甲醛雾霾</p>
                    <i class="yuan">¥</i><span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--版权-->
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
    <div>
</body>
</html>