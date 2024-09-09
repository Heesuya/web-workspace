<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
MVC1패턴 
jsp 가 콘트롤러 함께 담당 
화면과 컨트롤러 담당
소규모 프로젝트에서는 편함 
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MVC1</h1>
	<hr>
	<%-- JSP 주석 --%>
	<%--
		전체회원조회
		1. DB작업 필요한지 -> O
		2. query : select * from member_tbl order by 1
		3. 쿼리문에 사용자에게 입력받을 값이 있는지 -> X
			3-1. 입력받을 값이 있으면 -> 입력양식 페이지로 이동
			3-2. 입력받을 값이 없으면 -> Controller를 호출 (MVC1 구조에서는 Controller가 jsp)
	 --%>
	 <h3><a href="/jsp/allMember.jsp">1. 전체회원조회</a></h3>
	 
	 <%--
	 	아이디로 회원 조회
	 	1. DB작업 필요한지 -> O
	 	2. query : select * from member_tbl where member_id = ?
	 	3. 쿼리문에 사용자에게 입력받을 값이 있는지 -> O
	 		3-1. 입력받을 값이 있으면 -> 입력양식 페이지로 이동
	  --%>
	  <h3><a href="/jsp/searchIdFrm.jsp">2. 아이디로 회원 조회</a></h3>
	  
	  <%--
	  	회원가입
	  	1. DB작업 필요한지 -> O
	  	2. query : insert into member_tbl values(member_seq.nextval,?,?,?,?,?,3,char to(sysdate, (yyyy-mm-dd))
	 	3. 쿼리문에 사용자에게 입력받을 값이 있는지 -> O
	 		3-1. 입력받을 값이 있으면 -> 입력양식 페이지로 이동
	   --%>
	   <h3><a href="/jsp/joinMemberFrm.jsp">3. 회원가입</h3>
</body>
</html>