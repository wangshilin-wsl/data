<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/7/7
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<frameset rows="25%,*">
    <frame src="${pageContext.request.contextPath}/jsp/top.jsp">
    <frameset cols="25%,*">
        <frame src="${pageContext.request.contextPath}/jsp/left.jsp">
        <frame src="${pageContext.request.contextPath}/jsp/main.jsp" name="main">
    </frameset>
</frameset>
</html>
