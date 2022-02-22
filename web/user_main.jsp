<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>平台中心</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="shortcut icon" href="img/ico.ico">
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body class="app">
<div class="bg">
    <div class="bg-1">
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">图书借阅系统</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">首页</a></li>
                            <li><a href="#">查找图书</a></li>
                            <li><a href="#">我的借阅</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账户 <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">查看愿望单</a></li>
                                    <li><a href="#">修改密码</a></li>
                                    <li><a href="#">编辑个人资料</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">

                            <li><a href="../navbar-fixed-top/">用户名：${user.username}</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="jumbotron">
                <h2>公告：</h2>
                <p>欢迎大家访问图书借阅系统，本系统由wry333开发的第一个JavaWeb项目。</p>
                <p>由于第一次编码多有不周之处敬请谅解...</p>
            </div>

            <div class="jumbotron">
                <h2>全部书籍列表</h2>
                <table class="table table-hover" style="text-align: center">
                    <tr>
                        <td width="12.5%">ID</td>
                        <td width="20%">书名</td>
                        <td width="12.5%">作者</td>
                        <td width="12.5%">出版商</td>
                        <td width="12.5%">单价</td>
                        <td width="12.5%">类别</td>
                        <td width="17.5%" colspan="2">操作</td>
                        <td></td>
                    </tr>
                    <c:forEach items="${books}" var="book" varStatus="s">
                        <tr>
                            <td>${s.count}</td>
                            <td>${book.name}</td>
                            <td>${book.auther}</td>
                            <td>${book.publisher}</td>
                            <td>${book.price}</td>
                            <td>${book.getCls()}</td>
                            <td><a class="btn btn-info" href="#">查看详情</a></td>
                            <td><a class="btn btn-info" href="#">加入愿望单</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
</div>

</body>
</html>
