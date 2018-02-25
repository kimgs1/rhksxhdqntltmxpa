
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
	
//	tagBind("checkBoxMulti", "RequirePerformance","요구성능",null,codeAllInfo.A06);
	tagBind("selectBox_All", "EvaluationResult","평가결과",null,codeAllInfo.A05);
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
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
			EvaluationResult:$("#EvaluationResult option:selected").val(),
			FIRE_VALUE_RANGE:$("#FIRE_VALUE_RANGE").val(),
			PRESSURE_VALUE_RANGE:$("#PRESSURE_VALUE_RANGE").val(),
			FLOOD_VALUE_RANGE:$("#FLOOD_VALUE_RANGE").val(),
			RADIATION_VALUE_RANGE:$("#RADIATION_VALUE_RANGE").val(),
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
				           {name:'ManagementNo', hidden:true},
				           {name:'PenetrationNo',label:'관통부번호', align:'center', width:'30%'},
//				           {name:'ManagementNo', label:'관리번호', align:'center', width:'30%'},
				           {name:'VENTILATION_VALUE', label:'적용', align:'center', width:'10%'},
				           {name:'VENTILATION_VALUE_RANGE',label:'허용치', align:'center', width:'10%'},
				           {name:'VENTILATION_VAL_NO',label:'성능인증번호', align:'center', width:'30%'},
				           {name:'VENTILATION_JUDGMENT',label:'판정', align:'center', width:'10%'},
				           {name:'VENTILATION_REASON',label:'사유', align:'center', width:'10%'},
				           {name:'FIRE_VALUE', label:'적용', align:'center', width:'10%'},
				           {name:'FIRE_VALUE_RANGE',label:'허용치', align:'center', width:'10%'},
				           {name:'FIRE_VAL_NO',label:'성능인증번호', align:'center', width:'30%'},
				           {name:'FIRE_JUDGMENT',label:'판정', align:'center', width:'10%'},
				           {name:'FIRE_REASON',label:'사유', align:'center', width:'10%'},
				           {name:'RADIATION_VALUE', label:'적용', align:'center', width:'10%'},
				           {name:'RADIATION_VALUE_RANGE',label:'허용치', align:'center', width:'10%'},
				           {name:'RADIATION_VAL_NO',label:'성능인증번호', align:'center', width:'30%'},
				           {name:'RADIATION_JUDGMENT',label:'판정', align:'center', width:'10%'},
				           {name:'RADIATION_REASON',label:'사유', align:'center', width:'10%'},
				           {name:'FLOOD_VALUE', label:'적용', align:'center', width:'10%'},
				           {name:'FLOOD_VALUE_RANGE',label:'허용치', align:'center', width:'10%'},
				           {name:'FLOOD_VAL_NO',label:'성능인증번호', align:'center', width:'30%'},
				           {name:'FLOOD_JUDGMENT',label:'판정', align:'center', width:'10%'},
				           {name:'FLOOD_REASON',label:'사유', align:'center', width:'10%'},
				           {name:'PRESSURE_VALUE', label:'적용', align:'center', width:'10%'},
				           {name:'PRESSURE_VALUE_RANGE',label:'허용치', align:'center', width:'10%'},
				           {name:'PRESSURE_VAL_NO',label:'성능인증번호', align:'center', width:'30%'},
				           {name:'PRESSURE_JUDGMENT',label:'판정', align:'center', width:'10%'},
				           {name:'PRESSURE_REASON',label:'사유', align:'center', width:'30%'},
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
			
			grid.jqGrid('setGroupHeaders', {
			    useColSpanStyle: true,
			    groupHeaders:[
					{startColumnName:'VENTILATION_VALUE', numberOfColumns:5, titleText: '<div align="center"><p>환기</p></div>'},
					{startColumnName:'FIRE_VALUE', numberOfColumns:5, titleText: '<div align="center"><p>내화</p></div>'},
					{startColumnName:'RADIATION_VALUE', numberOfColumns:5, titleText: '<div align="center"><p>방사선 차페</p></div>'},
					{startColumnName:'FLOOD_VALUE', numberOfColumns:5, titleText: '<div align="center"><p>수밀</p></div>'},
					{startColumnName:'PRESSURE_VALUE', numberOfColumns:4, titleText: '<div align="center"><p>내압</p></div>'},
			    ] 
			})


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