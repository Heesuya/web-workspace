package kr.co.iei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.iei.util.AdminInterceptor;
import kr.co.iei.util.LoginInterceptor;


//스프링부트 설정파일   //자원설정
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Value("${file.root}")
	private String root;

	@Override//이제 수동 설정할꺼야
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry     // * : 모든 , ** : 몇개있더라도 모두
			.addResourceHandler("/**")
			.addResourceLocations("classpath:/templates/","classpath:/static/"); //우선순위 적용 됨, 먼저 다 찾아봐~
		
		registry
			.addResourceHandler("/photo/**") //포토라는 경로는 여기서 찾아야해
			.addResourceLocations("file:///"+root+"/photo/");
		
		registry
			.addResourceHandler("/notice/editor/**")  //여기있는 파일 경로 뜨면
			.addResourceLocations("file:///"+root+"/notice/editor/");//이 경로로 띄워죠
	}
	

	//interceptor 설정  //마지막 하는거 추천 .  로그인페이지/비로그인페이지 구분해서 설정 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/member/logout",
								"/member/mypage1",
								"/member/update1",
								"/member/mypage2",
								"/member/update2",
								"/member/delete",
								"/notice/**",
								"/admin/**")
				.excludePathPatterns("/notice/list","/notice/view","/notice/filedown","/notice/editor/**");  //editor 인터섹터 에 막혀서 예외처리
		registry.addInterceptor(new AdminInterceptor())
				.addPathPatterns("/admin/**");
	}

}
