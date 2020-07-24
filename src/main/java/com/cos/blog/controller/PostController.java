package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
// @RequiredArgsConstructor
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//private final PostService postService;	// DI 받아야 하는 필드를 final로 선언해 놓고  @RequiredArgsConstructor를 클래스에 붙이면 autowired가 됨

	// @Autowired가 실제 하는 일
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}
	
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		postService.글쓰기(post);
		return new CommonRespDto<String>(1,"글쓰기 성공");
	}
}
