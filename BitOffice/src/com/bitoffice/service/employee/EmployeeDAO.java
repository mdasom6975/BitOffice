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

	// ���ó��
	public void resignationEmp(String employeeNo) throws Exception;
	
	// SELECT LIST
    public List<Employee> getResignList(Search search) throws Exception;

	// ���Ȯ��
	public int idCheck(String employeeNo) throws Exception;

	// �Խ��� Page ó���� ���� ��üRow(totalCount) return
	public int getTotalCount(Search search) throws Exception;

	// ���Խ��� Page ó���� ���� ��üRow(totalCount) return
	public int getResignTotalCount(Search search) throws Exception;

	// �ӽú�й�ȣ�� ����
	public void emailPassword(Employee employee) throws Exception;

	// mongoDB�� ������ ���� add
	public void mongoDB(Employee employee) throws Exception;
	
	//������ ó���� ����..
	public List<Employee> treeEmployee() throws Exception;
	
	// �μ� ��� ���� Ȯ��
	public int useDepartmentCheck(String departmentNo) throws Exception;
	
	//���� ��� ���� Ȯ��
	public int usePositionCheck(String positionNo) throws Exception;
	
	//���� ��� ����
	public List<Employee> useAnnualLeave(String employeeNo) throws Exception;

}
