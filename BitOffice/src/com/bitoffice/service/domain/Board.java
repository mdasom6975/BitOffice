package com.bitoffice.service.domain;

import java.sql.Date;

public class Board {

	private int boardNo;
	private String boardTitle;
	private String employeeNo;
	private String employeeName;
	private Date boardDate;
	private String boardContent;
	private int boardAvailable;
	private String file;
	private int boardCount;
	
	public Board() {
		
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
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

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardAvailable() {
		return boardAvailable;
	}

	public void setBoardAvailable(int boardAvailable) {
		this.boardAvailable = boardAvailable;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", employeeNo=" + employeeNo
				+ ", employeeName=" + employeeName + ", boardDate=" + boardDate + ", boardContent=" + boardContent
				+ ", boardAvailable=" + boardAvailable + ", file=" + file + ", boardCount=" + boardCount + "]";
	}



}
