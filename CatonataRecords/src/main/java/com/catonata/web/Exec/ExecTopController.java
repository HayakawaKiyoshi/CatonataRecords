package com.catonata.web.Exec;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;
import com.catonata.dao.ExecDao;

@Controller
@RequestMapping("/exec")
public class ExecTopController {

	@Autowired
	HttpSession session;

	@RequestMapping("/logintop")
	public String top(Model model) {

		UserInformationBean user = (UserInformationBean) model.asMap().get("LoginUser");
		String label = (String) model.asMap().get("label");

			//全件表示のDaoを呼び出すメソッド
			List<ProductBean> empList = ExecDao.findAll(label);

			//全件をセッションに保存
			session.setAttribute("emplist", empList);
			session.setAttribute("LoginUser", user);

			//ログインしているかどうかの確認
			if (user != null) {
				model.addAttribute("emplist", empList);

			} else {
				return "redirect:/spring/login";
			}
				return "exec/mypage/UserTop";
	}

	@RequestMapping("/top")
	public String disp(Model model) {

		UserInformationBean user = (UserInformationBean)session.getAttribute("LoginUser");
	//全件表示のDaoを呼び出すメソッド
			List<ProductBean> empList = ExecDao.findAll(user.getLabel());

			//全件をセッションに保存
			session.setAttribute("emplist", empList);
//			InsertForm user = (InsertForm) session.getAttribute("LoginUser");

			//ログインしているかどうかの確認
//			if (user != null) {
				model.addAttribute("emplist", empList);
//
//			} else {
//				return "redirect:/spring/login";
//			}
				return "exec/mypage/UserTop";
	}
}
