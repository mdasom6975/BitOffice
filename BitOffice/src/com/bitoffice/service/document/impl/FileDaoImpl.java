package com.bitoffice.service.document.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.document.FileDao;
import com.bitoffice.service.domain.Files;

@Repository("fileDaoImpl")
public class FileDaoImpl implements FileDao{

	@Autowired
	@Qualifier("sqlSessionTemplate2")
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public FileDaoImpl() {
		
		System.out.println(this.getClass());
	}

	@Override
	public Files find(int id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("FileMapper.getFile", id);
	}

	@Override
	public List<Files> listAll(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("FileMapper.listFile");
	}

	@Override
	public void save(Files file) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("FileMapper.uploadFile", file);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("FileMapper.deleteFile", id);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("FileMapper.fileTotalCount", search);
	}
	
	
}
