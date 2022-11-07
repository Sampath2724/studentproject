package com.student.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.student.pages.LoginPage;

public class LoginTest extends StudentBaseTest {
	@BeforeClass
	public void initMethod() {
		this.driver = this.getWebDriver();
		driver.get("https://www.student.com/");
		loginPage = new LoginPage(driver);
	}

	@Parameters({ "email", "password" })
	@Test
	public void loginValidAccount(String email, String password) {
		loginAccount(email, password);
		String actualTitle = loginPage.getTitle();
		String expectTitle = "Student Accommodation Made Easy | Student.com";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@AfterClass
	public void quiteDriver() {
		driver.quit();
	}

}
