package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.User;

public interface UserRepository {
	public void save(User user);	// save(String username, String password, String email)로 해도 됨
	public User login(User user);
	
	/*
	public List<User> findAll();
	public User findById(int id);
	// public int save(ReqJoinDto dto);
	public int findByUsername(String username);
	// public User findByUsernameAndPassword(ReqLoginDto dto);
	public int update(int id, String password, String profile);
	*/
}
