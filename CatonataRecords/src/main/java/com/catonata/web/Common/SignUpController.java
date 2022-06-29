package com.catonata.web.Common;

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
@RequestMapping("/SignUp")
public class SignUpController {
	@Autowired
	HttpSession session;

	/**
	 * 新規登録の画面に遷移するメソッド
	 * @param uif 一般ユーザーの基本情報を登録するバリデーション
	 * @return
	 */
	@RequestMapping("")
	private String SignupUser (@ModelAttribute UserInformationForm uif,Model model) {
		model.addAttribute("send","/SignUp/CreditRegister");
		return "/newregister/PersonalRegister";
	}

	/**
	 * 基本情報の入力チェック及びクレジットカード情報入力画面に遷移するメソッド
	 * @param uif 基本情報チェック
	 * @param result 入力チェック
	 * @param ccif クレジットカード情報
	 * @return
	 */
	@RequestMapping("/CreditRegister")
	private String SignupCheck (@Validated({NameCheck.class,PasswordCheck.class,AgeCheck.class,GenderCheck.class
		,AddressCheck.class,BirthdayCheck.class,EmailCheck.class})  UserInformationForm uif, BindingResult result
			, @ModelAttribute CreditCardInformationForm ccif) {
		if (result.hasErrors()) {
			return "/newregister/PersonalRegister";
		}
		//基本情報の入力が正常であれば、基本情報をFormにセットしセッション保存
		session.setAttribute("uif", uif);
		//クレジット登録画面へ
		return "/newregister/CardRegister";
	}

	/**
	 * クレジットカード情報の入力チェック及び入力情報確認画面に遷移するメソッド
	 * @param ccif クレカ情報チェック
	 * @param result 入力チェック
	 * @return
	 */
	@RequestMapping("/SignUpCheck")
	private String SignupComplete (@Validated({CreditnumberCheck.class,CreditspanCheck.class,SecurityCheck.class}) CreditCardInformationForm ccif, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/newregister/CardRegister";
		}
		UserInformationForm uif = (UserInformationForm)session.getAttribute("uif");
		session.setAttribute("uif", uif);
		session.setAttribute("ccif", ccif);
		String[] cre_number = cre_number(ccif.getCreditnumber());
		model.addAttribute("send","/SignUp/SignUpComplete");
		model.addAttribute("cre_number", cre_number);
		//基本情報の入力が正常であれば、登録内容確認画面へ
		return "/newregister/RegisterCheck";
	}

	//クレジットカード番号伏字変換処理
	private String[] cre_number (String crenumber) {
		String[] cre_number = crenumber.split("-");
		for (int i = 0 ; i < 3 ; i++) {
				cre_number[i] = cre_number[i].replace(cre_number[i],"****-");
		}
		return cre_number;
	}

	/**
	 * 入力内容情報を登録する処理を行い完了画面に遷移するメソッド
	 * @param uif 基本情報保持
	 * @param ccif クレカ情報保持
	 * @param model
	 * @return
	 */
	@RequestMapping("/SignUpComplete")
	private String SignUpComplete (UserInformationForm uif,CreditCardInformationForm ccif
			, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		ccif = (CreditCardInformationForm)session.getAttribute("ccif");
		UserInfoDao.insert(uif,ccif);
		return "/newregister/RegisterComplete";
	}

	/**
	 * 戻るボタンが押された際の処理。セッションを再保存して
	 * 基本情報入力画面に遷移
	 * @param uif 基本情報入力画面に遷移
	 * @param model formに保存
	 * @return
	 */
	@RequestMapping("/SignUpBack")
	private String registerBack(UserInformationForm uif, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		uif = (UserInformationForm)session.getAttribute("uif");
		model.addAttribute("userInformationForm", uif);
		model.addAttribute("send","/SignUp/CreditRegister");
		return "/newregister/PersonalRegister";
	}

}
