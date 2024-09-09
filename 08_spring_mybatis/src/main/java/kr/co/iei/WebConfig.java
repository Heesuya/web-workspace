package kr.co.iei;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebConfig {
	@Bean
	public BCryptPasswordEncoder bcrypt() { //어노테이션 쓸수 없는 라이브러리는 @Bean 이라는 어노테이션으로 강제로 객체를 만들면 된다. 
		return new BCryptPasswordEncoder();
	}
}
