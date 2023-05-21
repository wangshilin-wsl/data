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
                <a href="#offer" >idea</a>
                <a href="#qq">qq</a>
                <a href="#vid">爱奇艺</a>
                <a href="#game">英雄联盟</a>
                <a href="#music">网易云音乐</a>
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
<div id="ms">
    <div class="ms_top" id="game">
        <span>游戏软件下载</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/goods1.png" alt=""/>
                    <p>《英雄联盟》是由美国拳头游戏（Riot Games）开发的一款英雄对战MOBA竞技网游。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods2.png" alt=""/>
                    <p>《和平精英》是腾讯光子工作室群自研打造的军事竞赛体验手游</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods3.png" alt=""/>
                    <p>《梦幻西游》是由中国网易公司自行开发并营运的一款角色扮演类网络游戏。</p>
                   <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods4.png" alt=""/>
                    <p>《使命召唤Online》是由动视暴雪研发，腾讯游戏独家代理。</p>
                   <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods5.png" alt=""/>
                    <p>《王者荣耀》是腾讯天美工作室推出的英雄竞技手游，不是一个人的王者，而是团队的荣耀！</p>
                    <span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>


    <div class="ms_top" id="offer">
        <span>办公软件下载</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/goods6.png" alt=""/>
                    <p>vs2013中文旗舰版是微软官方开发的一款软件开发平台。</p>
                  <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods7.png" alt=""/>
                    <p>IDEA 全称IntelliJ IDEA，是java语言开发的集成环境。</p>
                   <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods8.png" alt=""/>
                    <p>WebStorm 是jetbrains公司旗下一款JavaScript 开发工具。</p>
                  <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods9.png" alt=""/>
                    <p>Eclipse 是一个开放源代码的、基于Java的可扩展开发平台。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods10.png" alt=""/>
                    <p>腾讯会议提供一站式音视频会议解决方案，让您能随时随地体验高清流畅的会议以及会议协作。</p>
                   <span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>


    <div class="ms_top" id="qq">
        <span>社交软件下载</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/goods11.png" alt=""/>
                    <p>虎牙直播是以游戏直播为主的弹幕式互动直播平台。</p>
                   <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods12.png" alt=""/>
                    <p>腾讯QQ,8亿人在用的即时通讯软件。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods13.png" alt=""/>
                    <p>一款跨平台的通讯工具。支持单人、多人参与。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods14.png" alt=""/>
                    <p>玩游戏必备的语音软件，玩公会，与战友来论战。</p>
                  <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods15.png" alt=""/>
                    <p>斗鱼tv是由武汉斗鱼网络科技有限公司于2014年1月推出的一款弹幕式直播分享网站。</p>
                    <span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>


    <div class="ms_top" id="music">
        <span>音乐软件下载</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/goods16.png" alt=""/>
                    <p>网易云音乐是一款专注于发现与分享的音乐产品，为用户打造全新的音乐生活。</p>
                  <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods17.png" alt=""/>
                    <p>QQ音乐是腾讯公司推出的一款网络音乐服务产品。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods18.png" alt=""/>
                    <p>全民K歌2019最新官方版是腾讯官方最新推出的一款手机K歌播放器。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods19.png" alt=""/>
                    <p>千千音乐是中国音乐门户之一，为你提供海量正版高品质音乐。</p>
                  <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods20.png" alt=""/>
                    <p>虾米音乐是专业音乐内容发现平台，依托专业曲库内容和精准推荐算法，带你发现音乐惊喜。</p>
                  <span class="price">599</span>
                </a>
            </li>
        </ul>
    </div>


    <div class="ms_top" id="vid">
        <span>视频软件下载</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="">
                    <img src="../image/goods21.png" alt=""/>
                    <p>腾讯视频致力于打造中国领先的在线视频媒体平台。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods22.png" alt=""/>
                    <p>北京爱奇艺科技有限公司是一家独立视频服务公司，由龚宇于2010年4月22日在北京成立。</p>
                    <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods23.png" alt=""/>
                    <p>优酷网是中国领先的视频分享网站，是国内网络视频行业的第一品牌</p>
                   <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods24.png" alt=""/>
                    <p>暴风看电影，中国影视内容最全、更新最快的在线观看视频网站。</p>
                  <span class="price">599</span>
                </a>
            </li>
            <li>
                <a href="">
                    <img src="../image/goods25.png" alt=""/>
                    <p>QQ影音是由腾讯公司推出的一款支持任何格式影片和音乐文件的本地播放器。</p>
                    <span class="price">599</span>
                </a>
            </li>
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
    <div class="copyright">
        Copyright ©  2017-2018  蚂蚁My.com 版权所有
    </div>
    </div>
</body>
</html>