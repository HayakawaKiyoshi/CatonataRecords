
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

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.dao.ExecDao;
import com.catonata.validation.ProductForm;
import com.catonata.validation.Group.ArtistCheck;
import com.catonata.validation.Group.MediaCheck;
import com.catonata.validation.Group.PriceCheck;
import com.catonata.validation.Group.Pro_nameCheck;
import com.catonata.validation.Group.Release_dateCheck;
import com.catonata.validation.Group.StockCheck;


@Controller
@RequestMapping("/exec")
public class ProductUpdateController {

	@Autowired
	HttpSession session;


	@RequestMapping(path = "/update", method = RequestMethod.GET)
	public ModelAndView send(@RequestParam("id") String id,ProductForm form,UserInformationBean user,ModelAndView mav) {

		//ログイン情報の取得
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		System.out.println(user.getAuthority());

		//社員情報をid検索するDAOを呼び出す
		ProductBean update = ExecDao.profind(id);

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
	public ModelAndView send(@Validated({Pro_nameCheck.class,
		ArtistCheck.class,MediaCheck.class,PriceCheck.class,Release_dateCheck.
		class,StockCheck.class}) ProductForm form, BindingResult result, UserInformationBean user,ModelAndView mav) {
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);

		System.out.println(form.getPro_name());
		//バリデーションエラーの確認
		if (result.hasErrors()) {
			mav.setViewName("exec/update/ProductUpdate");
		} else {
			ProductBean update = (ProductBean) session.getAttribute("update");
			form.setPro_id(update.getPro_id());
			form.setSold(update.getSold());
			session.setAttribute("update", form);
			mav.addObject("update", form);

			mav.setViewName("exec/update/ProductCheck");
		}

		return mav;
	}
	/**
	 * 更新を実行するメソッド
	 * @param mav
	 * @return
	 */
	@RequestMapping(path = "update/execute", method = RequestMethod.POST)
	public ModelAndView send(UserInformationBean user,ModelAndView mav) {
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		//セッションに保存された情報を取得
		ProductForm update = (ProductForm) session.getAttribute("update");
		ExecDao.productUpdate(update);
		mav.setViewName("exec/complete/Complete");

		mav.addObject("msg", "更新が完了しました。");

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
	public ModelAndView back(UserInformationBean user,ModelAndView mav) {
		//ログイン情報の取得
		user = (UserInformationBean) session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", user);
		 //セッションに保存した情報を取得
		ProductForm update = (ProductForm) session.getAttribute("update");
		 mav.addObject("productForm",update);

		 mav.setViewName("exec/update/ProductUpdate");

		return mav;
	}

}