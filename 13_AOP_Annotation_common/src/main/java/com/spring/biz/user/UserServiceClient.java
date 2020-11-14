package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		
		System.out.println("--- 스프링 컨테이너 구동 전 ---");
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext_after-returning.xml");
		
		System.out.println("--- 스프링 컨테이너 구동 후 ---");
		UserService userService
			= (UserService)container.getBean("userService");
		
		UserVO vo = new UserVO();
		
		vo.setId("test");
		
		userService.getUser(vo);
		
		System.out.println("--- 스프링 컨테이너 종료처리 ---");
		//3. 스프링 컨테이너 종료(close)
		container.close();
	}
}
