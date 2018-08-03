package com.bitoffice.service.department.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.department.DepartmentDAO;
import com.bitoffice.service.department.DepartmentService;
import com.bitoffice.service.domain.Department;

//==> 부서관리 서비스 구현
@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
	
	//Field
		@Autowired
		@Qualifier("departmentDAOImpl")
		private DepartmentDAO departmentDAO;
		
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
			
			this.departmentDAO = departmentDAO;
		}

	//Constructor
	public DepartmentServiceImpl() {
		System.out.println(this.getClass());
		
	}
	
	//Method
	@Override
	public void addDepartment(Department department) throws Exception {
		departmentDAO.addDepartment(department);
		
	}

	@Override
	public Map<String, Object> getDepartmentList(Search search) throws Exception {
		
		List<Department> list = departmentDAO.getDepartmentList(search);
		int totalCount = departmentDAO.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		
		return map;
	}

	@Override
	public void updateDepartment(Department department) throws Exception {
		departmentDAO.updateDepartment(department);
		
	}

	@Override
	public int dbCheck(String departmentName) throws Exception {
	
		return departmentDAO.dbCheck(departmentName);
	}

	@Override
	public List<Department> getAllDepartment() throws Exception {
		
		return departmentDAO.getAllDepartment();
	}

	@Override
	public Department getDepartment(String departmentNo) throws Exception {
		// TODO Auto-generated method stub
		return departmentDAO.getDepartment(departmentNo);
	}

	@Override
	public void deleteDepartment(String departmentNo) throws Exception {
		departmentDAO.deleteDepartment(departmentNo);
		
	}

}
