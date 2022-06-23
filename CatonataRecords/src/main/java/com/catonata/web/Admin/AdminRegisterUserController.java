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
	@RequestMapping("")
	private String registerUser (@ModelAttribute UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		return "admin/register/GeneralRegister";
	}

	@RequestMapping("/Check")
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
		return "admin/register/Complete";
	}

	@RequestMapping("/Back")
	private String registerBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("UserInformationForm", uif);
		return "admin/register/GeneralRegister";
	}

	/*
	 * 経営者登録
	 */
	@RequestMapping("/Exec")
	private String registerExec (@ModelAttribute UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		return "admin/register/ExecRegister";
	}

	@RequestMapping("/ExecCheck")
	private String registerExecCheck (@Validated UserInformationForm uif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/register/ExecRegister";
		}
		session.setAttribute("uif", uif);
		return "admin/register/ExecCheck";
	}

	@RequestMapping("/ExecComplete")
	private String registerExecComplete (UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
//		UserInfoDao.execInsert(uif);
		return "admin/register/Complete";
	}

	@RequestMapping("/ExecBack")
	private String registerExecBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("UserInformationForm", uif);
		return "admin/register/ExecRegister";
	}
}
