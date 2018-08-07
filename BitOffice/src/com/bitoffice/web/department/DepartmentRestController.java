package com.bitoffice.web.department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitoffice.service.department.DepartmentService;
import com.bitoffice.service.domain.Department;



//==> 何辑包府 RestController
@RestController
@RequestMapping("/department/*")
public class DepartmentRestController {
	
	///Field
	@Autowired
	@Qualifier("departmentServiceImpl")
	private DepartmentService departmentService;
	//setter Method 备泅 臼澜
		
	public DepartmentRestController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="json/dbCheck")
	@ResponseBody
	public Map<Object,Object> dbCheck(@RequestParam(value="departmentName") String departmentName) throws Exception{
		
		System.out.println("department/json/dbCheck");
		
		int count=0;
		Map<Object,Object> map= new HashMap<Object,Object>();
		//Business Logic
		count=departmentService.dbCheck(departmentName);
		map.put("count", count);
		System.out.println(count);
		
		return map;
	}
	
	@RequestMapping(value="json/getAllDepartment", method=RequestMethod.GET)
	public JSONObject getAllDepartment() throws Exception{
		
		List<Department>list = departmentService.getAllDepartment();
		
		JSONObject jo = new JSONObject();
		jo.put("department", list);
	
		
		return jo;
	}
	
	
	@RequestMapping(value="json/updateDepartment")
	
	public Department updateDepartment(@RequestParam(value="departmentNo")String departmentNo) throws Exception{
		Department updateDepartment = departmentService.getDepartment(departmentNo);
		
		return updateDepartment;
	}
}
