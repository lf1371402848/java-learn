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
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>考试计划</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="js/page.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="row">
				<div class="col-md-12">
					<form action="exam/findExamPlanByCon" method="post">
						<div class="card">
							<div class="card-header bg-light" style="height: 55px">
								<div class="row">
									<div style="margin-left: 15px;">考试计划列表</div>
									<div style=" margin-top: -8px;margin-left: 10px;">
                                        <a href="exam/showExamPlanAdd">
                                            <button type="button" class="btn btn-primary">新增</button>
                                        </a>
                                    </div>
									<div class="col-md-3">
										科目: <select name="examType"
											style="width: 130px; height: 30px; margin-left: 15px; margin-top: -24px;">
											<option></option>
											<option value="exam1">科目一</option>
											<option value="exam2">科目二</option>
											<option value="exam3">科目三</option>
											<option value="exam4">科目四</option>
										</select>
									</div>
									<div class="col-md-3">
										考试车型: <select name="carType"
											style="width: 130px; height: 30px; margin-left: 15px; margin-top: -24px;">
											<option></option>
											<option value="B1">中型客车</option>
                                            <option value="B2">大型货车</option>
                                            <option value="C1">小型汽车自动挡</option>
                                            <option value="C2">小型汽车手动挡</option>
										</select>
									</div>
									<div class="col-md-2">
                                                                                                                        状态: <select name="status"
                                            style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;">
                                            <option></option>
                                            <option value="new">新增</option>
                                            <option value="start">预约中</option>
                                            <option value="end">预约结束</option>
                                        </select>
                                    </div>
									<div style="margin-left: 90px; margin-top: -8px;">
										<span class="input-group-btn">
										<button class="btn btn-primary"> <i class="fa fa-search"></i>查询 </button> 
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
												<th>考试编号</th>
												<th>考试场地</th>
												<th>详细地址</th>
												<th>考试类型</th>
												<th>考试车型</th>
												<th>考试预约计划人数</th>
												<th>考试时间</th>
												<th>状态</th>
												<th>备注</th>
												<th>编辑</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:forEach items="${allexamplans}" var="examplan"
												varStatus="status">
												<tr>
													<td>${status.index + 1 }</td>
													<td><a href="exam/showExamPlanEdit/${examplan.id}"
                                                            title="修改该考试计划" style="color: #2196f3">${examplan.planNo }</a>
                                                    </td>
													<td>${examplan.place }</td>
													<td>${examplan.address }</td>
													<td><c:if test="${examplan.examType  eq 'exam1' }">科目一</c:if>
                                                        <c:if test="${examplan.examType  eq 'exam2' }">科目二</c:if>
                                                        <c:if test="${examplan.examType  eq 'exam3' }">科目三</c:if>
                                                        <c:if test="${examplan.examType  eq 'exam4' }">科目四</c:if>
                                                    </td>   
													<td>${examplan.carType }</td>
													<td>${examplan.people }</td>
													<td><fmt:formatDate value="${examplan.examTime }"
															pattern="yyyy/MM/dd hh:mm" />
													</td>
													<td><c:if test="${examplan.status  eq 'new' }">新增</c:if>
													    <c:if test="${examplan.status  eq 'start' }">预约中</c:if>
                                                        <c:if test="${examplan.status  eq 'end' }">预约结束</c:if>
                                                    </td>	
                                                    <td>${examplan.comments }</td>
                                                    <td><a href="exam/deleteExamPlan/${examplan.id }"> <img
                                                                title="删除该考试计划" src="img/delete.png" width="20"
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
                                    var theTable = document.getElementById("tablelsw");   
                                    var totalPage = document.getElementById("spanTotalPage");   
                                    var pageNum = document.getElementById("spanPageNum"); 
                                    var rowNum = document.getElementById("numberRows"); 
                                      
                                    var spanPre = document.getElementById("spanPre");   
                                    var spanNext = document.getElementById("spanNext");   
                                    var spanFirst = document.getElementById("spanFirst");   
                                    var spanLast = document.getElementById("spanLast");   
                                      
                                    var numberRowsInTable = theTable.rows.length; 
                                    var maxPage = 0;  
                                    var pageSize = 7;   
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
