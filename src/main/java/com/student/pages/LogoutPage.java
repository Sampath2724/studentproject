package com.student.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends StudentBasePage {
	@FindBy(xpath = "//span[@class='header-desktop-menu__link header-desktop-menu__link--welcome']")
	private WebElement btnMyProfile;

	@FindBy(xpath = "//span[@class='header-desktop__subnav-link js-account-logout-trigger']")
	private WebElement btnLogout;

	public LogoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyProfile() {
		explicitWait(btnMyProfile);
		btnMyProfile.click();
	}

	public void clickOnLogout() {
		explicitWait(btnLogout);
		btnLogout.click();
	}

}
