package com.bitoffice.service.ip.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Ip;
import com.bitoffice.service.ip.IpService;
import com.bitoffice.service.ip.IpDAO;


//==> 회원관리 서비스 구현
@Service("ipServiceImpl")
public class IpServiceImpl implements IpService{
	
	///Field
	@Autowired
	@Qualifier("ipDAOImpl")
	private IpDAO ipDao;
	public void setIpDao(IpDAO ipDao) {
		this.ipDao = ipDao;
	}
	
	///Constructor
	public IpServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addIp(Ip ip) throws Exception {
		int resultValue =  ipDao.addIp(ip);

		return resultValue;
	}

	public Ip getIp(Ip ip) throws Exception {
		return ipDao.getIp(ip);
	}

	public Map<String , Object > getIpList(Search search) throws Exception {
		List<Ip> list= ipDao.getIpList(search);
		int totalCount = ipDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public int updateIp(Ip ip) throws Exception {

		int resultValue =  ipDao.updateIp(ip);
		return resultValue;		
	}
	
	public int deleteIp(Integer serialNo) throws Exception {
		
		int resultValue =  ipDao.deleteIp(serialNo);
		return resultValue;		
	}	

	public boolean checkDuplication(Ip ip) throws Exception {
		boolean result=true;
		ip=ipDao.getIp(ip);
		
		System.out.println("ip:"+ip);
		
		if(ip != null) {
			result=false;
		}
		return result;
	}
}