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
 * Servlet implementation class allMemberServlet
 */
@WebServlet("/allMember")
public class AllMemberFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberFrmServlet() {
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
		//3. 비즈니스로직
		MemberService memberService = new MemberService();
		ArrayList<Member> list = memberService.selectAllMember();
		//4. 결과처리(MVC2 에서는 결과를 jsp쪽에 처리를 위임)
		//4-1. 결과를 처리할 페이지를 지정(어떤 jsp가 이 결과를 처리할지 지정)
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/allMember.jsp");
		//4-2. 화면구현에 필요한 자바 데이터를 등록
		request.setAttribute("list", list);//("key",value) 등록할 값 더 있으면 request로 더 등록하면 된다.
		//4-3. 페이지이동
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
