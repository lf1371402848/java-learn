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
<title>教练员信息管理</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="js/page.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="row">
				<div class="col-md-12">
					<form action="trainer/findAllTrainersByCon" method="post">
						<div class="card">
							<div class="card-header bg-light" style="height: 55px">
								<div class="row">
									<div class="col-md-2">教练信息列表</div>
									<div class="col-md-3">
										账号： <input type="text" class="form-control" name="trainerNo"
											style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;"
											placeholder="教练账号" title="请输入教练账号">
									</div>
									<div class="col-md-3">
										姓名： <input type="text" class="form-control" name="name"
											style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;"
											placeholder="教练姓名" title="请输入教练姓名">
									</div>
									<div class="col-md-3">
										驾照类型： <select name="licenseType"
											style="width: 130px; height: 30px; margin-left: 75px; margin-top: -24px;">
											<option></option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
										</select>
									</div>
									<div style="margin-top: -8px;">
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
												<th>序号</th>
												<th>教练账号</th>
												<th>姓名</th>
												<th>性别</th>
												<th>年龄</th>
												<th>电话</th>
												<th>身份证号</th>
												<th>驾照类型</th>
												<th>所负责车辆</th>
												<th>入职时间</th>
												<th>备注</th>
												<th>编辑</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:if test="${flag eq 'admin' }">
												<c:forEach items="${allTrainers }" var="trainer"
													varStatus="status">
													<tr>
														<td>${status.index + 1 }</td>
														<td><a
															href="trainer/showTrainerEdit/${trainer.key.id }"
															title="修改该教练信息" style="color: #2196f3">${trainer.key.trainerNo }</a>
														</td>
														<td>${trainer.key.name }</td>
														<td><c:if test="${trainer.key.gender eq 'M' }">男</c:if>
															<c:if test="${trainer.key.gender eq 'F' }">女</c:if></td>
														<td>${trainer.key.age }</td>
														<td>${trainer.key.phone }</td>
														<td>${trainer.key.idNumber }</td>
														<td>${trainer.key.licenseType }</td>
														<td>${trainer.value.carNo }</td>
														<td><fmt:formatDate value="${trainer.key.joinDate }"></fmt:formatDate></td>
														<td>${trainer.key.comments }</td>
														<td><a
															href="trainer/deleteTrainer/${trainer.key.id }"> <img
																title="解聘该教练" src="img/delete.png" width="20"
																height="13" />
														</a></td>
													</tr>
												</c:forEach>
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
