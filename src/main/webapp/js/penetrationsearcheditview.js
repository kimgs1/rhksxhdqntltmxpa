
$(document).ready(function(){ 
//	getBaseCodeInfo();
//
//	tagBind("selectBox", "PenetrationForm","","${PenetrationForm}",codeAllInfo.A04);
	
});
$(function(){
	init();
})


function init(){
	
	
	
//	getBaseCodeInfo();
}
function getBaseCodeInfo(){
	getCodeAllInfo();
//	tagBind("radio", "FirewallYN","방화벽여부",null,codeAllInfo.A09);
//	tagBind("radio", "PenetrationForm","관통부형태",null,codeAllInfo.A02);
	var aa = "${PenetrationForm}";
	tagBind("selectBox", "PenetrationForm","","${PenetrationForm}",codeAllInfo.A04);
	
}

function SealMeterialAdd(){
	var value = document.getElementById("SealMeterial_name").value;
	if(value==''){
		value += $("#SealMeterial option:selected").text();
	}else{
		value += ','+$("#SealMeterial option:selected").text();
	}
	document.getElementById("SealMeterial_name").value = value;
}

function savePenetrationAllInfo(){
	if($("#Elevation_num_pit").val() == "" ||$("#Elevation_num_inc").val() == ""  ){
		alert("Elevation 값을 입력하여 주세요 ");
		return;
	}
	if($("#Diameter_num_pit").val() == "" ||$("#Diameter_num_inc").val() == ""  ){
		alert("관통부 직경 값을 입력하여 주세요 ");
		return;
	}
	if($("#Height_num_pit").val() == "" ||$("#Height_num_inc").val() == ""  ){
		alert("관통부 가로 값을 입력하여 주세요 ");
		return;
	}
	if($("#Length_num_pit").val() == "" ||$("#Length_num_inc").val() == ""  ){
		alert("관통부 세로 값을 입력하여 주세요 ");
		return;
	}
	if(checkSealMeterial() == false){
		alert("밀폐재 재질정보를 잘못 입력하였습니다. 다시한번 확인하여 주시길 바라겠습니다.");
		return;
	}
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'updatePenetrationAllInfo',
			EquipNo:$("#EquipNo option:selected").val(),
			LocNo :$("#LocNo option:selected").val(),
			ManagementNo:$("#ManagementNo").val(),
			PenetrationNo :$("#PenetrationNo").val(),
			ManagementAreaYN:$("#ManagementAreaYN").val(),
			Elevation_num_pit:$("#Elevation_num_pit").val(),
			Elevation_num_inc:$("#Elevation_num_inc").val(),
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
			Diameter_num_pit:$("#Diameter_num_pit").val(),
			Diameter_num_inc:$("#Diameter_num_inc").val(),
			Height_num_pit:$("#Height_num_pit").val(),
			Height_num_inc:$("#Height_num_inc").val(),
			Length_num_pit:$("#Length_num_pit").val(),
			Length_num_inc:$("#Length_num_inc").val(),
			PenetrationType:$("#PenetrationType").val(),
			MaximumFreeArea:$("#MaximumFreeArea").val(),
			MaximumFreeDistance:$("#MaximumFreeDistance").val(),
			Register:$("#Register").val(),
			Reviewer:$("#Reviewer").val(),
			Checker:$("#Checker").val(),
			SpecialNote:$("#SpecialNote").val(),
			SAFETY_CATEGORY : $("#SAFETY_CATEGORY").val(),
			ANCHORTYPE : $("#ANCHORTYPE").val(),
			LATERALMOVEMENT : $("#LATERALMOVEMENT").val(),
			LINETEMPERATURE : $("#LINETEMPERATURE").val(),
			VENTILATION_VALUE : $("#VENTILATION_VALUE").val(),
			VENTILATION_VALUE_RANGE : $("#VENTILATION_VALUE_RANGE").val(),
			VENTILATION_VAL_NO : $("#VENTILATION_VAL_NO").val(),
			VENTILATION_JUDGMENT : $("#VENTILATION_JUDGMENT").val(),
			VENTILATION_REASON : $("#VENTILATION_REASON").val(),
			FIRE_VALUE : $("#FIRE_VALUE").val(),
			FIRE_VALUE_RANGE : $("#FIRE_VALUE_RANGE").val(),
			FIRE_VAL_NO : $("#FIRE_VAL_NO").val(),
			FIRE_JUDGMENT : $("#FIRE_JUDGMENT").val(),
			FIRE_REASON : $("#FIRE_REASON").val(),
			RADIATION_VALUE : $("#RADIATION_VALUE").val(),
			RADIATION_VALUE_RANGE : $("#RADIATION_VALUE_RANGE").val(),
			RADIATION_VAL_NO : $("#RADIATION_VAL_NO").val(),
			RADIATION_JUDGMENT : $("#RADIATION_JUDGMENT").val(),
			RADIATION_REASON : $("#RADIATION_REASON").val(),
			FLOOD_VALUE : $("#FLOOD_VALUE").val(),
			FLOOD_VALUE_RANGE : $("#FLOOD_VALUE_RANGE").val(),
			FLOOD_VAL_NO : $("#FLOOD_VAL_NO").val(),
			FLOOD_JUDGMENT : $("#FLOOD_JUDGMENT").val(),
			FLOOD_REASON : $("#FLOOD_REASON").val(),
			PRESSURE_VALUE : $("#PRESSURE_VALUE").val(),
			PRESSURE_VALUE_RANGE : $("#PRESSURE_VALUE_RANGE").val(),
			PRESSURE_VAL_NO : $("#PRESSURE_VAL_NO").val(),
			PRESSURE_JUDGMENT : $("#PRESSURE_JUDGMENT").val(),
			PRESSURE_REASON : $("#PRESSURE_REASON").val(),

			matter:$("#matter option:selected").val() ,
			Pipe:$("#Pipe").val(),
			Duct:$("#Duct").val(),
			SectionTube:$("#SectionTube").val(),
			Conduit:$("#Conduit").val(),
			Cable:$("#Cable").val(),
			Tray:$("#Tray").val(),
			CoverTray:$("#CoverTray").val(),
			Etc:$("#Etc").val(),

			
//			RequirePerformance:$("#RequirePerformance").val(),
//			RequirePerformance:getRadioValueByTagName('RequirePerformance'),
//			EvaluationResult:$("#EvaluationResult").val(),
//			EvaluationResult:$("#EvaluationResult option:selected").val(),
//			FireResistanceRating:$("#FireResistanceRating").val(),
//			PSI:$("#PSI").val(),
//			WaterSeal:$("#WaterSeal").val(),
//			RadiationShield:$("#RadiationShield").val(),
			
			
//			ConstructionState:$("ConstructionState").val(),
//			ConstructionState:getRadioValueByTagName('ConstructionState'),
			SealSealDetailDWG:$("#SealSealDetailDWG").val(),
			SealQualityClass:$("#SealQualityClass").val(),
//			SealMeterial:$("SealMeterial").val(),
			SealMeterial_name:$("#SealMeterial_name").val(),
			SealThickness:$("#SealThickness").val(),
			PressingBoardMeterial:$("#PressingBoardMeterial").val(),
			PressingBoardThickness:$("#PressingBoardThickness").val(),
		},
		async: false,
		success : function(data) {
			var result = data.result;
			if(result.result == true){
				alert("관통부정보가 정상적으로 저장되었습니다.");
			}
			else{

				alert("관통부정보가를 저장하는데 실패하였습니다. \r\n 관리자에게 문의하시길 바라겠습니다. \r\n " + result.msg);
			}
		},
		error: function(data){

		}
	});
}

