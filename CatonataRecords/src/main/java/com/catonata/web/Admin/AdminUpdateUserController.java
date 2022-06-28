package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.UserInformationBean;
import com.catonata.dao.UserInfoDao;
import com.catonata.validation.ExecInformationForm;
import com.catonata.validation.UserInformationForm;

@Controller
@RequestMapping("/AdminUpdate")
public class AdminUpdateUserController {
	@Autowired
	HttpSession session;

	/*
	 * 一般者更新
	 */
	@RequestMapping("")
	private String updateUser (@RequestParam("name")String name,@RequestParam("password")String password,
			@ModelAttribute UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = UserInfoDao.find(name, password);
		model.addAttribute("userInformationForm", uif);
		return "admin/update/GeneralUpdate";
	}

	@RequestMapping("/Check")
	private String updateCheck (@Validated UserInformationForm uif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/update/GeneralUpdate";
		}
		session.setAttribute("uif", uif);
		return "admin/update/GeneralCheck";


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

	/*
	 * 経営者更新
	 */
	@RequestMapping("/Exec")
	private String updateExec (@RequestParam("name")String name,@RequestParam("password")String password,
			@ModelAttribute ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		eif = UserInfoDao.execFind(name, password);
		model.addAttribute("execInformationForm", eif);
		return "admin/update/ExecUpdate";
	}

	@RequestMapping("/ExecCheck")
	private String updateExecCheck (@Validated ExecInformationForm eif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/register/ExecRegister";
		}
		session.setAttribute("eif", eif);
		return "admin/update/ExecCheck";
	}

	@RequestMapping("/ExecComplete")
	private String updateExecComplete (ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		eif = (ExecInformationForm)session.getAttribute("eif");
		UserInfoDao.execUpdate(eif);
		model.addAttribute("msg","更新");
		return "admin/complete/Complete";
	}

	@RequestMapping("/ExecBack")
	private String updateExecBack(ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		eif = (ExecInformationForm)session.getAttribute("eif");
		model.addAttribute("execInformationForm", eif);
		return "admin/update/ExecUpdate";
	}
}
