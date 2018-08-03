package com.bitoffice.service.employee;

import java.util.List;
import java.util.Map;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;

public interface EmployeeService {

	// ������ ���
	public void addEmployee(Employee employee) throws Exception;

	// ������ ����
	public Employee getEmployee(String employeeNo) throws Exception;

	// �α���
	public Employee logIn(String employeeNo) throws Exception;

	// ������ ����Ʈ
	public Map<String, Object> getEmployeeList(Search search) throws Exception;

	// ����� ����Ʈ
	public Map<String, Object> getResignList(Search search) throws Exception;

	// ������ ���� ����
	public void updateEmployee(Employee employee) throws Exception;

	// ���ó��
	public void resignationEmp(String employeeNo) throws Exception;

	// ��� ���翩�� Ȯ��
	public int idCheck(String employeeNo) throws Exception;

	public void emailPassword(Employee employee) throws Exception;

	public void mongoDB(Employee employee) throws Exception;

	// ������ ó���� ����..
	public List<Employee> treeEmployee() throws Exception;

	// �μ� ��� ���� Ȯ��
	public int useDepartmentCheck(String departmentNo) throws Exception;
	
	//���� ��� ���� Ȯ��
	
	public int usePositionCheck(String positionNo) throws Exception;
	
	//���� ��� ����
		public List<Employee> useAnnualLeave(String employeeNo) throws Exception;

}
