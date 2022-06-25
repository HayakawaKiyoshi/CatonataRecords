package com.catonata.web.Common;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catonata.bean.ProductBean;
import com.catonata.bean.UserInformationBean;
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
		mav.addObject("send","/top/search");

		return mav;
	}

	@RequestMapping(path="/general/TopPage")
	private ModelAndView  toppagegene (ModelAndView mav,Model model) {

		UserInformationBean user = (UserInformationBean) model.asMap().get("LoginUser");
		session.setAttribute("LoginUser",user);
		//表示するものは商品全件表示
		mav.setViewName("sitetop/SiteTop");
		List<ProductBean> ap = CommonDao.allProduct();
		session.setAttribute("allproduct", ap);
		mav.addObject("allproduct",ap);
		mav.addObject("LoginUser",user);
		System.out.println(user.getName());
		mav.addObject("send","/top/search");

		return mav;
	}



	@PostMapping("/search")
	public ModelAndView search(@RequestParam("msg") String msg,ModelAndView mav) {

		//検索
		List<ProductBean> proname = CommonDao.proSearch(msg);

		mav.addObject("allproduct",proname);
		mav.setViewName("sitetop/SiteTop");
		mav.addObject("send","/top/search");

		return mav;
	}

	@PostMapping("/category/search")
	public ModelAndView searchctdr(@RequestParam("category") String category,ModelAndView mav) {

		session.setAttribute("category", category);

		//カテゴリ―別に全件表示
		List<ProductBean> proname = CommonDao.proSearchCategory(category);

		mav.addObject("allproduct",proname);
		mav.setViewName("sitetop/SiteTop");
		mav.addObject("send","/top/category");

		return mav;
	}

	@PostMapping("/category")
	public ModelAndView category(@RequestParam("msg") String msg,ModelAndView mav) {

		String ctgr= (String)session.getAttribute("category");

		//カテゴリ―別に全件表示
		List<ProductBean> proname = CommonDao.proCategory(msg,ctgr);

		mav.addObject("allproduct",proname);
		mav.setViewName("sitetop/SiteTop");
		mav.addObject("send","/top/category");


		return mav;
	}


}
