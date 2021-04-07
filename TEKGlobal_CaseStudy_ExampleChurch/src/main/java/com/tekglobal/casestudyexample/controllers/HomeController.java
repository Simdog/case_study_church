package com.tekglobal.casestudyexample.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tekglobal.casestudyexample.models.Attendance;
import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.Tithe;
import com.tekglobal.casestudyexample.models.User;
import com.tekglobal.casestudyexample.services.ChurchMemberService;
import com.tekglobal.casestudyexample.services.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
	private ChurchMemberService churchMemberService;
	
	@Autowired
	public HomeController(UserService userService, ChurchMemberService churchMemberService) {
		this.userService = userService;
		this.churchMemberService = churchMemberService;
	}
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String showContactPage() {
		return "contact";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@GetMapping("/signup")
	public String showSignUpPage(Model model) {
		model.addAttribute("ChurchMember", new ChurchMember());
		return "new_churchMember";
	}
	
	@GetMapping("/new")
	public String showNewPage(Model model) {
		model.addAttribute("ChurchMember", new ChurchMember());
		return "new_churchMember";
	}
	
	@GetMapping("/members")
	public String showChurchMemberPage(Model model) {
		 List<ChurchMember> listChurchMember = churchMemberService.listAll();
	        model.addAttribute("listChurchMember", listChurchMember);
//		model.addAttribute("tithe", new Tithe());
		return "churchManager";

	}
	
	
//	@GetMapping("/tithe")
//	public String showTithePage(Model model) {
//		 List<ChurchMember> listChurchMember = churchMemberService.listAll();
//	    model.addAttribute("listChurchMember", listChurchMember);
//		model.addAttribute("tithe", new Tithe());
//		return "tithe";
//
//	}
	
//	@GetMapping("/attendance")
//	public String showAttendancePage(Model model) {
//		 List<ChurchMember> listChurchMember = churchMemberService.listAll();
//	    model.addAttribute("listChurchMember", listChurchMember);
//		model.addAttribute("attendance", new Attendance());
//		return "attendance";
//
//	}
	
	@GetMapping("/profile")
	public String showProfilePage(Model model) {
//		List<ChurchMember> listChurchMember = churchMemberService.listAll();
//	    model.addAttribute("listChurchMember", listChurchMember);
//		model.addAttribute("tithe", new Tithe());
		return "profile_page";

	}
//	@RequestMapping(value = "/signup", method = RequestMethod.POST)
//	public String signUpChurchMember(@ModelAttribute("ChurchMember") ChurchMember churchMember) {
//        churchMemberService.save(churchMember);
//        return "redirect:/";
//    }

//	@PostMapping("/signup")
//	public String signUpUser(@ModelAttribute("ChurchMember") ChurchMember churchMember, BindingResult result) {
//		if (result.hasErrors()) {
//			return "new_churchMember";
//		}
//		churchMemberService.save(churchMember);
//		return "redirect:/index";
//	}
	
	
	@PostMapping("/register")
	public String registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		}
		userService.saveUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processLoginRequest(@RequestParam("username") String username, 
			@RequestParam("password") String password, Model model, HttpSession session) {
		User user = userService.findUserByUsername(username);
		
		if (user != null && password.equals(user.getPassword())) {
			session.setAttribute("currentUser", user);
			System.out.println("Login succeeded.");
			return "welcome";
		} 
		model.addAttribute("loginFailedMessage", "Login Invalid");
		return "login";
	}
	
	
	
	
	
	
//	@GetMapping("/saveHardCodedUser")
//	public String saveHardCodedUser() {
//		User user = new User("testUser1", "test@email.com", "12345");
//		userService.saveUser(user);
//		return "index";
//	}
}

