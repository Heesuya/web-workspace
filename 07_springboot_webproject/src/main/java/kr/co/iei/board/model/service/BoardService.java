package kr.co.iei.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.board.model.dao.BoardDao;
import kr.co.iei.board.model.dto.Board;
import kr.co.iei.board.model.dto.BoardFile;
import kr.co.iei.board.model.dto.BoardListData;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao = new BoardDao();

	public BoardListData selectAllBoard(int reqPage) { 
		//페이지 넘버링(reqPage)에 따라 가져오는 테이블 게시물 내용이 달라진다.
		int numPerPage = 10;//한페이지에서 받을 게시물 수 
		int end = reqPage * numPerPage; 
		int start = end - numPerPage +1 ;
		//1~10  , 21~30
		
		List list = boardDao.selectBoardList(start, end);//한페이지 내에서 받을 게시물 Dao 에서 db작업
		
		//페이지 네비게이션 작업
		//게시물 총 개수 
		int totalCount = boardDao.selectBoardTotalCount();
		
		//총 게시물 수를 통해서 페이지 개수 구하기
		int totalPage = totalCount%numPerPage==0 ? totalCount/numPerPage : totalCount/numPerPage+1 ;
		//System.out.println("totalPage : "+totalPage);
		
		
		//네비게이션 사이즈 지정 
		int pageNaviSize = 5;
		//페이지의 시작번호에 따라서 뜨는 번호 다르다, 시작번호 설정       //  1~5  6~10 
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize +1; 
		
		//html코드작성(페이지네비게이션 작성)
		String pageNavi = "<ul class='pagination circle-style'>";
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class = 'page-item' href='/board/list?reqPage="+(pageNo-1)+"'>";				
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
			pageNavi += "</li>";
		}
		for(int i = 0; i <pageNaviSize; i++) {
			pageNavi += "<li>";
			if(pageNo == reqPage) {
				pageNavi += "<a class='page-item active-page' href='/board/list?reqPage="+pageNo+"'>";
			}else {
				pageNavi += "<a class='page-item' href='/board/list?reqPage="+pageNo+"'>";

			}
			pageNavi += pageNo;
			pageNavi += "</a></li>";
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class = 'page-item' href='/board/list?reqPage="+pageNo+"'>";				
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
			pageNavi += "</li>";
		}
		pageNavi += "</ul>";
		//list.add(pageNavi);//종속적인 관계가 아니여서 따로 클래스를 빼서 만들어야함 html에서 th:each 에서 데이터 꺼내다가 오류
		//System.out.println(pageNavi);
		BoardListData bld = new BoardListData(list, pageNavi);
		return bld;
	}

	@Transactional
	public int insertBoard(Board b, ArrayList<BoardFile> fileList) {
		//board 테이블 insert   2. 1번 작업으로 insert할때 작업한 번호 조회    3. 반복문으로 board_file 테이블 insert
		//테이블 insert
		int result = boardDao.insertBoard(b);
		System.out.println(b);
		if(result > 0) {
			//insert한 번호 조회 (마지막 번호를 가져온다)
			int boardNo = boardDao.selectBoardNo();
			//반복문으로  board_file 테이블 insert
			for(BoardFile file : fileList) {
				file.setBoardNo(boardNo);
				result += boardDao.insertBoardFile(file);
			}
		}
		return result;
	}

	@Transactional
	public Board selectOneBoard(int boardNo) {
		//boardNo 로 board 정보와 board_file 에 등록된 파일 가져오기
		//board 에 등록된 객체정보 가져오기
		Board board = boardDao.selectOneBoard(boardNo);
	    if(board != null) {
	    	//조회수 올리기 
	    	int result = boardDao.readCountBoard(boardNo);
	    	//등록된 파일 가져오기 
	    	List fileList = boardDao.selectBoardFile(boardNo);
	    	board.setFileList(fileList);
	    }
	    return board;
	}

	public Board getOneBoard(int boardNo) {
		Board board = boardDao.selectOneBoard(boardNo);
		List fileList = boardDao.selectBoardFile(boardNo);
		board.setFileList(fileList);
		return board;
	}
	@Transactional
	public int boardDelete(int boardNo) {
		return boardDao.boardDelete(boardNo);
	}
}
