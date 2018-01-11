
$(function(){
	init();
})


function init(){
	getPenetrationsearchList();
	getBaseCodeInfo()
}

function getBaseCodeInfo(){
	getCodeAllInfo();
//	tagBind("radio", "FirewallYN","방화벽여부",null,codeAllInfo.A09);
//	tagBind("radio", "PenetrationForm","관통부형태",null,codeAllInfo.A02);
	tagBind("selectBox_All", "Location","건물",null,codeAllInfo.A11);
	tagBind("checkBoxMulti", "WallMeterial","벽재질",null,codeAllInfo.A04);
	tagBind("checkBoxMulti", "ConstructionState","밀페재시공상태",null,codeAllInfo.A03);
}
function getPenetrationsearchList(){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationsearchGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}


function getSearchPenetrationsearchList(){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo :$("#PenetrationNo").val(),
			ELEVATION :$("#ELEVATION").val(),
			Location :$("#Location option:selected").val(),
			WallMeterial :getCheckBoxValueByTagname('WallMeterial'),
			ConstructionState :getCheckBoxValueByTagname('ConstructionState'),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationsearchGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}


function drawPenetrationsearchGrid(result,dataList){
	if(dataList!= null){
		
		$('#penetrationsearch_Grid_div').empty();
		$('#penetrationsearch_Grid_div').append('<table id="penetrationsearch_Grid_table"></table>');
		$('#penetrationsearch_Grid_div').append('<div id="pager_list_1"></div>');
		
		var grid = $('#penetrationsearch_Grid_table');
		
		grid.jqGrid({
			datatype : 'jsonstring',
			datastr : dataList,
			colModel: [
						{name:'ManagementNo',hidden:true},
						{name:'PenetrationNo ',hidden:true},
						{name:'LocationFloorPlanNo',hidden:true},
						{name:'ReferenceFloorPlanNo',hidden:true},
						{name:'FrontPicNo',hidden:true},
						{name:'BackPicNo',hidden:true},
						{name:'FirewallYN',hidden:true},
						{name:'PenetrationForm',hidden:true},
						{name:'ConstructionState',hidden:true},
						{name:'EvaluationResult',hidden:true},
						{name:'InspectSeq',hidden:true},
//			           {name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},
			           {name:'PenetrationNo',label:'관통부번호', align:'center', width:'10%'},
			           {name:'Elevation',label:'Elevation', align:'center', width:'10%'},
			           {name:'LocNo_name',label:'건물', align:'center', width:'10%'},
			           {name:'WallMeterial_name',label:'벽재질', align:'center', width:'10%'},
			           
			           {label : "사진1", name: 'FrontPicNo_Lable', sorttype: 'string', align: 'center', width: '5%',
			        	   formatter:function (cellvalue, options, rowObject) {    
			        		   if(rowObject.FrontPicNo == ''){
			        			   return '<a href="#" class="down blank" "> </a>';
			        		   }
			        		   else{
			        			   return '<a href="#" class="down" onclick="openPicFront('+options.rowId+')" ></a>'; 
			        		   }
			        	   }
			           },			           
			           {label : "사진2", name: 'BackPicNo_Lable', sorttype: 'string', align: 'center', width: '5%',
			        	   formatter:function (cellvalue, options, rowObject) {    
			        		   if(rowObject.BackPicNo == ''){
			        			   return '<a href="#" class="down blank" > </a>';
			        		   }
			        		   else{
			        			   return '<a href="#" class="down" onclick="openPicBack('+options.rowId+')" ></a>'; 
			        		   }
			        	   }
			           },
			           {name:'FirewallYN_name', label:'종류',align:'center', width:'10%',editable:true},
			           {name:'PenetrationForm_name', label:'형태', align:'center', width:'10%'},
			           {name:'ConstructionState_name', label:'밀폐재시공상태', align:'center', width:'10%'},
			           {label : "상세보기", name: 'view_detail', sorttype: 'string', align: 'center', width: '8%',
			        	   formatter:function (cellvalue, options, rowObject) {  
			        		   return '<input onclick="getDetailView('+options.rowId+')" type="button" value="보기" style="{width:60px; height:20px; line-height:20px; font-size:13px; font-weight:400; color:#fff; background:url(../images/ico_show.png)no-repeat 7px center #ff8511; padding-left:23px; border:0; border-radius:5px; }">';
			        	   }
			           },
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
//				$('#Seq').val(rowdata.Seq);
//				$('#ManagementNo').val(rowdata.ManagementNo);
//				$('#PenetrationNo ').val(rowdata.PenetrationNo );
//				$('#ManagementAreaYN').val(rowdata.ManagementAreaYN);
//				$('#Elevation').val(rowdata.Elevation);
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
//				tagBind("radio", "FirewallYN","방화벽여부",rowdata.FirewallYN,codeAllInfo.A09);
//				tagBind("radio", "PenetrationForm","관통부형태",rowdata.PenetrationForm,codeAllInfo.A02);
//				tagBind("selectBox", "WallMeterial","벽재질",rowdata.WallMeterial,codeAllInfo.A04);
			},
		});				
	}
}

function PenetrationsearchSave(){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'save',
			Seq:$("#Seq").val(),
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
//				$('#create_Penetrationsearch_modal').modal('hide');
//			}
			getPenetrationsearchList();
		},
		error: function(data){
			
		}
	});
	
}


function deletePenetrationsearch(Seq){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			Seq:Seq,
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
			getPenetrationsearchList();
		},
		error: function(data){
			
		}
	});
}

function openPicFront(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
	var photoName = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).FrontPicNo;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getFrontImg',
			ManagementNo:ManagementNo,
			PenetrationNo:PenetrationNo,
			photoName:photoName,
		},
		success : function(data) {
			var result = data.result;
			if(result.result == "success"){
				window.open("./DownLoadImg/" + result.photoName);
			}else{
				alert("이미지가 저장이 되어있지 않았습니다.");
			}
		},
		error: function(data){

		}
	});
}



function openPicBack(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
	var photoName = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).FrontPicNo;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getBackImg',
			ManagementNo:ManagementNo,
			PenetrationNo:PenetrationNo,
			photoName:photoName,
		},
		success : function(data) {
			var result = data.result;
			if(result.result == "success"){
				
				window.open("./DownLoadImg/" + result.photoName);
			}else{
				alert("이미지가 저장이 되어있지 않았습니다.");
			}
		},
		error: function(data){
			
		}
	});
}

function getDetailView(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
	var InspectSeq = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).InspectSeq;
	window.open("./penetrationsearch?command=getSearchView&&ManagementNo="+ManagementNo+"&&PenetrationNo="+PenetrationNo+"&&InspectSeq="+InspectSeq);
}
