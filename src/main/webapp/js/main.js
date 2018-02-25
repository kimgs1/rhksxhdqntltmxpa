function getCookie(key) {
    var cookieArr = document.cookie.split('; ');
    for(var i = 0; i < cookieArr.length; i++) {
        var arr = cookieArr[i].split('=');
        if(arr[0] === key) {
            return arr[1];
        }
    }
    return false;
}


function imgBig(obj){
	var pos = obj.value.lastIndexOf("\\")*1;
	window.open("./DownLoadImg/" + obj.value.substring(pos+1));
}









var ucdv = false;
var rtdv = false;
var rcdv = false;
var lvdv = false;
var esdv = false;
var mdsdv = false;
var spcdv = false;
var codv = false;
var andv = false;
var asdv = false;
var ansdv = false;
var anldv = false;
var userid;
var userlevel;

var realtimeTimer;
var realtimeTimerUsed = false;

var spcTimer;
var isSPCTimerUse = false;

var esTimer;
var equipmentStateInfo=[];

$(function() {
	$(window).resize(function(){
		pageResizeAll();
	});

	$.ajax({
		url : 'main.do',
		type : 'post',
		dataType : 'json',
		data : 'command=user_info_load',
		success : function(data) {
			userid = data.userinfo.id;
			userlevel = data.userinfo.userlevel;
			var username = data.userinfo.username;
			if (userlevel == 0) username += '(관리자)';
			else if (userlevel == 1) username += '(품질관리자)';
			else username += '(사용자)';
			$('#username_label').text(username);
		},
		error : function() {
			alert("사용자 정보 로드 실패");
		}
	});
	
	// 장비상태 체크
	var esTimer = setInterval(checkEquipmentStates, 3000);
	//

	$('#sidebar_toggle_btn').click(function() {
		pageResizeAll();
	});

	$('#uc_btn').click(function() {
		mainHideAll();
		var page = $('#mainUserconfigDiv');
		if (!ucdv) { page.load('views/userconfig.jsp'); ucdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#uc_btn'));
		$('#pagename_label').text('설정');
	});

	$('#rt_btn').click(function() {
		mainHideAll();
		var page = $('#mainRealtimeDiv');
		if (!rtdv) { page.load('views/realtime.jsp'); rtdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#rt_btn'));
		$('#pagename_label').text('실시간모니터링');

		if (realtimeTimerUsed) startMonitoring();
	});

	$('#rc_btn').click(function() {
		mainHideAll();
		var page = $('#mainRecordcheckDiv');
		if (!rcdv) { page.load('views/recordcheck.jsp'); rcdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#rc_btn'));
		$('#pagename_label').text('이력조회');
	});

	$('#lv_btn').click(function() {
		mainHideAll();
		var page = $('#mainLogviewDiv');
		if (!lvdv) { page.load('views/logview.jsp'); lvdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#lv_btn'));
		$('#pagename_label').text('로그뷰어');
	});
	
	$('#es_btn').click(function() {
		mainHideAll();
		var page = $('#mainEquipmentStateDiv');
		if (!esdv) { page.load('views/equipmentstate.jsp'); esdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#es_btn'));
		$('#pagename_label').text('장비상태');
	});
	
	$('#mds_btn').click(function(){
		mainHideAll();
		var page = $('#mainMdsDiv');
		if (!mdsdv) { page.load('views/mds.jsp'); mdsdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#mds_btn'));
		$('#pagename_label').text('Multi Viewer');
	});
	
	$('#spc_btn').click(function() {
		mainHideAll();
		var page = $('#mainSpcDiv');
		if (!spcdv) { page.load('views/spc.jsp'); spcdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#spc_btn'));
		$('#pagename_label').text('SPC7 Rules');
		
		if (isSPCTimerUse) spcTimer = setInterval(spcChartLoad, tick);
	});
	
	$('#co_btn').click(function() {
		mainHideAll();
		var page = $('#mainCorrelationDiv');
		if (!codv) { page.load('views/correlation.jsp'); codv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#co_btn'));
		$('#pagename_label').text('상관분석');
	});
	
	$('#an_btn').click(function() {
		mainHideAll();
		var page = $('#mainAnovaDiv');
		if (!andv) { page.load('views/anova.jsp'); andv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#an_btn'));
		$('#pagename_label').text('그룹분석');
	});
	
	$('#as_btn').click(function() {
		mainHideAll();
		var page = $('#mainAssociationDiv');
		if (!asdv) { page.load('views/association.jsp'); asdv = true; }
		page.show();
		pageResizeAll();
		changeSelectColor($('#as_btn'));
		$('#pagename_label').text('연관규칙분석');
	});
	
	$('#anm_btn').click(function() {
		changeSelectColor($('#anm_btn'));
	});
	
	$('#anm_set_btn,#anm_log_btn').click(function() {
		var btn_id=$(this).context.id;
		
		mainHideAll();
		var page = $('#mainAnomalyDiv');
		if(btn_id=="anm_set_btn"){
			if(!ansdv) { page.load('views/anm_set.jsp'); ansdv = true; anldv = false; }
		}
		else{
			if(!anldv) { page.load('views/anm_log.jsp'); anldv = true; ansdv = false; }
		}
		page.show();
		pageResizeAll();
		$('#pagename_label').text('이상패턴분석');
	});
	
	$('#uc_reload_btn').click(function() {
		$('#mainUserconfigDiv').empty();
		ucdv = false;
	});

	$('#rt_reload_btn').click(function() {
		realtimeTimerUsed = false;
		clearInterval(realtimeTimer);
		$('#mainRealtimeDiv').empty();
		rtdv = false;
	});

	$('#rc_reload_btn').click(function() {
		$('#mainRecordcheckDiv').empty();
		rcdv = false;
	});

	$('#lv_reload_btn').click(function() {
		$('#mainLogviewDiv').empty();
		lvdv = false;
	});
	
	$('#es_reload_btn').click(function() {
		$('#mainEquipmentStateDiv').empty();
		esdv = false;
	});
	
	$('#mds_reload_btn').click(function() {
		$('#mainMdsDiv').empty();
		mdsdv = false;
	});
	
	$('#spc_reload_btn').click(function() {
		isSPCTimerUse = false;
		clearInterval(spcTimer);
		$('#mainSpcDiv').empty();
		spcdv = false;
	});
	
	$('#co_reload_btn').click(function() {
		$('#mainCorrelationDiv').empty();
		codv = false;
	});

	$('#an_reload_btn').click(function() {
		$('#mainAnovaDiv').empty();
		andv = false;
	});
	
	$('#as_reload_btn').click(function() {
		$('#mainAssociationDiv').empty();
		asdv = false;
	});
	
	$('#anm_reload_btn').click(function() {
		$('#mainAnomalyDiv').empty();
		ansdv = false;
		anldv = false;
	});
	
	$('#help_btn').click(function() {
		window.open("views/help.html", "도움말", "fullscreen, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	});

	$('#logout_btn').click(function() {
		location.href = "main.do?command=logout";
	});

	$('#uc_btn').click();
});

function pageResizeAll() {
	setTimeout( function(){
		if (ucdv) {
			var uc_tree_height;
			if (userlevel == 2) uc_tree_height = window.innerHeight - 142;
			else uc_tree_height = window.innerHeight - 190;

			if (uc_tree_height < 400) uc_tree_height = 400;
			$('#uc_tree_table').setGridHeight(uc_tree_height);
			$('#uc_tree_table').setGridWidth($('#uc_tree_div').width());
			$('#uc_vp_tree_table').setGridWidth($('#uc_vp_tree_div').width());
			$('#uc_vm_tree_X_table').setGridWidth($('#uc_vm_tree_X_div').width());
			$('#uc_vm_tree_Y_table').setGridWidth($('#uc_vm_tree_Y_div').width());
			$('#uc_vm_selected_grid').setGridWidth($('#uc_vm_selected_grid').width());
		}
		if (rtdv){
			var rt_tree_height = window.innerHeight - 235;
			if (rt_tree_height < 445) rt_tree_height = 445;
			setTimeout( function(){
				$('#realTimeGrid').setGridHeight(rt_tree_height);
				$('#realTimeGrid').setGridWidth($('#realTime_grid_div').width());
			}, 300);

			try {
				switch(screenNum) {
				case 1:
					$("#realTimeChart1").dxChart({ height: rt_tree_height + 59 }).dxChart("instance").render();
					break;
				case 2:
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				case 3:
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart3").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				case 4:
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart3").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart4").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				case 5: 
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart3").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart4").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart5").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				case 6: 
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart3").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart4").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart5").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart6").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				case 7: 
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart3").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart4").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart5").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart6").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart7").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				case 8: 
					$("#realTimeChart1").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart2").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart3").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart4").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart5").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart6").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart7").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					$("#realTimeChart8").dxChart({ height: (rt_tree_height + 41) / 2 }).dxChart("instance").render();
					break;
				default: 
					break;
				}
			} catch(err) {}
		}
		if (rcdv) {
			var rc_tree_height = window.innerHeight - 235;
			if (rc_tree_height < 445) rc_tree_height = 445;
			setTimeout( function(){
				$('#recordGrid').setGridHeight(rc_tree_height);
				$('#recordGrid').setGridWidth($('#record_grid_div').width());
			}, 300);
			try {
				if ($('#left_auto_check').val() == undefined){
					$("#recordChart1").dxChart({ height: (rc_tree_height+52)/2 - 12 }).dxChart("instance").render();
					$("#recordChart2").dxChart({ height: (rc_tree_height+52)/2 - 12 }).dxChart("instance").render();
				}
				else{
					$("#recordChart1").dxChart({ height: (rc_tree_height+10)/2 - 12 }).dxChart("instance").render();
					$("#recordChart2").dxChart({ height: (rc_tree_height+10)/2 - 12 }).dxChart("instance").render();
				}
			}catch(err){}
		}
		if (lvdv) {
			var lv_grid_height = window.innerHeight - 580;
			if (lv_grid_height < 240) lv_grid_height = 240;
			setTimeout( function(){
				$('#logGrid').setGridHeight(lv_grid_height);
				$('#logGrid').setGridWidth($('#log_grid_div').width());
			}, 300);
			try {
				$("#logChart").dxChart("instance").render();
			}catch(err){}
		}
		if (esdv) {
			var es_grid_height = window.innerHeight - 580;
			if (es_grid_height < 240) es_grid_height = 240;
			setTimeout( function(){
				$('#esGrid').setGridHeight(es_grid_height);
				$('#esGrid').setGridWidth($('#es_grid_div').width());
			}, 300);
		}
		if (mdsdv) {
			$('#mdsGrid').setGridWidth($('#mdsGrid_div').width());
			try{
				$("#mdsLineChart").dxChart("instance").render();
				$("#mdsHistoChart").dxChart("instance").render();
			}
			catch(err){}

			if($("#mds_sc_select_modal").hasClass('in')){
				var width = $("#mds_sc_select_modal").width()*0.8;
				$("#mds_sc_SelectChartDetail").dxChart({
					size:{
						height: 300,
						width: width
					}
				});

				var width = $("#mds_sc_select_modal").width()*0.85;
				$("#mds_sc_SelectChart").dxRangeSelector({
					size:{
						height: 200,
						width: width
					}
				});
			}
		}
		if (spcdv) {
			setTimeout( function(){
				$('#spcTreeGrid').setGridWidth($('#spc_treeGrid_div').width());
				$('#spcIGrid').setGridWidth($('#spc_IGrid_Div').width()); 
				$('#spcMRGrid').setGridWidth($('#spc_MRGrid_Div').width());
			}, 300);
			try {
			}catch(err){}
		}
		if(codv){
			if ($('#corrTabUl').find('.active').attr('id')=='corrUl1') {
				$('#corrTab1').show();
				$('#corrTab2').hide();
				$('#corrTab3').hide();
				$('#corrTree').setGridWidth($('#corrTreeDiv').width());
				$('#corrLGrid').setGridWidth($('#corrLGridDiv').width());
				$('#corrRGrid').setGridWidth($('#corrRGridDiv').width());
				try{
					$('#corrLChart').dxChart("instance").render();
					$('#corrRChart').dxChart("instance").render();
				}
				catch(err){}	
			} else if ($('#corrTabUl').find('.active').attr('id')=='corrUl2') {
				$('#corrTab1').hide();
				$('#corrTab2').show();
				$('#corrTab3').hide();
				$('#corrMatrix').setGridWidth($('#corrMatrixDiv').width());
			} else if ($('#corrTabUl').find('.active').attr('id')=='corrUl3') {
				$('#corrTab1').hide();
				$('#corrTab2').hide();
				$('#corrTab3').show();
				$('#corrApTree').setGridWidth($('#corrApTreeDiv').width());
				$('#corrApChart').dxChart({
					size: {
						width: $("#corrApChartDiv").width(),
					}
				});
				
				if($("#corrAp_section_select_modal").hasClass('in')){
					$("#corrAp_SelectChartDetail").dxChart({
						size:{
							height: 300,
							width:$("#corrAp_SelectChartDetail_Div").width()
						}
					});

					$("#corrAp_SelectChart").dxRangeSelector({
						size:{
							height: 180,
							width:$("#corrAp_SelectChart_Div").width()
						}
					});
				}
			}
		}
		if(andv){
			var an_tree_height = window.innerHeight - 235;
			if (an_tree_height < 445)an_tree_height = 445;
			an_tree_height = 780;
			$('#EquipGridDiv_table').jqGrid('setColProp','name',{fixed:false});
			$('#EquipGridDiv_table').setGridHeight(an_tree_height);
			$('#EquipGridDiv_table').setGridWidth($('#EquipGridDiv').width());
			
			$("#an_detailInfo_grid").setGridWidth($('#an_detailInfo_grid_div').width());
			$('#anovaGrid').setGridWidth($('#anovaGrid_div').width());
			
			try{
				if($("#section_select_modal").hasClass('in')){
					var width = $("#section_select_modal").width()*0.8;
					$("#anovaSelectChartDetail").dxChart({
						size:{
							height: 300,
							width: width
						}
					});

					var width = $("#section_select_modal").width()*0.85;
					$("#anovaSelectChart").dxRangeSelector({
						size:{
							height: 200,
							width: width
						}
					});
				}
			}
			catch(err){}
		}
		if (asdv) {
			$('#as_err_grid').setGridWidth($('#as_err_grid_div').width());
			$('#ac_pre_grid').setGridWidth($('#ac_pre_grid_div').width());
			$('#ac_post_grid').setGridWidth($('#ac_post_grid_div').width());

			try{
				$('#ac_chart_0').dxChart("instance").render();
				$('#ac_chart_1').dxChart("instance").render();
				$('#ac_chart_2').dxChart("instance").render();
			}
			catch(err){}
		}
		if (ansdv) {
			
		}
		if (anldv) {
			
		}
	}, 300);
}

function mainHideAll() {
	clearInterval(realtimeTimer);
	clearInterval(spcTimer);

	$('#mainUserconfigDiv').hide();
	$('#mainRealtimeDiv').hide();
	$('#mainRecordcheckDiv').hide();
	$('#mainLogviewDiv').hide();
	$('#mainEquipmentStateDiv').hide();
	$('#mainMdsDiv').hide();
	$('#mainSpcDiv').hide();
	$('#mainCorrelationDiv').hide();
	$('#mainAnovaDiv').hide();
	$('#mainAssociationDiv').hide();
	$('#mainAnomalyDiv').hide();
}

function changeSelectColor(btn) {
	$('#uc_btn').css('background-color','#F9FAFC');
	$('#rt_btn').css('background-color','#F9FAFC');
	$('#rc_btn').css('background-color','#F9FAFC');
	$('#lv_btn').css('background-color','#F9FAFC');
	$('#es_btn').css('background-color','#F9FAFC');
	$('#mds_btn').css('background-color','#F9FAFC');
	$('#spc_btn').css('background-color','#F9FAFC');
	$('#co_btn').css('background-color','#F9FAFC');
	$('#an_btn').css('background-color','#F9FAFC');
	$('#as_btn').css('background-color','#F9FAFC');
	$('#anm_btn').css('background-color','#F9FAFC');

	btn.css('background-color','#ECF0F5');
}

function checkEquipmentStates() {
	$.ajax({ 
		url : 'share.do',
		type : 'post',
		dataType : 'json',
		data : 'command=checkEquipmentStates',

		success : function(data) {
			var refresh = false;
			
			var num1=num2=0; // pre next 에러수
			$.each(equipmentStateInfo, function(i, val) {
				if(val.state==0) num1++;
			});
			$.each(data.equipmentStateInfo, function(i, val) {
				if(val.state==0) num2++;
			});
				
			if(equipmentStateInfo.length==data.equipmentStateInfo.length && num1==num2){
				for(i=0;i<equipmentStateInfo.length;i++){
					if(equipmentStateInfo[i].state==0){
						if(equipmentStateInfo[i].eqname==data.equipmentStateInfo[i].eqname){}
						else{refresh = true; break;}
					}
				}
			}
			else{refresh = true;}
			
			equipmentStateInfo = data.equipmentStateInfo;
			
			if(num2==0){
				$('#equipmentStateCheck').attr('style','color: #444444');
				if(esdv && refresh){es_grid_show(equipmentStateInfo);}
			}
			else{
				$('#equipmentStateCheck').attr('style','color: #FF0000');
				if(esdv && refresh){es_grid_show(equipmentStateInfo);}
			}
		},
		error : function(data) {
			alert("장비 상태 확인 실패");
		}
	});
}

function calculate_min_scale(min,max) {
	if(max-min==0) min-=1;
	else min=min-(max-min)*0.1;
	return min;
}

function calculate_max_scale(min,max) {
	if(max-min==0) max+=1;
	else max=max+(max-min)*0.1;
	return max;
}


//사용도구 모음 
function removeLastChar(val){
	if(val.length == 0){
		return val;
	}else{
		return val.substring(0,val.length-1);
	}
}

function toInt(number) {
  return number && + number | 0 || 0;
}

function DateAdd(interval,number,date){ 
	switch(interval.toLowerCase()){ 
	case "y": return new Date(date.setFullYear(date.getFullYear()+number)); 
	case "M": return new Date(date.setMonth(date.getMonth()+number)); 
	case "d": return new Date(date.setDate(date.getDate()+number)); 
	case "w": return new Date(date.setDate(date.getDate()+7*number)); 
	case "h": return new Date(date.setHours(date.getHours()+number)); 
	case "m": return new Date(date.setMinutes(date.getMinutes()+number)); 
	case "s": return new Date(date.setSeconds(date.getSeconds()+number)); 
	case "l": return new Date(date.setMilliseconds(date.getMilliseconds()+number)); 
	} 
} 

function DateDiff(interval,date1,date2){ 
	var long = date2.getTime() - date1.getTime();  
	switch(interval.toLowerCase()){ 
	case "y": return parseInt(date2.getFullYear() - date1.getFullYear()); 
	case "M": return parseInt((date2.getFullYear() - date1.getFullYear())*12 + (date2.getMonth()-date1.getMonth())); 
	case "d": return parseInt(long/1000/60/60/24); 
	case "w": return parseInt(long/1000/60/60/24/7); 
	case "h": return parseInt(long/1000/60/60); 
	case "m": return parseInt(long/1000/60); 
	case "s": return parseInt(long/1000); 
	case "l": return parseInt(long); 
	} 
} 

Date.prototype.Format = function(fmt)   
{   
	var o = {   
			"M+" : this.getMonth()+1,                 //   
			"d+" : this.getDate(),                    //  
			"h+" : this.getHours(),                   //   
			"m+" : this.getMinutes(),                 //  
			"s+" : this.getSeconds(),                 //   
			"S"  : this.getMilliseconds()             //  
	};   
	if(/(y+)/.test(fmt))   
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	for(var k in o)   
		if(new RegExp("("+ k +")").test(fmt))   
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	return fmt;   
} 

function HashMap() {  
  var size = 0;  
  var entry = new Object();  
    
  this.put = function (key, value) {  
      entry[key] = value;  
      size++;  
  };  
    
  this.putAll = function (map) {  
      if (typeof map == "object" && !map.sort) {  
          for (var key in map) {  
              this.put(key, map[key]);  
          }  
      } else {  
          throw "입력이 정확하지 않습니다. 입력데이터는 무조건 HashMap타입이 되어야 합니다.";  
      }  
  };  
    
  this.get = function (key) {  
      return entry[key];  
  };  
    
  this.remove = function (key) {  
      if (size == 0)  
          return;  
      delete entry[key];  
      size--;  
  };  
    
  this.containsKey = function (key) {  
      if (entry[key]) {  
          return true;  
      }  
      return false;  
  };  
    
  this.containsValue = function (value) {  
      for (var key in entry) {  
          if (entry[key] == value) {  
              return true;  
          }  
      }  
      return false;  
  };  
    
  this.clear = function () {  
      entry = new Object();  
      size = 0;  
  };  
    
  this.isEmpty = function () {  
      return size == 0;  
  };  
    
  this.size = function () {  
      return size;  
  };  
    
  this.keySet = function () {  
      var keys = new Array();  
      for (var key in entry) {  
          keys.push(key);  
      }  
      return keys;  
  };  
    
  this.entrySet = function () {  
      var entrys = new Array();  
      for (var key in entry) {  
          var et = new Object();  
          et[key] = entry[key];  
          entrys.push(et);  
      }  
      return entrys;  
  };  
    
  this.values = function () {  
      var values = new Array();  
      for (var key in entry) {  
          values.push(entry[key]);  
      }  
      return values;  
  };  
    
  this.each = function (cb) {  
      for (var key in entry) {  
          cb.call(this, key, entry[key]);  
      }  
  };  
    
  this.toString = function () {  
      return obj2str(entry);  
  };  
    
  function obj2str(o) {  
      var r = [];  
      if (typeof o == "string")  
          return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";  
      if (typeof o == "object") {  
          for (var i in o)  
              r.push("\"" + i + "\":" + obj2str(o[i]));  
          if (!!document.all && !/^\n?function\s*toString\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {  
              r.push("toString:" + o.toString.toString());  
          }  
          r = "{" + r.join() + "}";  
          return r;  
      }  
      return o.toString();  
  }  
}  