function checkSealMeterial(){
	var localResult = false;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'checkSealMeterial',
			SealMeterial_name : $("#SealMeterial_name").val()
		},
		async: false,
		success : function(data) {
			var result = data.result;
			if(result.resultFlag == 'false'){
				localResult =  false;
			}
			else{  
				localResult =  true;
			}
		},
		error: function(data){

		}
	});
	return localResult;
}




function insertInspectInfo(){
	if($("#ManagementNo").val() == ""){
		alert("관리번호를 먼저 입력하여 주시길 바랍니다.");
		return;
	}
	if($("#PenetrationNo").val() == ""){
		alert("관통부번호를 먼저 입력하여 주시길 바랍니다.");
		return;
	}
	$("#pic_ManagementNo").val($("#ManagementNo").val());
	$("#pic_PenetrationNo").val($("#PenetrationNo").val());
	$('#pic_Penetrationinspect_modal').css('z-index', 3000);
	$('#pic_Penetrationinspect_modal').modal();
}



function pic_SealantConditionStateAdd(){
	var value = document.getElementById("pic_SealantConditionState_name").value;
	if(value==''){
		value += $("#pic_SealantConditionState option:selected").text();
	}else{
		value += ','+$("#pic_SealantConditionState option:selected").text();
	}
	document.getElementById("pic_SealantConditionState_name").value = value;
}


