package com.bitoffice.web.ip;

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
import com.bitoffice.service.domain.Ip;
import com.bitoffice.service.ip.IpService;


//==> 회원관리 Controller
@Controller
@RequestMapping("/ip/*")
public class IpRestController {
	
	///Field
	@Autowired
	@Qualifier("ipServiceImpl")
	private IpService ipService;
	//setter Method 구현 않음
		
	public IpRestController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;	
	
	@RequestMapping( value="json/addIp", method=RequestMethod.POST )
	public @ResponseBody int addIp( @ModelAttribute("ip") Ip ip, Model model ) throws Exception {

		System.out.println("json/ip/addIp : POST");
		//Business Logic
		int resultValue = ipService.addIp(ip);

		return resultValue;

	}
	

	@RequestMapping( value="json/getIp", method=RequestMethod.GET )
	public @ResponseBody Ip getIp( @ModelAttribute("ip") Ip ip , Model model ) throws Exception {
		
		System.out.println("json/ip/getIp : GET"+ip);
		
		return ipService.getIp(ip);

	}

	@RequestMapping( value="json/updateIp", method=RequestMethod.POST )
	public @ResponseBody int updateIp( @ModelAttribute("ip") Ip ip , Model model , HttpSession session) throws Exception{

		System.out.println("/json/ip/updateIp : POST");
		//Business Logic

		int resultValue = ipService.updateIp(ip);
		return resultValue;		

	}
	
	@RequestMapping( value="json/deleteIp", method=RequestMethod.POST )
	public @ResponseBody int deleteIp( @ModelAttribute("ip") Ip ip ) throws Exception{

		System.out.println("json/ip/deleteIp : POST");
		//Business Logic
		
		int resultValue = ipService.deleteIp(ip.getSerialNo());
		return resultValue;			

	}		

	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.GET )
	public @ResponseBody void checkDuplication( @ModelAttribute("ip") Ip ip , Model model ) throws Exception{
		
		System.out.println("/ip/checkDuplication : POST");
		//Business Logic
		boolean result=ipService.checkDuplication(ip);
		// Model 과 View 연결
		System.out.println("result:"+result);
	}

	
	@RequestMapping( value="json/listIp", method=RequestMethod.GET)
	public @ResponseBody String listIp( @ModelAttribute("search") Search search , @ModelAttribute("ip") Ip ip , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("json/ip/listIp : GET / POST");
		
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