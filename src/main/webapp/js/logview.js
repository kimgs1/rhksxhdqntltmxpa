var logGridList;
var lv_deptList = [];
var lv_eqgList = [];
var lv_sensorList = [];

var log_lastSelection;
var log_setting_update_data = [];

$(function() {
	$('#log_datepickerFrom,#log_datepickerTo').val($.datepicker.formatDate($.datepicker.ATOM, new Date()));
	$('#log_datepickerFrom,#log_datepickerTo').datepicker({
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		changeYear : true,
		changeMonth : true,
		changeDay : true,
		dateFormat : 'yy-mm-dd',
		onClose : function(dateText, inst) {
			var day = $("#ui-datepicker-div .ui-datepicker-day :selected").val();
			var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
			var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
			$('#startDate').datepicker({defaultDate : -30});
			$('#endDate').datepicker({defaultDate : new Date()});
		}
	});

	//----------------------------------------------------------------------------------------------------------------------

	lv_grid_load();

	//------------------------------------------------------------------------------------------------------------------

	$('#logChart').dxChart({ 
		dataSource : [], 
		valueAxis : {
			tickInterval: 0.1,
			min : 0.0,
			max : 1.0,
			strips: [ { startValue: 0.2, endValue: 0.4, color: '#F1F3F7' }, { startValue: 0.6, endValue: 0.8, color: '#F1F3F7' } ]
		},
		argumentAxis: { title : "time" },
		legend : { visible : false },
	}).dxChart("instance").render();

	//------------------------------------------------------------------------------------------------------------------

	$('#log_research').click(function(){

		var h1 = $('#log_h1').val();   var check_h1 = new Number(h1);
		var m1 = $('#log_m1').val();   var check_m1 = new Number(m1);
		var h2 = $('#log_h2').val();   var check_h2 = new Number(h2);
		var m2 = $('#log_m2').val();   var check_m2 = new Number(m2);

		var from = $('#log_datepickerFrom').val();
		var to   = $('#log_datepickerTo').val();

		var year1  = from.split('-')[0];
		var month1 = from.split('-')[1];
		var day1   = from.split('-')[2];

		var year2  = to.split('-')[0];
		var month2 = to.split('-')[1];
		var day2   = to.split('-')[2];

		var date1 = new Date(year1,month1-1,day1,h1,m1);
		var date2 = new Date(year2,month2-1,day2,h2,m2);

		if(!isNaN(check_h1) && !isNaN(check_m1) && !isNaN(check_h2) && !isNaN(check_m2) && 
				h1.indexOf('.')<0 && m1.indexOf('.')<0 && h2.indexOf('.')<0 && m2.indexOf('.')<0 &&
				h1.length==2 && m1.length==2 && h2.length==2 && m2.length==2 &&
				0<=check_h1 && check_h1<=23 && 0<=check_m1 && check_m1<=59 && 0<=check_h2 && check_h2<=23 && 0<=check_m2 && check_m2<=59){
			if(date2-date1 > 0 && date2-date1 <= 30*24*60*60*1000){
				$('#lv_researchModal').modal({
					backdrop: 'static',
					keyboard: false
				});

				$.ajax({
					type :'post',
					url : "logview.do",
					data : "command=logGridResearch&&" +
					"datepickerFrom="+from+"&&h1="+h1+"&&m1="+m1+
					"&&datepickerTo="+to+"&&h2="+h2+"&&m2="+m2,
					dataType : 'json',
					success : function(data) {
						$('#lv_researchModal').modal('hide');
						logGridList = [];
						logGridList = data.rlogGridList;
						lv_grid_show(logGridList);
					},
					error:function(request,status,error){
						$('#lv_researchModal').modal('hide');
						alert("검색 실패");
					}
				});
			}
			else{
				alert("한달 주기의 검색만 가능합니다.");
			}
		}
		else{
			alert("검색 시간을 정확히 입력후 다시 시도해주세요.");
		}
	});

	$('#lv_cond_search_init_btn').click(function(){ 
		lv_grid_show(logGridList);
	});

	$('#lv_cond_search_modal_btn').click(function(){ 
		lv_cond_search_init();
		$('#lv_cond_search_modal').modal();
	});

	$('#lv_saveExcel').click(function(){ 

		$('#lv_excel_modal').modal({
			backdrop: 'static',
			keyboard: false
		});

		$.ajax({
			url : 'logview.do',
			type : 'post',
			dataType : 'json',
			data : 'command=lv_saveExcel&&data=' + JSON.stringify($('#logGrid').jqGrid('getRowData')),
			success : function(data) {
				$('#lv_excel_modal').modal('hide');
				var url='upload/' + data.fileName;
				var a = document.createElement('a'),
				ev = document.createEvent("MouseEvents");
				a.href = url;
				a.download = url.slice(url.lastIndexOf('/')+1);
				ev.initMouseEvent("click", true, false, self, 0, 0, 0, 0, 0,false, false, false, false, 0, null);
				a.dispatchEvent(ev);
				lv_excel_remove(data.fileName);
			},
			error : function() {
			}
		});
	});
	
	//------------------------------------------------------------------------------------------------------------------
	
	$('#log_setting_update_btn').click(function(){ 
		var ret = confirm('사용자가 수정한 설정 값을 저장하시겠습니까?');
		if (ret) {
			$.ajax({
				url : 'logview.do',
				type : 'post',
				dataType : 'json',
				data : 'command=log_setting_update&&data=' + JSON.stringify(log_setting_update_data),
				success : function(data) {
					lv_grid_load();
					log_setting_update_data = [];
					alert("사용자가 수정한 값을 성공적으로 저장하였습니다.");
				},
				error : function() {
					alert("설정 저장 실패");
				}
			});
		}
	});
});

