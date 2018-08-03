package com.bitoffice.web.schedule;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;
import com.bitoffice.service.schedule.ScheduleService;


//==> 회원관리 Controller
@Controller
@RequestMapping("/schedule/*")
public class ScheduleController {
	
	///Field
	@Autowired
	@Qualifier("scheduleServiceImpl")
	private ScheduleService scheduleService;
	//setter Method 구현 않음
		
	public ScheduleController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addSchedule", method=RequestMethod.GET )
	public void addSchedule() throws Exception{	
		System.out.println("/schedule/addSchedule : GET");
	}
	
	@RequestMapping( value="addSchedule", method=RequestMethod.POST )
	public String addSchedule( @ModelAttribute("schedule") Schedule schedule ) throws Exception {

		System.out.println("/schedule/addSchedule : POST");
		//Business Logic
		scheduleService.addSchedule(schedule);
		
		return "redirect:/schedule/loginView.jsp";
	}
	

	@RequestMapping( value="getSchedule", method=RequestMethod.GET )
	public String getSchedule( @RequestParam("scheduleId") String scheduleId , Model model ) throws Exception {
		
		System.out.println("/schedule/getSchedule : GET");
		//Business Logic
		Schedule schedule = scheduleService.getSchedule(scheduleId);
		// Model 과 View 연결
		model.addAttribute("schedule", schedule);
		
		return "forward:/schedule/getSchedule.jsp";
	}
	

	@RequestMapping( value="updateSchedule", method=RequestMethod.GET )
	public String updateSchedule( @RequestParam("scheduleId") String scheduleId , Model model ) throws Exception{

		System.out.println("/schedule/updateSchedule : GET");
		//Business Logic
		Schedule schedule = scheduleService.getSchedule(scheduleId);
		// Model 과 View 연결
		model.addAttribute("schedule", schedule);
		
		return "forward:/schedule/updateSchedule.jsp";
	}

	@RequestMapping( value="updateSchedule", method=RequestMethod.POST )
	public String updateSchedule( @ModelAttribute("schedule") Schedule schedule , Model model , HttpSession session) throws Exception{

		System.out.println("/schedule/updateSchedule : POST");
		//Business Logic
		scheduleService.updateSchedule(schedule);
		
		String sessionId=((Schedule)session.getAttribute("schedule")).getEmployeeNo();
		if(sessionId.equals(schedule.getEmployeeNo())){
			session.setAttribute("schedule", schedule);
		}
		
		return "redirect:/schedule/getSchedule?scheduleId="+schedule.getEmployeeNo();
	}
	
	
	@RequestMapping(value = "listSchedule" , method=RequestMethod.GET)
	public String listEmployee(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {

		System.out.println("/schedule/calendar");
		
		return "forward:/schedule/listSchedule.jsp";

	}
	
	@RequestMapping(value = "schedule" , method=RequestMethod.GET)
	public String listEmployee( Model model, HttpServletRequest request)
			throws Exception {

		System.out.println("/schedule/schedule");
		
		return "forward:/schedule/schedule.jsp";

	}	
	
	
	@RequestMapping( value="login", method=RequestMethod.GET )
	public String login() throws Exception{
		
		System.out.println("/schedule/logon : GET");

		return "redirect:/schedule/loginView.jsp";
	}

}