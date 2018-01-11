<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="main_head.jsp"%>

<script type="text/javascript" src="js/newMember.js"></script>
</head>
<body>

	<section class="user_pop">
        <h2>사용자 정보 수정</h2>
        <form action="#">
            <table>
                <tr>
                    <th>사용자아이디</th>
                    <td style="border:0"></td>
                    <td><input type="text"  id="userId" name="userId" /></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="userName" name="userName"  /></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td style="border:0"></td>
                    <td><input type="password" id = "password_precheck" /></td>
                </tr>
                <tr>
                    <th>비밀번호 재확인</th>
                    <td style="border:0"></td>
                    <td><input type="password" id="password" name="password"/></td>
                </tr>
                <tr>
                    <th>e-Mail 주소</th>
                    <td style="border:0"></td>
                    <td><input type="email"  id="email" name="email"/></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td style="border:0"></td>
                    <td><input type="text" id="address" name="address"/></td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td style="border:0"></td>
                    <td><input type="tel"  id="phone" name="phone"  /></td>
                </tr>
                <tr>
                    <th>핸드폰</th>
                    <td style="border:0"></td>
                    <td><input type="tel"  id="mobile" name="mobile" /></td>
                </tr>
                <tr>
                    <td style="border:0"><input type="submit" onclick="newMemberSaveOnclick()" value="확인" /></td>
                    <td style="border:0"></td>
                    <td style="border:0"><input type="reset" onclick="newMemberSaveCancelOnclick()"value="취소" /></td>
                </tr>
            </table>
        </form>
    </section>


		<div class="col-sm-12">
			<div class="col-sm-1">userId</div>
			<input id="userId" name="userId" class="col-sm-9">
		</div>

		<div class="col-sm-12">
			<div class="col-sm-1">userName</div>
			<input id="userName" name="userName" class="col-sm-9">
		</div>
		<div class="col-sm-12">
			<div class="col-sm-1">password</div>
			<input id="password" name="password" class="col-sm-9">
		</div>

		<div class="col-sm-12">
			<div class="col-sm-1">email</div>
			<input id="email" name="email" class="col-sm-9">

		</div>
		<!-- 
		<div class="col-sm-12">
			<div class="col-sm-1">company</div>
			<input name="company" class="col-sm-9">
		</div>
		
		
		 -->
		 <div class="col-sm-12">
			<div class="col-sm-1">address</div>
			<input id="address" name="address" class="col-sm-9">
		</div>
		<div class="coNaml-sm-12">
			<div class="col-sm-1">phone</div>
			<input id="phone" name="phone" class="col-sm-9">
		</div>
		<div class="col-sm-12">
			<div class="col-sm-1">mobile</div>
			<input id="mobile" name="mobile" class="col-sm-9">
		</div>

		<button class="col-sm-1" onclick="newMemberSaveOnclick()">submit</button>
</body>
</html>