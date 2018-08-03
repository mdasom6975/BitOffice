package com.bitoffice.service.domain;

import java.sql.Date;

public class Reservation {
	
	private Date reserveDate;
	private String startTime;
	private String endTime;
	private String employeeNo;
	private String usePurpose;
	private String mettingRoomName;
	private int meetingRoomStatusCode;
	private int meetingRoomFloor;
	private int reservationCode;
	private int reNum;
	private Date nowDate;
	
	public Reservation() {
		
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getUsePurpose() {
		return usePurpose;
	}

	public void setUsePurpose(String usePurpose) {
		this.usePurpose = usePurpose;
	}

	public String getmettingRoomName() {
		return mettingRoomName;
	}

	public void setmettingRoomName(String mettingRoomName) {
		this.mettingRoomName = mettingRoomName;
	}

	public int getMeetingRoomStatusCode() {
		return meetingRoomStatusCode;
	}

	public void setMeetingRoomStatusCode(int meetingRoomStatusCode) {
		this.meetingRoomStatusCode = meetingRoomStatusCode;
	}

	public int getReNum() {
		return reNum;
	}

	public void setReNum(int reNum) {
		this.reNum = reNum;
	}

	public int getMeetingRoomFloor() {
		return meetingRoomFloor;
	}

	public void setMeetingRoomFloor(int meetingRoomFloor) {
		this.meetingRoomFloor = meetingRoomFloor;
	}

	public int getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(int reservationCode) {
		this.reservationCode = reservationCode;
	}

	
	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	@Override
	public String toString() {
		return "Reservation [reserveDate=" + reserveDate + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", employeeNo=" + employeeNo + ", usePurpose=" + usePurpose + ", mettingRoomName=" + mettingRoomName
				+ ", meetingRoomStatusCode=" + meetingRoomStatusCode + ", meetingRoomFloor=" + meetingRoomFloor
				+ ", reservationCode=" + reservationCode + ", reNum=" + reNum + ", nowDate=" + nowDate + "]";
	}


	


}
