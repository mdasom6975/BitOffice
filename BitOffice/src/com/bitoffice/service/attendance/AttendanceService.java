package com.bitoffice.service.attendance;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Attendance;

public interface AttendanceService {
	// 회원가입
	public void addAttendance(Attendance attendance) throws Exception;
	
	// 내정보확인 / 로그인
	public Attendance getAttendance(String attendanceId) throws Exception;
	
	// 회원정보리스트 
	public Map<String , Object> getAttendanceList(Search search) throws Exception;
	
	// 회원정보수정
	public void updateAttendance(Attendance attendance) throws Exception;
	
	// 회원정보수정
	public void deleteAttendance(Attendance attendance) throws Exception;	
	
	// 회원 ID 중복 확인
	public boolean checkDuplication(String serialNo) throws Exception;
}
