package com.bitoffice.service.schedule;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//==> ������������ ������ ���� �߻�ȭ/ĸ��ȭ�� Service  Interface Definition  
public interface ScheduleService {
	
	// ��������
	public int addSchedule(Schedule schedule) throws Exception;
	
	// ������Ȯ�� / �α���
	public Schedule getSchedule(String employeeNo) throws Exception;
	
	// ������������Ʈ 
	public String getScheduleList(Search search) throws Exception;
	
	// ������������
	public int updateSchedule(Schedule schedule) throws Exception;
	
	// ������������
	public int deleteSchedule(Integer id) throws Exception;	
	
	// ���� ID �ߺ� Ȯ��
	public boolean checkDuplication(String employeeNo) throws Exception;
	
}