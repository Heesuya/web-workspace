package kr.or.iei.board.model.dto;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;



@Component
public class BoardRowMapper implements RowMapper<Board> {

	@Override
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		Board b = new Board();
		b.setPhotoFeedNo(rs.getInt("photo_feed_no"));
		b.setPhotoFeedImg(rs.getString("photo_feed_img"));
		b.setPhotoFeedWriter(rs.getString("photo_feed_writer"));
		b.setReadCount(rs.getInt("read_count"));
		b.setRegDate(rs.getString("reg_date"));
		return b;
	}
	
}
