<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>사용자 관리</title>

<%@ include file="main_head.jsp"%>
<%@ include file="/views/modal.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/userManage.js"></script>
</head>
<body>
	<%@ include file="home_side.jsp"%>
	<div class="con">
	<h2><img src="images/cs_user.gif"><br><br></h2><!--사용자 관리-->
		<div class="row" id="user_div">
			<div class="col-sm-12">
				<button onclick="newMemberOnClick(false)" style="cursor:hand; margin-bottom:10px;width:130px; height:25px; margin-right:20px; font-size:14px; font-weight:700; border-radius:5px; background: linear-gradient( to bottom, white, #c1d4f1 ); border:1px solid #b3caeb; color:#2e4481;">
				추가</button>
				 <font color=ef2f2f>*(주의: "admin"계정 삭제 및 수정은 반듯이 본 시스템 관리자와 협의 후 적용하세요. 임의 수정시 치명적인 오류가 발생 할 수 있습니다.)</font>
			</div>
			<div class="col-sm-12">
				<div class="col-sm-12" id="usermanage_Grid_div"></div>
			</div>
		</div>
		<br><br><br>
	</div>
</body>
</html>