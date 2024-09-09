<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/deleteUser">
		<label>삭제할 회원 이름 </label>
		<input type="text" id="userName" name="userName">
		<input type="submit" value="삭제">
	</form>
</body>
</html>