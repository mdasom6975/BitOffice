package com.bitoffice.web.employee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.email.sendMail;
import com.bitoffice.service.employee.EmployeeService;

//==> 임직원관리 Controller
@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	// Field
	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;

	public EmployeeController() {
		System.out.println(this.getClass());
	}

	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() throws Exception {
		System.out.println("/employee/login : GET");

		return "redirect:/loginView.jsp";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("employee") Employee employee, HttpSession session) throws Exception {

		System.out.println("/employee/login : POST");

		// Business Logic
		Employee dbEmployee = employeeService.logIn(employee.getEmployeeNo());

		if (employee.getPassword().equals(dbEmployee.getPassword())) {
			session.setAttribute("employee", dbEmployee);
		}
		String logCode = dbEmployee.getLogCode().trim();
		System.out.println("logCodelogCodelogCodelogCodelogCode" + logCode);
		String role = dbEmployee.getRole().trim();
		if (role.equals("employee") && logCode.equals("N")) {
			return "redirect:/employee/updateEmployee?employeeNo=" + dbEmployee.getEmployeeNo();
		} else {
			return "redirect:/main.jsp";
		}

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		System.out.println("/employee/logout : POST");

		session.invalidate();

		return "redirect:/loginView.jsp";
	}

	@RequestMapping(value = "addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) throws Exception {
		System.out.println("/employee/addEmployee : GET");
		
		String menu ="";
		menu="addEmployeeView";
		model.addAttribute("menu", menu);

		return "forward:/employee/employee.jsp";
	}

	@RequestMapping(value = "addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws Exception {
		System.out.println("/employee/addEmployee : POST");

		// 업로드할 폴더 경로
		String realFolder = request.getSession().getServletContext().getRealPath("/signFiles");

		// 폴더가 없을 경우 폴더 생성
		File dir = new File(realFolder);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 업로드할 파일 이름
		String org_filename = file.getOriginalFilename();
		String str_filename = employee.getEmployeeNo() + org_filename;

		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);

		String filepath = realFolder + "/" + str_filename;
		System.out.println("파일경로 : " + filepath);

		File f = new File(dir, str_filename);

		file.transferTo(f);

		employee.setSignImage(str_filename); // DB 전자서명이미지에 set

		// Business Logic
		employeeService.addEmployee(employee);

		return "redirect:/employee/listEmployee";
	}

	@RequestMapping(value = "updateEmployee", method = RequestMethod.GET)
	public String updateEmployee(@RequestParam("employeeNo") String employeeNo, Model model) throws Exception {

		System.out.println("/employee/updateEmployee:GET");
		// Business Logic
		Employee employee = employeeService.getEmployee(employeeNo);
		
		// Model 과 View 연결
		model.addAttribute("employee", employee);
		String menu ="";
		menu="updateEmployeeView";
		model.addAttribute("menu", menu);
		
		return "forward:/employee/employee.jsp";
	}

	@RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, HttpSession session,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		
		System.out.println("/employee/updateEmployee : POST");
		
		Employee oldEmployee = employeeService.getEmployee(employee.getEmployeeNo());
		
		if(employee.getAddress() == null) {
			String getAddress = oldEmployee.getAddress();
			employee.setAddress(getAddress);
		}
		
