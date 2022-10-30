<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>修改密码页面</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/change_pwd.js"></script>
</head>
<body>
	<div class="page-wrapper flex-row align-items-center">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-5">
					<div class="card p-4">
						<div
							class="card-header text-center text-uppercase h4 font-weight-light">
							修改密码</div>
						<div class="card-body py-5">
							<form action="login/changePwd" method="post"
								name="changepwd_form">
								<div class="form-group">
									<label class="form-control-label">账户:</label> <input type="text"
										class="form-control"
										<c:if test="${flag eq 'admin'}">name="username" value="${adminLogin.username }"</c:if>
										<c:if test="${flag eq 'trainer'}">name="username" value="${trainerLogin.trainerNo }"</c:if>
										<c:if test="${flag eq 'trainee'}">name="username" value="${traineeLogin.traineeNo }"</c:if>>
								</div>

								<div class="form-group">
									<label class="form-control-label">请设置新密码：</label>
									<span id="password" style="color: red; visibility: hidden;">密码只能为4到10位</span>								
									<input type="password" class="form-control" name="password"
										onclick="removemsg()" onblur="checkpassword()"
										placeholder="请输入新密码">
								</div>

								<div class="form-group">
									<label class="form-control-label">再次输入新密码:</label>
									<span id="againPwd" style="color: red; visibility: hidden;">密码只能为4到10位</span>
									<input type="password" class="form-control" name="againPwd"
										onclick="removemsg()" onblur="checkpassword()"
										placeholder="请再次输入密码">
								</div>
							</form>
						</div>
						<div id="changePwd_msg"
							style="color: red; margin-left: 40px; margin-top: -50px;visibility: visible;">${changePwd_msg }</div>
						<div class="card-footer">
							<div class="row">
								<div class="col-6">
									<a href="index"><button type="button"
											class="btn btn-primary px-5">返回</button></a>
								</div>
								<div class="col-6">
									<button type="button" class="btn btn-primary px-5"
										onclick="changepwd();">确认</button>
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
