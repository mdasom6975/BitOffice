package com.bitoffice.web.employee;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.employee.EmployeeService;

//==>임직원 관리 RestController
@RestController
@RequestMapping("/employee/*")
public class EmployeeRestController {

	// Field
	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;

	public EmployeeRestController() {
		System.out.println(this.getClass());
	}
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;

	// 로그인

	@RequestMapping(value = "json/logIn", method = RequestMethod.POST)
	public Employee logIn(@RequestBody Employee employee, HttpSession session) throws Exception {

		System.out.println("employee/json/logIn : POST");
		Employee loginEmployee = employeeService.logIn(employee.getEmployeeNo());

		// 입력정보가 없거나 퇴사처리된 임직원은 로그인 불가.
		if (loginEmployee == null || loginEmployee.getRole().equals("resign")) {
			loginEmployee = new Employee();
			loginEmployee.setEmployeeNo("none");
		}

		if (employee.getPassword().equals(loginEmployee.getPassword())) {
			session.setAttribute("employee", loginEmployee);
		}

		return loginEmployee;

	}

	// 이메일발송을 위한 아이디 체크
	@RequestMapping(value = "json/idCheck")
	@ResponseBody
	public Map<Object, Object> idCheck(@RequestParam(value = "employeeNo") String employeeNo) throws Exception {

		System.out.println("/employee/json/idcheck");

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		// Business Logic
		count = employeeService.idCheck(employeeNo);
		map.put("count", count);

		return map;
	}

	// 부서 삭제 시 부서 사용여부 확인
	@RequestMapping(value = "json/useDepartmentCheck")
	@ResponseBody
	public int useDepartmentChek(@RequestParam(value = "departmentNo") String departmentNo) throws Exception {
		System.out.println("/employee/json/useDepartmentCheck");

		int count = 0;
		// Business Logic
		count = employeeService.useDepartmentCheck(departmentNo);

		return count;
	}

	// 직급 삭제 시 직급 사용여부 확인
	@RequestMapping(value = "json/usePositionCheck")
	@ResponseBody
	public int usePositionCheck(@RequestParam(value = "positionNo") String positionNo) throws Exception {
		int count = 0;

		// Business Logic
		count = employeeService.usePositionCheck(positionNo);

		return count;
	}
	
	@RequestMapping(value="json/listEmployee")
	@ResponseBody
	public JSONObject listEmployee(@ModelAttribute("search") Search search) throws Exception{
		
		System.out.println("json/listEmployee");
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
				Map<String, Object> map =employeeService.getEmployeeList(search);
				Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
						pageSize);
				JSONObject jsonObject =new JSONObject();
				jsonObject.put("list", map);
				jsonObject.put("resultPage", resultPage);
				
				return jsonObject;
	}
	
	@RequestMapping(value="json/useAnnualLeave")
	@ResponseBody
	public JSONObject useAnnualLeave(@RequestParam("employeeNo") String employeeNo) throws Exception{
		System.out.println("json/useAnnualLeave");
		
		int annualLeave = 0;
		int sum = 0;
		int notUse = 0;
		Employee employee = employeeService.getEmployee(employeeNo);
		annualLeave = employee.getAnnualLeave();
		JSONObject jsonObject =new JSONObject();
		if (annualLeave != 0) {
			List<Employee> list = new ArrayList<>();
			list = employeeService.useAnnualLeave(employeeNo);

			for (Employee e : list) {
				int use = Integer.parseInt(e.getUseDay());
				sum += use;

			}
			notUse = annualLeave - sum;
			employee.setUseDay(Integer.toString(sum));
			employee.setNotUse(notUse);
			jsonObject.put("list", list);
		}

		List returnList = new ArrayList<>();
		returnList.add(sum);
		returnList.add(notUse);
		
		jsonObject.put("returnList", returnList);
		
		jsonObject.put("employee", employee);
		
		return jsonObject;
		
	}
	
	// 조직도
//	@RequestMapping(value = "json/treeEmployee", method = RequestMethod.GET)
//	public List treeEmployee() throws Exception {
//
//		System.out.println("json/treeEmployee");
//
//		List<Employee> list = employeeService.treeEmployee();
//		List returnList = new ArrayList<>();
//		if (list.size() != 0) {
//
//			for (Employee e : list) {
//				String name = e.getEmployeeName().trim();
//				String department = e.getDepartmentName().trim();
//				String position = e.getPositionName().trim();
//				String rankCode=e.getRankCode().trim();
//				
//
//				Map<String, String> returnMap = new HashMap<String, String>();
//				returnMap.put("name", name);
//				returnMap.put("department", department);
//				returnMap.put("position", position);
//				returnMap.put("rankCode", rankCode);
//			
//
//				System.out.println(returnMap);
//				returnList.add(returnMap);
//				
//			}
//		}
//
//		return returnList;
//	}
	


}
