
function newMemberSaveOnclick(){
	alert("wait");
	$.ajax({
		type :'post',
		url : "login",
		data : {
			command:'newMemberUpload',
			userId:$("#userId").val(),
			userName:$("#userName").val(),
			passowrd:$("#password").val(),
			email:$("#email").val(),
			phone:$("#address").val(),
			mobile:$("#mobile").val(),
			address:$("#address").val(),
		},
		dataType : 'json',
		success : function(data) {

		},
		error:function(request,status,error){

		}
	});
}