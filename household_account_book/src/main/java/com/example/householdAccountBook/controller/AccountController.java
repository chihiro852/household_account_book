package com.example.householdAccountBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("kakeibo/getaccount")
	public String doGet(@RequestParam("p1") int p1, Model model)
			throws JsonMappingException, JsonProcessingException {
		model.addAttribute("userList", accountService.getUsers(p1).getUsersList());
		model.addAttribute("kakeiboList", accountService.getKakeibo(p1).getKakeibolist());
		model.addAttribute("total", accountService.total(p1));
		return "account.html";
	}
}