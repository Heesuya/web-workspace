package kr.or.iei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllder {
	
	@GetMapping(value="/")
	public String main() {
		return "index";
	}
}
