package com.catonata.web.Common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.dao.ExecDao;

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

	//コミット確認
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
		ProductBean product = ExecDao.profind(id);
		session.setAttribute("product", product);
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
		if(LoginUser == null) {
			return "redirect:/login";
		}else {


		//セッションから商品情報を取得、再度セッションに保存
		ProductBean product = (ProductBean)session.getAttribute("product");
		session.setAttribute("product", product);
		//日時取得
		Calendar calendar = Calendar.getInstance();
		String[] delivaryDate = delivaryDateCreate(calendar);
		//クレジットカード伏字編集
		String[] cre_number = cre_number(LoginUser.getCreditnumber());
		model.addAttribute("cre_number",cre_number);
		session.setAttribute("delivary", delivaryDate);
		return "general/product/PurchaseCheck";
		}
	}

	//配送日の変数作成メソッド
	private String[] delivaryDateCreate (Calendar calendar) {
		String [] delivaryDate = new String[7];
		int date = 1;
		for (int i = 0 ; i < delivaryDate.length ; i++) {
			delivaryDate[i] = String.valueOf(calendar.get(Calendar.YEAR) + "/");
			if((calendar.get(Calendar.DATE) + i ) < 31) {
				delivaryDate[i] +=  String.valueOf("0" + (calendar.get(Calendar.MONTH) + 1 )+ "/"
									+ (calendar.get(Calendar.DATE) + ( i + 1 )));
				if (isDate(delivaryDate[i]) == false) {
					delivaryDate[i] =  String.valueOf(calendar.get(Calendar.YEAR) + "/"
							+"0" + (calendar.get(Calendar.MONTH) + 2 )+ "/"
							+ date);
					date++;
				}
			} else if ((calendar.get(Calendar.DATE) + ( i + 1 )) > 31) {
				delivaryDate[i] +=  String.valueOf("0" + (calendar.get(Calendar.MONTH) + 2 )+ "/"
						+ date);
				date++;
			}
		}
		return delivaryDate;
	}

	/*
	 * 日付が正しいかのチェック
	 * 存在しない日付の場合には戻り値でfalseを返す。
	 */
	private boolean isDate(String value) {
	    boolean result = false;
	    if (value != null) {
	        try {
	        	LocalDate.parse(value,
	        	DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT));
	            result = true;
	        } catch (Exception e) {
	            result = false;
	        }
	    }
	    return result;
	}

	//クレジットカード番号伏字変換
	private String[] cre_number (String crenumber) {
		String[] cre_number = crenumber.split("-");
		for (int i = 0 ; i < 3 ; i++) {
				cre_number[i] = cre_number[i].replace(cre_number[i],"****-");
		}
		return cre_number;
	}


	/**
	 * 購入確認から購入完了画面に遷移するメソッド
	 * 在庫数が0より下回ってしまった場合には、確認画面に戻します。
	 * 問題がなければ、DAOで購入処理を行い完了画面に遷移します。
	 *
	 * @param delivaryDate
	 * @param pur_number
	 * @param model
	 * @return
	 */
	@RequestMapping("/PurchaseComplete")
	private String purchaseComplete (@RequestParam("delivary")String delivaryDate,
			@RequestParam("purchase_number")String pur_number , Model model) {
		UserInformationBean LoginUser = (UserInformationBean)session.getAttribute("LoginUser");
		session.setAttribute("LoginUser", LoginUser);
		//セッションから商品情報を取得、購入処理
		ProductBean product = (ProductBean)session.getAttribute("product");
		session.setAttribute("product", product);

		/*
		 * ここから購入処理
		 */

		//在庫数チェック
		int stock = Integer.parseInt(product.getStock());
		int purNumber = Integer.parseInt(pur_number);
		//在庫が足りない場合はメッセージをセットして購入確認画面に戻す。
		if ((stock - purNumber) < 0) {
			String msg = "現在品薄で在庫が足りません。\n在庫数より多い数は選択できません。";
			model.addAttribute("msg",msg);
			String[] delivary = (String[])session.getAttribute("delivary");
			session.setAttribute("delivary", delivary);
			return "general/product/PurchaseCheck";
		}

		//購入日時取得
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String purchaseDate = String.valueOf(sdf.format(calendar.getTime()));

		//購入履歴テーブルに保存
		System.out.println("ID:" + LoginUser.getId() + "\n商品ID:" + product.getPro_id()
							+ "\n購入日" + purchaseDate + "\n配送日" + delivaryDate);
		ExecDao.purchaseHistory(LoginUser, product, purchaseDate, delivaryDate);

		//商品テーブルの在庫数と販売数をUPDATE
		String newStock = String.valueOf(stock -= purNumber);
		int sold = Integer.parseInt(product.getSold());
		String newSold = String.valueOf(sold += purNumber);
		ExecDao.stockUpdate(product.getPro_id(), newStock, newSold);

		//購入処理が完了したら完了画面へ遷移
		return "general/product/PurchaseComplete";
	}

}
