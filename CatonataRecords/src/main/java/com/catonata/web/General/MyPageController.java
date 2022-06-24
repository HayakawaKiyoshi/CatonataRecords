package com.catonata.web.General;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.validation.LoginForm;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
	HttpSession session;

	@RequestMapping(path = "/top", method = RequestMethod.GET)
	public ModelAndView index(LoginForm form, ModelAndView mav) {
		mav.setViewName("general/mypage/UserTop");
		return mav;
	}


}
