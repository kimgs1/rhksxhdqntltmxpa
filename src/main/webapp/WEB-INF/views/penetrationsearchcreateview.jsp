<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관통부 시스템</title>

<%@ include file="main_head.jsp"%>


<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationsearchcreateview.js"></script>
</head>
<body>
<div align="center" style="text-align:center">


	
    <section class="sec01_pop" >
        <h2>관통부정보</h2>
        <!-- 
         <input type="reset" value="삭제" />
         -->
        <table class="w_50">
            <tr>
                <th colspan="2">● 관통부 기본정보 
            </tr>
			<tr>
				<th>호기 | 건물</th>
				<td><div class="row">
						<div id="EquipNo_tag" class="col-sm-5"></div>
						<div class="col-sm-1">|</div>
						<div id="LocNo_tag" class="col-sm-5"></div>
					</div>
				</td>
			</tr>
				<tr>
	            <th>관리번호*</th>
            	<td><input id="ManagementNo" style="width:100%" value="${ManagementNo}" ></td>
            </tr>
            <tr>
                <th>관통부번호*</th>
                <td><input id="PenetrationNo" style="width:100%" value="${PenetrationNo}" ></td>
            </tr>
            <tr>
                <th>관리구역여부</th>
                <td><input id="ManagementAreaYN" style="width:100%" value="${ManagementAreaYN}"></td>
            </tr>
            <tr>
                <th>ELEVATION</th>
                <td>
                	<div class="row">
						<input id="Elevation_num_pit" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Elevation_num_pit}">
						<div class="col-sm-1">'-</div>
						<input id="Elevation_num_inc" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Elevation_num_inc}">
						<div class="col-sm-1">"</div>
					</div>
                </td>
            </tr>
            <tr>
                <th>방화지역번호</th>
                <td><input id="FirePreventionAreaNo" style="width:100%" value="${FirePreventionAreaNo}"></td>
            </tr>
            <tr>
                <th>점검방 번호</th>
                <td><input id="InspectionRoomNo" style="width:100%" value="${InspectionRoomNo}"></td>
            </tr>
            <tr>
                <th>이면방 번호</th>
                <td><input id="BackRoomNo" style="width:100%" value="${BackRoomNo}"></td>
            </tr>
            <tr>
                <th>관통부형태</th>
                <td><div id="PenetrationForm_tag" style="width:100%"></div></td>
            </tr>
            <tr>
                <th>벽, 바닥번호 | 방화벽 여부 </th>
                <td><div class="row">
                <input id="Wall_FloorNo" class="col-sm-5" value="${Wall_FloorNo}">
                <div class="col-sm-1">|</div>
                <div id="FirewallYN_tag" class="col-sm-5"></div></div></td>
            </tr>
            <tr>
                <th>벽재질</th>
                <td><div id="WallMeterial_tag" style="width:100%"></div></td>
            </tr>
            <tr>
                <th>벽두께</th>
                <td><input id="WallThickness" style="width:100%" value=${WallThickness}></td>
            </tr>
            <tr>
                <th>정면사진 번호</th>
                <td><input id="FrontPicNo" style="width:100%" value="${FrontPicNo}" disabled="disabled"></td>
            </tr>
            <tr>
                <th>이면사진번호</th>
                <td><input id="BackPicNo" style="width:100%" value="${BackPicNo}" disabled="disabled"></td>
            </tr>
            <tr>
                <th>관통부 참조도면 번호</th>
                <td><input id="ReferenceFloorPlanNo" style="width:100%" value="${ReferenceFloorPlanNo}"></td>
            </tr>
            <tr>
                <th>관통부 위치도면 번호</th>
                <td><input id="LocationFloorPlanNo" style="width:100%" value="${LocationFloorPlanNo}"></td>
            </tr>
            <tr>
                <th>관통부 SEAL DETAIL DWG</th>
                <td><input id="SealDetailDWG" style="width:100%" value="${SealDetailDWG}"></td>
            </tr>
            <tr>
                <th>관통부 EL.</th>
                <td><input id="EL" style="width:100%" value=${EL}></td>
            </tr>
            <tr>
                <th>관통부 직경</th>
                <td>
                    <div class="row">
						<input id="Diameter_num_pit" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Diameter_num_pit}">
						<div class="col-sm-1">'-</div>
						<input id="Diameter_num_inc" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Diameter_num_inc}">
						<div class="col-sm-1">"</div>
					</div>
                </td>
            </tr>
            <tr>
                <th>관통부 가로</th>
                <td>
                    <div class="row">
						<input id="Height_num_pit" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Height_num_pit}">
						<div class="col-sm-1">'-</div>
						<input id="Height_num_inc" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Height_num_inc}">
						<div class="col-sm-1">"</div>
					</div>
                </td>
            </tr>
            <tr>
                <th>관통부 세로</th>
                <td>
                    <div class="row">
						<input id="Length_num_pit" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Length_num_pit}">
						<div class="col-sm-1">'-</div>
						<input id="Length_num_inc" class="col-sm-5" onkeyup='clearNoNum_2(this);' value="${Length_num_inc}">
						<div class="col-sm-1">"</div>
					</div>
                </td>
            </tr>
            <tr>
                <th>관통부 TYPE | PROJECTION</th>
                <td><input id="PenetrationType" style="width:100%" value="${PenetrationType}"></td>
            </tr>
            <tr>
                <th>최대자유면적</th>
                <td><input id="MaximumFreeArea" style="width:100%" value=${MaximumFreeArea}></td>
            </tr>
            <tr>
                <th>최대환형거리</th>
                <td><input id="MaximumFreeDistance" style="width:100%" value=${MaximumFreeDistance}></td>
            </tr>
            <tr>
                <th>작성자  |  검토자</th>
                <td>
                	<div class="row">
                		<input id="Register" class="col-sm-5" style="width:47%" value="${Register}"> 
                		<div class="col-sm-1">|</div> 
                		<input id="Reviewer" class="col-sm-5" style="width:47%" value="${Reviewer}">
                
                	</div>
                </td>
            </tr>
            <tr>
                <th>확인자</th>
                <td><input id="Checker" style="width:100%" value="${Checker}">
            </tr>
            <tr>
                <th>특이사항</th>
                <td><input id="SpecialNote" style="width:100%" value="${SpecialNote}">
            </tr>
        </table>
        <table class="w_50">
            <tr>
                <th colspan="2">● 밀폐재 정보
            </tr>
            <tr>
                <th rowspan="2">밀폐재 재질</th>
                <td>
                	<div class="row">
	                	<div id="SealMeterial_tag" class="col-sm-8"></div> 
	                	<div class="col-sm-4">
								<input onclick="SealMeterialAdd()"
									style="width: 60px; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #ff8511; padding-left: 23px; border: 0; border-radius: 5px;"
									type="button" value="추가">
						</div>
                	</div>
                </td>
            </tr>
            <tr>
            	 <td><input id="SealMeterial_name" style="width:100%" value="${SealMeterial_name}"></td>
            </tr>
            <tr>
                <th>밀폐재 두께 (mm)</th>
                <td><input id="SealThickness" style="width:100%" value=${SealThickness}></td>
            </tr>
            <tr>
                <th>밀폐재 DETAIL DWG</th>
                <td><input id="SealSealDetailDWG" style="width:100%" value=${SealSealDetailDWG}></td>
            </tr>
            <tr>
                <th>SEAL QUALTY CLASS</th>
                <td><input id="SealQualityClass" style="width:100%" value="${SealQualityClass}"></td>
            </tr>
            <tr>
                <th>댐판 재질</th>
                <td><input id="PressingBoardMeterial" style="width:100%" value="${PressingBoardMeterial}"></td>
            </tr>
            <tr>
                <th>댐판 두께</th>
                <td><input id="PressingBoardThickness" style="width:100%" value=${PressingBoardThickness}></td>
            </tr>
            <tr>
                <th>시공상태</th>
                <td><input id="ConstructionState_name" style="width:100%" value="${ConstructionState_name}" disabled="disabled"></td>
                <!--네모네모 -->
            </tr>
            <!-- 
            
             <tr>
                <th rowspan="2">보수불량<br />(재질/물량)</th>
                <td></td>
            </tr>
            <tr>
                <td></td>
            </tr>
             -->
        </table>
        <table class="w_50">
            <tr>
                <th colspan="2">● 관통재 정보
            </tr>
            <tr>
                <td colspan="2" style="height:23px"></td>
            </tr>
            <tr>
                <th>관통물질명</th>
                <td>규격X수량</td>
            </tr>
            <tr>
                <th>배관</th>
                <td><input id="Pipe" style="width:100%" value=${Pipe}></td>
            </tr>
            <tr>
                <th>덕트</th>
                <td><input id="Duct" style="width:100%" value=${Duct}></td>
            </tr>
            <tr>
                <th>계장튜브</th>
                <td><input id="SectionTube" style="width:100%" value=${SectionTube}></td>
            </tr>
            <tr>
                <th>전선관</th>
                <td><input id="Conduit" style="width:100%" value=${Conduit}></td>
            </tr>
            <tr>
                <th>케이블</th>
                <td><input id="Cable" style="width:100%" value=${Cable}></td>
            </tr>
            <tr>
                <th>트레이</th>
                <td><input id="Tray" style="width:100%" value=${Tray}></td>
            </tr>
            <tr>
                <th>커버트레이</th>
                <td><input id="CoverTray" style="width:100%" value=${CoverTray}></td>
            </tr>
            <tr>
                <th>기타</th>
                <td><input id="Etc" style="width:100%" value=${Etc}></td>
            </tr>
        </table>
        <table class="w_50">
            <tr>
                <th colspan="2">● 이전설계 정보
            </tr>
            <tr>
                <th>SAFE CATEGORY</th>
                <td><input id="SAFETY_CATEGORY" style="width:100%" value=${SAFETY_CATEGORY}></td>
            </tr>
            <tr>
                <th>ANCHOR TYPE</th>
                <td><input id="ANCHORTYPE" style="width:100%" value=${ANCHORTYPE}></td>
            </tr>
            <tr>
                <th>LATERAL MOVEMENT</th>
                <td><input id="LATERALMOVEMENT" style="width:100%" value=${LATERALMOVEMENT}></td>
            </tr>
            <tr>
                <th>LINE TEMPERATURE</th>
                <td><input id="LINETEMPERATURE" style="width:100%" value=${LINETEMPERATURE}></td>
            </tr>
        </table>
        <table class="w_100">
            <tr>
                <th colspan="6">● 성능기준</th>
            </tr>
            <tr>
                <th>성능기준</th>
                <th>적용</th>
                <th>허용치</th>
                <th>성능인증번호</th>
                <th>성능평가</th>
                <th>판정</th>
            </tr>
            <tr>
                <th>VENTILATION</th>
                <td><input id="VENTILATION_VALUE" style="width:100%" value=${VENTILATION_VALUE}></td>
                <td><input id="VENTILATION_VALUE_RANGE" style="width:100%" value=${VENTILATION_VALUE_RANGE}></td>
                <td><input id="VENTILATION_VAL_NO" style="width:100%" value=${VENTILATION_VAL_NO}></td>
                <td><input id="VENTILATION_JUDGMENT" style="width:100%" value=${VENTILATION_JUDGMENT}></td>
                <td><input id="VENTILATION_REASON" style="width:100%" value=${VENTILATION_REASON}></td>
            </tr>
            <tr>
                <th>FIRE</th>
                <td><input id="FIRE_VALUE" style="width:100%" value=${FIRE_VALUE}></td>
                <td><input id="FIRE_VALUE_RANGE" style="width:100%" value=${FIRE_VALUE_RANGE}></td>
                <td><input id="FIRE_VAL_NO" style="width:100%" value=${FIRE_VAL_NO}></td>
                <td><input id="FIRE_JUDGMENT" style="width:100%" value=${FIRE_JUDGMENT}></td>
                <td><input id="FIRE_REASON" style="width:100%" value=${FIRE_REASON}></td>
            </tr>
            <tr>
                <th>RADIATION</th>
                <td><input id="RADIATION_VALUE" style="width:100%" value=${RADIATION_VALUE}></td>
                <td><input id="RADIATION_VALUE_RANGE" style="width:100%" value=${RADIATION_VALUE_RANGE}></td>
                <td><input id="RADIATION_VAL_NO" style="width:100%" value=${RADIATION_VAL_NO}></td>
                <td><input id="RADIATION_JUDGMENT" style="width:100%" value=${RADIATION_JUDGMENT}></td>
                <td><input id="RADIATION_REASON" style="width:100%" value=${RADIATION_REASON}></td>
                
            </tr>
            <tr>
                <th>FLOOD</th>
                <td><input id="FLOOD_VALUE" style="width:100%" value=${FLOOD_VALUE}></td>
                <td><input id="FLOOD_VALUE_RANGE" style="width:100%" value=${FLOOD_VALUE_RANGE}></td>
                <td><input id="FLOOD_VAL_NO" style="width:100%" value=${FLOOD_VAL_NO}></td>
                <td><input id="FLOOD_JUDGMENT" style="width:100%" value=${FLOOD_JUDGMENT}></td>
                <td><input id="FLOOD_REASON" style="width:100%" value=${FLOOD_REASON}></td>
            </tr>
            <tr>
                <th>PRESSURE</th>
                <td><input id="PRESSURE_VALUE" style="width:100%" value=${PRESSURE_VALUE}></td>
                <td><input id="PRESSURE_VALUE_RANGE" style="width:100%" value=${PRESSURE_VALUE_RANGE}></td>
                <td><input id="PRESSURE_VAL_NO" style="width:100%" value=${PRESSURE_VAL_NO}></td>
                <td><input id="PRESSURE_JUDGMENT" style="width:100%" value=${PRESSURE_JUDGMENT}></td>
                <td><input id="PRESSURE_REASON" style="width:100%" value=${PRESSURE_REASON}></td>
            </tr>
        </table>
        
        <br>
        <div class="row">
        	<div class="col-sm-10"></div>
				<div class="col-sm-2">
					<input onclick="savePenetrationAllInfo()"
						style="width: 130px; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #0866d8; padding-left: 23px; border: 0; border-radius: 5px;"
						type="button" value="관통부정보 저장">
				</div>
			</div>
        <br>
			<table class="w_100">
				<tr>
					<th colspan="12">● 점검정보 
						<input onclick="insertInspectInfo()"
										style="width: 60px; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #ff8511; padding-left: 23px; border: 0; border-radius: 5px;"
										type="button" value="추가">
					</th>
					</tr>
				<c:forEach var="list" items="${InspectList}">
					<tr>
						<th style="width: 10%">점검주기</th>
						<th style="width: 10%">점검차수</th>
						<th style="width: 8%">점검일</th>
						<th style="width: 13%">밀폐재시공상태</th>
						<th style="width: 9%">판정</th>
						<th style="width: 50%">
							<div class="row">
								<div class="col-sm-3"></div>
								<div class="col-sm-6">판단사유</div>
								<div class="col-sm-3">
									<input onclick="updateInspectInfo('${ManagementNo}','${PenetrationNo}','${list.InspectSeq}')"
										style="width: 70px; height: 20px; margin-right:1px;line-height: 20px; font-size: 13px; font-weight: 400; color: black; background: url(images/ico_write.png) no-repeat 5px center #fcf805; padding-left: 23px; border: 0; border-radius: 5px;"
										type="button" value="수정">
								</div>
							</div>

						</th>

					</tr>
					<tr>
						<td>&nbsp;${list.InspectionInterval}</td>
						<td id="InspectSeq">&nbsp;${list.InspectSeq}</td>
						<td>&nbsp;${list.InspectDate}</td>
						<td>&nbsp;${list.SealantConditionState_name}</td>
						<td>&nbsp;${list.Judgment_name}</td>
						<td>&nbsp;${list.JudgementReason}</td>
					</tr>
					<tr>
						<th>정면사진</th>
						<th>이면사진</th>
						<th>보수일자</th>
						<th>설계변경서번호</th>
						<th>보수담당자</th>
						<th>
							<div class="row">
								<div class="col-sm-3"></div>
								<div class="col-sm-6">보수내용</div>
								<div class="col-sm-3">
								
								</div>
							</div>
						</th>
					</tr>
					<tr>
						<td>${list.FrontPicNo}</td>
						<td>${list.BackPicNo}</td>
						<td>&nbsp;${list.ImproveDate}</td>
						<td>&nbsp;${list.DesignChangeNo}</td>
						<td>&nbsp;${list.ImproveMember}</td>
						<td>&nbsp;${list.ImproveNote}</td>
					</tr>

					<tr>
						<td colspan="5">
							<img id="frontImg_${list.InspectSeq}" src="DownLoadImg/${list.FrontPicNo}.png"  onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'" style="width:350px;height:250px">
						</td>
						<td>
							<img id="backImg_${list.InspectSeq}" src="DownLoadImg/${list.BackPicNo}.png"  onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'" style="width:350px;height:250px">
						</td>
					</tr>
					<tr>
						<td colspan="6" style="height: 1px" bgcolor="black"></td>
					</tr>

				</c:forEach>
			</table>
			<br/>
    </section>
    </div>
    
    <script type="text/javascript">
		getCodeAllInfo();
		tagBind("selectBox", "PenetrationForm","","${PenetrationForm}",codeAllInfo.A02);
		tagBind("selectBox", "FirewallYN","","${FirewallYN}",codeAllInfo.A09);
		tagBind("selectBox", "WallMeterial","","${WallMeterial}",codeAllInfo.A04);
		tagBind("selectBox", "SealMeterial","","${SealMeterial}",codeAllInfo.A12);
		tagBind("selectBox", "pie_SealantConditionState","","",codeAllInfo.A03);
		tagBind("selectBox", "pic_SealantConditionState","","",codeAllInfo.A03);
		tagBind("selectBox", "EquipNo","","${EquipNo}",codeAllInfo.A01);
		tagBind("selectBox", "LocNo","","${LocNo}",codeAllInfo.A11);
	</script>
</body>
</html>