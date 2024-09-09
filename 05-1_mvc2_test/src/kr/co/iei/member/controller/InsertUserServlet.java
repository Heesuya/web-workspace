package kr.co.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.iei.member.model.dto.User;
import kr.co.iei.member.model.service.UserService;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/insertUser")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 추출
		User u = new User();
		String userNickname = request.getParameter("userNickname");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userGender = request.getParameter("userGender");
		u.setUserAge(userAge);
		u.setUserGender(userGender);
		u.setUserNickname(userNickname);
		//3. 서비스로직
		UserService userService = new UserService();
		int result = userService.insertUser(u);
		//4. 결과
		if(result > 0) {
			response.sendRedirect("/allUser");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/insertUserFail.jsp");
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
