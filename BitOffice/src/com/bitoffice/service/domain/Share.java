package com.bitoffice.service.domain;

public class Share {

	///Field
	private String shareNo;
	private String requestEmployeeNo;
	private String requestEmployeeName;	
	private String requestDepartmentName;	
	private String requestPositionName;		
	private String acceptEmployeeNo;
	private String acceptEmployeeName;	
	private String acceptDepartmentName;	
	private String acceptPositionName;		
	private String acceptStatus;
	private String shareColor;
	private String regDate;
	
	///Constructor
	public Share(){
	}		
	
	public String getShareNo() {
		return shareNo;
	}
	public void setShareNo(String shareNo) {
		this.shareNo = shareNo;
	}
	public String getRequestEmployeeNo() {
		return requestEmployeeNo;
	}
	public void setRequestEmployeeNo(String requestEmployeeNo) {
		this.requestEmployeeNo = requestEmployeeNo;
	}
	public String getRequestEmployeeName() {
		return requestEmployeeName;
	}
	public void setRequestEmployeeName(String requestEmployeeName) {
		this.requestEmployeeName = requestEmployeeName;
	}
	public String getRequestDepartmentName() {
		return requestDepartmentName;
	}
	public void setRequestDepartmentName(String requestDepartmentName) {
		this.requestDepartmentName = requestDepartmentName;
	}
	public String getRequestPostionName() {
		return requestPositionName;
	}
	public void setRequestPostionName(String requestPostionName) {
		this.requestPositionName = requestPostionName;
	}
	public String getAcceptEmployeeNo() {
		return acceptEmployeeNo;
	}
	public void setAcceptEmployeeNo(String acceptEmployeeNo) {
		this.acceptEmployeeNo = acceptEmployeeNo;
	}
	public String getAcceptStatus() {
		return acceptStatus;
	}
	public void setAcceptStatus(String acceptStatus) {
		this.acceptStatus = acceptStatus;
	}
	public String getShareColor() {
		return shareColor;
	}
	public void setShareColor(String shareColor) {
		this.shareColor = shareColor;
	}
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getRequestPositionName() {
		return requestPositionName;
	}

	public void setRequestPositionName(String requestPositionName) {
		this.requestPositionName = requestPositionName;
	}

	public String getAcceptEmployeeName() {
		return acceptEmployeeName;
	}

	public void setAcceptEmployeeName(String acceptEmployeeName) {
		this.acceptEmployeeName = acceptEmployeeName;
	}

	public String getAcceptDepartmentName() {
		return acceptDepartmentName;
	}

	public void setAcceptDepartmentName(String acceptDepartmentName) {
		this.acceptDepartmentName = acceptDepartmentName;
	}

	public String getAcceptPositionName() {
		return acceptPositionName;
	}

	public void setAcceptPositionName(String acceptPositionName) {
		this.acceptPositionName = acceptPositionName;
	}	
	
	@Override
	public String toString() {
		return "ShareVO : [shareNo] "+shareNo+" [requestEmployeeNo] "+requestEmployeeNo+" [requestEmployeeName] "+requestEmployeeName+" [requestDepartmentName] "+ requestDepartmentName
			+" [requestPositionName] "+requestPositionName+" [acceptEmployeeNo] "+acceptEmployeeNo
			+" [acceptStatus] "+acceptStatus+" [shareColor] "+shareColor+" [regDate] "+regDate
			+" [acceptEmployeeName] "+acceptEmployeeName+" [acceptDepartmentName] "+acceptDepartmentName+" [acceptPositionName] "+acceptPositionName;
	
				
	}
	
}
