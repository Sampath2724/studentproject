package com.student.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends StudentBasePage {

	@FindBy(xpath = "//span[@class='header-desktop-menu__link header-desktop-menu__link--login js-account-modal-login-trigger']")
	private WebElement btnLogin;

	@FindBy(xpath = "//button[@class='account-switch__container__content']")
	private WebElement lnkSignup;

	@FindBy(xpath = "(//input[@class='input-field__input'])[1]")
	private WebElement txtBoxEmail;

	@FindBy(xpath = "(//input[@class='input-field__input'])[2]")
	private WebElement txtBoxPassword;

	@FindBy(xpath = "(//input[@class='input-field__input'])[3]")
	private WebElement txtBoxFirstName;

	@FindBy(xpath = "(//input[@class='input-field__input'])[4]")
	private WebElement txtBoxLastName;

	@FindBy(xpath = "//button[@class='button button__type-full button__with-right-arrow']")
	private WebElement btnSignup;

	@FindBy(xpath = "//div[@class='input-field__error-message']")
	private WebElement txtInvalidMessage1;

	@FindBy(xpath = "(//div[@class='input-field__error-message'])[2]")
	private WebElement txtInvalidMessage2;

	@FindBy(xpath = "(//div[@class='input-field__error-message'])[3]")
	private WebElement txtInvalidMessage3;

	@FindBy(xpath = "(//div[@class='input-field__error-message'])[4]")
	private WebElement txtInvalidMessage4;

	public SignupPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogin() {
		explicitWait(btnLogin);
		btnLogin.click();
	}

	public void clickOnSignupLink() {
		explicitWait(lnkSignup);
		lnkSignup.click();
	}

	public void setEmailText(String email) {
		explicitWait(txtBoxEmail);
		txtBoxEmail.click();
		txtBoxEmail.clear();
		txtBoxEmail.sendKeys(email);
	}

	public void setpasswordText(String password) {
		explicitWait(txtBoxPassword);
		txtBoxPassword.click();
		txtBoxPassword.clear();
		txtBoxPassword.sendKeys(password);
	}

	public void setFirstName(String firstName) {
		explicitWait(txtBoxFirstName);
		txtBoxFirstName.click();
		txtBoxFirstName.clear();
		txtBoxFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		explicitWait(txtBoxLastName);
		txtBoxLastName.click();
		txtBoxLastName.clear();
		txtBoxLastName.sendKeys(lastName);
	}

	public void clickOnSignupButton() {
		explicitWait(btnSignup);
		btnSignup.click();
	}

	public String getEmailInvalidMessage() {
		explicitWait(txtInvalidMessage1);
		return txtInvalidMessage1.getText();
	}

	public String getInvalidMessage2() {
		explicitWait(txtInvalidMessage2);
		return txtInvalidMessage2.getText();
	}
}
