<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>관통부기본정보</title>

<%@ include file="main_head.jsp"%>
<%@ include file="/views/modal.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/codeManage.js"></script>
</head>
<body>
	<%@ include file="home_side.jsp"%>
	<div class="con">
		<div class="row" id="code_group_div">
			<div class="col-sm-12">
				<button onclick="newCodeGroup()" style="margin-bottom:10px;width:130px; height:25px; margin-right:20px; font-size:14px; font-weight:700; border-radius:5px; background: linear-gradient( to bottom, white, #c1d4f1 ); border:1px solid #b3caeb; color:#2e4481;">
				추가</button>
				<button id="code_group_updatebtn" onclick="updateCodeGroupData()" style="margin-bottom:10px;width:130px; height:25px; margin-right:20px; font-size:14px; font-weight:700; border-radius:5px;  background: linear-gradient( to bottom, white, #f9c89f ); border:1px solid #fe9d4d; color:#d96403;"
					disabled>저장</button>
			</div>
			<div class="col-sm-12">
				<div class="col-sm-12" id="codeGroup_Grid_div"></div>
			</div>
		</div>
		<div class="row" id="code_info_div" hidden="true">
			<div class="col-sm-12">
				<button onclick="newCodeInfo()" style="margin-top:10px;margin-bottom:10px;width:130px; height:25px; margin-right:20px; font-size:14px; font-weight:700; border-radius:5px; background: linear-gradient( to bottom, white, #c1d4f1 ); border:1px solid #b3caeb; color:#2e4481;">
				추가</button>
				<button id="code_info_updatebtn" onclick="updateCodeInfoData()" style="margin-top:10px;margin-bottom:10px;width:130px; height:25px; margin-right:20px; font-size:14px; font-weight:700; border-radius:5px;  background: linear-gradient( to bottom, white, #f9c89f ); border:1px solid #fe9d4d; color:#d96403;"
					disabled>저장</button>
			</div>
			<div class="col-sm-12">
				<div class="col-sm-12" id="codeInfo_Grid_div"></div>
			</div>
		</div>

	</div>
</body>
</html>