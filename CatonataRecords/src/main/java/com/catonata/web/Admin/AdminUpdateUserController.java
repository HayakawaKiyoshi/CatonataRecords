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
import com.catonata.dao.CommonDao;
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
		session.setAttribute("uif", uif);
		return "admin/update/GeneralUpdate";
	}

	@RequestMapping("/Check")
	private String updateCheck (@Validated({NameCheck.class,PasswordCheck.class,AgeCheck.class,GenderCheck.class
		,AddressCheck.class,BirthdayCheck.class,EmailCheck.class}) UserInformationForm uif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/update/GeneralUpdate";
		}
		UserInformationForm suif =  (UserInformationForm)session.getAttribute("uif");
		uif.setCreditnumber(suif.getCreditnumber());
		uif.setCreditspan(suif.getCreditspan());
		uif.setSecurity(suif.getSecurity());
		uif.setId(suif.getId());
		session.setAttribute("uif", uif);
		return "admin/update/GeneralCheck";


	}

	@RequestMapping("/Complete")
	private String updateComplete (UserInformationForm uif,Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		UserInfoDao.adminUpdate(uif);
		model.addAttribute("msg","更新が完了しました。");

		return  "admin/complete/Complete";

	}

	@RequestMapping("/Back")
	private String updateBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("userInformationForm", uif);
		return "admin/update/GeneralUpdate";
	}

	/*
	 * 経営者更新
	 */
	@RequestMapping("/Exec")
	private String updateExec (@RequestParam("name")String name,@RequestParam("password")String password,
			@ModelAttribute ExecInformationForm eif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		System.out.println(name);
		eif = UserInfoDao.execFind(name, password);
		System.out.println(eif.getName());
		model.addAttribute("execInformationForm", eif);
		return "admin/update/ExecUpdate";
	}

	@RequestMapping("/ExecCheck")
	private String updateExecCheck (@Validated({NameCheck.class,LabelCheck.class,PasswordCheck.class,EmailCheck.class
		,AddressCheck.class,BanknumberCheck.class,BanknameCheck.class})  ExecInformationForm eif, BindingResult result) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "admin/update/ExecUpdate";
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
		if(LoginUser.getAuthority().equals("3")){
			LoginUser = CommonDao.find(eif.getName(),eif.getPassword());
			session.setAttribute("LoginUser", LoginUser);
		}
		model.addAttribute("msg","更新が完了しました。");
		String rtrn = null;
		if(LoginUser.getAuthority().equals("2")) {
			rtrn = "admin/complete/Complete";
		}else if(LoginUser.getAuthority().equals("3")){
			rtrn = "exec/complete/Complete";
		}

		return rtrn;
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