function pic_checkSealantConditionState(){
	var localResult = false;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'checkSealantConditionState',
			SealantConditionState_name : $("#pic_SealantConditionState_name").val()
		},
		async: false,
		success : function(data) {
			var result = data.result;
			if(result.resultFlag == 'false'){
				localResult =  false;
			}
			else{  
				localResult =  true;
			}
		},
		error: function(data){

		}
	});
	return localResult;
}


function pic_updateInspectInfoSave(){
	if($("#pic_InspectSeq").val() == ""){
		alert("점검차수 정보는 필수 입력입니다.");
		return;
	}
	if(pic_checkSealantConditionState() == false){
		alert("밀폐재 시공상태 를 잘못 입력하였습니다. 다시한번 확인하여 주시길 바라겠습니다.");
		return;
	}
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'insert',
			ManagementNo:$("#pic_ManagementNo").val(),
			PenetrationNo:$("#pic_PenetrationNo").val(),
			InspectDate:$("#pic_InspectDate").val(),
			InspectSeq:$("#pic_InspectSeq").val(),
			ImproveDate:$("#pic_ImproveDate").val(),
			InspectionInterval:$("#pic_InspectionInterval").val(),
			SealantConditionState_name:$("#pic_SealantConditionState_name").val(),
			JudgementReason:$("#pic_JudgementReason").val(),
			Judgment:$("#pic_Judgment").val(),
			ImproveNote:$("#pic_ImproveNote").val(),
			ImproveMember:$("#pic_ImproveMember").val(),
			FrontPicNo:$("#pic_FrontPicNo").val(),
			BackPicNo:$("#pic_BackPicNo").val(),
			DesignChangeNo:$("#pic_DesignChangeNo").val(),
		},	
		async: false,
		success : function(data) {
			var result = data.result;
			
			if(result.result == true){
				alert("정검정보가 정상적으로 저장되었습니다.");
				$('#pic_Penetrationinspect_modal').modal('hide');
			}
			else{

				alert("점검정보가를 저장하는데 실패하였습니다. \r\n 관리자에게 문의하시길 바라겠습니다. \r\n " + result.msg);
			}
			
		},
		error: function(data){

		}
	});
}




function pic_ajaxFileUploadFront(obj){
	 	var pos = obj.value.lastIndexOf("\\")*1;
		$("#pic_frontImgName").val(obj.value.substring(pos+1).split(".")[0]);
		
        var formData = new FormData($( "#pic_uploadPicFront" )[0]);
        
        var str = document.getElementById("pic_uploadFileFront").value;
        if(str.length == 0){
        	return;
        }
        var ajaxUrl = "uploadPic";
        //alert(ajaxUrl);
        //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
        //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
        $.ajax({
            type: "POST",
            //dataType: "text",
            url: ajaxUrl,
            data: formData,
            async: false,  
            cache: false,  
            contentType: false,  
            processData: false,
            success: function (data) {
            	document.getElementById("pic_frontImg").src="" + data + ".png";
            	$("#pic_frontImg").attr("src",function(){return this.src+"?1=" + (parseInt(Math.random() * (1000 - 1 + 1) + 1))});
            	$("#pic_FrontPicNo").val($("#pic_frontImgName").val());
            	alert("이미지를 성공적으로 올렸습니다.");
            	
            },
            error: function(data) {
                alert("이미지를 올리는데 실패하였습니다.");

             }
        });
        return false;
}
function pic_ajaxFileUploadBack(obj){

 	var pos = obj.value.lastIndexOf("\\")*1;
	$("#pic_backImgName").val(obj.value.substring(pos+1).split(".")[0]);
	
    var formData = new FormData($( "#pic_uploadPicBack" )[0]);  
    var ajaxUrl = "uploadPic";
    
    var str = document.getElementById("pic_uploadFileBack").value;
    if(str.length == 0){
    	return;
    }
    //alert(ajaxUrl);
    //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
    //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
    $.ajax({
        type: "POST",
        //dataType: "text",
        url: ajaxUrl,
        data: formData,
        async: false,  
        cache: false,  
        contentType: false,  
        processData: false,
        success: function (data) {
        	document.getElementById("pic_backImg").src="" + data + ".png";
        	$("#pic_backImg").attr("src",function(){return this.src+"?1=" + (parseInt(Math.random() * (1000 - 1 + 1) + 1))});
        	$("#pic_BackPicNo").val($("#pic_backImgName").val());
        	//        	document.getElementById("pic_backImg").src="images/default-img.png" ;
        	alert("이미지를 성공적으로 올렸습니다.");
        },
        error: function(data) {
            alert("이미지를 올리는데 실패하였습니다.");

         }
    });
    return false;
}




