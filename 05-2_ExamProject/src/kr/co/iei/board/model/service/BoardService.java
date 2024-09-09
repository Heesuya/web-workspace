package kr.co.iei.board.model.service;

import java.sql.Connection;

import java.util.ArrayList;

import common.JDBCTemplate;

import kr.co.iei.board.model.dao.BoardDao;

import kr.co.iei.board.model.vo.Board;

public class BoardService {

	private BoardDao boardDao;

	public BoardService() {

		super();

		boardDao = new BoardDao();

	}

	public ArrayList<Board> selectBoardWriter(String boardWriter) {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Board> boardList = boardDao.selectBoardWriter(conn, boardWriter);

		JDBCTemplate.close(conn);

		return boardList;

	}

}