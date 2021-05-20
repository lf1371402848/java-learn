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
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>车辆新增</title>
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
							<div class="card-header bg-light">车辆信息表</div>
							<form action="car/addCar" method="post" name="car_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">车牌号</label> <span
													id="carNo" style="color: red; visibility: hidden;">车牌号只能为8位</span>
												<input type="text" class="form-control" name="carNo"
													maxlength="8" onblur="checkCarNo()" placeholder="车牌号不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">品牌</label> <span
													id="carBrand" style="color: red; visibility: hidden;">车品牌最长位10位</span>
												<input type="text" class="form-control" name="carBrand"
													maxlength="10" onblur="checkCarBrand()"
													placeholder="车品牌不能为空">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">价格</label> <span
													id="price" style="color: red; visibility: hidden;">请输入车价格</span>
												<input type="text" class="form-control" name="price"
													oninput="value=value.replace(/[^\d]/g,'')" maxlength="10"
													onblur="checkCarPrice()" placeholder="车价格不能为空">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">车类型</label>
												<select class="form-control" name="carType">
													<option value="B1">B1</option>
													<option value="B2">B2</option>
													<option value="C1">C1</option>
													<option value="C2">C2</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="require">发动机编号</label> <span
													id="engineNo" style="color: red; visibility: hidden;">请输入发动机编号</span>
												<input type="text" class="form-control" name="engineNo"
													oninput="value=value.replace(/[\u4E00-\u9FA5 ]/g,'')"
													maxlength="6" onblur="checkEngineNo()">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">车辆状态</label>
												<select class="form-control" name=status>
													<option value="unuse">未使用</option>
													<option value="using">使用中</option>
												</select>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="form-control-label">购入时间</label>
                                                <input type="date" class="form-control" name="buyDate">
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
											<button type="button" class="btn btn-primary px-5"
												onclick="checkCarForm();">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="car/showCar/${flag }"><button type="button"
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