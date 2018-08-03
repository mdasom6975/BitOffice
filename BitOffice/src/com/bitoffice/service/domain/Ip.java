package com.bitoffice.service.domain;

import java.sql.Date;

public class Ip {
	private int serialNo;
	private String startIp;
	private String endIp;
	private Date regDate;
	private String regId;

	///Constructor
	public Ip(){
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getStartIp() {
		return startIp;
	}
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	public String getEndIp() {
		return endIp;
	}
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Override
	public String toString() {
		return "IpVO : [serialNo] "+serialNo+" [startIp] "+startIp+" [endIp] "+endIp+" [regDate] "+ regDate
			+" [regId] "+regId;
	}
	
	
}
