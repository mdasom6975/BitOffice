package com.bitoffice.service.standardtime.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.StandardTime;
import com.bitoffice.service.standardtime.StandardTimeService;
import com.bitoffice.service.standardtime.StandardTimeDAO;


//==> 회원관리 서비스 구현
@Service("standardtimeServiceImpl")
public class StandardTimeServiceImpl implements StandardTimeService{
	
	///Field
	@Autowired
	@Qualifier("standardtimeDAOImpl")
	private StandardTimeDAO standardtimeDao;
	public void setStandardTimeDao(StandardTimeDAO standardtimeDao) {
		this.standardtimeDao = standardtimeDao;
	}
	
	///Constructor
	public StandardTimeServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addStandardTime(StandardTime standardtime) throws Exception {
		int returnValue = standardtimeDao.addStandardTime(standardtime);
		return returnValue;
	}

	public StandardTime getStandardTime(String serialNo) throws Exception {
		return standardtimeDao.getStandardTime(serialNo);
	}

	public Map<String , Object > getStandardTimeList(Search search) throws Exception {
		List<StandardTime> list= standardtimeDao.getStandardTimeList(search);
		int totalCount = standardtimeDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public int updateStandardTime(StandardTime standardtime) throws Exception {
		
		int returnValue = standardtimeDao.updateStandardTime(standardtime);
		return returnValue;		
	}
	
	public void deleteStandardTime(StandardTime standardtime) throws Exception {
		standardtimeDao.deleteStandardTime(standardtime);
	}	

	public boolean checkDuplication(String standardtimeId) throws Exception {
		boolean result=true;
		StandardTime standardtime=standardtimeDao.getStandardTime(standardtimeId);
		if(standardtime != null) {
			result=false;
		}
		return result;
	}
}