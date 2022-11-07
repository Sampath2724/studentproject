package com.student.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectRoomPage extends StudentBasePage {

	@FindBy(xpath = "(//span[@class='label-select-desktop__item__primary'])[10]")
	private WebElement btnSelect;

	@FindBy(xpath = "//div[@class='hero-banner__search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//span[@class='super-filter-panel__cancelation-container__btn']")
	private WebElement btnGOtit;

	@FindBy(xpath = "(//button[@class='button property-card-new__btn button__size-small'])[1]")
	private WebElement btnViewRoom;

	@FindBy(xpath = "(//button[@class='button listing-card__enquiry-btn js-matrix-enquire js-account-modal-enquire button__size-small'])[1]")
	private WebElement btnselectRoom;

	@FindBy(xpath = "//button[@class='button bottom-action__confirm']")
	private WebElement btnContinue;

	public SelectRoomPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnSelect() {
		explicitWait(btnSelect);
		btnSelect.click();
	}

	public void clickOnSearch() {
		explicitWait(btnSearch);
		btnSearch.click();
	}

	public void clickOnGotit() {
		explicitWait(btnGOtit);
		btnGOtit.click();
	}

	public void clickOnViewRoom() {
		explicitWait(btnViewRoom);
		btnViewRoom.click();
	}

	public void clickOnSelectRoom() {
		moveToNewTab();
		scrollByPage(1200);
		explicitWait(btnselectRoom);
		btnselectRoom.click();
	}

	public void clickOnContinue() {
		moveToNewTab();
		explicitWait(btnContinue);
		btnContinue.click();
	}
}
