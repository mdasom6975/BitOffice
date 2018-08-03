package com.bitoffice.service.share;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Share;

public interface ShareService {
	// 공유가입
	public void addShare(Share share) throws Exception;
	
	// 내정보확인 / 로그인
	public Share getShare(Share share) throws Exception;
	
	// 공유정보리스트 
	public Map<String , Object> getShareList(Search search) throws Exception;

	// 공유정보리스트 
	public List<Share> getShareList2(Search search) throws Exception;	
	// 공유정보수정
	public void updateShare(Share share) throws Exception;
	
	// 공유정보수정
	public void deleteShare(String shareNo) throws Exception;	
	
	// 공유 ID 중복 확인
	public boolean checkDuplication(Share share) throws Exception;
}
