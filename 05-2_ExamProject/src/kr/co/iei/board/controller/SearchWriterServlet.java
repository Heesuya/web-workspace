package kr.co.iei.board.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import kr.co.iei.board.model.service.BoardService;

import kr.co.iei.board.model.vo.Board;

/**
 * 
 * Servlet implementation class SearchWriterServlet
 * 
 */

@WebServlet("/searchWriter")

public class SearchWriterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 * 
	 */

	public SearchWriterServlet() {

		super();

// TODO Auto-generated constructor stub

	}

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		//02
		//String boardWriter = request.getParameter("writer");
		String boardWriter = request.getParameter("boardWriter");

		BoardService boardService = new BoardService();

		ArrayList<Board> boardList = boardService.selectBoardWriter(boardWriter);

		if (boardList.isEmpty()) {

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/board/searchFail.jsp");

			view.forward(request, response);

		} else {

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/board/searchBoard.jsp");

			//
			request.setAttribute("boardList", boardList);

			view.forward(request, response);

		}

	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

// TODO Auto-generated method stub

		doGet(request, response);

	}

}