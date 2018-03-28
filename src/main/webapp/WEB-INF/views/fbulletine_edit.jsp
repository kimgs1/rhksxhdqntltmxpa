<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/fbulletine_edit.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="home_side.jsp"%>
	<div class="con1">
        <section class="board board_write">
        
            <h2><img src="images/cs_notice.gif"></h2><!--공지사항-->
            <div>
                                <table>
                    <tr>
                        <th class="nbg3 b2">제목</th>
                        <td><input type="text" id="title" value="${result.FB.title}"/></td>
                    </tr>
                    <tr>
                        <th class="nbg3 b2">내용</th>
                        <td><textarea style="min-height:386px; max-height:386px;" id="contents" > ${result.FB.contents}</textarea><br><img src=images/blink.gif height=10></td>
                    </tr>
                </table>
                
                <div class="bo_write_save">
                     
			<c:if test="${sessionScope.userInfo.id == 'admin'}">
	                <input class="savebtn" type="button" style="cursor:hand"  onclick="FbulletineEditSave('${result.FB.id}')"value="수정" />

                </c:if>
                    <a href="/NPower/fbulletine">목록</a>
                </div>
                
                
            </div>
        </section>
        <br><br><br>
    </div>
</body>
</html>