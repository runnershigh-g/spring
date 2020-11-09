package com.spring.biz.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController{
	
	@RequestMapping("/logout.do") // 요청 정보와 메서드 연결
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		// 1. 세션 초기화
		session.invalidate();
		
		return "login.jsp";
	}

}
