package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.UserInformationBean;
import com.catonata.dao.CommonDao;
import com.catonata.dao.UserInfoDao;

@Controller
@RequestMapping("/AdminDelete")
public class AdminDeleteUserController {
	@Autowired
	HttpSession session;

	//コミット確認
	/*
	 * 一般削除
	 */
	@RequestMapping("/Check")
	private String deleteCheck(@RequestParam("name")String name, @RequestParam("password")String pass, Model model ) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		UserInformationBean DeleteUser = CommonDao.find(name, pass);
		model.addAttribute("delete", DeleteUser);
		return "admin/delete/GeneralCheck";
	}

	@RequestMapping("/Complete")
	private String deleteComplete(@RequestParam("id")String id, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		UserInfoDao.adminDelete(id);
		model.addAttribute("msg","削除が完了しました。");
		return "admin/complete/Complete";
	}

	/*
	 * 経営者削除
	 */
	@RequestMapping("/ExecCheck")
	private String ExecdeleteCheck(@RequestParam("name")String name, @RequestParam("password")String pass, Model model ) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		UserInformationBean DeleteUser = CommonDao.find(name, pass);
		model.addAttribute("delete", DeleteUser);
		return "admin/delete/ExecCheck";
	}

	@RequestMapping("/ExecComplete")
	private String ExecdeleteComplete(@RequestParam("id")String id, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		UserInfoDao.execDelete(id);
		model.addAttribute("msg","削除が完了しました。");
		return "admin/complete/Complete";
	}
}
