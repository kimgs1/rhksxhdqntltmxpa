<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="con sub01">
        <section class="sec01">
            <h2>관통부 기본검색</h2>
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
                        
                        <li>
                            <label>ELEVATION</label>
                            <select id="ELEVATION_cal_flag">
	                            <option value="=" selected>=</option>
	                            <option value=">">&gt;</option>
	                            <option value=">=">&ge;</option>
	                            <option value="<">&lt;</option>
	                            <option value="<=">&le;</option>
                            </select>
                            <input id="ELEVATION_num_pit" style="width:150px" type="text" /> '-
                            <input id="ELEVATION_num_inc" style="width:150px" type="text" /> "
                        </li>
                        
                        <li id="Equip_tag">
                        </li>
                        <li id="Location_tag">
                        </li>
                        <li id = "WallMeterial_tag" style="width:800px">
                        </li>
                        <li id= "ConstructionState_tag" style="width:800px">
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
                        <input class="searchBtn" type="button" onclick="getSearchPenetrationsearchList()" value="검색" />
                        <input type="reset" value="초기화" />
                    </div>
                </form>
        </section>
        <section class="sec02">
        	<div>
                <p id="page_detail"></p>
            </div>
            <br/>
           <div id="penetrationsearch_Grid_div">
           </div>
           <br/>
           <ol id="paging" class="pager">
               
            </ol>
        </section>
    </div>
</html>