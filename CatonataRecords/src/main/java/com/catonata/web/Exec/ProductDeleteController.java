package com.catonata.web.Exec;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.dao.ExecDao;
import com.catonata.validation.LoginForm;
import com.catonata.validation.ProductForm;

@Controller
@RequestMapping("/exec")
public class ProductDeleteController {

	@Autowired
	HttpSession session;

	@RequestMapping(path = "/select", method = RequestMethod.GET)
	public String index(LoginForm form) {
		return "exec/delete/Select";
	}

	@RequestMapping(path = "/delete/select", method = RequestMethod.GET)
	public ModelAndView send(@RequestParam("check") ProductForm check, ProductForm form,ModelAndView mav) {
		mav.setViewName("exec/delete/Check");

//		//ログイン情報を取得する
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//検索のDaoを呼び出す
		ProductForm delete = ExecDao.profind(check.getPro_name());

		session.setAttribute("delete", delete);
		mav.addObject("delete", delete);

		return mav;
	}

	/**
	 * 削除する情報を検索して確認画面に遷移するメソッド
	 * @param empid
	 * @param form
	 * @param mav
	 * @return
	 */
	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public ModelAndView send(@RequestParam("name") String name, ProductForm form,ModelAndView mav) {
		mav.setViewName("exec/delete/Check");

//		//ログイン情報を取得する
//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);

		//検索のDaoを呼び出す
		ProductForm delete = ExecDao.profind(name);

		session.setAttribute("delete", delete);
		mav.addObject("delete", delete);

		return mav;
	}

	/**
	 * 削除を実行するメソッド
	 * @param mav
	 * @return
	 */
	@RequestMapping(path = "delete/execute", method = RequestMethod.POST)
	public ModelAndView send2(ModelAndView mav) {

//		InsertForm user = (InsertForm) session.getAttribute("user");
//		mav.addObject("user", user);
		ProductForm delete = (ProductForm) session.getAttribute("delete");

		//削除のDaoを呼び出す
		ExecDao.productDelete(delete);

		mav.setViewName("exec/complete/Complete");
		mav.addObject("msg", "削除が完了しました");

		//セッションインスタンスの削除
		session.removeAttribute("delete");

		return mav;
	}

}



