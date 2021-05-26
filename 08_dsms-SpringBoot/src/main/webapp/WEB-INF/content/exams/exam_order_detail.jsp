<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
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
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>考试预约</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript">
        var examPlanList= '<%=session.getAttribute("allExamPlansJson")%>';
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
							<div class="card-header bg-light">学员考试预约</div>
							<form action="exam/orderExam" method="post" name="orderExam_form">
								<div class="card-body">
									<c:forEach items="${trainee }" var="trainee">
										<div class="row">
											<div class="col-md-2">
												<div class="form-group">
													<input type="text" style="display: none;" name="traineeId"
														value="${trainee.key.id }">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">学员编号</label>
													<input type="text" class="form-control" name="traineeNo"
														value="${trainee.key.traineeNo }" readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">学员姓名</label>
													<input type="text" class="form-control" name="name"
														value="${trainee.key.name }" readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">学员电话</label>
													<input type="text" class="form-control" name="phone"
														value="${trainee.key.phone }" readonly>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">学员身份证号码</label>
													<input type="text" class="form-control" name="idNumber"
														value="${trainee.key.idNumber }" readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">报名时间</label>
													<input type="text" class="form-control" name="enterDate"
														value="<fmt:formatDate value="${trainee.key.enterDate }" pattern="yyyy-MM-dd"/>"
														readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">申请车型</label>
													<input type="text" class="form-control"
														name="applicationType"
														value="${trainee.key.applicationType }" readonly>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="require">考试编号</label> <select
														class="form-control" name="examPlanId"
														onchange="selectExamPlan()">
														<option>-------请选择考试编号------</option>
														<c:forEach items="${allExamPlans}" var="examplan">
															<c:if test="${examplan.status eq 'start' }">
																<option value="${examplan.id }">${examplan.planNo }</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="require">考试科目</label><input
														type="text" class="form-control" name="examType" value=""
														readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="require">考试日期</label> <input
														type="text" class="form-control" value="" name="examTime"
														readonly>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="require">考试车型</label><input
														type="text" class="form-control" name="carType" value=""
														readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="require"></label>考试地点<input
														type="text" class="form-control" name="place" value=""
														readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="require"></label>详细地址<input
														type="text" class="form-control" name="address" value=""
														readonly>
												</div>
											</div>
										</div>
										<div class="row" style="margin-top: 20px">
											<div class="col-4"></div>
											<div class="col-2">
												<a href="exam/showExamOrderList"><button type="button"
														class="btn btn-primary px-5">返回</button></a>
											</div>
											<div style="margin-left: 100px">
												<button type="button" class="btn btn-primary px-5"
													onclick="checkOrderExamForm();">保存</button>
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
