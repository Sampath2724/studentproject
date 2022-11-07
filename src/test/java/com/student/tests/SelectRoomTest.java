package com.student.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.student.pages.LoginPage;
import com.student.pages.SelectRoomPage;

public class SelectRoomTest extends StudentBaseTest {
	private SelectRoomPage selectRoomPage;

	@BeforeClass
	@Parameters({ "email", "password" })
	public void initMethod(String email, String password) {
		this.driver = this.getWebDriver();
		driver.get("https://www.student.com/");
		selectRoomPage = new SelectRoomPage(driver);
		loginPage = new LoginPage(driver);
		loginAccount(email, password);
	}

	@Test
	public void signupAccount() {

		selectRoomPage.clickOnSearch();
		selectRoomPage.clickOnSelect();
		selectRoomPage.clickOnGotit();
		selectRoomPage.clickOnViewRoom();
		selectRoomPage.clickOnSelectRoom();
		selectRoomPage.clickOnContinue();
		String actualTitle = loginPage.getTitle();
		String expectTitle = "iQ Shoreditch London Student Housing • Reviews • Student.com";
		Assert.assertEquals(actualTitle, expectTitle);
	}

	@AfterClass
	public void quiteDriver() {
		driver.quit();
	}

}
