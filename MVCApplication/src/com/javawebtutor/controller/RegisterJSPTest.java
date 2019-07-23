package com.javawebtutor.controller;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class RegisterJSPTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		// Create a new instance of the html unit driver
		driver = new HtmlUnitDriver();

		//Navigate to desired web page 
		driver.get("http://192.168.43.1:8080/MVCApplication/register.jsp");
	}
	
	@Test

	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expTitle = "Registration Form";

		// verify title of the jsp to be registration form
		assertEquals(actualTitle, expTitle);
		//print title in Console
		System.out.println(actualTitle);
	}

	
}
