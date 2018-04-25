package com.qa.util;

import com.google.gson.Gson;

public class JSONutil {
	private Gson gson;
	public JSONutil() {
		this.gson = new Gson();
	}
	

	public String getJSONForObject(Object obj) { //from json to obj
		return gson.toJson(obj);
	}
	
	public<T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString,  clazz);   //to work and return objs generically, obj to json
		
	}
}
