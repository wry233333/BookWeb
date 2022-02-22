<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>书籍管理页面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="shortcut icon" href="img/ico.ico">
</head>
<body>

<table class="table table-hover">
    <tr>
        <td></td>
        <td>书名</td>
        <td>作者</td>
        <td>出版商</td>
        <td>单价</td>
        <td>信息</td>
        <td>类别</td>
    </tr>
    <c:forEach items="${books}" var="book" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${book.name}</td>
            <td>${book.auther}</td>
            <td>${book.publisher}</td>
            <td>${book.price}</td>
            <td>${book.info}</td>
            <td>${book.getCls()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>