function lv_grid_load() {
	$.ajax({
		type:'post',
		url:"logview.do",
		data:"command=logGrid",
		dataType:'json', 

		success:function(data){
			logGridList = [];
			logGridList = data.logGridList;
			lv_grid_show(logGridList);
		},
		error:function(request,status,error){
			alert("그리드 로딩 실패");
		}
	});
}

function lv_excel_remove(fileName) {

	$.ajax({
		url : 'logview.do',
		type : 'post',
		dataType : 'json',
		data : 'command=lv_excel_remove&&fileName=' + fileName,
		success : function(data) {
		},
		error : function() {
		}
	});
}

function lv_grid_cond_search() {

	var depts = [];
	var eqgs = [];
	var sensors = [];
	var eqps = $('#lv_cond_search_eqps').val();

	var condData = [];

	for (var i = 0; i < lv_deptList.length; i++) {
		if ($('#lv_dept' + i + '_chk_dept').prop('checked')) {
			depts.push(lv_deptList[i].deptname);
		}
	}

	for (var i = 0; i < lv_eqgList.length; i++) {
		if ($('#lv_eqg' + i + '_chk_eqg').prop('checked')) {
			eqgs.push(lv_eqgList[i].eqgname);
		}
	}

	for (var i = 0; i < lv_sensorList.length; i++) {
		if ($('#lv_sensor' + i + '_chk_sensor').prop('checked')) {
			sensors.push(lv_sensorList[i].sensor);
		}
	}

	var deptflag = false;
	var eqgflag = false;
	var sensorflag = false;
	var eqpflag = false;

	if (depts.length > 0) deptflag = true;
	if (eqgs.length > 0) eqgflag = true;
	if (sensors.length > 0) sensorflag = true;
	if (eqps.length > 0) eqpflag = true;

	for (var i = 0; i < logGridList.length; i++) {

		var flag = true;

		if (flag && deptflag) {

			var tmpFlag = false;

			for (var j = 0; j < depts.length; j++) {
				if (depts[j] == logGridList[i].deptname) {
					tmpFlag = true;
					break;
				}
			}

			if (!tmpFlag) flag = false;
		}

		if (flag && eqgflag) {
			var tmpFlag = false;

			for (var j = 0; j < eqgs.length; j++) {

				if (eqgs[j] == logGridList[i].eqgname) {
					tmpFlag = true;
					break;
				}
			}

			if (!tmpFlag) flag = false;
		}

		if (flag && sensorflag) {
			var tmpFlag = false;

			for (var j = 0; j < sensors.length; j++) {
				if (sensors[j] == logGridList[i].sensor) {
					tmpFlag = true;
					break;
				}
			}

			if (!tmpFlag) flag = false;
		}

		if (flag && eqpflag) {
			if (logGridList[i].eqname.indexOf(eqps) < 0) flag = false;
		}

		if (flag) condData.push(logGridList[i]);

	}

	lv_grid_show(condData);
	$('#lv_cond_search_modal').modal('hide');
}

