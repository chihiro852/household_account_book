package com.example.householdAccountBook.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.householdAccountBook.data.Kakeibo;
import com.example.householdAccountBook.data.KakeiboList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class EditRepository {
	public KakeiboList postKakeiboList(int id, int userId, int amount, String account, String accountDate)
			throws JsonMappingException, JsonProcessingException {
		String url = "https://1l9qmgyfm5.execute-api.ap-northeast-1.amazonaws.com/deafult/kakeibo/setacount?p1=" + id
				+ "&p2=" + userId + "&p3=" + amount + "&p4=" + account + "&p5=" + accountDate;

		RestTemplate restTemplate = new RestTemplate();

		Kakeibo kakeibo = new Kakeibo();

		ResponseEntity<String> res = restTemplate.postForEntity(url, kakeibo, String.class);

		String json = res.getBody();

		ObjectMapper mapper = new ObjectMapper();

		KakeiboList kakeiboList = new KakeiboList();

		kakeiboList = mapper.readValue(json, KakeiboList.class);

		return kakeiboList;
	}
}