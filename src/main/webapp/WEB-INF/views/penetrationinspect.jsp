<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>관통부정보</title>

<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationinspect.js"></script>
</head>
<body>
<%@ include file="home_side.jsp"%>
<br>
	<div class="con">
        <section class="adm adm05">
            <ul class="tab">
            	<li><a onclick="menuClick('PTISC')">통합관리</a></li>
            	<li><a  onclick="menuClick('PTBI')">기본정보</a></li>
				<li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
				<li><a  onclick="menuClick('PTI')">관통재정보</a></li>
				<li><a  onclick="menuClick('PFEV')">성능평가정보</a></li>
				<li class="active"><a  onclick="menuClick('PTISP')">관통부점검</a></li>
            </ul>
            <section>
                <!-- <h2>점검정보</h2> -->
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
                        <li >
                            <label for="manag03">점검일</label>
                            <input type="text" id="InspectDate" value="2011.12.02" />
                            <!-- <input type="date" id="InspectDate" value="2011.12.02" /> -->
                            <!-- <label for="manag03" class="date_ico"></label>  -->
                        </li>
                        <li>
                            <label for="manag04">개선일</label>
                            <input type="text" id="ImproveDate" />
                            <!-- <input type="date" id="ImproveDate" /> -->
                            <!-- <label for="manag04" class="date_ico"></label>  -->
                        </li>
                        <li>
                            <label for="manag05">점검주기</label>
                            <input  id="InspectionInterval" type="text" value="" />
                        </li>
                        <li>
                            <label for="manag06">점검차수</label>
                            <input  id="InspectSeq" type="text" value="" />
                        </li>
						<!-- 
                        <li>
                            <label for="manag07">밀폐재시공상태</label>
                            <input  id="SealantConditionState_name" type="text" value="" />
                        </li>

                        <li>
                            <label for="manag08">판단사유</label>
                            <input  id="JudgementReason" type="text" value="" />
                        </li>
                        <li id="Judgment_tag">
                            <label for="manag09">판정</label>
                            <input id="manag09_01" type="checkbox" name="judg" /><label for="manag09_01">만족</label>
                            <input id="manag09_02" type="checkbox" name="judg" /><label for="manag09_02">불만족</label>

                        </li>
                        <li>
                            <label for="manag10">개선내용</label>
                            <input id="ImproveNote" type="text" value="" />
                        </li>
                        -->
                    </ul>
                    <div>
                        <input class="searchBtn" type="button" onmouseover="this.style.cursor='hand'" onclick="getSearchPenetrationinspectList()"value="검색" />
                        <input type="reset" onclick="init();" onmouseover="this.style.cursor='hand'" value="초기화" />
                        <!-- 
                        <input class="saveBtn"type="button" onmouseover="this.style.cursor='hand'" onclick="PenetrationinspectSave();"value="저장" />
                         -->
                    
                    </div>
                </form>
            </section>
           
        </section>
            <div  class="col-sm-12" id="penetrationinspect_Grid_div"></div>
            <br>
             <ol id="paging" class="pager1"></ol>
			
</div>
</body>
</html>