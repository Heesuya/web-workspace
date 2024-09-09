<%@page import="kr.co.iei.member.model.service.MemberService"%>
<%@page import="kr.co.iei.member.model.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//1.인코딩
                    request.setCharacterEncoding("utf-8");
                	//2.값추출
                	String memberId = request.getParameter("memberId");
                	String memberPw = request.getParameter("memberPw");
                	String memberName = request.getParameter("memberName");
                	String memberPhone = request.getParameter("memberPhone");
                	String memberAddr = request.getParameter("memberAddr");
                	Member m = new Member();
                	m.setMemberId(memberId);
                	m.setMemberPw(memberPw);
                	m.setMemberName(memberName);
                	m.setMemberPhone(memberPhone);
                	m.setMemberAddr(memberAddr);
                	MemberService memberService = new MemberService();
                	int result = memberService.insertMember(m);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result > 0) {%>
		<h1>회원 가입 완료</h1>
	<%}else{ %>
		<h1>회원 가입 실패</h1>
	<%} %>
</body>
</html>