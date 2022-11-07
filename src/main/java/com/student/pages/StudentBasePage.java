package com.student.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentBasePage {
	protected WebDriver driver = null;

	public StudentBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void scrollByPage(int scrollValue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		ArrayList<String> scr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(scr.get(1));
		jse.executeScript("window.scrollBy(0," + scrollValue + ")");
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void moveToNewTab() {
		ArrayList<String> scr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(scr.get(1));

	}
}
