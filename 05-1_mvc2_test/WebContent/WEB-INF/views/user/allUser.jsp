
<%@page import="kr.co.iei.member.model.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<User> list = (ArrayList<User>)request.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 유저 조회</h1>
	<table border="1">
		<tr>
			<th>유저 번호</th>
			<th>닉네임</th>
			<th>나이</th>
			<th>성별</th>
			<th>삭제할까</th>
		</tr>
		<%
			for(User m : list){
		%>
		<tr>
			<td><%=m.getUserNo()%></td>
			<td><%=m.getUserNickname()%></td>
			<td><%=m.getUserAge()%></td>
			<td><%=m.getUserGender()%></td>
			<td><a href="/deleteUser?userName=<%=m.getUserNickname()%>"><input type="submit" value="삭제"></a> </td>
		</tr>
		<%} %>
	</table>
</body>
</html>