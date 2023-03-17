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
	private int userId;
	@JsonProperty("amount")
	private int amount;
	@JsonProperty("account")
	private String account;
	@JsonProperty("accountdate")
	private String accountDate;
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
	public int getUserId() {
		return userId;
	}

	@JsonProperty("userid")
	public void setUserId(int userId) {
		this.userId = userId;
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

	@JsonProperty("accountdate")
	public String getAccountDate() {
		return accountDate;
	}

	@JsonProperty("accountdate")
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
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