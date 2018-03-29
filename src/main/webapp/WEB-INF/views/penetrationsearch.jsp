<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>관통부정보</title>

<%@ include file="main_head.jsp"%>


<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/penetrationsearch.js"></script>
</head>
<body>

<%@ include file="home_side.jsp"%>
    <!--글로벌속성 FIN-->    
    <div class="con1 sub01">
    	<section class="adm">
    			<table border=0 width=800 height=0 cellspacing=0 cellpadding=0>
    			<th><img src=./images/blink.gif width=12 height=1></th>
    			<th><ul class="tab">
            	<li class="active"><a onclick="menuClick('PTISC')">통합관리</a></li>
            	<li><a  onclick="menuClick('PTBI')">기본정보</a></li>
				<li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
				<li><a  onclick="menuClick('PTI')">관통재정보</a></li>
				<li><a  onclick="menuClick('PFEV')">성능평가정보</a></li>
				<li><a  onclick="menuClick('PTISP')">관통부점검</a></li>
            </ul></th></table>
</section>
        <section class="sec01">
            
                <form action="#">
                    <ul>
                        <li>
                            <label for="PenetrationNo">관통부번호</label>
                            <input id="PenetrationNo" type="text" />
                        </li>
                        <!-- 
	                        <li>
	                            <label for="PenetrationNo">관리번호</label>
	                            <input id="PenetrationNo" type="text" />
	                        </li>
                         -->
                        
                        <li id="Equip_tag">
                        </li>
                        <li>
                            <label>ELEVATION</label>
                            <select id="ELEVATION_cal_flag">
	                            <option value="=" selected>=</option>
	                            <option value=">">&gt;</option>
	                            <option value=">=">&ge;</option>
	                            <option value="<">&lt;</option>
	                            <option value="<=">&le;</option>
                            </select>
                            <input id="ELEVATION_num_pit" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> '-
                            <input id="ELEVATION_num_inc" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> "
                        </li>
                        
                         <li>
                            <label>ELEVATION</label>
                            <select id="ELEVATION_cal_flag_2">
	                            <option value="=" selected>=</option>
	                            <option value=">">&gt;</option>
	                            <option value=">=">&ge;</option>
	                            <option value="<">&lt;</option>
	                            <option value="<=">&le;</option>
                            </select>
                            <input id="ELEVATION_num_pit_2" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> '-
                            <input id="ELEVATION_num_inc_2" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> "
                        </li>
                        
                        
                        <li>
                            <label>관통부 직경</label>
                            <select id="Diameter_cal_flag">
	                            <option value="=" selected>=</option>
	                            <option value=">">&gt;</option>
	                            <option value=">=">&ge;</option>
	                            <option value="<">&lt;</option>
	                            <option value="<=">&le;</option>
                            </select>
                            <input id="Diameter_num_pit" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> '-
                            <input id="Diameter_num_inc" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> "
                        </li>
                        
                        
                        <li>
                            <label>관통부 가로</label>
                            <select id="Height_cal_flag">
	                            <option value="=" selected>=</option>
	                            <option value=">">&gt;</option>
	                            <option value=">=">&ge;</option>
	                            <option value="<">&lt;</option>
	                            <option value="<=">&le;</option>
                            </select>
                            <input id="Height_num_pit" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> '-
                            <input id="Height_num_inc" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> "
                        </li>
                        
                         <li>
                            <label>관통부 세로</label>
                            <select id="Length_cal_flag">
	                            <option value="=" selected>=</option>
	                            <option value=">">&gt;</option>
	                            <option value=">=">&ge;</option>
	                            <option value="<">&lt;</option>
	                            <option value="<=">&le;</option>
                            </select>
                            <input id="Length_num_pit" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> '-
                            <input id="Length_num_inc" style="width:150px" type="text" onkeyup="clearNoNum_2(this);"/> "
                        </li>
                        
                        <li id="Location_tag">
                        </li>
                        <li id = "WallMeterial_tag" style="width:1500px">
                        </li>
                        <li id= "ConstructionState_tag" style="width:1500px">
                        </li>
                        <li id= "Area_tag">
                        </li>
                        
                        <li id= "Wall_YN_tag" >
                        </li>
                        <li id= "Efficient_tag" >
                        </li>
                        <li id= "Result_tag" >
                        </li>
                      
                      
                    </ul>
                    <div>
                        <input class="searchBtn" type="button" onmouseover="this.style.cursor='hand'" onclick="getSearchPenetrationsearchList()" value="검색" />
                        <input type="reset" onmouseover="this.style.cursor='hand'" value="초기화" />
                    </div>
                </form>
        </section>
        
        <section class="sec02">
        	<div>
        	
                <c:if test="${sessionScope.userInfo.login == true}">
        					<input onclick="CreateDetailView()" onmouseover="this.style.cursor='hand'"
										style="width: 60px; height: 20px; line-height: 20px; font-size: 13px; font-weight: 400; color: #fff; background: url(images/ico_show.png) no-repeat 7px center #ff8511; padding-left: 23px; border: 0; border-radius: 5px;"
										type="button" value="추가">
				</c:if>
                <p id="page_detail"></p>
            </div>
            <br/>
           <div id="penetrationsearch_Grid_div"></div>
           <br/>
           <ol id="paging" class="pager1"></ol>
        </section>
        
</div>
</body>
</html>