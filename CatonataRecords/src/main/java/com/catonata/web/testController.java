package com.catonata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Catonata")
public class testController {

//	http://localhost:10000/Catonata/leyout/test
	@RequestMapping("/layout/test")
	public ModelAndView layoutTest(ModelAndView mav){
		mav.setViewName("/layout/LayoutTest");
		return mav;
	}
}

