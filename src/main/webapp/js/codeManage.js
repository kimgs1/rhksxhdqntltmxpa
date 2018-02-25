
var codeGroupUpdateData = [];
var codeInfoUpdateData = [];
var selectedGroupId = "";

$(function(){
	getCodeGroupList();
})


function getCodeGroupList(){

	$('#code_group_updatebtn').attr("disabled", true);
	$.ajax({
		url : 'codeGroup.do',
		type : 'get',
		dataType : 'json',
		data : {
			command:"getList"
		},
		success : function(data) {
			var dataList = data.result.DataList;
			$('#codeGroup_Grid_div').empty();
			$('#codeGroup_Grid_div').append('<table id="codeGroup_Grid_table"></table>');

			var grid = $('#codeGroup_Grid_table');
			grid.jqGrid({
				datatype : 'jsonstring',
				datastr : dataList,
				colModel: [
				           {name:'GroupID', label:'그룹코드', align:'center', width:'10%'},
				           {name:'GroupName',label:'그룹이름', align:'center', width:'10%',editable:true},
				           {name:'Remark', label:'비고',align:'center', width:'20%',editable:true},
				           {name:'RegID', label:'생성자', align:'center', width:'10%'},
				           {name:'RegDate', label:'생성일자', align:'center', width:'10%'},
				           {label : "Del", name: 'del', sorttype: 'string', align: 'center', width: '15%',
				        	   formatter:function (cellvalue, options, rowObject) {    
					        	   return '<input type="button" class="btn btn-default" style="border:1px solid #ccc;color:white;background-color:red;width:100%" onclick="deleteCodeGroup('+options.rowId+')" value="Delete"/>'; 
					           }
				           }
				],
				autowidth : true,
				shrinkToFit : true,
				scrollrows : true,
				gridview : true,
				height : 400,
				viewrecords: true,
				jsonReader : {
					repeatitems : false,
					root : function(obj) {return obj;},
					page : function(obj) {return 1;},
					total : function(obj) {return 1;},
					records : function(obj) {return obj.length;}
				},

				onSelectRow : function(id) {

					var rowdata = grid.jqGrid('getRowData', id);
					
					
					selectedGroupId = rowdata.GroupID;
					$("#code_info_div").attr('hidden',false);
					getCodeInfoList();
//					if (id != lastsel) { grid.jqGrid('restoreRow', lastsel); lastsel = id; }
					grid.jqGrid('editRow', id, {
						keys: true,
						url: 'clientArray',
						aftersavefunc : function(rowid) {
							var des = grid.jqGrid('getRowData', rowid);
							des = [];
							des = grid.jqGrid('getRowData', rowid);
							if(rowdata.GroupID != des.GroupID || rowdata.GroupName !=des.GroupName || rowdata.Remark != des.Remark){
								
//								$('#code_group_savebtn').attr("disabled", true);
								$('#code_group_updatebtn').removeAttr("disabled");
								
								
								codeGroupUpdateData.push(des);
								grid.jqGrid('setRowData', rowid, false, {'background' : '#CEF279'});
							}
						}
					}); // end edit row
				},
			});

		},
		
		
		error: function(data){

		}
	});
}


function updateCodeGroupData(){
	
	var ret = confirm('코드그룹정보에 대한 수정한 설정 값을 저장하시겠습니까?');
	if (ret) {
		for(var i =0;i<codeGroupUpdateData.length;i++){
			codeGroupUpdateData[i].del = "";
		}
		$.ajax({
			url : 'codeGroup.do',
			type : 'post',
			dataType : 'json',
			data : 'command=update&&data=' + JSON.stringify(codeGroupUpdateData),
			success : function(data) {
				getCodeGroupList();
				codeGroupUpdateData = [];
				alert("사용자가 수정한 값을 성공적으로 저장하였습니다.");
			},
			error : function() {
				alert("설정 저장 실패");
			}
		});
	}
}


function newCodeGroup(){
	$('#create_code_group_modal').css('z-index', 3000);
	$('#create_code_group_modal').modal();
}
function newCodeGroupSave(){
	$.ajax({
		url : 'codeGroup.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:"create",
			GroupID:$("#cgc_GroupID").val(),
			GroupName:$("#cgc_GroupName").val(),
			Remark:$("#cgc_Remark").val(),
			SortKey:$("#cgc_SortKey").val()
		},
		success : function(data) {
			getCodeGroupList();
			codeGroupUpdateData = [];
			alert("성공적으로 저장하였습니다.");
			$('#create_code_group_modal').modal('hide');
		},
		error : function() {
			alert("저장실패");
		}
	});
}


function deleteCodeGroup(rowId){
	$('#delete_code_group_modal').css('z-index', 3000);
	$('#delete_code_group_modal').modal();
	$('#delete_code_groupBtn').attr("onclick" , "deleteCodeGroupSave("+rowId+")");
}
function deleteCodeGroupSave(rowId){
	var groupId = $('#codeGroup_Grid_table').jqGrid('getRowData', rowId).GroupID;
	
	$.ajax({
		url : 'codeGroup.do',
		type : 'post',
		dataType : 'json',
		data : 'command=delete&&GroupID='+groupId,
		success : function(data) {
			if(data.result.success){
				getCodeGroupList();
				codeGroupUpdateData = [];
				$('#delete_code_group_modal').modal('hide');
			}
			alert(data.result.msg);
		},
		error : function() {
			alert("삭제실패");
		}
	});
}




