$(function(){
	  setInterval(function () {
	        // Create a newDate() object and extract the seconds of the current time on the visitor's
	        var seconds = new Date().getSeconds();
	        // Add a leading zero to seconds value
	        $("#sec").html((seconds < 10 ? "0" : "") + seconds);
	    }, 1000);

	    setInterval(function () {
	        // Create a newDate() object and extract the minutes of the current time on the visitor's
	        var minutes = new Date().getMinutes();
	        // Add a leading zero to the minutes value
	        $("#min").html((minutes < 10 ? "0" : "") + minutes);
	    }, 1000);

	    setInterval(function () {
	        // Create a newDate() object and extract the hours of the current time on the visitor's
	        var hours = new Date().getHours();
	        // Add a leading zero to the hours value
	        $("#hours").html((hours < 10 ? "0" : "") + hours);
	    }, 1000);
	    
		$.ajax({
			url : 'login.do',
			type : 'post',
			dataType : 'json',
			data : 'command=checkRem',
			success : function(data) {
				if(data.rid != ''){
					$('#txtUserId').val(data.rid);
					$('#chkRememberLogin').attr('checked',true);
					$('#remCheck').val("true");
				}
			}
		});
		
//		$('#login_modal').modal({
//			backdrop: 'static',
//			keyboard: false
//		});
		
		$('#chkRememberLogin').change(function() {
			
			if($('#chkRememberLogin').is(":checked")) $('#remCheck').val("true");
			else $('#remCheck').val("false");
		});
		
		$('#txtUserId,#txtUserPwd').click(function(){
			$(this).val("");
		});
		
		$('#txtUserPwd').focus();
});


function newMemberSaveCancelOnclick(){
	$('#create_NewMember_modal').modal('hide');
}

function newMemberOnClick(){
	$("#userId").val("");
	$("#password").val("");
	$("#password_precheck").val("");
	$("#userName").val("");
	$("#Phone").val("");
	$("#mobile").val("");
	$("#email").val("");
	$("#address").val("");
	$('#create_NewMember_modal').modal({
		backdrop: 'static',
		keyboard: false
	});
}


function newMemberSaveOnclick(){
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
			alert("회원가입이 완료되었습니다.");
		},
		error:function(request,status,error){
			alert("회원가입하는동안 오류가 생겼습니다.  관리자에게 문의하시길 바라겠습니다.");
		}
	});
}


