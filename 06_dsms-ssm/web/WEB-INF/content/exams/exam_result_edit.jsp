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
<title>考试成绩修改</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript">
        var traineeList= '<%=session.getAttribute("allTraineesJson")%>';
    </script>
<script src="js/select.js"></script>
<script src="js/check_formInput.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header bg-light">考试成绩</div>
							<form action="exam/updateExamResult" method="post"
								name="examResult_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div>
												<input type="text" style="display: none;" name="id"
													value="${examResult.id }">
											</div>
											<div class="form-group">
												<label for="read-only" class="form-control-label">考试编号</label>
												<input type="text" class="form-control" name="planNo"
													value="${examPlan.planNo }" readonly>
											</div>
										</div>
										<div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="require">考试科目</label> <select
                                                    class="form-control" name="examType">
                                                    <option value="exam1"
                                                        <c:if test="${examPlan.examType eq 'exam1' }">selected="selected"</c:if>>科目一</option>
                                                    <option value="exam2"
                                                        <c:if test="${examPlan.examType eq 'exam2' }">selected="selected"</c:if>>科目二</option>
                                                    <option value="exam3"
                                                        <c:if test="${examPlan.examType eq 'exam3' }">selected="selected"</c:if>>科目三</option>
                                                    <option value="exam4"
                                                        <c:if test="${examPlan.examType eq 'exam4' }">selected="selected"</c:if>>科目四</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="require">考试车型</label> <select
                                                    class="form-control" name="carType">
                                                    <option value="B1"
                                                        <c:if test="${examPlan.carType eq 'B1' }">selected="selected"</c:if>>B1</option>
                                                    <option value="B2"
                                                        <c:if test="${examPlan.carType eq 'B2' }">selected="selected"</c:if>>B2</option>
                                                    <option value="C1"
                                                        <c:if test="${examPlan.carType eq 'C1' }">selected="selected"</c:if>>C1</option>
                                                    <option value="C2"
                                                        <c:if test="${examPlan.carType eq 'C2' }">selected="selected"</c:if>>C2</option>
                                                </select>
                                            </div>
                                        </div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">考试场地</label> <span
													id="place" style="color: red; visibility: hidden;">考试场地不能为空</span>
												<input type="text" class="form-control" name="place"
													maxlength="10" onblur="checkPlanPlace()"
													value="${examPlan.place }">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">详细地址</label> <span
													id="address" style="color: red; visibility: hidden;">详细地址不能为空</span>
												<input type="text" class="form-control" name="address"
													maxlength="30" onblur="checkPlanAdress()"
													value="${examPlan.address }">
											</div>
										</div>
										
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">考试预约计划人数</label> <span
													id="people" style="color: red; visibility: hidden;">人数不能为空</span>
												<input type="text" class="form-control" name="people"
													maxlength="10" onblur="checkPlanPeople()"
													value="${examPlan.people }">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">考试时间</label> <input
													type="date" class="form-control" name="examTime"
													value="<fmt:formatDate value="${examPlan.examTime }" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">状态</label> <select
													class="form-control" name="status">
													<option value="new"
														<c:if test="${examPlan.status eq 'new' }">selected="selected"</c:if>>新增</option>
													<option value="start"
														<c:if test="${examPlan.status eq 'start' }">selected="selected"</c:if>>预约中</option>
													<option value="end"
														<c:if test="${examPlan.status eq 'end' }">selected="selected"</c:if>>预约结束</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments"
													value="${examPlan.comments }">
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<button type="button" class="btn btn-primary px-5"
												onclick="checkExamPlanForm();">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="exam/showExamPlan"><button type="button"
													class="btn btn-primary px-5">返回</button></a>
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