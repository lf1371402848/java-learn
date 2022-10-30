function checkTrainerNo(){
	trainerNo = trainer_form.trainerNo.value;
	a=new Object();
	a=document.getElementById("trainerNo");
	if (trainerNo == "" || trainerNo.length == 0) {
		a.innerText="请输入教练账号";
		a.style.visibility="visible"; 
		return false;
	} else if (trainerNo.length < 4 || trainerNo.length > 10) {
		a.innerText="教练账号长度只能为4到10位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTrainerName(){
	name = trainer_form.name.value;
	a=new Object();
	a=document.getElementById("name");
	if (name == "" || name.length == 0) {
		a.innerText="请输入教练名字";
		a.style.visibility="visible"; 
		return false;
	} else if (name.length < 2 || name.length > 5) {
		a.innerText="教练名字长度只能为2到5位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTrainerAge(){
	age = trainer_form.age.value;
	a=new Object();
	a=document.getElementById("age");
	if (age == "" || age.length == 0) {
		a.innerText="请输入教练年龄";
		a.style.visibility="visible"; 
		return false;
	} else if (age < 18 || age > 60) {
		a.innerText="教练年龄只能在18到60岁";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTrainerPhone(){
	phone = trainer_form.phone.value;
	a=new Object();
	a=document.getElementById("phone");
	if (phone == "" || phone.length == 0) {
		a.innerText="请输入教练电话";
		a.style.visibility="visible"; 
		return false;
	} else if (phone.length != 11) {
		a.innerText="电话只能为11位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTrainerIdNumber(){
	idNumber = trainer_form.idNumber.value;
	a=new Object();
	a=document.getElementById("idNumber");
	if (idNumber == "" || idNumber.length == 0) {
		a.innerText="请输入教练身份证";
		a.style.visibility="visible"; 
		return false;
	} else if (idNumber.length != 18) {
		a.innerText="身份证只能为18位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTrainerLicenseNo(){
	licenseNo = trainer_form.licenseNo.value;
	a=new Object();
	a=document.getElementById("licenseNo");
	if (licenseNo == "" || licenseNo.length == 0) {
		a.innerText="请输入驾照编号";
		a.style.visibility="visible"; 
		return false;
	} else if (licenseNo.length != 18) {
		a.innerText="驾照编号只能为18位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTrainerDrivingYears(){
	drivingYears = trainer_form.drivingYears.value;
	a=new Object();
	a=document.getElementById("drivingYears");
	if (drivingYears > 42) {
		a.innerText="驾龄只能小于42";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}

function checkTrainerForm(){
	if (checkTrainerNo()&&checkTrainerName()&&checkTrainerAge()&&checkTrainerPhone()&&checkTrainerIdNumber()) {
		trainer_form.submit();
	}
}

function checkTraineeNo(){
	traineeNo = trainee_form.traineeNo.value;
	a=new Object();
	a=document.getElementById("traineeNo");
	if (traineeNo == "" || traineeNo.length == 0) {
		a.innerText="请输入学员账号";
		a.style.visibility="visible"; 
		return false;
	} else if (traineeNo.length < 4 || traineeNo.length > 10) {
		a.innerText="学员账号长度只能为4到10位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTraineeName(){
	name = trainee_form.name.value;
	a=new Object();
	a=document.getElementById("name");
	if (name == "" || name.length == 0) {
		a.innerText="请输入学员名字";
		a.style.visibility="visible"; 
		return false;
	} else if (name.length < 2 || name.length > 5) {
		a.innerText="学员名字长度只能为2到5位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTraineeAge(){
	age = trainee_form.age.value;
	a=new Object();
	a=document.getElementById("age");
	if (age == "" || age.length == 0) {
		a.innerText="请输入学员年龄";
		a.style.visibility="visible"; 
		return false;
	} else if (age < 18 || age > 60) {
		a.innerText="学员年龄只能在18到60岁";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTraineeHeight(){
	height = trainee_form.height.value;
	a=new Object();
	a=document.getElementById("height");
	if (height == "" || height.length == 0) {
		a.innerText="请输入学员身高";
		a.style.visibility="visible"; 
		return false;
	} else if (height < 150 || height > 200) {
		a.innerText="学员身高只能在150到200cm";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTraineePhone(){
	phone = trainee_form.phone.value;
	a=new Object();
	a=document.getElementById("phone");
	if (phone == "" || phone.length == 0) {
		a.innerText="请输入学员电话";
		a.style.visibility="visible"; 
		return false;
	} else if (phone.length != 11) {
		a.innerText="电话只能为11位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTraineeIdNumber(){
	idNumber = trainee_form.idNumber.value;
	a=new Object();
	a=document.getElementById("idNumber");
	if (idNumber == "" || idNumber.length == 0) {
		a.innerText="请输入学员身份证";
		a.style.visibility="visible"; 
		return false;
	} else if (idNumber.length != 18) {
		a.innerText="身份证只能为18位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkTraineeForm(){
	if (checkTraineeNo()&&checkTraineeName()&&checkTraineeAge()&&checkTraineeHeight()&&checkTraineePhone()&&checkTraineeIdNumber()) {
		trainee_form.submit();
	}
}

function checkCarNo(){
	carNo = car_form.carNo.value;
	a=new Object();
	a=document.getElementById("carNo");
	if (carNo == "" || carNo.length == 0) {
		a.innerText="请输入车牌号";
		a.style.visibility="visible"; 
		return false;
	} else if (carNo.length != 8) {
		a.innerText="车牌号只能为8位";
		a.style.visibility="visible"; 
		return false;
	}else if (carNo.length == 8) {
		var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}·[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
		if(!express.test(carNo)){
			a.innerText="车牌号格式为(赣C·00000)";
			a.style.visibility="visible"; 
			return false;
		}else {
			a.style.visibility="hidden"; 
			return true;
		}
	}
}
function checkCarBrand(){
	carBrand = car_form.carBrand.value;
	a=new Object();
	a=document.getElementById("carBrand");
	if (carBrand == "" || carBrand.length == 0) {
		a.innerText="请输入车品牌";
		a.style.visibility="visible"; 
		return false;
	} else if (carBrand.length > 10) {
		a.innerText="车品牌最长位10位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkCarPrice(){
	price = car_form.price.value;
	a=new Object();
	a=document.getElementById("price");
	if (price == "" || price.length == 0) {
		a.innerText="请输入车价格";
		a.style.visibility="visible"; 
		return false;
	} else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkEngineNo(){
	engineNo = car_form.engineNo.value;
	a=new Object();
	a=document.getElementById("engineNo");
	if (engineNo == "" || engineNo.length == 0) {
		a.innerText="请输入发动机编号";
		a.style.visibility="visible"; 
		return false;
	} else if (engineNo.length != 6) {
		a.innerText="发动机编号只能为6位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkCarForm(){
	if (checkCarNo()&&checkCarBrand()&&checkCarPrice()&&checkEngineNo()) {
		car_form.submit();
	}
}

function checkPlanPlace(){
	place = examPLan_form.place.value;
	a=new Object();
	a=document.getElementById("place");
	if (place == "" || place.length == 0) {
		a.innerText="考试场地不能为空";
		a.style.visibility="visible"; 
		return false;
	} else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkPlanAdress(){
	address = examPLan_form.address.value;
	a=new Object();
	a=document.getElementById("address");
	if (address == "" || address.length == 0) {
		a.innerText="详细地址不能为空";
		a.style.visibility="visible"; 
		return false;
	} else {
		a.style.visibility="hidden"; 
		return true;
	}
}

function checkPlanPeople(){
	people = examPLan_form.people.value;
	a=new Object();
	a=document.getElementById("people");
	if (people == "" || people.length == 0) {
		a.innerText="人数不能为空";
		a.style.visibility="visible"; 
		return false;
	} else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkExamPlanForm(){
	if (checkPlanPlace()&&checkPlanAdress()&&checkPlanPeople()) {
		examPLan_form.submit();
	}
}

function checkOrderExamForm() {
	applicationType = orderExam_form.applicationType.value;
	carType = orderExam_form.carType.value;
	if(applicationType == carType){
		orderExam_form.submit();
	}else {
		alert("考试车型与申请车型不一致");
	}
}
function checkFeeType() {
	if (traineeFee_form.itemType.value == "") {
		alert("请输入费用类型"); 
		return false;
	}
	return true;
}
function checkFeeDate() {
	if (traineeFee_form.feeDate.value == "") {
		alert("请输入费用时间"); 
		return false;
	}
	return true;
}
function checkTraineeFeeForm() {
	if (checkFeeType()&&checkFeeDate()) {
		traineeFee_form.submit();
	}
}

function checkFeeSalary() {
	if (employeeFee_form.salary.value == "") {
		alert("请输入员工薪水"); 
		return false;
	}
	return true;
}
function checkEmployeeFeeForm() {
	if (checkFeeSalary()) {
		employeeFee_form.submit();
	}
}

function checkFeeCarNo() {
	if (carFee_form.itemId.value == "") {
		alert("请输入车辆编号"); 
		return false;
	}
	return true;
}
function checkCarFeeForm() {
	if (checkFeeCarNo()) {
		carFee_form.submit();
	}
}

function checkOtherItemType() {
	if (otherFee_form.itemType.value == "") {
		alert("请输入费用名称"); 
		return false;
	}
	return true;
}
function checkOtherItemFee() {
	if (otherFee_form.itemFee.value == "") {
		alert("请输入费用金额"); 
		return false;
	}
	return true;
}
function checkOtherFeeForm() {
	if (checkOtherItemType()&&checkOtherItemFee()) {
		otherFee_form.submit();
	}
}
