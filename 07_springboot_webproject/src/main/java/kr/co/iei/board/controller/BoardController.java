package kr.co.iei.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import kr.co.iei.board.model.dto.Board;
import kr.co.iei.board.model.dto.BoardFile;
import kr.co.iei.board.model.dto.BoardListData;
import kr.co.iei.board.model.service.BoardService;
import kr.co.iei.util.FileUtils;
//msg 메세지를 사용하면 편해진다
@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Value("${file.root}")
	private String root;//apllication.properties에서 설정값 가져오기
	
	@Autowired
	private FileUtils fileutils;
	
	@GetMapping(value="/list")
	public String list(int reqPage, Model model) {
		//페이지에 뜨는 게시물과 페이지네비 작업
		BoardListData list = boardService.selectAllBoard(reqPage);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageNavi", list.getPageNavi());
		return "board/list";
	}
	@GetMapping(value="/writeFrm")
	public String writeFrm() {
		return "board/writeFrm";
	}
	@PostMapping(value="/write")//제목, 작성자, 첨부파일, 내용
	public String write(Board b, MultipartFile[] upfile, Model model) {
		//<form enctype="multipart/form-data">  -->> controller 에서 MultipartFile[]
		
		System.out.println("b");
		//업데이트 된 파일이 있으면 arraylist 객체를 생성해서 넣어준다. 
		ArrayList<BoardFile> fileList = new ArrayList<BoardFile>();
		if(!upfile[0].isEmpty()) {
			String savepath = root+"/board/";   //root 값 가지고 와야 쓸수 있음 
			for(MultipartFile file : upfile) {
				String filename = file.getOriginalFilename();
				String filepath = fileutils.upload(savepath, file);
				BoardFile boardFile = new BoardFile();
				boardFile.setFilename(filename);
				boardFile.setFilepath(filepath);
				fileList.add(boardFile);
			}
		}
		// b : noticeTilte, noticeWriter, noticeContent
		// fileList : (BoardFile) X 개수
		int result = boardService.insertBoard(b, fileList);
		if(result > 0) {
			model.addAttribute("title", "작성 성공!");
			model.addAttribute("msg", "게시글 작성에 성공했습니다.");
			model.addAttribute("icon", "success");
			model.addAttribute("loc", "/board/list?reqPage=1");
			return "common/msg";
		}
		return "redirect:/board.wireFrm";
	}
	
	@GetMapping(value="/view")
	public String view(int boardNo, Model model) {
		//view에 보내는 정보 : 제목, 작성자, 내용, 파일불러오기 
		//view 페이지에서 보면 read_count 카운팅 
		//받은 정보 : boardNo -> board에서 원하는 정보 꺼내오기
		Board board = boardService.selectOneBoard(boardNo);
		if(board == null) {
			model.addAttribute("title", "조회실패");
			model.addAttribute("msg", "해당 게시물이 존재하지 않습니다.");
			model.addAttribute("icon", "info");
			model.addAttribute("loc", "/board/list=?reqPage=1");
			return "common/msg";
		}
		model.addAttribute("board", board);
		return "board/view";
	}
	
	@GetMapping(value="/filedown")
	public void filedown(BoardFile boardFile, HttpServletResponse response) {
		//파일 위치 
		String savepath = root + "/board/";
		fileutils.downloadFile(savepath, boardFile.getFilename(), boardFile.getFilepath(), response);
	}
	@GetMapping(value="/updateViewFrm")
	public String updateViewFrm(int boardNo, Model model) {
		Board board = boardService.getOneBoard(boardNo);
		model.addAttribute("board", board);
		return "board/updateViewFrm";
	}
	@GetMapping(value="/delete")
	public String delete(int boardNo, Model model) {
		int result = boardService.boardDelete(boardNo);
		if(result > 0) {
			return "redirect:/list?peqPage=1";
		}else {
			model.addAttribute("title", "게시글 삭제 실패");
			model.addAttribute("msg", "관리자에게 문의하세요.");
			model.addAttribute("icon", "warning");
			model.addAttribute("loc", "/board/list=?reqPage=1");
			return "common/msg";
		}
	}
}
