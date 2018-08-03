package com.bitoffice.service.organization;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;


//==> ȸ���������� CRUD �߻�ȭ/ĸ��ȭ�� DAO Interface Definition
public interface OrganizationDao {
	
	// INSERT
	public void addOrganization(Organization user) throws Exception ;

	// SELECT ONE
	public Organization getOrganization(String userId) throws Exception ;

	// SELECT LIST
	public List<Organization> getOrganizationList(Search search) throws Exception ;

	// UPDATE
	public void updateOrganization(Organization user) throws Exception ;
	
	// �Խ��� Page ó���� ���� ��üRow(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}