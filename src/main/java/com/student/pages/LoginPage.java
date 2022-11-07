package com.student.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StudentBasePage {
	@FindBy(xpath = "//span[@class='header-desktop-menu__link header-desktop-menu__link--login js-account-modal-login-trigger']")
	private WebElement btnMoveTOLogin;

	@FindBy(xpath = "(//input[@class='input-field__input'])[1]")
	private WebElement txtBoxEmail;

	@FindBy(xpath = "(//input[@class='input-field__input'])[2]")
	private WebElement txtBoxPassword;

	@FindBy(xpath = "//button[@class='button button__type-full button__with-right-arrow']")
	private WebElement btnLogin;
	@FindBy(xpath = "//div[@class='input-field__error-message']")
	private WebElement txtInvalidMessage1;

	@FindBy(xpath = "(//div[@class='input-field__error-message'])[2]")
	private WebElement txtInvalidMessage2;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMoveToLogin() {
		explicitWait(btnMoveTOLogin);
		btnMoveTOLogin.click();
	}

	public void setEmailText(String email) {
		explicitWait(txtBoxEmail);
		txtBoxEmail.click();
		txtBoxEmail.clear();
		txtBoxEmail.sendKeys(email);
	}

	public void setPasswordText(String password) {
		explicitWait(txtBoxPassword);
		txtBoxPassword.click();
		txtBoxPassword.clear();
		txtBoxPassword.sendKeys(password);
	}

	public void clickOnLogin() {
		explicitWait(btnLogin);
		btnLogin.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getInvalidMessage1() {
		explicitWait(txtInvalidMessage1);
		return txtInvalidMessage1.getText();
	}

	public String getInvalidMessage2() {
		explicitWait(txtInvalidMessage2);
		return txtInvalidMessage2.getText();
	}
}
