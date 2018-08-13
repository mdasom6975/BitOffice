package com.bitoffice.service.document;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Files;

public interface FileDao {

	public Files find(int id) throws Exception;

	public List<Files> listAll(Search search) throws Exception;

	public void save(final Files file) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;

}
