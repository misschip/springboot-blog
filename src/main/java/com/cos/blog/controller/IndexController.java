package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping({"/",""})
	public String index() {
		return "index";
	}
	
	// auth가 붙는 user 관련 주소 처리는 여기서!
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		// 위 한줄은 아래 코드와 동일
		// return "index";
	}
}
