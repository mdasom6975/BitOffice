package com.bitoffice.service.domain;

public class MeetingRoom {
	
	private int meetingRoomCode;
	private String mettingRoomName;
//	private boolean deleteMeetingRoom;
	private int mR;
	
	public MeetingRoom() {
		
	}

	public int getMeetingRoomCode() {
		return meetingRoomCode;
	}

	public void setMeetingRoomCode(int meetingRoomCode) {
		this.meetingRoomCode = meetingRoomCode;
	}

	public String getMettingRoomName() {
		return mettingRoomName;
	}

	public void setMettingRoomName(String mettingRoomName) {
		this.mettingRoomName = mettingRoomName;
	}

	public int getmR() {
		return mR;
	}

	public void setmR(int mR) {
		this.mR = mR;
	}

	@Override
	public String toString() {
		return "MeetingRoom [meetingRoomCode=" + meetingRoomCode + ", mettingRoomName=" + mettingRoomName + ", mR=" + mR
				+ "]";
	}

	

	
}