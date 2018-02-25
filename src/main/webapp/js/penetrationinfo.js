
$(function(){
	init();
})

function init(){
	$('#Seq').val("");
	$('#ManagementNo').val("");
	$('#PenetrationNo').val("");
	$('#matter').val("");
	$('#Pipe').val("");
	$('#Duct').val("");
	$('#SectionTube').val("");
	$('#Conduit').val("");
	$('#Cable').val("");
	$('#Tray').val("");
	$('#CoverTray').val("");
	$('#Etc').val("");
	$('#RegID').val("");
	getPenetrationinfoList();
	getBaseCodeInfo();
}

function getBaseCodeInfo(){
	getCodeAllInfo();
	tagBind("selectBox_All", "matter","관통재정보",null,codeAllInfo.A08);
}


function getPenetrationinfoList(){
	$.ajax({
		url : 'penetrationinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationinfoGrid(result,dataList);
		},
		error: function(data){
			
		}
	});
}



function getSearchPenetrationinfoList(){
	$.ajax({
		url : 'penetrationinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
//			Seq:$("#Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
//			matter:$("#matter").val(),
//			matter:$("#matter option:selected").val(),
			Pipe:$("#Pipe").val(),
			Duct:$("#Duct").val(),
			SectionTube:$("#SectionTube").val(),
			Conduit:$("#Conduit").val(),
			Cable:$("#Cable").val(),
			Tray:$("#Tray").val(),
			CoverTray:$("#CoverTray").val(),
			Etc:$("#Etc").val(),
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			drawPenetrationinfoGrid(result,dataList)
		},
		
		
		error: function(data){

		}
	});
}

 function drawPenetrationinfoGrid(result,dataList){
	 if(dataList!= null){
			
			$('#penetrationinfo_Grid_div').empty();
			$('#penetrationinfo_Grid_div').append('<table id="penetrationinfo_Grid_table"></table>');
			$('#penetrationinfo_Grid_div').append('<div id="pager_list_1"></div>');
			
			var grid = $('#penetrationinfo_Grid_table');
			
			grid.jqGrid({
				datatype : 'jsonstring',
				datastr : dataList,
				colModel: [
							{name:'ManagementNo',hidden:true},
							{name:'PenetrationNo',hidden:true},
							{name:'matter',hidden:true},
							{name:'Pipe',hidden:true},
							{name:'Duct',hidden:true},
							{name:'SectionTube',hidden:true},
							{name:'Conduit',hidden:true},
							{name:'Cable',hidden:true},
							{name:'Tray',hidden:true},
							{name:'CoverTray',hidden:true},
							{name:'Etc',hidden:true},
							{name:'RegID',hidden:true},
							{name:'RegDate',hidden:true},
							{name:'UpdateRegID',hidden:true},
							{name:'UpdateDate',hidden:true},
							{name:'ManagementNo', label:'관리번호', align:'center', width:'10%'},
							{name:'PenetrationNo',label:'관통부번호', align:'center', width:'10%'},
//							{name:'matter_name',label:'관통재정보', align:'center', width:'10%'},
							{name:'Pipe',label:'배관', align:'center', width:'10%'},
							{name:'Duct',label:'덕트', align:'center', width:'10%'},
							{name:'SectionTube',label:'계장튜브', align:'center', width:'10%'},
							{name:'Conduit',label:'전선관', align:'center', width:'10%'},
							{name:'Cable',label:'케이블', align:'center', width:'10%'},
							{name:'Tray',label:'트레이', align:'center', width:'10%'},
							{name:'CoverTray',label:'커버트레이', align:'center', width:'10%'},
							{name:'Etc',label:'기타', align:'center', width:'10%'},
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
				
				onSelectRow : function(id) {
					var rowdata = grid.jqGrid('getRowData', id);
					$('#ManagementNo').val(rowdata.ManagementNo);
					$('#PenetrationNo').val(rowdata.PenetrationNo);
					$('#matter').val(rowdata.matter);
					$('#Pipe').val(rowdata.Pipe);
					$('#Duct').val(rowdata.Duct);
					$('#SectionTube').val(rowdata.SectionTube);
					$('#Conduit').val(rowdata.Conduit);
					$('#Cable').val(rowdata.Cable);
					$('#Tray').val(rowdata.Tray);
					$('#CoverTray').val(rowdata.CoverTray);
					$('#Etc').val(rowdata.Etc);
					$('#RegID').val(rowdata.RegID);
//					document.getElementById("RegDateTime").innerHTML = rowdata.RegDateTime;

					tagBind("selectBox_All", "matter","관통재정보",rowdata.matter,codeAllInfo.A08);
				},
			});				
		}
}

function PenetrationinfoSave(){
	$.ajax({
		url : 'penetrationinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'save',
			Seq:$("#Seq").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo:$("#PenetrationNo").val(),
//			matter:$("#matter").val(),
			matter:getRadioValueByTagName('matter'),
			Pipe:$("#Pipe").val(),
			Duct:$("#Duct").val(),
			SectionTube:$("#SectionTube").val(),
			Conduit:$("#Conduit").val(),
			Cable:$("#Cable").val(),
			Tray:$("#Tray").val(),
			CoverTray:$("#CoverTray").val(),
			Etc:$("#Etc").val(),
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
//			if(result.success == true){
//				$('#create_Penetrationbaseinfo_modal').modal('hide');
//			}
			getPenetrationinfoList();
		},
		error: function(data){
			
		}
	});
}




function deletePenetrationinfo(Seq){
	$.ajax({
		url : 'penetrationinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'delete',
			Seq:Seq,
		},
		success : function(data) {
			var result = data.result;
			alert(result.msg);
			getPenetrationinfoList();
		},
		error: function(data){
			
		}
	});
}