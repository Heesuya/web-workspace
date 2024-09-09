<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC2 프로젝트</title>
</head>
<body>
	<h1>MVC2 프로젝트 - 건들지 마시오</h1>
	<hr>
	<%--
		전체회원조회
		1. DB작업 필요한지 -> O
		2. query : select * from member_tbl order by 1
		3. 사용자에게 받을 데이터 없음 -> Controller 호출
		4. 요청성공했을때/실패했을때 어덯게 처리할지 결정
	 --%>
	 <h3><a href="/allMember">1. 전체회원조회</a></h3>
	 
	  <%--
	 	아이디로 회원 조회
	 	1. DB작업 필요한지 -> O
		2. query : select * from member_tbl where member_id=?
		3. 사용자에게 받을 데이터 있음(아이디) -> 아이디를 입력받는 양식으로 이동
		4. 아이디를 입력받은 후
			-> 조회 성공한 경우 : searchSuccess.jsp 에서 회원정보 출력
			-> 조회 실패한 경우 : searchFail.jsp 에서 회원 정보를 조회할 수 없습니다 출력 
	 --%>
	  <h3><a href="/searchIdFrm">2. 아이디로 회원 조회</a></h3>
	  
	  <%--
	  	회원가입 
	  	1. DB작업 필요한지 -> O
	  	2. query : insert into member_tbl values(member.seq.nextval,?,?,?,?,?,3,to_char(sysdate, 'yyyy-mm-dd'))
	  	3. 입력받을 데이터 : id, pw, name, phone, addr -> 입력양식으로이동
	  	4. 성공했을때 / 실패했을때
	  		-> 회원가입 성공한 경우 : allMember.jsp로 이동해서 전체회원 정보 중 추가된 회원정보 확인
	  		-> 회원가입 실패할 경우 : insertFail.jsp로 이동해서 회원가입에 실패했습니다. 출력
	   --%>
	   	  <h3><a href="/joinMemberFrm">3. 회원가입</a></h3>
	
		<%--
		  회원정보 수정
		 1. DB 작업 : O
		 2. query : update member_tbl set member_pw= ? , member_phone = ? , member_addr = ? where member_id = ?   
		 3. 입력받아야하는 정보 : 아이디 / 비밀번호 / 전화번호 / 주소
		 아이디를 먼저 입력 받음 -> 아이디로 회원조회 -> 조회성공하면 수정 양식을 띄워줌 -> 수정
		 														  -> 수정성공하면 searchSuccess.jsp 사용
		 														  -> 수정실패하면 updateFail.jsp 에서 실패메세지
		 								 -> 조회실패하면 회원정보를 찾을 수 없습니다.
		 --%>
		 <h3><a href="/updateSearch">4. 회원정보 수정</a></h3>
		 
		 <%--
		 	회원탈퇴
		 	1. DB 작업 : O
		 	2. query : delete from member_tbl where member_id=?
		 	3. 입력받을 데이터 존재 : 회원아이디
		 		-> 삭제회원 아이디를 입력받을 양식으로 이동 
		 	4. 아이디를 입력받아서 바로 삭제
		 		-> 삭제성공하면 : allMember.jsp로 전체회원정보 확인
		 		-> 삭제실패하면 : searchFail.jsp로 가서 회원정보를 조회할 수 없습니다. 출력
		  --%>
		  <h3><a href="/deleteMemberFrm">5. 회원정보 삭제</a></h3>
</body>
</html>