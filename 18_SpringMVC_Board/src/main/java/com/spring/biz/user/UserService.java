package com.spring.biz.user;

import java.util.List;

import com.spring.biz.board.BoardVO;

public interface UserService {
	// CRUD 기능 구현 메서드 정의
		void insertUser(UserVO vo);
		void updateUser(UserVO vo);
		void deleteUser(UserVO vo);
		UserVO getUser(UserVO vo);
		List<UserVO> getUserList(UserVO vo);
}
