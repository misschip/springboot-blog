package com.cos.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.dto.TransferDto;
import com.cos.blog.dto.WithdrawDto;
import com.cos.blog.model.Account;
import com.cos.blog.service.AccountService;


@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("account")
	public @ResponseBody List<Account> 계좌전체보기() {
		return accountService.showAll();
	}
	
	
	@PutMapping("withdraw")
	public @ResponseBody String 인출(WithdrawDto dto) {
		accountService.인출(dto);
		
		return "<h1>인출 성공</h1>";
	}
	
	@PutMapping("transfer")
	public @ResponseBody String 송금(TransferDto dto) {
		accountService.송금(dto);
		
		return "<h1>송금 성공</h1>";
	}
}
