package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">> 로그인 처리 -POST");
		System.out.println("vo : " + vo);
		System.out.println("userDAO : " + userDAO);
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			System.out.println(" > 로그인 성공!");
			return "redirect:getBoardList.do";
		}else {
			System.out.println(" > 로그인 실패~");
			return "login.jsp";
		}
	}
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String loginView() {
		System.out.println(">>> 로그인 처리 - login 뷰로 이동 ");
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do") // 요청 정보와 메서드 연결
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		// 1. 세션 초기화
		session.invalidate();
		return "login.jsp";
	}
}
