package kr.co.iei.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData6Servlet
 */
@WebServlet("/sendData6")
public class SendData6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData6Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩(요청 시 한글로 데이터가 전달 될 수 있으므로 한글을 인코딩)
		request.setCharacterEncoding("utf-8");
		//2. 값 추출(화면에서 요청 시 보내준 값을 꺼내는 과정)
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String oper = request.getParameter("oper");
		//3. 비즈니스로직(서버에서 처리해야 할 기능)
		double reuslt = 0;
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		//강사님은 if문으로 처리
		switch(oper) {
		case "+":
			reuslt = num1+num2;
			break;
		case "-":
			reuslt = num1-num2;
			break;
		case "*":
			reuslt = num1*num2;
			break;
		case "/":
			reuslt = (num1/num2);
			break;
		}
		//4. 결과처리(화면제작)
		//응답 형식 및 문자 셋 지정
		response.setContentType("text/html;charset=utf-8");
		//HTML작성하는 객체 생성
		PrintWriter out = response.getWriter();
		//결과 처리 할 HTML작성
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>연산결과</title></head>");
		out.println("<body>");
		out.println("<h1>연산결과<h1>");
		out.println("<hr>");
		out.println("<h3>"+num1 + oper + num2+ " = " + reuslt+"<h3>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
