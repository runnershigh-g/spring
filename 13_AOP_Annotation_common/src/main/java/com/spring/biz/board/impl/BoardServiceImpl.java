package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

// @Service : @Component 상속확장 어노테이션
// 비지니스 로직처리 서비스 영역에 사용
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired // 타입이 일치하는 객체 (인스턴스) 주입 (DI)
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 객체 생성");
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		// 일부러 예외 발생시킴 (after-throwing 테스트용)
		System.out.println(">>BoardServiceImpl.insertBoard() 실행 시작");
		if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0번 글은 입력할 수 없습니다");
		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
		
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
