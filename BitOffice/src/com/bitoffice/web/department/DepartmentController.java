package com.bitoffice.web.department;

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
import com.bitoffice.service.department.DepartmentService;
import com.bitoffice.service.domain.Department;

//==> 부서관리 Controller

@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	// Field
	@Autowired
	@Qualifier("departmentServiceImpl")
	private DepartmentService departmentService;

	public DepartmentController() {
		System.out.println(this.getClass());
	}

	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;

	@RequestMapping(value = "addDepartment")
	public String addDepartment(@ModelAttribute("department") Department department) throws Exception {

		System.out.println("/department/addDepartment : GET");


		// Business Logic
		departmentService.addDepartment(department);

		return "redirect:/department/listDepartment";

	}


//	@RequestMapping(value = "updateDepartment", method = RequestMethod.GET)
//	public String updateDepartment(@RequestParam("departmentNo") String departmentNo, Model model) throws Exception {
//
//		System.out.println("/department/updateDepartment : GET");
//
//		// Business Logic
//		Department department=departmentService.getDepartment(departmentNo);
//		// Model 과 View 연결
//		model.addAttribute("getDepartment", department);
//
//		return "forward:/department/updateDepartmentView.jsp";
//
//	}

	@RequestMapping(value = "updateDepartment", method = RequestMethod.POST)
	public String updateDepartment(@ModelAttribute("department") Department department) throws Exception {

		System.out.println("/department/updateDepartment : POST");

		// Business Logic

		departmentService.updateDepartment(department);

		return "forward:/department/listDepartment";

	}
	
	@RequestMapping(value = "deleteDepartment")
	public String deleteDepartment(@RequestParam("departmentNo") String departmentNo) throws Exception {

		System.out.println("/department/deleteDepartment");

		// Business Logic
		departmentService.deleteDepartment(departmentNo);
	

		return "redirect:/department/listDepartment";

	}

	@RequestMapping(value = "listDepartment")
	public String listDepartment(@ModelAttribute("search") Search search, Model model)
			throws Exception {
		System.out.println("/department/listDepartment");

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		// Business logic 수행
		Map<String, Object> map = departmentService.getDepartmentList(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);

		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);

		return "forward:/department/department.jsp";

	}

}
