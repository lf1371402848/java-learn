<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>学员新增</title>
<link rel="stylesheet" href="css/styles.css">
<script src="js/check_formInput.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header bg-light">新增学员</div>
							<form action="trainee/addTrainee" method="post"
								name="trainee_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">账号</label> <span
													id="traineeNo" style="color: red; visibility: hidden;">学员账号长度只能为4到10位</span>
												<input type="text" class="form-control" name="traineeNo"
													maxlength="10"
													oninput="value=value.replace(/[\u4E00-\u9FA5 ]/g,'')"
													onblur="checkTraineeNo()" placeholder="账号不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">姓名</label> <span
													id="name" style="color: red; visibility: hidden;">学员名字长度只能为2到5位</span>
												<input type="text" class="form-control" name="name"
													maxlength="5" onblur="checkTraineeName()"
													placeholder="姓名不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="single-select">性别</label> <select
													class="form-control" name="gender">
													<option value="M">男</option>
													<option value="F">女</option>
												</select>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">年龄</label> <span
													id="age" style="color: red; visibility: hidden;">学员年龄只能在18到60岁</span>
												<input type="text" class="form-control" name="age"
													maxlength="2" oninput="value=value.replace(/[^\d]/g,'')"
													onblur="checkTraineeAge()" placeholder="年龄不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">身高</label> <span
													id="height" style="color: red; visibility: hidden;">学员身高只能在150到200cm</span>
												<input type="text" class="form-control" name="height"
													maxlength="3" oninput="value=value.replace(/[^\d]/g,'')"
													onblur="checkTraineeHeight()">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">电话</label> <span
													id="phone" style="color: red; visibility: hidden;">电话只能为11位</span>
												<input type="text" class="form-control" name="phone"
													maxlength="11" oninput="value=value.replace(/[^\d]/g,'')"
													onblur="checkTraineePhone()" placeholder="电话号码不能为空">
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">身份证号</label> <span
													id="idNumber" style="color: red; visibility: hidden;">身份证只能为18位</span>
												<input type="text" class="form-control" name="idNumber"
													maxlength="18" onblur="checkTraineeIdNumber()"
													placeholder="身份证不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">所住地址</label>
												<input type="text" class="form-control" name="address"
													maxlength="30">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="form-control-label">报名时间</label>
												<input type="date" class="form-control" name="enterDate"
													placeholder="报名时间不能为空">
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">申请类型</label>
												<select class="form-control" name="applicationType">
													<option value="B1">B1</option>
													<option value="B2">B2</option>
													<option value="C1">C1</option>
													<option value="C2">C2</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">学员状态</label>
												<select class="form-control" name="status">
													<option value="first" selected="selected">初次申领</option>
													<option value="add">增驾</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">教练编号</label>
												<select class="form-control" name="trainerId"
													onchange="selectTrainer()">
													<option value="">-------请选择教练编号------</option>
													<c:forEach items="${allTrainers}" var="trainer">
														<option value="${trainer.id }">${trainer.trainerNo }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments"
													maxlength="30" value="${trainee.comments }">
											</div>
										</div>
									</div>
									
									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<a href="trainee/showTrainee/${flag }"><button
													type="button" class="btn btn-primary px-5">返回</button></a>
										</div>
										<div style="margin-left: 100px">
											<button type="button" class="btn btn-primary px-5"
												onclick="checkTraineeForm();">保存</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>