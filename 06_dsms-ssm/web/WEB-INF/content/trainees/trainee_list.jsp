<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>学员信息管理</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="js/page.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="row">
				<div class="col-md-12">
					<form
						<c:if test="${flag eq 'admin' }">action="trainee/findAllTraineesByCon"</c:if>
						<c:if test="${flag eq 'trainer'}">action="trainer/findAllTrainersTraineesByCon"</c:if>
						method="post">
						<div class="card">
							<div class="card-header bg-light" style="height: 55px">
								<div class="row">
									<div class="col-md-2">学员信息列表</div>
									<div class="col-md-3">
										账号： <input type="text" class="form-control" name="traineeNo"
											style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;"
											placeholder="学员账号" title="请输入学员账号">
									</div>
									<div class="col-md-3">
										申请类型： <select name="applicationType"
											style="width: 130px; height: 30px; margin-left: 75px; margin-top: -24px;">
											<option></option>
											<option>B1</option>
											<option>B2</option>
											<option>C1</option>
											<option>C2</option>
										</select>
									</div>
									<div class="col-md-3">
										状态:<select name="status"
											style="width: 130px; height: 30px; margin-left: 15px; margin-top: -24px;">
											<option></option>
											<option value="first">初次申领</option>
											<option value="add">增驾</option>
											<option value="finish">已毕业</option>
											<option value="exam1_ordered">已预约科目一</option>
											<option value="exam1_pass">已通过科目一</option>
											<option value="exam2_ordered">已预约科目二</option>
                                            <option value="exam2_pass">已通过科目二</option>
                                            <option value="exam3_ordered">已预约科目三</option>
                                            <option value="exam3_pass">已通过科目三</option>
                                            <option value="exam4_ordered">已预约科目四</option>
                                            <option value="exam4_pass">已通过科目四</option>
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
												<th>学员账号</th>
												<th>姓名</th>
												<th>性别</th>
												<th>年龄</th>
												<th>身高</th>
												<th>电话</th>
												<th>身份证号</th>
												<th>地址</th>
												<th>报名时间</th>
												<th>申请类型</th>
												<th>状态</th>
												<th>教练账号</th>
												<th>编辑</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:forEach items="${alltrainees}" var="trainee"
												varStatus="status">
												<tr>
													<td>${status.index + 1 }</td>
													<td><a href="trainee/showTraineeEdit/${trainee.key.id }"
														title="修改该学员信息" style="color: #2196f3">${trainee.key.traineeNo }</a>
													</td>
													<td>${trainee.key.name }</td>
													<td><c:if test="${trainee.key.gender eq 'M' }">男</c:if> <c:if
															test="${trainee.key.gender eq 'F' }">女</c:if></td>
													<td>${trainee.key.age }</td>
													<td>${trainee.key.height }</td>
													<td>${trainee.key.phone }</td>
													<td>${trainee.key.idNumber }</td>
													<td>${trainee.key.address }</td>
													<td><fmt:formatDate value="${trainee.key.enterDate }" pattern="yyyy-MM-dd" /></td>
													<td>${trainee.key.applicationType }</td>
													<td>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam1_ordered')}">已预约科目一</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam1_pass')}">已通过科目一</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam2_ordered')}">已预约科目二</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam2_pass')}">已通过科目二</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam3_ordered')}">已预约科目三</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam3_pass')}">已通过科目三</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam4_ordered')}">已预约科目四</c:if>
                                                            <c:if test="${fn:contains(trainee.key.status, 'exam4_pass')}">已通过科目四</c:if>
                                                            <c:if test="${trainee.key.status eq 'first' }">初次申领</c:if>
                                                            <c:if test="${trainee.key.status eq 'add' }">增驾</c:if>
                                                            <c:if test="${trainee.key.status eq 'finish' }">已毕业</c:if>
                                                    </td>
                                                    <td>${trainee.value.trainerNo }</td>
													<td><a href="trainee/deleteTrainee/${trainee.key.id }">
															<img title="开除该学员" src="img/delete.png" width="20"
															height="13" />
													</a></td>
												</tr>
											</c:forEach>
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
