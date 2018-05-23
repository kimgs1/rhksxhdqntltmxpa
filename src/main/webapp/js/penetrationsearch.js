var lastColWidth='20%';
$(function(){
	init();
})


function init(){
	getSearchPenetrationsearchList(1);
	getBaseCodeInfo();
	if(loginflag == false){
		lastColWidth = '8%';
	}
}

function getBaseCodeInfo(){
	getCodeAllInfo();
//	tagBind("radio", "FirewallYN","방화벽여부",null,codeAllInfo.A09);
//	tagBind("radio", "PenetrationForm","관통부형태",null,codeAllInfo.A02);
	tagBind("selectBox_All", "Equip","호기",null,codeAllInfo.A01);
	tagBind("selectBox_All", "Location","건물",null,codeAllInfo.A11);
	tagBind("checkBoxMulti", "WallMeterial","벽재질",null,codeAllInfo.A04);
	tagBind("checkBoxMulti", "ConstructionState","밀페재시공상태",null,codeAllInfo.A03);
	tagBind("checkBoxMulti", "Area","관통부분야",null,codeAllInfo.A08);
	tagBind("checkBoxMulti", "Wall_YN","관통부위치",null,codeAllInfo.A10);
	tagBind("checkBoxMulti", "Efficient","요구성능",null,codeAllInfo.A06);
	tagBind("checkBoxMulti", "Result","평가결과",null,codeAllInfo.A05);
	
}


function getSearchPenetrationsearchList(nowPage){
	if($("#ELEVATION_num_pit").val() != "" || $("#ELEVATION_num_inc").val() != "" ){
		if(isNaN(Number($("#ELEVATION_num_pit").val())) || isNaN($("#ELEVATION_num_inc").val()) || $("#ELEVATION_num_pit").val() == "" || $("#ELEVATION_num_inc").val() == ""  ){
			alert("ELEVATION 은 빈값이나  두 자리에 모두 숫자를 입력하여야 합니다.");
			return;
		}
	}
	
	if($("#ELEVATION_num_pit_2").val() != "" || $("#ELEVATION_num_inc_2").val() != "" ){
		if(isNaN(Number($("#ELEVATION_num_pit_2").val())) || isNaN($("#ELEVATION_num_inc_2").val()) || $("#ELEVATION_num_pit_2").val() == "" || $("#ELEVATION_num_inc_2").val() == ""  ){
			alert("ELEVATION 은 빈값이나  두 자리에 모두 숫자를 입력하여야 합니다.");
			return;
		}
	}
	
	
	if($("#Diameter_num_pit").val() != "" || $("#Diameter_num_inc").val() != "" ){
		if(isNaN(Number($("#Diameter_num_pit").val())) || isNaN($("#Diameter_num_inc").val()) || $("#Diameter_num_pit").val() == "" || $("#Diameter_num_inc").val() == ""  ){
			alert("Diameter 은 빈값이나  두 자리에 모두 숫자를 입력하여야 합니다.");
			return;
		}
	}
	
	
	if($("#Height_num_pit").val() != "" || $("#Height_num_inc").val() != "" ){
		if(isNaN(Number($("#Height_num_pit").val())) || isNaN($("#Height_num_inc").val()) || $("#Height_num_pit").val() == "" || $("#Height_num_inc").val() == ""  ){
			alert("Height 은 빈값이나  두 자리에 모두 숫자를 입력하여야 합니다.");
			return;
		}
	}
	
	if($("#Length_num_pit").val() != "" || $("#Length_num_inc").val() != "" ){
		if(isNaN(Number($("#Length_num_pit").val())) || isNaN($("#Length_num_inc").val()) || $("#Length_num_pit").val() == "" || $("#Length_num_inc").val() == ""  ){
			alert("Length 은 빈값이나  두 자리에 모두 숫자를 입력하여야 합니다.");
			return;
		}
	}
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
			nowPage: nowPage,
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo :$("#PenetrationNo").val(),
			Equip :$("#Equip option:selected").val(),
			ELEVATION_cal_flag :$("#ELEVATION_cal_flag option:selected").val(),
			ELEVATION_num_pit :$("#ELEVATION_num_pit").val(),
			ELEVATION_num_inc :$("#ELEVATION_num_inc").val(),
			ELEVATION_cal_flag_2 :$("#ELEVATION_cal_flag_2 option:selected").val(),
			ELEVATION_num_pit_2 :$("#ELEVATION_num_pit_2").val(),
			ELEVATION_num_inc_2 :$("#ELEVATION_num_inc_2").val(),

			Diameter_cal_flag :$("#Diameter_cal_flag option:selected").val(),
			Diameter_num_pit :$("#Diameter_num_pit").val(),
			Diameter_num_inc :$("#Diameter_num_inc").val(),

			Height_cal_flag :$("#Height_cal_flag option:selected").val(),
			Height_num_pit :$("#Height_num_pit").val(),
			Height_num_inc :$("#Height_num_inc").val(),

			Length_cal_flag :$("#Length_cal_flag option:selected").val(),
			Length_num_pit :$("#Length_num_pit").val(),
			Length_num_inc :$("#Length_num_inc").val(),
			
			Location :$("#Location option:selected").val(),
			WallMeterial :getCheckBoxValueByTagname('WallMeterial'),
			ConstructionState :getCheckBoxValueByTagname('ConstructionState'),
			Area:getCheckBoxValueByTagname('Area'),
			Wall_YN:getCheckBoxValueByTagname('Wall_YN'),
			Efficient:getCheckBoxValueByTagname('Efficient'),
			Result:getCheckBoxValueByTagname('Result'),
			InspectionInterval : $("#InspectionInterval option:selected").val(),
			ManagementAreaYN : $("#ManagementAreaYN option:selected").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationsearchGrid(result,dataList);
			drawPaging(result.pagingBean);
		},
		
		
		error: function(data){

		}
	});
}

