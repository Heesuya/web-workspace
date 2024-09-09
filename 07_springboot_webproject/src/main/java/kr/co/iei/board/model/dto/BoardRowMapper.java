package kr.co.iei.board.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BoardRowMapper implements RowMapper<Board>{

	@Override
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		Board board = new Board();
		board.setBoardContent(rs.getString("board_content"));
		board.setBoardNo(rs.getInt("board_no"));
		board.setBoardTitle(rs.getString("board_title"));
		board.setBoardWriter(rs.getString("board_writer"));
		board.setReadCount(rs.getInt("read_count"));
		board.setRegDate(rs.getString("reg_date"));
		return board;
	}
	
}
