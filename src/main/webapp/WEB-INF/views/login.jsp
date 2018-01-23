<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!--[if lt IE 7 ]> <html lang="ko" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="ko" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="ko" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="ko" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="ko" class="no-js">
<!--<![endif]-->

<head>
	<meta charset="UTF-8" />
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
	<title>관통부 관리 시스템</title>
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
	<meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
	<meta name="author" content="Codrops" />
	<link rel="shortcut icon" href="img/home.ico">
	<link rel="stylesheet" type="text/css" href="css/login-css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/login-css/style3.css" />
	<link rel="stylesheet" type="text/css" href="css/login-css/animate-custom.css" />

	<!-- 한글폰트 -->
	<link rel="stylesheet" href="css/nanumbarungothic.css" />
	<!-- icon -->
	<link rel="shortcut icon" type="image/x-icon" href="img/home.ico" />
	<!-- jQuery -->
	<script src="plugins/jquery/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css" />
	<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- login -->
	<script type="text/javascript" src="js/login.js"></script>
</head>


<%@ include file="main_head.jsp"%>
<!--#include file="./main_head.asp" -->

<body>
	<div class="login">

		<!-- div class="container"-->

		<!-- Codrops top bar -->
		<div class="codrops-top">
			<section>
				<br><br>
				<center>
					<font class="nbg18 b4">관통부 관리 시스템&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
				</center>
				<br>
			</section>

			<div class="clr">
				<!--시계-->
				<!-- <div class="clock">
					<ul>
						<li id="hours"></li>
						<li id="point">:</li>
						<li id="min"></li>
						<li id="point">:</li>
						<li id="sec"></li>
					</ul>
				</div>-->
			</div>

		</div>
		<!--/ Codrops top bar -->

		<script type="text/javascript" charset="utf-8">
			/* 현재 코드는 쿠키 동작 안함
			$(document).ready(function(){
			if($.cookie('rid')){ $("#txtUserPwd").focus(); }
			else { $("#txtUserId").focus(); }
			});
			*/

			// 위 코드는 쿠키가 동작 할때 .... 현재는 동작 하지 않아서 임시로 넣음.
			$(document).ready(function() {
				$("#txtUserId").focus();
			});

		</script>


		<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="toregister"></a>
				<a class="hiddenanchor" id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form id="loginForm" action="login" method="post" autocomplete="on">
							<input type="hidden" id="command" name="command" value="login">
							<input type="hidden" id="remCheck" name="remCheck" value="false">
							<h1>Log in</h1>
							<p>
								<c:if test="${check!=null}">
									<!-- <label for="user_id">아이디</label>  -->
									<label for="user_id" class="nbg2 b1" data-icon="u"> 사용자 아이디 </label>
									<!-- <input type="text" id="txtUserId" name="txtUserId" value="${check.id}" required="required" placeholder="아이디"> -->
									<input id="txtUserId" name="txtUserId" required="required" type="text" value="${check.id}" placeholder="아이디" />
								</c:if>
								<!--
								<c:if test="${check==null}">
									<label for="user_id" class="uname nbg1 b1" data-icon="u"> 사용자 아이디 </label>
									<input id="txtUserId" name="txtUserId" required="required" type="text" placeholder="아이디" />
								</c:if>
								-->
							</p>
							<p>

								<label for="password" class="nbg2 b1" data-icon="p"> 사용자 패스워드 </label>
								<input type="password" id="txtUserPwd" name="txtUserPwd" required="required" placeholder="eg. X8df!90EO" />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="chkRememberLogin" value="loginkeeping" />
								<label for="loginkeeping">아이디 저장</label>
							</p>
							<p class="signin button">
								<input type="submit" value="로그인" />
							</p>
							<!--
							<p class="change_link">
								사용자 추가

								<a href="javascript:void(0);" onclick="newMemberOnClick();">사용자추가</a>
							</p>
							-->
						</form>
					</div>

					<div id="register" class="animate form">
						<form action="mysuperscript.php" autocomplete="on">
							<h1> Sign up </h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">Your username</label>
								<input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
							</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e"> Your email</label>
								<input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
								<input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
								<input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p class="signin button">
								<input type="submit" value="Sign up" />
							</p>
							<p class="change_link">
								Already a member ?
								<a href="#tologin" class="to_register"> Go and log in </a>
							</p>
						</form>
					</div>

				</div>
			</div>
		</section>
	</div>
	<!-- 한글 나눔 바른 고딕 -->

</body>

</html>
