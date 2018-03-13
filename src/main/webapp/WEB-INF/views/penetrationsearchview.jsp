<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관통부 시스템</title>

<%@ include file="main_head.jsp"%>


<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationsearchview.js"></script>
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
                <th>호기  | 건물</th>
                <td >${EquipNo_name} | ${LocNo_name}   </td>
            </tr>
            <tr>
                <th>관리번호</th>
                <td >${ManagementNo}</td>
            </tr>
            <tr>
                <th>관통부번호</th>
                <td >${PenetrationNo}</td>
            </tr>
            <tr>
                <th>관리구역여부</th>
                <td>${ManagementAreaYN}</td>
            </tr>
            <tr>
                <th>ELEVATION</th>
                <td>${Elevation}</td>
            </tr>
            <tr>
                <th>방화지역번호</th>
                <td>${FirePreventionAreaNo}</td>
            </tr>
            <tr>
                <th>점검방 번호</th>
                <td>${InspectionRoomNo}</td>
            </tr>
            <tr>
                <th>이면방 번호</th>
                <td>${BackRoomNo}</td>
            </tr>
            <tr>
                <th>관통부형태</th>
                <td>${PenetrationForm_name}</td>
            </tr>
            <tr>
                <th>벽, 바닥번호 | 방화벽 여부 </th>
                <td>${Wall_FloorNo} | ${FirewallYN_name}</td>
            </tr>
            <tr>
                <th>벽재질</th>
                <td>${WallMeterial_name}</td>
            </tr>
            <tr>
                <th>벽두께</th>
                <td>${WallThickness}</td>
            </tr>
            <tr>
                <th>정면사진 번호</th>
                <td>${FrontPicNo}</td>
            </tr>
            <tr>
                <th>이면사진번호</th>
                <td>${BackPicNo}</td>
            </tr>
            <tr>
                <th>관통부 참조도면 번호</th>
                <td>${ReferenceFloorPlanNo}</td>
            </tr>
            <tr>
                <th>관통부 위치도면 번호</th>
                <td>${LocationFloorPlanNo}</td>
            </tr>
            <tr>
                <th>관통부 SEAL DETAIL DWG</th>
                <td>${SealDetailDWG}</td>
            </tr>
            <tr>
                <th>관통부 EL.</th>
                <td>${EL}</td>
            </tr>
            <tr>
                <th>관통부 직경</th>
                <td>${Diameter}</td>
            </tr>
            <tr>
                <th>관통부 가로</th>
                <td>${Height}</td>
            </tr>
            <tr>
                <th>관통부 세로</th>
                <td>${Length}</td>
            </tr>
            <tr>
                <th>관통부 TYPE | PROJECTION</th>
                <td>${PenetrationType}|</td>
            </tr>
            <tr>
                <th>최대자유면적</th>
                <td>${MaximumFreeArea}</td>
            </tr>
            <tr>
                <th>최대환형거리</th>
                <td>${MaximumFreeDistance}</td>
            </tr>
            <tr>
                <th>작성자  |  검토자</th>
                <td>${Register}  | ${Reviewer}</td>
            </tr>
            <tr>
                <th>확인자</th>
                <td>${Checker}</td>
            </tr>
            
        </table>
        <table class="w_50">
            <tr>
                <th colspan="2">● 밀폐재 정보
            </tr>
            <tr>
                <th>밀폐재 재질</th>
                <td>${SealMeterial_name}</td>
            </tr>
            <tr>
                <th>밀폐재 두께 (mm)</th>
                <td>${SealThickness}</td>
            </tr>
            <tr>
                <th>밀폐재 DETAIL DWG</th>
                <td>${SealSealDetailDWG}</td>
            </tr>
            <tr>
                <th>SEAL QUALTY CLASS</th>
                <td>${SealQualityClass}</td>
            </tr>
            <tr>
                <th>댐판 재질</th>
                <td>${PressingBoardMeterial}</td>
            </tr>
            <tr>
                <th>댐판 두께</th>
                <td>${PressingBoardThickness}</td>
            </tr>
            <tr>
                <th>시공상태</th>
                <td>
                    ${ConstructionState_name}
                    
                </td><!--네모네모 -->
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
                <th>관통물질명</th>
                <td>규격X수량</td>
            </tr>
            <tr>
                <th>배관</th>
                <td>${Pipe}</td>
            </tr>
            <tr>
                <th>덕트</th>
                <td>${Duct}</td>
            </tr>
            <tr>
                <th>계장튜브</th>
                <td>${SectionTube}</td>
            </tr>
            <tr>
                <th>전선관</th>
                <td>${Conduit}</td>
            </tr>
            <tr>
                <th>케이블</th>
                <td>${Cable}</td>
            </tr>
            <tr>
                <th>트레이</th>
                <td>${Tray}</td>
            </tr>
            <tr>
                <th>커버트레이</th>
                <td>${CoverTray}</td>
            </tr>
            <tr>
                <th>기타</th>
                <td>${Etc}</td>
            </tr>
        </table>
        <table class="w_50">
            <tr>
                <th colspan="2">● 이전설계 정보
            </tr>
            <tr>
                <th>SAFE CATEGORY</th>
                <td>${SAFETY_CATEGORY}</td>
            </tr>
            <tr>
                <th>ANCHOR TYPE</th>
                <td>${ANCHORTYPE}</td>
            </tr>
            <tr>
                <th>LATERAL MOVEMENT</th>
                <td>${LATERALMOVEMENT}</td>
            </tr>
            <tr>
                <th>LINE TEMPERATURE</th>
                <td>${LINETEMPERATURE}</td>
            </tr>
            
            <tr style="height:108px">
                <th >특이사항</th>
                <td>${SpecialNote}</td>
            </tr>
        </table>
        <table class="w_100">
            <tr>
                <th colspan="6">● 성능기준
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
                <td>${VENTILATION_VALUE}</td>
                <td>${VENTILATION_VALUE_RANGE}</td>
                <td>${VENTILATION_VAL_NO}</td>
                <td>${VENTILATION_JUDGMENT}</td>
                <td>${VENTILATION_REASON}</td>
            </tr>
            <tr>
                <th>FIRE</th>
                <td>${FIRE_VALUE}</td>
                <td>${FIRE_VALUE_RANGE}</td>
                <td>${FIRE_VAL_NO}</td>
                <td>${FIRE_JUDGMENT}</td>
                <td>${FIRE_REASON}</td>
            </tr>
            <tr>
                <th>RADIATION</th>
                <td>${RADIATION_VALUE}</td>
                <td>${RADIATION_VALUE_RANGE}</td>
                <td>${RADIATION_VAL_NO}</td>
                <td>${RADIATION_JUDGMENT}</td>
                <td>${RADIATION_REASON}</td>
                
            </tr>
            <tr>
                <th>FLOOD</th>
                <td>${FLOOD_VALUE}</td>
                <td>${FLOOD_VALUE_RANGE}</td>
                <td>${FLOOD_VAL_NO}</td>
                <td>${FLOOD_JUDGMENT}</td>
                <td>${FLOOD_REASON}</td>
            </tr>
            <tr>
                <th>PRESSURE</th>
                <td>${PRESSURE_VALUE}</td>
                <td>${PRESSURE_VALUE_RANGE}</td>
                <td>${PRESSURE_VAL_NO}</td>
                <td>${PRESSURE_JUDGMENT}</td>
                <td>${PRESSURE_REASON}</td>
            </tr>
        </table>
			<table class="w_100">
				<tr>
					<th colspan="12">● 점검정보
				</tr>
				<c:forEach var="list" items="${InspectList}">
					<tr>
						<th style="width: 10%">점검주기</th>
						<th style="width: 10%">점검차수</th>
						<th style="width: 8%">점검일</th>
						<th style="width: 13%">밀폐재시공상태</th>
						<th style="width: 9%">판정</th>
						<th style="width: 50%">판단사유</th>

					</tr>
					<tr>
						<td>${list.InspectionInterval}</td>
						<td>${list.InspectSeq}</td>
						<td>${list.InspectDate}</td>
						<td>${list.SealantConditionState_name}</td>
						<td>${list.Judgment_name}</td>
						<td>${list.JudgementReason}</td>
					</tr>
					<tr>
						<th>정면사진</th>
						<th>이면사진</th>
						<th>보수일자</th>
						<th>설계변경서번호</th>
						<th>보수담당자</th>
						<th>보수내용</th>
					</tr>
					<tr>
						<td>${list.FrontPicNo}</td>
						<td>${list.BackPicNo}</td>
						<td>${list.ImproveDate}</td>
						<td>${list.DesignChangeNo}</td>
						<td>${list.ImproveMember}</td>
						<td>${list.ImproveNote}</td>
					</tr>
					
					<tr>
						<td colspan="5">
							<img id="frontImg_${list.InspectSeq}" src="DownLoadImg/${list.FrontPicNo}.png" onclick="imgBig(this)"
									onerror="javascript:this.src='images/default-img.png'" style="width:350px;height:250px">
						</td>
						<td>
							<img id="backImg_${list.InspectSeq}" src="DownLoadImg/${list.BackPicNo}.png" onclick="imgBig(this)"
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
</body>
</html>