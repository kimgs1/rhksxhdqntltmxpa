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

<!-- 
h6 {
    position: relative;
    left: -141px;
    margin-bottom: -63px;
    width: 140px;
    opacity: 0.99;
}
 -->
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=./images/logo.jpg border=0 aria-disabled="true" >
<ul id="tmenu">


		<c:if test="${sessionScope.userInfo.id == 'admin'}">
		

		<li class="tmenu_right"><a href="#" class="drop">시스템관리</a>
		
		<div class="dropdown_2columns align_right">
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('USMNG')">사용자관리</a></li>
                </ul>   
            </div>
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('CDMNG')">코드관리</a></li>
                </ul>   
            </div>				
				
			</div>
			</c:if>


			<c:if test="${sessionScope.userInfo.login != true}">
            <li class="tmenu_right">
                <a href="/NPower/login">로그인</a>
            </li>
            </c:if>
            <c:if test="${sessionScope.userInfo.login == true}">
            <li class="tmenu_right">
                <a href="/NPower/home.do?command=logout">로그아웃</a>
            </li>
            </c:if>


    <li class="tmenu_right"><a href="#" class="">자료실</a><!-- Begin 3 columns Item -->
        
    </li> <!-- End 자료실 -->
    
    <li class="tmenu_right"><a href="#" class="drop">커뮤니티</a><!-- Begin 4 columns Item -->
    
    
    <div class="dropdown_2columns align_left">
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('FBUL')">공지사항</a></li>
                </ul>
            </div>
            
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('QNA')">자주하는질문</a></li>
                </ul>
            </div>
    </div>
    
    </li> <!-- End 커뮤니티 -->  


    <li class="tmenu_right"><a href="#" class="drop">관통부 관리</a>
    
    
        <div class="dropdown_2columns align_left">

            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('PTISC')">통합관리</a></li>
                </ul>   
            </div>
            
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('PTBI')">기본정보</a></li>
                </ul>
            </div>

            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('SEAL')">밀폐재정보</a></li>
                </ul>   
            </div>
            
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('PTI')">관통재정보</a></li>
                </ul>
            </div>

            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('PFEV')">성능평가</a></li>
                </ul>   
            </div>
            
            <div class="cols_1">
                <ul class="greybox" onmouseover="this.style.cursor='hand'">
                    <li><a onclick="menuClick('PTISP')">관통부점검</a></li>
                </ul>
            </div>
		</div>
    
    </li> <!-- End 관통부 관리 -->

    <li class="tmenu_right"><a href="/NPower" class="">Home</a>
              
    </li> <!-- End Home -->


</ul>


	
