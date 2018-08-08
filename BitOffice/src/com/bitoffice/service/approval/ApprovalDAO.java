package com.bitoffice.service.approval;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Approval;

public interface ApprovalDAO {

	// INSERT
	public int addApproval(Approval approval) throws Exception ;

	// SELECT ONE
	public Approval getApproval(String approvalId) throws Exception ;

	// SELECT ONE
	public int getTotalCountStatus(Approval approval) throws Exception ;	
	
	// SELECT LIST
	public List<Approval> getApprovalList(Search search) throws Exception ;

	// UPDATE
	public int updateApproval(Approval approval) throws Exception ;

	public int updateApprovalStatus(Approval approval) throws Exception ;
	
	// DELETE
	public int deleteApproval(Approval approval) throws Exception ;	
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}
