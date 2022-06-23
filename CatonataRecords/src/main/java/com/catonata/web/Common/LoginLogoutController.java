package com.catonata.web.Common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.validation.LoginForm;

@Controller
public class LoginLogoutController {

	@Autowired
	HttpSession session;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String index(LoginForm form) {
		return "login/login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView index2(@Validated LoginForm form, BindingResult bindingResult,
			ModelAndView mav) {


			//バリデーションエラ-
			if (bindingResult.hasErrors()) {
				mav.setViewName("login/login");

			} else {

				//id検索するDAOを呼び出す


//				boolean isLogin = ();
//				if (isLogin) {
//					//ログイン情報をセッションに保存
//					session.setAttribute("user", emp);
//					mav.setViewName("redirect:/display");
//				} else {
//					mav.setViewName("login/login");
//					mav.addObject("msg", "ログインに失敗しました");
//				}

			}


		return mav;

	}

}
