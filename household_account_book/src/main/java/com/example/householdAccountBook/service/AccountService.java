package com.example.householdAccountBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.householdAccountBook.data.KakeiboList;
import com.example.householdAccountBook.data.UsersList;
import com.example.householdAccountBook.repository.AccountRepository;
import com.example.householdAccountBook.repository.UsersRepository;
import com.example.householdAccountBook.utility.DateFormatUtility;
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

	public KakeiboList getKakeibo(int userId) throws JsonMappingException, JsonProcessingException {
		KakeiboList kakeiboList = new KakeiboList();

		kakeiboList = accountRepository.getKakeiboList(userId, 0);

		int size = kakeiboList.getKakeibolist().size();

		// yyyyMMddをyyyy/MM/ddに変換する
		for (int i = 0; i < size; i++) {
			String strDate = kakeiboList.getKakeibolist().get(i).getAccountDate();

			String dateTime = DateFormatUtility.DateFormatSlash(strDate);

			kakeiboList.getKakeibolist().get(i).setAccountDate(dateTime);
		}

		return kakeiboList;
	}

	public int total(int userId) throws JsonMappingException, JsonProcessingException {
		int result = 0;

		int size = getKakeibo(userId).getKakeibolist().size();

		for (int i = 0; i < size; i++) {
			result = result + getKakeibo(userId).getKakeibolist().get(i).getAmount();
		}

		return result;
	}
}