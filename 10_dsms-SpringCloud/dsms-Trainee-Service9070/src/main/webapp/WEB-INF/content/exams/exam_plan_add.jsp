<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>考试计划新增</title>
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
							<div class="card-header bg-light">新增考试计划</div>
							<form action="exam/addExamPlan" method="post"
								name="examPLan_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="single-select">考试科目</label> <select
													class="form-control" name="examType">
													<option value="exam1">科目一</option>
													<option value="exam2">科目二</option>
													<option value="exam3">科目三</option>
													<option value="exam4">科目四</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="form-control-label">考试车型</label> <select
													class="form-control" name="carType">
													<option value="B1">B1</option>
													<option value="B2">B2</option>
													<option value="C1">C1</option>
													<option value="C2">C2</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">考试场地</label> <span
													id="place" style="color: red; visibility: hidden;">考试场地不能为空</span>
												<input type="text" class="form-control" name="place"
													maxlength="10" onblur="checkPlanPlace()"
													placeholder="考试场地不能为空">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">详细地址</label> <span
													id="address" style="color: red; visibility: hidden;">详细地址不能为空</span>
												<input type="text" class="form-control" name="address"
													maxlength="30" onblur="checkPlanAdress()"
													placeholder="详细地址不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">考试预约计划人数</label>
												<span id="people" style="color: red; visibility: hidden;">人数不能为空</span>
												<input type="text" class="form-control" name="people"
													maxlength="10" onblur="checkPlanPeople()"
													placeholder="考试预约计划人数不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input">考试时间</label> <input type="date"
													class="form-control" name="examTime">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">状态</label> <select
													class="form-control" name="status">
													<option value="new">新增</option>
													<option value="start">预约中</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments"
													maxlength="30">
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<a href="exam/showExamPlan"><button type="button"
													class="btn btn-primary px-5">返回</button></a>
										</div>
										<div style="margin-left: 100px">
											<button type="button" class="btn btn-primary px-5"
												onclick="checkExamPlanForm();">保存</button>
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