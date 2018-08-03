package com.bitoffice.service.domain;

import java.sql.Date;


//==>ÀÏÁ¤Á¤º¸¸¦ ¸ðµ¨¸µ(Ãß»óÈ­/Ä¸½¶È­)ÇÑ Bean
public class Schedule {
	
	///Field
	private String scheSerialNo;
	private String startDate;
	private String endDate;	
	private String startTime;
	private String endTime;
	private String shareRange;		
	private String title;
	private String content;		
	private String regDate;
	private String employeeNo;
	private String color;
	
	private String departmentName;
	private String positionName;
	private String employeeName;
	
	///Constructor
	public Schedule(){
	}	

	public String getScheSerialNo() {
		return scheSerialNo;
	}


	public void setScheSerialNo(String scheSerialNo) {
		this.scheSerialNo = scheSerialNo;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
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


	public String getShareRange() {
		return shareRange;
	}


	public void setShareRange(String shareRange) {
		this.shareRange = shareRange;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getEmployeeNo() {
		return employeeNo;
	}


	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}	

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPostionName() {
		return positionName;
	}

	public void setPostionName(String postionName) {
		this.positionName = postionName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Override
	public String toString() {
		return "ScheduleVO : [scheSerialNo] "+scheSerialNo+" [startDate] "+startDate+" [endDate] "+endDate+" [startTime] "+ startTime
			+" [endTime] "+endTime+" [shareRange] "+shareRange+" [title] "+title+" [content] "+content+" [regDate] "+regDate
			+" [employeeNo] "+employeeNo+" [color] "+color+" [departmentName] "+departmentName+" [postionName] "+positionName+" [employeeName] "+employeeName;
		
				
	}

	

}