package com.bitoffice.service.ip;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Ip;

public interface IpDAO {

	// INSERT
	public int addIp(Ip ip) throws Exception ;

	// SELECT ONE
	public Ip getIp(Ip ip) throws Exception ;

	// SELECT LIST
	public List<Ip> getIpList(Search search) throws Exception ;

	// UPDATE
	public int updateIp(Ip ip) throws Exception ;
	
	// DELETE
	public int deleteIp(Integer serialNo) throws Exception ;	
	
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception ;
	
}
