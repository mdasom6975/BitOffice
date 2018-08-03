package com.bitoffice.web.position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitoffice.service.domain.Department;
import com.bitoffice.service.domain.Position;
import com.bitoffice.service.position.PositionService;

//==>직급관리 RestController
@RestController
@RequestMapping("/position/*")
public class PositionRestController {
	
	//Field
	@Autowired
	@Qualifier("positionServiceImpl")
	private PositionService positionService;
	
	public PositionRestController() {
		System.out.println(this.getClass());
	}
	
/*	@RequestMapping(value="json/dbCheck")
	@ResponseBody
	public Map<Object, Object> dbCheck(@RequestParam(value="positionName") String positionName) throws Exception{
System.out.println("position/json/dbCheck");
		
		int count=0;
		Map<Object,Object> map= new HashMap<Object,Object>();
		//Business Logic
		count=positionService.dbCheck(positionName);
		map.put("count", count);
		System.out.println(count);
		
		return map;
		
	}*/
	
	@RequestMapping(value="json/getAllPosition", method=RequestMethod.GET)
	public JSONObject getAllPosition() throws Exception{
		
		List<Position>list = positionService.getAllPosition();
		
		JSONObject jo = new JSONObject();
		jo.put("position", list);
	
		
		return jo;

		
	}

}
