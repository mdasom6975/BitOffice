package com.bitoffice.service.domain;

import java.sql.Date;


//==>ȸ�������� �𵨸�(�߻�ȭ/ĸ��ȭ)�� Bean
public class Organization {
	   
	///Field
	private String id;
	private String parent;
	private String text;

	///Constructor
	public Organization(){
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "OrganizationVO : [id] "+id+" [parent] "+parent+" [text] "+text;
	}
	

}