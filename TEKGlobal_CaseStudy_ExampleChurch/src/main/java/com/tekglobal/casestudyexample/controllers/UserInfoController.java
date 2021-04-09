package com.tekglobal.casestudyexample.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tekglobal.casestudyexample.models.Attendance;
import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.UserInfo;
import com.tekglobal.casestudyexample.services.AttendanceService;
import com.tekglobal.casestudyexample.services.ChurchMemberService;
import com.tekglobal.casestudyexample.services.UserInfoService;

@Controller
public class UserInfoController {

	private UserInfoService userInfoService;
	private ChurchMemberService churchMemberService;
	
	public UserInfoController (UserInfoService userInfoService, ChurchMemberService churchMemberService ) {
		this.userInfoService = userInfoService;
		this.churchMemberService = churchMemberService;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUserInfo(@ModelAttribute("userInfo") UserInfo userInfo) {
        userInfoService.save(userInfo);
        return "redirect:/";
    }
	
	@RequestMapping("/edit")
    public ModelAndView editChurchMemberForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("profile_page");
        ChurchMember churchMember = churchMemberService.get(id);
//        UserInfo userInfo = userInfoService.get(id);
        mav.addObject("ChurchMember", churchMember);
     
        return mav;
    }
	
//	@RequestMapping(value = "/profile/save", method = RequestMethod.GET)
//	public String userInfoProfile(Model model) {
//		model.addAttribute("userInfo", new UserInfo());
//        return "profile_page";
//    }
//	
	
	@RequestMapping(value = "/viewmember", method = RequestMethod.GET)
	public String getMemberInfo(ModelMap modelMap, Model model) {
		model.addAttribute("userInfo", new UserInfo());

		List<ChurchMember> listChurchMember = churchMemberService.listAll();

		modelMap.put("listChurchMember", listChurchMember);
		modelMap.put("newInfo", listChurchMember);
		
        return "edit_member";
    }
	
//	@RequestMapping(value = "/updatemember", method = RequestMethod.POST)
//	public ModelAndView enterNewMemberInfo(@ModelAttribute("userInfo") UserInfo  userInfo, Errors errors, Model model) {
//		List<ChurchMemberService> members = new ArrayList<ChurchMemberService>();
//		
//		if(null != members && members.size() > 0) {
//			this.churchMemberService = (ChurchMemberService) members;
//			
//		}
//		userInfoService.save(userInfo);
//		return new ModelAndView("profile_page", "userInfo", userInfo);
//}
//	
	
	
	@RequestMapping(value = "/updatemember", method = RequestMethod.POST)
	public String updateNewTithe(HttpServletRequest request) throws ParseException {
		String[] memberIds = request.getParameterValues("churchMemberId");
		String[] memberLastName = request.getParameterValues("churchMemberLastName");
		String[] email = request.getParameterValues("churchMemberEmail");
		String[] phoneNumber = request.getParameterValues("churchMemberPhoneNumber");
		String[] memberFirstName = request.getParameterValues("churchMemberFirstName");
		String[] address = request.getParameterValues("churchMemberAddress");

		int L1 = memberIds.length;
		Long[] newId = new Long[L1];
		
		for (int i = 0; i < memberIds.length; i++) {
			newId[i] = Long.parseLong(memberIds[i]);
			UserInfo userInfo = new UserInfo();
			userInfo.setId(newId[i]);
			userInfo.setLastName(memberLastName[i]);
			userInfo.setFirstName(memberFirstName[i]);
			userInfo.setAddress(address[i]);
			userInfo.setEmail(email[i]);
			userInfo.setPhoneNumber(phoneNumber[i]);
			
			if (!memberFirstName[i].isBlank() && address[i].isBlank()) {
				userInfo.setId(newId[i]);
				userInfo.setLastName(memberLastName[i]);
				userInfo.setFirstName(memberFirstName[i]);
				userInfo.setEmail(email[i]);
				userInfo.setPhoneNumber(phoneNumber[i]);
				
			} else if (!address[i].isBlank() && memberFirstName[i].isBlank()) {
				userInfo.setId(newId[i]);
				userInfo.setLastName(memberLastName[i]);
				userInfo.setAddress(address[i]);
				userInfo.setEmail(email[i]);
				userInfo.setPhoneNumber(phoneNumber[i]);
			} else if (address[i].isBlank()) {
				continue;
			}
			

			
			
			
			userInfoService.save(userInfo);
		}
		
		return "edit_member";
	}
	
	
	
	@RequestMapping(value = "/profile/save", method = RequestMethod.POST)
	public String processUserInfoProfile(@ModelAttribute("userInfo") UserInfo userInfo, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "profile_page";
		}
		
        userInfoService.save(userInfo);
        return "redirect:/";
    }
}
