package com.Automation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Pages.BaseClass;
import com.Automation.Pages.NDTVHomePage;
import com.Automation.Utility.Helper;

public class LoginTestCRM extends BaseClass {

	/*
	 * @Test public void loginApp() { LoginPage loginPage =
	 * PageFactory.initElements(driver, LoginPage.class);
	 * loginPage.LoginCRM(excel.getStringData("Login", 0, 0),
	 * excel.getStringData("Login", 0, 1)); Helper.captureScreenshot(driver); }
	 */
	
	@Test
	public void NDTVApp() throws InterruptedException {
		NDTVHomePage ndtvpage = PageFactory.initElements(driver, NDTVHomePage.class);
		//loginPage.LoginCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Thread.sleep(3000);
		ndtvpage.handlelert();
		ndtvpage.expandSection();
		
		ndtvpage.clickWeatherSection();
		String cityName = "Bengaluru";
		ndtvpage.pinyourcity(cityName);
		String cityname2 = ndtvpage.verifyCityname();
		Assert.assertEquals(cityname2, cityName);
		String cityTemperature = ndtvpage.verifyCitytemperature();
		System.out.println("The temperature of the city "+cityName+" is: "+cityTemperature);
		String weatherDetails = ndtvpage.verifyWeatherDetails();
		System.out.println("The weather details for the city are: "+weatherDetails);
		Helper.captureScreenshot(driver);
	}

}
