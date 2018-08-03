package com.bitoffice.service.department.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bitoffice.common.Search;
import com.bitoffice.service.department.DepartmentDAO;
import com.bitoffice.service.domain.Department;


//==> 부서관리 DAO CRUD 구현
@Repository("departmentDAOImpl")
public class DepartmentDAOImpl implements DepartmentDAO {
	
	///Field
		@Autowired
		@Qualifier("sqlSessionTemplate")
		private SqlSession sqlSession;
		public void setSqlSession(SqlSession sqlSession) {
			this.sqlSession = sqlSession;
		}
		
		///Constructor
		public DepartmentDAOImpl() {
			System.out.println(this.getClass());
		}

	@Override
	public void addDepartment(Department department) throws Exception {
		sqlSession.insert("DepartmentMapper.addDepartment", department);
		
	}

	@Override
	public List<Department> getDepartmentList(Search search) throws Exception {
		
		return sqlSession.selectList("DepartmentMapper.getDepartmentList", search);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		
		return sqlSession.selectOne("DepartmentMapper.getTotalCount", search);
	}

	@Override
	public void updateDepartment(Department department) throws Exception {
		
		sqlSession.update("DepartmentMapper.updateDepartment", department);
		
	}

	@Override
	public int dbCheck(String departmentName) throws Exception {
	
		return sqlSession.selectOne("DepartmentMapper.dbCheckDepartment", departmentName);
	}

	@Override
	public List<Department> getAllDepartment() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("DepartmentMapper.getAllDepartment");
	}

	@Override
	public Department getDepartment(String departmentNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("DepartmentMapper.getDepartment", departmentNo);
	}

	@Override
	public void deleteDepartment(String departmentNo) throws Exception {
		System.out.println("삭제들어왔나");
		sqlSession.delete("DepartmentMapper.deleteDepartment", departmentNo);
		
	}
	
	

}
