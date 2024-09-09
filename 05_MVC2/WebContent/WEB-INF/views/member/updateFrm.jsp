<%@page import="kr.co.iei.member.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Member m = (Member) request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<hr>
	<form action="/updateMember" method="post">
		<table border="1">
			<tr>
				<th>회원정보</th>
				<td>
				<input type="text" name="memberNo" id="memberNo" value="<%=m.getMemberNo()%>" disabled>
				<%--disabled 하면 데이터 안넘어감 --%>
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
				<%=m.getMemberId()%>
				<input type="hidden" name="memberId" id="memberId" value="<%=m.getMemberId()%>"><%--생각보다 많이 쓰임 --%>
				<%-- 
				<input type="text" name="memberId" id="memberId" value="<%=m.getMemberId()%>" readonly>
				--%>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="memberPw" id="memberPw" value="<%=m.getMemberPw()%>">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="memberName" id="memberName" value="<%=m.getMemberName()%>">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="memberPhone" id="memberPhone" value="<%=m.getMemberPhone()%>">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="memberAddr" id="memberAddr" value="<%=m.getMemberAddr()%>">
				</td>
			</tr>
			<tr>
				<th>회원등급</th>
				<%
					if (m.getMemberLevel() == 1) {
				%>
				<td>관리자</td>
				<%
					} else if (m.getMemberLevel() == 2) {
				%>
				<td>정회원</td>
				<%
					} else if (m.getMemberLevel() == 3) {
				%>
				<td>준회원</td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>가입일</th>
				<td><%=m.getEnrollDate()%></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="수정하기">
				</th>
			</tr>
		</table>
	</form>

</body>
</html>