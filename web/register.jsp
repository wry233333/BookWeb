<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>网上借阅平台--注册</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/register.css"/>
    <link rel="shortcut icon" href="img/ico.ico">
    <script type="text/javascript">
        window.onload = function (){
            document.getElementById("h3").innerHTML = "${cc_error}${reg_error}${reg_success}";
            setTimeout(function f2() {document.getElementById("h3").innerHTML = "";},3000);//3000为3秒钟
            document.getElementById("submit").disabled =true;
            function f1 (){document.getElementById("img").src = "/checkCode?"+new Date().getTime();}
            document.getElementById("img").onclick = f1;
            document.getElementById("change").onclick = f1;

            const username = document.getElementById("username");
            const password = document.getElementById("password");
            const c_password = document.getElementById("c_password");
            const cc = document.getElementById("cc");
            cc.onblur = function (){
                if(cc.value.length != 0){
                    document.getElementById("submit").disabled =false;
                }
            }
            document.getElementById("form").onsubmit = function f2(){
                if(username.value.length == 0 || password.value.length == 0 || c_password.value.length == 0 || cc.value.length == 0){
                    alert("有必填项目为空")
                    return false;
                }
                else {
                    if(password.value != c_password.value) {
                        alert("确认密码与第一次输入密码不一样");
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            }
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
                <h1>欢迎注册</h1>
                <br>
                <form class="form-horizontal" action="/registerServlet" method="get" id="form">
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
                        <tr>
                            <td class="td1">确认密码：</td>
                            <td class="td2"><input id="c_password" class="form-control" type="password" name="password" placeholder="请再次确认输入密码.."></td>
                        </tr>
                        <tr></tr>
                        <tr>
                            <td class="td1">请输入验证码:</td>
                            <td class="td2"><input id="cc" name="cc" type="text" class="form-control" ></td>
                        </tr>
                        <tr></tr>

                    </table>
                    <table>
                        <tr>
                            <td><img id="img" src="/checkCode"></td>
                            <td><a id="change" href="#">看不清换一张..</a></td>
                        </tr>
                        <tr></tr>
                        <tr>
                            <td class="td3"><input id="submit" type="submit" class="btn btn-success" value="确认注册"></td>
                            <td class="td3"><a class="btn btn-default" href="index.jsp">返回登录</a></td>
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
