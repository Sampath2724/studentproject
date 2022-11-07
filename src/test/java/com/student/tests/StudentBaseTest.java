package com.student.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import com.student.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentBaseTest {
	protected WebDriver driver = null;
	protected LoginPage loginPage = null;

	public WebDriver getWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	@Parameters({ "email", "password" })
	public void loginAccount(String email, String password) {
		loginPage.clickOnMoveToLogin();
		loginPage.setEmailText(email);
		loginPage.setPasswordText(password);
		loginPage.clickOnLogin();
	}
}
