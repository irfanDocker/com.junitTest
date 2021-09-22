package com.junitTest.smokeTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest {

	WebDriver D;

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		D = new ChromeDriver();
		D.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		D.manage().window().maximize();

	}

	@Test
	public void Vytack1() throws InterruptedException {

//		D.get("");				
		D.findElement(By.id("txtUsername")).sendKeys("Admin ");
		D.findElement(By.id("txtPassword")).sendKeys("admin123");
		D.findElement(By.id("btnLogin")).click();

		String CurrentUrl = D.getCurrentUrl();
		System.out.println(CurrentUrl);

		System.out.println(CurrentUrl.substring(CurrentUrl.length() - 9, CurrentUrl.length()));

		String dashbord = "This is HRM: " + CurrentUrl.substring(CurrentUrl.length() - 9, CurrentUrl.length());

		System.out.println(dashbord);
		
		assertTrue("Validate if the we are at the dashboard",CurrentUrl.endsWith("dashboard"));
		
	}

	@After
	public void Endtest() {

		D.close();
	}
}
