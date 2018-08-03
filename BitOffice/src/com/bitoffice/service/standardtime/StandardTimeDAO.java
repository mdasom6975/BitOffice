package com.bitoffice.service.standardtime;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.StandardTime;

public interface StandardTimeDAO {

	// INSERT
	public int addStandardTime(StandardTime standardtime) throws Exception ;

	// SELECT ONE
	public StandardTime getStandardTime(String standardtimeId) throws Exception ;

	// SELECT LIST
	public List<StandardTime> getStandardTimeList(Search search) throws Exception ;

	// UPDATE
	public int updateStandardTime(StandardTime standardtime) throws Exception ;
	
	// DELETE
	public int deleteStandardTime(StandardTime standardtime) throws Exception ;	
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}
