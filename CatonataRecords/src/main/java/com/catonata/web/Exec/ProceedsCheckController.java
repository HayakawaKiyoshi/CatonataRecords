package com.catonata.web.Exec;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catonata.bean.ProductBean;
import com.catonata.dao.ExecDao;

@Controller
@RequestMapping("/ProceedsCheck")
public class ProceedsCheckController {
	@Autowired
	HttpSession session;

	@RequestMapping(path="")
	private String proceedsCheck (@RequestParam("label")String label, Model model) {

		//labelで商品テーブルの検索を行う。
		List<ProductBean> proceedsCheck = ExecDao.findAll(label);
		model.addAttribute("proceeds",proceedsCheck);
		return "exec/profit/ProfitCheck";
	}

	//区間検索の部分はなしで
//	@RequestMapping(path="/formTo")
//	private String fromToSearch (@RequestParam("from_period")String from,
//			@RequestParam("to_period")String to,
//			@RequestParam("label")String label, Model model) {
//
//		//区間を追加した商品テーブルの検索を行う。
//		List<ProductBean> proceedsCheck = ExecDao.findAll(label);
//		model.addAttribute("proceeds",proceedsCheck);
//		return "exec/profit/ProfitCheck";
//	}
}
