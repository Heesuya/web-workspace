package kr.co.iei.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.co.iei.board.model.service.BoardService;

@Component//1) 객체 생성
public class ScheduleTest {
	@Autowired
	private BoardService boardService;
	
	//스케줄에 의해서 자동으로 실행되는 메소드는 매개변수를 받을 수 없음 
	//@Scheduled(fixedDelay = )//2) 실행되는 주기 작성   1000=1초
	public void test1() { 
		//메소드를 자동으로 묶는다 생각하면 된다. 언제 실행할껀데? 
		//기존의 메소드는 사용자의 요청으로 메소드가 실행이 된다. 
		//스케줄은 일정한 시간을 지정하면 된다.
		System.out.println("이건 자동으로 실행되는 메소드");
	}
	
	@Scheduled(cron = "10 * * * * *")
	public void test2() {
		System.out.println("cron으로 실행되는 메소드");
	}
	
	@Scheduled(cron = "0 0 0 * * *")
	public void test3() {
		//서비스에서 데이터 베이스 작업을 걸어주면 된다. 
	}
}
