package com.example.householdAccountBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.householdAccountBook.data.UsersList;
import com.example.householdAccountBook.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class UsersService {
	private final UsersRepository usersRepository;

	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public UsersList getUsers(int userId) throws JsonMappingException, JsonProcessingException {
		UsersList usersList = new UsersList();

		usersList = usersRepository.getUsers(userId);

		return usersList;
	}
}