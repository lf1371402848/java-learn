<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, 
minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>学员信息修改</title>
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
							<div class="card-header bg-light">学员个人信息表</div>
							<form action="trainee/updateTrainee" method="post"
								name="trainee_form">
								<div class="card-body">
									<c:forEach items="${trainee }" var="trainee">
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div>
													<input type="text" style="display: none;" name="id"
														value="${trainee.key.id }">
												</div>
												<div class="form-group">
													<label for="read-only" class="form-control-label">账号</label>
													<span id="traineeNo"
														style="color: red; visibility: hidden;">学员账号长度只能为4到10位</span>
													<input type="text" class="form-control" name="traineeNo"
														value="${trainee.key.traineeNo }" readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">姓名</label> <span
														id="name" style="color: red; visibility: hidden;">学员名字长度只能为2到5位</span>
													<input type="text" class="form-control" name="name"
														value="${trainee.key.name }" maxlength="5"
														onblur="checkTraineeName()" placeholder="姓名不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="single-select">性别</label> <select
														class="form-control" name="gender">
														<option value="M"
															<c:if test="${trainee.key.gender eq 'M' }">selected="selected"</c:if>>男</option>
														<option value="F"
															<c:if test="${trainee.key.gender eq 'F' }">selected="selected"</c:if>>女</option>
													</select>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">年龄</label> <span
														id="age" style="color: red; visibility: hidden;">学员年龄只能在18到60岁</span>
													<input type="text" class="form-control" name="age"
														value="${trainee.key.age }" maxlength="2"
														oninput="value=value.replace(/[^\d]/g,'')"
														onblur="checkTraineeAge()" placeholder="年龄不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">身高</label> <span
														id="height" style="color: red; visibility: hidden;">学员身高只能在150到200cm</span>
													<input type="text" class="form-control" name="height"
														value="${trainee.key.height }" maxlength="3"
														oninput="value=value.replace(/[^\d]/g,'')"
														onblur="checkTraineeHeight()">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="required-input" class="require">电话</label> <span
														id="phone" style="color: red; visibility: hidden;">电话只能为11位</span>
													<input type="text" class="form-control" name="phone"
														value="${trainee.key.phone }" maxlength="11"
														oninput="value=value.replace(/[^\d]/g,'')"
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
														value="${trainee.key.idNumber }" maxlength="18"
														oninput="value=value.replace(/[^\d]/g,'')"
														onblur="checkTraineeIdNumber()" placeholder="身份证不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="single-select">所住地址</label> <input type="text"
														class="form-control" name="address"
														value="${trainee.key.address }" maxlength="30">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">报名时间</label> <span
														id="enterDate" style="color: red; visibility: hidden;">请输入学员报名时间</span>
													<input type="date" class="form-control" name="enterDate"
														value="<fmt:formatDate value="${trainee.key.enterDate }" pattern="yyyy-MM-dd"/>"
														title="必填项不能为空">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">申请类型</label>
													<c:if test="${flag eq 'trainee' }">
														<input type="text" class="form-control"
															name="applicationType"
															value="${trainee.key.applicationType }"
															readonly="readonly">
													</c:if>
													<c:if test="${flag != 'trainee' }">
														<select class="form-control" name="applicationType">
															<option value="B1"
																<c:if test="${trainee.key.applicationType eq 'B1' }">selected="selected"</c:if>>B1</option>
															<option value="B2"
																<c:if test="${trainee.key.applicationType eq 'B2' }">selected="selected"</c:if>>B2</option>
															<option value="C1"
																<c:if test="${trainee.key.applicationType eq 'C1' }">selected="selected"</c:if>>C1</option>
															<option value="C2"
																<c:if test="${trainee.key.applicationType eq 'C2' }">selected="selected"</c:if>>C2</option>
														</select>
													</c:if>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">学员状态</label>
													<c:if test="${flag eq 'trainee' }">
														<input type="text" class="form-control" name="status"
															value="${trainee.key.status }" style="display: none;">
														<input type="text" class="form-control"
															readonly="readonly"
															<c:if test="${fn:contains(trainee.key.status, 'exam1_ordered')}">已预约科目一</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam1_pass')}">已通过科目一</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam2_ordered')}">已预约科目二</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam2_pass')}">已通过科目二</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam3_ordered')}">已预约科目三</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam3_pass')}">已通过科目三</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam4_ordered')}">已预约科目四</c:if>
															<c:if test="${fn:contains(trainee.key.status, 'exam4_pass')}">已通过科目四</c:if>
															<c:if test="${trainee.key.status eq 'first' }">初次申领</c:if>
															<c:if test="${trainee.key.status eq 'add' }">增驾</c:if>
															<c:if test="${trainee.key.status eq 'finish' }">已毕业</c:if>>
													</c:if>
													<c:if test="${flag != 'trainee' }">
														<select class="form-control" name="status">
															<c:if test="${fn:contains(trainee.key.status,'first_')}">
																<option value="first_exam1_ordered"
																	<c:if test="${trainee.key.status eq 'first_exam1_ordered' }">selected="selected"</c:if>>已预约科目一</option>
																<option value="first_exam1_pass"
																	<c:if test="${trainee.key.status eq 'first_exam1_pass' }">selected="selected"</c:if>>已通过科目一</option>
																<option value="first_exam2_ordered"
																	<c:if test="${trainee.key.status eq 'first_exam2_ordered' }">selected="selected"</c:if>>已预约科目二</option>
																<option value="first_exam2_pass"
																	<c:if test="${trainee.key.status eq 'first_exam2_pass' }">selected="selected"</c:if>>已通过科目二</option>
																<option value="first_exam3_ordered"
																	<c:if test="${trainee.key.status eq 'first_exam3_ordered' }">selected="selected"</c:if>>已预约科目三</option>
																<option value="first_exam3_pass"
																	<c:if test="${trainee.key.status eq 'first_exam3_pass' }">selected="selected"</c:if>>已通过科目三</option>
																<option value="first_exam4_ordered"
																	<c:if test="${trainee.key.status eq 'first_exam4_ordered' }">selected="selected"</c:if>>已预约科目四</option>
															</c:if>
															<c:if test="${fn:contains(trainee.key.status,'add_')}">
																<option value="add_exam1_ordered"
																	<c:if test="${trainee.key.status eq 'add_exam1_ordered' }">selected="selected"</c:if>>已预约科目一</option>
																<option value="add_exam1_pass"
																	<c:if test="${trainee.key.status eq 'add_exam1_pass' }">selected="selected"</c:if>>已通过科目一</option>
																<option value="add_exam2_ordered"
																	<c:if test="${trainee.key.status eq 'add_exam2_ordered' }">selected="selected"</c:if>>已预约科目二</option>
																<option value="add_exam2_pass"
																	<c:if test="${trainee.key.status eq 'add_exam2_pass' }">selected="selected"</c:if>>已通过科目二</option>
																<option value="add_exam3_ordered"
																	<c:if test="${trainee.key.status eq 'add_exam3_ordered' }">selected="selected"</c:if>>已预约科目三</option>
																<option value="add_exam3_pass"
																	<c:if test="${trainee.key.status eq 'add_exam3_pass' }">selected="selected"</c:if>>已通过科目三</option>
																<option value="add_exam4_ordered"
																	<c:if test="${trainee.key.status eq 'add_exam4_ordered' }">selected="selected"</c:if>>已预约科目四</option>
															</c:if>
															<option value="first"
																<c:if test="${trainee.key.status eq 'first' }">selected="selected"</c:if>>初次申领</option>
															<option value="add"
																<c:if test="${trainee.key.status eq 'add' }">selected="selected"</c:if>>增驾</option>
															<option value="finish"
																<c:if test="${trainee.key.status eq 'finish' }">selected="selected"</c:if>>已毕业</option>
														</select>
													</c:if>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">教练编号</label>
													<c:if test="${flag eq 'trainee' }">
														<input type="text" class="form-control"
															value="${trainee.value.trainerNo }" readonly="readonly">
														<input type="text" class="form-control" name="trainerId"
															value="${trainee.key.trainerId }" style="display: none;">
													</c:if>
													<c:if test="${flag != 'trainee' }">
														<select class="form-control" name="trainerId"
															onchange="selectTrainer()">
															<option value="">-------请选择教练编号------</option>
															<c:forEach items="${allTrainers}" var="trainer">
																<option value="${trainer.id }"
																	<c:if test="${trainer.id eq trainee.key.trainerId }">selected="selected"</c:if>>${trainer.trainerNo }
																</option>
															</c:forEach>
														</select>
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
														value="${trainee.key.comments }" maxlength="30">
												</div>
											</div>
										</div>

										<div class="row" style="margin-top: 40px">
											<div class="col-4"></div>
											<div class="col-2">
												<button type="button" class="btn btn-primary px-5"
													onclick="checkTraineeForm();">保存</button>
											</div>
											<div style="margin-left: 100px">
												<a
													<c:if test="${flag eq 'trainee' }">href="trainee/showTraineeEdit/${trainee.key.id }"</c:if>
													<c:if test="${flag eq 'admin' }">href="trainee/showTrainee/${flag }"</c:if>
													<c:if test="${flag eq 'trainer' }">href="trainer/showTrainee"</c:if>><button
														type="button" class="btn btn-primary px-5">返回</button></a>
											</div>
										</div>
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
