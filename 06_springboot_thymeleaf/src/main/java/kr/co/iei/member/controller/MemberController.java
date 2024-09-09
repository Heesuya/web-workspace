package kr.co.iei.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.iei.member.model.dto.Member;
import kr.co.iei.member.service.MemberService;

//이 클래스를 서버 시작할때 객체 생성을 미리해놔
//이 클래스가 컨트롤러 클래스임을 알리는 어노테이션
@Controller
public class MemberController {
	@Autowired//spring이 자동으로 생성한 객체중에 일치하는 타입의 객체를 주입
	private MemberService memberService;
	
	@GetMapping(value="/allMember")
	public String allMember(Model model) {
		//3. 비즈니스로직
		List list = memberService.selectAllMember();
		model.addAttribute("list", list);
		return "member/allMember";
	}
	
	@GetMapping(value="/searchIdFrm")
	public String searchIdFrm() {
		return "member/searchIdFrm";
	}
	
	@GetMapping(value="/searchId")
	public String searchId(String memberId, Model model) {
		Member m= memberService.selectIneMember(memberId);
		//결과처리 1. 성공/실패 시 다른 html로 이동
		/*
		if(m == null) {
			return "member/searchFail";
		}else {
			model.addAttribute("m", m);
			return "member/searchSuccess";
		}
		*/
		
		//결과처리 2. 화면에 조회결과를 주고 화면에서 성공/실패 판단
		model.addAttribute("m", m);
		return "member/searchResult";
	}
	
	@GetMapping(value="/joinFrm")
	public String joinFrm() {
		return "member/joinFrm";
	}
	
	@PostMapping(value="/join")
	public String join(Member m) {//Spring 은 맞는 변수명대로 객체까지 만들어줌, 한단계 포장까지만 가능
		/*잘 받아지는지 확인용
		System.out.println(memberId);
		System.out.println(memberPw);
		System.out.println(memberName);
		System.out.println(memberPhone);
		System.out.println(memberAddr);
		*/
		//System.out.println(m); 확인용
		int result = memberService.insertMember(m);
		//만약 결과처리를 html페이지가 아니라 다른 컨트롤러 요청하고 싶으면
		//return "redirect:컨트롤러주소";
		return "redirect:/allMember";
		//return "member/joinResult";
	}
}