function updateInspectInfo(managementNo, penatrationNo, inspectSeq){
	
	
	
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'getList',
			ManagementNo:managementNo,
			PenetrationNo :penatrationNo,
			InspectSeq :inspectSeq,
		},
		async: false,
		success : function(data) {
			var result = data.result;
			var inspectInfo = result.DataList[0];
			$("#pie_ManagementNo").val(inspectInfo.ManagementNo);
			$("#pie_PenetrationNo").val(inspectInfo.PenetrationNo);
			$("#pie_InspectSeq").val(inspectInfo.InspectSeq);
			$("#pie_InspectionInterval").val(inspectInfo.InspectionInterval);
			$("#pie_SealantConditionState_name").val(inspectInfo.SealantConditionState_name);
			$("#pie_InspectDate").val(inspectInfo.InspectDate);
			$("#pie_Judgment").val(inspectInfo.Judgment);
			$("#pie_JudgementReason").val(inspectInfo.JudgementReason);
			$("#pie_FrontPicNo").val(inspectInfo.FrontPicNo);
			$("#pie_BackPicNo").val(inspectInfo.BackPicNo);
			$("#pie_ImproveDate").val(inspectInfo.ImproveDate);
			$("#pie_DesignChangeNo").val(inspectInfo.DesignChangeNo);
			$("#pie_ImproveMember").val(inspectInfo.ImproveMember);
			$("#pie_ImproveNote").val(inspectInfo.ImproveNote);

		
			
			$("#pie_frontImg").attr("src","DownLoadImg/"+inspectInfo.FrontPicNo + ".png" +"?1=" + (parseInt(Math.random() * (1000 - 1 + 1) + 1)));
			$("#pie_backImg").attr("src","DownLoadImg/"+inspectInfo.BackPicNo + ".png" +"?1=" + (parseInt(Math.random() * (1000 - 1 + 1) + 1)));
		
			$('#pie_Penetrationinspect_modal').css('z-index', 3000);
			$('#pie_Penetrationinspect_modal').modal();
			
		},
		error: function(data){

		}
	});
}


function pie_SealantConditionStateAdd(){
	var value = document.getElementById("pie_SealantConditionState_name").value;
	if(value==''){
		value += $("#pie_SealantConditionState option:selected").text();
	}else{
		value += ','+$("#pie_SealantConditionState option:selected").text();
	}
	document.getElementById("pie_SealantConditionState_name").value = value;
}


function pie_checkSealantConditionState(){
	var localResult = false;
	$.ajax({
		url : 'penetrationsearch.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'checkSealantConditionState',
			SealantConditionState_name : $("#pie_SealantConditionState_name").val()
		},
		async: false,
		success : function(data) {
			var result = data.result;
			if(result.resultFlag == 'false'){
				localResult =  false;
			}
			else{  
				localResult =  true;
			}
		},
		error: function(data){

		}
	});
	return localResult;
}


