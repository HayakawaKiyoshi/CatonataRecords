package com.catonata.web.General;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.bean.UserInformationBean;
import com.catonata.validation.LoginForm;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
	HttpSession session;



	@PostMapping("/top")
	public ModelAndView index(LoginForm form, ModelAndView mav) {
		UserInformationBean user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);


		mav.setViewName("general/mypage/UserTop");
		return mav;
	}


}
