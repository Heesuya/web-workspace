package kr.co.iei.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.iei.member.model.dao.UserDao;
import kr.co.iei.member.model.dto.User;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		super();
		userDao = new UserDao();
	}
	
	
	
	public ArrayList<User> allMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<User> list = userDao.alllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}



	public int insertUser(User u) {
		Connection conn = JDBCTemplate.getConnection();
		int result = userDao.insertUser(conn, u);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public User selectOneUser(String userNickname) {
		Connection conn = JDBCTemplate.getConnection();
		User user = userDao.selectOneUser(conn, userNickname);
		JDBCTemplate.close(conn);
		return user;
	}



	public int deleteUser(String userName) {
		Connection conn = JDBCTemplate.getConnection();
		int result = userDao.deleteUser(conn, userName);
		if(result > 0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


}
