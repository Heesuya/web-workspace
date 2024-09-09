package kr.co.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.iei.member.model.dto.Member;
import kr.co.iei.member.model.service.MemberService;

/**
 * Servlet implementation class JoinMemberServledt
 */
@WebServlet("/joinMember")
public class JoinMemberServledt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberServledt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 추출하기
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		System.out.println("memberId : "+memberId);
		System.out.println("memberPw : "+memberPw);
		System.out.println("memberName : "+memberName);
		System.out.println("memberPhone : "+memberPhone);
		System.out.println("memberAddr : "+memberAddr);
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		m.setMemberName(memberName);
		m.setMemberPhone(memberPhone);
		m.setMemberAddr(memberAddr);
		//3. 비즈니스 로직
		MemberService memberService = new MemberService();
		int result = memberService.insertMember(m);
		//4. 결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원가입결과</title></head>");
		out.println("<body>");
		if(result > 0) {
			out.println("<h1>회원가입 성공</h1>");
		}else {
			out.println("<h1>회원가입 실패</h1>");
		}
		out.println("<a href='/'>메인으로</a>");
		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
