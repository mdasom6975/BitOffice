package com.bitoffice.service.organization.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;
import com.bitoffice.service.organization.OrganizationDao;


//==> 회원관리 DAO CRUD 구현
@Repository("organizationDaoImpl")
public class OrganizationDaoImpl implements OrganizationDao{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public OrganizationDaoImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addOrganization(Organization organization) throws Exception {
		sqlSession.insert("OrganizationMapper.addOrganization", organization);
	}

	public Organization getOrganization(String organizationId) throws Exception {
		return sqlSession.selectOne("OrganizationMapper.getOrganization", organizationId);
	}
	
	public void updateOrganization(Organization organization) throws Exception {
		sqlSession.update("OrganizationMapper.updateOrganization", organization);
	}

	public List<Organization> getOrganizationList(Search search) throws Exception {
		return sqlSession.selectList("OrganizationMapper.getOrganizationList", search);		
	}

	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("OrganizationMapper.getTotalCount", search);
	}
}