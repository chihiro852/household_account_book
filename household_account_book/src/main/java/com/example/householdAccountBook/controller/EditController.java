package com.example.householdAccountBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.householdAccountBook.data.KakeiboList;
import com.example.householdAccountBook.service.EditService;
import com.example.householdAccountBook.utility.DateFormatUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class EditController {
	private final EditService editService;

	@Autowired
	public EditController(EditService editService) {
		this.editService = editService;
	}

	@PostMapping("kakeibo/editAccount")
	public String editHyoji(@RequestParam("p1") int id, @RequestParam("p2") int userId,
			@RequestParam("p3") int amount, @RequestParam("p4") String account, @RequestParam("p5") String accountDate,
			Model model)
			throws JsonMappingException, JsonProcessingException {
		model.addAttribute("id", id);
		model.addAttribute("userId", userId);
		model.addAttribute("amount", amount);
		model.addAttribute("account", account);
		model.addAttribute("accountDate", DateFormatUtility.DateFormatSlashToHyphen(accountDate));

		return "edit.html";
	}

	@PostMapping("kakeibo/setaccount")
	public String editToroku(@RequestParam("p1") int id, @RequestParam("p2") int userId,
			@RequestParam("p3") int amount, @RequestParam("p4") String account, @RequestParam("p5") String accountDate,
			Model model)
			throws JsonMappingException, JsonProcessingException {
		KakeiboList kakeiboList = new KakeiboList();
		kakeiboList = editService.kakeiboEdit(id, userId, amount, account, accountDate);

		model.addAttribute("kakeiboList", kakeiboList);
		return "account.html";
	}
}