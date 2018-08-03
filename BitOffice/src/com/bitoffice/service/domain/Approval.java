package com.bitoffice.service.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Approval {
	
	private String docNo;
	private char docType;
	private char docApprovalOrder;
	private char docStatus;
	private String startDate;
	private String endDate;
	private int useDay;
	private String title;
	private String content;
	private String memo;
	private String fileName1;
	private String fileName2;
	private String fileName3;
	private Date regDate;
	private String regEmployeeNo;
	private String regEmployeeName;
	private Date modDate;
	private String modEmployeeNo;
	private String modEmployeeName;	
	private String departmentName;
	private String positionName;
	private MultipartFile[] multiFile;	
	
	public Approval() {
		
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public char getDocType() {
		return docType;
	}

	public void setDocType(char docType) {
		this.docType = docType;
	}

	public char getDocApprovalOrder() {
		return docApprovalOrder;
	}

	public void setDocApprovalOrder(char docApprovalOrder) {
		this.docApprovalOrder = docApprovalOrder;
	}

	public char getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(char docStatus) {
		this.docStatus = docStatus;
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

	public int getUseDay() {
		return useDay;
	}

	public void setUseDay(int useDay) {
		this.useDay = useDay;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public void setRegEmployeeNo(String regEmployNo) {
		this.regEmployeeNo = regEmployNo;
	}

	public String getRegEmployeeName() {
		return regEmployeeName;
	}

	public void setRegEmployeeName(String regEmployName) {
		this.regEmployeeName = regEmployName;
	}
	
	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
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

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	public String getFileName3() {
		return fileName3;
	}

	public void setFileName3(String fileName3) {
		this.fileName3 = fileName3;
	}

	public String getModEmployeeNo() {
		return modEmployeeNo;
	}

	public void setModEmployeeNo(String modEmployeeNo) {
		this.modEmployeeNo = modEmployeeNo;
	}

	public String getModEmployeeName() {
		return modEmployeeName;
	}

	public void setModEmployeeName(String modEmployeeName) {
		this.modEmployeeName = modEmployeeName;
	}
	
	public MultipartFile[] getMultiFile() {
		return multiFile;
	}

	public void setMultiFile(MultipartFile[] multiFile) {
		this.multiFile = multiFile;
	}	
	
	@Override
	public String toString() {
		return "Approval [docNo=" + docNo + ", docType=" + docType + ", docApprovalOrder=" + docApprovalOrder
				+ ", docStatus=" + docStatus + ", startDate=" + startDate + ", endDate=" + endDate + ", useDay="
				+ useDay + ", title=" + title + ", content=" + content + ", memo=" + memo + ", fileName1=" + fileName1
				+ ", fileName2=" + fileName2 + ", fileName3=" + fileName3 + ", regDate=" + regDate + ", regEmployNo="
				+ regEmployeeNo + ", regEmployName=" + regEmployeeName + ", modDate=" + modDate 
				+ ", modEmployeeNo=" + modEmployeeNo+ ", modEmployeeName=" + modEmployeeName
				+ ", departmentName=" + departmentName+", positionName=" + positionName+"]";
	}







	
}
