package com.bitoffice.web.approvalEmployee;

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
import com.bitoffice.service.domain.ApprovalEmployee;
import com.bitoffice.service.approvalEmployee.ApprovalEmployeeService;



//==> 회원관리 Controller
@Controller
@RequestMapping("/approvalEmployee/*")
public class ApprovalEmployeeController {
	
	///Field
	@Autowired
	@Qualifier("approvalEmployeeServiceImpl")
	private ApprovalEmployeeService approvalEmployeeService;
	//setter Method 구현 않음
		
	public ApprovalEmployeeController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	@RequestMapping( value="addApprovalEmployeeView", method=RequestMethod.GET )
	public String addApprovalEmployee(@RequestParam("docType") String docType, @RequestParam("approvalEmployeeOrder") String approvalEmployeeOrder) throws Exception{
	
		System.out.println("/approvalEmployee/addApprovalEmployeeView : GET");		
		return "redirect:/approvalEmployee/addApprovalEmployeeView.jsp?docType="+docType+"&approvalEmployeeOrder="+approvalEmployeeOrder;
	}
	
	@RequestMapping( value="addApprovalEmployee", method=RequestMethod.POST )
	public String addApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee, Model model) throws Exception {

		System.out.println("/approvalEmployee/addApprovalEmployee : POST");
		//Business Logic
		approvalEmployeeService.addApprovalEmployee(approvalEmployee);
		
		model.addAttribute("approvalEmployee", approvalEmployee);
		
		return "redirect:/approvalEmployee/addApprovalEmployee";
	}

	@RequestMapping( value="getApprovalEmployee", method=RequestMethod.GET )
	public String getApprovalEmployee( @RequestParam("approvalEmployeeNo") String approvalEmployeeNo , Model model ) throws Exception {
		
		System.out.println("/approvalEmployee/getApprovalEmployee : GET");
		//Business Logic
		ApprovalEmployee approvalEmployee = approvalEmployeeService.getApprovalEmployee(approvalEmployeeNo);
		// Model 과 View 연결
		model.addAttribute("approvalEmployee", approvalEmployee);
		
		return "forward:/approvalEmployee/getApprovalEmployee.jsp";
	}
	

	@RequestMapping( value="updateApprovalEmployee", method=RequestMethod.GET )
	public String updateApprovalEmployee( @RequestParam("approvalEmployeeNo") String approvalEmployeeNo , Model model ) throws Exception{

		System.out.println("/approvalEmployee/updateApprovalEmployee : GET");
		//Business Logic
		ApprovalEmployee approvalEmployee = approvalEmployeeService.getApprovalEmployee(approvalEmployeeNo);
		// Model 과 View 연결
		model.addAttribute("approvalEmployee", approvalEmployee);
		
		return "forward:/approvalEmployee/updateApprovalEmployeeView.jsp";
	}

	@RequestMapping( value="updateApprovalEmployee", method=RequestMethod.POST )
	public String updateApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee , Model model , HttpSession session) throws Exception{

		System.out.println("/approvalEmployee/updateApprovalEmployee : POST");
		//Business Logic
		approvalEmployeeService.updateApprovalEmployee(approvalEmployee);
	
		return "redirect:/approvalEmployee/updateApprovalEmployeeView.jsp";
	}

	@RequestMapping( value="deleteApprovalEmployee", method=RequestMethod.GET )
	public String deleteApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee) throws Exception{

		System.out.println("/approvalEmployee/deleteApprovalEmployee : GET");
		//Business Logic
		approvalEmployeeService.deleteApprovalEmployee(approvalEmployee);
	
		return "redirect:/approvalEmployee/listApprovalEmployee.jsp";
	}	
	
	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
	public String checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("/approvalEmployee/checkDuplication : POST");
		//Business Logic
		boolean result=approvalEmployeeService.checkDuplication(serialNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

		return "forward:/approvalEmployee/checkDuplication.jsp";
	}

	
	@RequestMapping( value="listApprovalEmployee" )
	public String listApprovalEmployee( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("/approvalEmployee/listApprovalEmployee : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=approvalEmployeeService.getApprovalEmployeeList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/approvalEmployee/listApprovalEmployee.jsp";
	}
}