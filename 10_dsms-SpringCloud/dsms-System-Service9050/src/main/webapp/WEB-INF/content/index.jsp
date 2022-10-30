<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>主页面</title>
<link rel="stylesheet" href="css/simple-line-icons.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<link rel="stylesheet" href="css/styles.css">
<script src="js/jquery/jquery.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/chart/chart.min.js"></script>
<script src="js/carbon.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<nav class="navbar page-header">
			<a class="navbar-brand">新力驾校</a>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item d-md-down-none"><a href="#"> <i
						class="fa fa-bell"></i> <span
						class="badge badge-pill badge-danger">5</span>
				</a></li>

				<li class="nav-item d-md-down-none"><a href="#"> <i
						class="fa fa-envelope-open"></i> <span
						class="badge badge-pill badge-danger">5</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img class="avatar avatar-sm" alt="logo"
						<c:if test="${flag eq 'admin' }"> src="img/admin.png"</c:if>
						<c:if test="${flag eq 'trainer' }"> src="img/trainer.png"</c:if>
						<c:if test="${flag eq 'trainee' }"> src="img/trainee.png"</c:if>>
						<span class="small ml-1 d-md-down-none"> <c:if
								test="${flag eq 'admin' }">${adminLogin.username }</c:if> <c:if
								test="${flag eq 'trainer' }">${trainerLogin.trainerNo }</c:if> <c:if
								test="${flag eq 'trainee' }">${traineeLogin.traineeNo }</c:if>
					</span>
				</a>
					<div class="dropdown-menu dropdown-menu-right">
						<div class="dropdown-header">账户</div>
						<a href="login/showChangePwd" class="dropdown-item"> <i
							class="fa fa-wrench"></i> 修改密码
						</a> <a href="login/userLogOut" class="dropdown-item"> <i class="fa fa-lock"></i>
							退出登录
						</a>
					</div></li>
			</ul>
		</nav>

		<div class="main-container">
			<div class="sidebar">
				<nav class="sidebar-nav">
					<ul class="nav">
						<li class="nav-title">主界面</li>

						<c:if test="${flag eq 'admin' }">
							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-speedometer"></i> 教练管理 <i
									class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="system/trainer/showTrainer/${flag }"
										  target="Conframe" class="nav-link" style="margin-left: 30px"> 
										            教练列表 </a></li>
									<li class="nav-item"><a href="system/trainer/showTrainerAdd"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											新教练聘用 </a></li>
								</ul></li>
							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-target"></i> 学员管理 <i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="trainee/showTrainee/${flag }" 
									   target="Conframe" class="nav-link" style="margin-left: 30px"> 
									                   学员列表 </a></li>
									<li class="nav-item"><a href="trainee/showTraineeAdd"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											新学员信息录入 </a></li>
								</ul></li>

							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-energy"></i> 车辆信息管理 <i
									class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="car/showCar/${flag }"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											车辆列表 </a></li>
									<li class="nav-item"><a href="car/showCarAdd"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											新车辆信息录入 </a></li>
								</ul></li>

							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-grid"></i> 考试管理 <i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="exam/showExamPlan"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											考试计划 </a> <a href="exam/showExamOrdered" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 已预约考试情况 </a> <a
										href="exam/showExamOrderList" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 预约考试 </a> <a
										href="exam/showExamResult" target="Conframe" class="nav-link"
										style="margin-left: 30px"> 学员考试成绩 </a></li>
								</ul></li>
							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-puzzle"></i> 财务管理 <i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a
										href="finance/showTraineeFee/${flag }" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 学员交费情况 </a> <a
										href="finance/showEmployeeFee/${flag }" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 员工工资发放情况 </a> <a
										href="finance/showCarFee/${flag }" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 车辆费用情况 </a> <a
										href="finance/showOtherFee/${flag }" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 其它费用情况 </a></li>
								</ul></li>
							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle" href=""> <i
									class="icon icon-graph"></i> 统计分析 <i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="analysis/showSchoolInOut"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											驾校收支情况 </a> <a href="analysis/showPeopleNum" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 人员统计 </a> <a
										href="analysis/showCarNum" target="Conframe" class="nav-link"
										style="margin-left: 30px"> 车辆统计 </a></li>
								</ul></li>
							<li class="nav-title">更多</li>

							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"><i 
								    class="icon icon-umbrella"></i> 系统管理 <i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="system/showSystemLog" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 系统日志 </a></li>
								</ul></li>
						</c:if>

						<c:if test="${flag eq 'trainer' }">
							<li class="nav-item"><a class="nav-link"
								href="trainer/showTrainerEdit/${trainerLogin.id }"
								target="Conframe"> <i class="icon icon-speedometer"></i>
									个人信息
							</a></li>
							<li class="nav-item"><a href="trainer/showTrainee"
								class="nav-link" target="Conframe"> <i
									class="icon icon-target"></i> 负责学员列表
							</a></li>
							<li class="nav-item">
							<c:if test="${trainerLogin.carId eq null}">
							<a class="nav-link" target="Conframe"
								href="car/showCarEdit/0"> <i
									class="icon icon-energy"></i> 负责车辆信息
							</a>
							</c:if>
							<c:if test="${trainerLogin.carId != null}">
                            <a class="nav-link" target="Conframe"
                                href="car/showCarEdit/${trainerLogin.carId}"> <i
                                    class="icon icon-energy"></i> 负责车辆信息
                            </a>
                            </c:if>
							</li>
							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-grid"></i> 负责学员考试信息<i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="exam/showExamPlan"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											考试计划 </a> <a href="exam/showExamOrdered" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 已预约考试情况 </a> <a
										href="exam/showExamOrderList" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 预约负责学员考试 </a> <a
										href="exam/showExamResult" target="Conframe" class="nav-link"
										style="margin-left: 30px"> 负责学员考试成绩 </a></li>
								</ul></li>
						</c:if>
						<c:if test="${flag eq 'trainee' }">
							<li class="nav-item"><a
								href="trainee/showTraineeEdit/${traineeLogin.id }"
								class="nav-link" target="Conframe"> <i
									class="icon icon-energy"></i> 个人信息
							</a></li>
							<li class="nav-item"><a class="nav-link"
								href="trainer/showTrainerEdit/${traineeLogin.trainerId }"
								target="Conframe"> <i class="icon icon-speedometer"></i>
									教练信息
							</a></li>
							<li class="nav-item"><a class="nav-link"
								href="trainee/showCar/${traineeLogin.trainerId }"
								target="Conframe"> <i class="icon icon-speedometer"></i>
									车辆信息
							</a></li>
							<li class="nav-item nav-dropdown"><a
								class="nav-link nav-dropdown-toggle"> <i
									class="icon icon-grid"></i> 考试信息<i class="fa fa-caret-left"></i>
							</a>
								<ul class="nav-dropdown-items">
									<li class="nav-item"><a href="exam/showExamPlan"
										target="Conframe" class="nav-link" style="margin-left: 30px">
											考试计划 </a> <a href="exam/showExamOrdered" target="Conframe"
										class="nav-link" style="margin-left: 30px"> 已预约考试情况 </a> <a
										href="exam/showExamResult" target="Conframe" class="nav-link"
										style="margin-left: 30px"> 考试成绩 </a></li>
								</ul></li>
							<%-- <li class="nav-item"><a class="nav-link"
								href="trainee/showFee/${flag }" target="Conframe"> <i
									class="icon icon-speedometer"></i> 所交费用信息
							</a></li> --%>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<div class="content-box">
		<iframe name="Conframe" id="Conframe"></iframe>
	</div>
</body>
</html>
