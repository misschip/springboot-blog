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
		userRepository.save(user);
								
	}
	
	@Transactional(readOnly = true)	// database isolation으로 구글 검색
	public User 로그인(User user) {
		return userRepository.login(user);
	}
}
