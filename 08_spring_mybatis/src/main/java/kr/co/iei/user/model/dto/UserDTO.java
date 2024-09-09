package kr.co.iei.user.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
@Alias(value="user")			//mybatis에게 해당 DTO의 자료형을 알려주기위한 별칭 설정
public class UserDTO {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
}
