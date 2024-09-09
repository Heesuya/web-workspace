package kr.co.iei;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.iei.user.model.dto.UserDTO;
import kr.co.iei.user.model.service.UserService;

@Controller
@RequestMapping(value="/mybatis")
public class MybatisController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/main")
	public String main() {
		return "mybatis/main";
	}
	@GetMapping(value="/searchId")
	public String searchId(UserDTO u, Model model) {
		//문자 타입을 사용하던지, 만들어놓은 VO 를 사용하던지 선택
		//userNo =0 // userName, userPw =null //userId = 만 입력받은 값이 들어간다
		UserDTO user = userService.checkId2(u);//상황에 따라 바뀌기 때문에 동적쿼리라고 함
		model.addAttribute("user", user);
		return "mybatis/searchUser";
	}
	@GetMapping(value="/searchUser1")
	public String searchUser1(String type, String keyword, Model model) {
		List list = userService.searchUser1(type,keyword);
		model.addAttribute("list", list);
		return "user/userList";
	}
	@GetMapping(value="/searchUser2")
	public String searchUser2(UserDTO user, Model model) {
		//html 에서 userId, userName 을 input으로 submit을 했기때문에 값이 안들어가면 null 이 아닌 ""빈문자열로 들어감
		List list = userService.searchUser2(user);
		model.addAttribute("list", list);
		return "user/userList";
	}
	@GetMapping(value="/userIdList")
	public String userIdList(Model model) {
		List list = userService.selectAllId();
		model.addAttribute("list", list);
		return "mybatis/idList";
	}
	@GetMapping(value="/searchUser3")
	public String searchUser3(String[] id, Model model) {
		List list = userService.searchUser3(id);
		model.addAttribute("list", list);
		return "user/userList";
	}
}
