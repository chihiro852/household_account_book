package com.example.householdAccountBook.data;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
	@JsonProperty("userid")
	private int userid;
	@JsonProperty("usernm")
	private String usernm;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("userid")
	public int getUserid() {
		return userid;
	}

	@JsonProperty("userid")
	public void setUserid(int userid) {
		this.userid = userid;
	}

	@JsonProperty("usernm")
	public String getUsernm() {
		return usernm;
	}

	@JsonProperty("usernm")
	public void setUsernm(String usernm) {
		this.usernm = usernm;
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