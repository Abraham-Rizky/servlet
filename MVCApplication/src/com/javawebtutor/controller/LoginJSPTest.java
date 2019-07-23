package com.javawebtutor.controller;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class LoginJSPTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		// Create a new instance of the html unit driver
		driver = new HtmlUnitDriver();

		//Navigate to desired web page
		driver.get("http://192.168.43.1:8080/MVCApplication/");
	}
	
	@Test

	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expTitle = "Login";

		// verify title
		assertEquals(actualTitle, expTitle);
		System.out.println(actualTitle);
	}

	
}
