<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
	<%@ include file="main_head.jsp"%>
</head>
<body>
	
	
<html>

<%@ include file="home_side.jsp"%>

	<div class="main">
		<script>
        $(document).ready(function () {
            $(".tab_content").hide();
            $(".tab_content:first").show();

            $(".tabs li").click(function () {
                $(".tabs li").removeClass("active");
                $(this).addClass("active");
                $(".tab_content").hide();
                var activeTab = $(this).attr("rel");
                $("#" + activeTab).fadeIn();
            });
        });       
        $(document).ready(function () {
            $(".tab_content2").hide();
            $(".tab_content2:first").show();

            $(".tabs2 li").click(function () {
                $(".tabs2 li").removeClass("active");
                $(this).addClass("active");
                $(".tab_content2").hide();
                var activeTab = $(this).attr("rel");
                $("#" + activeTab).fadeIn();
            });
        });
    </script><!--탭스크립트-->
<script type="text/javascript" src="js/home.js"></script>

 <div class="con1">
        <div class="section01">
            <article id="bulletine_div">
                <h2>공지사항</h2>
                <ul>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">공지사항 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">공지사항 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">공지사항 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">공지사항 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">공지사항 데이타 로딩중...</a>
                    </li>                    
                </ul>
            </article>
            <article id="qna_div">
                <h2>자주하는 질문</h2>
                <ul>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">Q & A 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">Q & A 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">Q & A 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">Q & A 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">Q & A 데이타 로딩중...</a>
                    </li>
                </ul>
            </article>
            <article id="download_div">
                <h2>자료실</h2>
                <ul>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">자료실 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">자료실 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">자료실 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">자료실 데이타 로딩중...</a>
                    </li>
                    <li onmouseover="this.style.color='#efefef'">
                        <a href="#">자료실 데이타 로딩중...</a>
                    </li>
                </ul>
            </article>
        </div>
        <div class="section02">
            <section>
                <h2>관통부 기본정보</h2>
                <div id="container">
                    <ul class="tabs">
                        <li rel="tab1" class="active" onclick="tabClick('DepartmentChart_div')">부서별</li>
                        <li rel="tab2" onclick="tabClick('sealantMaterialChart_div')">밀페재 종류</li>
                        <li rel="tab3" onclick="tabClick('ConstructionStateChart_div')">밀페재 시공상태</li>
                        <li rel="tab4" onclick="tabClick('LocChart_div')">건물별 관통부수량</li>
                        <li rel="tab5" onclick="tabClick('EffectChart_div')">요구성능</li>
                        <li rel="tab6" onclick="tabClick('WallMeterialChart_div')">벽재질</li>
                        
                    </ul>
                    <div class="tab_container" id= "tab_container">
                    
                        <div id="tab1" class="tab_content">
                        	<div id="DepartmentChart_div">
                            	<svg style="height: 200px; width:100%"></svg>
                            </div>
                        </div>
                        
                        <div id="tab2" class="tab_content">
                        	 <div id="sealantMaterialChart_div">
	                            	<svg style="height: 200px; width:100%"></svg>
	                        </div>
                        </div>
                        
                        <div id="tab3" class="tab_content">
                            <div id="ConstructionStateChart_div">
                            	<svg style="height: 200px; width:100%"></svg>
                            </div>
                        </div>
                        <div id="tab4" class="tab_content">
                            <div id="LocChart_div">
                            	<svg style="height: 200px; width:100%"></svg>
                            </div>
                        </div>
                        
                        <div id="tab5" class="tab_content">
	                        <div id="EffectChart_div">
	                            	<svg style="height: 200px; width:100%"></svg>
	                        </div>
                        </div>
                        <div id="tab6" class="tab_content">
                            <div id="WallMeterialChart_div">
                            	<svg style="height: 200px; width:100%"></svg>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <article><!--어떤기능이지..?-->
                <h2>건물 관통부 개수</h2>
                <p class="nbg2 b4">합계 : <span id="total_count">로딩중...</span></p>
                <ul id="EquipNoLocNoData_div">
                    <li>6호기-PAB<span>로딩중...</span></li>
                    <li>5호기-PAB<span>로딩중...</span></li>
                    <li>공통-RWB<span>로딩중...</span></li>
                    <li>6호기-SAB<span>로딩중...</span></li>
                    <li>5호기-SAB<span>로딩중...</span></li>
                    <li>5호기-TGB<span>로딩중...</span></li>
                    <li>6호기-TGB<span>로딩중...</span></li>
                </ul>
            </article>
        </div>
        <div id="container2" >
            <div id="MergeGrid_div" style="margin-left:16px;margin-right:16px;margin-top:18px;">
            </div>
        </div>
        <br><br><br>
    </div>


	<div class="col-sm-12" hidden="true">
		<div class="col-sm-12">
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li class="dropdown user user-menu">
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('FBUL')">
							공지사항</button>
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('QNA')">
							Q&A</button>
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('PTBI')">
							교통부기본정보</button>
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('PTI')">
							교통부정보</button>
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('PTISP')">
							관통부점검정보</button>
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('PFEV')">
							성능평가정보</button>
						<button type="button" class="btn btn-sm btn-default" id=""
							style="margin-right: 10px" onclick="menuClick('CDMNG')">
							공통코드관리</button>


					</li>
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><span
							class="hidden-xs" id="username_label"></span></a></li>

					<li class="dropdown user user-menu" style="margin: 10px;">
						<c:if test="${sessionScope.userInfo != null}">
							<button type="button" class="btn btn-sm btn-default"
								id="user_name_tag" style="margin-right: 10px" hidden="true">${sessionScope.userInfo.username}</button>
						</c:if>
						<button type="button" class="btn btn-sm btn-default"
							id="userinf_edit">정보수정</button>
						<button type="button" class="btn btn-sm btn-default"
							id="logout_btn" onclick="logout();" style="margin-right: 10px">로그아웃</button>
					</li>
				</ul>
			</div>
		</div>

		<div class="col-sm-6">
			<div class="col-sm-12">
				<div class="col-sm-2" onclick="newBulletine();">공지사항 글쓰기</div>
				<div id="bulletine_div" class="col-sm-12">
					<div style="color: blue" onclick="getBulletineContent(4)"
						hidden="true"></div>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-sm-2" onclick="newQNA();">자주하는 질문 글쓰기</div>
			<div id="bulletine_div" class="col-sm-12">
				<div style="color: blue" onclick="getQNAContent(4)" hidden="true"></div>
			</div>
		</div>
	</div>






	</div>
</div> <!-- home_side.jsp에 wrapper div close -->

</body>
</html>