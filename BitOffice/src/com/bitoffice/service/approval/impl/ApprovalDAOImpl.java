package com.bitoffice.service.approval.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Approval;
import com.bitoffice.service.approval.ApprovalDAO;


//==> 회원관리 DAO CRUD 구현
@Repository("approvalDAOImpl")
public class ApprovalDAOImpl implements ApprovalDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public ApprovalDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addApproval(Approval approval) throws Exception {
		int resultvalue = sqlSession.insert("ApprovalMapper.addApproval", approval);
		return resultvalue;
	}

	public Approval getApproval(String approvalId) throws Exception {
		return sqlSession.selectOne("ApprovalMapper.getApproval", approvalId);
	}
	
	public int getTotalCountStatus(Approval approval) throws Exception {
		int resultvalue = sqlSession.selectOne("ApprovalMapper.getTotalCountStatus", approval);
		return resultvalue;
	}	
	
	public int updateApproval(Approval approval) throws Exception {
		int resultvalue = sqlSession.update("ApprovalMapper.updateApproval", approval);
		return resultvalue;
	}
	
	public int updateApprovalStatus(Approval approval) throws Exception {
		int resultvalue = sqlSession.update("ApprovalMapper.updateApprovalStatus", approval);
		return resultvalue;
	}	
	
	public int deleteApproval(Approval approval) throws Exception {
		int resultvalue = sqlSession.delete("ApprovalMapper.deleteApproval", approval);
		return resultvalue;
	}	

	public List<Approval> getApprovalList(Search search) throws Exception {
		return sqlSession.selectList("ApprovalMapper.getApprovalList", search);
	}

	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ApprovalMapper.getTotalCount", search);
	}
}