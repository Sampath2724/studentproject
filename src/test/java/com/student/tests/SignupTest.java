package com.student.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.student.pages.SignupPage;

public class SignupTest extends StudentBaseTest {
	private SignupPage signupPage;

	@BeforeClass
	public void initMethod() {
		this.driver = this.getWebDriver();
		driver.get("https://www.student.com/");
		signupPage = new SignupPage(driver);
	}

	@Parameters({ "email", "password", "firstName", "lastName" })
	@Test
	public void signupAccount(String email, String password, String firstName, String lastName) {
		signupPage.clickOnLogin();
		signupPage.clickOnSignupLink();
		signupPage.setEmailText(email);
		signupPage.setpasswordText(password);
		signupPage.setFirstName(firstName);
		signupPage.setLastName(lastName);
		signupPage.clickOnSignupButton();
		String actualTitle = signupPage.getEmailInvalidMessage();
		String expectTitle = "Looks like the provided email is already registered. Please attempt to Login now";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@AfterClass
	public void quiteDriver() {
		driver.quit();
	}
}
