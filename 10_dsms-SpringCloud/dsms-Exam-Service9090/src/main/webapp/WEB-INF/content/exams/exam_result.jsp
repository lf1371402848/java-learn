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
<title>考试成绩</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="js/page.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="row">
				<div class="col-md-12">
					<form action="exam/findExamResultByCon" method="post">
						<div class="card">
							<div class="card-header bg-light" style="height: 55px">
								<div class="row">
									<div style="margin-left: 15px;">学员考试成绩列表</div>
									<div style=" margin-top: -8px;margin-left: 10px;">
                                        <a href="exam/showExamResultAdd">
                                            <button type="button" class="btn btn-primary">新增</button>
                                        </a>
                                    </div>
									<div class="col-md-3">
										账号： <input type="text" class="form-control" name="traineeNo"
											style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;"
											placeholder="学员账号" title="请输入学员账号">
									</div>
									<div class="col-md-3">
										姓名： <input type="text" class="form-control" name="name"
											style="width: 130px; height: 30px; margin-left: 45px; margin-top: -24px;"
											placeholder="学员姓名" title="请输入学员姓名">
									</div>
									<div class="col-md-2">
										科目: <select name="examType"
											style="width: 130px; height: 30px; margin-left: 75px; margin-top: -24px;">
											<option></option>
											<option value="exam1">科目一</option>
											<option value="exam2">科目二</option>
											<option value="exam3">科目三</option>
											<option value="exam4">科目四</option>
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
												<th>序号</th>
												<th>学员编号</th>
												<th>学员姓名</th>
												<th>考试科目</th>
												<th>考试成绩</th>
												<th>考试时间</th>
												<th>是否合格</th>
												<th>编辑</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:forEach items="${allexamresults }" var="examresult"
												varStatus="status">
												<tr>
													<td>${status.index + 1 }</td>
													<td>${examresult.key.traineeNo }</td>
													<td>${examresult.key.name }</td>
													<td>
													<c:forEach items="${allExamPlan }" var="examPlan">
													    <c:if test="${examresult.value.examPlanId eq examPlan.id && examPlan.examType eq 'exam1'}">科目一</c:if>
                                                        <c:if test="${examresult.value.examPlanId eq examPlan.id && examPlan.examType eq 'exam2'}">科目二</c:if>
                                                        <c:if test="${examresult.value.examPlanId eq examPlan.id && examPlan.examType eq 'exam3'}">科目三</c:if>
                                                        <c:if test="${examresult.value.examPlanId eq examPlan.id && examPlan.examType eq 'exam4'}">科目四</c:if>
                                                    </c:forEach>
                                                    </td>  
													<td>${examresult.value.examScore }</td>
													<td>
													   <c:forEach items="${allExamPlan }" var="examPlan">
													   <c:if test="${examresult.value.examPlanId eq examPlan.id}">
													   <fmt:formatDate value="${examPlan.examTime }"
                                                            pattern="yyyy/MM/dd hh:mm" />
                                                       </c:if>
                                                       </c:forEach>
                                                    </td>
													<td>
													    <c:if test="${examresult.value.status eq 'pass' }"><span style="color: #2196f3">通过</span></c:if>
                                                        <c:if test="${examresult.value.status eq 'out' }"><span style="color: red">失败</span></c:if>
													</td>
													<td><a href="exam/deleteExamResult/${examresult.value.id }"> <img
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
