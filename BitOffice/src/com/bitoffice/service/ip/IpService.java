package com.bitoffice.service.ip;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Ip;

public interface IpService {
	// IP���
	public int addIp(Ip ip) throws Exception;
	
	// ��IPȮ�� / �α���
	public Ip getIp(Ip ip) throws Exception;
	
	// IP��������Ʈ 
	public Map<String , Object> getIpList(Search search) throws Exception;
	
	// IP��������
	public int updateIp(Ip ip) throws Exception;
	
	// IP��������
	public int deleteIp(Integer serialNo) throws Exception;	
	
	// IP �ߺ� Ȯ��
	public boolean checkDuplication(Ip ip) throws Exception;
}
