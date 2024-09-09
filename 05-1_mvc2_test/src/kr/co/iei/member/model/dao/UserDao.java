package kr.co.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.iei.member.model.dto.User;

public class UserDao {

	public ArrayList<User> alllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from user_tbl";
		ArrayList<User> list = new ArrayList<User>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				User m = new User();
				m.setUserGender(rset.getString("user_gender"));
				m.setUserAge(rset.getInt("user_age"));
				m.setUserNickname(rset.getString("user_nickname"));
				m.setUserNo(rset.getInt("user_no"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertUser(Connection conn, User u) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into user_tbl values(user_seq.nextval,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getUserNickname());
			pstmt.setInt(2, u.getUserAge());
			pstmt.setString(3, u.getUserGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public User selectOneUser(Connection conn, String userNickname) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from user_tbl where user_nickname = ? ";
		User user = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNickname);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				user.setUserAge(rset.getInt("user_age"));
				user.setUserGender(rset.getString("user_gender"));
				user.setUserNickname(rset.getString("user_nickname"));
				user.setUserNo(rset.getInt("user_no"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return user;
	}

	public int deleteUser(Connection conn, String userName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from user_tbl where user_nickname =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
