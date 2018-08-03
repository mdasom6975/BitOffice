package com.bitoffice.service.share;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Share;

public interface ShareDAO {

	// INSERT
	public void addShare(Share share) throws Exception ;

	// SELECT ONE
	public Share getShare(Share share) throws Exception ;

	// SELECT LIST
	public List<Share> getShareList(Search search) throws Exception ;
	
	// SELECT LIST2
	public List<Share> getShareList2(Search search) throws Exception ;
	
	// UPDATE
	public void updateShare(Share share) throws Exception ;
	
	// DELETE
	public void deleteShare(String shareNo) throws Exception ;	
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}
