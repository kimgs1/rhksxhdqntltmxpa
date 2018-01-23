
$(document).ready(function(){ 
//	getBaseCodeInfo();
//
//	tagBind("selectBox", "PenetrationForm","","${PenetrationForm}",codeAllInfo.A04);
	
});
$(function(){
	init();
})


function init(){
	//inspect edit modal img upload button onclick
	var fileSelect = document.getElementById("fileSelect"),
	fileElem = document.getElementById("fileElem");

	fileSelect.addEventListener("click", function (e) {
		if (fileElem) {
			fileElem.click();
		}
		e.preventDefault(); // prevent navigation to "#"
	}, false);
	
	
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
	var innerHtml = document.getElementById("SealMeterial_name").innerHTML.replace("&nbsp;","");
	if(innerHtml==''){
		innerHtml += $("#SealMeterial option:selected").text();
	}else{
		innerHtml += ','+$("#SealMeterial option:selected").text();
	}
	document.getElementById("SealMeterial_name").innerHTML = innerHtml;
}

function savePenetrationAllInfo(){
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
			ManagementNo:$("#ManagementNo").html().replace("&nbsp;",""),
			PenetrationNo :$("#PenetrationNo").html().replace("&nbsp;",""),
			ManagementAreaYN:$("#ManagementAreaYN").html().replace("&nbsp;",""),
			Elevation_num_pit:$("#Elevation_num_pit").val(),
			Elevation_num_inc:$("#Elevation_num_inc").val(),
			FirePreventionAreaNo:$("#FirePreventionAreaNo").html().replace("&nbsp;",""),
			InspectionRoomNo:$("#InspectionRoomNo").html().replace("&nbsp;",""),
			BackRoomNo:$("#BackRoomNo").html().replace("&nbsp;",""),
//			PenetrationForm:$("#PenetrationForm").html().replace("&nbsp;",""),
			PenetrationForm:$("#PenetrationForm option:selected").val(),
			Wall_FloorNo:$("#Wall_FloorNo").html().replace("&nbsp;",""),
//			FirewallYN:$("#FirewallYN").html().replace("&nbsp;",""),
			FirewallYN:$("#FirewallYN option:selected").val(),
//			WallMeterial:$("#WallMeterial").html().replace("&nbsp;",""),
			WallMeterial:$("#WallMeterial option:selected").val(),
			WallThickness:$("#WallThickness").html().replace("&nbsp;",""),
			FrontPicNo:$("#FrontPicNo").html().replace("&nbsp;",""),
			BackPicNo:$("#BackPicNo").html().replace("&nbsp;",""),
			ReferenceFloorPlanNo:$("#ReferenceFloorPlanNo").html().replace("&nbsp;",""),
			LocationFloorPlanNo:$("#LocationFloorPlanNo").html().replace("&nbsp;",""),
			SealDetailDWG:$("#SealDetailDWG").html().replace("&nbsp;",""),
			EL:$("#EL").html().replace("&nbsp;",""),
			Diameter:$("#Diameter").html().replace("&nbsp;",""),
			Height:$("#Height").html().replace("&nbsp;",""),
			Length:$("#Length").html().replace("&nbsp;",""),
			PenetrationType:$("#PenetrationType").html().replace("&nbsp;",""),
			MaximumFreeArea:$("#MaximumFreeArea").html().replace("&nbsp;",""),
			MaximumFreeDistance:$("#MaximumFreeDistance").html().replace("&nbsp;",""),
			Register:$("#Register").html().replace("&nbsp;",""),
			Reviewer:$("#Reviewer").html().replace("&nbsp;",""),
			Checker:$("#Checker").html().replace("&nbsp;",""),
			SpecialNote:$("#SpecialNote").html().replace("&nbsp;",""),
			SAFETY_CATEGORY : $("#SAFETY_CATEGORY").html().replace("&nbsp;",""),
			ANCHORTYPE : $("#ANCHORTYPE").html().replace("&nbsp;",""),
			LATERALMOVEMENT : $("#LATERALMOVEMENT").html().replace("&nbsp;",""),
			LINETEMPERATURE : $("#LINETEMPERATURE").html().replace("&nbsp;",""),
			VENTILATION_VALUE : $("#VENTILATION_VALUE").html().replace("&nbsp;",""),
			VENTILATION_VALUE_RANGE : $("#VENTILATION_VALUE_RANGE").html().replace("&nbsp;",""),
			VENTILATION_VAL_NO : $("#VENTILATION_VAL_NO").html().replace("&nbsp;",""),
			VENTILATION_JUDGMENT : $("#VENTILATION_JUDGMENT").html().replace("&nbsp;",""),
			VENTILATION_REASON : $("#VENTILATION_REASON").html().replace("&nbsp;",""),
			FIRE_VALUE : $("#FIRE_VALUE").html().replace("&nbsp;",""),
			FIRE_VALUE_RANGE : $("#FIRE_VALUE_RANGE").html().replace("&nbsp;",""),
			FIRE_VAL_NO : $("#FIRE_VAL_NO").html().replace("&nbsp;",""),
			FIRE_JUDGMENT : $("#FIRE_JUDGMENT").html().replace("&nbsp;",""),
			FIRE_REASON : $("#FIRE_REASON").html().replace("&nbsp;",""),
			RADIATION_VALUE : $("#RADIATION_VALUE").html().replace("&nbsp;",""),
			RADIATION_VALUE_RANGE : $("#RADIATION_VALUE_RANGE").html().replace("&nbsp;",""),
			RADIATION_VAL_NO : $("#RADIATION_VAL_NO").html().replace("&nbsp;",""),
			RADIATION_JUDGMENT : $("#RADIATION_JUDGMENT").html().replace("&nbsp;",""),
			RADIATION_REASON : $("#RADIATION_REASON").html().replace("&nbsp;",""),
			FLOOD_VALUE : $("#FLOOD_VALUE").html().replace("&nbsp;",""),
			FLOOD_VALUE_RANGE : $("#FLOOD_VALUE_RANGE").html().replace("&nbsp;",""),
			FLOOD_VAL_NO : $("#FLOOD_VAL_NO").html().replace("&nbsp;",""),
			FLOOD_JUDGMENT : $("#FLOOD_JUDGMENT").html().replace("&nbsp;",""),
			FLOOD_REASON : $("#FLOOD_REASON").html().replace("&nbsp;",""),
			PRESSURE_VALUE : $("#PRESSURE_VALUE").html().replace("&nbsp;",""),
			PRESSURE_VALUE_RANGE : $("#PRESSURE_VALUE_RANGE").html().replace("&nbsp;",""),
			PRESSURE_VAL_NO : $("#PRESSURE_VAL_NO").html().replace("&nbsp;",""),
			PRESSURE_JUDGMENT : $("#PRESSURE_JUDGMENT").html().replace("&nbsp;",""),
			PRESSURE_REASON : $("#PRESSURE_REASON").html().replace("&nbsp;",""),

			matter:$("#matter option:selected").val() ,
			Pipe:$("#Pipe").html().replace("&nbsp;",""),
			Duct:$("#Duct").html().replace("&nbsp;",""),
			SectionTube:$("#SectionTube").html().replace("&nbsp;",""),
			Conduit:$("#Conduit").html().replace("&nbsp;",""),
			Cable:$("#Cable").html().replace("&nbsp;",""),
			Tray:$("#Tray").html().replace("&nbsp;",""),
			CoverTray:$("#CoverTray").html().replace("&nbsp;",""),
			Etc:$("#Etc").html().replace("&nbsp;",""),

			
//			RequirePerformance:$("#RequirePerformance").html().replace("&nbsp;",""),
//			RequirePerformance:getRadioValueByTagName('RequirePerformance'),
//			EvaluationResult:$("#EvaluationResult").html().replace("&nbsp;",""),
//			EvaluationResult:$("#EvaluationResult option:selected").val(),
//			FireResistanceRating:$("#FireResistanceRating").html().replace("&nbsp;",""),
//			PSI:$("#PSI").html().replace("&nbsp;",""),
//			WaterSeal:$("#WaterSeal").html().replace("&nbsp;",""),
//			RadiationShield:$("#RadiationShield").html().replace("&nbsp;",""),
			
			
//			ConstructionState:$("ConstructionState").html().replace("&nbsp;",""),
//			ConstructionState:getRadioValueByTagName('ConstructionState'),
			SealSealDetailDWG:$("#SealSealDetailDWG").html().replace("&nbsp;",""),
			SealQualityClass:$("#SealQualityClass").html().replace("&nbsp;",""),
//			SealMeterial:$("SealMeterial").html().replace("&nbsp;",""),
			SealMeterial_name:$("#SealMeterial_name").html().replace("&nbsp;",""),
			SealThickness:$("#SealThickness").html().replace("&nbsp;",""),
			PressingBoardMeterial:$("#PressingBoardMeterial").html().replace("&nbsp;",""),
			PressingBoardThickness:$("#PressingBoardThickness").html().replace("&nbsp;",""),
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
			SealMeterial_name : $("#SealMeterial_name").html().replace("&nbsp;","")
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
			$("#pie_ManagementNo").text(inspectInfo.ManagementNo);
			$("#pie_PenetrationNo").text(inspectInfo.PenetrationNo);
			$("#pie_InspectSeq").text(inspectInfo.InspectSeq);
			$("#pie_InspectionInterval").text(inspectInfo.InspectionInterval);
			$("#pie_InspectDate").text(inspectInfo.InspectDate);
			$("#pie_Judgment").text(inspectInfo.Judgment);
			$("#pie_JudgementReason").text(inspectInfo.JudgementReason);
			$("#pie_FrontPicNo").text(inspectInfo.FrontPicNo);
			$("#pie_BackPicNo").text(inspectInfo.BackPicNo);
			$("#pie_ImproveDate").text(inspectInfo.ImproveDate);
			$("#pie_DesignChangeNo").text(inspectInfo.DesignChangeNo);
			$("#pie_ImproveMember").text(inspectInfo.ImproveMember);
			$("#pie_ImproveNote").text(inspectInfo.ImproveNote);
			
			
			
			
			$('#create_Penetrationinspect_modal').css('z-index', 3000);
			$('#create_Penetrationinspect_modal').modal();
			
		},
		error: function(data){

		}
	});
	

	
}
function clickFrontImg(){
	if($("#pie_FrontPicNo").text() == ''){
		alert("정면사진번호를 먼저 입력하여 주세요");
	}else{
		$("#frontImgName").val($("#pie_FrontPicNo").text());
	}
}
function clickBackImg(){
	$("#backImgName").val($("#pie_BackPicNo").text());
}
function ajaxFileUploadFront(){
        var formData = new FormData($( "#uploadPicFront" )[0]);  
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
            	document.getElementById("frontImg").src="" + data + ".png";
            	alert("이미지를 성공적으로 올렸습니다.");
            },
            error: function(data) {
                alert("이미지를 올리는데 실패하였습니다.");

             }
        });
        return false;
}
function ajaxFileUploadBack(){
    var formData = new FormData($( "#uploadPicBack" )[0]);  
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
        	document.getElementById("backImg").src="" + data + ".png";
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
