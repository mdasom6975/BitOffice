package com.bitoffice.service.approvalEmployee;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.ApprovalEmployee;

public interface ApprovalEmployeeDAO {

	// INSERT
	public int addApprovalEmployee(ApprovalEmployee approval) throws Exception ;

	// SELECT ONE
	public ApprovalEmployee getApprovalEmployee(String approvalId) throws Exception ;

	// SELECT LIST
	public List<ApprovalEmployee> getApprovalEmployeeList(Search search) throws Exception ;

	// SELECT LIST
	public List<ApprovalEmployee> getApprovalEmployeeList2(Search search) throws Exception ;
	
	// UPDATE
	public int updateApprovalEmployee(ApprovalEmployee approval) throws Exception ;
	
	public int updateApprovalEmployeeStatus(ApprovalEmployee approval) throws Exception ;	
	
	// DELETE
	public int deleteApprovalEmployee(ApprovalEmployee approval) throws Exception ;	
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}
