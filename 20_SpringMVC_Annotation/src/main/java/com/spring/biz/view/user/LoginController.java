package com.spring.biz.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

//@Controller DispatcherServlet 에서 인식할 수 있는 컨트롤러 객체 생성
@Controller
public class LoginController {

/*@RequestMapping : 요청과 처리 (Controller) 연결 (HandlerMapping역할 대체)
 		command 객체 사용 : 파라미터로 전달되는 값을 Command 객체에 설정
 		SpringFramework 에서 객체 생성 후 파라미터 값을 설정해서 전달해줌
 		1. UserVO 타입의 객체 생성
 		2. UserVO 타입의 객체에 전달받은 파라미터 값을 설정 (이름이 일치하는 경우)
 		3. UserVO 타입의 객체를 메서드에 파라미터 값으로 전달
 */
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">> 로그인 처리 ");
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

}
