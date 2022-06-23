package com.catonata.web.Exec;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.validation.ProductForm;


@Controller
@RequestMapping("/exec")
public class ProductRegisterController {
	@Autowired
	HttpSession session;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView index2(@Validated() ProductForm form,BindingResult result, ModelAndView mav) {
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//バリデーションエラーの確認
		if (result.hasErrors()) {
			mav.setViewName("exec/register/ProductRegister");

		} else {

			//入力フォームをセッションに保存
			session.setAttribute("proForm", form);
			mav.setViewName("insert/insertCheck");
		}

		return mav;

	}


}
