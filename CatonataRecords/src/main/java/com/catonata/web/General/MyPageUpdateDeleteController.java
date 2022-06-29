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
import com.catonata.dao.CommonDao;
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
		model.addAttribute("userInformationForm",uif);
		return "general/mypage/UserUpdate";
	}

	@PostMapping("/creditCard")
	private String updateCrdt(@Validated UserInformationForm uif, BindingResult result, Model model,
								@ModelAttribute CreditCardInformationForm form) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "general/mypage/UserUpdate";
		}else {
			session.setAttribute("uif", uif);
			form = UserInfoDao.findCard(LoginUser.getName(),LoginUser.getPassword());
			model.addAttribute("creditCardInformationForm", form);
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
			UserInformationForm Uif = (UserInformationForm)session.getAttribute("uif");
			session.setAttribute("uif", Uif);
			session.setAttribute("card", form);
			return "general/mypage/UpdateCheck";
		}
	}

	@RequestMapping("/Complete")
	private String updateComplete (UserInformationForm uif,Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		uif.setId(LoginUser.getId());
		CreditCardInformationForm form = (CreditCardInformationForm)session.getAttribute("card");
		UserInfoDao.generalUpdate(uif,form);
		UserInformationBean loginuser = CommonDao.find(uif.getName(), uif.getPassword());
		session.setAttribute("LoginUser", loginuser);
		model.addAttribute("msg","更新");

		session.removeAttribute("card");
		return  "general/mypage/UpdateComplete";


	}

	@RequestMapping("/Back")
	private String updateBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("userInformationForm", uif);
		return "general/mypage/UserUpdate";
	}

	@RequestMapping("/delete/Check")
	private String deleteCheck(@RequestParam("name")String name, @RequestParam("pass")String pass, Model model ) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		UserInformationBean DeleteUser = CommonDao.find(name, pass);
		model.addAttribute("delete", DeleteUser);
		return "general/mypage/ResignCheck";
	}

	@RequestMapping("delete/Complete")
	private String deleteComplete(@RequestParam("id")String id, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		UserInfoDao.execDelete(id);
		model.addAttribute("msg","削除");
		return "general/mypage/ResignComplete";
	}
}
