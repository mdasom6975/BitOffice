package com.bitoffice.web.meetingroom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.meetingroom.MeetingRoomDAO;
import com.bitoffice.service.meetingroom.MeetingRoomService;

@RestController
@RequestMapping("/meetingRoom/*")
public class MeetingRoomRestController {

	@Autowired
	@Qualifier("meetingRoomServiceImpl")
	private MeetingRoomService meetingRoomService;
	
	public MeetingRoomRestController() {
		
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="json/codeCheck")
	@ResponseBody
	public Map<Object, Object> codeCheck(@RequestParam (value="meetingRoomCode") int meetingRoomCode) throws Exception{
		
		System.out.println("/meetingRoom/json/codeCheck");
		
		int count=0;
		Map<Object, Object> map = new HashMap<Object,Object>();
		
		count = meetingRoomService.codeCheck(meetingRoomCode);
		map.put("count", count);
		
		return map;
	}
	
	@RequestMapping(value="json/nameCheck")
	@ResponseBody
	public Map<Object, Object> nameCheck(@RequestParam (value="mettingRoomName") String mettingRoomName) throws Exception{
		
		System.out.println("/meetingRoom/json/nameCheck");
		
		int count=0;
		Map<Object, Object> map = new HashMap<Object,Object>();
		
		count = meetingRoomService.nameCheck(mettingRoomName);
		map.put("count", count);
		
		return map;
	}
	
	@RequestMapping(value="json/getReserveMeetingRoom",  method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getReserveMeetingRoom() throws Exception{
		
		System.out.println("여기는 레스트 미팅룸");
		List<MeetingRoom> list = meetingRoomService.getReserveMeetingRoom();
		System.out.println("여기는 레스트의 리스트"+list);
		
		String menu = "";
		menu = "getReserveMeetingRoom";
		
		JSONObject jsob = new JSONObject();
		jsob.put("meetingRoom", list);
		jsob.put("menu", menu);
		System.out.println("JSOB::::::::::"+jsob);
		
		return jsob;
	}


}

