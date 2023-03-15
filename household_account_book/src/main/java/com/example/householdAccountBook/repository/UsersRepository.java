package com.example.householdAccountBook.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.householdAccountBook.data.UsersList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class UsersRepository {
	public UsersList getUsers() throws JsonMappingException, JsonProcessingException {
		String url = "https://1l9qmgyfm5.execute-api.ap-northeast-1.amazonaws.com/deafult/kakeibo/getusers";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);

		String json = res.getBody();

		ObjectMapper mapper = new ObjectMapper();

		UsersList usersList = new UsersList();

		usersList = mapper.readValue(json, UsersList.class);

		return usersList;
	}
}