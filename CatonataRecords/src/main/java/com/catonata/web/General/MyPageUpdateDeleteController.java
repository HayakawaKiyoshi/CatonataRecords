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
import com.catonata.validation.Group.AddressCheck;
import com.catonata.validation.Group.AgeCheck;
import com.catonata.validation.Group.BirthdayCheck;
import com.catonata.validation.Group.CreditnumberCheck;
import com.catonata.validation.Group.CreditspanCheck;
import com.catonata.validation.Group.EmailCheck;
import com.catonata.validation.Group.GenderCheck;
import com.catonata.validation.Group.NameCheck;
import com.catonata.validation.Group.PasswordCheck;
import com.catonata.validation.Group.SecurityCheck;

@Controller
@RequestMapping("/mypageUpdate")
public class MyPageUpdateDeleteController {

	@Autowired
	HttpSession session;

	@RequestMapping("")
	private String updateUser (@RequestParam("name")String name,@RequestParam("password")String password,
			@ModelAttribute UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		System.out.println(name);
		System.out.println(password);
		session.setAttribute("LoginUser", LoginUser);
		uif = UserInfoDao.find(name, password);
		session.setAttribute("uif", uif);
		model.addAttribute("userInformationForm",uif);
		return "general/mypage/UserUpdate";
	}

	@PostMapping("/creditCard")
	private String updateCrdt(@Validated({NameCheck.class,PasswordCheck.class,AgeCheck.class,GenderCheck.class
		,AddressCheck.class,BirthdayCheck.class,EmailCheck.class}) UserInformationForm uif,
			BindingResult result, Model model,@ModelAttribute CreditCardInformationForm form) {
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
	private String updateCheck (@Validated({CreditnumberCheck.class,CreditspanCheck.class,SecurityCheck.class})
	CreditCardInformationForm form, BindingResult result, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		if (result.hasErrors()) {
			return "general/mypage/CardUpdate";
		}else {
			UserInformationForm Uif = (UserInformationForm)session.getAttribute("uif");
			session.setAttribute("uif", Uif);
			session.setAttribute("card", form);
			//クレジットカード伏字編集
			String[] cre_number = cre_number(form.getCreditnumber());
			model.addAttribute("cre_number",cre_number);
			return "general/mypage/UpdateCheck";
		}
	}

	//クレジットカード番号伏字変換
	private String[] cre_number (String crenumber) {
		String[] cre_number = crenumber.split("-");
		for (int i = 0 ; i < 3 ; i++) {
				cre_number[i] = cre_number[i].replace(cre_number[i],"****-");
		}
		return cre_number;
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
