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
<title>考试成绩新增</title>
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
							<div class="card-header bg-light">新增考试成绩</div>
							<form action="exam/addExamResult" method="post"
								name="examResult_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="single-select">学员编号</label> <select
													class="form-control" name="traineeId"
													onchange="selectTrainee()">
													<option>-------请选择学员编号------</option>
													<c:forEach items="${allTrainees}" var="trainee">
														<option value="${trainee.id }"
															<c:if test="${examResult.traineeId eq trainee.id }">selected="selected"</c:if>>${trainee.traineeNo }
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">姓名</label> <input
													type="text" class="form-control" name="name" readonly>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">考试科目</label> <input
													type="text" class="form-control" name="examType" readonly>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">考试时间</label> <input
													type="text" class="form-control" name="examTime" readonly>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">考试分数</label> <input
													type="text" class="form-control" name="examScore" readonly>
											</div>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-2"></div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="required-input" class="require">状态</label> <input
												type="text" class="form-control" name="status" readonly>
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
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>