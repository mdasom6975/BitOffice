package com.bitoffice.service.share.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Share;
import com.bitoffice.service.share.ShareDAO;


//==> 회원관리 DAO CRUD 구현
@Repository("shareDAOImpl")
public class ShareDAOImpl implements ShareDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public ShareDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addShare(Share share) throws Exception {
		sqlSession.insert("ShareMapper.addShare", share);
	}

	public Share getShare(Share share) throws Exception {
		return sqlSession.selectOne("ShareMapper.getShare", share);
	}
	
	public void updateShare(Share share) throws Exception {
		sqlSession.update("ShareMapper.updateShare", share);
	}
	
	public void deleteShare(String shareNo) throws Exception {
		sqlSession.delete("ShareMapper.deleteShare", shareNo);
	}	

	public List<Share> getShareList(Search search) throws Exception {
		return sqlSession.selectList("ShareMapper.getShareList", search);
	}
	
	public List<Share> getShareList2(Search search) throws Exception {
		return sqlSession.selectList("ShareMapper.getShareList", search);
	}	

	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ShareMapper.getTotalCount", search);
	}
}