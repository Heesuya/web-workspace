package kr.co.iei.board.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import common.JDBCTemplate;

import kr.co.iei.board.model.vo.Board;

public class BoardDao {

	public ArrayList<Board> selectBoardWriter(Connection conn, String boardWriter) {

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		ArrayList<Board> boardList = new ArrayList<Board>();

		String query = "select * from board where board_writer = ?";

		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, boardWriter);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Board b = new Board();

				b.setBoardContent(rset.getString("board_content"));

				b.setBoardNo(rset.getInt("board_no"));

				b.setBoardTitle(rset.getString("board_title"));

				b.setBoardWriter(rset.getString("board_writer"));

				b.setReadCount(rset.getInt("read_count"));

				boardList.add(b);

			}

		} catch (SQLException e) {

// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			JDBCTemplate.close(rset);

			JDBCTemplate.close(pstmt);

		}

		return boardList;

	}

}