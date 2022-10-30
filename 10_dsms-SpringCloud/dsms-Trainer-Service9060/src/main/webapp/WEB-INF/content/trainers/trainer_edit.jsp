<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>教练信息修改</title>
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
							<div class="card-header bg-light">教练员个人信息表</div>
							<form action="trainer/updateTrainer" method="post"
								name="trainer_form">
								<div class="card-body">
									<c:forEach items="${trainer }" var="trainer">
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div>
													<input type="text" style="display: none;" name="id"
														value="${trainer.key.id }">
												</div>
												<div class="form-group">
													<label for="read-only" class="form-control-label">账号</label>
													<span id="trainerNo" style="color: red; visibility: hidden;">教练账号长度只能为4到10位</span>
													<input type="text" class="form-control" name="trainerNo"
														value="${trainer.key.trainerNo }" readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">姓名</label>
													<span id="name" style="color: red; visibility: hidden;">教练名字长度只能为2到5位</span>
													<input
														type="text" class="form-control" name="name"
														value="${trainer.key.name }" maxlength="5" onblur="checkTrainerName()" title="姓名不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">年龄</label>
													<span id="age" style="color: red; visibility: hidden;">教练年龄只能在18到60岁</span>
													<input type="text" class="form-control" name="age"
														value="${trainer.key.age }" maxlength="2"
														oninput="value=value.replace(/[^\d]/g,'')" onblur="checkTrainerAge()" title="年龄不能为空">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="single-select">性别</label> <select
														class="form-control" name="gender">
														<option value="M"
															<c:if test="${trainer.key.gender eq 'M' }">selected="selected"</c:if>>男</option>
														<option value="F"
															<c:if test="${trainer.key.gender eq 'F' }">selected="selected"</c:if>>女</option>
													</select>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">电话</label>
													<span id="phone" style="color: red; visibility: hidden;">电话只能为11位</span>
													<input
														type="text" class="form-control" name="phone"
														value="${trainer.key.phone }" maxlength="11"
														oninput="value=value.replace(/[^\d]/g,'')"
														onblur="checkTrainerPhone()" title="电话号码不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="required-input" class="require">身份证号</label>
													<span id="idNumber" style="color: red; visibility: hidden;">身份证只能为18位</span>
													<input
														type="text" class="form-control" name="idNumber"
														value="${trainer.key.idNumber }" maxlength="18"
														onblur="checkTrainerIdNumber()" title="身份证不能为空">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="single-select">驾照类型</label> <select
														class="form-control" name="licenseType">
														<option value="B1"
															<c:if test="${trainer.key.licenseType eq 'B1' }">selected="selected"</c:if>>B1</option>
														<option value="B2"
															<c:if test="${trainer.key.licenseType eq 'B2' }">selected="selected"</c:if>>B2</option>
														<option value="C1"
															<c:if test="${trainer.key.licenseType eq 'C1' }">selected="selected"</c:if>>C1</option>
														<option value="C2"
															<c:if test="${trainer.key.licenseType eq 'C2' }">selected="selected"</c:if>>C2</option>
													</select>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">驾照编号</label>
													<span id="licenseNo" style="color: red; visibility: hidden;">驾照编号只能为18位</span>
													<input
														type="text" class="form-control" name="licenseNo"
														value="${trainer.key.licenseNo }" maxlength="18" onblur="checkTrainerLicenseNo()" title="驾照编号不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">驾龄</label>
													<span id="drivingYears" style="color: red; visibility: hidden;">驾龄只能小于42</span>
													<input type="text" class="form-control" name="drivingYears"
														value="${trainer.key.drivingYears }" maxlength="2" onblur="checkTrainerDrivingYears()"
														oninput="value=value.replace(/[^\d]/g,'')">
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
															    <c:if test="${trainer.value.carNo eq null}">
															        <c:if test="${car.status eq 'using' }">
																	    <option value="${car.id }">${car.carNo }</option>
																	</c:if>
																</c:if>
																<c:if test="${trainer.value.carNo != null}">
																    <c:if test="${car.status eq 'using' }">
		                                                                <option value="${car.id }"
		                                                                    <c:if test="${trainer.value.carNo eq car.carNo }">selected="selected"</c:if>>${car.carNo }
		                                                                </option>
		                                                            </c:if>
	                                                            </c:if>
															</c:forEach>
														</select>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
												    <c:if test="${flag eq 'admin' }">
														<label for="normal-input" class="form-control-label">薪水</label>
														<input type="text" class="form-control" name="salary"
															value="${trainer.key.salary }" maxlength="10"
															oninput="value=value.replace(/[^\d]/g,'')">
													</c:if>
												    <c:if test="${flag eq 'trainer' }">
												        <label for="read-only" class="form-control-label">薪水</label>
                                                        <input type="text" class="form-control" name="salary"
                                                            value="${trainer.key.salary }" readonly>
												    </c:if>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
												    <c:if test="${flag eq 'admin' }">
														<label for="normal-input" class="form-control-label">入职时间</label>
														<input type="date" class="form-control" name="joinDate"
															value="<fmt:formatDate value="${trainer.key.joinDate }" pattern="yyyy-MM-dd"/>">
													</c:if>
													<c:if test="${flag eq 'trainer' }">
													   <label for="read-only" class="form-control-label">入职时间</label>
													   <input type="date" class="form-control" name="joinDate"
                                                            value="<fmt:formatDate value="${trainer.key.joinDate }" pattern="yyyy-MM-dd"/>" readonly>
													</c:if>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">备注</label>
													<input type="text" class="form-control" name="comments"
														value="${trainer.key.comments }" maxlength="30">
												</div>
											</div>
										</div>
										<c:if test="${flag != 'trainee' }">
											<div class="row" style="margin-top: 20px">
												<div class="col-4"></div>
												<div class="col-2">
													<button type="button" class="btn btn-primary px-5"
														onclick="checkTrainerForm();">保存</button>
												</div>
												<c:if test="${flag eq 'admin' }">
													<div style="margin-left: 100px">
														<a href="trainer/showTrainer/${flag }"><button
																type="button" class="btn btn-primary px-5">返回</button></a>
													</div>
												</c:if>
											</div>
										</c:if>
									</c:forEach>
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