<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>유저 등록</h3>
	<hr>
	<form action="/insertUser" method="get">
		<table border="1">
			<tr>
				<th>
					<label for="userNickname">닉네임 입력 </label>
				</th>
				<td>
					<input type="text" name="userNickname" id="userNickname">
				</td>
			<tr>	
				<th>
					<label for="userAge">나이 입력 </label>
				</th>
				<td>
					<input type="text" name="userAge" id="userAge">
				</td>
			</tr>	
			<tr>
				<th>
					<label for="userGender">성별입력 </label>
				</th>
				<td>
					<input type="radio" name="userGender" id="userNickname" value="남">남
					<input type="radio" name="userGender" id="userNickname" value="여">여
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="등록">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>