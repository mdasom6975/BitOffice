package com.bitoffice.web.reservation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Employee;
import com.bitoffice.service.domain.MeetingRoom;
import com.bitoffice.service.domain.Reservation;
import com.bitoffice.service.employee.EmployeeService;
import com.bitoffice.service.meetingroom.MeetingRoomService;
import com.bitoffice.service.reservation.ReservationService;

@Controller
@RequestMapping("/reservation/*")
public class ReservationController {

	@Autowired
	@Qualifier("reservationServiceImpl")
	private ReservationService reservationService;
	
	public ReservationController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
//	@Autowired
//	@Qualifier("employeeServiceImpl")
//	private EmployeeService employeeService;
//	
//	@Autowired
//	@Qualifier("meetingRoomServiceImpl")
//	private MeetingRoomService meetingRoomService;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="listReservation")
	public String listReservation(@ModelAttribute("search") Search search, Model model) throws Exception{
		
		System.out.println("/reservation/listReservation");
		
		if(search.getCurrentPage() == 0) {
			
			
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);

//		String mettingRoomName = ((MeetingRoom)session.getAttribute("meetingRoom")).getMettingRoomName();

		Map<String, Object> map = reservationService.getReservationList(search);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);

		String menu = "";
		menu="listReservation";
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		model.addAttribute("menu", menu);
		
		return "forward:/reservation/reservation.jsp";
	
	}
	
	@RequestMapping(value="addReservation", method=RequestMethod.GET)
	public String addReservation(Model model) throws Exception{
		
		System.out.println("/reservation/addReservation:GET");
		
		String menu = "";
		menu = "addReservation";
				
		model.addAttribute("menu", menu);
		
		return "forward:/reservation/reservation.jsp";
	}
	
	@RequestMapping(value="addReservation", method=RequestMethod.POST)
	public String addReservation(@ModelAttribute("reservation") Reservation reservation) throws Exception{
		
		System.out.println("/reservation/addReservation:POST");
		
		reservationService.addReservation(reservation);
		System.out.println(reservation);
		
		return "redirect:/reservation/myReservation";
	}
		
	@RequestMapping(value="updateReservation", method=RequestMethod.GET ) 
	public String updateReservation(@RequestParam("reNum") int reNum, Model model) throws Exception{
		
		System.out.println("/reservation/updateReservation");
		
		Reservation reservation = reservationService.getReservation(reNum);
		
		String menu = "";
		menu="updateReservation";
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("menu", menu);
		
		System.out.println("여기는 업데이트 컨트롤러 레저베이션"+reservation);
		
		return "forward:/reservation/reservation.jsp";
	}
	
	@RequestMapping(value="updateReservation", method=RequestMethod.POST)
	public String updateReservation(@ModelAttribute("reservation") Reservation reservation) throws Exception{
		
		System.out.println("/reservation/updateReservation");
		
		reservationService.updateReservation(reservation);
		
		System.out.println("업뎃??"+reservation);
		
		return "forward:/reservation/myReservation";
	}
	
//	@RequestMapping(value="getReservation", method=RequestMethod.GET)
//	public String getReservation(@RequestParam("employeeNo") String employeeNo, Model model) throws Exception{
//		
//		System.out.println("/reservation/getReservation");
//		
//		Reservation reservation = reservationService.getReservation(employeeNo);
//		
//		model.addAttribute("reservation", reservation);
//		
//		return "forward:/reservation/getReservation.jsp";
//	}
	
	@RequestMapping(value="getReservation", method=RequestMethod.GET)
	public String getReservation(@RequestParam("reNum") int reNum, Model model) throws Exception{
		
		System.out.println("/reservation/getReservation");
		
		Reservation reservation = reservationService.getReservation(reNum);
		
		String menu = "";
		menu = "getReservation";
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("menu", menu);
		
		return "forward:/reservation/reservation.jsp";
	}
	
	@RequestMapping(value="cancelReservation")
	public String cancelReservation(@RequestParam("reNum") int reNum) throws Exception{
		
		System.out.println("/reservation/cancelReservation");
		
		reservationService.cancelReservation(reNum);
		
		return "redirect:/reservation/myReservation";
	}
	
	@RequestMapping(value="myReservation")
	public String myReservation(@ModelAttribute("search") Search search, Model model, HttpSession session) throws Exception{
		
		System.out.println("/reservation/myReservation");
		
//		String mettingRoomName = ((MeetingRoom)session.getAttribute("meetingRoom")).getMettingRoomName();
//		System.out.println("meetingRoom::::::"+session.getAttribute("meetingRoom"));
		String employeeNo = ((Employee)session.getAttribute("sessionEmployee")).getEmployeeNo();
		System.out.println(session.getAttribute("sessionEmployee"));
		System.out.println("EMPEEEEEEEEE"+employeeNo);
		
		if(search.getCurrentPage() == 0) {
			
			
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		
//		Date date = new Date();
//		
//		String sysdate = format.format(date);// java sysdate
//		
//		System.out.println("자바시스데이트??"+sysdate);
//		
//		String reservationDate = format.format(reserveDate);
//		
//		if(sysdate.compareTo(reservationDate)>0) {
//			System.out.println("auto delete process");
//			
//			reservationService.autoDelete(reserveDate);
//		}
			
		Map<String, Object> map = reservationService.myReservation(search, employeeNo);
		System.out.println("EMPNO::::::::::"+employeeNo);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);

		String menu = "";
		menu = "myReservation";
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		model.addAttribute("employeeNo", employeeNo);
		model.addAttribute("menu", menu);
		
		System.out.println("@@@@@@@@@@@"+model);
		
		return "forward:/reservation/reservation.jsp";
	}
	
}
