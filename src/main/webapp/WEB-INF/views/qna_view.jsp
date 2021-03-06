<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="main_head.jsp"%>
<%@ include file="/views/modal.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/qna_view.js"></script>
<title>Q &amp; A</title>
</head>
<body>
	<%@ include file="home_side.jsp"%>
     <div class="con1">
        <section class="board board_view">
            <h2><img src="images/cs_qa.gif"></h2><!--자료실 공지사항-->
            <div>
                <table>
                    <tr>
                        <th>제목</th>
                        <td class="board_title">${qna.QNAObject.subject}</td>
                        <td class="right_float">
                            <table>
                                <tr>
                                    <td>작성자: &nbsp; ${qna.QNAObject.regid}</td>
                                    <td>&nbsp;&nbsp; 작성일 : &nbsp; ${qna.QNAObject.writtenDate}</td>
                                </tr>   
                            </table>
                        </td>
                    </tr>  
                    <!-- 
                    <tr>
                        <th>첨부파일</th>
                        <td>
                            <a href=""><img src="images/icon_file.gif" /><strong>파일이름</strong></a>
                        </td>
                    </tr>
                     -->        
                    <tr style="height:145px;">
                        <th>내용</th>
                        <td colspan="2" class="board_text" style="min-height:386px; max-height:386px;">
                            ${qna.QNAObject.Content}
                        <br><img src=images/blink.gif height=10></td>
                    </tr>
                </table>
                <div class="bo_write_save">
                     
			<c:if test="${sessionScope.userInfo.id == 'admin'}">
	                <input class="savebtn" type="button" style="cursor:hand"  onclick="QNAEditView('${qna.QNAObject.ID}')"value="수정" />
                    <input type="reset" style="cursor:hand" onclick="QNADelete('${qna.QNAObject.ID}')" value="삭제" />
                </c:if>
                    <a href="/NPower/qna">목록</a>
                </div>
            </div>
        </section>
        <br><br><br>
    </div>
</body>
</html>