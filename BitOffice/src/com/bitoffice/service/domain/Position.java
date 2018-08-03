package com.bitoffice.service.domain;

public class Position {
	
	private String positionNo;
	private String positionName;
	private String rankCode;
	
	public Position() {
		
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

	public String getRankCode() {
		return rankCode;
	}

	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}

	@Override
	public String toString() {
		return "Position [positionNo=" + positionNo + ", positionName=" + positionName + ", rankCode=" + rankCode + "]";
	}
	
}
