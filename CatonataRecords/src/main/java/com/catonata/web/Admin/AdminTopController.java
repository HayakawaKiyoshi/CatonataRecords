package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catonata.bean.UserInformationBean;

@Controller
@RequestMapping("/Admin")
public class AdminTopController {
	@Autowired
	HttpSession session;

//テスト
	@RequestMapping("/top")
	private String admintop () {
		//一般ユーザーの情報一覧取得、セッション保存

		//経営者のユーザー情報一覧取得、セッション保存

		//ログインユーザーの情報ゲット→保存
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		return "admin/mypage/UserTop";
	}
}
