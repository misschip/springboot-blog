package com.cos.blog.config.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.config.handler.exception.MySessionException;
import com.cos.blog.model.User;

// 인증 관리
public class RoleInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		
		if (principal == null) {
			System.out.println("RoleInterceptor : 인증이 안됨");
			throw new MySessionException();
		} else {
			if (!principal.getRole().equals("ROLE_ADMIN")) {
				System.out.println("RoleInterceptor : 권한이 없음");
				// 아래에서 IOException을 던지면 인터셉터가 어떻게 반응하는지 이해할 것!
				throw new MyRoleException();
			}
		}
		
		// System.out.println("인증과 권한을 체크해야 함");
		return true;
	}
}
