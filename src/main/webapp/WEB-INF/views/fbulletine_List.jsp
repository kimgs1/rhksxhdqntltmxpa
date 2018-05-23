<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/fbulletine_list.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="home_side.jsp"%>
	<div class="con1">
        <section class="board board_list">
            <h2><img src="images/cs_notice.gif"></h2><!--자료실 공지사항-->
            <div>
                <table id="bulletine_div">
                    <tr>
                        <th style="width:10%;">번호</th>
                        <th style="width:50%;">제목</th>
                        <th style="width:10%;">작성자</th>
                        <th style="width:20%;">작성일자</th>
                        <th style="width:10%;">조회</th>
                    </tr>
                    <tr>
                        <td colspan="5">등록된 데이터가 없습니다.</td>
                    </tr>
                </table>
                <ol class="pager" id="board_list_page_div">
                <br>
                <!-- 
                    <li><a href="#"><img src="images/pager_01.png" /></a></li>
                    <li><a href="#"><img src="images/pager_02.png" /></a></li>
                    <li><a href="#"><img src="images/pager_03.png" /></a></li>
                    <li><a href="#" class="active">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><a href="#">10</a></li>
                    <li><a href="#" style="transform: rotate(180deg)"><img src="images/pager_04.png" /></a></li>
                    <li><a href="#"><img src="images/pager_05.png" /></a></li>
                    <li><a href="#" style="transform: rotate(180deg)"><img src="images/pager_01.png" /></a></li>
                 -->
                </ol>
                <!-- :if test="${sessionScope.userInfo.login == true}" -->
			<c:if test="${sessionScope.userInfo.id == 'admin'}">
                <span><input type="button" style="cursor:hand" onclick="newBulletine()" value="글쓰기" /></span>
                </c:if>
            </div>
            
            <!-- 
            <div class="bo_search">
                <select>
                    <option>전체</option>
                    <option>작성자</option>
                    <option>내용</option>
                </select>
                <input type="search" />
                <input type="button" value="검색"/>
            </div>
             -->
        </section>
    </div>
</body>
</html>