package com.bitoffice.service.schedule.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;
import com.bitoffice.service.schedule.ScheduleDAO;


//==> 스케줄관리 DAO CRUD 구현
@Repository("scheduleDAOImpl")
public class ScheduleDAOImpl implements ScheduleDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public ScheduleDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addSchedule(Schedule schedule) throws Exception {	
		
		 int returnValue = sqlSession.insert("ScheduleMapper.addSchedule", schedule);
		 
		 return returnValue;
	}

	public Schedule getSchedule(String employeeNo) throws Exception {
		
		System.out.println("==>>"+employeeNo);
		
		return sqlSession.selectOne("ScheduleMapper.getSchedule", employeeNo);
		
	}
	
	public int updateSchedule(Schedule schedule) throws Exception {
		
		 int returnValue = sqlSession.update("ScheduleMapper.updateSchedule", schedule);
		 
		 return returnValue;		
	}
	
	public int deleteSchedule(Integer id) throws Exception {
		
		 int returnValue = sqlSession.delete("ScheduleMapper.deleteSchedule", id);
		 
		 return returnValue;		
	}	

	public List<Schedule> getScheduleList(Search search) throws Exception {
		return sqlSession.selectList("ScheduleMapper.getScheduleList", search);
	}

	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ScheduleMapper.getTotalCount", search);
	}
}