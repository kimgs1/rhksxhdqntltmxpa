<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="main_head.jsp"%>
<%@ include file="/views/modal.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/qna_create.js"></script>
<title>Q &amp; A</title>
</head>
<body>
	<%@ include file="home_side.jsp"%>
     <div class="con">
        <section class="board board_write">
            <h2>Q &amp; A</h2><!--자료실 공지사항-->
            <div>
                <table>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" id="subject"/></td>
                    </tr>
                    <tr style="height:145px;">
                        <th>내용</th>
                        <td><textarea id="Content"></textarea></td>
                    </tr>
                </table>
                <div class="bo_write_save">
                    <input class="savebtn" type="button" onclick="newQNASave()" value="저장" />
                    <input type="reset" value="초기화" />
                    <a href="/NPower/qna">목록</a>
                </div>
            </div>
        </section>
    </div>
</body>
</html>