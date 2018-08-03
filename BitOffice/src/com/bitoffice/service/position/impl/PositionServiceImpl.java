package com.bitoffice.service.position.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Position;
import com.bitoffice.service.position.PositionDAO;
import com.bitoffice.service.position.PositionService;

//==>직급관리 서비스 구현
@Service("positionServiceImpl")
public class PositionServiceImpl implements PositionService {
	
	//Field
	@Autowired
	@Qualifier("positionDAOImpl")
	private PositionDAO positionDAO;
	
	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}
	
	

	public PositionServiceImpl() {
		System.out.println(this.getClass());
	}


	//Method
	@Override
	public void addPosition(Position position) throws Exception {
		positionDAO.addPosition(position);
		
	}



	@Override
	public Map<String, Object> getPositionList(Search search) throws Exception {
		List<Position> list = positionDAO.getPositionList(search);
		int totalCount = positionDAO.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}



	@Override
	public List<Position> getAllPosition() throws Exception {
		// TODO Auto-generated method stub
		return positionDAO.getAllPosition();
	}



	@Override
	public Position getPosition(String positionNo) throws Exception {
		// TODO Auto-generated method stub
		return positionDAO.getPosition(positionNo);
	}



	@Override
	public void updatePosition(Position position) throws Exception {
		positionDAO.updatePosition(position);
		
	}



	@Override
	public int dbCheck(String positionName) throws Exception {
		return positionDAO.dbCheck(positionName);
	}



	@Override
	public void deletePosition(String positionNo) throws Exception {
		positionDAO.deletePosition(positionNo);
		
	}

}
