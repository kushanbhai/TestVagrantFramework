package com.Automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		try {
			File src = new File("./Configuration/Config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Not able to load config file " + e.getMessage());
		}

	}

	public String getDatafromConfig(String keytoSearch) {
		return prop.getProperty(keytoSearch);
	}

	public String getBrowser() {
		return prop.getProperty("Browser");

	}

	public String getTestUrl() {
		return prop.getProperty("url");
	}
}