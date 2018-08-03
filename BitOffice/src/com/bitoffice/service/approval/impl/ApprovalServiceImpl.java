package com.bitoffice.service.approval.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Approval;
import com.bitoffice.service.approval.ApprovalService;
import com.bitoffice.service.approval.ApprovalDAO;


//==> 회원관리 서비스 구현
@Service("approvalServiceImpl")
public class ApprovalServiceImpl implements ApprovalService{
	
	///Field
	@Autowired
	@Qualifier("approvalDAOImpl")
	private ApprovalDAO approvalDao;
	public void setApprovalDao(ApprovalDAO approvalDao) {
		this.approvalDao = approvalDao;
	}
	
	///Constructor
	public ApprovalServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addApproval(Approval approval) throws Exception {
		int resultValue = approvalDao.addApproval(approval);
		return resultValue;
	}

	public Approval getApproval(String approvalId) throws Exception {
		return approvalDao.getApproval(approvalId);
	}

	public Map<String , Object > getApprovalList(Search search) throws Exception {
		List<Approval> list= approvalDao.getApprovalList(search);
		int totalCount = approvalDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	public int getTotalCountStatus(String EmployeeNo) throws Exception {
		int resultValue = approvalDao.getTotalCountStatus(EmployeeNo);
		return resultValue;
	}	

	public int updateApproval(Approval approval) throws Exception {
		int resultValue = approvalDao.updateApproval(approval);
		return resultValue;
	}
	
	public int updateApprovalStatus(Approval approval) throws Exception {
		int resultValue = approvalDao.updateApprovalStatus(approval);
		return resultValue;
	}	
	
	public int deleteApproval(Approval approval) throws Exception {
		int resultValue = approvalDao.deleteApproval(approval);
		return resultValue;
	}	

	public boolean checkDuplication(String approvalId) throws Exception {
		boolean result=true;
		Approval approval=approvalDao.getApproval(approvalId);
		if(approval != null) {
			result=false;
		}
		return result;
	}
}