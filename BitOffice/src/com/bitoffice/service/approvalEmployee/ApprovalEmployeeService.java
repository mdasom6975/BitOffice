package com.bitoffice.service.approvalEmployee;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.ApprovalEmployee;

public interface ApprovalEmployeeService {
	// ����, �����ΰ���
	public int addApprovalEmployee(ApprovalEmployee approval) throws Exception;
	
	// ������Ȯ�� / �α���
	public ApprovalEmployee getApprovalEmployee(String approvalId) throws Exception;
	
	// ����, ��������������Ʈ 
	public Map<String , Object> getApprovalEmployeeList(Search search) throws Exception;
	
	public List<ApprovalEmployee> getApprovalEmployeeList2(Search search) throws Exception;
	
	// ����, ��������������
	public int updateApprovalEmployee(ApprovalEmployee approval) throws Exception;
	
	// ����, ������  ����/�ݷ� ���
	public int updateApprovalEmployeeStatus(ApprovalEmployee approval) throws Exception;
	
	// ����, ��������������
	public int deleteApprovalEmployee(ApprovalEmployee approval) throws Exception;	
	
	// ����, ������ ID �ߺ� Ȯ��
	public boolean checkDuplication(String serialNo) throws Exception;
}
