<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="css/menu.css" type="text/css" media="screen" />
	<script type="text/javascript" src="js/home_side.js"></script>
	</head>
	

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=./images/logo.jpg border=0 aria-disabled="true" >
<ul id="menu">


			<c:if test="${sessionScope.userInfo.login != true}">
            <li class="menu_right">
                <a href="/NPower/login">로그인</a>
            </li>
            </c:if>
            <c:if test="${sessionScope.userInfo.login == true}">
            <li class="menu_right">
                <a href="/NPower/home.do?command=logout">로그아웃</a>
            </li>
            </c:if>


    <li class="menu_right"><a href="#" class="">자료실</a><!-- Begin 3 columns Item -->
        
    </li> <!-- End 자료실 -->
    
    <li class="menu_right"><a href="#" class="drop">커뮤니티</a><!-- Begin 4 columns Item -->
    
    
    <div class="dropdown_2columns align_right">
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a href="#">공지사항</a></li>
                </ul>   
    
            </div>
            
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a href="#">Q/A</a></li>
                </ul>
    
            </div>
    </div>
    
    </li> <!-- End 커뮤니티 -->  


    <li class="menu_right"><a href="#" class="drop">관통부 관리</a>
    
    
        <div class="dropdown_3columns align_right">

            <div class="col_1">
    
                <ul class="greybox">
                    <li><a onclick="menuClick('PTISC')">통합관리</a></li>
                </ul>   
    
            </div>
            
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a onclick="menuClick('PTBI')">기본정보</a></li>
                </ul>
    
            </div>
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
                </ul>   
    
            </div>
            
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a onclick="menuClick('PTI')">관통재정보</a></li>
                </ul>
    
            </div>
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a onclick="menuClick('PFEV')">성능평가</a></li>
                </ul>   
    
            </div>
            
            <div class="col_1">
    
                <ul class="greybox">
                    <li><a onclick="menuClick('PTISP')">관통부점검</a></li>
                </ul>
    
            </div>
		</div>
    
    </li> <!-- End 관통부 관리 -->

    <li class="menu_right"><a href="/NPower" class="">Home</a>
              
    </li> <!-- End Home -->


</ul>

<!-- 
	
	<header><section>
	
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
			

		<li><a href="#">자료실</a>
			<ol>
				<li><a href="#">관련문서</a></li>
				<li><a href="#">업데이트 공유프로그램</a></li>
			</ol></li>

			
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
	</nav> 
</section> </header>
-->
	
