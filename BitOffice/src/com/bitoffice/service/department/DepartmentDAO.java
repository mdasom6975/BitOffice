package com.bitoffice.service.department;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Department;


//==> 부서관리에서 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface DepartmentDAO {

	// INSERT
	public void addDepartment(Department department) throws Exception;
	
	//SELECT ONE
	public Department getDepartment(String departmentNo) throws Exception;
	
	// UPDATE
	public void updateDepartment(Department department) throws Exception;
	
	public List<Department> getAllDepartment()throws Exception;

	// SELECT LIST
	public List<Department> getDepartmentList(Search search) throws Exception;

	// 게시판 Page 처리를 위한 전체Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception;
	
	public int dbCheck(String departmentName) throws Exception;
	
	//DELETE
	public void deleteDepartment(String departmentNo) throws Exception;

}
