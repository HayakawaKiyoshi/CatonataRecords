package com.catonata.web.Exec;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.dao.ExecDao;
import com.catonata.validation.LoginForm;
import com.catonata.validation.ProductForm;

@Controller
@RequestMapping("/exec")
public class ProductDeleteController {

	@Autowired
	HttpSession session;

	@RequestMapping(path = "/select", method = RequestMethod.GET)
	public ModelAndView index(LoginForm form, ModelAndView mav) {
		UserInformationBean user = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		List<ProductBean> empList = null;
		if(user.getAuthority().equals("3")) {
			empList = ExecDao.findAll(user.getLabel());
		}else if(user.getAuthority().equals("2")) {
			empList = ExecDao.adminFindAll();
		}
		mav.setViewName("exec/delete/Select");
		mav.addObject("productForm",empList);
		return mav;
	}

	@RequestMapping(path = "/delete/select", method = RequestMethod.GET)
	public ModelAndView get(@RequestParam("check") String[] check, ProductForm form,UserInformationBean user,ModelAndView mav) {
		mav.setViewName("exec/delete/Check");

		//ログイン情報を取得する
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);

		//検索のDaoを呼び出す
		ArrayList<ProductForm> delete = ExecDao.profind2(check);

		session.setAttribute("delete", delete);
		session.setAttribute("check", check);
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
	public ModelAndView send(@RequestParam("name") String name, ProductForm form,UserInformationBean user,ModelAndView mav) {
		mav.setViewName("exec/delete/Check");

		//ログイン情報を取得する
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);

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
	public ModelAndView send2(UserInformationBean user,ModelAndView mav) {

		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		String[] check = (String[]) session.getAttribute("check");

		//削除のDaoを呼び出す
		ExecDao.productDelete(check);
		mav.addObject("msg", "削除が完了しました");
		if(user.getAuthority().equals("3")) {
			mav.setViewName("exec/complete/Complete");
		}else if(user.getAuthority().equals("2")){
			mav.setViewName("admin/complete/Complete");
		}
		//セッションインスタンスの削除
		session.removeAttribute("delete");

		return mav;
	}

	@RequestMapping(path = "delete/search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("msg") String msg,ModelAndView mav) {

		UserInformationBean user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);

		List<ProductBean> proname = ExecDao.proSearch(msg,user.getLabel());

		mav.addObject("productForm",proname);
		mav.setViewName("exec/delete/Select");

		return mav;
	}

	@RequestMapping("/back")
	public ModelAndView back(ModelAndView mav) {
		//ログイン情報の取得
		UserInformationBean user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		 //セッションに保存した情報を取得
		ProductForm delete = (ProductForm) session.getAttribute("delete");
		session.setAttribute("delete",delete );
		String[] check = (String[]) session.getAttribute("check");
		session.setAttribute("delete",check );

		return mav;
	}


}



