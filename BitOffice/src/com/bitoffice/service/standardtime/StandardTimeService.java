package com.bitoffice.service.standardtime;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.StandardTime;

public interface StandardTimeService {
	// ȸ������
	public int addStandardTime(StandardTime standardtime) throws Exception;
	
	// ������Ȯ�� / �α���
	public StandardTime getStandardTime(String standardtimeId) throws Exception;
	
	// ȸ����������Ʈ 
	public Map<String , Object> getStandardTimeList(Search search) throws Exception;
	
	// ȸ����������
	public int updateStandardTime(StandardTime standardtime) throws Exception;
	
	// ȸ����������
	public void deleteStandardTime(StandardTime standardtime) throws Exception;	
	
	// ȸ�� ID �ߺ� Ȯ��
	public boolean checkDuplication(String standardtimeId) throws Exception;
}
