package com.bitoffice.service.organization;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;


//==> 회원관리에서 서비스할 내용 추상화/캡슐화한 Service  Interface Definition  
public interface OrganizationService {
	
	// 회원가입
	public void addOrganization(Organization orgation) throws Exception;
	
	// 내정보확인 / 로그인
	public Organization getOrganization(String orgationId) throws Exception;
	
	// 회원정보리스트 
	public String getOrganizationList(Search search) throws Exception;
	
	// 회원정보수정
	public void updateOrganization(Organization orgation) throws Exception;
	
	// 회원 ID 중복 확인
	public boolean checkDuplication(String orgationId) throws Exception;
	
}