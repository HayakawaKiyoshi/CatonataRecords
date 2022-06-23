package com.catonata.web.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdminTopController {
	@Autowired
	HttpSession session;

	@RequestMapping(path="/top")
	private String admintop () {
		return "admin/mypage/UserTop";
	}
}
