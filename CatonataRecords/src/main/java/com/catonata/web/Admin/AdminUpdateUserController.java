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
import com.catonata.validation.ExecInformationForm;
import com.catonata.validation.UserInformationForm;

@Controller
@RequestMapping("/AdminUpdate")
public class AdminUpdateUserController {
	@Autowired
	HttpSession session;

	//コミット確認コメント
	/*
	 * 一般者更新
	 */
	@RequestMapping("")
	private String updateUser (@ModelAttribute UserInformationForm uif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
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
//		UserInfoDao.adminUpdate(uif);
		model.addAttribute("msg","更新");
		return "admin/update/GeneralComplete";
	}

	@RequestMapping("/Back")
	private String updateBack(UserInformationForm uif, Model model) {
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
	private String updateExec (@ModelAttribute ExecInformationForm eif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
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
//		UserInfoDao.execUpdate(eif);
		model.addAttribute("msg","更新");
		return "admin/update/ExecComplete";
	}

	@RequestMapping("/ExecBack")
	private String updateExecBack(ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		eif = (ExecInformationForm)session.getAttribute("eif");
		model.addAttribute("ExecInformationForm", eif);
		return "admin/update/ExecUpdate";
	}
}
