package com.catonata.web.Common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.catonata.bean.UserInformationBean;
import com.catonata.dao.CommonDao;
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
			RedirectAttributes redirectAttributes,ModelAndView mav) {


			//バリデーションエラ-
			if (bindingResult.hasErrors()) {
				mav.setViewName("login/login");

			} else {

				//name検索するDAOを呼び出す
				UserInformationBean user = CommonDao.find(form.getName(),form.getPassword());

				boolean isLogin = (user != null && form.getName().equals(user.getName()))
						&& form.getPassword().equals(user.getPassword());
				if (isLogin) {
					//ログイン情報をセッションに保存
					session.setAttribute("LoginUser", user);
					if(user.getAuthority().equals("1")) {
						mav.setViewName("/general/product/AllDisplay");
					}else if(user.getAuthority().equals("2")) {
						mav.setViewName("/admin/mypage/UserTop");
					}else if(user.getAuthority().equals("3")) {
						mav.setViewName("redirect:/exec/logintop");
					}
				} else {
					mav.setViewName("login/login");
					mav.addObject("msg", "ログインに失敗しました");
				}

			}


		return mav;

	}

}