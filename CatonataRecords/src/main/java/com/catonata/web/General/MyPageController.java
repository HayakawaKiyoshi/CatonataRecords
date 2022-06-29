package com.catonata.web.General;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.bean.PurchaseBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.dao.UserInfoDao;
import com.catonata.validation.LoginForm;


@Controller
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
	HttpSession session;



	@PostMapping("/top")
	public ModelAndView index(LoginForm form, ModelAndView mav) {
		UserInformationBean user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		if(user == null) {
			mav.setViewName("redirect:/login");
		}else {
			List<PurchaseBean> bean = UserInfoDao.findPurchase(user.getId());
			mav.addObject("purchase",bean);
			mav.setViewName("general/mypage/UserTop");
			}
		return mav;
	}

	@RequestMapping("/error/top")
	public ModelAndView errorMypage(LoginForm form, ModelAndView mav, Model model) {
		UserInformationBean user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		String msg = (String) model.asMap().get("msg");
		model.addAttribute("msg", msg);
		if(user == null) {
			mav.setViewName("redirect:/login");
		}else {
			List<PurchaseBean> bean = UserInfoDao.findPurchase(user.getId());
			mav.addObject("purchase",bean);
			mav.setViewName("general/mypage/UserTop");
			}
		return mav;
	}
}
