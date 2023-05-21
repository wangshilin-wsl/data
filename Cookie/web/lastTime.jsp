<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/4/21
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    boolean flag=false;
    Cookie[] cookies = request.getCookies();
    if(cookies.length>0&&cookies!=null){
        for (Cookie c:cookies) {
            String name=c.getName();
            if("lastTime".equals(name)){
                flag=true;
                //有该cookie，不是第一次访问
                //响应数据
                //获取cookie的value
                String value = c.getValue();
                value= URLDecoder.decode(value,"utf-8");
               out.write("<h1>欢迎回来，您上次访问的时间是："+value+"<h1>");
                // System.out.println(value);
                //设置cookie的value
                //获取当前时间的字符串
                Date date=new Date();

                String str_date=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
                //   System.out.println(str_date);
                str_date= URLEncoder.encode(str_date,"utf-8");
                c.setValue(str_date);
                //设置cookie的存活时间,1个月
                c.setMaxAge(60*60*24*30);
                response.addCookie(c);
                break;
            }
        }
    }
    if(cookies.length==0||cookies==null||flag==false){
        //没有，第一次访问
        Date date=new Date();
        String str_date=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
        str_date=URLEncoder.encode(str_date,"utf-8");
        Cookie c=new Cookie("lastTime",str_date);
        //设置cookie的存活时间,1个月
        c.setMaxAge(60*60*24*30);
        response.addCookie(c);
        %>
      <h1> "欢迎您第一次访问！！！"</h1>
<%
    }

%>
</body>
</html>
