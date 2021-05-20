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
<title>新增其它费用情况</title>
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
							<div class="card-header bg-light">新增其它费用情况</div>
							<form action="finance/addOtherFee" method="post"
								name="otherFee_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<label for="normal-input" class="form-control-label">费用名称</label>
											<input type="text" class="form-control" name="itemType">
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">费用金额</label>
												<input type="text" class="form-control" name="itemFee"
													oninput="value=value.replace(/[^\d]/g,'')">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">费用时间</label> <input
													type="date" class="form-control" name="feeDate">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">交费类型</label> <select
													class="form-control" name="flag">
													<option>-------请选择交费类型------</option>
													<option value="in">收入</option>
													<option value="out">支出</option>
												</select>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3"></div>
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
												onclick="checkOtherFeeForm();">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="finance/showOtherFee/${flag }"><button
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