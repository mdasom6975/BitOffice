package com.bitoffice.service.department;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Department;

//==> 부서관리에서 서비스할 내용 추상화/캡슐화한 Service  Interface Definition  
public interface DepartmentService {

	// 부서 등록
	public void addDepartment(Department department) throws Exception;

	// 부서 정보조회
	public Department getDepartment(String departmentNo) throws Exception;

	// 부서정보 수정
	public void updateDepartment(Department department) throws Exception;

	// 부서 정보리스트
	public Map<String, Object> getDepartmentList(Search search) throws Exception;

	public int dbCheck(String departmentName) throws Exception;

	public List<Department> getAllDepartment() throws Exception;
	
	//부서 삭제
	public void deleteDepartment(String departmentNo) throws Exception;

}
