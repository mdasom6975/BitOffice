package com.bitoffice.service.domain;

import java.sql.Date;

public class ApprovalEmployee {
	
	//field
	private int serialNo;
	private String docNo;
	private char gubun;
	private String approvalOrder;	
	private char status;
	private Date approvalDate;
	private String signImage;
	private Date regDate;
	private String employeeNo;	
	private String employeeName;
	private String departmentName;
	private String positionName;
	private String memo;
	private String docEmployeeNo;

	///Constructor
	public ApprovalEmployee() {
		
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public char getGubun() {
		return gubun;
	}

	public void setGubun(char gubun) {
		this.gubun = gubun;
	}

	public String getApprovalOrder() {
		return approvalOrder;
	}

	public void setApprovalOrder(String approvalOrder) {
		this.approvalOrder = approvalOrder;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getSignImage() {
		return signImage;
	}

	public void setSignImage(String signImage) {
		this.signImage = signImage;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}	

	public String getDocEmployeeNo() {
		return docEmployeeNo;
	}

	public void setDocEmployeeNo(String docEmployeeNo) {
		this.docEmployeeNo = docEmployeeNo;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}	
	
	@Override
	public String toString() {
		return "Approval [serialNo=" + serialNo + ", docNo=" + docNo + ", gubun=" + gubun
				+ ", approvalOrder=" + approvalOrder + ", status=" + status + ", approvalDate=" + approvalDate + ", signImage="
				+ signImage+ ", regDate=" + regDate + ", employeeNo=" + employeeNo + ", employeeName=" + employeeName
				+ ", departmentName=" + departmentName	+ ", positionName=" + positionName+ ", memo=" + memo+ ", docEmployeeNo=" + docEmployeeNo+"]";
	}

	
}
