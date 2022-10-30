<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>教练新增</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript">
   var msg="<%=(String) session.getAttribute("addTrainer_msg")%>"; 
</script>
<script src="js/check_formInput.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header bg-light">新增教练</div>
							<form action="trainer/addTrainer" method="post"
								name="trainer_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">账号</label>
												<span id="trainerNo" style="color: red; visibility: hidden;">教练账号长度只能为4到10位</span>
												 <input
													type="text" class="form-control" name="trainerNo"
													maxlength="10" oninput="value=value.replace(/[\u4E00-\u9FA5 ]/g,'')" onblur="checkTrainerNo()" placeholder="账号不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">姓名</label>
												<span id="name" style="color: red; visibility: hidden;">教练名字长度只能为2到5位</span>
												 <input
													type="text" class="form-control" name="name" maxlength="5" onblur="checkTrainerName()"
													placeholder="姓名不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">年龄</label>
												<span id="age" style="color: red; visibility: hidden;">教练年龄只能在18到60岁</span>
												<input type="text" class="form-control"
													name="age" maxlength="2"
													oninput="value=value.replace(/[^\d]/g,'')" onblur="checkTrainerAge()"
													placeholder="年龄不能为空">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="single-select">性别</label> <select
													class="form-control" name="gender">
													<option value="M">男</option>
													<option value="F">女</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">电话</label>
												<span id="phone" style="color: red; visibility: hidden;">电话只能为11位</span>
												 <input type="text" class="form-control" name="phone"
													maxlength="11" oninput="value=value.replace(/[^\d]/g,'')" onblur="checkTrainerPhone()" 
													placeholder="电话不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">身份证号</label>
												<span id="idNumber" style="color: red; visibility: hidden;">身份证只能为18位</span>
												<input
													type="text" class="form-control" name="idNumber"
													maxlength="18" onblur="checkTrainerIdNumber()" placeholder="身份证不能为空">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input">驾照类型</label> <select
													class="form-control" name="licenseType">
													<option value="B1">B1</option>
													<option value="B2">B2</option>
													<option value="C1">C1</option>
													<option value="C2">C2</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">驾照编号</label>
												<span id="licenseNo" style="color: red; visibility: hidden;">驾照编号只能为18位</span>
												<input
													type="text" class="form-control" name="licenseNo"
													maxlength="18" onblur="checkTrainerLicenseNo()" placeholder="驾照编号不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">驾龄</label>
												<span id="drivingYears" style="color: red; visibility: hidden;">驾龄只能小于42</span>
												<input type="text" class="form-control" value="0"
													name="drivingYears" maxlength="2"
													oninput="value=value.replace(/[^\d]/g,'')" onblur="checkTrainerDrivingYears()"
													placeholder="驾龄不能为空">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">所负责车辆</label>
												<select class="form-control" name="carId">
												    <option value="">------请选择所负责车辆------</option>
                                                        <c:forEach items="${allCars}" var="car">
                                                            <c:if test="${car.status eq 'using' }">
                                                                <option value="${car.id }">${car.carNo }</option>
                                                            </c:if>
                                                        </c:forEach>
                                                 </select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">薪水</label>
												<input type="text" class="form-control" name="salary" maxlength="10" oninput="value=value.replace(/[^\d]/g,'')">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">入职时间</label>
												<input type="date" class="form-control" name="joinDate">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments" maxlength="30">
											</div>
										</div>
									</div>
									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<a href="trainer/showTrainer/${flag }"><button
													type="button" class="btn btn-primary px-5">返回</button></a>
										</div>
										<div style="margin-left: 100px">
											<button type="button" class="btn btn-primary px-5"
												onclick="checkTrainerForm();">保存</button>
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