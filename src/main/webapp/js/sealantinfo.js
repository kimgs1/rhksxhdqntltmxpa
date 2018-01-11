
$(function(){
	init();
})


function init(){
	$('#Seq').val("");
	$('#ManagementNo').val("");
	$('#PenetrationNo').val("");
	$('#ConstructionState').val("");
	$('#SealQualityClass').val("");
	$('#SealMeterial').val("");
	$('#SealThickness').val("");
	$('#PressingBoardMeterial').val("");
	$('#PressingBoardThickness').val("");
//	$('#RepairQuantity').val("");
//	$('#Register').val("");
//	$('#Reviewer').val("");
//	$('#Checker').val("");
//	$('#SpecialNote').val("");
	$('#RegID').val("");
	getSealantinfoList();
	getBaseCodeInfo();
}

function getBaseCodeInfo(){
	getCodeAllInfo();
	tagBind("radio", "ConstructionState","시공상태",null,codeAllInfo.A03);
}
function getSealantinfoList(){
	$.ajax({
		url : 'sealantinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawSealantinfoGrid(result,dataList)
		},
		error: function(data){
		}
	});
}



function getSearchSealantinfoList(){
	$.ajax({
		url : 'sealantinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',

			Seq:$("Seq").val(),
			ManagementNo:$("ManagementNo").val(),
			PenetrationNo:$("PenetrationNo").val(),
//			ConstructionState:$("ConstructionState").val(),
			ConstructionState:getRadioValueByTagName('ConstructionState'),
			SealQualityClass:$("SealQualityClass").val(),
			SealMeterial:$("SealMeterial").val(),
			SealThickness:$("SealThickness").val(),
			PressingBoardMeterial:$("PressingBoardMeterial").val(),
			PressingBoardThickness:$("PressingBoardThickness").val(),
//			RepairQuantity:$("RepairQuantity").val(),
//			Register:$("Register").val(),
//			Reviewer:$("Reviewer").val(),
//			Checker:$("Checker").val(),
//			SpecialNote:$("SpecialNote").val(),
			RegID:$("RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawSealantinfoGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}

function drawSealantinfoGrid(result,dataList){
	if(dataList!= null){
		
		$('#sealantinfo_Grid_div').empty();
		$('#sealantinfo_Grid_div').append('<table id="sealantinfo_Grid_table"></table>');
		$('#sealantinfo_Grid_div').append('<div id="pager_list_1"></div>');
		
		var grid = $('#sealantinfo_Grid_table');
		
		grid.jqGrid({
			datatype : 'jsonstring',
			datastr : dataList,
			colModel: [
						{name:'Seq',hidden:true},
						{name:'ManagementNo',hidden:true},
						{name:'PenetrationNo',hidden:true},
						{name:'ConstructionState',hidden:true},
						{name:'SealQualityClass',hidden:true},
						{name:'SealMeterial',hidden:true},
						{name:'SealThickness',hidden:true},
						{name:'PressingBoardMeterial',hidden:true},
						{name:'PressingBoardThickness',hidden:true},
//						{name:'RepairQuantity',hidden:true},
//						{name:'Register',hidden:true},
//						{name:'Reviewer',hidden:true},
//						{name:'Checker',hidden:true},
//						{name:'SpecialNote',hidden:true},
						{name:'RegID',hidden:true},
			           {name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},
			           {name:'PenetrationNo',label:'관통부번호', align:'center', width:'10%'},
			           {name:'ConstructionState_name', label:'시공상태',align:'center', width:'10%',editable:true},
			           {name:'SealMeterial', label:'밀폐재재질', align:'center', width:'10%'},
			           {name:'SealThickness', label:'밀폐재두께', align:'center', width:'10%'},
			           {name:'SealQualityClass', label:'SEAL QUALITY CLASS', align:'center', width:'10%'},
			           {name:'PressingBoardMeterial', label:'댐판재질', align:'center', width:'10%'},
			           {name:'PressingBoardThickness', label:'댐판두께', align:'center', width:'10%'},
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
//				$('#ConstructionState').val(rowdata.ConstructionState);
				$('#SealQualityClass').val(rowdata.SealQualityClass);
				$('#SealMeterial').val(rowdata.SealMeterial);
				$('#SealThickness').val(rowdata.SealThickness);
				$('#PressingBoardMeterial').val(rowdata.PressingBoardMeterial);
				$('#PressingBoardThickness').val(rowdata.PressingBoardThickness);
				$('#RepairQuantity').val(rowdata.RepairQuantity);
				$('#Register').val(rowdata.Register);
				$('#Reviewer').val(rowdata.Reviewer);
				$('#Checker').val(rowdata.Checker);
				$('#SpecialNote').val(rowdata.SpecialNote);
				$('#RegID').val(rowdata.RegID);

//				document.getElementById("RegDateTime").innerHTML = rowdata.RegDateTime;
				tagBind("radio", "ConstructionState","시공상태",rowdata.ConstructionState,codeAllInfo.A03);
			},
		});				
	}
}

function SealantinfoSave(){
	$.ajax({
		url : 'sealantinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'save',
//			Seq:$("Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
//			ConstructionState:$("#ConstructionState").val(),
			ConstructionState:getRadioValueByTagName('ConstructionState'),
			SealQualityClass:$("#SealQualityClass").val(),
			SealMeterial:$("#SealMeterial").val(),
			SealThickness:$("#SealThickness").val(),
			PressingBoardMeterial:$("#PressingBoardMeterial").val(),
			PressingBoardThickness:$("#PressingBoardThickness").val(),
//			RepairQuantity:$("RepairQuantity").val(),
//			Register:$("Register").val(),
//			Reviewer:$("Reviewer").val(),
//			Checker:$("Checker").val(),
//			SpecialNote:$("SpecialNote").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
//			if(result.success == true){
//				$('#create_Sealantinfo_modal').modal('hide');
//			}
			getSealantinfoList();
		},
		error: function(data){
			
		}
	});
	
}


function deleteSealantinfo(Seq){
	$.ajax({
		url : 'sealantinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			Seq:Seq,
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
			getSealantinfoList();
		},
		error: function(data){
			
		}
	});
}