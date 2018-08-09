package com.bitoffice.service.document;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Files;

public interface FilesService {

	public Files find(int id) throws Exception;

	public Map<String, Object> listAll(Search search) throws Exception;

	public void save(final Files file) throws Exception;
	
	public void delete(int id) throws Exception;

}
