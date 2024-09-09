package kr.co.iei.notice.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class NoticeCommentRowMapper implements RowMapper<NoticeComment>{

	@Override
	public NoticeComment mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeComment nc = new NoticeComment();
		nc.setNoticeCommentContent(rs.getString("notice_comment_content"));
		nc.setNoticeCommentDate(rs.getString("notice_comment_date"));
		nc.setNoticeCommentNo(rs.getInt("notice_comment_no"));
		nc.setNoticeCommentRef(rs.getInt("notice_comment_ref"));
		nc.setNoticeCommentWriter(rs.getString("notice_comment_writer"));
		nc.setNoticeRef(rs.getInt("notice_ref"));
		nc.setIsLike(rs.getInt("is_like"));
		nc.setLikeCount(rs.getInt("like_count"));
		return nc;
	}
	
}