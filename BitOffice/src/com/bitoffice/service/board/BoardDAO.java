package com.bitoffice.service.board;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Board;

public interface BoardDAO {

	public void addBoard(Board board) throws Exception;
	
	public Board getBoard(int boardNo) throws Exception;
	
	public List<Board> getBoardList(Search search, String orderby) throws Exception;

	// �Խ��� Page ó���� ���� ��üRow(totalCount) return
	public int getTotalCount(Search search) throws Exception;
	
	public void deleteBoard(int boardNo) throws Exception;
	
	public void updateBoard(Board board) throws Exception;
	
	public void updateFile(Board board) throws Exception;
	
	public void countView(int boardNo) throws Exception;

}
