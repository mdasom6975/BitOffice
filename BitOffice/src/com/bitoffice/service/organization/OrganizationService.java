package com.bitoffice.service.organization;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;


//==> ȸ���������� ������ ���� �߻�ȭ/ĸ��ȭ�� Service  Interface Definition  
public interface OrganizationService {
	
	// ȸ������
	public void addOrganization(Organization orgation) throws Exception;
	
	// ������Ȯ�� / �α���
	public Organization getOrganization(String orgationId) throws Exception;
	
	// ȸ����������Ʈ 
	public String getOrganizationList(Search search) throws Exception;
	
	// ȸ����������
	public void updateOrganization(Organization orgation) throws Exception;
	
	// ȸ�� ID �ߺ� Ȯ��
	public boolean checkDuplication(String orgationId) throws Exception;
	
}