<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/7/8
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有顾客</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/jsp/docust?op=search">
关键字<input type="text" name="name" value="${requestScope.condition.custname}"/>
    <input type="submit" value="搜索">
</form>
<table border="2px">
    <tr>
        <td>客户编号</td>
        <td>客户名字</td>
        <td>客户联系人</td>
        <td>客户电话</td>
        <td>客户邮箱</td>
        <td>客户所属员工的编号</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${custs}" var="str" varStatus="s">
        <tr>
            <td>${str.custid}</td>
            <td>${str.custname}</td>
            <td>${str.contacts}</td>
            <td>${str.tel}</td>
            <td>${str.email}</td>
            <td>${str.empid}</td>
            <td>
                <a href="${pageContext.request.contextPath}/jsp/docust?op=update&custid=${str.custid}">修改</a> |
                <a onclick="return confirm('是否删除？');" href="${pageContext.request.contextPath}/jsp/docust?op=delete&custid=${str.custid}"> 删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${requestScope.pageindex>1}">
<a href="${pageContext.request.contextPath}/jsp/docust?op=search&name=${requestScope.condition.custname}&pageindex=1">首页</a>
<a href="${pageContext.request.contextPath}/jsp/docust?op=search&name=${requestScope.condition.custname}&pageindex=${requestScope.pageindex-1}">上一页</a>
</c:if>
<c:if test="${requestScope.pageindex<=1}">
    首页 上一页
</c:if>
<c:if test="${requestScope.pageindex<requestScope.pagecount}">
<a href="${pageContext.request.contextPath}/jsp/docust?op=search&name=${requestScope.condition.custname}&pageindex=${requestScope.pageindex+1}">下一页</a>
<a href="${pageContext.request.contextPath}/jsp/docust?op=search&name=${requestScope.condition.custname}&pageindex=${requestScope.pagecount}">末页</a>
</c:if>
<c:if test="${requestScope.pageindex>=requestScope.pagecount}">
    下一页 末页
</c:if>
</body>
</html>
