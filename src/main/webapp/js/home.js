var userId;
var codeAllInfo;
var chartList;
$(function(){
	chartList = new HashMap();
	getQNAList();
	getBulletineList();
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
					innerHtml += "<li>";
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
				innerHtml += "<h2 onclick='menuClick(" + "\"QNA\""+")'>Q&A</h2>";
				innerHtml += "<ul>";
				for(var i=0; i<dataList.length;i++){
					innerHtml += "<li>";
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
				innerHtml +='<li>'+Data[i].name+'<span>'+Data[i].value+'</span></li>';
				
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
					           {name:'val1',label:'양호', align:'center', width:'10%'},
					           {name:'val2',label:'미시공', align:'center', width:'10%'},
					           {name:'val3',label:'파손', align:'center', width:'10%'},
					           {name:'val4',label:'댐재 미제거', align:'center', width:'10%'},
					           {name:'val5',label:'전선관내 미시공', align:'center', width:'10%'},
					           {name:'val6',label:'CAP 미설치', align:'center', width:'10%'},
					           
					],
					pager: "#pager_list_1", 
					page : 1,
					rowNum: 25,                            //在grid上显示记录条数，这个参数是要被传递到后台
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
//	nv.addGraph(function() {
//		  var chart = nv.models.discreteBarChart()
//		      .x(function(d) { return d.label })    //Specify the data accessors.
//		      .y(function(d) { return d.value })
//		      .staggerLabels(true)    //Too many bars and not enough room? Try staggering labels.
//		      .tooltips(false)        //Don't show tooltips
//		      .showValues(true)       //...instead, show the bar value right on top of each bar.
//		      .transitionDuration(350)
//		      ;
//
//		  d3.select('#chart svg')
//		      .datum(exampleData())
//		      .call(chart);
//
//		  nv.utils.windowResize(chart.update);
//
//		  return chart;
//		});
//	
	$("#"+chart_tag + " svg").empty();
	nv.addGraph(function() {
		var chart = nv.models.discreteBarChart()
			.x(function(d) { return d.name })
		    .y(function(d) { return d.value })
			.staggerLabels(true)    //Too many bars and not enough room? Try staggering labels.
		    .tooltips(true)        //Don't show tooltips
		    .showValues(true)       //...instead, show the bar value right on top of each bar.
			;
 
			
        d3.select("#"+chart_tag + ' svg')
		.datum(exampleData(data))
		.call(chart);

		nv.utils.windowResize(chart.update);
		chartList.put(chart_tag , chart);
		
		return chart;
	});
	
	
//	$("#"+chart_tag).dxChart({
//        dataSource: data, 
//        series: {
//            argumentField: "name",
//            valueField: "value",
//            type: "bar",
//            color: '#87ceeb'
//        },
//		 
//	     size: {
//				height: 160,
//				width: $("#tab_container").width()
//		},
//
//		valueAxis: {
//            showZero: false
//        },
//        legend: {
//            visible: false
//        },
//        tooltip: {
//            enabled: true
//        }
//    });
}