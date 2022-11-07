package com.student.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.student.pages.LoginPage;

public class LoginInvalidTest extends StudentBaseTest {
	@BeforeMethod
	public void initMethod() {
		this.driver = this.getWebDriver();
		driver.get("https://www.student.com/");
		loginPage = new LoginPage(driver);
	}

	@Parameters({ "email" })
	@Test(priority = 1)
	public void loginWithOnlyEmail(String email) {
		loginAccount(email, "");
		String actualTitle = loginPage.getInvalidMessage1();
		String expectTitle = "Please enter password";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@Parameters({ "password" })
	@Test(priority = 2)
	public void loginWithOnlypassword(String password) {
		loginAccount("", password);
		String actualTitle = loginPage.getInvalidMessage1();
		String expectTitle = "Please enter an email";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@Parameters({ "email1", "password1" })
	@Test(priority = 3)
	public void loginWithOnlyInvalidEmailInvalidpassword(String email1, String password1) {
		loginAccount(email1, password1);
		String actualTitle = loginPage.getInvalidMessage1();
		String expectTitle = "Please enter a valid email address";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@AfterMethod
	public void quiteDriver() {
		driver.quit();
	}

}
