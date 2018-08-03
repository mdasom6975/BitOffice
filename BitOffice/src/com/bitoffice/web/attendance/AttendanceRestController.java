package com.bitoffice.web.attendance;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Attendance;
import com.bitoffice.service.attendance.AttendanceService;


//==> 회원관리 Controller
@Controller
@RequestMapping("/attendance/*")
public class AttendanceRestController {
	
	///Field
	@Autowired
	@Qualifier("attendanceServiceImpl")
	private AttendanceService attendanceService;
	//setter Method 구현 않음
		
	public AttendanceRestController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;	
	
	@RequestMapping( value="json/addAttendance", method=RequestMethod.GET )
	public @ResponseBody void addAttendance( @ModelAttribute("attendance") Attendance attendance ) throws Exception{
		
		System.out.println("json/attendance/addAttendance : GET");
		
		attendanceService.addAttendance(attendance);

	}

	
	@RequestMapping( value="json/addAttendance", method=RequestMethod.POST )
	public @ResponseBody void addAttendance( @ModelAttribute("attendance") Attendance attendance, Model model ) throws Exception {

		System.out.println("json/attendance/addAttendance : POST");
		//Business Logic
		attendanceService.addAttendance(attendance);

	}
	

	@RequestMapping( value="json/getAttendance/{attendanceNo}", method=RequestMethod.GET )
	public @ResponseBody Attendance getAttendance( @PathVariable String attendanceNo , Model model ) throws Exception {
		
		System.out.println("json/attendance/getAttendance : GET"+attendanceNo);
		//Business Logic
		//Attendance attendance = attendanceService.getAttendance(serialNo);
		// Model 과 View 연결
		//model.addAttribute("attendance", attendance);
		
		return attendanceService.getAttendance(attendanceNo);

	}
	

	@RequestMapping( value="json/updateAttendance", method=RequestMethod.GET )
	public @ResponseBody void updateAttendance( @ModelAttribute("attendance") Attendance attendance, Model model ) throws Exception{

		System.out.println("/attendance/updateAttendance : GET");
		//Business Logic
		attendanceService.updateAttendance(attendance);

	}

	@RequestMapping( value="json/updateAttendance", method=RequestMethod.POST )
	public @ResponseBody void updateAttendance( @ModelAttribute("attendance") Attendance attendance, Model model , HttpSession session) throws Exception{

		System.out.println("/attendance/updateAttendance : POST");
		//Business Logic
		attendanceService.updateAttendance(attendance);

	}

	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
	public @ResponseBody void checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("/attendance/checkDuplication : POST");
		//Business Logic
		boolean result=attendanceService.checkDuplication(serialNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

	}

	
	@RequestMapping( value="json/listAttendance", method=RequestMethod.GET)
	public @ResponseBody void listAttendance( @ModelAttribute("search") Search search , @ModelAttribute("attendance") Attendance attendance , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("json/attendance/listAttendance : GET / POST");
		
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


	}
}