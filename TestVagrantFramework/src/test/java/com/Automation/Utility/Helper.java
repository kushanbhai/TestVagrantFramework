package com.Automation.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static void captureScreenshot(WebDriver driver) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/FreeCRM" + getCurrentDate() + "Login.png"));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot " + e.getMessage());
		}
	}

	public static String getCurrentDate() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}
}
