package com.bitoffice.service.board;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Board;

public interface BoardService {

	
	public void addBoard(Board board) throws Exception;
	
	public Board getBoard(int boardNo) throws Exception;
	
	public Map<String, Object> getBoardList(Search search, String orderby) throws Exception;
	
	public void delete(int boardNo) throws Exception;
	
	public void updateBoard(Board board) throws Exception;
	
	public void updateFile(Board board) throws Exception;
	
	public void countView(int boardNo) throws Exception;
	
}
