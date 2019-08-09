package com.newer.petmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.petmall.domain.Account;
import com.newer.petmall.mapper.AccountMapper;

@Service
public class AccountService {

	// 依赖注入
	@Autowired
	private AccountMapper accountMapper;

	//查询
	public Account getAccount(String username) {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String username, String password) {
		return accountMapper.getAccountByUsernameAndPassword(username, password);
	}

	
	//插入
	public void insertAccount(Account account) {
		
		accountMapper.insertSignon(account);
		accountMapper.insertProfile(account);
		accountMapper.insertAccount(account);

	}

	
	//更新
	public void updateAccount(Account account) {
		accountMapper.updateAccount(account);
		accountMapper.updateProfile(account);

		if (account.getPassword() != null && account.getPassword().length() > 0) {
			accountMapper.updateSignon(account);
		}
	}

}
