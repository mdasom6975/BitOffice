package com.bitoffice.service.organization;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;


//==> 회원관리에서 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface OrganizationDao {
	
	// INSERT
	public void addOrganization(Organization user) throws Exception ;

	// SELECT ONE
	public Organization getOrganization(String userId) throws Exception ;

	// SELECT LIST
	public List<Organization> getOrganizationList(Search search) throws Exception ;

	// UPDATE
	public void updateOrganization(Organization user) throws Exception ;
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}