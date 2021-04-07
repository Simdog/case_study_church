package com.tekglobal.casestudyexample.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.Tithe;
import com.tekglobal.casestudyexample.repositories.ChurchMemberRepository;
import com.tekglobal.casestudyexample.services.ChurchMemberService;
import com.tekglobal.casestudyexample.services.TitheService;

@Controller
public class TitheController {
	
	
	private TitheService titheService;
	private ChurchMemberService churchMemberService;

	@Autowired
	public TitheController (TitheService titheService, ChurchMemberService churchMemberService) {
		this.titheService = titheService;
		this.churchMemberService = churchMemberService;
	}
	
	
//	@RequestMapping("/")
//	public ModelAndView home() {
//        List<Tithe> listTithe = titheService.listAll();
//        ModelAndView mav = new ModelAndView("tithe");
//        mav.addObject("listTithe", listTithe);
//        return mav;
//    }
	
//	@RequestMapping("/new")
//    public String newTitheForm(Map<String, Object> model) {
//        Tithe tithe = new Tithe();
//        model.put("tithe", tithe);
//        return "tithe";
//    }
	
	
	@RequestMapping(value = "/tithe", method = RequestMethod.POST)
	public ModelAndView enterNewTithe(Tithe tithe, Model model, Errors errors) {
		 List<ChurchMember> members = churchMemberService.listAll();
		ModelAndView mv = new ModelAndView("tithe");
		 model.addAttribute("memberMap", members);
		System.out.println(tithe.toString());
		titheService.save(tithe);
		mv.addObject("tithe", tithe);
		return mv;
}
	

//	@RequestMapping(value = "/tithe", method = RequestMethod.POST)
//	public String enterNewTithe(@ModelAttribute("tithe") Tithe tithe, Errors errors, Model model) {
//		System.out.println(tithe.toString());
//		titheService.save(tithe);
//		return "redirect:/";
//}
	
	@RequestMapping(value = "/tithe", method = RequestMethod.GET)
	public String enterTithePage(Model model) {
		 List<ChurchMember> members = churchMemberService.listAll();
		 model.addAttribute("memberMap", members);
		 model.addAttribute("tithe", new Tithe());
		 return "tithe";
    }
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
//        sdf.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//    }
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//	    sdf.setLenient(true);
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
}