function drawPaging(pagingBean){
	//paging
	innerHtml = "<table border=0 width=0 cellspacing=0 cellpadding=5 align=center><td width=48%><img src=./images/blink.gif width=1 height=1></td>";
	
	if(pagingBean.previousPageGroup){
		innerHtml += '<td align=right style="cursor:pointer"><li onclick="getSearchPenetrationsearchList('+(pagingBean.startPageOfPageGroup - 1)+')"><a><img src="images/bnBtn_prev.gif" /></a></li></td>';
//		innerHtml += "<a href='javascript:;' onclick='getBulletineList("+(pagingBean.startPageOfPageGroup - 1)+")'><<</a>";
	}
	for(var i=pagingBean.startPageOfPageGroup;i<=pagingBean.endPageOfPageGroup;i++){
		if(pagingBean.nowPage!=i)
			innerHtml += '<td style="cursor:pointer"><li onclick="getSearchPenetrationsearchList('+i+')"><a><font class="nbg4 b4">'+i+'</font></a></li></td>'
		else
			innerHtml += '<td style="cursor:pointer"><li onclick="getSearchPenetrationsearchList('+i+')"><a class="active"><font class="nbg4 b4" color=orange>'+i+'</font></a></li></td>'
	}
	if(pagingBean.nextPageGroup){
		innerHtml += '<td align=left style="cursor:pointer"><li onclick="getSearchPenetrationsearchList('+(pagingBean.endPageOfPageGroup + 1)+')"><a style="transform: rotate(180deg)"><img src="images/bnBtn_prev.gif"></a></li></td>';
	}
	innerHtml += '<td width=48%><img src=./images/blink.gif width=1 height=1></td></table>';
	document.getElementById("paging").innerHTML = innerHtml;
	document.getElementById("page_detail").innerHTML = 'Total:<span>'+pagingBean.totalContent+'</span>'+'(' + pagingBean.nowPage + '/' + pagingBean.totalPage + ')Page' ;
}
function drawPenetrationsearchGrid(result,dataList){
	if(dataList!= null){
		
		$('#penetrationsearch_Grid_div').empty();
		$('#penetrationsearch_Grid_div').append('<table id="penetrationsearch_Grid_table"></table>');
		
		var grid = $('#penetrationsearch_Grid_table');
		
		grid.jqGrid({
			datatype : 'jsonstring',
			datastr : dataList,
			colModel: [
						{name:'ManagementNo',hidden:true},
						{name:'PenetrationNo',hidden:true},
						{name:'LocationFloorPlanNo',hidden:true},
						{name:'ReferenceFloorPlanNo',hidden:true},
						{name:'FrontPicNo',hidden:true},
						{name:'BackPicNo',hidden:true},
						{name:'FirewallYN',hidden:true},
						{name:'PenetrationForm',hidden:true},
						{name:'ConstructionState',hidden:true},
						{name:'EvaluationResult',hidden:true},
						{name:'InspectSeq',hidden:true},
						{name:'FileLocation_1',hidden:true},
						{name:'FileLocation_2',hidden:true},
						{name:'FileLocation_3',hidden:true},
//			           {name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},

			           {name:'PenetrationNo_Icon',label:'관통부번호', align:'center', width:'10%',
							 formatter:function (cellvalue, options, rowObject) {    

				        			   return '<div align="center" style="cursor:hand" onclick="OpenPdfFiles(\''+rowObject.FileLocation_1+'\')" >'+rowObject.PenetrationNo+'</div>'; 
				        	   }
			           },
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
			           
			           {label : "평면도", name: 'ReferenceFloorPlanNo_Lable', sorttype: 'string', align: 'center', width: '5%',
			        	   formatter:function (cellvalue, options, rowObject) {    
			        		   if(rowObject.FrontPicNo == ''){
			        			   return '<a href="#" class="pdfDown pdfBlank" "> </a>';
			        		   }
			        		   else{
			        			   
			        			   return '<a href="#" class="pdfDown" onclick="OpenPdfFiles(\''+rowObject.FileLocation_2+'\')" ></a>'; 
			        			   
			        			   
			        		   }
			        	   }
			           },			           
			           {label : "위치도", name: 'LocationFloorPlanNo_Lable', sorttype: 'string', align: 'center', width: '5%',
			        	   formatter:function (cellvalue, options, rowObject) {    
			        		   if(rowObject.BackPicNo == ''){
			        			   return '<a href="#" class="pdfDown pdfBlank" > </a>';
			        		   }
			        		   else{
			        			   return '<a href="#" class="pdfDown" onclick="OpenPdfFiles(\''+rowObject.FileLocation_3+'\')" ></a>'; 
			        		   }
			        	   }
			           },
			           {name:'FirewallYN_name', label:'종류',align:'center', width:'10%',editable:true},
			           {name:'PenetrationForm_name', label:'형태', align:'center', width:'10%'},
			           {name:'SealantConditionState_name', label:'밀폐재시공상태', align:'center', width:'10%'},
			           {label : "상세보기", name: 'view_detail', sorttype: 'string', align: 'center', width: lastColWidth,
			        	   formatter:function (cellvalue, options, rowObject) {  
//			        		   return '<input onclick="getDetailView('+options.rowId+')" type="button" value="보기" style="{width:60px; height:20px; line-height:20px; font-size:13px; font-weight:400; color:#fff; background:url(../images/ico_show.png)no-repeat 7px center #ff8511; padding-left:23px; border:0; border-radius:5px; }">';
			        		   var returnTagStr = "";
			        		   returnTagStr +=  '<input class="view" onclick="getDetailView('+options.rowId+')" type="button" style="cursor:pointer;" value="보기" >';
			        		   if(loginflag == true){
				        		   returnTagStr +=  '<input class="edit" onclick="EditDetailView('+options.rowId+')" style="cursor:pointer;" type="button" value="수정">';
				        		   returnTagStr +=  '<input class="delete" onclick="deletePenetrationsearch('+options.rowId+')" style="cursor:pointer;" type="button" value="삭제">';
			        		   }
			        		   return returnTagStr
			        	   }
			           },
			],

			rowNum: 100,
			rownumWidth:50,
			rownumbers: true,  
			loadonce:true,
			cellEdit : false,  
			autowidth : true,
			shrinkToFit : true,
			scrollrows : true,
			gridview : true,
			height : 240,
			viewrecords: true,
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


function deletePenetrationsearch(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
	var msg = "관통부번호 : " +PenetrationNo+ " 관리번호 :"+ManagementNo+" 인 관통부 정보를 삭제하시겠습니까?"; 
	 if (confirm(msg)==false){ 
	  return;
	 } 
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			ManagementNo:ManagementNo,
			PenetrationNo:PenetrationNo,
		},
		success : function(data) {
			var result = data.result;
			if(result.result == true){
				alert("관통부정보가 정상적으로 삭제되었습니다.");
				getSearchPenetrationsearchList();
			}
			else{

				alert("관통부정보를 삭제하는데 실패하였습니다. \r\n 관리자에게 문의 바랍니다. \r\n " + result.msg);
			}
		},
		error: function(data){
			
		}
	});
}

function openPicFront(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
	var InspectSeq = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).InspectSeq;
	var photoName = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).FrontPicNo;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getFrontImg',
			ManagementNo:ManagementNo,
			PenetrationNo:PenetrationNo,
			InspectSeq:InspectSeq,
			photoName:photoName,
		},
		success : function(data) {
			var result = data.result;
			if(result.result == "success"){
				window.open("./DownLoadImg/" + result.photoName);
			}else{
				alert("이미지가 저장 되어있지 않습니다.");
			}
		},
		error: function(data){

		}
	});
}



