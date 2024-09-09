package kr.co.iei.user.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.user.model.dao.UserDao;
import kr.co.iei.user.model.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;//user-mapper 통해서 UserDTO 연결 클래스를 만들고 다형성을 통해서 클래스를 넣은것
	@Autowired
	private BCryptPasswordEncoder encoder;
	public UserDTO selectOneUser(UserDTO u) {
		//System.out.println("평문 pw : "+u.getUserPw());
		//bcrypt는 동일한 값을 hash로 암호화해도 salt값으로 인해서 다른 결과를 가져옴
		//pw를 검증하지 않고 id로만 회원을 조회
		UserDTO user = userDao.selectOneUser(u);
		//회원이 조회되지 않으면 id가 잘못된 케이스
		if(user != null) {
			//bcrypt는 평문패스워드와 암호화된 패스워드를 비교해서 일치하는지 결과를 알려주는 함수는 제공
			//matches(평문패스워드 , 암호화패스워드) -> 일치하면 true / 일치하지 않으면 false
			if(encoder.matches(u.getUserPw(), user.getUserPw())) {
				user.setUserPw(null);
				return user;
			}else {
				return null;
			}
		}else{
			return null;
		}
	}
	
	public UserDTO checkId2(UserDTO u) {
		UserDTO user = userDao.selectOneUser(u); //pw = null 인 상태
		return user;
	}

	public List selectAllUser() {
		List list = userDao.selectAllUser();
		return list;
	}
	@Transactional
	public int insertUser(UserDTO user) {
		int result = userDao.insertUser(user);
		return result;
	}
	@Transactional
	public int userUpdate(UserDTO u) {
//		String encPw = encoder.encode(u.getUserPw()); 
//		u.setUserPw(encPw);	
		//비밀번호를 바꾸지 않아도 쿼리문 수행이 되서 문제가 된다. 
		int result = userDao.userUpdate(u);
		return result;
	}
	@Transactional
	public int deleteUser(int userNo) {
		int result = userDao.deleteUser(userNo);
		return result;
	}

	public UserDTO checkId(String userId) {
		UserDTO user = userDao.checkId(userId);
		return user;
	}
	public List searchUser1(String type, String keyword) {
		//mybatis에 매개변수로 데이터를 전송할때는 하나의 객체로 묶어서 줘야 함
		//전송할 데이터를 모두 담을 DTO, VO 객체가 있으면 사용하면 됨
		//-> DTO나 VO가 없으면 -> DTO나 VO를 생성 or HashMap을 생성해서 전달 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("keyword", keyword);
		List list = userDao.selectUserIdOrName(map);
		return list;
	}
	public List searchUser2(UserDTO user) {
		List list = userDao.searchUser2(user);
		return list;
	}
	public List selectAllId() {
		List list = userDao.selectAllId();
		return list;
	}
	public List searchUser3(String[] id) {
		List lsit = userDao.searchUser3(id);
		return lsit;
	}

	@Transactional
	public int updatePw(UserDTO u) {
		String encPw = encoder.encode(u.getUserPw());
		u.setUserPw(encPw);
		int result = userDao.changePw(u);
		return result;
	}

	public UserDTO searhUser(UserDTO u) {
		UserDTO user = userDao.selectOneUser(u);
		return user;
	}
}
