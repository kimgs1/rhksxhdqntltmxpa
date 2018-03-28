<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/home_side.js"></script>
<script type="text/javascript" src="js/contentinfo_edit.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="home_side.jsp"%>
	
	<div class="con1">
	
        <section class="board board_write">
        	
            <h2><img src="images/cs_download.jpg"></h2><!--공지사항-->
            <input id="id" hidden="true" value="${result.data.id}">
            <div>
                <table>
                 	<tr>
                        <th class="nbg3 b2">제목</th>
                        <td><input type="text" id="subject" value="${result.data.subject}"/></td>
                    </tr>
                    <tr>
                        <th class="nbg3 b2">내용</th>
                        <td><textarea style="min-height:386px; max-height:386px;" id="Contents" >${result.data.Contents}</textarea><br><img src=images/blink.gif height=10></td>
                    </tr>
                    <tr>
                        <th class="nbg3 b2">파일첨부</th>
					
                        <td>
                        	<form id="FileUploadForm" action="#" enctype="multipart/form-data">
	                        	<input type="file" id="uploadFile" name="uploadFile" onchange="UploadFileFunc(this)" src="UploadFiles/${result.data.FileViewName}">
								<input type="text" id="uploadFileName" name="uploadFileName"hidden="true" value="${result.data.Filename}">                        
                       		</form>
                       </td>
                    </tr>
                    
                </table>
                <div class="bo_write_save">
                    <input class="savebtn" type="button" style="cursor:hand" onclick="newContentInfoEditSave()" value="저장" />
                    <a href="/NPower/contentinfo">목록</a>
                </div>
                
            </div>
        </section>
        <br><br><br>
    </div>
</body>
</html>