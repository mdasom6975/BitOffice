package com.bitoffice.service.attendance;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Attendance;

public interface AttendanceService {
	// ȸ������
	public void addAttendance(Attendance attendance) throws Exception;
	
	// ������Ȯ�� / �α���
	public Attendance getAttendance(String attendanceId) throws Exception;
	
	// ȸ����������Ʈ 
	public Map<String , Object> getAttendanceList(Search search) throws Exception;
	
	// ȸ����������
	public void updateAttendance(Attendance attendance) throws Exception;
	
	// ȸ����������
	public void deleteAttendance(Attendance attendance) throws Exception;	
	
	// ȸ�� ID �ߺ� Ȯ��
	public boolean checkDuplication(String serialNo) throws Exception;
}
