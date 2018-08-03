package com.bitoffice.service.meetingroom.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.meetingroom.MeetingRoomDAO;


@Repository("meetingRoomDAOImpl")
public class MeetingRoomDAOImpl implements MeetingRoomDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public MeetingRoomDAOImpl() {
		
		System.out.println(this.getClass());
	}
	
	public void addMeetingRoom(MeetingRoom meetingRoom) throws Exception{
		System.out.println("@@@@@@@@@@"+meetingRoom.toString());
		
		sqlSession.insert("MeetingRoomMapper.addMeetingRoom", meetingRoom);
	}
	
	public List<MeetingRoom> getMeetingRoomList(Search search) throws Exception{
		
		return sqlSession.selectList("MeetingRoomMapper.getMeetingRoomList", search);
	}
	
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("MeetingRoomMapper.getTotalCount", search);
	}
	
	public void deleteMeetingRoom(int meetingRoomCode) throws Exception{
		
		sqlSession.delete("MeetingRoomMapper.deleteMeetingRoom", meetingRoomCode);
	}
	
	
	public int codeCheck(int meetingRoomCode) throws Exception{
		
		return sqlSession.selectOne("MeetingRoomMapper.codeCheck", meetingRoomCode);
	}
	
	public int nameCheck(String mettingRoomName) throws Exception{
		
		return sqlSession.selectOne("MeetingRoomMapper.nameCheck", mettingRoomName);
	}
	
	public void updateMeetingRoom(MeetingRoom meetingRoom) throws Exception{
		
		sqlSession.update("MeetingRoomMapper.updateMeetingRoom", meetingRoom);
		System.out.println("다오 임플"+meetingRoom);
	}
	
	public MeetingRoom getMeetingRoom(int mR) throws Exception{
		
		return sqlSession.selectOne("MeetingRoomMapper.getMeetingRoom", mR);
	}
	
	public List<MeetingRoom> getReserveMeetingRoom() throws Exception{
		
		return sqlSession.selectList("MeetingRoomMapper.getReserveMeetingRoom");
	}

}
