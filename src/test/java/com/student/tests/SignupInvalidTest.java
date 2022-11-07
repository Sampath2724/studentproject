package com.student.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.student.pages.SignupPage;

public class SignupInvalidTest extends StudentBaseTest {
	private SignupPage signupPage;

	@BeforeMethod
	public void initMethod() {
		this.driver = this.getWebDriver();
		driver.get("https://www.student.com/");
		signupPage = new SignupPage(driver);
	}

	@Parameters({ "email" })
	@Test(priority = 1)
	public void signupAccountWithOnlyEmail(String email) {
		signupPage.clickOnLogin();
		signupPage.clickOnSignupLink();
		signupPage.setEmailText(email);
		signupPage.clickOnSignupButton();
		String actualTitle = signupPage.getEmailInvalidMessage();
		String expectTitle = "Please enter password";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@Parameters({ "password" })
	@Test(priority = 2)
	public void signupAccountWithOnlyPassword(String password) {
		signupPage.clickOnLogin();
		signupPage.clickOnSignupLink();
		signupPage.setpasswordText(password);
		signupPage.clickOnSignupButton();
		String actualTitle = signupPage.getEmailInvalidMessage();
		String expectTitle = "Please enter a valid email address";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@Parameters({ "firstName" })
	@Test(priority = 3)
	public void signupAccountWithOnlyFirstName(String firstName) {
		signupPage.clickOnLogin();
		signupPage.clickOnSignupLink();
		signupPage.setFirstName(firstName);
		signupPage.clickOnSignupButton();
		String actualTitle = signupPage.getInvalidMessage2();
		String expectTitle = "Please enter password";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@Parameters({ "lastName" })
	@Test(priority = 4)
	public void signupAccountWithOnlyLastName(String lastName) {
		signupPage.clickOnLogin();
		signupPage.clickOnSignupLink();
		signupPage.setLastName(lastName);
		signupPage.clickOnSignupButton();
		String actualTitle = signupPage.getEmailInvalidMessage();
		String expectTitle = "Please enter a valid email address";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@Parameters({ "email1", "password1", "firstName1", "lastName1" })
	@Test(priority = 5)
	public void signupAccount(String email1, String password1, String firstName1, String lastName1) {
		signupPage.clickOnLogin();
		signupPage.clickOnSignupLink();
		signupPage.setEmailText(email1);
		signupPage.setpasswordText(password1);
		signupPage.setFirstName(firstName1);
		signupPage.setLastName(lastName1);
		signupPage.clickOnSignupButton();
		String actualTitle = signupPage.getEmailInvalidMessage();
		String expectTitle = "Please enter a valid email address";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@AfterMethod
	public void quiteDriver() {
		driver.quit();
	}

}
