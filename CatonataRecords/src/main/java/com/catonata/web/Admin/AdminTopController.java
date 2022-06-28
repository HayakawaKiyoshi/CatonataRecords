package com.catonata.web.Admin;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catonata.bean.ExecInformationBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.dao.UserInfoDao;

@Controller
@RequestMapping("/Admin")
public class AdminTopController {
	@Autowired
	HttpSession session;

//テスト
	@RequestMapping("/Top")
	private String admintop ( Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		//一般ユーザーの情報一覧取得、セッション保存
		ArrayList<UserInformationBean> alluser = UserInfoDao.allGeneralUserSerach();
		session.setAttribute("AllGeneralUser", alluser);
		//経営者のユーザー情報一覧取得、セッション保存
		ArrayList<ExecInformationBean> allexec = UserInfoDao.allExecUser();
		session.setAttribute("AllExecUser", allexec);
		model.addAttribute("LoginUser");
		return "admin/mypage/UserTop";
	}

	@RequestMapping("/Start")
	private String adminStart (UserInformationBean uib, Model model) {
		uib = (UserInformationBean)model.asMap().get("LoginUser");
		session.setAttribute("LoginUser", uib);
		//一般ユーザーの情報一覧取得、セッション保存
		ArrayList<UserInformationBean> alluser = UserInfoDao.allGeneralUserSerach();
		session.setAttribute("AllGeneralUser", alluser);
		//経営者のユーザー情報一覧取得、セッション保存
		ArrayList<ExecInformationBean> allexec = UserInfoDao.allExecUser();
		session.setAttribute("AllExecUser", allexec);
		return "admin/mypage/UserTop";
	}
}
