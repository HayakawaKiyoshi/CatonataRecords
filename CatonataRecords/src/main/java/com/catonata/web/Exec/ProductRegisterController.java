package com.catonata.web.Exec;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.dao.ExecDao;
import com.catonata.validation.ProductForm;



@Controller
@RequestMapping("/exec")
public class ProductRegisterController {
	@Autowired
	HttpSession session;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView index2(@Validated ProductForm form,BindingResult result, ModelAndView mav) {
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//バリデーションエラーの確認
		if (result.hasErrors()) {
			mav.setViewName("exec/register/ProductRegister");

		} else {

			//入力フォームをセッションに保存
			session.setAttribute("proForm", form);
			mav.setViewName("exec/register/ProductCheck");
		}

		return mav;

	}

	@RequestMapping(path = "/register/execute", method = RequestMethod.POST)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("exec/register/ProductComplete");
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//入力内容をセッションから取得
		ProductForm proForm = (ProductForm) session.getAttribute("proForm");

		//登録を実行するDaoを呼び出す
		ExecDao.productRegister(proForm);


		//セッションインスタンスの削除
		session.removeAttribute("proForm");

		return mav;
	}

	/**
	 * 入力画面に戻るメソッド
	 * @param mav
	 * @return
	 */
	@RequestMapping(path = "/register/back")
	public ModelAndView back(ModelAndView mav) {
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);
		mav.setViewName("exec/register/ProductRegister");

		 //入力した内容を取得
		 ProductForm form = (ProductForm) session.getAttribute("proForm");
		 mav.addObject("productForm", form);

		return mav;
	}


}
