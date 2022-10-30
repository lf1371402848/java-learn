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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, 
minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>学员费用信息修改</title>
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
							<div class="card-header bg-light">学员费用情况</div>
							<form action="finance/updateTraineeFee" method="post"
								name="traineeFee_form">
								<div class="card-body">
									<c:forEach items="${traineeFee}" var="traineeFee">
										<div class="row">
											<div class="col-md-3"></div>
											<div class="col-md-3">
												<div>
													<input type="text" style="display: none;" name="id"
														value="${traineeFee.value.id }">
												</div>
												<div class="form-group">
													<label for="read-only" class="form-control-label">账号</label>
													<input type="text" class="form-control" name="traineeNo"
														value="${traineeFee.key.traineeNo }" readonly>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="read-only" class="form-control-label">姓名</label>
													<input type="text" class="form-control" name="name"
														value="${traineeFee.key.name }" maxlength="5" readonly>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-3"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">交费类型</label>
													<select class="form-control" name="itemType">
														<option value="resit"
															<c:if test="${traineeFee.value.itemType eq 'resit' }">selected="selected"</c:if>>补考费</option>
														<option value="entryFee"
															<c:if test="${traineeFee.value.itemType eq 'entryFee' }">selected="selected"</c:if>>报名费</option>
													</select>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">交费金额</label>
													<input type="text" class="form-control" name="itemFee"
														value="${traineeFee.value.itemFee }"
														oninput="value=value.replace(/[^\d]/g,'')">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-3"></div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">交费时间</label>
													<input type="date" class="form-control" name="feeDate"
														value="<fmt:formatDate value="${traineeFee.value.feeDate }" pattern="yyyy-MM-dd"/>"
														title="必填项不能为空">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label for="normal-input" class="form-control-label">备注</label>
													<input type="text" class="form-control" name="comments"
														value="${traineeFee.value.comments }">
												</div>
											</div>
										</div>
									</c:forEach>

									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<button class="btn btn-primary px-5">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="finance/showTraineeFee/${flag}"><button
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
