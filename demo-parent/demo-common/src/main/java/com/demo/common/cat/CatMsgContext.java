package com.demo.common.cat;

import java.util.HashMap;
import java.util.Map;

import com.dianping.cat.Cat;

public class CatMsgContext implements Cat.Context {

	private Map<String, String> properties = new HashMap<>();

	@Override
	public void addProperty(String key, String value) {
		properties.put(key, value);
	}

	@Override
	public String getProperty(String key) {
		return properties.get(key);
	}
}
