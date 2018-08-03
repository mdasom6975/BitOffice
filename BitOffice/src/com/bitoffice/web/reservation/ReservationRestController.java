package com.bitoffice.web.reservation;

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
import com.bitoffice.service.reservation.ReservationService;

@RestController
@RequestMapping("/meetingRoom/*")
public class ReservationRestController {

	@Autowired
	@Qualifier("reservationServiceImpl")
	private ReservationService reservationService;
	
	public ReservationRestController() {
		
		System.out.println(this.getClass());
	}
		
	@RequestMapping(value="json/testReserveMeetingRoom",  method=RequestMethod.GET)
	@ResponseBody
	public JSONObject testReserveMeetingRoom() throws Exception{
		
		System.out.println("여기는 레스트 미팅룸");
		List<MeetingRoom> list = reservationService.testReserveMeetingRoom();
		System.out.println("여기는 레스트의 리스트"+list);
		
		String menu = "";
		menu = "testReserveMeetingRoom";
		
		JSONObject jsob = new JSONObject();
		jsob.put("meetingRoom", list);
		jsob.put("menu", menu);
		System.out.println("JSOB::::::::::"+jsob);
		
		return jsob;
	}


}

