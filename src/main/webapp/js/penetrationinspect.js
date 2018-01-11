
$(function(){
	init();
})

function init(){
	$('#Seq').val("");
	$('#ManagementNo').val("");
	$('#PenetrationNo').val("");
	$('#InspectDate').val("");
	$('#InspectSeq').val("");
	$('#ImproveDate').val("");
	$('#InspectionInterval').val("");
	$('#SealantConditionState').val("");
	$('#JudgementReason').val("");
	$('#Judgment').val("");
	$('#ImproveNote').val("");
	$('#RegID').val("");
	$('#RegDate').val("");
	$('#UpdateID').val("");
	$('#UpdateDate').val("");
	getPenetrationinspectList();
	getBaseCodeInfo();
}


function getBaseCodeInfo(){
	getCodeAllInfo();
	tagBind("radio", "Judgment","판정",null,codeAllInfo.A05);
}


function getPenetrationinspectList(){
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationinspectGrid(result,dataList);
		},
		error: function(data){
			
		}
	});
}



function getSearchPenetrationinspectList(){
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
//			Seq:$("#Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
			InspectDate:$("#InspectDate").val(),
			InspectSeq:$("#InspectSeq").val(),
			ImproveDate:$("#ImproveDate").val(),
			InspectionInterval:$("#InspectionInterval").val(),
			SealantConditionState:$("#SealantConditionState").val(),
			JudgementReason:$("#JudgementReason").val(),
//			Judgment:$("#Judgment").val(),
			Judgment:getRadioValueByTagName('Judgment'),
			ImproveNote:$("#ImproveNote").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationinspectGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}

 function drawPenetrationinspectGrid(result,dataList){
	 if(dataList!= null){
			
			$('#penetrationinspect_Grid_div').empty();
			$('#penetrationinspect_Grid_div').append('<table id="penetrationinspect_Grid_table"></table>');
			$('#penetrationinspect_Grid_div').append('<div id="pager_list_1"></div>');
			
			var grid = $('#penetrationinspect_Grid_table');
			
			grid.jqGrid({
				datatype : 'jsonstring',
				datastr : dataList,
				colModel: [
							{name:'Seq',hidden:true},
							{name:'ManagementNo',hidden:true},
							{name:'PenetrationNo',hidden:true},
							{name:'InspectDate',hidden:true},
							{name:'InspectSeq',hidden:true},
							{name:'ImproveDate',hidden:true},
							{name:'InspectionInterval',hidden:true},
							{name:'SealantConditionState',hidden:true},
							{name:'JudgementReason',hidden:true},
							{name:'Judgment',hidden:true},
							{name:'ImproveNote',hidden:true},
							{name:'RegID',hidden:true},
				           {name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},
				           {name:'PenetrationNo',label:'관통부번호', align:'center', width:'10%'},
				           {name:'InspectionInterval_InspectSeq',label:'점검주기/차수', align:'center', width:'10%'},
				           {name:'Judgment_name',label:'판정', align:'center', width:'10%'},
				           {name:'JudgementReason',label:'판단사유', align:'center', width:'10%'},
				           {name:'SealantConditionState_name',label:'밀폐재시공상태', align:'center', width:'10%'},
				           {name:'InspectDate',label:'점검일', align:'center', width:'10%'},
				           {name:'ImproveDate',label:'개선일', align:'center', width:'10%'},
				           {name:'RegID', label:'작업자ID', align:'center', width:'10%'},
				           {name:'RegDateTime', label:'생성일', align:'center', width:'10%'},
				           
				],			
				pager: "#pager_list_1", 
				page : 1,
				rowNum: 100,                            //在grid上显示记录条数，这个参数是要被传递到后台
			    rowList: [100, 200, 300],              //一个下拉选择框，用来改变显示记录数，当选择时会覆盖rowNum参数传递到后台
				rownumbers: true,  
				cellEdit : false,  
				loadonce:true,
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
					$('#Seq').val(rowdata.Seq);
					$('#ManagementNo').val(rowdata.ManagementNo);
					$('#PenetrationNo').val(rowdata.PenetrationNo);
					$('#InspectDate').val(rowdata.InspectDate);
					$('#InspectSeq').val(rowdata.InspectSeq);
					$('#ImproveDate').val(rowdata.ImproveDate);
					$('#InspectionInterval').val(rowdata.InspectionInterval);
					$('#SealantConditionState').val(rowdata.SealantConditionState);
					$('#JudgementReason').val(rowdata.JudgementReason);
					$('#Judgment').val(rowdata.Judgment);
					$('#ImproveNote').val(rowdata.ImproveNote);
					$('#RegID').val(rowdata.RegID);
//					document.getElementById("RegDateTime").innerHTML = rowdata.RegDateTime;

					tagBind("radio", "Judgment","판정",rowdata.Judgment,codeAllInfo.A05);				},
			});				
		}
}

function PenetrationinspectSave(){
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'save',
			Seq:$("#Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
			InspectDate:$("#InspectDate").val(),
			InspectSeq:$("#InspectSeq").val(),
			ImproveDate:$("#ImproveDate").val(),
			InspectionInterval:$("#InspectionInterval").val(),
			SealantConditionState:$("#SealantConditionState").val(),
			JudgementReason:$("#JudgementReason").val(),
//			Judgment:$("#Judgment").val(),
			Judgment:getRadioValueByTagName('Judgment'),
			ImproveNote:$("#ImproveNote").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
//			if(result.success == true){
//				$('#create_Penetrationbaseinfo_modal').modal('hide');
//			}
			getPenetrationinspectList();
		},
		error: function(data){
			
		}
	});
}




function deletePenetrationinspect(Seq){
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			Seq:Seq,
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
			getPenetrationinspectList();
		},
		error: function(data){
			
		}
	});
}
