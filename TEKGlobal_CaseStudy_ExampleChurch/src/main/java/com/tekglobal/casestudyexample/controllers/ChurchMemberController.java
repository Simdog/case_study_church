package com.tekglobal.casestudyexample.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.services.ChurchMemberService;

@Controller
public class ChurchMemberController {

	@Autowired
	private ChurchMemberService churchMemberService;
	
	
//    @RequestMapping("/")
//	public ModelAndView home() {
//        List<ChurchMember> listChurchMember = churchMemberService.listAll();
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("listChurchMember", listChurchMember);
//        return mav;
//    }
	
    @RequestMapping(value ="/new" , method = RequestMethod.POST)
    public String newChurchmemberForm(@ModelAttribute("ChurchMember") ChurchMember churchMember, HttpServletRequest request) {
    	churchMemberService.save(churchMember);
        return "redirect:";
    }
    
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveChurchMember(@ModelAttribute("ChurchMember") ChurchMember churchMember) {
//        churchMemberService.save(churchMember);
//        return "redirect:/";
//    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUpChurchMember(@ModelAttribute("ChurchMember") ChurchMember churchMember) {
        churchMemberService.save(churchMember);
        return "redirect:/members";
    }
//	
//    @RequestMapping("/edit")
//    public ModelAndView editChurchMemberForm(@RequestParam long id) {
//        ModelAndView mav = new ModelAndView("profile_page");
//        ChurchMember churchMember = churchMemberService.get(id);
//        mav.addObject("ChurchMember", churchMember);
//     
//        return mav;
//    }
    
    @RequestMapping("/delete")
    public String deleteChurchMemberForm(@RequestParam Long id) {
        churchMemberService.delete(id);
        return "redirect:/";       
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchResult(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
//    	model.addAttribute("result", churchMemberService.search(keyword));
    	List<ChurchMember> result = churchMemberService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
     
        return mav;    
    }
    

}
