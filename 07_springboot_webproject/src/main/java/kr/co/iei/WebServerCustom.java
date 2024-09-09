package kr.co.iei;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebServerCustom implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		//404 error 처리                                  //HttpStatus 에러에 대해 메세지로 가지고 있는 객체 //에러 메시지가 사용자에게 누출되면 안되서 잡아놓아야함
		ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND,"/error/notFound");
		//500 error 처리
		ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/serverError");
		
		factory.addErrorPages(error404,error500);
	}
}
