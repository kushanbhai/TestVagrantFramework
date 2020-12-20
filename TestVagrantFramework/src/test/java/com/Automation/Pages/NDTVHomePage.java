package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NDTVHomePage {

	WebDriver driver;

	public NDTVHomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//a[@class='topnavmore']")
	WebElement expandSection;

	@FindBy(xpath = "//a[text()='WEATHER']")
	WebElement lnk_WeatherSection;

	@FindBy(xpath = "//input[@id='searchBox']")
	WebElement input_searchBox;

	@FindBy(xpath = "//div//input[@id='Bengaluru']")
	WebElement checkbox_Bengaluru;

	@FindBy(xpath = "//div//a[text()='No Thanks']")
	WebElement alert_NoThanks;

	@FindBy(xpath = "//div//div[@title='Bengaluru']")
	WebElement map_cityName;

	@FindBy(xpath = "//div//div[@title='Bengaluru']//div//span[@class='tempRedText']")
	WebElement map_cityTemp;

	@FindBy(xpath = "//div//div[@class='leaflet-popup-content']")
	WebElement map_weatherDetails;

	public void expandSection() {

		expandSection.click();
	}

	public void clickWeatherSection() {

		lnk_WeatherSection.click();
	}

	public void pinyourcity(String city) {
		input_searchBox.sendKeys(city);
		if (!checkbox_Bengaluru.isSelected()) {
			checkbox_Bengaluru.click();
		}
	}

	public void handlelert() {
		alert_NoThanks.click();
	}

	public String verifyCityname() {
		return map_cityName.getAttribute("title");
	}

	public String verifyCitytemperature() {
		return map_cityTemp.getText();
	}

	public String verifyWeatherDetails() {
		map_cityName.click();
		return map_weatherDetails.getText();
	}
}
