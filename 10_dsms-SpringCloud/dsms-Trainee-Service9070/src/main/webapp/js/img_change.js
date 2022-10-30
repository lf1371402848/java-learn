//获取对象
function Id(id){
	return document.getElementById(id);
}
//触发文件选择
function git(){
	Id("fileId").click();
}
//获取选择后图片的url
function getFileUrl(fileId) { 
	var url; 
	var file = Id(fileId).files[0];
	if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
      }else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
      }
	console.log(url);
	return url; 
}
//显示选择后的图片
function changeImg(fileId,imgId){
	Id(imgId).src = getFileUrl(fileId); 
}

