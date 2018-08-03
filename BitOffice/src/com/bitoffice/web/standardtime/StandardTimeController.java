package com.bitoffice.web.standardtime;

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
import com.bitoffice.service.domain.Ip;
import com.bitoffice.service.domain.StandardTime;
import com.bitoffice.service.standardtime.StandardTimeService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/standardtime/*")
public class StandardTimeController {
	
	///Field
	@Autowired
	@Qualifier("standardtimeServiceImpl")
	private StandardTimeService standardtimeService;
	//setter Method 구현 않음
		
	public StandardTimeController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addStandardTime", method=RequestMethod.GET )
	public String addStandardTime(@ModelAttribute("standardtime") StandardTime standardtime) throws Exception{
	
		System.out.println("/standardtime/addStandardTime : GET");
		standardtimeService.addStandardTime(standardtime);
		return "redirect:/standardtime/standardTime.jsp";
	}
	
	@RequestMapping( value="addStandardTime", method=RequestMethod.POST )
	public String addStandardTime( @ModelAttribute("standardtime") StandardTime standardtime, Model model) throws Exception {

		System.out.println("/standardtime/addStandardTime : POST");
		//Business Logic
		standardtimeService.addStandardTime(standardtime);		
		
		return "redirect:/standardtime/standardTime.jsp";
	}
	

	@RequestMapping( value="getStandardTime")
	public String getStandardTime( @RequestParam(value = "serialNo" , required=false) String serialNo , Model model ) throws Exception {
		
		System.out.println("/standardtime/getStandardTime : GET/POST");
		//Business Logic
		StandardTime standardtime = standardtimeService.getStandardTime(serialNo);
		// Model 과 View 연결
		model.addAttribute("standardtime", standardtime);
		
		return "forward:/standardtime/standardTime.jsp";
	}
	
	@RequestMapping( value="updateStandardTime", method=RequestMethod.POST )
	public String updateStandardTime( @ModelAttribute("standardtime") StandardTime standardtime , Model model , HttpSession session) throws Exception{

		System.out.println("/standardtime/updateStandardTime : POST");
		//Business Logic
	
		standardtimeService.updateStandardTime(standardtime);
		// Model 과 View 연결
		model.addAttribute("standardtime", standardtime);
		
		return "forward:/standardtime/updateStandardTimeView";
	}

	@RequestMapping( value="deleteStandardTime", method=RequestMethod.GET )
	public String deleteStandardTime( @ModelAttribute("standardtime") StandardTime standardtime) throws Exception{

		System.out.println("/standardtime/deleteStandardTime : GET");
		//Business Logic
		standardtimeService.deleteStandardTime(standardtime);
	
		return "redirect:/standardtime/standardTime.jsp";
	}	
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @RequestParam("standardtimeNo") String standardtimeNo , Model model ) throws Exception{
		
		System.out.println("/standardtime/checkDuplication : POST");
		//Business Logic
		boolean result=standardtimeService.checkDuplication(standardtimeNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("standardtimeNo", standardtimeNo);

		return "forward:/standardtime/standardTime.jsp";
	}

	
	@RequestMapping( value= {"listStandardTime", "updateStandardTimeView"} )
	public String listStandardTime( @ModelAttribute("search") Search search , @ModelAttribute("standardtime") StandardTime standardtime , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/standardtime/listStandardTime : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=standardtimeService.getStandardTimeList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		
		return "forward:/standardtime/standardTime.jsp";
	}
}