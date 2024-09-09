package kr.co.iei.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.iei.board.model.dto.BoardDTO;
import kr.co.iei.board.model.dto.BoardFile;

@Mapper
public interface BoardDao {

	List selectBoardList(Map<String, Object> map);

	int totalCount();

	int insertBoard(BoardDTO board);

	//int selectBoardNo();

	int insertBoardFile(BoardFile boardFile);

	BoardDTO selectBoard(BoardDTO board);

	List selectBoardFile(BoardDTO board);

	BoardDTO selectOneBoard(int boardNo);

	int updateBoard(BoardDTO board);

	List<BoardFile> selectDeleteFileList(int[] delFileNo);

	int deleteBoardFile(int[] delFileNo);

	int deleteBoard(int boardNo);

}
