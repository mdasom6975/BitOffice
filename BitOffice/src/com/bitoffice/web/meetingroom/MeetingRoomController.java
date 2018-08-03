package com.bitoffice.web.meetingroom;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.meetingroom.MeetingRoomService;

@Controller
@RequestMapping("/meetingRoom/*")
public class MeetingRoomController {
	
	@Autowired
	@Qualifier("meetingRoomServiceImpl")
	private MeetingRoomService meetingRoomService;
	
	public MeetingRoomController() {
		
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="addMeetingRoom")
	public String addMeetingRoom(@ModelAttribute("meetingRoom") MeetingRoom meetingRoom) throws Exception{
		
		System.out.println("/meetingRoom/addMeetingRoom : GET");
		
		meetingRoomService.addMeetingRoom(meetingRoom);
		
		return "redirect:/meetingRoom/listMeetingRoom";
	}
	
	@RequestMapping(value="listMeetingRoom")
	public String listMeetingRoom(@ModelAttribute("search") Search search, Model model, HttpServletRequest request) throws Exception{
		
		System.out.println("/meetingRoom/listMeetingRoom : GET");
		
		
		if(search.getCurrentPage() ==0) {
			
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		Map<String, Object> map = meetingRoomService.getMeetingRoomList(search);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		String menu = "";
		menu = "listMeetingRoom";
		model.addAttribute("menu", menu);
		
		System.out.println("@@@@@@@@@@@@@@ : "+model);
			
		return "forward:/meetingRoom/meetingRoom.jsp";
		
	}
	
	@RequestMapping(value="deleteMeetingRoom", method=RequestMethod.GET)
	public String deleteMeetingRoom(@RequestParam(value="meetingRoomCode") int meetingRoomCode) throws Exception{
		
		System.out.println("/meetingRoom/deleteMeetingRoom");

		meetingRoomService.deleteMeetingRoom(meetingRoomCode);
		
		return "redirect:/meetingRoom/listMeetingRoom";
	}
	
	@RequestMapping(value="updateMeetingRoom", method=RequestMethod.GET)
	public String updateMeetingRoom(@RequestParam("mR") int mR, Model model) throws Exception{
		
		System.out.println("/meetingRoom/updateMeetingRoom : GET");
		
		MeetingRoom meetingRoom = meetingRoomService.getMeetingRoom(mR);
		
		String menu = "";
		menu = "updateMeetingRoom";
		
		model.addAttribute("menu", menu);
		
		model.addAttribute("meetingRoom", meetingRoom);
		
		return "forward:/meetingRoom/meetingRoom.jsp";
	}
	
	@RequestMapping(value="updateMeetingRoom", method=RequestMethod.POST)
	public String updateMeetingRoom(@ModelAttribute("meetingRoom") MeetingRoom meetingRoom) throws Exception{
		
		System.out.println("/meetingRoom/updateMeetingRoom : POST");
		
		meetingRoomService.updateMeetingRoom(meetingRoom);
		
		/*return "redirect:/meetingRoom/getMeetingRoom?mettingRoomName="+meetingRoom.getMettingRoomName();*/
		return "redirect:/meetingRoom/listMeetingRoom";
	}
	
	@RequestMapping(value="getMeetingRoom", method=RequestMethod.GET)
	public String getMeetingRoom(@RequestParam("mR") int mR, Model model) throws Exception{
		
		System.out.println("/meetingRoom/getMeetingRoom");
		
		MeetingRoom meetingRoom = meetingRoomService.getMeetingRoom(mR);
		
		String menu = "";
		menu = "getMeetingRoom";
		
		model.addAttribute("menu", menu);
		
		model.addAttribute("meetingRoom", meetingRoom);
		
		return "forward:/meetingRoom/meetingRoom.jsp";
	}

	
}
