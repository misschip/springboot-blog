package com.cos.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBlogApplication {
	
	public static void main(String[] args) {
		System.out.println("메인1");	// 시작시 두번 찍힌다.
		SpringApplication.run(SpringbootBlogApplication.class, args);
		System.out.println("메인2");
	}

}
