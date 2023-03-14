package com.example.householdAccountBook.data;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Kakeibo {
	@JsonProperty("id")
	private int id;
	@JsonProperty("userid")
	private int userid;
	@JsonProperty("amount")
	private int amount;
	@JsonProperty("account")
	private String account;
	@JsonProperty("accountdate")
	private String accountdate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("userid")
	public int getUserid() {
		return userid;
	}

	@JsonProperty("userid")
	public void setUserid(int userid) {
		this.userid = userid;
	}

	@JsonProperty("amount")
	public int getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@JsonProperty("account")
	public String getAccount() {
		return account;
	}

	@JsonProperty("account")
	public void setAccount(String account) {
		this.account = account;
	}

	@JsonProperty("accountdata")
	public String getAccountdata() {
		return accountdate;
	}

	@JsonProperty("accountdata")
	public void setAccountdata(String accountdata) {
		this.accountdate = accountdata;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}