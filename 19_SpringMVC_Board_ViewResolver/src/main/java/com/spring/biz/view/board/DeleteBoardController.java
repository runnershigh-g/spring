package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(">>> 게시글 삭제 처리 ");
		// 1. 전달받은 파라미터 추출 (확인)
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리 (데이터 수정)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. 화면 네비게이션 (목록 페이지로 이동)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirct:getBoardList.do");
		
		return mav;
	}

}

