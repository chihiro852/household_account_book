package com.example.householdAccountBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.householdAccountBook.service.EditService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class EditController {
	private final EditService editService;

	@Autowired
	public EditController(EditService editService) {
		this.editService = editService;
	}

	@GetMapping("kakeibo/setaccount")
	public String getEdit(@RequestParam("p1") int id, @RequestParam("p2") int userId, Model model)
			throws JsonMappingException, JsonProcessingException {
		model.addAttribute("id", id);
		model.addAttribute("userId", userId);
		model.addAttribute("amount", amount);
		model.addAttribute("account", account);
		model.addAttribute("accountDate", accountDate);

		return "edit.html";
	}

	@PostMapping("kakeibo/getaccount")
	public String postAccount(@RequestParam("p1") int id, @RequestParam("p2") int userId,
			@RequestParam("p3") int amount, @RequestParam("p4") String account, @RequestParam("p5") String accountDate,
			Model model) {
		editService.kakeiboEdit(id, userId, amount, account, accountDate);
		return "account.html";
	}
}