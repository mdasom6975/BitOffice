package com.bitoffice.service.standardtime;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.StandardTime;

public interface StandardTimeService {
	// 회원가입
	public int addStandardTime(StandardTime standardtime) throws Exception;
	
	// 내정보확인 / 로그인
	public StandardTime getStandardTime(String standardtimeId) throws Exception;
	
	// 회원정보리스트 
	public Map<String , Object> getStandardTimeList(Search search) throws Exception;
	
	// 회원정보수정
	public int updateStandardTime(StandardTime standardtime) throws Exception;
	
	// 회원정보수정
	public void deleteStandardTime(StandardTime standardtime) throws Exception;	
	
	// 회원 ID 중복 확인
	public boolean checkDuplication(String standardtimeId) throws Exception;
}
