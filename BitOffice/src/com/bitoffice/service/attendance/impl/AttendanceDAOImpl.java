package com.bitoffice.service.attendance.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Attendance;
import com.bitoffice.service.attendance.AttendanceDAO;


//==> 회원관리 DAO CRUD 구현
@Repository("attendanceDAOImpl")
public class AttendanceDAOImpl implements AttendanceDAO{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public AttendanceDAOImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addAttendance(Attendance attendance) throws Exception {		
		sqlSession.insert("AttendanceMapper.addAttendance", attendance);
	}

	public Attendance getAttendance(String attendanceId) throws Exception {
		return sqlSession.selectOne("AttendanceMapper.getAttendance", attendanceId);
	}
	
	public void updateAttendance(Attendance attendance) throws Exception {
		sqlSession.update("AttendanceMapper.updateAttendance", attendance);
	}
	
	public void deleteAttendance(Attendance attendance) throws Exception {
		sqlSession.delete("AttendanceMapper.deleteAttendance", attendance);
	}	

	public List<Attendance> getAttendanceList(Search search) throws Exception {
		return sqlSession.selectList("AttendanceMapper.getAttendanceList", search);
	}

	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("AttendanceMapper.getTotalCount", search);
	}
}