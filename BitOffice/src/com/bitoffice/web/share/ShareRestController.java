package com.bitoffice.web.share;

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
import com.bitoffice.service.domain.Organization;
import com.bitoffice.service.domain.Schedule;
import com.bitoffice.service.domain.Share;
import com.bitoffice.service.share.ShareService;


//==> 회원관리 Controller
@Controller
@RequestMapping("/share/*")
public class ShareRestController {
	
	///Field
	@Autowired
	@Qualifier("shareServiceImpl")
	private ShareService shareService;
	//setter Method 구현 않음
		
	public ShareRestController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;	
	
	@RequestMapping( value="json/addShare", method=RequestMethod.GET )
	public @ResponseBody void addShare( @ModelAttribute("share") Share share ) throws Exception{
		
		System.out.println("json/share/addShare : GET");
		
		shareService.addShare(share);

	}

	
	@RequestMapping( value="json/addShare", method=RequestMethod.POST )
	public @ResponseBody void addShare( @ModelAttribute("share") Share share, Model model ) throws Exception {

		System.out.println("json/share/addShare : POST");
		//Business Logic
		shareService.addShare(share);

	}
	

	@RequestMapping( value="json/getShare", method=RequestMethod.GET )
	public @ResponseBody Share getShare( @ModelAttribute("share") Share share , Model model ) throws Exception {
		
		System.out.println("json/share/getShare : GET"+share);
		
		return shareService.getShare(share);

	}
	
	@RequestMapping( value="json/updateShare", method=RequestMethod.POST )
	public @ResponseBody void updateShare( @ModelAttribute("share") Share share , Model model , HttpSession session) throws Exception{

		System.out.println("/json/share/updateShare : POST");
		//Business Logic
		shareService.updateShare(share);

	}
	
	@RequestMapping( value="json/deleteShare/{shareNo}", method=RequestMethod.GET )
	public @ResponseBody void deleteShare( @PathVariable String shareNo) throws Exception{

		System.out.println("json/share/deleteShare : GET:"+shareNo);
		//Business Logic
		shareService.deleteShare(shareNo);

	}		

	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.GET )
	public @ResponseBody void checkDuplication( @ModelAttribute("share") Share share , Model model ) throws Exception{
		
		System.out.println("/share/checkDuplication : GET");
		//Business Logic
		boolean result=shareService.checkDuplication(share);
		// Model 과 View 연결
		System.out.println("result:"+result);
	}

	
	@RequestMapping( value="json/listShare/{employeeNo}", method=RequestMethod.GET)
	public @ResponseBody String listShare( @ModelAttribute("search") Search search , @ModelAttribute("share") Share share , @PathVariable String employeeNo , HttpServletRequest request) throws Exception{
		
		System.out.println("json/share/listShare : GET"+employeeNo);
		
		search.setSearchCondition("2");
		search.setSearchKeyword(employeeNo);	
		
		
		// Business logic 수행
		Map<String , Object> map=shareService.getShareList(search);

		String data = map.get("list")+"";
  
		return data;

	}
	
	@RequestMapping( value="json/listShare2/{employeeNo}", method=RequestMethod.GET)
	public @ResponseBody String listShare2( @ModelAttribute("search") Search search , @ModelAttribute("share") Share share , @PathVariable String employeeNo , HttpServletRequest request) throws Exception{
		
		System.out.println("json/share/listShare2 : GET"+employeeNo);
		
		search.setSearchCondition("2");
		search.setSearchKeyword(employeeNo);	
		search.setCurrentPage(1);
		search.setPageSize(1000);
		
		// Business logic 수행

		List<Share> list= shareService.getShareList2(search);
		
        //최종 완성될 JSONObject 선언(전체)
        JSONObject jsonObject = new JSONObject();
        //person의 JSON정보를 담을 Array 선언
        JSONArray personArray = new JSONArray();
        //person의 한명 정보가 들어갈 JSONObject 선언
        JSONObject personInfo = new JSONObject();

        
		for (Share sampleVO : list) {
            //System.out.println("organizationSErviceImple::"+sampleVO.getId());
            
            personInfo = new JSONObject();
 
            personInfo.put("shareNo", sampleVO.getShareNo());
            personInfo.put("acceptEmployeeNo", sampleVO.getAcceptEmployeeNo());
            personInfo.put("acceptEmployeeName", sampleVO.getAcceptEmployeeName());
            personInfo.put("acceptDepartmentName", sampleVO.getAcceptDepartmentName());
            personInfo.put("acceptPositionName", sampleVO.getAcceptPositionName());            
            personInfo.put("acceptStatus", sampleVO.getAcceptStatus());
            personInfo.put("shareColor", sampleVO.getShareColor());
             

            //Array에 입력
            personArray.add(personInfo);            
        }

		String jsonInfo = personArray.toString();
        
        System.out.print("jsonInfo::"+jsonInfo);
        
	
		//return jsonInfo;
		return jsonInfo;

	}	
}