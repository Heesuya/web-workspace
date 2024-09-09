package kr.co.iei.board.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardPageData {
	//DB로 직접적 연결이 없어서 alias 어노테이션 없음
	private List list;
	private String pageNavi;
}
