<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationbaseinfo.js"></script>
</head>
<body>
<%@ include file="home_side.jsp"%>
<br>
	<div id="homeContentDiv" class="con">
        <section class="adm adm01">
            <ul class="tab">
            	<li><a onclick="menuClick('PTISC')">통합관리</a></li>
            	<li class="active"><a onclick="menuClick('PTBI')">기본정보</a></li>
				<li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
				<li><a onclick="menuClick('PTI')">관통재정보</a></li>
				<li><a onclick="menuClick('PFEV')">성능평가</a></li>
				<li><a onclick="menuClick('PTISP')">관통부점검</a></li>
            </ul>
            <section>
                <!-- <h2>기본정보</h2>  -->
                <form action="#">
                    <ul>
                    	<li hidden="true">
                    		<input id="Seq" type="text" value=""/>
                    	</li>
                        <li>
                            <label for="manag01">관리번호</label>
                            <input id="ManagementNo" type="text" value=""/>
                        </li>
                        <li>
                            <label for="manag02">관통부번호</label>
                            <input id="PenetrationNo" type="text" value=""/>
                        </li> 
                        <li>
                        <!-- 
                            <label for="manag04">ELEVATION</label>
                            <input id="Elevation" type="text" value=""/>
                         -->
                            
                            <label>ELEVATION</label>
	                            <select id="ELEVATION_cal_flag">
		                            <option value="=" selected>=</option>
		                            <option value=">">&gt;</option>
		                            <option value=">=">&ge;</option>
		                            <option value="<">&lt;</option>
		                            <option value="<=">&le;</option>
	                            </select>
	                            <input id="ELEVATION_num_pit" style="width:60px" type="text" onkeyup="clearNoNum_2(this);"/> '-
	                            <input id="ELEVATION_num_inc" style="width:60px" type="text" onkeyup="clearNoNum_2(this);"/> "
                            
                        </li>
                        <li id="EquipNo_tag">
                            <label for="manag03">호기</label>
                        </li>
                        <li id="LocNo_tag">
                            <label for="manag03">건물</label>
                        </li>
                        <li>
                            <label for="manag03">관리구역여부</label>
                            <input id=ManagementAreaYN type="text" value=""/>
                        </li>
                        
                        <li>
                            <label for="manag05">방화지역번호</label>
                            <input  id="FirePreventionAreaNo" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag06">점검방번호</label>
                            <input  id="InspectionRoomNo" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag07">이면방번호</label>
                            <input  id="BackRoomNo" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag08">벽,바닥번호</label>
                            <input  id="Wall_FloorNo" type="text" value="" />
                        </li>
                        <li id="FirewallYN_tag">
                            <label>방화벽 여부</label><!--radio-->
                            <input type="radio" name="FirewallYN" value="Y" checked/><label for="manag09_01">방화벽</label>
                            <input type="radio" name="FirewallYN" value="N"/><label for="manag09_02">비방화벽</label>
                        </li>
                        <li id="PenetrationForm_tag">
                            <label>관통부형태</label><!--radio-->
                            <input type="radio" name="PenetrationForm" checked/><label for="manag10_01">원형</label>
                            <input type="radio" name="PenetrationForm"/><label for="manag10_02">사각</label>
                        </li>
                        <li id="WallMeterial_tag">
                            <label>벽재질</label><!--selector-->
                            <select name="mat" id="WallMeterial">
                                <option value="cw">cw</option>
                                <option value="cw1">cw1</option>
                                <option value="cw2">cw2</option>
                            </select>
                        </li>
                        <li>
                            <label for="manag12">벽두께(inch)</label>
                            <input  id="WallThickness" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag13">정면사진번호</label>
                            <input  id="FrontPicNo" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag14">이면사진번호</label>
                            <input  id="BackPicNolp1" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag15">참조도면번호</label>
                            <input  id="ReferenceFloorPlanNo" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag16">위치도면번호</label>
                            <input  id="LocationFloorPlanNo" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag17">SEAL DETAIL DWG</label>
                            <input  id="SealDetailDWG" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag18">관통부 EL</label>
                            <input  id="EL" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag19">관통부 직경</label>
                            <input  id="Diameter" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag20">관통부 가로</label>
                            <input  id="Height" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag21">관통부 세로</label>
                            <input  id="Length" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag22">TYPE/PROJECTION</label>
                            <input  id="PenetrationType" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag23">최대자유면적</label>
                            <input  id="MaximumFreeArea" type="text" value="" />
                        </li>

                        <li>
                            <label for="manag24">최대환형거리</label>
                            <input  id="MaximumFreeDistance" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag25">작성자</label>
                            <input  id="Register" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag26">검토자</label>
                            <input  id="Reviewer" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag27">확인자</label>
                            <input  id="Checker" type="text" value="" />
                        </li>
                        <li  style="width:66.66%">
                            <label for="manag28"  style="width:23%">특이사항</label>
                            <input  id="SpecialNote" type="text" value="" style="width:75%"/>
                        </li>
                        <li>
                            <label for="manag29">백업일</label>
                            <span id="RegDateTime"></span>
                        </li>
                        
                    </ul>
                    <div>
                        <input class="searchBtn" type="button" onmouseover="this.style.cursor='hand'" onclick="getSearchPenetrationbaseinfoList()"value="검색" />
                        <input style="margin-left: 15px" type="reset" onmouseover="this.style.cursor='hand'" onclick="init();" value="초기화" />
                        <!--<input class="saveBtn"type="button" onclick="PenetrationbaseinfoSave();"value="저장" />검색도 저장도 submit?-->
                    </div>
                </form>
            </section>
        </section>
			<div class="col-sm-12" id="penetrationbaseinfo_Grid_div"></div>
			<br><br><br>
</div>
</body>
</html>