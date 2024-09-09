package kr.co.iei.board.model.vo;

public class Board {

	private int boardNo;

	private String boardWriter;

	private String boardTitle;

	private String boardContent;

	private int readCount;

	public Board() {

		super();

// TODO Auto-generated constructor stub

	}

	public Board(int boardNo, String boardWriter, String boardTitle, String boardContent, int readCount) {

		super();

		this.boardNo = boardNo;

		this.boardWriter = boardWriter;

		this.boardTitle = boardTitle;

		this.boardContent = boardContent;

		this.readCount = readCount;

	}

	public int getBoardNo() {

		return boardNo;

	}

	public void setBoardNo(int boardNo) {

		this.boardNo = boardNo;

	}

	public String getBoardWriter() {

		return boardWriter;

	}

	public void setBoardWriter(String boardWriter) {

		this.boardWriter = boardWriter;

	}

	public String getBoardTitle() {

		return boardTitle;

	}

	public void setBoardTitle(String boardTitle) {

		this.boardTitle = boardTitle;

	}

	public String getBoardContent() {

		return boardContent;

	}

	public void setBoardContent(String boardContent) {

		this.boardContent = boardContent;

	}

	public int getReadCount() {

		return readCount;

	}

	public void setReadCount(int readCount) {

		this.readCount = readCount;

	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", readCount=" + readCount + "]";
	}

	
	
}