function openPicBack(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
	var InspectSeq = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).InspectSeq;
	var photoName = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).BackPicNo;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getBackImg',
			ManagementNo:ManagementNo,
			PenetrationNo:PenetrationNo,
			InspectSeq:InspectSeq,
			photoName:photoName,
		},
		success : function(data) {
			var result = data.result;
			if(result.result == "success"){
				
				window.open("./DownLoadImg/" + result.photoName);
			}else{
				alert("이미지가 저장 되어있지 않습니다.");
			}
		},
		error: function(data){
		}
	});
}

function getDetailView(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
//	var InspectSeq = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).InspectSeq;
//	window.open("./penetrationsearch?command=getSearchView&&ManagementNo="+ManagementNo+"&&PenetrationNo="+PenetrationNo+"&&InspectSeq="+InspectSeq);
	window.open("./penetrationsearch?command=getSearchView&&ManagementNo="+ManagementNo+"&&PenetrationNo="+PenetrationNo);
}
function EditDetailView(rowId){
	var ManagementNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).ManagementNo;
	var PenetrationNo = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).PenetrationNo;
//	var InspectSeq = $('#penetrationsearch_Grid_table').jqGrid('getRowData', rowId).InspectSeq;
//	window.open("./penetrationsearch?command=getSearchEditView&&ManagementNo="+ManagementNo+"&&PenetrationNo="+PenetrationNo+"&&InspectSeq="+InspectSeq);
	window.open("./penetrationsearch?command=getSearchEditView&&ManagementNo="+ManagementNo+"&&PenetrationNo="+PenetrationNo);
}


