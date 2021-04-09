package com.tekglobal.casestudyexample.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	
	@Autowired
	private UserService userService;
	private ChurchMemberService churchMemberService;
	
	@Autowired
	public HomeController( ChurchMemberService churchMemberService) {
		this.churchMemberService = churchMemberService;
	}
	
	public void setUserService(UserService userService) {
		this.userService= userService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String showRegisterPage(Model model) {
		model.addAttribute("userCred", new User());
		return "signlog";
	}
	
	
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("userCred", new User());
		return "signlog";
	}
	
	@RequestMapping(value ="/registersuccess" ,method=RequestMethod.POST)
	public ModelAndView registerNewUser(@Valid @ModelAttribute("userCred") User user, BindingResult result, HttpServletRequest request) {
		String uEmail = request.getParameter("email");
		String uPass = request.getParameter("password");
		String userName = request.getParameter("username");

		User newU = new User();
		newU.setEmail(uEmail);
		newU.setPassword(uPass);
		newU.setUsername(userName);
		System.out.println(newU);
		if (result.hasErrors()) {
			return new ModelAndView("signlog");
		}
		getUserService().saveUser(newU);
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("userCred", user);
		return mav;
	}
	
    @RequestMapping(value = "/forgotpasswordrequest", method = RequestMethod.GET)
	public ModelAndView forgotPass (@RequestParam(value = "forgotPassUserName", required = true)String userName,
			@RequestParam(value = "forgotPassEmail", required = true)String email, Model model) {
    		
    	User uName = userService.findUserByUsername(userName);
    	System.out.println(uName.getEmail());
    	System.out.println(email);
    	ModelAndView mav = new ModelAndView("forgot_password");
    	if (uName.getUsername().equals(userName) && uName.getEmail().equals(email)) {
    		mav.addObject("userCred", uName);
    		System.out.println(uName);
    		return mav;
    	} 
    	
    		return new ModelAndView("notFound");
    	}
    		   
		
	
    
    @RequestMapping(value ="/forgotpassword" ,method=RequestMethod.GET)
	public String showForgotPage(Model model) {
		model.addAttribute("userCred", new User());
		return "forgot_password";
	}
	
//	@RequestMapping(value ="/loginsuccess" ,method=RequestMethod.POST)
//	public ModelAndView loginSuccess(@Valid @ModelAttribute("userCred") User user,
//			@RequestParam("email") String email,
//			@RequestParam("password") String password,
//			BindingResult bindingResult){
//		if(bindingResult.hasErrors()){
//			return new ModelAndView("signlog");
//		}
//		ModelAndView mav = new ModelAndView("signlog");
//		User valEmail = getUserService().findByEmail(email);
//		User valPass = getUserService().findByPassword(password);
//		User[] newU = new User[25]; 
//		if (valEmail!=null && password == valPass.toString()) {
//			newU[1] = valEmail;
//			newU[2] = valPass;
//			mav.addObject("userCred", newU);
////			mav.addObject(valPass);
////			mav.addObject(valEmail);
//			return mav;
//		}else {
//			mav = new ModelAndView("notFound");
//		}
//		return mav;
//	
//	}
	
	@RequestMapping(value ="/loginsuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("userCred") User user,
			BindingResult bindingResult, HttpServletRequest request){
		if(bindingResult.hasErrors()){
			return new ModelAndView("signlog");
		}
		ModelAndView mav = new ModelAndView("signlog");
		String uMail = request.getParameter("email");
		String uPass = request.getParameter("password");

		User valEmail = getUserService().findByEmail(uMail);
		System.out.println(uMail);
		String uEmail = getUserService().findByEmail(uMail).getEmail();
		System.out.println(uEmail);
		User newUser = valEmail;
		System.out.println(newUser);


		if (uMail != null) {
//			User newUser = valEmail;
			System.out.println(newUser + "if statement");
//			newU = valEmail;
//			newU[2] = getUserService().findByPassword(uPass);
			mav.addObject("userCred", newUser);

			return mav;
		}else {
			mav = new ModelAndView("notFound");
		}
		return mav;
	
	}

	
//	public String processLoginRequest(@RequestParam("username") String username, 
//			@RequestParam("password") String password, Model model, HttpSession session) {
//		User user = userService.findUserByUsername(username);
//		
//		if (user != null && password.equals(user.getPassword())) {
//			session.setAttribute("currentUser", user);
//			System.out.println("Login succeeded.");
//			return "welcome";
//		} 
//		model.addAttribute("loginFailedMessage", "Login Invalid");
//		return "login";
//	}
	
	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String showContactPage() {
		return "signlog";
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
	
	

	
	
	
	
	
//	@GetMapping("/saveHardCodedUser")
//	public String saveHardCodedUser() {
//		User user = new User("testUser1", "test@email.com", "12345");
//		userService.saveUser(user);
//		return "index";
//	}
}

