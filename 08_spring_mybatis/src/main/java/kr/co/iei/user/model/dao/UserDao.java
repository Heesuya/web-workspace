package kr.co.iei.user.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.iei.user.model.dto.UserDTO;
 
@Mapper   //mybatis가 관여할수 있게 interface 로 Dao 만듦 
public interface UserDao {   

	UserDTO selectOneUser(UserDTO u);

	List selectAllUser();

	int insertUser(UserDTO user);

	int userUpdate(UserDTO u);

	int deleteUser(int userNo);

	UserDTO checkId(String userId);

	List selectUserIdOrName(Map<String, Object> map);

	List searchUser2(UserDTO user);

	List selectAllId();

	List searchUser3(String[] id);

	int changePw(UserDTO u);

}
