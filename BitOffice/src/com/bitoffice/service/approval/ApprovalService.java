package com.bitoffice.service.approval;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Approval;

public interface ApprovalService {
	// 전자결재가입
	public int addApproval(Approval approval) throws Exception;
	
	// 내정보확인 / 로그인
	public Approval getApproval(String approvalId) throws Exception;
	
	// 결재상태별건수
	public int getTotalCountStatus(Approval approval) throws Exception;
	
	// 전자결재정보리스트 
	public Map<String , Object> getApprovalList(Search search) throws Exception;
	
	// 전자결재정보수정
	public int updateApproval(Approval approval) throws Exception;
	
	// 전자결재정보수정
	public int updateApprovalStatus(Approval approval) throws Exception;
	
	// 전자결재정보수정
	public int deleteApproval(Approval approval) throws Exception;	
	
	// 전자결재 ID 중복 확인
	public boolean checkDuplication(String serialNo) throws Exception;
}
