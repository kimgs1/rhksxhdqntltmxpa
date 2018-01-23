<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관통부 시스템</title>

<%@ include file="main_head.jsp"%>


<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationsearcheditview.js"></script>
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
	            <th>관리번호</th>
            	<td><div id="ManagementNo" style="width:100%">&nbsp;${ManagementNo}</div></td>
            </tr>
            <tr>
                <th>관통부번호</th>
                <td><div id="PenetrationNo" style="width:100%">&nbsp;${PenetrationNo}</div></td>
            </tr>
            <tr>
                <th>관리구역여부</th>
                <td><div id="ManagementAreaYN" style="width:100%" contenteditable="true">&nbsp;${ManagementAreaYN}</div></td>
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
                <td><div id="FirePreventionAreaNo" style="width:100%" contenteditable="true">&nbsp;${FirePreventionAreaNo}</div></td>
            </tr>
            <tr>
                <th>점검방 번호</th>
                <td><div id="InspectionRoomNo" style="width:100%" contenteditable="true">&nbsp;${InspectionRoomNo}</div></td>
            </tr>
            <tr>
                <th>이면방 번호</th>
                <td><div id="BackRoomNo" style="width:100%" contenteditable="true">&nbsp;${BackRoomNo}</div></td>
            </tr>
            <tr>
                <th>관통부형태</th>
                <td><div id="PenetrationForm_tag" style="width:100%"></div></td>
            </tr>
            <tr>
                <th>벽, 바닥번호 | 방화벽 여부 </th>
                <td><div class="row">
                <div id="Wall_FloorNo" class="col-sm-5" contenteditable="true">&nbsp;${Wall_FloorNo}</div>
                <div class="col-sm-1">|</div>
                <div id="FirewallYN_tag" class="col-sm-5"></div></div></td>
            </tr>
            <tr>
                <th>벽재질</th>
                <td><div id="WallMeterial_tag" style="width:100%" contenteditable="true">&nbsp;${WallMeterial_name}</div></td>
            </tr>
            <tr>
                <th>벽두께</th>
                <td><div id="WallThickness" style="width:100%" contenteditable="true">&nbsp;${WallThickness}</div></td>
            </tr>
            <tr>
                <th>정면사진 번호</th>
                <td><div id="FrontPicNo" style="width:100%">&nbsp;${FrontPicNo}</div></td>
            </tr>
            <tr>
                <th>이면사진번호</th>
                <td><div id="BackPicNo" style="width:100%">&nbsp;${BackPicNo}</div></td>
            </tr>
            <tr>
                <th>관통부 참조도면 번호</th>
                <td><div id="ReferenceFloorPlanNo" style="width:100%" contenteditable="true">&nbsp;${ReferenceFloorPlanNo}</div></td>
            </tr>
            <tr>
                <th>관통부 위치도면 번호</th>
                <td><div id="LocationFloorPlanNo" style="width:100%" contenteditable="true">&nbsp;${LocationFloorPlanNo}</div></td>
            </tr>
            <tr>
                <th>관통부 SEAL DETAIL DWG</th>
                <td><div id="SealDetailDWG" style="width:100%" contenteditable="true">&nbsp;${SealDetailDWG}</div></td>
            </tr>
            <tr>
                <th>관통부 EL.</th>
                <td><div id="EL" style="width:100%" contenteditable="true">&nbsp;${EL}</div></td>
            </tr>
            <tr>
                <th>관통부 직경</th>
                <td><div id="Diameter" style="width:100%" contenteditable="true">&nbsp;${Diameter}</div></td>
            </tr>
            <tr>
                <th>관통부 가로</th>
                <td><div id="Height" style="width:100%" contenteditable="true">&nbsp;${Height}</div></td>
            </tr>
            <tr>
                <th>관통부 세로</th>
                <td><div id="Length" style="width:100%" contenteditable="true">&nbsp;${Length}</div></td>
            </tr>
            <tr>
                <th>관통부 TYPE | PROJECTION</th>
                <td><div id="PenetrationType" style="width:100%" contenteditable="true">&nbsp;${PenetrationType}</div></td>
            </tr>
            <tr>
                <th>최대자유면적</th>
                <td><div id="MaximumFreeArea" style="width:100%" contenteditable="true">&nbsp;${MaximumFreeArea}</div></td>
            </tr>
            <tr>
                <th>최대환형거리</th>
                <td><div id="MaximumFreeDistance" style="width:100%" contenteditable="true">&nbsp;${MaximumFreeDistance}</div></td>
            </tr>
            <tr>
                <th>작성자  |  검토자</th>
                <td>
                	<div class="row">
                		<div id="Register" class="col-sm-5" style="width:47%" contenteditable="true">&nbsp;${Register}</div>  
                		<div class="col-sm-1">|</div> 
                		<div id="Reviewer" class="col-sm-5" style="width:47%" contenteditable="true">&nbsp;${Reviewer}</div>
                
                	</div>
                </td>
            </tr>
            <tr>
                <th>확인자</th>
                <td><div id="Checker" style="width:100%" contenteditable="true">&nbsp;${Checker}</div></td>
            </tr>
            <tr>
                <th>특이사항</th>
                <td><div id="SpecialNote" style="width:100%" contenteditable="true">&nbsp;${SpecialNote}</div></td>
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
            	 <td><div id="SealMeterial_name" style="width:100%" contenteditable="true">&nbsp;${SealMeterial_name}</div></td>
            </tr>
            <tr>
                <th>밀폐재 두께 (mm)</th>
                <td><div id="SealThickness" style="width:100%" contenteditable="true">&nbsp;${SealThickness}</div></td>
            </tr>
            <tr>
                <th>밀폐재 DETAIL DWG</th>
                <td><div id="SealSealDetailDWG" style="width:100%" contenteditable="true">&nbsp;${SealSealDetailDWG}</div></td>
            </tr>
            <tr>
                <th>SEAL QUALTY CLASS</th>
                <td><div id="SealQualityClass" style="width:100%" contenteditable="true">&nbsp;${SealQualityClass}</div></td>
            </tr>
            <tr>
                <th>댐판 재질</th>
                <td><div id="PressingBoardMeterial" style="width:100%" contenteditable="true">&nbsp;${PressingBoardMeterial}</div></td>
            </tr>
            <tr>
                <th>댐판 두께</th>
                <td><div id="PressingBoardThickness" style="width:100%" contenteditable="true">&nbsp;${PressingBoardThickness}</div></td>
            </tr>
            <tr>
                <th>시공상태</th>
                <td><div id="ConstructionState_name" style="width:100%">&nbsp;${ConstructionState_name}</div></td>
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
                <td><div id="Pipe" style="width:100%" contenteditable="true">&nbsp;${Pipe}</div></td>
            </tr>
            <tr>
                <th>덕트</th>
                <td><div id="Duct" style="width:100%" contenteditable="true">&nbsp;${Duct}</div></td>
            </tr>
            <tr>
                <th>계장튜브</th>
                <td><div id="SectionTube" style="width:100%" contenteditable="true">&nbsp;${SectionTube}</div></td>
            </tr>
            <tr>
                <th>전선관</th>
                <td><div id="Conduit" style="width:100%" contenteditable="true">&nbsp;${Conduit}</div></td>
            </tr>
            <tr>
                <th>케이블</th>
                <td><div id="Cable" style="width:100%" contenteditable="true">&nbsp;${Cable}</div></td>
            </tr>
            <tr>
                <th>트레이</th>
                <td><div id="Tray" style="width:100%" contenteditable="true">&nbsp;${Tray}</div></td>
            </tr>
            <tr>
                <th>커버트레이</th>
                <td><div id="CoverTray" style="width:100%" contenteditable="true">&nbsp;${CoverTray}</div></td>
            </tr>
            <tr>
                <th>기타</th>
                <td><div id="Etc" style="width:100%" contenteditable="true">&nbsp;${Etc}</div></td>
            </tr>
        </table>
        <table class="w_50">
            <tr>
                <th colspan="2">● 이전설계 정보
            </tr>
            <tr>
                <th>SAFE CATEGORY</th>
                <td><div id="SAFETY_CATEGORY" style="width:100%" contenteditable="true">&nbsp;${SAFETY_CATEGORY}</div></td>
            </tr>
            <tr>
                <th>ANCHOR TYPE</th>
                <td><div id="ANCHORTYPE" style="width:100%" contenteditable="true">&nbsp;${ANCHORTYPE}</div></td>
            </tr>
            <tr>
                <th>LATERAL MOVEMENT</th>
                <td><div id="LATERALMOVEMENT" style="width:100%" contenteditable="true">&nbsp;${LATERALMOVEMENT}</div></td>
            </tr>
            <tr>
                <th>LINE TEMPERATURE</th>
                <td><div id="LINETEMPERATURE" style="width:100%" contenteditable="true">&nbsp;${LINETEMPERATURE}</div></td>
            </tr>
            <tr>
                <th></th>
                <td></td>
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
                <td><div id="VENTILATION_VALUE" style="width:100%" contenteditable="true">&nbsp;${VENTILATION_VALUE}</div></td>
                <td><div id="VENTILATION_VALUE_RANGE" style="width:100%" contenteditable="true">&nbsp;${VENTILATION_VALUE_RANGE}</div></td>
                <td><div id="VENTILATION_VAL_NO" style="width:100%" contenteditable="true">&nbsp;${VENTILATION_VAL_NO}</div></td>
                <td><div id="VENTILATION_JUDGMENT" style="width:100%" contenteditable="true">&nbsp;${VENTILATION_JUDGMENT}</div></td>
                <td><div id="VENTILATION_REASON" style="width:100%" contenteditable="true">&nbsp;${VENTILATION_REASON}</div></td>
            </tr>
            <tr>
                <th>FIRE</th>
                <td><div id="FIRE_VALUE" style="width:100%" contenteditable="true">&nbsp;${FIRE_VALUE}</div></td>
                <td><div id="FIRE_VALUE_RANGE" style="width:100%" contenteditable="true">&nbsp;${FIRE_VALUE_RANGE}</div></td>
                <td><div id="FIRE_VAL_NO" style="width:100%" contenteditable="true">&nbsp;${FIRE_VAL_NO}</div></td>
                <td><div id="FIRE_JUDGMENT" style="width:100%" contenteditable="true">&nbsp;${FIRE_JUDGMENT}</div></td>
                <td><div id="FIRE_REASON" style="width:100%" contenteditable="true">&nbsp;${FIRE_REASON}</div></td>
            </tr>
            <tr>
                <th>RADIATION</th>
                <td><div id="RADIATION_VALUE" style="width:100%" contenteditable="true">&nbsp;${RADIATION_VALUE}</div></td>
                <td><div id="RADIATION_VALUE_RANGE" style="width:100%" contenteditable="true">&nbsp;${RADIATION_VALUE_RANGE}</div></td>
                <td><div id="RADIATION_VAL_NO" style="width:100%" contenteditable="true">&nbsp;${RADIATION_VAL_NO}</div></td>
                <td><div id="RADIATION_JUDGMENT" style="width:100%" contenteditable="true">&nbsp;${RADIATION_JUDGMENT}</div></td>
                <td><div id="RADIATION_REASON" style="width:100%" contenteditable="true">&nbsp;${RADIATION_REASON}</div></td>
                
            </tr>
            <tr>
                <th>FLOOD</th>
                <td><div id="FLOOD_VALUE" style="width:100%" contenteditable="true">&nbsp;${FLOOD_VALUE}</div></td>
                <td><div id="FLOOD_VALUE_RANGE" style="width:100%" contenteditable="true">&nbsp;${FLOOD_VALUE_RANGE}</div></td>
                <td><div id="FLOOD_VAL_NO" style="width:100%" contenteditable="true">&nbsp;${FLOOD_VAL_NO}</div></td>
                <td><div id="FLOOD_JUDGMENT" style="width:100%" contenteditable="true">&nbsp;${FLOOD_JUDGMENT}</div></td>
                <td><div id="FLOOD_REASON" style="width:100%" contenteditable="true">&nbsp;${FLOOD_REASON}</div></td>
            </tr>
            <tr>
                <th>PRESSURE</th>
                <td><div id="PRESSURE_VALUE" style="width:100%" contenteditable="true">&nbsp;${PRESSURE_VALUE}</div></td>
                <td><div id="PRESSURE_VALUE_RANGE" style="width:100%" contenteditable="true">&nbsp;${PRESSURE_VALUE_RANGE}</div></td>
                <td><div id="PRESSURE_VAL_NO" style="width:100%" contenteditable="true">&nbsp;${PRESSURE_VAL_NO}</div></td>
                <td><div id="PRESSURE_JUDGMENT" style="width:100%" contenteditable="true">&nbsp;${PRESSURE_JUDGMENT}</div></td>
                <td><div id="PRESSURE_REASON" style="width:100%" contenteditable="true">&nbsp;${PRESSURE_REASON}</div></td>
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
						<input onclick="deleteDetailView('+options.rowId+')"
										style="width: 60px; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #ff8511; padding-left: 23px; border: 0; border-radius: 5px;"
										type="button" value="추가">
					</th>
					</tr>
				<c:forEach var="list" items="${InspectList}">
					<tr>
						<th style="width: 10%">점검주기</th>
						<th style="width: 10%">점검차수</th>
						<th style="width: 10%">점검일</th>
						<th style="width: 15%">밀폐재시공상태</th>
						<th style="width: 10%">판정</th>
						<th>
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
						<td>&nbsp;${list.FrontPicNo}</td>
						<td>&nbsp;${list.BackPicNo}</td>
						<td>&nbsp;${list.ImproveDate}</td>
						<td>&nbsp;${list.DesignChangeNo}</td>
						<td>&nbsp;${list.ImproveMember}</td>
						<td>&nbsp;${list.ImproveNote}</td>
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
		tagBind("selectBox", "EquipNo","","${EquipNo}",codeAllInfo.A01);
		tagBind("selectBox", "LocNo","","${LocNo}",codeAllInfo.A11);
	</script>
</body>
</html>