function lv_cond_search_init() {

	$('#lv_cond_search_dept').empty();
	$('#lv_cond_search_eqg').empty();
	$('#lv_cond_search_sensor').empty();

	for (var i = 0; i < lv_deptList.length; i++) {
		$('#lv_cond_search_dept').append('<label class="control-label" style="margin-right: 15px"><input type="checkbox" id="lv_dept' + i + '_chk_dept"> ' + lv_deptList[i].deptname + '</label>');
	}

	for (var i = 0; i < lv_eqgList.length; i++) {
		$('#lv_cond_search_eqg').append('<label class="control-label" style="margin-right: 15px"><input type="checkbox" id="lv_eqg' + i + '_chk_eqg"> ' + lv_eqgList[i].eqgname + '</label>');
	}

	for (var i = 0; i < lv_sensorList.length; i++) {
		$('#lv_cond_search_sensor').append('<label class="control-label" style="margin-right: 15px"><input type="checkbox" id="lv_sensor' + i + '_chk_sensor"> ' + lv_sensorList[i].sensor + '</label>');
	}
}

function lv_grid_show(lv_grid_data) {

	var lg_tree_height = window.innerHeight - 580;
	if (lg_tree_height < 240) lg_tree_height = 240;

	$('#log_grid_div').empty();
	$('#log_grid_div').append('<table id="logGrid"></table>');

	lv_deptList = [];
	lv_eqgList = [];
	lv_sensorList = [];
	lv_specList = [];

	var dept_select = ':All', eqg_select = ':All', sensor_select = ':All', spec_select = ':All';

	for (var i = 0; i < logGridList.length; i++) {

		var exist = false;
		for (var j = 0; j < lv_deptList.length; j++) { if (logGridList[i].deptname == lv_deptList[j].deptname) { exist = true; break; }} 
		if (!exist) {
			lv_deptList.push(logGridList[i]);
			dept_select += ';' + logGridList[i].deptname + ':' + logGridList[i].deptname;
		}

		exist = false;
		for (var j = 0; j < lv_eqgList.length; j++) { if (logGridList[i].eqgname == lv_eqgList[j].eqgname) { exist = true; break; }}
		if (!exist) {
			lv_eqgList.push(logGridList[i]);
			eqg_select += ';' + logGridList[i].eqgname + ':' + logGridList[i].eqgname;
		}

		exist = false;
		for (var j = 0; j < lv_sensorList.length; j++) { if (logGridList[i].sensor == lv_sensorList[j].sensor) { exist = true; break; }} 
		if (!exist) {
			lv_sensorList.push(logGridList[i]);
			sensor_select += ';' + logGridList[i].sensor + ':' + logGridList[i].sensor;
		}
		
		exist = false;
		for (var j = 0; j < lv_specList.length; j++) { if (logGridList[i].log == lv_specList[j].log) { exist = true; break; }} 
		if (!exist) {
			lv_specList.push(logGridList[i]);
			spec_select += ';' + logGridList[i].log + ':' + logGridList[i].log;
		}
	}

	$('#logGrid').jqGrid({
		datastr : lv_grid_data,
		datatype : "jsonstring",
		colModel: [
		           {label : "시간", name: 'dbtime', sorttype: 'date', width: '15%', align: 'center', searchoptions: {sopt:['cn']}}, 
		           {label : "생산부서", name: 'deptname', sorttype: 'string', width: '8%', align: 'center', stype: 'select', searchoptions: { sopt:['eq'], value: dept_select }},
		           {label : "설비그룹", name: 'eqgname', sorttype: 'string', width: '8%', align: 'center', stype: 'select', searchoptions: { sopt:['eq'], value: eqg_select }},
		           {label : "파라미터", name: 'sensor', sorttype: 'string', width: '8%', align: 'center', stype: 'select', searchoptions: { sopt:['eq'], value: sensor_select }},
		           {label : "장비명", name: 'eqname', sorttype: 'string', width: '10%', align: 'center', searchoptions: {sopt:['cn']}},
		           {label : "상한제한", name: 'upperlimit', sorttype: 'number', width: '10%', align: 'center', searchoptions: {sopt:['gt','ge','eq','lt','le']}},
		           {label : "하한제한", name: 'lowerlimit', sorttype: 'number', width: '10%', align: 'center', searchoptions: {sopt:['lt','le','eq','gt','ge']}},
		           {label : "값", name: 'value', sorttype: 'number', width: '10%', align: 'center', searchoptions: {sopt:['lt','le','eq','gt','ge']}},
		           {label : "내용", name: 'log', width: '10%', align: 'center', stype: "select", searchoptions: { sopt:['eq'], value: spec_select }},
		           {label : "코맨트", name: 'comment', width: '11%', align: 'center', searchoptions: {sopt:['cn']},  editable: true}, 
		           {name: 'mid',hidden: true}
		          ],
		          loadonce : true,
		          autowidth : true,
		          shrinkToFit : true,
		          height: lg_tree_height, 
		          rowNum: 1000,
		          altRows: true,
		          altclass : 'altRowClass',
		          ondblClickRow: function(rowid) {
		        	 drawLogChart(rowid);
		          },
		          onSelectRow : function(id) {
		        	  if (id && id !== log_lastSelection) {
		        		  var grid = $("#logGrid");
		        		  grid.jqGrid('restoreRow',log_lastSelection);
		                  log_lastSelection = id;
		                  
		                  grid.jqGrid('editRow', id, {
		                	  keys: true,
		  					  url: 'clientArray',
		  					  aftersavefunc : function(rowid) {		  
		  						  var des = grid.jqGrid('getRowData', rowid);
		  						  var comment = des.comment;
		  						  grid.jqGrid('setCell', rowid, 'comment', comment);
		  						  
		  						  des = [];
		  						  des = grid.jqGrid('getRowData', rowid);
		  						  log_setting_update_data.push(des);
		  						  grid.jqGrid('setRowData', rowid, false, {'background' : '#CEF279'});
		  					  }
		  				});
		              }
		          },
	}); 

	$('#logGrid').jqGrid("filterToolbar", {searchOnEnter: false, searchOperators: true});
}

