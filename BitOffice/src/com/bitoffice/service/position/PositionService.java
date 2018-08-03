package com.bitoffice.service.position;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Position;

public interface PositionService {
	
	public void addPosition(Position position) throws Exception;
	
	public Position getPosition(String positionNo) throws Exception;
	
	public void updatePosition(Position position)throws Exception;
	
	public List<Position> getAllPosition() throws Exception;
	
	public Map<String, Object> getPositionList(Search search) throws Exception; 
	
	public int dbCheck(String positionName) throws Exception;
	
	public void deletePosition(String positionNo) throws Exception;
	

}
