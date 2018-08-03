package com.bitoffice.web.schedule;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.schedule.ScheduleService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//==> 회원관리 RestController
@RestController
@RequestMapping("/schedule/*")
public class ScheduleRestController {
	
	///Field
	@Autowired
	@Qualifier("scheduleServiceImpl")
	private ScheduleService scheduleService;
	//setter Method 구현 않음
		
	public ScheduleRestController(){
		System.out.println(this.getClass());
	}
	
	
	@RequestMapping( value="json/addSchedule", method=RequestMethod.POST )
	public @ResponseBody int addSchedule( @ModelAttribute("schedule") Schedule schedule) throws Exception {

		System.out.println("/schedule/addSchedule : POST");
		//Business Logic
		
		int returnValue = scheduleService.addSchedule(schedule);
		
		return returnValue;
	}	
	
	@RequestMapping( value="json/getSchedule/{useId}", method=RequestMethod.GET )
	public @ResponseBody Schedule getSchedule( @PathVariable String useId ) throws Exception{
		
		System.out.println("/schedule/json/getSchedule : GET");
		
		//Business Logic
		return scheduleService.getSchedule(useId);		
	}
	
	@RequestMapping( value="json/listSchedule/{employeeNo}", method=RequestMethod.GET )
	public @ResponseBody String listSchedule( @ModelAttribute("search") Search search , @PathVariable String employeeNo,  Model model , HttpServletRequest request) throws Exception{
		
		search.setSearchCondition("0");
		search.setSearchKeyword(employeeNo);
		
		System.out.println("/schedule/json/listSchedule : GET");		
		
		String JSONArray;
		
		JSONArray=scheduleService.getScheduleList(search);	
		
		return JSONArray;
	}
	
	
	
	@RequestMapping( value="json/updateSchedule", method=RequestMethod.POST )
	public int updateSchedule( @ModelAttribute("schedule") Schedule schedule ) throws Exception {

		System.out.println("/schedule/updateSchedule : POST");
		//Business Logic
		
		int returnValue = scheduleService.updateSchedule(schedule);
		
		return returnValue;
	}	

	
	@RequestMapping( value="json/deleteSchedule/{id}", method=RequestMethod.POST )
	public int deleteSchedule( @PathVariable Integer id ) throws Exception {

		System.out.println("/schedule/deleteSchedule : GET");
		//Business Logic
		
		int resultValue = scheduleService.deleteSchedule(id);
		
		return resultValue;
	}		
	


}