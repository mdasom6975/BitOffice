package com.bitoffice.service.board.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.board.BoardDAO;
import com.bitoffice.service.domain.Board;




@Repository("boardDAOImpl")
public class BoardDAOImpl implements BoardDAO {
	
	///Field
		@Autowired
		@Qualifier("sqlSessionTemplate")
		private SqlSession sqlSession;
		public void setSqlSession(SqlSession sqlSession) {
			this.sqlSession = sqlSession;
		}
		
		///Constructor
		public BoardDAOImpl() {
			System.out.println(this.getClass());
		}

		@Override
		public void addBoard(Board board) throws Exception {
			sqlSession.insert("BoardMapper.addBoard", board);
			
		}

		@Override
		public List<Board> getBoardList(Search search, String orderby) throws Exception {
			
			Map<String, String > map = new HashMap<String, String>();
			map.put("searchCondition", search.getSearchCondition());
			map.put("searchKeyword", search.getSearchKeyword());
			map.put("endRowNum", search.getEndRowNum()+"");
			map.put("startRowNum", search.getStartRowNum()+"");		
			map.put("orderby", orderby);
			
			return sqlSession.selectList("BoardMapper.getBoardList", map);
		}

		@Override
		public int getTotalCount(Search search) throws Exception {
			
			return sqlSession.selectOne("BoardMapper.getTotalCount", search);
		}

		@Override
		public Board getBoard(int boardNo) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("BoardMapper.getBoard", boardNo);
		}

		@Override
		public void deleteBoard(int boardNo) throws Exception {
			sqlSession.delete("BoardMapper.deleteBoard", boardNo);
			
		}

		@Override
		public void updateBoard(Board board) throws Exception {
			sqlSession.update("BoardMapper.updateBoard", board);
			
		}

		@Override
		public void updateFile(Board board) throws Exception {
			sqlSession.insert("BoardMapper.updateFile", board);
			
		}

		@Override
		public void countView(int boardNo) throws Exception {
			
		sqlSession.update("BoardMapper.countView", boardNo);
		}
}
