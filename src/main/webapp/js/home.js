var userId;
var codeAllInfo;
var chartList;
$(function(){
	chartList = new HashMap();
	getQNAList();
	getBulletineList();
	getContentInfoList();
	getChart();
	loadEquipNoLocNoData();
	getMergeData();
})


function logout(){
	location.href = "home.do?command=logout";
}

function moveToBulletineList(){
	window.location.href = '/NPower/fbulletine';
}

function getBulletineList(){
	$.ajax({
		url : 'fbulletine.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList'
		},
		success : function(data) {
			var result = data.result;
			var fbList = data.result.FBList;
			if(fbList!= null){
				var innerHtml = "";
				innerHtml += "<h2 onclick='menuClick(" + "\"FBUL\""+")'>공지사항</h2>";
				innerHtml += "<ul>";
				for(var i=0; i<fbList.length;i++){
					innerHtml += "<li onmouseover=this.style.color='#9f4faf'>";
					innerHtml +=  '<a onclick="getBulletineContent('+fbList[i].id+')" >';
					innerHtml += '['+fbList[i].RegDateTime+']';
					innerHtml += '   '+fbList[i].title+'   ';
					innerHtml +=  '</a>';
					innerHtml += "</li>";

				}
				innerHtml += "</ul>";
				document.getElementById("bulletine_div").innerHTML = innerHtml;
			}
		},
		error: function(data){
			
		}
	});
}

function getBulletineContent(id){
	window.location.href = '/NPower/fbulletine_content?id='+id;
}

function getQNAList(){
	$.ajax({
		url : 'qna.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList'
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.DataList;
			if(dataList!= null){
				var innerHtml = "";
				innerHtml += "<h2 onclick='menuClick(" + "\"QNA\""+")'>자주하는 질문</h2>";
				innerHtml += "<ul>";
				for(var i=0; i<dataList.length;i++){
					innerHtml += "<li onmouseover=this.style.color='#9f4faf'>";
					innerHtml +=  '<a onclick="getQNAContent('+dataList[i].ID+')" >';
					innerHtml += '['+dataList[i].RegDateTime+']';
					innerHtml += '   '+dataList[i].subject+'   ';
					innerHtml +=  '</a>';
					innerHtml += "</li>";

				}
				innerHtml += "</ul>";
				document.getElementById("qna_div").innerHTML = innerHtml;
			}
		},
		error: function(data){
			
		}
	});
}

function getQNAContent(id){
	window.location.href = '/NPower/qna_content?id='+id;
}
function getContentInfoList(){
	$.ajax({
		url : 'contentinfo.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList'
		},
		success : function(data) {
			var result = data.result;
			var dataList = data.result.dataList;
			if(dataList!= null){
				var innerHtml = "";
				innerHtml += "<h2 onclick='menuClick(" + "\"CNT\""+")'>자료실</h2>";
				innerHtml += "<ul>";
				for(var i=0; i<dataList.length;i++){
					innerHtml += "<li onmouseover=this.style.color='#9f4faf'>";
					innerHtml +=  '<a onclick="getContentInfoContent('+dataList[i].id+')" >';
					innerHtml += '['+dataList[i].RegDateTime+']';
					innerHtml += '   '+dataList[i].subject+'   ';
					innerHtml +=  '</a>';
					innerHtml += "</li>";

				}
				innerHtml += "</ul>";
				document.getElementById("content_div").innerHTML = innerHtml;
			}
		},
		error: function(data){
			
		}
	});
}

function getContentInfoContent(id){
	window.location.href = '/NPower/contentinfo_content?id='+id;
}
function getChart(){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'LocChart'
		},
		success : function(data) {
			var Data = data.result.DataList;
			drawChart('LocChart_div',Data,'건물별 관통부통계');
		},
		error: function(data){
			
		}
	});
	
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'WallMeterialChart'
		},
		success : function(data) {
			var Data = data.result.DataList;
			drawChart('WallMeterialChart_div',Data,'벽재질');
		},
		error: function(data){
			
		}
	});
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'ConstructionStateChart'
		},
		success : function(data) {
			var Data = data.result.DataList;
			drawChart('ConstructionStateChart_div',Data,'시공상태');
		},
		error: function(data){
			
		}
	});
	
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'DepartmentChart'
		},
		success : function(data) {
			var Data = data.result.DataList;
			drawChart('DepartmentChart_div',Data,'부서별');
		},
		error: function(data){
			
		}
	});
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'EffectChart'
		},
		success : function(data) {
			var Data = data.result.DataList;
			drawChart('EffectChart_div',Data,'요구성능');
		},
		error: function(data){
			
		}
	});
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'sealantMaterialChart'
		},
		success : function(data) {
			var Data = data.result.DataList;
			drawChart('sealantMaterialChart_div',Data,'밀페재 재질');
		},
		error: function(data){
			
		}
	});

}

