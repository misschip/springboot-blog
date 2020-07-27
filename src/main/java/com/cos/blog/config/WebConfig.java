package com.cos.blog.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleInterceptor;
import com.cos.blog.config.aop.SessionInterceptor;

// 필터링
// 인터셉터 : 디스패쳐 서블릿과 콘트롤러 사이에서 작동
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor())
			.addPathPatterns("/user/**")	// 열거한 주소로의 접근은 Controller로 가기 전에
			.addPathPatterns("/post/**")	// SessionInterceptor가 낚아채서 우선 처리함
			.addPathPatterns("/post**");
			
		
		registry.addInterceptor(new RoleInterceptor())
			.addPathPatterns("/admin/**");
		

	}
}
