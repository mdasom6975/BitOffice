package com.bitoffice.service.document.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.document.FileDao;
import com.bitoffice.service.document.FilesService;
import com.bitoffice.service.domain.Files;

@Service("fileServiceImpl")
public class FileServiceImpl implements FilesService{

	@Autowired
	@Qualifier("fileDaoImpl")
	private FileDao fileDao;

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	public FileServiceImpl() {
		
		System.out.println(this.getClass());
	}

	@Override
	public Files find(int id) throws Exception {
		// TODO Auto-generated method stub
		return fileDao.find(id);
	}

	@Override
	public Map<String, Object> listAll(Search search) throws Exception {
		// TODO Auto-generated method stub
		List<Files> list = fileDao.listAll(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public void save(Files file) throws Exception {
		// TODO Auto-generated method stub
		fileDao.save(file);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		fileDao.delete(id);
	}
	
	
}
