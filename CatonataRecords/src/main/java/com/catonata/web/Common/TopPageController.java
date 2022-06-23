package com.catonata.web.Common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopPageController {
	@Autowired
	HttpSession session;

	@RequestMapping(path="/TopPage")
	private String toppage () {
		//表示するものは商品全件表示
//		ArrayList<ProductBean> ap = Common.allProduct(ap);
//		session.setAttribute("allproduct", ap);
		return "sitetop/SiteTop";
	}
}