function pie_updateInspectInfoSave(){
	if(pie_checkSealantConditionState() == false){
		alert("밀폐재 시공상태 를 잘못 입력하였습니다. 다시한번 확인하여 주시길 바라겠습니다.");
		return;
	}
	$.ajax({
		url : 'penetrationinspect.do',
		type : 'post',
		dataType : 'json',
		data : {
			command:'update',
			ManagementNo:$("#pie_ManagementNo").val(),
			PenetrationNo:$("#pie_PenetrationNo").val(),
			InspectDate:$("#pie_InspectDate").val(),
			InspectSeq:$("#pie_InspectSeq").val(),
			ImproveDate:$("#pie_ImproveDate").val(),
			InspectionInterval:$("#pie_InspectionInterval").val(),
			SealantConditionState_name:$("#pie_SealantConditionState_name").val(),
			JudgementReason:$("#pie_JudgementReason").val(),
			Judgment:$("#pie_Judgment").val(),
			ImproveNote:$("#pie_ImproveNote").val(),
			ImproveMember:$("#pie_ImproveMember").val(),
			FrontPicNo:$("#pie_FrontPicNo").val(),
			BackPicNo:$("#pie_BackPicNo").val(),
			DesignChangeNo:$("#pie_DesignChangeNo").val(),
		},	
		async: false,
		success : function(data) {
			var result = data.result;
			
			if(result.result == true){
				alert("정검정보가 정상적으로 저장되었습니다.");
				$('#pie_Penetrationinspect_modal').modal('hide');
			}
			else{

				alert("점검정보가를 저장하는데 실패하였습니다. \r\n 관리자에게 문의하시길 바라겠습니다. \r\n " + result.msg);
			}
			
		},
		error: function(data){

		}
	});
}




function pie_ajaxFileUploadFront(obj){
	 	var pos = obj.value.lastIndexOf("\\")*1;
		$("#pie_frontImgName").val(obj.value.substring(pos+1).split(".")[0]);
		
        var formData = new FormData($( "#pie_uploadPicFront" )[0]);
        
        var str = document.getElementById("pie_uploadFileFront").value;
        if(str.length == 0){
        	return;
        }
        var ajaxUrl = "uploadPic";
        //alert(ajaxUrl);
        //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
        //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
        $.ajax({
            type: "POST",
            //dataType: "text",
            url: ajaxUrl,
            data: formData,
            async: false,  
            cache: false,  
            contentType: false,  
            processData: false,
            success: function (data) {
            	document.getElementById("pie_frontImg").src="" + data + ".png";
            	$("#pie_frontImg").attr("src",function(){return this.src+"?1=" + (parseInt(Math.random() * (1000 - 1 + 1) + 1))});
            	$("#pie_FrontPicNo").val($("#pie_frontImgName").val());
            	alert("이미지를 성공적으로 올렸습니다.");
            	
            },
            error: function(data) {
                alert("이미지를 올리는데 실패하였습니다.");

             }
        });
        return false;
}
function pie_ajaxFileUploadBack(obj){

 	var pos = obj.value.lastIndexOf("\\")*1;
	$("#pie_backImgName").val(obj.value.substring(pos+1).split(".")[0]);
	
    var formData = new FormData($( "#pie_uploadPicBack" )[0]);  
    var ajaxUrl = "uploadPic";
    
    var str = document.getElementById("pie_uploadFileBack").value;
    if(str.length == 0){
    	return;
    }
    //alert(ajaxUrl);
    //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
    //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
    $.ajax({
        type: "POST",
        //dataType: "text",
        url: ajaxUrl,
        data: formData,
        async: false,  
        cache: false,  
        contentType: false,  
        processData: false,
        success: function (data) {
        	document.getElementById("pie_backImg").src="" + data + ".png";
        	$("#pie_backImg").attr("src",function(){return this.src+"?1=" + (parseInt(Math.random() * (1000 - 1 + 1) + 1))});
        	$("#pie_BackPicNo").val($("#pie_backImgName").val());
        	//        	document.getElementById("pie_backImg").src="images/default-img.png" ;
        	alert("이미지를 성공적으로 올렸습니다.");
        },
        error: function(data) {
            alert("이미지를 올리는데 실패하였습니다.");

         }
    });
    return false;
}

function clearNoNum_2(obj) {     
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符  
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是  
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");  
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数 
}  
