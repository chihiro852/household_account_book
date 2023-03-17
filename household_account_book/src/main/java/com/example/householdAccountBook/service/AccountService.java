package com.example.householdAccountBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.householdAccountBook.data.KakeiboList;
import com.example.householdAccountBook.data.UsersList;
import com.example.householdAccountBook.repository.AccountRepository;
import com.example.householdAccountBook.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class AccountService {
	private final UsersRepository usersRepository;
	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(UsersRepository usersRepository, AccountRepository accountRepository) {
		this.usersRepository = usersRepository;
		this.accountRepository = accountRepository;
	}

	public UsersList getUsers(int userId) throws JsonMappingException, JsonProcessingException {
		UsersList usersList = new UsersList();

		usersList = usersRepository.getUsers(userId);

		return usersList;
	}

	public KakeiboList getKakeibo(int p1) throws JsonMappingException, JsonProcessingException {
		KakeiboList kakeiboList = new KakeiboList();

		kakeiboList = accountRepository.getKakeiboList(p1, 0);

		return kakeiboList;
	}

	public int total(int p1) throws JsonMappingException, JsonProcessingException {
		int result = 0;

		int size = getKakeibo(p1).getKakeibolist().size();

		for (int i = 0; i < size; i++) {
			result = result + getKakeibo(p1).getKakeibolist().get(i).getAmount();
		}

		return result;
	}
}