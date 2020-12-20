package com.Automation.testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetWeatherinfowithQueryparams {

	@Test
	public void getuserAPI() {
		RestAssured.baseURI = "http://api.openweathermap.org/";
		RequestSpecification request = RestAssured.given().log().all();
		request.queryParam("q", "Bengaluru,India");
		request.queryParam("APPID", "7fe67bf08c80ded756e598d6f8fedaea");
		Response resp = request.get("data/2.5/weather");
		System.out.println("Response is: " + resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
}
