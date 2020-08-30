package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// * 대표적인 스프링 어노테이션
// Controller, Repository, Configuration, Service, Component
// RestController, Bean

@Service	// IoC
public class UserService {
	
	@Autowired
	private UserRepository userRepository;	// DI
	
	@Transactional
	public void 회원가입(User user) {
		// 아래 try -- catch 의 catch로  실행이 흘러도 ajax 쪽에는 done()으로 반환됨
		// 나중에는 리턴값은 인터셉터로 처리하게 된다고 함
		user.setRole("ROLE_USER");
		userRepository.save(user);
		
	}
	
	@Transactional(readOnly = true)	// database isolation으로 구글 검색
	public User 로그인(User user) {
		// userService 객체는 아래에서 com.sun.proxy.$ProxyXX(XX은 두자리 임의의 숫자) 타입으로 출력됨
		// JVM이 리플렉션 기법으로 실행타임에 UserRepository 인터페이스를 구현하는 객체를 만들어 내기 때문인 듯
		// 이때 Proxy가 중요한 역할을 한다.
		System.out.println("UserService: userRepository.getClass().getName() : " + userRepository.getClass().getName());
		
		return userRepository.login(user);
	}
	
	@Transactional
	public void 회원정보수정(User user) {
		userRepository.update(user);
	}
}
