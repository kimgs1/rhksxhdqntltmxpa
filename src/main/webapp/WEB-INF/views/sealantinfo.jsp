<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/sealantinfo.js"></script>
</head>

<body>
<%@ include file="home_side.jsp"%>
	<div id="homeContentDiv" class="con">
        <section class="adm adm02">
            <ul class="tab">
            	<li ><a onclick="menuClick('PTBI')">기본정보</a></li>
				<li class="active"><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
				<li><a  onclick="menuClick('PTI')">관통재정보</a></li>
				<li><a  onclick="menuClick('PFEV')">성능평가</a></li>
				<li><a  onclick="menuClick('PTISP')">관통부점검</a></li>
            </ul>
            <section>
                <h2>밀페재정보</h2>
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
                        <li id="ConstructionState_tag" style="width:100%" hidden="true">
                            <label >시공상태</label>
                            <input id="manag03_01" type="checkbox" name="condition" /><label for="manag03_01">양호</label>
                            <input id="manag03_02" type="checkbox" name="condition" /><label for="manag03_02">비밀폐</label>
                            <input id="manag03_03" type="checkbox" name="condition" /><label for="manag03_03">파손</label>
                        </li>
                        <li>
                            <label for="manag04">SEAL QUALITY CLASS</label>
                            <input id="SealQualityClass" type="text" value=""/>
                        </li>
                        <!--
                        <li>
                        
                            <label for="manag05">밀폐제재질</label>
                            <input  id="SealMeterial" type="text" value="" />
                        </li>
                          -->
                        <li>
                            <label for="manag06">밀폐재두꼐</label>
                            <input  id="SealThickness" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag07">댐판재질</label>
                            <input  id="PressingBoardMeterial" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag08">댐판두께</label>
                            <input  id="PressingBoardThickness" type="text" value="" />
                        </li>
                    </ul>
                    <div>
                        <input class="searchBtn" type="button" onclick="getSearchSealantinfoList()"value="검색" />
                        <input type="reset" onclick="init();" value="초기화" />
                        <!-- 
                        <input class="saveBtn"type="button" onclick="SealantinfoSave();"value="저장" />
                         -->
                    </div>
                </form>
            </section>
        </section>
			<div class="col-sm-12" id="sealantinfo_Grid_div"></div>

</div>
</body>
</html>