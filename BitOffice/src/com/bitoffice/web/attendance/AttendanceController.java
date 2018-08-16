package com.bitoffice.web.attendance;

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
import com.bitoffice.service.domain.Attendance;
import com.bitoffice.service.attendance.AttendanceService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/attendance/*")
public class AttendanceController {
	
	///Field
	@Autowired
	@Qualifier("attendanceServiceImpl")
	private AttendanceService attendanceService;
	//setter Method 구현 않음
		
	public AttendanceController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addAttendance", method=RequestMethod.GET )
	public String addAttendance(@ModelAttribute("attendance") Attendance attendance) throws Exception{
	
		System.out.println("/attendance/addAttendance : GET");
		attendanceService.addAttendance(attendance);
		return "redirect:/attendance/listAttendance";
	}
	
	@RequestMapping( value="addAttendance", method=RequestMethod.POST )
	public String addAttendance( @ModelAttribute("attendance") Attendance attendance, Model model) throws Exception {
		

		System.out.println("/attendance/addAttendance : POST");
		//Business Logic
		attendanceService.addAttendance(attendance);
		
		return "redirect:/attendance/listAttendance";
	}
	

	@RequestMapping( value="getAttendance", method=RequestMethod.GET )
	public String getAttendance( @RequestParam("attendanceNo") String attendanceNo , Model model ) throws Exception {
		
		System.out.println("/attendance/getAttendance : GET");
		//Business Logic
		Attendance attendance = attendanceService.getAttendance(attendanceNo);
		// Model 과 View 연결
		model.addAttribute("attendance", attendance);
		
		return "forward:/attendance/getAttendance.jsp";
	}
	

	@RequestMapping( value="updateAttendance", method=RequestMethod.GET )
	public String updateAttendance( @RequestParam("attendanceNo") String attendanceNo , Model model ) throws Exception{

		System.out.println("/attendance/updateAttendance : GET");
		//Business Logic
		Attendance attendance = attendanceService.getAttendance(attendanceNo);
		
		
		// Model 과 View 연결
		model.addAttribute("attendance", attendance);
		
		return "forward:/attendance/updateAttendanceView.jsp";
	}

	@RequestMapping( value="updateAttendance", method=RequestMethod.POST )
	public String updateAttendance( @ModelAttribute("attendance") Attendance attendance , Model model , HttpSession session) throws Exception{

		System.out.println("/attendance/updateAttendance : POST");
		//Business Logic
		attendanceService.updateAttendance(attendance);
	
		return "redirect:/attendance/updateAttendanceView.jsp";
	}

	@RequestMapping( value="deleteAttendance", method=RequestMethod.GET )
	public String deleteAttendance( @ModelAttribute("attendance") Attendance attendance) throws Exception{

		System.out.println("/attendance/deleteAttendance : GET");
		//Business Logic
		attendanceService.deleteAttendance(attendance);
	
		return "redirect:/attendance/listAttendance.jsp";
	}	
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("/attendance/checkDuplication : POST");
		//Business Logic
		boolean result=attendanceService.checkDuplication(serialNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

		return "forward:/attendance/checkDuplication.jsp";
	}

	
	@RequestMapping( value="listAttendance" )
	public String listAttendance( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/attendance/listAttendance : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=attendanceService.getAttendanceList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/attendance/attendance.jsp";
	}
}