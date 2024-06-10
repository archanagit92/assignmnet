package com.assignment.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	private static PropertyUtils instance = null;
	private final Properties properties;

	private PropertyUtils() {
		String env = System.getProperty("env", "stage");
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/" + env + "/application.properties");
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static synchronized PropertyUtils getInstance() {
		if (instance == null) {
			instance = new PropertyUtils();
		}
		return instance;
	}

	public String getValue(String key) {
		return this.properties.getProperty(key, String.format("The key %s does not exists!", key));
	}
}
