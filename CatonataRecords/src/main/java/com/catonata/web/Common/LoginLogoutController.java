package com.catonata.web.Common;

//@Controller
//public class LoginLogoutController {
//
//	@Autowired
//	HttpSession session;
//
//	@RequestMapping(path = "/login", method = RequestMethod.GET)
//	public String index(LoginForm form) {
//		return "login/login";
//	}
//
//	@RequestMapping(path = "/login", method = RequestMethod.POST)
//	public ModelAndView index2(@Validated LoginForm form, BindingResult bindingResult,
//			ModelAndView mav) {
//
//
//			//バリデーションエラ-
//			if (bindingResult.hasErrors()) {
//				mav.setViewName("login/login");
//
//			} else {
//
//				//id検索するDAOを呼び出す
//
//
//				boolean isLogin = ();
//				if (isLogin) {
//					//ログイン情報をセッションに保存
//					session.setAttribute("user", emp);
//					mav.setViewName("redirect:/display");
//				} else {
//					mav.setViewName("login/login");
//					mav.addObject("msg", "ログインに失敗しました");
//				}
//
//			}
//
//
//		return mav;
//
//	}
//
//}
