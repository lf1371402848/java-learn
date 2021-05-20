<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="false"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="css/styles.css">
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        Login
                    </div>
                    <div class="card-body py-4">
                        <form action="login/userLogin" method="post" name="loginform">
                            <div class="form-group">                                
                                <label class="form-control-label">Username</label>
                                <input type="text" class="form-control" name="username" onclick="removemsg()" onblur="checkusername()" placeholder="请输入用户名">
                            </div>
                            <div class="form-group">
                                <label class="form-control-label">Password</label>
                                <input type="password" class="form-control" name="password" onclick="removemsg()" onblur="checkpassword()" placeholder="请输入密码">
                            </div>
                            <div style="margin-top: 40px;">
                                <input type="radio" name="flag" value="admin" checked="checked">管理员
                                <input type="radio" name="flag" value="trainer" style="margin-left: 20px;">教练 
                                <input type="radio" name="flag" value="trainee" style="margin-left: 20px;">学员 
                                <a href="#" class="btn btn-link" style="margin-left: 80px;">忘记密码?</a>
                            </div>
                        </form>
                    </div>
                    <div id="login_msg" style="color: red;margin-left: 40px;">${login_msg }</div>
                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                                <button class="btn btn-primary px-5" onclick="login();">登录</button>
                            </div>
                            <div class="col-6">
                                <a href="login"><button type="button" class="btn btn-primary px-5">返回</button></a>
                            </div>                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
