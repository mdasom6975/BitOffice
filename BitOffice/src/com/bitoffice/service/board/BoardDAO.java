package com.bitoffice.service.board;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Board;

public interface BoardDAO {

	public void addBoard(Board board) throws Exception;
	
	public Board getBoard(int boardNo) throws Exception;
	
	public List<Board> getBoardList(Search search, String orderby) throws Exception;

	// 게시판 Page 처리를 위한 전체Row(totalCount) return
	public int getTotalCount(Search search) throws Exception;
	
	public void deleteBoard(int boardNo) throws Exception;
	
	public void updateBoard(Board board) throws Exception;
	
	public void updateFile(Board board) throws Exception;
	
	public void countView(int boardNo) throws Exception;

}
