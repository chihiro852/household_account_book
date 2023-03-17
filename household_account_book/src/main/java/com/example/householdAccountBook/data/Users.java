package com.example.householdAccountBook.data;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
	@JsonProperty("userid")
	private int userId;
	@JsonProperty("usernm")
	private String userNm;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("userid")
	public int getUserId() {
		return userId;
	}

	@JsonProperty("userid")
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@JsonProperty("usernm")
	public String getUserNm() {
		return userNm;
	}

	@JsonProperty("usernm")
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}