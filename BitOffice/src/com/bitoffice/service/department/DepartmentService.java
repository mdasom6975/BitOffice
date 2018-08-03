package com.bitoffice.service.department;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Department;

//==> �μ��������� ������ ���� �߻�ȭ/ĸ��ȭ�� Service  Interface Definition  
public interface DepartmentService {

	// �μ� ���
	public void addDepartment(Department department) throws Exception;

	// �μ� ������ȸ
	public Department getDepartment(String departmentNo) throws Exception;

	// �μ����� ����
	public void updateDepartment(Department department) throws Exception;

	// �μ� ��������Ʈ
	public Map<String, Object> getDepartmentList(Search search) throws Exception;

	public int dbCheck(String departmentName) throws Exception;

	public List<Department> getAllDepartment() throws Exception;
	
	//�μ� ����
	public void deleteDepartment(String departmentNo) throws Exception;

}
