<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>驾校收支统计分析</title>
<link rel="stylesheet" href="css/styles.css">
<script src="js/jquery/jquery.min.js"></script>
<script src="js/chart/chart.min.js"></script>
<script type="text/javascript">
        var schoolInOutNameBar= '<%=session.getAttribute("schoolInOutNameBar")%>';
        var schoolInOutValueBar= '<%=session.getAttribute("schoolInOutValueBar")%>';
        var schoolInOutNameLine= '<%=session.getAttribute("schoolInOutNameLine")%>';
        var schoolInValueLine= '<%=session.getAttribute("schoolInValueLine")%>';
        var schoolOutValueLine= '<%=session.getAttribute("schoolOutValueLine")%>';
</script>
<script src="js/chart/school_chart.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<form action="analysis/findSchoolInOutByCon" method="post">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header bg-light" style="height: 55px">
								<div class="row">
									<div style="margin-left: 15px;">驾校收支情况</div>
									<div class="col-md-2"></div>
									<div style="margin-left: 30px">
										时间从： <input type="date" class="form-control" name="startDate"
											style="width: 150px; height: 30px; margin-left: 80px; margin-top: -24px;">
									</div>
									<div style="margin-left: 30px">
										时间至： <input type="date" class="form-control" name="endDate"
											style="width: 150px; height: 30px; margin-left: 80px; margin-top: -24px;">
									</div>
									<div style="margin-left: 170px; margin-top: -8px;">
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
												<th>总收入</th>
												<th>学员收入</th>
												<th>其它收入</th>
												<th>总支出</th>
												<th>员工工资</th>
												<th>车辆费用</th>
												<th>其它支出</th>
											</tr>
										</thead>
										<tbody id="tablelsw">
											<c:forEach items="${schoolInOutValueBar}" var="schoolInOutValue">
												<td>${schoolInOutValue }</td>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-header bg-light">驾校收支条形图</div>

							<div class="card-body">
								<canvas id="bar-chart" width="100%" height="70"></canvas>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-header bg-light">驾校总收支折线图</div>

							<div class="card-body">
								<canvas id="line-chart" width="100%" height="70"></canvas>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
