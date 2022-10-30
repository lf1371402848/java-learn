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
<title>其它费用信息管理</title>
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
									<div style="margin-left: 15px;">其它费用信息列表</div>
                                    <div style="margin-top: -8px;margin-left: 10px;">
                                        <a href="finance/showOtherFeeAdd">
                                            <button type="button" class="btn btn-primary">新增</button>
                                        </a>
                                    </div>
									<div style="margin-left: 30px">
										费用类型： <input type="text" class="form-control" name="itemType"
                                            style="width: 130px; height: 30px; margin-left: 70px; margin-top: -24px;"
                                            placeholder="费用类型" title="请输入费用类型">
									</div>
									<div style="margin-left: 30px">
										费用时间从： <input type="date" class="form-control" name="startDate"
											style="width: 150px; height: 30px; margin-left: 80px; margin-top: -24px;">
									</div>
									<div style="margin-left: 30px">
										费用时间至： <input type="date" class="form-control" name="endDate"
                                            style="width: 150px; height: 30px; margin-left: 80px; margin-top: -24px;">
									</div>
									<div style="margin-left: 30px; margin-top: -8px;">
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
												<th>费用编号</th>
												<th>费用类型</th>
												<th>费用金额</th>
												<th>费用时间</th>
												<th>备注</th>
												<th>编辑</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:forEach items="${allOtherFee }" var="otherFee"
												varStatus="status">
												<tr>
													<td>${status.index + 1 }</td>
													<td><a href="finance/showOtherFeeEdit/${otherFee.id }"
														title="修改该费用信息" style="color: #2196f3">${otherFee.id }</a>
													</td>
													<td>${otherFee.itemType }</td>
													<td>${otherFee.itemFee }</td>
													<td><fmt:formatDate value="${otherFee.feeDate }"
                                                            pattern="yyyy-MM-dd" /></td>
													<td>${otherFee.comments }</td>
													<td><a href="finance/deleteOtherFee/${otherFee.id }">
															<img title="解聘该教练" src="img/delete.png" width="20"
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
