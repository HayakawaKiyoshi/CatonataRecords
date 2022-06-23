package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catonata.bean.UserInformationBean;
import com.catonata.validation.UserInformationForm;

@Controller
@RequestMapping("/AdminUpdate")
public class AdminUpdateUserController {
	@Autowired
	HttpSession session;

	@RequestMapping("")
	private String registerUser (@ModelAttribute UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		return "admin/update/GeneralUpdate";
	}
}
