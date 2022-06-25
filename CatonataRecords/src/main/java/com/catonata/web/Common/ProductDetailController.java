package com.catonata.web.Common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;

/**
 * 商品詳細/商品購入/商品購入完了処理
 *
 * @author 伊藤 馨
 *
 */

@Controller
@RequestMapping("/Purchase")
public class ProductDetailController {
	@Autowired
	HttpSession session;

	/**
	 * 商品一覧から商品詳細画面に遷移するメソッド
	 * @param name 商品名
	 * @param model
	 * @return 遷移先
	 */
	@RequestMapping("/ProductDetail")
	private String productDetailPage (@RequestParam("pro_id")String id, Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		//商品名で商品詳細を検索→セッションに保存
//		ProductBean product = ExecDao.pro_find(id);
//		session.setAttribute("product", product);
		return "general/product/ProductDetail";
	}

	/**
	 * 商品詳細画面から購入確認画面に遷移するメソッド
	 * @param model
	 * @return 遷移先
	 */
	@RequestMapping("/PurchaseCheck")
	private String purchaseCheck (Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		//セッションから商品情報を取得、再度セッションに保存
		ProductBean product = (ProductBean)session.getAttribute("product");
		session.setAttribute("product", product);
		return "general/product/PurchaseCheck";
	}

	@RequestMapping("/PurchaseComplete")
	private String purchaseComplete (Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		//セッションから商品情報を取得、購入処理
		ProductBean product = (ProductBean)session.getAttribute("product");
		session.setAttribute("product", product);

		//購入処理が完了したら完了画面へ
		//未変更
		return "general/product/PurchaseCheck";
	}

}
