
$(function(){
	init();
})


function init(){
	$('#Seq').val("");
	$('#ManagementNo').val("");
	$('#PenetrationNo ').val("");
	$('#ManagementAreaYN').val("");
	$('#Elevation').val("");
	$('#FirePreventionAreaNo').val("");
	$('#InspectionRoomNo').val("");
	$('#BackRoomNo').val("");
	$('#PenetrationForm').val("");
	$('#Wall_FloorNo').val("");
	$('#FirewallYN').val("");
	$('#WallMeterial').val("");
	$('#WallThickness').val("");
	$('#FrontPicNo').val("");
	$('#BackPicNo').val("");
	$('#ReferenceFloorPlanNo').val("");
	$('#LocationFloorPlanNo').val("");
	$('#SealDetailDWG').val("");
	$('#EL').val("");
	$('#Diameter').val("");
	$('#Height').val("");
	$('#Length').val("");
	$('#PenetrationType').val("");
	$('#MaximumFreeArea').val("");
	$('#MaximumFreeDistance').val("");
	$('#Register').val("");
	$('#Reviewer').val("");
	$('#Checker').val("");
	$('#SpecialNote').val("");
	$('#RegID').val("");
	getPenetrationbaseinfoList();
	getBaseCodeInfo();
}

function getBaseCodeInfo(){
	getCodeAllInfo();
	tagBind("selectBox_All", "FirewallYN","방화벽여부",null,codeAllInfo.A09);
	tagBind("selectBox_All", "PenetrationForm","관통부형태",null,codeAllInfo.A02);
	tagBind("selectBox_All", "WallMeterial","벽재질",null,codeAllInfo.A04);
	tagBind("selectBox_All", "EquipNo","호기",null,codeAllInfo.A01);
	tagBind("selectBox_All", "LocNo","건물",null,codeAllInfo.A11);
}
function getPenetrationbaseinfoList(){
	$.ajax({
		url : 'penetrationbaseinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationbaseinfoGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}



function getSearchPenetrationbaseinfoList(){
	if($("#ELEVATION_num_pit").val() != "" || $("#ELEVATION_num_inc").val() != "" ){
		if(isNaN(Number($("#ELEVATION_num_pit").val())) || isNaN($("#ELEVATION_num_inc").val()) || $("#ELEVATION_num_pit").val() == "" || $("#ELEVATION_num_inc").val() == ""  ){
			alert("ELEVATION은 빈값이나 두개자리에 모두 수자를 입력하여야 합니다.");
			return;
		}
	}
	$.ajax({
		url : 'penetrationbaseinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
			EquipNo:$("#EquipNo option:selected").val(),
			LocNo :$("#LocNo option:selected").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo :$("#PenetrationNo").val(),
			ManagementAreaYN:$("#ManagementAreaYN").val(),
//			Elevation:$("#Elevation").val(),
			ELEVATION_cal_flag :$("#ELEVATION_cal_flag option:selected").val(),
			ELEVATION_num_pit :$("#ELEVATION_num_pit").val(),
			ELEVATION_num_inc :$("#ELEVATION_num_inc").val(),
			FirePreventionAreaNo:$("#FirePreventionAreaNo").val(),
			InspectionRoomNo:$("#InspectionRoomNo").val(),
			BackRoomNo:$("#BackRoomNo").val(),
//			PenetrationForm:$("#PenetrationForm").val(),
			PenetrationForm:$("#PenetrationForm option:selected").val(),
			Wall_FloorNo:$("#Wall_FloorNo").val(),
//			FirewallYN:$("#FirewallYN").val(),
			FirewallYN:$("#FirewallYN option:selected").val(),
//			WallMeterial:$("#WallMeterial").val(),
			WallMeterial:$("#WallMeterial option:selected").val(),
			WallThickness:$("#WallThickness").val(),
			FrontPicNo:$("#FrontPicNo").val(),
			BackPicNo:$("#BackPicNo").val(),
			ReferenceFloorPlanNo:$("#ReferenceFloorPlanNo").val(),
			LocationFloorPlanNo:$("#LocationFloorPlanNo").val(),
			SealDetailDWG:$("#SealDetailDWG").val(),
			EL:$("#EL").val(),
			Diameter:$("#Diameter").val(),
			Height:$("#Height").val(),
			Length:$("#Length").val(),
			PenetrationType:$("#PenetrationType").val(),
			MaximumFreeArea:$("#MaximumFreeArea").val(),
			MaximumFreeDistance:$("#MaximumFreeDistance").val(),
			Register:$("#Register").val(),
			Reviewer:$("#Reviewer").val(),
			Checker:$("#Checker").val(),
			SpecialNote:$("#SpecialNote").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationbaseinfoGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}

function drawPenetrationbaseinfoGrid(result,dataList){
	if(dataList!= null){
		
		$('#penetrationbaseinfo_Grid_div').empty();
		$('#penetrationbaseinfo_Grid_div').append('<table id="penetrationbaseinfo_Grid_table"></table>');
		$('#penetrationbaseinfo_Grid_div').append('<div id="pager_list_1"></div>');
		
		
		var grid = $('#penetrationbaseinfo_Grid_table');
		
		grid.jqGrid({
			datatype : 'jsonstring',
			datastr : dataList,
			colModel: [
						{name:'EquipNo',hidden:true},
						{name:'LocNo',hidden:true},
						{name:'ManagementNo',hidden:true},
						{name:'PenetrationNo ',hidden:true},
						{name:'ManagementAreaYN',hidden:true},
						{name:'Elevation',hidden:true},
						{name:'FirePreventionAreaNo',hidden:true},
						{name:'InspectionRoomNo',hidden:true},
						{name:'BackRoomNo',hidden:true},
						{name:'PenetrationForm',hidden:true},
						{name:'Wall_FloorNo',hidden:true},
						{name:'FirewallYN',hidden:true},
						{name:'WallMeterial',hidden:true},
						{name:'WallThickness',hidden:true},
						{name:'FrontPicNo',hidden:true},
						{name:'BackPicNo',hidden:true},
						{name:'ReferenceFloorPlanNo',hidden:true},
						{name:'LocationFloorPlanNo',hidden:true},
						{name:'SealDetailDWG',hidden:true},
						{name:'EL',hidden:true},
						{name:'Diameter',hidden:true},
						{name:'Height',hidden:true},
						{name:'Length',hidden:true},
						{name:'PenetrationType',hidden:true},
						{name:'MaximumFreeArea',hidden:true},
						{name:'MaximumFreeDistance',hidden:true},
						{name:'Register',hidden:true},
						{name:'Reviewer',hidden:true},
						{name:'Checker',hidden:true},
						{name:'SpecialNote',hidden:true},
						{name:'RegID',hidden:true},
			           {name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},
			           {name:'PenetrationNo',label:'관통부번호', align:'center', width:'10%'},
			           {name:'EquipNo_name',label:'호기', align:'center', width:'10%'},
			           {name:'LocNo_name',label:'건물', align:'center', width:'10%'},
			           {name:'PenetrationForm_name', label:'관통부형태',align:'center', width:'10%',editable:true},
			           {name:'WallMeterial_name', label:'벽재질', align:'center', width:'10%'},
			           {name:'Elevation', label:'Elevation(ft)', align:'center', width:'10%'},
			           {name:'WallThickness', label:'벽두께(inch)', align:'center', width:'10%'},
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
			lazyload: true,
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
//				var rowdata = grid.jqGrid('getRowData', id);
//				$('#ManagementNo').val(rowdata.ManagementNo);
//				$('#PenetrationNo ').val(rowdata.PenetrationNo );
//				$('#ManagementAreaYN').val(rowdata.ManagementAreaYN);
//				$('#ELEVATION_num_pit').val(rowdata.ELEVATION_num_pit);
//				$('#ELEVATION_num_inc').val(rowdata.ELEVATION_num_inc);
//				$('#FirePreventionAreaNo').val(rowdata.FirePreventionAreaNo);
//				$('#InspectionRoomNo').val(rowdata.InspectionRoomNo);
//				$('#BackRoomNo').val(rowdata.BackRoomNo);
////				$('#PenetrationForm').val(rowdata.PenetrationForm);
//				$('#Wall_FloorNo').val(rowdata.Wall_FloorNo);
//				$('#FirewallYN').val(rowdata.FirewallYN);
////				$('#WallMeterial').val(rowdata.WallMeterial);
//				$('#WallThickness').val(rowdata.WallThickness);
//				$('#FrontPicNo').val(rowdata.FrontPicNo);
//				$('#BackPicNo').val(rowdata.BackPicNo);
//				$('#ReferenceFloorPlanNo').val(rowdata.ReferenceFloorPlanNo);
//				$('#LocationFloorPlanNo').val(rowdata.LocationFloorPlanNo);
//				$('#SealDetailDWG').val(rowdata.SealDetailDWG);
//				$('#EL').val(rowdata.EL);
//				$('#Diameter').val(rowdata.Diameter);
//				$('#Height').val(rowdata.Height);
//				$('#Length').val(rowdata.Length);
//				$('#PenetrationType').val(rowdata.PenetrationType);
//				$('#MaximumFreeArea').val(rowdata.MaximumFreeArea);
//				$('#MaximumFreeDistance').val(rowdata.MaximumFreeDistance);
//				$('#Register').val(rowdata.Register);
//				$('#Reviewer').val(rowdata.Reviewer);
//				$('#Checker').val(rowdata.Checker);
//				$('#SpecialNote').val(rowdata.SpecialNote);
//				$('#RegID').val(rowdata.RegID);
//				document.getElementById("RegDateTime").innerHTML = rowdata.RegDateTime;
//				tagBind("selectBox_All", "FirewallYN","방화벽여부",rowdata.FirewallYN,codeAllInfo.A09);
//				tagBind("selectBox_All", "PenetrationForm","관통부형태",rowdata.PenetrationForm,codeAllInfo.A02);
//				tagBind("selectBox_All", "WallMeterial","벽재질",rowdata.WallMeterial,codeAllInfo.A04);
//				tagBind("selectBox_All", "EquipNo","호기",rowdata.EquipNo,codeAllInfo.A01);
//				tagBind("selectBox_All", "LocNo","건물",rowdata.LocNo,codeAllInfo.A11);
			},
		});
		grid.navGrid('#pager1',{edit:false,add:false,del:false});				
	}
}

function PenetrationbaseinfoSave(){
	$.ajax({
		url : 'penetrationbaseinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'save',
			EquipNo:$("#EquipNo option:selected").val(),
			LocNo :$("#LocNo option:selected").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo :$("#PenetrationNo").val(),
			ManagementAreaYN:$("#ManagementAreaYN").val(),
			Elevation:$("#Elevation").val(),
			FirePreventionAreaNo:$("#FirePreventionAreaNo").val(),
			InspectionRoomNo:$("#InspectionRoomNo").val(),
			BackRoomNo:$("#BackRoomNo").val(),
//			PenetrationForm:$("#PenetrationForm").val(),
			PenetrationForm:getRadioValueByTagName('PenetrationForm'),
			Wall_FloorNo:$("#Wall_FloorNo").val(),
//			FirewallYN:$("#FirewallYN").val(),
			FirewallYN:getRadioValueByTagName('FirewallYN'),
//			WallMeterial:$("#WallMeterial").val(),
			WallMeterial:$("#WallMeterial option:selected").val(),
			WallThickness:$("#WallThickness").val(),
			FrontPicNo:$("#FrontPicNo").val(),
			BackPicNo:$("#BackPicNo").val(),
			ReferenceFloorPlanNo:$("#ReferenceFloorPlanNo").val(),
			LocationFloorPlanNo:$("#LocationFloorPlanNo").val(),
			SealDetailDWG:$("#SealDetailDWG").val(),
			EL:$("#EL").val(),
			Diameter:$("#Diameter").val(),
			Height:$("#Height").val(),
			Length:$("#Length").val(),
			PenetrationType:$("#PenetrationType").val(),
			MaximumFreeArea:$("#MaximumFreeArea").val(),
			MaximumFreeDistance:$("#MaximumFreeDistance").val(),
			Register:$("#Register").val(),
			Reviewer:$("#Reviewer").val(),
			Checker:$("#Checker").val(),
			SpecialNote:$("#SpecialNote").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
//			if(result.success == true){
//				$('#create_Penetrationbaseinfo_modal').modal('hide');
//			}
			getPenetrationbaseinfoList();
		},
		error: function(data){
			
		}
	});
	
}


function deletePenetrationbaseinfo(Seq){
	$.ajax({
		url : 'penetrationbaseinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			Seq:Seq,
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
			getPenetrationbaseinfoList();
		},
		error: function(data){
			
		}
	});
}