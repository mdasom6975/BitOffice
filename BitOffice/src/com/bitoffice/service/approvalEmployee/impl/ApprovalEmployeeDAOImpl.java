package com.bitoffice.service.approvalEmployee.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.ApprovalEmployee;
import com.bitoffice.service.approvalEmployee.ApprovalEmployeeDAO;


//==> 회원관리 DAO CRUD 구현
@Repository("approvalEmployeeDAOImpl")
public class ApprovalEmployeeDAOImpl implements ApprovalEmployeeDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public ApprovalEmployeeDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addApprovalEmployee(ApprovalEmployee approvalEmployee) throws Exception {		
		int resultValue = sqlSession.insert("ApprovalEmployeeMapper.addApprovalEmployee", approvalEmployee);
		return resultValue;
	}

	public ApprovalEmployee getApprovalEmployee(String approvalEmployeeId) throws Exception {
		return sqlSession.selectOne("ApprovalEmployeeMapper.getApprovalEmployee", approvalEmployeeId);
	}
	
	public int updateApprovalEmployee(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = sqlSession.update("ApprovalEmployeeMapper.updateApprovalEmployee", approvalEmployee);
		return resultValue;
	}
	
	public int updateApprovalEmployeeStatus(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = sqlSession.update("ApprovalEmployeeMapper.updateApprovalEmployeeStatus", approvalEmployee);
		return resultValue;
	}	
	
	public int deleteApprovalEmployee(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = sqlSession.delete("ApprovalEmployeeMapper.deleteApprovalEmployee", approvalEmployee);
		return resultValue;
	}	

	public List<ApprovalEmployee> getApprovalEmployeeList(Search search) throws Exception {
		return sqlSession.selectList("ApprovalEmployeeMapper.getApprovalEmployeeList", search);
	}
	
	public List<ApprovalEmployee> getApprovalEmployeeList2(Search search) throws Exception {
		return sqlSession.selectList("ApprovalEmployeeMapper.getApprovalEmployeeList", search);
	}	

	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ApprovalEmployeeMapper.getTotalCount", search);
	}
}