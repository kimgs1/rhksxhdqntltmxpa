var codeGroupUpdateData = [];
var codeInfoUpdateData = [];
var selectedGroupId = "";

$(function() {
	getUserList();
})

function getUserList() {

	$
			.ajax({
				url : 'usermanage.do',
				type : 'get',
				dataType : 'json',
				data : {
					command : "getList"
				},
				success : function(data) {
					var dataList = data.result.DataList;
					$('#usermanage_Grid_div').empty();
					$('#usermanage_Grid_div').append(
							'<table id="usermanage_Grid_table"></table>');

					var grid = $('#usermanage_Grid_table');
					grid
							.jqGrid({
								datatype : 'jsonstring',
								datastr : dataList,
								colModel : [
										{
											name : 'userid',
											label : '사용자아이디',
											align : 'center',
											width : '10%'
										},
										{
											name : 'username',
											label : '사용자명',
											align : 'center',
											width : '10%'
										},
										{
											name : 'Phone',
											label : '전화번호',
											align : 'center',
											width : '10%'
										},
										{
											name : 'Mobile',
											label : '핸드폰',
											align : 'center',
											width : '10%'
										},
										{
											name : 'Email',
											label : '이메일',
											align : 'center',
											width : '10%'
										},
										{
											name : 'IP',
											label : '접속허용IP주소',
											align : 'center',
											width : '10%'
										},
										{
											label : "Edit",
											name : 'Edit',
											sorttype : 'string',
											align : 'center',
											width : '8%',
											formatter : function(cellvalue,
													options, rowObject) {
												return '<input type="button" class="btn btn-default" style="border:1px solid #ccc;color:white;background: linear-gradient( to bottom, white, #c1d4f1 );color: #2e4481;width:100%" onclick="editUserinfo('
														+ options.rowId
														+ ')" value="Edit"/>';
											}
										},
										{
											label : "Del",
											name : 'del',
											sorttype : 'string',
											align : 'center',
											width : '8%',
											formatter : function(cellvalue,
													options, rowObject) {
												if (rowObject.userid == 'admin') {
													return '<input type="button" class="btn btn-default" style="border:1px solid #ccc;color:white;background-color:gray;width:100%"  value="Delete" disable/>';
												} else {
													return '<input type="button" class="btn btn-default" style="border:1px solid #ccc;color:white;background-color:red;width:100%" onclick="deleteUserinfo('
															+ options.rowId
															+ ')" value="Delete"/>';
												}
											}
										} ],
								autowidth : true,
								shrinkToFit : true,
								scrollrows : true,
								gridview : true,
								height : 800,
								viewrecords : true,
								jsonReader : {
									repeatitems : false,
									root : function(obj) {
										return obj;
									},
									page : function(obj) {
										return 1;
									},
									total : function(obj) {
										return 1;
									},
									records : function(obj) {
										return obj.length;
									}
								},
								onSelectRow : function(id) {
								},
							});

				},
				error : function(data) {

				}
			});
}

function deleteUserinfo(rowId) {
	$('#delete_userinfo_modal').css('z-index', 4000);
	$('#delete_userinfo_modal').modal();
	$('#delete_userinfo_Btn').attr("onclick",
			"deleteUserinfoSave(" + rowId + ")");
}

function deleteUserinfoSave(rowId) {
	var userId = $('#usermanage_Grid_table').jqGrid('getRowData', rowId).userid;

	$.ajax({
		url : 'usermanage.do',
		type : 'post',
		dataType : 'json',
		data : 'command=delete&&UserID=' + userId,
		success : function(data) {
			if (data.result.success) {
				getUserList();
				$('#delete_userinfo_modal').modal('hide');
			}
			alert(data.result.msg);
		},
		error : function() {
			alert("삭제실패");
		}
	});
}

function editUserinfo(rowId) {
	var userid = $('#usermanage_Grid_table').jqGrid('getRowData', rowId).userid;
	$.ajax({
		url : 'usermanage.do',
		type : 'post',
		dataType : 'json',
		data : 'command=getcontent&&UserID=' + userid,
		success : function(data) {
			$("#e_userId").val(data.result.DataList.UserID);
			$("#e_password_precheck").val(data.result.DataList.Password);
			$("#e_password").val(data.result.DataList.Password);
			$("#e_userName").val(data.result.DataList.UserName);
			$("#e_phone").val(data.result.DataList.Phone);
			$("#e_mobile").val(data.result.DataList.Mobile);
			$("#e_email").val(data.result.DataList.Email);
			$("#e_ip").val(data.result.DataList.IP);
			$('#edit_NewMember_modal').modal({
				backdrop : 'static',
				keyboard : false
			});
		},
		error : function() {
		}
	});

}
function editMemberSaveOnclick() {
	if($("#e_password_precheck").val() != $("#e_password").val()){
		alert("입력하신 비밀번호가 동일하지 않습니다.");
		return;
	}
	$.ajax({
		type : 'post',
		url : "login",
		data : {
			command : 'editMemberUpload',
			userId : $("#e_userId").val(),
			userName : $("#e_userName").val(),
			password : $("#e_password").val(),
			email : $("#e_email").val(),
			phone : $("#e_phone").val(),
			mobile : $("#e_mobile").val(),
			ip : $("#e_ip").val(),
		},
		dataType : 'json',
		success : function(data) {
			$('#edit_NewMember_modal').modal('hide');
			getUserList();
		},
		error : function(request, status, error) {
			alert("회원정보를 수정하는 동안 오류가 생겼습니다.  관리자에게 문의 바랍니다.");
		}
	});
}

function editMemberSaveCancelOnclick() {
	$("#userId").val();
	$('#edit_NewMember_modal').modal('hide');
}

function newMemberOnClick(editflag) {
	$('#create_NewMember_modal').modal({
		backdrop : 'static',
		keyboard : false
	});
}

function newMemberSaveOnclick() {
	if($("#password_precheck").val() != $("#password").val()){
		alert("입력하신 비밀번호가 동일하지 않습니다.");
		return;
	}
	$.ajax({
		type : 'post',
		url : "login",
		data : {
			command : 'newMemberUpload',
			userId : $("#userId").val(),
			userName : $("#userName").val(),
			password : $("#password").val(),
			email : $("#email").val(),
			phone : $("#phone").val(),
			mobile : $("#mobile").val(),
			ip : $("#ip").val(),
		},
		dataType : 'json',
		success : function(data) {
			$('#create_NewMember_modal').modal('hide');
			getUserList();
		},
		error : function(request, status, error) {
			alert("회원가입하는동안 오류가 생겼습니다.  관리자에게 문의 바랍니다.");
		}
	});
}

function newMemberSaveCancelOnclick() {
	$("#userId").val();
	$('#create_NewMember_modal').modal('hide');
}