function loadEquipNoLocNoData(){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'TotalCount'
		},
		success : function(data) {
			var Data = data.result.DataList;
			document.getElementById("total_count").innerHTML = Data[0].value;
		},
		error: function(data){
			
		}
	});
	
	
	
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'EquipNoLocNoData'
		},
		success : function(data) {
			var Data = data.result.DataList;
			var innerHtml = "";
			for(var i=0;i<Data.length;i++){ 
				innerHtml +='<li class="nbg1 b2">'+Data[i].name+'<span>'+Data[i].value+'</span></li>';
				
			}
			document.getElementById("EquipNoLocNoData_div").innerHTML = innerHtml;
		},
		error: function(data){
			
		}
	});
	
}

function getMergeData(){
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'MergeData'
		},
		success : function(data) {
			var dataList = data.result.DataList;
			if(dataList!= null){
				
				$('#MergeGrid_div').empty();
				$('#MergeGrid_div').append('<table id="MergeGrid_div_table"></table>');
				$('#MergeGrid_div').append('<div id="pager_list_1"></div>');
				
				var grid = $('#MergeGrid_div_table');
				
				grid.jqGrid({
					datatype : 'jsonstring',
					datastr : dataList,
					colModel: [
					           {name:'name', label:'구분', align:'center', width:'10%'},
					           {name:'value',label:'Total', align:'center', width:'10%'},
					           {name:'val9',label:'환기', align:'center', width:'10%'},
					           {name:'val10',label:'내화', align:'center', width:'10%'},
					           {name:'val11',label:'방사선 차폐', align:'center', width:'10%'},
					           {name:'val12',label:'수밀', align:'center', width:'10%'},
					           {name:'val13',label:'내압', align:'center', width:'10%'},
					           {name:'val1',label:'양호', align:'center', width:'10%'},
					           {name:'val2',label:'미시공', align:'center', width:'10%'},
					           {name:'val3',label:'파손', align:'center', width:'10%'},
					           {name:'val4',label:'댐재 미제거', align:'center', width:'10%'},
					           {name:'val5',label:'전선관내 미시공', align:'center', width:'10%'},
					           {name:'val6',label:'CAP 미설치', align:'center', width:'10%'},
					           {name:'val7',label:'만족', align:'center', width:'10%'},
					           {name:'val8',label:'불만족', align:'center', width:'10%'},
					],
					pager: "#pager_list_1", 
					page : 1,
					rowNum: 25,                         //在grid上显示记录条数，这个参数是要被传递到后台
				    rowList: [10, 25, 35],              //一个下拉选择框，用来改变显示记录数，当选择时会覆盖rowNum参数传递到后台
					rownumbers: true,  
					cellEdit : false,  
					loadonce:true,
					lazyload: true,
					autowidth : true,
					shrinkToFit : true,
					scrollrows : true,
					gridview : true,
					height : 280,
					width : $("#MergeGrid_div").width() * 0.5,
					viewrecords: true,
					jsonReader : {
						repeatitems : false,
						root : function(obj) {return obj;},
						page : function(obj) {return 1;},
						total : function(obj) {return 1;},
						records : function(obj) {return obj.length;}
					},
				});				
			}
		},
		error: function(data){
			
		}
	});
}



function tabClick(tagName){
	setTimeout( function(){
		chartList.get(tagName).update();
	}, 100);
}

function exampleData(data) {
	 return  [ 
	    {
	      key: "Cumulative Return",
	      values:data
	    }
	  ]
}

function drawChart(chart_tag, data,chart_name){
	$("#"+chart_tag + " svg").empty();
	nv.addGraph(function() {
		var chart = nv.models.discreteBarChart()
			.x(function(d) { return d.name })
		    .y(function(d) { return d.value })
			.staggerLabels(true)    //Too many bars and not enough room? Try staggering labels.
		    .showValues(true)       //...instead, show the bar value right on top of each bar.
			;
 
		chart.tooltip.enabled(); 
        d3.select("#"+chart_tag + ' svg')
		.datum(exampleData(data))
		.call(chart);
		nv.utils.windowResize(chart.update);
		chartList.put(chart_tag , chart);
		
		return chart;
	});
	
	
}