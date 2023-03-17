package com.example.householdAccountBook.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.householdAccountBook.data.KakeiboList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AccountRepository {
	public KakeiboList getKakeiboList(int p1, int p2) throws JsonMappingException, JsonProcessingException {
		String url = "https://1l9qmgyfm5.execute-api.ap-northeast-1.amazonaws.com/deafult/kakeibo/getacount?p1=" + p1
				+ "&p2=" + p2;

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);

		String json = res.getBody();

		ObjectMapper mapper = new ObjectMapper();

		KakeiboList kakeiboList = new KakeiboList();

		kakeiboList = mapper.readValue(json, KakeiboList.class);

		return kakeiboList;
	}
}