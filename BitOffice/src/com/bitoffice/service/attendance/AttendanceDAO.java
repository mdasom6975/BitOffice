package com.bitoffice.service.attendance;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Attendance;

public interface AttendanceDAO {

	// INSERT
	public void addAttendance(Attendance attendance) throws Exception ;

	// SELECT ONE
	public Attendance getAttendance(String attendanceId) throws Exception ;

	// SELECT LIST
	public List<Attendance> getAttendanceList(Search search) throws Exception ;

	// UPDATE
	public void updateAttendance(Attendance attendance) throws Exception ;
	
	// DELETE
	public void deleteAttendance(Attendance attendance) throws Exception ;	
	
	// �Խ��� Page ó���� ���� ��üRow(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}
