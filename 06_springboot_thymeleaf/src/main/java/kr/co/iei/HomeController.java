package kr.co.iei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//   /로 요청 오면 컨트롤해줄 작업
@Controller
public class HomeController {
	
	//컨트롤러가 Servlet 클래스에서 메소드로 변경
	//메소드의 리턴타입은 String(특이한 케이스 제외)
	@GetMapping(value="/")
	public String main() {
		//컨트롤러 메소드의 리턴값은 view파일의 위치
		return "index";
	}
}
