package com.catonata.web.Exec;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.dao.ExecDao;
import com.catonata.validation.ProductForm;


@Controller
@RequestMapping("/exec")
public class ProductUpdateController {

	@Autowired
	HttpSession session;

	@RequestMapping(path = "/update", method = RequestMethod.GET)
	public ModelAndView send(@RequestParam("name") String name,
			ProductForm form,ModelAndView mav) {

//		//ログイン情報の取得
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//社員情報をid検索するDAOを呼び出す
		ProductForm update = ExecDao.profind(name);

		//検索結果の情報をセッションに保存
		session.setAttribute("update", update);
		mav.addObject("productForm", update);
		mav.setViewName("exec/update/ProductUpdate");

		return mav;
	}

	/**
	 * 入力内容のエラー確認と確認画面に遷移するメソッド
	 * @param form
	 * @param result
	 * @param mav
	 * @return
	 */
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ModelAndView send(@Validated ProductForm form, BindingResult result, ModelAndView mav) {
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//バリデーションエラーの確認
		if (result.hasErrors()) {
			mav.setViewName("exec/update/ProductUpdate");
		} else {
			mav.addObject("update", form);

			mav.setViewName("exec/update/ExecCheck");
		}

		return mav;
	}
	/**
	 * 更新を実行するメソッド
	 * @param mav
	 * @return
	 */
	@RequestMapping(path = "update/execute", method = RequestMethod.POST)
	public ModelAndView send(ModelAndView mav) {
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);
		//セッションに保存された情報を取得
		ProductForm update = (ProductForm) session.getAttribute("update");
		ExecDao.productUpdate(update);
		mav.setViewName("exec/complete/Complete");

		//セッションインスタンスの削除
		session.removeAttribute("update");

		return mav;
	}

	/**
	 * 情報を保持したまま入力画面に戻るメソッド
	 * @param mav
	 * @return
	 */
	@RequestMapping("update/back")
	public ModelAndView back(ModelAndView mav) {
		//ログイン情報の取得
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		 //セッションに保存した情報を取得
		ProductForm update = (ProductForm) session.getAttribute("update");
		 mav.addObject("productForm",update);

		 mav.setViewName("exec/update/ProductUpdate");

		return mav;
	}

}
