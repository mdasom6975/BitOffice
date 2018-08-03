package com.bitoffice.service.domain;

import java.sql.Date;

public class Attendance {
	
	//Field	
	private String attendanceNo;	//날짜+사번	
	private String attendateDate;
	private String employeeNo;
	private String stdStartTime;
	private String startTime;
	private String startIp;
	private String leaveDate;
	private String stdEndTime;
	private String endTime;
	private String endIp;
	private String memo;
	
	//
	private String employeeName;
	private String departmentNo;
	private String departmentName;
	private String positionNo;
	private String positionName;
	

	//Constructor
	public Attendance() {
		
	}

	public String getAttendanceNo() {
		return attendanceNo;
	}


	public void setAttendanceNo(String attendanceNo) {
		this.attendanceNo = attendanceNo;
	}


	public String getAttendateDate() {
		return attendateDate;
	}


	public void setAttendateDate(String attendateDate) {
		this.attendateDate = attendateDate;
	}


	public String getEmployeeNo() {
		return employeeNo;
	}


	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}


	public String getStdStartTime() {
		return stdStartTime;
	}


	public void setStdStartTime(String stdStartTime) {
		this.stdStartTime = stdStartTime;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getStartIp() {
		return startIp;
	}


	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}


	public String getLeaveDate() {
		return leaveDate;
	}


	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}


	public String getStdEndTime() {
		return stdEndTime;
	}


	public void setStdEndTime(String stdEndTime) {
		this.stdEndTime = stdEndTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getEndIp() {
		return endIp;
	}


	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getDepartmentNo() {
		return departmentNo;
	}


	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getPositionNo() {
		return positionNo;
	}


	public void setPositionNo(String positionNo) {
		this.positionNo = positionNo;
	}


	public String getPositionName() {
		return positionName;
	}


	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		String value = "AttendanceVO : [attendanceNo] " + attendanceNo + " [attendateDate] " + attendateDate + " [employeeNo]" + employeeNo; 
		value = value + " [stdStartTime] "+ stdStartTime + "[ startTime] " + startTime;
		value = value + " [startIp] "+ startIp + "[ leaveDate] " + leaveDate;
		value = value + " [stdEndTime] "+ stdEndTime + "[ endTime] " + endTime;
		value = value + " [endIp] "+ endIp + "[memo]" + memo;
		
		return value;
	}

	
}
