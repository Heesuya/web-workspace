package kr.co.iei.notice.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class NoticeRowMapper implements RowMapper<Notice> {

	@Override
	public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notice notice = new Notice();
		notice.setNoticeNo(rs.getInt("notice_no"));
		notice.setNoticeTitle(rs.getString("notice_title"));
		notice.setNoticeWriter(rs.getString("notice_writer"));
		notice.setNoticeContent(rs.getString("notice_content"));
		notice.setReadCount(rs.getInt("read_count"));
		notice.setRegDate(rs.getString("reg_date"));
		return notice;
	}


}
