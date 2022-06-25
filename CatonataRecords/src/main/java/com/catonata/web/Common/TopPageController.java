package com.catonata.web.Common;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catonata.bean.ProductBean;
import com.catonata.dao.CommonDao;

@Controller
public class TopPageController {
	@Autowired
	HttpSession session;

	@RequestMapping(path="/TopPage")
	private String toppage () {
		//表示するものは商品全件表示
		List<ProductBean> ap = CommonDao.allProduct();
		session.setAttribute("allproduct", ap);
		return "sitetop/SiteTop";
	}
}
