<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>网上借阅平台--登录</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/index.css"/>
    <link rel="shortcut icon" href="img/ico.ico">
    <script type="text/javascript">
        window.onload= function (){
            document.getElementById("h3").innerHTML = "${login_error}";
            document.getElementById("submit").disabled = true;
            setTimeout(function f2() {document.getElementById("h3").innerHTML = "";},3000);//1000为3秒钟

            function f1 (){
                if(document.getElementById("username").value.length == 0 || document.getElementById("password").value.length == 0){
                    document.getElementById("submit").disabled=true;
                    document.getElementById("h3").innerHTML = "用户名和密码不能为空";
                    setTimeout(function f2() {document.getElementById("h3").innerHTML = "";},3000);
                }
                else {
                    document.getElementById("submit").disabled=false;
                    document.getElementById("h3").innerHTML = "";
                }
            }
            document.getElementById("username").onblur = f1
            document.getElementById("password").onblur = f1
        }
    </script>
</head>
<body class="app">
<div class="bg">
    <div class="bg-1">
        <div class="loginbox">
            <div class="left_img">
            </div>
            <div class="form_login">
                <br>
                <div class="form-group"></div>
                <h1>欢迎登录</h1>
                <br>
                <form class="form-horizontal" action="/loginServlet" method="get">
                    <table>
                        <tr>
                            <td class="td1">用户名：</td>
                            <td class="td2"><input id="username" class="form-control" type="text" placeholder="请输入用户名" name="username"></td>
                        </tr>
                        <tr></tr>
                        <tr>
                            <td class="td1">密码：</td>
                            <td class="td2"><input id="password" class="form-control" type="password" name="password" placeholder="请输入密码.."></td>
                        </tr>
                        <tr></tr>
                    </table>
                    <table>
                        <tr>
                            <td class="td3"><input id="submit" type="submit" class="btn btn-success" value="登录"></td>
                            <td class="td3"><a class="btn btn-default" href="register.jsp">注册</a></td>
                        </tr>
                        <tr></tr>
                    </table>
                </form>
                <div class="error">
                    <p id="h3" class="bg-danger"></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
