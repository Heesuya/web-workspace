package kr.co.iei;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok 사용, Spring종속 라이브러리가 아닌 추가 라이브러리임
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	private String name;
	private int age;
	private String addr;	
	//private String testData; 이런 변수가 없지만 있다 생가하고 getter만든거 
	
	public String getTestData() {
		return "이건 테스트용 데이터";
	}
}
