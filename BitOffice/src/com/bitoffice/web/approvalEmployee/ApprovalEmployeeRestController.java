package com.bitoffice.web.approvalEmployee;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import com.bitoffice.service.domain.ApprovalEmployee;
import com.bitoffice.service.domain.Share;
import com.bitoffice.service.approvalEmployee.ApprovalEmployeeService;


//==> 회원관리 Controller
@Controller
@RequestMapping("/approvalEmployee/*")
public class ApprovalEmployeeRestController {
	
	///Field
	@Autowired
	@Qualifier("approvalEmployeeServiceImpl")
	private ApprovalEmployeeService approvalEmployeeService;
	//setter Method 구현 않음
		
	public ApprovalEmployeeRestController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;	
	
	@RequestMapping( value="json/addApprovalEmployee", method=RequestMethod.GET )
	public @ResponseBody void addApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee ) throws Exception{
		
		System.out.println("json/approvalEmployee/addApprovalEmployee : GET");
		
		approvalEmployeeService.addApprovalEmployee(approvalEmployee);

	}

	
	@RequestMapping( value="json/addApprovalEmployee", method=RequestMethod.POST )
	public @ResponseBody int addApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee, Model model ) throws Exception {

		System.out.println("json/approvalEmployee/addApprovalEmployee : POST");
		//Business Logic
		int resultValue = approvalEmployeeService.addApprovalEmployee(approvalEmployee);
		return resultValue;

	}
	

	@RequestMapping( value="json/getApprovalEmployee/{approvalEmployeeNo}", method=RequestMethod.GET )
	public @ResponseBody ApprovalEmployee getApprovalEmployee( @PathVariable String approvalEmployeeNo , Model model ) throws Exception {
		
		System.out.println("json/approvalEmployee/getApprovalEmployee : GET"+approvalEmployeeNo);
		//Business Logic
		//ApprovalEmployee approvalEmployee = approvalEmployeeService.getApprovalEmployee(serialNo);
		// Model 과 View 연결
		//model.addAttribute("approvalEmployee", approvalEmployee);
		
		return approvalEmployeeService.getApprovalEmployee(approvalEmployeeNo);

	}
	

	@RequestMapping( value="json/updateApprovalEmployee", method=RequestMethod.GET )
	public @ResponseBody void updateApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee, Model model ) throws Exception{

		System.out.println("/approvalEmployee/updateApprovalEmployee : GET");
		//Business Logic
		approvalEmployeeService.updateApprovalEmployee(approvalEmployee);

	}

	@RequestMapping( value="json/updateApprovalEmployee", method=RequestMethod.POST )
	public @ResponseBody int updateApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee, Model model , HttpSession session) throws Exception{

		System.out.println("json/approvalEmployee/updateApprovalEmployee : POST");
		//Business Logic
		int resultValue = approvalEmployeeService.updateApprovalEmployee(approvalEmployee);
		return resultValue;

	}
	
	@RequestMapping( value="json/updateApprovalEmployeeStatus", method=RequestMethod.POST )
	public @ResponseBody int updateApprovalEmployeeStatus( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee, Model model , HttpSession session) throws Exception{

		System.out.println("json/approvalEmployee/updateApprovalEmployeeStatus : POST");
		//Business Logic
		int resultValue = approvalEmployeeService.updateApprovalEmployeeStatus(approvalEmployee);
		return resultValue;

	}	
	
	@RequestMapping( value="json/deleteApprovalEmployee", method=RequestMethod.POST )
	public @ResponseBody int deleteApprovalEmployee( @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee) throws Exception{

		System.out.println("json/approvalEmployee/deleteApprovalEmployee : POST");
		//Business Logic
		int resultValue = approvalEmployeeService.deleteApprovalEmployee(approvalEmployee);
	
		return resultValue;
	}		

	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
	public @ResponseBody void checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("json/approvalEmployee/checkDuplication : POST");
		//Business Logic
		boolean result=approvalEmployeeService.checkDuplication(serialNo);
		// Model 과 View 연결
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

	}

	
	@RequestMapping( value="json/listApprovalEmployee/{docNo}", method=RequestMethod.GET)
	public @ResponseBody String listApprovalEmployee( @PathVariable("docNo") String docNo , @ModelAttribute("search") Search search , @ModelAttribute("approvalEmployee") ApprovalEmployee approvalEmployee , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("json/approvalEmployee/listApprovalEmployee : GET / POST"+docNo);	

		search.setPageSize(pageSize);
		search.setSearchCondition("1");
		search.setSearchKeyword(docNo);
		search.setCurrentPage(1);
		search.setPageSize(1000);
		
		// Business logic 수행

		List<ApprovalEmployee> list= approvalEmployeeService.getApprovalEmployeeList2(search);
		
        //최종 완성될 JSONObject 선언(전체)
        JSONObject jsonObject = new JSONObject();
        //person의 JSON정보를 담을 Array 선언
        JSONArray personArray = new JSONArray();
        //person의 한명 정보가 들어갈 JSONObject 선언
        JSONObject personInfo = new JSONObject();
        
		
		for (ApprovalEmployee sampleVO : list) {
            //System.out.println("organizationSErviceImple::"+sampleVO.getId());
            
            personInfo = new JSONObject();
 
            personInfo.put("serialNo", sampleVO.getSerialNo());
            personInfo.put("docNo", sampleVO.getDocNo());
            personInfo.put("gubun", sampleVO.getGubun());
            personInfo.put("approvalOrder", sampleVO.getApprovalOrder());
            personInfo.put("status", sampleVO.getStatus());    
            if (sampleVO.getApprovalDate()==null) {
            	personInfo.put("approvalDate", sampleVO.getApprovalDate());
            }else {
            	personInfo.put("approvalDate", sampleVO.getApprovalDate().toString());
            }
            personInfo.put("signImage", sampleVO.getSignImage());
            personInfo.put("regDate", sampleVO.getRegDate().toString());
            personInfo.put("employeeNo", sampleVO.getEmployeeNo());
            personInfo.put("employeeName", sampleVO.getEmployeeName());
            personInfo.put("departmentName", sampleVO.getDepartmentName());
            personInfo.put("positionName", sampleVO.getPositionName());
            personInfo.put("memo", sampleVO.getMemo());
            personInfo.put("docEmployeeNo", sampleVO.getDocEmployeeNo());
             

            //Array에 입력
            personArray.add(personInfo);            
        }

		String jsonInfo = personArray.toString();
        
        System.out.print("ApprovalEmployee1 : jsonInfo::"+jsonInfo);
        
	
		//return jsonInfo;
		return jsonInfo;

	}
}