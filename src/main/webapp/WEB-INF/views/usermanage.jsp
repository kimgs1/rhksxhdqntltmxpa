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
		<div class="row" id="user_div">
			<div class="col-sm-12">
				<button onclick="newMemberOnClick(false)" style="margin-bottom:10px;width:130px; height:25px; margin-right:20px; font-size:14px; font-weight:700; border-radius:5px; background: linear-gradient( to bottom, white, #c1d4f1 ); border:1px solid #b3caeb; color:#2e4481;">
				추가</button>
			</div>
			<div class="col-sm-12">
				<div class="col-sm-12" id="usermanage_Grid_div"></div>
			</div>
		</div>
	</div>
</body>
</html>