function CreateDetailView(){
	window.open("./penetrationsearch?command=getSearchCreateView");
}

function saveCharExcel (){
	
	$('#excel_modal').modal({
		backdrop: 'static',
		keyboard: false
	});
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getExcelData',
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo :$("#PenetrationNo").val(),
			Equip :$("#Equip option:selected").val(),
			ELEVATION_cal_flag :$("#ELEVATION_cal_flag option:selected").val(),
			ELEVATION_num_pit :$("#ELEVATION_num_pit").val(),
			ELEVATION_num_inc :$("#ELEVATION_num_inc").val(),
			ELEVATION_cal_flag_2 :$("#ELEVATION_cal_flag_2 option:selected").val(),
			ELEVATION_num_pit_2 :$("#ELEVATION_num_pit_2").val(),
			ELEVATION_num_inc_2 :$("#ELEVATION_num_inc_2").val(),

			Diameter_cal_flag :$("#Diameter_cal_flag option:selected").val(),
			Diameter_num_pit :$("#Diameter_num_pit").val(),
			Diameter_num_inc :$("#Diameter_num_inc").val(),

			Height_cal_flag :$("#Height_cal_flag option:selected").val(),
			Height_num_pit :$("#Height_num_pit").val(),
			Height_num_inc :$("#Height_num_inc").val(),

			Length_cal_flag :$("#Length_cal_flag option:selected").val(),
			Length_num_pit :$("#Length_num_pit").val(),
			Length_num_inc :$("#Length_num_inc").val(),
			
			Location :$("#Location option:selected").val(),
			WallMeterial :getCheckBoxValueByTagname('WallMeterial'),
			ConstructionState :getCheckBoxValueByTagname('ConstructionState'),
			Area:getCheckBoxValueByTagname('Area'),
			Wall_YN:getCheckBoxValueByTagname('Wall_YN'),
			Efficient:getCheckBoxValueByTagname('Efficient'),
			Result:getCheckBoxValueByTagname('Result'),
			InspectionInterval : $("#InspectionInterval option:selected").val(),
			ManagementAreaYN : $("#ManagementAreaYN option:selected").val(),
		},
		timeout : 0,
		success : function(data) {
			$('#excel_modal').modal('hide');
			var url='ExcelData/' + data.result.FileName;
			var a = document.createElement('a'),
			ev = document.createEvent("MouseEvents");
			a.href = url;
			a.download = url.slice(url.lastIndexOf('/')+1);
			ev.initMouseEvent("click", true, false, self, 0, 0, 0, 0, 0,false, false, false, false, 0, null);
			a.dispatchEvent(ev);

//			$.ajax({
//				url : 'realTime.do',
//				type : 'post',
//				dataType : 'json',
//				data : 'command=excel_remove&&fileName=' + data.fileName,
//				success : function(data) {},
//				error : function() {}
//			});
		},
		error : function() {
			alert("엑셀 저장 실패");
			$('#excel_modal').modal('hide');
		}
	});

}
