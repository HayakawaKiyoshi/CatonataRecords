package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.UserInformationBean;

@Controller
@RequestMapping("/AdminDelete")
public class AdminDeleteUserController {
	@Autowired
	HttpSession session;

	/*
	 * 一般削除
	 */
	@RequestMapping("/Check")
	private String deleteCheck(@RequestParam("id")String id, @RequestParam("pass")String pass, Model model ) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
//		UserInformationBean DeleteUser = UserInfoDao.searchUser(id, pass);
//		model.addAttribute("delete", DeleteUser);
		return "admin/delete/GeneralCheck";
	}

	@RequestMapping("/Complete")
	private String deleteComplete(@RequestParam("id")String id, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
//		UserInfoDao.deleteUser(id);
//		if (id.equals(au.getId())) {
//			model.addAttribute("step", "1");
//		}
		return "admin/delete/Complete";
	}

	/*
	 * 経営者削除
	 */
	@RequestMapping("/ExecCheck")
	private String ExecdeleteCheck(@RequestParam("id")String id, @RequestParam("pass")String pass, Model model ) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
//		UserInformationBean DeleteUser = UserInfoDao.searchExecUser(id, pass);
//		model.addAttribute("delete", DeleteUser);
		return "admin/delete/ExecCheck";
	}

	@RequestMapping("/ExecComplete")
	private String ExecdeleteComplete(@RequestParam("id")String id, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
//		UserInfoDao.deleteUser(id);
//		if (id.equals(au.getId())) {
//			model.addAttribute("step", "1");
//		}
		return "admin/delete/Complete";
	}
}
