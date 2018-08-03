package com.bitoffice.service.attendance.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Attendance;
import com.bitoffice.service.attendance.AttendanceService;
import com.bitoffice.service.attendance.AttendanceDAO;


//==> 회원관리 서비스 구현
@Service("attendanceServiceImpl")
public class AttendanceServiceImpl implements AttendanceService{
	
	///Field
	@Autowired
	@Qualifier("attendanceDAOImpl")
	private AttendanceDAO attendanceDao;
	public void setAttendanceDao(AttendanceDAO attendanceDao) {
		this.attendanceDao = attendanceDao;
	}
	
	///Constructor
	public AttendanceServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addAttendance(Attendance attendance) throws Exception {
		attendanceDao.addAttendance(attendance);
	}

	public Attendance getAttendance(String attendanceId) throws Exception {
		return attendanceDao.getAttendance(attendanceId);
	}

	public Map<String , Object > getAttendanceList(Search search) throws Exception {
		List<Attendance> list= attendanceDao.getAttendanceList(search);
		int totalCount = attendanceDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public void updateAttendance(Attendance attendance) throws Exception {
		attendanceDao.updateAttendance(attendance);
	}
	
	public void deleteAttendance(Attendance attendance) throws Exception {
		attendanceDao.deleteAttendance(attendance);
	}	

	public boolean checkDuplication(String attendanceId) throws Exception {
		boolean result=true;
		Attendance attendance=attendanceDao.getAttendance(attendanceId);
		if(attendance != null) {
			result=false;
		}
		return result;
	}
}