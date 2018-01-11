<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="main_head.jsp"%>
<%@ include file="/views/modal.jsp"%>

<script type="text/javascript" src="js/qna.js"></script>
<title>Q&A</title>
</head>
<body>
	Q&A 페이지 입니다.

	<div class="col-sm-12">
		<div class="col-sm-6">
			<div class="col-sm-12">
				<div class="col-sm-2" onclick="newQNA();">글쓰기</div>
				<div id="qna_div" class="col-sm-12">
					<div style="color: blue" onclick="getQNAContent(4)"
						hidden="true"></div>
				</div>
				<div class="paging col-sm-12">
					<div id="qna_paging_div">
						<div hidden="true">
							<a>이전페이지</a> 
							<a>1</a> 
							<a><strong>2</strong></a> 
							<a>3</a> 
							<a>4</a>
							<a>5</a> <a>다음페이지</a>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6"></div>
	</div>
</body>
</html>