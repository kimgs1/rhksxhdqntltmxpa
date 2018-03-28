<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/contentinfo_view.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="home_side.jsp"%>
	<div class="con1">
        <section class="board board_view">
            <h2><img src="images/cs_download.jpg"></h2><!--공지사항-->
            <div>
                <table>
                    <tr>
                        <th>제목</th>
                        <td class="board_title">${result.data.subject}</td>
                        <td class="right_float">
                            <table>
                                <tr>
                                    <td>작성자 :${result.data.RegID}</td>
                                    <td>작성일 :${result.data.RegDateTime}</td>
                                </tr>   
                            </table>
                        </td>
                    </tr>     
                    
                    
				   <c:if test="${result.data.Filename != ''}">
                   <tr>
                        <th>첨부파일</th>
                        <td>
                            <a href="UploadFiles/${result.data.Filename}"><img src="images/icon_file.gif" /><strong id="FileName">${result.data.FileViewName}</strong></a>
                        </td>
                    </tr>
                    </c:if>
                    <tr style="height:145px;">
                        <th>내용</th>
                        <td colspan="2" class="board_text" style="min-height:386px; max-height:386px;">
                            ${result.data.Contents}
                        <br><img src=images/blink.gif height=10></td>
                    </tr>
                </table>
                <div class="bo_write_save">
                     
			<c:if test="${sessionScope.userInfo.id == 'admin'}">
	                <input class="savebtn" type="button" style="cursor:hand"  onclick="ContentInfoEditView('${result.data.id}')"value="수정" />
                    <input type="reset" style="cursor:hand" onclick="ContentInfoDelete('${result.data.id}')" value="삭제" />
                </c:if>
                    <a href="/NPower/contentinfo">목록</a>
                </div>
                
            </div>
        </section>
        <br><br><br>
    </div>
</body>
</html>