<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2020/6/7
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <%--使用BootStrap美化界面--%>
    <link href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
<%--出现的问题，我们提交了修改的sql请求，但是修改失败，初步考虑是事务的问题，配置之后，依旧失败，sql
执行失败，id=0，隐藏域--%>
        <input type="hidden" name="bookID" value="${books.bookID}"/>
        <div class="form-group">
            <label >书籍名称:</label>
            <input type="text" name="bookName" class="form-control" value="${books.bookName}" placeholder="书籍名称" required/>
        </div>
        <div class="form-group">
            <label >书籍数量:</label>
            <input type="text" name="bookCounts" class="form-control" value="${books.bookCounts}" placeholder="书籍数量" required/>
        </div>
        <div class="form-group">
            <label>书籍描述:</label>
            <input type="text" name="detail" class="form-control" value="${books.detail}" placeholder="书籍描述" required/>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control"  value="添加">
        </div>
    </form>

</div>
</body>
</html>
