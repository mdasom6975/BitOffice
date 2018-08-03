package com.bitoffice.web.approval;

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
import com.bitoffice.service.domain.Approval;
import com.bitoffice.service.approval.ApprovalService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/approval/*")
public class ApprovalController {
	
	///Field
	@Autowired
	@Qualifier("approvalServiceImpl")
	private ApprovalService approvalService;
	//setter Method 구현 않음
		
	public ApprovalController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
/*	@RequestMapping( value="addApprovalView", method=RequestMethod.GET )
	public String addApproval(@RequestParam("docType") String docType, @RequestParam("approvalOrder") String approvalOrder) throws Exception{
	
		System.out.println("/approval/addApprovalView : GET");		
		return "redirect:/approval/addApprovalView.jsp?docType="+docType+"&approvalOrder="+approvalOrder;
	}*/
	
	@RequestMapping( value="addApprovalView", method=RequestMethod.POST )
	public String addApproval( Model model, @RequestParam("docType") String docType, @RequestParam("approvalOrder") String approvalOrder) throws Exception{
	
		System.out.println("/approval/addApprovalView : POST");	
		
		String menu="";
		menu ="addApprovalView";		
		
		model.addAttribute("menu",menu);		
		model.addAttribute("docType", docType);
		model.addAttribute("approvalOrder", approvalOrder);
		return "forward:/approval/approval.jsp";
	}	
	
	@RequestMapping( value="addApproval", method=RequestMethod.POST )
	public String addApproval( @RequestParam("approvalNo") String approvalNo, Model model) throws Exception {

		System.out.println("/approval/addApproval : POST");
		//Business Logic
		Approval approval = approvalService.getApproval(approvalNo);
		
		String menu="";
		menu ="updateApproval";
		
		model.addAttribute("menu",menu);		
		model.addAttribute("approval", approval);
		
		return "forward:/approval/approval.jsp";
	}

	@RequestMapping( value="getApproval", method=RequestMethod.GET )
	public String getApproval( @RequestParam("approvalNo") String approvalNo , Model model ) throws Exception {
		
		System.out.println("/approval/getApproval : GET");
		//Business Logic
		Approval approval = approvalService.getApproval(approvalNo);
		
		String menu="";
		menu ="getApproval";
		
		model.addAttribute("menu",menu);		
		// Model 과 View 연결
		model.addAttribute("approval", approval);
		
		return "forward:/approval/approval.jsp";
	}
	

	@RequestMapping( value="updateApproval", method=RequestMethod.GET )
	public String updateApproval( @RequestParam("approvalNo") String approvalNo , Model model ) throws Exception{

		System.out.println("/approval/updateApproval : GET");
		//Business Logic
		Approval approval = approvalService.getApproval(approvalNo);
		// Model 과 View 연결
		model.addAttribute("approval", approval);
		
		return "forward:/approval/updateApprovalView.jsp";
	}

	@RequestMapping( value="updateApproval", method=RequestMethod.POST )
	public String updateApproval( @ModelAttribute("approval") Approval approval , Model model , HttpSession session) throws Exception{

		System.out.println("/approval/updateApproval : POST");
		//Business Logic
		approvalService.updateApproval(approval);
	
		//Business Logic
		approval = approvalService.getApproval(approval.getDocNo());
		
		// Model 과 View 연결
		model.addAttribute("approval", approval);
		
		return "forward:/approval/getApproval.jsp";
	}

	@RequestMapping( value="deleteApproval", method=RequestMethod.GET )
	public String deleteApproval( @ModelAttribute("approval") Approval approval) throws Exception{

		System.out.println("/approval/deleteApproval : GET");
		//Business Logic
		approvalService.deleteApproval(approval);
	
		return "redirect:/approval/listApproval.jsp";
	}	
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("/approval/checkDuplication : POST");
		//Business Logic
		boolean result=approvalService.checkDuplication(serialNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

		return "forward:/approval/checkDuplication.jsp";
	}

	
	@RequestMapping( value="listApproval" )
	public String listApproval( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/approval/listApproval : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=approvalService.getApprovalList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);

		String menu="";
		menu ="listApproval";
		
		// Model 과 View 연결
		model.addAttribute("menu",menu);		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/approval/approval.jsp";
	}
}