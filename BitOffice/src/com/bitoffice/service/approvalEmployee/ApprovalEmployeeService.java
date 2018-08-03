package com.bitoffice.service.approvalEmployee;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.ApprovalEmployee;

public interface ApprovalEmployeeService {
	// 결재, 참조인가입
	public int addApprovalEmployee(ApprovalEmployee approval) throws Exception;
	
	// 내정보확인 / 로그인
	public ApprovalEmployee getApprovalEmployee(String approvalId) throws Exception;
	
	// 결재, 참조인정보리스트 
	public Map<String , Object> getApprovalEmployeeList(Search search) throws Exception;
	
	public List<ApprovalEmployee> getApprovalEmployeeList2(Search search) throws Exception;
	
	// 결재, 참조인정보수정
	public int updateApprovalEmployee(ApprovalEmployee approval) throws Exception;
	
	// 결재, 참조인  승인/반려 등록
	public int updateApprovalEmployeeStatus(ApprovalEmployee approval) throws Exception;
	
	// 결재, 참조인정보수정
	public int deleteApprovalEmployee(ApprovalEmployee approval) throws Exception;	
	
	// 결재, 참조인 ID 중복 확인
	public boolean checkDuplication(String serialNo) throws Exception;
}
