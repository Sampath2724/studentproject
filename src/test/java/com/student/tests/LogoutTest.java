package com.student.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.student.pages.LoginPage;
import com.student.pages.LogoutPage;

public class LogoutTest extends StudentBaseTest {
	private LogoutPage logoutPage;

	@BeforeClass
	@Parameters({ "email", "password" })
	public void initMethod(String email, String password) {
		this.driver = this.getWebDriver();
		driver.get("https://www.student.com/");
		logoutPage = new LogoutPage(driver);
		loginPage = new LoginPage(driver);
		loginAccount(email, password);
	}

	@Test
	public void signupAccount() {

		logoutPage.clickOnMyProfile();
		;
		logoutPage.clickOnLogout();
		;
		String actualTitle = loginPage.getTitle();
		String expectTitle = "Student Accommodation Made Easy | Student.com";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@AfterClass
	public void quiteDriver() {
		// driver.quit();
	}

}
