package kr.co.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.iei.member.model.dto.Member;
import kr.co.iei.member.model.service.MemberService;

/**
 * Servlet implementation class updateMemberServlet
 */
@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		String memberPw = request.getParameter("memberPw");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		String memberId = request.getParameter("memberId");
		m.setMemberId(memberId);
		m.setMemberPhone(memberPhone);
		m.setMemberPw(memberPw);
		m.setMemberAddr(memberAddr);
		System.out.println(m);
		//3. 비즈니스로직
		MemberService memberService = new MemberService();
		int result = memberService.updateMember(m);
		//4. 결과처리
		if(result > 0) {
			response.sendRedirect("/searchId?memberId="+m.getMemberId());
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/updateFail.jsp");
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
