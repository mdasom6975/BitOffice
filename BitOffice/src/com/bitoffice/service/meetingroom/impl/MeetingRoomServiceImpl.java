package com.bitoffice.service.meetingroom.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.meetingroom.MeetingRoomDAO;
import com.bitoffice.service.meetingroom.MeetingRoomService;

@Service("meetingRoomServiceImpl")
public class MeetingRoomServiceImpl implements MeetingRoomService {
	
	@Autowired
	@Qualifier("meetingRoomDAOImpl")
	private MeetingRoomDAO meetingRoomDAO;
	public void setMeetingRoomDAO(MeetingRoomDAO meetingRoomDAO) {
		
		this.meetingRoomDAO = meetingRoomDAO;
	}
	
	public MeetingRoomServiceImpl() {
		
		System.out.println(this.getClass());
	}
	
	public void addMeetingRoom(MeetingRoom meetingRoom) throws Exception{
		
		meetingRoomDAO.addMeetingRoom(meetingRoom);
	}
	
	public Map<String, Object> getMeetingRoomList(Search search) throws Exception{
		
		List<MeetingRoom> list = meetingRoomDAO.getMeetingRoomList(search);
		int totalCount = meetingRoomDAO.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;		
	}
	
	public void deleteMeetingRoom(int meetingRoomCode) throws Exception{
		
		meetingRoomDAO.deleteMeetingRoom(meetingRoomCode);
	}
	
	public int codeCheck(int meetingRoomCode) throws Exception{
		
		return meetingRoomDAO.codeCheck(meetingRoomCode);
	}
	
	public int nameCheck(String mettingRoomName) throws Exception{
		
		return meetingRoomDAO.nameCheck(mettingRoomName);
	}
	
	public void updateMeetingRoom(MeetingRoom meetingRoom) throws Exception{
		
		meetingRoomDAO.updateMeetingRoom(meetingRoom);
		System.out.println("여기는 서비스임플"+meetingRoom);
	}
	
	public MeetingRoom getMeetingRoom(int mR) throws Exception{
		
		return meetingRoomDAO.getMeetingRoom(mR);
	}
	
	public List<MeetingRoom> getReserveMeetingRoom() throws Exception{
		
		return meetingRoomDAO.getReserveMeetingRoom();
	}
	
	

}
