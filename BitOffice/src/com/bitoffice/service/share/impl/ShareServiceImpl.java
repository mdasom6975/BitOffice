package com.bitoffice.service.share.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Share;
import com.bitoffice.service.share.ShareService;
import com.bitoffice.service.share.ShareDAO;


//==> 회원관리 서비스 구현
@Service("shareServiceImpl")
public class ShareServiceImpl implements ShareService{
	
	///Field
	@Autowired
	@Qualifier("shareDAOImpl")
	private ShareDAO shareDao;
	public void setShareDao(ShareDAO shareDao) {
		this.shareDao = shareDao;
	}
	
	///Constructor
	public ShareServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addShare(Share share) throws Exception {
		shareDao.addShare(share);
	}

	public Share getShare(Share share) throws Exception {
		return shareDao.getShare(share);
	}

	public Map<String , Object > getShareList(Search search) throws Exception {
		List<Share> list= shareDao.getShareList(search);
		int totalCount = shareDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	public List<Share> getShareList2(Search search) throws Exception {
		List<Share> list= shareDao.getShareList(search);
		
		return list;
	}	
	
	

	public void updateShare(Share share) throws Exception {
		shareDao.updateShare(share);
	}
	
	public void deleteShare(String shareNo) throws Exception {
		shareDao.deleteShare(shareNo);
	}	
	
	public boolean checkDuplication(Share share) throws Exception {
		boolean result=true;
		share=shareDao.getShare(share);
		
		System.out.println("share:"+share);
		
		if(share != null) {
			result=false;
		}
		return result;
	}	

}