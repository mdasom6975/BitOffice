package com.bitoffice.service.employee.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.employee.EmployeeDAO;

//烙流盔包府 DAO CRUD 备泅
@Repository("employeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	//Constructor
	public EmployeeDAOImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addEmployee(Employee employee) throws Exception {
		sqlSession.insert("EmployeeMapper.addEmployee", employee);
		
	}

	@Override
	public Employee getEmployee(String employeeNo) throws Exception {
		
		return sqlSession.selectOne("EmployeeMapper.getEmployee", employeeNo);
	}

	@Override
	public int idCheck(String employeeNo) throws Exception {
		
		return sqlSession.selectOne("EmployeeMapper.idCheck", employeeNo);
	}

	@Override
	public List<Employee> getEmployeeList(Search search) throws Exception {
		
		return sqlSession.selectList("EmployeeMapper.getEmployeeList", search);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		
		return sqlSession.selectOne("EmployeeMapper.getTotalCount", search);
	}

	@Override
	public void emailPassword(Employee employee) throws Exception {
		sqlSession.update("EmployeeMapper.emailPassword", employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		sqlSession.update("EmployeeMapper.updateEmployee", employee);
		
	}

	@Override
	public void mongoDB(Employee employee) throws Exception {
		
		
	}

	@Override
	public void resignationEmp(String employeeNo) throws Exception {
		sqlSession.update("EmployeeMapper.resignationEmp", employeeNo);
		
	}

	@Override
	public List<Employee> getResignList(Search search) throws Exception {
		return sqlSession.selectList("EmployeeMapper.getResignList", search);
	}

	@Override
	public int getResignTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("EmployeeMapper.getResignTotalCount", search);
	}

	@Override
	public List<Employee> treeEmployee() throws Exception {
	
		return sqlSession.selectList("EmployeeMapper.treeEmployee");
	}

	@Override
	public Employee logIn(String employeeNo) throws Exception {
		return sqlSession.selectOne("EmployeeMapper.logIn", employeeNo);
	}

	@Override
	public int useDepartmentCheck(String departmentNo) throws Exception {
		return sqlSession.selectOne("EmployeeMapper.useDepartmentCheck", departmentNo);
	}

	@Override
	public int usePositionCheck(String positionNo) throws Exception {
		
		return sqlSession.selectOne("EmployeeMapper.usePositionCheck", positionNo);
	}

	@Override
	public List<Employee> useAnnualLeave(String employeeNo) throws Exception {
		
		return sqlSession.selectList("EmployeeMapper.useAnnualLeave", employeeNo);
	}

}
