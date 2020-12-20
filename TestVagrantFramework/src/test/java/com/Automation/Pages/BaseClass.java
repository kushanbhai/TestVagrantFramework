package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Automation.Utility.BrowserFactory;
import com.Automation.Utility.ConfigDataProvider;
import com.Automation.Utility.ExcelDataProvider;
import com.Automation.Utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getTestUrl());
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
	}
}
