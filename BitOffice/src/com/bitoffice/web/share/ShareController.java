package com.bitoffice.web.share;

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
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.domain.Share;
import com.bitoffice.service.share.ShareService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/share/*")
public class ShareController {
	
	///Field
	@Autowired
	@Qualifier("shareServiceImpl")
	private ShareService shareService;
	//setter Method 구현 않음
		
	public ShareController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addShare", method=RequestMethod.GET )
	public String addShare(@ModelAttribute("share") Share share) throws Exception{
	
		System.out.println("/share/addShare : GET");
		shareService.addShare(share);
		return "redirect:/share/share.jsp";
	}
	
	@RequestMapping( value="addShare", method=RequestMethod.POST )
	public String addShare( @ModelAttribute("share") Share share, Model model) throws Exception {

		System.out.println("/share/addShare : POST");
		//Business Logic
		shareService.addShare(share);
		
		return "redirect:/share/share.jsp";
	}
	

	@RequestMapping( value="getShare", method=RequestMethod.GET )
	public String getShare( @ModelAttribute("share") Share share , Model model ) throws Exception {
		
		System.out.println("/share/getShare : GET");
		//Business Logic
		share = shareService.getShare(share);
		// Model 과 View 연결
		model.addAttribute("share", share);
		
		return "forward:/share/share.jsp";
	}
	

	@RequestMapping( value="updateShare", method=RequestMethod.GET )
	public String updateShare( @ModelAttribute("share") Share share , Model model ) throws Exception{

		System.out.println("/share/updateShare : GET");
		//Business Logic
		shareService.updateShare(share);
		// Model 과 View 연결
		model.addAttribute("share", share);
		
		return "forward:/share/share.jsp";
	}

	@RequestMapping( value="updateShare", method=RequestMethod.POST )
	public String updateShare( @ModelAttribute("share") Share share , Model model , HttpSession session) throws Exception{

		System.out.println("/share/updateShare : POST");
		//Business Logic
		shareService.updateShare(share);
	
		return "redirect:/share/share.jsp";
	}

	@RequestMapping( value="deleteShare", method=RequestMethod.GET )
	public String deleteShare( @RequestParam("shareNo") String shareNo) throws Exception{

		System.out.println("/share/deleteShare : GET");
		//Business Logic
		shareService.deleteShare(shareNo);
	
		return "redirect:/share/share.jsp";
	}	
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @ModelAttribute("share") Share share , Model model ) throws Exception{
		
		System.out.println("/share/checkDuplication : POST");
		//Business Logic
		boolean result=shareService.checkDuplication(share);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", share);

		return "forward:/share/share.jsp";
	}

	
	@RequestMapping( value= {"updateShareView","listShare","index"} )
	public String listShare( @ModelAttribute("search") Search search , Model model , HttpSession session, HttpServletRequest request) throws Exception{
		
		System.out.println("/share/listShare : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);		
		
		//세션 임직원번호 가져오기
		//Employee employee = (Employee)session.getAttribute("employee");
		
		//System.out.println(employee.getEmployeeNo()+"=hello="+session.getAttribute("employee"));

		// Business logic 수행
		Map<String , Object> map=shareService.getShareList(search);	
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/share/share.jsp";
	}
}