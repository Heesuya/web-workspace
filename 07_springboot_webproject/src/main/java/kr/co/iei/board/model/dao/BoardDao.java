package kr.co.iei.board.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.iei.board.model.dto.Board;
import kr.co.iei.board.model.dto.BoardFile;
import kr.co.iei.board.model.dto.BoardListData;
import kr.co.iei.board.model.dto.BoardFileRowMapper;
import kr.co.iei.board.model.dto.BoardRowMapper;

@Repository
public class BoardDao {
	@Autowired
	JdbcTemplate jdbc = new JdbcTemplate();
	@Autowired
	BoardRowMapper boardRowMapper = new BoardRowMapper();
	@Autowired
	BoardFileRowMapper boardFileRowMapper = new BoardFileRowMapper();
	
	public List selectAllBoard() {
		String query = "select * from board order by 1 desc";
		List list = jdbc.query(query, boardRowMapper);
		return list;
	}
	
	public List selectBoardList(int start, int end) {
		String query = "select * from (select rownum as rnum, n.* from (select * from board order by 1 desc)n) where rnum between ? and ?";
		Object[] params = {start, end};
		List list = jdbc.query(query, boardRowMapper, params);
		return list;
	}
	
	public int selectBoardTotalCount() {
		String query = "select count(*) from board";
		int totalCount = jdbc.queryForObject(query, Integer.class);
		return totalCount;
	}

	public int insertBoard(Board b) {
		String query = "insert into board values(board_seq.nextval,?,?,?,0,to_char(sysdate,'yyyy-mm-dd'))";
		Object[] params = {b.getBoardTitle(),b.getBoardWriter(),b.getReadCount()};
		int result = jdbc.update(query, params);
		return result;
	}

	public int selectBoardNo() {
		String query = "select max(board_no) from board";
		int boardNo = jdbc.queryForObject(query, Integer.class);
		return boardNo;
	}

	public int insertBoardFile(BoardFile file) {
		String query = "insert into board_file values(board_file_seq.nextval,?,?,?)";
		Object[] params = {file.getBoardNo(),file.getFilename(),file.getFilepath()};
		int result = jdbc.update(query, params);
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		String query = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List list = jdbc.query(query, boardRowMapper, params);//List 타입으로 가져와서 형변환을 해줘야 한다
		if(list.isEmpty()) {
			return null;
		}
		return (Board)list.get(0);//List 타입으로 받기때문에 꺼내서 형변
	}

	public int readCountBoard(int boardNo) {
		String query = "update board set read_count = read_count+1 where board_no = ?";
		Object[] params = {boardNo};
		int result = jdbc.update(query, params);
		return result;
	}
	
	public List selectBoardFile(int boardNo) {
		String query = "select * from board_file where board_no =?";
		Object[] params = {boardNo};
		List list = jdbc.query(query, boardFileRowMapper, params);
		return list;
	}

	public int boardDelete(int boardNo) {
		String query = "delete from board where board_no=?";
		Object[] params = {boardNo};
		int result = jdbc.update(query, params);
		return result;
	}
}
