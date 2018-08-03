package com.bitoffice.web.ip;

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
import com.bitoffice.service.ip.IpService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/ip/*")
public class IpController {
	
	///Field
	@Autowired
	@Qualifier("ipServiceImpl")
	private IpService ipService;
	//setter Method 구현 않음
		
	public IpController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addIp", method=RequestMethod.GET )
	public String addIp(@ModelAttribute("ip") Ip ip) throws Exception{
	
		System.out.println("/ip/addIp : GET");
		ipService.addIp(ip);
		return "redirect:/ip/ip.jsp";
	}
	
	@RequestMapping( value="addIp", method=RequestMethod.POST )
	public String addIp( @ModelAttribute("ip") Ip ip, Model model) throws Exception {

		System.out.println("/ip/addIp : POST");
		//Business Logic
		ipService.addIp(ip);
		
		return "redirect:/ip/ip.jsp";
	}
	

	@RequestMapping( value="getIp", method=RequestMethod.GET )
	public String getIp( @ModelAttribute("ip") Ip ip , Model model ) throws Exception {
		
		System.out.println("/ip/getIp : GET");
		//Business Logic
		ip = ipService.getIp(ip);
		// Model 과 View 연결
		model.addAttribute("ip", ip);
		
		return "forward:/ip/ip.jsp";
	}
	

	@RequestMapping( value="updateIp", method=RequestMethod.GET )
	public String updateIp( @ModelAttribute("ip") Ip ip , Model model ) throws Exception{

		System.out.println("/ip/ip : GET");
		//Business Logic
		ipService.updateIp(ip);
		// Model 과 View 연결
		model.addAttribute("ip", ip);
		
		return "forward:/ip/ip.jsp";
	}

	@RequestMapping( value="updateIp", method=RequestMethod.POST )
	public String updateIp( @ModelAttribute("ip") Ip ip , Model model , HttpSession session) throws Exception{

		System.out.println("/ip/updateIp : POST");
		//Business Logic
		ipService.updateIp(ip);
	
		return "redirect:/ip/ip.jsp";
	}

	@RequestMapping( value="deleteIp", method=RequestMethod.GET )
	public String deleteIp( @RequestParam("serialNo") Integer serialNo) throws Exception{

		System.out.println("/ip/deleteIp : GET");
		//Business Logic
		ipService.deleteIp(serialNo);
	
		return "redirect:/ip/ip.jsp";
	}	
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @ModelAttribute("ip") Ip ip , Model model ) throws Exception{
		
		System.out.println("/ip/checkDuplication : POST");
		//Business Logic
		boolean result=ipService.checkDuplication(ip);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", ip);

		return "forward:/ip/ip.jsp";
	}

	
	@RequestMapping( value= {"updateIpView","listIp"} )
	public String listIp( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/ip/listIp : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=ipService.getIpList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/ip/ip.jsp";
	}
}