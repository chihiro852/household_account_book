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
public class KakeiboList {
	@JsonProperty("kakeibolist")
	private List<Kakeibo> kakeibolist;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("kakeibolist")
	public List<Kakeibo> getKakeibolist() {
		return kakeibolist;
	}

	@JsonProperty("kakeibolist")
	public void setKakeibolist(List<Kakeibo> kakeibolist) {
		this.kakeibolist = kakeibolist;
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