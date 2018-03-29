
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
	tagBind("selectBox_All", "Judgment","판정",null,codeAllInfo.A05);
}


function getPenetrationinspectList(){
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getDataList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationinspectGrid(result,dataList);
			drawPaging(result.pagingBean);
		},
		error: function(data){
			
		}
	});
}



function getSearchPenetrationinspectList(nowPage){
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getDataList',
//			Seq:$("#Seq").val(),
			nowPage: nowPage,
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
			InspectDate:$("#InspectDate").val(),
			InspectSeq:$("#InspectSeq").val(),
			ImproveDate:$("#ImproveDate").val(),
			InspectionInterval:$("#InspectionInterval").val(),
			SealantConditionState:$("#SealantConditionState").val(),
			JudgementReason:$("#JudgementReason").val(),
//			Judgment:$("#Judgment").val(),
			Judgment:$("#Judgment option:selected").val(),
			ImproveNote:$("#ImproveNote").val(),
			RegID:$("#RegID").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationinspectGrid(result,dataList);
			drawPaging(result.pagingBean);
		},
		
		
		error: function(data){

		}
	});
}
function drawPaging(pagingBean){
	//paging
	innerHtml = "<table border=0 width=100% cellspacing=0 cellpadding=5 align=center><td width=48%><img src=./images/blink.gif width=1 height=1></td>";
	
	if(pagingBean.previousPageGroup){
		innerHtml += '<td align=right style="cursor:pointer"><li onclick="getSearchPenetrationinspectList('+(pagingBean.startPageOfPageGroup - 1)+')"><a><img src="images/bnBtn_prev.gif" /></a></li></td>';
//		innerHtml += "<a href='javascript:;' onclick='getBulletineList("+(pagingBean.startPageOfPageGroup - 1)+")'><<</a>";
	}
	for(var i=pagingBean.startPageOfPageGroup;i<=pagingBean.endPageOfPageGroup;i++){
		if(pagingBean.nowPage!=i)
			innerHtml += '<td style="cursor:pointer"><li onclick="getSearchPenetrationinspectList('+i+')"><a><font class="nbg4 b4">'+i+'</font></a></li></td>'
		else
			innerHtml += '<td style="cursor:pointer"><li onclick="getSearchPenetrationinspectList('+i+')"><a class="active"><font class="nbg4 b4" color=orange>'+i+'</font></a></li></td>'
	}
	if(pagingBean.nextPageGroup){
		innerHtml += '<td align=left style="cursor:pointer"><li onclick="getSearchPenetrationinspectList('+(pagingBean.endPageOfPageGroup + 1)+')"><a><img src="images/bnBtn_next.gif" /></a></li></td>';
	}
	innerHtml += '<td width=48%><img src=./images/blink.gif width=1 height=1></td></table>';
	document.getElementById("paging").innerHTML = innerHtml;
//	document.getElementById("page_detail").innerHTML = 'Total:<span>'+pagingBean.totalContent+'</span>'+'(' + pagingBean.nowPage + '/' + pagingBean.totalPage + ')Page' ;
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
				rownumbers: true,  
				cellEdit : false,  
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
//					var rowdata = grid.jqGrid('getRowData', id);
//					$('#Seq').val(rowdata.Seq);
//					$('#ManagementNo').val(rowdata.ManagementNo);
//					$('#PenetrationNo').val(rowdata.PenetrationNo);
//					$('#InspectDate').val(rowdata.InspectDate);
//					$('#InspectSeq').val(rowdata.InspectSeq);
//					$('#ImproveDate').val(rowdata.ImproveDate);
//					$('#InspectionInterval').val(rowdata.InspectionInterval);
//					$('#SealantConditionState').val(rowdata.SealantConditionState);
//					$('#JudgementReason').val(rowdata.JudgementReason);
//					$('#Judgment').val(rowdata.Judgment);
//					$('#ImproveNote').val(rowdata.ImproveNote);
//					$('#RegID').val(rowdata.RegID);
////					document.getElementById("RegDateTime").innerHTML = rowdata.RegDateTime;
//
//					tagBind("radio", "Judgment","판정",rowdata.Judgment,codeAllInfo.A05);				
				},
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
