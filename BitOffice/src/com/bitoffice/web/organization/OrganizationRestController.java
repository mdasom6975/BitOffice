package com.bitoffice.web.organization;

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

import com.bitoffice.service.organization.OrganizationService;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;


//==> 회원관리 RestController
@RestController
@RequestMapping("/organization/*")
public class OrganizationRestController {
	
	///Field
	@Autowired
	@Qualifier("organizationServiceImpl")
	private OrganizationService organizationService;
	//setter Method 구현 않음
		
	public OrganizationRestController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="json/getOrganization/{organizationId}", method=RequestMethod.GET )
	public @ResponseBody Organization getOrganization( @PathVariable String organizationId ) throws Exception{
		
		System.out.println("/organization/json/getOrganization : GET");
		
		//Business Logic
		return organizationService.getOrganization(organizationId);
	}
	
	@RequestMapping( value="json/listOrganization", method=RequestMethod.POST )
	public @ResponseBody String listOrganization( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/organization/json/listOrganization : POST");		
		
		String JSONArray;
		
		JSONArray=organizationService.getOrganizationList(search);

		return JSONArray;
	}	

}