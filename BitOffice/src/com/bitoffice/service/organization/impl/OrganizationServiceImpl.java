package com.bitoffice.service.organization.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Organization;
import com.bitoffice.service.domain.Schedule;
import com.bitoffice.service.organization.OrganizationService;
import com.bitoffice.service.organization.OrganizationDao;;


//==> ȸ������ ���� ����
@Service("organizationServiceImpl")
public class OrganizationServiceImpl implements OrganizationService{
	
	///Field
	@Autowired
	@Qualifier("organizationDaoImpl")
	private OrganizationDao organizationDao;
	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}
	
	///Constructor
	public OrganizationServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public void addOrganization(Organization organization) throws Exception {
		organizationDao.addOrganization(organization);
	}

	public Organization getOrganization(String organizationId) throws Exception {
		return organizationDao.getOrganization(organizationId);
	}

	public String getOrganizationList(Search search) throws Exception {
		
		List<Organization> list= organizationDao.getOrganizationList(search);
		
        //���� �ϼ��� JSONObject ����(��ü)
        JSONObject jsonObject = new JSONObject();
        //person�� JSON������ ���� Array ����
        JSONArray personArray = new JSONArray();
        //person�� �Ѹ� ������ �� JSONObject ����
        JSONObject personInfo = new JSONObject();

        
		for (Organization sampleVO : list) {
            //System.out.println("organizationSErviceImple::"+sampleVO.getId());
            
            personInfo = new JSONObject();
 
            personInfo.put("id", sampleVO.getId());
            personInfo.put("parent", sampleVO.getParent());
            personInfo.put("text", sampleVO.getText());
            //personInfo.put("icon", "/organization/images/user.png");
            

            //Array�� �Է�
            personArray.add(personInfo);            
        }
	
		//System.out.print("personArray::"+personArray);
		
		//jsonObject.put("events", personArray);
		
		//JSONObject�� String ��ü�� �Ҵ�
        //String jsonInfo = jsonObject.toJSONString();
		//String jsonInfo = personArray.toJSONString();
		String jsonInfo = personArray.toString();
        
        System.out.print("jsonInfo::"+jsonInfo);
        
	
		//return jsonInfo;
		return jsonInfo;
		
	}	

	public void updateOrganization(Organization organization) throws Exception {
		organizationDao.updateOrganization(organization);
	}

	public boolean checkDuplication(String organizationId) throws Exception {
		boolean result=true;
		Organization organization=organizationDao.getOrganization(organizationId);
		if(organization != null) {
			result=false;
		}
		return result;
	}
}