package com.bitoffice.service.schedule.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Schedule;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.schedule.ScheduleService;
import com.bitoffice.service.schedule.ScheduleDAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//==> �������� ���� ����
@Service("scheduleServiceImpl")
public class ScheduleServiceImpl implements ScheduleService{
	
	///Field
	@Autowired
	@Qualifier("scheduleDAOImpl")
	private ScheduleDAO scheduleDAO;
	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}
	
	///Constructor
	public ScheduleServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addSchedule(Schedule schedule) throws Exception {		
		
		int returnValue = scheduleDAO.addSchedule(schedule);
		return returnValue;
	}

	public int updateSchedule(Schedule schedule) throws Exception {
		
		int returnValue = scheduleDAO.updateSchedule(schedule);
		return returnValue;		
	}
	
	public int deleteSchedule(Integer id) throws Exception {
		
		int returnValue = scheduleDAO.deleteSchedule(id);
		return returnValue;			
	}	
	
	public Schedule getSchedule(String employeeNo) throws Exception {    
		return scheduleDAO.getSchedule(employeeNo);
	}

	public String getScheduleList(Search search) throws Exception {
		List<Schedule> list= scheduleDAO.getScheduleList(search);
		
        //���� �ϼ��� JSONObject ����(��ü)
        JSONObject jsonObject = new JSONObject();
        //person�� JSON������ ���� Array ����
        JSONArray personArray = new JSONArray();
        //person�� �Ѹ� ������ �� JSONObject ����
        JSONObject personInfo = new JSONObject();

        
		for (Schedule sampleVO : list) {
            //System.out.println("scheduleSErviceImple::"+sampleVO.getTitle());
            
            personInfo = new JSONObject();
            
            personInfo.put("id", sampleVO.getScheSerialNo());
            personInfo.put("title", sampleVO.getTitle());
            personInfo.put("description", sampleVO.getContent());
            personInfo.put("start", sampleVO.getStartDate()+"T"+sampleVO.getStartTime());
            personInfo.put("end", sampleVO.getEndDate()+"T"+sampleVO.getEndTime());
            //personInfo.put("color", sampleVO.getColor());
            personInfo.put("writer", sampleVO.getEmployeeNo());
            personInfo.put("writername", sampleVO.getDepartmentName()+" "+sampleVO.getPostionName()+" "+sampleVO.getEmployeeName());
            personInfo.put("sharerange", sampleVO.getShareRange());
            personInfo.put("backgroundColor", sampleVO.getColor());
            personInfo.put("borderColor", sampleVO.getColor());
            
            //Array�� �Է�
            personArray.add(personInfo);            
        }
	
		//System.out.print("�迭"+personArray);
		
		//jsonObject.put("events", personArray);
		
		//JSONObject�� String ��ü�� �Ҵ�
        //String jsonInfo = jsonObject.toJSONString();
		String jsonInfo = personArray.toJSONString();
        
        //System.out.print(jsonInfo);
        
	
		//return jsonInfo;
		return jsonInfo;
		
	}

	public boolean checkDuplication(String scheduleId) throws Exception {
		boolean result=true;
		Schedule schedule=scheduleDAO.getSchedule(scheduleId);
		if(schedule != null) {
			result=false;
		}
		return result;
	}
}