package com.catonata.web.Common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
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
		return "login/Login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView index2(@Validated LoginForm form, BindingResult bindingResult,
			RedirectAttributes redirect, ModelAndView mav) {

		//バリデーションエラ-
		if (bindingResult.hasErrors()) {
			mav.setViewName("login/login");

		} else {

			//name検索するDAOを呼び出す
			UserInformationBean user = CommonDao.findId(form.getId(),form.getName(), form.getPassword());

			boolean isLogin = (user != null && form.getName().equals(user.getName()))
					&& form.getPassword().equals(user.getPassword());
			if (isLogin) {
				//ログイン情報をセッションに保存
				session.setAttribute("LoginUser", user);
				if (user.getAuthority().equals("1")) {
					mav.setViewName("redirect:/top/general/TopPage");
					redirect.addFlashAttribute("LoginUser", user);
				} else if (user.getAuthority().equals("2")) {
					redirect.addFlashAttribute("LoginUser", user);
					mav.setViewName("redirect:/Admin/Start");
				} else if (user.getAuthority().equals("3")) {
					redirect.addFlashAttribute("LoginUser", user);
					redirect.addFlashAttribute("label", user.getLabel());
					mav.setViewName("redirect:/exec/logintop");

				}
			} else {
				mav.setViewName("login/login");
				mav.addObject("msg", "ログインに失敗しました");
			}

		}

		return mav;

	}

	@RequestMapping("/logout")
	public String disp(SessionStatus sessionStatus) {
		//セッションを削除する
		sessionStatus.setComplete();
		session.invalidate();
		session.removeAttribute("LoginUser");
		session.removeAttribute("card");
		return "redirect:/top";
	}
}
