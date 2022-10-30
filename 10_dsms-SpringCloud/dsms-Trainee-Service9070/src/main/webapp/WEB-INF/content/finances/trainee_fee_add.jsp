<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>新增学员交费情况</title>
<link rel="stylesheet" href="css/styles.css">
<script src="js/check_formInput.js"></script>
<script type="text/javascript">
	   var traineeList= '<%=session.getAttribute("allTraineesJson")%>';
	</script>
<script src="js/select.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
	<div class="page-wrapper">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header bg-light">新增学员交费情况</div>
							<form action="finance/addTraineeFee" method="post"
								name="traineeFee_form">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">学员账号</label> <select
													class="form-control" name="itemId"
													onchange="selectTrainee()">
													<option>-------请选择学员账号------</option>
													<c:forEach items="${allTrainees}" var="trainee">
														<option value="${trainee.key.id }">${trainee.key.traineeNo }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="read-only" class="form-control-label">姓名</label>
												<input type="text" class="form-control" name="name" readonly>
											</div>
										</div>
										<div class="col-md-3">
                                            <div class="form-group">
                                                <label for="required-input" class="require">交费类型</label> <select
                                                    class="form-control" name="itemType">
                                                    <option>-------请选择交费类型------</option>
                                                    <option value="entryFee">学费</option>
                                                    <option value="resit">补考费</option>
                                                    <option value="else">其它</option>
                                                </select>
                                            </div>
                                        </div>
									</div>

									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
                                            <div class="form-group">
                                                <label for="normal-input" class="form-control-label">交费金额</label>
                                                <input type="text" class="form-control" name="itemFee" maxlength="10" oninput="value=value.replace(/[^\d]/g,'')">
                                            </div>
                                        </div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="required-input" class="require">交费时间</label> <input
													type="date" class="form-control" name="feeDate">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="normal-input" class="form-control-label">备注</label>
												<input type="text" class="form-control" name="comments">
											</div>
										</div>
									</div>
									<div class="row" style="margin-top: 40px">
										<div class="col-4"></div>
										<div class="col-2">
											<button type="button" class="btn btn-primary px-5"
												onclick="checkTraineeFeeForm();">保存</button>
										</div>
										<div style="margin-left: 100px">
											<a href="finance/showTraineeFee/${flag}"><button
													type="button" class="btn btn-primary px-5">返回</button></a>
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