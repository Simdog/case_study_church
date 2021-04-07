package com.tekglobal.casestudyexample.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		modelMap.put("listChurchMember", listChurchMember);
		return "attendance";
	
}
	

	
	//https://www.viralpatel.net/spring-mvc-multi-row-submit-java-list/
	//https://www.youtube.com/watch?v=P6VnaykpXpg
//	
	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST)
	public String updateNewTithe(HttpServletRequest request) throws ParseException {
		String[] memberIds = request.getParameterValues("churchMemberId");
		String[] memberAttendance =request.getParameterValues("churchMemberAttendance");
		String[] attendanceDate = request.getParameterValues("attendanceDate");
//		SimpleDateFormat availDate = new SimpleDateFormat("dd-MM-yyyy");

		int L1 = memberIds.length;
		Boolean[] newBool = new Boolean[L1];
		Long[] newId = new Long[L1];

		for (int i = 0; i < memberIds.length; i++) {
			
			String isPresent = request.getParameter("status_"+i);
			
			
			newId[i] = Long.parseLong(memberIds[i]);
			Attendance attendance = new Attendance();
//			Boolean setBool = false;
			attendance.setId(newId[i]);
			attendance.setDate(attendanceDate[i]);
			
			newBool[i] = Boolean.getBoolean(memberAttendance[i]);
			attendance.setIsPresent(newBool[i]);
//			attendance.setDate(attendanceDate[i]);
			
			attendanceService.save(attendance);
		}
		
		return "attendance";
	
	
}
	
	
}
