package com.tekglobal.casestudyexample.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tekglobal.casestudyexample.models.Attendance;
import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.UserInfo;
import com.tekglobal.casestudyexample.services.AttendanceService;
import com.tekglobal.casestudyexample.services.ChurchMemberService;

@Controller
public class AttendanceController {
	
	private AttendanceService attendanceService;
	private ChurchMemberService churchMemberService;
	
	public AttendanceController (AttendanceService attendanceService, ChurchMemberService churchMemberService ) {
		this.attendanceService = attendanceService;
		this.churchMemberService = churchMemberService;
	}

//	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST)
//	public ModelAndView enterNewAttendance(@ModelAttribute("attendance") Attendance  attendance, Errors errors, Model model) {
//		List<ChurchMemberService> members = new ArrayList<ChurchMemberService>();
//		
//		if(null != members && members.size() > 0) {
//			this.churchMemberService = (ChurchMemberService) members;
//			
//		}
//		attendanceService.save(attendance);
//		return new ModelAndView("attendance", "attendance", attendance);
//}
	
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String getNewAttendance(ModelMap modelMap, Model model) {
		model.addAttribute("attendance", new Attendance());
		List<ChurchMember> listChurchMember = churchMemberService.listAll();
		model.addAttribute("listChurchMember",listChurchMember);
//		modelMap.put("listChurchMember", listChurchMember);
		return "attendance";
	
}
	

	
	//https://www.viralpatel.net/spring-mvc-multi-row-submit-java-list/
	//https://www.youtube.com/watch?v=P6VnaykpXpg
//	
//	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST)
//	public String updateNewTithe(HttpServletRequest request, Attendance attendance) throws ParseException {
//		String[] memberIds = request.getParameterValues("churchMemberId");
//		String[] memberAttendance =request.getParameterValues("churchMemberAttendance");
//		String[] attendanceDate = request.getParameterValues("attendanceDate");
////		SimpleDateFormat availDate = new SimpleDateFormat("dd-MM-yyyy");
//	
//		int L1 = memberIds.length;
//		Boolean[] newBool = new Boolean[L1];
////		System.out.println(memberAttendance.length);
//		Long[] newId = new Long[L1];
////		Attendance attendance = new Attendance();
//
//		for (int i = 0; i < memberIds.length; i++) {
//			String selected = request.getParameter("churchMemberAttendance" + memberIds[i]);
//			
////			newBool[i] = Boolean.parseBoolean(memberAttendance[i]);
//
////			boolean checkBool = request.getParameter("churchMemberAttendance" + memberIds) !=null;
////			System.out.println(checkBool);
//			
//			
//			boolean newB = false;
//			
//			if (selected.equals("1")) {
//				 newB = true;
//			} 
//			
//			System.out.println(newB);
//			
//			newId[i] = Long.parseLong(memberIds[i]);
////			Attendance attendance = new Attendance();
////			if (memberAttendance[i] != null) {
//////				System.out.println(memberAttendance[i]);
////				
////			} else {
////				i++;
////				
////				memberAttendance[i] = "false";
////				System.out.println("false");
////				continue;
////			}
//			
//			attendance.setId(newId[i]);
//			attendance.setDate(attendanceDate[i]);
//			
//			attendance.setIsPresent(newB);
////			attendance.setDate(attendanceDate[i]);
//			
//			attendanceService.save(attendance);
//		}
//		
//		return "attendance";
//	
//	
//}
	
	
//	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST)
//	public ModelAndView updateNewTithe(HttpServletRequest request, Attendance attendance, Model model) throws ParseException {
//		String[] memberIds = request.getParameterValues("churchMemberId");
//		String[] memberAttendance =request.getParameterValues("churchMemberAttendance");
//		String[] attendanceDate = request.getParameterValues("attendanceDate");
//	
//		int L1 = memberIds.length;
//		Boolean[] newBool = new Boolean[L1];
//		Long[] newId = new Long[L1];
//		
//		List<ChurchMember> members = churchMemberService.listAll();
//		ModelAndView mv = new ModelAndView("attendance");
//		model.addAttribute("listChurchMember", members);
//
//		
//		for (int i = 0; i < memberIds.length; i++) {
//			String selected = request.getParameter("churchMemberAttendance" + memberIds[i]);
//
//			ChurchMember memId = churchMemberService.get(Long.parseLong(memberIds[i]));
//
//			boolean newB = false;
//			
//			if (selected.equals("1")) {
//				 newB = true;
//			} 
//			
//			System.out.println(newB);
//			
//			newId[i] = Long.parseLong(memberIds[i]);
//			
//			
//			attendance.setMember(memId);
////			attendance.setId(newId[i]);
//			attendance.setDate(attendanceDate[i]);
//			
//			attendance.setIsPresent(newB);
//			
//			attendanceService.save(attendance);
//			mv.addObject("attendance", attendance);
//		}
////		attendanceService.save(attendance);
////
////		mv.addObject("attendance", attendance);
//
//		
//		
//		return mv;
//	
//	
//}
	
	List<ChurchMember> members = new ArrayList<ChurchMember>();
	
	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST)
	public String updateNewAttendance(HttpServletRequest request) throws ParseException {
		String[] memberIds = request.getParameterValues("churchMemberId");
		String[] memberAttendance =request.getParameterValues("churchMemberAttendance");
		String[] attendanceDate = request.getParameterValues("attendanceDate");

		int L1 = memberIds.length;
		Long[] newId = new Long[L1];
		for (int i = 0; i < memberIds.length; i++) {
			newId[i] = Long.parseLong(memberIds[i]);
			Attendance attendance = new Attendance();
			String selected = request.getParameter("churchMemberAttendance" + memberIds[i]);

//			ChurchMember mem[] = new ChurchMember[memberIds.length];
//			mem[i].getId();
			ChurchMember memId = churchMemberService.get(Long.parseLong(memberIds[i]));
			attendance.setMember(memId);
			attendance.setDate(attendanceDate[i]);
			boolean newB = false;
//			System.out.println(memberAttendance[i]);
			if (selected.equals("1")) {
				 newB = true;
			} 
			attendance.setIsPresent(newB);


			attendanceService.save(attendance);
			
			
		}
		
		return "redirect:/attendance";
	}
		
	
	
}

