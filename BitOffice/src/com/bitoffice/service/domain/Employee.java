package com.bitoffice.service.domain;

import java.sql.Date;

public class Employee {

	private String departmentNo;
	private String positionNo;
	private String employeeNo;
	private String employeeName;
	private String password;
	private Date hireDate;
	private Date birthDate;
	private Date endDate;
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	private String extension;
	private String email;
	private String address;
	private int annualLeave;
	private int notUse;
	private String role;
	private String signImage;
	private String profileImage;
	private String logCode;
	private String rankCode;


	// ==> 부서와 직급 Join을 위한 선언
	private String departmentName;
	private String positionName;
	
	//==> 전자결재 Join을 위한 선언
	private String docType;
	private String docStatus;
	private String startDate;
	private String leaveEndDate;
	private String useDay;
	private String title;

	public Employee() {

	}
	
	



	public int getNotUse() {
		return notUse;
	}





	public void setNotUse(int notUse) {
		this.notUse = notUse;
	}





	public String getDocType() {
		return docType;
	}





	public void setDocType(String docType) {
		this.docType = docType;
	}





	public String getDocStatus() {
		return docStatus;
	}





	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}





	public String getStartDate() {
		return startDate;
	}





	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}





	public String getLeaveEndDate() {
		return leaveEndDate;
	}





	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}





	public String getUseDay() {
		return useDay;
	}





	public void setUseDay(String useDay) {
		this.useDay = useDay;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getRankCode() {
		return rankCode;
	}



	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
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



	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;

		if (phone != null && phone.length() != 0) {
			phone1 = phone.split("-")[0];
			phone2 = phone.split("-")[1];
			phone3 = phone.split("-")[2];
		}
	}
	
	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSignImage() {
		return signImage;
	}

	public void setSignImage(String signImage) {
		this.signImage = signImage;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getLogCode() {
		return logCode;
	}

	public void setLogCode(String logCode) {
		this.logCode = logCode;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(String positionNo) {
		this.positionNo = positionNo;
	}





	@Override
	public String toString() {
		return "Employee [departmentNo=" + departmentNo + ", positionNo=" + positionNo + ", employeeNo=" + employeeNo
				+ ", employeeName=" + employeeName + ", password=" + password + ", hireDate=" + hireDate
				+ ", birthDate=" + birthDate + ", phone=" + phone + ", extension=" + extension + ", email=" + email
				+ ", address=" + address + ", annualLeave=" + annualLeave + ", role=" + role + ", signImage="
				+ signImage + ", profileImage=" + profileImage + ", logCode=" + logCode + ", departmentName="
				+ departmentName + ", positionName=" + positionName + "]";
	}







}
