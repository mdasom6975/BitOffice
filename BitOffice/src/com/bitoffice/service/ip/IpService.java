package com.bitoffice.service.ip;

import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Ip;

public interface IpService {
	// IP등록
	public int addIp(Ip ip) throws Exception;
	
	// 내IP확인 / 로그인
	public Ip getIp(Ip ip) throws Exception;
	
	// IP정보리스트 
	public Map<String , Object> getIpList(Search search) throws Exception;
	
	// IP정보수정
	public int updateIp(Ip ip) throws Exception;
	
	// IP정보삭제
	public int deleteIp(Integer serialNo) throws Exception;	
	
	// IP 중복 확인
	public boolean checkDuplication(Ip ip) throws Exception;
}
