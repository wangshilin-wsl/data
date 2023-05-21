<%@ page import="java.util.List" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/4/22
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示数据</title>
</head>
<body>
<%
    List<User> list=new ArrayList<>();
    list.add(new User("张三",22 ,new Date()));
    list.add(new User("李四",23 ,new Date()));
    list.add(new User("王五",24 ,new Date()));
    request.setAttribute("list",list);
%>
<table border="1"width="500" align="center">
    <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>生日</th>
    </tr>
    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count%2==0}">
        <tr bgcolor="#a52a2a">
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birStr}</td>
        </tr>
        </c:if>
        <c:if test="${s.count%2==1}">
            <tr bgcolor="aqua">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
