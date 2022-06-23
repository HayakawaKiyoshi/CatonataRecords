package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catonata.bean.UserInformationBean;
import com.catonata.validation.UserInformationForm;

@Controller
@RequestMapping("/AdminRegister")
public class AdminRegisterUserController {
	@Autowired
	HttpSession session;

	/*
	 * 一般者の登録
	 */
	@RequestMapping("/start")
	private String registerstart (@ModelAttribute UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		return "admin/register/GeneralRegister";
	}

	@RequestMapping("/check")
	private String registerCheck (@Validated UserInformationForm uif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/register/GeneralRegister";
		}
		session.setAttribute("uif", uif);
		return "admin/register/GeneralCheck";
	}

	@RequestMapping("/Complete")
	private String registerComplete (UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
//		UserInfoDao.insert(uif);
		return "register/RegisterComplete";
	}

	@RequestMapping("/Back")
	private String registerBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("UserInformationForm", uif);
		 return "register/Register";
	}

	/*
	 * 経営者登録
	 */
}