function drawLogChart(rowid) {
	var rowData = $("#logGrid").jqGrid('getRowData', rowid);
	$.ajax({
		type :'post',
		url : "logview.do",
		data : "command=drawLogChart&&mid="+rowData.mid+"&&dbtime="+rowData.dbtime,
		dataType : 'json',
		success : function(data) {
			var min=rowData.lowerlimit*1.0,max=rowData.upperlimit*1.0;
			$.each(data.logChartList, function(i, val) {
				if(val.value>max) max=val.value;
				if(val.value<min) min=val.value;
			});
			
			var minValue = calculate_min_scale(min,max);
			var maxValue = calculate_max_scale(min,max);

			$("#logChart").dxChart({
				dataSource : data.logChartList,
				commonSeriesSettings : {
					argumentField : "arg",
					point : { visible : false } 
				},
				argumentAxis: {
					title : false,
					constantLines: [{
						value: rowData.dbtime,
						color: 'rosybrown',
						dashStyle: 'Dash',
						width: 1,
						label: { position: 'outside', text: 'now', font: { color: 'rosybrown', size: 14 } }
					}]
				},
				valueAxis : [{
					name : "valueAxis",
					position : "left",
					visible : true,
					min : minValue,
					max : maxValue,
					constantLines: [
					                {
					                	value: rowData.upperlimit,
					                	color: '#FF0000',
					                	dashStyle: 'solid',
					                	width: 1,
					                	label: { position: 'inside', text: 'upperlimit(' + rowData.upperlimit + ')', font: { color: '#FF0000', size: 14 } }
					                },
					                {
					                	value: rowData.lowerlimit,
					                	color: '#6E0088',
					                	dashStyle: 'solid',
					                	width: 1,
					                	label: { position: 'inside', text: 'lowerlimit(' + rowData.lowerlimit + ')', font: { color: '#6E0088', size: 14 } }
					                }
					                ],
					                label : {
					                	customizeText : function() {
					                		if(rowData.sensor=="진공도(Torr)"){
					                		var value = this.value.toExponential(3);
					                		return value;
					                		}
					                		else return this.value;
					                	}
					                }
				}], 
				series : {
					valueField : "value", 
					name: rowData.eqname,
					axis : 'valueAxis'
				},
				scrollBar : { visible : false },
				scrollingMode : "all",
				zoomingMode : "all",
				legend : {
					visible : true,
					columnCount: 3,
					verticalAlignment: 'top',
					horizontalAlignment: 'center',
					itemTextPosition: "right" 
				},
				tooltip : {
					enabled : true,
					customizeTooltip : function(point) { return { text: point.seriesName + "  :  " + point.valueText }; }
				},
				crosshair : {
					enabled : true,
					color : "#949494",
					width : 3,
					dashStyle : "dot",
					label : { visible : true, backgroundColor : "#949494", font : { color : "#fff", size : 12 } }
				},
				animation : { enabled : false }
			}).dxChart("instance").render();
		},
		error:function(request,status,error){
			alert("차트 로드 실패");
		}
	});
}

function initLogTimeTxt(id){
	$(id).val('');
}