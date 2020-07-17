package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.TransferDto;
import com.cos.blog.dto.WithdrawDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Transactional
	public void 송금(TransferDto dto) {
		Account sender = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		sender.setMoney(sender.getMoney() - dto.getMoney());
		accountRepository.update(sender);
		
		
		Account receiver = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		receiver.setMoney(receiver.getMoney() + dto.getMoney());
		accountRepository.update(receiver);
	}
	
	
	@Transactional
	public void 인출(WithdrawDto dto) {
		Account account = accountRepository.findByAccountNumber(dto.getAccountNumber());
		account.setMoney(account.getMoney() - dto.getMoney());
		accountRepository.update(account);
	}
	
	
	public List<Account> showAll() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}
}
