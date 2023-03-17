package com.example.householdAccountBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.householdAccountBook.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class UsersController {
	private final UsersService usersService;

	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@GetMapping("/kakeibo/getusers")
	public String readKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("userslist", usersService.getUsers(0).getUsersList());

		return "users.html";
	}
}