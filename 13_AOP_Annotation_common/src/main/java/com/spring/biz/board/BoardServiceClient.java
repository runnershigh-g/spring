package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.impl.BoardServiceImpl;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		System.out.println("--- 스프링 컨테이너 구동 전 --- ");
		// 1. 스프링 컨테이너 구동 (스프링 설정 파일 읽어서)
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("--- 스프링 컨테이너 구동 후 ---");
		// 2. 스프링 컨테이너 사용 : 생성된 객체 요청 (Lookup)
		BoardService boardService
						= (BoardService)container.getBean("boardService");
		
		// 2-1. 입력
		BoardVO vo = new BoardVO();
//		vo.setSeq(100); // 명시적으로 값을 넣을 경우 throwing exception이 발생되지 않는다.
		vo.setTitle("테스트");
		vo.setWriter("홍길동");
		vo.setContent("테스트 - 내용");
		
		try {
		boardService.insertBoard(vo);
		}catch(Exception e) {
			
		}
		
		// 전체목록 조회
		List<BoardVO> list = boardService.getBoardList(vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
		
		System.out.println("--- 스프링 컨테이너 종료처리 ---");
		//3. 스프링 컨테이너 종료(close)
		container.close();
	}
}
