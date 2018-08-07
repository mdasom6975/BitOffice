package com.bitoffice.service.employee;

import java.util.List;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;

public interface EmployeeDAO {

	// INSERT
	public void addEmployee(Employee employee) throws Exception;

	// SELECT ONE
	public Employee getEmployee(String employeeNo) throws Exception;
	
	public Employee logIn(String employeeNo) throws Exception;

	// SELECT LIST
	public List<Employee> getEmployeeList(Search search, String orderby) throws Exception;

	// UPDATE
	public void updateEmployee(Employee employee) throws Exception;
	
	// UPDATE
		public void updateByAdmin(Employee employee) throws Exception;

	// 퇴사처리
	public void resignationEmp(String employeeNo) throws Exception;
	
	// SELECT LIST
    public List<Employee> getResignList(Search search) throws Exception;

	// 사번확인
	public int idCheck(String employeeNo) throws Exception;

	// 게시판 Page 처리를 위한 전체Row(totalCount) return
	public int getTotalCount(Search search) throws Exception;

	// 퇴사게시판 Page 처리를 위한 전체Row(totalCount) return
	public int getResignTotalCount(Search search) throws Exception;

	// 임시비밀번호로 변경
	public void emailPassword(Employee employee) throws Exception;

	// mongoDB에 임직원 정보 add
	public void mongoDB(Employee employee) throws Exception;
	
	//조직도 처리를 위한..
	public List<Employee> treeEmployee() throws Exception;
	
	// 부서 사용 여부 확인
	public int useDepartmentCheck(String departmentNo) throws Exception;
	
	//직급 사용 여부 확인
	public int usePositionCheck(String positionNo) throws Exception;
	
	//연차 사용 내역
	public List<Employee> useAnnualLeave(String employeeNo) throws Exception;

}
