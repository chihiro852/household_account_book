package com.example.householdAccountBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.householdAccountBook.data.UsersList;
import com.example.householdAccountBook.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class UsersService {
	public final UsersRepository usersRepository;

	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public UsersList doGet() throws JsonMappingException, JsonProcessingException {
		UsersList usersList = new UsersList();

		usersList = usersRepository.getUsers();

		return usersList;
	}
}