package com.example.householdAccountBook.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsersList {
	@JsonProperty("userslist")
	private List<Users> usersList;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<>();

	@JsonProperty("userslist")
	public List<Users> getUsersList() {
		return usersList;
	}

	@JsonProperty("userslist")
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
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