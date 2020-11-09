package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{
	
	@RequestMapping("/getBoard")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>> 게시글 상세보기 - getBoard()");
		
		BoardVO board = boardDAO.getBoard(vo);
		
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
	
}
