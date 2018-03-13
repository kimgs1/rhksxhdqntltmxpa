<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
	<script type="text/javascript" src="js/home_side.js"></script>
	<script type="text/javascript">
	        $(document).ready(function () {
	            setInterval(function () {
	                // Create a newDate() object and extract the minutes of the current time on the visitor's
	                var minutes = new Date().getMinutes();
	                // Add a leading zero to the minutes value
	                $("#min").html((minutes < 10 ? "0" : "") + minutes);
	            }, 1000);
	
	            setInterval(function () {
	                // Create a newDate() object and extract the hours of the current time on the visitor's
	                var hours = new Date().getHours();
	                // Add a leading zero to the hours value
	                $("#hours").html((hours < 10 ? "0" : "") + hours);
	            }, 1000);
	        });
	        sessionVar = '<%=session.getAttribute("userInfo")%>';
	        if(sessionVar.split('true').length > 1){
	        	loginflag = true;
	        }else{
	        	loginflag = false;
	        }
	    	
	    </script><!--시계 스크립트-->
	</head>
	
    
	
	<header>
	
	
	<section>
	
	<ul class="top_nav">
            <li>
                <a id="user_name" onclick="window.open(this.href, '', 'width=630, height=555, top=200'); return false;"> &nbsp;</a>
            </li>
            
			<c:if test="${sessionScope.userInfo.login != true}">
            <li>
                <a href="/NPower/login">로그인</a>
            </li>
            </c:if>
            <c:if test="${sessionScope.userInfo.login == true}">
            <li>
                <a href="/NPower/home.do?command=logout">로그아웃</a>
            </li>
            </c:if>
        </ul>
	<h1>
		<a >logo</a>
	</h1>
	<nav>
	<ul>
		<li><a href="/NPower">HOME</a></li>
		<li><a onclick="menuClick('PTISC')">관통부관리</a>
			<ol>
				<li><a onclick="menuClick('PTBI')">기본정보</a></li>
				<li><a onclick="menuClick('SEAL')" >밀폐재정보</a></li>
				<li><a onclick="menuClick('PTI')">관통재정보</a></li>
				<li><a onclick="menuClick('PFEV')">성능평가</a></li>
				<li><a onclick="menuClick('PTISP')">관통부점검</a></li>
			</ol></li>
			
			<!-- 
		<li><a href="#">자료실</a>
			<ol>
				<li><a href="#">관련문서</a></li>
				<li><a href="#">업데이트 공유프로그램</a></li>
			</ol></li>
			 -->
			
		<li><a href="#">커뮤니티</a>
			<ol>
				<li><a onclick="menuClick('FBUL')">공지사항</a></li>
				<li><a onclick="menuClick('QNA')">Q&amp;A</a></li>
			</ol></li>
			
			<c:if test="${sessionScope.userInfo.id == 'admin'}">
		<li><a href="#">시스템관리</a>
			<ol>
				<li><a onclick="menuClick('USMNG')">사용자관리</a></li>
				<li><a onclick="menuClick('CDMNG')">코드관리</a></li>
			</ol></li>
			</c:if>
	</ul>
	</nav> </section> </header>
	<aside>
	<br>
	<div id="date" class="wrap">
		<!--달력 임시로 끼워놨어욥! 스크립트도 안에 있어욥 global.css 36~44번라인 -->
		<div class='btn-holder'>
			<button id='btnPrev'>&lt;</button>
			<span id='currentDate'></span>
			<button id='btnNext'>&gt;</button>
		</div>
		<div id="calendar"></div>
		<script>
                var calendar = new controller();
                calendar.init();

                function controller(target) {

                    var that = this;
                    var m_oMonth = new Date();
                    m_oMonth.setDate(1);

                    this.init = function () {
                        that.renderCalendar();
                        that.initEvent();
                    }

                    /* 달력 UI 생성 */
                    this.renderCalendar = function () {
                        var arrTable = [];

                        arrTable.push('<table><colgroup>');
                        for (var i = 0; i < 7; i++) {
                            arrTable.push('<col width="100">');
                        }
                        arrTable.push('</colgroup><thead><tr>');

                        var arrWeek = "일월화수목금토".split("");

                        for (var i = 0, len = arrWeek.length; i < len; i++) {
                            var sClass = '';
                            sClass += i % 7 == 0 ? 'sun' : '';
                            sClass += i % 7 == 6 ? 'sat' : '';
                            arrTable.push('<td class="' + sClass + '">' + arrWeek[i] + '</td>');
                        }
                        arrTable.push('</tr></thead>');
                        arrTable.push('<tbody>');

                        var oStartDt = new Date(m_oMonth.getTime());
                        // 1일에서 1일의 요일을 빼면 그 주 첫번째 날이 나온다.
                        oStartDt.setDate(oStartDt.getDate() - oStartDt.getDay());

                        for (var i = 0; i < 100; i++) {
                            if (i % 7 == 0) {
                                arrTable.push('<tr>');
                            }

                            var sClass = 'date-cell '
                            sClass += m_oMonth.getMonth() != oStartDt.getMonth() ? 'not-this-month ' : '';
                            sClass += i % 7 == 0 ? 'sun' : '';
                            sClass += i % 7 == 6 ? 'sat' : '';

                            arrTable.push('<td class="' + sClass + '">' + oStartDt.getDate() + '</td>');
                            oStartDt.setDate(oStartDt.getDate() + 1);

                            if (i % 7 == 6) {
                                arrTable.push('</tr>');
                                if (m_oMonth.getMonth() != oStartDt.getMonth()) {
                                    break;
                                }
                            }
                        }
                        arrTable.push('</tbody></table>');

                        $('#calendar').html(arrTable.join(""));

                        that.changeMonth();
                    }

                    /* Next, Prev 버튼 이벤트 */
                    this.initEvent = function () {
                        $('#btnPrev').click(that.onPrevCalendar);
                        $('#btnNext').click(that.onNextCalendar);
                    }

                    /* 이전 달력 */
                    this.onPrevCalendar = function () {
                        m_oMonth.setMonth(m_oMonth.getMonth() - 1);
                        that.renderCalendar();
                    }

                    /* 다음 달력 */
                    this.onNextCalendar = function () {
                        m_oMonth.setMonth(m_oMonth.getMonth() + 1);
                        that.renderCalendar();
                    }

                    /* 달력 이동되면 상단에 현재 년 월 다시 표시 */
                    this.changeMonth = function () {
                        $('#currentDate').text(that.getYearMonth(m_oMonth).substr(0, 9));
                    }

                    /* 날짜 객체를 년 월 문자 형식으로 변환 */
                    this.getYearMonth = function (oDate) {
                        return oDate.getFullYear() + '년 ' + (oDate.getMonth() + 1) + '월';
                    }
                }
            </script>
	</div>
	</aside>