function getCodeInfoList(){

	$('#code_info_updatebtn').attr("disabled", true);
	$.ajax({
		url : 'codeInfo.do',
		type : 'get',
		dataType : 'json',
		data : {
			command:"getList",
			GroupID:selectedGroupId
		},
		success : function(data) {
			var dataList = data.result.DataList;
			$('#codeInfo_Grid_div').empty();
			$('#codeInfo_Grid_div').append('<table id="codeInfo_Grid_table"></table>');

			var grid = $('#codeInfo_Grid_table');
			grid.jqGrid({
				datatype : 'jsonstring',
				datastr : dataList,
				colModel: [
				           {name:'GroupID', label:'그룹코드', align:'center', width:'10%',hidden:true},
				           {name:'CodeID', label:'코드ID', align:'center', width:'10%'},
				           {name:'CodeName',label:'코드명', align:'center', width:'10%',editable:true},
				           {name:'Remark', label:'비고',align:'center', width:'20%',editable:true},
				           {name:'RegID', label:'생성자', align:'center', width:'10%'},
				           {name:'RegDate', label:'생성일자', align:'center', width:'10%'},
				           {label : "Del", name: 'del', sorttype: 'string', align: 'center', width: '15%',
				        	   formatter:function (cellvalue, options, rowObject) {    
					        	   return "<input type=button' class='btn btn-default' style='border:1px solid #ccc;color:white;background-color:red;width:100%' onclick='deleteCodeInfo("+options.rowId+")' value='Delete'/>"; 
					           }
				           }
				],
				autowidth : true,
				shrinkToFit : true,
				scrollrows : true,
				gridview : true,
				height : 400,
				viewrecords: true,
				jsonReader : {
					repeatitems : false,
					root : function(obj) {return obj;},
					page : function(obj) {return 1;},
					total : function(obj) {return 1;},
					records : function(obj) {return obj.length;}
				},

				onSelectRow : function(id) {

					var rowdata = grid.jqGrid('getRowData', id);
//					if (id != lastsel) { grid.jqGrid('restoreRow', lastsel); lastsel = id; }
					grid.jqGrid('editRow', id, {
						keys: true,
						url: 'clientArray',
						aftersavefunc : function(rowid) {
							var des = grid.jqGrid('getRowData', rowid);
							des = [];
							des = grid.jqGrid('getRowData', rowid);
							if(rowdata.InfoID != des.InfoID || rowdata.InfoName !=des.InfoName || rowdata.Remark != des.Remark || rowdata.ExtraRate != des.ExtraRate ){
								
//								$('#code_info_savebtn').attr("disabled", true);
								$('#code_info_updatebtn').removeAttr("disabled");
								
								
								codeInfoUpdateData.push(des);
								grid.jqGrid('setRowData', rowid, false, {'background' : '#CEF279'});
							}
						}
					}); // end edit row
				},
			});

		},
		
		
		error: function(data){

		}
	});
}


function updateCodeInfoData(){
	var ret = confirm('코드그룹정보에 대한 수정한 설정 값을 저장하시겠습니까?');
	if (ret) {
		for(var i =0;i<codeInfoUpdateData.length;i++){
			codeInfoUpdateData[i].del = "";
		}
		$.ajax({
			url : 'codeInfo.do',
			type : 'post',
			dataType : 'json',
			data : 'command=update&&data=' + JSON.stringify(codeInfoUpdateData),
			success : function(data) {
				getCodeInfoList();
				codeInfoUpdateData = [];
				alert("사용자가 수정한 값을 성공적으로 저장하였습니다.");
			},
			error : function() {
				alert("설정 저장 실패");
			}
		});
	}
}


function newCodeInfo(){
	$('#create_code_info_modal').css('z-index', 3000);
	$('#create_code_info_modal').modal();
}
function newCodeInfoSave(){
	$.ajax({
		url : 'codeInfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:"create",
			GroupID:selectedGroupId,
			CodeID:$("#cic_CodeID").val(),
			CodeName:$("#cic_CodeName").val(),
			Remark:$("#cic_Remark").val(),
			ExtraRate:$("#cic_ExtraRate").val(),
			SortKey:$("#cic_SortKey").val()
		},
		success : function(data) {
			getCodeInfoList();
			codeInfoUpdateData = [];
			alert("성공적으로 저장하였습니다.");
			$('#create_code_info_modal').modal('hide');
		},
		error : function() {
			alert("저장실패");
		}
	});
}


function deleteCodeInfo(rowId){
	$('#delete_code_info_modal').css('z-index', 3000);
	$('#delete_code_info_modal').modal();
	$('#delete_code_infoBtn').attr("onclick" , "deleteCodeInfoSave("+rowId+")");
}
function deleteCodeInfoSave(rowId){
	var codeId = $('#codeInfo_Grid_table').jqGrid('getRowData', rowId).CodeID;
	
	$.ajax({
		url : 'codeInfo.do',
		type : 'post',
		dataType : 'json',
		data : 'command=delete&&CodeID='+codeId +"&&GroupID=" + selectedGroupId,
		success : function(data) {
			if(data.result.success){
				getCodeInfoList();
				codeInfoUpdateData = [];
				$('#delete_code_info_modal').modal('hide');
			}
			alert(data.result.msg);
		},
		error : function() {
			alert("삭제실패");
		}
	});
}

