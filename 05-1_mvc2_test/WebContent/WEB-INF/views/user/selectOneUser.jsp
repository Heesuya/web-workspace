<%@page import="kr.co.iei.member.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	User user =(User)request.getAttribute("user");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>닉네임으로 유저 조회</h1>
	<ul>
		<li>
			유저 번호 : <%=user.getUserNo()%>
		</li>
		<li>
			닉네임 : <%=user.getUserNickname()%>
		</li>
		<li>
			나이 : <%=user.getUserAge()%>
		</li>
		<li>
			성별 : <%=user.getUserGender()%>
		</li>
	</ul>
	<a href="/deleteUser?userName=<%=user.getUserNickname()%>"><input type="submit" value="유저삭제"></a>
</body>
</html>