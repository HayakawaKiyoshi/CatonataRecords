package com.catonata.web.Exec;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.bean.UserInformationBean;
import com.catonata.dao.ExecDao;
import com.catonata.validation.ProductForm;



@Controller
@RequestMapping("/exec")
public class ProductRegisterController {
	@Autowired
	HttpSession session;

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String index(ProductForm form) {
		return "exec/register/ProductRegister";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ModelAndView index2(@Validated ProductForm form,BindingResult result, UserInformationBean user,ModelAndView mav) {
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);

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
	public ModelAndView insert(UserInformationBean user,ModelAndView mav) {
		mav.setViewName("exec/complete/Complete");
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);

		//入力内容をセッションから取得
		ProductForm proForm = (ProductForm) session.getAttribute("proForm");

		//登録を実行するDaoを呼び出す
		ExecDao.productRegister(proForm);
		mav.addObject("msg", "登録が完了しました");


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
	public ModelAndView back(UserInformationBean user,ModelAndView mav) {
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		mav.setViewName("exec/register/ProductRegister");

		 //入力した内容を取得
		 ProductForm form = (ProductForm) session.getAttribute("proForm");
		 mav.addObject("productForm", form);

		return mav;
	}


}
