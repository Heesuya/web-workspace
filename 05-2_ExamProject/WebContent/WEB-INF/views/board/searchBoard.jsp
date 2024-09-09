<%@page import="kr.co.iei.board.model.vo.Board"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--01 --%>
<%
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<h1>작성자로 조회 결과</h1>

	<hr>

	<table border="1">

		<tr>

			<th>글번호</th>

			<th>제목</th>

			<th>내용</th>

			<th>작성자</th>

			<th>조회수</th>

		</tr>

		<%
			for (int i = 0; i < boardList.size(); i++) {
		%>

		<tr>

			<td><%=boardList.get(i).getBoardNo()%></td>

			<td><%=boardList.get(i).getBoardTitle()%></td>

			<td><%=boardList.get(i).getBoardContent()%></td>

			<td><%=boardList.get(i).getBoardWriter()%></td>

			<td><%=boardList.get(i).getReadCount()%></td>

		</tr>

		<%
			}
		%>

	</table>

</body>

</html>