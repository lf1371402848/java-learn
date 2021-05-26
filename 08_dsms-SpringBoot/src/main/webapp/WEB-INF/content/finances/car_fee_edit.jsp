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
<title>车辆费用信息修改</title>
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
							<div class="card-header bg-light">车辆费用信息表</div>
							<form action="finance/updateCarFee" method="post" name="carFee_form">
								<div class="card-body">
								<c:forEach items="${carFee }" var="carFee">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div>
												<input type="text" style="display: none;" name="id"
													value="${carFee.value.id }">
											</div>
											<div>
                                                <input type="text" style="display: none;" name="itemId"
                                                    value="${carFee.value.itemId }">
                                            </div>
											<div class="form-group">
												<label for="read-only" class="form-control-label">车牌号</label>
												<input type="text" class="form-control" name="carNo"
													value="${carFee.key.carNo }" readonly>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="read-only" class="form-control-label">价格</label>
												<input type="text" class="form-control" name="price"
													value="${carFee.key.price }" readonly>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">费用类型</label>
												<select class="form-control" name="itemType">
                                                    <option value="repairFee"
                                                        <c:if test="${carFee.value.itemType eq 'repairFee' }">selected="selected"</c:if>>维修费用</option>
                                                    <option value="oilFee"
                                                        <c:if test="${carFee.value.itemType eq 'oilFee' }">selected="selected"</c:if>>加油费用</option>
                                                    <option value="else"
                                                        <c:if test="${carFee.value.itemType eq 'else' }">selected="selected"</c:if>>其它费用</option>
                                                </select>
											</div>
										</div>
										<div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="form-control-label">费用金额</label>
                                                <input type="text" class="form-control" name="itemFee"
                                                    value="${carFee.value.itemFee }" oninput="value=value.replace(/[^\d]/g,'')">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="form-control-label">费用时间</label>
                                                <input type="date" class="form-control" name="feeDate"
                                                    value="<fmt:formatDate value="${carFee.value.feeDate }" pattern="yyyy-MM-dd"/>">
                                            </div>
                                        </div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments"
													value="${carFee.value.comments }">
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