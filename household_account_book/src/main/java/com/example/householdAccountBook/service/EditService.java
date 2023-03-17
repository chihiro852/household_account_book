package com.example.householdAccountBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.householdAccountBook.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class EditService {
	private final AccountRepository accountRepository;

	@Autowired
	public EditService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void getKakeibo(int p2) throws JsonMappingException, JsonProcessingException {
		if (p2 == 0) {

		} else {

		}
	}

	public void kakeiboEdit(int id, int userId, int amount, String account, String accountDate) {
		String json = accountRepository.getKakeiboList(id, userId, amount, account, accountDate);
	}
}