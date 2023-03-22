package com.example.householdAccountBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.householdAccountBook.data.Kakeibo;
import com.example.householdAccountBook.data.KakeiboList;
import com.example.householdAccountBook.repository.AccountRepository;
import com.example.householdAccountBook.repository.EditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class EditService {
	private final AccountRepository accountRepository;
	private final EditRepository editRepository;

	@Autowired
	public EditService(AccountRepository accountRepository, EditRepository editRepository) {
		this.accountRepository = accountRepository;
		this.editRepository = editRepository;
	}

	public KakeiboList kakeiboEdit(int id, int userId, int amount, String account, String accountDate)
			throws JsonMappingException, JsonProcessingException {
		KakeiboList kakeiboList = new KakeiboList();

		Kakeibo kakeibo = new Kakeibo();
		// 新規登録
		if (id == 0) {
			kakeiboList = editRepository.postKakeiboList(id, userId, amount, account, accountDate);

			return kakeiboList;
			// 編集登録
		} else {
			return kakeiboList;
		}
	}

	public KakeiboList getKakeibo(int userId) throws JsonMappingException, JsonProcessingException {
		KakeiboList kakeiboList = new KakeiboList();

		kakeiboList = accountRepository.getKakeiboList(userId, 0);

		//		int size = kakeiboList.getKakeibolist().size();

		//		// yyyyMMddをyyyy/MM/ddに変換する
		//		for (int i = 0; i < size; i++) {
		//			String strDate = kakeiboList.getKakeibolist().get(i).getAccountDate();
		//
		//			String dateTime = DateFormatUtility.DateFormatSlash(strDate);
		//
		//			kakeiboList.getKakeibolist().get(i).setAccountDate(dateTime);
		//		}

		return kakeiboList;
	}
}