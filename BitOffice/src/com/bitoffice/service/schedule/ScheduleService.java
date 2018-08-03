package com.bitoffice.service.schedule;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//==> 일정관리에서 서비스할 내용 추상화/캡슐화한 Service  Interface Definition  
public interface ScheduleService {
	
	// 일정가입
	public int addSchedule(Schedule schedule) throws Exception;
	
	// 내정보확인 / 로그인
	public Schedule getSchedule(String employeeNo) throws Exception;
	
	// 일정정보리스트 
	public String getScheduleList(Search search) throws Exception;
	
	// 일정정보수정
	public int updateSchedule(Schedule schedule) throws Exception;
	
	// 일정정보삭제
	public int deleteSchedule(Integer id) throws Exception;	
	
	// 일정 ID 중복 확인
	public boolean checkDuplication(String employeeNo) throws Exception;
	
}