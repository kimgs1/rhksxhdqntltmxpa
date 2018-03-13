<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>관통부정보</title>

<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationinfo.js"></script>
</head>
<body>

<%@ include file="home_side.jsp"%>
<div class="con">
        <section class="adm adm02">
            <ul class="tab">
            	<li><a onclick="menuClick('PTBI')">기본정보</a></li>
				<li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
				<li class="active"><a  onclick="menuClick('PTI')">관통제정보</a></li>
				<li><a  onclick="menuClick('PFEV')">성능평가</a></li>
				<li><a  onclick="menuClick('PTISP')">관통부점검</a></li>
            </ul>
            <section>
                <h2>밀폐재정보</h2>
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
                        <li id="matter_tag" style="width:100%;" hidden="true">
                            <label style="width:20%;">관통재종류</label><!--radio-->
                            <input id="manag03_01" type="checkbox" name="kinds" /><label for="manag03_01">배관</label>
                            <input id="manag03_02" type="checkbox" name="kinds" /><label for="manag03_02">덕트</label>
                            <input id="manag03_03" type="checkbox" name="kinds" /><label for="manag03_03">계장</label>
                            <input id="manag03_04" type="checkbox" name="kinds" /><label for="manag03_04">전선관</label>
                            <input id="manag03_05" type="checkbox" name="kinds" /><label for="manag03_05">케이블</label>
                            <input id="manag03_06" type="checkbox" name="kinds" /><label for="manag03_06">트레이</label>
                            <input id="manag03_07" type="checkbox" name="kinds" /><label for="manag03_07">기타</label>
                        </li>
                       
                        <li>
                            <label for="manag04">배관</label>
                            <input id="Pipe" type="text" value=""/>
                        </li>
                        <li>
                            <label for="manag05">덕트</label>
                            <input  id="Duct" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag06">계장튜브</label>
                            <input  id="SectionTube" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag07">전선관</label>
                            <input  id="Conduit" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag08">케이블</label>
                            <input  id="Cable" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag09">트레이</label>
                            <input id="Tray" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag10">커버트레이</label>
                            <input id="CoverTray" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag11">기타</label>
                            <input id="Etc" type="text" value="" />
                        </li>
                    </ul>
                    <div>
                        <input class="searchBtn" type="button" onclick="getSearchPenetrationinfoList()"value="검색" />
                        <input type="reset" onclick="init();" value="초기화" />
                        <!-- 
                        <input class="saveBtn"type="button" onclick="PenetrationinfoSave();"value="저장" />
                         -->
                    </div>
                </form>
            </section>
        </section>
         	<div  class="col-sm-12" id="penetrationinfo_Grid_div"></div>
         	</div>


</html>