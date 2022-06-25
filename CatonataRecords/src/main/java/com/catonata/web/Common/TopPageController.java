package com.catonata.web.Common;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.bean.ProductBean;
import com.catonata.dao.CommonDao;

@Controller
@RequestMapping(path="/top")
public class TopPageController {
	@Autowired
	HttpSession session;

	@RequestMapping(path="/TopPage")
	private ModelAndView  toppage (ModelAndView mav) {
		//表示するものは商品全件表示
		mav.setViewName("sitetop/SiteTop");
		List<ProductBean> ap = CommonDao.allProduct();
		session.setAttribute("allproduct", ap);
		mav.addObject("allproduct",ap);
		return mav;
	}

	@PostMapping("/search")
	public ModelAndView search(@RequestParam("msg") String msg,ModelAndView mav) {


		System.out.println(msg);

		List<ProductBean> proname = CommonDao.proSearch(msg);

		mav.addObject("allproduct",proname);
		mav.setViewName("sitetop/SiteTop");

		return mav;
	}

	@PostMapping("/category/search")
	public ModelAndView searchctdr(@RequestParam("category") String category,ModelAndView mav) {

		List<ProductBean> proname = CommonDao.proSearchCategory(category);

		mav.addObject("allproduct",proname);
		mav.setViewName("sitetop/SiteTop");

		return mav;
	}


}
