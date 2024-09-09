<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<h1>게시판 프로젝트</h1>

	<hr>

	<form action="/searchWriter">

		<label for="boardWriter">작성자를 입력하세요 : </label> 
		<input type="text"name="boardWriter" id="boardWriter"> 
		<input type="submit"value="조회">

	</form>

</body>

</html>