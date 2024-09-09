package kr.co.iei.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.board.model.dao.BoardDao;
import kr.co.iei.board.model.dto.BoardDTO;
import kr.co.iei.board.model.dto.BoardFile;
import kr.co.iei.board.model.dto.BoardPageData;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public BoardPageData selectBoardList(int reqPage) {
		int numPerPage = 10; //한 페이지당 보여줄 게시물 수 
		int end = reqPage * numPerPage;
		int start = end-numPerPage +1;
		//마이바티스에서 데이터를 전달할 때 여러개여도 하나로 묶어서 전달
		//start, end 정수 2개를 전달하고 싶은 상황
		//하나로 묶는 방법 -> 객체를 만들어서 사용 or HashMap 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List list = boardDao.selectBoardList(map);
		
		//pageNavi 생성
		//-> 총 페이지 수 계산을 위해서 총 게시물 수를 조회 
		int totalCount = boardDao.totalCount();
		//총 페이지 수 계산
		int totalPage = totalCount % numPerPage == 0 ? (totalCount/numPerPage) : (totalCount/numPerPage)+1 ;
		
		//페이지 네비 길이
		int pageNaviSize = 5;
		
		//페이징 시작번호
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1; 
		
		String pageNavi ="";
		//이전버튼 
		if(pageNo != 1) {
			pageNavi += "<a href='/board/list?reqPage="+(pageNo-1)+"'>[이전]</a>";
		}
		//숫자 페이징
		for(int i = 0; i < pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span>"+pageNo+"</span>";
			}else {
				pageNavi += "<a href='/board/list?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/board/list?reqPage="+pageNo+"'>[다음]</a>";
		}
		BoardPageData bpd = new BoardPageData(list, pageNavi);
		return bpd;
	}
	@Transactional
	public int insertBoard(BoardDTO board, ArrayList<BoardFile> fileList) {
		//board테이블 insert
		//System.out.println(board);
		int result = boardDao.insertBoard(board); 
		//System.out.println(board);     //mybatis 에서 제공하는 부가기능 board-mapper 에서 selectKey 키를 하면 boardDTO 에 들어간다 들어감
		if(result > 0) {  
			//방금 board테이블에 insert된 게시글의 글번호를 조회
			//int boardNo = boardDao.selectBoardNo();
			for(BoardFile boardFile : fileList) {
				boardFile.setBoardNo(board.getBoardNo());
				result += boardDao.insertBoardFile(boardFile);
			}
		}
		return result;
	}
	public BoardDTO selectBoard(BoardDTO board) {
		BoardDTO b = boardDao.selectBoard(board);
		List fileList = boardDao.selectBoardFile(board);
		b.setFileList(fileList);
		return b;
	}
	public BoardDTO selectOneBoard(int boardNo) {
		BoardDTO bobard = boardDao.selectOneBoard(boardNo);
		return bobard;
	}
	@Transactional
	public List<BoardFile> updateBoard(BoardDTO board, List<BoardFile> fileList, int[] delFileNo) {
		//Board테이블 수정
		int result = boardDao.updateBoard(board);
		if(result > 0) {
			List<BoardFile> delFileList = new ArrayList<BoardFile>();
			// 삭제할 파일이 있는 경우
			if(delFileNo != null) {
				//board_file테이블에서 삭제할 파일을 조회 
				delFileList = boardDao.selectDeleteFileList(delFileNo);
				//board_file테이블에서 삭제할 파일을 삭제 
				result += boardDao.deleteBoardFile(delFileNo);
			}
			//추가 첨부파일 insert
			for(BoardFile boardFile : fileList) {
				result += boardDao.insertBoardFile(boardFile);
			}
			//최종 성공/실패 판단 
			//삭제파일이 있는지 없는지에 따라서 다르게 처리 
			int updateTotal = (delFileNo == null)?
								1 + fileList.size() //board테이블 수정 + 추가한 파일수
								: 
								1 + fileList.size() + delFileNo.length; //board테이블 수정 + 추가한파일수 + 지운 파일수
			if(result == updateTotal) {
				return delFileList;
			}else {
				return null;
			}
		}else {
			return null;			
		}
	}
	public int deleteBoard(int boardNo) {
		int result = boardDao.deleteBoard(boardNo);
		return 0;
	}
}
