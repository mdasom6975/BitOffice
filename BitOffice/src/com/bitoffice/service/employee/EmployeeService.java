package com.bitoffice.service.employee;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;

public interface EmployeeService {

	// 임직원 등록
	public void addEmployee(Employee employee) throws Exception;

	// 임직원 정보
	public Employee getEmployee(String employeeNo) throws Exception;

	// 로그인
	public Employee logIn(String employeeNo) throws Exception;

	// 임직원 리스트
	public Map<String, Object> getEmployeeList(Search search) throws Exception;

	// 퇴사자 리스트
	public Map<String, Object> getResignList(Search search) throws Exception;

	// 임직원 정보 수정
	public void updateEmployee(Employee employee) throws Exception;

	// 퇴사처리
	public void resignationEmp(String employeeNo) throws Exception;

	// 사번 존재여부 확인
	public int idCheck(String employeeNo) throws Exception;

	public void emailPassword(Employee employee) throws Exception;

	public void mongoDB(Employee employee) throws Exception;

	// 조직도 처리를 위한..
	public List<Employee> treeEmployee() throws Exception;

	// 부서 사용 여부 확인
	public int useDepartmentCheck(String departmentNo) throws Exception;
	
	//직급 사용 여부 확인
	
	public int usePositionCheck(String positionNo) throws Exception;
	
	//연차 사용 내역
		public List<Employee> useAnnualLeave(String employeeNo) throws Exception;

}
