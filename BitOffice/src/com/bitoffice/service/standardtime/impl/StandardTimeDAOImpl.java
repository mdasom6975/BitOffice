package com.bitoffice.service.standardtime.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.StandardTime;
import com.bitoffice.service.standardtime.StandardTimeDAO;


//==> ȸ������ DAO CRUD ����
@Repository("standardtimeDAOImpl")
public class StandardTimeDAOImpl implements StandardTimeDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public StandardTimeDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addStandardTime(StandardTime standardtime) throws Exception {
		int resultValue = sqlSession.insert("StandardTimeMapper.addStandardTime", standardtime);
		return resultValue;
	}

	public StandardTime getStandardTime(String serialNo) throws Exception {
		return sqlSession.selectOne("StandardTimeMapper.getStandardTime", serialNo);
	}
	
	public int updateStandardTime(StandardTime standardtime) throws Exception {
		
		int resultValue = sqlSession.update("StandardTimeMapper.updateStandardTime", standardtime);
		return resultValue;		
	}
	
	public int deleteStandardTime(StandardTime standardtime) throws Exception {
		
		int resultValue = sqlSession.delete("StandardTimeMapper.deleteStandardTime", standardtime);
		return resultValue;		
	}	

	public List<StandardTime> getStandardTimeList(Search search) throws Exception {
		return sqlSession.selectList("StandardTimeMapper.getStandardTimeList", search);
	}

	// �Խ��� Page ó���� ���� ��ü Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("StandardTimeMapper.getTotalCount", search);
	}
}