//		if(employee.getSignImage() == null) {
//			String getSignImg = oldEmployee.getSignImage();
//			employee.setSignImage(getSignImg);
//		}
		if( file== null) {
			String getProImg=oldEmployee.getProfileImage();
			employee.setProfileImage(getProImg);
		} else {
			// 업로드할 폴더 경로
			String realFolder = request.getSession().getServletContext().getRealPath("/profileFiles");
			// 폴더가 없을 경우 폴더 생성
			File dir = new File(realFolder);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 업로드할 파일 이름
			String org_filename = file.getOriginalFilename();
			String str_filename = employee.getEmployeeNo() + org_filename;

			System.out.println("원본 파일명 : " + org_filename);
			System.out.println("저장할 파일명 : " + str_filename);

			String filepath = realFolder + "/" + str_filename;
			System.out.println("파일경로 : " + filepath);

			File f = new File(dir, str_filename);

			file.transferTo(f);

	employee.setProfileImage(str_filename); // DB 프로필 사진 set
			
		}
		
		
		// Business Logic
		employeeService.updateEmployee(employee);

		String sessionId = ((Employee) session.getAttribute("employee")).getEmployeeNo();
		if (sessionId.equals(employee.getEmployeeNo())) {
			session.setAttribute("employee", employee);
		}

		return "redirect:/employee/getEmployee?employeeNo=" + employee.getEmployeeNo();

	}

	@RequestMapping(value = "resignationEmp")
	public String resignationEmp(@RequestParam("employeeNo") String employeeNo) throws Exception {

		employeeService.resignationEmp(employeeNo);

		return "redirect:/employee/resignList";
	}

	@RequestMapping(value = "getRandomPassword")
	public String getRandomPassword(Model model) throws Exception {

		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		int idx = 0;
		StringBuffer sb = new StringBuffer();

		System.out.println("charSet.length ::::::::::::::" + charSet.length);
		int len = 6;
		for (int i = 0; i < len; i++) {

			idx = (int) (charSet.length * Math.random());
			System.out.println("idx :::::::::::::::" + idx);

			sb.append(charSet[idx]);
		}
		model.addAttribute("len", sb.toString());
		
		String menu ="";
		menu="addEmployeeView";
		model.addAttribute("menu", menu);
		
		return "forward:/employee/employee.jsp";
	}



	@RequestMapping(value = "getEmployee", method = RequestMethod.GET)
	public String getEmployee(@RequestParam("employeeNo") String employeeNo, Model model, HttpSession session)
			throws Exception {

		System.out.println("/employee/getEmployee:GET");

		// Business Logic
		Employee employee = employeeService.getEmployee(employeeNo);

		// Model 과 View 연결
		model.addAttribute("employee", employee);
		String menu ="";
		menu="getEmployee";
		model.addAttribute("menu", menu);

		return "forward:/employee/employee.jsp";
	}

	@RequestMapping(value = "listEmployee")
	public String listEmployee(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {

		System.out.println("/employee/listEmployee");

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		// Business logic 수행
		Map<String, Object> map = employeeService.getEmployeeList(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);

		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		String menu ="";
		menu="listEmployee";
		model.addAttribute("menu", menu);

		return "forward:/employee/employee.jsp";

	}

	@RequestMapping(value = "resignList")
	public String getResignList(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {

		System.out.println(" ###### " + search);

		System.out.println("/employee/resignList");

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		// Business logic 수행
		Map<String, Object> map = employeeService.getResignList(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);

		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		String menu ="";
		menu="resignList";
		model.addAttribute("menu", menu);

		return "forward:/admin/admin.jsp";

	}

	@RequestMapping(value = "useAnnualLeave")
	public String useAnnualLeave(@RequestParam("employeeNo") String employeeNo, Model model) throws Exception {

		int annualLeave = 0;
		int sum = 0;
		int notUse = 0;
		Employee employee = employeeService.getEmployee(employeeNo);
		annualLeave = employee.getAnnualLeave();

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
			model.addAttribute("list", list);
		}

		List returnList = new ArrayList<>();
		returnList.add(sum);
		returnList.add(notUse);

		model.addAttribute("returnList", returnList);

		model.addAttribute("employee", employee);
		
		String menu ="";
		menu="useAnnualLeave";
		model.addAttribute("menu", menu);

		return "forward:/employee/employee.jsp";

	}

	@RequestMapping(value = "emailPassword")
	public String emailPassword(@RequestParam("employeeNo") String employeeNo, Model model) throws Exception {

		System.out.println("emailPassword : START!");
		Employee employee = employeeService.getEmployee(employeeNo);
		String email = employee.getEmail();

		String password = sendMail.emailPassword(employeeNo, email);

		employee.setPassword(password);
		model.addAttribute("employee", employee);
		// 변경된 비밀번호 업데이트
		employeeService.emailPassword(employee);
		return "redirect:/loginView.jsp";
	}

}
