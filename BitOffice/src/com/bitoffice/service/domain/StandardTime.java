package com.bitoffice.service.domain;

import java.sql.Date;

public class StandardTime {
	
	//Filed
	private int serialNo;	
	private String stdStartTime;
	private String stdEndTime;
	private Date regDate;
	private String regEmployeeNo;

	//Constructor
	public StandardTime() {
		
	}

	public String getStdStartTime() {
		return stdStartTime;
	}

	public void setStdStartTime(String stdStartTime) {
		this.stdStartTime = stdStartTime;
	}

	public String getStdEndTime() {
		return stdEndTime;
	}

	public void setStdEndTime(String stdEndTime) {
		this.stdEndTime = stdEndTime;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegEmployeeNo() {
		return regEmployeeNo;
	}

	public void setRegEmployeeNo(String regEmployeeNo) {
		this.regEmployeeNo = regEmployeeNo;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "StandardTime [stdStartTime=" + stdStartTime + ", stdEndTime=" + stdEndTime + ", regDate=" + regDate
				+ ", regEmployeeNo=" + regEmployeeNo + ", serialNo=" + serialNo + "]";
	}

}
