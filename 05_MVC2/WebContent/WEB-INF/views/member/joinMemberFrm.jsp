<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/joinMember" method="post">
		<table border='1'>
			<tr>
				<td>
				<label for="memberId">아이디 입력 </label>
				</td>
				<td>
				<input type="text" name="memberId" id="memberId">
				</td>
			</tr>
			<tr>
				<td>
				<label for="memberPw">비밀번호 입력 </label>
				</td>
				<td>
				<input type="password" name="memberPw" id="memberPw">
				</td>
			</tr>
			<tr>
				<td>
				<label for="memberName">이름 입력 </label>
				</td>
				<td>
				<input type="text" name="memberName" id="memberName">
				</td>
			</tr>
			<tr>
				<td>
				<label for="memberPhone">전화번호 입력 </label>
				</td>
				<td>
				<input type="text" name="memberPhone" id="memberPhone">
				</td>
			</tr>
			<tr>
				<td>
				<label for="memberAddr">주소 입력 </label>
				</td>
				<td>
				<input type="text" name="memberAddr" id="memberAddr">
				</td>
			</tr>
			<tr >
				<td colspan="2">
				<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>