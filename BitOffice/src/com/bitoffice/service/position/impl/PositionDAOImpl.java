package com.bitoffice.service.position.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Position;
import com.bitoffice.service.position.PositionDAO;

//==> 流鞭包府 CRUD 备泅
@Repository("positionDAOImpl")
public class PositionDAOImpl implements PositionDAO {
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public PositionDAOImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addPosition(Position position) throws Exception {
		sqlSession.insert("PositionMapper.addPosition", position);
		
	}

	@Override
	public List<Position> getPositionList(Search search) throws Exception {
		
		return sqlSession.selectList("PositionMapper.getPositionList", search);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		
		return sqlSession.selectOne("PositionMapper.getTotalCount", search);
	}

	@Override
	public List<Position> getAllPosition() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("PositionMapper.getAllPosition");
	}

	@Override
	public void updatePosition(Position position) throws Exception {
		sqlSession.update("PositionMapper.updatePosition",position);
		
	}

	@Override
	public int dbCheck(String positionName) throws Exception {
		
		return sqlSession.selectOne("PositionMapper.dbChckPosition", positionName);
	}

	@Override
	public Position getPosition(String positionNo) throws Exception {
		
		return sqlSession.selectOne("PositionMapper.getPosition", positionNo);
	}

	@Override
	public void deletePosition(String positionNo) throws Exception {
		sqlSession.delete("PositionMapper.deletePosition", positionNo);
	}

	

}
