package kr.co.iei.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.iei.member.model.dto.Member;
import kr.co.iei.member.model.service.MemberService;

/**
 * Servlet implementation class joinMemberServlet
 */
@WebServlet("/joinMember")
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		Member m = new Member();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		m.setMemberId(memberId);
		m.setMemberAddr(memberAddr);
		m.setMemberName(memberName);
		m.setMemberPhone(memberPhone);
		m.setMemberPw(memberPw);
		//3. 비즈니스로직
		MemberService memberService = new MemberService();
		int result = memberService.insertMember(m);
		//4. 결과처리
		if(result > 0) {
			//결과처리 시 다른 서블릿을 재 호출하고싶은 경우
			//-> 사용자 브라우저의 주소창을 서블릿 주소로 변경
			response.sendRedirect("/allMember");
			
			
			//아래와 같이 하면 새로고침하면 다시 입력하라고 뜸.
			//4-1. 결과처리할 jsp 지정
			//RequestDispatcher view = request.getRequestDispatcher("/jsp/allMember.jsp");
			//4-2. 화면구현에 필요한 데이터 등록
			//ArrayList<Member> list = memberService.selectAllMember();//실제로는 여기서 하지 않음 
			//request.setAttribute("list", list);
			//4-3. 페이지이동
			//view.forward(request, response);
		}else {
			//4-1. 결과처리할 jsp 지정
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/insertFail.jsp");
			//4-2. 화면구현에 필요한 데이터 등록
			//4-3. 페이지이동
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
