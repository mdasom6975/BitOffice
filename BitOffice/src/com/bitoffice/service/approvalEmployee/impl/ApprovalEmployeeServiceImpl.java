package com.bitoffice.service.approvalEmployee.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.ApprovalEmployee;
import com.bitoffice.service.approvalEmployee.ApprovalEmployeeService;
import com.bitoffice.service.approvalEmployee.ApprovalEmployeeDAO;


//==> 회원관리 서비스 구현
@Service("approvalEmployeeServiceImpl")
public class ApprovalEmployeeServiceImpl implements ApprovalEmployeeService{
	
	///Field
	@Autowired
	@Qualifier("approvalEmployeeDAOImpl")
	private ApprovalEmployeeDAO approvalEmployeeDao;
	public void setApprovalEmployeeDao(ApprovalEmployeeDAO approvalEmployeeDao) {
		this.approvalEmployeeDao = approvalEmployeeDao;
	}
	
	///Constructor
	public ApprovalEmployeeServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addApprovalEmployee(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = approvalEmployeeDao.addApprovalEmployee(approvalEmployee);
		return resultValue;
	}

	public ApprovalEmployee getApprovalEmployee(String approvalEmployeeId) throws Exception {
		return approvalEmployeeDao.getApprovalEmployee(approvalEmployeeId);
	}

	public Map<String , Object > getApprovalEmployeeList(Search search) throws Exception {
		List<ApprovalEmployee> list= approvalEmployeeDao.getApprovalEmployeeList(search);
		int totalCount = approvalEmployeeDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	public List<ApprovalEmployee> getApprovalEmployeeList2(Search search) throws Exception {
		List<ApprovalEmployee> list= approvalEmployeeDao.getApprovalEmployeeList(search);		
		return list;
	}	

	public int updateApprovalEmployee(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = approvalEmployeeDao.updateApprovalEmployee(approvalEmployee);
		return resultValue;
	}
	
	public int updateApprovalEmployeeStatus(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = approvalEmployeeDao.updateApprovalEmployeeStatus(approvalEmployee);
		return resultValue;
	}	
	
	public int deleteApprovalEmployee(ApprovalEmployee approvalEmployee) throws Exception {
		int resultValue = approvalEmployeeDao.deleteApprovalEmployee(approvalEmployee);
		return resultValue;
	}	

	public boolean checkDuplication(String approvalEmployeeId) throws Exception {
		boolean result=true;
		ApprovalEmployee approvalEmployee=approvalEmployeeDao.getApprovalEmployee(approvalEmployeeId);
		if(approvalEmployee != null) {
			result=false;
		}
		return result;
	}
}