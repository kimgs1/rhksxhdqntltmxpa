
$(function(){
	init();
})

function init(){
	$('#ManagementNo').val("");
	$('#PenetrationNo').val("");
	$('#EvalueSeq').val("");
	$('#RequirePerformance').val("");
	$('#EvaluationResult').val("");
	$('#FireResistanceRating').val("");
	$('#PSI').val("");
	$('#WaterSeal').val("");
	$('#RadiationShield').val("");
	$('#RegID').val("");
	$('#RegDate').val("");
	$('#UpdateID').val("");
	$('#UpdateDate').val("");
	getPerformanceEvaluationList();
	getBaseCodeInfo();
}


function getBaseCodeInfo(){
	getCodeAllInfo();
	tagBind("radio", "RequirePerformance","요구성능",null,codeAllInfo.A06);
	tagBind("radio", "EvaluationResult","평가결과",null,codeAllInfo.A05);
}


function getPerformanceEvaluationList(){
	$.ajax({
		url : 'performanceEvaluation.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPerformanceEvaluationGrid(result,dataList);
		},
		error: function(data){
			
		}
	});
}



function getSearchPerformanceEvaluationList(){
	$.ajax({
		url : 'performanceEvaluation.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
			Seq:$("#Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
//			RequirePerformance:$("#RequirePerformance").val(),
			RequirePerformance:getRadioValueByTagName('RequirePerformance'),
//			EvaluationResult:$("#EvaluationResult").val(),
			EvaluationResult:getRadioValueByTagName('EvaluationResult'),
			FireResistanceRating:$("#FireResistanceRating").val(),
			PSI:$("#PSI").val(),
			WaterSeal:$("#WaterSeal").val(),
			RadiationShield:$("#RadiationShield").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPerformanceEvaluationGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}

 function drawPerformanceEvaluationGrid(result,dataList){
	 if(dataList!= null){
			
			$('#performanceEvaluation_Grid_div').empty();
			$('#performanceEvaluation_Grid_div').append('<table id="performanceEvaluation_Grid_table"></table>');
			$('#performanceEvaluation_Grid_div').append('<div id="pager_list_1"></div>');
			
			var grid = $('#performanceEvaluation_Grid_table');
			
			grid.jqGrid({
				datatype : 'jsonstring',
				datastr : dataList,
				colModel: [
							{name:'Seq',hidden:true},
							{name:'ManagementNo',hidden:true},
							{name:'PenetrationNo',hidden:true},
							{name:'RequirePerformance',hidden:true},
							{name:'EvaluationResult',hidden:true},
							{name:'FireResistanceRating',hidden:true},
							{name:'PSI',hidden:true},
							{name:'WaterSeal',hidden:true},
							{name:'RadiationShield',hidden:true},
							{name:'RegID',hidden:true},
							{name:'RegDate',hidden:true},
							{name:'UpdateID',hidden:true},
							{name:'UpdateDate',hidden:true},
				           {name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},
				           {name:'PenetrationNo',label:'관통부번호', align:'center', width:'10%'},
				           {name:'FireResistanceRating',label:'내화등급', align:'center', width:'10%'},
				           {name:'RadiationShield',label:'방사선차폐', align:'center', width:'10%'},
				           {name:'WaterSeal',label:'수밀', align:'center', width:'10%'},
				           {name:'PSI',label:'내압', align:'center', width:'10%'},
				           {name:'EvaluationResult_name',label:'평가결과', align:'center', width:'10%'},
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
					$('#RequirePerformance').val(rowdata.RequirePerformance);
					$('#EvaluationResult').val(rowdata.EvaluationResult);
					$('#FireResistanceRating').val(rowdata.FireResistanceRating);
					$('#PSI').val(rowdata.PSI);
					$('#WaterSeal').val(rowdata.WaterSeal);
					$('#RadiationShield').val(rowdata.RadiationShield);
					$('#RegID').val(rowdata.RegID);
					$('#RegDate').val(rowdata.RegDate);
					$('#UpdateID').val(rowdata.UpdateID);
					$('#UpdateDate').val(rowdata.UpdateDate);
//					document.getElementById("RegDateTime").innerHTML = rowdata.RegDateTime;

					tagBind("radio", "RequirePerformance","요구성능",rowdata.RequirePerformance,codeAllInfo.A06);
					tagBind("radio", "EvaluationResult","평가결과",rowdata.EvaluationResult,codeAllInfo.A05);
				},
			});				
		}
}

function PerformanceEvaluationSave(){
	$.ajax({
		url : 'performanceEvaluation.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'save',
			Seq:$("#Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
//			RequirePerformance:$("#RequirePerformance").val(),
			RequirePerformance:getRadioValueByTagName('RequirePerformance'),
//			EvaluationResult:$("#EvaluationResult").val(),
			EvaluationResult:getRadioValueByTagName('EvaluationResult'),
			FireResistanceRating:$("#FireResistanceRating").val(),
			PSI:$("#PSI").val(),
			WaterSeal:$("#WaterSeal").val(),
			RadiationShield:$("#RadiationShield").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
//			if(result.success == true){
//				$('#create_Penetrationbaseinfo_modal').modal('hide');
//			}
			getPerformanceEvaluationList();
		},
		error: function(data){
			
		}
	});
}




function deletePerformanceEvaluation(Seq){
	$.ajax({
		url : 'performanceEvaluation.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			Seq:Seq,
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
			getPerformanceEvaluationList();
		},
		error: function(data){
			
		}
	});
}