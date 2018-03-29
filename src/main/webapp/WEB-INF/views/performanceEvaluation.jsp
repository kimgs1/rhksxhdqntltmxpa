<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>관통부정보</title>

<%@ include file="main_head.jsp"%>


<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/performanceEvaluation.js"></script>
</head>
<body>

<%@ include file="home_side.jsp"%>
 <div class="con">
        <section class="adm adm04">
            <ul class="tab">
            	<li><a onclick="menuClick('PTISC')">통합관리</a></li>
            	<li><a  onclick="menuClick('PTBI')">기본정보</a></li>
				<li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
				<li><a  onclick="menuClick('PTI')">관통재정보</a></li>
				<li class="active"><a  onclick="menuClick('PFEV')">성능평가정보</a></li>
				<li><a  onclick="menuClick('PTISP')">관통부점검</a></li>
            </ul>
            <section>
                <!-- <h2>성능평가정보</h2> -->
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
                        <!-- 
                        <li id="RequirePerformance_tag" style="width:800px">
                            <label for="manag03">요구성능</label>
                            <input id="manag03_01" type="checkbox" name="perform" /><label for="manag03_01">환기</label>
                            <input id="manag03_02" type="checkbox" name="perform" /><label for="manag03_02">내화</label>
                            <input id="manag03_03" type="checkbox" name="perform" /><label for="manag03_03">방사선자폐</label>
                            <input id="manag03_04" type="checkbox" name="perform" /><label for="manag03_04">수밀</label>
                            <input id="manag03_05" type="checkbox" name="perform" /><label for="manag03_05">내압</label>
                        </li>
                         -->
                        <li id="EvaluationResult_tag">
                            <label for="manag04">평가결과</label>
                            <input id="manag04_01" type="checkbox" name="sati" /><label for="manag04_01">만족</label>
                            <input id="manag04_02" type="checkbox" name="sati" /><label for="manag04_02">불만족</label>

                        </li>
                        <li>
                            <label for="manag05">내화등급</label>
                            <input  id="FIRE_VALUE_RANGE" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag06">내압(PSI)</label>
                            <input  id="PRESSURE_VALUE_RANGE" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag07">수밀</label>
                            <input  id="FLOOD_VALUE_RANGE" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag08">방사선차폐</label>
                            <input  id="RADIATION_VALUE_RANGE" type="text" value="" />
                        </li>
                    </ul>
                    <div>
                        
                    <div>
                        <input class="searchBtn" type="button" onmouseover="this.style.cursor='hand'" onclick="getSearchPerformanceEvaluationList()"value="검색" />
                        <input type="reset" onclick="init();" onmouseover="this.style.cursor='hand'" value="초기화" />
                        <!-- 
                        <input class="saveBtn"type="button" onmouseover="this.style.cursor='hand'" onclick="PerformanceEvaluationSave();"value="저장" />
                         -->
                    </div>
                    </div>
                </form>
            </section>
            
        </section>
            <div  class="col-sm-12" id="performanceEvaluation_Grid_div"></div>
			<br><br><br>
</div>
</body>
</html>