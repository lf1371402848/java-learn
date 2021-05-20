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
<title>车辆信息管理</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="js/page.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="row">
				<div class="col-md-12">
					<form action="car/findCarByCon" method="post">
						<div class="card">
							<div class="card-header bg-light" style="height: 55px">
								<div class="row">
									<div class="col-md-2">车辆信息管理</div>
									<div class="col-md-3">
										车牌号： <input type="text" class="form-control" name="carNo"
											style="width: 130px; height: 30px; margin-left: 60px; margin-top: -24px;"
											placeholder="车牌号" title="请输入车牌号">
									</div>
									<div class="col-md-3">
										车型: <select name="carType"
											style="width: 130px; height: 30px; margin-left: 10px; margin-top: -24px;">
											<option></option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
										</select>
									</div>
									<div class="col-md-2">
										状态： <select name=status
											style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;">
											<option></option>
											<option value="unuse">未使用</option>
											<option value="using">使用中</option>
											<option value="scraped">已报废</option>
										</select>
									</div>
									<div style="margin-left: 90px; margin-top: -8px;">
										<span class="input-group-btn">
											<button class="btn btn-primary">
												<i class="fa fa-search"></i>查询
											</button>
										</span>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-striped" id="main_table">
										<thead>
											<tr>
												<c:if test="${flag eq 'admin' }">
													<th>序号</th>
												</c:if>
												<th>车牌号</th>
												<th>品牌</th>
												<th>车型</th>
												<th>价格</th>
												<th>车辆状态</th>
												<th>购入时间</th>
												<th>备注</th>
												<th>编辑</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:if test="${flag eq 'admin' }">
												<c:forEach items="${allCars }" var="car" varStatus="status">
													<tr>
														<td>${status.index + 1 }</td>
														<td><a href="car/showCarEdit/${car.id }"
															title="修改该车辆信息" style="color: #2196f3">${car.carNo }</a></td>
														<td>${car.carBrand }</td>
														<td><c:if test="${car.carType eq 'B1' }">B1</c:if> <c:if
                                                            test="${car.carType eq 'B2' }">B2</c:if> <c:if
                                                            test="${car.carType eq 'C1' }">C1</c:if> <c:if
                                                            test="${car.carType eq 'C2' }">C2</c:if></td>
														<td>${car.price }</td>
														<td><c:if test="${car.status eq 'unuse' }">未使用</c:if>
															<c:if test="${car.status eq 'using' }">使用中</c:if> <c:if
																test="${car.status eq 'scraped' }">已报废</c:if></td>
														<td><fmt:formatDate value="${car.buyDate }"
                                                            pattern="yyyy-MM-dd" /></td>
														<td>${car.comments }</td>
														<td><a href="car/deleteCar/${car.id }"> <img
																title="报废该车" src="img/delete.png" width="20" height="13" /></a></td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${flag eq 'trainer' }">
												<tr>
													<td><a href="car/showCarEdit/${car.id }"
														title="修改该车辆信息" style="color: #2196f3">${car.carNo }</a></td>
													<td>${car.carBrand }</td>
													<td><c:if test="${car.carType eq 'B1' }">B1</c:if> <c:if
															test="${car.carType eq 'B2' }">B2</c:if> <c:if
															test="${car.carType eq 'C1' }">C1</c:if> <c:if
															test="${car.carType eq 'C2' }">C2</c:if></td>
													<td>${car.price }</td>
													<td><c:if test="${car.status eq 'unuse' }">未使用</c:if>
														<c:if test="${car.status eq 'using' }">使用中</c:if> <c:if
															test="${car.status eq 'scraped' }">已报废</c:if></td>
													<td>${car.comments }</td>
													<td><img title="报废该车" src="img/delete.png" width="20"
														height="13" /></a></td>
												</tr>
											</c:if>
										</tbody>
									</table>
									共<span id="numberRows"></span>条数据 <span
										style="margin-left: 300px;"> <span id="spanFirst"><a
											href='javascript:first();'>首页</a></span> <span id="spanPre"><a
											href='javascript:pre();'>上一页</a></span> <span id="spanNext"><a
											href='javascript:next();'>下一页</a></span> <span id="spanLast"><a
											href='javascript:last();'>尾页</a></span>
									</span> <span style="margin-left: 10px;"> 第<span
										id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
									</span>
									<script type="text/javascript">
										var theTable = document
												.getElementById("tablelsw");
										var totalPage = document
												.getElementById("spanTotalPage");
										var pageNum = document
												.getElementById("spanPageNum");
										var rowNum = document
												.getElementById("numberRows");

										var spanPre = document
												.getElementById("spanPre");
										var spanNext = document
												.getElementById("spanNext");
										var spanFirst = document
												.getElementById("spanFirst");
										var spanLast = document
												.getElementById("spanLast");

										var numberRowsInTable = theTable.rows.length;
										var maxPage = 0;
										var pageSize = 6;
										var page = 1;

										window.onload = function hide() {
											for (var i = pageSize; i < numberRowsInTable; i++) {
												theTable.rows[i].style.display = 'none';
											}
											totalPage.innerHTML = pageCount();
											pageNum.innerHTML = page;
											rowNum.innerHTML = numberRowsInTable;
										}
									</script>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
