function selectExamPlan() {
	//获取json数据
	var allExamplans = eval('(' + examPlanList + ')');
	//获取下拉框选中的值
	var planId = orderExam_form.examPlanId.value;
	//获取页面上的标签
	var examType = orderExam_form.examType;
	var examTime = orderExam_form.examTime;
	var carType = orderExam_form.carType;
	var place = orderExam_form.place;
	var address = orderExam_form.address;
	for (i = 0; i < allExamplans.length; i++) {
		if(allExamplans[i].id == planId){
			if(allExamplans[i].examTime!=null){
				var exExamTime=exchangeDate(allExamplans[i].examTime.time);
			}
			examType.value=allExamplans[i].examType;
			examTime.value=exExamTime;
			carType.value=allExamplans[i].carType;
			place.value=allExamplans[i].place;
			address.value=allExamplans[i].address;
		}
	}

	function exchangeDate(time){
		var date = new Date(time);
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		month = month<10?'0'+month:month;
		var day = date.getDate();
		day = day<10?("0"+day):day;
		var str = year+"-"+month+"-"+day;
		return str;
	}
}

function selectTrainer() {
	//获取json数据
	var allTrainers = eval('(' + trainerList + ')');
	//获取值
	var id = employeeFee_form.trainerNo.value;
	//获取页面上的标签
	var name = employeeFee_form.name;
	for (i = 0; i < allTrainers.length; i++) {
		if(allTrainers[i].id == id){
			name.value=allTrainers[i].name;
		}
	}
}

function selectTrainee() {
	//获取json数据
	var allTrainees = eval('(' + traineeList + ')');
	//获取值
	var itemId = traineeFee_form.itemId.value;
	//获取页面上的标签
	var name = traineeFee_form.name;
	for (i = 0; i < allTrainees.length; i++) {
		if(allTrainees[i].id == itemId){
			name.value=allTrainees[i].name;
		}
	}
}

function selectEmployee() {
	//获取json数据
	var allEmployees = eval('(' + employeeList + ')');
	//获取值
	var trainerNo = employeeFee_form.trainerNo.value;
	//获取页面上的标签
	var name = employeeFee_form.name;
	for (i = 0; i < allEmployees.length; i++) {
		if(allEmployees[i].trainerNo == trainerNo){
			name.value=allEmployees[i].name;
		}
	}
}