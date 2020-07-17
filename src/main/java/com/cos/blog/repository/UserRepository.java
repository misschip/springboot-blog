package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.user.User;

public interface UserRepository {
	public List<User> findAll();
	public User findById(int id);
	// public int save(ReqJoinDto dto);
	public int findByUsername(String username);
	// public User findByUsernameAndPassword(ReqLoginDto dto);
	public int update(int id, String password, String profile);

}
