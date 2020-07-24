package com.cos.blog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/user/**");
			
		
		
		registry.addInterceptor(new RoleInterceptor()).addPathPatterns("/admin/**");
		

	}
}
