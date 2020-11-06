package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	private final String BOARD__INSERT 
//	= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
//		+ "VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM BOARD), ?, ?, ?)";
	
	private final String BOARD__INSERT 
	= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
		+ "VALUES(?, ?, ?, ?)";

	private final String BOARD__UPDATE 
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	
	private final String BOARD__DELETE 
		= "DELETE FROM BOARD WHERE SEQ = ?";
	
	private final String BOARD__GET 
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	
	private final String BOARD__LIST 
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	public BoardDAOSpring() {
		System.out.println(">> BoardDAOSpring() 객체 생성");
	}
	
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 실행");
		
//		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
//		jdbcTemplate.update(BOARD__INSERT, args);

		Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD__INSERT, args);
}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 실행");
		
//		Object[] args = { vo.getTitle(), vo.getContent(), vo.getSeq() };
//				jdbcTemplate.update(BOARD__UPDATE, args);
		
		jdbcTemplate.update(BOARD__UPDATE, vo.getTitle(), 
					vo.getContent(),	 vo.getSeq());	
				}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) { 
		System.out.println("===> Spring JDBC로 deleteBoard() 실행");
		jdbcTemplate.update(BOARD__DELETE, vo.getSeq());
	}
	
	// 글 조회 (하나)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 실행");
		
		Object[] args = { vo.getSeq() };
		
		return jdbcTemplate.queryForObject(BOARD__GET, args, 
						new BoardRowMapper());
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoardList() 실행");
		return jdbcTemplate.query(BOARD__LIST, new BoardRowMapper());
		
	}
}
