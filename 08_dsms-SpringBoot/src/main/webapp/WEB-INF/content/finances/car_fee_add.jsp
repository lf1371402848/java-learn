<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
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
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>车辆费用新增</title>
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
							<div class="card-header bg-light">车辆费用新增</div>
							<form action="finance/addCarFee" method="post" name="carFee_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">车牌号</label> <select
                                                    class="form-control" name="itemId">
                                                    <option>-------请选择车牌号------</option>
                                                    <c:forEach items="${allCars}" var="car">
                                                        <option value="${car.id }">${car.carNo }</option>
                                                    </c:forEach>
                                                </select>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-3"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">费用类型</label>
												<select
                                                    class="form-control" name="itemType">
                                                    <option>-------请选择交费类型------</option>
                                                    <option value="repairFee">维修费用</option>
                                                    <option value="oilFee">加油费用</option>
                                                    <option value="else">其它费用</option>
                                                </select>
											</div>
										</div>
										<div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="form-control-label">费用金额</label>
                                                <input type="text" class="form-control" name="itemFee" oninput="value=value.replace(/[^\d]/g,'')">
                                            </div>
                                        </div>
									</div>

									<div class="row">
										<div class="col-md-3"></div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="form-control-label">费用时间</label>
                                                <input type="date" class="form-control" name="feeDate">
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
												onclick="checkCarFeeForm();">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="finance/showCarFee/${flag }"><button type="button"
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