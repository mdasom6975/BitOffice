package com.bitoffice.service.reservation.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.domain.Reservation;
import com.bitoffice.service.reservation.ReservationDAO;
import com.bitoffice.service.reservation.ReservationService;

@Service("reservationServiceImpl")
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	@Qualifier("reservationDAOImpl")
	private ReservationDAO reservationDAO;
	
	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO=reservationDAO;
	}
	
	public ReservationServiceImpl() {
		
		System.out.println(this.getClass());
	}
	
	public Map<String, Object> myReservation(Search search, String employeeNo) throws Exception{
		
		Calendar sysdate = Calendar.getInstance();
		SimpleDateFormat rdate = new SimpleDateFormat("yyyy-mm-dd");
		String nowtime = rdate.format(sysdate.getTime());
		
		List<Reservation> list = reservationDAO.myReservation(search, employeeNo);
		int totalCount = reservationDAO.myTotalCount(search, employeeNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public Map<String, Object> getReservationList(Search search) throws Exception{
	
//		MeetingRoom meetingRoom = new MeetingRoom();
//		java.lang.reflect.Field fd = meetingRoom.getClass().getDeclaredField("mettingRoomName");
//		fd.setAccessible(true);
//		String mettingRoomName = (String)fd.get(meetingRoom);
//		
//		System.out.println("@@@@@@@@@@@@@미팅룸네임체크@@@@@@@"+mettingRoomName);
//	
//		
//		List mettingRoomNameList = reservationDAO.getReservationList(search);
//		List<Map<String, Object>> listMap = mettingRoomNameList;
//		
//		String mettingRoomName1 = listMap.get(0).get("mettingRoomName").toString();
//		System.out.println("###########1번실@@@@@@@@@@"+mettingRoomName1);
//		
		List<Reservation> list = reservationDAO.getReservationList(search);
		int totalCount = reservationDAO.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		System.out.println("SERVICEMAP:::"+map);
		
		return map;
	}

	public void addReservation(Reservation reservation) throws Exception {
		// TODO Auto-generated method stub
		
		reservationDAO.addReservation(reservation);		
	}
	
	public void updateReservation(Reservation reservation) throws Exception{
		
		reservationDAO.updateReservation(reservation);
		System.out.println("여기는 업데이트 서비스 레저베이션"+reservation);
	}
	
	public Reservation getReservation(int reNum) throws Exception{
		
		System.out.println("서비스 겟::::"+reNum);
		return reservationDAO.getReservation(reNum);
	}
	
	public void cancelReservation(int reNum) throws Exception{
		
		reservationDAO.cancelReservation(reNum);
	}
	
	public List<MeetingRoom> testReserveMeetingRoom() throws Exception{
		
		return reservationDAO.testReserveMeetingRoom();
	}
}
