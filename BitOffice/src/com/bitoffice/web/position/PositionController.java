package com.bitoffice.web.position;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.bitoffice.service.domain.Position;
import com.bitoffice.service.position.PositionService;

//==>직급관리 Controller

@Controller
@RequestMapping("/position/*")
public class PositionController {

	// Field
	@Autowired
	@Qualifier("positionServiceImpl")
	private PositionService positionService;

	public PositionController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;

	@RequestMapping(value = "addPosition", method = RequestMethod.GET)
	public String addPosition(@ModelAttribute("position") Position position) throws Exception {
		System.out.println("/position/addPosition : GET");
		

		// Business Logic
		positionService.addPosition(position);

		return "redirect:/position/listPosition";
	}

	/*
	 * @RequestMapping(value="addPosition", method=RequestMethod.POST) public String
	 * addPosition(@ModelAttribute("position") Position position) throws Exception{
	 * System.out.println("/position/addPosition : POST");
	 * 
	 * // Business Logic positionService.addPosition(position);
	 * 
	 * return "redirect:/position/addPosition.jsp";
	 * 
	 * }
	 */
	
	@RequestMapping(value="updatePosition", method=RequestMethod.GET)
	public String updatePosition(@RequestParam("positionNo")String positionNo,Model model) throws Exception{
		
		System.out.println("position/updatePosition : GET");
		
		Position position = positionService.getPosition(positionNo);
		
		model.addAttribute("position", position);
		
		return "forward:/position/updatePositionView.jsp";
		
		
	}
	
	@RequestMapping(value="updatePosition", method=RequestMethod.POST)
	public String updatePosition(@ModelAttribute("Position")Position position) throws Exception{
		
		System.out.println("/position/updatePosition : POST");
		
		positionService.updatePosition(position);
		
		return "redirect:/position/listPosition";
	}
	
	@RequestMapping(value = "deletePosition")
	public String deletePosition(@RequestParam("positionNo") String positionNo) throws Exception {

		System.out.println("/position/deletePosition");

		// Business Logic
		
		positionService.deletePosition(positionNo);

		return "redirect:/position/listPosition";

	}
	
	
	@RequestMapping(value="listPosition")
	public String listPosition(@ModelAttribute("search") Search search, Model model) throws Exception{
		
		System.out.println("/position/listPosition");
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		// Business logic 수행
		Map<String, Object> map = positionService.getPositionList(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);

		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);

		return "forward:/position/position.jsp";
		
	}
	
	

}
