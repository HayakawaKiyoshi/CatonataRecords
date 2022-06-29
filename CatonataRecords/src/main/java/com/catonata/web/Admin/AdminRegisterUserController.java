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
import com.catonata.dao.UserInfoDao;
import com.catonata.validation.ExecInformationForm;
import com.catonata.validation.UserInformationForm;
import com.catonata.validation.Group.AddressCheck;
import com.catonata.validation.Group.AgeCheck;
import com.catonata.validation.Group.BanknameCheck;
import com.catonata.validation.Group.BanknumberCheck;
import com.catonata.validation.Group.BirthdayCheck;
import com.catonata.validation.Group.EmailCheck;
import com.catonata.validation.Group.GenderCheck;
import com.catonata.validation.Group.LabelCheck;
import com.catonata.validation.Group.NameCheck;
import com.catonata.validation.Group.PasswordCheck;

@Controller
@RequestMapping("/AdminRegister")
public class AdminRegisterUserController {
	@Autowired
	HttpSession session;

	/*
	 * 一般者の登録
	 */
	@RequestMapping("")
	private String registerUser (@ModelAttribute UserInformationForm uif,Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		model.addAttribute("send","/AdminRegister/Check");
		return "newregister/PersonalRegister";
	}

	@RequestMapping("/Check")
	private String registerCheck (@Validated({NameCheck.class,PasswordCheck.class,AgeCheck.class,GenderCheck.class
		,AddressCheck.class,BirthdayCheck.class,EmailCheck.class}) UserInformationForm uif, BindingResult result,Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "newregister/PersonalRegister";
		}
		session.setAttribute("uif", uif);
		model.addAttribute("send","/AdminRegister/Complete");
		return "newregister/RegisterCheck";
	}

	@RequestMapping("/Complete")
	private String registerComplete (UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		UserInfoDao.adminInsert(uif);
		model.addAttribute("msg","登録が完了しました。");
		return "admin/complete/Complete";
	}

	@RequestMapping("/Back")
	private String registerBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("userInformationForm", uif);
		model.addAttribute("send","/AdminRegister/Check");
		return "newregister/PersonalRegister";
	}

	/*
	 * 経営者登録
	 */
	@RequestMapping("/Exec")
	private String registerExec (@ModelAttribute ExecInformationForm eif) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		return "admin/register/ExecRegister";
	}

	@RequestMapping("/ExecCheck")
	private String registerExecCheck (@Validated({NameCheck.class,LabelCheck.class,PasswordCheck.class,EmailCheck.class
		,AddressCheck.class,BanknumberCheck.class,BanknameCheck.class}) ExecInformationForm eif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/register/ExecRegister";
		}
		session.setAttribute("eif", eif);
		return "admin/register/ExecCheck";
	}

	@RequestMapping("/ExecComplete")
	private String registerExecComplete (ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		eif = (ExecInformationForm)session.getAttribute("eif");
		UserInfoDao.execInsert(eif);
		model.addAttribute("msg","登録が完了しました。");
		return "admin/complete/Complete";
	}

	@RequestMapping("/ExecBack")
	private String registerExecBack(ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		eif = (ExecInformationForm)session.getAttribute("eif");
		model.addAttribute("execInformationForm", eif);
		return "admin/register/ExecRegister";
	}
}