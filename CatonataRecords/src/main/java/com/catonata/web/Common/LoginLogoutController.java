package com.catonata.web.Common;

//@Controller
//public class LoginLogoutController {

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
//			//バリデーションエラーの確認
//			if (bindingResult.hasErrors()) {
//				mav.setViewName("login/login");
//
//			} else {
//
//				//id検索するDAOを呼び出す
//				InsertForm emp = EmployeeDao.find(form.getId());
//
//				boolean isLogin = (emp != null && form.getId().equals(emp.getId()))
//						&& form.getPass().equals(emp.getPass());
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
