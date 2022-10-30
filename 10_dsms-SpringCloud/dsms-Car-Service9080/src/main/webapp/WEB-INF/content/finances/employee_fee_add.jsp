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
	<title>新增员工工资情况</title>
	<link rel="stylesheet" href="css/styles.css">
	<script src="js/check_formInput.js"></script>
	<script type="text/javascript">
       var trainerList= '<%=session.getAttribute("allTrainersJson")%>';
    </script>
    <script src="js/select.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header bg-light">新增员工工资情况</div>
							<form action="finance/addEmployeeFee" method="post"
								name="employeeFee_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<div class="form-group">
                                                <label for="required-input" class="require">员工账号</label> <select
                                                    class="form-control" name="trainerNo"
                                                    onchange="selectTrainer()">
                                                    <option>-------请选择员工账号------</option>
                                                    <c:forEach items="${allTrainers}" var="trainer">
                                                        <option value="${trainer.key.id }">${trainer.key.trainerNo }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="read-only" class="form-control-label">姓名</label> <input
													type="text" class="form-control" name="name" readonly>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">薪水</label>
												<input type="text" class="form-control" name="salary" maxlength="10" oninput="value=value.replace(/[^\d]/g,'')">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments">
											</div>
										</div>
									</div>
									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<button type="button" class="btn btn-primary px-5"
												onclick="checkEmployeeFeeForm();">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="finance/showEmployeeFee/${flag }"><button
													type="button" class="btn btn-primary px-5">返回</button></a>
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