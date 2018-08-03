package com.bitoffice.service.position;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Position;

public interface PositionDAO {
	
	public void addPosition(Position position) throws Exception;
	
	public List<Position> getAllPosition()throws Exception;
	
	public List<Position> getPositionList(Search search) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;
	
	public Position getPosition(String positionNo) throws Exception;
	
	public void updatePosition(Position position) throws Exception;
	
	public int dbCheck(String positionName) throws Exception;
	
	public void deletePosition(String positionNo)throws Exception;

}
