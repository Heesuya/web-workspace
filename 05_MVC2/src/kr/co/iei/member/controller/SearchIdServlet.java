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
 * Servlet implementation class searchidServlet
 */
@WebServlet(name = "searchId", urlPatterns = { "/searchId" })
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
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
		String memberId = request.getParameter("memberId");
		//3. 비즈니스로직
		MemberService memberSerivce = new MemberService();
		Member m = memberSerivce.selectOneMember(memberId);
		//4. 결과처리
		if(m == null) {
			//4-1. 결과 처리 처리할 페이지 지정
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/searchFail.jsp");
			//4-2. 화면제작에 필요한 데이터 등록
			//4-3. 페이지이동
			view.forward(request, response);
		}else {
			//4-1. 결과 처리 처리할 페이지 지정
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/searchSuccess.jsp");
			//4-2. 화면제작에 필요한 데이터 등록
			request.setAttribute("member", m);
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
