package com.bitoffice.service.reservation;

import java.util.Date;
import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.domain.Reservation;

public interface ReservationDAO {
	
	//����
	public void addReservation(Reservation reservation) throws Exception;
	
	//���� ��Ȳ
	public List<Reservation> getReservationList(Search search) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;
	
	public List<Reservation> myReservation(Search search, String employeeNo) throws Exception;
	
	public int myTotalCount(Search search, String employeeNo) throws Exception;
	
	//���� ����
	public void updateReservation(Reservation reservation) throws Exception;
	
	public Reservation getReservation(int reNum) throws Exception;
	
	//���� ���
	public void cancelReservation(int reNum) throws Exception;
	
	public List<MeetingRoom> testReserveMeetingRoom() throws Exception;
	
	public void autoDelete(Date reserveDate) throws Exception;
}
