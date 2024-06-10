package com.assignment.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private static final ThreadLocal<ScenarioContext> context = new ThreadLocal<>();
	private Map<String, Object> data;

	private ScenarioContext() {
		data = new HashMap<>();
	}

	public static ScenarioContext getInstance() {
		ScenarioContext ctx = context.get();
		if (ctx == null) {
			ctx = new ScenarioContext();
			context.set(ctx);
		}
		return ctx;
	}

	public void put(String key, Object val) {
		data.put(key, val);
	}

	public Object get(String key) {
		return data.get(key);
	}

}
