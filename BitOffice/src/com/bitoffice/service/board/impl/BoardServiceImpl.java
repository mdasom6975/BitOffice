package com.bitoffice.service.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.board.BoardDAO;
import com.bitoffice.service.board.BoardService;
import com.bitoffice.service.domain.Board;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

	// Field
	@Autowired
	@Qualifier("boardDAOImpl")
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {

		this.boardDAO = boardDAO;
	}

	// Constructor
	public BoardServiceImpl() {
		System.out.println(this.getClass());

	}

	@Override
	public void addBoard(Board board) throws Exception {
		boardDAO.addBoard(board);

	}

	@Override
	public Map<String, Object> getBoardList(Search search, String orderby) throws Exception {

		List<Board> list = boardDAO.getBoardList(search, orderby);
		int totalCount = boardDAO.getTotalCount(search);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));

		return map;
	}

	@Override
	public Board getBoard(int boardNo) throws Exception {
		return boardDAO.getBoard(boardNo);
	}

	@Override
	public void delete(int boardNo) throws Exception {
		boardDAO.deleteBoard(boardNo);

	}

	@Override
	public void updateBoard(Board board) throws Exception {
		boardDAO.updateBoard(board);

	}

	@Override
	public void updateFile(Board board) throws Exception {
		boardDAO.updateFile(board);

	}

	@Override
	public void countView(int boardNo) throws Exception {
		boardDAO.countView(boardNo);
	}

}
