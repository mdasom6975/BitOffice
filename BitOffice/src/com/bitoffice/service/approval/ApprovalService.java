package com.bitoffice.service.approval;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Approval;

public interface ApprovalService {
	// ���ڰ��簡��
	public int addApproval(Approval approval) throws Exception;
	
	// ������Ȯ�� / �α���
	public Approval getApproval(String approvalId) throws Exception;
	
	// ������º��Ǽ�
	public int getTotalCountStatus(Approval approval) throws Exception;
	
	// ���ڰ�����������Ʈ 
	public Map<String , Object> getApprovalList(Search search) throws Exception;
	
	// ���ڰ�����������
	public int updateApproval(Approval approval) throws Exception;
	
	// ���ڰ�����������
	public int updateApprovalStatus(Approval approval) throws Exception;
	
	// ���ڰ�����������
	public int deleteApproval(Approval approval) throws Exception;	
	
	// ���ڰ��� ID �ߺ� Ȯ��
	public boolean checkDuplication(String serialNo) throws Exception;
}
