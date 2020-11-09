package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository
public class UserDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_INSERT
		="INSERT INTO USERS (ID, PASSWORD, NAME, ROLE)"
			+ "VALUES(?,?,?,?)";
	
	private final String USER_UPDATE
	="UPDATE USERS SET(PASSWORD = ?,	NAME = ?, ROLE = ?)";
	
	private final String USER_DELETE
	="DELETE FROM USERS WHERE ID = ? ";
	
	private final String USER_GET
	="SELECT * FROM USERS WHERE ID = ? ";
	
	private final String USER_LIST
	="SELECT * FROM USERS ORDER BY ID DESC ";

	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 실행");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setNString(1, vo.getId());
			stmt.setNString(2, vo.getPassword());
			stmt.setNString(3, vo.getName());
			stmt.setNString(4, vo.getRole());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC로 updateUser() 실행");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
		
	}

	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC로 deleteUser() 실행");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 실행");
		
		UserVO user = null;
		
		conn = JDBCUtil.getConnection();
		if( conn == null ) return null;
		
		try {
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return user;
	}

	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> JDBC로 getUserList() 실행");
		
		List<UserVO> list = null;
		
		conn = JDBCUtil.getConnection();
		if ( conn == null ) return null;
		try {
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));			
			
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return null;
	}
}
