package com.example.householdAccountBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.householdAccountBook.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class AccountController {
	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	// users.htmlからの情報を受け取って、account.htmlを表示する
	@PostMapping("kakeibo/getaccount")
	public String doGet(@RequestParam("p1") int userId, Model model)
			throws JsonMappingException, JsonProcessingException {
		model.addAttribute("userName", accountService.getUsers(userId).getUsersList().get(0).getUserNm());
		model.addAttribute("kakeiboList", accountService.getKakeibo(userId).getKakeibolist());
		model.addAttribute("userId", userId);
		model.addAttribute("total", accountService.total(userId));
		return "account.html";
	}
}