package com.bitoffice.service.reservation.impl;

import java.text.Format.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.domain.Reservation;
import com.bitoffice.service.reservation.ReservationDAO;
import com.bitoffice.service.reservation.ReservationService;

@Repository("reservationDAOImpl")
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public ReservationDAOImpl() {
		
		System.out.println(this.getClass());
	}
	
	public List<Reservation> myReservation(Search search, String employeeNo) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("employeeNo", employeeNo);
		System.out.println("DAOOOOOOOOOOOOOOOOOOOOOOOOOO"+map);
		
		return sqlSession.selectList("ReservationMapper.myReservation", map);
	}
	
	public int myTotalCount(Search search, String employeeNo) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("employeeNo", employeeNo);
		
		return sqlSession.selectOne("ReservationMapper.myTotalCount", map);
	}
		
	public List<Reservation> getReservationList(Search search) throws Exception{
		
//		MeetingRoom meetingRoom = new MeetingRoom();
//		java.lang.reflect.Field fd = meetingRoom.getClass().getDeclaredField("mettingRoomName");
//		fd.setAccessible(true);
//		String mettingRoomName = (String)fd.get(meetingRoom);
//		
//		System.out.println("@@@@@@@@@@@@@미팅룸네임체크@@@@@@@"+mettingRoomName);
//		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
//		map.put("mettingRoomName", mettingRoomName);
		System.out.println("DAOOOOOOOOOOOOOOOOOOOOOOOOOOMAP:::"+map);
		
		return sqlSession.selectList("ReservationMapper.getReservationList", map);
	}
	
	public int getTotalCount(Search search) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
//		map.put("mettingRoomName", mettingRoomName);
		System.out.println("TOTALLLLLLLLLLLLLLMAP:::"+map);
		
		return sqlSession.selectOne("ReservationMapper.getTotalCount", map);
	}

	@Override
	public void addReservation(Reservation reservation) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.insert("ReservationMapper.addReservation", reservation);
	}
	
	public void updateReservation(Reservation reservation) throws Exception {
		
		sqlSession.update("ReservationMapper.updateReservation", reservation);
		System.out.println("여기는 업데이트 레저베이션"+reservation);
	}
	
	public Reservation getReservation(int reNum) throws Exception{
		
		System.out.println("겟  ::"+reNum);
		return sqlSession.selectOne("ReservationMapper.getReservation", reNum);
	}
	
	public void cancelReservation(int reNum) throws Exception{
		
		sqlSession.delete("ReservationMapper.cancelReservation", reNum);
	}
	
	public List<MeetingRoom> testReserveMeetingRoom() throws Exception{
		
		return sqlSession.selectList("ReservationMapper.getReservationList");
	}
	
}
