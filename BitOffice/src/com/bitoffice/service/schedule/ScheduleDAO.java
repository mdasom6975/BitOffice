package com.bitoffice.service.schedule;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;


//==> 스케줄관리에서 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface ScheduleDAO {
	
	// INSERT
	public int addSchedule(Schedule schedule) throws Exception ;

	// SELECT ONE
	public Schedule getSchedule(String employeeNo) throws Exception ;

	// SELECT LIST
	public List<Schedule> getScheduleList(Search search) throws Exception ;

	// UPDATE
	public int updateSchedule(Schedule schedule) throws Exception ;
	
	// DELETE
	public int deleteSchedule(Integer id) throws Exception ;	
	
	
}