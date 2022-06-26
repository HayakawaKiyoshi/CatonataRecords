package com.catonata.web.General;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.UserInformationBean;
import com.catonata.dao.UserInfoDao;
import com.catonata.validation.CreditCardInformationForm;
import com.catonata.validation.UserInformationForm;

@Controller
@RequestMapping("/mypageUpdate")
public class MyPageUpdateDeleteController {

	@Autowired
	HttpSession session;

	@RequestMapping("")
	private String updateUser (@RequestParam("name")String name,@RequestParam("password")String password,
			@ModelAttribute UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = UserInfoDao.find(name, password);
		session.setAttribute("uif", uif);
		return "general/mypage/UserUpdate";
	}
	@PostMapping("/creditCard")
	private String updateCrdt(@Validated UserInformationForm uif, BindingResult result, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "general/mypage/UserUpdate";
		}else {
//			uif = UserInfoDao.find(name, password);
			UserInformationBean Uif = (UserInformationBean)session.getAttribute("uif");
			session.setAttribute("uif", Uif);
			return "general/mypage/CardUpdate";
		}
	}

	@RequestMapping("/Check")
	private String updateCheck (@Validated CreditCardInformationForm form, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "general/mypage/CardUpdate";
		}else {
			UserInformationBean Uif = (UserInformationBean)session.getAttribute("uif");
			session.setAttribute("uif", Uif);
			session.setAttribute("creditForm", form);
			return "admin/update/GeneralCheck";
		}
	}

	@RequestMapping("/Complete")
	private String updateComplete (UserInformationForm uif,Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		uif.setId(LoginUser.getId());
		UserInfoDao.adminUpdate(uif);
		model.addAttribute("msg","更新");

		return  "admin/complete/Complete";

	}

	@RequestMapping("/Back")
	private String updateBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("userInformationForm", uif);
		return "admin/register/GeneralRegister";
	}


}
