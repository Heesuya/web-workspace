package kr.co.iei.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import kr.co.iei.user.model.dto.UserDTO;
import kr.co.iei.user.model.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder; //Bean 주입하고 만들어야 함 
	
	@PostMapping(value="/login")
	public String login(UserDTO u, HttpSession session) {
//		System.out.println("평문 pw : "+u.getUserPw());
//		String encPw = encoder.encode(u.getUserPw());
//		System.out.println("암호화 pw : "+encPw);
//		u.setUserPw(encPw);
		UserDTO user = userService.selectOneUser(u);
		if(user !=null) {
			session.setAttribute("user", user);
		}
		return "redirect:/";
	}
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping(value="/allUser")
	public String allUser(Model model) {
		List list = userService.selectAllUser();
		model.addAttribute("list", list);
		return "user/userList";
	}
	@GetMapping(value="/joinFrm")
	public String joinFrm() {
		return "user/joinFrm";
	}
	@PostMapping(value="/join")
	public String join(UserDTO user) { //여기까지는 사용자가 받아온 정보가 들어가 있다. 
		//db에 insert하기 전에 pw 암호화
		String defaultPw = user.getUserPw();
		//System.out.println("사용자가 입력 한 pw : " + defaultPw);
		String encPw = encoder.encode(defaultPw);
		System.out.println("암호화 된 pw : " + encPw);
		//user.setUserPw(encPw);
		int result = userService.insertUser(user);
		if(result > 0) {
			return "redirect:/";
		}else {
			return "redirect:/user/joinFrm";
		}
	}
	@GetMapping(value="/mypage")
	public String mypage() {
		return "user/mypage";
	}
	@PostMapping(value="/update" )  //세션 정보 변경을 해줘야 함 
	public String update(UserDTO u, @SessionAttribute UserDTO user) {
		int result = userService.userUpdate(u);//보통은 하는 행위 먼저 적음
		if(result > 0) {
			user.setUserName(u.getUserName());
			//user.setUserPw(u.getUserPw());
			return "redirect:/user/mypage";
		}else {
			return "redirect:/";
		}
	}
	@GetMapping(value="/delete")
	public String delete(@SessionAttribute UserDTO user) { 
		int userNo = user.getUserNo();
		int result = userService.deleteUser(userNo);
		return "redirect:/user/logout";//만들어져있는 로그아웃 사용
	}
	@ResponseBody//데이터자체를 보내주는 설정
	@GetMapping(value="/checkId")
	public int checkId(String userId) {
		UserDTO user = userService.checkId(userId);
		//다른 사람의 회원 정보를 조회할때는 안정성으로 인해 굳이 데이터를 줄 필요가 없음 
		 if(user != null){
			 return 1;
		 }else{
			 return 0;
		 }
	}
	@ResponseBody
	@GetMapping(value="/checkId2")
	public int checkId2(UserDTO u) {//객체로 받아보자
		UserDTO user = userService.checkId2(u);
		//다른 사람의 회원 정보를 조회할때는 안정성으로 인해 굳이 데이터를 줄 필요가 없음 
		 if(user != null){
			 return 1;
		 }else{
			 return 0;
		 }
	}
	@GetMapping(value="/updatePwFrm")
	public String updatePwFrm() {
		return "user/updatePwFrm";
	}
	@ResponseBody
	@PostMapping(value="/oldPwCheck")
	public int oldPwCheck(UserDTO u) {
		UserDTO user = userService.selectOneUser(u);
		if(user != null) {
			return 1;
		}else {
			return 0;
		}
	}
	@PostMapping(value="/changePw")
	public String changePw(UserDTO u) {
		int result = userService.updatePw(u);
		return "redirect:/user/mypage";
	}
	@GetMapping(value="/searchPwFrm")
	public String searchPw() {
		return "user/searchPwFrm";
	}
	@ResponseBody
	@PostMapping(value="/searchUser")
	public int searchUser(UserDTO u) {
		System.out.println(u);
		UserDTO user = userService.searhUser(u);
		System.out.println("user"+user);
		if(user != null) {
			return 1;
		}else {
			return 0;
		}
	}
}
