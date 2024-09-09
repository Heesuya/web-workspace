package kr.co.iei.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeComment {
	private int noticeCommentNo;
	private String noticeCommentWriter;
	private String noticeCommentContent;
	private String noticeCommentDate;
	private int noticeRef;
	private int noticeCommentRef;
	private int likeCount;//좋아요 카운트 저장 
	private int isLike;
}