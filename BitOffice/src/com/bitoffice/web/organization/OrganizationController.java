package com.bitoffice.web.organization;

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

import com.bitoffice.service.organization.OrganizationService;
import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;


//==> 회원관리 Controller
@Controller
@RequestMapping("/organization/*")
public class OrganizationController {
	
	///Field
	@Autowired
	@Qualifier("organizationServiceImpl")
	private OrganizationService organizationService;
	//setter Method 구현 않음
		
	public OrganizationController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addOrganization", method=RequestMethod.GET )
	public String addOrganization() throws Exception{
	
		System.out.println("/organization/addOrganization : GET");
		
		return "redirect:/organization/addOrganizationView.jsp";
	}
	
	@RequestMapping( value="addOrganization", method=RequestMethod.POST )
	public String addOrganization( @ModelAttribute("organization") Organization organization ) throws Exception {

		System.out.println("/organization/addOrganization : POST");
		//Business Logic
		organizationService.addOrganization(organization);
		
		return "redirect:/organization/loginView.jsp";
	}
	

	@RequestMapping( value="getOrganization", method=RequestMethod.GET )
	public String getOrganization( @RequestParam("organizationId") String organizationId , Model model ) throws Exception {
		
		System.out.println("/organization/getOrganization : GET");
		//Business Logic
		Organization organization = organizationService.getOrganization(organizationId);
		// Model 과 View 연결
		model.addAttribute("organization", organization);
		
		return "forward:/organization/getOrganization.jsp";
	}
	

	@RequestMapping( value="updateOrganization", method=RequestMethod.GET )
	public String updateOrganization( @RequestParam("organizationId") String organizationId , Model model ) throws Exception{

		System.out.println("/organization/updateOrganization : GET");
		//Business Logic
		Organization organization = organizationService.getOrganization(organizationId);
		// Model 과 View 연결
		model.addAttribute("organization", organization);
		
		return "forward:/organization/updateOrganization.jsp";
	}
	
	@RequestMapping( value="login", method=RequestMethod.GET )
	public String login() throws Exception{
		
		System.out.println("/organization/logon : GET");

		return "redirect:/organization/loginView.jsp";
	}
	
	@RequestMapping( value="logout", method=RequestMethod.GET )
	public String logout(HttpSession session ) throws Exception{
		
		System.out.println("/organization/logout : POST");
		
		session.invalidate();
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @RequestParam("organizationId") String organizationId , Model model ) throws Exception{
		
		System.out.println("/organization/checkDuplication : POST");
		//Business Logic
		boolean result=organizationService.checkDuplication(organizationId);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("organizationId", organizationId);

		return "forward:/organization/checkDuplication.jsp";
	}

	
	@RequestMapping( value="listOrganization" )
	public String listOrganization( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/organization/listOrganization : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		String organization = organizationService.getOrganizationList(search);

		// Model 과 View 연결
		model.addAttribute("search", search);
		
		return "forward:/organization/listOrganization.jsp";
	}
}