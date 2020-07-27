package com.cos.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.repository.UserRepository;
import com.cos.blog.service.PostService;
import com.cos.blog.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor	// final 필드가 존재할 때 필수
public class PostController {
	
	@Autowired
	private final PostService postService;
	@Autowired
	private final PostRepository postRepository;
	
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
	
	
	// post 관련된 것은 전부 인증 필요하게!
	@GetMapping("/posts")
	public String getPosts(Model model) {	// Model은 RequestDispatcher와 관련
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}
	
	// /post/안녕 도 아래로 오게 되는데 PathVariable에서 걸려서 오류남
	// ?주소 -> 쿼리 스트링 받는 것
	// /post/{id} -> 파라메터를 받는 것
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("postDetailRespDto", postService.상세보기(id));
		return "post/detail";
	}
	
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id, HttpSession session) throws MyRoleException {
		// 세션 값 확인, 글의 주인 확인. 한번 쓰고 말 기능을 AOP로 구현할 필요는 없다.
		User principal = (User) session.getAttribute("principal");
		Post postEntity = postRepository.findOne(id);
		if (principal.getId() != postEntity.getUserId()) {
			// return new CommonRespDto<String>(-1,"권한이 없습니다");	// 이렇게 return하면 ajax에서 done()쪽으로 흘러가기 때문에 다시 분기해서 처리해야 하므로 예외 던지는 게 간단함
			throw new MyRoleException();
		}
		
		postService.삭제하기(id);
		return new CommonRespDto<String>(1, "삭제성공");
	}
	
	@PutMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> update(@RequestBody Post post) {
		postService.수정하기(post);
		return new CommonRespDto<String>(1, "수정성공");
	}
}
