package com.bitoffice.web.standardtime;

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
import com.bitoffice.service.domain.StandardTime;
import com.bitoffice.service.standardtime.StandardTimeService;


//==> 회원관리 Controller
@Controller
@RequestMapping("/standardtime/*")
public class StandardTimeRestController {
	
	///Field
	@Autowired
	@Qualifier("standardtimeServiceImpl")
	private StandardTimeService standardtimeService;
	//setter Method 구현 않음
		
	public StandardTimeRestController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;	
	

	@RequestMapping( value="json/addStandardTime", method=RequestMethod.POST )
	public int addStandardTime( @ModelAttribute("standardtime") StandardTime standardtime, Model model ) throws Exception {

		System.out.println("json/standardtime/addStandardTime : POST");
		//Business Logic
		int returnValue = standardtimeService.addStandardTime(standardtime);

		return returnValue;
	}
	

	@RequestMapping( value="json/getStandardTime/{serialNo}", method=RequestMethod.GET )
	public @ResponseBody  StandardTime getStandardTime( @PathVariable String serialNo , Model model ) throws Exception {
		
		System.out.println("json/standardtime/getStandardTime : GET"+serialNo);
		//Business Logic
		//StandardTime standardtime = standardtimeService.getStandardTime(serialNo);
		// Model 과 View 연결
		//model.addAttribute("standardtime", standardtime);
		
		return standardtimeService.getStandardTime(serialNo);

	}
	
	@RequestMapping( value="json/updateStandardTime", method=RequestMethod.POST )
	public int updateStandardTime( @ModelAttribute("standardtime") StandardTime standardtime , Model model , HttpSession session) throws Exception{

		System.out.println("/standardtime/updateStandardTime : POST");
		//Business Logic
		int returnValue = standardtimeService.updateStandardTime(standardtime);

		return returnValue;	

	}

	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
	public @ResponseBody  void checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("/standardtime/checkDuplication : POST");
		//Business Logic
		boolean result=standardtimeService.checkDuplication(serialNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

	}

	
	@RequestMapping( value="json/listStandardTime", method=RequestMethod.GET)
	public String listStandardTime( @ModelAttribute("search") Search search , @ModelAttribute("standardtime") StandardTime standardtime , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("json/standardtime/listStandardTime : GET / POST");
		
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
		
		return "forward:/standardtime/updateStandardTimeView.jsp";

	}
}