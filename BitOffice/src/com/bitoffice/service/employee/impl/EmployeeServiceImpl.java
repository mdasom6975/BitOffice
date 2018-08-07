package com.bitoffice.service.employee.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.employee.EmployeeDAO;
import com.bitoffice.service.employee.EmployeeService;

//==>임직원관리 서비스 구현
@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	//Field
	@Autowired
	@Qualifier("employeeDAOImpl")
	private EmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}
	
	//Constructor
	
	public EmployeeServiceImpl() {
		System.out.println(this.getClass());
	}
	@Override
	public void addEmployee(Employee employee) throws Exception {
		employeeDAO.addEmployee(employee);
		
	}

	@Override
	public Employee getEmployee(String employeeNo) throws Exception {
		System.out.println("들어왔나1");
		
		return employeeDAO.getEmployee(employeeNo);
	}

	@Override
	public int idCheck(String employeeNo) throws Exception {
		
		return employeeDAO.idCheck(employeeNo);
	}

	@Override
	public Map<String, Object> getEmployeeList(Search search,String orderby) throws Exception {
		
		List<Employee> list = employeeDAO.getEmployeeList(search,orderby);
		int totalCount = employeeDAO.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	@Override
	public void emailPassword(Employee employee) throws Exception {
		employeeDAO.emailPassword(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public void mongoDB(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		employeeDAO.mongoDB(employee);
	}

	@Override
	public void resignationEmp(String employeeNo) throws Exception {
		employeeDAO.resignationEmp(employeeNo);
		
	}

	@Override
	public Map<String, Object> getResignList(Search search) throws Exception {
		List<Employee> list = employeeDAO.getResignList(search);
		int totalCount = employeeDAO.getResignTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	@Override
	public List<Employee> treeEmployee() throws Exception {
	
		return employeeDAO.treeEmployee();
	}

	@Override
	public Employee logIn(String employeeNo) throws Exception {

		return employeeDAO.logIn(employeeNo);
	}

	@Override
	public int useDepartmentCheck(String departmentNo) throws Exception {
		
		return employeeDAO.useDepartmentCheck(departmentNo);
	}

	@Override
	public int usePositionCheck(String positionNo) throws Exception {
		
		return employeeDAO.usePositionCheck(positionNo);
	}

	@Override
	public List<Employee> useAnnualLeave(String employeeNo) throws Exception {	
		return employeeDAO.useAnnualLeave(employeeNo);
	}

	@Override
	public void updateByAdmin(Employee employee) throws Exception {
		employeeDAO.updateByAdmin(employee);
		
	}

}
