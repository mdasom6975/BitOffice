package com.bitoffice.service.share;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Share;

public interface ShareService {
	// ��������
	public void addShare(Share share) throws Exception;
	
	// ������Ȯ�� / �α���
	public Share getShare(Share share) throws Exception;
	
	// ������������Ʈ 
	public Map<String , Object> getShareList(Search search) throws Exception;

	// ������������Ʈ 
	public List<Share> getShareList2(Search search) throws Exception;	
	// ������������
	public void updateShare(Share share) throws Exception;
	
	// ������������
	public void deleteShare(String shareNo) throws Exception;	
	
	// ���� ID �ߺ� Ȯ��
	public boolean checkDuplication(Share share) throws Exception;
}
