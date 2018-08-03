package com.bitoffice.service.meetingroom;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;

public interface MeetingRoomDAO {
	
	//ȸ�ǽ� �߰�
	public void addMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
	//ȸ�ǽ� ���� ���
	public List<MeetingRoom> getMeetingRoomList(Search search) throws Exception;

	//totalCount
	public int getTotalCount(Search search) throws Exception;
	
	//ȸ�ǽ� ����
	public void deleteMeetingRoom(int meetingRoomCode) throws Exception;
	
	//ȸ�ǽ� �ߺ�üũ
	public int codeCheck(int meetingRoomCode) throws Exception;
	
	public int nameCheck(String mettingRoomName) throws Exception;
	
	//ȸ�ǽ� ����
	public void updateMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
	public MeetingRoom getMeetingRoom(int mR) throws Exception;

	//json list
	public List<MeetingRoom> getReserveMeetingRoom() throws Exception;
	
}
