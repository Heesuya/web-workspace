<%@page import="kr.co.iei.member.model.dto.Member"%>
<%@page import="kr.co.iei.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//1. 인코딩
                    request.setCharacterEncoding("utf-8");
                    //2. 값추출
                    String memberId = request.getParameter("memberId");    	
                    //3. 비즈니스로직
                    MemberService memberService = new MemberService();
                    Member m = memberService.selectOneMember(memberId);
                    //4. 결과처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름으로 회원 조회</title>
</head>
<body>
	<%if(m == null) {%>
		<h1>회원정보를 찾을 수 없습니다.</h1>
	<%}else{ %>
	<h1>이름 정보 조회</h1>
	<hr>
	<ul>
		<li>회원 번호 : <%=m.getMemberNo() %></li>
		<li>회원아이디: <%=m.getMemberId() %></li>
		<li>비밀번호  : <%=m.getMemberPw() %></li>
		<li>회원이름 : <%=m.getMemberName() %></li>
		<li>전화번호 : <%=m.getMemberPhone() %></li>
		<li>주소 : <%=m.getMemberAddr() %></li>
		<%if(m.getMemberLevel() == 1){ %>
		 	<li>회원 등급 : 관리자 </li>
		<%} else if( m.getMemberLevel() == 2) {%>
		 	<li>회원 등급 : 정회원 </li>
		<%} else if(m.getMemberLevel() == 3) {%>
		 	<li>회원 등급 : 준회원</li>
		<%} %>
		<li>가입일 : <%=m.getEnrollDate() %></li>
	<%} %>
	</ul>
	
</body>
</html>