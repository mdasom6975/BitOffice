package com.bitoffice.service.ip.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Ip;
import com.bitoffice.service.ip.IpDAO;


//==> ȸ������ DAO CRUD ����
@Repository("ipDAOImpl")
public class IpDAOImpl implements IpDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public IpDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addIp(Ip ip) throws Exception {
		int resultValue = sqlSession.insert("IpMapper.addIp", ip);

		return resultValue;
	}

	public Ip getIp(Ip ip) throws Exception {
		return sqlSession.selectOne("IpMapper.getIp", ip);
	}
	
	public int updateIp(Ip ip) throws Exception {
		
		int resultValue = sqlSession.update("IpMapper.updateIp", ip);
		return resultValue;		
	}
	
	public int deleteIp(Integer serialNo) throws Exception {
		
		int resultValue = sqlSession.delete("IpMapper.deleteIp", serialNo);
		return resultValue;			
	}	

	public List<Ip> getIpList(Search search) throws Exception {
		return sqlSession.selectList("IpMapper.getIpList", search);
	}

	// �Խ��� Page ó���� ���� ��ü Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("IpMapper.getTotalCount", search);
	}
}